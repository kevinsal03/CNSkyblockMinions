package me.kevsal.minecraft.skyblockminions.utilities;

import com.google.gson.JsonObject;
import org.bukkit.inventory.Inventory;
import org.json.simple.JSONObject;

//TODO: Implement JSON/Inventory converter
public class InventoryConverter {
    public static JSONObject inventoryToJSON(Inventory inv) {
        return new JSONObject();
    }

    public static Inventory jsonToInventory(String json) {
        System.out.println("JSON String: " + json);
        return null;
    }

}
