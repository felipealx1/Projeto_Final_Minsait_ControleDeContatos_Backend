package com.ControleDeContatos.ApiControleDeContatos.resourse;

import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import com.ControleDeContatos.ApiControleDeContatos.repository.PessoaRepository;
import com.ControleDeContatos.ApiControleDeContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Exibe todos os cadastros feitos")
    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        List<Pessoa> pessoas = pessoaService.buscarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Faz o cadastro de Pessoas")
    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrarPessoas(@RequestBody Pessoa pessoa){
        Pessoa newPessoa = pessoaService.adicionarPessoa(pessoa);
        if(newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }
    @Operation(summary = "Exibe apenas o cadastrado feito por meio do id especificado")
    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> buscarPessoasId(@PathVariable Long id){
        Pessoa pessoa =pessoaService.buscarPessoaId(id);
        return ResponseEntity.ok(pessoa);
    }

    @Operation(summary = "Exibe o ID, o nome, os dados de rua, cep, cidade e uf ficam dentro de MalaDireta")
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaDTO> listarPessoaMalaDiretaId(@PathVariable Long id){
        Pessoa pessoa = pessoaService.buscarPessoaId(id);
        PessoaMalaDiretaDTO malaDiretaDTO = new PessoaMalaDiretaDTO(pessoa.getId(), pessoa.getNome(),
                pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf());
        return ResponseEntity.ok(malaDiretaDTO);
    }

    @Operation(summary = "Atualiza os dados do cadastro feito espeficando o id")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaId(@PathVariable Long id,
                                                    @RequestBody Pessoa pessoaAtualizada){
        Pessoa atualizarPessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        if (atualizarPessoa == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarPessoa);
    }

    @Operation(summary = "Deleta os dados cadastrados de Pessoa por meio do id que for especificado")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPessoaId(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    record PessoaMalaDiretaDTO(Long id, String Nome, String MalaDireta){}




}
