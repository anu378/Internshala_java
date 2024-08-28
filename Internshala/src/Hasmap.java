import java.util.HashMap;
import java.util.Map;
public class Hasmap {
    public static  void main(String s[]){
        Map<Integer,String> namesMap=new HashMap();
        namesMap.put(1,"Shashank");
        namesMap.put(23,"Ayush");
        namesMap.put(2,"Harsh");
        //namesMap.put(23,"Anuj");
       // System.out.println(namesMap.get(23));
        for (Map.Entry entry: namesMap.entrySet()){

            System.out.println(entry.getKey()+" "+entry.getValue());
        }
             {

        }
    }
}
