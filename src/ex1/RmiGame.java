package ex1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RmiGame extends UnicastRemoteObject implements RmiInt {
	
	private TicTacToeGui GUI;
	
	// oppretter Rmi-ting med ref. til GUI
	protected RmiGame(TicTacToeGui GUI) throws RemoteException {
		this.GUI = GUI;
	}
	
	// denne metoden kalles når en klient ikke finner server, og vil derfor sette seg selv som server
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

	// sette motspillers brikker på mitt brett
	@Override
	public void setMark(int x, int y) throws RemoteException {
		
	}

}
