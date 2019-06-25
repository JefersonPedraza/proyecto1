package trm;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Mailer {
 

    public static void sendBienvenido(String valor, String vigencia) {
        final String user = "jefersonSti203030@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "1016091477js";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
       
//2nd paso)compose message
        try {
        	BodyPart texto = new MimeBodyPart();
            
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\webDriver\\Trm.png")));
            adjunto.setFileName("C:\\webDriver\\Trm.png");
            MimeMultipart multiParte = new MimeMultipart();
            MimeMessage message = new MimeMessage(session);
            
            texto.setContent( "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
                    " \r\n" + 
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
                    " \r\n" + 
                    " <head>\r\n" + 
                    " \r\n" + 
                    " <meta charset=\"UTF-8\"/>\r\n" + 
                    " \r\n" + 
                    " \r\n" + 
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n" + 
                    " \r\n" + 
                    "<style>\r\n" + 
                    "table, td, th {  \r\n" + 
                    "  border: 1px solid #ddd;\r\n" + 
                    "  text-align: left;\r\n" + 
                    "}\r\n" + 
                    "\r\n" + 
                    "table {\r\n" + 
                    "  border-collapse: collapse;\r\n" + 
                    "  width: 100%;\r\n" + 
                    "}\r\n" + 
                    "\r\n" + 
                    "th, td {\r\n" + 
                    "  padding: 15px;\r\n" + 
                    "}\r\n" + 
                    "</style>\r\n" + 
                    "\r\n" + 
                    "</head>\r\n" + 
                    " \r\n" + 
                    "<body style=\"margin: 0; padding: 0; \">\r\n" + 
                    " \r\n" + 
                    "<table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"padding: 10px 100px 0px 100px; \" >\r\n" + 
                    "	<tr >\r\n" + 
                    "   		<td style=\"padding: 25px 0 0 0; background-color:#1F618D ; border: 1px solid black;\">\r\n" + 
                    "<center > <p style=\"color:#F7F9F9;\">BIENVENIDO A TU BANCO FAVORITO </p> </center>\r\n" + 
                    "   		</td>\r\n" + 
                    "	</tr>\r\n" + 
                    "	<tr style=\"1px solid black;\">\r\n" + 
                    "		<td style=\"padding: 10px 0 0 0; border: 1px solid black;\">\r\n" + 
                    " 			<img src=\"https://i2.wp.com/www.gestionandoportunidades.com/wp-content/uploads/2017/03/Eres-Tecn%C3%B3logo-en-Educaci%C3%B3n-Normalista-Superior-Licenciado-o-Profesional.-Banco-de-la-Excelencia-MINEDUCACI%C3%93N.jpg?fit=1170%2C421\r\n" + 
                    "			\" alt=\"Smiley face\" height=\"190\" width=\"100%\"/>	\r\n" + 
                    "		</td>	\r\n" + 
                    "	</tr>\r\n" + 
                    "	<tr>	\r\n" + 
                    "		<td style=\"padding: 25px 0 0 0;\">\r\n" + 
                    "			<center><img src='http://fs5.directupload.net/images/160530/khs5cmdc.jpg' title='Tu banco Favorito xD'/></center>\r\n" + 
                    "		</td>	\r\n" + 
                    "	</tr>\r\n" + 
                    "	<tr>\r\n" + 
                    "		<td style=\"padding: 10px 0 0 0;  \">\r\n" + 
                    "			<center> NUEVA ACTUALIZACI&#211;N </center>\r\n" + 
                    "   		</td>\r\n" + 
                    "	</tr>\r\n" + 
                    "	<tr style=\"padding: 10px 0 0 0;\" >\r\n" + 
                    "		<center><table border=\"1\" style=\"border-collapse: collapse;\r\n" + 
                    "  width: 50%;\">\r\n" + 
                    "                     <caption style=\"padding: 30px 0 0 0;\">Historico TRM</caption>\r\n" + 
                    "                    <tbody > \r\n" + 
                    "                       <tr>\r\n" + 
                    "                         <th>Valor TRM</th>\r\n" + 
                    "                     <td>"+valor+"</td> \r\n" + 
                    "                    </tr> \r\n" + 
                    "                   <tr>\r\n" + 
                    "                       <th>Vigencia</th>\r\n" + 
                    "                          <td>"+vigencia+"</td>\r\n" + 
                    "                      </tr> \r\n" + 
                    "                      </tbody>\r\n" + 
                    "                   </table></center>\r\n" + 
                    "	</tr>\r\n" + 
                    "</table>\r\n" + 
                    " </body>\r\n" + 
                    "</html>", "text/html");
                   
            
            
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            
        	
          
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("Arleypedraza1427@gmail.com"));
            message.setSubject("Bienvenido Banco-Pedagogico");
            message.setContent(multiParte);
 
            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

   
}

