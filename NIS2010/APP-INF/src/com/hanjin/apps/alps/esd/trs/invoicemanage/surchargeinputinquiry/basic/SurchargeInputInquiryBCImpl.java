/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SurchargeInputInquiryBCImpl.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-17
*@LastModifier : Bong-jun
*@LastVersion : 1.8
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration.SurchargeInputInquiryDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-InvoiceManage Business Logic Basic Command implementation<br>
 * - ESD-InvoiceManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_918EventResponse,SurchargeInputInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SurchargeInputInquiryBCImpl   extends BasicCommandSupport implements SurchargeInputInquiryBC {

	// Database Access Object
	private transient SurchargeInputInquiryDBDAO dbDao=null;

	/**
	 * SurchargeInputInquiryBCImpl 객체 생성<br>
	 * SurchargeInputInquiryDBDAO를 생성한다.<br>
	 */
	public SurchargeInputInquiryBCImpl(){
		dbDao = new SurchargeInputInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeInputInquiryList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0918Event event=(EsdTrs0918Event)e;
		try {
			rowSet=dbDao.searchSurchargeInputInquiryList(event);
//			return  new EsdTrs0918EventResponse(rowSet, "SUCCESS");
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
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBIfFlag(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0918Event event=(EsdTrs0918Event)e;
		try {
			rowSet=dbDao.searchTPBIfFlag(event);
//			return  new EsdTrs0918EventResponse(rowSet, "SUCCESS");
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			if(rowSet.next()){
				eventResponse.setETCData("if_so_ofc", rowSet.getString("IF_SO_OFC"));
				eventResponse.setETCData("if_so_seq", rowSet.getString("IF_SO_SEQ"));
				eventResponse.setETCData("if_flg", rowSet.getString("IF_FLG"));
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
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeCodeNameList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0918Event event=(EsdTrs0918Event)e;
		try {
			rowSet=dbDao.searchSurchargeCodeNameList(event);
//			return new EsdTrs0918EventResponse(rowSet,"SUCCESS");
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * insert 처리<br>
	 * Surcharge Temp Table에 insert 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse addTempSurchargeList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0918Event event=(EsdTrs0918Event)e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet=dbDao.addTempSurchargeList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.ADD)){
					eventResponse.setETCData("scg_grp_seq", rowSet.getString("group_seq"));
				}
			}
			//eventResponse.setRsVo(rowSet);
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
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_918 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_918Event
	 * @return EventResponse ESD_TRS_918EventResponse
	 * @exception EventException
	 */
//	public EventResponse multiSurchargeInputInquiry(Event e) throws EventException{
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTrs0918Event event=(EsdTrs0918Event)e;
//
//		try {
//			dbDao.multiSurchargeInputInquiry(event);
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * InvoiceManage 업무 시나리오 마감작업<br>
	 * SurchargeInputInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}