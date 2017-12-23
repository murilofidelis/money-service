package br.com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.money.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
