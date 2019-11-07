package ObserverPublisher;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    public static void main(String[] args) {PewDiePie pewDiePie = new PewDiePie();
        pewDiePie.addVideo("My first video");
        pewDiePie.addVideo("A funny montage");
        pewDiePie.addVideo("Minecraft let's play");

        Subscriber firstSubscriber = new TheSubscriber("Nick");
        Subscriber secondSubscriber = new TheSubscriber("Anna");
        Subscriber thirdSubscriber = new TheSubscriber("Mike");

        pewDiePie.addSubscriber(firstSubscriber);
        pewDiePie.addSubscriber(secondSubscriber);
        pewDiePie.addSubscriber(thirdSubscriber);

        pewDiePie.removeVideo("My first video");
    }
}

interface Subscriber {
    void handleEvent(List<String> videos);
}

interface YouTuber {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

class TheSubscriber implements Subscriber {
    private String name;

    public TheSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> videos) {
        System.out.println("Dear " + name + "\ntoday was released new video on your feed\n************************");
    }
}

class PewDiePie implements YouTuber {
    private List<String> videos = new ArrayList<>();

    private List<Subscriber> subscribers = new ArrayList<>();

    public void addVideo(String video) {
        videos.add(video);
        notifySubscribers();
    }

    public void removeVideo(String video) {
        videos.remove(video);
        notifySubscribers();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers)
            subscriber.handleEvent(videos);
    }
}