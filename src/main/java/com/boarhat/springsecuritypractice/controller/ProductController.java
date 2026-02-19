package com.boarhat.springsecuritypractice.controller;

import com.boarhat.springsecuritypractice.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        logger.info("Adding product {}", product);
        return "redirect:/main";
    }
}
