package com.rosatel.api.service;

import com.rosatel.api.model.Ciudad;
import com.rosatel.api.model.Distrito;

import java.util.List;

public interface IUbicacionService {
    List<Ciudad> listarCiudades();
    Ciudad guardarCiudad(Ciudad ciudad);

    List<Distrito> listarDistritos();
    Distrito guardarDistrito(Distrito distrito);
    void eliminarDistrito(Integer id);
}