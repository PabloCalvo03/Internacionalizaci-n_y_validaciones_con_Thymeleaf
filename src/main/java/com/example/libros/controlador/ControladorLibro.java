package com.example.libros.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.libros.entidad.Categoria;
import com.example.libros.entidad.Libro;
import com.example.libros.servicio.ServicioCategorias;
import com.example.libros.servicio.ServicioLibros;

import jakarta.validation.Valid;

@Controller
public class ControladorLibro {
	
	@Autowired
	ServicioLibros serviciolibros;
	
	@Autowired
	ServicioCategorias servicioCategorias;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("mensaje", " DWES :: RA3");
		return "index";
	}
	
	@GetMapping("/libros")
	public String listarLibros(Model model) {
		List<Libro> libros = serviciolibros.obtenerLibros();
		model.addAttribute("libros", libros);
		model.addAttribute("categorias", Categoria.values());
		return "libros";
	}
	
	
	@GetMapping("/filtrar")
	public String filtrarLibros(@RequestParam String categoria, Model model) {
		List<Libro> libros = serviciolibros.obtenerLibros(categoria);
		model.addAttribute("libros", libros);
		model.addAttribute("categorias", Categoria.values());
		return "libros";
	}
	
	@GetMapping("/formulario")
	public String form_libro(Model model) {
		model.addAttribute("categorias", Categoria.values());
		model.addAttribute("libro", new Libro());
		return "form_libro";
	}
	
		@PostMapping("/nuevo_libro")
		public String agregarLibro(@Valid @ModelAttribute("libro") Libro libro, BindingResult result, Model model) {
    	
    	
        // Si hay errores, volver al formulario
		if (result.hasErrors()) {
			model.addAttribute("categorias", servicioCategorias.obtenerCategorias());
			return "form_libro";
		}

   
        serviciolibros.guardarLibro(libro);
        return "redirect:/libros"; // redirigir a la página principal
    }

}
