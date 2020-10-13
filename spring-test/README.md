# spring-test

# spring-test-annotations

**1. Class level annotations**
**@RunWith vs @ExtendWith:**
- In JUnit 5, the @RunWith annotation has been replaced by the more powerful @ExtendWith annotation.
- However, the @RunWith annotation can still be used in JUnit5 for the sake of the backward compatibility.
- @RunWith(SpringJUnit4ClassRunner.class) and @RunWith(SpringRunner.class): SpringRunner is an alias for the SpringJUnit4ClassRunner.

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
