package sample;

import org.apache.camel.builder.RouteBuilder;

public class ServiceRouteBuilder extends RouteBuilder {
    private static final String PACKAGE_NAME = ServiceRouteBuilder.class.getPackage().getName();
    private static final String INTERNAL_ENDPOINT_URI = String.format("direct:%s.foo", PACKAGE_NAME);
    public static final String ENDPOINT_URI = String.format("direct:%s", PACKAGE_NAME);

    public void configure() {
        from(ENDPOINT_URI)
//                .transform(simple("Hello ${body}"))
                .bean(Translator.class)
            .to(INTERNAL_ENDPOINT_URI);

        from(INTERNAL_ENDPOINT_URI)
                .transform(simple(String.format("${body} says %s", ServiceRouteBuilder.class.getSimpleName())));
    }
}
