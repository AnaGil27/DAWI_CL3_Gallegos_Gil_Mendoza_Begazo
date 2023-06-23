package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.Usuario;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.repository.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
	}
	public void registrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void eliminarUsuario(Integer idusuario) {
		usuarioRepository.deleteById(idusuario);
	}
}
