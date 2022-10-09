import java.util.*;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    Scanner userinput = new Scanner(System.in);
    // Welcome Text
    System.out.println("Welcome to a UNO simulation. You will be playing against the computer. Choose an index from your deck to play a card, and type 'draw' to draw a card from the main deck.");
    // Create a temp Card 
    Card currentCard;
    Deck generalDeck = new Deck();
    
    final String[] cardsColor = {"red", "yellow", "green", "blue"};
    final int[] cardsNum = {0,1,2,3,4,5,6,7,8,9};

    //make the general deck
    Card card;
    for(String color : cardsColor)
    {
      for(int num : cardsNum)
      {
        card = new Card(color, num);
        generalDeck.add(card);
      }
    }

    //draw the first card
    int index = (int)(Math.random() * generalDeck.size());
    currentCard = generalDeck.get(index);
    generalDeck.remove(index);

    //creating user deck w 7 cards:
    Deck user = new Deck();
    
    for(int i = 0; i < 7; i++)
    {
      index = (int)(Math.random() * generalDeck.size());
      user.add(generalDeck.get(index));
      generalDeck.remove(index);
    }
    
    //creating computer deck w 7 cards:
    Deck computer = new Deck();
    for(int i = 0; i < 7; i++)
    {
      index = (int)(Math.random() * generalDeck.size());
      computer.add(generalDeck.get(index));
      generalDeck.remove(index);
    }

    HashMap<Card,Integer> generalDeckMap = new HashMap<Card,Integer>();
    HashMap<Card,Integer> userMap = new HashMap<Card,Integer>();
    HashMap<Card,Integer> computerMap = new HashMap<Card,Integer>();

    for(int i = 0; i < generalDeck.size(); i++)
    {
      generalDeckMap.put(generalDeck.get(i), i+1);
    }

    for(int i = 0; i < user.size(); i++)
    {
      userMap.put(user.get(i), i+1);
    }

    for(int i = 0; i < computer.size(); i++)
    {
      computerMap.put(computer.get(i), i+1);
    }

    String userInput;
    int cardIndex = 0;
    Card player;
    while(true)
    {
      //check for the winner 
      if(user.size() == 0)
      {
        System.out.println("YOU WIN!!");
        userinput.close();
        break;
      }
      else if(computer.size() == 0)
      {
        System.out.println("COMPUTER WON");
        userinput.close();
        break;
      }
      else if(generalDeck.size() == 0)
      {
        System.out.println("Out of cards");
        userinput.close();
        break;
      }
      else
      {
        System.out.println("Current Card: " + currentCard);
      }

      //user is playing here:
      System.out.println("YOUR DECK");
      printCard(user);
      System.out.println("CHOOSE A CARD:");
      userInput = userinput.nextLine();
      //check if the index chosen is valid
      while(userInput.length() == 0 || userInput.length() > 4)
      {
        System.out.println("CHOOSE A CARD:");
        userInput = userinput.nextLine();
        if(userInput.length() > 0 && userInput.length() < 4)
        {
          break;
        }
      }
      if ((userInput.toLowerCase()).equals("d") || (userInput.toLowerCase()).equals("draw"))
      {
          index = (int)(Math.random() * generalDeck.size());
          while(true){
            if(index > generalDeck.size() -1){
              index = (int)(Math.random() * generalDeck.size());
            }else{
              break;
            }
          }
          user.add(generalDeck.get(index));
          generalDeck.remove(index);
      }
      else
      {
        cardIndex = Integer.parseInt(userInput);
        
        if(cardIndex < 0 || cardIndex > user.size())
        {
          while(true)
          {
            System.out.println("Pick a card P1");
            userInput = userinput.nextLine();
            if ((userInput.toLowerCase()).equals("d") || (userInput.toLowerCase()).equals("draw"))
            {
              index = (int)(Math.random() * generalDeck.size());
              while(true)
              {
                if(index > generalDeck.size() -1)
                {
                  index = (int)(Math.random() * generalDeck.size());
                }
                else
                {
                  break;
                }
              }
              user.add(generalDeck.get(index));
              generalDeck.remove(index);
              break;
            }
            cardIndex = Integer.parseInt(userInput);
            // cardIndex = userinput.nextInt(); 
            if(cardIndex <= 0 || !(cardIndex > user.size()))
            {
              break;
            }
          }
        }
        try
        {
          player = user.get(cardIndex);
        }
        catch(Exception E){
          while(true)
          {
            System.out.println("Pick a card P1: else");
            userInput = userinput.nextLine();
            while(true){
              if(userInput.length() > 4){
                System.out.println("Pick a card P1: else");
                userInput = userinput.nextLine();
              }else{
                break;
              }
            }
            if ((userInput.toLowerCase()).equals("d") || (userInput.toLowerCase()).equals("draw"))
            {
              index = (int)(Math.random() * generalDeck.size());
              while(true)
              {
                if(index > generalDeck.size() -1)
                {
                  index = (int)(Math.random() * generalDeck.size());
                }
                else
                {
                  break;
                }
              }
              user.add(generalDeck.get(index));
              generalDeck.remove(index);
              break;
            }
            cardIndex = Integer.parseInt(userInput);
            // cardIndex = userinput.nextInt(); 
            if(cardIndex <= 0 || !(cardIndex > user.size()))
            {
              break;
            }
          }
        }
        player = user.get(cardIndex);

        if(player.getColor().equals(currentCard.getColor()) || player.getValue() == currentCard.getValue())
        {
          currentCard.setColor(player.getColor());
          currentCard.setValue(player.getValue());
          user.remove(cardIndex);
        }
        else
        {
          while(true)
          {
            System.out.println("Current Card: " + currentCard);
            System.out.println("Try again");
            userInput = userinput.nextLine();
            if ((userInput.toLowerCase()).equals("d") || (userInput.toLowerCase()).equals("draw"))
            {
              index = (int)(Math.random() * generalDeck.size());
              while(true){
                if(index > generalDeck.size() -1){
                  index = (int)(Math.random() * generalDeck.size());
                }else{
                  break;
                }
              }
              user.add(generalDeck.get(index));
              generalDeck.remove(index);
              break;
            }
            cardIndex = Integer.parseInt(userInput);
            if(cardIndex < user.size())
            {
              player = user.get(cardIndex);
              if(player.getColor().equals(currentCard.getColor()) || player.getValue() == currentCard.getValue())
              {
                currentCard.setColor(player.getColor());
                currentCard.setValue(player.getValue());
                user.remove(cardIndex);
                break;
              } 
            }
          }
        }
      }
      
      //check if the player won before the computer play
      if(user.size() == 0){
        System.out.println("YOU WIN!!");
        userinput.close();
        break;
      }
      
      // Computer Ai Code here
      boolean notPickedCard = true;
      for(int i = 0; i < computer.size(); i++)
      {
        player = computer.get(i);
        if(player.getColor().equals(currentCard.getColor()) || player.getValue() == currentCard.getValue())
        {
          currentCard.setColor(player.getColor());
          currentCard.setValue(player.getValue());
          computer.remove(i);
          notPickedCard = false;
          System.out.println("COMPUTER IS PLAYING...");
          break;
        }
      }
      //if a card is not picked then the computer will pick a card here
      if(notPickedCard)
      {
        index = (int)(Math.random() * generalDeck.size());
        while(true)
        {
          if(index > generalDeck.size() -1)
          {
            index = (int)(Math.random() * generalDeck.size());
          }
          else
          {
            break;
          }
        }
        
        computer.add(generalDeck.get(index));
        generalDeck.remove(index);
      }
    }
  }

  
  public static void printCard(Deck deck)
  {
    for(int i = 0; i < deck.size(); i++)
    {
      System.out.println(i + " : " + deck.get(i));
    }
  }
}
