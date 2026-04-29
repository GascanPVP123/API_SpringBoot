package com.rosatel.api.service;

import com.rosatel.api.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarTodos();
    Usuario registrar(Usuario usuario);
    Usuario buscarPorId(Integer id);
    String login(String correo, String contrasena);
}
