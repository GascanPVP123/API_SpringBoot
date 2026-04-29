package com.rosatel.api.controller;

import com.rosatel.api.model.Ciudad;
import com.rosatel.api.model.Distrito;
import com.rosatel.api.repository.DistritoRepository;
import com.rosatel.api.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private IUbicacionService ubicacionService;

    @GetMapping("/ciudades")
    public List<Ciudad> listarCiudades() {
        return ubicacionService.listarCiudades();
    }

    @GetMapping("/distritos")
    public List<Distrito> listarDistritos(){
        return ubicacionService.listarDistritos();
    }

    @PostMapping("/ciudades")
    public Ciudad guardarCiudad(@RequestBody Ciudad ciudad){
        return ubicacionService.guardarCiudad(ciudad);
    }

    @PostMapping("/distritos")
    public Distrito guardarDistrito(@RequestBody Distrito distrito){
        return ubicacionService.guardarDistrito(distrito);
    }

    @DeleteMapping("/distritos/{id}")
    public void eliminarDistrito(@PathVariable Integer id){
        ubicacionService.eliminarDistrito(id);
    }
}