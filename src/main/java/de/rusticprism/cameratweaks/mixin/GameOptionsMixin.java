package de.rusticprism.cameratweaks.mixin;

import de.rusticprism.cameratweaks.CameraTweaks;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
    @Inject(method = "setPerspective", at = @At("HEAD"))
    public void onPerspective(Perspective perspective, CallbackInfo ci) {
        CameraTweaks.distance = 4;
    }
}
