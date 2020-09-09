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
---
https://reflectoring.io/spring-boot-test/

**other:**
- @AutoConfigureMockMvc
- @ActiveProfiles
- @TestPropertySource
- @Import
- @AutoConfigureTestEntityManager
