package tr.com.cbc.credit.register.rest;

import tr.com.cbc.credit.register.domain.Credit;
import tr.com.cbc.credit.register.rest.*;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Validation {

	public void bankadiKontrol(String bankaadi) throws ValidationException {

		if (bankaadi == null || bankaadi.isEmpty()) {
			throw new ValidationException("bank name cannot be empty!!!");
		}

		if (!bankaadi.equals("Akbank") && !bankaadi.equals("Halkbank") && !bankaadi.equals("Ziraat")
				&& !bankaadi.equals("Garanti") && !bankaadi.equals("Finansbank")) {
			throw new ValidationException("bank name not defined!!!");

		}

	}

	public void krediTuruKontrol(String kredituru) {

		if (kredituru == null || kredituru.isEmpty()) {
			throw new ValidationException("Credit Type cannot be empty!!!");
		}

		if (!kredituru.equals("Konut Kredisi") && !kredituru.equals("Tasit Kredisi")
				&& !kredituru.equals("İhtiyac Kredisi")) {
			throw new ValidationException("Credit Type not defined!!!");

		}

	}

	public void tcknKontrol(String tckn) throws ValidationException {

		if (tckn == null || tckn.isEmpty()) {
			throw new ValidationException("tckn cannot be empty!!!");
		}

		if (tckn.length() != 11)
			throw new ValidationException("invalid  TCKN");

		char[] chars = tckn.toCharArray();
		int[] a = new int[11];

		for (int i = 0; i < 11; i++) {
			a[i] = chars[i] - '0';
		}

		if (a[0] == 0)
			throw new ValidationException("invalid  TCKN!!!");
		if (a[10] % 2 == 1)
			throw new ValidationException("invalid  TCKN!!!");

		if (((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9])
			throw new ValidationException("invalid  TCKN!!!");

		if ((a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 != a[10])
			throw new ValidationException("invalid  TCKN!!!");

	}

	public void tutarKontrol(String tutar) throws ValidationException {

		if (tutar == null || tutar.isEmpty()) {
			throw new ValidationException("Amount cannot be empty!!!");
		}

		if (!isAllNumeric(tutar)) {
			throw new ValidationException("Amount must be numeric!!!");

		}

		int tutarValid = Integer.valueOf(tutar);
		if (1000 > tutarValid || tutarValid > 999999) {

			throw new ValidationException("invalid amount!!!");

		}

	}

	public void krediNumarasiKontrol(String kredinumarasi) throws ValidationException, NumberFormatException {

		if (kredinumarasi == null || kredinumarasi.isEmpty()) {
			throw new ValidationException("Credit Number cannot be empty!!!");
		}

	}

	public boolean isAllNumeric(String code) throws ValidationException {

		try {

			for (int i = 0; i < code.length(); i++)
				if (!Character.isDigit(code.charAt(i))) {
					throw new ValidationException("Amount must be numeric!!!");
				}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		return true;

	}

//
//	public void baglan(String kredinumarasi, String bankaadi,String kredituru,String tckn,String tutar,String kredikayit) throws ValidationException {
//		try {
//			
//			  Date date = new Date();  
//			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//			    String strDate= formatter.format(date);  
//			
//			
//			String connectionString = "jdbc:mysql://localhost:3306/crediregister?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection baglanti = (Connection) DriverManager.getConnection(connectionString, "root", "1234");
//			try {
//
//			//	String SQL = "SELECT bankaadi,kredinumarasi FROM crediregister.kredi where DATE_FORMAT(datetime, '%d %m %Y')= DATE_FORMAT(NOW(), '%d %m %Y')";
//				
//				String SQL = "INSERT INTO crediregister.kredi(bankaadi,kredinumarasi,kredituru,tckn,tutar,kredikayit)" + "VALUES('?','?','?','?','?','?')";
////				PreparedStatement preparedStatement = baglanti.prepareStatement(SQL);
//				PreparedStatement preparedStmt = baglanti.prepareStatement(SQL);
//	            preparedStmt.setString(1, bankaadi);
//	            preparedStmt.setString(2, kredinumarasi);
//	            preparedStmt.setString(3, kredituru);
//	            preparedStmt.setString(4, tckn);
//	            preparedStmt.setString(5, tutar);
//	         
//	        
//	            preparedStmt.setString(6,kredikayit);
//	         
//	            int row = preparedStmt.executeUpdate();
//				
////				Statement durum = (Statement) baglanti.createStatement();
////				ResultSet rs = (ResultSet) durum.executeQuery(SQL);
////				while (rs.next()) {
////					System.out.println(rs.getString("bankaadi") + " " + rs.getString("kredinumarasi"));
////					if (kredinumarasi.equals(rs.getString("kredinumarasi")) == true
////							&& bankaadi.equals(rs.getString("bankaadi")) == true) {
////						throw new ValidationException(
////								"No more than 1 registration can be made on the same day with the same bank name and credit number.");
////					}
////				}
//
//			}
//
//			catch (SQLException e) {
//	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//	        }
//			catch (Exception e) {
//	            e.printStackTrace();
//	        }
//		} catch (ValidationException e) {
//			throw e;
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			throw new ValidationException("A general error occurred.");
//		}
//
//	}

}
