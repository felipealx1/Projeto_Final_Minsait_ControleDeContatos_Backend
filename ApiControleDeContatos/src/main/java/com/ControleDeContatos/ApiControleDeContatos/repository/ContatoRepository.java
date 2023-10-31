package com.ControleDeContatos.ApiControleDeContatos.repository;

import com.ControleDeContatos.ApiControleDeContatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
