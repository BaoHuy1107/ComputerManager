package com.example.demoSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "MACHINE")
public class Machine {
    @Id
    @Column(name = "Machine_id")
    @NotBlank(message = "Không được để trống thông tin này")
    @Pattern(regexp = "^M\\d{2}$",
            message = "Mã máy phải theo định dạng Mxx, với x là ký tự số.")
    private String id;

    @Column(name = "Location")
    private String location;

    @Column(name = "Status")
    private String status;

    @OneToMany(mappedBy = "machine", fetch = FetchType.LAZY)
    private List<MachineUsage> machineUsages;

    public Machine() {
    }
    public Machine(String id, String location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MachineUsage> getMachineUsages() {
        return machineUsages;
    }

    public void setMachineUsages(List<MachineUsage> machineUsages) {
        this.machineUsages = machineUsages;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", machineUsages=" + machineUsages +
                '}';
    }
}
