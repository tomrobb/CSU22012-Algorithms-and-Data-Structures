import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
 *         This class implements tests both the Dijkstra and the Floyd-Warshall
 *         algorithms.
 **/

public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() {

		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		// TODO
		CompetitionFloydWarshall map;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	// TODO - more tests

	// Dijkstra: testing for using an invalid filename
	@Test
	public void testDInvalidFileName() {
		CompetitionDijkstra map;
		String fileName = "numbers.txt";
		int sA = 50;
		int sB = 70;
		int sC = 60;
		map = new CompetitionDijkstra(fileName, sA, sB, sC);
	}

	// Floyd-Warshall: testing for using an invalid filename
	@Test
	public void testFWInvalidFileName() {
		CompetitionFloydWarshall map;
		String fileName = "numbers.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		map = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Dijkstra: testing for when speed <= 0
	@Test
	public void testDNegativeSpeed() {
		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int sA = 0;
		int sB = 70;
		int sC = 60;
		map = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
		sA = -3;
		sB = -7;
		sC = -4;
		map = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	// Dijkstra: testing for when speed <= 0
	@Test
	public void testFWNegativeSpeed() {
		CompetitionFloydWarshall map;
		String fileName = "tinyEWD.txt";
		int sA = 0;
		int sB = 70;
		int sC = 60;
		map = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
		sA = -3;
		sB = -7;
		sC = -4;
		map = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	// Testing the requirements for speed A, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedA <= 100)
	//
	@Test
	public void testSpeedA() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed a < 50
		int sA = 40;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed a > 100
		sA = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing the requirements for speed B, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedB <= 100)
	//
	@Test
	public void testSpeedB() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed b < 50
		int sA = 60;
		int sB = 40;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed b > 100
		sB = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing the requirements for speed C, in both Dijkstra and Floyd-Warshall
	// Reminder: (50 <= speedC <= 100)
	//
	@Test
	public void testSpeedC() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		// when speed c < 50
		int sA = 60;
		int sB = 50;
		int sC = 40;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());
		// when speed c > 100
		sC = 110;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, mapDijkstra.timeRequiredforCompetition());
		assertEquals(-1, mapFloydWarshall.timeRequiredforCompetition());

	}

	// Testing Dijkstra and Floyd-Warshall for the input file: tinyEWD.txt
	// note: Running the tests on 1000EWD.txt works, but takes a long time (>10
	// seconds)
	@Test
	public void testTinyEWD() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-A.txt
	@Test
	public void testInputA() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-A.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-B.txt
	@Test
	public void testInputB() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-B.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-C.txt
	@Test
	public void testInputC() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-C.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-D.txt
	@Test
	public void testInputD() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-D.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-F.txt
	@Test
	public void testInputF() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-F.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-G.txt
	@Test
	public void testInputG() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-G.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-I.txt
	@Test
	public void testInputI() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-I.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-J.txt
	@Test
	public void testInputJ() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-J.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-K.txt
	@Test
	public void testInputK() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-K.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-L.txt
	@Test
	public void testInputL() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-L.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-M.txt
	@Test
	public void testInputM() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-M.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	// Testing Dijkstra and Floyd-Warshall for the input file: input-N.txt
	@Test
	public void testInputN() {
		CompetitionDijkstra mapDijkstra;
		CompetitionFloydWarshall mapFloydWarshall;
		String fileName = "input-N.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		mapDijkstra = new CompetitionDijkstra(fileName, sA, sB, sC);
		mapFloydWarshall = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

}
