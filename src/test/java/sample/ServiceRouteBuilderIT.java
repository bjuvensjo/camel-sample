package sample;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Ignore;
import org.junit.Test;

public class ServiceRouteBuilderIT extends CamelTestSupport {

    @Test
    @Ignore
    public void testSuccess() {
        String requestBody = this.getClass().getSimpleName();
        Exchange requestExchange = createExchangeWithBody(requestBody);

        Exchange responseExchange = template.send(ServiceRouteBuilder.ENDPOINT_URI + "?restletMethod=POST", requestExchange);
        String responseBody = responseExchange.getOut().getBody(String.class);

        assertEquals("Hello " + requestBody + " says ServiceRouteBuilder", responseBody);
    }

    @Test
    @Ignore
    public void testFailure() {
        String requestBody = null;
        Exchange requestExchange = createExchangeWithBody(requestBody);

        Exchange responseExchange = template.send(ServiceRouteBuilder.ENDPOINT_URI + "?restletMethod=POST", requestExchange);

        assertTrue(responseExchange.isFailed());
    }
}
