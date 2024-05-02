/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderCCManageBC.java
*@FileTitle : Transportation Report & Code
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-07 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-WorkOrderManage Business Logic Command Interface<br>
 * - ESD-WorkOrderManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0072EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderCCManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCFaxList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCEmailList(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_072 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderCCManageList(Event e) throws EventException;

}