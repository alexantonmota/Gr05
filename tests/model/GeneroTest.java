package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test Genero (NO FUNCIONA TODAVIA)
 * @author alex
 *
 */
public class GeneroTest {

	

	
	@Test
    public void testGetGenero() {
        
		String genero= "ACCION";
		System.out.println("El género es"+genero);
        assertEquals(Genero.getGenero("ACCION"), "ACCION");
	}
      

}
