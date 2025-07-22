package com.mayur.HospitalAppointmentSystem.Mapper;

import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Model.Prescription;

public class PrescriptionMapper {
    public static PrescriptionDto toDto(Prescription prescription) {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        prescriptionDto.setPrescriptionId(prescription.getPrescriptionId());
        prescriptionDto.setMedicineName(prescription.getMedicineName());
        prescriptionDto.setDosage(prescription.getDosage());
        prescriptionDto.setFrequency(prescription.getFrequency());
        prescriptionDto.setDuration(prescription.getDuration());
        prescriptionDto.setAppointmentDto(AppointmentMapper.toAppointmentDto(prescription.getAppointment()));
        return prescriptionDto;
    }

    public static Prescription toEntity(PrescriptionDto prescriptionDto) {
        Prescription prescription = new Prescription();
        prescription.setMedicineName(prescriptionDto.getMedicineName());
        prescription.setDosage(prescriptionDto.getDosage());
        prescription.setFrequency(prescriptionDto.getFrequency());
        prescription.setDuration(prescriptionDto.getDuration());
        prescription.setAppointment(AppointmentMapper.toEntity(prescriptionDto.getAppointmentDto()));
        return prescription;
    }
}
