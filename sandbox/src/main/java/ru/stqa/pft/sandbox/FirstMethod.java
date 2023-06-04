package ru.stqa.pft.sandbox;

public class FirstMethod {

  public static void main(String[] args) {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(7, 9);

    System.out.println("Расстояние между точками примера №1  = " + distance(p1, p2));


    // Пример использования из класса Poin через метод
    Point p3 = new Point(2, 3, 4, 2);

    System.out.println("Расстояние между точками примера №2  = " + p3.distancePoint());

  }


  // Пример использования из класса FirstMethod
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x1 - p1.x1, 2) + Math.pow(p2.y1 - p1.y1, 2));
  }


}

//A(xa, ya) и B(xb, yb) на плоскости
//AB = √(xb - xa)2 + (yb - ya)2