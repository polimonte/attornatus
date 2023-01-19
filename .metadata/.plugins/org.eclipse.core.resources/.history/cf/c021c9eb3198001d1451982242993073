package com.attornatus.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.backend.entities.Pessoa;
import com.attornatus.backend.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Long salvarPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return pessoa.getId_pessoa();
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> listarPessoasPorId(long id){
		return pessoaRepository.findById(id);
	}
	
	public void removerPessoa(long id) {
		pessoaRepository.deleteById(id);
	}
}