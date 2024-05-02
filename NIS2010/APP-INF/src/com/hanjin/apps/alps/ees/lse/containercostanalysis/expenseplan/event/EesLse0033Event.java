/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0033Event.java
*@FileTitle : Lease Expense-CNTR/CHSS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.24 장준우
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanVO;


/**
 * EES_LSE_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExpensePlanVO expensePlanVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ExpensePlanVO[] expensePlanVOs = null;

	public EesLse0033Event(){}
	
	public void setExpensePlanVO(ExpensePlanVO expensePlanVO){
		this. expensePlanVO = expensePlanVO;
	}

	public void setExpensePlanVOs(ExpensePlanVO[] expensePlanVOs){
		this. expensePlanVOs = expensePlanVOs;
	}

	public ExpensePlanVO getExpensePlanVO(){
		return expensePlanVO;
	}

	public ExpensePlanVO[] getExpensePlanVOs(){
		return expensePlanVOs;
	}
	
	/* Plan Year */
	private String plnYr;
	
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	public String getPlnYr() {
		return plnYr;
	}
	
	/* Version Sequence */
	private String verSeq;
	
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	public String getVerSeq() {
		return verSeq;
	}
	
	/* Command Type */
	private String cmdType;
	
	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}
	
	public String getCmdType() {
		return cmdType;
	}
}