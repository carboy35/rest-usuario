package cl.ionix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Usuarios {
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String phone;
}
