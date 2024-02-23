
public class TransitLine {
	private char lineLetter;
	private Station firstStn;

	public TransitLine(char letter, Station first) {
		lineLetter = letter;
		firstStn = first;
	}

	public char getLineLetter() {
		return lineLetter;
	}

	public Station getFirstStn() {
		return firstStn;
	}

	/*
	 * Checks if stn is an interchange station or a regular station, and invokes the
	 * appropriate getNext method to check whether or not stn has a next station.
	 */
	public boolean hasNext(Station stn) {
		if (stn instanceof InterchangeStation) {
			if (((InterchangeStation) stn).getNext(lineLetter) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (stn.getNext() != null) {
				return true;
			} else {
				return false;
			}
		}
	}

	/*
	 * The while loop and currStn are used to traverse the list; checking whether
	 * each individual station is an interchange station and dealing with it
	 * appropriately. The two nested if statements check whether stn and currStn are
	 * interchange stations, and deals with each of the four possibilities
	 * (Interchange-Interchange, Interchange-Station, Station-Interchange,
	 * Station-Station) appropriately.
	 */
	public void addStation(Station stn) {
		Station currStn = firstStn;
		while (hasNext(currStn)) {
			if (currStn instanceof InterchangeStation) {
				currStn = ((InterchangeStation) currStn).getNext(lineLetter);
			} else {
				currStn = currStn.getNext();
			}
		}
		if (stn instanceof InterchangeStation) {
			if (currStn instanceof InterchangeStation) {
				((InterchangeStation) currStn).setNext(stn, lineLetter);
				((InterchangeStation) stn).setPrev(currStn, lineLetter);
			} else {
				currStn.setNext(stn);
				((InterchangeStation) stn).setPrev(currStn, lineLetter);
			}

		} else {
			if (currStn instanceof InterchangeStation) {
				((InterchangeStation) currStn).setNext(stn, lineLetter);
				stn.setPrev(currStn);
			} else {
				currStn.setNext(stn);
				stn.setPrev(currStn);
			}
		}
	}

	/*
	 * The first line creates a string containing the line letter and the first
	 * station's number. the while loop traverses the list and adds each station's
	 * number to the string.
	 */
	public String toString() {
		String lineStr = "Line " + lineLetter + ":  " + firstStn.getStnNo() + "  ";
		Station currStn = firstStn;
		while (hasNext(currStn)) {
			if (currStn instanceof InterchangeStation) {
				currStn = ((InterchangeStation) currStn).getNext(lineLetter);
				lineStr += currStn.getStnNo() + "  ";
			} else {
				currStn = currStn.getNext();
				lineStr += currStn.getStnNo() + "  ";
			}
		}
		return lineStr;
	}
}
