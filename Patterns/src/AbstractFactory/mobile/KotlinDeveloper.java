package AbstractFactory.mobile;

import AbstractFactory.Developer;

public class KotlinDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes on android devices...");
    }
}
