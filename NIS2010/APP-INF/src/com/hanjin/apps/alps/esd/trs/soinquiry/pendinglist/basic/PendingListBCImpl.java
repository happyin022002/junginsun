/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PendingListBCImpl.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-18 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic;

import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event.EsdTrs0001Event;
//import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event.EsdTrs0001EventResponse;
import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration.PendingListDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
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
 * @author juhyun
 * @see ESD_TRS_001EventResponse,PendingListBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PendingListBCImpl   extends BasicCommandSupport implements PendingListBC {

	// Database Access Object
	private transient PendingListDBDAO dbDao=null;

	/**
	 * PendingListBCImpl 객체 생성<br>
	 * PendingListDBDAO를 생성한다.<br>
	 */
	public PendingListBCImpl(){
		dbDao = new PendingListDBDAO();
	}
		

	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchPendingListList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		EsdTrs0001Event event=(EsdTrs0001Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchPendingListList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	

	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search_vvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		EsdTrs0001Event event=(EsdTrs0001Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.search_vvd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(rowSet.getRowCount() > 0){
				eventResponse.setETCData("CNT_CD", "1");
			}else{
				eventResponse.setETCData("CNT_CD", "0");
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	

	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0001Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search_ofc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		EsdTrs0001Event event=(EsdTrs0001Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.search_ofc(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PendingList업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}