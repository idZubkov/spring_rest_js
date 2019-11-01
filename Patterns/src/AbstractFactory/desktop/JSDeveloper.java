package AbstractFactory.desktop;

import AbstractFactory.Developer;

public class JSDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes frontend layer of application...");
    }
}
