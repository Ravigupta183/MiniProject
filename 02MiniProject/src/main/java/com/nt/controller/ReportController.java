package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.CitizenPlan;
import com.nt.entity.SearchRequest;
import com.nt.service.IReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportController {

	@Autowired
	private IReportService service;
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> planNames = service.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getPlanStatuses(){
		List<String> planStatuses = service.getPlanStatus();
		return new ResponseEntity<>(planStatuses, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<CitizenPlan>> search(@RequestBody SearchRequest request){
		List<CitizenPlan> citizenPlan = service.getCitizenPlans(request);
		return new ResponseEntity<>(citizenPlan, HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response)throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String key = "Content-Disposition";
		String value = "attachment ;fileName = citizens.xlsx";
		
		response.setHeader(key, value);
		
		service.exportExcel(response);
		
		response.flushBuffer();
		
	}
	
	@GetMapping("/pdf")
	public void exportpdf(HttpServletResponse response)throws Exception {
		
		response.setContentType("application/pdf");
		
		String key = "Content-Disposition";
		String value = "attachmnet;fileName = plans.pdf";
		
		response.setHeader(key, value);
		
		service.exportPdf(response);
		
		response.flushBuffer();
		
	}
	
	
	
}
