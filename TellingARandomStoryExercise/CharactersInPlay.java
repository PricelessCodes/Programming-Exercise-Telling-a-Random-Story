
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    
    private ArrayList<String> names;
    private ArrayList<Integer> freqs;
    
    public CharactersInPlay() {
        names = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    
    private void update(String person){
        
        int index = names.indexOf(person);
        if (index == -1)
        {
            names.add(person);
            freqs.add(1);
        }
        else
        {
            int freq = freqs.get(index);
            freqs.set(index,freq+1);
        }
    }

    private void findAllCharacters()
    {
        names.clear();
        freqs.clear();
        
        FileResource resource = new FileResource();
        
        for(String line : resource.lines())
        {
            if (line.indexOf(".") != -1)
            {
               String name = line.substring(0, line.indexOf("."));
               update(name);
            }
        }
    }
    
    private void charactersWithNumParts(int num1, int num2){
        System.out.println("Names of all those characters that have between " + num1 + " and " + num2 + " lines:");
        for (int i = 0; i < names.size(); i++)
        {
            if (freqs.get(i) >= num1 && freqs.get(i)<= num2)
            {
               System.out.println(names.get(i) + "\t" + freqs.get(i));
            }
        }
    }
    
    public void tester()
    {
        findAllCharacters();
        
        for(int i=0; i < names.size(); i++)
        {
            if (freqs.get(i) > 1)
            {
                System.out.println("word: " + names.get(i) + ", Freq: " + freqs.get(i));
            }
        }
        
        charactersWithNumParts(10, 15);
    }
}
