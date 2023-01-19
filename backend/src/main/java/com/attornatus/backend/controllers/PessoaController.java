package com.attornatus.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.attornatus.backend.entities.Pessoa;
import com.attornatus.backend.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public long salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.salvarPessoa(pessoa);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> listarPessoas(){
		return pessoaService.listarPessoas();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pessoa listarPessoasPorId(@PathVariable Long id) {
		return pessoaService.listarPessoasPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa com id: " + id + " não foi encontrado."));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPessoa (@PathVariable Long id, @RequestBody Pessoa pessoaDetalhes) {
		Pessoa update = pessoaService.listarPessoasPorId(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Pessoa com id: " + id + " não foi encontrado."));
		
		update.setCep(pessoaDetalhes.getCep());
		update.setCidade(pessoaDetalhes.getCidade());
		update.setDataDeAniversario(pessoaDetalhes.getDataDeAniversario());
		update.setLogradouro(pessoaDetalhes.getLogradouro());
		update.setNome(pessoaDetalhes.getNome());
		update.setNumero(pessoaDetalhes.getNumero());
		
		pessoaService.salvarPessoa(update);
	}
	
	@DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPessoa(@PathVariable Long id) {
		Pessoa remover = pessoaService.listarPessoasPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
		                "Endereco com id: " + id + " não foi encontrado."));
		
		pessoaService.removerPessoa(remover.getId_pessoa());
	}
}