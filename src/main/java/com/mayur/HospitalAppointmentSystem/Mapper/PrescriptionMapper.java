package com.mayur.HospitalAppointmentSystem.Mapper;

import com.mayur.HospitalAppointmentSystem.Dto.AppointmentDto;
import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Dto.PatientDto;
import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Prescription;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrescriptionMapper {
    public static PrescriptionDto toDto(Prescription prescription) {
        if (prescription == null) {
            return null;
        }
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setPrescriptionId(prescription.getPrescriptionId());
        prescriptionDto.setMedicineName(prescription.getMedicineName());
        prescriptionDto.setDosage(prescription.getDosage());
        prescriptionDto.setFrequency(prescription.getFrequency());
        prescriptionDto.setDuration(prescription.getDuration());

        return prescriptionDto;
    }


    public static Prescription toEntity(PrescriptionDto prescriptionDto) {
        Prescription prescription = new Prescription();
        prescription.setMedicineName(prescriptionDto.getMedicineName());
        prescription.setDosage(prescriptionDto.getDosage());
        prescription.setFrequency(prescriptionDto.getFrequency());
        prescription.setDuration(prescriptionDto.getDuration());
        return prescription;
    }
}