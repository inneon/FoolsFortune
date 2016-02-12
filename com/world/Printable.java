package com.world;

public abstract class Printable {

  public abstract String Printable(int depth);

  public String GetPadding(int depth) {
	  String result = new String(new char[depth]).replace("\0", " ");
	  return result;
  }
  
}
