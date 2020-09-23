package cl.ionix.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import cl.ionix.model.Response;

public interface TestTecnicoService {
	public ResponseEntity<Response> consultaPublica(String param);
}
