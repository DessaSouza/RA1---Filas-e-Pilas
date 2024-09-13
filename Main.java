// Classe para representar um elemento (solicitação ou cliente)
class Elemento {
    String id;
    String descricao;
    String data;

    public Elemento(String id, String descricao, String data) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
    }
}

// Classe para representar um nó da lista encadeada
class Node {
    Elemento elemento;
    Node proximo;

    public Node(Elemento elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}

// Classe para representar a pilha usando lista encadeada
class Pilha {
    private Node topo;

    public Pilha() {
        topo = null;
    }

    public void push(Elemento elemento) {
        Node novoNode = new Node(elemento);
        novoNode.proximo = topo;
        topo = novoNode;
    }

    public Elemento pop() {
        if (topo == null) {
            return null;
        }
        Elemento elemento = topo.elemento;
        topo = topo.proximo;
        return elemento;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}

// Classe para representar a fila usando lista encadeada
class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        frente = null;
        tras = null;
    }

    public void enqueue(Elemento elemento) {
        Node novoNode = new Node(elemento);
        if (tras == null) {
            frente = novoNode;
            tras = novoNode;
        } else {
            tras.proximo = novoNode;
            tras = novoNode;
        }
    }

    public Elemento dequeue() {
        if (frente == null) {
            return null;
        }
        Elemento elemento = frente.elemento;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        return elemento;
    }

    public boolean isEmpty() {
        return frente == null;
    }
}
