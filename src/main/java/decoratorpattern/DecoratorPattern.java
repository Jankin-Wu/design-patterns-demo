package decoratorpattern;

/**
 * @author wwg
 * @description 装饰器模式
 * 允许向一个现有的对象添加新的功能，同时又不改变其结构
 * @date 2021/12/19 23:47
 */
public class DecoratorPattern {
    public static void main(String[] args) {

        new RobotDecorator(new FirstRobot()).doMoreThings();
    }
}

interface Robot {
    void doSomething();
}

class FirstRobot implements Robot {

    @Override
    public void doSomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class RobotDecorator implements Robot {

    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMoreThings() {
        robot.doSomething();
        System.out.println("跳舞");
    }
}

