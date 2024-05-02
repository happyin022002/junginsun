/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementApprovalBCImpl.java
*@FileTitle : Agreement Approval 권한 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2014-05-28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014-05-28 최종혁
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration.AgreementApprovalDBDAO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author agreement
 * @see EsdTrs0237EventResponse 참조
 * @since J2EE 1.6
 */
public class AgreementApprovalBCImpl extends BasicCommandSupport implements AgreementApprovalBC {

	private transient AgreementApprovalDBDAO dbDao=null;

	public AgreementApprovalBCImpl() {
		dbDao = new AgreementApprovalDBDAO();
	}

	/**
	 * Agreement 결재자 리스트 조회<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApprovalList(Event e,SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0237Event event=(EsdTrs0237Event)e;
		try {
			rowSet=dbDao.searchApprovalList(event, account);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}

	/**
	 * Agreement 결재자 리스트 저장<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse saveApprovalList(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0237Event event=(EsdTrs0237Event)e;
		try {
			dbDao.saveApprovalList(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Agreement 결재자 리스트 삭제<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse delApprovalList(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0237Event event=(EsdTrs0237Event)e;
		try {
			dbDao.delApprovalList(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Sheet에 USER ID로 USER NAME을 가져오는 이벤트 처리<br>
	 * @param e Event
	 * @return String
	 * @throws EventException
	 */
	public SearchApprovalMgmtVO searchUsrId(Event e) throws EventException {
	    EsdTrs0237Event event	= (EsdTrs0237Event)e;
	    SearchApprovalMgmtVO vo = new SearchApprovalMgmtVO();
	    try{
	    	vo = dbDao.searchUsrId(event);
			return vo;					
	    } catch (DAOException de) {
	    	log.error("err "+de.toString(),de);
	    	throw new EventException(de.getMessage());
	    } catch (Exception ex) {
	    	log.error(ex.toString(), ex);
	    	throw new EventException(ex.getMessage());
	    } 
	}
}
