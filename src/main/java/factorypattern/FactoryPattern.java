package factorypattern;

/**
 * @author wwg
 * 工厂模式
 * 定义一个创建对象的接口，
 * 让子类决定实例化哪个类。
 * 工厂方法使一个类的实例化延迟到其子类
 * @date 2021/12/19 23:05
 */
public class FactoryPattern {

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.createProduct().print();
    }

}

interface AbstractFactory{
    public Product createProduct();
}

class FactoryA implements AbstractFactory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements AbstractFactory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

abstract class Product{
    public abstract void print();
}

class ProductA extends Product {

    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductB extends Product {

    @Override
    public void print() {
        System.out.println("产品B");
    }
}