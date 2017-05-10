package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);
	private LijnStuk lijnStuk;
	private LijnStuk zelfdeLijnStuk;

	@Before
	public void setUp() {
		lijnStuk = new LijnStuk(punt1, punt2);
		zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
	}

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		assertEquals(punt1, lijnStuk.getStartPunt());
		assertEquals(punt2, lijnStuk.getEindPunt());
	}

	@Test(expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null() {
		new LijnStuk(null, punt2);
	}

	@Test(expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null() {
		new LijnStuk(punt1, null);
	}

	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn() {
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}

	@Test
	public void equals_moet_false_teruggeven_als_parameter_null() {
		assertFalse(lijnStuk.equals(null));
	}

	@Test
	public void test_getOmhullende() {
		Punt linksBoven = new Punt(10, 20);
		int breedte = 180;
		int hoogte = 10;
		Omhullende omhullende = new Omhullende(linksBoven, breedte, hoogte);
		assertEquals(omhullende, lijnStuk.getOmhullende());
	}
}
