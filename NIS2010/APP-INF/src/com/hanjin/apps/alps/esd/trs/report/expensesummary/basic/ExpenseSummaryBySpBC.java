/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpenseSummaryBC.java
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-07
*@LastModifier : jh choi
*@LastVersion : 1.0
* 2009-01-07 jh choi
* 1.0 최초 생성
* @history
* N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-ExpenseSummary Business Logic Command Interface<br>
 * - ENIS-ExpenseSummary에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong yeon cho
 * @see EsdTrs0105EventResponse 참조
 * @since J2EE 1.4
 */
public interface ExpenseSummaryBySpBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_105Event
	 * @return EventResponse ESD_TRS_105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseSummary(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchExpenseDetail(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchParentSP(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchDetailCount(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSummaryCount(Event e) throws EventException;
}