package de.rusticprism.cameratweaks.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeToFile(File file, JsonObject data) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(gson.toJson(data));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error Writing data (" + data + ")!");
        }
    }

    @NotNull
    public static JsonObject readFile(File file) {
        try {
            FileInputStream reader = new FileInputStream(file);
            String str = new String(reader.readAllBytes());
            reader.close();
            return gson.fromJson(str, JsonObject.class);
        } catch (IOException e) {
            System.out.println("Error Reading File (" + file.getName() + ")!");
            return new JsonObject();
        }
    }
}
