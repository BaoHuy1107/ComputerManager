package com.example.demoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Services {
    @Id
    @Column(name = "Service_id")
    @NotBlank(message = "Không được để trống thông tin này")
    @Pattern(regexp = "^DV\\d{2}$",
            message = "Mã DV phải theo định dạng DVxx, với x là ký tự số.")
    private String id;

    @Column(name = "Service_name")
    private String name;

    @Column(name = "Unit")
    private String unit;

    @Column(name = "Price")
    @Min(value = 1, message = "Đơn giá phải là số nguyên dương.")
    private Double price;

    @OneToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<ServiceUsage> serviceUsages;

    public Services() {
    }

    public Services(String id, String name, String unit, Double price, List<ServiceUsage> serviceUsages) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.serviceUsages = serviceUsages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ServiceUsage> getServiceUsages() {
        return serviceUsages;
    }

    public void setServiceUsages(List<ServiceUsage> serviceUsages) {
        this.serviceUsages = serviceUsages;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", serviceUsages=" + serviceUsages +
                '}';
    }
}
