package br.org.confetraf.entity.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.confetraf.entity.ibge.Mesoregiao;
import br.org.confetraf.entity.pessoa.PessoaFisica;

@Entity
@Table(name = "tb_usu_usr")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@PrimaryKeyJoinColumn(name = "pes_id",
foreignKey = @ForeignKey(name = "fk_usr_fis") 
)
public class Usuario extends PessoaFisica implements UserDetails, Serializable  {
	
	private static final long serialVersionUID = -6179966186646395309L;
	
	@EqualsAndHashCode.Include
	@Column(name = "usr_usn", nullable = false, columnDefinition = "VARCHAR(11)")
	private String username;
	
	@Column(name = "usr_pwd", nullable = false, columnDefinition = "VARCHAR(20)")
	private String password;
	
	@Column(name = "usr_rol", nullable = false, columnDefinition = "VARCHAR(20)")
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