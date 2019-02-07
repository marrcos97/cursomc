package com.marcosgomes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marcosgomes.cursomc.domain.Categoria;
import com.marcosgomes.cursomc.exceptions.DataIntegrityException;
import com.marcosgomes.cursomc.exceptions.ObjectNotFoundException;
import com.marcosgomes.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        final Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);

        } catch (final DataIntegrityViolationException e) {
            //TODO
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

}
