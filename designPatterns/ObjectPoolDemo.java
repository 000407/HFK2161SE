import java.util.*;

public class ObjectPoolDemo {
    public static void main(String[] args) {
        BroomPool bp = new BroomPool(4);
        
        for (int i = 0; i < 5; i++) {
            Broom b = bp.acrquireBroom();
            b.sweep();
        }
    }
}

class BroomPool {
    private Set<Broom> brooms;
    private Set<Broom> broomsInUse;

    public BroomPool(int maxPoolSize) {
        brooms = new HashSet<>();
        broomsInUse = new HashSet<>();

        for (int i = 0; i < maxPoolSize; i++) {
            brooms.add(new Broom());
        }
    }

    public Broom acrquireBroom() {
        for (Broom broom : brooms) {
            if (broomsInUse.contains(broom)) {
                continue;
            }

            broomsInUse.add(broom);
            return broom;
        }
        
        throw new RuntimeException("All brooms are in use.");
    }

    public void releaseBroom(Broom b) {
        broomsInUse.remove(b);
    }
}

class Broom {
    public void sweep() {
        System.out.println("Sweep! Sweep!");
    }
}
