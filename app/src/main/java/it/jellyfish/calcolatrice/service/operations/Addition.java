package it.jellyfish.calcolatrice.service.operations;

public class Addition extends Operation {

    @Override
    public double execution() {
        return this.op1 + this.op2;
    }
}
