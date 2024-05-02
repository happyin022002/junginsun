/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxBCImpl.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi	
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxList;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0001Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0001EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.WorkOrderInboxDBDAO;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_019EventResponse,WorkOrderInboxBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderInboxBCImpl   extends BasicCommandSupport implements WorkOrderInboxBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient WorkOrderInboxDBDAO dbDao=null;

	/**
	 * WorkOrderInboxBCImpl 객체 생성<br>
	 * WorkOrderInboxDBDAO를 생성한다.<br>
	 */
	public WorkOrderInboxBCImpl(){
		dbDao = new WorkOrderInboxDBDAO();
	}


	/**
	 * WorkOrderInbox화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap001Event
	 * @return EventResponse ExpPap001EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchWorkOrderPeriodList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0001Event event=(ExpPap0001Event)e;
        ExpPap0001EventResponse eventResponse = null;

      

		try {
			Object[] result = dbDao.searchWorkOrderPeriodList(event);
            eventResponse = new ExpPap0001EventResponse((WorkOrderInboxList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
          
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		
	    }
	   
	    
		return eventResponse;
		
	}
	

	/**
	 * WorkOrderInbox화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap001Event
	 * @return response ExpPap001EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchWorkOrderNoList(Event e) throws EventException { 
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0001Event event=(ExpPap0001Event)e;
        ExpPap0001EventResponse eventResponse = null;


		try {
			Object[] result = dbDao.searchWorkOrderNoList(event);
            eventResponse = new ExpPap0001EventResponse((WorkOrderInboxList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
		
	}		


	/**
	 * WorkOrderInbox화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap001Event
	 * @return response ExpPap001EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchInboxExcelPrint(Event e) throws EventException { 
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0001Event event=(ExpPap0001Event)e;
        ExpPap0001EventResponse eventResponse = null;


		try {
			Object[] result = dbDao.searchInboxExcelPrint(event);
			Object result2 = dbDao.searchInboxExcelHeader(event);
            eventResponse = new ExpPap0001EventResponse((WorkOrderInboxList[])result[0], (WorkOrderInboxList)result2, "SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
		
	}		


	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * WorkOrderInbox업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}