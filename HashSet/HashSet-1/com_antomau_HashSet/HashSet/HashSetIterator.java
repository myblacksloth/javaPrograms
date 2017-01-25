package com_antomau_HashSet.HashSet;

import com_antomau_HashSet.Book.Book;

/**
 * Iterator interface.
 * @author Antonio Maulucci http://www.antomau.com
 */
public interface HashSetIterator {
	
	boolean hasNext();
	
	Book next();
	
	void remove();
	
}
