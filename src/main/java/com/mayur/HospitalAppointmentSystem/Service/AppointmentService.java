package com.mayur.HospitalAppointmentSystem.Service;

import com.mayur.HospitalAppointmentSystem.Dto.AppointmentDto;
import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.DoctorNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.PatientNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.AppointmentMapper;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Doctor;
import com.mayur.HospitalAppointmentSystem.Model.Patient;
import com.mayur.HospitalAppointmentSystem.Repository.AppointmentRepository;
import com.mayur.HospitalAppointmentSystem.Repository.DoctorRepository;
import com.mayur.HospitalAppointmentSystem.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public AppointmentDto addAppointment(Long patientId, Long doctorId, AppointmentDto appointmentDto) throws
            PatientNotFoundException,
            DoctorNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id : " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id : " + doctorId));

        Appointment appointment = AppointmentMapper.toEntity(appointmentDto);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.toAppointmentDto(savedAppointment);
    }

    public Page<AppointmentDto> getAllAppointments(int page, int size, String direction, String sortBy) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Appointment> appointments = appointmentRepository.findAll(pageable);
        return appointments.map(AppointmentMapper::toAppointmentDto);
    }

    public AppointmentDto getAppointmentById(Long appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id : " + appointmentId));
        return AppointmentMapper.toAppointmentDto(appointment);
    }

    @Transactional
    public AppointmentDto updateAppointment(Long appointmentId, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id : " + appointmentId));
        if (appointment.getAppointmentStatus() != null)
            appointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
        return AppointmentMapper.toAppointmentDto(appointment);
    }

    public void deleteAppointment(Long appointmentId) throws AppointmentNotFoundException {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new AppointmentNotFoundException("Appointment not found with id : " + appointmentId);
        }
        appointmentRepository.deleteById(appointmentId);
    }
}
