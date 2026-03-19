package com.dev.bibliotecaduoc.repository;

import com.dev.bibliotecaduoc.entity.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List<Libro> listarLibros = new ArrayList<>();


    public LibroRepository(){
        listarLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House", 2018, "George R. R. Martin"));
        listarLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listarLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listarLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listarLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listarLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listarLibros.add(new Libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
        listarLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listarLibros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listarLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }


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

    public int listarLibros(){
        return listarLibros.size();
    }

    public int totalLibros(){
        return listarLibros.size();
    }






}
