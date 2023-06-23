package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	Usuario findByNomusuario(String username);
}
