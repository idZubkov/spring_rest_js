package AbstractFactory.mobile;

import AbstractFactory.Developer;

public class SwiftDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes on iOS devices...");
    }
}
