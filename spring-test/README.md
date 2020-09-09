# spring-test

# spring-test-annotations

**1. Class level annotations**
**@RunWith vs @ExtendWith:**
- In JUnit 5, the @RunWith annotation has been replaced by the more powerful @ExtendWith annotation.
- However, the @RunWith annotation can still be used in JUnit5 for the sake of the backward compatibility.
- @RunWith(SpringJUnit4ClassRunner.class) and @RunWith(SpringRunner.class): SpringRunner is an alias for the SpringJUnit4ClassRunner.

**@SpringBootTest:**
- Adding Auto-Configurations
  @SpringBootTest
  @AutoConfigureMockMvc
  class RegisterUseCaseIntegrationTest {
   ...
  }
  
There’s a lot of other auto-configurations available that each add other beans to the application context.
---
- Setting Custom Configuration Properties
@SpringBootTest(properties = "foo=bar")
If the property foo exists in the default setting, it will be overridden by the value bar for this test.
---
- Externalizing Properties with @ActiveProfiles
If many of our tests need the same set of properties, we can create a configuration file application-<profile>.properties or application-<profile>.yml and load the properties from that file by activating a certain profile:

# application-test.yml
foo: bar

@SpringBootTest
@ActiveProfiles("test")
class SpringBootProfileTest {

  @Value("${foo}")
  String foo;

  @Test
  void test(){
    assertThat(foo).isEqualTo("bar");
  }
}
---
- Setting Custom Properties with @TestPropertySource
Another way to customize a whole set of properties is with the @TestPropertySource annotation:

# src/test/resources/foo.properties
foo=bar

@SpringBootTest
@TestPropertySource(locations = "/foo.properties")
class SpringBootPropertySourceTest {

  @Value("${foo}")
  String foo;

  @Test
  void test(){
    assertThat(foo).isEqualTo("bar");
  }
}

All properties from the foo.properties file are loaded into the application context. @TestPropertySource also to configure a lot more.
---
https://reflectoring.io/spring-boot-test/

**other:**
- @AutoConfigureMockMvc
- @ActiveProfiles
- @TestPropertySource
- @Import
- @AutoConfigureTestEntityManager
