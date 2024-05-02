/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA Rail PerformanceBC.java
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-10
*@LastModifier : 김종호
*@LastVersion : 1.6
* 2007-12-19 Jun Ho Kim
* 1.0 최초 생성
* 1.6 2011.06.10 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-USA Rail Performance Business Logic Command Interface<br>
 * - ENIS-USA Rail Performance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jun Ho Kim
 * @see EsdTrs0102EventResponse 참조
 * @since J2EE 1.4
 */
public interface USARailPerformanceBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISInvRailPerformanceByLaneVvd(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISInvRailPerformance(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISSOCRailPerformanceByLaneVvd(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISSORRailPerformanceByLaneVvd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISSOCRailPerformance(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchENISSORRailPerformance(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchNISSOCRailPerformance(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchNISSORRailPerformance(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchALLSORRailPerformanceByLaneVvd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchALLSORRailPerformance(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchALLSOCRailPerformanceByLaneVvd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchALLSOCRailPerformance(Event e) throws EventException;

}