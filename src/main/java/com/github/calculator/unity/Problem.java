package com.github.calculator.unity;

import java.util.ArrayList;

public class Problem{
    private ArrayList<ExpressImpl> problems;
    private int problemCount;
    public Problem(){}
    public Problem(int problemCount)
    {
        this.problemCount=problemCount;
        this.problems=new ArrayList<ExpressImpl>();
        for(int i=0;i<problemCount;++i)
        {
            var temp=new ExpressImpl();
            temp.deal();
            problems.add(temp);
        }
    }

    public ArrayList<ExpressImpl> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<ExpressImpl> problems) {
        this.problems = problems;
    }

    public int getProblemCount() {
        return problemCount;
    }

    public void setProblemCount(int problemCount) {
        this.problemCount = problemCount;
    }
}
