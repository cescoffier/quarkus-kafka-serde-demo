package me.escoffier.quarkus.json.publisher;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@ApplicationScoped
public class JsonPublisherApp {

    private static List<Hero> HEROES = List.of(
            new Hero("Superman", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/kal-el--6588698781056217537.jpg"),
            new Hero("Batman", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/bruce-wayne--2025947968722612285.jpg"),
            new Hero("Hulk", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/bruce-banner-5841770625972586926.jpg"),
            new Hero("Thor", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/thor-odinson--5525123334458093779.jpg"),
            new Hero("Wonder Woman", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/diana-prince--3889120050011682223.jpg"),
            new Hero("Captain Marvel", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/phyla-vell-2794029539156181072.jpg"),
            new Hero("Catwoman", "https://raw.githubusercontent.com/quarkusio/quarkus-super-heroes/characterdata/images/selina-kyle-6483523119104476523.jpg")
    );

    @Channel("heroes")
    Emitter<Hero> emitter;

    Iterator<Hero> iterator;

    @Scheduled(every = "5s", delayed = "5s")
    public void writeAHero() {
        if (iterator == null || !iterator.hasNext()) {
            iterator = HEROES.iterator();
        }
        var hero = iterator.next();
        emitter.send(hero);
    }
}
