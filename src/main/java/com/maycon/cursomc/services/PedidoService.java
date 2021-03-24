package com.maycon.cursomc.services;

import com.maycon.cursomc.domain.Pedido;
import com.maycon.cursomc.repositories.PedidoRepository;
import com.maycon.cursomc.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository PedidoRepository;

    public Pedido buscar(Integer id) {
        Optional<Pedido> optional = PedidoRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }
}
