/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerNominatedTruckerAproBCImpl.java
*@FileTitle : CNT(Customer Nominated Trucker) Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2014-06-17
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2014-05-28 김도현
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0087Event;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration.CustomerNominatedTruckerAproDAO;
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
 * @see EsdTrs0087EventResponse 참조
 * @since J2EE 1.6
 */
public class CustomerNominatedTruckerAproBCImpl extends BasicCommandSupport implements CustomerNominatedTruckerAproBC {

	private transient CustomerNominatedTruckerAproDAO dbDao=null;

	public CustomerNominatedTruckerAproBCImpl() {
		dbDao = new CustomerNominatedTruckerAproDAO();
	}
	/**
	 * CNT(Customer Nominated Trucker) Approval 조회<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntApproval(Event e,SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			rowSet=dbDao.searchCntApproval(event, account);
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
	 * CNT(Customer Nominated Trucker) Approval - Approval Status 조회<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDtAproDiv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String comboText = "";
		StringBuffer sb = new StringBuffer();
		try {
			rowSet = dbDao.searchDtAproDiv(event);

			while(rowSet.next()){
				sb.append( rowSet.getString("INTG_CD_VAL_CTNT") +"-"+  rowSet.getString("INTG_CD_VAL_DP_DESC") + "|" );
			}
			comboText = sb.toString();
			
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("MUTI_STATUS", comboText);
			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	

	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Save <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntAproSave(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.updateCntAproSave(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Reject <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntRjct(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.updateCntRjct(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Approval <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntApro(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.updateCntApro(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Save <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse saveCntApro(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.saveCntApro(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Cancel <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntCxl(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.updateCntCxl(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CNT(Customer Nominated Trucker) Registration 화면의 Destination을 조회하는 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtRtnYdNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchMtRtnYdNm(event);
			while(rowSet.next()){
				eventResponse.setETCData("yd_cd", rowSet.getString("YD_CD"));
				eventResponse.setETCData("yd_nm", rowSet.getString("YD_NM"));
			}
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 AGMT No를 조회하는 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchAgmtNo(event);
			while(rowSet.next()){
				eventResponse.setETCData("agmt_flg", rowSet.getString("AGMT_FLG"));
				eventResponse.setETCData("agmt_no", rowSet.getString("AGMT_NO"));
			}
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
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval S/P 화면의 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchCntVendorCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		String rtn_val = "";
		try {
			rtn_val=dbDao.searchCntVendorCheck(event);
			return rtn_val;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} 
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
     * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCntAproDorYdNm(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchCntAproDorYdNm(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Delete <br>
	 * 
	 * @param e ESD_TRS_0087Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0087EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntDel(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		try {
			dbDao.updateCntDel(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
     * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Location name 조회<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCntAproDorLocNm(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0087Event event=(EsdTrs0087Event)e;
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchCntAproDorLocNm(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
}

