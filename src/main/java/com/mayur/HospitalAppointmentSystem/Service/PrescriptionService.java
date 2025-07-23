package com.mayur.HospitalAppointmentSystem.Service;

import com.mayur.HospitalAppointmentSystem.Dto.PrescriptionDto;
import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.PrescriptionNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.PrescriptionMapper;
import com.mayur.HospitalAppointmentSystem.Model.Appointment;
import com.mayur.HospitalAppointmentSystem.Model.Prescription;
import com.mayur.HospitalAppointmentSystem.Repository.AppointmentRepository;
import com.mayur.HospitalAppointmentSystem.Repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, AppointmentRepository appointmentRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public PrescriptionDto addPrescription(Long appointmentId, PrescriptionDto prescriptionDto) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id : " + appointmentId));
        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDto);
        prescription.setAppointment(appointment);
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return PrescriptionMapper.toDto(savedPrescription);
    }

    public Page<PrescriptionDto> getAllPrescriptions(int page, int size, String direction, String sortBy) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Prescription> prescriptions = prescriptionRepository.findAll(pageable);
        return prescriptions.map(PrescriptionMapper::toDto);
    }

    public PrescriptionDto getPrescriptionById(Long prescriptionId) throws PrescriptionNotFoundException {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new AppointmentNotFoundException("Prescription not found with id : " + prescriptionId));
        return PrescriptionMapper.toDto(prescription);
    }

    @Transactional
    public PrescriptionDto updatePrescription(Long prescriptionId, PrescriptionDto prescriptionDto) throws PrescriptionNotFoundException {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new AppointmentNotFoundException("Prescription not found with id : " + prescriptionId));
        if (prescription.getMedicineName() != null)
            prescription.setMedicineName(prescriptionDto.getMedicineName());
        if (prescription.getDosage() != null)
            prescription.setDosage(prescriptionDto.getDosage());
        if (prescription.getFrequency() != null)
            prescription.setFrequency(prescriptionDto.getFrequency());
        if (prescription.getDuration() != null)
            prescription.setDuration(prescriptionDto.getDuration());
        return PrescriptionMapper.toDto(prescription);
    }

    public void deletePrescription(Long prescriptionId) throws PrescriptionNotFoundException {
        if (!prescriptionRepository.existsById(prescriptionId)) {
            throw new PrescriptionNotFoundException("Prescription not found with id : " + prescriptionId);
        }
        prescriptionRepository.deleteById(prescriptionId);
    }
}
