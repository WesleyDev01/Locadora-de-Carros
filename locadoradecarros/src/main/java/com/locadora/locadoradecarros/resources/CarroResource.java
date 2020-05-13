package com.locadora.locadoradecarros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadoradecarros.models.Carro;
import com.locadora.locadoradecarros.repository.CarroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locadora")
@Api(value = "API REST Aluguéis de carros")
@CrossOrigin(origins = "*")
public class CarroResource {

	@Autowired
	CarroRepository carroRepository;

	@GetMapping("/carros")
	@ApiOperation(value = "Lista todos os carros")
	public List<Carro> listaCarros() {
		return carroRepository.findAll();
	}

	@GetMapping("/carro/{id}")
	@ApiOperation(value = "Lista um carro pelo seu ID")
	public Carro listaCarroId(@PathVariable(value = "id") long id) {
		return carroRepository.findById(id);
	}

	@GetMapping("/carro/placa/{placa}")
	@ApiOperation(value = "Lista um carro pela sua placa")
	public Carro listaCarroPlaca(@PathVariable(value = "placa") String placa) {
		return carroRepository.findByPlaca(placa);
	}

	@PostMapping("/carro")
	@ApiOperation(value = "Cadastra um novo carro")
	public Carro cadastrarCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}

	@DeleteMapping("/carro")
	@ApiOperation(value = "Remove um carro")
	public void removerCarro(@RequestBody Carro carro) {
		carroRepository.delete(carro);
	}

	@PutMapping("/carro")
	@ApiOperation(value = "Atualiza os dados do carro")
	public Carro atualizarCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
}
