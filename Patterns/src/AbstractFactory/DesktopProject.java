package AbstractFactory;

import AbstractFactory.desktop.DesktopTeamFactory;

public class DesktopProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new DesktopTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        PM pm = projectTeamFactory.getPM();

        System.out.println("Creating application...");
        developer.writeCode();
        tester.testCode();
        pm.manageProject();
    }
}
