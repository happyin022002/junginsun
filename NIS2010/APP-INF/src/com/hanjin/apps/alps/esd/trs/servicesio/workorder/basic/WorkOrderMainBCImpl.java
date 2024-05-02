/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderMainBCImpl.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderMainList;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0005Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0005EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.WorkOrderMainDBDAO;

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
 * @see ESD_TRS_005EventResponse,WorkOrderMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderMainBCImpl   extends BasicCommandSupport implements WorkOrderMainBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient WorkOrderMainDBDAO dbDao=null;

	/**
	 * WorkOrderMainBCImpl 객체 생성<br>
	 * WorkOrderMainDBDAO를 생성한다.<br>
	 */
	public WorkOrderMainBCImpl(){
		dbDao = new WorkOrderMainDBDAO();
	}

	/**
	 * WorkOrderMain화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0005Event
	 * @return EventResponse ExpPap0005EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderMainList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0005Event event=(ExpPap0005Event)e;
        ExpPap0005EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchWorkOrderMainList(event);
            eventResponse = new ExpPap0005EventResponse((WorkOrderMainList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}
	
	/**
	 * count 가져오기.
	 * @param e ExpPap0005Event
	 * @return EventResponse ExpPap0005EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderMainKnt(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0005Event event=(ExpPap0005Event)e;
        ExpPap0005EventResponse eventResponse = new ExpPap0005EventResponse();
        
        try {
        	
            int mainCnt[] = dbDao.searchWorkOrderMainKnt(event);	
            eventResponse.setNewWorkOrderCount(mainCnt[0]); 
            eventResponse.setPendingInvoiceCount(mainCnt[1]);
            eventResponse.setAckCount(mainCnt[2]);
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;		
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * WorkOrderMain업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}