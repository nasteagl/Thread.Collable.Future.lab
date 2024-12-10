package lab_5;
import java.util.*;
public class ComandaOnlineClass {
private final int comanda_id;
private final String customer_name;
private final String product_name;


public ComandaOnlineClass()
{
    this.comanda_id=func_random_id();
    this.customer_name=func_random_customer_name();
    this.product_name=func_random_customer_name();
}

public ComandaOnlineClass(int comanda_id,String customer_name,String product_name){
    System.out.print("Id-ul comenzii este"+comanda_id);
    this.comanda_id=comanda_id;
    System.out.println("Numele clientului este:"+customer_name);
    this.customer_name=customer_name;
    System.out.println("Numele clientului este:"+customer_name);
    this.product_name=product_name;
}
Random random=new Random();

int func_random_id(){
int[] random_id={12121212,23232323,12343322,2344334,3455666,4543434,4343434};
int index=random.nextInt(random_id.length);
return random_id[index]; 
}
String func_random_product_name(){
    String[] random_product_name={"Clothes","Cosmetics","Car","Toys","Toy Bear",""};
    int index=random.nextInt(random_product_name.length);
    return random_product_name[index];
}
String func_random_customer_name(){
    String[] random_customer_name={"Ana","Danu","Alexandra","Ion","Aaa","Bbb","Ccc"};
    int index=random.nextInt(random_customer_name.length);
    return random_customer_name[index];
}
public String toString() {
    return "Comanda{" +
            "comanda_id=" + comanda_id +
            ", customer_name='" + customer_name + '\'' +
            ", product_name='" + product_name + '\'' +
            '}';
}

}
