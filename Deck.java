import java.util.*;

public class Deck{
  private ArrayList<Card> deck;

  public Deck()
  {
    deck = new ArrayList<Card>();
    return;
  }

  public void add(Card card)
  {
    deck.add(card);
  }

  public void remove(int index)
  {
    deck.remove(index);
  }

  public Card get(int index)
  {
    return deck.get(index);
  }
  
  public int size()
  {
    return deck.size();
  }
}
  
