package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void Dist() {

    Point p4 = new Point(2, 3, 4, 2);

    //assert p4.distancePoint() == 2.23606797749979;

    Assert.assertEquals(p4.distancePoint(), 2.23606797749979);
  }
}
