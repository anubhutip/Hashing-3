import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
//TC: O(10n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        Set<String> res=new HashSet<>();
        HashSet<String> ss=new HashSet<>();
        for(int i=0;i<n-9;i++){  //substring(n-10,n)
            String curr=s.substring(i,i+10);
            if(ss.contains(curr)){
                res.add(curr);
            }else{
                ss.add(curr);
            }
        }
        return new ArrayList<>(res);
    }
}
*/
//TC: O(n)
//SC: O(n-10)
class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);
        Set<Long> set=new HashSet<>();
        Set<String> res=new HashSet<>();
        long currhash=0l;
        for(int i=0;i<n;i++){
            char in =s.charAt(i);
            if(i>9){
                char out=s.charAt(i-10);
                currhash=currhash-(long)Math.pow(4,9)*map.get(out);
            }
            currhash = currhash*4 + map.get(in);
            if(i>=9){
                if(set.contains(currhash)){
                    res.add(s.substring(i-9,i+1));
                }else{
                    set.add(currhash);
                }
            }
            
        }
        return new ArrayList<>(res);
    }
}