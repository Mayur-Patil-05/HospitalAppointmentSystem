package com.mayur.HospitalAppointmentSystem.Mapper;

import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Doctor;

public class DoctorMapper {
    public static DoctorDto toDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorId(doctor.getDoctorId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setPhone(doctor.getPhone());
        doctorDto.setEmail(doctor.getEmail());
        return doctorDto;
    }

    public static Doctor toEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setEmail(doctorDto.getEmail());
        return doctor;
    }
}
