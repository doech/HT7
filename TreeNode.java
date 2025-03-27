/**
 * Ale Sierra #24405
 * Clase que representa un nodo de un árbol binario.
 *
 * @param <K> tipo generics de key
 * @param <V> tipo generics de value.
 */
public class TreeNode<K, V> {
    public K key;
    public V value;
    public TreeNode<K, V> left, right;

    /**
     * constructor que permite establecer los atributos al crear un nodo.
     *
     * @param key  
     * @param value 
     */
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }
}

