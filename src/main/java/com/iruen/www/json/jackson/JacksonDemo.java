package com.iruen.www.json.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 *
 * @author steve jin (http://www.doublecloud.org)
 */
public class JacksonDemo
{
  private static ObjectMapper mapper = new ObjectMapper();
 
  public static void main(String[] args) throws IOException
  {
    parseJson();
 
    saveJson();
 
    perfTest();
  }
 
  public static void parseJson() throws IOException
  {
    String jsonStr = "{ \"author\": \"Steve Jin\", \"title\" : \"vSphere SDK\", \"obj\" : {\"objint\" : {}} }";
 
    // parsing JSON to generic object
    Object obj = mapper.readValue(jsonStr, Object.class);
    System.out.println("obj type: " + obj.getClass().toString()); // java.util.LinkedHashMap
    System.out.println("obj: " + obj);
 
    // parsing JSON to Map object
    Map m = mapper.readValue(jsonStr, Map.class);
    System.out.println("map.size: " + m.size());
    for(Object key: m.keySet())
    {
      System.out.println("key:" + key);
    }
 
    // parsing JSON to concrete Object
    Book book = mapper.readValue(jsonStr, Book.class);
    System.out.println("book: " + book);
    System.out.println("book.author: " + book.author);
    System.out.println("book.obj class: " + book.obj.getClass()); //com.google.gson.internal.LinkedTreeMap
    System.out.println("book.obj: " + book.obj);
  }
 
  public static void saveJson() throws IOException
  {
    Book book = new Book();
    book.author = "Steve Jin";
    book.title = "VMware vSphere and VI SDK";
 
    mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    String bookJson = mapper.writeValueAsString(book);
    System.out.println("bookJson: " + bookJson);
  }
 
  public static void perfTest() throws IOException
  {
    long start = System.nanoTime();
 
    Zips zips = mapper.readValue(new File("src/main/resources/zips.json"), Zips.class);
    Map m = mapper.readValue(new File("src/main/resources/zips.json"), Map.class);
    Object obj = mapper.readValue(new File("src/main/resources/zips.json"), Object.class);
    
    System.out.println("zips.class.type : " + obj.getClass().toString());
    System.out.println("zips.class.type : " + m.getClass().toString());
    System.out.println("zips.class.type : " + zips.getClass().toString());
    System.out.println("zips.key.size : " + m.size());
   	System.out.println("zips.state : " + zips.state);
   	System.out.println("zips.loc.index[0] : " + zips.loc.get(0));
   	
   	boolean hasLoc = m.keySet().contains("loc");
   	System.out.println("hasLoc : " + hasLoc);

   	for (Object key : m.keySet()) {
		System.out.println("key : " + key);
	}
 
    long end = System.nanoTime();
    System.out.println("Time taken (nano seconds): " + (end - start) * 0.000000001);
  }
}
 
class Book
{
  public String author;
  public String title;
  public Map obj;
}

class Zips
{
	public String _id;
	public String city;
	public List<Integer> loc;
	public String pop;
	public String state;
}
