# NBP

### 0. To start the server, run this command:
```
java -jar NBPApp-0.0.1-SNAPSHOT.jar
```
Alternatively, you can run this project directly from your IDE by running the main class.


### 1. To query operation 1, run this command:
```
curl http://localhost:8080/api/exchange/USD/2023-04-24 
```
which should give the result of 4.1905

### 2. To query operation 2, run this command:
```
curl http://localhost:8080/api/averageValue/USD/12
```
which result will be min and max average rates for USD in the last 12 days. 

### 3. To query operation 3, run this command:
```
curl http://localhost:8080/api/bidAndAsk/USD/15
```
which will result in showing the biggest difference in ask and bid rates for USD in the last 15 days.
