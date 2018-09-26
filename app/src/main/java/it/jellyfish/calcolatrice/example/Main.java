package it.jellyfish.calcolatrice.example;

import it.jellyfish.calcolatrice.service.Calculator;
import it.jellyfish.calcolatrice.service.operations.Addition;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");


        Calculator calculator = new Calculator();

        calculator.setDisplay(2);
        calculator.setOperation(new Addition());
        calculator.setDisplay(2);

        calculator.execute();

        System.out.println(calculator.getDisplay());


        calculator.setOperation(new Addition());
        calculator.setDisplay(4);

        calculator.execute();

        System.out.println(calculator.getDisplay());


    }

}
