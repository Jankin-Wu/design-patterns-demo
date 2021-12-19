package abstractfactorypattern;

/**
 * @author wwg
 * @description 抽象工厂模式
 * 工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。
 * 工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。
 * @date 2021/12/19 23:24
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        huaWeiFactory.createPhone().print();
        huaWeiFactory.createMask().print();
    }
}

interface AbstractFactory{
    public Phone createPhone();
    public Mask createMask();
}

class HuaWeiFactory implements AbstractFactory {

    @Override
    public Phone createPhone() {
        return new HuaWei();
    }

    @Override
    public Mask createMask() {
        return new N95();
    }
}

class AppleFactory implements AbstractFactory {

    @Override
    public Phone createPhone() {
        return new Apple();
    }

    @Override
    public Mask createMask() {
        return new N95();
    }
}

interface Phone {
     void print();
}

class Apple implements Phone {

    @Override
    public void print() {
        System.out.println("苹果手机");
    }
}

class HuaWei implements Phone {

    @Override
    public void print() {
        System.out.println("华为手机");
    }
}

interface Mask {
    void print();
}

class N95 implements Mask {

    @Override
    public void print() {
        System.out.println("N95 口罩");
    }
}