package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Administrador
 * @author alex
 *
 */
public class AdminTest {

	private Administrador a;
	private Administrador prueba;
	private Administrador empty;
	private Administrador admin;


	@Before
	public void setUp() {

		a=  new Administrador("alex","1234",false);
		prueba=  new Administrador(a);
		empty= new Administrador();
		admin= new Administrador ("admin","admin",true);
	}	


	@Test
	public void testEsAdmin() {
		if (a.esAdmin()) {
			fail("A no es un administrador");
		} else {
			assertEquals(false, a.esAdmin());
		}

		if (prueba.esAdmin()) {
			fail("Prueba no es administrador, es una copia de A. Revisa el constructor copia");
		} else {
			assertEquals(false, prueba.esAdmin());
		}

		if (empty.esAdmin()) {
			fail("El trabajador vacío no es administrador. Revisa el constructor vacío");
		} else {
			assertEquals(false, empty.esAdmin());
		}

		if (admin.esAdmin()) {
			assertEquals(true, admin.esAdmin());
		} else {
			fail("El admin si que es administrador. Revisa los constructores");
		}


	}


	@Test
	public void testSetesAdmin() {
		a.setEsAdmin(true);
		if (!a.esAdmin()) {
			fail("El set.esAdmin de la clase Administrador no funciona correctamente");
		}
	}
}

