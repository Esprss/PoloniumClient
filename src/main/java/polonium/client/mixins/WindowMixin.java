package polonium.client.mixins;

import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import polonium.client.PoloniumClient;
import polonium.client.features.modules.render.AspectRatio;

@Mixin(Window.class)
public class WindowMixin {
    
    // Warning: 'Unable to determine descriptor' игнорируем, он часто появляется в Mixin'ах
    @Inject(method = "getAspectRatio", at = @At("HEAD"), cancellable = true)
    private void polonium_onGetAspectRatio(CallbackInfoReturnable<Float> cir) {
        
        // Используем унифицированный доступ: INSTANCE.getModuleManager().getModule()
        AspectRatio module = (AspectRatio) PoloniumClient.INSTANCE.getModuleManager().getModule(AspectRatio.class);

        if (module != null && module.isEnabled()) {
            cir.setReturnValue(module.ratio.getValue());
            cir.cancel(); 
        }
    }
}
