/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DeliveryMonitorBC.java
*@FileTitle : Delivery Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EsdTrs3004EventResponse 참조
 * @since J2EE 1.4
 */
public interface DeliveryMonitorBC  {
	/**
	 * 조회 이벤트 처리<br>
	 * Delivery Monitor Summary 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDelivery(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Delivery Monitor Detail 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDeliveryDetail(Event e) throws EventException;

}