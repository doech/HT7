/**
 * Ale Sierra #24405
 * Clase que representa un árbol binario de búsqueda y sus operaciones.
 *
 * @param <K> tipo generico del key.
 * @param <V> tipo generico del value.
 */
public class BinarySearchTree<K, V> {
    private TreeNode<K, V> root;

    /**
     * método que inserta un nodo en el árbol
     *
     * @param key   
     * @param value 
     */
    public void insert(K key, V value) {
        TreeNode<K, V> newNode = new TreeNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode<K, V> current = root;
            TreeNode<K, V> parent;
            while (true) {
                parent = current;
                if (key.toString().compareTo(current.key.toString()) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * método que busca un nodo en el árbol por sku
     *
     * @param key que será sku en este caso
     * @return el valor del nodo
     */
    public V search(K key) {
        TreeNode<K, V> current = root;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            } else if (key.toString().compareTo(current.key.toString()) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    /**
     * método que busca un nodo en el árbol por nombre
     *
     * @param nombre que será el nombre del producto
     * @return el valor del nodo
     */
    public V searchPorNombre(String nombre) {
        return search2(root, nombre);
    }

    private V search2(TreeNode<K, V> node, String nombre) {
        if (node == null) {
            return null;
        }
        Producto producto = (Producto) node.value; 
        if (producto.getNombre().equals(nombre)) {
            return node.value;
        }
        V leftResult = search2(node.left, nombre);
        if (leftResult != null) {
            return leftResult;
        }
        return search2(node.right, nombre);
    }

    /**
     * método que recorre el árbol en orden
     * no tiene parametros de entrada ni de salida porque solo imprime los valores
     * que ya se tienen de los nodos en orden
     */
    public void recorrer() {
        recorrer2(root);
    }

    private void recorrer2(TreeNode<K, V> node) {
        if (node != null) {
            recorrer2(node.left);
            System.out.println(node.value);
            recorrer2(node.right);
        }
    }
}

