package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String nameClient;
	private String emailClient;
	private Date dateNasc;
	
	public Client() {
	}
	
	public Client(String nameClient, String emailClient, Date dateNasc) {
		this.nameClient = nameClient;
		this.emailClient = emailClient;
		this.dateNasc = dateNasc;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public Date getDateNasc() {
		return dateNasc;
	}

	public void setDateNasc(Date dateNasc) {
		this.dateNasc = dateNasc;
	}
	
	public String toString() {
		return nameClient + " (" + sdf.format(dateNasc) + ") - " + emailClient;
	}
	
}
