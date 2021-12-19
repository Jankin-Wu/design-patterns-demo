package adapterpattern;

import java.util.Locale;

/**
 * @author wwg
 * @description 适配器模式
 * @date 2021/12/20 1:19
 */
public class AdapterPattern {

    public static void main(String[] args) {
        String translate = new Adapter(new Speaker()).translate();
        System.out.println(translate);
    }
}

class Speaker {
    public String speak() {
        return "adapter";
    }
}

interface Translator{
    public String translate();
}

class Adapter implements Translator {

    private Speaker speaker;

    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        // 进行装换，然后返回
        return result.toUpperCase(Locale.ROOT);
    }
}
