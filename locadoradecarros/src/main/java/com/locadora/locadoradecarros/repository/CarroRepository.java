package com.locadora.locadoradecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadoradecarros.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	Carro findById(long id);

	Carro findByPlaca(String placa);
}
