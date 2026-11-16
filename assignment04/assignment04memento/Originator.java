package assignment04memento;
  
import java.util.Stack;

import assignment04.Board;
import assignment04.Command;

public class Originator {
	private Stack<Memento> executedStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();
	
	public void createMemento(Board board, Command cm) {
		executedStack.push(new MoveMemento(board, cm));
		redoStack.clear();
	}	
	
	public void reset (Board board) {		
		if(!executedStack.isEmpty()) {
			MoveMemento mmem = (MoveMemento) executedStack.pop();
			redoStack.push(mmem.getCommand());
			board.setICCF(mmem.getFrom(), mmem.getFromPiece());
			board.setICCF(mmem.getTo(), mmem.getToPiece());
		}
	}

	public void redo (Board board) {
		if(!redoStack.isEmpty()) {
			Command cm = redoStack.pop();
			executedStack.push(new MoveMemento(board, cm));
			cm.execute();
		}
	}
}
