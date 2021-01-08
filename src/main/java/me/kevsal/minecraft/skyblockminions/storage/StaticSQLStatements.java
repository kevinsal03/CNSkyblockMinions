package me.kevsal.minecraft.skyblockminions.storage;

public class StaticSQLStatements {

    /**
     * The statement used to create the table
     */
    public static final String MINION_ENTITY_DATABASE_CREATION_STMT ="CREATE TABLE IF NOT EXISTS MINION_ENTITIES(" +
            "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
            "OWNER_UUID UUID NOT NULL, " +
            "MINION_NAME VARCHAR NOT NULL DEFAULT 'Minion', " +
            "MINION_TYPE VARCHAR_IGNORECASE, " +
            "MINION_SPAWNED BOOLEAN DEFAULT FALSE, " +
            "MINION_LOCATION GEOMETRY(POINT Z), " +
            "ACCESS_GRANTED_TO ARRAY, " +
            "INVENTORY JSON DEFAULT '{\"TOTAL_SLOTS\": 36, \"INV_DATA\": []}', " +
            "OPTIONS JSON DEFAULT '{}', " +
            "LAST_UPDATED TIMESTAMP DEFAULT SYSTIMESTAMP);";

    /**
     * Test seed data for Entity DB
     * Not to be included in stable release
     * UUID is of Kevinjss2
     */
    public static final String MINION_CREATE_TEST_STMT = "INSERT INTO MINION_ENTITIES\n" +
            "    VALUES (DEFAULT, 'a2936ea6-ebc7-4cc8-83f2-378b29f328bf', DEFAULT, 'STONE', DEFAULT, 'POINT(7 52 15)', DEFAULT, DEFAULT, DEFAULT, DEFAULT);";
}
