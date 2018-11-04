package eulir.model;

public class Floor {
	private Controller controller;
	private int number;

	public Floor(int floor) {
		number = floor;
		controller = new Controller(this.number);
	}
}

class Controller {
	private int request;
	private int floor;

	public Controller(int floor) {
		this.floor = floor;
	}

	//TODO: I haven't thought about the solution or structure clearly yet
	public void setRequest(int requestFloor) {
		this.request = requestFloor;

	}
}
