package AbstractFactory.mobile;

import AbstractFactory.Developer;
import AbstractFactory.PM;
import AbstractFactory.ProjectTeamFactory;
import AbstractFactory.Tester;

public class MobileTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new KotlinDeveloper();
    }

    @Override
    public Tester getTester() {
        return new MobileTester();
    }

    @Override
    public PM getPM() {
        return new MobileProjectManager();
    }
}
