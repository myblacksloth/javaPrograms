package com_antomau_BinarySearchTree_OrdineAlfabetico.Tree;

/**
 * Questa classe implementa un albero di ricerca binario
 * @author Antonio Maulucci http://www.antomau.com
 */
public class BinarySearchTree {
	
	//definizione di un nodo dell'albero
	/**
	 * Un nodo dell'albero memorizzera' una stringa ed i riferimenti al figlio sinistro ed al figlio destro del nodo
	 * @author Antonio Maulucci
	 */
	class Node {
		//il nodo deve contenere una stringa che consiste in una parola
		String word;
		//ed inoltre deve contenere i riferimenti al figlio sinistro ed al figlio destro
		private Node left;
		private Node right;
		
		
		/**
		 * Questo metodo si occupa di aggiungere un nuovo nodo all'albro
		 * @param newNode Il nodo da aggiungere all'albero.
		 */
		public void addNode(Node newNode)
		{
			int comp = newNode.word.compareTo(word); //questa variabile salva il risultato della comparazione tra word del nodo da aggiungere e word del nodo corrente
			
			if (comp == 0) return; //se il risultato della comparazione e' uguale a 0 il metodo interrompe la propria esecuzione perche' il dato gia' esiste
			else if (comp < 0) { //se il risultato della comparazione e' minore di 0 vuol dire che il nodo dovra' divenire il figlio sinistro del nodo corrente
				
				if (left == null) left = newNode; //se il figlio sinistro non esiste il nodo da aggiungere diviene il figlio sinistro di quello attaule
				else left.addNode(newNode); //se il figlio sinistro esiste sara' quest'ultimo a decidere in che modo inserire il nuovo nodo in quanto il corrente metodo di tale nodo sara' invocato per l'aggiunta del nuovo nodo
				
			} else { // if (comp > 0) //se il risultato della comparazione e' maggiore di 0 vuol dire che il nodo da aggiungere diviene il figlio destro del nodo attuale
				
				if (right == null) right = newNode; //se il figlio destro non esiste il nodo diviene il figlio destro del nodo corrente
				else right.addNode(newNode); //se il figlio destro esiste sara' esso ad occuparsi dell'aggiunta del nuovo nodo
				
			} //end of else
			
		} //end of addNode
		
		
		
		
		
		
		//debug = this method is to test
		/**
		 * Questo metodo restituisce una stringa del contenuto dell'albero binario.
		 * @return Una stringa contenente il contenuto dell'albero binario
		 */
		public String toString()
		{
			String result="";
			
			if (left != null) result += left.toString();
			
			if (right != null) result += right.toString();
			
			return result;
		} //end of toString
		
		
	} //end of Node
	
	
	//viene creata la variabile nodo radice
	private Node root;
	
	
	
	
	
	//builder
	/**
	 * Metodo costruttore della classe: inizializza il nodo dell'albero a null poiche' all'avvio del programma l'albero e' vuoto
	 */
	public BinarySearchTree()
	{
		root = null;
	} //end of builder
	
	
	
	
	/**
	 * Questo metodo si occupa di aggiungere un nuovo nodo all'albero.
	 * @param s La stringa da utilizzare come dato del nuovo nodo.
	 */
	public void add(String s)
	{
		Node newNode = new Node(); //viene creato un nuovo oggetto di tipo Node
		
		newNode.word = s; //l'oggetto contenuto nel nuovo nodo sara' la stringa s
		
		//il nodo che stiamo creando sara' sicuramente un nodo foglia pertanto non ha figli
		newNode.left = null;
		newNode.right = null;
		
		//OPERAZIONI PER L'AGGIUNTA DEL NUOVO NODO
		
		if (root == null) root = newNode; //se il nodo radice e' null vuol dire che l'albero e' vuoto e pertanto il nodo da aggiungere diverra' il nodo radice
		else root.addNode(newNode); //se il nodo radice esiste sara' questo ad occuparsi dell'inserimento del nuovo nodo
	} //end of add
	
	
	
	
	
	
	
	
	/**
	 * Questo metodo cerca una parola (Stringa) all'intero dell'albero binario.
	 * @param f La parola da cercare all'interno dell'albero.
	 * @return Vero se la parola viene trovata, altrimnti falso.
	 */
	public boolean find(String f)
	{
		
		Node current = root; //variabile di tipo nodo per scorrere l'albero
		
		while (current != null) //fintanto che l'albero non e' vuoto
		{
			int comp = current.word.compareTo(f); //questa variabile salva il risultato della comparazione tra il dato contenuto nel nodo corrente e quello da cercare
			
			if (comp == 0) return true; //se il risultato della comparazione e' 0 il metodo restituisce vero ed interrompe la propria esecuzione
			else if (comp < 0) current = current.left; //se il risultato della comparazione e' <0 si itera verso il sottoalbero sinistro
			else if (comp > 0) current = current.right; //se il risultato della comparazione e' >0 si itera verso il sottoalbero destro
			
		} //end of while
		
		return false; //se non viene interrotta l'esezuione del metodo prima di questo punto vuol dire che il dato cercato non e'stato trovato
	} //end of find
	
	
	
	
	
	
	/**
	 * Questo metodo rimuove il nodo contenente una stringa dall'albero.
	 * @param r La stringa contenuta nel nodo da rimuovere.
	 */
	public void remove(String r)
	{
		
		Node toBeRemoved = root; //per cercare ed eventualmente eliminare il nodo si parte dalla radice dell'albero
		
		Node parent = null; //il nodo genitore del nodo da eliminare
		
		Boolean found = false; //risultato della ricerca dell'elemento
		
		while (!found && toBeRemoved != null)
		{
			
			int comp = toBeRemoved.word.compareTo(r); //questa variabile salva il risultato della comparazione tra l'elemtno del nodo corrente e quello da eliminare
			
			//questo e' un algoritmo di ricerca per trovare il nodo da eliminare
			
			if (comp == 0) found = true; //se gli elementi corrispondono la varibile found diventa vera interrompendo l'esecuzione del ciclo while
			else if (comp < 0) {
				parent = toBeRemoved;
				toBeRemoved = toBeRemoved.left;
			}
			else if (comp > 0) {
				parent = toBeRemoved;
				toBeRemoved = toBeRemoved.right;
			} //end of else
			
		} //end of while
		
		
		
		//a questo punto la ricerca del nodo da eliminare e' terminata
		
		if (!found) return; //se il dato non e'stato trovato viene interrotta l'esecuzione del metodo altrimenti questa procede regolarmente
		
		
		/*
		 * SE IL NODO DA ELIMINARE NON HA FIGLI
		 */
		if (toBeRemoved.left==null && toBeRemoved.right==null) {
			//what son are you?... comparazione tra genitore e figlio... se figlio<genitore = figlio sinistro ... se figlio>genitore = figlio destro
			if (toBeRemoved.word.compareTo(parent.word) < 0) parent.left = null;
			else parent.right = null;
		} //end of if
		
		
		
		/*
		 * SE IL NODO DA ELIMINARE HA UN SOLO FIGLIO
		 */
		if (toBeRemoved.left==null || toBeRemoved.right==null) {
			
			
			if (toBeRemoved.left==null) {
				parent.right = toBeRemoved.right;
			}
			else if (toBeRemoved.right ==null) {
				
			}
			else if (parent == null) { //toBeRemoved is root
				
			} //end of else
			
		} //end of if
		
	} //end of remove
	
	
	
	
	
	
	
	
	
	
} //end of class





















