package com.fouadev.hospitaljpa.repositories;

import com.fouadev.hospitaljpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
}
