package me.kevsal.minecraft.skyblockminions.storage;

public class StaticSQLStatements {

    /**
     * The statement used to create the MINION_ENTITY table
     */
    protected static final String MINION_ENTITY_DATABASE_CREATION_STMT = "CREATE TABLE IF NOT EXISTS MINION_ENTITIES(" +
            "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
            "OWNER_UUID UUID NOT NULL, " +
            "MINION_NAME VARCHAR NOT NULL DEFAULT 'Minion', " +
            "MINION_TYPE VARCHAR_IGNORECASE, " +
            "MINION_SPAWNED BOOLEAN DEFAULT FALSE, " +
            "MINION_WORLD VARCHAR NOT NULL, " +
            "MINION_LOCATION GEOMETRY(POINT Z), " +
            "MINION_CHUNK_LOCATION GEOMETRY(POINT), " +
            "ACCESS_GRANTED_TO ARRAY, " +
            "INVENTORY JSON DEFAULT '{\"TOTAL_SLOTS\": 36, \"INV_DATA\": []}', " +
            "OPTIONS JSON DEFAULT '{}', " +
            "LAST_UPDATED TIMESTAMP DEFAULT SYSTIMESTAMP);";

    /**
     * Test seed data for Entity DB.
     * Not to be included in stable release.
     * UUID is of Kevinjss2
     */
    protected static final String MINION_CREATE_TEST_STMT = "INSERT INTO MINION_ENTITIES\n" +
            "    VALUES (DEFAULT, 'a2936ea6-ebc7-4cc8-83f2-378b29f328bf', DEFAULT, 'GENERIC', DEFAULT, 'world', 'POINT(7 52 15)', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);";
    /**
     * Test seed data for Entity DB.
     * Not to be included in stable release.
     * UUID is of Kevinjss2
     */
    protected static final String MINION_CREATE_TEST_STMT2 = "INSERT INTO MINION_ENTITIES\n" +
            "    VALUES (DEFAULT, 'a2936ea6-ebc7-4cc8-83f2-378b29f328bf', 'BOB', 'GENERIC', DEFAULT, 'world', 'POINT(7 52 15)', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);";
}
