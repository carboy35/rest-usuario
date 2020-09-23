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
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResponseService<T>  implements Serializable {
	private static final long serialVersionUID = 1L;
	@NonNull private Integer responseCode;
	@NonNull private String description;
	private T result;
}
