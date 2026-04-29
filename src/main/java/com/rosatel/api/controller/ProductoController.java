package com.rosatel.api.controller;
import com.rosatel.api.model.Producto;
import com.rosatel.api.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> listarTodos(){
        return productoService.listarTodos();
    }

    @PostMapping
    public  Producto crear(@RequestBody Producto producto){
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto detalles){
        return productoService.actualizar(id, detalles);
    }
}
