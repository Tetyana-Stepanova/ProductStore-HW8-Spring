package com.goit.productstore.controllers;

import com.goit.productstore.models.manufacturer.Manufacturer;
import com.goit.productstore.models.manufacturer.ManufacturerService;
import com.goit.productstore.models.product.Product;
import com.goit.productstore.models.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    @RequestMapping("/product")
    public ModelAndView viewProductPage(){
        List<Product> listProducts = productService.getAll();
        ModelAndView result = new ModelAndView("product");
        result.addObject("listProducts", listProducts);
        return result;
    }

    @RequestMapping("/createProduct")
    public ModelAndView viewCreateProductPage(){
        Product product = new Product();
        ModelAndView result = new ModelAndView("createProduct");
        result.addObject("product", product);
        List<Manufacturer> listManufacturers = manufacturerService.getAll();
        result.addObject("listManufacturers", listManufacturers);
        return result;
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveNewProduct(@ModelAttribute("product") Product product) {
        product.setManufacturer(product.getManufacturer());
        productService.create(product);
        ModelAndView result = new ModelAndView("product");
        List<Product> listProducts = productService.getAll();
        result.addObject("listProducts", listProducts);
        return result;
    }

    @RequestMapping("/updateProduct/{uuid}")
    public ModelAndView showUpdateProductPage(@PathVariable(name = "uuid") UUID uuid) {
        ModelAndView result = new ModelAndView("updateProduct");
        Product product = productService.getByUuId(uuid);
        result.addObject("product", product);
        List<Manufacturer> listManufacturers = manufacturerService.getAll();
        result.addObject("listManufacturers", listManufacturers);
        return result;
    }

    @RequestMapping("/deleteProduct/{uuid}")
    public ModelAndView deleteProduct(@PathVariable(name = "uuid") UUID uuid){
        productService.deleteById(uuid);
        ModelAndView result = new ModelAndView("product");
        List<Product> listProducts = productService.getAll();
        result.addObject("listProducts", listProducts);
        return result;
    }
}
