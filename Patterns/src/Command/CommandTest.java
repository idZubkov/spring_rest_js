package Command;

public class CommandTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface Command {
    void execute();
}

//Receiver
class Computer {
    void start() {
        System.out.println("Computer starting...");

    }
    void stop() {
        System.out.println("Computer stopping...");
    }
    void reset() {
        System.out.println("Computer reset...");
    }
}

//ConcreteCommand
class StartCommand implements Command {
    private Computer computer;

    public StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command {
    private Computer computer;

    public StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command {
    private Computer computer;

    public ResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

//Invoker
class User {
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}