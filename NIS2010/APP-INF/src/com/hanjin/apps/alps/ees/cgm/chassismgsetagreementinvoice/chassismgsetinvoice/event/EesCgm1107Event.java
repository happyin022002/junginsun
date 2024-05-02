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
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;


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
		return cHSEstimateExpenseINVOs;
	}

	public void setCHSEstimateExpenseINVOs(
			CHSEstimateExpenseINVO[] estimateExpenseINVOs) {
		cHSEstimateExpenseINVOs = estimateExpenseINVOs;
	}

	public CHSEstimateExpenseMGTVO[] getCHSEstimateExpenseMGTVOs() {
		return cHSEstimateExpenseMGTVOs;
	}

	public void setCHSEstimateExpenseMGTVOs(
			CHSEstimateExpenseMGTVO[] estimateExpenseMGTVOs) {
		cHSEstimateExpenseMGTVOs = estimateExpenseMGTVOs;
	}
	
	
	
}