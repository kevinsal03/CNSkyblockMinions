package me.kevsal.minecraft.skyblockminions.storage;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.SkyblockMinions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class DatabaseManager {

    @Getter
    private static Connection database; // The H2 database

    // DatabaseManager specific logger
    private static final Logger logger = LoggerFactory.getLogger("CNSkyblockMinions - DatabaseManager");


    /**
     * Attempt to load the H2 drivers from the shaded and non-shaded location.
     */
    public static void loadDBDrivers() {
        try {
            Class.forName("org.h2.Driver"); // Not shaded + relocated
            Class.forName("me.kevsal.minecraft.skyblockminions.lib.h2.Driver"); // Shaded + relocated
        } catch (ClassNotFoundException ignored) {}
    }

    /**
     * Initialize the database and entity table
     * @return true if the database initialized successfully
     */
    public static boolean initDatabase() {
        loadDBDrivers();
        try {
            database = DriverManager.getConnection("jdbc:h2:" + SkyblockMinions.getInstance().getDataFolder().getAbsolutePath() + "/minion-data");
            logger.info("Using H2 Driver from " + DriverManager.getDriver(database.getMetaData().getURL()).getClass());
            logger.info("Successfully connected to DB.");
            initializeMinionEntityTable();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Fatal Error! Could not initialize to database!");
            return false;
        }
    }

    /**
     * Close the H2 database
     */
    public static void closeDatabase() {
        try {
            getDatabase().close();
            logger.info("Database closed.");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Fatal Error! Could not close database, corruption could occur.");
        }
    }

    /* Private Methods */

    /**
     * Setup minion entity table
     * @throws SQLException if statement fails to execute
     */
    private static void initializeMinionEntityTable() throws SQLException {
        database.prepareStatement(StaticSQLStatements.MINION_ENTITY_DATABASE_CREATION_STMT).execute();
        database.prepareStatement(StaticSQLStatements.MINION_CREATE_TEST_STMT).execute(); // Seed test data, TODO: Remove before release
        logger.info("MINION_ENTITY table initialized.");
    }
}
