package polonium.client.features.modules.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import polonium.client.PoloniumClient;
import polonium.client.features.Category;
import polonium.client.features.Module;
import polonium.client.managers.ModuleManager;

import java.util.List;
import java.util.stream.Collectors;

public class HUD extends Module {

    // Кэшируем экземпляр клиента, чтобы не вызывать его каждый кадр
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public HUD() {
        super("HUD", Category.RENDER);
        this.enabled = true; // Включаем HUD по умолчанию
    }

    // Этот метод вызывается на каждом кадре, он должен быть максимально быстрым
    public void render(DrawContext context) {
        // Рендер названия клиента
        context.drawTextWithShadow(
            mc.textRenderer,
            "Polonium Client" + Formatting.GRAY + " 1.21",
            2, 2, 0xFF00FFFF // Ярко-голубой цвет
        );

        // Получаем список ТОЛЬКО ВКЛЮЧЕННЫХ модулей и сортируем их по имени 
        // (хотя сортировка на каждом кадре - это небольшие накладные расходы, для списка из ~10 модулей это нормально)
        List<Module> enabledModules = ModuleManager.INSTANCE.getModules().stream()
                .filter(Module::isEnabled)
                .sorted((m1, m2) -> m2.getName().compareTo(m1.getName())) // Сортируем
                .collect(Collectors.toList());

        int y = mc.textRenderer.fontHeight + 4; // Начальная позиция для списка (ниже названия)
        
        // Рисуем список модулей
        for (Module module : enabledModules) {
            context.drawTextWithShadow(
                mc.textRenderer,
                module.getName(),
                2, y, 0xFFFFFFFF // Белый цвет
            );
            y += mc.textRenderer.fontHeight + 2; // Увеличиваем Y для следующей строки
        }
    }
}
