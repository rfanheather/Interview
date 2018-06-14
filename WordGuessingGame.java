// 一个dictionary，里面有很多单词，猜单词，起始1w分，猜错了一个扣1k，每过5秒扣100分，
// 每次猜的单词都能知道哪个字母是属于正确答案里面的，求一个优化算法。
// 比如[abcde, super,europ,kbcda, etc] 如果答案是abcde，你猜kbcda，那你能打到abcd_.

public class WordGuessingGame {
    TrieNode root;
    int score;
    String hint;
    
    public WordGuessingGame (String[] dict) {
        root = new TrieNode();
        score = 10000;
        hint = "";
        
        for (String str : dict) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            TrieNode cur = root;
            for (char c : s) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.words.add(str);
        }
    }
    
    public int guess() {
        int start = Instant.now().getEpochSecond();

        while (true) {
            if (hint.length() == 0) {
                String firstTry = "abcdefghijklmnopqrstuvwxyz";
                int end = Instant.now().getEpochSecond();
                if (tryWords(firstTry)) {
                    score += 1000 - (end - start) / 5 * 100;
                    int end = Instant.now().getEpochSecond();
                    start = end;
                    return score;
                } else {
                    hint = getHint(firstTry);
                    score -= (end - start) / 5 * 100;
                }
                continue;
            }

            TrieNode cur = root;
            for (char c : hint.toCharArray()) {
                cur = cur.children[c - 'a'];
            }

            for (String word : cur.words) {
                int end = Instant.now().getEpochSecond();
                if (tryWords(word)) {
                    score += 1000 - (end - start) / 5 * 100;
                    int end = Instant.now().getEpochSecond();
                    start = end;
                    hint = "";
                    return score;
                }
            }
        }
    }
    
    public int getScore() {
        return score;
    }
}

class TrieNode {
    TrieNode[] children;
    List<String> words;
    public TrieNode() {
        children = new TrieNode[26];
        words = new ArrayList<>();
    }
}
