package com.example.codecontest.mcquestions;

public class Example1CompilationError {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        // this can cause compilation error
        //b = c;
        newPrint(b);
    }

    public static void newPrint(A a) {
        a.printName();
    }
}

class A {
    public void printName() {
        System.out.println("Value-A");
    }
}

class B extends A {
    public void printName() {
        System.out.println("Value-B");
    }
}

class C extends A {
    public void printName() {
        System.out.println("Value-C");
    }
}