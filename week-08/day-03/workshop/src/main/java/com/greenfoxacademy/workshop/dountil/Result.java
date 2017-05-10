package com.greenfoxacademy.workshop.dountil;

public class Result {
  private int result;

  public Result(int until, String what) {
    this.result = sum(until);
  }


  public int sum(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n + sum(n - 1);
    }
  }

  public int factorial(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++) {
      fact *= i;
    }
    return fact;
  }

}
