package com.maycon.cursomc.services;

import com.maycon.cursomc.domain.Cliente;
import com.maycon.cursomc.repositories.ClienteRepository;
import com.maycon.cursomc.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository ClienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> optional = ClienteRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }
}
