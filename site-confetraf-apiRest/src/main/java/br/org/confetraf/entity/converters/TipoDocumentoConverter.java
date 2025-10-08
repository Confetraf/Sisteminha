package br.org.confetraf.entity.converters;

import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

import br.org.confetraf.entity.enums.TipoDocumento;

public class TipoDocumentoConverter implements AttributeConverter<TipoDocumento, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoDocumento attribute) {
		if (attribute == null) return null;
		return attribute.getCodigo();
	}

	@Override
	public TipoDocumento convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
            return null;
        }

        return Stream.of(TipoDocumento.values())
          .filter(c -> c.getCodigo().equals(dbData))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
