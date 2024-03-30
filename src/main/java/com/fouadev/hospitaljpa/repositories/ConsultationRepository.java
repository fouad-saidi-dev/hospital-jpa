package com.fouadev.hospitaljpa.repositories;

import com.fouadev.hospitaljpa.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
