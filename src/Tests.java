import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.ArrayList;

public class Tests {
    TrieNode[] array = new TrieNode[26]; //starting 26 letters for any word
    public void test()
    {
        String[] keys = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        for (int i = 0; i < keys.length; i++)
            insert(keys[i]);

        String[] inputs = {"h", "se", "sea", "ho", "xyz"};
        String[][] expectedOutputs = {
                {"hello", "high", "hollow", "how"},
                {"seatac", "seattle", "see"},
                {"seatac", "seattle"},
                {"hollow", "how"},
                {}
        };

        for (int i = 0; i < inputs.length; i++)
        {
            List<String> list = search(inputs[i]);
            if (list.size() == 0) //for xyz search
                assertTrue(list.size() == expectedOutputs[i].length);
            else
            {
                for (int x = 0; x < list.size(); x++)
                    assertTrue(list.get(x).equals(expectedOutputs[i][x]));
            }
        }
    }

    public void insert(String key) //insert and TrieNode class from GeeksForGeeks.com
    {
        int root = key.charAt(0) - 'a';
        if (array[root] == null)
            array[root] = new TrieNode();
        TrieNode pCrawl = array[root];
        for (int i = 1; i < key.length(); i++)
        {
            int index = key.charAt(i) - 'a'; //converts to 0-25
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public List<String> search(String search) {
        List<String> list = new ArrayList<String>();
        if (search.length() == 0 || array[search.charAt(0) - 'a'] == null)
            return list;
        TrieNode ptr = array[search.charAt(0) - 'a'];
        for (int i = 1; i < search.length(); i++) {
            if( array[search.charAt(0) - 'a'] == null)
                return list;
            ptr = ptr.children[search.charAt(i) - 'a'];
        }
        if (ptr.isEndOfWord)
            list.add(search); //searched full word
        else
            searchRec(search.toLowerCase(), list, ptr);
        return list;
    }
    public void searchRec(String search, List<String> list, TrieNode ptr)
    {
        for (int i = 0; i < ptr.children.length; i++)
        {
            if (ptr.children[i] != null)
            {
                if (ptr.children[i].isEndOfWord)
                    list.add(search + Character.toString(i + 'a'));
                else
                    searchRec(search + Character.toString(i + 'a'), list, ptr.children[i]);
            }
        }
    }
}
