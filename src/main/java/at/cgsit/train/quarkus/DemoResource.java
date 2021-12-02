package at.cgsit.train.quarkus;

import at.cgsit.train.quarkus.service.DemoService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * doku
 */
@Path("/helloDemo")
public class DemoResource {

    @Inject
    DemoService service;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo/{inputString}")
    public String greeting(@PathParam String inputString) {
        return "Hello [" + service.reverseEcho(inputString ) + "]";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloSimple() {
        return "Hello helloDemo TEST2";
    }
}
