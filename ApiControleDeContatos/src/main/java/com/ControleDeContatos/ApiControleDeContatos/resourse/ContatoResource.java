package com.ControleDeContatos.ApiControleDeContatos.resourse;


import com.ControleDeContatos.ApiControleDeContatos.model.Contato;
import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import com.ControleDeContatos.ApiControleDeContatos.service.ContatoService;
import com.ControleDeContatos.ApiControleDeContatos.service.PessoaService;
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

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatosPessoas(@PathVariable Long idPessoa){
        List<Contato> contatos = contatoService.buscarContatos();
        return ResponseEntity.ok(contatos);
    }

    @PostMapping
    public ResponseEntity<Contato> cadastrarContato(@PathVariable Long idPessoa, @RequestBody Contato contato){
        Pessoa pessoa = pessoaService.buscarPessoaId(idPessoa);
        contato.setPessoa(pessoa);
        Contato newContato = contatoService.adicionarContato(contato);
        if(newContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newContato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> listarContatoId(@PathVariable Long id){
        Contato contato = contatoService.buscarContatoId(id);
        return ResponseEntity.ok(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContatoId(@PathVariable Long id,
                                                      @RequestBody Contato contatoAtualizado){
        Contato atualizarContato = contatoService.atualizarContato(id, contatoAtualizado);
        if (atualizarContato == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contatoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarContatoId(@PathVariable Long id){
        contatoService.deletarContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
