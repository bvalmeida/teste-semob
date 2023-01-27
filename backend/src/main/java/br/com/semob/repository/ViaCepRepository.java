package br.com.semob.repository;

import br.com.semob.model.ViaCepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViaCepRepository extends JpaRepository<ViaCepEntity, Long> {

}
