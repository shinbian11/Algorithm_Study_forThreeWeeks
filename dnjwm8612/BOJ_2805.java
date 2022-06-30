package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] trees = new long[n];
		long prev = 0;
		long curr = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			if(trees[i] > curr) {
				curr = trees[i];
			}
		}
		
		while(prev <= curr) {
			long middle = (prev + curr) / 2;
			long sumStick = 0;
			for(long tree : trees) {
				if(tree > middle) {
					sumStick += ( tree - middle);
				}
			}
			
			if(sumStick >= m) {
				prev = middle + 1;
			}else {
				curr = middle - 1;
			}
		}
		
		System.out.println(curr);
		

	}

}
