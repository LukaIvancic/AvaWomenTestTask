package util;

import com.sun.mail.pop3.POP3SSLStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;

import constants.Const;

public class MailServiceUtil {

	public MailServiceUtil() {

	}

	private Session session = null;
	private Store store = null;
	private String username, password;




	public void setUserCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public void connect() throws Exception {
		Properties pop3Props = new Properties();
		pop3Props.setProperty(Const.SOCKET_FACTORY_CLASS, Const.SSL_FACTORY);
		pop3Props.setProperty(Const.SOCKET_FACTORY_FALLBACK, "false");
		pop3Props.setProperty(Const.MAIL_PORT, Const.PORT);
		pop3Props.setProperty(Const.SOCKET_FACTORY_PORT, Const.PORT);

		URLName url = new URLName(Const.PROTOCOL, Const.HOST, 995, "",
				username, password);

		session = Session.getInstance(pop3Props, null);
		store = new POP3SSLStore(session, url);
		store.connect();

	}


	public void disconnect() {

		try {
			store.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


	public String getLinkFromEmail(String subject, String recipientName) {
		try {
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);


			Message[] messages = inbox.getMessages();
			 for (int i = 0; i < messages.length; i++) {
				Thread.sleep(3000);
				Message message = messages[i];
				ArrayList<String> links = new ArrayList<>();

				if (message.getSubject().contains(subject)
						&& message.getRecipients(Message.RecipientType.TO)[0].toString().equals(recipientName)) {
					String emailContent = message.getContent().toString();


					Pattern linkPattern = Pattern.compile(" <a\\b[^>]*href=\"([^\"]*)[^>]*>(.*?)</a>",
							Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
					Matcher pageMatcher = linkPattern.matcher(emailContent);
					while (pageMatcher.find()) {
						links.add(pageMatcher.group(1));
					}
				}

				for (String temp : links) {
					if (temp.contains("confirm_registration")) {

						return temp;
					}
				}
			}
			return null;
		} catch (MessagingException | InterruptedException e) {

		} catch (IOException e) {

		}
		return null;
	}
}
