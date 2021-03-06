package me.chanjar.section3.noboot1;

import me.chanjar.section2.service.FooService;
import me.chanjar.section2.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * 没用Spring Boot，只使用了Spring TestContext Framework。
 * 从@SpringBootTest抄来了@BootstrapWith(SpringBootTestContextBootstrapper.class)
 */
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ContextConfiguration(classes = FooServiceImpl.class)
public class FooNoBoot1Test extends AbstractTestNGSpringContextTests {

  @Autowired
  private FooService foo;

  @Test
  public void testPlusCount() throws Exception {
    assertEquals(foo.getCount(), 0);

    foo.plusCount();
    assertEquals(foo.getCount(), 1);
  }

}
