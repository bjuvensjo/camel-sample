package sample;

import org.apache.camel.component.restlet.RestletComponent;

public class Main {

    public static void main(String[] args) {
        try {
            // create a Main instance
            org.apache.camel.main.Main main = new org.apache.camel.main.Main();

            // bind RestletComponent into the registry
            main.bind("restlet", new RestletComponent());

            // add routes
            main.addRouteBuilder(new ServiceRouteBuilder());

            main.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}