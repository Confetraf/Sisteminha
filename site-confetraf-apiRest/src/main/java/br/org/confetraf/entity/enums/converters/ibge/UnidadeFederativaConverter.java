package br.org.confetraf.entity.enums.converters.ibge;

import br.org.confetraf.entity.enums.ibge.UnidadeFederativa;
import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

public class UnidadeFederativaConverter implements AttributeConverter<UnidadeFederativa, Integer> {

	@Override
	public Integer convertToDatabaseColumn(UnidadeFederativa attribute) {
		if (attribute == null) return null;
		return attribute.getCodigoIBGE();
	}

	@Override
	public UnidadeFederativa convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
            return null;
        }

        return Stream.of(UnidadeFederativa.values())
          .filter(c -> c.getCodigoIBGE().equals(dbData))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

	

}
