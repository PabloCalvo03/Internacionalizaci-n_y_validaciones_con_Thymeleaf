package com.example.libros.entidad;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Libro {
		
		private Long id;
		
		@NotBlank(message = "{autor.notblank}")
		@Size(min = 1, max = 100, message = "{autor.size}")
		private String autor;
		
		@NotBlank(message = "{titulo.notblank}")
		@Size(min = 1, max = 100, message = "{titulo.size}")
		private String nombre;
		
		@Positive(message = "{precio.positive}")
		private Double precio;
		
		@NotBlank(message = "{isbn.notblank}")
		@Pattern(regexp = "ISBN(?:-1[03])?:?\\ (?=[-0-9xX ]{13}$|[-0-9X]{17}$|979[-0-9 ]{10}$|978[-0-9 ]{10}$)(?:97[89][- ]?)?[0-9]+[- ]?[0-9]+[-]?[0-9]+[- ]?[0-9X]", message = "{isbn.pattern}")
		private String isbn;
		
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		@NotNull(message = "El año de publicacion no puede estar vacío")
		@Min(value= 0, message= "El año de publicacion no puede ser menor que 0")
		@Max(value= 100, message= "El año de publicacion no puede ser mayor que 100")
		private Integer anyoPublicacion;
		
		@NotNull(message = "La categoría es requerida")
		private Categoria categoria;
			
		public Integer getAnyoPublicacion() {
			return anyoPublicacion;
		}
		public void setAnyoPublicacion(Integer anyoPublicacion) {
			this.anyoPublicacion = anyoPublicacion;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		public Double getPrecio() {
			return precio;
		}
		public void setPrecio(Double precio) {
			this.precio = precio;
		}
		
		
		

	}
