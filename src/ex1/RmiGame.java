package ex1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RmiGame extends UnicastRemoteObject implements RmiInt {
	
	private TicTacToeGui GUI;
	
	protected RmiGame(TicTacToeGui GUI) throws RemoteException {
		this.GUI = GUI;
	}
	
	public void bind(String url) {
		System.out.println("Server started");
		
		try {
			LocateRegistry.createRegistry(9999);
		}
		catch (RemoteException e) {
			System.out.println("Java RMI registry already exists");
		}
		
		try {
			Naming.rebind(url, this);
			System.out.println("Shit. It's working!");
		}
		catch (Exception e) {
			System.err.println("MIH");
		}
		
		// sett meg selv som server
	}

	@Override
	public void setMark(int x, int y) throws RemoteException {
		
	}

}
