package com.example.demoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@IdClass(MachineUsageId.class) // Sử dụng khóa phức hợp
public class MachineUsage {
    @Id
    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "Machine_id")
    private Machine machine;

    @Id
    @Column(name = "Start_Date")
    @NotNull(message = "Không được để trống thông tin này")
    private LocalDate startDate;

    @Id
    @Column(name = "Start_Time")
    @NotNull(message = "Không được để trống thông tin này")
    private LocalTime startTime;

    @Column(name = "Usage_duration")
    @Min(value = 1, message = "Thời gian phải là số nguyên dương.")
    private Integer usageDuration;

    // constructor
    public MachineUsage() {
    }

    public MachineUsage(Customer customer, Machine machine, LocalDate startDate, LocalTime startTime,
                        Integer usageDuration) {
        this.customer = customer;
        this.machine = machine;
        this.startDate = startDate;
        this.startTime = startTime;
        this.usageDuration = usageDuration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
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

    public Integer getUsageDuration() {
        return usageDuration;
    }

    public void setUsageDuration(Integer usageDuration) {
        this.usageDuration = usageDuration;
    }

}
