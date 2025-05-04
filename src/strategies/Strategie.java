package strategies;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import Jeu.Coup;

public interface Strategie {
	public default TreeSet<Coup> trierCoups(HashSet<Coup> ensCoup){
		assert(! ensCoup.isEmpty());
		NavigableSet<Coup> ensTrie = new TreeSet<Coup> (new Comparator<Coup>() {

			@Override
			public int compare(Coup o1, Coup o2) {
				if (o1.equals(o2)) {
					return 0;
				} 
				Random rnd = new Random();
				Integer[] tabRes = new Integer[] {-1,1};
				return tabRes[rnd.nextInt(2)];
			}
			
		});
		ensTrie.addAll(ensCoup);
		return (TreeSet<Coup>) ensTrie;
	}
	public default Coup selectionnerCoup(HashSet<Coup> ensCoup) {
		NavigableSet <Coup> ensTrie = trierCoups(ensCoup);
		return ensTrie.pollLast();
	}
	public default Coup selectionnerDefausse(HashSet<Coup> ensCoup) {
		NavigableSet <Coup> ensTrie = trierCoups(ensCoup);
		return ensTrie.pollFirst();
	}
	
}
