package ru.stqa.pft.sandbox;

public class Point {

  public double x1 = 1;
  public double y1 = 1;

  public double x2 = 1;
  public double y2 = 1;

  // Первый конструктор
  public Point(double x1, double y1) {
    this.x1 = x1;
    this.y1 = y1;

  }

  // Второй конструктор
  public Point(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }




  public double distancePoint() {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

}

//A(xa, ya) и B(xb, yb) на плоскости
//AB = √(xb - xa)2 + (yb - ya)2


