package polonium.client.managers;

import polonium.client.features.Category;
import polonium.client.features.Module;
import polonium.client.features.modules.render.HUD;
import polonium.client.features.modules.render.FOV;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();

    private List<Module> modules;

    private ModuleManager() {
        modules = new ArrayList<>();
        modules.add(new HUD());
        modules.add(new FOV());
    }

    public List<Module> getModules() {
        return modules;
    }

    // ИСПРАВЛЕНИЕ: Добавлено подавление предупреждения unchecked cast
    @SuppressWarnings("unchecked")
    public <T extends Module> T getModule(Class<T> clazz) {
        for (Module module : modules) {
            if (module.getClass() == clazz) {
                return (T) module; 
            }
        }
        return null;
    }

    public List<Module> getModulesByCategory(Category category) {
        return modules.stream()
                .filter(module -> module.getCategory() == category)
                .collect(Collectors.toList());
    }
}
