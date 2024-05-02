/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpperformancEvaluationBCImpl.java
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.basic;

import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.event.EsdTrs0039Event;
import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration.SpperformancEvaluationDBDAO;
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
 * @see SpperformancEvaluationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SpperformancEvaluationBCImpl   extends BasicCommandSupport implements SpperformancEvaluationBC {

	// Database Access Object
	private transient SpperformancEvaluationDBDAO dbDao=null;

	/**
	 * SpperformancEvaluationBCImpl 객체 생성<br>
	 * SpperformancEvaluationDBDAO를 생성한다.<br>
	 */
	public SpperformancEvaluationBCImpl(){
		dbDao = new SpperformancEvaluationDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SpperformancEvaluation화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0039Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpperformancEvaluationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0039Event event=(EsdTrs0039Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchSpperformancEvaluationList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_039 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0039Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiSpperformancEvaluation(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0039Event event=(EsdTrs0039Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiTrsTrspVndrPerfEv(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SpperformancEvaluation업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}