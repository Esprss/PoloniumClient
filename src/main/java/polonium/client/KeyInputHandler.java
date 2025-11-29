package polonium.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import polonium.client.features.gui.ClickGuiScreen;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    // 1. Объявляем и регистрируем горячую клавишу для ClickGUI (Правый Shift)
    public static final KeyBinding clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.polonium.clickgui",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_RIGHT_SHIFT,
        "category.polonium.client"
    ));

    // 2. Метод для обработки нажатий клавиш
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // ИСПРАВЛЕНИЕ: Используем while(wasPressed()) для захвата однократного нажатия
            while (clickGuiKey.wasPressed()) { 
                if (client.currentScreen instanceof ClickGuiScreen) {
                    // Если меню уже открыто -> закрываем его
                    client.setScreen(null);
                } else if (client.currentScreen == null) {
                    // Если нет никакого меню -> открываем ClickGUI
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });
    }
}
