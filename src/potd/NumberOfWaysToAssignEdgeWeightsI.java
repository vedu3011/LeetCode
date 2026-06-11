package potd;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToAssignEdgeWeightsI {

	private int maxDepth = 0;

	public int assignEdgeWeights(int[][] edges) {
		int n = edges.length + 1;

		// Build adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		// Find maximum depth from root node 1
		maxDepth = 0;
		dfs(1, 0, 0, adj);

		// Return 2^(maxDepth - 1) mod 1e9+7
		return power(2, maxDepth - 1, 1000000007);
	}

	private void dfs(int node, int parent, int currentDepth, List<List<Integer>> adj) {

		maxDepth = Math.max(maxDepth, currentDepth);

		for (int neighbor : adj.get(node)) {
			if (neighbor != parent) {
				dfs(neighbor, node, currentDepth + 1, adj);
			}
		}
	}

	// Fast modular exponentiation
	private int power(long base, long exp, int mod) {
		long result = 1;
		base %= mod;

		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = (result * base) % mod;
			}

			base = (base * base) % mod;
			exp >>= 1;
		}

		return (int) result;
	}

	public static void main(String[] args) {
		NumberOfWaysToAssignEdgeWeightsI solution = new NumberOfWaysToAssignEdgeWeightsI();

		int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };

		System.out.println(solution.assignEdgeWeights(edges));
	}
}
