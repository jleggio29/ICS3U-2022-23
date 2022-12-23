package SecondAssignmentGoFish;

import java.util.Scanner;

public class GoFish {
   static Scanner in = new Scanner(System.in);
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String CLUBS = "C";
   private static final String SPADES = "S";
   private static final String DIAMONDS = "D";
   private static final int NUM_VALUES = 13;
   private static final String JACK = "J";
   private static final String ACE = "A";
   private static final String QUEEN = "Q";
   private static final String KING = "K";
   static String playerOneHand = dealCards();
   static String computerOneHand = dealCards();
   static String computerTwoHand = dealCards();
   static String computerThreeHand = dealCards();
   static int playerOnePoints = playerPoints(playerOneHand);
   static int computerOnePoints = playerPoints(computerOneHand);
   static int computerTwoPoints = playerPoints(computerTwoHand);
   static int computerThreePoints = playerPoints(computerThreeHand);
   
   public static void main(String[] args) {
        
      // Takes the player's first hand and removes pairs.
      playerOneHand = newHand(playerOneHand);
      computerOneHand = newHand(computerOneHand);
      computerTwoHand = newHand(computerTwoHand);
      computerThreeHand = newHand(computerThreeHand);   

      // Displays each player's hand.
      displayHand(playerOneHand, false, "Player One: ");
      displayHand(computerOneHand, true, "Computer One: ");
      displayHand(computerTwoHand, true, "Computer Two: ");
      displayHand(computerThreeHand, true, "Computer Three: ");

      // Displays each player's points.
      System.out.println("Player One Points: " + playerOnePoints);
      System.out.println("Computer One Points: " + computerOnePoints);
      System.out.println("Computer Two Points: " + computerTwoPoints);
      System.out.println("Computer Three Points: " + computerThreePoints);

      // Loop for the when the game is being played
      boolean isPlaying = true;     
      while (isPlaying){
              
         while (playerOnePoints < 10 && computerOnePoints < 10 && computerTwoPoints < 10 && computerThreePoints < 10) {

         playerOneHand = playerTurn(playerOneHand, computerOneHand, computerTwoHand, computerThreeHand); 
         computerOneHand = computerOneTurn();
         computerTwoHand = computerTwoTurn();
         computerThreeHand = computerThreeTurn(); 

         if (playerOneHand == null) {
            playerOneHand = dealCards();
           }
         if (computerOneHand == null) {
            computerOneHand = dealCards();
           }
         if (computerTwoHand == null) {
            computerTwoHand = dealCards();
           }
         if (computerThreeHand == null) {
            computerThreeHand = dealCards();
           }
           
           if (playerOnePoints >= 10){
            System.out.println("Player One Wins!");
            isPlaying = playAgain();
           }
           if (computerOnePoints >= 10){
            System.out.println("Computer One Wins!");
            isPlaying = playAgain();
           }
           if (computerTwoPoints >= 10){
            System.out.println("Computer Two Wins!");
            isPlaying = playAgain();
           }
           if (computerThreePoints >= 10){
            System.out.println("Computer Three Wins!");
            isPlaying = playAgain();
           }
           
        }
      }
   }

// Asks if you want to play again after the game has finished.
private static boolean playAgain() {
      while (true) {
         System.out.println("Play Again? ([Y]es/[N]o): ");
         String result = in.nextLine().toLowerCase();

         if (result.equals("y") || result.equals("yes"))
            return true;
         else if (result.equals("n") || result.equals("no"))
            return false;

         if (playAgain() == true){
          main(null);  
          playerOneHand = newHand(playerOneHand);
          computerOneHand = newHand(computerOneHand);
          computerTwoHand = newHand(computerTwoHand);
          computerThreeHand = newHand(computerThreeHand);   
         }
      }
   }

// Deals 5 cards to a player.
private static String dealCards() {
      return getCard()  + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " ";
      
   }

// The manual player's turn.
private static String playerTurn(String playerOneHand, String computerOneHand, String computerTwoHand, String computerThree4Hand ) {

   System.out.println("Player One's Turn ");
   System.out.println(playerOneHand);
   System.out.println("Choose a player to ask for a card: (1) Player One, (2) Player Two, (3) Player Three");

   String playerSelected = in.nextLine();

   if(playerSelected.equals("1")) {
      System.out.println("Do you have a(an): ");

      String cardSelect = in.nextLine();

      int cardIndex = computerOneHand.indexOf(cardSelect);

      if (playerOneHand.indexOf(cardSelect)<0){
         if (playerOneHand.indexOf(cardSelect)<0) {
         System.out.println("Invalid Input!");
         System.out.println("Do you have a(an): ");
         }
         
      }
      else if (playerOneHand.indexOf(cardSelect)>=1) {

      if(computerOneHand.indexOf(cardSelect) >= 1){

         System.out.println("They had the card!");

         computerOneHand = computerOneHand.substring(0,cardIndex) + computerOneHand.substring(cardIndex+3);
         playerOneHand = playerOneHand.substring(0,cardIndex) + playerOneHand.substring(cardIndex + 3);
         playerOnePoints++;

      }
      else{
         System.out.println("GO FISH");
         playerOneHand = playerOneHand += " " + getCard();
      }
   }
      System.out.println("Computer Two: " + computerOneHand);
      System.out.println("Player One:" + playerOneHand);
      System.out.println("Player One Points: " + playerOnePoints);
      System.out.println("Computer One Points: " + computerOnePoints);
      System.out.println("Computer Two Points: " + computerTwoPoints);
      System.out.println("Computer Three Points: " + computerThreePoints);

   } else if (playerSelected.equals("2")){
      System.out.print("Do you have a(an): ");
      String cardSelect = in.nextLine();
      int cardIndex = computerOneHand.indexOf(cardSelect);
      if (playerOneHand.indexOf(cardSelect)>=0){
         return cardSelect;
      }
      else if (playerOneHand.indexOf(cardSelect)<0){
         System.out.println("Invalid Input!");
      }
      else{

      if(computerTwoHand.indexOf(cardSelect) >= 1){

         System.out.println("They had the card!");

         computerTwoHand = computerTwoHand.substring(0,cardIndex) + computerTwoHand.substring(cardIndex, computerTwoHand.length());
         playerOneHand = playerOneHand.substring(0,cardIndex) + playerOneHand.substring(cardIndex, playerOneHand.length());
         playerOnePoints++;

      }else{
         System.out.println("GO FISH");
         playerOneHand = playerOneHand += getCard();
      }
   }
      System.out.println("Computer Two: " + computerTwoHand);
      System.out.println("Player One:" + playerOneHand);
      System.out.println("Player One Points: " + playerOnePoints);
      System.out.println("Computer One Points: " + computerOnePoints);
      System.out.println("Computer Two Points: " + computerTwoPoints);
      System.out.println("Computer Three Points: " + computerThreePoints);
   

   } else if(playerSelected.equals("3")){
      System.out.println("Do you have a(an): ");

      String cardSelect = in.nextLine();

      int cardIndex = computerThreeHand.indexOf(cardSelect);

      if (playerOneHand.indexOf(cardSelect)<0){
         System.out.println("Invalid Input!");
         System.out.println("Do you have a(an): ");

      }

      if(computerThreeHand.indexOf(cardSelect) >= 1){

         System.out.println("They had the card!");
         computerThreeHand = computerThreeHand.substring(0,cardIndex) + computerThreeHand.substring(cardIndex+3);
         playerOneHand = playerOneHand.substring(0,cardIndex) + playerOneHand.substring(cardIndex + 3);
         playerOnePoints++;

      }else{
         System.out.println("GO FISH");
         playerOneHand = playerOneHand += getCard();
      }

      System.out.println("Computer Two: " + computerThreeHand);
      System.out.println("Player One:" + playerOneHand);
      System.out.println("Player One Points: " + playerOnePoints);
      System.out.println("Computer One Points: " + computerOnePoints);
      System.out.println("Computer Two Points: " + computerTwoPoints);
      System.out.println("Computer Three Points: " + computerThreePoints);

   }
   return playerOneHand;
}

// The turn of the first computer player.
private static String computerOneTurn(){
       
String card = computerOneHand.substring(0,1);
if (card.equals("1")){
     card = "10";
   }
int whoVariable = (int)(Math.random() * 3 + 1);
String who = Integer.toString(whoVariable);

if (who.equals("1")){
   System.out.println("Computer One picked Player One");   
    if (playerOneHand.indexOf(card) > 0) {
      System.out.println("They had the card!");
      computerOneHand = computerOneHand.substring(0,computerOneHand.indexOf(card)) + computerOneHand.substring(computerOneHand.indexOf(card) + 3);
      playerOneHand = playerOneHand.substring(0,playerOneHand.indexOf(card)) + playerOneHand.substring(playerOneHand.indexOf(card) + 3);
      computerOnePoints++;
       
    }else{
      System.out.println("GO FISH");
        computerOneHand += getCard();
       
    }
}else if (who.equals("2")){
   System.out.println("Computer One picked Computer Two");
    if (computerTwoHand.indexOf(card) > 0) {
      System.out.println("They had the card!");
      computerOneHand = computerOneHand.substring(0,computerOneHand.indexOf(card)) + computerOneHand.substring(playerOneHand.indexOf(card) + 3);
      computerTwoHand = computerTwoHand.substring(0,computerTwoHand.indexOf(card)) + computerTwoHand.substring(computerTwoHand.indexOf(card) + 3);
      computerOnePoints++;
    }else{
       System.out.println("GO FISH");
        computerOneHand += getCard();
       
    }
}else if (who.equals("3")){
   System.out.println("Computer One picked Computer Three");
    if (computerThreeHand.indexOf(card) > 0) {
      computerOneHand = computerOneHand.substring(0,computerOneHand.indexOf(card)) + computerOneHand.substring(playerOneHand.indexOf(card) + 3);
      computerThreeHand = computerThreeHand.substring(0,computerThreeHand.indexOf(card)) + computerThreeHand.substring(computerThreeHand.indexOf(card) + 3);
      computerOnePoints++;
      
    }else{
         System.out.println("GO FISH");
        computerOneHand += getCard();
      
      }
   }
      return computerOneHand;
}

// The turn of the second computer player
private static String computerTwoTurn(){
       
   String card = computerOneHand.substring(0,1);
   if (card.equals("1")){
        card = "10";
      }
   int whoVariable = (int)(Math.random() * 3 + 1);
   String who = Integer.toString(whoVariable);
   
   if (who.equals("1")){
      System.out.println("Computer Two picked Player One");   
       if (playerOneHand.indexOf(card) > 0) {
         System.out.println("They had the card!");
         computerTwoHand = computerTwoHand.substring(0,computerTwoHand.indexOf(card)) + computerTwoHand.substring(computerTwoHand.indexOf(card) + 3);
         playerOneHand = playerOneHand.substring(0,playerOneHand.indexOf(card)) + playerOneHand.substring(playerOneHand.indexOf(card) + 3);
         computerTwoPoints++;
          
       }else{
         System.out.println("GO FISH");
           computerTwoHand += getCard();
          
       }
   }else if (who.equals("2")){
      System.out.println("Computer Two picked Computer One");
       if (computerTwoHand.indexOf(card) > 0) {
         System.out.println("They had the card!");
         computerTwoHand = computerTwoHand.substring(0,computerTwoHand.indexOf(card)) + computerTwoHand.substring(computerTwoHand.indexOf(card) + 3);
         computerOneHand = computerOneHand.substring(0,computerOneHand.indexOf(card)) + computerOneHand.substring(playerOneHand.indexOf(card) + 3);
         computerTwoPoints++;
       }else{
          System.out.println("GO FISH");
           computerTwoHand += getCard();
          
       }
   }else if (who.equals("3")){
      System.out.println("Computer Two picked Computer Three");
       if (computerThreeHand.indexOf(card) > 0) {
         computerTwoHand = computerOneHand.substring(0,computerTwoHand.indexOf(card)) + computerTwoHand.substring(computerTwoHand.indexOf(card) + 3);
         computerThreeHand = computerThreeHand.substring(0,computerThreeHand.indexOf(card)) + computerThreeHand.substring(computerThreeHand.indexOf(card) + 3);
         computerTwoPoints++;
         
       }else{
            System.out.println("GO FISH");
           computerTwoHand += getCard();
         
         }
      }
         return computerTwoHand;
   }

