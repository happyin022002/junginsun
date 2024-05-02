/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultistopLocationInquiryBCImpl.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.basic;

import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.integration.MultistopLocationInquiryDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
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
 * @see ESD_TRS_933EventResponse,MultistopLocationInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MultistopLocationInquiryBCImpl   extends BasicCommandSupport implements MultistopLocationInquiryBC {

	// Database Access Object
	private transient MultistopLocationInquiryDBDAO dbDao=null;

	/**
	 * MultistopLocationInquiryBCImpl 객체 생성<br>
	 * MultistopLocationInquiryDBDAO를 생성한다.<br>
	 */
	public MultistopLocationInquiryBCImpl(){
		dbDao = new MultistopLocationInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultistopLocationInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_933EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMultistopLocationInquiryList(Event e) throws EventException {
		EsdTrs0933Event event=(EsdTrs0933Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchMultistopLocationInquiryList(event);
//			return new EsdTrs0933EventResponse(rowSet,"SUCCESS");
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
	 * MultistopLocationInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}