package at.cgsit.train.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoServiceNew {

    public String reverseEcho(String echoIn) {
        StringBuilder sb= new StringBuilder(echoIn);
        sb.reverse();
        return sb.toString().toLowerCase();
    }
}
