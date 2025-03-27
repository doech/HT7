public class BinarySearchTree<K, V> {
    private TreeNode<K, V> root;

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

    public V searchPorNombre(String nombre) {
        return searchPorNombreRecursive(root, nombre);
    }

    private V searchPorNombreRecursive(TreeNode<K, V> node, String nombre) {
        if (node == null) {
            return null;
        }
        Producto producto = (Producto) node.value; // Assume all values are Producto
        if (producto.getNombre().equals(nombre)) {
            return node.value;
        }
        V leftResult = searchPorNombreRecursive(node.left, nombre);
        if (leftResult != null) {
            return leftResult;
        }
        return searchPorNombreRecursive(node.right, nombre);
    }

    public void recorrer() {
        recorrer(root);
    }

    private void recorrer(TreeNode<K, V> node) {
        if (node != null) {
            recorrer(node.left);
            System.out.println(node.value);
            recorrer(node.right);
        }
    }
}

