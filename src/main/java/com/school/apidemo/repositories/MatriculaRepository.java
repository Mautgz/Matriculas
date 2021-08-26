package com.school.apidemo.repositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.school.apidemo.models.Matricula;
import org.springframework.data.jpa.repository.*;
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    @Query(value = "SELECT o FROM Matricula o WHERE o.id=?1")
    Optional<Matricula> findById(Integer id);
    
}

