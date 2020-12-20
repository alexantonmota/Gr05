package model;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
/**
 * Test Cliente con sus métodos
 * @author alex
 *
 */
public class ClienteTest {

	private Cliente c;
	private Cliente prueba;
	private Cliente empty;

	@Before
	public void setUp() {

		c=  new Cliente(1,"alex","1234","alex@gmail.com","Alex","Anton","Mota","27/09/1999");
		prueba=  new Cliente(c);
		empty= new Cliente();

	}	

	@Test
	public void testGetId() {
		assertEquals(1, c.getId());
		assertEquals(1, prueba.getId());
		assertEquals(0, empty.getId());
	}@Test
	public void testSetId() {
		c.setId(2);
		assertEquals(2, c.getId());

	}

	@Test
	public void testGetUsername() {
		assertEquals("alex", c.getUsername());
		assertEquals("alex", prueba.getUsername());
		assertEquals("", empty.getUsername());
	}

	@Test
	public void testSetUsername() {
		c.setUsername("unai");
		assertEquals("unai", c.getUsername());
	}
	@Test
	public void testGetPassword() {
		assertEquals("1234", c.getPassword());
		assertEquals("1234", prueba.getPassword());
		assertEquals("", empty.getPassword());
	}

	@Test
	public void testSetPassword() {
		c.setPassword("pruebacontra");
		assertEquals("pruebacontra", c.getPassword());
	}
	@Test
	public void testGetEmail() {
		assertEquals("alex@gmail.com", c.getEmail());
		assertEquals("alex@gmail.com", prueba.getEmail());
		assertEquals("", empty.getEmail());
	}

	@Test
	public void testSetEmail() {
		c.setEmail("unai@gmail.com");
		assertEquals("unai@gmail.com", c.getEmail());
	}
	@Test
	public void testGetNombre() {
		assertEquals("Alex", c.getNombre());
		assertEquals("Alex", prueba.getNombre());
		assertEquals("", empty.getNombre());
	}

	@Test
	public void testSetNombre() {
		c.setNombre("Unai");
		assertEquals("Unai", c.getNombre());
	}
	@Test
	public void testGetApellido1() {
		assertEquals("Anton", c.getApellido_1());
		assertEquals("Anton", prueba.getApellido_1());
		assertEquals("", empty.getApellido_1());
	}

	@Test
	public void testSetApellido_1() {
		c.setApellido_1("Villalba");
		assertEquals("Villalba", c.getApellido_1());
	}
	@Test
	public void testGetApellido_2() {
		assertEquals("Mota", c.getApellido_2());
		assertEquals("Mota", prueba.getApellido_2());
		assertEquals("", empty.getApellido_2());
	}

	@Test
	public void testSetApellido_2() {
		c.setApellido_2("Salvador");
		assertEquals("Salvador", c.getApellido_2());
	}
	@Test
	public void testGetFecha_nac() {
		assertEquals("27/09/1999", c.getFecha_nac());
		assertEquals("27/09/1999", prueba.getFecha_nac());
		assertEquals("", empty.getFecha_nac());
	}

	@Test
	public void testSetApellidos() {
		c.setFecha_nac("19/04/1999");
		assertEquals("19/04/1999", c.getFecha_nac());
	}


}

