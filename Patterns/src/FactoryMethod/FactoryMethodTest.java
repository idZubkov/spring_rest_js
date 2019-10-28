package FactoryMethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory maker = carByDestiny("sport");                       //в скобках пишется какого типа машина требуется (предназначение)
        Car car = maker.createCar();                                   //если необходим, например, маслкар, то нужно просто добавить класс Musclecar implements Car
        car.drive();                                                   //и создать фабрику маслкаров class Musclecar implements CarFactory, и не забыть добавить в carByDestiny
    }

    static CarFactory carByDestiny(String destiny) {
        if (destiny.equalsIgnoreCase("sport"))
            return new SportcarFactory();
        else if (destiny.equalsIgnoreCase("electro"))
            return new ElectroarFactory();
        else
            throw new RuntimeException("destiny '" + destiny + "' is unknown");
    }
}

interface Car {
    void drive();
}

class Electrocar implements Car {

    @Override
    public void drive() {
        System.out.println("*звук электромотора*");
    }
}

class Sportcar implements Car {

    @Override
    public void drive() {
        System.out.println("*звук выхлопа спорткара*");
    }
}

interface CarFactory {
    Car createCar();
}

class ElectroarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Electrocar();
    }
}

class SportcarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Sportcar();
    }
}