/*
 * Copywrite: Denny Azevedo & Marilene Esquiavoni.
 * Todos os direitos reservados.
 * MD Virtual Academy.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;

/**
 *
 * @author Denny Azevedo <dennyazevedo@gmail.com>
 */
public class TestePersistirPais 
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		EntityManager em = EntityManagerUtil.getEntityManager();
		Pais p = new Pais();
		//p.setId(1);
		p.setNome("Chile");
		p.setIso("CHI");
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
}
