package tr.com.cbc.credit.register.rest;

import tr.com.cbc.credit.register.domain.Credit;
import tr.com.cbc.credit.register.service.CreditService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@RestController

@EnableAutoConfiguration

public class CreditController {

	@Autowired
	private Validation validation;

	@Autowired
	private CreditService service;

	@PostMapping("/save")
	public ResponseEntity<?> getKredi(@RequestBody Credit creditregister)
			throws IOException, NumberFormatException, SQLIntegrityConstraintViolationException

	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(date);

		try {

			validation.krediNumarasiKontrol(creditregister.getKrediNumarasi());
			validation.bankadiKontrol(creditregister.getBankaadi());
			validation.krediTuruKontrol(creditregister.getKrediTuru());
			validation.tcknKontrol((creditregister.getTckn()));
			validation.tutarKontrol(creditregister.getTutar());

			creditregister.setKayittarihi(strDate);
			service.saveOrUpdate(creditregister);

			return ResponseEntity.ok("successful");
		} catch (ValidationException e) {
			return ResponseEntity.badRequest().body("unsuccessful  : \n" + "error message : " + e.getMessage());
		}

	}

}

//try {
//validation.baglan(creditregister.getKrediNumarasi(), creditregister.getBankaadi(),
//		creditregister.getKrediTuru(), creditregister.getTckn(), creditregister.getTutar(), strDate);
//
//} catch (ValidationException e) {
//e.printStackTrace();
//return ResponseEntity.badRequest().body(e.getMessage());
//
//}
