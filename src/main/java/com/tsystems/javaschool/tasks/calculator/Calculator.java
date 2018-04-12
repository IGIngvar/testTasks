package com.tsystems.javaschool.tasks.calculator;

import java.util.Stack;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {

        Stack<Double> stack = new Stack<>();
        String psf;
        //transform in convertor
        //if statement null -> result returns null
        try{
        Convertor convertor = new Convertor(statement);
            psf = convertor.toPsf();
        }
        catch (NullPointerException e){
            return null;
        }

        double val;
        double tmpResult = 0;
        double num1, num2;
        if (psf.isEmpty()) return null;
        String[] tmp = psf.split(" ");
        for (int j = 0; j < tmp.length; j++) {
            if (tmp[j].isEmpty())
                return null;
            if (!tmp[j].equals("+") && !tmp[j].equals("-") &&
                    !tmp[j].equals("*") && !tmp[j].equals("/")) {
                try {
                    val = Double.valueOf(tmp[j]);
                } catch (NumberFormatException ex) {
                    return null;
                }
                stack.push(val);
            } else {
                //if its an operator - make calculation
                num2 = Double.valueOf(stack.pop());
                num1 = Double.valueOf(stack.pop());
                if (tmp[j].equals("+")) {
                    tmpResult = num1 + num2;
                }
                if (tmp[j].equals("-")) {
                    tmpResult = num1 - num2;
                }
                if (tmp[j].equals("*")) {
                    tmpResult = num1 * num2;
                }
                if (tmp[j].equals("/")) {
                    //if divide by zero -> null
                    if (num2 == 0)
                        return null;
                    tmpResult = num1 / num2;
                }
                stack.push(tmpResult);
            }
        }
        //output
        return fmt(stack.pop());
    }

    // formatter, that delete all zeros
    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

}
