package Lab03.Lab3_4.Q2.Q2a;

public class StringBst {
    private StringBstNode root;

    public StringBst() {
        this.root = null;
    }

    public void addNode(String data) {
        StringBstNode p = root;
        StringBstNode prev = null;

        if (root == null) { // empty tree
            root = new StringBstNode(data);
            return;
        }

        while (p != null) {    // find a place for insertion
            prev = p;
            if (data.compareTo(p.getData()) < 0)
                p = p.getLeft();
            else
                p = p.getRight();
        }

        if (data.compareTo(prev.getData()) < 0)
            prev.setLeft(new StringBstNode(data));
        else
            prev.setRight(new StringBstNode(data));
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    public void preorder(StringBstNode v) {
        System.out.print(v.getData() + " ");
        if (v.getLeft() != null)
            preorder(v.getLeft());
        if (v.getRight() != null)
            preorder(v.getRight());
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void inorder(StringBstNode v) {
        if (v.getLeft() != null)
            inorder(v.getLeft());
        System.out.print(v.getData() + " ");
        if (v.getRight() != null)
            inorder(v.getRight());
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    public void postorder(StringBstNode v) {
        if (v.getLeft() != null)
            postorder(v.getLeft());
        if (v.getRight() != null)
            postorder(v.getRight());
        System.out.print(v.getData() + " ");
    }

    public String search(String item) {
        return search(root, item);
    }

    public String search(StringBstNode v, String item) {
        if (v == null)
            return null;
        if (v.getData().equals(item))
            return v.getData();
        if (item.compareTo(v.getData()) < 0)
            return search(v.getLeft(), item);
        else
            return search(v.getRight(), item);
    }
}

			


