package com.maycon.cursomc.services;

import com.maycon.cursomc.domain.Categoria;
import com.maycon.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        return optional.orElse(null);
    }
}
