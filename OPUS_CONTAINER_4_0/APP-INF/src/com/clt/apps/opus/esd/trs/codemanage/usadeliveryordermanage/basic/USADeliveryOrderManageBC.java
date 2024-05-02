/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USADeliveryOrderManageBC.java
 *@FileTitle : USA Delivery Order Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-20
 *@LastModifier : poong yeon cho
 *@LastVersion : 1.0
 * 2008-10-20 poong yeon cho
 * 1.0 최초 생성
 * -------------------------------------------------------
 * history
 * 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ENIS-USADeliveryOrderManage Business Logic Command Interface<br>
 * - ENIS-USADeliveryOrderManage에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author poong yeon cho
 * @see EsdTrs0083EventResponse 참조
 * @since J2EE 1.4
 */
public interface USADeliveryOrderManageBC {

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_083 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_083Event
	 * @return EventResponse ESD_TRS_083EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSADeliveryOrderManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USADeliveryOrderManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSADeliveryOrderManageList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USADeliveryOrderManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSADeliveryOrderCheck(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * USADeliveryOrderManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSDeliveryOrderConsigneeManage(Event e) throws EventException;
}