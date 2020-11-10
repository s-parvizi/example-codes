package com.example.designpatterns.behavioral.iterator;

public interface Iterator {
  boolean hasNext();
  String current();
  void next();
}

