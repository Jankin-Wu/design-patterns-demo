package singletonpattern;

/**
 * @author wwg
 * 确保一个类只有一个实例,
 * 而且自行实例化
 * 并向整个系统提供这个实例
 *
 * 1. 如何确保一个类只有一个实例?
 * 构造方法不能公开, 不能被外界实例化使用 private修饰
 * 这个实例是当前类的类成员变量 用static修饰
 * 2. 向整个系统提供这个实例
 * 使用方法向外界提供这个实例
 *
 * 单例模式一般以无状态的 工具类模式进行提供
 * 因为在使用过程中状态可能随时被改变
 * @date 2021/12/19 18:30
 */
public class Singleton {

    public static void main(String[] args) {
        SingletonLazy.getInstance().print();
    }

}


/**
 * @author wwg
 * @description 饿汉式: 类加载的时候就实例化
 * @date 2021/12/19 18:30
 */
class SingletonHungry {

    private static SingletonHungry singletonHungry = new SingletonHungry();

    public SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return singletonHungry;
    }
}

/**
 * 懒汉式：在第一次使用时实例化
 */
class SingletonLazy {

    // 使用 volatile 关键字进行修饰，防止多线程时候cpu优化，被重排序
    // 使用双重检查锁进行初始化必须使用volatile关键字进行修饰
    private volatile static SingletonLazy singletonLazy;

    public SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        // 双重检查锁定,降低同步的开销
        if (singletonLazy == null) {
            // 同步锁，防止被多次实例化
            synchronized (SingletonLazy.class) {
                if(singletonLazy == null){
                    singletonLazy = new SingletonLazy();

                }
            }
        }
        return singletonLazy;
    }

    public void print() {
        System.out.println("产品");
    }
}
