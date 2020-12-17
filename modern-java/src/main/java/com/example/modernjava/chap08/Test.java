package com.example.modernjava.chap08;

public class Test {
    
    class A {
        private String s;
        public A(String s) {
            this.s = s;
        }
    }
    
    class B extends A{
        private String t;
        public B(String s, String t) {
            super(s);
            this.t = t;
        }
    }

    B b = new B("s", "t");
}
