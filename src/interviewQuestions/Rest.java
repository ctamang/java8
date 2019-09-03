package interviewQuestions;

/*

What does REST stand for? (answer)
	REST stands for REpresentational State Transfer, which uses HTTP protocol to send data from client to server e.g. a book in 
	the server can be delivered to the client using JSON or XML.


What is a resource? (answer)
	A resource is how data is represented in REST architecture. By exposing entities as the resource it allows a client to read,
	write, modify, and create resources using HTTP methods e.g. GET, POST, PUT, DELETE etc.


What are safe REST operations? (answer)
	REST API uses HTTP methods to perform operations. Some of the HTTP operations which doesn't modify the resource at the 
	server is known as safe operations e.g. GET and HEAD. On the other hand, PUT, POST, and DELETE are unsafe because they 
	modify the resource on the server.


What are idempotent operations? Why is idempotency important? (answer)
	In the context of REST APIs, when making multiple identical requests has the same effect as making a single request – then
	that REST API is called idempotent.
	When you design REST APIs, you must realize that API consumers can make mistakes. They can write client code in such a way
	that there can be duplicate requests as well. These duplicate requests may be unintentional as well as intentional some time
	(e.g. due to timeout or network issues). You have to design fault-tolerant APIs in such a way that duplicate requests do 
	not leave the system unstable.
	An idempotent HTTP method is an HTTP method that can be called many times without different outcomes. It would not matter 
	if the method is called only once, or ten times over. The result should be the same. It essentially means that the result 
	of a successfully performed request is independent of the number of times it is executed. For example, in arithmetic, adding
	zero to a number is idempotent operation.
	If you follow REST principles in designing API, you will have automatically idempotent REST APIs for GET, PUT, DELETE, HEAD,
	OPTIONS and TRACE HTTP methods. Only POST APIs will not be idempotent.
	POST is NOT idempotent.
	GET, PUT, DELETE, HEAD, OPTIONS and TRACE are idempotent.
	Let’s analyze how above HTTP methods end up being idempotent – any why POST is not.
	HTTP POST
		Generally – not necessarily – POST APIs are used to create a new resource on server. So when you invoke the same POST 
		request N times, you will have N new resources on the server. So, POST is not idempotent.

What are the advantages of the RestTemplate? (answer)
	The RestTemplate class is an implementation of Template method pattern in Spring framework. Similar to other popular
	template classes e.g. JdbcTemplate or JmsTempalte, it also simplifies the interaction with RESTful Web Services on the 
	client side. You can use it to consume a RESTful Web Servicer very easily as shown in this example.

What is an HttpMessageConverter in Spring REST? (answer)
	An HttpMessageConverter is a Strategy interface that specifies a converter that can convert from and to HTTP requests and
	responses. Spring REST uses this interface to convert HTTP response to various formats e.g. JSON or XML.
	Each HttpMessageConverter implementation has one or several MIME Types associated with it. Spring uses the "Accept" header
	to determine the content type client is expecting.
	It will then try to find a registered HTTPMessageConverter that is capable of handling that specific content-type and use
	it to convert the response into that format before sending to the client.

Is REST normally stateless? (answer)
	Yes, REST API should be stateless because it is based on HTTP which is also stateless. A Request in REST API should contain
	all the details required it to process i.e. it should not rely on previous or next request or some data maintained at the
	server end e.g. Sessions. REST specification put a constraint to make it stateless and you should keep that in mind while
	designing your REST API.

What does @RequestMapping annotation do? (answer)
	The @RequestMapping annotation is used to map web requests to Spring Controller methods. You can map request based upon
	HTTP methods  e.g. GET and POST and various other parameters. For examples, if you are developing RESTful Web Service using 
	Spring then you can use produces and consumes property along with media type annotation to indicate that this method is 
	only used to produce or consumers JSON as shown below:
		@RequestMapping (method = RequestMethod.POST, consumes="application/json")
		public Book save(@RequestBody Book aBook) {
		   return bookRepository.save(aBook);
		}
	You can similarly create other handler methods to produce JSON or XML.

What is the difference between @Controller and @RestController?  
	1. The @Controller is a common annotation which is used to mark a class as Spring MVC Controller while @RestController is
	 	a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody.
	2. The @RestController is relatively new, added only on Spring 4.0 but @Controller is an old annotation, exists since 
		Spring started supporting annotation, officially it was added on Spring 2.5 version.
	3. The @Controller annotation indicates that the class is a "Controller" like a web controller while @RestController 
		annotation indicates that the class is a controller where @RequestMapping methods assume @ResponseBody semantics by 
		default i.e. servicing REST API.
	4. The @Controller is a specialization of @Component annotation while @RestController is a specialization of @Controller 
		annotation. It is actually a convenience controller annotated with @Controller and @ResponseBody as shown below.
			
			@Target(value=TYPE)
			@Retention(value=RUNTIME)
			@Documented
			@Controller
			@ResponseBody
			public @interface RestController
			
			and here is how the declaration of @Controller looks like:
			
			@Target(value=TYPE)
			@Retention(value=RUNTIME)
			@Documented
			@Component
			public @interface Controller
	
	5. One of the key difference between @Controler and @RestCotroller in Spring MVC is that once you mark a class 
		@RestController then every method is written a domain object instead of a view. You can see Bryan Hassen's 
		Introduction to Spring MVC 4 to learn more about how to use the @RestController annotation in your Spring-based 
		application.
		
	6. Another key difference between @RestController and @Controller is that you don't need to use @ResponseBody on every
	 	handler method once you annotate the class with @RestController as shown below:
		with @RestControler
	
			@RestController
			public class Book{
			
			@RequestMapping(value={"/book"})
			public Book getBook(){
			//...
			return book;
			}
			}
			
			without @RestController
			
			@Controller
			public class Book{
			
			@RequestMapping(value={"/book"})
			@ResponseBody
			public Book getBook(){
			//...
			return book;
			}
			}
	
	You can see that if you use Spring MVC @Controller annotation to create a RESTful response you need to annotate each 
	method with the @ResponseBody annotation, which is not required when you use @RestController. It not only makes your code 
	more readable but also saves a couple of keystrokes for you.
	
What is @Requestbody and @ResponseBody annotation used for?
	@RequestBody and @ResponseBody annotations are used to bind the HTTP request/response body with a domain object in method
	parameter or return type. Behind the scenes, these annotation uses HTTP Message converters to convert the body of HTTP 
	request/response to domain objects.
	@RequestBody
		If a method parameter is annotated with @RequestBody, Spring will bind the incoming HTTP request body(for the URL 
		mentioned in @RequestMapping for that method) to that parameter. While doing that, Spring will [behind the scenes] use
		HTTP Message converters to convert the HTTP request body into domain object [deserialize request body to domain object]
		, based on Accept header present in request.
		The Accept header is used by HTTP clients [browsers] to tell the server what content types they’ll accept.
		The server sends back the response, which will include a Content-Type header telling the client what the content type
		of the returned content actually is. In case of POST or PUT request, browsers do send data in request, so they actually 
		send content-type as well.
		Take this method for example:
	
			@RequestMapping(value="/user/create", method=RequestMethod.POST)
			public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
			    System.out.println("Creating User "+user.getName());
			     
			    if(userService.isUserExist(user)){
			        System.out.println("A User with name "+user.getName()+" already exist");
			        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			    }
			 
			    userService.saveUser(user);
			     
			    HttpHeaders headers = new HttpHeaders();
			    headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}
	This is the controller method to handle typical HTTP Post request [for URL /user/create]. In a pure REST oriented approach, 
	this controller method creates a user, and returns the HTTP 201[CREATED] along with a LocationHeader containing the 
	locations of newly created user [/app-address/user/1 e.g].
	Now back to our original discussion, HTTP Post request body contains the detail of user to be created. When a client sends 
	a request [/user/create] to create a user, it will be intercepted in this method. Method parameter user is marked with 
	@RequestBody annotation. Thanks to this annotation, Spring will try to bind the request body [which can be JSON/XML/Other] 
	to user object[ Means crating a new user object with the details found in the request body like user name,age etc..], based 
	on Content-Type header in Http request.
	But Spring need help to convert the request body into user object. It needs a converter which can convert the data in HTTP 
	request body [which can be JSON/XML/Other] into user object.
	Spring provides out-of-box many default HttpMessageConverters, which will be used for conversion, depending on presence of 
	certain library in project classpath.
	For example, if the Content-Type in request Header was one of application/json or application/xml , that means the POST 
	body contains json or XML[Popular formats], and if Jackson library is found in your classpath, Spring will delegate the 
	conversion to MappingJackson2HttpMessageConverter [for json] or MappingJackson2XmlHttpMessageConverter [for xml].
	To declare a dependency to Jackson library (jackson-databind) include following dependency in your pom.xml
			<dependency>
			    <groupId>com.fasterxml.jackson.core</groupId>
			    <artifactId>jackson-databind</artifactId>
			    <version>${jackson.version}</version>
			</dependency>
	ResponseEntity (used in above example) represents the entire HTTP response. Good thing about it is that you can control 
	anything that goes into it. You can specify status code, headers, and body. Next post goes into details of it with a fully 
	working example.
	
	@ResponseBody
		If a method is annotated with @ResponseBody, Spring will bind the return value to outgoing HTTP response body. While 
		doing that, Spring will [behind the scenes] use HTTP Message converters to convert the return value to HTTP response 
		body [serialize the object to response body], based on Content-Type present in request HTTP header.
		Take this method for example:
		@RequestMapping(value = "/user/all", method = RequestMethod.GET)
		public @ResponseBody List<User> listAllUsers() {
		    return userService.findAllUsers();
		}
		This is the controller method to handle typical HTTP GET request [for URL /user/all] to retrieve all users. In this 
		case, Spring will convert the user list into appropriate format [JSON/XML/Other] using available converters, based on 
		content type.
		NOTE : As from Spring 4, @RestController is the preferred way to achieve the same functionality earlier provided by @ResponseBody. Under the hood, @RestController is @Controller+@ResponseBody, and it avoids the need of prefixing every method with @ResponseBody. Next post goes into details with a full working example.

When do you need @ResponseBody annotation in Spring MVC? (answer)
	The @ResponseBody annotation can be put on a method to indicates that the return type should be written directly to the 
	HTTP response body (and not placed in a Model, or interpreted as a view name).
	For example:
	
	@RequestMapping(path = "/hello", method = RequestMethod.PUT)
	@ResponseBody
	public String helloWorld() {
	   return "Hello World";
	}
	
	Alternatively, you can also use @RestController annotation instead of @Controller annotation. This will remove the need for
	using @ResponseBody because as discussed in the previous answer, it comes automatically with @RestController annotation

Difference between @PathVariable and @RequestParam in Spring
	Now that we understand both the difference as well as how to use both @RequestParam and @PathVariable in Spring MVC 
	application, let's revise the critical difference between them from an interview perspective.
	1) The @RequestParam is used to extract query parameters while @PathVariable is used to extract data right from the URI.
	2) @RequestParam is more useful on a traditional web application where data is mostly passed in the query abatements while 
		@PathVariable is more suitable for RESTful web services where URL contains values,
		e.g. http://localhost:8080/book/9783827319333, 
		here data, which is ISBN number is part of URI.
	3) @RequestParam annotation can specify default values if a query parameter is not present or empty by using a defaultValue 
		attribute, provided the required attribute is false.
	4) Spring MVC allows you to use multiple @PathVariable annotations in the same method, provided, no more than one argument 
		has the same pattern.
		
		@RequestMapping(value="/book/{ISBN}", method= RequestMethod.GET)
		public String showBookDetails(@PathVariable("ISBN") String id,
		                              Model model){
		   model.addAttribute("ISBN", id);
		   return "bookDetails";
		}
		
		
		URL: http://localhost:8080/eportal/trades?tradeId=2001

		@RequestMapping("/trades")
		public String showTradeDetails(@RequestParam String tradeId,
		                               Model model){
		  model.addAttribute("tradeId", tradeId);
		  return "tradeDetails";
		}

		Example : 
			@RequestMapping(value="/order/{orderId}/receipts", method = RequestMethod.GET)
			public List listUsersInvoices(@PathVariable("orderId") int order,
			 @RequestParam(value = "date", required = false) Date dateOrNull) {
			...
			}
			The required=false denotes that the query parameter can be optional, but the URL must have the same URI.

Where do you need @EnableWebMVC? (answer)
	The @EnableWebMvc annotation is required to enable Spring MVC when Java configuration is used to configure Spring MVC 
	instead of XML. It is equivalent to <mvc: annotation-driven>  in XML configuration.
	It enables support for @Controller-annotated classes that use @RequestMapping to map incoming requests to handler methods 

When do you need @ResponseStatus annotation in Spring MVC? (answer)
	A good questions for 3 to 5 years experienced spring developers. The @ResponseStatus annotation is required during error 
	handling in Spring MVC and REST. Normally when an error or exception is thrown at server side, web server return a blanket 
	HTTP status code 500 - Internal server error.
	This may work for a human user but not for REST clients. You need to send them proper status code e.g. 404 if the resource 
	is not found. That's where you can use @ResponseStatus annotation, which allows you to send custom HTTP status code along 
	with proper error message in case of Exception.
	In order to use it, you can create custom exceptions and annotated them using @ResponseStatus annotation and proper HTTP 
	status code and reason.
	When such exceptions are thrown from controller's handler methods and not handled anywhere else, then appropriate HTTP 
	response with the proper HTTP status code, which you have set is sent to the client.
	For example, if you are writing a RESTful Web Service for a library which provides book information then you can use 
	@ResponseStatus to create Exception which returns HTTP response code 404 when a book is not found instead of Internal 
	Server Error (500), as shown below:
	
	 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Book")  // 404
	 public class BookNotFoundException extends RuntimeException {
	     // ...
	 }
	If this Exception is thrown from any handler method then HTTP error code 404 with reason "No such Book" will be returned to
	the client.

Do you need Spring MVC in your classpath for developing RESTful Web Service? (answer)
	This question is often asked to Java programmers with 1 to 2 years of experience in Spring. Short answer is Yes, you need 
	Spring MVC in your Java application's classpath to develop RESTful web services using Spring framework. It's actually 
	Spring MVC which provides all useful annotations e.g. @RestController, @ResponseCode, @ResponseBody, @RequestBody, and 
	@PathVariable, hence you must spring-mvc.jar or appropriate Maven entry in your pom.xml

Does REST work with transport layer security (TLS)? (answer)
	TLS or Transport Layer Security is used for secure communication between client and server. It is the successor of SSL (Secure Socket Layer). Since HTTPS can work with both SSL and TLS, REST can also work with TLS.

Is REST secure? What can you do to secure it? (answer)
	This question is mostly asked with experienced Java programmers e.g. 2 to 5 years experience with both REST and Spring. 
	Security is a broad term, it could mean security of message which is provided by encryption or access restriction which is 
	provided using authentication and authorization. REST is normally not secure but you can secure it by using Spring security.
	At the very least you can enable HTTP basic authentication by using HTTP in your Spring security configuration file. 
	Similarly, you can expose your REST API using HTTPS if the underlying server supports HTTPS.


*/
public class Rest {

}
