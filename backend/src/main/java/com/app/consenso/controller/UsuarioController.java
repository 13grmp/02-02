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

import com.app.consenso.model.TipoUsuario;
import com.app.consenso.model.Usuario;
import com.app.consenso.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
    @PostMapping("/usuarios")
    public TipoUsuario criarNovoUsuario(@RequestBody Usuario usuario) {
        // aqui deve ser feito uma verificaçao se o tipo do usuario é correto, já que vai ser a primeira entidade a ser preenchida
        usuarioService.save(usuario);
        return usuario.getTipoUsuario();
    }

    @GetMapping("/usuarios")
    public Iterable<Usuario> obterTodosUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario obterUsuarioPorId(@PathVariable("id") Integer id){
        return usuarioService.findById(id).get();
    }

    //no put, deve ser passado o atributo "idUsuario" para referenciar o usuario a ser atualizado
    @PutMapping("/usuarios")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAtt = usuarioService.findById(usuario.getIdUsuario()).get();
        usuarioAtt.setNome(usuario.getNome());
        usuarioAtt.setSobrenome(usuario.getSobrenome());
        usuarioAtt.setEmail(usuario.getEmail());
        usuarioAtt.setSenha(usuario.getSenha());
        usuarioAtt.setTipoUsuario(usuario.getTipoUsuario());
        usuarioService.save(usuarioAtt);

        return usuarioAtt;
    }

    @DeleteMapping("/usuarios/{id}")
    public String removeUsuarioPorId(@PathVariable("id") Integer id) {
        usuarioService.deleteById(id);
        return "Contato removido com sucesso!";
    }

    @Autowired
    private UsuarioService usuarioService;
}