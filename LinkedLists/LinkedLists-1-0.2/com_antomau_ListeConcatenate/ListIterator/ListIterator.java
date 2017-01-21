package com_antomau_ListeConcatenate.ListIterator;
import com_antomau_ListeConcatenate.Studente.Studente;
public interface ListIterator {
	Studente next();
	boolean hasNext();
	void add(Studente element);
	void remove();
	void set (Studente element);
} //end of interface
