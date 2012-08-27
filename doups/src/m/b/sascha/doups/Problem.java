
package m.b.sascha.doups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Problem {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int sz = Integer.parseInt(args[0]);
		for(int dupes : new int[] { 0, 1, 2}) {
			System.out.println(String.format("%d duplicates:", dupes));
			SequenceProcessor smart = new ProblemSolution();
			SequenceProcessor dumb = new SortAndScan();
			for(Integer i : newSequence(sz, dupes)) {
				smart.processNumber(i);
				dumb.processNumber(i);
			}
			System.out.println("smart: " + smart.getSingulars());
			System.out.println("dumb:  " + dumb.getSingulars());
		}
	}

	private static List<Integer> newSequence(int size, int dupes) {
		final Random r = new Random();
		final Set<Integer> set = new HashSet<Integer>(size);
		final ArrayList<Integer> list = new ArrayList<Integer>(size * 2 + 2);
		while(size > 0) {
			final int q = r.nextInt();
			if(set.add(q)) {
				size -= 1;
			}
		}
		list.addAll(set);
		size = dupes;
		while(size > 0) {
			final int q = r.nextInt();
			if(set.add(q)) {
				size -= 1;
			}
		}
		list.addAll(set);
		Collections.shuffle(list);
		return list;
	}

}
