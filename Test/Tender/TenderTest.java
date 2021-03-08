package Tender;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.Assert.*;

public class TenderTest {
    private Tender tender;
    private List<ArrayList<Builder>> listParticipatingBrigade;

    private final static Builder BUILDER_ONE = new Builder(EnumSet.of(Specialty.ENGINEER), 25);
    final static Builder BUILDER_TWO = new Builder(EnumSet.of(Specialty.CARPENTER, Specialty.CRANE_OPERATOR), 29);
    final static Builder BUILDER_THREE = new Builder(EnumSet.of(Specialty.GAS_WELDER, Specialty.MASON), 17);
    final static Builder BUILDER_FOUR = new Builder(EnumSet.of(Specialty.ENGINEER, Specialty.MASTER), 32);
    final static Builder BUILDER_FIVE = new Builder(EnumSet.of(Specialty.ROOFER), 11);
    final static Builder BUILDER_SIX = new Builder(EnumSet.of(Specialty.VENEER, Specialty.SURVEYOR), 34);
    final static Builder BUILDER_SEVEN = new Builder(EnumSet.of(Specialty.CONCRETE_WORKER), 8);
    final static Builder BUILDER_EIGHT = new Builder(EnumSet.of(Specialty.CRANE_OPERATOR), 4);
    final static Builder BUILDER_NINE = new Builder(EnumSet.of(Specialty.ENGINEER), 9);
    final static Builder BUILDER_TEN = new Builder(EnumSet.of(Specialty.MASON), 11);

    private final static ArrayList<Builder> BRIGADE_ONE = new ArrayList<>();
    private final static ArrayList<Builder> BRIGADE_TWO = new ArrayList<>();
    private final static ArrayList<Builder> BRIGADE_THREE = new ArrayList<>();
    private final static ArrayList<Builder> BRIGADE_FOUR = new ArrayList<>();
    private final static ArrayList<Builder> BRIGADE_FIVE = new ArrayList<>();
    private final static ArrayList<Builder> BRIGADE_SIX = new ArrayList<>();


    static {
        BRIGADE_ONE.add(BUILDER_ONE);
        BRIGADE_ONE.add(BUILDER_TWO);

        BRIGADE_TWO.add(BUILDER_THREE);
        BRIGADE_TWO.add(BUILDER_FOUR);

        BRIGADE_THREE.add(BUILDER_ONE);
        BRIGADE_THREE.add(BUILDER_TWO);
        BRIGADE_THREE.add(BUILDER_THREE);

        BRIGADE_FOUR.add(BUILDER_FOUR);
        BRIGADE_FOUR.add(BUILDER_FIVE);
        BRIGADE_FOUR.add(BUILDER_SIX);

        BRIGADE_FIVE.add(BUILDER_SEVEN);
        BRIGADE_FIVE.add(BUILDER_EIGHT);
        BRIGADE_FIVE.add(BUILDER_NINE);
        BRIGADE_FIVE.add(BUILDER_TEN);

        BRIGADE_SIX.add(BUILDER_FIVE);
        BRIGADE_SIX.add(BUILDER_SIX);
        BRIGADE_SIX.add(BUILDER_EIGHT);
        BRIGADE_SIX.add(BUILDER_NINE);
    }

    @Before
    public void setUp() throws Exception {
        tender = new Tender(3,
                EnumSet.of(Specialty.ENGINEER, Specialty.CRANE_OPERATOR,Specialty.MASON));
        listParticipatingBrigade = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        tender = null;
        listParticipatingBrigade = null;
    }

    @Test(expected = RuntimeException.class)
    public void holdTenderBrigadeNumberBuildersLessRequired() {
        listParticipatingBrigade.add(BRIGADE_ONE);
        listParticipatingBrigade.add(BRIGADE_TWO);
        tender.setListParticipatingBrigade(listParticipatingBrigade);
        tender.holdTender();
    }

    @Test(expected = RuntimeException.class)
    public void holdTenderBrigadeSpecialtiesDoNotCorrespondRequired() {
        listParticipatingBrigade.add(BRIGADE_FOUR);
        listParticipatingBrigade.add(BRIGADE_SIX);
        tender.setListParticipatingBrigade(listParticipatingBrigade);
        tender.holdTender();
    }

    @Test
    public void holdTenderOneBrigadeCorrespondRequired() {
        listParticipatingBrigade.add(BRIGADE_ONE);
        listParticipatingBrigade.add(BRIGADE_TWO);
        listParticipatingBrigade.add(BRIGADE_THREE);
        listParticipatingBrigade.add(BRIGADE_FOUR);
        listParticipatingBrigade.add(BRIGADE_SIX);
        tender.setListParticipatingBrigade(listParticipatingBrigade);
        List<Builder> expected = BRIGADE_THREE;
        List<Builder> actual = tender.holdTender();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void holdTenderTwoBrigadesCorrespondRequiredSelectingLowestPrice() {
        listParticipatingBrigade.add(BRIGADE_ONE);
        listParticipatingBrigade.add(BRIGADE_TWO);
        listParticipatingBrigade.add(BRIGADE_THREE);
        listParticipatingBrigade.add(BRIGADE_FOUR);
        listParticipatingBrigade.add(BRIGADE_FIVE);
        listParticipatingBrigade.add(BRIGADE_SIX);
        tender.setListParticipatingBrigade(listParticipatingBrigade);
        List<Builder> expected = BRIGADE_FIVE;
        List<Builder> actual = tender.holdTender();
        Assert.assertEquals(expected,actual);
    }
}