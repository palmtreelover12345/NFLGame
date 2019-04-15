package nfl.game;

import java.util.Random;
import java.util.Scanner;

public class Game{
	final static int GAME_PLAY = 5;
	static Team team;
	static Scanner input = new Scanner(System.in);
	static int gameRound = 0;
	final static String PLAY_ERR_MSG = "Can not play.  Create a team first.";
	final static String CREATE_ERR_MSG = "Team is already created.";
	final static String UPDATE_ERR_MSG = "Can not update.  Create a team first.";
	final static String TEAM_ERR_MSG = "Nothing to show.  Create a team first.";
	final static String STATS_ERR_MSG = "No stats available.  Create a team first.";
	final static String INVALID_ERR_MSG = "Invalid input.  Try again.";
	
	public static void main(String[] args) {
		char choice = ' ';
		boolean done = false;
		do {
			do {
				showMainMenu();
				try {
					choice = input.nextLine().charAt(0);
					choice = Character.toUpperCase(choice);
					if (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5' && choice != 'Q')
						showError(INVALID_ERR_MSG);
						pressAnyKey();
				} else {
					done = true;
				}
			} catch (Exception e) {
				showError(INVALID_ERR_MSG);
			}
		
		} while (!done);
		
	} while (processSelection(choice));
}
	public static void clearScreen() {
		for (int i = 0; i < 7; System.out.println(), i++)
			;
	}
	private static void showError(String message) {
		System.out.println("\n>>>> " + message + " <<<<\n");
	}
	private static boolean processSelection(char choice) {
		switch (choice) {
		case '1': // Play game
			if (team != null)
				if (gameRound >=5) {
					System.out.print("Play Again (Y/N)?");
					try {
						choice = input.nextLine().charAt(0);
						choice = Character.toUpperCase(choice);
						if (choice == 'Y') {
							gameRound = 0;
							team.setScores(new int[] { 0, 0, 0 });
							play();
						}
					} catch (Exception e) {
						showError(INVALID_ERR_MSG);
					}
					
				} else {
					play();
				}
			else
				showError(PLAY_ERR_MSG);
			break;
		case '2': // Create Team
			if (team == null)
				createTeam();
			else
				showError(CREATE_ERR_MSG);
			break;
		case '3': //Update Team
			if (team != null)
				updateTeam();
			else
				showError(UPDATE_ERR_MSG);
			break;
		case '4': //Display Stats
			if (team != null)
				displayStats();
			else
				showError(STATS_ERR_MSG);
			break;
		case '5': // Show Roster
			if (team != null)
				showRoster();
			else
				showError(TEAM_ERR_MSG);
			break;
		case 'Q': //Exit Game
				showError(TEAM_ERR_MSG);
			break;
		case 'Q': //Exit Game
			quit();
			break;
		}
		pressAnyKey();
		return true;	
		}
	
	private static void showRoster() {
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("                       TEAM ROSTER");
			System.out.println("-----------------------------------------------");
			team.showRoster();
						}
						
	private static void quit() {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("    THANKS FOR PLAYING.  GOOD-BYE.");
		System.out.println("-------------------------------------");
		System.exit(0);
	}
	
	private static void displayStats() {
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("                        TEAM STATISTICS");
		System.out.println("----------------------------------------------------");
		team.showTeamStats();
		
	}
	
	private static void createTeam() {
		team = new Team();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println(" Let's Create Your Team");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.print("Team Name: ");
		team.setName(input.nextLine());
		System.out.print("Owner Name: ");
		team.setOwner(input.nextLine());
		System.out.print("Head Coach: ");
		team.setCoach(input.nextLine());
		System.out.println();
		setSide();
		team.setSide("Offensive");
		System.out.println(" ** Team Created! **");
	}
	
	private static void setSide() {
		char choice;
		do {
			System.out.print("(1) Defensive or (2) Offensive: ");
			choice = input.nextLine().charAt(0);
		} while (choice != '1' && choice != '2');
		
		if (choice == '1') {
			setupDefensiveTeam();
		} else {
			setupOffensiveTeam();
		}
		}
	
	private static void setupOffensiveTeam() { 
		Player[] players = new Player[6];
		for (int i = 0; i < Team.MAX_PLAYERS; i++) {
			players[i] = new Player();
		}
		team.setSide("Offensive");
		setupPlayer(players[0], "Quarterback");
		setupPlayer(players[1], "Wide Receiver");
		setupPlayer(players[2], "Wide Receiver");
		setupPlayer(players[3], "Offensive Guard");
		setupPlayer(players[4], "Offensive Guard");
		setupPlayer(players[5], "Center");
	}
	
