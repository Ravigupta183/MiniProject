package com.nt.service;

import java.util.List;

import com.nt.entity.CitizenPlan;
import com.nt.entity.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface IReportService {

	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<CitizenPlan> getCitizenPlans(SearchRequest request);
	public void exportExcel(HttpServletResponse response)throws Exception;
	public void exportPdf(HttpServletResponse response)throws Exception;
}
