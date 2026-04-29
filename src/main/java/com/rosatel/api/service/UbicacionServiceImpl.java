package com.rosatel.api.service;

import com.rosatel.api.model.Ciudad;
import com.rosatel.api.model.Distrito;
import com.rosatel.api.repository.CiudadRepository;
import com.rosatel.api.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements IUbicacionService {

    @Autowired
    private CiudadRepository ciudadRepo;

    @Autowired
    private DistritoRepository distritoRepo;

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad guardarCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    @Override
    public List<Distrito> listarDistritos() {
        return distritoRepo.findAll();
    }

    @Override
    public Distrito guardarDistrito(Distrito distrito) {
        return distritoRepo.save(distrito);
    }

    @Override
    public void eliminarDistrito(Integer id) {
        distritoRepo.deleteById(id);
    }
}
