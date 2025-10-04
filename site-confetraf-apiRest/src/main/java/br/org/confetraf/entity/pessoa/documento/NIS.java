package br.org.confetraf.entity.pessoa.documento;

import static br.org.confetraf.entity.pessoa.documento.DocumentoUtils.limparNumero;

public class NIS implements IDocumentoStrategy {

	 private boolean validarDigitoVerificador(String nis) {
	        try {
	            int[] pesos = {3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	            int soma = 0;

	            for (int i = 0; i < 10; i++) {
	                soma += Character.getNumericValue(nis.charAt(i)) * pesos[i];
	            }

	            int resto = soma % 11;
	            int digito = resto == 0 || resto == 1 ? 0 : 11 - resto;

	            return digito == Character.getNumericValue(nis.charAt(10));
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public String validar(String numero) throws IllegalArgumentException {
	        String apenasNumeros = limparNumero(numero);
	        validarBrancos(apenasNumeros);

	        if (apenasNumeros.length() != 11)
	            throw new IllegalArgumentException("O NIS precisa ter 11 caracteres!");

	        if (apenasNumeros.matches("(\\d)\\1{10}"))
	            throw new IllegalArgumentException("Os números do NIS não podem ser todos iguais!");

	        if (!validarDigitoVerificador(apenasNumeros))
	            throw new IllegalArgumentException("Dígito verificador do NIS inválido!");

	        return apenasNumeros;
	    }

	    @Override
	    public String numeroComMascara(String numero) {
	        return numero.replaceFirst("(\\d{3})(\\d{5})(\\d{2})(\\d)", "$1.$2.$3-$4");
	    }


}
