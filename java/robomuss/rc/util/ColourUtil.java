package robomuss.rc.util;

import java.awt.Color;

public class ColourUtil {

	public static Color[] colours = {Color.WHITE, Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA};
	
	public static float getRed(int meta) {
		return colours[meta].getRed();
	}

	public static float getGreen(int meta) {
		return colours[meta].getGreen();
	}

	public static float getBlue(int meta) {
		return colours[meta].getBlue();
	}
	
	public static float getAlpha(int meta) {
		return colours[meta].getAlpha();
	}
}
