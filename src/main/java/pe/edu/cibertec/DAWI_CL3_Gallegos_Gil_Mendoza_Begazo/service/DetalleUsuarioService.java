package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.bd.Rol;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.bd.Usuario;

public class DetalleUsuarioService implements UserDetailsService {
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nomUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.buscarPorNombreUsuario(nomUsuario);
		return usuarioPorAutenticacion(usuario, obtenerAutorizacionUsuario(usuario.getRoles()));
	}

	private List<GrantedAuthority> obtenerAutorizacionUsuario(Set<Rol> listRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Rol rol : listRoles) {
			roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;

	}

	private UserDetails usuarioPorAutenticacion(Usuario usuario, List<GrantedAuthority> authorityList) {
		return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(), true, true, true,
				authorityList);
	}

}
