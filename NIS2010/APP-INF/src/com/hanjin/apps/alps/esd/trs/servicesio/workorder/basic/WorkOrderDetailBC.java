/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailBC.java
*@FileTitle : WO Detail 
*Open Issues :
*Change history :
* 2007-08-13 Jung-Jae Kim : TRS 요청에 의해 bkg_no, bkg_no_split 추가.
*@LastModifyDate : 2007-08-13
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * EXP_PAP Business Logic Command Interface<br>
 * - EXP_PAP에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author doomi
 * @see ExpPap002EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderDetailBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EXP_PAP_002Event
	 * @return EventResponse EXP_PAP_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderDetailList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * TRS 요청에 의한 파라미터(bkg_no, bkg_no_split) 추가.
	 * @param e Event
	 * @return
	 * @throws EventException
	 */
	public int modifyWorkOrderDetail(Event e) throws EventException;		

	
	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response ESD_TRS_002EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailExcelPrint(Event e) throws EventException;
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response ESD_TRS_007EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailExcelUpload(Event e) throws EventException;
		
	
}