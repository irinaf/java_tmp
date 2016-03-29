package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0)
      //if( app.group().list().size()==0 )                         //     (!app.group().isThereAGroup()) {
      app.group().create(new GroupData().withName("testik2"));
  }


  @Test(dataProvider = "validGroupsFromJson")
  public void groupTestModification(GroupData group) {

    //Set<GroupData> before = app.group().all();
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    //int index=before.size() - 1;

    GroupData groupWithId=group.withId(modifiedGroup.getId());
   // GroupData group = new GroupData().withId(modifiedGroup.getId()).
   //         withName("aaa").withHeader("123").withFooter("test12");
   // app.group().modify(group);
    //Set<GroupData> after = app.group().all();
    app.group().modify(groupWithId);
    assertEquals(app.group().count(), before.size());
    Groups after = app.group().all();

    //before.remove(modifiedGroup);
    //before.add(group);
   /* Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId); */

    // Assert.assertEquals(new HashSet<Object> (before), new HashSet<Object> (after));
    //Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.withOut(modifiedGroup).
            withAdded(group)));

  }


}
