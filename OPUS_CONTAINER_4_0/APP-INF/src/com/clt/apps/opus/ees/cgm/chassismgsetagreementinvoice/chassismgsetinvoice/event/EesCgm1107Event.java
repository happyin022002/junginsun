/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1107Event.java
*@FileTitle : Chassis Estimate Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.08 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1107HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEstimateExpenseINVO cHSEstimateExpenseINVO = null;
	private CHSEstimateExpenseMGTVO cHSEstimateExpenseMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEstimateExpenseINVO[] cHSEstimateExpenseINVOs = null;
	private CHSEstimateExpenseMGTVO[] cHSEstimateExpenseMGTVOs = null;
	
	public EesCgm1107Event(){}

	public CHSEstimateExpenseINVO getCHSEstimateExpenseINVO() {
		return cHSEstimateExpenseINVO;
	}

	public void setCHSEstimateExpenseINVO(CHSEstimateExpenseINVO estimateExpenseINVO) {
		cHSEstimateExpenseINVO = estimateExpenseINVO;
	}

	public CHSEstimateExpenseMGTVO getCHSEstimateExpenseMGTVO() {
		return cHSEstimateExpenseMGTVO;
	}

	public void setCHSEstimateExpenseMGTVO(
			CHSEstimateExpenseMGTVO estimateExpenseMGTVO) {
		cHSEstimateExpenseMGTVO = estimateExpenseMGTVO;
	}

	public CHSEstimateExpenseINVO[] getCHSEstimateExpenseINVOs() {
		CHSEstimateExpenseINVO[] rtnVOs = null;
		if (this.cHSEstimateExpenseINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSEstimateExpenseINVOs, cHSEstimateExpenseINVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSEstimateExpenseINVOs(CHSEstimateExpenseINVO[] estimateExpenseINVOs){
		if(estimateExpenseINVOs != null){
			CHSEstimateExpenseINVO[] tmpVOs = java.util.Arrays.copyOf(estimateExpenseINVOs, estimateExpenseINVOs.length);
			this.cHSEstimateExpenseINVOs = tmpVOs;
		}
	}

	public CHSEstimateExpenseMGTVO[] getCHSEstimateExpenseMGTVOs() {
		CHSEstimateExpenseMGTVO[] rtnVOs = null;
		if (this.cHSEstimateExpenseMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSEstimateExpenseMGTVOs, cHSEstimateExpenseMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSEstimateExpenseMGTVOs(CHSEstimateExpenseMGTVO[] estimateExpenseMGTVOs){
		if(estimateExpenseMGTVOs != null){
			CHSEstimateExpenseMGTVO[] tmpVOs = java.util.Arrays.copyOf(estimateExpenseMGTVOs, estimateExpenseMGTVOs.length);
			this.cHSEstimateExpenseMGTVOs = tmpVOs;
		}
	}
	
	
	
}