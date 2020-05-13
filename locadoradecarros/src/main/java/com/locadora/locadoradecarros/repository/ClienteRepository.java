package com.locadora.locadoradecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.locadoradecarros.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
