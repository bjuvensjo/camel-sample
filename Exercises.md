<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<title></title>
<xmp theme="cerulean" style="display:none;">

## Setup ##

1. Clone [camel-sample](https://github.com/bjuvensjo/camel-sample/tree/master)
2. Checkout the "Exercise-1" branch
3. Import camel-sample in Intellij

## Analyze ##

1. Run the test [ServiceRouteBuilderTest](./src/test/java/sample/ServiceRouteBuilderTest.java)
   1. What happens?
2. Analyze [ServiceRouteBuilder](./src/main/java/sample/ServiceRouteBuilder.java)
   1. Why "extends RouteBuilder"?
   2. Why is the constant PACKAGE_NAME declared private, and why is ENDPOINT_URI public?
   3. What is "direct"? Where can you find its documentation? What options does it have? Is it synchronous or asynchronous and what difference does that make? 
   4. Pros and cons with "direct"?
   5. Why is the method we implement named "configure"?
   6. Is the route we configure a consumer or producer (hint: "from")?
   7. What is a consumer and what is a producer?
   8. Can we configure a route that is both a consumer and a producer?
   9. Where are "from" and "transform" defined? And what do they return?
   10. Where is "simple" defined? Where is it documented?
   11. The "transform" method accepts a parameter of type "Expression". What is an "Expression"? And how can you know that "simple" makes an "Expression"? What is transformed by "transform"? 
3. Analyze [ServiceRouteBuilderTest](./src/test/java/sample/ServiceRouteBuilderTest.java)
   1. Write down some findings and/or questions
4. Analyze [pom](./pom.xml)
   1. What is it?
   2. Why "dependencies"?
   
## Develop ##

1. Configure a second route in the configure method that does some transformation
2. Invoke the second route from the first
3. Run the test and confirm that it gives you an error message
4. Update the test and confirm that you can run it with success
5. Refactor the first route so that is does not use the "transform" method, but does the same transformation in a "bean"

</xmp>
<script src="http://strapdownjs.com/v/0.2/strapdown.js"></script>
</html>
