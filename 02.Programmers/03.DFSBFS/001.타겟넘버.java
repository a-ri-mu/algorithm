import java.util.*;

class Solution {
    int target;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.target = target;

        int a = numbers[0];

        answer += dfs(a,0,numbers);
        answer += dfs(-a,0,numbers);

        return answer;
    }

    public int dfs(int a, int index, int[] numbers){
        ++index;
        if(index == numbers.length){
            if(target == a){
                //System.out.println("index "+index+" target "+target);
                return 1;
            }else{
                return 0;
            }
        }

        int plus = a + numbers[index];
        int minus = a - numbers[index];

        int midAns = 0;
        midAns += dfs(plus,index,numbers);
        midAns += dfs(minus,index,numbers);

        return midAns;

    }

}