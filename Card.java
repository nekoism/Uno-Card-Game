import java.util.*;

//get color AND number of card (add +4, +2, reverse later on)

public class Card{
  private String color;
  private int value;
  
  public Card (String color, int value)
  {
    this.color = color;
    this.value = value;
  }
  public String getColor(){
    return color;
  }

  public int getValue(){
    return value;
  }
  public void setValue(int value){
    this.value = value;
  }
  public void setColor(String color){
    this.color = color;
  }
  
  public String toString ()
  {
    if(color.equals("red")){
      return "{ 🟥, " + color + ", " + value + " }";
    }else if(color.equals("yellow")){
      return "{ 🟨, " + color + ", " + value + " }";
    }else if(color.equals("blue")){
      return "{ 🟦, " + color + ", " + value + " }";
    }else{
      return "{ 🟩, " + color + ", " + value + " }";
    }
  }
  
}
