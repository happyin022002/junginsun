/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SupplementSOManageBCImpl.java
 *@FileTitle : Service Order 생성-Supplement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-30
 *@LastModifier : juhyun
 *@LastVersion : 1.0
 * 2006-10-30 juhyun
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.basic;

import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration.SupplementSOManageDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import java.util.List;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author juhyun
 * @see GeneralResponse, SupplementSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SupplementSOManageBCImpl extends BasicCommandSupport implements SupplementSOManageBC {
	private transient SupplementSOManageDBDAO dbDao = null;

	/**
	 * SupplementSOManageBCImpl 객체 생성<br>
	 * SupplementSOManageDBDAO를 생성한다.<br>
	 */
	public SupplementSOManageBCImpl() {
		dbDao = new SupplementSOManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0016Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSupplementSOTargetList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		try {
			return dbDao.searchSupplementSOTargetList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0016Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSupplementSOCorrectionList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchSupplementSOCorrectionList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_077 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0077Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public List<String> addSupplementSOList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		try {
			return dbDao.addSupplementSOList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param arrayList
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSOCreatedList(List<String> arrayList) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchSOCreatedList(arrayList));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_077 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e EesTrs0077vent
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSupplementSOCreatedList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		try {
			dbDao.removeSupplementSOCreatedList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return null;
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SupplementSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}