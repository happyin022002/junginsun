/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpotBidPerformanceReportBCImpl.java
*@FileTitle : Spot Bid Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 2016.02.03 
* 1.0 최초 생성
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.basic;

import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.event.EsdTrs0092Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidperformancereport.integration.SpotBidPerformanceReportDBDAO;
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
 * @author 
 * @see ESD_TRS_0092EventResponse, SpotBidPerformanceReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public  class SpotBidPerformanceReportBCImpl   extends BasicCommandSupport implements SpotBidPerformanceReportBC {

	// Database Access Object
	private transient SpotBidPerformanceReportDBDAO dbDao=null;
	
	/**
	 * SpotBidPerformanceReportBCImpl 객체 생성<br>
	 * SpotBidPerformanceReportDBDAO를 생성한다.<br>
	 */
	public SpotBidPerformanceReportBCImpl(){
		dbDao = new SpotBidPerformanceReportDBDAO();
	}


	/**
	 * 조회 이벤트 처리<br>
	 * SpotBidPerformanceReport 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0092Event
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_0092EventResponse
	 * @exception EventException
	 */
	public EventResponse srchSpotBidPerfRpt(Event e, String soffice_cd) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0092Event event=(EsdTrs0092Event)e;
		
		try {
			rowSet=dbDao.srchSpotBidPerfRpt(event,soffice_cd);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SpotBidPerformanceReport 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}