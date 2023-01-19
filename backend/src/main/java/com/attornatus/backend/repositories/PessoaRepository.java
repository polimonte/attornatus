package com.attornatus.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
