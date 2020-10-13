# spring-test

# spring-test-annotations

**1. Class level annotations**
**@RunWith vs @ExtendWith:**
- In JUnit 5, the @RunWith annotation has been replaced by the more powerful @ExtendWith annotation.
- However, the @RunWith annotation can still be used in JUnit5 for the sake of the backward compatibility.
- @RunWith(SpringJUnit4ClassRunner.class) and @RunWith(SpringRunner.class): SpringRunner is an alias for the SpringJUnit4ClassRunner.
**@Mockito.mock() vs Mock vs @MockBean:** 
- @Mock is a shorthand for the Mockito.mock() method. As well, we should only use it in a test class. Unlike the mock() method, we need to enable Mockito annotations to use this annotation. Apart from making the code more readable, @Mock makes it easier to find the problem mock in case of a failure, as the name of the field appears in the failure message
- We can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context. If no bean of the same type is defined, a new one will be added. This annotation is useful in integration tests where a particular bean – for example, an external service – needs to be mocked.
- Note that to enable Mockito annotations during test executions, the MockitoAnnotations.initMocks(this) static method has to be called.
To avoid side effect between tests, it is advised to do it before each test execution :

@Before 
public void initMocks() {
    MockitoAnnotations.initMocks(this);
}

Another way to enable Mockito annotations is annotating the test class with @RunWith by specifying the MockitoJUnitRunner that does this task and also other useful things :

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public MyClassTest{...}
- If your test needs to rely on the Spring Boot container and you want also to add or mock one of the container beans : @MockBean from Spring Boot is the way.


**@SpringBootTest:**
- Adding Auto-Configurations, @AutoConfigureMockMvc, ...  
- Setting Custom Configuration Properties, @SpringBootTest(properties = "foo=bar")
- Externalizing Properties with @ActiveProfiles, @ActiveProfiles("test")
- Setting Custom Properties with @TestPropertySource, @TestPropertySource(locations = "/foo.properties")
- Injecting Mocks with @MockBean
- Adding Beans with @Import, @Import(other.namespace.Foo.class)
- Creating a Custom @SpringBootApplication, @SpringBootTest(classes = CustomApplication.class) and @ConditionalOnProperty

**@WebMvcTest:**
- @SpringBootTest is the general test annotation. If you're looking for something that does the same thing prior to 1.4, that's the one you should use. It does not use slicing at all which means it'll start your full application context and not customize component scanning at all.

- @WebMvcTest is only going to scan the controller you've defined and the MVC infrastructure. That's it. So if your controller has some dependency to other beans from your service layer, the test won't start until you either load that config yourself or provide a mock for it. This is much faster as we only load a tiny portion of your app. This annotation uses slicing.

---
https://reflectoring.io/spring-boot-test/
https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/

**other:**
- @AutoConfigureMockMvc
- @ActiveProfiles
- @TestPropertySource
- @Import
- @AutoConfigureTestEntityManager
- @ContextConfiguration
