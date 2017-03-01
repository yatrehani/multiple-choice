package Task2;

/*
 * @author Yat Rehani
 * 
 * This file is the Model component of the MVC, and it models the business
 * logic for the web application.  In this case, the business logic involves
 * maintaining survey results
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ClickerModel {

  private HashMap<String, Integer> result = new HashMap<String, Integer>();

    /**
     * Arguments.
     *
     * @param answer submitted by user.
     */
    public void postAnswer(String answer){
        if(result.get(answer)!=null)
        result.put(answer,result.get(answer)+new Integer(1));
        else
        result.put(answer,new Integer(1));
    }

   

    /*
     * 
     * @return Returns Survey Results as String
     */
    public String getResults() {
        
        StringBuilder str = new StringBuilder();
        
        List<String> keys = new ArrayList<String>(result.keySet());
        Collections.sort(keys);
        for (String key: keys) {
        str = str.append(System.getProperty("line.separator")).append(key + ": " + result.get(key)+"</br>");
            }
        result.clear();
        
        return str.toString();
    }

}
