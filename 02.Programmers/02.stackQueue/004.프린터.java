import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int priorLen = priorities.length;
        Queue<Integer> priorQ = new LinkedList<Integer>();
        Queue<Integer> locQ = new LinkedList<Integer>();

        for(int i=0; i<priorLen; i++){
            priorQ.offer(priorities[i]);
            locQ.offer(i);
        }

        while(!priorQ.isEmpty()){
            int pq = priorQ.poll();
            int lq = locQ.poll();

            if(priorQ.isEmpty()){
                ++answer;
                break;
            }

            if(pq < Collections.max(priorQ)){
                priorQ.offer(pq);
                locQ.offer(lq);
            }else{
                ++answer;
                if(lq == location){
                    break;
                }
            }
        }

        return answer;
    }
}