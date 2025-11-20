package com.example.banque_service.repositories;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface Repository pour gérer les opérations CRUD sur les comptes bancaires
 * Hérite de JpaRepository qui fournit les méthodes de base (save, findAll, findById, delete, etc.)
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    /**
     * Recherche tous les comptes d'un type spécifique
     * @param type le type de compte (COURANT ou EPARGNE)
     * @return liste des comptes du type spécifié
     */
    List<Compte> findByType(TypeCompte type);
    
    /**
     * Recherche tous les comptes dont le solde est supérieur à un montant donné
     * @param solde le montant minimum du solde
     * @return liste des comptes avec un solde supérieur au montant spécifié
     */
    List<Compte> findBySoldeGreaterThan(double solde);

    /**
     * Calcule la somme totale de tous les soldes des comptes
     * Utilise COALESCE pour retourner 0.0 si aucun compte n'existe
     * @return la somme totale des soldes de tous les comptes
     */
    @Query("SELECT COALESCE(SUM(c.solde), 0.0) FROM Compte c")
    double sumSoldes();
}
