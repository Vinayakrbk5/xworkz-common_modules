package main.java.com.xworkz.modules.service;

import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;

public interface EmailService {

	public void sendRegisterSuccessEmail(TempleRegistrationDTO dto);
}
