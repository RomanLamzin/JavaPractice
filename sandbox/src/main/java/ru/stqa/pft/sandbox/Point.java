package ru.stqa.pft.sandbox;

public class Point {

  public double x = 1;
  public double y = 1;


  // Первый конструктор
  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double distance(Point p) {
    return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
  }

}
//A(xa, ya) и B(xb, yb) на плоскости
//AB = √(xb - xa)2 + (yb - ya)2


