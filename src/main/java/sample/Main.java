package sample;

import org.apache.camel.component.restlet.RestletComponent;

public class Main {

    public static void main(String[] args) {
        try {
            // create a Main instance
            org.apache.camel.main.Main main = new org.apache.camel.main.Main();

            // bind MyBean into the registry
            main.bind("restlet", new RestletComponent());

            // add routes
            main.addRouteBuilder(new ServiceRouteBuilder());

            // run until you terminate the JVM
            System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
            main.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}