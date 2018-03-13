package leetcode;
/**
 * @author CoderGang
 */
public class Problem5 {
    public Problem5() {
    }
    public String solustion(String s){
        char[] a=s.toCharArray();
        int end=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            char c=a[i];
            for(int n=s.length()-1;n>i;n--){
                if(c==a[n]) {
                    char c2=c;
                    boolean flag=false;
                    for (int j = n; ; ) {
                        if (c2 == a[j]) {
                            j--;
                            if (j >i) {
                                c2 = a[n - j+i];
                            } else {
                                if((n-i)>(end-start))
                                {
                                    end=n;
                                    start=i;
                                    flag=true;
                                }
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            if ((end-start)>s.length()-i)
            {
                break;
            }
        }
        return s.substring(start,end+1);
    }

    public String solution2(String s){
        int center=0;
        int len=0;
        char[] a=s.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            int len1=getlen(a,i,i);
            int len2=getlen(a,i,i+1);
            int len3=Math.max(len1,len2);

            if(len3>len){
                len=len3;
                center=i;
            }
            if(len>(a.length-i)*2) {
                break;
            }
        }
        return s.substring(center-(len-1)/2,center+len/2+1);
    }
    private int getlen(char[] s, int left, int right) {
        int l = left,  r= right;
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public static void main(String[] args){

        System.out.println(new Problem5().solution2("bb"));
    }

}
