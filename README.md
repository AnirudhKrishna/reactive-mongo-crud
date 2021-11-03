# spring-boot-embedded-mongo
Sample project with spring webflux and embedded mongo

# to build application 

~~~
mvn clean install
~~~

# to run application
~~~
mvn spring-boot:run
~~~

-----------------------------------------------------------------------------------------------
create-product
-----------------------------------------------------------------------------------------------
curl --location --request POST 'http://localhost:8080/api/product/' \
--header 'Content-Type: application/json' \
--data-raw '{
"sku": "sample09",
"name": "sample request 02",
"brand": "sample request 02",
"size": "sample request 02",
"price": "sample request 02",
"principalImage": "sample request 02",
"otherImage": "images"
}'

-----------------------------------------------------------------------------------------------
find-all-products
-----------------------------------------------------------------------------------------------
curl --location --request GET 'http://localhost:8080/api/product/' \
--header 'Content-Type: application/json' \
--data-raw ''

-----------------------------------------------------------------------------------------------
findby-sku
-----------------------------------------------------------------------------------------------
curl --location --request GET 'http://localhost:8080/api/product/sample09'


-----------------------------------------------------------------------------------------------
update product
-----------------------------------------------------------------------------------------------
curl --location --request PUT 'http://localhost:8080/api/product/' \
--header 'Content-Type: application/json' \
--data-raw '{
"sku": "sample09",
"name": "sample request 04",
"brand": "sample request 02",
"size": "sample request 02",
"price": "sample request 02",
"principalImage": "sample request 02",
"otherImage": "sample request 02"
}'

-----------------------------------------------------------------------------------------------
delete-product
-----------------------------------------------------------------------------------------------
curl --location --request DELETE 'http://localhost:8080/api/product/sample03'







