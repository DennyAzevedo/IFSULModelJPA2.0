/*
 * Copywrite: Denny Azevedo & Marilene Esquiavoni.
 * Todos os direitos reservados.
 * MD Virtual Academy.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Denny Azevedo <dennyazevedo@gmail.com>
 */
public class TesteExcluirPais 
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
		EntityManager em = emf.createEntityManager();
		Pais p = em.find(Pais.class, 3);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}
