package br.org.confetraf.entity.converters;

import br.org.confetraf.entity.pessoa.NomePessoa;
import jakarta.persistence.AttributeConverter;


public class NomePessoaConverter implements AttributeConverter<NomePessoa, String> {

    @Override
    public String convertToDatabaseColumn(NomePessoa nomePessoa) {
        return nomePessoa != null ? nomePessoa.getNome() : null;
    }

    @Override
    public NomePessoa convertToEntityAttribute(String dbData) {
        NomePessoa nome = new NomePessoa();
        nome.setNome(dbData);
        return nome;
    }
}
