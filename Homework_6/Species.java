package Homework_6;

public enum Species {
    CAT(false, 4, true),
    SPIDER(false, 8, false),
    DOG(false, 4, true),
    ELEPHANT(false, 4, false),
    BIRD(true, 2, false);

    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;
    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
    @Override
    public String toString() {
        return "{" +
                "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFur=" + hasFur +
                '}';
    }
}
