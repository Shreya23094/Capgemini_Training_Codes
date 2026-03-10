package com.gal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.TableGenerator;

@Entity
public class AnOrder {

    @TableGenerator(name = "allseqgenerator", allocationSize = 1, initialValue = 101, pkColumnName = "seqname", pkColumnValue = "nextorderid")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long orderid;

    @ManyToOne(fetch = FetchType.EAGER) // customer_custid
    @JoinColumn(name = "custid")
    Customer customer;
//	custid	numberItems	amount	deliveryaddress	paymentid

    int numberItems;
    Double amnout;
    String deliveryAddress;

    @OneToOne
    @JoinColumn(name = "paymentid")
    Payment payment;

}