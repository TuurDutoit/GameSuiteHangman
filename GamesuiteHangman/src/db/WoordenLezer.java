package db;

import java.io.File;
import java.util.Scanner;

import domain.WoordenLijst;

public class WoordenLezer {
	private String bestandsNaam;

	public WoordenLezer(String bestandsnaam) {
		this.bestandsNaam = bestandsnaam;
	}

	public WoordenLijst lees() {
		Scanner scanner = null;
		WoordenLijst lijst = new WoordenLijst();

		try {
			scanner = new Scanner(new File(this.bestandsNaam));
			while (scanner.hasNextLine()) {
				Scanner lijnScanner = new Scanner(scanner.nextLine());

				lijnScanner.useDelimiter("\n");

				String woord = lijnScanner.next();
				lijst.voegToe(woord);

				lijnScanner.close();
			}
			return lijst;
		}
		catch (Exception e) {
			throw new DbException(e.getMessage(), e);
		}
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
