package CollectonsLessons;

import java.util.HashSet;

public class HashSetTask {
    public HashSet getUnion(HashSet fistHashSet, HashSet secondHashSet){
        fistHashSet.addAll(secondHashSet);
        return fistHashSet;
    }

    public HashSet getIntersection(HashSet fistHashSet, HashSet secondHashSet){
        HashSet intersectionFistHashSetAndSecondHashSet = new HashSet<>();
        for(Object o : secondHashSet)
            if (fistHashSet.contains(o)){
                intersectionFistHashSetAndSecondHashSet.add(o);
            }
        return intersectionFistHashSetAndSecondHashSet;
    }

    public HashSet getMinus(HashSet fistHashSet, HashSet secondHashSet){
        fistHashSet.removeAll(secondHashSet);
        return fistHashSet;
    }

    public HashSet getDifference(HashSet fistHashSet, HashSet secondHashSet){
        HashSet temp = getIntersection(fistHashSet, secondHashSet);
        fistHashSet.removeAll(temp);
        secondHashSet.removeAll(temp);
        return getUnion(fistHashSet, secondHashSet);
    }
}
