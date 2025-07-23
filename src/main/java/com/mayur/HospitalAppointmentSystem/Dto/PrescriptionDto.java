package com.mayur.HospitalAppointmentSystem.Dto;

public class PrescriptionDto {
    private Long prescriptionId;
    private String medicineName;
    private String dosage;
    private String frequency;
    private String duration;
    private AppointmentDto appointmentDto;

    public PrescriptionDto() {
    }

    public PrescriptionDto(Long prescriptionId, String medicineName, String dosage, String frequency, String duration, AppointmentDto appointmentDto) {
        this.prescriptionId = prescriptionId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.duration = duration;
        this.appointmentDto = appointmentDto;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public AppointmentDto getAppointmentDto() {
        return appointmentDto;
    }

    public void setAppointmentDto(AppointmentDto appointmentDto) {
        this.appointmentDto = appointmentDto;
    }
}
