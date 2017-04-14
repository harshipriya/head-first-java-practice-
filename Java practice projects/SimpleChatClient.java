import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SimpleChatClient{
JTextArea incoming;
JTextField outgoing;
PrintWriter writer;
BufferedReader reader;
Socket sock;

public void go(){
JFrame frame=new JFrame("Ludicrously simple chat client");
JPanel mainPanel=new JPanel();
incoming =new JTextArea(15,50);
incoming.setLineWrap(true);
incoming.setWrapStyleWord(true);
incoming.setEditable(false);
JScrollPane qScroller=new JScrollPane(incoming);
qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

outgoing=new JTextField(20);
JButton button=new JButton("Send");
button.addActionListener(new SendButtonListener());
mainPanel.add(outgoing);
mainPanel.add(qScroller);
mainPanel.add(button);
frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
setUpNetworking();
Thread readerThread=new Thread(new IncomingReader());
readerThread.start();
frame.setSize(400,500);
frame.setVisible(true);
}
private void setUpNetworking(){
try{
sock=new Socket("127.0.0.1",5000);
InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
reader=new BufferedReader(streamReader);
writer=new PrintWriter(sock.getOutputStream());
System.out.println("network established");
}catch(Exception e){
e.printStackTrace();
}
}
public class SendButtonListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
try{
writer.println(outgoing.getText());
writer.flush();

}catch(Exception ex){
ex.printStackTrace();
}
outgoing.setText("");
outgoing.requestFocus();
}
}
public class IncomingReader implements Runnable{
public void run(){
String message;
try{
while((message=reader.readLine())!=null){
System.out.println("read "+message);
incoming.append(message+"\n");
}
}catch(Exception e){
e.printStackTrace();
}
}
}
}
