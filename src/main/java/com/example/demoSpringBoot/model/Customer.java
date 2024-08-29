package com.example.demoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(name = "Customer_id")
    @NotBlank(message = "Không được để trống thông tin này")
    @Pattern(regexp = "^KH\\d{3}$",
            message = "Mã KH phải theo định dạng KHxxx, với x là ký tự số.")
    private String id;

    @Column(name = "Customer_name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone_number")
    @Pattern(regexp = "^(090\\d{7}|091\\d{7}|\\(84\\)\\+90\\d{7}|\\(84\\)\\+91\\d{7})$",
            message = "Số điện thoại không hợp lệ")
    private String phone;

    @Column(name = "Email")
    @NotBlank(message = "Không được để trống thông tin này")
    @Email(message = "Định dạng email không hợp lệ")
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<ServiceUsage> serviceUsages;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<MachineUsage> machineUsages;

    public Customer() {
    }
    public Customer(String id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ServiceUsage> getServiceUsages() {
        return serviceUsages;
    }

    public void setServiceUsages(List<ServiceUsage> serviceUsages) {
        this.serviceUsages = serviceUsages;
    }

    public List<MachineUsage> getMachineUsages() {
        return machineUsages;
    }

    public void setMachineUsages(List<MachineUsage> machineUsages) {
        this.machineUsages = machineUsages;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", serviceUsages=" + serviceUsages +
                ", machineUsages=" + machineUsages +
                '}';
    }
}
