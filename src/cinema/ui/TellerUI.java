package cinema.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import cinema.model.Hour;
import cinema.model.Theater;
import cinema.model.Ticket;

public class TellerUI extends AbstractUI {

	
	
	@Override
	protected void showMenu() {

		System.out.println();
		System.out.println("Please make a selection:");
		System.out.println("1. List theatres");
		System.out.println("2. Sell ticket");
		System.out.println("q. Quit");
		
	}

	@Override
	protected void runMainLoop() {
		
		Map<Integer,Theater> theaters = new HashMap<>();
		Collection<Ticket> tickets = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		String line;
		
	
		
		while(!(line= showMenuAndGetSelection(scanner)).equals("q")){
			int selection =Integer.valueOf(line);
			
			switch (selection) {
			case 1:
				listTheaters(theaters.values());
				break;
				
			case 2:
				sellTickets(scanner, theaters, tickets);
				break;

			default:
				System.out.println("Invalid choice, please try again.");
				break;
			}
		}
		
	}
	
	private void sellTickets(Scanner scanner, Map<Integer,Theater> theaters,Collection<Ticket> tickets){
		
		System.out.println("Select a theater:");
		listTheaters(theaters.values());
		int selectedTheaterId = Integer.valueOf(scanner.nextLine());
		Theater selectedTheater = theaters.get(selectedTheaterId);
		if(selectedTheater ==null){
			
			System.out.println("Wrong selection");
			return;
		}
		System.out.println("Select an hour:");
		ListAllHours();
		Integer selectedHourIndex = Integer.valueOf(scanner.nextLine());
		Hour selectedHour = Hour.values()[selectedHourIndex-1];
		
		Ticket ticket = new Ticket(1,1,selectedHour,selectedTheater);
		tickets.add(ticket);
		showSeatStatus(selectedTheater.getEmptySeats(tickets, selectedHour));
	}
	
	
	private void ListAllHours(){
		
		int i=1;
		
		for (Hour hour :Hour.values()) {
			System.out.println(i+": "+ hour.getFormattedHour()+", Price: $"+ hour.getPrice());
			i++;
		}
	}
	
	private void showSeatStatus(boolean[][] seats){
		
		
		for (int i = 0; i < seats.length; i++) {
			
			boolean[] currentRow = seats[i];
			for (int j = 0; j < currentRow.length; j++) {
				boolean currentSeat = currentRow[j];
				if(currentSeat){
					System.out.println("# ");
				}else{
					
					System.out.println(":)");
					
					
				}
			}
			
		}
	}
	
}
