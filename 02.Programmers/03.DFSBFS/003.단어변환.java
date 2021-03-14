import java.util.*;

class Solution {

    String targetWord;
    boolean[] visited;
    int minimum;

    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        minimum = len+1; //최대값+1 설정
        visited = new boolean[len];
        targetWord = target;

        int answer = dfs(begin, words, 1);

        return answer == len + 1? 0 : answer;
    }

    public int dfs(String begin, String[] words, int n){

        for(int i=0; i<words.length; i++){
            if(!visited[i] && chkChar(begin,words[i])){

                //System.out.println(n + " " + minimum + " " + begin + " " + words[i]);

                if (words[i].equals(targetWord) ) {
                    //System.out.println("right! " + n + "  mini "+ minimum);
                    return minimum>n? n: minimum;
                }

                visited[i] = true;
                int number = dfs(words[i], words, n+1);
                if(minimum > number) minimum = number;
                visited[i] = false;

            }
        }

        return minimum;
    }

    //1단어만 다른지 체크
    public boolean chkChar(String str1, String str2){
        int chkCnt = 0;
        for(int j=0; j<str1.length(); j++){
            if(str1.charAt(j) != str2.charAt(j))
                ++chkCnt;

            if(chkCnt>1)
                return false;
        }
        return (chkCnt==1);
    }

}