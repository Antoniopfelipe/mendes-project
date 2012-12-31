package br.com.mendes.dataloader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.mendes.model.Cliente;

public class DataLoader {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
					
			SessionFactory sf = null;
			Session session = null;
			Transaction tx = null;

			try {
			
				sf = ctx.getBean(SessionFactory.class);
				session = sf.openSession();
				tx = session.beginTransaction();				

				loadData(session);
				
				tx.commit();
				
			} catch (Exception e) {
			
				e.printStackTrace();
				tx.rollback();
				
			} finally {

				if (session != null) {
					session.close();
				}
				
				if (sf != null) {
					sf.close();
				}
			}
			
			
	}

	private static void loadData(Session session) {
		carregarCliente(session);
		
	}
	
	private static void save(Session session, Object... entities) {
		for (Object entity  : entities) {
			session.save(entity);
			session.flush();
		}
	}
	
	/**
	 * Método responsável por carregar o dado dos clientes
	 * @param session
	 */
	private static void carregarCliente(Session session){
		Cliente cli = new Cliente();
		cli.setNome("Diógenes");
		cli.setSobrenome("Feijó");
		cli.setCelular("1997297043");
		cli.setTelefone("1939713673");
		cli.setCnpj("123129038120");
		cli.setCpf("40504624865");
		cli.setRg("497555384");
		
		save(session, cli);
	}
	
}
