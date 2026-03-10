package com.gal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Supplier {

    @Id
    int sid;

    String sname;
    double srank;
    String city;

    @OneToMany(mappedBy = "supplier")
    List<Supply> supplies;

    public List<Supply> getSupplies() {
        return supplies;
    }

    public Supplier() {
    }

    public Supplier(int sid, String sname, double srank, String city){
        this.sid = sid;
        this.sname = sname;
        this.srank = srank;
        this.city = city;

    }

    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public Double getSrank() {
        return srank;
    }

    public void setSrank(Double srank) {
        this.srank = srank;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
