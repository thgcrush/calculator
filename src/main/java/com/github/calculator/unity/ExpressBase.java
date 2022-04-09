package com.github.calculator.unity;

abstract public class ExpressBase {
    private int opnums;//操作符数量
    private int minnum;//最小的数
    private int maxnum;//取值范围
    public String express;//当前的表达式
    public int result;//d当前表达式的结果

    public int getOpnums() {
        return opnums;
    }

    public void setOpnums(int opnums) {
        this.opnums = opnums;
    }

    public int getMinnum() {
        return minnum;
    }

    public void setMinnum(int minnum) {
        this.minnum = minnum;
    }

    public int getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(int maxnum) {
        this.maxnum = maxnum;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void display(){
        System.out.print(this.express);
        System.out.print(" = ");
        System.out.println(this.result);
    }
}
