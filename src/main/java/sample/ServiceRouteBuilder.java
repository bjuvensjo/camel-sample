package sample;

import org.apache.camel.builder.RouteBuilder;

public class ServiceRouteBuilder extends RouteBuilder {
    private static final String PACKAGE_NAME = ServiceRouteBuilder.class.getPackage().getName();
    public static final String ENDPOINT_URI = "direct:" + PACKAGE_NAME;

    public void configure() {
        from(ENDPOINT_URI)
                .transform(simple("Hello ${body}"));
    }
}
