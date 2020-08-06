package main.java.com.xworkz.modules.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;

@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendRegisterSuccessEmail(TempleRegistrationDTO dto) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			StringBuffer sb = new StringBuffer("<html><body><h2>");
			sb.append("Services Selected are :</h2><table><tbody><big><tr>");
			sb.append("<td>No Of People : </td><td><b>" + dto.getNoOfPeople() + "</b></td><tr>");
			sb.append("<td>ID Card Type : </td><td><b>" + dto.getIdCardType() + "</b></td><tr>");
			sb.append("<td>Pooja Type : </td><td><b>" + dto.getPoojaType() + "</b></td><tr>");
			sb.append("<td>Prasad Type : </td><td><b>" + dto.getPrasad() + "</b></td><tr>");
			sb.append("<td>Special Entry Type : </td><td><b>" + dto.getSpecialEntry()
					+ "</td></b></tr></tbody></table></big><br>");
			sb.append("<h1>Thank you for Selecting Services</h1>");
			sb.append("<h3> Visit Again </h3></body></html>");
			String str = new String(sb);
			helper.setTo(dto.getEmailId());
			helper.setSubject("Temple Services Information");
			helper.setText(str, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
