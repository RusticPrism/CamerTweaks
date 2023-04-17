package de.rusticprism.cameratweaks.mixin;

import de.rusticprism.cameratweaks.CameraTweaks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {

    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    public void onScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        if (MinecraftClient.getInstance().options.getPerspective() == Perspective.FIRST_PERSON || MinecraftClient.getInstance().currentScreen != null)
            return;
        if (CameraTweaks.config.get("max-distance") != null && CameraTweaks.distance >= CameraTweaks.config.get("max-distance").getAsInt()) {
            if (vertical > 0) {
                CameraTweaks.distance -= vertical * 0.25 * CameraTweaks.distance;
            }
            ci.cancel();
            return;
        }
        CameraTweaks.distance -= vertical * 0.25 * CameraTweaks.distance;

        ci.cancel();
    }

}
