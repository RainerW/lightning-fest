package com.example.backend;

import java.util.ArrayList;
import java.util.List;

public class Backend
{

  public Integer getANumber()
  {
    return 23;
  }

  public ResultWithValue getAResult()
  {
    ResultWithValue result = new ResultWithValue();
    result.add("f02","1");
    result.add("f03","1");
    return result;
  }

  public List<Result> getAList()
  {
    List<Result> liste = new ArrayList<Result>();
    liste.add(new Result("rainer"));
    liste.add(new Result("text"));
    liste.add(new Result("dummy"));
    return liste;
  }

}
