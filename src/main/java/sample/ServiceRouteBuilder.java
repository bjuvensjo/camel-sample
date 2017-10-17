package sample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class ServiceRouteBuilder extends RouteBuilder {
    private static final String PACKAGE_NAME = ServiceRouteBuilder.class.getPackage().getName();
    private static final String INTERNAL_ENDPOINT_URI = String.format("direct:%s.foo", PACKAGE_NAME);
    public static final String ENDPOINT_URI = String.format("restlet:?restletMethods=POST&restletUriPatterns=#restletUriPatterns");
    
    public void configure() {
        from(ENDPOINT_URI)
                .choice()
                    .when(body().isNull()).throwException(new RuntimeException("Body must not be null!"))
                .otherwise()
                    .bean(Translator.class)
                    .to(INTERNAL_ENDPOINT_URI)
                .end();

        from(INTERNAL_ENDPOINT_URI)
                .transform(simple(String.format("${body} says %s", ServiceRouteBuilder.class.getSimpleName())));
    }
}
