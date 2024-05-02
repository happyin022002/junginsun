package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo;

import java.util.ArrayList;
import java.util.List;

public class FinancialAffairsMtxGrpVO {
	
	private CarrierVO carrierVO = null;
	private List<FinancialAffairsMtxVO> revenueFinancialAffairsMtxVOs = null;
	private List<FinancialAffairsMtxVO> expenseFinancialAffairsMtxVOs = null;

	public FinancialAffairsMtxGrpVO(){
		carrierVO = new CarrierVO();
		revenueFinancialAffairsMtxVOs = new ArrayList<FinancialAffairsMtxVO>();
		expenseFinancialAffairsMtxVOs = new ArrayList<FinancialAffairsMtxVO>();
	}
	
	public void setCarrierVO(CarrierVO pCarrierVO){
		carrierVO = pCarrierVO;
	}
	
	public CarrierVO getCarrierVO(){
		return carrierVO;
	}

	/**
	 * @return the revenueFinancialAffairsMtxVOs
	 */
	public List<FinancialAffairsMtxVO> getRevenueFinancialAffairsMtxVOs() {
		return revenueFinancialAffairsMtxVOs;
	}

	/**
	 * @param revenueFinancialAffairsMtxVOs the revenueFinancialAffairsMtxVOs to set
	 */
	public void setRevenueFinancialAffairsMtxVOs(List<FinancialAffairsMtxVO> revenueFinancialAffairsMtxVOs) {
		this.revenueFinancialAffairsMtxVOs = revenueFinancialAffairsMtxVOs;
	}

	/**
	 * @return the expenseFinancialAffairsMtxVOs
	 */
	public List<FinancialAffairsMtxVO> getExpenseFinancialAffairsMtxVOs() {
		return expenseFinancialAffairsMtxVOs;
	}

	/**
	 * @param expenseFinancialAffairsMtxVOs the expenseFinancialAffairsMtxVOs to set
	 */
	public void setExpenseFinancialAffairsMtxVOs(List<FinancialAffairsMtxVO> expenseFinancialAffairsMtxVOs) {
		this.expenseFinancialAffairsMtxVOs = expenseFinancialAffairsMtxVOs;
	}
	
	
	
}
