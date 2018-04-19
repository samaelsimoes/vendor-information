/**
 * @author  Samael Pereira Simões
 **/
package br.com.neomind.daoconnect;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.neomind.configuration.HConnect;

public abstract class ConnectionDAO<T> extends HConnect implements GenericEntityDAO{
	protected EntityManager em;
	
	public ConnectionDAO(){
		em = getEntityManager();
	}
	
	public String getEntityName(){
		return getSuperClass().getSimpleName();
	}
	

	public Class<T> getEmClass(){
		Class<T> classe = getSuperClass();
		return classe;
	}
	
	public Class<T> getSuperClass(){
		ParameterizedType superclass = (ParameterizedType)getClass().getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<T> classe = (Class<T>)superclass.getActualTypeArguments()[0];
		return classe;
	}

}
