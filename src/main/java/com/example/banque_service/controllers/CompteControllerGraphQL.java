package com.example.banque_service.controllers;


import com.example.banque_service.entities.Compte;
import com.example.banque_service.repositories.CompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Contrôleur GraphQL pour gérer les opérations sur les comptes bancaires
 * Expose des queries pour consulter les données et des mutations pour les modifier
 */
@Controller
@AllArgsConstructor
public class CompteControllerGraphQL {

    /** Repository pour accéder aux données des comptes */
    private CompteRepository compteRepository;

    /**
     * Query GraphQL pour récupérer tous les comptes bancaires
     * @return liste de tous les comptes
     */
    @QueryMapping
    public List<Compte> allComptes(){
        return compteRepository.findAll();
    }

    /**
     * Query GraphQL pour récupérer un compte par son identifiant
     * @param id l'identifiant du compte recherché
     * @return le compte correspondant à l'identifiant
     * @throws RuntimeException si le compte n'existe pas
     */
    @QueryMapping
    public Compte compteById(@Argument Long id){
        Compte compte = compteRepository.findById(id).orElse(null);
        if(compte == null) throw new RuntimeException(String.format("Compte %s not found", id));
        else return compte;
    }

    /**
     * Mutation GraphQL pour créer ou mettre à jour un compte
     * @param compte l'objet compte à sauvegarder
     * @return le compte sauvegardé avec son identifiant généré
     */
    @MutationMapping
    public Compte saveCompte(@Argument Compte compte){
        return compteRepository.save(compte);
    }

    /**
     * Query GraphQL pour obtenir des statistiques sur les soldes
     * Calcule le nombre total de comptes, la somme et la moyenne des soldes
     * @return Map contenant count (nombre), sum (somme) et average (moyenne)
     */
    @QueryMapping
    public Map<String, Object> totalSolde() {
        long count = compteRepository.count(); // Nombre total de comptes
        double sum = compteRepository.sumSoldes(); // Somme de tous les soldes
        double average = count > 0 ? sum / count : 0; // Calcul de la moyenne

        return Map.of(
                "count", count,
                "sum", sum,
                "average", average
        );
    }
}