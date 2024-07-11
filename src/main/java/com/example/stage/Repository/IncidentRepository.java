package com.example.stage.Repository;

import com.example.stage.entites.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IncidentRepository extends JpaRepository<Incident,Integer> {
    List<Incident> findByStatus(String status);

}
