package fr.m2i.santaBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2i.santaBackend.models.Liste;

public interface ListeRepository extends JpaRepository<Liste, Long>{

}
