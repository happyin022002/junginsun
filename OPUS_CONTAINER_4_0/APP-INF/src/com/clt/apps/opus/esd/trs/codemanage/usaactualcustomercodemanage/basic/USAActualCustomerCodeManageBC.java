/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USAActualCustomerCodeManageBC.java
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jun Ho
 * @see EsdTrs0082EventResponse 참조
 * @since J2EE 1.4
 */
public interface USAActualCustomerCodeManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSAActualCustomerCodeManageList(Event e) throws EventException;

	
	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerName(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCheck(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeExcel(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_082 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */

	public EventResponse multiUSAActualCustomerCodeManageList(Event e) throws EventException;

}