package polonium.client.features.modules.render;

import polonium.client.features.modules.Module;
import polonium.client.features.modules.Category;
import polonium.client.setting.Setting;

public class AspectRatio extends Module {
    public Setting<Float> ratio = new Setting<>("Ratio", 1.78f, 0.1f, 5f);
    
    public AspectRatio() {
        super("AspectRatio", Category.RENDER);
    }
}
