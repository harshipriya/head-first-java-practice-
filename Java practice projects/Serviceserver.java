import java.rmi.*;
import interface ServiceServer extends Remote{
Object[] getServiceList() throws RemoteException;
Service getService(Object serviceKey) throws RemoteException;
}