package com.ControleDeContatos.ApiControleDeContatos.resourse;


import com.ControleDeContatos.ApiControleDeContatos.model.Contato;
import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import com.ControleDeContatos.ApiControleDeContatos.service.ContatoService;
import com.ControleDeContatos.ApiControleDeContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas/{idPessoa}/contatos")
public class ContatoResource {
    private final ContatoService contatoService;
    private final PessoaService pessoaService;

    @Autowired
    public ContatoResource(ContatoService contatoService, PessoaService pessoaService) {
        this.contatoService = contatoService;
        this.pessoaService = pessoaService;
    }

    @Operation(summary = "Exibe todos os cadastros e seus dados, e também os dados que foram cadastrados em Pessoa ")
    @GetMapping
    public ResponseEntity<List<Contato>> listarContatosPessoas(@PathVariable Long idPessoa){
        List<Contato> contatos = contatoService.buscarContatos();
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Faz o cadastro dos dados de Contato ")
    @PostMapping
    public ResponseEntity<Contato> cadastrarContato(@PathVariable Long idPessoa, @RequestBody Contato contato){
        Pessoa pessoa = pessoaService.buscarPessoaId(idPessoa);
        contato.setPessoa(pessoa);
        Contato newContato = contatoService.adicionarContato(contato);
        if(newContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newContato);
    }

    @Operation(summary = "Exibe o cadastro e seus dados, e também os dados que foram cadastrados em Pessoa, tudo por meio do id especificado")
    @GetMapping("/{id}")
    public ResponseEntity<Contato> listarContatoId(@PathVariable Long id){
        Contato contato = contatoService.buscarContatoId(id);
        return ResponseEntity.ok(contato);
    }

    @Operation(summary = "Atualiza os dados do cadastro feito em Contato por meio do id especificado ")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContatoId(@PathVariable Long id,
                                                      @RequestBody Contato contatoAtualizado){
        Contato atualizarContato = contatoService.atualizarContato(id, contatoAtualizado);
        if (atualizarContato == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatoAtualizado);
    }

    @Operation(summary = "Deleta os dados do cadastro feito em Contato por meio do id especificado ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarContatoId(@PathVariable Long id){
        contatoService.deletarContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
