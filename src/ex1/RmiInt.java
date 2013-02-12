package ex1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInt extends Remote {
	public void setMark (int x, int y) throws RemoteException;
}
