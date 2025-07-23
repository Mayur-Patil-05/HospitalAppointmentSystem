package com.mayur.HospitalAppointmentSystem.Dto;

import com.mayur.HospitalAppointmentSystem.Model.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {
    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus appointmentStatus;
    private PatientDto patientDto;
    private DoctorDto doctorDto;
    private PrescriptionDto prescriptionDto;

    public AppointmentDto() {
    }

    public AppointmentDto(Long appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, AppointmentStatus appointmentStatus, PatientDto patientDto, DoctorDto doctorDto, PrescriptionDto prescriptionDto) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
        this.patientDto = patientDto;
        this.doctorDto = doctorDto;
        this.prescriptionDto = prescriptionDto;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public void setDoctorDto(DoctorDto doctorDto) {
        this.doctorDto = doctorDto;
    }

    public PrescriptionDto getPrescriptionDto() {
        return prescriptionDto;
    }

    public void setPrescriptionDto(PrescriptionDto prescriptionDto) {
        this.prescriptionDto = prescriptionDto;
    }
}
