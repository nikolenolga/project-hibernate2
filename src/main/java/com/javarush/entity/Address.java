package com.javarush.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "movie", name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short id;

    private String address;
    private String address2;
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city;

    @Column(name = "postal_code")
    private String postalCode;
    private String phone;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

//    @OneToMany(mappedBy = "address")
//    @ToString.Exclude
//    private final Collection<Customer> customers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "address")
//    @ToString.Exclude
//    private final Collection<Staff> staffs = new ArrayList<>();

}
