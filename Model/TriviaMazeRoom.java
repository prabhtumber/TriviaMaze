package Model;
import java.io.Serializable;
import java.util.Locale;

public class TriviaMazeRoom implements Serializable {
    private static final long serialVersionUID = 638649015203610635L;

    /**
     * A static int that hold the north location.
     */
    private static final int NORTH = 0;

    /**
     * A static int that hold the west location.
     */
    private static final int WEST = 1;

    /**
     * A static int that hold the south location.
     */
    private static final int SOUTH = 2;

    /**
     * A static int that hold the east location.
     */
    private static final int EAST = 3;
    private final TriviaMazeDoor[] myDoors;
    private boolean myHasVisited;

    public TriviaMazeRoom(final int theRow, final int theCol, final TriviaMazeDoor theNorth, final TriviaMazeDoor theWest,
                          final TriviaMazeDoor theSouth, final TriviaMazeDoor theEast) {
        myHasVisited = false;
        myDoors = new TriviaMazeDoor[4];
        if (theRow >= 0 && theRow < myDoors.length && theCol < myDoors.length - 1) {
            myDoors[EAST] = theEast;
        }
        if (theCol >= 0 && theCol < myDoors.length && theRow < myDoors.length - 1) {
            myDoors[SOUTH] = theSouth;
        }
        if (theCol > 0 && theCol < myDoors.length && theRow < myDoors.length) {
            myDoors[WEST] = theWest;
        }
        if (theRow > 0 && theRow < myDoors.length && theCol < myDoors.length) {
            myDoors[NORTH] = theNorth;
        }
    }

    public TriviaMazeDoor getDoor(final String theDirection) {
        return switch (theDirection.toLowerCase(Locale.ENGLISH)) {
            case "north" -> myDoors[NORTH];
            case "west" -> myDoors[WEST];
            case "south" -> myDoors[SOUTH];
            case "east" -> myDoors[EAST];
            default -> null;
        };
    }

    public boolean visited() {

        return myHasVisited;
    }

    public void markVisited(boolean theVisit) {
        myHasVisited = theVisit;
    }

    @Override
    public String toString() {
        String[] door = new String[4];
        for (int i = 0; i < myDoors.length; i++) {
            if (myDoors[i] == null) {
                door[i] = "XX";
            } else if (myDoors[i].isMyDoorLocked() && !(myDoors[i].isMyDoorLockedPermanent())) {
                door[i] = "LK";
            } else if (myDoors[i].isMyDoorLockedPermanent()) {
                door[i] = "XX";
            } else {
                door[i] = "OP";
            }
        }

        // Build the room representation with even spacing
        return String.format("""
                             ROOM
                ______________________________
                            NORTH
                             ____
                             |%s|
                        ____ ---- ____
                WEST  |%s|  PL  |%s|  EAST
                        ---- ____ ----
                             |%s|
                             ----
                            SOUTH
                ------------------------------
                """,
                door[0], door[1], door[3],door[2]);

    }
}
