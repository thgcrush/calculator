package com.github.calculator.controller;

import com.github.calculator.unity.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpressController {

    @RequestMapping(value={"/","/index"},method={RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "index";
    }

    @RequestMapping(value="/three/problem",method={RequestMethod.GET,RequestMethod.POST})
    public String three_problem_select(){
        return "three_problem_select";
    }

    @RequestMapping(value="/three/problem/arithmetic",method={RequestMethod.GET,RequestMethod.POST})
    public String three_problem_arithmetic(Model model){
        Problem gradeProblems=new Problem(20);
        model.addAttribute("gradeProblems",gradeProblems);
        return "grade_3_integer_arithmetic";
    }

}
