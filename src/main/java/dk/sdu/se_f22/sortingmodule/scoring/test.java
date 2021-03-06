package dk.sdu.se_f22.sortingmodule.scoring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) throws ParseException {
        List<TestProduct> products = new ArrayList<>();

        products.add(new TestProduct("Pizza",1895,2.3,1,new SimpleDateFormat("dd/MM/yyyy").parse("02/22/2020")));
        products.add(new TestProduct("Stikkontakt",3000,3.6,17,new SimpleDateFormat("dd/MM/yyyy").parse("05/22/2028")));
        products.add(new TestProduct("Burger",859,1,50,new SimpleDateFormat("dd/MM/yyyy").parse("05/22/1996")));
        products.add(new TestProduct("Chocolate",6879,3.2,23,new SimpleDateFormat("dd/MM/yyyy").parse("03/22/1972")));
        products.add(new TestProduct("Apple",4632,4.9,150,new SimpleDateFormat("dd/MM/yyyy").parse("09/22/2019")));
        products.add(new TestProduct("French Fries",465,4.7,2,new SimpleDateFormat("dd/MM/yyyy").parse("02/22/2018")));
        products.add(new TestProduct("Tacos",1895,2.2,102,new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2016")));
        products.add(new TestProduct("Waffles",1995,17,8,new SimpleDateFormat("dd/MM/yyyy").parse("12/22/2017")));
        products.add(new TestProduct("Pancakes",2895,4.5,77,new SimpleDateFormat("dd/MM/yyyy").parse("08/22/2018")));
        products.add(new TestProduct("Syrup",3895,3,46,new SimpleDateFormat("dd/MM/yyyy").parse("01/22/2002")));
        products.add(new TestProduct("Oatmeals",2895,1.3,200,new SimpleDateFormat("dd/MM/yyyy").parse("06/22/2018")));
        products.add(new TestProduct("Cornflakes",2395,2.2,5,new SimpleDateFormat("dd/MM/yyyy").parse("02/22/2019")));
        products.add(new TestProduct("Cake",3395,4.7,9,new SimpleDateFormat("dd/MM/yyyy").parse("02/22/2017")));

        IScoring scoring = new Scoring();
        //System.out.println(scoring.scoreSort(products));
        //System.out.println(scoring.readTable());
        scoring.updateRow(16,"1500","bracket");
        //scoring.deleteRow(28);
        //scoring.createRow("price",2000,2);
        System.out.println(scoring.readTable());
        //System.out.println(scoring.scoreSortPrice(products));
    }
}
