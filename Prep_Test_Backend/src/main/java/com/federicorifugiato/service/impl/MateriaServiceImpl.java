package com.federicorifugiato.service.impl;

import com.federicorifugiato.dto.MateriaDTO;
import com.federicorifugiato.model.Materia;
import com.federicorifugiato.dao.MateriaDao;
import com.federicorifugiato.service.MateriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaDao materiaDao;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public MateriaDTO createMateria(MateriaDTO materiaDTO) {
        Materia materia = modelMapper.map(materiaDTO, Materia.class);
        materia = materiaDao.save(materia);
        return modelMapper.map(materia, MateriaDTO.class);
    }

    @Override
    public MateriaDTO findById(Integer id) {
        Materia materia = materiaDao.findById(id).orElseThrow(() -> new RuntimeException("Materia not found"));
        return modelMapper.map(materia, MateriaDTO.class);
    }

    @Override
    public List<MateriaDTO> findAll() {
        return materiaDao.findAll().stream().map(materia -> modelMapper.map(materia, MateriaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteMateria(Integer id) {
        materiaDao.deleteById(id);
    }
}
