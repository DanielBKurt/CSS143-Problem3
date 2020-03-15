My solution to autocomplete used TrieNodes. The TrieNodes have an instance array of 26 TrieNodes (for each letter of the alphabet)
and insert fills that array for every new letter. The tests class also has an instance array of 26 TrieNodes which serves as the 'roots'
for each word. For example, in the word see, it starts in the Tests instance array at array[18] (s) and insert creates a new TrieNode to fill
that spot. It then moves a pointer to that TrieNode and fills in its instance array of children TrieNodes, in this case e, which is array[4].
The pointer then moves to that TrieNode and creates a new TrieNode in the next array of children TrieNodes and it would continue from there
for longer words. When searching, a pointer moves through the searched term, such as "sea", and then recursively moves down the rest of the
nodes, calling itself each time it reaches a new TrieNode and passing in the same key plus the new letter. Each TrieNode also has an 
instance boolean, isEndOfWord, to determine when the word is complete, in which case it simply adds that word to the list. 

(I wrote the search and searchRec functions but used code from Geeksforgeeks to write insert() and the TrieNode class).

This is the fastest method I could think of because it uses O(N) time complexity. Besides a few outliers, the total time to call the 
search function on all inputs combined was around 60 - 75 milliseconds (this does not include populating the TrieNode array). I can not think
of a way to get below O(N) time complexity for this problem and since I think this follows it, I think this is one of the fastest ways.


