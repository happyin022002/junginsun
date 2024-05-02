/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiGae0006Event.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;


import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInfoMgtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM-0007] Foreign Exchange Rate Maintenance
 * CPS_GEM_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0009HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ExpenseInfoMgtVO expenseInfoMgtVO;
	
	private String acctCd = "";
	
	private String ofcCd = "";

	private String sprtGenExpnCd = "";
	


	public String getAcctCd() {
		return acctCd;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	
	
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	
	public String getSprtGenExpnCd() {
		return sprtGenExpnCd;
	}

	public void setSprtGenExpnCd(String sprtGenExpnCd) {
		this.sprtGenExpnCd = sprtGenExpnCd;
	}
	
	public ExpenseInfoMgtVO getExpenseInfoMgtVO() {
		return expenseInfoMgtVO;
	}

	public void setExpenseInfoMgtVO(ExpenseInfoMgtVO expenseInfoMgtVO) {
		this.expenseInfoMgtVO = expenseInfoMgtVO;
	}

	public CpsGem0007Event() {
	}





}