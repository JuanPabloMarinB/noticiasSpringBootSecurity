
package com.circuitosinteligentes.primer_proyecto_spring.Repositorio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioImagen extends JpaRepository<Imagen, Integer> {
    
}
