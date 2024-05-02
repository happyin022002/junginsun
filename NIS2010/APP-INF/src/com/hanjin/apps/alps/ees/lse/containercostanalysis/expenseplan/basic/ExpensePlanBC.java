/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanBC.java
*@FileTitle : Lease Expense-CNTR/CHSS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.24 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.SearchParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containercostanalysis Business Logic Command Interface<br>
 * - ALPS-Containercostanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0033EventResponse 참조
 * @since J2EE 1.6
 */

public interface ExpensePlanBC {
	/**
	 * CNTR/CHSS에 대한 년간 사업계획 목록을 조회합니다.<br>
	 * 
	 * @param  String plnYr
	 * @param  String verSeq
	 * @param  String cmdType
	 * @return List<ExpensePlanVO>
	 * @exception EventException
	 */
	public List<ExpensePlanVO> searchLeaseExpensePlanListBasic(String plnYr, String verSeq, String cmdType) throws EventException;
		
	/**
	 * 년간/월간 장비임차 형태별 임차료 실적자료를 일괄 저장합니다.<br>
	 * 
	 * @param ExpensePlanVO[] expensePlanVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageLeaseExpensePlanListBasic(ExpensePlanVO[] expensePlanVOs, SignOnUserAccount userAccount) throws EventException;
	
	/**
	 * 년간/월별 장비임차 형태별 임차료 실적목록을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<ExpensePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<ExpensePlanPerformanceVO> searchExpensePlanPerformanceListBasic(SearchParamVO searchParamVO) throws EventException;
}