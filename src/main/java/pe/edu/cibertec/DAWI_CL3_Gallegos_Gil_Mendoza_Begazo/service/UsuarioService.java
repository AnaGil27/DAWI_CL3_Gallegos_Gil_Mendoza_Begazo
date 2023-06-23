package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.bd.Usuario;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.repository.UsuarioRepository;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.bd.Rol;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.repository.RolRepository;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	private BCryptPasswordEncoder bCryptPass = new BCryptPasswordEncoder();
	
	public Usuario buscarPorNombreUsuario(String nomUsuario) {
		return usuarioRepository.findByNomusuario(nomUsuario);
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPass.encode(usuario.getPassword()));
		usuario.setActivo(true);
		
		Rol rol = rolRepository.findByNomrol("ADMIN");
		usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
		
		return usuarioRepository.save(usuario);
	}
}
