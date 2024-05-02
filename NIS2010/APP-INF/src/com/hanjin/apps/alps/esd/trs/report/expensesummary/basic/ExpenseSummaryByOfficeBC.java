/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpenseSummaryByOfficeBC.java
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-08
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2009-01-08 ah young Han
* 1.0 최초 생성
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-Transportation S/O Business Logic Command Interface<br>
 * - ENIS-Transportation S/O에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author ah young Han
 * @see EsdTrs0104EventResponse 참조
 * @since J2EE 1.4
 */
public interface ExpenseSummaryByOfficeBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_105Event
	 * @return EventResponse ESD_TRS_105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseSummaryByOffice(Event e) throws EventException;
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchOfficeCount(Event e) throws EventException;
	
}  