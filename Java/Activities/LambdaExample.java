package Examples;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
public static void main(String[] args){
    List<String> list=  new ArrayList<>();
    list.add("Rick");
    list.add("Negan");
    list.add("Deryl");
    list.add("Glen");
    list.add("Carl");

    //loop through Arraylist
    list.forEach(
            (String name)-> System.out.println(name)
    );
}
}
