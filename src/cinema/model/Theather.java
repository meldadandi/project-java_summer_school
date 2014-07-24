package cinema.model;

public class Theather {
	
	private int id;
	private String name;
	private int rows;
	private int cols;
	
	
	
	public Theather(String name, int rows, int cols) {
		super();
		this.name = name;
		this.rows = rows;
		this.cols = cols;
	}
	
	public Theather(int id, String name, int rows, int cols) {
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
	
	
}
