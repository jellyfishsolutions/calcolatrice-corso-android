package it.jellyfish.calcolatrice.service;

import it.jellyfish.calcolatrice.service.operations.Operation;

public class Calculator {


    protected double display;

    protected Operation operation;


    public void clean() {
        this.display = 0;
    }

    public double getDisplay() {
        return  this.display;
    }

    public void setDisplay(double val) {
        this.display = val;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        this.operation.setFirstOperator(this.display);
    }

    public void execute() {
        this.operation.setSecondOperator(this.display);
        this.display = this.operation.execution();
    }


}
