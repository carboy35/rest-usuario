package cl.ionix.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.model.Response;
import cl.ionix.service.TestTecnicoService;

@RestController
@RequestMapping("/testTecnico")
public class TestTecnico {
	@Autowired
	TestTecnicoService testTecnicoService;
	
	@PostMapping("/rut/param/{param}")
	public ResponseEntity<Response> consultaPublica(@PathVariable String param) {
		return testTecnicoService.consultaPublica(param);
	}
}
