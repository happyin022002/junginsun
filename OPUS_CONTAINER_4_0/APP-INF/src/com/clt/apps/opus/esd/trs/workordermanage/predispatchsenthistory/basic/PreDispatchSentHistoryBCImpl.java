/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PreDispatchSentHistoryBCImpl.java
 *@FileTitle : Pre-Dispatch Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-19
 *@LastModifier : kim_sang_geun
 *@LastVersion : 1.0
 * 2006-12-19 kim_sang_geun
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.event.EsdTrs0021Event;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration.PreDispatchSentHistoryDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration.RDFaxSendEAIDAO;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration.RDMailSendEAIDAO;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.vo.SearchPreDispatchSentHistoryVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kim_sang_geun
 * @see ESD_TRS_021EventResponse,PreDispatchSentHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PreDispatchSentHistoryBCImpl extends BasicCommandSupport implements PreDispatchSentHistoryBC {

	// Database Access Object
	private transient PreDispatchSentHistoryDBDAO dbDao = null;
	private transient RDMailSendEAIDAO mailDao = null;
	private transient RDFaxSendEAIDAO faxDao = null;

	/**
	 * PreDispatchSentHistoryBCImpl 객체 생성<br>
	 * PreDispatchSentHistoryDBDAO를 생성한다.<br>
	 */
	public PreDispatchSentHistoryBCImpl() {
		dbDao = new PreDispatchSentHistoryDBDAO();
		mailDao = new RDMailSendEAIDAO();
		faxDao = new RDFaxSendEAIDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_021Event
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreDispatchSentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0021Event event = (EsdTrs0021Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchPreDispatchSentHistory(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_021Event
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
	public EventResponse search01PreDispatchSentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0021Event event = (EsdTrs0021Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.search01PreDispatchSentHistory(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param faxresponse_array
	 * @param emlresponse_array
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
	public EventResponse updatePreDispatchSentHistory(ArrayList faxresponse_array, ArrayList emlresponse_array) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.updatePRE_DISPATCHSENTHISTORY(faxresponse_array, emlresponse_array);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 <br>
	 * 
	 * @param bkgPkupNtcNoVOS
	 * @exception EventException
	 */
	public void searchPickupNoticeBasicManage(ArrayList<BkgPkupNtcPkupNoVO> bkgPkupNtcNoVOS) throws EventException {

		int voSize = bkgPkupNtcNoVOS.size();
		List<TrsTrspSvcOrdVO> soList = null;
		List<SearchPreDispatchSentHistoryVO> preDisList = null;

		ArrayList faxresponse_array = null;
		ArrayList emlresponse_array = null;

		try {

			if (voSize > 0) {
				soList = dbDao.searchServiceOrderManage(bkgPkupNtcNoVOS);
			}

			if (soList != null && soList.size() > 0) {
				preDisList = dbDao.batchPreDispatchSentHistory(soList);
				if (preDisList.size() > 0) {
					// faxresponse_array = faxDao.faxEdiSend(preDisList);
					// emlresponse_array = mailDao.emailEdiSend(preDisList);
					if (faxresponse_array != null && emlresponse_array != null) {
						updatePreDispatchSentHistory(faxresponse_array, emlresponse_array);
					}
				}
			}

		} catch (Exception ee) {

			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PreDispatchSentHistory업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}