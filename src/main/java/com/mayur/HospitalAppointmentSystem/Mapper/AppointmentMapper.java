package com.mayur.HospitalAppointmentSystem.Mapper;

import com.mayur.HospitalAppointmentSystem.Dto.AppointmentDto;
import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Dto.PatientDto;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentMapper {
    public static AppointmentDto toAppointmentDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentId(appointment.getAppointmentId());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDto.setAppointmentStatus(appointment.getAppointmentStatus());
        appointmentDto.setPatientDto(PatientMapper.toPatientDto(appointment.getPatient()));
        appointmentDto.setDoctorDto(DoctorMapper.toDto(appointment.getDoctor()));
        appointmentDto.setPrescriptionDto(PrescriptionMapper.toDto(appointment.getPrescription()));
        return appointmentDto;
    }

    public static Appointment toEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setAppointmentTime(LocalTime.now());
        appointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
        return appointment;
    }
}
