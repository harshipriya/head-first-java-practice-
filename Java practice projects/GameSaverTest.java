import java.io.*;
public class GameSaverTest{
public static void main(String[] args){
GameCharacter one=new GameCharacter(50,"ELF",new String[]{"bow","sword","dust"});
GameCharacter two=new GameCharacter(200,"Troll",new String[]{"bare hands","big axe"});
GameCharacter three=new GameCharacter(50,"Magician",new String[]{"spells","invisibility"});
try{
ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Game.ser"));
oos.writeObject(one);
oos.writeObject(two);
oos.writeObject(three);
oos.close();
}catch(Exception e){
e.printStackTrace();
}
one=null;
two=null;
three=null;
try{
ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Game.ser"));
GameCharacter oneRestore=(GameCharacter)ois.readObject();
GameCharacter twoRestore=(GameCharacter)ois.readObject();
GameCharacter threeRestore=(GameCharacter)ois.readObject();
System.out.println("one's type: "+oneRestore.getType());
System.out.println("two's type: "+twoRestore.getType());
System.out.println("three's type: "+threeRestore.getType());
}catch(Exception e){
e.printStackTrace();
}
}
}