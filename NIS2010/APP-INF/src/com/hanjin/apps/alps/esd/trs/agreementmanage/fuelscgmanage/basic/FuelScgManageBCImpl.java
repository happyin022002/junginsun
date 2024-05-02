/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FuelScgManageBCImpl.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.basic;


import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event.EsdTrs0280Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration.FuelScgManageDBDAO;
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
 * @author SHIN DONG IL
 * @see ESD_TRS_0280EventResponse,FuelScgManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FuelScgManageBCImpl extends BasicCommandSupport implements FuelScgManageBC {
	// Database Access Object
	private transient FuelScgManageDBDAO dbDao=null;
	
	/**
	 * FuelScgManageBCImpl 객체 생성<br>
	 * FuelScgManageDBDAO 생성한다.<br>
	 */
	public FuelScgManageBCImpl(){
		dbDao = new FuelScgManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchFuelSurchargeList(Event e) throws EventException {
		EsdTrs0280Event event=(EsdTrs0280Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchFuelSurchargeList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
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
	 * Fuel Surcharge (FUA) Correction화면에 대한 Verify Data 생성 <br>
	 * @param e
	 * @param account
	 * @exception EventException
	 */
	public void insertFeulScgAgmtVerifyData(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event 	event	= (EsdTrs0280Event)e;
		try {
			dbDao.insertFeulScgAgmtVerifyData(event,account);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement FUA Surcharge Verify 이벤트 처리
	 * 
	 * @param e
	 * @return response ESD_TRS_0280EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event 	event	= (EsdTrs0280Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyFuelScgAgmt(event);
			eventResponse.setRsVo(rowSet);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction화면의 Verify data 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void deleteFuelScgAgmtVerifyData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event 	event	= (EsdTrs0280Event)e;
		try {
			dbDao.deleteFuelScgAgmtVerifyData(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Fuel Surcharge (FUA) Correction저장 이벤트 처리<br>
	 * Agreement FUA Rate 정보 수정<br>
	 * @param e
	 * @param account 
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiCorrFuelScgRateAgmt(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event 	event	= (EsdTrs0280Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.multiCorrFuelScgRateAgmt(event,account);
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
	 * FUA Agreement Rate정보 삭제 처리<br>
	 * 
	 * @param e
	 * @param account  
	 * @return response ESD_TRS_0280EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteCorrFuelScgRateAgmt(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event 	event	= (EsdTrs0280Event)e;
		try {
			dbDao.deleteCorrFuelScgRateAgmt(event,account);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		return eventResponse;
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * CommodityGroupCodeManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}