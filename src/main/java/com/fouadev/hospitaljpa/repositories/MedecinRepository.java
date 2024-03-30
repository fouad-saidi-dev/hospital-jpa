package com.fouadev.hospitaljpa.repositories;

import com.fouadev.hospitaljpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByName(String name);
}
