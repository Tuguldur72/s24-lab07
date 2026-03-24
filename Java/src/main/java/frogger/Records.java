package frogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactor Task 2.
 * Anti-pattern fixed: Long Parameter List
 *
 * Previously, addRecord() accepted 6 separate String parameters. This is a
 * Long Parameter List smell — hard to read, easy to pass arguments in wrong order.
 *
 * Fix: Use the FroggerID record class to group all identity fields into one object.
 * Also replaced List<String[]> with List<FroggerID> for type safety and clarity.
 * Duplicate check simplified using FroggerID's built-in .equals() (record classes
 * auto-generate equals() based on all fields).
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Records {
    private final List<FroggerID> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    /**
     * Adds a frogger's record.
     *
     * @param id the FroggerID of the frogger to record
     * @return false if the record already exists, true otherwise
     */
    public boolean addRecord(FroggerID id) {
        // FroggerID is a record class — .equals() automatically compares all fields.
        if (this.records.contains(id)) {
            return false;
        }
        this.records.add(id);
        return true;
    }
}