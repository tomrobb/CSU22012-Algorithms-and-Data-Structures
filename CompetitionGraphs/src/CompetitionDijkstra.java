import java.io.*;
import java.util.*;

/**
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants
 * at three random city intersections. In order to win, the three contestants
 * need all to meet at any intersection of the city as fast as possible. It
 * should be clear that the contestants may arrive at the intersections at
 * different times, in which case, the first to arrive can wait until the others
 * arrive. From an estimated walking speed for each one of the three
 * contestants, ACM wants to determine the minimum time that a live TV broadcast
 * should last to cover their journey regardless of the contestants’ initial
 * positions and the intersection they finally meet. You are hired to help ACM
 * answer this question. You may assume the following:  Each contestant walks
 * at a given estimated speed.  The city is a collection of intersections in
 * which some pairs are connected by one-way streets that the contestants can
 * use to traverse the city.
 *
 * @author Tom Roberts
 *
 *         This class implements the competition using Dijkstra's algorithm
 **/

public class CompetitionDijkstra {

	public String fileName;
	public int sA;
	public int sB;
	public int sC;
	public double distTo[][];
	public int edgeTo[][];
	public int edgeCount;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA,       sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra(String filename, int sA, int sB, int sC) {

		// TODO
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;

		try {
			File inputFile = new File(filename);
			Scanner scanner = new Scanner(inputFile);
			int i = 0;

			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().trim().split("\\s+");

				if (i == 0) {
					distTo = new double[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					edgeTo = new int[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					for (int a = 0; a < distTo.length; a++) {
						for (int b = 0; b < distTo[a].length; b++) {
							distTo[a][b] = Integer.MAX_VALUE;
							if (a == b) {
								distTo[a][b] = 0;
							}
						}
					}
				} else if (i == 1) {
					edgeCount = Integer.parseInt(line[i - 1]);
				} else {
					distTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Double.parseDouble(line[2]);
					edgeTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[0]);

				}
				i++;
			}
			for (int j = 0; j < distTo.length; j++) {
				dijkstraShortestPath(j);
			}
			scanner.close();
		} catch (Exception x) {
			distTo = new double[0][0];
			edgeTo = new int[0][0];
			return;
		}
	}

	public void dijkstraShortestPath(int k) {

		boolean[] shortestPath = new boolean[distTo.length];
		shortestPath[k] = true;
		while (true) {
			int x = -1;
			for (int i = 0; i < distTo.length; i++) {
				if ((shortestPath[i] == false) && (distTo[k][i] != Integer.MAX_VALUE)) {
					x = i;
					break; // break as new vertex is found
				}
			}
			if (x == -1) {
				return;
			}
			shortestPath[x] = true;

			for (int i = 0; i < distTo.length; i++) {
				if (distTo[k][x] + distTo[x][i] < distTo[k][i]) {
					distTo[k][i] = distTo[k][x] + distTo[x][i];
					shortestPath[i] = false;
					edgeTo[k][i] = x;
				}
			}
		}

	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {

		if ((sA < 50 || sA > 100) || (sB < 50 || sB > 100) || (sC < 50 || sC > 100)) {
			return -1;
		}
		int minSpeed = Math.min(sC, Math.min(sA, sB));
		double maxDistance = 0.0;

		for (int i = 0; i < distTo.length; i++) {
			for (int j = 0; j < distTo[i].length; j++) {
				if (distTo[i][j] == Integer.MAX_VALUE) return -1;
				else if (distTo[i][j] > maxDistance) {
					maxDistance = distTo[i][j];
				}
			}
		}
		int maxTime = (int) Math.ceil((maxDistance * 1000) / minSpeed);
		if (minSpeed <= 0 || maxDistance == 0) return -1;
		return maxTime;

	}

}