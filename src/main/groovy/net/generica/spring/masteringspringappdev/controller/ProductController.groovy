package net.generica.spring.masteringspringappdev.controller

import net.generica.spring.masteringspringappdev.domain.Product
import net.generica.spring.masteringspringappdev.repositories.ProductRepository
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import javax.annotation.PostConstruct

@Controller
public class ProductController {
    @Autowired
    private ProductRepository respository
    private List<Product> productList

    public ProductController() {
        super()
    }

    @PostConstruct
    public void init() {
        this.productList = respository.getAllObjects()
    }

//to get the list of products
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    String getaddproduct(Model model) {
        model.addAttribute("productList", productList)
        model.addAttribute("productAttribute", new Product())
        return "product"
    }

//to save the product
    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    String addproduct(@ModelAttribute Product prod, Model model) {
        if (StringUtils.hasText(prod.getProdid())) {
            respository.updateObject(prod)
        } else {
            respository.saveObject(prod)
        }
        this.productList = respository.getAllObjects()
        model.addAttribute("productList", productList)
        return "product"
    }

//to update the edited product
    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    String updatecustomer(@ModelAttribute Product prod, Model model) {
        respository.updateObject(prod)
        this.productList = respository.getAllObjects()
        model.addAttribute("productList", productList)
        return "product"
    }

//to edit a product based on ID
    @RequestMapping(value = "/product/geteditproduct", method = RequestMethod.GET)
    String geteditproduct(
        @RequestParam(value = "prodid", required = true) String prodid, Model model) {
        model.addAttribute("productList", productList)
        model.addAttribute("productAttribute", respository.getObject(prodid))
        return "editproduct"
    }

//to delete a product based on ID
    @RequestMapping(value = "/product/deleteproduct", method = RequestMethod.GET)
    String deleteproduct(
        @RequestParam(value = "prodid", required = true) String prodid, Model model) {
        respository.deleteObject(prodid)
        this.productList = respository.getAllObjects()
        model.addAttribute("productList", this.productList)
        return "product"
    }

//to get all the products
    @RequestMapping(value = "/product/getallproducts", method = RequestMethod.GET)
    String getallproducts(Model model) {
        this.productList = respository.getAllObjects()
        model.addAttribute("productList", this.productList)
        return "allproducts"
    }
}
