import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class node {
	int x;
	int y;
	char c;
	node p;

	node(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}

	node(int x, int y, char c, node parent) {
		this.x = x;
		this.y = y;
		this.c = c;
		p = parent;
	}

	@Override
	public String toString() {
		return ("(" + this.x + "," + this.y + "," + this.c + " " + p + ") ");
	}
}

class coor {
	int x;
	int y;

	coor(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class homework {
	static String color = new String();
	static char maxPlayer;
	static char minPlayer;
	static String move = new String();
	static double time = 0;
	static char[][] in = new char[16][16];
	static List<node> nodePosB = new ArrayList<>();
	static List<node> nodePosW = new ArrayList<>();
	static List<node> initialB = new ArrayList<>();
	static List<node> initialW = new ArrayList<>();
	static char[][] initial = new char[16][16];

	/*
	 * public static node nInpamp(node n) { node pMove = null; node m = eva(n); if
	 * (n.c == 'B') { if (m.x >= n.x && m.y >= n.y) { pMove = m; } } if (n.c == 'W')
	 * { if (m.x <= n.x && m.y <= n.y) { pMove = m; } } return pMove; }
	 */
	/*
	 * public static node eva(node n, List<node> needmove) { node bestNode = null;
	 * double bestV = 10000; List<node> allM = needmove; if (n.c == 'B') { for (node
	 * m : allM) { double a = Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 - m.y,
	 * 2)); if (a <= bestV) { bestNode = m; bestV = a; } } }
	 *
	 * if (n.c == 'W') { for (node m : allM) { double a = Math.sqrt(Math.pow(m.x -
	 * 0, 2) + Math.pow(m.y - 0, 2)); if (a <= bestV) { bestNode = m; bestV = a; } }
	 * } return bestNode; }
	 *
	 * public static node eva(node n) { node bestNode = null; double bestV = 10000;
	 * List<node> allM = new ArrayList<>(); allM = validM(n); if (n.c == 'B') { for
	 * (node m : allM) { double a = Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 -
	 * m.y, 2)); if (a <= bestV) { bestNode = m; bestV = a; } } }
	 *
	 * if (n.c == 'W') { for (node m : allM) { double a = Math.sqrt(Math.pow(m.x -
	 * 0, 2) + Math.pow(m.y - 0, 2)); if (a <= bestV) { bestNode = m; bestV = a; } }
	 * } return bestNode; }
	 *
	 * public static node evaluation(char c, List<node> k) { List<node> goodMove =
	 * new ArrayList<>(); node bestNode = null; double bestV = 0; if (c == 'B') {
	 * for (node n : k) { goodMove.add(eva(n)); } for (node m : goodMove) { if (m !=
	 * null) { node l = m.p; while (l.p != null) { l = l.p; } double a =
	 * Math.sqrt(Math.pow(15 - l.x, 2) + Math.pow(15 - l.y, 2)) -
	 * Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 - m.y, 2));
	 *
	 * // double a = Math.sqrt(Math.pow(m.x - 0, 2) + Math.pow(m.y - 0, 2)); //- //
	 * Math.sqrt(Math.pow(m.p.x - 0, 2) + Math.pow(m.p.y - 0, 2)); if (a >= bestV) {
	 * bestNode = m; bestV = a; } // test // System.out.println(m); } } } if (c ==
	 * 'W') { for (node n : k) { goodMove.add(eva(n)); } for (node m : goodMove) {
	 * if (m != null) { node l = m.p; while (l.p != null) { l = l.p; } double a =
	 * Math.sqrt(Math.pow(l.x - 0, 2) + Math.pow(l.y - 0, 2)) -
	 * Math.sqrt(Math.pow(m.x - 0, 2) + Math.pow(m.y - 0, 2)); // double a =
	 * Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 - m.y - 0, 2)); //- //
	 * Math.sqrt(Math.pow(15 - m.p.x, 2) + Math.pow(15 - m.p.y - 0, 2)); if (a >=
	 * bestV) { bestNode = m; bestV = a; } // test // System.out.println(m); } } }
	 *
	 * return bestNode; }
	 */
	public static void main(String[] args) throws FileNotFoundException {

//		PrintStream o = new PrintStream("testoutput.txt");
//		PrintStream console = System.out;
//		System.setOut(o);

		long tStart = System.currentTimeMillis();

		initialB.add(new node(0, 0, 'B'));
		initialB.add(new node(0, 1, 'B'));
		initialB.add(new node(0, 2, 'B'));
		initialB.add(new node(0, 3, 'B'));
		initialB.add(new node(0, 4, 'B'));
		initialB.add(new node(1, 0, 'B'));
		initialB.add(new node(1, 1, 'B'));
		initialB.add(new node(1, 2, 'B'));
		initialB.add(new node(1, 3, 'B'));
		initialB.add(new node(1, 4, 'B'));
		initialB.add(new node(2, 0, 'B'));
		initialB.add(new node(2, 1, 'B'));
		initialB.add(new node(2, 2, 'B'));
		initialB.add(new node(2, 3, 'B'));
		initialB.add(new node(3, 0, 'B'));
		initialB.add(new node(3, 1, 'B'));
		initialB.add(new node(3, 2, 'B'));
		initialB.add(new node(4, 0, 'B'));
		initialB.add(new node(4, 1, 'B'));

		initialW.add(new node(15, 15, 'W'));
		initialW.add(new node(15, 14, 'W'));
		initialW.add(new node(15, 13, 'W'));
		initialW.add(new node(15, 12, 'W'));
		initialW.add(new node(15, 11, 'W'));
		initialW.add(new node(14, 15, 'W'));
		initialW.add(new node(14, 14, 'W'));
		initialW.add(new node(14, 13, 'W'));
		initialW.add(new node(14, 12, 'W'));
		initialW.add(new node(14, 11, 'W'));
		initialW.add(new node(13, 15, 'W'));
		initialW.add(new node(13, 14, 'W'));
		initialW.add(new node(13, 13, 'W'));
		initialW.add(new node(13, 12, 'W'));
		initialW.add(new node(12, 15, 'W'));
		initialW.add(new node(12, 14, 'W'));
		initialW.add(new node(12, 13, 'W'));
		initialW.add(new node(11, 15, 'W'));
		initialW.add(new node(11, 14, 'W'));

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				initial[i][j] = '.';
			}
		}
		for (node n : initialB) {
			initial[n.y][n.x] = n.c;
		}
		for (node n : initialW) {
			initial[n.y][n.x] = n.c;
		}

		read();

		// show input.txt
//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 16; j++) {
//				System.out.print(in[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
		// done
//
//		for (int i = 0; i < 19; i++) {
//			System.out.print(nodePosB.get(i));
//		}
//		System.out.print("\n");
//		for (int i = 0; i < 19; i++) {
//			System.out.print(nodePosW.get(i));
//		}
//		System.out.print("\n");
//
//		System.out.println(checkGoal('W', in));
//		System.out.println(checkGoal('B', in));

		// validMove(nodePosB.get(0));

		// System.out.println("eva of 99");
		// System.out.println(eva(new node(10,9,'W')));
		// System.out.println(evaluation('B'));

//		System.out.println("move:");
//		if (color.equals("WHITE")) {
//			move('W');
//		}
//		if (color.equals("BLACK")) {
//			move('B');
//		}
//		move('B');

		if (color.equals("WHITE")) {
			maxPlayer = 'W';
			minPlayer = 'B';
		}
		if (color.equals("BLACK")) {
			maxPlayer = 'B';
			minPlayer = 'W';
		}
//		System.out.println(score('W', in));
//		System.out.println(score('B', in));

		// printBoard();
		// System.out.println("----------");

		// System.out.println(getAllValidMove('B', in));

//		for (node n : nodePosB) {
//			System.out.print(validM(n, in));
//		}

		if (time >= 9) {
			printOutput(firstMiniMax(maxPlayer, 3, in, Integer.MIN_VALUE, Integer.MAX_VALUE));
		} else {
			printOutput(firstMiniMax(maxPlayer, 2, in, Integer.MIN_VALUE, Integer.MAX_VALUE));
		}

		// double m = miniMax(maxPlayer, 2, in, Integer.MIN_VALUE, Integer.MAX_VALUE);
		// System.out.println(m);
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		// System.out.println("time consumed: " + elapsedSeconds);
		// System.out.println(firstMiniMax(maxPlayer, 4, in, Integer.MIN_VALUE,
		// Integer.MAX_VALUE));

		// test output board and best value
//		System.out.println("---test---");
//		System.out.println(getTarget(maxPlayer, in).x + "," + getTarget(maxPlayer, in).y);
//		System.out.println(getAllValidMove('B', in));

		// System.out.println(firstMiniMax(maxPlayer, 3, in, Integer.MIN_VALUE,
		// Integer.MAX_VALUE));
		// printBoard(initial);
	}

