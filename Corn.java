public class Corn {

    private boolean healthy;
    private CornType type;

    private Corn() {
    }

    private Corn(CornType type, boolean healthy) {

    }

    public void cook() {
        System.out.println("Cooked");
    }

    public void shuck() {
        System.out.println("Shucked");
    }

    public void butter() {
        System.out.println("Buttered");
    }

    public static class CornBuilder {
        private static CornBuilder instance;
        private CornType cornType;
        private boolean watered, fertilized, plowed;

        private CornBuilder() {
        }

        public static CornBuilder getInstance() {
            if (instance == null) {
                System.out.println("Created singleton corn builder");
                instance = new CornBuilder();
            }
            return instance;
        }

        public CornBuilder plant(CornType seed) {
            if (plowed == false) {
                System.out.println("Not plowed");
                return this;
            }
            System.out.println("Planted corn");

            cornType = seed;
            return this;
        }

        public CornBuilder water() {
            if (plowed == false) {
                System.out.println("Not plowed");
                return this;
            }
            System.out.println("Watered corn");
            watered = true;
            return this;
        }

        public CornBuilder fertilize() {
            if (plowed == false) {
                System.out.println("Not plowed");
                return this;
            }
            System.out.println("Fertilized corn");
            fertilized = true;
            return this;
        }

        public CornBuilder plow() {
            System.out.println("Plowed field");
            plowed = true;
            return this;
        }

        public Corn harvest() {
            if (!plowed || cornType == null) {
                System.out.println("No corn.  You’re a bad farmer.");
                return null;
            }
            plowed = false;
            boolean healthy = watered && fertilized;
            System.out.println("Harvested " + (healthy ? "healthy" : "unhealthy") + " corn of type " + cornType + ".");
            return new Corn(cornType, healthy);
        }

    }

    public enum CornType {
        YELLOW, GREEN, RED, SWEET
    }
}
