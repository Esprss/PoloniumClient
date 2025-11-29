package polonium.client.features.setting;

import java.util.function.Predicate;

public class Setting<T> {
    
    private final String name;
    private T value;
    private final T minimum;
    private final T maximum;
    private Predicate<T> visibility; 

    // Конструктор для числовых настроек
    public Setting(String name, T defaultValue, T minimum, T maximum) {
        this.name = name;
        this.value = defaultValue;
        this.minimum = minimum;
        this.maximum = maximum;
        this.visibility = v -> true; 
    }

    // Конструктор для булевых и простых настроек
    public Setting(String name, T defaultValue) {
        this.name = name;
        this.value = defaultValue;
        this.minimum = null; 
        this.maximum = null; 
        this.visibility = v -> true;
    }

    // Конструктор с условием видимости
    public Setting(String name, T defaultValue, T minimum, T maximum, Predicate<T> visibility) {
        this(name, defaultValue, minimum, maximum);
        this.visibility = visibility;
    }
    
    public Setting(String name, T defaultValue, Predicate<T> visibility) {
        this(name, defaultValue);
        this.visibility = visibility;
    }

    // Геттеры и Сеттеры
    public String getName() { return name; }
    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    public T getMinimum() { return minimum; }
    public T getMaximum() { return maximum; }
    public boolean isVisible() { return visibility.test(getValue()); }
}