	private static void setupDefensiveTeam() {
		Player[] players = new Player[6];
		for(int i = 0; i < Team.MAX_PLAYERS; i++) {
			players[i] = new Player();
		}
		team.setSide("Defensive");
		setupPlayer(players[0], "Safety");
		setupPlayer(players[1], "Cornerback");
		setupPlayer(players[2], "Cornerback");
		setupPlayer(players[3], "Defensive Tackle");
		setupPlayer(players[4], "Defensive Tackle");
		setupPlayer(players[5], "Middle Linebacker");
		team.setPlayers(players);
		}
	
	private static void setupPlayer(Player player, String position) {
		System.out.println("Position: " + position);
		player.setPosition(position);
		System.out.print("Name:");
		player.setName(input.nextLine());
		System.out.print("Jersey Number:");
		player.setJerseyNumber(input.nextInt());
		System.out.print("Height:");
		player.setHeight(input.nextInt());
		System.out.print("Weight:");
		player.setWeight(input.nextInt());
		System.out.print("Age:");
		player.setAge(input.nextInt());
		input.hasNextLine(); //flush out stream
	}
	
	private static void play() {
		System.out.println("------------------------------------");
		System.out.println("     LET'S PLAY.  GOOD LUCK!");
		System.out.println("------------------------------------");
		for (gameRound = 1; gameRound <= GAME_PLAY; gameRound++) {
			System.out.println("Round #" + gameRound);
			pressAnyKey();
			
			int result = getRandom();
			team.updateScore(result); // update score
			switch (result) {
			case 0:
				System.out.println(">>> Sorry, You Lost!");
				break;
			case 1:
				System.out.println(">>> You Win!");
				break;
			case 2:
				System.out.println(">>> It's a Tie!");
				break;
			}
		}
		clearScreen();
	}
	
	private static void pressAnyKey() {
		System.out.println();
		System.out.println("Press any key to start");
		input.nextLine();
	}
	
	static void showMainMenu() {
		System.out.println("----------------------------------");
		System.out.println("             NFL GAME");
		System.out.println("----------------------------------");
		System.out.println("(1) Play");
		System.out.println("(2) Create New Team");
		System.out.println("(3) Update Team");
		System.out.println("(4) Display Team Stats");
		System.out.println("(5) Display Roster");
		System.out.println("(Q) Exit");
		
		System.out.print("\nSelection (1, 2, 3, 4, 5, Q):");
	}
	
	static void showUpdateMenu() {
		System.out.println("----------------------------------");
		System.out.println("             TEAM UPDATE");
		System.out.println("----------------------------------");
		System.out.println("(1) Edit Team Name");
		System.out.println("(2) Edit Owner");
		System.out.println("(3) Edit Coach");
		System.out.println("(4) Edit Team Stats");
		System.out.println("(5) Edit Roster");
		System.out.println("(Q) Exit");
		
		System.out.print("\nSelection (1, 2, 3, 4, 5, Q):");
	}
		
	static void updateTeam() {
		
		}
	
	static void processUpdate() {
		
	}
	
	static void editPlayers() {
		System.out.println();
		System.out.print("Enter new Players name or (999 to cancel): ");
		try {
			String temp = input.nextLine();
			if (!temp.contentEquals("999") && temp.length()>0) {
				team.setName(temp);
				System.out.println(" ** Team Players Edited! ** ");
			}
		} catch (Exception e) {
			showError(INVALID_ERR_MSG);
		}
	}
	
	private static void editCoach() {
		System.out.println();
		System.out.print("Enter new Coach name or (999 to cancel): ");
		try {
			String temp = input.nextLine();
			if (!temp.contentEquals("999") && temp.length()>0) {
				team.setName(temp);
				System.out.println(" ** Team Coach Edited! ** ");
			}
		} catch (Exception e) {
			showError(INVALID_ERR_MSG);
		}
	}
	
	private static void editOwner() {
		System.out.println();
		System.out.print("Enter new Owner name or (999 to cancel): ");
		try {
			String temp = input.nextLine();
			if (!temp.contentEquals("999") && temp.length()>0) {
				team.setName(temp);
				System.out.println(" ** Team Owner Edited! ** ");
			}
		} catch (Exception e) {
			showError(INVALID_ERR_MSG);
	}

				}
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void editTeam() {
			System.out.println();
			System.out.print("Enter new team name or (999 to cancel): ");
			try {
				String temp = input.nextLine();
				if (!temp.equals("999") && temp.length()>0) {
					team.setName(temp);
					System.out.println(" ** Team Name Edited! **");
				}
			} catch (Exception e) {
				showError(INVALID_ERR_MSG);
			}
		}
		
		public static int getRandom() {
			return new Random().nextInt(2);
		}
		
	}
		
		
	}