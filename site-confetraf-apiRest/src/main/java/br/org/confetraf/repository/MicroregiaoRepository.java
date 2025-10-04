package br.org.confetraf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.confetraf.entity.ibge.Microregiao;

@Repository
public interface MicroregiaoRepository extends JpaRepository<Microregiao, Long> {

}
