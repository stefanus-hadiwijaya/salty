package com.task.salty.controller;

import com.task.salty.model.Konsumen;
import com.task.salty.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KonsumenController {

    @Autowired
    KonsumenService konsumenService;

    @GetMapping("/add-konsumen")
    public String addKonsumen(Konsumen konsumen) {
        konsumen.setStatus("aktif");
        return "add-konsumen";
    }

    @PostMapping("/add-konsumen")
    public String saveKonsumen(Konsumen konsumen, BindingResult result, Model model) {
        return konsumenService.saveKonsumen(konsumen, result);
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

}
