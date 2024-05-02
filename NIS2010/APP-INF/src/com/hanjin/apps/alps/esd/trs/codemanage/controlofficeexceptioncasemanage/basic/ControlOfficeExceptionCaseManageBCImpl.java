/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageBCImpl.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-09-27 poong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration.ControlOfficeExceptionCaseManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
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
 * @see ESD_TRS_079EventResponse,ControlOfficeExceptionCaseManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ControlOfficeExceptionCaseManageBCImpl   extends BasicCommandSupport implements ControlOfficeExceptionCaseManageBC {

//	 Database Access Object
	private transient ControlOfficeExceptionCaseManageDBDAO dbDao=null;

	
	/**
	 * OtherSOManageBCImpl 객체 생성<br>
	 * OtherSOManageDBDAO를 생성한다.<br>
	 */
	public ControlOfficeExceptionCaseManageBCImpl(){
		dbDao = new ControlOfficeExceptionCaseManageDBDAO();
	}
	
/**
	 * 조회 이벤트 처리<br>
	 * ControlOfficeExceptionCaseManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		try {
			rowSet=dbDao.searchControlOfficeExceptionCaseManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;

		try {
			dbDao.multiTRS_TRSP_OFC_EXPT_RULE(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String comboText = "";
		StringBuffer sb = new StringBuffer();
		try {
			rowSet=dbDao.searchYardCode(event);
			while(rowSet.next()){
				//소스품질 결함 수정
				//comboText = comboText + rowSet.getString("NOD") + "|";
				sb.append(rowSet.getString("NOD") + "|");
			}
			comboText = sb.toString();
			
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("nod", comboText);
			
			eventResponse.setRsVo(rowSet);
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
	 * SEARCH02 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH02 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		try {
			rowSet=dbDao.searchCountryCode(event);
			
			if(rowSet.next()){
				if(formcommand.isCommand(FormCommand.SEARCH02)){
					eventResponse.setETCData("CNT_CD", rowSet.getString("CNT_CD"));
				}
			}
			
			eventResponse.setRsVo(rowSet);
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
	 * SEARCH03 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH03 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchControlOfficeCode(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String comboText = "";
		StringBuffer sb = new StringBuffer();
		
		try {
			rowSet=dbDao.searchEquipmentSZ(event);

			while(rowSet.next()){
				//소스품질 결함 수정
				//comboText = comboText + rowSet.getString("CNTR_SZ_CD") + "|";
				sb.append(rowSet.getString("CNTR_SZ_CD") + "|");
			}
			comboText = sb.toString();
			
			if(comboText.length()>0)  comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("TEXT", comboText);

			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요 (여러 Event에서 호출시 필요)
		try {
			rowSet=dbDao.searchEquipmentTP(event);
			String comboText = "";
			
			while(rowSet.next()){
				if(formcommand.isCommand(FormCommand.SEARCH05)){ //(IF문은 여러 Event에서 호출시가 아니면 없어도 된다.
				comboText = comboText + rowSet.getString("CNTR_TP_CD") + "|";
				}
			}
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("TEXT", comboText);
			
			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.verifyControlOfficeCD(event);
			if(rowSet.next()){
				eventResponse.setETCData("OFC_CD", rowSet.getString("OFC_CD"));
				eventResponse.setETCData("OFC_TP_CD", rowSet.getString("OFC_TP_CD"));
			}
			
			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 이벤트 처리<br>
	 * ESD_TRS_079 화면에 대한 SEARCH01 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifySOOfficeCD(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event=(EsdTrs0079Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.verifySOOfficeCD(event);
			if(rowSet.next()){
				eventResponse.setETCData("OFC_CD", rowSet.getString("OFC_CD"));
			}
			
			eventResponse.setRsVo(rowSet);
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
	 * ControlOfficeExceptionCaseManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}