package br.org.confetraf.entity.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.confetraf.entity.pessoa.Pessoa;
import br.org.confetraf.entity.pessoa.PessoaFisica;

@Entity
@Table(name = "tb_usuario")
@PrimaryKeyJoinColumn(name = "pes_id")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends PessoaFisica implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	private String role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}