package model;

public enum TypeOfJob {
    INTERNSHIP(1), EMPLOYMENT(2);

    private final int typeOfJOb;

    TypeOfJob(int typeOfJOb) {
        this.typeOfJOb = typeOfJOb;
    }

    public int getTypeOfJOb() {
        return typeOfJOb;
    }
}
