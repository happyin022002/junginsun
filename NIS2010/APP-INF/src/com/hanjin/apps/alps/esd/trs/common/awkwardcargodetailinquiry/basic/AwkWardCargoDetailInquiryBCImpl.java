/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkWardCargoDetailInquiryBCImpl.java
*@FileTitle : BKG CGO SPE Detail Popup - AK
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.basic;

import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.event.EsdTrs0936Event;
import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.integration.AwkWardCargoDetailInquiryDBDAO;
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
 * @see AwkWardCargoDetailInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AwkWardCargoDetailInquiryBCImpl   extends BasicCommandSupport implements AwkWardCargoDetailInquiryBC {

	// Database Access Object
	private transient AwkWardCargoDetailInquiryDBDAO dbDao=null;

	/**
	 * AwkWardCargoDetailInquiryBCImpl 객체 생성<br>
	 * AwkWardCargoDetailInquiryDBDAO를 생성한다.<br>
	 */
	public AwkWardCargoDetailInquiryBCImpl(){
		dbDao = new AwkWardCargoDetailInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * AwkWardCargoDetailInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0936Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAwkWardCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0936Event event=(EsdTrs0936Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchAwkWardCargoDetailInquiry(event);
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
	 * AwkWardCargoDetailInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}