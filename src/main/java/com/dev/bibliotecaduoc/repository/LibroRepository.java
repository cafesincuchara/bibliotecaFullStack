package com.dev.bibliotecaduoc.repository;

import com.dev.bibliotecaduoc.entity.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List<Libro> listarLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){
        return  listarLibros;
    }

    public Libro buscarPorId(int id){
        for(Libro libro : listarLibros){
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for(Libro libro : listarLibros){
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public  Libro guardar(Libro lib){
        listarLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro libro){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listarLibros.size();  i++){
            if(listarLibros.get(i).getId() == libro.getId()){
                id = libro.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();

        libro1.setId(id);
        libro1.setTitulo(libro.getTitulo());
        libro1.setAutor(libro.getAutor());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setEditorial(libro.getEditorial());
        libro1.setIsbn(libro.getIsbn());

        listarLibros.set(idPosicion, libro1);
        return libro1;

    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if(libro != null){
            listarLibros.remove(libro);
        }
    }






}
