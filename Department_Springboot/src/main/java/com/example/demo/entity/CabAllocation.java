package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cab_allocation")
public class CabAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer cabid;
    Integer employeeid;

    Date allocateDate;

    // ===== Getters =====
    public Long getId() {
        return id;
    }

    public Integer getCabid() {
        return cabid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public Date getAllocateDate() {
        return allocateDate;
    }

    // ===== Setters =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setCabid(Integer cabid) {
        this.cabid = cabid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public void setAllocateDate(Date allocateDate) {
        this.allocateDate = allocateDate;
    }
}