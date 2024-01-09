package algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 *
 * @author: east
 * @date: 2024/1/5
 */
public class Nqueens {
    static class Res {
        public Integer x;
        public Integer y;

        public Res() {
        }

        public Res(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public void backtrace(Integer row, Integer col, List<Res> state, List<List<String>> choices, List<List<Res>> res) {
        if (isSolution(state, choices)) {
            recordSolution(state, res);
            return;
        }

        for (int i = 0; i < choices.size(); i++) {
            if (isValid(row, col, state, choices.get(0))) {
                updateState(row, col, state);
//                    // 如果x到底，则x归0,y+1 ;
                if (col == choices.size() - 1) {
                    row += 1;
                    col = 0;
                } else {
                    col += 1;
                }
                backtrace(row, col, state, choices, res);
                undoChoice(state);
            }

        }

    }

    /**
     * 状态回退
     */
    private void undoChoice(List<Res> state) {
        if (!state.isEmpty()) {
            state.remove(state.size() - 1);
        }
    }

    private void updateState(Integer row, Integer col, List<Res> state) {
        state.add(new Res(row, col));
    }

    /**
     * 判断当前位置是否可以摆放QUEUE棋子
     * 0. x, y不越界
     * 1. 当前位置x,y轴不能有棋子: x!=x0 && y!=y0
     * 2. 当前位置两个对角线不能有棋子: (x-y)!=(x0-y0) && (x+y)!=(x0+y0)
     *
     * @param row    row
     * @param col    col
     * @param state  state
     * @param choice choice
     * @return res
     */
    private boolean isValid(Integer row, Integer col, List<Res> state, List<String> choice) {
        boolean judge0 = row < choice.size() && col < choice.size();
        if (!judge0) {
            return false;
        }
        for (Res res : state) {
            boolean judge1 = (!row.equals(res.x)) && (!col.equals(res.y));
            boolean judge2 = ((row - col) != (res.x - res.y)) && ((row + col) != (res.x + res.y));
            if (!(judge1 && judge2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 记录结果
     *
     * @param state state
     * @param res   res
     */
    private void recordSolution(List<Res> state, List<List<Res>> res) {
        res.add(new ArrayList<>(state));
    }

    /**
     * 怎么判断当前摆放状态是解？
     * 直接判断state，数量为行数则说明是解。判别逻辑由减枝逻辑保证
     *
     * @param state   state
     * @param choices CHOICE
     * @return res
     */
    private boolean isSolution(List<Res> state, List<List<String>> choices) {
        return state.size() == choices.size();
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> choices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<String> choice = new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                choice.add("#");
            }
            choices.add(choice);
        }
        List<List<Res>> res = new ArrayList<List<Res>>();
        Nqueens nqueens = new Nqueens();
        nqueens.backtrace(0, 0, new ArrayList<Res>(), choices, res);

        // 打印结果
        for (int i = 0; i < res.size(); i++) {
            System.out.println("第" + i + "种结果");
            // 第i种结果
            List<Res> res1 = res.get(i);
            for (int x = 0; x < n; x++) {
                // 第一行QUEUE棋子位置
                Integer targetX = res1.get(x).x;
                Integer targetY = res1.get(x).y;
                for (int y = 0; y < n; y++) {
                    if (x == targetX && y == targetY) {
                        System.out.print("Q");
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
            System.out.println("\n");
        }


    }

}
