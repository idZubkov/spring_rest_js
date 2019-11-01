package AbstractFactory.desktop;

import AbstractFactory.PM;

public class DesktopPM implements PM {
    @Override
    public void manageProject() {
        System.out.println("Desktop PM manages desktop project...");
    }
}
