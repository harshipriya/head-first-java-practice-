public class RyanAndMounicaJob implements Runnable{
private BankAccount account=new BankAccount();
public static void main(String[] args){
RyanAndMounicaJob theJob=new RyanAndMounicaJob();
Thread one=new Thread(theJob);
Thread two=new Thread(theJob);
one.setName("Ryan");
two.setName("Mounica");
one.start();
two.start();
}
public void run(){
for(int i=0;i<10;i++){
makeWithdrawl(10);
if(account.getBalance()<0){
System.out.println("overdrawn");
}
}
}
private void makeWithdrawl(int amount){
if(account.getBalance()>=amount){
System.out.println(Thread.currentThread().getName()+" is about to withdraw");
try{
System.out.println(Thread.currentThread().getName()+" is going to sleep");
Thread.sleep(500);
}catch(InterruptedException e){
e.printStackTrace();
}
System.out.println(Thread.currentThread().getName()+" is wakeup");
account.withdraw(amount);
System.out.println(Thread.currentThread().getName()+" completes the withdrawl");
}
else{
System.out.println("sorry,not enough for "+Thread.currentThread().getName());
}
}
}
