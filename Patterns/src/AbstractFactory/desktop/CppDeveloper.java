package AbstractFactory.desktop;

import AbstractFactory.Developer;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes backend layer of application...");
    }
}
