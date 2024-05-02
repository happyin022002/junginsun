/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2206Event.java
*@FileTitle : M.G. Set Estimate Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.12 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_2206HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2206Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSEstimateExpenseINVO mGSEstimateExpenseINVO = null;
	private MGSEstimateExpenseMGTVO mGSEstimateExpenseMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSEstimateExpenseINVO[] mGSEstimateExpenseINVOs = null;
	private MGSEstimateExpenseMGTVO[] mGSEstimateExpenseMGTVOs = null;

	public EesCgm2206Event(){}

	public MGSEstimateExpenseINVO getMGSEstimateExpenseINVO() {
		return mGSEstimateExpenseINVO;
	}

	public void setMGSEstimateExpenseINVO(MGSEstimateExpenseINVO estimateExpenseINVO) {
		mGSEstimateExpenseINVO = estimateExpenseINVO;
	}

	public MGSEstimateExpenseMGTVO getMGSEstimateExpenseMGTVO() {
		return mGSEstimateExpenseMGTVO;
	}

	public void setMGSEstimateExpenseMGTVO(
			MGSEstimateExpenseMGTVO estimateExpenseMGTVO) {
		mGSEstimateExpenseMGTVO = estimateExpenseMGTVO;
	}

	public MGSEstimateExpenseINVO[] getMGSEstimateExpenseINVOs() {
		MGSEstimateExpenseINVO[] rtnVOs = null;
		if (this.mGSEstimateExpenseINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSEstimateExpenseINVOs, mGSEstimateExpenseINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSEstimateExpenseINVOs(MGSEstimateExpenseINVO[] estimateExpenseINVOs){
		if(estimateExpenseINVOs != null){
			MGSEstimateExpenseINVO[] tmpVOs = java.util.Arrays.copyOf(estimateExpenseINVOs, estimateExpenseINVOs.length);
			this.mGSEstimateExpenseINVOs = tmpVOs;
		}
	}

	public MGSEstimateExpenseMGTVO[] getMGSEstimateExpenseMGTVOs() {
		MGSEstimateExpenseMGTVO[] rtnVOs = null;
		if (this.mGSEstimateExpenseMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSEstimateExpenseMGTVOs, mGSEstimateExpenseMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSEstimateExpenseMGTVOs(MGSEstimateExpenseMGTVO[] estimateExpenseMGTVOs){
		if(estimateExpenseMGTVOs != null){
			MGSEstimateExpenseMGTVO[] tmpVOs = java.util.Arrays.copyOf(estimateExpenseMGTVOs, estimateExpenseMGTVOs.length);
			this.mGSEstimateExpenseMGTVOs = tmpVOs;
		}
	}
	
	

}