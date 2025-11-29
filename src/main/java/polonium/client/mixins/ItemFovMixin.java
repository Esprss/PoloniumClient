package polonium.client.mixins;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import polonium.client.PoloniumClient;
import polonium.client.features.modules.FOV; // Теперь FOV наследует Module

@Mixin(AbstractClientPlayerEntity.class)
public class ItemFovMixin {
    
    @Inject(method = "getFovMultiplier", at = @At("HEAD"), cancellable = true)
    private void polonium_onGetFovMultiplier(CallbackInfoReturnable<Float> cir) {
        
        FOV fovModule = (FOV) PoloniumClient.INSTANCE.getModuleManager().getModule(FOV.class);
        
        // if (fovModule.isEnabled()) { ... } // Оставляем только доступ
    }
}
