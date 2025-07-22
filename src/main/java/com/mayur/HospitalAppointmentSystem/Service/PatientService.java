package com.mayur.HospitalAppointmentSystem.Service;

import com.mayur.HospitalAppointmentSystem.Dto.PatientDto;
import com.mayur.HospitalAppointmentSystem.Exception.PatientNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.PatientMapper;
import com.mayur.HospitalAppointmentSystem.Model.Patient;
import com.mayur.HospitalAppointmentSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    public final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDto registerPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.toPatientEntity(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toPatientDto(savedPatient);
    }

    public Page<PatientDto> getPatients(int page, int size, String direction, String sortBy) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Patient> allPatients = patientRepository.findAll(pageable);
        return allPatients.map(PatientMapper::toPatientDto);
    }

    public PatientDto getPatientById(Long patientId) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id : " + patientId));
        return PatientMapper.toPatientDto(patient);
    }

    @Transactional
    public PatientDto updatePatient(Long patientId, PatientDto patientDto) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id : " + patientId));

        if (patientDto.getName() != null)
            patient.setName(patientDto.getName());
        if (patientDto.getGender() != null)
            patient.setGender(patientDto.getGender());
        if (patientDto.getDob() != null)
            patient.setDob(patientDto.getDob());
        if (patientDto.getPhoneNumber() != null)
            patient.setPhoneNumber(patientDto.getPhoneNumber());
        if (patientDto.getEmail() != null)
            patient.setEmail(patientDto.getEmail());
        if (patientDto.getAddress() != null)
            patient.setAddress(patientDto.getAddress());
        return PatientMapper.toPatientDto(patient);
    }

    public void deletePatientById(Long patientId) throws PatientNotFoundException {
        if (!patientRepository.existsById(patientId)) {
            throw new PatientNotFoundException("Patient not found with id : " + patientId);
        }
        patientRepository.deleteById(patientId);
    }
}
