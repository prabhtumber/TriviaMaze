public class TriviaMazeRoom {
    private enum Direction {
        NORTH, WEST, SOUTH, EAST
    }

    private final TriviaMazeDoor[] myDoors = new TriviaMazeDoor[4];
    private boolean myHasVisited;

    public TriviaMazeRoom(TriviaMazeDoor directionNorth, TriviaMazeDoor directionWest,
            TriviaMazeDoor directionSouth, TriviaMazeDoor directionEast) {
        myHasVisited = false;
        myDoors[Direction.NORTH.ordinal()] = directionNorth;
        myDoors[Direction.WEST.ordinal()] = directionWest;
        myDoors[Direction.SOUTH.ordinal()] = directionSouth;
        myDoors[Direction.EAST.ordinal()] = directionEast;
    }

    public TriviaMazeDoor getDoor(Direction direction) {
        return myDoors[direction.ordinal()];
    }

    public boolean visited() {
        return myHasVisited;
    }

    public void markVisited(boolean theVisit) {
        myHasVisited = theVisit;
    }

    @Override
    public String toString() {
        String[] doorStates = new String[4];
        for (int i = 0; i < myDoors.length; i++) {
            if (myDoors[i] == null) {
                doorStates[i] = "XX";
            } else if (myDoors[i].isMyDoorLocked() && !myDoors[i].isMyDoorLockedPermanent()) {
                doorStates[i] = "LK";
            } else if (myDoors[i].isMyDoorLockedPermanent()) {
                doorStates[i] = "XX";
            } else {
                doorStates[i] = "OP";
            }
        }
        return String.format("""
                             ROOM
                ______________________________
                              NORTH
                             ____
                             |%s|
                        ____ ---- ____
                WEST    |%s|  PL  |%s|    EAST
                        ---- ____ ----
                             |%s|
                             ----
                              SOUTH
                ------------------------------
                """, doorStates[Direction.NORTH.ordinal()], doorStates[Direction.WEST.ordinal()],
                doorStates[Direction.EAST.ordinal()], doorStates[Direction.SOUTH.ordinal()]);
    }
}
