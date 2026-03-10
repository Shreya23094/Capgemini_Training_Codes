package com.gal.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {

    @SequenceGenerator(name = "customerSeq", initialValue = 1001, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
    // hibernate will generate the id with the help of some
    // other table/sequence in DB

    long custid;
    String name, address, phone, email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<AnOrder> orders;

}