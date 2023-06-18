package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.pft.sandbox.FirstMethod.distance;

public class PointTests {

  @Test
  public void dist() {

    Point p1 = new Point(2, 3);
    Point p2 = new Point(7, 9);

    assert distance(p1,p2) == 7.810249675906654;

   Assert.assertEquals(p1.distance(p2), 7.810249675906654);
  }

  @Test
  public void dist2() {


    Point p3 = new Point(4, 5);
    Point p4 = new Point(9, 9);


    assert distance(p3,p4) == 6.4031242374328485;

    Assert.assertEquals(p3.distance(p4), 6.4031242374328485);
  }





}
