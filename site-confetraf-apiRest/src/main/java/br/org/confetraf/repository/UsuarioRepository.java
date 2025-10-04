package br.org.confetraf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.confetraf.entity.usuario.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
