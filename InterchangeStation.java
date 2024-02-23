
public class InterchangeStation extends Station {
	private Station[] prevs;
	private Station[] nexts;

	public InterchangeStation(int stnNo, String stnName, int x, int y) {
		super(stnNo, stnName, x, y);
		prevs = new Station[2];
		nexts = new Station[2];
	}

	public Station getPrev() throws StationException {
		throw new StationException("InterchangeStation cannot use getPrev()");
	}

	public Station getNext() throws StationException {
		throw new StationException("InterchangeStation cannot use getNext()");
	}

	public void setPrev(Station stn) throws StationException {
		throw new StationException("InterchangeStation cannot use setPrev()");
	}

	public void setNext(Station stn) throws StationException {
		throw new StationException("InterchangeStation cannot use setNext()");
	}

	/*
	 * Private helper method that expands the prevs array by one more than the
	 * index, "num", that is passed in as a parameter
	 */
	private void expandPrevs(int num) {
		if (num >= prevs.length) {
			Station[] newPrevs = new Station[num + 1];
			for (int i = 0; i < prevs.length; i++) {
				newPrevs[i] = prevs[i];
			}
			prevs = newPrevs;
		}
	}

	public void setPrev(Station stn, char lineLetter) {
		int num = lineLetter - 65;
		expandPrevs(num);
		prevs[num] = stn;
	}

	/*
	 * Private helper method that expands the nexts array by one more than the
	 * index, "num", that is passed in as a parameter
	 */
	private void expandNexts(int num) {
		if (num >= nexts.length) {
			Station[] newNexts = new Station[num + 1];
			for (int i = 0; i < nexts.length; i++) {
				newNexts[i] = nexts[i];
			}
			nexts = newNexts;
		}
	}

	public void setNext(Station stn, char lineLetter) {
		int num = lineLetter - 65;
		expandNexts(num);
		nexts[num] = stn;
	}

	public Station getPrev(char lineLetter) {
		int num = lineLetter - 65;
		try {
			if (num >= nexts.length) {
				return null;
			}
			return prevs[num];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	/*
	 * Returns null if there is no next station
	 */
	public Station getNext(char lineLetter) {
		int num = lineLetter - 65;
		try {
			if (num >= nexts.length) {
				return null;
			}
			return nexts[num];
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Station[] getPrevArray() {
		return prevs;
	}

	public Station[] getNextArray() {
		return nexts;
	}

	/*
	 * if statement determines whether there is a previous station for each index.
	 * If there is it, adds the station number to the string, otherwise, it adds to
	 * underscores
	 */
	public String getPrevString() {
		String prevString = "";
		for (int i = 0; i < prevs.length; i++) {
			Station stn = prevs[i];
			String stnString = "";
			if (stn != null) {
				stnString = stn.getStnNo() + "  ";
			} else {
				stnString = "__  ";
			}
			prevString += stnString;
		}

		return prevString;
	}

	/*
	 * if statement determines whether there is a next station for each index. If
	 * there is it, adds the station number to the string, otherwise, it adds to
	 * underscores
	 */
	public String getNextString() {
		String nextString = "";
		for (int i = 0; i < nexts.length; i++) {
			Station stn = nexts[i];
			String stnString = "";
			if (stn != null) {
				stnString = stn.getStnNo() + "  ";
			} else {
				stnString = "__  ";
			}
			nextString += stnString;
		}

		return nextString;
	}

	/* Helper method that returns the greater of two integers */
	private int max(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	/*
	 * The first line calls the super class's toString, and the second line creates
	 * an array of integer objects and initializes it to be as large as either prevs
	 * or nexts (whichever is larger). The first two for loops traverse the prevs
	 * and nexts arrays and records the non-null values in both of them, those
	 * values are then stored in the array from the second line. The third loop adds
	 * the characters (from non-null indices in the integer object array) to the
	 * string.
	 */
	public String toString() {
		String interStnString = super.toString() + " on Lines: ";
		Integer[] stationNumbers = new Integer[max(prevs.length, nexts.length)];
		for (int i = 0; i < prevs.length; i++) {
			if (prevs[i] != null) {
				stationNumbers[i] = Integer.valueOf(i);
			}
		}
		for (int i = 0; i < nexts.length; i++) {
			if (nexts[i] != null) {
				stationNumbers[i] = Integer.valueOf(i);
			}
		}
		for (int i = 0; i < stationNumbers.length; i++) {
			String stnString = "";
			if (stationNumbers[i] != null) {
				stnString = (char) (65 + i) + " ";
			}
			interStnString += stnString;
		}
		return interStnString;
	}
}
