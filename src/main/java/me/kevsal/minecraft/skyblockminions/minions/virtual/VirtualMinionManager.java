package me.kevsal.minecraft.skyblockminions.minions.virtual;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import me.kevsal.minecraft.skyblockminions.storage.DatabaseManager;
import me.kevsal.minecraft.skyblockminions.utilities.H2GeometryPointParser;
import me.kevsal.minecraft.skyblockminions.utilities.InventoryConverter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.Inventory;
import org.h2.value.ValueGeometry;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class VirtualMinionManager {
    /**
     * All active Virtual Minions
     */
    @Getter public static HashMap<Integer, AbstractVirtualMinion> virtualMinions = new HashMap<>();

    public static void buildVirtualMinionsFromDB() {
        ResultSet queryResult;
        int resultSize;
        try {
            Statement smt = DatabaseManager.getDatabase().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            queryResult = smt.executeQuery("SELECT * FROM MINION_ENTITIES"); // get all MINION_ENTITIES
            queryResult.last(); // go to last entry in the scrolling result
            resultSize = queryResult.getRow(); // get last row to get result size
            queryResult.beforeFirst(); // reset to before start
            // incoming magic code that does what it should except for where it says it doesn't
            if (resultSize > 0) {
                for (int i = 1; i <= resultSize; i++) {
                    queryResult.absolute(i);
                    int minionID = queryResult.getInt(1);
                    UUID ownerUUID = UUID.fromString(queryResult.getString(2));
                    String minionName = queryResult.getString(3);
                    MinionType type = MinionType.valueOf(queryResult.getString(4));
                    boolean spawned = queryResult.getBoolean(5);
                    World world = Bukkit.getWorld(queryResult.getString(6));
                    double[] coordinates = H2GeometryPointParser.parse(queryResult.getString(7));
                    Location minionLocation = new Location(world, coordinates[0], coordinates[1], coordinates[2]);
                    // 7 is chunk location -> not used in this instance
                    // 8 is unused for now
                    Inventory inv = InventoryConverter.jsonToInventory(queryResult.getString(10));
                    HashMap<String, ?> options = new HashMap<>(); // from 11 queryResult.getObject(11); TODO: Make this work
                    Timestamp lastUpdated = queryResult.getTimestamp(12);

                    // Create the actual minion
                    AbstractVirtualMinion minion;
                    switch (type) {
                        // Case for each valid type
                        // TODO: Implement each case for each type
                        case GENERIC:
                            minion = new GenericVirtualMinion(minionID, ownerUUID, minionName, type, spawned, minionLocation, inv, options, lastUpdated);
                            break;
                        case COBBLESTONE:
                            throw new UnsupportedOperationException("Not yet implemented");
                        default:
                            throw new IllegalStateException("Unexpected MinionType: " + type);
                    }

                    // By now, the minion object contains a valid VirtualMinion.
                    // It was built using data grabbed from the DB and parsed very terribly but it works
                    getVirtualMinions().put(minionID, minion); // It is injected into the HashMap with the ID as its key
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace(); // bruh if this happens somethings very broken
        }

        // TODO: Implement saving changes back to DB
    }
}
