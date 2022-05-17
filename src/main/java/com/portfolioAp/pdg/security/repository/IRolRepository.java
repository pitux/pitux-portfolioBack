package com.portfolioAp.pdg.security.repository;

import com.portfolioAp.pdg.security.entity.Rol;
import com.portfolioAp.pdg.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
