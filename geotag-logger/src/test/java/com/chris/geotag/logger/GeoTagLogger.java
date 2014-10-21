package com.chris.geotag.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeoTagLogger {
	private static final Logger logger = Logger.getAnonymousLogger();
	
	public static final Level INFO = Level.INFO;
	
	public static void log(Level level, String message) {
		logger.log(level, message);
	}
}
