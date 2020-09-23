package cl.ionix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.ionix.controller.CrudUsuario;
import cl.ionix.controller.TestTecnico;
import cl.ionix.entities.Usuario;
import cl.ionix.model.Response;
import cl.ionix.model.Usuarios;

@SpringBootTest
class RestUsuarioApplicationTests {
	@Autowired
	CrudUsuario crudUsuario;
	
	@Autowired
	TestTecnico testTecnico;

	@Test
	void testGetAll() {
		ResponseEntity<Response> response=	crudUsuario.getAll();
		assertEquals(response.getBody().getResponseCode(),0);
	}
	
	@Test
	void testPost() {
		Usuarios usuario=null;
		usuario = new Usuarios();
		usuario.setName("prueba");
		usuario.setPhone("3333");
		usuario.setUsername("pruebausername");
		usuario.setEmail("email");
		
		ResponseEntity<Response> response=	crudUsuario.save(usuario);
		assertEquals(response.getBody().getResponseCode(),0);
	}
	
	@Test
	void testByEmail() {
		ResponseEntity<Response> response=	crudUsuario.getByEmail("hmolinet1@hotmail.com");
		assertEquals(response.getBody().getResponseCode(),0);
	}
	@Test
	void consultaPublica() {
		ResponseEntity<Response> response=	testTecnico.consultaPublica("1-9");
		assertEquals(response.getBody().getResponseCode(),0);
	}
}
