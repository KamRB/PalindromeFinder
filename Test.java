import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		String word = "semdmaa";
		
		String[] letters = word.split("");
		
		Map<Character, Integer> charMap = new HashMap<>();
		
		for (int i = 0; i <letters.length ; i++)
		{
			char letter = letters[i].charAt(0);
			if (charMap.containsKey(letter))
			{
				int count = charMap.get(letter);
				count++;
				
				charMap.put(letter, count);
			}
			else
			{
				charMap.put(letter, 1);
			}
		}
		
		boolean found = false;
		char middleLetter = 0;
		
		Iterator<Entry<Character,Integer>>  it = charMap.entrySet().iterator();
		while (it.hasNext()) {
		   Map.Entry<Character, Integer> entry = it.next();
			if (entry.getValue() == 1)
			{
				middleLetter = entry.getKey();
				it.remove();
			}
			else 
			{
				if (entry.getValue() % 2 != 0) 
				{
					if (!found)
					{
						found = true;
						middleLetter = entry.getKey();
					}
					
					entry.setValue(entry.getValue()-1);
				}				
			}
		}
		
		System.out.println(print(charMap, middleLetter));		
	}

	private static String print( Map<Character, Integer> charMap, char middleLetter)
	{
		String returnString = "";
		if (charMap.isEmpty())
		{
			return String.valueOf(middleLetter);
		}
		else
		{
			for (Map.Entry<Character, Integer> entry: charMap.entrySet())
			{
				for (int i = 0; i < (entry.getValue()/2); i++)
				{
					returnString += entry.getKey();
				}			 
				 
				charMap.remove(entry.getKey());
				returnString += print(charMap, middleLetter);			
				
				for (int i = 0; i < (entry.getValue()/2); i++)
				{
					returnString += entry.getKey();
				}				
				break;
			}
		}		
		return returnString;
	}

}
