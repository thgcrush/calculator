package com.github.calculator.unity;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class ExpressImpl extends ExpressBase implements Express {
    private int grade;
    private String nowExpress;
    private int nowExpressResult;
    private static final HashMap<Character, Integer> PRIORITY;

    static {
        PRIORITY = new HashMap<Character, Integer>();
        PRIORITY.put('+', 0);
        PRIORITY.put('-', 0);
        PRIORITY.put('*', 1);
        PRIORITY.put('/', 1);
    }

    public ExpressImpl() {
    }

    public ExpressImpl(int grade) {
        this.grade = grade;
    }

    /**
     * 小学三年级整数运算
     */
    public void deal() {
        this.nowExpress = getIntegerExpress();
        this.nowExpressResult = this.getIntegerResult(this.nowExpress);
        while (this.nowExpressResult < 0) {
            this.nowExpress = getIntegerExpress();
            this.nowExpressResult = this.getIntegerResult(this.nowExpress);
        }
    }

    public String getIntegerExpress() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        int opnums = rand.nextInt(MAXOPNUMS - MINOPNUMS + 1) + MINOPNUMS;//生成操作符的数量
        //opnums+1个数
        int preNumber = -1;//记录前一个数字是多少
        int preop = -1;
        //随机插入括号
        preNumber = rand.nextInt(MAXNUMBER + 1);
        sb.append(preNumber);
        for (int i = 1; i <= opnums; ++i) {
            int number = rand.nextInt(MAXNUMBER + 1);//0~100
            int id = rand.nextInt(4);
            if (id == 3 && preNumber % number != 0) {//如果是除法就看前面那个能不能整除当前的不能就换个运算符
                id = rand.nextInt(3);
            }
            if (id == 2&&preop==2) id = rand.nextInt(2);
            sb.append(getCharacterById(id));
            sb.append(number);
            preop=id;
            preNumber = number;
        }
        return sb.toString();
    }

    public int getIntegerResult(String calString) {
        Stack<Character> ops = new Stack<Character>();
        Stack<Integer> numbers = new Stack<Integer>();
        int val = 0;
        for (int i = 0; i < calString.length(); ++i) {
            if (isDigit(calString.charAt(i))) {
                val = val * 10 + (calString.charAt(i) - '0');
            } else {
                numbers.push(val);
                if (calString.charAt(i) == '+' || calString.charAt(i) == '-') {
                    //如果符号栈有元素 比较优先级计算 优先级高的先计算
                    while (ops.size() > 0 && PRIORITY.get(ops.peek()) >= PRIORITY.get(calString.charAt(i))) {
                        jisuan(ops, numbers);
                    }
                    //计算以后将当前符号押入栈
                    ops.push(calString.charAt(i));
                } else if (calString.charAt(i) == '*' || calString.charAt(i) == '/') {
                    //如果符号栈有元素 比较优先级计算 优先级高的先计算
                    while (ops.size() > 0 && PRIORITY.get(ops.peek()) >= PRIORITY.get(calString.charAt(i))) {
                        jisuan(ops, numbers);
                    }
                    //计算以后将当前符号押入栈
                    ops.push(calString.charAt(i));
                }
                val = 0;
            }
        }
        numbers.push(val);
        while (ops.size() > 0) jisuan(ops, numbers);
        return numbers.pop();
    }

    public void jisuan(Stack<Character> ops, Stack<Integer> numbers) {
        if (ops.size() > 0) {
            int a = numbers.pop();
            int b = numbers.pop();
            char op = ops.pop();
            if (op == '+')
                numbers.push(b + a);
            else if (op == '-')
                numbers.push(b - a);
            else if (op == '*')
                numbers.push(b * a);
            else
                numbers.push(b / a);//由于生成的时候已经考虑了整除故可以直接除
        }
    }

    public Character getCharacterById(int id) {
        Character op = null;
        switch (id) {
            case 0: {
                op = '+';
                break;
            }
            case 1: {
                op = '-';
                break;
            }
            case 2: {
                op = '*';
                break;
            }
            case 3: {
                op = '/';
                break;
            }
        }
        return op;
    }

    public void display() {
        System.out.print(this.nowExpress);
        System.out.print(" = ");
        System.out.println(this.nowExpressResult);
    }
}
