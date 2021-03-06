package me.chanjar.section3.noboot2;

import me.chanjar.section2.service.FooService;
import me.chanjar.section2.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 只使用了Spring TestContext Framework。
 * 实际上使用的 DefaultTestContextBootstrapper
 */
@ContextConfiguration(classes = FooServiceImpl.class)
public class FooNoBoot2Test extends AbstractTestNGSpringContextTests {

  @Autowired
  private FooService foo;

  @Test
  public void testPlusCount() throws Exception {
    assertEquals(foo.getCount(), 0);

    foo.plusCount();
    assertEquals(foo.getCount(), 1);
  }

}
