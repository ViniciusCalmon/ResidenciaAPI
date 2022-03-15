package org.serratec.backend.ecommerce.configuration;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.domain.Endereco;
import org.serratec.backend.ecommerce.util.EnderecoViaCep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(EnderecoViaCep.class, Endereco.class)
				.<String>addMapping(src -> src.getLogradouro(), (dest, value) -> dest.setRua(value))
				.<String>addMapping(src -> src.getLocalidade(), (dest, value) -> dest.setCidade(value))
				.<String>addMapping(src -> src.getUf(), (dest, value) -> dest.setEstado(value));

		return modelMapper;
	}

}
