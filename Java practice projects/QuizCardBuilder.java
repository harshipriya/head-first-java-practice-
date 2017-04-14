import java.util.*;
import java.awt.event.*;
import java.swing.*;
import java.awt.*;
import java.io.*;
public class QuizCardBuilder{
private JTextArea question;
private JTextArea answer;
private ArrayList<QuizCard> cardList;
private JFrame frame;

public static void main(String[] args){
QuizCardBuilder builder=new QuizCardBuilder();
builder.go();
}

public void go(){
//build gui

frame=new JFrame("Quiz Card Builder");
JPanel mainPanel=new Jpanel();
Font bigFont=new Font("TimesNewRoman",Font.BOLD,24);
question=new JTextArea(6,20);
question.setLineWrap(true);
question.setWrapStyleWord(true);
question.setFont(bigFont);

JScrollPane qScroller=new JScrollPanel(question);
qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
qScroller.setHorizantalScrollBarPolicy(ScrollPaneConstants.HORIZANTAL_SCROLLBAR_NEVER);

answer=new JTextArea(6,20);
answer.setLineWrap(true);
answer.setWrapStyleWord(true);
answer.setFont(bigFont);

JScrollPane aScroller=new JScrollPanel(answer);
aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
aScroller.setHorizantalScrollBarPolicy(ScrollPaneConstants.HORIZANTAL_SCROLLBAR_NEVER);

JButton nextButton=new JButton("Next Card");
cardList=new ArrayList<QuizCard>();

JLabel qLabel=new JLabel("Question");
JLabel aLabel=new JLabel("Answer");

mainPanel.add(qLabel);
mainPanel.add(qScroller);
mainPanel.add(aLabel);
mainPanel.add(aScroller);
mainPanel.add(nextButton);
nextButton.addActionListener(new NextCardListner());

JMenubar menuBar=new JMenuBar();
JMenu fileMenu=new JMenu("File");
JMenuItem newMenuItem=new JMenuItem("New");
JMenuItem saveMenuItem=new JMenuItem("save");
newMenuItem.addActionListener(new NewMenuListener());
saveMenuItem.addActionListner(new SaveMenuListner());
fileMenu.add(newMenuItem);
fileMenu.add(saveMenuItem);
menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
frame.setSize(500,600);
frame.setVisible(true);

}
public class NextCardListener implements ActionListener{
public void actionperformed(ActionEvent ev){
QuizCard card=new QuizCard(question.getText(),answer.getText());
cardList.add(card);
clearCard();
}
}
public class SaveMenuListner implements ActionListner{
public void actionPerformed(ActionEvent ev){
QuizCard card=new QuizCard(question.getText(),answer.getText());
cardList.add(card);

JFileChooser fileSave=new JfileChooser();
fileSave.showSaveDialog(frame);
saveFile(fileSave.getSelectedFile());
}
}

public class NewMenuListener imlements ActionListener{

public void actionperformed(ActionEvent ev){
cardList.clear();
clearCard();
}
}

public clearCard(){
question.setText("");
answer.setText("");
question.requestFocus();
}
private void saveFile(File file){
try {
BufferWriter writer=new BufferWriter(new FileWriter(file));
for(QuizCard card:cardList){
writer.write(card.getQuestion()+"/");
writer.write(card.getAnswer()+"\n");

}
writer.close();
}catch(Exception e){
e.printStackTrace()
}
}
}