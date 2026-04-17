public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(this.toFeet(), q.toFeet()) == 0;
        }
    }
    public static void main(String[] args) {
        Quantity f1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity f2 = new Quantity(1.0, LengthUnit.INCHES);

        System.out.println("Equal: " + f1.equals(f2));
    }
}
