class Solution {
    public String decodeString(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)!=']')
                s.push(str.charAt(i));
            else {
                StringBuilder res = new StringBuilder();
                String temp = "";
                char c = s.pop();
                while(c!='[') {
                    temp+= c+"";
                    c=s.pop();
                }
                String n = "";
                c = s.pop();
                while(true) {
                    n= c+n;
                    if(!s.isEmpty())
                        c= s.peek();
                    if(c>='0' && c<='9' && !s.isEmpty())
                        c=s.pop();
                    else
                        break;
                }
                int reps = Integer.parseInt(n);
                while(reps!=0) {
                    res.append(temp);
                    reps--;
                }
                res.reverse();
                char ch[] = new char[res.length()];
                res.getChars(0, res.length(), ch, 0);
                for(char l : ch)
                    s.push(l);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.reverse().toString();
    }
}