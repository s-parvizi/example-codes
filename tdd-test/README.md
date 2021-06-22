# tdd-test

-Junit  
-Mockito  
-Assertj

Learn how to use different TDD techniques  
Mockito(Fake, Stub, Mock)  
Fake: just mock the object without any data and behavior
Stub: related to data  
Mock: related to behavior  

1. Real object: we can use the real objects inside tests
2. Spy Object: we can use spy objects when we want the real object and just want to stub some of its methods
3. Mock Object: when we want to totally mock the object then based on the case we can behave like fake, stub or mock.

Simply When using Spy all methods are real and then we can decide to change its real behavior if we want,
but in the Mock all methods are fake then we can define behavior for each of them.

