package com.miempresa.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoTest {
	private Producto producto;
	@BeforeEach
	void setUp() throws Exception {
		producto=new Producto("Teclado",30.0);
	}
	
	@Test
	@DisplayName("Prueba excepcion precio constructor")
	void excepcionPrecioNegativo() throws Exception {
		Exception excepcion=assertThrows(IllegalArgumentException.class, ()->new Producto ("Monitor", -12.5));
		String mensajeEsperado="El precio no puede ser negativo: "+ -12.5;
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	@Test
	@DisplayName("Test de getNombre")
	void pruebaGetNombre() {
		String nombreEsperado="Teclado";
		String nombreResultado=producto.getNombre();
		assertEquals(nombreEsperado, nombreResultado);
	}
	@Test
	@DisplayName("Test de getPrecio")
	void pruebaGetPrecio() {
		double precioEsperado=30.0;
		double precioResultado=producto.getPrecio();
		assertEquals(precioEsperado, precioResultado);
	}
	@Test
	@DisplayName("Test de setNombre")
	void pruebaSetNombre() {
		String nombreEsperado="Raton";
		producto.setNombre(nombreEsperado);
		String nombre= producto.getNombre();
		assertEquals(nombreEsperado,nombre);
	}
	@Test
	@DisplayName("Test de setPrecio")
	void pruebaSetPrecio() {
		double precioEsperado=45.75;
		producto.setPrecio(precioEsperado);
		double precio=producto.getPrecio();		
		assertEquals(precioEsperado, precio);
	}
	
	@Test
	@DisplayName("Test excepcion setPrecio")
	void pruebaExcepcionSetPrecio() {
		Exception excepcion=assertThrows(IllegalArgumentException.class,()->producto.setPrecio(-34.2));	
		String mensajeEsperado="El precio no puede ser negativo: " + -34.2;
		assertEquals(mensajeEsperado, excepcion.getMessage());
	}
	
	

}
