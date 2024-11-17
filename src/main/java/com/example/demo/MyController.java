package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @Autowired
    CondService condService;

    @GetMapping("/")
    public String getCalculator() {
        return "enterform";
    }

    @GetMapping("getresult")
    public String getResult(String t1, String t2, String operation, Model model) throws Exception {
        try {
            if (Integer.parseInt(t1) > 56 || Integer.parseInt(t1) < -89 || Integer.parseInt(t2) > 56 || Integer.parseInt(t2) < -89) {
                model.addAttribute("error", "введенные значения температуры выходят за пределы максимально/минимально возможных");
            } else {
                int result = Conditioner.getResultTemp(Integer.parseInt(t1), Integer.parseInt(t2), operation);
                model.addAttribute("res", result);
             //   model.addAttribute("str", t1 + t2 + operation);/////?????
                condService.add(t1,t2,operation);

            }
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Введен текст вместа числа");
        }
        return "enterform";
    }

    @GetMapping("/history")
    public String getHistory(Model model) {

        model.addAttribute("list",condService.getList().toString());


        return "enterform"; /////???
    }
}
