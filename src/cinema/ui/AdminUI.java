package cinema.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import cinema.model.Theater;

public class AdminUI extends AbstractUI {

	
	public static void main(String[] args) {
		
		AdminUI ui = new AdminUI();
		ui.runMainLoop();
	}

	
	
	@Override
	protected  void runMainLoop() {
		Scanner scanner = new Scanner(System.in);
		String line;
		Collection<Theater> theaters = new ArrayList<>();
		
		while(!(line=showMenuAndGetSelection(scanner)).equals("q")){
			
			int selection  = Integer.valueOf(line);
			
			switch (selection) {
			case 1:
				listTheaters(theaters);
				break;
			case 2:
				addTheater(scanner, theaters);
				break;

			default:
				System.out.println("Invalid choice, please try again.");
				break;
			}			
		}
	}

	
	private void addTheater(Scanner scanner, Collection<Theater> theaters){
		
		System.out.println("Enter a theater in the following format:");
		System.out.println("name, rows, cols");
		String line = scanner.nextLine();
		String []splitted = line.split(", ");
				
		String name=splitted[0];
		int rows =Integer.valueOf(splitted[1]);
	    int cols = Integer.valueOf(splitted[2]);
		Theater theater =new Theater(name,rows,cols);
		theaters.add(theater);
	
	}




	@Override
	protected void showMenu() {
		System.out.println();
		System.out.println("Please make a selection:");
		System.out.println("1. List theatres");
		System.out.println("2. Add theater");
		System.out.println("q. Quit");
		
	}
	
	

	

}