	private static void read() {
		File file = new File("input.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			move = br.readLine().trim();
			color = br.readLine().trim();
			time = Double.parseDouble(br.readLine().trim());
			String st;
			for (int i = 0; i < 16; i++) {
				st = br.readLine().trim();
				for (int j = 0; j < 16; j++) {
					in[i][j] = st.charAt(j);
					if (in[i][j] == 'B') {
						node readintestNode = new node(j, i, 'B');
						nodePosB.add(readintestNode); // , new node(j, i, 'B')));
						// System.out.println("readin color: " + readintestNode.c);
					}
					if (in[i][j] == 'W') {
						node readintestNode = new node(j, i, 'W');
						nodePosW.add(readintestNode);// , new node(j, i, 'W')));
						// System.out.println("readin color: " + readintestNode.c);
					}
				}
			}

			br.close();
		} catch (Exception E) {
		}
	}

	private static List<node> needMove(char c, char[][] board) {
		List<node> moveFirst = new ArrayList<>();
		if (c == 'B') {
			for (node a : initialB) {
				if (board[a.y][a.x] == 'B') {
					moveFirst.add(new node(a.x, a.y, a.c));
				}
			}
		}
		if (c == 'W') {
			for (node a : initialW) {
				if (board[a.y][a.x] == 'W') {
					moveFirst.add(new node(a.x, a.y, a.c));
				}
			}
		}
		return moveFirst;
	}

