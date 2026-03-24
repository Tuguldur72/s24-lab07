package frogger;

/**
 * Refactor Task 1.
 * Anti-pattern fixed: Feature Envy / Inappropriate Intimacy
 *
 * Previously, Frogger directly accessed Road's internal boolean[] via getOccupied(),
 * and performed isOccupied / isValid logic itself. This is Feature Envy — Frogger
 * was more interested in Road's data than Road itself.
 *
 * Fix: Move isOccupied() and isValid() into Road, and remove the raw getOccupied()
 * accessor so internal state is no longer exposed.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        this.occupied = occupied;
    }

    /**
     * Checks whether the given position is within the road bounds.
     *
     * @param position the position to check
     * @return true if valid, false otherwise
     */
    public boolean isValid(int position) {
        return position >= 0 && position < this.occupied.length;
    }

    /**
     * Checks whether the given position is occupied.
     * Assumes position is valid.
     *
     * @param position the position to check
     * @return true if occupied, false otherwise
     */
    public boolean isOccupied(int position) {
        return this.occupied[position];
    }

    // getOccupied() removed — internal state should not be exposed directly.
    // Frogger now delegates to Road's own methods instead.
}