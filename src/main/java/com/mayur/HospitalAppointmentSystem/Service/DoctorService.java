package com.mayur.HospitalAppointmentSystem.Service;

import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Exception.DoctorNotFoundException;
import com.mayur.HospitalAppointmentSystem.Mapper.DoctorMapper;
import com.mayur.HospitalAppointmentSystem.Model.Doctor;
import com.mayur.HospitalAppointmentSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {
    public final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.toEntity(doctorDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDto(savedDoctor);
    }

    public Page<DoctorDto> getDoctors(int page, int size, String direction, String sortBy) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Doctor> allDoctors = doctorRepository.findAll(pageable);
        return allDoctors.map(DoctorMapper::toDto);
    }

    public DoctorDto getDoctorById(Long doctorId) throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id : " + doctorId));
        return DoctorMapper.toDto(doctor);
    }

    @Transactional
    public DoctorDto updateDoctor(Long doctorId, DoctorDto doctorDto) throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id : " + doctorId));

        if (doctor.getName() != null)
            doctor.setName(doctorDto.getName());
        if (doctor.getSpecialization() != null)
            doctor.setSpecialization(doctorDto.getSpecialization());
        if (doctor.getPhone() != null)
            doctor.setPhone(doctorDto.getPhone());
        if (doctor.getEmail() != null)
            doctor.setEmail(doctorDto.getEmail());
        Doctor updated = doctorRepository.save(doctor);
        return DoctorMapper.toDto(updated);
    }

    public void deleteDoctorById(Long doctorId) throws DoctorNotFoundException {
        if (!doctorRepository.existsById(doctorId)) {
            throw new DoctorNotFoundException("Doctor not found with id : " + doctorId);
        }
        doctorRepository.deleteById(doctorId);
    }
}
