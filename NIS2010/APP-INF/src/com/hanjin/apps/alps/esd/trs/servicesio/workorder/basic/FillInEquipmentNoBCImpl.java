/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoBCImpl.java
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


import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoList;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0003EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.FillInEquipmentNoDBDAO;

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
 * @see ESD_TRS_019EventResponse,FillInEquipmentNoBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class FillInEquipmentNoBCImpl   extends BasicCommandSupport implements FillInEquipmentNoBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient FillInEquipmentNoDBDAO dbDao=null;

	/**
	 * FillInEquipmentNoBCImpl 객체 생성<br>
	 * FillInEquipmentNoDBDAO를 생성한다.<br>
	 */
	public FillInEquipmentNoBCImpl(){
		dbDao = new FillInEquipmentNoDBDAO();
	}


	/**
	 * FillInEquipmentNo화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0003Event
	 * @return EventResponse ExpPap0003EventResponse
	 * @exception EventException
	 */
	public EventResponse searchFillInEquipmentNoList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0003Event event=(ExpPap0003Event)e;
        ExpPap0003EventResponse eventResponse = null;


		try {
			Object[] result = dbDao.searchFillInEquipmentNoList(event);
            eventResponse = new ExpPap0003EventResponse((FillInEquipmentNoList[])result[0],"SUCCESS");   
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
           
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}
	
	
	
	/**
	 * searchFillInEquipmentNoExcelPrint 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0003Event
	 * @return EventResponse ExpPap0003EventResponse
	 * @exception EventException
	 */
	public EventResponse searchFillInEquipmentNoExcelPrint(Event e) throws EventException {
		ExpPap0003Event event=(ExpPap0003Event)e;
        ExpPap0003EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchFillInEquipmentNoExcelPrint(event);
            eventResponse = new ExpPap0003EventResponse((FillInEquipmentNoList[])result[0],"SUCCESS");   
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
           
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}



	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * FillInEquipmentNo업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}