package domain;

import java.util.List;
import java.util.ArrayList;
public class HintWoord {

		private String woord;
		private List<HintLetter> letters = new ArrayList<>();
		
		
		
		
		public HintWoord(String woord){
			this.setWoord(woord);
		}




		public String getWoord() {
			return woord;
		}


		private void setWoord(String woord) {
			if(woord == null){
				throw new DomainException("geldig woord verwacht");
			}
			this.woord = woord;
		}

		public List<HintLetter> getLetters() {
			return letters;
		}

		private void setLetters(List<HintLetter> letters) {
			this.letters = letters;
		}
		
		public boolean isGeraden(){
			for (HintLetter hintLetter : letters) {
				if(!hintLetter.isGeraden()) return false;
				
				
			}
			return true;
		}
		

		
}
