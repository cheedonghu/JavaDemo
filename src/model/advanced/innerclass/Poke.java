package model.advanced.innerclass;

import model.base.DemoClassA;

/**
 * 扑克类，内部有红桃和黑桃
 *
 * @author: east
 * @date: 2023/10/23
 */

public class Poke {
    public static class Spade {
        public Spade() {
            System.out.println("Poke.Spade created");
        }
    }

    public class Peach extends DemoClassA {
        public Peach() {
            super();
            System.out.println("Poke.Peach created");
        }
    }

    public Poke() {
        System.out.println("Poke created");
    }
}
