package com.federicorifugiato.dao;

import com.federicorifugiato.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaDao extends JpaRepository<Materia, Integer> {
}
