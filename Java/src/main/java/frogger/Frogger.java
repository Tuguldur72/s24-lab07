package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * Task 1 - Anti-pattern fixed: Feature Envy / Inappropriate Intimacy
 *   Previously, Frogger called road.getOccupied() and directly worked with the raw
 *   boolean[] array. Frogger was more interested in Road's data than Road itself.
 *   Fix: Frogger now delegates isOccupied() and isValid() to Road, which owns that logic.
 *
 * Task 2 - Anti-pattern fixed: Long Parameter List
 *   Previously, Frogger stored 6 separate identity fields (firstName, lastName, etc.)
 *   and passed them all to Records.addRecord(). This is a Long Parameter List smell.
 *   Fix: Use FroggerID (a record class) to encapsulate all identity fields into one object.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;

    // Field for task 2. Changed: replaced 6 individual String fields with one FroggerID.
    private final Records records;
    private final FroggerID id;

    public Frogger(Road road, int position, Records records, FroggerID id) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.id = id;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true to move forward, false to move backward.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        // Task 1 fix: delegate to Road instead of accessing road.getOccupied() directly.
        if (!isValid(nextPosition) || isOccupied(nextPosition)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    /**
     * Task 1 fix: now delegates to Road.isOccupied().
     * Road owns the occupied[] data and the logic to check it.
     */
    public boolean isOccupied(int position) {
        return this.road.isOccupied(position);
    }

    /**
     * Task 1 fix: now delegates to Road.isValid().
     * Road owns the bounds-checking logic.
     */
    public boolean isValid(int position) {
        return this.road.isValid(position);
    }

    /**
     * Records Frogger to the list of records.
     *
     * Task 2 fix: passes FroggerID object instead of 6 separate parameters.
     *
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
        return records.addRecord(this.id);
    }
}