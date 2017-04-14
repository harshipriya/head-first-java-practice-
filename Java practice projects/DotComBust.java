import java.util.*;
public class DotComBust{
private GameHelper helper=new GameHelper();
private ArrayList<DotCom> dotComList=new ArrayList<DotCom>();
private int numberofGuesses=0;
private void setUpGame(){
//first make some dot coms and give them locations
DotCom one = new DotCom();
one.setName("Pets.com");
DotCom two=new DotCom();
two.setName("eToys.com");
DotCom three=new DotCom();
three.setName("Go2.com");
dotComList.add(one);
dotComList.add(two);
dotComList.add(three);

System.out.println("Your goal is to sink three dom coms");
System.out.println("Pets.com, eToys.com, Go2.com");
System.out.println("Try to sink them all in the fewest number of guesses");

for(DotCom dotComToSet:dotComList){
ArrayList<String> newLocation=helper.placeDotCom(3);
dotComToSet.setLocationCells(newLocation);
} 
} 
private void startPlaying(){
while(!dotComList.isEmpty()){
String userGuess=helper.getUserInput("Enter a guess");
checkUserGuess(userGuess);
}
}
private void checkUserGuess(String userGuess){
numberofGuesses++;
String result="miss";
for(DotCom dotComToTest:dotComList) {
result=dotComToTest.checkYourself(userGuess);
if(result.equals("hit")) {
break;
}
if(result.equals("Kill")){
dotComList.remove(dotComToTest);
break;
}
}
System.out.println(result);
}
private void finishGame(){
System.out.println("All DotComs are Dead! Your Stock is now worthless.");
if(numberofGuesses<=18){
System.out.println("It only took you "+numberofGuesses+"guesses.");
System.out.println("You got out before your options sank");
}
else{
System.out.println("tOOK YOU LONG ENOUGH"+numberofGuesses+" guesses");
System.out.println("You didnot get out before your options sank");
}
}
public static void main(String[] args){
DotComBust game=new DotComBust();
game.setUpGame();
game.startPlaying();
}
}