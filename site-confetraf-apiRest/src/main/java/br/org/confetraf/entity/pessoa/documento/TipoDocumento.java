package br.org.confetraf.entity.pessoa.documento;

public enum TipoDocumento {
	
	CPF (1, "CPF", true, new CPF()),
	RG  (2, "RG", false, new RG()),
	NIS (3, "NIS", true, new NIS());
	
	private final Integer codigo;
    private final String tipo;
    private final boolean unico;
    private final IDocumentoStrategy strategy;


	
	private TipoDocumento(Integer codigo, String tipo, boolean unico, IDocumentoStrategy strategy) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.unico = unico;
		this.strategy =  strategy;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean isUnico() {
		return unico;
	}
	
	public String validar(String numero) {
        return strategy.validar(numero);
    }

    public String numeroComMascara(String numero) {
        return strategy.numeroComMascara(numero);
    }

}
