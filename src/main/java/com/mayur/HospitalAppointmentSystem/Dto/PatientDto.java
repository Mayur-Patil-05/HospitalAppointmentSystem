package com.mayur.HospitalAppointmentSystem.Dto;

import com.mayur.HospitalAppointmentSystem.Model.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDto {
    private Long patientId;
    private String name;
    private Gender gender;
    private Date dob;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate registrationDate;
    private List<Long> appointments = new ArrayList<>();

    public PatientDto() {
    }

    public PatientDto(Long patientId, String name, Gender gender, Date dob, String phoneNumber, String email, String address, LocalDate registrationDate, List<Long> appointments) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.registrationDate = registrationDate;
        this.appointments = appointments;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Long> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Long> appointments) {
        this.appointments = appointments;
    }
}
