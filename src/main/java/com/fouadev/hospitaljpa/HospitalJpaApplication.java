package com.fouadev.hospitaljpa;

import com.fouadev.hospitaljpa.entities.*;
import com.fouadev.hospitaljpa.repositories.ConsultationRepository;
import com.fouadev.hospitaljpa.repositories.MedecinRepository;
import com.fouadev.hospitaljpa.repositories.PatientRepository;
import com.fouadev.hospitaljpa.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Fouad", "Ahmed", "Reda", "Hajar")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });

            Stream.of("Youssef","Hanane","Reda")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecinRepository.save(medecin);
                    });

            Patient patient = patientRepository.findByName("Fouad");

            Medecin medecin = medecinRepository.findByName("Hanane");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.CANCELED);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setRapport("Rapport ...");
            consultation.setRendezVous(rendezVous1);
            consultationRepository.save(consultation);
        };
    }
}
