package com.tsystems.javaschool.tasks.calculator;

import java.util.Stack;

public class Convertor {

    private Stack<Character> theStack;
    private String input;
    private String output = "";


    public Convertor(String in) // constructor
    {
        input = in;
        theStack = new Stack<>();
    }

    public String toPsf() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            if (ch == ' ')
                continue;
            if (ch == '+' || ch == '-') {
                output += ' ';
                oper(ch, 1);
                continue;
            }
            if (ch == '*' || ch == '/') {
                output += ' ';
                oper(ch, 2);
                continue;
            }
            if (ch == '(') {
                theStack.push(ch);
                continue;
            }
            if (ch == ')') {
                int res = rightSk(ch);
                if (res == 0) return "";
            } else {
                output += ch;
            }
        }
        while (!theStack.isEmpty()) {
            output += ' ';
            output += theStack.pop();
        }
        return output;
    }

    public void oper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else {
                    output = output + opTop + ' ';
                }
            }
        }
        theStack.push(opThis);
    }

    public int rightSk(char ch) {
        if (theStack.size() < 2)
            return 0;
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') {
                break;
            } else {
                output += ' ';
                output += chx;
            }
        }
        return 1;
    }
}
