package com.javarush;

import com.javarush.config.ServiceLocator;
import com.javarush.service.DemoService;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Runner {

    public static void main(String[] args) throws IOException {
        DemoService demoService = ServiceLocator.getService(DemoService.class);

        String lineSeparator = "-------------------------------------------------------------------";
        System.out.printf("%s%n", lineSeparator);
        System.out.printf("Demo 1 - customer creation: %n%s%n%s%n", demoService.demoCreateCustomer(), lineSeparator);
        System.out.printf("Demo 2 - customer return rental: %n%s%n%s%n", demoService.demoCustomerReturnRental(), lineSeparator);
        System.out.printf("Demo 3 - customer rent film: %n%s%n%s%n", demoService.demoCustomerRentedFilm(), lineSeparator);
        System.out.printf("Demo 4 - create new film and add to all stores: %n%s%n%s%n", demoService.demoCreateNewFilmAvailableForRental(), lineSeparator);

    }
}
