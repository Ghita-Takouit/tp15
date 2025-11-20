package com.example.banque_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Entité JPA représentant un compte bancaire
 * Cette classe modélise les informations d'un compte avec son solde, sa date de création et son type
 */
@Entity
@Data // Génère automatiquement les getters, setters, toString, equals et hashCode
@NoArgsConstructor // Génère un constructeur sans paramètres
@AllArgsConstructor // Génère un constructeur avec tous les paramètres
public class Compte {

    /** Identifiant unique du compte, généré automatiquement */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Solde du compte bancaire */
    private double solde;

    /** Date de création du compte */
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    /** Type de compte (COURANT ou EPARGNE) */
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
