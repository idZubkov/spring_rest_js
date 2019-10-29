package State;

public class StateTest {
    public static void main(String[] args) {
        Station vestiFM = new VestiFM();
        Radio radio = new Radio();
        radio.setStation(vestiFM);

        for (int i = 0; i < 15; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}

interface Station {
    void play();
}

class Radio7 implements Station {

    @Override
    public void play() {
        System.out.println("Radio 7...");
    }
}

class RadioDFM implements Station {

    @Override
    public void play() {
        System.out.println("RadioDFM...");
    }
}

class VestiFM implements Station {

    @Override
    public void play() {
        System.out.println("VestiFM...");
    }
}

//context
class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}
