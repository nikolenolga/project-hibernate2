package com.javarush.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "movie", name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Byte id;

    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    @ToString.Exclude
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @ToString.Exclude
    private Address address;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private final Collection<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private Collection<Inventory> inventories = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private final Collection<Staff> staffs = new ArrayList<>();
}
