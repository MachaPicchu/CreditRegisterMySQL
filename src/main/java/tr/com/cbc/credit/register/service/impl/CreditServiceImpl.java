package tr.com.cbc.credit.register.service.impl;

import tr.com.cbc.credit.register.domain.Credit;
import tr.com.cbc.credit.register.repository.CreditRepository;
import tr.com.cbc.credit.register.service.CreditService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.validation.ValidationException;

@Service
@Transactional

public class CreditServiceImpl implements CreditService {

	@Autowired
	CreditRepository repo;

	@Override
	public List<Credit> getAllKredi() {
		// TODO Auto-generated method stub
		return (List<Credit>)repo.findAll();
	}

	@Override
	public Credit getbyId(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void saveOrUpdate(Credit kredi) throws ValidationException, SQLIntegrityConstraintViolationException {
		try
		{
			repo.save(kredi);
		}
		catch(Exception e)
		{
			throw new ValidationException(
					"No more than 1 registration can be made on the same day with the same bank name and credit number.");
		}
		
	}

	@Override
	public void deleteKredi(Long id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

}
