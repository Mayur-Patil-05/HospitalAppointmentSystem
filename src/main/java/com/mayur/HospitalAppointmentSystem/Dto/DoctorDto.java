package com.mayur.HospitalAppointmentSystem.Dto;

import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class DoctorDto {
    private Long doctorId;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    private List<Long> appointments = new ArrayList<>();

    public DoctorDto() {
    }

    public DoctorDto(Long doctorId, String name, String specialization, String phone, String email, List<Long> appointments) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.appointments = appointments;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public List<Long> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Long> appointments) {
        this.appointments = appointments;
    }
}
