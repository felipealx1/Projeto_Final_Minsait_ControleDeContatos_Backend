package com.ControleDeContatos.ApiControleDeContatos.repository;

import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
