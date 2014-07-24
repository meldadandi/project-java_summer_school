package cinema.ui;

import java.util.Collection;
import java.util.Scanner;

import cinema.model.Theater;

public abstract class AbstractUI {
	
	protected String showMenuAndGetSelection(Scanner scanner){
		
		showMenu();
		return scanner.nextLine();
}
	
	
	protected abstract void showMenu();
	protected abstract void runMainLoop();


	protected void listTheaters(Collection<Theater> theaters){
		
		for (Theater theater : theaters) {
				System.out.println(theater.getId()+": "+theater.getName()+", "+theater.getRows()+"x"+theater.getCols());
		}
	}	
}
