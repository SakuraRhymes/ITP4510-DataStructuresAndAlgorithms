package Lab03.Lab3_4.Q1;

public class IntBstNode {
    private int data;
    private IntBstNode left;
    private IntBstNode right;

    public IntBstNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public IntBstNode getLeft() {
        return left;
    }

    public IntBstNode getRight() {
        return right;
    }

    public void setLeft(IntBstNode p) {
        left = p;
    }

    public void setRight(IntBstNode p) {
        right = p;
    }
}
