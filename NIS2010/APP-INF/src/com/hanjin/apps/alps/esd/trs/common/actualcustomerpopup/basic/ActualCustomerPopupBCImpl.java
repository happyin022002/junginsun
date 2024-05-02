/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCustomerPopupBCImpl.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-10-30 poong_yeon
* 1.0 최초 생성
* -----------------------------------------------------------------
* History
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 : Actual Customer 자동 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.basic;

import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.integration.ActualCustomerPopupDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

 

/**
 * ESD-OtherSOManage Business Logic Basic Command implementation<br>
 * - ESD-OtherSOManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see OtherSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ActualCustomerPopupBCImpl   extends BasicCommandSupport implements ActualCustomerPopupBC {

	// Database Access Object
	private transient ActualCustomerPopupDBDAO dbDao=null;

	/**
	 * ActualCustomerPopupBCImpl 객체 생성<br>
	 * ActualCustomerPopupDBDAO를 생성한다.<br>
	 */
	public ActualCustomerPopupBCImpl(){
		dbDao = new ActualCustomerPopupDBDAO();
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer Popup List 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0914Event event=(EsdTrs0914Event)e;
		try {
			
			rowSet=dbDao.searchActualCustomerList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer Popup 화면에 대한 Detail 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomer(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0914Event event=(EsdTrs0914Event)e;
		try {
			rowSet=dbDao.searchActualCustomer(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actual customer 의 코드입력시 자동 조회<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerName(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0914Event event=(EsdTrs0914Event)e;

		try {
			rowSet=dbDao.searchActualCustomerName(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			return eventResponse;		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
	}	
	
	/**
	 * ActualCustomerPopup 업무 시나리오 마감작업<br>
	 * ActualCustomerPopup업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}