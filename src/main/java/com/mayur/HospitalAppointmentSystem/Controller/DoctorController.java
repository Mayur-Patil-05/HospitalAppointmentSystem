package com.mayur.HospitalAppointmentSystem.Controller;

import com.mayur.HospitalAppointmentSystem.Dto.DoctorDto;
import com.mayur.HospitalAppointmentSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    public final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> registerDoctor(@RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorDto>> getDoctors(@RequestParam(defaultValue = "0") int size,
                                                      @RequestParam(defaultValue = "3") int page,
                                                      @RequestParam(defaultValue = "asc") String direction,
                                                      @RequestParam(defaultValue = "doctorId") String sortBy) {
        return new ResponseEntity<>(doctorService.getDoctors(size, page, direction, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId) {
        return new ResponseEntity<>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorId, doctorDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable Long doctorId) {
        doctorService.deleteDoctorById(doctorId);
        return ResponseEntity.noContent().build();
    }
}
