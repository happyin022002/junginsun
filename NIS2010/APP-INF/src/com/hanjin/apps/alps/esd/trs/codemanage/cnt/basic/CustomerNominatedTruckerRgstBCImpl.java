/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstBCImpl.java
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0086Event;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration.CustomerNominatedTruckerRgstDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeon Jee Ye
 * @see ESD_TRS_0086EventResponse,CustomerNominatedTruckerRgstBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CustomerNominatedTruckerRgstBCImpl extends BasicCommandSupport implements CustomerNominatedTruckerRgstBC {
	// Database Access Object
	private transient CustomerNominatedTruckerRgstDAO dbDao=null;
	
	/**
	 * CustomerNominatedTruckerRgstBCImpl 객체 생성<br>
	 * CustomerNominatedTruckerRgstDAO를 생성한다.<br>
	 */
	public CustomerNominatedTruckerRgstBCImpl(){
		dbDao = new CustomerNominatedTruckerRgstDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntRgst(Event e) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchCntRgst(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면의 searchDt에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDtDiv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		try {
			rowSet = dbDao.searchDtDiv(event);
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
	 * CommodityGroupCodeManage화면의 searchCust에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCust(Event e) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchCust(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 S/C, RFA  조회시 Custmer Contract 정보를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContractInfo(Event e) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchContractInfo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면의 searchTrucker에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrucker(Event e) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchTrucker(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage화면의 searchRepYd에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRepYd(Event e) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchRepYd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 저장 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0086EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCntRgst(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiCntRgst(event, account);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0086EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCntRgst(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.deleteCntRgst(event, account);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * CommodityGroupCodeManage화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse ESD_TRS_0086EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCntAproRqst(Event e, SignOnUserAccount account) throws EventException {
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.updateCntAproRqst(event, account);
		  } catch (DAOException de) {
		    log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SCAC CD로 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpNameByScacCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event=(EsdTrs0086Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet2=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			/*
			 * DUP CHECK LOGIC 추가해야 
			 */
			String dupCd= "N";
			String vndr_seq = "";
			String vndr_nm = "";
			String usa_edi_cd = "";
			
			rowSet = dbDao.searchDupChkSpNameByScacCd(event);
			while(rowSet.next()){
				dupCd = rowSet.getString("DUP_CD");
			}
			
			if(dupCd.equals("N")){
				rowSet2 = dbDao.searchSpNameByScacCd(event);
				while(rowSet2.next()){
					vndr_seq	= 	rowSet2.getString("VNDR_SEQ");
					vndr_nm 	= 	rowSet2.getString("VNDR_NM");
					usa_edi_cd	=	rowSet2.getString("USA_EDI_CD");
				}
			}
			eventResponse.setETCData("dup_cd", 		dupCd);
			eventResponse.setETCData("vndr_seq", 	vndr_seq);
			eventResponse.setETCData("vndr_nm", 	vndr_nm);
			eventResponse.setETCData("usa_edi_cd", 	usa_edi_cd);
			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			throw new EventException(se.getMessage());
		}
	}
	

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * CommodityGroupCodeManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}

