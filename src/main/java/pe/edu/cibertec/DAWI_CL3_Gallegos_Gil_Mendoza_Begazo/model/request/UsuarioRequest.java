package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
	private Integer idusuario;
	private String nomusuario;
	private String email;
	private String password;
	private String nombres;
	private String apellidos;
}
