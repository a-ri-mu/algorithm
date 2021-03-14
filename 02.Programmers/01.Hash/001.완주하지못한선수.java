class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        int len = phone_book.length;

        //1. no HASH
        for(int i =0; i < len; i++){
            for(int j=i+1; j < len; j++){
                if(phone_book[j].startsWith(phone_book[i])
                        || phone_book[i].startsWith(phone_book[j])){
                    return false;
                }
            }
        }
        return answer;
    }
}