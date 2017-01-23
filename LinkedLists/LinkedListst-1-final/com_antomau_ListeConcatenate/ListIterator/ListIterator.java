package com_antomau_ListeConcatenate.ListIterator;
import com_antomau_ListeConcatenate.Studente.Studente;
/**
 * Questa interfaccia costituisce un interfaccia per l'iteratore della lista.
 * @author Antonio Maulucci http://www.antomau.com
 */
public interface ListIterator {
	Studente next();
	boolean hasNext();
	void add(Studente element);
	void remove();
	void set (Studente element);
	void reset();
} //end of interface