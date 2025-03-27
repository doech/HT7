import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    public void testInsertAndSearchSKU() {
        BinarySearchTree<String, Producto> bst = new BinarySearchTree<>();

        Producto producto1 = new Producto("001", "Camiseta Running", "Camiseta ligera", "xs:5|s:10|m:20|l:15|xl:10");
        Producto producto2 = new Producto("002", "Short Deportivo", "Short elástico", "s:10|m:25|l:30");

        bst.insert(producto1.getSku(), producto1);
        bst.insert(producto2.getSku(), producto2);

        assertEquals(producto1, bst.search("001"));
        assertEquals(producto2, bst.search("002"));
        assertNull(bst.search("999"));
    }

    @Test
    public void testSearchPorNombre() {
        BinarySearchTree<String, Producto> bst = new BinarySearchTree<>();

        Producto producto1 = new Producto("001", "Camiseta Running", "Camiseta ligera", "xs:5|s:10|m:20|l:15|xl:10");
        Producto producto2 = new Producto("002", "Short Deportivo", "Short elástico", "s:10|m:25|l:30");

        bst.insert(producto1.getSku(), producto1);
        bst.insert(producto2.getSku(), producto2);

        assertEquals(producto1, bst.searchPorNombre("Camiseta Running"));
        assertEquals(producto2, bst.searchPorNombre("Short Deportivo"));
        assertNull(bst.searchPorNombre("Producto Inexistente"));
    }
}
