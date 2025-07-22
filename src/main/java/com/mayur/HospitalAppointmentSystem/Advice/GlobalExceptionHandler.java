package com.mayur.HospitalAppointmentSystem.Advice;

import com.mayur.HospitalAppointmentSystem.Exception.AppointmentNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.DoctorNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.PatientNotFoundException;
import com.mayur.HospitalAppointmentSystem.Exception.PrescriptionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handle(PatientNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> handle(DoctorNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<String> handle(AppointmentNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PrescriptionNotFoundException.class)
    public ResponseEntity<String> handle(PrescriptionNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
