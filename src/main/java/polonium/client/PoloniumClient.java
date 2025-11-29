package polonium.client;

import polonium.client.features.modules.Module;
import net.fabricmc.api.ModInitializer; // <--- НОВЫЙ ИМПОРТ

// Главный класс клиента Polonium, который должен быть ModInitializer
public class PoloniumClient implements ModInitializer { // <--- НОВЫЙ ИНТЕРФЕЙС
    
    public static final PoloniumClient INSTANCE = new PoloniumClient();
    
    private final ModuleManager moduleManager = new ModuleManager();

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
    
    @Override
    public void onInitialize() { // <--- НОВЫЙ МЕТОД ЗАПУСКА
        // Здесь должен быть твой код инициализации (регистрация модулей, настроек и т.д.)
        // Пока оставляем пустым для успешного запуска.
    }

    // Заглушка ModuleManager для компиляции
    public static class ModuleManager {
        public Module getModule(Class<? extends Module> clazz) {
            return null;
        }
    }
}
