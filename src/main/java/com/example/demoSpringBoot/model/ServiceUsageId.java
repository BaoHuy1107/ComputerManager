package com.example.demoSpringBoot.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class ServiceUsageId implements Serializable {
    private String customer;
    private String services;
    private LocalDate usageDate;
    private LocalTime usageTime;

    public ServiceUsageId() {
    }

    public ServiceUsageId(String customer, String services, LocalDate usageDate, LocalTime usageTime) {
        this.customer = customer;
        this.services = services;
        this.usageDate = usageDate;
        this.usageTime = usageTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return services;
    }

    public void setService(String service) {
        this.services = service;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }

    public LocalTime getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(LocalTime usageTime) {
        this.usageTime = usageTime;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceUsageId that = (ServiceUsageId) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(services, that.services) &&
                Objects.equals(usageDate, that.usageDate) &&
                Objects.equals(usageTime, that.usageTime);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(customer, services, usageDate, usageTime);
    }
}
