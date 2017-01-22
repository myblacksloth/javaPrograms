package com_antomau_ListeConcatenate.LinkedList;

import com_antomau_ListeConcatenate.Studente.Studente;

import java.util.NoSuchElementException;

import com_antomau_ListeConcatenate.ListIterator.ListIterator;


public class ListaConcatenata {
	
	
	
	//viene dichiarato quello che sarà un nodo della lista - esso contiene un oggetto di tipo studente e un collegamento al nodo successivo
	class Node //la classe nodo viene dichiarata come classe interna alla classe "ListaConcatenata"
	{
		//variaibli contenute in ogni nodo della lista
		Studente student;
		public Node link; //collegamento al nodo successivo
	} //end of Node class


	//variabili
	public Node headList; //nodo testa della lista


	/**
	 * Metodo costruttore della classe: esso inizializza il nodo in testa alla lista
	 */
	public ListaConcatenata()
	{
		headList = null; //il nodo in testa alla lista viene inizializzato a null perché all'inizio dell'esecuzione del programma la lista è vuota
	}
	
	
	/**
	 * Questo metodo restituisce il nodo in testa alla lista
	 * @return Lo studente che si trova in testa alla lista, altrimenti null se la lista è vuota
	 */
	public Studente getFirst()
	{
		if (!(headList == null)) //if (headlist!=null) //se il primo nodo della lista non e' nullo
		{
			return headList.student; //il metodo restituisce l'oggetto studente contenuto nel primo nodo della lista
		} //end of if
		//throw NoSucheElementException(); //errore generato dal fatto che l'elemento non esiste e quindi non e' stato trovato
		return null; //il metodo restituisce null se il nodo in testa alla lista risulta essere nullo
	} //end of firstToString method
	

	/**
	 * Questo metodo si occupa dell'eliminazione del nodo in testa alla lista
	 * @return L'oggetto contenuto nel nodo appena eliminato, se la lista e' vuota esso restituisce null
	 */
	public Studente removeFirst()
	{
		if (!(headList!=null)) //if (headList==null) //se la lista e' vuota il nodo in testa alla lista e' nullo
			return null; //il metodo restituisce null
		else //altrimenti, se la lista non e' vuota il nodo in testa alla lista non e' nullo
		{
			Studente element = headList.student; //questa variabile salva il dato contenuto nel nodo da eliminare
			headList = headList.link; //il nodo in testa alla lista diviene il nodo successivo a quello attuale
			return element; //il metodo restituisce il valore memorizzato nella variabile element
		} //end of else
	} //end of removeFirst
	
	
	/**
	 * Questo metodo aggiunge un nodo in testa alla lista
	 * @param s Lo studente da aggiungere come oggetto del nodo della lista
	 */
	public void addFirst(Studente s)
	{
		System.out.println("debug current data = " + s.getSurname() + " " + s.getName() + " " + s.getSerial() + " " + s.getExamName() + " " + s.getExamVote()); //debug
		Node newNode = new Node(); //viene creato un nuovo nodo
		
		newNode.student = s; //l'oggetto studente del nuovo nodo diviene s, lo studente passato al metodo corrente
		
		newNode.link = headList; //poiche' il nodo deve essere inserito in testa alla lista il suo successivo sara' l'attuale nodo in testa alla lista
		
		headList = newNode; //e pertanto il nuovo nodo in testa alla lista diviene il nodo appena aggiunto
	} //end of addFirst
	
	
	
	
	public void addLast(Studente s)
	{
		if (headList==null) addFirst(s);
		else {
			Node newNode = new Node();
			newNode.student = s;
			newNode.link = null;
			Node current = headList;
			Node previous = null;
			while (current.link!=null)
			{
				previous = current;
				current = current.link;
			} //end of while
			current.link = newNode;
		} //end of else
	} //end of addLast
	
	
	
	
	
	
	
