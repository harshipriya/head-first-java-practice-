public class SimpleDotCom{
int[] locationCells;
int numOfHits;
public void setLocationCells(int[] locs){
locationCells=locs;
}
public String checkYourself(String stringGuess){
int guess=Integer.parseInt(stringGuess);
String result="miss";
for(int cell:locationCells){
if(guess==cell){
result="hit";
numOfHits++;
break;
}
}
if(numOfHits==locationCells.length){
result="Kill";
}
System.out.println(result);
return result;
}
}