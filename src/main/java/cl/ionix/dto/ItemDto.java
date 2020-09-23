package cl.ionix.dto;

import cl.ionix.model.ResultUser;
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
public class ItemDto {
	String name;
	DetailDto detail;
}
