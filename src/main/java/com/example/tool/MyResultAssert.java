package com.example.tool;

import org.fest.assertions.IntAssert;

import com.example.backend.ResultWithValue;
import static org.fest.assertions.Assertions.*;

public class MyResultAssert
{
  ResultWithValue _result;

  public MyResultAssert(ResultWithValue result)
  {
    _result = result;
  }

  public MyResultAssert isNotNull()
  {
    assertThat(_result).isNotNull();
    return this;
  }

  public FieldAssert field(String field)
  {
    String value = _result.getValue(field);
    return new FieldAssert(value);
  }

  public class FieldAssert
  {

    private String _value;

    public FieldAssert(String value)
    {
      _value = value;
    }

    public FieldAssert isEqualTo(String expected)
    {
      assertThat(_value).isEqualTo(expected);
      return this;
    }

    public FieldAssert field(String field)
    {
      return MyResultAssert.this.field(field);
    }
  }

}
