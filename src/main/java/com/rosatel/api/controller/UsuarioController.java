package com.rosatel.api.controller;

import com.rosatel.api.model.Usuario;
import com.rosatel.api.repository.UsuarioRepository;
import com.rosatel.api.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario credenciales) {
        return usuarioService.login(credenciales.getCorreo(), credenciales.getContraseña());
    }

    @GetMapping("/{id}")
    public Usuario verPerfil(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }
}