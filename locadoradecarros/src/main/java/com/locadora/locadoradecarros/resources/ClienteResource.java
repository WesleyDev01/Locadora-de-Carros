package com.locadora.locadoradecarros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadoradecarros.models.Cliente;
import com.locadora.locadoradecarros.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locadora")
@Api(value = "API REST Aluguéis de carros")
@CrossOrigin(origins = "*")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	@ApiOperation(value = "Lista todos os clientes")
	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}

	@PostMapping("/cliente")
	@ApiOperation(value = "Cadastra um novo cliente")
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/cliente")
	@ApiOperation(value = "Remove um cliente")
	public void removerCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
