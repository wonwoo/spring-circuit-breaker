# spring-circuit-breaker


## Run
```
git clone https://github.com/wonwoo/spring-circuit-breaker.git
cd spring-circuit-breaker/coffeestore
mvn clean package
java -jar target/*.jar

cd spring-circuit-breaker/starbucks
mvn clean package
java -jar target/*.jar

cd spring-circuit-breaker/hystrix-dashboard
mvn clean package
java -jar target/*.jar
```

## hystrix dashborad

 - http://localhost:8010/hystrix.html
 - http://localhost:8080/hystrix.stream


## Test

1. http request

```
http localhost:8080

HTTP/1.1 200
Content-Length: 30
Content-Type: text/plain;charset=UTF-8
Date: Mon, 29 May 2017 13:39:09 GMT
X-Application-Context: application

Espresso, Cappuccino, Hazelnut

...
...

```

2. hystrix dashborad circuit `closed`
3. shutdown starbucks

4. http request
```
http localhost:8080

HTTP/1.1 200
Content-Length: 10
Content-Type: text/plain;charset=UTF-8
Date: Mon, 29 May 2017 13:40:47 GMT
X-Application-Context: application

Cappuccino

... 
...
...
```
5. hystrix dashborad circuit `open`




