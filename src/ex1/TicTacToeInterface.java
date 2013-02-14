package ex1;


import java.rmi.*;


public interface TicTacToeInterface extends Remote{
	/*TODO: Add the methods that are supposed to be exported by the Remote object.
	Methods like "isTheGameWon" and "isThisMoveLegal" are not supposed to be here,
	but checked by each client seprately.. I think*/
	
	public void setMark(int x, int y) throws RemoteException;
	public void leaveGame() throws RemoteException;
	public void setOpponentMark(char mark) throws RemoteException;
	public boolean isMyTurn() throws RemoteException;
	public void setMyTurn(boolean myTurn) throws RemoteException;
	
	public void setOpponent(TicTacToeInterface server) throws RemoteException;
}

