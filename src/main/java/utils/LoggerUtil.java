package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import listeners.LogListeners;

public class LoggerUtil {
	private static final Logger logger = LogManager.getLogger(LogListeners.class);

	public static Logger getLogger() {
		return logger;
	}

	public static void log(String message) {
		logger.info(message);
	}

}
