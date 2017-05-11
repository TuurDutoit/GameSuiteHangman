package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ui.TekeningHangMan;
import ui.UiException;

public class TekeningHangManTest {
	TekeningHangMan tekening;
	
	@Before
	public void setUp() {
		tekening = new TekeningHangMan();
	}
	
	@Test
	public void test_constructor_maakt_een_tekening_met_18_vormen() {
		assertEquals(18, tekening.getAantalVormen());
	}
	
	@Test
	public void test_constructor_maakt_een_tekening_met_14_onzichtbare_vormen() {
		assertEquals(14, tekening.getAantalOnzichtbaar());
	}
	
	@Test
	public void test_zetVolgendeZichtbaar_zet_eerstvolgende_vorm_zichtbaar() {
		assertFalse(tekening.getVorm(4).isZichtbaar());
		tekening.zetVolgendeZichtbaar();
		assertTrue(tekening.getVorm(4).isZichtbaar());
	}
	
	@Test(expected = UiException.class)
	public void test_zet_volgendeZichtbaar_gooit_exception_als_alle_vormen_zichtbaar() {
		for(int i = 4; i < 18; i++) {
			tekening.zetVolgendeZichtbaar();
		}
		
		tekening.zetVolgendeZichtbaar();
	}
	
	@Test
	public void test_reset_zet_alle_vormen_behalve_de_galg_onzichtbaar() {
		// Maak alle vormen onzichtbaar
		for(int i = 4; i < 18; i++) {
			tekening.zetVolgendeZichtbaar();
		}
		tekening.reset();
		for(int i = 0; i < 4; i++) {
			assertTrue(tekening.getVorm(i).isZichtbaar());
		}
		for(int i = 4; i < 18; i++) {
			assertFalse(tekening.getVorm(i).isZichtbaar());
		}
	}
	
	@Test(expected = UiException.class)
	public void test_voegToe_gooit_exception() {
		tekening.voegToe(new Cirkel(new Punt(10, 10), 5));
	}
	
	@Test(expected = UiException.class)
	public void test_verwijder_gooit_exception() {
		tekening.verwijder(new Cirkel(new Punt(10, 10), 5));
	}

}
