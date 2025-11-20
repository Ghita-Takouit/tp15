package com.example.banque_service.repositories;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);
    
    List<Compte> findBySoldeGreaterThan(double solde);

    @Query("SELECT COALESCE(SUM(c.solde), 0.0) FROM Compte c")
    double sumSoldes();
}
