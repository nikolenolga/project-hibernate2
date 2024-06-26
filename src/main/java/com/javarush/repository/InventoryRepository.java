package com.javarush.repository;

import com.javarush.config.SessionCreator;
import com.javarush.entity.Inventory;
import com.javarush.entity.Store;
import org.hibernate.query.Query;

import java.util.List;

import static java.util.Objects.isNull;

public class InventoryRepository extends BaseRepository<Inventory> {
    public InventoryRepository(SessionCreator sessionCreator) {
        super(sessionCreator, Inventory.class);
    }

    public boolean isAvailable(Inventory inventory) {
        return inventory.getRentals().stream()
                .filter(rental -> isNull(rental.getRentalDate()))
                .findFirst()
                .isEmpty();
    }

    public Inventory getRandomAvailableInventory(Store store) {
        Query<Inventory> query = getCurrentSession().createQuery(
                "select i from Inventory i " +
                        "where i.store.id = :storeId " +
                        "and i.id not in " +
                        "(select distinct r.inventory.id " +
                        "from Rental r where r.returnDate is null)", Inventory.class);

        query.setParameter("storeId", store.getId());
        query.setMaxResults(100);
        List<Inventory> inventoryList = query.list();
        return inventoryList.isEmpty() ? null : inventoryList.get((int) (Math.random() * inventoryList.size()));
    }
}
