package de.rusticprism.cameratweaks;

import com.google.gson.JsonObject;
import de.rusticprism.cameratweaks.utils.FileUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

public class CameraTweaks implements ClientModInitializer {
    public static double distance = 4;
    public static final String MOD_ID = "camera-tweaks";
    public static final File FOLDER = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID).resolve("config.json").toFile();
    public static JsonObject config;

    @Override
    public void onInitializeClient() {
        System.out.println("Enabled CameraTweaks");
        if (!FOLDER.exists()) {
            FOLDER.getParentFile().mkdirs();
            try {
                FOLDER.createNewFile();
                JsonObject object = new JsonObject();
                object.addProperty("max-distance", 20);
                object.addProperty("default-distance", 4);
                FileUtils.writeToFile(FOLDER, object);
            } catch (IOException e) {
                System.out.println("Error creating and saving defaults!");
            }
        }
        config = FileUtils.readFile(FOLDER);
        if (CameraTweaks.config.get("default-distance") == null) {
            CameraTweaks.distance = 4;
        } else CameraTweaks.distance = CameraTweaks.config.get("default-distance").getAsInt();
    }
}
