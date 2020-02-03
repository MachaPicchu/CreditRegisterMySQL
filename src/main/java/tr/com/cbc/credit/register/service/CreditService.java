package tr.com.cbc.credit.register.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.validation.ValidationException;

import tr.com.cbc.credit.register.domain.Credit;

public interface CreditService {
	
	List<Credit> getAllKredi();
	Credit getbyId(Long id);
	void saveOrUpdate(Credit kredi) throws ValidationException, SQLIntegrityConstraintViolationException;
	void deleteKredi(Long id);
	

}
