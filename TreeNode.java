public class TreeNode<K, V> {
    public K key; 
    public V value; 
    public TreeNode<K, V> left, right; 

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}