   // The turn of the third computer player
   private static String computerThreeTurn(){
       
      String card = computerOneHand.substring(0,1);
      if (card.equals("1")){
           card = "10";
         }
      int whoVariable = (int)(Math.random() * 3 + 1);
      String who = Integer.toString(whoVariable);
      
      if (who.equals("1")){
         System.out.println("Computer Three picked Player One");   
          if (playerOneHand.indexOf(card) > 0) {
            System.out.println("They had the card!");
            computerThreeHand = computerThreeHand.substring(0,computerThreeHand.indexOf(card)) + computerThreeHand.substring(computerThreeHand.indexOf(card) + 3);
            playerOneHand = playerOneHand.substring(0,playerOneHand.indexOf(card)) + playerOneHand.substring(playerOneHand.indexOf(card) + 3);
            computerThreePoints++;
             
          }else{
            System.out.println("GO FISH");
              computerThreeHand += getCard();
             
          }
      }else if (who.equals("2")){
         System.out.println("Computer Three picked Computer One");
          if (computerTwoHand.indexOf(card) > 0) {
            System.out.println("They had the card!");
            computerThreeHand = computerThreeHand.substring(0,computerThreeHand.indexOf(card)) + computerThreeHand.substring(computerThreeHand.indexOf(card) + 3);
            computerOneHand = computerOneHand.substring(0,computerOneHand.indexOf(card)) + computerOneHand.substring(playerOneHand.indexOf(card) + 3);
            computerThreePoints++;
          }else{
             System.out.println("GO FISH");
              computerThreeHand += getCard();
             
          }
      }else if (who.equals("3")){
         System.out.println("Computer Three picked Computer Two");
          if (computerThreeHand.indexOf(card) > 0) {
            computerThreeHand = computerThreeHand.substring(0,computerThreeHand.indexOf(card)) + computerThreeHand.substring(computerThreeHand.indexOf(card) + 3);
            computerTwoHand = computerOneHand.substring(0,computerTwoHand.indexOf(card)) + computerTwoHand.substring(computerTwoHand.indexOf(card) + 3);
            computerThreePoints++;
            
          }else{
               System.out.println("GO FISH");
              computerThreeHand += getCard();
            
            }
         }
            return computerThreeHand;
      }

