package ex1;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

public class TicTacToeImpl extends UnicastRemoteObject implements TicTacToeInterface
{
	private TicTacToeGui GUI;
	private boolean myTurn;
	private char opponentMark;
	
	
	// oppretter Rmi-ting med ref. til GUI
	protected TicTacToeImpl(TicTacToeGui GUI) throws RemoteException {
		this.GUI = GUI;
		this.myTurn = false;
		this.opponentMark = 'X';
	}
	@Override
	public void setMyTurn(boolean myTurn) throws RemoteException
	{
		this.myTurn = myTurn;
	}
	@Override
	public boolean isMyTurn() throws RemoteException
	{
		return this.myTurn;
	}
	@Override
	public void setOpponentMark(char mark) throws RemoteException
	{
		this.opponentMark = mark;
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
		GUI.setMark(x, y, opponentMark);
		this.setMyTurn(true);
	}

	@Override
	public void leaveGame() throws RemoteException {
		GUI.server = null;
		GUI.clearBoard();
	}
	@Override
	public void setOpponent(TicTacToeInterface server) throws RemoteException {
		GUI.setServer(server);
		
	}
	@Override
	public void newGame() throws RemoteException {
		GUI.clearBoard();
	}
	
}

