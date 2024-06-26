package com.javarush.service;

import com.javarush.config.SessionCreater;
import com.javarush.entity.*;
import com.javarush.repository.*;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
public class DemoService {
    private final CustomerRepository customerRepository;
    private final StoreRepository storeRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final InventoryRepository inventoryRepository;
    private final RentalRepository rentalRepository;
    private final PaymentRepository paymentRepository;
    private final LanguageRepository languageRepository;
    private final ActorRepository actorRepository;
    private final CategoryRepository categoryRepository;
    private final FilmRepository filmRepository;
    private final SessionCreater sessionCreater;

    public String demoCreateCustomer() throws IOException {
        Session session = sessionCreater.getSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            try {
                City city = getRandomCity();
                Address address = Address.builder()
                        .address("TestAddress")
                        .district("TestDistrict")
                        .city(city)
                        .phone("9999999999")
                        .build();
                addressRepository.create(address);

                Store store = getRandomStore();
                Customer customer = Customer.builder()
                        .email("TestEmail")
                        .store(store)
                        //.firstName("TestFirstName")
                        .address(address)
                        //.lastName("TestLastName")
                        .active(true)
                        .build();

                customer.setFirstName("TestFirstName");
                customer.setLastName("TestLastName");
                customerRepository.create(customer);
                transaction.commit();
                return "Address created: %s%nCustomer created: %s".formatted(address, customer);
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
                return "Customer creation FAILED!";
            }
        }
    }

    public String demoCustomerReturnRental() {
        boolean noRentals = false;
        Session session = sessionCreater.getSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            try {
                Rental rental = getRandomOpenRental();
                if (isNull(rental)) noRentals = true;

                rental.setReturnDate(LocalDateTime.now());
                rentalRepository.update(rental);
                Customer customer = rental.getCustomer();

                transaction.commit();
                return "Customer: %s%nReturned rental: %s".formatted(customer, rental);
            } catch (Exception e) {
                transaction.rollback();
                return noRentals
                        ? "DataBase doesn't have not returned rentals"
                        : "Rental returned FAILED!";
            }
        }
    }

    public String demoCustomerRentedFilm() {
        Session session = sessionCreater.getSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            try {
                Customer customer = getRandomCustomer();
                Store store = getRandomStore();
                Staff staff = store.getStaff();
                Inventory inventory = getRandomAvailableInventory(store);

                Rental rental = Rental.builder()
                        .rentalDate(LocalDateTime.now())
                        .inventory(inventory)
                        .customer(customer)
                        .staff(staff)
                        .build();
                rentalRepository.create(rental);

                Payment payment = Payment.builder()
                        .customer(customer)
                        .staff(staff)
                        .rental(rental)
                        .amount(BigDecimal.valueOf(33.17))
                        .build();
                paymentRepository.create(payment);
                String rentedFilm = inventory.getFilm().getTitle();

                transaction.commit();

                return "Film: %s%nRental created: %s%nPayment created: %s".formatted(rentedFilm, rental, payment);
            } catch (Exception e) {
                transaction.rollback();
                return "Film rent FAILED!";
            }
        }
    }

    /*
    Добавить транзакционный метод, который описывает событие «сняли новый фильм,
    и он стал доступен для аренды». Фильм, язык, актеров, категории и т д выбери на свое усмотрение.
    */
    public String demoCreateNewFilmAvailableForRental() {
        Session session = sessionCreater.getSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            try {
                Language language = languageRepository.getRandomEntity();
                List<Actor> actories = actorRepository.getEntities(5, 5).toList();
                List<Category> categories = categoryRepository.getEntities(0, 3).toList();
                        Film film = Film.builder()
                        .title("TestTitle")
                        .description("TestDescription")
                        .releaseYear(Year.now())
                        .language(language)
                        .rentalDuration((byte) 1)
                        .rentalRate(BigDecimal.valueOf(3.5))
                        .length((short) 3)
                        .replacementCost(BigDecimal.valueOf(33.5))
                        .rating(Rating.R)
                        .actors(actories)
                        .categories(categories)
                        .build();

                film.setSpecialFeatures(Set.of(SpecialFeatures.COMMENTARIES, SpecialFeatures.BEHIND_THE_SCENES));
                filmRepository.create(film);

                storeRepository.getAll().forEach(store -> inventoryRepository.create(Inventory.builder().film(film).store(store).build()));

                transaction.commit();
                return "Film created: %s%nLanguage: %s%nCategories: %s%nActors: %s%nSpecialFeatures: %s".formatted(film, language,
                                categories.stream().map(Category::getName).collect(Collectors.joining(", ")),
                                actories.stream().map(Actor::getFullName).collect(Collectors.joining(", ")),
                                film.getSpecialFeatures());
            } catch (Exception e) {
                transaction.rollback();
                return "Film creation FAILED!";
            }
        }
    }

    public Inventory getRandomAvailableInventory(Store store) {
        return inventoryRepository.getRandomAvailableInventory(store);
    }

    public Customer getRandomCustomer() {
        return customerRepository.getRandomEntity();
    }

    public Rental getRandomOpenRental() {
        return rentalRepository.getRandomOpenedRental();
    }

    public Store getRandomStore() {
        return storeRepository.getRandomEntity();
    }

    public City getRandomCity() {
        return cityRepository.getRandomEntity();
    }
}
