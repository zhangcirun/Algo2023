package Go2023;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, n, ans, new StringBuilder());
        return ans;
    }

    private void dfs(int openNum, int closeNum, List<String> ans, StringBuilder sb) {
        if (openNum == 0 && closeNum == 0) {
            ans.add(sb.toString());
            return;
        }

        if (openNum > 0) {
            sb.append('(');
            dfs(openNum - 1, closeNum, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeNum > 0 && closeNum > openNum) {
            sb.append(')');
            dfs(openNum, closeNum - 1, ans, sb);
        }
    }
}
