package polonium.client.features.modules;

public class Module {
    // Используется для конструктора AspectRatio и FOV
    public Module(String name, Category category) {}

    // Используется для проверки в WindowMixin и FOV Mixin
    public boolean isEnabled() {
        return false;
    }
}
