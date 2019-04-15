package nfl.game;

public class Player {
	private String name;
	private int jerseyNumber;
	private String position;
	private int height;
	private int weight;
	private int age;
	
	public Player() {}
	public Player(	String name,
					int jerseyNumber,
					String position,
					int height,
					int weight,
					int age) {
		setName(name);
		setJerseyNumber(jerseyNumber);
		setPosition(position);
		setHeight(height);
		setWeight(weight);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
}