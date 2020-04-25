# clean-code

**Clean Code:**  

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
        - you may not call methods ob objects that are:
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

**TDD:**

