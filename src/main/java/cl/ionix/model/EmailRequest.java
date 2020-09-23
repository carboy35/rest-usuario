package cl.ionix.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class EmailRequest implements Serializable {
	private static final long serialVersionUID = 7283292398571857254L;
 private String email;
}
