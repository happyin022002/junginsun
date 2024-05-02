/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityBCImpl.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi	
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.basic;

import com.clt.apps.opus.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiry;
import com.clt.apps.opus.esd.trs.servicesio.availability.event.ExpPap0004Event;
import com.clt.apps.opus.esd.trs.servicesio.availability.event.ExpPap0004EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.availability.integration.AvailabilityDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.common.document.AvailabilityList;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_019EventResponse,AvailabilityBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AvailabilityBCImpl   extends BasicCommandSupport implements AvailabilityBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient AvailabilityDBDAO dbDao=null;

	/**
	 * AvailabilityBCImpl 객체 생성<br>
	 * AvailabilityDBDAO를 생성한다.<br>
	 */
	public AvailabilityBCImpl(){
		dbDao = new AvailabilityDBDAO();
	}


	/**
	 * Availability화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap004Event
	 * @return EventResponse ExpPap004EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchAvailabilityPeriodList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0004Event event=(ExpPap0004Event)e;
        ExpPap0004EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchAvailabilityPeriodList(event);
            eventResponse = new ExpPap0004EventResponse((AvailabilityList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		}
		
		
		return eventResponse;
		
	}
	

	/**
	 * Availability화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap004Event
	 * @return response ExpPap004EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchAvailabilityNoList(Event e) throws EventException { 
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0004Event event=(ExpPap0004Event)e;
        ExpPap0004EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchAvailabilityNoList(event);
            eventResponse = new ExpPap0004EventResponse((AvailabilityList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}		
	/**
	 * Availability화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EXP_PAP_004Event
	 * @return EventResponse EXP_PAP_004EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchEmptyAvailabilityList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0004Event event=(ExpPap0004Event)e;
        ExpPap0004EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchEmptyAvailabilityList(event);
            eventResponse = new ExpPap0004EventResponse((EmptyAvailabilityInquiry[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
     	} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		}
		
		
		return eventResponse;
		
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * Availability업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}