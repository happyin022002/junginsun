/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCancelManageBCImpl.java
*@FileTitle : Invoice Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event.InvoiceCancelEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.integration.InvoiceCancelManageDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectEventResponse,WORejectManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InvoiceCancelManageBCImpl   extends BasicCommandSupport implements InvoiceCancelManageBC {

	// Database Access Object
	private transient InvoiceCancelManageDBDAO dbDao=null;
	
	/**
	 * WORejectManageBCImpl 객체 생성<br>
	 * WORejectManageDBDAO를 생성한다.<br>
	 */
	public InvoiceCancelManageBCImpl(){
		dbDao = new InvoiceCancelManageDBDAO();
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WORejectEvent에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e WORejectEvent
	 * @return EventResponse WORejectEventResponse
	 * @exception EventException
	 */
	public EventResponse cancelInvoiceList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		boolean successFlag = false;
		InvoiceCancelEvent event=(InvoiceCancelEvent)e;
		try {
			successFlag = dbDao.multiCancelInvoiceList(event);		
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if( successFlag )
				eventResponse.setFlowFlag("true");
			else
				eventResponse.setFlowFlag("false");
			return eventResponse;    
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}