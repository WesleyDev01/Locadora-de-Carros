package com.locadora.locadoradecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadoradecarros.models.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

	Aluguel findById(long id);
}
