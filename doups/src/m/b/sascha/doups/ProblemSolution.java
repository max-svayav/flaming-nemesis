package m.b.sascha.doups;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProblemSolution implements SequenceProcessor {

	final int w;
	final int[] ac;
	
	ProblemSolution(final int w) {
		this.w = w;
		this.ac = new int[w];
	}
	
	public ProblemSolution() {
		this(Integer.SIZE);
	}
	
	@Override
	public void processNumber(Integer number) {
		for(int i = 0 ; i < w ; i += 1) {
			final int mask = 1 << i;
			if((number & mask) != 0) {
				long q = ((w + 1) & 1) << i;
				for(int j = 0 ; j < w ; j += 1) {
					q ^= (number & (mask | 1 << j)); 
				}				
				ac[i] ^= q;
			}
		}
	}

	@Override
	public Collection<Integer> getSingulars() {
		int xor = 0;
		int x = -1;
		for(int i = 0 ; i < w; i += 1) {
			xor |= ac[i] & 1 << i;
			if(x < 0 && xor != 0) {
				x = i;
			}
		}
		if(x < 0) {
			return Collections.emptyList();
		}
		
		final List<Integer> result = Arrays.asList(ac[x], ac[x] ^ xor);
		Collections.sort(result);
		return result;
	}

}
