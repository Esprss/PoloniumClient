package polonium.client.mixins;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import polonium.client.PoloniumClient;
import polonium.client.features.modules.FOV; // Теперь FOV наследует Module

@Mixin(GameRenderer.class)
public class FovMixin {
    
    @Inject(method = "getFov", at = @At("HEAD"), cancellable = true)
    private void polonium_onGetFov(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
        
        FOV fovModule = (FOV) PoloniumClient.INSTANCE.getModuleManager().getModule(FOV.class);

        // if (fovModule.isEnabled()) { ... } // Мы не знаем логику, оставляем только доступ
    }
}
