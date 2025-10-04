package br.org.confetraf.entity.pessoa.documento;


import br.org.confetraf.entity.enums.converters.TipoDocumentoConverter;
import br.org.confetraf.entity.pessoa.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_documento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Documento implements IDocumento {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq")
	@SequenceGenerator(name = "doc_seq", sequenceName = "doc_seq", allocationSize = 50)
	private Long doc_id;

	@Column(name = "doc_numero", nullable = false, length = 50)
	protected String numero;
	
	@Column(name = "doc_emissor", nullable = false, length = 50)
	protected String emissor;

	@Convert(converter = TipoDocumentoConverter.class)
	@Column(name = "doc_tipo", nullable = false, columnDefinition = "INT")
	protected TipoDocumento tipo;
	
	@ManyToOne
    @JoinColumn(name = "pes_id", nullable = false)
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
