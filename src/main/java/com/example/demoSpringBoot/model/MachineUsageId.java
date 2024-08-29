package com.example.demoSpringBoot.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class MachineUsageId implements Serializable {
    private String customer;
    private String machine;
    private LocalDate startDate;
    private LocalTime startTime;

    public MachineUsageId() {
    }

    public MachineUsageId(String customer, String machine, LocalDate startDate, LocalTime startTime) {
        this.customer = customer;
        this.machine = machine;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineUsageId that = (MachineUsageId) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(machine, that.machine) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(startTime, that.startTime);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(customer, machine, startDate, startTime);
    }
}
