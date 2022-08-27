package me.escoffier.quarkus;

import io.smallrye.mutiny.Multi;
import me.escoffier.quarkus.avro.Hero;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/heroes")
public class AvroConsumerResource {

    @Channel("heroes")
    Multi<Hero> heroes;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<Hero> stream() {
        return heroes;
    }


}
