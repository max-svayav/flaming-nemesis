package m.b.sascha.doups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortAndScan implements SequenceProcessor {

	private final ArrayList<Integer> list = new ArrayList<Integer>();
	
	@Override
	public void processNumber(Integer number) {
		list.add(number);
		
	}

	@Override
	public Collection<Integer> getSingulars() {
		Collections.sort(list);
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < list.size() ; i += 1) {
			if(i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
				i += 1;
			} else {
				result.add(list.get(i));
			}
		}
		return result;
	}

}
