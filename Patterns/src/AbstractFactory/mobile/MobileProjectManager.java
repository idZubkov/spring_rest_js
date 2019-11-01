package AbstractFactory.mobile;

import AbstractFactory.PM;

public class MobileProjectManager implements PM {
    @Override
    public void manageProject() {
        System.out.println("Mobile PM manages mobile project...");
    }
}
