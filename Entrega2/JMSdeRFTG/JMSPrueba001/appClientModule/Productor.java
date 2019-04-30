import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Productor {
	@Resource(mappedName = "jms/ConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(mappedName = "jms/Queue")
	private static Queue queue;

	public void enviaMensajeCola(String mundo) throws JMSException
	{
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		Message message = null;
		boolean esTransaccional = false;
		try {
			connection = connectionFactory.createConnection();
			//Recordar llamar a start() para permitir el envio de mensajes
			connection.start();
			//Creamos una sesion sin transaccionalidad y con envio de acuse automatico
			session = connection.createSession(esTransaccional, Session.AUTO_ACKNOWLEDGE);
			//Creamos el productor a partir de una cola
			producer = session.createProducer(queue);
			//Creamos un mensaje sencillo de texto
			message = session.createTextMessage(mundo);
			//Mediante le productor, enviamos el mensaje
			producer.send(message);
			System.out.println("Enviado mensaje [" + mundo + "]");
		} finally {
			//Cerramos los recursos
			producer.close();
			session.close();
			connection.close();
		}
	}

	public static void main(String[] args) throws Exception {
		Productor p = new Productor();
		p.enviaMensajeCola("Hola Mundo");
		p.enviaMensajeCola("Adios Mundo");
	}
}
