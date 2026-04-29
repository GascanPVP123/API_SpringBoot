package com.rosatel.api.service;

import com.rosatel.api.model.Usuario;
import com.rosatel.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public String login(String correo, String contrasena) {
        Usuario u = usuarioRepo.findByCorreo(correo);

        if (u != null && u.getContraseña().equals(contrasena)) {
            return "Bienvenido " + u.getNombre() + " (Rol: " + u.getRol() + ")";
        }

        return "Correo o contraseña incorrectos";
    }
}