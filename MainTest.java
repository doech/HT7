import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private BinarySearchTree<String, Producto> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert("001", new Producto("001", "Camiseta Running", "Camiseta ligera", "xs:5|s:10|m:20|l:15|xl:10"));
        bst.insert("002", new Producto("002", "Short Deportivo", "Short elástico", "s:10|m:25|l:30"));
    }

    @Test
    public void testAñadirProducto() {
        Producto nuevoProducto = new Producto("003", "Leggings Compresión", "Leggings ajustados", "xs:8|s:12|m:18|l:20|xl:10");
        bst.insert(nuevoProducto.getSku(), nuevoProducto);

        assertEquals(nuevoProducto, bst.search("003"));
    }

    @Test
    public void testBuscarProductoPorSKU() {
        assertNotNull(bst.search("001"));
        assertNull(bst.search("999"));
    }

    @Test
    public void testBuscarProductoPorNombre() {
        assertNotNull(bst.searchPorNombre("Camiseta Running"));
        assertNull(bst.searchPorNombre("Producto Inexistente"));
    }

    @Test
    public void testEditarProducto() {
        Producto producto = bst.search("001");
        producto.setNombre("Camiseta Actualizada");

        assertEquals("Camiseta Actualizada", bst.search("001").getNombre());
    }
}
