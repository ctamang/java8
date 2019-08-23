package interviewQuestions;


/*
 * 
1. What is bean factory?
 	The BeanFactory is the actual container which instantiates, configures, and manages a number of beans. These beans typically 
 	collaborate with one another, and thus have dependencies between themselves. These dependencies are reflected in the 
 	configuration data used by the BeanFactory.
 	
 	How to Create XmlBeanFactory
		Resource resource = new FileSystemResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		ClassPathResource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		

2. WHat is application context ?
	The ApplicationContext builds on top of the BeanFactory (it's a subclass) and adds other functionality such as easier 
	integration with Springs AOP features, message resource handling (for use in internationalization), event propagation, 
	declarative mechanisms to create the ApplicationContext and optional parent contexts, and application-layer specific 
	contexts such as the WebApplicationContext, among other enhancements.
	The most commonly used ApplicationContext implementations are:

		(i). FileSystemXmlApplicationContext – This container loads the definitions of the beans from an XML file. Here you need to 
			provide the full path of the XML bean configuration file to the constructor.
		(ii). ClassPathXmlApplicationContext – This container loads the definitions of the beans from an XML file. Here you 
		    do not need to provide the full path of the XML file but you need to set CLASSPATH properly because this container will 
			look bean configuration XML file in CLASSPATH.
		(iii). WebXmlApplicationContext – This container loads the XML file with definitions of all beans from within a web 
			application.	
	How to create ApplicationContext
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");			
 
3 . Difference b/w beanFactory and applicationContext?
 	the BeanFactory provides the configuration framework and basic functionality, while the ApplicationContext adds enhanced 
 	capabilities to it, some of them perhaps more J2EE and enterprise-centric. In general, an ApplicationContext is a complete 
 	superset of a BeanFactory, and any description of BeanFactory capabilities and behavior should be considered to apply to 
 	ApplicationContexts as well.
	Users are sometimes unsure whether a BeanFactory or an ApplicationContext are best suited for use in a particular situation. 
	Normally when building most applications in a J2EE-environment, the best option is to use the ApplicationContext, since it 
	offers all the features of the BeanFactory and adds on to it in terms of features, while also allowing a more declarative 
	approach to use of some functionality, which is generally desirable. The main usage scenario when you might prefer to use 
	the BeanFactory is when memory usage is the greatest concern (such as in an applet where every last kilobyte counts), and 
	you don't need all the features
	of the ApplicationContext.
	Differences:
		1) BeanFactory doesn't provide support for internationalization i.e. i18n but ApplicationContext provides support for it.
		2) Another difference between BeanFactory vs ApplicationContext is ability to publish event to beans that are 
			registered as listener.
		3) One of the popular implementation of BeanFactory interface is XMLBeanFactory while one of the popular implementation
		 	of ApplicationContext interface is ClassPathXmlApplicationContext. On Java web application we use 
		 	WebApplicationContext  which extends ApplicationContext interface and adds getServletContext method.
		4) If you are using auto wiring and using BeanFactory than you need to register AutoWiredBeanPostProcessor using API
		 	which you can configure in XML if you are using  ApplicationContext. In summary BeanFactory is OK for testing and
		 	non production use but ApplicationContext is more feature rich container implementation and should be favored over
		 	BeanFactory


Read more: https://javarevisited.blogspot.com/2012/11/difference-between-beanfactory-vs-applicationcontext-spring-framework.html#ixzz5vPJiQfrJ
 
4. What is spring IOC Container ? 
	The Spring IoC container is at the core of the Spring Framework. The container will create the objects, wire them together, 
	configure them, and manage their complete life cycle from creation till destruction. The Spring container uses dependency 
	injection (DI) to manage the components that make up an application.
	Spring provides following two distinct types of containers.
		(i). BeanFactory container
		(ii).  ApplicationContext container
 
5. What is the default scope of bean in Spring framework?
	The default scope of bean is Singleton for Spring framework.
	
6. Is Singleton beans are thread safe in Spring Framework?
	No, singleton beans are not thread-safe in Spring framework.
	Spring framework does not do anything under the hood concerning the multi-threaded behavior of a singleton bean. It is the 
	developer’s responsibility to deal with concurrency issue and thread safety of the singleton bean.
	While practically, most spring beans have no mutable state, and as such are trivially thread safe. But if your bean has 
	mutable state, so you need to ensure thread safety. The most easy and obvious solution for this problem is to change bean 
	scope of mutable beans from “singleton” to “prototype“.

 7.What are the benefits of Spring Framework?
	Following are the benefits of Spring framework:
		Extensive usage of Components
		Reusability
		Decoupling
		Reduces coding effort by using pattern implementations such as singleton, factory, service locator etc.
		Removal of leaking connections
		Declarative transaction management
		Easy to integrate with third party tools and technologies.
 
8. What is bean wiring?
 	Combining together beans within the Spring container is known as bean wiring or wiring. When wiring beans, you should tell 
 	the container what beans are needed and how the container should use dependency injection to tie them together.
 	
9. what is sprint mvc?
	A Spring MVC is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern.
	It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.
	A Spring MVC provides an elegant solution to use MVC in spring framework by the help of DispatcherServlet. Here, 
	DispatcherServlet is a class that receives the incoming request and maps it to the right resource such as controllers, 
	models, and views.

10. Name the various modules used in spring framework?
		AOP module (Aspect Oriented Programming)
		JDBC abstraction and DAO module
		The Core container module
		MVC framework module
		Application context module
		O/R mapping integration module (Object/Relational)
		Web module
		
11. What is AOP?
	In computing, aspect-oriented programming (AOP) is a programming paradigm that aims to increase modularity by allowing the 
	separation of cross-cutting concerns. It does so by adding additional behavior to existing code (an advice) without modifying the 
	code itself, instead separately specifying which code is modified via a "pointcut" specification, such as "log all function calls 
	when the function's name begins with 'set'". This allows behaviors that are not central to the business logic (such as logging) 
	to be added to a program without cluttering the code, core to the functionality. AOP forms a basis for aspect-oriented software 
	development. 

12. what do you mean by cross cutting concerns?
	The crosscutting concern is a concern which is applicable throughout the application and it affects the entire application. For 
	example: logging, security and data transfer are the concerns which are needed in almost every module of an application, 
	hence they are cross-cutting concerns.
	
13. What is a BeanFactory Interface?
	Bean factory interface is used to provide configuration framework for object creation and basic functionality around object 
	management.
	
14. What is Auto Wiring?
	Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or 
	constructor injection. Autowiring can't be used to inject primitive and string values. It works with reference only.
	
15. What are the different Modes of Autowiring?
	Autowiring has five different modes:
		no: no autowire
		byName : Autowiring that can be done by property name
		byType : property type as autowired
		constructor: It is similar to byType and it is property is in constructor
		autodetect : Spring is allowed to select autowiring from byType or constructor	
	
	
16. What are the methods of bean life cycle?
	 SpringIOC container is also responsible for managing the Spring Bean Life Cycle, the life cycle of beans consist of 
	 callback methods such as Post initialization call back method and Pre destruction call back method. Below steps are 
	 followed by Spring IoC Container to manage bean life cycle.
		Spring Bean Life Cycle :
			Creation of bean instance by a factory method. 
			Set the values and bean references to the bean properties.
			Call the initialization call back method.
			Bean is ready for use.
			Call the destruction call back method.
	
	(i). init-method and destroy-method Attributes in the Configuration file		
	(ii). Using @PostConstruct and @PreDestroy Annotations	
	
17. What is IOC?		
	IoC is when you have someone else create objects for you.” So instead of writing “new MyObject” in your code, the object is 
	created by someone else. This ‘someone else’ is normally referred to as an IoC container.
		(ii). It is called IoC because control of the object is inverted. It is not the programmer, but someone else who 
			  controls the object.
		(ii). IoC is relative in the sense that it only applies to some objects of the application. So there may be IoC for 
		      some objects, whereas others are under the direct control of the programmer.
	Apart from Spring, there are other examples of IoC like Java Servlets and Akka Actors.
	Here is a quick summary of the ideas discussed so far:
		1. IoC containers control and manage the lifecycle of some objects: creation, destruction, and callback invocations.
		2. The programmer must identify the classes whose instances are to be managed by the IoC container. There are several 
			ways to do this: with annotations, by extending some specific classes, using external configuration.
		3. The programmer can influence, to some extent, the way the objects are managed by the IoC container. Normally, this 
			is achieved by overriding the default behavior of the object callbacks.

18. What is difference between singleton and prototype bean?
	Prototype scope = A new object is created each time it is injected/looked up. It will use new SomeClass() each time.
	Singleton scope = (Default) The same object is returned each time it is injected/looked up. Here it will instantiate one 
						instance of SomeClass and then return it each time.
					
19. What are the different types of Injection in spring?
	There are three types of Injection in spring:
		(i). Setter Injection
		(ii). Constructor Injection
		(iii). Getter or Method Injection

21. What is ORM?
	Object-relational-mapping is the idea of being able to write queries like the one above, as well as much more complicated 
	ones, using the object-oriented paradigm of your preferred programming language.
	Long story short, we are trying to interact with our database using our language of choice instead of SQL.

21. What are ORM integration modules?
	Object/relational mapping (ORM) tool is supported by Spring over straight JDBC by implementing the ORM module. Spring can 
	join various important ORM frameworks, including JDO, iBATIS SQL Maps and Hibernate.
	
22. What is XMLBeanFactory?
	Spring includes several applications of Bean factory. Out of these, org.springframework.beans.factory.xml.XmlBeanFactory is a 
	very important one. It loads the beans on the basis of the definitions stored in an XML file. For the creation of an 
	XmlBeanFactory, a java.io.InputStream is passed to the constructor. The InputStream provides the XML to the factory. For 
	example, for retrieval of the bean, the getBean() method is called by passing the name of the desired bean.
	MyBean helloBean = (MyBean) factory.getBean("helloBean");
	
23. What is Aspect ?
	The class which implements the JEE application cross-cutting concerns(transaction, logger etc) is known as the aspect. It 
	can be normal class configured through XML configuration or through regular classes annotated with @Aspect.

24. What is Pointcut?
	Since it is not feasible to apply advice at every point of the code, therefore, the selected join points where advice 
	is finally applied are known as the Pointcut. Often you specify these pointcuts using explicit class and method names or 
	through regular expressions that define a matching class and method name patterns. It helps in reduction of repeating code 
	by writing once and use at multiple points.
	@Pointcut("execution(public void com.aspect.ImplementAspect.aspectCall())") // line 1 
    public void pointCut() { } 
    
    @Before("pointcut()") 
    public void loggingAdvice1() 
    { 
        System.out.println("Before advice is executed"); 
    } 
	
25. What is Advice?.
	The job which is meant to be done by an Aspect or it can be defined as the action taken by the Aspect at a particular point. 
	There are five types of Advice namely: Before, After, Around, AfterThrowing and AfterReturning. Let’s have a brief discussion 
	about all the five types.
		a. Before: Runs before the advised method is invoked. It is denoted by @Before annotation.
		b. After: Runs after the advised method completes regardless of the outcome, whether successful or not. It is denoted 
			by @After annotation.
		c. AfterReturning: Runs after the advised method successfully completes ie without any runtime exceptions. It is 
			denoted by @AfterReturning annotation.
		d. Around: This is the strongest advice among all the advice since it wraps around and runs before and after the 
			advised method. This type of advice is used where we need frequent access to a method or database like- caching. 
			It is denoted by @Around annotation.
		e. AfterThrowing: Runs after the advised method throws a Runtime Exception. It is denoted by @AfterThrowing annotation.
		
26. What is JointPoint?
	An application has thousands of opportunities or points to apply Advice. These points are known as join points. For example – 
	Advice can be applied at every invocation of a method or exception be thrown or at various other points. But Spring AOP 
	currently supports only method execution join points (advising the execution of methods on Spring beans).
	
27. What is Weaving?
	The process of linking Aspects with an Advised Object. It can be done at load time, compile time or at runtime time. Spring AOP 
	does weaving at runtime.
	
28. What is the difference b/w setter and constructor injection?
	Partial dependency:
		In Setter Injection, partial injection of dependencies can possible, means if we have 3 dependencies like int, string, long, then its not necessary to inject all values if we use setter injection. If you are not inject it will takes default values for those primitives.
		In Constructor injection, partial injection of dependencies cannot possible, because for calling constructor we must pass all the arguments right, if not so we may get error.
	
	Overriding:
		Setter Injection will overrides the constructor injection value, provided if we write setter and constructor injection for the same property.
		But, constructor injection cannot overrides the setter injected values.
	
	Number of dependencies:
		If we have more dependencies for example 15 to 20 are there in our bean class then, in this case setter injection is not recommended as we need to write almost 20 setters right, bean length will increase.
		In this case, Constructor injection is highly recommended, as we can inject all the dependencies with in 3 to 4 lines by calling one constructor.
	
	Changes:
		Setter injection makes bean class object as mutable. (We can easily change the value by setter injection)
		Constructor injection makes bean class object as immutable. (We cannot change the value by Constructor injection)
 
 29. Explain how to implement Spring bean life cycle in Spring?
 	 Spring framework provides following 4 ways for controlling life cycle events of a bean:
		1. 	InitializingBean and DisposableBean callback interfaces
 		2. 	*Aware interfaces for specific behavior
 		3.	Custom init() and destroy() methods in bean configuration file
		4.  @PostConstruct and @PreDestroy annotations
 
 	3. Custom init() and destroy() methods in bean configuration file
 		The default init and destroy methods in bean configuration file can be defined in two ways:
			Bean local definition applicable to a single bean
			Global definition applicable to all beans defined in beans context
 		***************************
 			beans.xml
			<beans>
    					<bean id="demoBean" class="com.howtodoinjava.task.DemoBean"
                    init-method="customInit"
                    destroy-method="customDestroy"></bean>
			</beans>
 		***************************	
 		package com.howtodoinjava.task;
		public class DemoBean
		{
		    public void customInit()
		    {
		        System.out.println("Method customInit() invoked...");
		    }
		 
		    public void customDestroy()
		    {
		        System.out.println("Method customDestroy() invoked...");
		    }
		}
		*****************************
		GLOBAL Definition
		******************************
			<beans default-init-method="customInit" default-destroy-method="customDestroy">  
        			<bean id="demoBean" class="com.howtodoinjava.task.DemoBean"></bean>
			</beans>
		******************************	
	4. Spring Bean Life Cycle – @PostConstruct and @PreDestroy annotations
		*****************************
		Spring 2.5 onwards, you can use annotations also for specifying life cycle methods using @PostConstruct and @PreDestroy annotations.
			@PostConstruct annotated method will be invoked after the bean has been constructed using default constructor and 
							just before it’s instance is returned to requesting object.
			@PreDestroy annotated method is called just before the bean is about be destroyed inside bean container.
		Java program to show usage of annotation configuration to control using annotations.
		******************************
		package com.howtodoinjava.task;
		import javax.annotation.PostConstruct;
		import javax.annotation.PreDestroy;
		public class DemoBean
		{
		    @PostConstruct
		    public void customInit()
		    {
		        System.out.println("Method customInit() invoked...");
		    }
		    @PreDestroy
		    public void customDestroy()
		    {
		        System.out.println("Method customDestroy() invoked...");
		    }
		}
		******************************
30. What is Dependency Injection?
		Dependency injection is basically providing the objects that an object needs (its dependencies) instead of having it 
		construct them itself. It's a very useful technique for testing, since it allows dependencies to be mocked or stubbed 
		out.
		Dependencies can be injected into objects by many means (such as constructor injection or setter injection). One can
		even use specialized dependency injection frameworks (e.g. Spring) to do that, but they certainly aren't required. You
		don't need those frameworks to have dependency injection. Instantiating and passing objects (dependencies) explicitly 
		is just as good an injection as injection by framework.
		
31. Difference b/w @inject and @autowired annotation?
		If you have worked with Hibernate and JPA in past then JSR-330 annotation is nothing but like JPA annotations which 
		standardize the Object-Relational mapping across the framework. When you use the JPA annotations like @Entity, your 
		code will not only work on Hibernate but also on other ORM tools and framework e.g. TopLink.
		Btw, like all similar things in the world, even though both @Autowired and @Inject serve the same purpose there are a 
		couple of differences between them, let's examine them briefly
		1) The first and most important difference between @Autowired and @Inject annotation is that the @Inject annotation is 
			only available from Spring 3.0 onwards, so if you want to use annotation-driven dependency injection in Spring 2.5
			then you have to use the @Autowired annotation.
		2) The second difference between these two annotations is that unlike Spring's @Autowired,  the @Inject does require 
			the 'required' attribute.
		3) The third most common difference between @Autowired and @Inject annotation is that former is Spring specific while 
		   	later is the standard for Dependency Injection, specified in JSR-330.
		4) The @Autowired annotation was added on Spring 2.5 and used for annotation-driven dependency injection. It works 
			in conjunction with @Component annotation and <context:component-scan /> to streamline development cycle.
			From Spring 3.0, Spring offers support for JSR-330 dependency injection annotations e.g. @Inject, @Named, and @Singleton. 
			It also added more Spring specific annotations e.g. @Primary, @Lazy, and @DependsOn annotation

32. difference b/w @controller and @restcontroller?	

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
	5. Another key difference between @RestController and @Controller is that you don't need to use @ResponseBody on every
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
33. What is the use of @Qualifier annotation?
	There may be a situation when you create more than one bean of the same type and want to wire only one of them with a 
	property. In such cases, you can use the @Qualifier annotation along with @Autowired to remove the confusion by specifying 
	which exact bean will be wired. Following is an example to show the use of @Qualifier annotation
	You can use @Qualifier along with @Autowired. In fact spring will ask you explicitly select the bean if ambiguous bean 
	type are found, in which case you should provide the qualifier
	For Example in following case it is necessary provide a qualifier
	
		@Component
		@Qualifier("staff") 
		public Staff implements Person {}
		
		@Component
		@Qualifier("employee") 
		public Manager implements Person {}
		
		@Component
		public Payroll {
		    private Person person;
		
		    @Autowired
		    public Payroll(@Qualifier("employee") Person person){
		          this.person = person;
		    }
		}


35.What is DispatcherServlet?
	DispatcherServlet acts as front controller for Spring based web applications. It provides a mechanism for request 
	processing where actual work is performed by configurable, delegate components. It is inherited from 
	javax.servlet.http.HttpServlet, it is typically configured in the web.xml file.
	A web application can define any number of DispatcherServlet instances. Each servlet will operate in its own namespace, 
	loading its own application context with mappings, handlers, etc. Only the root application context as loaded by 
	ContextLoaderListener, if any, will be shared. In most cases, applications have only single DispatcherServlet with the 
	context-root URL(/), that is, all requests coming to that domain will be handled by it.
	DispatcherServlet uses Spring configuration classes to discover the delegate components it needs for request mapping, view
	resolution, exception handling etc

36. Can a web application define the multiple instances of DispatcherServlet?
	A web application can define any number of DispatcherServlets. Each servlet will operate in its own namespace, loading its
	own application context with mappings, handlers, etc. Only the root application context as loaded by 
	ContextLoaderListener, if any, will be shared.
	So as long as you map the two Servlets to two different URL patterns, you are all good.

37. How can we call stored procedure from Spring?
	We can use one of the query() method from JdbcTemplate to call stored procedures, or we can extend abstract class 
	StoredProcedure to call stored procedures from Java. In this Java Spring tutorial, we will see second approach to call 
	stored procedure. It's more object oriented, but same time requires more coding. StoredProcedure class allows you to 
	declare IN and OUT parameters and call stored procedure using its various execute() method, which has protected access and 
	can only be called from sub class. I personally prefer to implement StoredProcedure class as Inner class, if its tied up 
	with one of DAO Object.

39. What kind of exceptions can be propagated using exception?
	only unchecked, compiler error happens in case of checked exception propagation.
	
	 class TestExceptionPropagation2{  
	  void m(){  
	    throw new java.io.IOException("device error");//checked exception  
	  }  
	  void n(){  
	    m();  
	  }  
	  void p(){  
	   try{  
	    n();  
	   }catch(Exception e){System.out.println("exception handeled");}  
	  }  
	  public static void main(String args[]){  
	   TestExceptionPropagation2 obj=new TestExceptionPropagation2();  
	   obj.p();  
	   System.out.println("normal flow");  
	  }  
	}  
	Output:Compile Time Error
 
38. What kind of exceptions can be declared using throws keyword?
	only checked exceptions. because :
		unchecked Exception: under your control so correct your code.
		error: beyond your control e.g. you are unable to do anything if there occurs VirtualMachineError or StackOverflowError.
	Advantage of Java throws keyword
		Now Checked Exception can be propagated (forwarded in call stack).
		It provides information to the caller of the method about the exception.
	
	Let's see the example of java throws clause which describes that checked exceptions can be propagated by throws keyword.
	import java.io.IOException;  
	class Testthrows1{  
	  void m()throws IOException{  
	    throw new IOException("device error");//checked exception  
	  }  
	  void n()throws IOException{  
	    m();  
	  }  
	  void p(){  
	   try{  
	    n();  
	   }catch(Exception e){System.out.println("exception handled");}  
	  }  
	  public static void main(String args[]){  
	   Testthrows1 obj=new Testthrows1();  
	   obj.p();  
	   System.out.println("normal flow...");  
	  }  
	}  
 * 
 */
public class Spring {
	
	final Customer c = new Customer("name");

}
