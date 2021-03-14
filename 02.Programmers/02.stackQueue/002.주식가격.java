import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // Queue 는 인터페이스이므로 링크드인을 사용함
        Queue<Integer> q1 = new LinkedList<Integer>();
        for(int a : prices){
            q1.offer(a);
        }

        int i, j=0;

        while(!q1.isEmpty()){
            int cnt = 0;
            int match = q1.poll();
            //System.out.println("match : "+match);
            for(i=j+1; i<prices.length; i++){
                cnt++;
                answer[j] = cnt;
                if(match>prices[i]){
                    break;
                }
                //System.out.println("i : "+i+" j : "+j+ " cnt : "+ cnt);
            }
            j++;
        }

        return answer;
    }
}