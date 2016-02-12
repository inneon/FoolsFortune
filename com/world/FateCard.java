package com.world;

public class FateCard extends Card {

  private Realm realm;
  private Resource resource;

  public FateCard (Realm realm, Resource resource) {
	if (realm == null) throw new java.lang.IllegalArgumentException("realm is null");
	if (resource == null) throw new java.lang.IllegalArgumentException("resource is null");
	
    this.realm = realm;
    this.resource = resource;
  }
  
  public Realm GetRealm() {
	  return realm;
  }
  
  public Resource GetResource() {
	  return resource;
  }
  
  public String Printable(int depth) {
	String result = GetPadding(depth) + "{" + realm + ", " + resource + "}";
	return result;
  }
}
