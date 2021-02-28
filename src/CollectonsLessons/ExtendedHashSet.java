package CollectonsLessons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public  class ExtendedHashSet<E> extends HashSet<E> {

     public ExtendedHashSet() {
    }

    public  ExtendedHashSet(Collection c) {
        super(c);
    }

    public   Set  getUnion(Set fistSet, Set secondSet) {
        fistSet.addAll(secondSet);
        return fistSet;
    }

    public Set getIntersection(Set fistSet, Set secondHashSet) {
        fistSet.retainAll(secondHashSet);
        return fistSet;
    }

    public Set getMinus(Set fistHashSet, Set secondHashSet) {
        fistHashSet.removeAll(secondHashSet);
        return fistHashSet;
    }

    public Set getDifference(Set fistSet, Set secondSet) {
        Set temp = getIntersection(fistSet, secondSet);
        fistSet.removeAll(temp);
        secondSet.removeAll(temp);
        return getUnion(fistSet, secondSet);
    }

}
