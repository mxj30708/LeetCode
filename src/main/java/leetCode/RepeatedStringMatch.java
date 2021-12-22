package leetCode;

/**
 * @author mengxijie
 * @since 2021/12/22 9:27 上午
 * 686. 重复叠加字符串匹配
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int n = (b.length()/a.length())+2;
        StringBuilder result = new StringBuilder();
        int number =-1;
        for(int i =0;i<=n;i++){
            if(result.toString().contains(b)){
                number=i;
                break;
            }
            result.append(a);
        }
        return number;
    }

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        System.out.println(repeatedStringMatch.repeatedStringMatch("abc","cabcabca"));
    }
}
