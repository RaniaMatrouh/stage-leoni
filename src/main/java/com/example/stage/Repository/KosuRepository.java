package com.example.stage.Repository;

import com.example.stage.entites.Kosu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KosuRepository extends JpaRepository<Kosu,Integer> {
}
