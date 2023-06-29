package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {

  public static void main (String[] args) {

    List<String> languages = new ArrayList<String>();

    languages.add("Java");
    languages.add("JS");
    languages.add("html");

    for (String l : languages) {
      System.out.println("new skill is " + l);
    }

    System.out.println(languages.get(1));

  }
}
