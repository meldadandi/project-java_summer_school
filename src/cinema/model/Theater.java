package cinema.model;

import java.util.Arrays;
import java.util.Collection;

public class Theater {
	
	private int id;
	private String name;
	private int rows;
	private int cols;
	
	
	
	public Theater(String name, int rows, int cols) {
		super();
		this.name = name;
		this.rows = rows;
		this.cols = cols;
	}
	
	public Theater(int id, String name, int rows, int cols) {
		super();
		this.id = id;
		this.name = name;
		this.rows = rows;
		this.cols = cols;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	public int getAvailableSpace(Collection<Ticket> tickets, Hour hour){
		
		boolean[][] emptySeats = getEmptySeats(tickets, hour);
		int availableSpaces =0;
		for (int i = 0; i < emptySeats.length; i++) {
			for (int j = 0; j < emptySeats[i].length; j++) {
				if(emptySeats[i][j]){
					availableSpaces++;
				}
			}
			
		}
		return availableSpaces;
	}
	
	
	public boolean[][] getEmptySeats(Collection<Ticket> tickets,Hour hour){
			
		boolean[][] emptySeats = new boolean[rows][cols];
		
		for (int i = 0; i < emptySeats.length; i++) {
			boolean[] currentRow = emptySeats[i];
			Arrays.fill(currentRow,true);
		}
		
		for (Ticket ticket : tickets) {
			
			if(ticket.getTheater().equals(this)&& ticket.getHour().equals(hour)){
				
				emptySeats[ticket.getRow()-1][ticket.getCol()-1]= false;
			}
		}
		return emptySeats;
			
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(!(other instanceof Theater)){
			return false;
		}
		return this.getId() == ((Theater)other).getId();
	}
	
	@Override
	public int hashCode() {
	
		return this.getId();
	}
	}
