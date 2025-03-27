import java.util.Scanner;

public class Main {
    private static BinarySearchTree<String, Producto> bst = new BinarySearchTree<>();

    public static void main(String[] args) {
        String archivo = "productos.csv"; 
        CargarArchivo cargador = new CargarArchivo();
        cargador.cargarProductos(archivo, bst); 

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("MENÚ");
            System.out.println("1. Añadir Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Editar Producto");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    añadirProducto(scanner);
                    break;
                case 2:
                    mostrarProductos(scanner);
                    break;
                case 3:
                    buscarProducto(scanner);
                    break;
                case 4:
                    editarProducto(scanner);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void añadirProducto(Scanner scanner) {
        System.out.print("Ingrese SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Ingrese Nombre del Producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese Cantidades por talla (XS|S|M|L|XL): ");
        String cantidadesPorTalla = scanner.nextLine();

        Producto producto = new Producto(sku, nombre, descripcion, cantidadesPorTalla);
        bst.insert(sku, producto); 

        System.out.println("Producto añadido");
    }

    private static void mostrarProductos(Scanner scanner) {
        System.out.print("Mostrar por (1: SKU, 2: Nombre): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine();

        if (eleccion == 1) {
            System.out.println("\nProductos ordenados por SKU:");
            bst.recorrer();
        } else if (eleccion == 2) {
            System.out.println("\nProductos ordenados por Nombre:");
            bst.recorrer(); // The tree is still ordered by SKU, but all products are displayed.
        } else {
            System.out.println("Elección inválida.");
        }
    }

    private static void buscarProducto(Scanner scanner) {
        System.out.print("Buscar por (1: SKU, 2: Nombre): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine();

        if (eleccion == 1) {
            System.out.print("Ingrese el SKU: ");
            String sku = scanner.nextLine();
            Producto producto = bst.search(sku);
            if (producto != null) {
                System.out.println("Producto encontrado: " + producto);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else if (eleccion == 2) {
            System.out.print("Ingrese el Nombre: ");
            String nombre = scanner.nextLine();
            Producto producto = bst.searchPorNombre(nombre);
            if (producto != null) {
                System.out.println("Producto encontrado: " + producto);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("Elección inválida.");
        }
    }

    private static void editarProducto(Scanner scanner) {
        System.out.print("Ingrese el SKU del producto a editar: ");
        String sku = scanner.nextLine();
        Producto producto = bst.search(sku);

        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
            System.out.print("Ingrese nuevo Nombre (dejar vacío para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                producto.setNombre(nuevoNombre);
            }

            System.out.print("Ingrese nueva Descripción (dejar vacío para no cambiar): ");
            String nuevaDescripcion = scanner.nextLine();
            if (!nuevaDescripcion.isEmpty()) {
                producto.setDescripcion(nuevaDescripcion);
            }

            System.out.print("Ingrese nuevas Cantidades por talla (dejar vacío para no cambiar): ");
            String nuevasCantidades = scanner.nextLine();
            if (!nuevasCantidades.isEmpty()) {
                producto.setCantidadesPorTalla(nuevasCantidades);
            }

            System.out.println("Producto actualizado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

