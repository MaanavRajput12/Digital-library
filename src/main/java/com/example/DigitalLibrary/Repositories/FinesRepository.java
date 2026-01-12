package com.example.DigitalLibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DigitalLibrary.Entites.Fines;

public interface FinesRepository extends JpaRepository<Fines, Long> {
}
