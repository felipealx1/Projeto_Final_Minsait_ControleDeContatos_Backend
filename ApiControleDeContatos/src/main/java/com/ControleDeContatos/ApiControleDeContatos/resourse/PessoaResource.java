package com.ControleDeContatos.ApiControleDeContatos.resourse;

import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import com.ControleDeContatos.ApiControleDeContatos.repository.PessoaRepository;
import com.ControleDeContatos.ApiControleDeContatos.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaResource {
    private final PessoaService pessoaService;
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        List<Pessoa> pessoas = pessoaService.buscarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrarPessoas(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.adicionarPessoa(pessoa);
        if(newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> buscarPessoasId(@PathVariable Long id){
        Pessoa pessoa =pessoaService.buscarPessoaId(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> listarPessoaMalaDiretaId(@PathVariable Long id){
        Pessoa pessoa = pessoaService.buscarPessoaId(id);
        PessoaMalaDiretaDTO malaDiretaDTO = new PessoaMalaDiretaDTO(pessoa.getId(), pessoa.getNome(),
                pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf());
        return ResponseEntity.ok(malaDiretaDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaId(@PathVariable Long id,
                                                    @RequestBody Pessoa pessoaAtualizada){
        Pessoa atualizarPessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        if (atualizarPessoa == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarPessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPessoaId(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    record PessoaMalaDiretaDTO(Long id, String Nome, String MalaDireta){}




}
