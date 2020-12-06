package com.matyspring.market.persistence.crud;

import com.matyspring.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


  //Forma Nativa  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //Query method //
     List<Producto> findByIdCategoriaOrderByNombreAsc
              (int idCategoria);


     Optional<List<Producto>> findByCantidadStockLessThanAndEstado
             (int cantidadStock, boolean estado);


     Optional<List<Producto>> findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc
             (int precioVenta, int idCategoria);
}
