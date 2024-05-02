/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ChassisGensetSOManageBCImpl.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.04 조풍연
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.01.04 최 선         1.1 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic; 


import java.sql.SQLException;
import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event;
import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration.ChassisGensetSOManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong
 * @see ESD_TRS_014EventResponse,ChassisGensetSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChassisGensetSOManageBCImpl   extends BasicCommandSupport implements ChassisGensetSOManageBC {

	// Database Access Object
	private transient ChassisGensetSOManageDBDAO dbDao=null;

	/**
	 * ChassisGensetSOManageBCImpl 객체 생성<br>
	 * ChassisGensetSOManageDBDAO를 생성한다.<br>
	 */
	public ChassisGensetSOManageBCImpl(){
		dbDao = new ChassisGensetSOManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param v
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList v) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchTrspSvcOrdList(v);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse removeChassisGensetList(Event e) throws EventException {
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {			
			dbDao.removeChassisGensetList(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		try {
			rowSet=dbDao.searchVendorList(event);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			StringBuffer vndrNoText = new StringBuffer();
			StringBuffer vndrNmText = new StringBuffer();
			
			if(rowSet != null && rowSet.getRowCount() > 0 ){
				int i = 1;
				while(rowSet.next()){
					vndrNoText.append( (i == 1 ? "":"|"));
					vndrNoText.append( rowSet.getString("vndr_no"));

					vndrNmText.append( (i++ == 1 ? "":"|"));
					vndrNmText.append( rowSet.getString("vndr_nm_eng"));
				}
				
				eventResponse.setETCData("vndr_no", vndrNoText.toString());
				eventResponse.setETCData("vndr_nm_eng", vndrNmText.toString());

			}
			return eventResponse;
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
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		try {
			rowSet=dbDao.searchVendor(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH11)){
				if(rowSet.next()){		
					eventResponse.setETCData("vndr_no", 			JSPUtil.getNull(rowSet.getString("vndr_no"),""));
					eventResponse.setETCData("vndr_nm_eng", 		JSPUtil.getNull(rowSet.getString("vndr_nm_eng"),""));
					eventResponse.setETCData("vndr_cnt_curr_cd", 	JSPUtil.getNull(rowSet.getString("vndr_cnt_curr_cd"),""));
					eventResponse.setETCData("hzd_mtrl_flg", 		JSPUtil.getNull(rowSet.getString("hzd_mtrl_flg"),""));
					eventResponse.setETCData("ovwt_tri_axl_flg", 	JSPUtil.getNull(rowSet.getString("ovwt_tri_axl_flg"),""));
					eventResponse.setETCData("vndr_eml", 			JSPUtil.getNull(rowSet.getString("vndr_eml"),""));
					eventResponse.setETCData("sp_ptal_exist_flg", 	JSPUtil.getNull(rowSet.getString("sp_ptal_exist_flg"),""));
					eventResponse.setETCData("cnddt_vndr_flg",		JSPUtil.getNull(rowSet.getString("cnddt_vndr_flg"),""));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorChld(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		try {
			rowSet=dbDao.searchVendorChld(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH15)){
				if(rowSet.next()){		
					eventResponse.setETCData("vndr_no", 			rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", 		rowSet.getString("vndr_nm_eng"));
					eventResponse.setETCData("vndr_cnt_curr_cd", 	rowSet.getString("vndr_cnt_curr_cd"));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorPrnt(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		try {
			rowSet=dbDao.searchVendorPrnt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH16)){
				if(rowSet.next()){		
					eventResponse.setETCData("vndr_no", 			rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", 		rowSet.getString("vndr_nm_eng"));
					eventResponse.setETCData("vndr_cnt_curr_cd", 	rowSet.getString("vndr_cnt_curr_cd"));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisCorrectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;

		try {
			rowSet=dbDao.searchChassisCorrectionList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetCorrectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		
		try {
			rowSet=dbDao.searchGensetCorrectionList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedChassis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		try {
			rowSet=dbDao.searchImportedChassis(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedGenset(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		try {
			rowSet=dbDao.searchImportedGenset(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요	
		try {	
			rowSet=dbDao.verifyEqNo(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH04)||formcommand.isCommand(FormCommand.SEARCH05)){
				while(rowSet.next()){		
					eventResponse.setETCData(JSPUtil.getNull(rowSet.getString("eq_no")),JSPUtil.getNull(rowSet.getString("eq_no")));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addTRS_TRSP_SVC_ORD(Event e) throws EventException {
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		ArrayList returnV = null;
		try {
			returnV = dbDao.addTRS_TRSP_SVC_ORD(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return returnV;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyChassisGensetSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet=dbDao.verifyChassisGensetSOManage(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH03)){	
				while (rowSet != null && rowSet.next()) {
					eventResponse.setETCData(JSPUtil.getNull(rowSet.getString("eq_no")), JSPUtil.getNull(rowSet.getString("cre_dt")));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisGensetSOManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null;
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		try {
			rowSet=dbDao.searchChassisGensetSOManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null;
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet=dbDao.searchChassisSOManage(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH01)){			
				eventResponse.setETCData("ROW", event.getRow());
			}
			
			return eventResponse;	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null;
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet=dbDao.searchGensetSOManage(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH02)){			
				eventResponse.setETCData("ROW", event.getRow());
			}			
			return eventResponse;	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_014 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyChassisGensetSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.modifyChassisGensetSOManage(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerTpSzCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0014Event event = (EsdTrs0014Event)e;
		DBRowSet rowSet = null;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요		
		
		try {
			rowSet=dbDao.searchContainerTpSzCdList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH14)){
				while(rowSet.next()){	
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisTpSzCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet = null;
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요	
		try {
			rowSet=dbDao.searchChassisTpSzCdList(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH12)){
				while(rowSet.next()){	
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * ChassisGensetSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetTpSzCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null;
		EsdTrs0014Event event=(EsdTrs0014Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요	
		try {
			rowSet=dbDao.searchGensetTpSzCdList(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH13)){
				while (rowSet.next()) {
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * TRS 업무 시나리오 마감작업<br>
	 * ChassisGensetSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}