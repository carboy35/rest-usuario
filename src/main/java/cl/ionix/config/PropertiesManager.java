package cl.ionix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
@Component
@Getter
public class PropertiesManager {
	@Value("${servicioRut}")
	private String servicioRut;
	
	@Value("${clave}")
	private String clave;
	
}
