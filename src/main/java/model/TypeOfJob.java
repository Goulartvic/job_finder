package model;

public enum TypeOfJob {
    ESTAGIO("Estágio"), EFETIVO("Efetivo");

    private final String typeOfJOb;

    TypeOfJob(String typeOfJOb) {
        this.typeOfJOb = typeOfJOb;
    }

    public String getTypeOfJOb() {
        return typeOfJOb;
    }
}