   // How pairs are removed from any player's original hand.
   private static String newHand(String cards) {
      String firstHand = cards;

      for(int i = 0; i<cards.length(); i++){
       String start = cards.substring(i, i+1);
       String restOf = cards.substring(i+1);
       if("JQK10A23456789".indexOf(start)>=0){
           if(restOf.indexOf(start)>=0){
               String newHand = "";
               int location1 = cards.indexOf(start);
               int location2 = cards.lastIndexOf(start);

               newHand = cards.substring(0, location1) + cards.substring(location1+3, location2) + cards.substring(location2+3);
               
               cards = newHand;
               i = 0; 
                  
           }
       }
           
   }
   
      firstHand = cards;
   
      return firstHand;

   }

   // Displays any player's hand.
   private static void displayHand(String cards, boolean isHidden, String label) {
      String result = "";
   if (isHidden){
      for (int i = 0; i<cards.length();i++){
         String s = cards.substring(i, i+1);

         if (s.equals(" ")){
            result += " ";
         }else if ("123456789JKQA".indexOf(s)>0){
            result += "X";
         }
      }
      result = label + result;
   }
   else {
      result += label + cards;
   }

   System.out.println(result);
   }

// Calculates any players's points after they are dealt their first hand and displays any player's point throughout the game.
private static int playerPoints(String playerOneHand) {

      int score = 0;

      for(int i = 0; i<playerOneHand.length(); i++){
          String startHand = playerOneHand.substring(i, i+1);
          String restOf = playerOneHand.substring(i+1);
          if("234567891JQKA".indexOf(startHand)>=0){
              if(restOf.indexOf(startHand)>=0){
                  score++;
              }
          }
          if (score == 3){
            score--;
          }
   }
      return score;
}

// Puts a card value and card suit together to make a card.
private static String getCard() {
    return getValue() + getSuit();
 }

// Gets a random suit for a card.
private static String getSuit() {
    int iSuit = (int) (Math.random() * NUM_SUITS) + 1;

    if (iSuit == 1)
       return HEARTS;
    else if (iSuit == 2)
       return SPADES;
    else if (iSuit == 3)
       return CLUBS;
    else
       return DIAMONDS;
 }

// Gets a random card value.
private static String getValue() {
    int iValue = (int) (Math.random() * NUM_VALUES) + 1;

    if (iValue == 1)
       return ACE;
    else if (iValue == 11)
       return JACK;
    else if (iValue == 12)
       return QUEEN;
    else if (iValue == 13)
       return KING;
    else
       return "" + iValue;
    }

}
