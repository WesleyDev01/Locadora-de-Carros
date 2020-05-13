package com.locadora.locadoradecarros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.locadoradecarros.models.Aluguel;
import com.locadora.locadoradecarros.repository.AluguelRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locadora")
@Api(value = "API REST Aluguéis de carros")
@CrossOrigin(origins = "*")
public class AluguelResource {

	@Autowired
	AluguelRepository aluguelRepository;

	@GetMapping("/alugueis")
	@ApiOperation(value = "Lista todos os aluguéis")
	public List<Aluguel> listarAlugeis() {
		return aluguelRepository.findAll();
	}

	@GetMapping("/aluguel/{id}")
	@ApiOperation(value = "Lista aluguel pelo ID")
	public Aluguel listaAluguelId(@PathVariable(value = "id") long id) {
		return aluguelRepository.findById(id);
	}

	@PostMapping("/aluguel")
	@ApiOperation(value = "Efetua um novo aluguel")
	public Aluguel efetuarAluguel(@RequestBody Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}

	@PutMapping("/aluguel")
	@ApiOperation(value = "Atualiza os dados de um aluguel pelo ID")
	public Aluguel atualizarAluguel(@RequestBody Aluguel aluguel) {
		return aluguelRepository.save(aluguel);
	}
}
