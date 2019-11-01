package AbstractFactory.desktop;

import AbstractFactory.Developer;
import AbstractFactory.PM;
import AbstractFactory.ProjectTeamFactory;
import AbstractFactory.Tester;

public class DesktopTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new CppDeveloper();
    }

    @Override
    public Tester getTester() {
        return new DesktopTester();
    }

    @Override
    public PM getPM() {
        return new DesktopPM();
    }
}
