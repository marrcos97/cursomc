package com.marcosgomes.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcosgomes.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {

        final Categoria cat1 = new Categoria(1, "Informatica");
        final Categoria cat2 = new Categoria(2, "Escritório");

        final List<Categoria> lista = new ArrayList<>();

        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }

}
