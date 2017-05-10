package domain;

public class HintLetter {

	
		private char letter;
		private boolean geraden = false;

		
			public HintLetter(char letter){
				this.setLetter(letter);
			}



			public char getLetter() {
				return letter;
			}



			private void setLetter(char letter) {
				
				this.letter = letter;
			}
			
			
			public boolean isGeraden(){
				return geraden;
			}
			
			public boolean raad(char letter){
				if(geraden) return false;
				if(letter == this.letter){
					geraden = true;
					return true;
				}
				return false;
			}
			
			public char toChar(){
				return geraden ? letter : '_';
			}
}
