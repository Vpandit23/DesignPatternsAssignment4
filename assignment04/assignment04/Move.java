package assignment04;

public class Move implements Command {
	int from;
	int to;
	Board board;
	
	public Move (Board brd, int fromIn, int toIn) {
		board = brd;
		from = fromIn;
		to = toIn;
	}

	@Override
	public void execute() {
		String p = board.getICCF(from);
		board.setICCF(from, "  ");
		board.setICCF(to, p);
	}

	public int getFrom() {
		return from;
	}
	public int getTo() {
		return to;
	}
}
