package eu.ase.ro.proiect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ase.ro.proiect.model.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
}
