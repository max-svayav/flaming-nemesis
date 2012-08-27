package m.b.sascha.doups;
import java.util.Collection;


public interface SequenceProcessor {

	void processNumber(final Integer number);
	
	Collection<Integer> getSingulars();
	
}
