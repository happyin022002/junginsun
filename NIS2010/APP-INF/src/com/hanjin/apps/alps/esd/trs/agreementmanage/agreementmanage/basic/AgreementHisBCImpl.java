/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionBCImpl.java
*@FileTitle : Agreement File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.2
* 2010-04-05 cjh
* 1.0 최초 생성
* 
* 1.1 2010-05-26 김종호 : Inquiry 기능 구현
* 1.2 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0227Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0230Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0231Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0235Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration.AgreementHisDBDAO;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
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
 * @author agreement
 * @see ESD_TRS_0231EventResponse,AgreementCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AgreementHisBCImpl   extends BasicCommandSupport implements AgreementHisBC {

	// Database Access Object
	private transient AgreementHisDBDAO dbDao=null;

	/**
	 * AgreementHisBCImpl 객체 생성<br>
	 * AgreementHisDBDAO를 생성한다.<br>
	 */
	public AgreementHisBCImpl(){
		dbDao = new AgreementHisDBDAO();
	}

	/**
	 * Agreement Rate History정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateHisAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0227Event event=(EsdTrs0227Event)e;
		try {
			rowSet=dbDao.searchRateHisAgmt(event);
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
	 * Agreement Rate inquiry정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */ 
	public EventResponse searchDtlAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetTot=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0231Event event=(EsdTrs0231Event)e;
		String page_cnt = "";
		try {
			page_cnt = event.getCurPageCnt();
			rowSet=dbDao.searchDtlAgmt(event);
			if(page_cnt.equals("1")){
			    rowSetTot=dbDao.searchDtlAgmtTot(event);
			    if(rowSetTot.next()){
					eventResponse.setETCData("TOT_CNT", rowSetTot.getString("TOT_CNT"));
				}else{
					eventResponse.setETCData("TOT_CNT", "");
			    }
			}else{
				eventResponse.setETCData("TOT_CNT", "");
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
	 * Agreement Rate inquiry정보 조회(Effective date 형식으로)<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */ 
	public EventResponse searchDtlAgmtEffDt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetTot=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0231Event event=(EsdTrs0231Event)e;
		String page_cnt = "";
		try {
			page_cnt = event.getCurPageCnt();
			rowSet=dbDao.searchDtlAgmtEffDt(event);
			if(page_cnt.equals("1")){
			    rowSetTot=dbDao.searchDtlAgmtTotEffDt(event);
			    if(rowSetTot.next()){
					eventResponse.setETCData("TOT_CNT", rowSetTot.getString("TOT_CNT"));
				}else{
					eventResponse.setETCData("TOT_CNT", "");
			    }
			}else{
				eventResponse.setETCData("TOT_CNT", "");
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
	 * Agreement Surcharge Rate History정보 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchScgHisAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0230Event event=(EsdTrs0230Event)e;
		try {
			rowSet=dbDao.searchScgHisAgmt(event);
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
	 * Agreement Surcharge Rate Inquiry 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchScgDtlAgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0235Event event=(EsdTrs0235Event)e;
		try {
			rowSet=dbDao.searchScgDtlAgmt(event);
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
	 * Type Size 조회<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTpSz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0231Event event=(EsdTrs0231Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String comboText = "";
		try {
			rowSet = dbDao.searchTpSz(event);

			while(rowSet.next()){
				comboText = comboText + rowSet.getString("TPSZ") + "|";
			}
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("TPSZ", comboText);
			
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
	 * Agreement Rate History 삭제 여부 저장<br>
	 * 
	 * @param e ESD_TRS_0227Event
	 * @return EventResponse ESD_TRS_0227EventResponse
	 * @exception EventException
	 */
	public EventResponse saveTrsAgmtEqRtHis(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0227Event event=(EsdTrs0227Event)e;

		try {
			dbDao.saveTrsAgmtEqRtHis(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
				
	/**
	 * Agreement Surcharge Rate History 화면의 Rate History 삭제 여부 저장<br>
	 * 
	 * @param e ESD_TRS_0230Event
	 * @return EventResponse ESD_TRS_0230EventResponse
	 * @exception EventException
	 */
	public EventResponse saveScgHisAgmt(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0230Event event=(EsdTrs0230Event)e;

		try {
			dbDao.saveScgHisAgmt(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
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