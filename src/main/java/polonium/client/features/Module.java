package polonium.client.features;

public class Module {
    private String name;
    private Category category;
    protected boolean enabled = false; // Статус модуля (вкл/выкл)

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    // Метод переключения
    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    // Методы для переопределения в конкретных модулях
    public void onEnable() {}
    public void onDisable() {}
    public void onRender() {} // Для рендера в мире, если нужно
}
