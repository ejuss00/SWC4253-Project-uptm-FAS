package com.example.vacation.controllers;

import com.example.vacation.models.BookingDto;
import com.example.vacation.models.Product;
import com.example.vacation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/calculate")
    @ResponseBody
    public BookingDto calculateBooking(@RequestBody Map<String, Integer> selectedPackages) {
        BookingDto bookingDTO = new BookingDto();
        double totalPrice = 0;

        Map<Integer, Integer> processedPackages = new HashMap<>();

        // Calculate total price based on selected packages and number of people
        for (Map.Entry<String, Integer> entry : selectedPackages.entrySet()) {
            int productId = Integer.parseInt(entry.getKey().replace("package_", ""));
            int numberOfPeople = entry.getValue();

            Product product = productRepository.findById(productId).orElse(null);
            if (product != null && numberOfPeople > 0) {
                processedPackages.put(productId, numberOfPeople);
                totalPrice += product.getPrice() * numberOfPeople;
            }
        }

        bookingDTO.setSelectedPackages(processedPackages);
        bookingDTO.setTotalPrice(totalPrice);

        // Apply 20% discount if 3 or more packages are selected
        if (processedPackages.size() >= 3) {
            bookingDTO.setHasDiscount(true);
            bookingDTO.setDiscountedPrice(totalPrice * 0.8); // 20% off
        } else {
            bookingDTO.setHasDiscount(false);
            bookingDTO.setDiscountedPrice(totalPrice);
        }

        return bookingDTO;
    }

    @GetMapping("/index")  // This maps to /booking/index
    public String showBookingPage(Model model) {
        // Add the products to the model so they can be displayed
        model.addAttribute("products", productRepository.findAll());
        return "booking/index";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(@RequestParam Map<String, String> params, Model model) {
        Map<Product, Integer> selectedPackages = new HashMap<>();
        double totalPrice = 0;

        // Process selected packages
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("package_")) {
                int productId = Integer.parseInt(entry.getKey().replace("package_", ""));
                int numberOfPeople = Integer.parseInt(entry.getValue());

                Product product = productRepository.findById(productId).orElse(null);
                if (product != null && numberOfPeople > 0) {
                    selectedPackages.put(product, numberOfPeople);
                    totalPrice += product.getPrice() * numberOfPeople;
                }
            }
        }

        // Calculate discount if applicable
        boolean hasDiscount = selectedPackages.size() >= 3;
        double finalPrice = hasDiscount ? totalPrice * 0.8 : totalPrice;

        model.addAttribute("selectedPackages", selectedPackages);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("hasDiscount", hasDiscount);
        model.addAttribute("finalPrice", finalPrice);
        model.addAttribute("savings", totalPrice - finalPrice);

        return "booking/confirmation";
    }
}