	/*
	 * private static List<node> validM(node n) { List<node> valid = new
	 * ArrayList<>(); valid.addAll(validMove(n)); valid.addAll(validJump(n)); for
	 * (node m : valid) { // Printing here !!!! // System.out.println(m); } return
	 * valid; }
	 *
	 * private static List<node> validMove(node n) { List<node> dir = new
	 * ArrayList<>();
	 *
	 * if (n.y - 1 >= 0 && n.x - 1 >= 0 && in[n.y - 1][n.x - 1] == '.') {
	 * dir.add(new node(n.x - 1, n.y - 1, n.c, n)); } if (n.x - 1 >= 0 &&
	 * in[n.y][n.x - 1] == '.') { dir.add(new node(n.x - 1, n.y, n.c, n)); } if (n.y
	 * + 1 < 16 && n.x - 1 >= 0 && in[n.y + 1][n.x - 1] == '.') { dir.add(new
	 * node(n.x - 1, n.y + 1, n.c, n)); } if (n.y - 1 >= 0 && in[n.y - 1][n.x] ==
	 * '.') { dir.add(new node(n.x, n.y - 1, n.c, n)); } if (n.y + 1 < 16 && in[n.y
	 * + 1][n.x] == '.') { dir.add(new node(n.x, n.y + 1, n.c, n)); } if (n.y - 1 >=
	 * 0 && n.x + 1 < 16 && in[n.y - 1][n.x + 1] == '.') { dir.add(new node(n.x + 1,
	 * n.y - 1, n.c, n)); } if (n.x + 1 < 16 && in[n.y][n.x + 1] == '.') {
	 * dir.add(new node(n.x + 1, n.y, n.c, n)); } if (n.y + 1 < 16 && n.x + 1 < 16
	 * && in[n.y + 1][n.x + 1] == '.') { dir.add(new node(n.x + 1, n.y + 1, n.c,
	 * n)); } for (node c : dir) { // System.out.println(c.x + " " + c.y); //
	 * System.out.println(c); } return dir; }
	 *
	 * private static List<node> validJump(node n) { boolean m[][] = new
	 * boolean[16][16]; return validJump(n, m); }
	 *
	 * private static List<node> validJump(node n, boolean[][] b) { List<node> dir =
	 * new ArrayList<>();
	 *
	 * if (n.y - 2 >= 0 && n.x - 2 >= 0 && in[n.y - 2][n.x - 2] == '.' && in[n.y -
	 * 1][n.x - 1] != '.' && b[n.y - 2][n.x - 2] == false) { dir.add(new node(n.x -
	 * 2, n.y - 2, n.c, n)); b[n.y - 2][n.x - 2] = true; } if (n.x - 2 >= 0 &&
	 * in[n.y][n.x - 2] == '.' && in[n.y][n.x - 1] != '.' && b[n.y][n.x - 2] ==
	 * false) { dir.add(new node(n.x - 2, n.y, n.c, n)); b[n.y][n.x - 2] = true; }
	 * if (n.y + 2 < 16 && n.x - 2 >= 0 && in[n.y + 2][n.x - 2] == '.' && in[n.y +
	 * 1][n.x - 1] != '.' && b[n.y + 2][n.x - 2] == false) { dir.add(new node(n.x -
	 * 2, n.y + 2, n.c, n)); b[n.y + 2][n.x - 2] = true; } if (n.y - 2 >= 0 &&
	 * in[n.y - 2][n.x] == '.' && in[n.y - 1][n.x] != '.' && b[n.y - 2][n.x] ==
	 * false) { dir.add(new node(n.x, n.y - 2, n.c, n)); b[n.y - 2][n.x] = true; }
	 * if (n.y + 2 < 16 && in[n.y + 2][n.x] == '.' && in[n.y + 1][n.x] != '.' &&
	 * b[n.y + 2][n.x] == false) { dir.add(new node(n.x, n.y + 2, n.c, n)); b[n.y +
	 * 2][n.x] = true; } if (n.y - 2 >= 0 && n.x + 2 < 16 && in[n.y - 2][n.x + 2] ==
	 * '.' && in[n.y - 1][n.x + 1] != '.' && b[n.y - 2][n.x + 2] == false) {
	 * dir.add(new node(n.x + 2, n.y - 2, n.c, n)); b[n.y - 2][n.x + 2] = true; } if
	 * (n.x + 2 < 16 && in[n.y][n.x + 2] == '.' && in[n.y][n.x + 1] != '.' &&
	 * b[n.y][n.x + 2] == false) { dir.add(new node(n.x + 2, n.y, n.c, n));
	 * b[n.y][n.x + 2] = true; } if (n.y + 2 < 16 && n.x + 2 < 16 && in[n.y + 2][n.x
	 * + 2] == '.' && in[n.y + 1][n.x + 1] != '.' && b[n.y + 2][n.x + 2] == false) {
	 * dir.add(new node(n.x + 2, n.y + 2, n.c, n)); b[n.y + 2][n.x + 2] = true; }
	 *
	 * List<node> child = new ArrayList<node>(); for (node c : dir) {
	 * child.addAll(validJump(c, b)); } dir.addAll(child);
	 *
	 * return dir; }
	 */
	/*
	 * public static node moveBest(char c, List<node> bestnodes) { node bestNode =
	 * null; double bestV = 0; if (c == 'B') { for (node m : bestnodes) { if (m !=
	 * null) { node l = m.p; while (l.p != null) { l = l.p; } double a =
	 * Math.sqrt(Math.pow(15 - l.x, 2) + Math.pow(15 - l.y, 2)) -
	 * Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 - m.y, 2));
	 *
	 * // double a = Math.sqrt(Math.pow(m.x - 0, 2) + Math.pow(m.y - 0, 2)); //- //
	 * Math.sqrt(Math.pow(m.p.x - 0, 2) + Math.pow(m.p.y - 0, 2)); if (a >= bestV) {
	 * bestNode = m; bestV = a; } } } } if (c == 'W') { for (node m : bestnodes) {
	 * if (m != null) { node l = m.p; while (l.p != null) { l = l.p; } double a =
	 * Math.sqrt(Math.pow(l.x - 0, 2) + Math.pow(l.y - 0, 2)) -
	 * Math.sqrt(Math.pow(m.x - 0, 2) + Math.pow(m.y - 0, 2)); // double a =
	 * Math.sqrt(Math.pow(15 - m.x, 2) + Math.pow(15 - m.y - 0, 2)); //- //
	 * Math.sqrt(Math.pow(15 - m.p.x, 2) + Math.pow(15 - m.p.y - 0, 2)); if (a >=
	 * bestV) { bestNode = m; bestV = a; } } } }
	 *
	 * return bestNode; }
	 */
	/*
	 * private static void move(char c) { List<node> result = new ArrayList<>();
	 * List<node> checked = new ArrayList<>(); List<node> inCamp = needMove(c);
	 * List<node> bestnodes = new ArrayList<>(); for (node n : inCamp) { List<node>
	 * m = moveOutOfCamp(n); if (m != null) { checked.addAll(m); } }
	 *
	 * if (checked.size() != 0) { // move the best for (node n : inCamp) {
	 * bestnodes.add(eva(n, checked)); } System.out.println(moveBest(c, bestnodes));
	 * return; } for (node n : inCamp) { node m = nInCamp(n); if (m != null) {
	 * result.add(n); } }
	 *
	 * if (c == 'B') { if (result.size() != 0) { System.out.println(evaluation('B',
	 * result)); } else { System.out.println(evaluation('B', nodePosB)); } } if (c
	 * == 'W') { if (result.size() != 0) { System.out.println(evaluation('W',
	 * result)); } else { System.out.println(evaluation('W', nodePosW)); } } }
	 */
	private static boolean checkGoal(char c, char[][] nodepos) {
		int count = 0;

		// System.out.println("checking goal for "+ c);

		// printBoard(nodepos);
		if (c == 'W') {
			for (node n : initialB) {
				if (nodepos[n.y][n.x] == '.') {
					return false;
				}
				if (nodepos[n.y][n.x] == 'W') {
					count++;
				}
			}
			// System.out.println("w has won? "+ (count>0));
			return (count > 0);
		}
		if (c == 'B') {
			for (node n : initialW) {
				if (nodepos[n.y][n.x] == '.') {
					return false;
				}
				if (nodepos[n.y][n.x] == 'B') {
					count++;
				}
			}
			// System.out.println("b has won? "+ (count>0));

			return (count > 0);
		}
		return false;
	}

