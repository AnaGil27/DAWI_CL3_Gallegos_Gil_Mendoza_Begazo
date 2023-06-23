package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.Rol;

@Repository
public interface RolRepository 	extends JpaRepository<Rol, Integer>{
	
	Rol findByNomrol(String rolname);
	
}
