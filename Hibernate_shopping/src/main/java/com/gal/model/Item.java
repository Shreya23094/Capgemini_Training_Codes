package com.gal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    long itemid;

    String name, type;
    Double cost;


}