import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer{
HashMap serviceList;
public ServiceServerImpl() throws RemoteException{
setUpServices();
}
private void setUpServices(){
serviceList=new HashMap();
serviceList.put("Dice Rolling service", new DiceService());
serviceList.put("Day of the week service", new DayOfTheWeek());
serviceList.put("Mini music service", new MiniMusicService());
}

public object[] getserviceList(){
System.out.println("in remote");
return serviceList.keySet().toArray();
} 
public Service getservice(Object serviceKey) throws RemoteException{
Service theService=(Service)serviceList.get(serviceKey);
return theService
}
public static void main(String[] args ){
try{
Naming.rebind("ServiceServer",new ServiceServerImpl());
}catch(Exception ex){
e.printStackTrace();
}
}
}