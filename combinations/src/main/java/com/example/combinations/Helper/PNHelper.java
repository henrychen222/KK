package com.example.combinations.Helper;

import com.example.combinations.model.Combination;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PNHelper {

    public List<Combination> getAllCombinationsOperation(String phoneNumber) {
        String pn = removeSpace(phoneNumber);
        int count = 0;
        List<String> allData = new ArrayList<>();
        List<Combination> cList = new ArrayList<>();

        for (int i = 0; i < pn.length(); i++) {
            if (pn.charAt(i) == '1' || pn.charAt(i) == '0') {
                // do nothing

            } else if (pn.charAt(i) == '2') {
                allData.add(pn.replace(pn.charAt(i), 'A'));
                allData.add(pn.replace(pn.charAt(i), 'B'));
                allData.add(pn.replace(pn.charAt(i), 'C'));
                count += 3;
            } else if (pn.charAt(i) == '3') {
                allData.add(pn.replace(pn.charAt(i), 'D'));
                allData.add(pn.replace(pn.charAt(i), 'E'));
                allData.add(pn.replace(pn.charAt(i), 'F'));
                count += 3;
            } else if (pn.charAt(i) == '4') {
                allData.add(pn.replace(pn.charAt(i), 'G'));
                allData.add(pn.replace(pn.charAt(i), 'H'));
                allData.add(pn.replace(pn.charAt(i), 'I'));
                count += 3;
            } else if (pn.charAt(i) == '5') {
                allData.add(pn.replace(pn.charAt(i), 'J'));
                allData.add(pn.replace(pn.charAt(i), 'K'));
                allData.add(pn.replace(pn.charAt(i), 'L'));
                count += 3;
            } else if (pn.charAt(i) == '6') {
                allData.add(pn.replace(pn.charAt(i), 'M'));
                allData.add(pn.replace(pn.charAt(i), 'N'));
                allData.add(pn.replace(pn.charAt(i), 'O'));
                count += 3;
            } else if (pn.charAt(i) == '7') {
                allData.add(pn.replace(pn.charAt(i), 'P'));
                allData.add(pn.replace(pn.charAt(i), 'Q'));
                allData.add(pn.replace(pn.charAt(i), 'R'));
                allData.add(pn.replace(pn.charAt(i), 'S'));
                count += 3;
            } else if (pn.charAt(i) == '8') {
                allData.add(pn.replace(pn.charAt(i), 'T'));
                allData.add(pn.replace(pn.charAt(i), 'U'));
                allData.add(pn.replace(pn.charAt(i), 'V'));
                count += 3;
            } else if (pn.charAt(i) == '9') {
                allData.add(pn.replace(pn.charAt(i), 'W'));
                allData.add(pn.replace(pn.charAt(i), 'X'));
                allData.add(pn.replace(pn.charAt(i), 'Y'));
                allData.add(pn.replace(pn.charAt(i), 'Z'));
                count += 3;
            }
        }

        System.out.println(allData);
        System.out.println(count);

        Combination c = new Combination();
        c.setCombination(allData.toString());
        c.setCount(count);
        cList.add(c);
        return cList;
    }

    private String removeSpace(String s) {
        return s.replaceAll("\\s+", "");
    }


//    public static void main(String[] args) {
//        PNHelper test = new PNHelper();
//        String pn = "240 386 6106";
//        test.getAllCombinationsOperation(pn);
//    }
}
