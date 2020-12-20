package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SalaTest {

	private Sala s;
	private Sala prueba;
	private Sala empty;

	@Before
	public void setUp() {

		s=  new Sala("Sala 1",10);
		prueba=  new Sala(s);
		empty= new Sala();

	}
	@Test
	public void testGetNombre() {
		assertEquals("Sala 1", s.getNombre());
		assertEquals("Sala 1", prueba.getNombre());
		assertEquals("", empty.getNombre());
	}@Test
	public void testSetNombre() {
		s.setNombre("Sala 2");
		assertEquals("Sala 2", s.getNombre());
	}	

	@Test
	public void testGetNumAsientos() {
		assertEquals(10, s.getNumAsientos());
		assertEquals(10, prueba.getNumAsientos());
		assertEquals(0, empty.getNumAsientos());
	}@Test
	public void testSetNumAsientos() {
		s.setNumAsientos(2);
		assertEquals(2, s.getNumAsientos());
	}

}
