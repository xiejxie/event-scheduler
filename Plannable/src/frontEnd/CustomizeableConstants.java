package frontEnd;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to control the customizable portions of the UI, namely the colours of the time blocks and the text
 * of the header of each step
 */
public class CustomizeableConstants {
	static private final String[] colourSet = {"#5B0028", "#820139", "#960042", "#DD0061", "#E20063", "#6C1100", "#991902",
			"#B11B00", "#FF2800", "#FF2800", "#380147",  "#500465", "#5C0275", "#8C02B4", "#9505BE"};
	static private final String[] steps = {"Your Courses", "Your Extracurriculars", "Your Evaluations", "Your ????"};
	/**
	 * @return	colour of the new time block
	 */
	public static String getColour() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, colourSet.length);
		return colourSet[randomNum];
	}
	
	/**
	 * @param state	the current step
	 * @return	the header string for the current step
	 */
	public static String getHeaderString(int state) {
		return steps[state-1];
	}
}
