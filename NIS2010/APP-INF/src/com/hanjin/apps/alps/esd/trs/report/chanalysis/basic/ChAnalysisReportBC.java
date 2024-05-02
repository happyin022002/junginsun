/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PendingListBC.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimjin
 * @see EsdTrs0001EventResponse 참조
 * @since J2EE 1.6
 */
public interface ChAnalysisReportBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChAnalysis(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_vvd(Event e) throws EventException;	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_ofc(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse weekDate(Event e) throws EventException;		

}