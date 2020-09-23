package cl.ionix.service.impl;

import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.ionix.config.PropertiesManager;
import cl.ionix.config.UrlManager;
import cl.ionix.dto.ItemsDto;
import cl.ionix.model.Response;
import cl.ionix.model.ResponseService;
import cl.ionix.model.ResultUser;
import cl.ionix.repository.UsuarioRepository;
import cl.ionix.service.TestTecnicoService;
import cl.ionix.util.Util;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("TestTecnicoService")
public class TestTecnicoServiceImpl implements TestTecnicoService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	RestTemplate restTemplate= new RestTemplate();
	
	@Autowired
	UrlManager urlManager;
	
	@Autowired
	PropertiesManager propertiesManager;
	
	public ResponseEntity<Response> consultaPublica(String param) {
		ResultUser resultUser=null;
		Map<String,Long> mapaTiempo= new HashMap<>();
		Util.measureTime(mapaTiempo);
		try {
			DESKeySpec keySpec = new DESKeySpec(this.propertiesManager.getClave().getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey ks = keyFactory.generateSecret(keySpec);
			byte[] cleartext = param.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, ks); //incializa cifrador
			String encryptedRut = Base64.getEncoder().encodeToString(cipher.doFinal(cleartext));
			resultUser=this.obtieneResult(encryptedRut);
		}catch(Exception e) {
			Util.measureTime(mapaTiempo);
			log.error("Ocurrió un error",e);
			return ResponseEntity.ok(new Response(1,"NO OK",mapaTiempo.get("executeTime"),null));
		}
		Util.measureTime(mapaTiempo);
		return ResponseEntity.ok(new Response(0,"OK",mapaTiempo.get("executeTime"),resultUser));
	}
	
	private ResultUser obtieneResult(String param){
		ResultUser resultUser=null;
		Map<String, String> data = new LinkedHashMap<String, String>();
		ItemsDto itemsDto=null;
		StringBuilder urlConsultaPublica = new StringBuilder(this.propertiesManager.getServicioRut());
		data.put("param", String.valueOf(param));
		
		String url = this.urlManager.parseUrlApiPathParams(
				urlConsultaPublica.toString(),
				data);
		
		ResponseEntity<ResponseService<ItemsDto>> response=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseService<ItemsDto>>() {});
		if (response.getBody()!=null) {
			if (response.getBody().getResponseCode().equals(0) && response.getBody().getDescription().equals("OK")) {
				itemsDto=(ItemsDto)response.getBody().getResult();
				resultUser=new ResultUser();
				resultUser.setRegisterCount(itemsDto.getItems().size());
			}
		}
		return resultUser;
	}
	


}
