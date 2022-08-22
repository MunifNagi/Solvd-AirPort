package com.solvd.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Starting The Application.");
        AirportApplication.run();
        logger.info("Exiting The Application.");
    }
}
