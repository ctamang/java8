package InterviewQuestions;


/*
 * 
1. What is bean factory?
 	The BeanFactory is the actual container which instantiates, configures, and manages a number of beans. These beans typically 
 	collaborate with one another, and thus have dependencies between themselves. These dependencies are reflected in the configuration 
 	data used by the BeanFactory.
 	
 	How to Create XmlBeanFactory
		Resource resource = new FileSystemResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		ClassPathResource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		

2. WHat is application context ?
	The ApplicationContext builds on top of the BeanFactory (it's a subclass) and adds other functionality such as easier integration 
	with Springs AOP features, message resource handling (for use in internationalization), event propagation, declarative mechanisms 
	to create the ApplicationContext and optional parent contexts, and application-layer specific contexts such as the 
	WebApplicationContext, among other enhancements.
	The most commonly used ApplicationContext implementations are:

		(i). FileSystemXmlApplicationContext – This container loads the definitions of the beans from an XML file. Here you need to 
			provide the full path of the XML bean configuration file to the constructor.
		(ii). ClassPathXmlApplicationContext – This container loads the definitions of the beans from an XML file. Here you do not 
			need to provide the full path of the XML file but you need to set CLASSPATH properly because this container will look 
			bean configuration XML file in CLASSPATH.
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
	Normally when building most applications in a J2EE-environment, the best option is to use the ApplicationContext, since it offers 
	all the features of the BeanFactory and adds on to it in terms of features, while also allowing a more declarative approach to use 
	of some functionality, which is generally desirable. The main usage scenario when you might prefer to use the BeanFactory is when 
	memory usage is the greatest concern (such as in an applet where every last kilobyte counts), and you don't need all the features
	of the ApplicationContext.
 
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
	While practically, most spring beans have no mutable state, and as such are trivially thread safe. But if your bean has mutable 
	state, so you need to ensure thread safety. The most easy and obvious solution for this problem is to change bean scope of 
	mutable beans from “singleton” to “prototype“.

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
 	Combining together beans within the Spring container is known as bean wiring or wiring. When wiring beans, you should tell the 
 	container what beans are needed and how the container should use dependency injection to tie them together.
 	
9. what is sprint mvc?
	A Spring MVC is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern. It 
	implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.
	A Spring MVC provides an elegant solution to use MVC in spring framework by the help of DispatcherServlet. Here, DispatcherServlet 
	is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.

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
	 SpringIOC container is also responsible for managing the Spring Bean Life Cycle, the life cycle of beans consist of call back methods such as Post initialization call back method and Pre destruction call back method. Below steps are followed by Spring IoC Container to manage bean life cycle.
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
		(ii). It is called IoC because control of the object is inverted. It is not the programmer, but someone else who controls the object.
		(ii). IoC is relative in the sense that it only applies to some objects of the application. So there may be IoC for some 
			objects, whereas others are under the direct control of the programmer.
	Apart from Spring, there are other examples of IoC like Java Servlets and Akka Actors.
	Here is a quick summary of the ideas discussed so far:
		1. IoC containers control and manage the lifecycle of some objects: creation, destruction, and callback invocations.
		2. The programmer must identify the classes whose instances are to be managed by the IoC container. There are several ways 
			to do this: with annotations, by extending some specific classes, using external configuration.
		3. The programmer can influence, to some extent, the way the objects are managed by the IoC container. Normally, this is 
			achieved by overriding the default behavior of the object callbacks.

18. What is difference between singleton and prototype bean?
	Prototype scope = A new object is created each time it is injected/looked up. It will use new SomeClass() each time.
	Singleton scope = (Default) The same object is returned each time it is injected/looked up. Here it will instantiate one instance 
					of SomeClass and then return it each time.
					
19. What are the different types of Injection in spring?
	There are three types of Injection in spring:
		(i). Setter Injection
		(ii). Constructor Injection
		(iii). Getter or Method Injection

21. What is ORM?
	Object-relational-mapping is the idea of being able to write queries like the one above, as well as much more complicated ones, 
	using the object-oriented paradigm of your preferred programming language.
	Long story short, we are trying to interact with our database using our language of choice instead of SQL.

21. What are ORM integration modules?
	Object/relational mapping (ORM) tool is supported by Spring over straight JDBC by implementing the ORM module. Spring can join 
	various important ORM frameworks, including JDO, iBATIS SQL Maps and Hibernate.
	
22. What is XMLBeanFactory?
	Spring includes several applications of Bean factory. Out of these, org.springframework.beans.factory.xml.XmlBeanFactory is a 
	very important one. It loads the beans on the basis of the definitions stored in an XML file. For the creation of an 
	XmlBeanFactory, a java.io.InputStream is passed to the constructor. The InputStream provides the XML to the factory. For example, 
	for retrieval of the bean, the getBean() method is called by passing the name of the desired bean.
	MyBean helloBean = (MyBean) factory.getBean("helloBean");
	
23. What is Aspect ?
	The class which implements the JEE application cross-cutting concerns(transaction, logger etc) is known as the aspect. It can be 
	normal class configured through XML configuration or through regular classes annotated with @Aspect.

24. What is Pointcut?
	Since it is not feasible to apply advice at every point of the code, therefore, the selected join points where advice 
	is finally applied are known as the Pointcut. Often you specify these pointcuts using explicit class and method names or through 
	regular expressions that define a matching class and method name patterns. It helps in reduction of repeating code by writing 
	once and use at multiple points.
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
		b. After: Runs after the advised method completes regardless of the outcome, whether successful or not. It is denoted by 
			@After annotation.
		c. AfterReturning: Runs after the advised method successfully completes ie without any runtime exceptions. It is denoted by 
			@AfterReturning annotation.
		d. Around: This is the strongest advice among all the advice since it wraps around and runs before and after the advised 
			method. This type of advice is used where we need frequent access to a method or database like- caching. It is denoted 
			by @Around annotation.
		e. AfterThrowing: Runs after the advised method throws a Runtime Exception. It is denoted by @AfterThrowing annotation.
		
26. What is JointPoint?
	An application has thousands of opportunities or points to apply Advice. These points are known as join points. For example – 
	Advice can be applied at every invocation of a method or exception be thrown or at various other points. But Spring AOP 
	currently supports only method execution join points (advising the execution of methods on Spring beans).
	
27. What is Weaving?
	The process of linking Aspects with an Advised Object. It can be done at load time, compile time or at runtime time. Spring AOP 
	does weaving at runtime.
 * 
 */
public class Spring {

}
