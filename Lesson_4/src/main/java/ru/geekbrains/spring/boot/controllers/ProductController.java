package ru.geekbrains.spring.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.spring.boot.services.ProductService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping // GET http://localhost:8189/app/products
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_cost") Integer minCost,
                          @RequestParam(required = false, name = "max_cost") Integer maxCost
    ) {
        model.addAttribute("products", productService.findAll(minCost, maxCost));
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id, HttpServletResponse response) {
        productService.deleteBydId(id);
        return "redirect:/products";
    }
}
