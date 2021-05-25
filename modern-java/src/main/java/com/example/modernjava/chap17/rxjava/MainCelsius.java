package com.example.modernjava.chap17.rxjava;

import io.reactivex.Observable;
import com.example.modernjava.chap17.TempInfo;

import static com.example.modernjava.chap17.rxjava.TempObservable.getCelsiusTemperatures;

public class MainCelsius {

  public static void main(String[] args) {
    Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
    observable.subscribe(new TempObserver());

    try {
      Thread.sleep(10000L);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
