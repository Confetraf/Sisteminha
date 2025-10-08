package br.org.confetraf.entity.documento;


import br.org.confetraf.entity.Auditable;
import br.org.confetraf.entity.converters.TipoDocumentoConverter;
import br.org.confetraf.entity.enums.TipoDocumento;
import br.org.confetraf.entity.pessoa.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_doc_dcm")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
public abstract class Documento extends Auditable implements IDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dcm_seq")
	@SequenceGenerator(name = "dcm_seq", sequenceName = "dcm_seq", allocationSize = 50)
	private Long dcm_id;

	@Column(name = "dcm_num", nullable = false, length = 50)
	@EqualsAndHashCode.Include
	protected String numero;
	
	@Column(name = "dcm_emis", nullable = false, length = 50)
	protected String emissor;

	@Convert(converter = TipoDocumentoConverter.class)
	@Column(name = "dcm_tipo_sts", nullable = false, columnDefinition = "INT")
	@EqualsAndHashCode.Include
	protected TipoDocumento tipo;
	
	@ManyToOne
	@JoinColumn(
		    name = "pes_id",
		    nullable = false,
		    foreignKey = @ForeignKey(name = "fk_pes_dcm") 
		)
	private Pessoa pessoa;


	@Override
	public final String getSomenteNumeros() {
		return this.numero;
	}
	
	
	public void setNumeroDocumento(String numero) throws IllegalArgumentException {
		this.numero = tipo.validar(numero);
	}

	@Override
	public final String getComMascara() {
		return tipo.numeroComMascara(numero);
	}

}
