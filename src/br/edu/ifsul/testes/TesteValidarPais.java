/*
 * Copywrite: Denny Azevedo & Marilene Esquiavoni.
 * Todos os direitos reservados.
 * MD Virtual Academy.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Denny Azevedo <dennyazevedo@gmail.com>
 */
public class TesteValidarPais 
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
		EntityManager em = emf.createEntityManager();
		Pais p = new Pais();
		//p.setId(1);
		p.setNome("Uruguai");
		p.setIso("URU");
		em.getTransaction().begin();
		Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Pais>> erros = validador.validate(p);
		if (erros.size() > 0)
		{
			for (ConstraintViolation<Pais> erro : erros)
			{
				System.out.println("Erro: " + erro.getMessage());
			}
		}
		else
		{
			em.persist(p);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
}
