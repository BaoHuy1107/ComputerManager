package com.example.demoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@IdClass(ServiceUsageId.class) // Sử dụng khóa phức hợp
public class ServiceUsage {
    @Id
    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "Service_id")
    private Services services;

    @Id
    @Column(name = "Usage_Date")
    @NotNull(message = "Không được để trống thông tin này")
    private LocalDate usageDate;

    @Id
    @Column(name = "Usage_Time")
    @NotNull(message = "Không được để trống thông tin này")
    private LocalTime usageTime;

    @Column(name = "Quantity")
    @Min(value = 1, message = "Số lượng phải là số nguyên dương.")
    private Integer quantity;

    public ServiceUsage() {
    }

    public ServiceUsage(Customer customer, Services services, LocalDate usageDate, LocalTime usageTime, Integer quantity) {
        this.customer = customer;
        this.services = services;
        this.usageDate = usageDate;
        this.usageTime = usageTime;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
