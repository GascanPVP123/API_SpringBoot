package com.rosatel.api.service;

import com.rosatel.api.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listarTodos();
    Producto guardar(Producto producto);

    Producto obtenerPorId(Integer id);

    void eliminar(Integer id);

    public Producto actualizar(Integer id, Producto detalles);
}
