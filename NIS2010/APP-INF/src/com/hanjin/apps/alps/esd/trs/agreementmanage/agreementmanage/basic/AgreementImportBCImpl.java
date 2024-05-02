/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportBCImpl.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2010-04-05
*@LastModifier : agreement
*@LastVersion : 1.0 
* 2010-04-05 agreement
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0240Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration.AgreementImportDBDAO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
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
 * @author agreement
 * @see ESD_TRS_061EventResponse,AgreementImportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AgreementImportBCImpl   extends BasicCommandSupport implements AgreementImportBC {

	// Database Access Object
	private transient AgreementImportDBDAO dbDao=null;

	/**
	 * AgreementImportBCImpl 객체 생성<br>
	 * AgreementImportDBDAO를 생성한다.<br>
	 */
	public AgreementImportBCImpl(){
		dbDao = new AgreementImportDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Header정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtHdr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			rowSet=dbDao.searchAgmtHdr(event);
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
	 * Agreement Child S/P정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtChdVndr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			rowSet=dbDao.searchAgmtChdVndr(event);
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
	 * Agreement S/P명 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */

	public EventResponse searchVenderName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			rowSet=dbDao.searchVenderName(event);
			if(rowSet.next()){
				eventResponse.setETCData("VNDR_NM", rowSet.getString("VNDR_NM"));
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
	 * Contract Office 존재여부 조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContractOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			rowSet=dbDao.searchContractOffice(event);
			if(rowSet.next()){
				eventResponse.setETCData("CTRT_OFC_CD", rowSet.getString("OFC_CD"));
			}
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
	 * Agreement 중복여부 체크<br>
	 * 
	 * @param searchAgmtHdrVO
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtDupChk(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			rowSet=dbDao.searchAgmtDupChk(searchAgmtHdrVO);
			if(rowSet.next()){
				eventResponse.setETCData("CNT_CD_AGREE", rowSet.getString("AGMT_NO"));
			}
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
	 * 입력 이벤트 처리<br>
	 * Agreement Header자료 생성<br>
	 * 
	 * @param searchAgmtHdrVO
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiAgmtHdr(SearchAgmtHdrVO searchAgmtHdrVO) throws EventException {
		String rtn_agmt_no = "";
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			rtn_agmt_no = dbDao.multiAgmtHdr(searchAgmtHdrVO);
			eventResponse.setETCData("NEW_AGMT_NO", rtn_agmt_no);
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
	 * HJS-HJL Handling Fee Management 정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchHjlHndlFee(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0240Event event=(EsdTrs0240Event)e;
		try {
			rowSet=dbDao.searchHjlHndlFee(event);
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
	 * HJS-HJL Handling Fee Management 정보 History 포함 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchHjlHndlFeeHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0240Event event=(EsdTrs0240Event)e;
		try {
			rowSet=dbDao.searchHjlHndlFeeHis(event);
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
	 * 수정 이벤트 처리<br>
	 * Agreement Header자료 수정<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAgmtHdrRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			dbDao.multiAgmtHdrRmk(event);
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
	 * Agreement S/P 정보 저장<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiAgmtHdrVndr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event=(EsdTrs0220Event)e;
		try {
			dbDao.multiAgmtHdrVndr(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Sequence 생성<br>
	 * Verify시 Sequence생성<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String createAgmtVerifyNewTmpSeq() throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String newAgmtTmpSeq  = null;
		try {
			rowSet=dbDao.createNewAgmtTmpSeq();
			if(rowSet.next())	newAgmtTmpSeq = rowSet.getString(1);
			return newAgmtTmpSeq;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * Agreement Verify 처리<br>
	 * AgreementImport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void insertAgmtVerifyData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		try {
			dbDao.insertAgreementVerifyData(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Creation화면의 Pair Type Verify 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0221EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyAgmtPair(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyAgmtPair(event);
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Creation화면의 Distance Type Verify 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0221EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyAgmtDistance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyAgmtDistance(event);
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Creation화면의 Verify data 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void deleteAgmtVerifyData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		try {
			dbDao.deleteAgmtVerifyData(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Surcharge Verify 이벤트 처리
	 * 
	 * @param e
	 * @return response ESD_TRS_0221EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyAgmtSurcharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyAgmtSurcharge(event);
			eventResponse.setRsVo(rowSet);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 *  Agreement Sub Office정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOfcCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0221Event event=(EsdTrs0221Event)e;
		try {
			rowSet=dbDao.searchSubOfcCd(event);
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
	 * Agreement Rate정보 삭제 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0225EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCorrRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		try {
			dbDao.deleteCorrRateAgmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Rate 정보 수정<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.multiCorrRateAgmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Rate 정보 수정<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse saveHjlHndlFee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0240Event 	event	= (EsdTrs0240Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.saveHjlHndlFee(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Surcharge Rate 정보 수정<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.multiCorrScgAgmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Agreement Surcharge Rate정보 삭제 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0228EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCorrScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		try {
			dbDao.deleteCorrScgAgmt(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return eventResponse;
	}
	
	/**
	 * Agreement Contract Office 권한체크<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return response ESD_TRS_0221EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthChk(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event 	event	= (EsdTrs0221Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			rowSet=dbDao.searchAuthChk(event, account);
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
	 * TRS 업무 시나리오 마감작업<br>
	 * AgreementFileImport업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
