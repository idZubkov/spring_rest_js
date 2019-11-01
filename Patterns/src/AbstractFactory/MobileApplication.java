package AbstractFactory;

import AbstractFactory.mobile.MobileTeamFactory;

public class MobileApplication {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new MobileTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        PM pm = projectTeamFactory.getPM();

        System.out.println("Creating application...");
        developer.writeCode();
        tester.testCode();
        pm.manageProject();
    }
}
