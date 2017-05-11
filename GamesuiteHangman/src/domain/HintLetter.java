package domain;

public class HintLetter {
	private char letter;
	private boolean geraden = false;

	public HintLetter(char letter) {
		this.setLetter(letter);
	}

	public char getLetter() {
		return letter;
	}

	private void setLetter(char letter) {
		this.letter = Character.toLowerCase(letter);

		if (this.letter == ' ') {
			geraden = true;
		}
	}

	public boolean isGeraden() {
		return geraden;
	}

	public boolean raad(char letter) {
		if (geraden) {
			return false;
		}
		if (Character.toLowerCase(letter) == this.letter) {
			geraden = true;
		}

		return geraden;
	}

	public char toChar() {
		return geraden ? letter : '_';
	}
}
