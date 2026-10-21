
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                break;
            }

            if (i == 25) {
                return true;
            }
        }

        for (int right = s1.length(); right < s2.length(); right++) {

            count2[s2.charAt(right) - 'a']++;

            count2[s2.charAt(right - s1.length()) - 'a']--;

            boolean match = true;

            for (int i = 0; i < 26; i++) {
                if (count1[i] != count2[i]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }

        return false;
    }
}
