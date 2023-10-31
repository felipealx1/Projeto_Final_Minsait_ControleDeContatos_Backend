package com.ControleDeContatos.ApiControleDeContatos.service;

import com.ControleDeContatos.ApiControleDeContatos.exception.ContatoNotFoundException;
import com.ControleDeContatos.ApiControleDeContatos.model.Contato;
import com.ControleDeContatos.ApiControleDeContatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> buscarContatos(){
        return contatoRepository.findAll();
    }

    public Contato buscarContatoId(Long id){
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não foi encontrado pelo id: "+ id));
    }

    public Contato adicionarContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato atualizarContato(Long id, Contato contatoAtualizado){
        Contato contatoExistente = contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNotFoundException("Não foi possível autalizar, pois o contato não foi encontrado pelo id: "+ id));
        contatoExistente.setTipoContato(contatoAtualizado.getTipoContato());
        contatoExistente.setContato(contatoAtualizado.getContato());
        return contatoRepository.save(contatoExistente);
    }

    public void deletarContato(Long id){
        contatoRepository.deleteById(id);
    }



}
