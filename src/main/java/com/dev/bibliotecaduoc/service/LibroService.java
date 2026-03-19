package com.dev.bibliotecaduoc.service;


import com.dev.bibliotecaduoc.entity.Libro;
import com.dev.bibliotecaduoc.repository.LibroRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibroPorId(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibor(int id){
        if(libroRepository.buscarPorId(id) != null){
            libroRepository.eliminar(id);
            return "Libro eliminado con id: " + id;
        }
        return "ERROR";
    }

    public int totalLibros(){
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }
}
