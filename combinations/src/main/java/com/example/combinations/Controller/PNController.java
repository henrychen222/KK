package com.example.combinations.Controller;

import com.example.combinations.Helper.PNHelper;
import com.example.combinations.model.Combination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PNController {

    @Autowired
    PNHelper pnHelper;

    @GetMapping("/getAllCombinations/{phoneNumber}")
    public List<Combination> getAllCombinations(@PathVariable String phoneNumber) throws Exception {
        return pnHelper.getAllCombinationsOperation(phoneNumber);
    }
}
