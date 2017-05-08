package domain;

public class Speler {
	private String naam;
	private int score;
	
	public Speler(String naam) {
		if(naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Name cannot be empty");
		}
		
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addToScore(int diff) {
		if(score + diff < 0) {
			throw new DomainException("New score cannot be negative");
		}
		
		score += diff;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Speler) {
			Speler other = (Speler) o;
			return other.getNaam().equals(naam) && other.getScore() == score;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return naam + " heeft als score: " + score;
	}
}
