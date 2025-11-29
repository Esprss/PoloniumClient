package polonium.client.setting;

public class Setting<T> {
    private T value;

    // Конструктор, необходимый для AspectRatio
    public Setting(String name, T defaultValue, float min, float max) {
        this.value = defaultValue;
    }

    // Метод getValue(), необходимый для WindowMixin
    public T getValue() {
        return value;
    }
}
