package com.mayur.HospitalAppointmentSystem.Mapper;

import com.mayur.HospitalAppointmentSystem.Dto.PatientDto;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientDto toPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setName(patient.getName());
        patientDto.setGender(patient.getGender());
        patientDto.setDob(patient.getDob());
        patientDto.setPhoneNumber(patient.getPhoneNumber());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setRegistrationDate(patient.getRegistrationDate());
        patientDto.setAppointments(patient.getAppointments().stream().map(Appointment::getAppointmentId).toList());
        return patientDto;
    }


    public static Patient toPatientEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setDob(patientDto.getDob());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setRegistrationDate(LocalDate.now());
        return patient;
    }
}
