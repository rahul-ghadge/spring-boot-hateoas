# spring-boot-hateoas
Spring boot rest api with hateoas 


This application handles the Rest API calls to Super heros, also handle exceptions occured in application<br>
It will provide out the json response in return for success and errors also along with **reference links to other APIS** with the help of HATEOAS.

<b> Features Implemented : </b>

* `SuperHeroUtils` class is under `com.arya.demo.util` package. Which provides dummy data of Super Heros using `Supplier<SuperHero>`.
* `SuperHeroController` from `com.arya.demo.controller` package exposes Rest APIs.
* Each record will have self link to show data individually.
* `GlobalExceptionHandler` from `com.arya.demo.exception` package handles all exceptions thrown from the **controller**.

<strong> BUILD the application as Maven Project </strong>

> mvn clean install

<strong> Run Jar file from target folder </strong>

> java -jar spring-boot-hateoas-1.0.0.jar

<strong> Or Run application without creating jar in IDE(Eclipse/Intellij) </strong>

> Run Spring main class `SpringBootMainApplication` from package `com.arya.demo`

---------------------------------------------------------
## API Endpoints
Get all super heros via **`http://host:port/super-heros`**

http://localhost:8080/super-heros</br>
&nbsp;&nbsp;- This API will return all super heros from util class</br>
&nbsp;&nbsp;- Each super hero will have it't own link url</br>


http://localhost:8080/super-heros/name/Tony</br>
&nbsp;&nbsp;- This API will return Iron Mans data with it's self link to **fetch data by age**</br>
&nbsp;&nbsp;- super hero will also return link url for **all super heros**</br>


-------------------------------------------------------------
http://localhost:8080/super-heros/age/28</br>
&nbsp;&nbsp;- This API will return Deadpools data with it's self link to **fetch data by name**</br>
&nbsp;&nbsp;- super hero will also return link url for **all super heros**</br>


