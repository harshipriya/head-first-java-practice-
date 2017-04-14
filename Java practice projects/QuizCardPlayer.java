import java.util.*;
import.java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer{
private JTextArea display;
private JTextArea answer;
private ArrayList<QuizCard> cardList;
private QuizCard currentCard;
private int currentCardIndex;
private JFrame frame;
private JButton nextButton;
private boolean isShowAnswer;

public static void main(String[] args){
QuizCardPlayer reader=new QuizCardPlayer();
reader.go();
}
public void go(){
//build gui

frame=new JFrame("Quiz card Player");
JPanel mainPanel=new JPanel();
Font bigFont=new Font("TimesNewRoman",Font.BOLD,24);

display=new JTextArea(10,20);
display.setFont(bigFont);

display.setLineWrap(true);
display.setEditable(false);

JScrollPane qScroller=new JScrollPanel(question);
qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
qScroller.setHorizantalScrollBarPolicy(ScrollPaneConstants.HORIZANTAL_SCROLLBAR_NEVER);
nextButton=new JButton("Show Question");
mainPanel.add(qScroller);
mainPanel.add(nextButton);
nextButton.addActionListener(new NextCardListener());

JMenubar menuBar=new JMenuBar();
JMenu fileMenu=new JMenu("File");
JMenuItem loadMenuItem=new JMenuItem("Load Card Set");

newMenuItem.addActionListener(new OpenMenuListener());

fileMenu.add(loadMenuItem);

menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
frame.setSize(640,500);
frame.setVisible(true);
}

public class NextCardListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
if(isShowAnswer){
display.setText(currentCard.getAnswer());
nextButton.setText("NextCard");
isShowAnswer=false;
}
else{
if(currentCardIndex<cardList.size()){
showNextCard();
}else{
display.setText("This was last Card");
nextButton.setEnabled(false);
}
}
}
}

public class OpenMenuListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
JFileChooser fileOpen=new JFileChooser();
fileOpen.showOpenDiolog(frame);
loadFile(fileOpen.getSelectedFile());
}
}
private void loadFile(File file){
cardList=new ArrayList<QuizCard>();
try{
BufferedReader reader=new BufferedReader(new FileReader(file));
String line=null;
while((line=reader.readLine())!=null){
makeCard(line);
}
reader.close();
}catch(Exception e){
System.out.println("couldn't read the card file");
e.printStackTrace();
}
showNextCard();
}
private void makeCard(String lineToParse){
String[] result=lineToParse.split("/"); 
QuizCard card=new QuizCard(result[0],result[1]);
cardList.add(card);
System.out.println("make a card");
}
private void showNextCard(){
currentCard=cardList.get(currentCardIndex)
currentCardIndex++;
display.setText(currentCard.getQuestion());
nextButton.setText("ShowAnswer");
isShowAnswer=true;
}
}