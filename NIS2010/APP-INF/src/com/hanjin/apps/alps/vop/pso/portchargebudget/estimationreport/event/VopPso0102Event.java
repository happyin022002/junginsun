/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0102Event.java
*@FileTitle : Estimation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : S.K.Y
*@LastVersion : 1.0
* 2013.05.21 S.K.Y
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.BudgetSmryByVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * VOP_PSO-0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_PSO-0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author S.K.Y
 * @see VOP_PSO-0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
		
	/** BudgetSmryByVvdVO*/

	private BudgetSmryByVvdVO budgetSmryByVvdVO = null;


	/**
	 * @return the budgetSmryByVvdVO
	 */
	public BudgetSmryByVvdVO getBudgetSmryByVvdVO() {
		return budgetSmryByVvdVO;
	}


	/**
	 * @param budgetSmryByVvdVO the budgetSmryByVvdVO to set
	 */
	public void setBudgetSmryByVvdVO(BudgetSmryByVvdVO budgetSmryByVvdVO) {
		
		this.budgetSmryByVvdVO = budgetSmryByVvdVO;
	}


	
	
	

	
	


}