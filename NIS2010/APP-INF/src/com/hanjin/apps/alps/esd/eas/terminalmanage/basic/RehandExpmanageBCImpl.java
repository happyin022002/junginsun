/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageBCImpl.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.integration.RehandExpmanageDBDAO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasLocationVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasMdmCountryVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
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
 * ENIS-RehandExpmanage Business Logic Basic Command implementation<br>
 * - ENIS-RehandExpmanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jun Ho Kim
 * @see ESD_EAS_001EventResponse,RehandExpmanageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RehandExpmanageBCImpl   extends BasicCommandSupport implements RehandExpmanageBC {

	// Database Access Object
	private transient RehandExpmanageDBDAO dbDao=null;

	/**
	 * RehandExpmanageBCImpl 객체 생성<br>
	 * RehandExpmanageDBDAO를 생성한다.<br>
	 */
	public RehandExpmanageBCImpl(){
		dbDao = new RehandExpmanageDBDAO();
	}

	/**
	 * Termanal Manage Rehanding Exp. COD vs. TPB조회
	 * @param e EsdEas0001Event
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchRehandTPBCheckList(Event e) throws EventException {
    	EsdEas0001Event event  = (EsdEas0001Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	rowSet = dbDao.searchRehandTPBCheckList(event);
    		eventResponse.setRsVo(rowSet);
    		return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * Expense Audit Remark 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRehandExpnAudRmk(Event e) throws EventException {

		EsdEas0901Event	event	= (EsdEas0901Event)e;
		
		DBRowSet	rowSet	= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet	= dbDao.searchRehandExpnAudRmk(event);
    		eventResponse.setRsVo(rowSet);
    		return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Expense Audit Remark 추가/수정. 4341.11.24
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRehandExpnAudRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0901Event	event	= (EsdEas0901Event)e;
		
		try {
			dbDao.multiRehandExpnAudRmk(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    

	/**
	 * RehandExpmanage 업무 시나리오 마감작업<br>
	 * RehandExpmanage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	
	/**
	 * Port 정보를 조회합니다.
	 * 
	 * @param EasLocationVO locationVO
	 * @return List<EasLocationVO>
	 * @exception EventException
	 */
	public List<EasLocationVO> searchPortList(EasLocationVO locationVO) throws EventException {
		try {
			return dbDao.searchPortList(locationVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<EasMdmCountryVO>
	 * @exception EventException
	 */
	public List<EasMdmCountryVO> searchCountryList(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryList(cntCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	 /**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param ofcCd
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHierarchy(String ofcCd) throws EventException {

		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.searchOfficeHierarchy(ofcCd);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	 /**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param ofcCd
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOffice(String ofcCd) throws EventException {
		

		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.searchSubOffice(ofcCd);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	
	/**
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param EasOpfTdrAtchFileVO opfTdrAtchFileVO
	 * @return List<EasOpfTdrAtchFileVO>
	 * @exception EventException
	 */
	public List<EasOpfTdrAtchFileVO> searchOpfTdrAtchFileVO(EasOpfTdrAtchFileVO opfTdrAtchFileVO) throws EventException {
		try {
			return dbDao.searchOpfTdrAtchFileVO(opfTdrAtchFileVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
}