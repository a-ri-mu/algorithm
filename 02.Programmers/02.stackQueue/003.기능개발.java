import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q1 = new LinkedList<Integer>();
        for(int i=0; i<progresses.length; i++){
            //offer add 차이는?
            int a = (100-progresses[i])/speeds[i];
            int b = (100-progresses[i])%speeds[i];

            if(b != 0) a=a+1;
            //System.out.println(" a :  " + a);
            q1.offer(a);
        }

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        int cnt = 1;
        int max = q1.poll();

        while(!q1.isEmpty()){
            //System.out.println(" max :  " + max + " peek :  " + peek);
            if(max >= q1.peek() ){
                ++cnt;
                q1.poll();
            }else{
                a1.add(cnt);
                max = q1.poll();
                cnt=1;
            }
        }
        a1.add(cnt);

        int[] answer = new int[a1.size()];
        for(int j=0; j<answer.length; j++){
            answer[j] = a1.get(j);
        }

        return answer;
    }
}