package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Sala con sus métodos
 * @author alex
 *
 */
public class SalaTest {

	private Sala s;
	private Sala prueba;
	private Sala empty;

	@Before
	public void setUp() {

		s=  new Sala(10);
		prueba=  new Sala(s);
		empty= new Sala();

	}
	
	
	@Test
	public void testGetNumSala() {
		assertEquals(10, s.getNumSala());
		assertEquals(10, prueba.getNumSala());
		assertEquals(0, empty.getNumSala());
	}
	
	@Test
	public void testSetNumSala() {
		s.setNumSala(2);
		assertEquals(2, s.getNumSala());
	}

}
