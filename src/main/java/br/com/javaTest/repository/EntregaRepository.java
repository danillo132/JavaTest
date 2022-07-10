package br.com.javaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javaTest.model.EntregaEntity;

/**
 * Interface de repositório da classe EntregaEntity que extende da interface JpaRepository
 * responsável pela camada de persistência 
 * @author Danillo Santiago
 * @since jul 2022
 */
@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, Long> {

}
