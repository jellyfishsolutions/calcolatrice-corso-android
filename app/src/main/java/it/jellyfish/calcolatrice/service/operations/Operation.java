package it.jellyfish.calcolatrice.service.operations;

public abstract class Operation {

    protected double op1;
    protected double op2;

    public void setFirstOperator(double op) {
        this.op1 = op;
    }

    public void setSecondOperator(double op) {
        this.op2 = op;
    }


    public abstract double execution();

}
