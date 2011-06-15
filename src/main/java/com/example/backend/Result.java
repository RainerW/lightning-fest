package com.example.backend;

public class Result
{

  String _value;

  public String getName()
  {
    return _value;
  }

  public Result(String string)
  {
    _value = string;
  }

  @Override
  public boolean equals(Object obj)
  {
    return _value.equals(((Result) obj)._value);
  }

  @Override
  public String toString()
  {
    return _value;
  }

  @Override
  public int hashCode()
  {
    return _value.hashCode();
  }
}
