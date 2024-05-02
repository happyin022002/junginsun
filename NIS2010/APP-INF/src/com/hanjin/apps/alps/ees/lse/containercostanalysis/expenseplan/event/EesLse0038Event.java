/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0038Event.java
*@FileTitle : Lease Expense Plan and Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.SearchParamVO;


/**
 * EES_LSE_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ExpensePlanPerformanceVO[] expensePlanPerformanceVOs = null;

	public EesLse0038Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setExpensePlanPerformanceVOs(ExpensePlanPerformanceVO[] expensePlanPerformanceVOs){
		this. expensePlanPerformanceVOs = expensePlanPerformanceVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public ExpensePlanPerformanceVO[] getExpensePlanPerformanceVOs(){
		return expensePlanPerformanceVOs;
	}		
}