	public static node firstMiniMax(char curPlayer, int depth, char[][] board, double alpha, double beta) {
		node bestMove = null;
		double val = 0;
		List<node> posW = new ArrayList<node>();
		List<node> posB = new ArrayList<node>();

		// coor targetW = getTarget('W', board);
		// coor targetB = getTarget('B', board);

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (board[i][j] == 'B') {
					posB.add(new node(j, i, 'B', null));
				}
				if (board[i][j] == 'W') {
					posW.add(new node(j, i, 'W', null));
				}
			}
		}

		List<node> valid = new ArrayList<node>();
		if (curPlayer == 'W') {
			valid.addAll(getAllValidMove('W', board));
//			for (node n : posW) {
//				valid.addAll(validM(n, board));
//			}
		}
		if (curPlayer == 'B') {
			valid.addAll(getAllValidMove('B', board));
//			for (node n : posB) {
//				valid.addAll(validM(n, board));
//			}
		}

		double bestVal = Integer.MIN_VALUE;
		for (node n : valid) {
			char[][] newBoard = new char[16][16];
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					newBoard[i][j] = board[i][j];
				}
			}
			newBoard[n.y][n.x] = n.c;
			node m = n;
			while (m.p != null) {
				m = m.p;
			}
			newBoard[m.y][m.x] = '.';
			coor targetW = getTarget('W', newBoard);
			coor targetB = getTarget('B', newBoard);
			val = miniMax(minPlayer, depth - 1, newBoard, board, alpha, beta, targetW, targetB);
			// val = score(maxPlayer, newBoard, targetW, targetB);
			// printBoard(newBoard);
//			System.out.println("current step: " + n);
//			System.out.println("val: " + val);
//			System.out.println(targetW.x + "," + targetW.y);

			if (val > bestVal) {
				bestVal = val;
				bestMove = n;
			}
		}

//		System.out.println(valid);
//
//		System.out.println(bestVal);
		return bestMove;
	}

	public static double miniMax(char curPlayer, int depth, char[][] board, char[][] oldBoard, double alpha,
			double beta, coor targetW, coor targetB) {
		List<node> posW = new ArrayList<node>();
		List<node> posB = new ArrayList<node>();

		// change here
		// targetW = getTarget('W', board);
		// targetB = getTarget('B', board);

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (board[i][j] == 'B') {
					posB.add(new node(j, i, 'B', null));
				}
				if (board[i][j] == 'W') {
					posW.add(new node(j, i, 'W', null));
				}
			}
		}

