package com;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class AllDoorsSimulator {


//		- EventId : the id of each event
//
//		- DoorId : the id of the door
//
//		- Dpattern : the pattern of the door can be
//				["swinging ","folding ", "low-energy", "revolving"]
//
//		- Dloc : the address of the building can be
//				["4460  Rhode Island Avenue", "3593  Gateway Road",
//				"1200  Joyce Street", "9176 Harvey St. Drexel Hill", "8571 Temple Street Frankfort"]
//
//
//		- Dlvl : the door floor level
//
//		- EventType : event type ["IN","OUT"]
//
//		- Timestamp : timestamp




    public List<Long> EventId;
    public List<Long> DoorId;
    public List<String> Dpattern;
    public List<String> DLoc;
    public List<String> DLvl;
    public List<String> EventType;
    public List<Long> Timestamp;

    AllDoorsSimulator(String path){
        Random rand = new Random();
        List<Long> eventid = new ArrayList<>();
        List<Long> doorid = new ArrayList<>();
        List<String> dpattern = new ArrayList<>();
        List<String> patterns = Arrays.asList("swinging ", "folding ", "low-energy", "revolving");
        List<String> dloc = new ArrayList<>();
        List<String> loc = Arrays.asList("4460  Rhode Island Avenue", "3593  Gateway Road", "1200  Joyce Street", "9176 Harvey St. Drexel Hill", "8571 Temple Street Frankfort");
        List<String> dlvl = new ArrayList<>();
        List<String> lvl = Arrays.asList("1st", "2nd", "3rd", "5th", "6th", "park", "10th");
        List<String> eventtype = new ArrayList<>();
        List<String> events = Arrays.asList("IN", "OUT");
        List<Long> timestamp = new ArrayList<>();


        for(int i=0; i<200; i+=1) {
            eventid.add((long) i);
            doorid.add((long) rand.nextInt(201));
            dpattern.add(patterns.get(rand.nextInt(patterns.size())));
            dloc.add(loc.get(rand.nextInt(loc.size())));
            dlvl.add(lvl.get(rand.nextInt(lvl.size())));
            eventtype.add(events.get(rand.nextInt(events.size())));
            timestamp.add(LocalDate.now().toEpochDay() + rand.nextInt(1000));
        }

        this.EventId = eventid;
        this.DoorId = doorid;
        this.Dpattern = dpattern;
        this.DLoc = dloc;
        this.DLvl = dlvl;
        this.EventType = eventtype;
        this.Timestamp = timestamp;

        Object.class.getResourceAsStream(path);

    }
}


class DoorSimulator{

    public Long EventId;
    public Long DoorId;
    public String Dpattern;
    public String DLoc;
    public String DLvl;
    public String EventType;
    public Long Timestamp;

    private static int nbr_doors = 0;
    {
        setNbr_doors(getNbr_doors() + 1);
    }

    DoorSimulator(String line){
        List<String> myList = new ArrayList<String>(Arrays.asList(line.split(",")));
        this.EventId = Long.valueOf(myList.get(0));
        this.DoorId = Long.valueOf(myList.get(1));
        this.Dpattern = myList.get(2);
        this.DLoc = myList.get(3);
        this.DLvl = myList.get(4);
        this.EventType = myList.get(5);
        this.Timestamp = Long.valueOf(myList.get(6));

    }


    public static int getNbr_doors() {
        return nbr_doors;
    }

    public static void setNbr_doors(int nbr_doors) {
        DoorSimulator.nbr_doors = nbr_doors;
    }
}
