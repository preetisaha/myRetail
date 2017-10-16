# myRetail

The application is deployed in AWS, please access the application with the following URL's

GET<br>
http://myretail-env.cjwzu2vrem.us-west-2.elasticbeanstalk.com/products/<PRODUCT_ID><br>
example: http://myretail-env.cjwzu2vrem.us-west-2.elasticbeanstalk.com/products/13860428<br>
<br>

PUT<br>
http://myretail-env.cjwzu2vrem.us-west-2.elasticbeanstalk.com/products/<PRODUCT_ID><br>
REQUEST_BODY<br>
```
{
    "id": <PRODUCT_ID>,
    "title": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": <UPDATED_PRODUCT_VALUE>,
        "currency_code": <UPDATED_CURRENCY_CODE>
    }
}
```
<br>

# Run the application locally
mvn spring-boot:run<br>
Note: it will still connect with the cloud (AWS) mongo instance

# Test the application
mvn clean test<br>
