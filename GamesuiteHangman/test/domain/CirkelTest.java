package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	private Punt punt = new Punt(5, 5);
	private int radius = 5;
	private Cirkel cirkel;

	@Before
	public void setUp() {
		cirkel = new Cirkel(punt, radius);
	}

	@Test
	public void test_geldig() {
		assertEquals(punt, cirkel.getMiddelpunt());
		assertEquals(radius, cirkel.getRadius());
	}

	@Test(expected = DomainException.class)
	public void test_middelpunt_null() {
		Cirkel c = new Cirkel(null, 5);
	}

	@Test(expected = DomainException.class)
	public void test_radius_kleiner_dan_nul() {
		Cirkel c = new Cirkel(punt, -5);
	}

	@Test(expected = DomainException.class)
	public void test_radius_nul() {
		Cirkel c = new Cirkel(punt, 0);
	}

	@Test
	public void test_equals() {
		Cirkel c1 = new Cirkel(punt, radius);

		assertTrue(cirkel.equals(c1));
	}

	@Test
	public void test_equals_null() {
		assertFalse(cirkel.equals(null));
	}

	@Test
	public void test_equals_verschillend_middelpunt() {
		Cirkel c = new Cirkel(new Punt(10, 6), radius);

		assertFalse(cirkel.equals(c));
	}

	@Test
	public void test_equals_verschillende_straal() {
		Cirkel c = new Cirkel(punt, 10);
		assertFalse(cirkel.equals(c));
	}

	@Test
	public void test_toString() {
		assertEquals("Cirkel: middelpunt: (5, 5) - straal: 5", cirkel.toString());
	}

	@Test
	public void test_getOmhullende() {
		Punt linksBoven = new Punt(0, 0);
		int breedte = 10;
		int hoogte = 10;
		Omhullende omhullende = new Omhullende(linksBoven, breedte, hoogte);
		assertEquals(cirkel.getOmhullende(), omhullende);
	}

}
