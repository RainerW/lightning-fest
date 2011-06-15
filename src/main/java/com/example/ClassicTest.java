package com.example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import com.example.backend.Backend;
import com.example.backend.Result;

public class ClassicTest
{
  // ### The SUT
  Backend sut = new Backend();

  /****************************************************
   * Test 1
   ****************************************************/
  @Test
  public void numberExactMatch()
  {
    // execute
    Integer number = sut.getANumber();

    // verify
    assertThat(number, is(not(nullValue())));
    assertThat(number, is(23));
    assertThat(number, describedAs("returned Value", is(23)));
    assertThat(number, is(not(22)));
  }

  /****************************************************
   * Test 2
   ****************************************************/
  @Test
  public void listTest()
  {
    // execute
    List<Result> values = sut.getAList();

    // verify
    // ## Typ Abhängige Asserts
    assertThat(values, hasSize(3));
    assertThat(values, hasItem(new Result("rainer")));
    assertThat(values, contains(new Result("rainer"), new Result("text"),new Result("dummy")));
    // ## onProperty
  }

  /****************************************************
   * Test 3
   ****************************************************/
  @Test
  public void numberRangeMatch()
  {
    // execute
    int number = sut.getANumber();

    // verify
    assertThat(number, between(10, 90));

  }

  /****************************************************
   * My Own Matcher
   ****************************************************/
  private Matcher<Integer> between(final int min, final int max)
  {
    return new TypeSafeMatcher<Integer>()
    {
      @Override
      public void describeTo(Description description)
      {
      }

      @Override
      protected boolean matchesSafely(Integer value)
      {
        return value > min && value < max;
      }
    };
  }
}
