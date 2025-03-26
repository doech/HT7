public class TreeNode {
    public String key; 
    public Producto value; 
    public TreeNode left, right; 

    public TreeNode(String key, Producto value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}

