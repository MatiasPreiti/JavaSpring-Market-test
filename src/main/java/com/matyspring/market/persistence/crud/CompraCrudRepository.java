package com.matyspring.market.persistence.crud;


import com.matyspring.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

        Optional<List<Compra>> findByIdCliente(String idCliente);
}
