/**
 * @author  Samael Pereira Sim�es
 **/

package br.com.neomind.datatype;

public enum HOperator implements DataType{
	EQUALS(0), DIFFERENT(1), LIKE(2), CONTAINS(3), INITS_WITH(4), TERMINATES_WITH(5), MINOR(6), MAJOR(7), BETWEEN(8);
	
	public int index;
	HOperator(int index){
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}

}
