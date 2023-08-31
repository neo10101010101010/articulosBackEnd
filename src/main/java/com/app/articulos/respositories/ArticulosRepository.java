package com.app.articulos.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.articulos.models.Articulos;

public interface ArticulosRepository extends JpaRepository<Articulos, Long>{

}
