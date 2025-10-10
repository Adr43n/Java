package businessModel;

public class Score{
	private int score;
	
	public Score(int score) {
		this.score=score;
	}
	

	public  void one (int score) {
		this.score+=1;
		
	}
	public  void two (int score) {
		this.score+=2;
		
	}
	public  void three (int score) {
		this.score+=3;
		
	}

	public int getScore() {
		return this.score;
	}

}
