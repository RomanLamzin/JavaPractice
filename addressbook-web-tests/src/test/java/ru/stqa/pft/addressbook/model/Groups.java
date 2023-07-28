package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> { // ForwardingSet построение коллекций с рассширенным набором функций

  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate); // копируем новое множество в объект
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }


  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupData group) {
    Groups groups = new Groups(this); // констр который делает копию сущ-го объекта
    groups.add(group); // построенна копия с добавленной группой
    return groups;
  }


  public Groups without(GroupData group) {  // делает копию из которой удалена какая то группа
    Groups groups = new Groups(this); // констр который делает копию сущ-го объекта
    groups.remove(group); // построенна копия с добавленной группой
    return groups;
  }

}
