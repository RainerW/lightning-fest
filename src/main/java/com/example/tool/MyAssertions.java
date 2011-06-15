package com.example.tool;

import com.example.backend.ResultWithValue;

public class MyAssertions
{
  public static MyResultAssert assertThat(ResultWithValue result)
  {
    return new MyResultAssert(result);
  }
}
