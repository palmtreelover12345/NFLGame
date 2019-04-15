package nfl.game;

public class Team{
	public final static int MAX_PLAYERS = 6;
	private String name;
	private String side;
	private String owner;
	private String coach;
	private int[] scores = {0,0,0}; //{wins, loss, tie}
	private Player[] players = new Player[6];
	private int[] gamePlays = {0,0,0,0,0};
	
	public Team() {
		for(int i=0; i<MAX_PLAYERS; i++) {
			players[i] = new Player();
		}
		defaultTeam();
	}
	public Team(String name,
				String side,
				String owner,
				Player[] players) {
		this.setName(name);
		this.setSide(side);
		this.setOwner(owner);
		this.setPlayers(players);
	}
	
	public void defaultTeam() {
		setName("Avengers");
		setOwner("Nick Fury");
		setCoach("Agent Colsun");
		players[0]=new Player("Iron Man",12,"Quarterback (QB)",75,225,45);
		players[1]=new Player("Captain Marvel",80,"Wide Receiver (WR)",68,140,28);
		players[2]=new Player("Captain America",88,"Wide Receiver (WR)",75,240,32);
		players[3]=new Player("Hulk",60,"Offensive Guard (OG)",95,650,40);
		players[4]=new Player("Hulkbuster",61,"Offensive Guard (OG)",75,225,30);
		players[5]=new Player("Hawkeye",65,"Center",75,190,35);
	}
	
	
	public void showTeamStats() {
		final int MAX_CHAR=20;
		System.out.println();
 		System.out.println("\t\t\t\t\tHead \t\tStanding");
 		System.out.println("Team Name \t\tOwner \t\tCoach \t\t(W-L-T)");
 		System.out.println("------------------------------------------------------------");
 		System.out.printf("%s \t %s \t%s \t\t %d-%d-%d",name,owner,coach,scores[0],scores[1],scores[2]);
		System.out.println("Team Name: " + getName());
		System.out.println("Owner: " + getOwner());
		System.out.println("Head Coach: " + getCoach());
		System.out.println("Standing: " + scores[0] + "-" + scores[1] + "-" + scores[2]);
		System.out.println();
		
		System.out.println("Players\t\t\tPosition");
		System.out.println("---------------------------------------------------------");
		for(Player p: players) {
			System.out.print(p.getName() + " (" + p.getJerseyNumber() + ")");
			int len = p.getName().length() + 4;
			for(int i=0; i<(MAX_CHAR - len);i++) {
				System.out.print(" ");
			}
			System.out.print("\t");
			System.out.println(p.getPosition());
		}
	}
	
	public void showRoster() {
		final int MAX_CHAR=20;
		System.out.println();
		System.out.println("NO\tName\tPOSITION\t\tHEIGHT\tWEIGHT\tAGE");
		System.out.println("--\t------\t-------------\t--------------\t------\t---");
		for(Player p: players) {
			System.out.print(p.getJerseyNumber() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPosition());
			for(int i=0; i<(MAX_CHAR - p.getPosition().length());i++) {
				System.out.print(" ");
			}
			System.out.print("\t");
			System.out.print(p.getHeight() + "\t");
			System.out.print(p.getWeight() + "\t");
			System.out.println(p.getHeight());
			}
		}
	
	public void updateScore(int index) {
		this.scores[index]++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public int[] getGamePlays() {
		return gamePlays;
	}
	public void setGamePlays(int[] gamePlays) {
		this.gamePlays = gamePlays;
	}
	
	
}