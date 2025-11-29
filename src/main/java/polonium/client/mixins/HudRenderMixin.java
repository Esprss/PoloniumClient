package polonium.client.mixins;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import polonium.client.PoloniumClient;
import polonium.client.features.modules.HUD; // Теперь HUD наследует Module

@Mixin(InGameHud.class)
public class HudRenderMixin {

    // Предполагаем, что HUD Mixin нацелен на метод render()
    @Inject(method = "render", at = @At("HEAD"))
    private void polonium_onRender(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        
        HUD hudModule = (HUD) PoloniumClient.INSTANCE.getModuleManager().getModule(HUD.class);
        
        // if (hudModule.isEnabled()) { ... } // Оставляем только доступ
    }
}
