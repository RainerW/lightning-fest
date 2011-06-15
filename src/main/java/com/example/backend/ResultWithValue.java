package com.example.backend;

import java.util.HashMap;
import java.util.Map;

public class ResultWithValue
{

  private Map<String, String> _values = new HashMap<String, String>();

  public String getValue(String field)
  {
    return _values.get(field);
  }

  public void add(String key, String value)
  {
    _values.put(key, value);
  }

}
