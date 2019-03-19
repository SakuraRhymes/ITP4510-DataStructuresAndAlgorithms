package Lab03.Lab3_4.Q1;

public class DemoIntBst {
    public static void main(String[] args) {
        IntBst tree = new IntBst();
        int[] dataList =
                {14, 15, 4, 9, 7, 18, 3, 5, 16, 4, 20, 17, 9, 14, 5};
        for (int i = 0; i < dataList.length; i++)
            tree.addNode(dataList[i]);
        tree.preorder();
        System.out.println();
        tree.inorder();
        System.out.println();
        tree.postorder();
    }
}
