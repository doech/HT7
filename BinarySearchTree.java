public class BinarySearchTree {
    private TreeNode root;

    public void insert(String key, Producto value) {
        TreeNode newNode = new TreeNode(key, value);
        if (root == null) {
            root = newNode; 
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (key.compareTo(current.key) < 0) { 
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else { // Ir al subárbol derecho
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Producto search(String key) {
        TreeNode current = root;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value; 
            } else if (key.compareTo(current.key) < 0) {
                current = current.left; 
            } else {
                current = current.right;
            }
        }
        return null; 
    }

    public void recorrer() {
        recorrer(root); 
    }

    private void recorrer(TreeNode node) {
        if (node != null) {
            recorrer(node.left); 
            System.out.println(node.value); 
            recorrer(node.right); 
        }
    }
}

