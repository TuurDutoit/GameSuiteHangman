package domain;

import java.util.List;
import java.util.ArrayList;
public class HintWoord {
		private ArrayList<HintLetter> hintLetters = new ArrayList<>();
		
		public HintWoord(String woord){
			this.setWoord(woord);
		}

		public String getWoord() {
			String res = "";
			
			for(HintLetter letter : hintLetters) {
				res += letter.getLetter();
			}
			
			return res;
		}

		private void setWoord(String woord) {
			if(woord == null || woord.trim().isEmpty()){
				throw new DomainException("geldig woord verwacht");
			}
			
			char[] letters = woord.toCharArray();
			
			for(char letter : letters) {
				hintLetters.add(new HintLetter(letter));
			}
		}
		
		public boolean isGeraden(){
			for (HintLetter hintLetter : hintLetters) {
				if(!hintLetter.isGeraden()) return false;
			}
			return true;
		}
		
		public boolean raad(char letter) {
			boolean geraden = false;
			
			for(HintLetter hintLetter : hintLetters) {
				if(hintLetter.raad(letter)) {
					geraden = true;
				}
			}
			
			return geraden;
		}
		
		@Override
		public String toString() {
			String res = "";
			
			for(HintLetter letter : hintLetters) {
				res += " " + letter.toChar();
			}
			
			return res.substring(1);
		}
		
}
