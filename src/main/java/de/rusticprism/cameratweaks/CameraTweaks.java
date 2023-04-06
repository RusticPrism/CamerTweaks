package de.rusticprism.cameratweaks;

import net.fabricmc.api.ClientModInitializer;

public class CameraTweaks implements ClientModInitializer {
    public static double distance = 4;

    @Override
    public void onInitializeClient() {
        System.out.println("Enabled CameraTweaks");
    }
}
