package com.app.consenso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.consenso.model.Servico;
import com.app.consenso.model.Usuario;
import com.app.consenso.service.ServicoService;
import com.app.consenso.service.UsuarioService;
@CrossOrigin(origins = "*")
@RestController
public class ServicoController {
    @PostMapping("/servicos")
    public Object criarNovoServico(@RequestBody Servico servico){
        Usuario user  = usuarioService.findById(servico.getUsuario().getIdUsuario()).get();
       //prestador = 2
        if(user.getTipoUsuario().getIdTipoUsuario() == 2){
            return servicoService.save(servico);
        }else{
            return "Tipo de usuario não compatível com método";
        }   
    }

    @GetMapping("/servicos")
    public Iterable<Servico> obterTodosUsuarios(){
        return servicoService.findAll();
    }

    @GetMapping("/servicos/{id}")
    public Servico oterServicoPorId(@PathVariable("id") Integer id){
        return servicoService.findById(id).get();
    }
    @PutMapping("/servicos")
    public Servico atualizaServico(@RequestBody Servico servico){
        Servico servicoAtt = servicoService.findById(servico.getIdServico()).get();
        servicoAtt.setNome(servico.getNome());
        servicoAtt.setDescricao(servico.getDescricao());
        servicoService.save(servicoAtt);

        return servicoAtt;
    }

    @DeleteMapping("/servicos/{id}")
    public String removeServicoPorId(@PathVariable("id") Integer id){
        servicoService.deleteById(id);
        
        return "Serviço removido com sucesso!";
    }
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private UsuarioService usuarioService;
}
