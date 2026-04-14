public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j <= n - i; j++) {
                String f = num.substring(0, i);
                String s = num.substring(i, j);
                String l = num.substring(j);
                if (isValid(f) && isValid(s) && validSeq(f, s, l)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(String str) {
        return str.length() == 1 || str.charAt(0) != '0';
    }
    private boolean validSeq(String f, String s, String l) {
        if (l.length() == 0) return true;
        String sum = String.valueOf(Long.parseLong(f) + Long.parseLong(s));
        if (!l.startsWith(sum)) return false;
        return validSeq(s, sum, l.substring(sum.length()));
    }
}
