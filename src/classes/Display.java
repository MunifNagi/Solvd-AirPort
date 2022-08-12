package classes;

import java.util.Iterator;
import java.util.List;

public abstract class Display {

    public static void print(List<?> items){
        for (Iterator iter = items.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
    public static void numberedPrint(List<?> items){
        int i = 0;
        for (Iterator iter = items.iterator(); iter.hasNext();) {
            System.out.println(++i +"-"+iter.next());
        }
    }

}
