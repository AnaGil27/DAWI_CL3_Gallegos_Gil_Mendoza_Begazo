package pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.model.bd.Usuario;
import pe.edu.cibertec.DAWI_CL3_Gallegos_Gil_Mendoza_Begazo.service.UsuarioService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String login() {
		return "auth/frmLogin";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "auth/frmRegistro";
	}
	
	@GetMapping("/bienvenido")
	public String loginSuccess() {
		return "auth/bienvenido";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("registroCorrecto",true);
		return "auth/frmRegistro";
	}
}
