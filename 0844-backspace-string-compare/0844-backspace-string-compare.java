class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            // Find the index of the next valid character in s
            i = getNextValidIndex(s, i);
            // Find the index of the next valid character in t
            j = getNextValidIndex(t, j);

            // If both pointers are within bounds, compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } 
            // If one string is exhausted but the other still has valid characters
            else if ((i >= 0) != (j >= 0)) {
                return false;
            }

            // Move backwards for the next iteration
            i--;
            j--;
        }

        return true;
    }

    private int getNextValidIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
                index--;
            } else if (backspaceCount > 0) {
                backspaceCount--;
                index--;
            } else {
                // We found a character that won't be deleted
                break;
            }
        }
        return index;
    }    
}
