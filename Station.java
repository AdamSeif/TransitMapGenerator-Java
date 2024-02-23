
public class Station {
	private static int nextID = 0;
	private int id;
	private int stnNo;
	private String name;
	private Station prev;
	private Station next;
	private int x;
	private int y;

	public Station(int stnNo, String stnName, int x, int y) {
		this.stnNo = stnNo;
		name = stnName;
		this.x = x;
		this.y = y;
		prev = null;
		next = null;
		id = nextID;
		nextID++;
	}

	public int getID() {
		return id;
	}

	public int getStnNo() {
		return stnNo;
	}

	public String getName() {
		return name;
	}

	public Station getPrev() {
		return prev;
	}

	public Station getNext() {
		return next;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPrev(Station stn) {
		prev = stn;
	}

	public void setNext(Station stn) {
		next = stn;
	}

	public String toString() {
		return "Stn: " + stnNo + " (" + name + ")";
	}

}
