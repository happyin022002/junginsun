/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultipleInquiryBCImpl.java
*@FileTitle : Multiple Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.basic;
import com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.integration.MultipleInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_906EventResponse,MultipleInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MultipleInquiryBCImpl   extends BasicCommandSupport implements MultipleInquiryBC {

	// Database Access Object
	private transient MultipleInquiryDBDAO dbDao=null;

	/**
	 * MultipleInquiryBCImpl 객체 생성<br>
	 * MultipleInquiryDBDAO를 생성한다.<br>
	 */
	public MultipleInquiryBCImpl(){
		dbDao = new MultipleInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultipleInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_906EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMultipleInquiryList() throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			
			rowSet=dbDao.searchMultipleInquiryList();
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
	 * MultipleInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}