package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
	private Boolean respuesta;
	private String mensaje;
}
