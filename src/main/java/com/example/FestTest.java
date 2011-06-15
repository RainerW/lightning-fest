package com.example;

import static org.fest.assertions.Assertions.*;
import static com.example.tool.MyAssertions.*;

import org.fest.assertions.Condition;
import org.junit.Test;

import com.example.backend.Backend;
import com.example.backend.ResultWithValue;


public class FestTest
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
    assertThat(number).isNotNull();
    assertThat(number).isEqualTo(23);
    assertThat(number).as("returned Value").isEqualTo(23);
    assertThat(number).isNotEqualTo(22);
  }

  /****************************************************
   * Test 2
   ****************************************************/
  @Test
  public void numberRangeMatch()
  {
    // execute
    int number = sut.getANumber();

    // verify
    assertThat(number).isGreaterThan(10).isLessThan(90);
    assertThat(number).is(between(10, 90));
  }

  /****************************************************
   * my own Condition
   ****************************************************/
  private Condition<Integer> between(final int min, final int max)
  {
    return new Condition<Integer>()
    {
      @Override
      public boolean matches(Integer value)
      {
        return value > min && value < max;
      }
    };
  }
  
  /****************************************************
   * Test 3
   ****************************************************/
  @Test
  public void oneResultAssert()
  {
    // execute
    ResultWithValue result= sut.getAResult();

    // verify
    assertThat(result)
          .isNotNull()
          .field("f02").isEqualTo("1")
          .field("f03").isEqualTo("1")
          ; 
  }
  
}
