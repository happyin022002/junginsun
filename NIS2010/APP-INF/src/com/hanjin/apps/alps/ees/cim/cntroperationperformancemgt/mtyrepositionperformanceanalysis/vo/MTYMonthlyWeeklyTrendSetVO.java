package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;


import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;


public class MTYMonthlyWeeklyTrendSetVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	
	/* Column Info */
	private List<MTYCNTRPERFSummaryVO> mtycntrperfsummaryvo = null;

	/* Column Info */
	private List<MTYMonthlyWeeklyPeriodVO> mtymonthlyweeklyperiodvo = null;

	



	/**
	 * 
	 * @return
	 */
	public List<MTYCNTRPERFSummaryVO> getMtycntrperfsummaryvo() {
		return mtycntrperfsummaryvo;
	}

	/**
	 * 
	 * @param mtycntrperfsummaryvo
	 */
	public void setMtycntrperfsummaryvo(
			List<MTYCNTRPERFSummaryVO> mtycntrperfsummaryvo) {
		this.mtycntrperfsummaryvo = mtycntrperfsummaryvo;
	}

	/**
	 * 
	 * @return
	 */
	public List<MTYMonthlyWeeklyPeriodVO> getMtymonthlyweeklyperiodvo() {
		return mtymonthlyweeklyperiodvo;
	}

	/**
	 * 
	 * @param mtymonthlyweeklyperiodvo
	 */
	public void setMtymonthlyweeklyperiodvo(
			List<MTYMonthlyWeeklyPeriodVO> mtymonthlyweeklyperiodvo) {
		this.mtymonthlyweeklyperiodvo = mtymonthlyweeklyperiodvo;
	}


	public MTYMonthlyWeeklyTrendSetVO() {}


	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}