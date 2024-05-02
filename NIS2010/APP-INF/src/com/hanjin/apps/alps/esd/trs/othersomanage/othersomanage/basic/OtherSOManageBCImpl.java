/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageBCImpl.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration.OtherSOManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

 

/**
 * ESD-OtherSOManage Business Logic Basic Command implementation<br>
 * - ESD-OtherSOManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_018EventResponse,OtherSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OtherSOManageBCImpl   extends BasicCommandSupport implements OtherSOManageBC {

	// Database Access Object
	private transient OtherSOManageDBDAO dbDao=null;

	/**
	 * OtherSOManageBCImpl 객체 생성<br>
	 * OtherSOManageDBDAO를 생성한다.<br>
	 */
	public OtherSOManageBCImpl(){
		dbDao = new OtherSOManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param v
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList v) throws EventException {
		DBRowSet rowSet = null; 
		try {
			rowSet = dbDao.searchTrspSvcOrdList(v);
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
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherSOCorrectionList(Event e) throws EventException {
		DBRowSet rowSet			= null; 
		EsdTrs0018Event event	= (EsdTrs0018Event)e;
		try {
			rowSet=dbDao.searchOtherSOCorrectionList(event);
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
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerEqNo(Event e) throws EventException {
		DBRowSet rowSet			= null; 
		EsdTrs0018Event event	= (EsdTrs0018Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet=dbDao.searchContainerEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03)){
				while(rowSet.next()){
					eventResponse.setETCData(rowSet.getString("eq_no"), rowSet.getString("eq_no"));				
				}
			}
			
			if(formcommand.isCommand(FormCommand.SEARCH10) || formcommand.isCommand(FormCommand.SEARCH11) || formcommand.isCommand(FormCommand.SEARCH12))
				eventResponse.setETCData("ROW", event.getRow());
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisEqNo(Event e) throws EventException {
		DBRowSet rowSet			= null; 
		EsdTrs0018Event event	= (EsdTrs0018Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet=dbDao.searchChassisEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData(rowSet.getString("eq_no"), rowSet.getString("eq_no"));
			}
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetEqNo(Event e) throws EventException {
		DBRowSet rowSet			= null; 
		EsdTrs0018Event event	= (EsdTrs0018Event)e;
		FormCommand formcommand = e.getFormCommand();	
		try {
			rowSet=dbDao.searchGensetEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData(rowSet.getString("EQ_NO"), rowSet.getString("EQ_NO"));
			}
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());									
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public ArrayList addOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event=(EsdTrs0018Event)e;

		try {
			ArrayList returnV = dbDao.addTRS_TRSP_SVC_ORD(event);
			return returnV;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Rate Apply 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateApplyList(Event e) throws EventException {
		EsdTrs0018Event event=(EsdTrs0018Event)e;

		try {
			return dbDao.searchRateApplyList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_0018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0018Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event=(EsdTrs0018Event)e;

		try {
			dbDao.modifyOtherSOManage(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_018 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event=(EsdTrs0018Event)e;

		try {
			dbDao.removeOtherSOManage(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OtherSOManage 업무 시나리오 마감작업<br>
	 * OtherSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}