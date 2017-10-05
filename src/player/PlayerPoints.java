package player;

public class PlayerPoints extends Player{

	static int pointsTotal;
	
	public PlayerPoints(String name) {
		super(name);
	}
	
	public static void setPoints(int points){
		pointsTotal += points;
	}
	
	public int getPoints() {
		return pointsTotal;
	}
}
