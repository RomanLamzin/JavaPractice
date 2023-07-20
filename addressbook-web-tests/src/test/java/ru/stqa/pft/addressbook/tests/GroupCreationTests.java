package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test7", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    //group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId()); // вычесляем макс id
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()); // лямбда-выражение или анонимная функция
    before.sort(byId);
    after.sort(byId);

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    Assert.assertEquals(before, after);  // сравнение по упорядоченному списку
  }


}
