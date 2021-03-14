import java.util.*;

// 고유 번호(idx)와 재생 횟수(plays)를 가진 Song 클래스 생성
class Song implements Comparable<Song> {
    public int idx;
    public int plays;
    public Song(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }

    //재생 횟수(plays) 큰 것이 더 크도록, 재생 횟수가 같다면 idx를 비교하여 더 낮은 것이 크도록 설정
    @Override
    public int compareTo(Song o) {
        if (this.plays == o.plays) {
            if (this.idx > o.idx) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.plays < o.plays) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //int[] answer = {};

        Map<String,Integer> grank = new HashMap<>();

        // 1. 장르의 순위 결정
        for(int i=0; i<genres.length; i++){
            grank.put(genres[i], grank.getOrDefault(genres[i], 0) + plays[i]);
        }
        int[] rank = new int[grank.size()];

        int j = 0;
        for(String genre :  grank.keySet()){
            rank[j] = grank.get(genre);
            j++;
        }
        //내림차순으로 정렬하고팠으나 일단 오름차순
        Arrays.sort(rank);
        // 왜 안되는지 모름  Arrays.sort(rank, Collections.reverseOrder());

        //모든 장르는 재생된 횟수가 다르므로 rankHash의 Key, Value를 바꾼 HashMap 생성
        Map<Integer, String> rankMapReverse = new HashMap<>();
        for (String key : grank.keySet()) {
            rankMapReverse.put(grank.get(key), key);
        }

        //장르의 재생 횟수를 이용하여 가장 높은 장르부터 rankArr에 순서대로 저장(장르의 순위 선정 완료)
        String[] rankArr = new String[rank.length];
        for (int i = 0; i < rank.length; i++) {
            rankArr[i] = rankMapReverse.get(rank[(rank.length-1) - i]);
        }

        // 여기부터 보기
        //장르의 순위는 정해졌으니 각 노래의 1,2위를 뽑기 위한 HashMap 생성
        HashMap<String, PriorityQueue<Song>> songsRank = new HashMap<String, PriorityQueue<Song>>();
        for (int i = 0; i < plays.length; i++) {
            if (songsRank.containsKey(genres[i])) {
                songsRank.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                songsRank.put(genres[i], new PriorityQueue<Song>());
                songsRank.get(genres[i]).add(new Song(i, plays[i]));
            }
        }

        //정답리스트를 만들고 rankArr에 저장한 장르 순서대로 우선순위 큐에서 우선 순위가 높은 Song 하나씩 뽑아서 idx 저장
        ArrayList<Integer> answerArrList = new ArrayList<Integer>();
        for (int i = 0; i < rankArr.length; i++) {
            answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
            //해당 장르에 한 곡이 전부라면 if 문 통과
            if (songsRank.get(rankArr[i]).peek() != null) {
                answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
            }
        }

        //정답 리스트를 Array 형태로 변환 .toArray()는 Object[] 형태로 나오므로 int[] 형태로 바꾸어줌
        int[] answerArr = new int[answerArrList.size()];
        Object[] answerArrObj = answerArrList.toArray();
        for (int i = 0; i < answerArrObj.length; i++) {
            answerArr[i] = (int) answerArrObj[i];
        }

        return answerArr;

    }

}