/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpperformancEvaluationBC.java
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0039EventResponse 참조
 * @since J2EE 1.4
 */
public interface SpperformancEvaluationBC  {


	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_039 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0039Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSpperformancEvaluation(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SpperformancEvaluation화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0039Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpperformancEvaluationList(Event e) throws EventException;

}