package Tender;

import java.util.*;

public class Tender {
    private final int requiredNumberBuilder;
    private final EnumSet<Specialty> requiredSpeciality;
    private List<ArrayList<Builder>> listParticipatingBrigade;

    public Tender(int requiredNumberBuilder, EnumSet<Specialty> requiredSpeciality) {
        this.requiredNumberBuilder = requiredNumberBuilder;
        this.requiredSpeciality = requiredSpeciality;
    }

    public void setListParticipatingBrigade(List<ArrayList<Builder>> listParticipatingBrigade) {
        this.listParticipatingBrigade = listParticipatingBrigade;
    }

    public ArrayList<Builder> holdTender() {
        if(checkingNumberBuilderInBrigade() & checkingSpecialtyBrigade()){
            return getLowestPrice();
        } else throw new RuntimeException("the tender is closed");
    }

    private boolean checkingNumberBuilderInBrigade() {
        listParticipatingBrigade.removeIf(brigade -> brigade.size() < requiredNumberBuilder);
        return !listParticipatingBrigade.isEmpty();
    }

    private boolean checkingSpecialtyBrigade() {
        Iterator<ArrayList<Builder>> iteratorBrigade = listParticipatingBrigade.iterator();
        while (iteratorBrigade.hasNext()) {
            Set<Specialty> brigadeSpecialties = new HashSet<>();
            iteratorBrigade.next().forEach(builder -> brigadeSpecialties.addAll(builder.getSpecialties()));
            if (!brigadeSpecialties.containsAll(requiredSpeciality)) {
                iteratorBrigade.remove();
            }
        }
        return !listParticipatingBrigade.isEmpty();
    }

    private ArrayList<Builder> getLowestPrice() {
        if (listParticipatingBrigade.size() == 1) return listParticipatingBrigade.get(0);
        int minPrice = listParticipatingBrigade.get(0).stream().mapToInt(builder -> builder.getSalary()).sum();
        int indexBrigadeWithLowestPrice = 0;
        for(int i =1; i< listParticipatingBrigade.size(); i++) {
            int brigadePrice = listParticipatingBrigade.get(i).stream().mapToInt(builder -> builder.getSalary()).sum();
            if (brigadePrice < minPrice) {
                indexBrigadeWithLowestPrice = i;
                minPrice = brigadePrice;
            }
        }
        return listParticipatingBrigade.get(indexBrigadeWithLowestPrice);
    }
}


