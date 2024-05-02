/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UsaLastCityManagementBCImpl.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-09-22 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.integration.USALastCityManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
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
 * @see ESD_TRS_076EventResponse,USALastCityManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USALastCityManageBCImpl   extends BasicCommandSupport implements USALastCityManageBC {

	// Database Access Object
	private transient USALastCityManageDBDAO dbDao=null;

	/**
	 * USALastCityManageBCImpl 객체 생성<br>
	 * USALastCityManageDBDAO를 생성한다.<br>
	 */
	public USALastCityManageBCImpl(){
		dbDao = new USALastCityManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USALastCityManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_076EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSALastCityManageList(Event e) throws EventException {
		
		EsdTrs0076Event event=(EsdTrs0076Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchUSALastCityManageList(event.getTrsDmstLstCtyVO());
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_076 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_076Event
	 * @return EventResponse ESD_TRS_076EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0076Event event=(EsdTrs0076Event)e;		
		try {			
			dbDao.multiTRS_DMST_LST_CTY(event.getTrsDmstLstCtyVos(), event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}


	/**
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_077 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_077Event
	 * @return EventResponse ESD_TRS_077EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCodeManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)		
		EsdTrs0076Event event=(EsdTrs0076Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String comboText = "";
		try {
			rowSet=dbDao.searchLocalCodeManage(event);
			while(rowSet.next()){
				comboText = rowSet.getString("LOC_CD");
			}			
			eventResponse.setETCData("CNT_CD", comboText);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());			
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	
	
	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * USALastCityManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}