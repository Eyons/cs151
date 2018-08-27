
import java.util.*;

public class Encoding
{
   public static Set<String> morseCodes(int m, int n){
        Set<String> result = new TreeSet<>();
        String init = "";
        for(int i = 0; i < m; i++)
            init += ".";
        for(int i = 0; i < n; i++)
            init += "-";

        generate(init, 0, result);
        
        return result;
    }

    public static void generate(String str, int j, Set<String> result){
        for(int i = j; i < str.length(); i++){
            char[] temp = str.toCharArray();
            char ctemp = temp[i];
            temp[i] = temp[j];
            temp[j] = ctemp;
            str = new String(temp);

            generate(str, j+1, result);

            temp = str.toCharArray();
            ctemp = temp[i];
            temp[i] = temp[j];
            temp[j] = ctemp;
            str = new String(temp);
        }
        if(j == str.length()-1)
            result.add(str);
    }
}