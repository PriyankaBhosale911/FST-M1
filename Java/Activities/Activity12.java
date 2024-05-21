package Activities;
interface FunctionalInterfaceExample{
    String display(String str);
        }
      /*  public class Activity12
        {
            Activity12 onj=new Activity12();
            public static void main(String[] args)
            {
               //  System.out.println(obj.display("Hello"));
                FunctionalInterfaceExample obj= (String str) -> {
                    return str;


            };

            System.out.println(obj.display("Hello"));
        }}*/
interface Addable{
    int add(int a, int b);
}
public class Activity12{
    public static void main(String[] args){
        //Lambda Expression without return keyword
        Addable ad1=(a,b)->(a + b);
        System.out.println(ad1.add(10,28));

        //Lambda Expression with return Keyword
        Addable ad2=(int a, int b)->{
            return(a + b);
        };
        System.out.println(ad2.add(100,200));
    }
}
