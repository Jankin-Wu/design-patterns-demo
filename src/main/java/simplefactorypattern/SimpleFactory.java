package simplefactorypattern;

/**
 * @author wwg
 * 简单工厂模式属于类创建型模式
 * 可以根据参数的不同返回不同的实例
 * 专门创建一个类来创建其他类的实例
 * 被创建的实例通常具有共同的父类
 *
 * 简单工厂中的角色:
 * 1. 抽象产品类
 * 2. 产品子类
 * 3. 工厂类
 * @date 2021/12/19 19:16
 */
public class SimpleFactory {

    public static Product creatProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        }else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = SimpleFactory.creatProduct("A");
        product.print();
    }

}

abstract class Product {
    public abstract void print();
}

class ProductA extends Product{


    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductB extends Product{


    @Override
    public void print() {
        System.out.println("产品B");
    }
}