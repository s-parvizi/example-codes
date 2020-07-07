# clean-code

**Clean Code:**  

**1. FUNDAMENTALS:**
**Names:**
- Choose descriptive and unambiguous names.
- Make meaningful distinction without misinformation.
- Use pronounceable names.
- Use searchable names.
- Replace magic numbers with named constants.
- Avoid encodings. Don't append prefixes or type information.
- if the class or method is used in vast area, use short names, otherwise we can use longer names
  and for variables the scenario is vice versa 

**Functions:**
- Small.  
- Do one thing.  
- Use descriptive names.  
- Prefer fewer arguments.  
- Have no side effects.  
- Don't use flag arguments. Split method into several independent methods that can be called from the client without the flag  
- Number of lines
    - 3 is awesome  
    - 4 is good  
    - 5 is acceptable (max)
    - not more than 10 lines  
- Arguments
    - 0 is perfect  
    - 1 is OK  
    - 2 is acceptable (max)
    - 3 just use if there is no other way (maximum limit)
- Avoid boolean argument  
- Avoid passing null into a function  
- Avoid output argument  
- Use step down rule (public then related privates)  
- Avoid switches cases (cause fan out problem and breaks plugin structure of application)
- Functional Programming (1957, the oldest!!!)
    - Avoid temporal dependency (f.open(); f.process(); f.close();) side effects with passing a block  
    - CQS (Command Query Separation)  
        - Function that returns a value should not change the state (Query)
        - Function that change the state can throw exception, but should not return values (Command)
    - Tell, don't ask
    - Law of Demeter
        - call methods of objects:
            - passed as arguments
            - created locally
            - instance variables
            - globals
        - you may not call methods of objects that are:
            - returned from a previous method call 
- OOP Programming (1962-66)   
- Structured Programming (1967 !!!, the youngest!!!, but some of the ideas started from 1940)
    - Single entry and single exit (it is easy to achieve with short functions)   
- Exception Handling
    - Derive your exceptions from Runtime Exception and do not use checked exceptions
    - Null object pattern (special case pattern), and it's better to check nullity in many places
    - Null is a value (e.g. if we don't find the desired value in the stack) 
    it's better than returning -1, null means nothing 
    - Trying is one thing
        - try should be the most word after variable declaration
        - try body of try block must contain a single line (a function call)
        - the try close or finally must be very last thing, nothing follows them 
        - a function suppose to do one thing and error handling is one thing
        so a function should either do something or should handle errors but it shouldn't do both
    
**Form:**
- Comments:
    - comments are failures
    - comments are lies
    - Good comments: 
        - informative comments
        - clarification and explanation of intent
        - warning of consequences
        - TODO comments
        - Public API documentation (Best documentation is the documentation you don't have to write)
    - Bad comments:
        - Mumbling
        - Redundant explanation
        - Mandated redundancy
        - Journal comments
        - Big banner comments
        - Closing brace comments
        - Attribution comments
        - HTML in comments
        - Non-Local Information
- Explanatory structure (instead of huge amount of comments)
- Formatting (white spaces, communication, getting your code to communicate is more important than getting it to work)
- File size (smaller is better, keep your file sizes small)
- Vertical Formatting
    - one blank line between methods
    - one line to separate method from variables outside
    - one line between public constants and private variables
    - one line between variable definition and other part of a method
    - things that are related to each other should be vertically close to each other
- Horizontal Formatting
    - you never have to scroll to right to see it
    - lines should be less than 100 or 120
- Indentation
    - everybody in the team should use the same rule
- Classes
    - variables should not be appear from the outside of the class
    - minimize using getters and setters, the more getters and setters a class has the less cohesive that class is
    - the less implementation you expose the more opportunity you have to make polymorphic classes
- Data Structures
    - Data structures has public variables without method and class has private variables and public methods
    - Data structures and switch statements are related in the same way that classes and polymorphism are related
    - classes protect us against new types but expose us to new methods. data structures protect us against new methods 
    but expose us to new types
    - is there any way to get protection from both? new methods and new types? expression problem
    solution: design patterns
    - key of independent deployability is to know which form to use and when. 
    - we use classes and objects when its types more likely to be added 
    - we use data structures and switch statements when methods are likely to be added
- Boundaries
- The impedance mismatch (relational data bases and object oriented design, ORM)
      
**TDD:**
- Good tests make change and code cleanup easier
- The Three laws of TDD:
    - write **NO** production code except to pass a failing test
    - write only **enough** of a test to demonstrate a failure
    - write only **enough** production code to pass the test
- Red, Green, Refactor
- You get a better design if you write your tests first
    - you have to design the production code to be accessible from the test     
    - it influences the production code and you write codes that are testable
    - result will be decoupled production codes that are testable nicely
- Codes rots if developers can't change and clean it up during time, and having
good tests make it possible to easily change and cleanup codes
- The tests allow you clean the code, the tests stop the code from rotting
- Good design and architecture cause good flexibility, maintainability and scalability
- Good suit of test makes system more flexible
- If every line of production code was written to make a failing unit test pass, 
then you will trust your test suit
- If you write your tests after the fact, the you will never truest that test suite
- Test Driven Development save time on debugging so it's speed up the development
- The test test the production code and the production code test the test
- If some few changes in the production code cause huge amount of changes on tests then it is something wrong with those tests
- Tests should be well designed like production codes
- When you write tests first, you can trust them, because you write every line of production code is tested
- With test, production code is flexible and without the test production code rots
- The goal of professional development team is that QA will find nothing
- The code should be 100% covered, but 100% is a goal, we should try to achieve

**2. SOLID PRINCIPLES:**
**Foundations:**
- The source code is a document 
- The source code is the design
-  


