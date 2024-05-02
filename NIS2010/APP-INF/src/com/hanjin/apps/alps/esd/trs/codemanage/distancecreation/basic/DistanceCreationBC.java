/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DistanceCreationBC.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.31 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.17 최 선  1.1 [] SAVE시, Distance 중복 등록  현상 처리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0080EventResponse 참조
 * @since J2EE 1.4
 */
public interface DistanceCreationBC  {

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreation(Event e) throws EventException;	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreationhis(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceCreation(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceHistory(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceCreationDuple(Event e) throws EventException;	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceDelete(Event e) throws EventException;	
	
}