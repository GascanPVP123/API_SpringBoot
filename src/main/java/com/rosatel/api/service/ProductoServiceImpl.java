package com.rosatel.api.service;

import com.rosatel.api.model.Producto;
import com.rosatel.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private ProductoRepository productoRepo;

    @Override
    public List<Producto> listarTodos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto guardar (Producto producto){
        return productoRepo.save(producto);
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id){
        productoRepo.deleteById(id);
    }

    @Override
    public Producto actualizar(Integer id, Producto detalles) {
        return productoRepo.findById(id)
                .map(p -> {
                    p.setNombre(detalles.getNombre());
                    p.setPrecio(detalles.getPrecio());
                    p.setStock(detalles.getStock());
                    p.setDescripcion(detalles.getDescripcion());
                    p.setCategoriaId(detalles.getCategoriaId());
                    return productoRepo.save(p);
                }).orElse(null);
    }
}
