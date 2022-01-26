## JaxRS + openAPI

1. Import this project in your IDE, 
2. Start the database
3. Start the database viewer
4. Start the backend. There is a main class to start the backend




# Task Open API Integration 

Now, we would like to ensure that our API can be discovered. The OpenAPI Initiative (OAI) was created by a consortium of forward-looking industry experts who recognize the immense value of standardizing on how REST APIs are described. As an open governance structure under the Linux Foundation, the OAI is focused on creating, evolving and promoting a vendor neutral description format. 

APIs form the connecting glue between modern applications. Nearly every application uses APIs to connect with corporate data sources, third party data services or other applications. Creating an open description format for API services that is vendor neutral, portable and open is critical to accelerating the vision of a truly connected world.

To do this integration first, I already add a dependencies to openAPI libraries. 

```xml
			<dependency>
			<groupId>io.swagger.core.v3</groupId>
			<artifactId>swagger-jaxrs2</artifactId>
			<version>2.1.4</version>
		</dependency>
		<dependency>
			<groupId>io.swagger.core.v3</groupId>
			<artifactId>swagger-jaxrs2-servlet-initializer-v2</artifactId>
			<version>2.1.4</version>
		</dependency>
```

Next you have to add OpenAPI Resource to your application

Your application could be something like that. 

```java
@ApplicationPath("/")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<>();


		// SWAGGER endpoints
		resources.add(OpenApiResource.class);

        //Your own resources. 
        resources.add(PersonResource.class);
....
		return resources;
	}
}
```

Next start your server, you must have your api description available at [http://localhost:8080/openapi.json](http://localhost:8080/openapi.json)

### Integrate Swagger UI. 

Next we have to integrate Swagger UI. We will first download it.
https://github.com/swagger-api/swagger-ui

Copy dist folder content in src/main/webapp/swagger in your project. 

Edit index.html file to automatically load your openapi.json file. 

At the end of the index.html, your must have something like that.

```js
   // Build a system
      const ui = SwaggerUIBundle({
        url: "http://localhost:8080/openapi.json",
        dom_id: '#swagger-ui',
        
        ...
```

Next add a new resources to create a simple http server when your try to access to http://localhost:8080/api/.

This new resources can be developped as follows

```java
package app.web.rest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/api")
public class SwaggerResource {

    private static final Logger logger = Logger.getLogger(SwaggerResource.class.getName());

    @GET
    public byte[] Get1() {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/index.html"));
        } catch (IOException e) {
            return null;
        }
    }

    @GET
    @Path("{path:.*}")
    public byte[] Get(@PathParam("path") String path) {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/"+path));
        } catch (IOException e) {
            return null;
        }
    }

}
```

Add this new resources in your application

```java
@ApplicationPath("/")
public class RestApplication extends Application {


	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<>();


		// SWAGGER endpoints
		resources.add(OpenApiResource.class);
		resources.add(PersonResource.class);
        //NEW LINE TO ADD
		resources.add(SwaggerResource.class);

		return resources;
	}
}
```

Restart your server and access to http://localhost:8080/api/, you should access to a swagger ui instance that provides documentation on your api. 

You can follow this guide to show how you can specialise the documentation through annotations.

https://github.com/swagger-api/swagger-samples/blob/2.0/java/java-resteasy-appclasses/src/main/java/io/swagger/sample/resource/PetResource.java