package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CitizenPlan;
import com.nt.repository.ICitizenPlanRepo;

@Component
public class DataInserter implements ApplicationRunner{
	
	@Autowired
	private ICitizenPlanRepo repo;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CitizenPlan cp1 = new CitizenPlan();
		cp1.setCname("john");
		cp1.setGender("Male");
		cp1.setPhno(708102537l);
		cp1.setPlanName("SNAP");
		cp1.setPlanStatus("Approved");
		cp1.setSsn(98989899l);
		
		CitizenPlan cp2 = new CitizenPlan();
		cp2.setCname("Smith");
		cp2.setGender("Male");
		cp2.setPhno(708102537l);
		cp2.setPlanName("CCAP");
		cp2.setPlanStatus("Approved");
		cp2.setSsn(8856783l);
		
		
		CitizenPlan cp3 = new CitizenPlan();
		cp3.setCname("lucy");
		cp3.setGender("fe-Male");
		cp3.setPhno(708102537l);
		cp3.setPlanName("SNAP");
		cp3.setPlanStatus("Approved");
		cp3.setSsn(98989899l);
		
		CitizenPlan cp4 = new CitizenPlan();
		cp4.setCname("laura");
		cp4.setGender("Fe-Male");
		cp4.setPhno(708102537l);
		cp4.setPlanName("CCAP");
		cp4.setPlanStatus("Denied");
		cp4.setSsn(876862l);
		
		List<CitizenPlan> list = Arrays.asList(cp1, cp2, cp3, cp4);
		
		repo.saveAll(list);
		
		
	}

}
