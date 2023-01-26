package br.com.semob.repository;

import br.com.semob.model.ViaCepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaCepRepository extends JpaRepository<ViaCepEntity, Long> {
}
