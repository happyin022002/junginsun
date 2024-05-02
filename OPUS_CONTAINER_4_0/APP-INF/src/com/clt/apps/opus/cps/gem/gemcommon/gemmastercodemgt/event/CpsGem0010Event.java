/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0010Event.java
 *@FileTitle : Expense Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInqVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0010HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Popup 처리 판단 */
	public String popup = null;

	public String getPopup() {
		return popup;
	}

	public void setPopup(String popup) {
		this.popup = popup;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ExpenseInquiryVO expenseInquiryVO = null;
	private ExpenseInqVO expenseInqVO = null;

	/** Table Value Object Multi Data 처리 */
	private ExpenseInquiryVO[] expenseInquiryVOs = null;
	private ExpenseInqVO[] expenseInqVOs = null;

	public CpsGem0010Event() {
	}

	public ExpenseInquiryVO getExpenseInquiryVO() {
		return expenseInquiryVO;
	}

	public void setExpenseInquiryVO(ExpenseInquiryVO expenseInquiryVO) {
		this.expenseInquiryVO = expenseInquiryVO;
	}

	public ExpenseInqVO getExpenseInqVO() {
		return expenseInqVO;
	}

	public void setExpenseInqVO(ExpenseInqVO expenseInqVO) {
		this.expenseInqVO = expenseInqVO;
	}

	public ExpenseInquiryVO[] getExpenseInquiryVOs() {
		return expenseInquiryVOs;
	}

	public void setExpenseInquiryVOs(ExpenseInquiryVO[] expenseInquiryVOs) {
		this.expenseInquiryVOs = expenseInquiryVOs;
	}

	public ExpenseInqVO[] getExpenseInqVOs() {
		return expenseInqVOs;
	}

	public void setExpenseInqVOs(ExpenseInqVO[] expenseInqVOs) {
		this.expenseInqVOs = expenseInqVOs;
	}

}