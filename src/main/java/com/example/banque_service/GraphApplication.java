package com.example.banque_service;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.TypeCompte;
import com.example.banque_service.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * Classe principale de l'application Spring Boot GraphQL pour la gestion des comptes bancaires
 * Cette classe initialise l'application et charge des données de test au démarrage
 */
@SpringBootApplication
public class GraphApplication {

    /**
     * Méthode principale qui lance l'application Spring Boot
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

    /**
     * Bean CommandLineRunner qui s'exécute au démarrage de l'application
     * Initialise la base de données avec des comptes de test
     * @param compteRepository le repository pour gérer les comptes
     * @return CommandLineRunner pour l'initialisation des données
     */
    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            // Création de données de test
            compteRepository.save(new Compte(null, 9000.0, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 5000.0, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 12000.0, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 3000.0, new Date(), TypeCompte.COURANT));

            // Affichage de tous les comptes créés
            compteRepository.findAll().forEach(compte -> {
                System.out.println(compte);
            });
        };
    }
}