	//iteratore per la lista concatenata
	/*
	 * Questo iteratore viene creato appositamente per la lista realizzata in questo programma
	 * pertanto i suoi metodi restituiranno studenti
	 * e coterranno riferimenti alle caratteristiche della lista attuale
	 * e/o dati pertinenti alla lista in questione
	 */
	public class LinkedListIterator implements ListIterator
	{
		//variabili
		Node current; //riferimento al nodo corrente referenziato dall'iteratore
		Node previous; //riferimento al nodo precedente a quello referenziato dall'iteratore
		//
		/**
		 * Questo è il costruttore della classe
		 */
		public LinkedListIterator()
		{
			current = null; //essendo un passaggio eseguito all'inizio dell'esecuzione del codice la lista e' vuota e pertanto il riferimento al nodo attuale e' null
			previous = null; //per il medesimo motivo della linea precedente si inizializza questa variabile a null
		} //end of builder
		//
		/**
		 * Questo metodo sposta l'iteratore nella posizione successiva della lista
		 */
		@Override
		public Studente next()
		{
			previous = current; //il riferimento al nodo precedente assume il valore del nodo attuale
			if (!hasNext()) throw new NoSuchElementException(); //se non esiste un elemento successivo a quello corrente viene restituito un errore inerente ad un elemento inesistente
			//
			//l'obbiettivo e' scorrere la lista mediante un iteratore
			if (!(current!=null)) //if (current == null)
				current = headList; //se current e' uguale a null vuol dire che non referenzia nulla e quindi andra' a referenziare il nodo in testa alla lista
			else current = current.link; // altrimenti il riferimento al nodo attuale diviene il nodo successivo a quello attuale
			/*
		 	 * il metodo deve restituire quello che è divenuto l'elemento attuale
			 */
			return current.student;
		} //end of next
		//
		/**
		 * Questo metodo verifica che esista un nodo successivo a quello attuale
		 * @return Vero se esiste un nodo successivo a quello attualmente referenziato, falso se questo non esiste.
		 */
		@Override
		public boolean hasNext()
		{
			if (!(current!=null)) //if (current==null) //se il nodo corrente è nullo
				return headList!=null; //restituisce il risultato dell'espressione (headList!=null): è vero se headList esiste, è falso se headList non esiste
			else return current.link!=null; //se il nodo corente non è nullo - restituisce il riultato dell'espressione (current.link!=null): è vero se il nodo successivo a quello attuale esiste, è falso se il nodo successivo a quello attuale non esiste
		} //end of hasNext
		//
		/**
		 * Questo metodo aggiunge un elemento alla lista.
		 * @param s Lo studente da aggiungere alla lista.
		 */
		@Override
		public void add(Studente s)
		{
			if (!(current!=null)) { //if (current==null) //se il nodo current e' null vuol dire che la lista e' vuota
				addFirst(s); //lo studente (oggetto) da aggiungere viene aggiuntom in testa alla lista chiamando il metodo addFirst
				current = headList; //il riferimento al nodo corrente diviene il nodo in testa alla lista
			} else {
				Node newNode = new Node(); //viene creato un nuovo nodo
				newNode.student = s; //l'oggetto (studente) del nodo divene s
				newNode.link = current.link; //il nodo successivo a quello da aggiungere sara' il nodo successivo a quello attualmente referenziato
				current = newNode; //il nodo attualmente referenziato diviene il nodo appena aggiunto
			} //end of else
			previous = current; //il riferimento al nodo precedente diviene il riferimento al nodo corrente per bloccare alcune operazioni in seguito descritte
		} //end of add
		//
		/**
		 * Questo metodo rimuove un nodo della lista
		 */
		@Override
		public void remove()
		{
			/*
			 * Come noi sappiamo da una lista non si puo' eliminare un nodo senza prima averlo referenziato
			 * oppure immediatamente dopo averne inserito uno
			 * oppure immediatamente dopo averne eliminato uno
			 * pertanto per fare si che cio' ia realizzabile in maniera corretta
			 * alla fine di ogni metodo che non puo' precedere l'eliminazione il riferimento al nodo precedente viene modificato al fine di referenziare il nodo attuale
			 * cosi', giunti a questo punto del programma, viene verificato il valore del riferimento al nodo precedente
			 * e se questo risulta essere uguale al nodo attuale viene lanciata un eccezione
			 */
			if (previous == current) throw new IllegalStateException();
			else if (current == headList) removeFirst(); //se il nodo corrente fa riferimento al nodo in testa alla lista viene chiamato il metodo per l'eliminazione del nodo in testa alla lista
			else previous.link = current.link; //altrimenti, se il nodo si trova in un altra posizione, il riferimento al nodo successivo del nodo precedente diviene il riferimento al nodo successivo al nodo attuale
			/*
			 * per impedire l'eliminazione di un nodo immediatamente dopo che ne sia gia' stato eliminato uno
			 * viene imposto che previous e current siano uguali
			 * in questo caso, essendo appena stato eliminato il nodo corrente, il nodo corrente referenziera' il nodo precedente
			 */
			current = previous;
		} //end of remove
		//
		/**
		 * Questo metoo modifica l'oggetto contenuto nel nodo attualmente refereniato.
		 * @param s Lo studente da impostare come oggetto del nodo attuale
		 */
		@Override
		public void set (Studente s)
		{
			if (current==null) throw new NoSuchElementException(); //se current e' uguale a null viene lanciata un eccezione in merito ad un oggetto inesistente e viene interrotta l'esecuzione del metodo
			current.student = s; //se current e' diverso da null il suo oggetto (student) viene modificato con quello passato al metodo
		} //end of set
		//
	} //end of LinkedListIterator class
	
	
	/**
	 * Questo metodo restituisce un iteratore per la lista.
	 * @return Un iteratore per la lista.
	 */
	public ListIterator listIterator()
	{
		return new LinkedListIterator();
	}


	
	
	
	
	
	
	
} //end of class
