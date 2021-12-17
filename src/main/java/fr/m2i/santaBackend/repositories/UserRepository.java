package fr.m2i.santaBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2i.santaBackend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
