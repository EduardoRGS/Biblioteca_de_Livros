package TestesUnitarios;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;


class TesteControleDados {
	ControleDados d = new ControleDados();
	
	@Test
	void testRemoveLivro() {
		assertFalse(d.removeLivro(0));
		assertTrue(d.removeLivro(4));
		assertTrue(d.removeLivro(3));
		assertTrue(d.removeLivro(2));
		assertTrue(d.removeLivro(1));
	}
	 
	@Test
	void testPesquisa() {
		assertEquals(1, d.pesquisa("Livro1"));
		assertEquals(2, d.pesquisa("Livro2"));
		assertEquals(3, d.pesquisa("Livro3"));
		assertEquals(4 ,d.pesquisa("Livro4"));
		assertEquals(-1, d.pesquisa("Livro5"));
	}
	
	@Test
	void testPesquisaUsuario() {
		assertEquals(1, d.pesquisaUsuario("Usuario1"));
		assertEquals(2, d.pesquisaUsuario("Usuario2"));
		assertEquals(3, d.pesquisaUsuario("Usuario3"));
		assertEquals(4, d.pesquisaUsuario("Usuario4"));
		assertNotSame(5, d.pesquisaUsuario("Usuario5"));
	}
	

}
