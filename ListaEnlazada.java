
public class ListaEnlazada<T> {

private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        }
}

private Nodo<T> cabeza;
private int nElementos;

public ListaEnlazada() {
        this.cabeza = null;
        this.nElementos = 0;
}

public int size() {
        return nElementos;
}

public void clear() {
        cabeza = null;
        nElementos = 0;
}

public void pushBack(T o) {
        insert(o, nElementos);
}

public void insert(T o, int index) {
        if (index < 0 || index > nElementos) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Nodo<T> nuevoNodo = new Nodo<>(o);
        if (index == 0) {
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        } else {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < index - 1; i++) {
        actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        }
        nElementos++;
        }

public T get(int index) {
        if (index < 0 || index >= nElementos) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < index; i++) {
        actual = actual.siguiente;
        }

        return actual.dato;
        }

public T remove(int index) {
        if (index < 0 || index >= nElementos) {
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Nodo<T> aEliminar;

        if (index == 0) {
        aEliminar = cabeza;
        cabeza = cabeza.siguiente;
        } else {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < index - 1; i++) {
        actual = actual.siguiente;
        }
        aEliminar = actual.siguiente;
        actual.siguiente = aEliminar.siguiente;
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        nElementos--;
        return aEliminar.dato;
        }

public void invertir() {
        Nodo<T> previo = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;

        while (actual != null) {
        siguiente = actual.siguiente;
        actual.siguiente = previo;
        previo = actual;
        actual = siguiente;
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
        cabeza = previo;
}

public void concatenar(ListaEnlazada<T> otraLista) {
        if (otraLista == null) return;

        Nodo<T> actualOtra = otraLista.cabeza;
        while (actualOtra != null) {
        this.pushBack(actualOtra.dato);
        actualOtra = actualOtra.siguiente;
        }
}

public void print() {
        Nodo<T> actual = cabeza;
        System.out.print("[ ");
        while (actual != null) {
        System.out.print(actual.dato + " ");
        actual = actual.siguiente;
        }
        System.out.println("]");
}

public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.insert(10, 0);
        lista.insert(30, 1);
        lista.insert(20, 1);
        lista.insert(5, 0);

        System.out.print("Lista actual: ");
        lista.print();
        System.out.println("Tamaño de la lista (size): " + lista.size());
        System.out.println("Elemento en índice 0: " + lista.get(0));
        System.out.println("Elemento en índice 2: " + lista.get(2));

        int eliminado = lista.remove(1);
        System.out.println("Elemento removido del índice 1: " + eliminado);
        System.out.print("Lista tras remoción: ");
        lista.print();
        System.out.println("Nuevo tamaño: " + lista.size());

        lista.invertir();
        System.out.print("Lista invertida: ");
        lista.print();

        ListaEnlazada<Integer> otraLista = new ListaEnlazada<>();
        otraLista.pushBack(100);
        otraLista.pushBack(200);
        otraLista.pushBack(300);

        lista.concatenar(otraLista);
        System.out.print("Lista concatenada: ");
        lista.print();
        System.out.println("Nuevo tamaño: " + lista.size());

        lista.clear();
        System.out.print("Lista tras clear(): ");
        lista.print();
        System.out.println("Tamaño final: " + lista.size());
        }
}