/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WORejectManageBC.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.basic;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see InvoiceCancelEventResponse 참조
 * @since J2EE 1.4
 */
public interface WORejectManageBC  {


	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 */
	public EsdTrs0024Event multiWorkOrderManage(Event e) throws EventException;

	/**
	 * 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param rowset
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EsdTrs0024Event selectWorkOrderManage(DBRowSet rowset,Event e) throws EventException;
	
	/**
	 * WORejcetManage Send FAX
	 * 
	 * @param e
	 * @param userId
	 * @throws EventException
	 */
	public void faxEdiSend(Event e,String userId) throws EventException;
	
	/**
	 * WORejcetManage Send E-MAIL
	 * @param Event e
	 * @exception EventException
	 */		
	public void emailSend(Event e) throws EventException;	
}