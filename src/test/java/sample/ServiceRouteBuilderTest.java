package sample;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ServiceRouteBuilderTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new ServiceRouteBuilder();
    }

    @Test
    public void test() {
        String requestBody = this.getClass().getSimpleName();
        Exchange requestExchange = createExchangeWithBody(requestBody);

        Exchange responseExchange = template.send(ServiceRouteBuilder.ENDPOINT_URI + "?restletMethod=POST", requestExchange);
        String responseBody = responseExchange.getOut().getBody(String.class);

        assertEquals("Hello " + requestBody + " says ServiceRouteBuilder", responseBody);
    }
}
