import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm3 = new HashMap<String,Integer>();
        Object obj;

        //HashMap에 넣기
        for(int i=0; i<clothes.length; i++) {
            obj = hm3.get(clothes[i][1]);
            if(obj == null){
                hm3.put(clothes[i][1], 1);
            }else{
                hm3.put(clothes[i][1],(int)obj+1);
            }
        }

        // 각 의상 개수가 a,b,c라면 (a+1)(b+1)(c+1) - 1 가 총 갯수
        for(String cloth: hm3.keySet()){
            answer = answer*(hm3.get(cloth)+1);
        }
        answer = answer - 1;

        return answer;
    }
}