//		if (posB.size() != 19) {
//			System.out.println("posB size not 19");
//			printBoard(board);
//			System.exit(0);
//		}
//		if (posW.size() != 19) {
//			System.out.println("posW size not 19");
//			printBoard(board);
//			System.exit(0);
//		}

		if (depth == 0 || checkGoal('W', board) || checkGoal('B', board)) {
			coor oldTargetW = getTarget('W', oldBoard);
			coor oldTargetB = getTarget('B', oldBoard);
			return score(curPlayer, board, oldTargetW, oldTargetB);
		}

		List<node> valid = new ArrayList<node>();

		valid.addAll(getAllValidMove(curPlayer, board));

		// System.out.println(valid);
		if (curPlayer == maxPlayer) {
			double bestVal = Integer.MIN_VALUE;
			for (node n : valid) {
				char[][] newBoard = new char[16][16];
				for (int i = 0; i < 16; i++) {
					for (int j = 0; j < 16; j++) {
						newBoard[i][j] = board[i][j];
					}
				}
				// System.out.println("current: " + n);
				newBoard[n.y][n.x] = n.c;

//				List<node> checkWList = new ArrayList<node>();
//				List<node> checkBList = new ArrayList<node>();
//				for (int i = 0; i < 16; i++) {
//					for (int j = 0; j < 16; j++) {
//						if (newBoard[i][j] == 'B') {
//							checkBList.add(new node(j, i, 'B', null));
//						}
//						if (newBoard[i][j] == 'W') {
//							checkWList.add(new node(j, i, 'W', null));
//						}
//					}
//				}

				while (n.p != null) {
					n = n.p;
				}
				newBoard[n.y][n.x] = '.';

//				System.out.print("check W size: " + checkWList.size() + "\n");
//				if (checkWList.size() < 20) {
//					System.out.println(" trying step:  " + n);
//					printBoard(newBoard);
//					System.exit(0);
//				}
//				System.out.print("check B size: " + checkBList.size() + "\n");
//				if (checkBList.size() != 19) {
//					printBoard(newBoard);
//					System.exit(0);
//				}
//				System.out.print("check B size: " + checkBList.size());

				// printBoard(newBoard);

				coor newTargetW = getTarget('W', newBoard);
				coor newTargetB = getTarget('B', newBoard);
				double value = miniMax(minPlayer, depth - 1, newBoard, board, alpha, beta, newTargetW, newTargetB);
				// System.out.println("test: " + value);
				bestVal = Math.max(bestVal, value);
				alpha = Math.max(alpha, bestVal);
				if (beta <= alpha) {
					break;
				}
			}
			return bestVal;
		} else {
			double bestVal = Integer.MAX_VALUE;
			for (node n : valid) {
				char[][] newBoard = new char[16][16];
				for (int i = 0; i < 16; i++) {
					for (int j = 0; j < 16; j++) {
						newBoard[i][j] = board[i][j];
					}
				}
				newBoard[n.y][n.x] = n.c;
				while (n.p != null) {
					n = n.p;
				}
				newBoard[n.y][n.x] = '.';
				coor newTargetW = getTarget('W', newBoard);
				coor newTargetB = getTarget('B', newBoard);
				double value = miniMax(maxPlayer, depth - 1, newBoard, board, alpha, beta, newTargetW, newTargetB);
				bestVal = Math.min(bestVal, value);
				beta = Math.min(beta, bestVal);
				if (beta <= alpha) {
					break;
				}
			}
			// System.out.println(bestVal);
			return bestVal;
		}
	}

	public static coor getTarget(char player, char[][] board) {

		if (player == 'W') {
			coor target = new coor(0, 0);
			if (board[0][0] == 'W') {
				target.x = 0;
				target.y = 1;
				if (board[1][0] == 'W') {
					target.x = 1;
					target.y = 0;
					if (board[0][1] == 'W') {
						target.x = 1;
						target.y = 1;
						if (board[1][1] == 'W') {
							target.x = 0;
							target.y = 2;
							if (board[2][0] == 'W') {
								target.x = 2;
								target.y = 0;
								if (board[0][2] == 'W') {
									target.x = 1;
									target.y = 2;
									if (board[2][1] == 'W') {
										target.x = 2;
										target.y = 1;
										if (board[1][2] == 'W') {
											target.x = 0;
											target.y = 3;
											if (board[3][0] == 'W') {
												target.x = 3;
												target.y = 0;
												if (board[0][3] == 'W') {
													target.x = 2;
													target.y = 2;
													if (board[2][2] == 'W') {
														target.x = 1;
														target.y = 3;
														if (board[3][1] == 'W') {
															target.x = 3;
															target.y = 1;
															if (board[1][3] == 'W') {
																target.x = 0;
																target.y = 4;
																if (board[3][1] == 'W') {
																	target.x = 4;
																	target.y = 0;
																	if (board[0][4] == 'W') {
																		target.x = 2;
																		target.y = 3;
																		if (board[3][2] == 'W') {
																			target.x = 3;
																			target.y = 2;
																			if (board[2][3] == 'W') {
																				target.x = 1;
																				target.y = 4;
																				if (board[4][1] == 'W') {
																					target.x = 4;
																					target.y = 1;
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return target;
		} else {
			coor target = new coor(15, 15);
			if (board[15][15] == 'B') {
				target.x = 15;
				target.y = 14;
				if (board[14][15] == 'B') {
					target.x = 14;
					target.y = 15;
					if (board[15][14] == 'B') {
						target.x = 14;
						target.y = 14;
						if (board[14][14] == 'B') {
							target.x = 15;
							target.y = 13;
							if (board[13][15] == 'B') {
								target.x = 13;
								target.y = 15;
								if (board[15][13] == 'B') {
									target.x = 14;
									target.y = 13;
									if (board[13][14] == 'B') {
										target.x = 13;
										target.y = 14;
										if (board[14][13] == 'B') {
											target.x = 15;
											target.y = 12;
											if (board[12][15] == 'B') {
												target.x = 12;
												target.y = 15;
												if (board[15][12] == 'B') {
													target.x = 13;
													target.y = 13;
													if (board[13][13] == 'B') {
														target.x = 14;
														target.y = 12;
														if (board[12][14] == 'B') {
															target.x = 12;
															target.y = 14;
															if (board[14][12] == 'B') {
																target.x = 15;
																target.y = 11;
																if (board[12][14] == 'B') {
																	target.x = 11;
																	target.y = 15;
																	if (board[15][11] == 'B') {
																		target.x = 13;
																		target.y = 12;
																		if (board[12][13] == 'B') {
																			target.x = 12;
																			target.y = 13;
																			if (board[13][12] == 'B') {
																				target.x = 14;
																				target.y = 11;
																				if (board[11][14] == 'B') {
																					target.x = 11;
																					target.y = 14;
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}
			return target;
		}

	}

	public static double score(char player, char[][] board, coor targetW, coor targetB) {
		double best = 0;
		double w0 = 0;
		double w1 = 0;
		double b0 = 0;
		double b1 = 0;
//		coor target = getTarget('W', board);
//		System.out.println(target.x + "," + target.y);
//		coor targetB = getTarget('B', board);

		List<node> posW = new ArrayList<node>();
		List<node> posB = new ArrayList<node>();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (board[i][j] == 'B') {
					posB.add(new node(j, i, 'B', null));
				}
				if (board[i][j] == 'W') {
					posW.add(new node(j, i, 'W', null));
				}
			}
		}

//		System.out.println(maxPlayer);
//		System.out.println(minPlayer);

		if (checkGoal(maxPlayer, board)) {
			// printBoard(board);
			return 10000;
		}
		if (checkGoal(minPlayer, board)) {
			// printBoard(board);
			return -10000;
		}

		// printBoard(board);

		for (node n : posB) {
			b1 += Math.sqrt(Math.pow(targetB.x - n.x, 2) + Math.pow(targetB.y - n.y, 2));
		}
		for (node m : nodePosB) {
			b0 += Math.sqrt(Math.pow(targetB.x - m.x, 2) + Math.pow(targetB.y - m.y, 2));
		}

		for (node n : posW) {
			w1 += Math.sqrt(Math.pow(n.x - targetW.x, 2) + Math.pow(n.y - targetW.y, 2));
			// System.out.println("a: " + a);
		}
		for (node m : nodePosW) {
			w0 += Math.sqrt(Math.pow(m.x - targetW.x, 2) + Math.pow(m.y - targetW.y, 2));
			// System.out.println("b: " + b);
		}
		if (maxPlayer == 'W') {
//			System.out.println("posW    ####" + posW.size());
//			System.out.println("w0: " + w0 + " #w1: " + w1);

			best = (w0 - w1) - 0.6 * Math.abs(b0 - b1);
		} else {
//			System.out.println("posB" + posB.size());
//
//			System.out.println("b0: " + b0 + " #b1: " + b1);

			best = (b0 - b1) - 0.6 * Math.abs(w0 - w1);
		}
//
//		if (player == 'W') {
//
//			for (node n : posB) {
//				b1 += Math.sqrt(Math.pow(targetB.x - n.x, 2) + Math.pow(targetB.y - n.y, 2));
//			}
//			for (node m : nodePosB) {
//				b0 += Math.sqrt(Math.pow(targetB.x - m.x, 2) + Math.pow(targetB.y - m.y, 2));
//			}
//
//			for (node n : posW) {
//				w1 += Math.sqrt(Math.pow(n.x - targetW.x, 2) + Math.pow(n.y - targetW.y, 2));
//				// System.out.println("a: " + a);
//			}
//			for (node m : nodePosW) {
//				w0 += Math.sqrt(Math.pow(m.x - targetW.x, 2) + Math.pow(m.y - targetW.y, 2));
//				// System.out.println("b: " + b);
//			}
//			if (player == maxPlayer) {
//				best = (w0 - w1) - 0.6 * Math.abs(b0 - b1);
//			}
//			if (player == minPlayer) {
//				best = (b0 - b1) - 0.6 * Math.abs(w0 - w1);
//			}
//
//		}
//		if (player == 'B') {
//			for (node n : posB) {
//				b1 += Math.sqrt(Math.pow(targetB.x - n.x, 2) + Math.pow(targetB.y - n.y, 2));
//			}
//			for (node m : nodePosB) {
//				b0 += Math.sqrt(Math.pow(targetB.x - m.x, 2) + Math.pow(targetB.y - m.y, 2));
//			}
//
//			for (node n : posW) {
//				w1 += Math.sqrt(Math.pow(n.x - targetW.x, 2) + Math.pow(n.y - targetW.y, 2));
//				// System.out.println("a: " + a);
//			}
//			for (node m : nodePosW) {
//				w0 += Math.sqrt(Math.pow(m.x - targetW.x, 2) + Math.pow(m.y - targetW.y, 2));
//				// System.out.println("b: " + b);
//			}
//			if (player == maxPlayer) {
//				best = (b0 - b1) - 0.6 * Math.abs(w0 - w1);
//			}
//			if (player == minPlayer) {
//				best = (w0 - w1) - 0.6 * Math.abs(b0 - b1);
//			}
//		}
//

//		printBoard(board);
//		System.out.println(targetW.x + "," + targetW.y);
//		System.out.println("best:" + best);
		return best;

	}

	private static List<node> getAllValidMove(char c, char[][] newIn) {
		List<node> allValidMove = new ArrayList<node>();
		List<node> checked = new ArrayList<node>();
		List<node> posW = new ArrayList<node>();
		List<node> posB = new ArrayList<node>();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (newIn[i][j] == 'B') {
					posB.add(new node(j, i, 'B', null));
				}
				if (newIn[i][j] == 'W') {
					posW.add(new node(j, i, 'W', null));
				}
			}
		}
//		for (node n : posB) {
//			if (n.c != 'W' && n.c != 'B') {
//				System.out.println("invalid starting point!!!!!!!!!!!!!!!!!!");
//				System.exit(0);
//			}
//		}

		List<node> inCamp = needMove(c, newIn);
		for (node n : inCamp) {
			List<node> m = moveOutOfCamp(n, newIn);
			if (m != null && m.size() != 0) {
				checked.addAll(m);
			}
		}
		// need check
		if (checked.size() != 0) {
			return checked;
		}

		List<node> moveFurther = new ArrayList<node>();
		for (node n : inCamp) {
			if (n.c == 'B') {
				List<node> moveInCamp = validM(n, newIn, 1);
				for (node m : moveInCamp) {
					if (m.x >= n.x && m.y >= n.y) {
						moveFurther.add(m);
					}
				}
			}
			if (n.c == 'W') {
				List<node> moveInCamp = validM(n, newIn, 1);
				for (node m : moveInCamp) {
					if (m.x <= n.x && m.y <= n.y) {
						moveFurther.add(m);
					}
				}
			}
		}
		if (moveFurther.size() != 0) {
			return moveFurther;
		}

		if (c == 'W') {
			for (node n : posW) {
				allValidMove.addAll(validM(n, newIn, 1));
			}
			if (allValidMove.size() <= 1) {
				List<node> newValid = new ArrayList<node>();
				for (node n : posW) {
					if (outSideEnermyBase(n, newIn)) {
						newValid.addAll(validM(n, newIn, 2));
					}
				}
				allValidMove = newValid;
//				printBoard(newIn);
//				for (node m : allValidMove) {
//					System.out.println("m in allvalidmove: " + m);
//				}
			}
		}
		if (c == 'B') {
			for (node n : posB) {
				allValidMove.addAll(validM(n, newIn, 1));
			}
			if (allValidMove.size() <= 1) {
				// System.out.println("valid < 3: " + allValidMove);
				List<node> newValid = new ArrayList<node>();
				for (node n : posB) {
					if (outSideEnermyBase(n, newIn)) {
						newValid.addAll(validM(n, newIn, 2));
					}
				}
				allValidMove = newValid;
				// System.out.println("all valid move: " + allValidMove);
			}
		}
		// System.out.println("all valid move: " + allValidMove);
		return allValidMove;
	}

	public static List<node> moveOutOfCamp(node n, char[][] board) {
		List<node> allvalid = validM(n, board, 2);
		List<node> checked = new ArrayList<>();
		for (node m : allvalid) {
			if (initial[m.y][m.x] == '.') {
				checked.add(m);
			}
		}
		return checked;
	}

	public static boolean outSideEnermyBase(node n, char[][] board) {
		if (initial[n.y][n.x] == '.') {
			return true;
		} else {
			return false;
		}
	}

	// private static check if in target camp but move out

	private static List<node> validM(node n, char[][] newIn, int type) {
		List<node> valid = new ArrayList<>();
		valid.addAll(validMove(n, newIn));
		valid.addAll(validJump(n, newIn));

//		for (node validmresult : valid) {
//			if (validmresult.c != 'W' && validmresult.c != 'B') {
//				System.out.println("invalid jump!!!!!!!!!!!!!");
//				System.exit(0);
//			}
//		}
		List<node> less = new ArrayList<>();
		if (type == 1) {
			for (node m : valid) {
				node parent = m;
				if (n.c == 'W') {
					while (parent.p != null) {
						parent = parent.p;
					}
					if (parent.x >= m.x && parent.y >= m.y) {
						less.add(m);
					}
				}
				if (n.c == 'B') {
					while (parent.p != null) {
						parent = parent.p;
					}
					if (parent.x <= m.x && parent.y <= m.y) {
						less.add(m);
					}
				}
			}
		}
		// System.out.println(less);
		if (type == 2) {
			for (node m : valid) {
				node parent = m;
				if (n.c == 'W') {
					while (parent.p != null) {
						parent = parent.p;
					}
					if (parent.x >= m.x - 3 || parent.y >= m.y - 3) {
						less.add(m);
						// System.out.println("node m in type 2" + m);
					}
				}
				if (n.c == 'B') {
					while (parent.p != null) {
						parent = parent.p;
					}
					if (parent.x <= m.x + 3 || parent.y <= m.y + 3) {
						less.add(m);
						// System.out.println("node m in type 2" + m);
					}
				}
			}
			// less = valid;
		}
		// System.out.println(less);
		return less;
	}

	private static List<node> validMove(node n, char[][] newIn) {
		List<node> dir = new ArrayList<>();
//		if (n.c != 'W' && n.c != 'B') {
//			System.out.println("trying to move empty space");
//			System.exit(0);
//		}

		if (n.y - 1 >= 0 && n.x - 1 >= 0 && newIn[n.y - 1][n.x - 1] == '.') {
			dir.add(new node(n.x - 1, n.y - 1, n.c, n));
		}
		if (n.x - 1 >= 0 && newIn[n.y][n.x - 1] == '.') {
			dir.add(new node(n.x - 1, n.y, n.c, n));
		}
		if (n.y + 1 < 16 && n.x - 1 >= 0 && newIn[n.y + 1][n.x - 1] == '.') {
			dir.add(new node(n.x - 1, n.y + 1, n.c, n));
		}
		if (n.y - 1 >= 0 && newIn[n.y - 1][n.x] == '.') {
			dir.add(new node(n.x, n.y - 1, n.c, n));
		}
		if (n.y + 1 < 16 && newIn[n.y + 1][n.x] == '.') {
			dir.add(new node(n.x, n.y + 1, n.c, n));
		}
		if (n.y - 1 >= 0 && n.x + 1 < 16 && newIn[n.y - 1][n.x + 1] == '.') {
			dir.add(new node(n.x + 1, n.y - 1, n.c, n));
		}
		if (n.x + 1 < 16 && newIn[n.y][n.x + 1] == '.') {
			dir.add(new node(n.x + 1, n.y, n.c, n));
		}
		if (n.y + 1 < 16 && n.x + 1 < 16 && newIn[n.y + 1][n.x + 1] == '.') {
			dir.add(new node(n.x + 1, n.y + 1, n.c, n));
		}
//		for (node dstN : dir) {
//			if (dstN.c != 'W' && dstN.c != 'B') {
//				System.out.println("invalid walk generated");
//				System.exit(0);
//			}
//		}
		return dir;
	}

	private static List<node> validJump(node n, char[][] newIn) {
		boolean m[][] = new boolean[16][16];
		// System.out.println("validjump: " + validJump(n, m, newIn));
		// validJump(n, m, newIn);
		return validJump(n, m, newIn);
	}

	private static List<node> validJump(node n, boolean[][] b, char[][] newIn) {
		List<node> dir = new ArrayList<>();

		if (n.y - 2 >= 0 && n.x - 2 >= 0 && newIn[n.y - 2][n.x - 2] == '.' && newIn[n.y - 1][n.x - 1] != '.'
				&& b[n.y - 2][n.x - 2] == false) {
			dir.add(new node(n.x - 2, n.y - 2, n.c, n));
			b[n.y - 2][n.x - 2] = true;
		}
		if (n.x - 2 >= 0 && newIn[n.y][n.x - 2] == '.' && newIn[n.y][n.x - 1] != '.' && b[n.y][n.x - 2] == false) {
			dir.add(new node(n.x - 2, n.y, n.c, n));
			b[n.y][n.x - 2] = true;
		}
		if (n.y + 2 < 16 && n.x - 2 >= 0 && newIn[n.y + 2][n.x - 2] == '.' && newIn[n.y + 1][n.x - 1] != '.'
				&& b[n.y + 2][n.x - 2] == false) {
			dir.add(new node(n.x - 2, n.y + 2, n.c, n));
			b[n.y + 2][n.x - 2] = true;
		}
		if (n.y - 2 >= 0 && newIn[n.y - 2][n.x] == '.' && newIn[n.y - 1][n.x] != '.' && b[n.y - 2][n.x] == false) {
			dir.add(new node(n.x, n.y - 2, n.c, n));
			b[n.y - 2][n.x] = true;
		}
		if (n.y + 2 < 16 && newIn[n.y + 2][n.x] == '.' && newIn[n.y + 1][n.x] != '.' && b[n.y + 2][n.x] == false) {
			dir.add(new node(n.x, n.y + 2, n.c, n));
			b[n.y + 2][n.x] = true;
		}
		if (n.y - 2 >= 0 && n.x + 2 < 16 && newIn[n.y - 2][n.x + 2] == '.' && newIn[n.y - 1][n.x + 1] != '.'
				&& b[n.y - 2][n.x + 2] == false) {
			dir.add(new node(n.x + 2, n.y - 2, n.c, n));
			b[n.y - 2][n.x + 2] = true;
		}
		if (n.x + 2 < 16 && newIn[n.y][n.x + 2] == '.' && newIn[n.y][n.x + 1] != '.' && b[n.y][n.x + 2] == false) {
			dir.add(new node(n.x + 2, n.y, n.c, n));
			b[n.y][n.x + 2] = true;
		}
		if (n.y + 2 < 16 && n.x + 2 < 16 && newIn[n.y + 2][n.x + 2] == '.' && newIn[n.y + 1][n.x + 1] != '.'
				&& b[n.y + 2][n.x + 2] == false) {
			dir.add(new node(n.x + 2, n.y + 2, n.c, n));
			b[n.y + 2][n.x + 2] = true;
		}

		List<node> child = new ArrayList<node>();
		for (node c : dir) {
			child.addAll(validJump(c, b, newIn));
		}
		dir.addAll(child);

		return dir;
	}

	private static void printOutput(node n) {
		try {
			File file = new File("output.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			List<node> parentList = new ArrayList<node>();

			node m = n;
			parentList.add(m);

			while (m.p != null) {
				m = m.p;
				parentList.add(new node(m.x, m.y, m.c, null));
			}
			Collections.reverse(parentList);
			if (Math.abs(m.x - n.x) > 1 || Math.abs(m.y - n.y) > 1) {
				for (int i = 0; i < parentList.size() - 1; i++) {
					bw.write("J " + parentList.get(i).x + "," + parentList.get(i).y + " " + parentList.get(i + 1).x
							+ "," + parentList.get(i + 1).y);
					if (i != parentList.size() - 2) {
						bw.write("\n");
					}
				}
			} else {
				bw.write("E " + parentList.get(0).x + "," + parentList.get(0).y + " " + parentList.get(1).x + ","
						+ parentList.get(1).y);
			}

			// bw.write();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
