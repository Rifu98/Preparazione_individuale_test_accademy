package com.federicorifugiato.service;

import java.util.List;

import com.federicorifugiato.dto.MateriaDTO;

public interface MateriaService {
    MateriaDTO createMateria(MateriaDTO materiaDTO);
    MateriaDTO findById(Integer id);
    List<MateriaDTO> findAll();
    void deleteMateria(Integer id);
}
