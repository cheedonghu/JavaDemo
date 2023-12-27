package algorithm.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列问题
 * 输入一个整数数组，其中不包含重复元素，返回所有可能的排列。
 *
 * @author: east
 * @date: 2023/12/27
 */
public class AllFormat {
    public void backtrace(List<String> state, List<String> choices, List<List<String>> res) {
        if (isSolution(state)) {
            recordSolution(state, res);
            return;
        }

        for (String choice : choices) {
            if (isValid(state, choice)) {
                updateState(state, choice);
                backtrace(state, choices, res);
                undoChoice(state, choice);
            }
        }
    }

    private void undoChoice(List<String> state, String choice) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<String> state, String choice) {
        state.add(choice);
    }

    /**
     * @param state  情形
     * @param choice 选择
     * @return 是否合法
     */
    private boolean isValid(List<String> state, String choice) {
        return !state.contains(choice);
    }

    private void recordSolution(List<String> state, List<List<String>> res) {
        ArrayList<String> list = new ArrayList<>(state);
        res.add(list);
    }

    private boolean isSolution(List<String> state) {
        return state.size() == 3;
    }

    public static void main(String[] args) {
        AllFormat allFormat = new AllFormat();
        ArrayList<String> state = new ArrayList<>();
        List<String> choices = Arrays.asList("1", "2", "3");
        ArrayList<List<String>> res = new ArrayList<>();
        allFormat.backtrace(state, choices, res);
    }

}
