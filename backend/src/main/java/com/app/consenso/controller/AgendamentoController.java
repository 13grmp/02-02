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

import com.app.consenso.model.Agendamento;
import com.app.consenso.model.Servico;
import com.app.consenso.model.Usuario;
import com.app.consenso.service.AgendamentoService;
import com.app.consenso.service.ServicoService;
import com.app.consenso.service.UsuarioService;
@CrossOrigin(origins = "*")
@RestController
public class AgendamentoController {
    @PostMapping("/agendamentos")
    public Object criarNovoAgendamento(@RequestBody Agendamento agendamento){ //retornando Object que é a raiz da hierarquia de classes
        //cliente -> agendamento ; prestador -> serviço
        Usuario user  = usuarioService.findById(agendamento.getUsuario().getIdUsuario()).get();

        if(user.getTipoUsuario().getIdTipoUsuario() == 1){
            return agendamentoService.save(agendamento);
        }else {
            return "Tipo de usuario não compatível com método";  //retorno de String possibilitado pelo class Object
        }
    }

    @GetMapping("/agendamentos")
    public Iterable<Agendamento> obterTodosAgendamentos(){
        return agendamentoService.findAll();
    } 

    @GetMapping("/agendamentos/{id}")
    public Agendamento obterAgendamentoPorId(@PathVariable("id") Integer id){
        return agendamentoService.findById(id).get();
    }

    // @GetMapping("/agendamentos/{id}")

    @PutMapping("/agendamentos")
    public Agendamento atualizaAgendamento(@RequestBody Agendamento agendamento){
        Agendamento agendamentoAtt = agendamentoService.findById(agendamento.getIdAgendamento()).get();
        agendamentoAtt.setData(agendamento.getData());
        agendamentoAtt.setHora(agendamento.getHora());

        agendamentoService.save(agendamentoAtt);
        return agendamentoAtt;
    }

    @DeleteMapping("/agendamentos/{id}")
    public String removeAgendamento(@PathVariable("id") Integer id){
        agendamentoService.deleteById(id);
        return "Agendamento removido com sucesso!";
    }

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AgendamentoService agendamentoService;

}
