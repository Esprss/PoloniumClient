package polonium.client.features.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;

import polonium.client.features.Category;
import polonium.client.features.Module;
import polonium.client.managers.ModuleManager;

public class ClickGuiScreen extends Screen {

    private static final int FRAME_WIDTH = 100;
    private static final int HEADER_HEIGHT = 15;
    private static final int BUTTON_HEIGHT = 15;
    private static final int PADDING = 20;

    public ClickGuiScreen() {
        super(Text.of("Click GUI"));
    }

    // 1. ОТРИСОВКА (RENDER)
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Затемняем фон (опционально, можно убрать)
        this.renderBackground(context, mouseX, mouseY, delta);

        int xOffset = PADDING;
        int yOffset = PADDING;

        // Проходимся по всем категориям (Render, Combat и т.д.)
        for (Category category : Category.values()) {
            // Рисуем заголовок категории
            context.fill(xOffset, yOffset, xOffset + FRAME_WIDTH, yOffset + HEADER_HEIGHT, 0xFF222222); // Темно-серый фон
            context.drawTextWithShadow(textRenderer, category.name(), xOffset + 5, yOffset + 4, 0xFF55FFFF); // Голубой текст

            int currentY = yOffset + HEADER_HEIGHT;

            // Проходимся по модулям в этой категории
            for (Module module : ModuleManager.INSTANCE.getModulesByCategory(category)) {
                // Цвет кнопки: Зеленый (0xFF00FF00) если включен, Серый (0xFF555555) если выключен
                // Добавляем проверку на наведение мыши (hover) для подсветки
                boolean isHovered = isHovered(xOffset, currentY, FRAME_WIDTH, BUTTON_HEIGHT, mouseX, mouseY);
                int color = module.isEnabled() ? 0xFF00AA00 : 0xFF555555;
                
                if (isHovered) {
                    color = module.isEnabled() ? 0xFF00FF00 : 0xFF777777; // Светлее при наведении
                }

                // Рисуем фон кнопки модуля
                context.fill(xOffset, currentY, xOffset + FRAME_WIDTH, currentY + BUTTON_HEIGHT, color);
                
                // Рисуем имя модуля
                context.drawTextWithShadow(textRenderer, module.getName(), xOffset + 5, currentY + 4, 0xFFFFFFFF);

                currentY += BUTTON_HEIGHT;
            }

            // Сдвигаем X для следующей колонки категорию
            xOffset += FRAME_WIDTH + 10;
        }
    }

    // 2. ОБРАБОТКА КЛИКОВ (MOUSE CLICKED)
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) { // 0 = Левая кнопка мыши
            int xOffset = PADDING;
            int yOffset = PADDING;

            for (Category category : Category.values()) {
                // Пропускаем заголовок, начинаем с кнопок
                int currentY = yOffset + HEADER_HEIGHT;

                for (Module module : ModuleManager.INSTANCE.getModulesByCategory(category)) {
                    // Проверяем, попал ли клик в область кнопки
                    if (isHovered(xOffset, currentY, FRAME_WIDTH, BUTTON_HEIGHT, (int)mouseX, (int)mouseY)) {
                        module.toggle(); // ПЕРЕКЛЮЧАЕМ МОДУЛЬ!
                        return true;
                    }
                    currentY += BUTTON_HEIGHT;
                }
                xOffset += FRAME_WIDTH + 10;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    // Вспомогательный метод для проверки наведения мыши
    private boolean isHovered(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
    
    // Чтобы меню не закрывалось при нажатии Esc (опционально)
    @Override
    public boolean shouldPause() {
        return false;
    }
}
