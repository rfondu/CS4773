package player;

public class PlayerPoints extends Player{

	private int pointsTotal;
	
	public PlayerPoints(String name) {
		super(name);
	}
	
	public void setPoints(int points){
		pointsTotal += points;
	}
	
	public int getPoints() {
		return pointsTotal;
	}
}