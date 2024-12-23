package com.alura.foro.AluraForo.Repository;

import com.alura.foro.AluraForo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String username);

    boolean existsByEmail(String email);
}
