package ru.stqa.pft.sandbox;

public class FirstMethod {

  public static void main(String[] args) {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(7, 9);

    System.out.println("Расстояние между точками примера №1  = " + distance(p1, p2));


    // Пример использования из класса Poin через метод
    System.out.println("Расстояние между точками примера №2 через метод = " + p1.distance(p2));


  }


  // Пример использования из класса FirstMethod
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }




  }
