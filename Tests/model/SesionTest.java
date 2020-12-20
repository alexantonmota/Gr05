package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SesionTest {

	private Sesion s;
	private Sesion prueba;
	private Sesion empty;

	@Before
	public void setUp() {

		s=  new Sesion(22.00);
		prueba=  new Sesion(s);
		empty= new Sesion();

	}	
	@Test
	@Deprecated
	public void testGetHora() {
		assertEquals(22.00, s.getHora(),20.00);
		assertEquals(20.00, prueba.getHora(),20.00);
		assertEquals(18.00, empty.getHora(),20.00);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testSetHora() {
		s.setHora(18.00);
		assertEquals(18.00, s.getHora(),20.00);
		
	}
}
