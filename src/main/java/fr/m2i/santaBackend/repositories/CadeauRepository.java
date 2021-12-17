package fr.m2i.santaBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2i.santaBackend.models.Cadeau;

public interface CadeauRepository extends JpaRepository<Cadeau, Long>{

}
