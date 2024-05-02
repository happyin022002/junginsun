/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageBCImpl.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration.SingleTransportationSOManageDBDAO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageHdrVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.TrspSoSeqVO;
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
 * @author kim_sang_geun 
 * @see ESD_TRS_012EventResponse,SingleTransportationSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SingleTransportationSOManageBCImpl   extends BasicCommandSupport implements SingleTransportationSOManageBC {

	// Database Access Object
	private transient SingleTransportationSOManageDBDAO dbDao=null;

	/**
	 * SingleTransportationSOManageBCImpl 객체 생성<br>
	 * SingleTransportationSOManageDBDAO를 생성한다.<br>
	 */
	public SingleTransportationSOManageBCImpl(){
		dbDao = new SingleTransportationSOManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search04SingleTransportationSOManage( Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event=(EsdTrs0012Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.search04SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search05SingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event=(EsdTrs0012Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.search05SingleTransportationSOManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event=(EsdTrs0012Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.search03SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
		
			rowSet=dbDao.searchSingleTransportationSOManage(event);
			
			eventResponse.setRsVo(rowSet);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.search01SingleTransportationSOManage(event);
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
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search02SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.search02SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			dbDao.emptyModifySingleTrs(soffice_cd, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.emptyModify01SingleTrs(soffice_cd, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.emptyRemoveSingleTrs(soffice_cd, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_TRS_0012: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeEmptyRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			SingleTransportationSOManageHdrVO[] hdrVOs = event.getSingleTransportationSOManageHdrVOs();
			
			for(int i=0; hdrVOs.length > 0 && i<hdrVOs.length; i++){
				if(hdrVOs[i].getChk1().equals("1")){
					dbDao.removeEmptyRepoPlan(hdrVOs[i]);
				}
			}

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMultiSingleTransportationSo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		try {
			return dbDao.searchMultiSingleTransportationSo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchEmptyRepoCombineSeq(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
		try {
			return dbDao.searchEmptyRepoCombineSeq(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param chk_param Map<String, Object>
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchVerifyECC(Map<String, Object> chk_param) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchVerifyECC(chk_param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * SingleTransportationSOManage의 EmptyRepoSeq를 가져온다<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEmptyRepoSeq() throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchEmptyRepoSeq();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param insModels Collection<SingleTransportationVO>
	 * @param param Map<String, Object>
	 * @return 
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage5(Collection<SingleTransportationVO> insModels, Map<String, Object> param) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrayList resList = null;
		try {
			resList = dbDao.multiSingleTransportationSOManage5(insModels, param);
			eventResponse.setRsVoList(resList);
			return eventResponse;
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	/**
	 * CHM-201327722 MT repo & EQ on/off-hire 메뉴 개선사항1
	 * 2013.11.21 by SHIN DONG IL
	 * Off Hire일 경우 Node Combo정보를 MDM YARD와 LSE YARD정보를 모두 가져온다.
	 * ESD_TRS_0012
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	public String searchNodCdForOffHire(Event e) throws EventException{
		EsdTrs0012Event event=(EsdTrs0012Event)e;

		try {
			return dbDao.searchNodCdForOffHire(event);
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	
	/**
	 * Save 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @param account SignOnUserAccount 
	 * @return String
	 * @exception EventException
	 */
	public String multi01SingleTransportationSOManage(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event=(EsdTrs0012Event)e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String chk_us_rail = "N";
		String rtn_ref_no = "";
		try {
			
			SingleTransportationSOManageHdrVO[] hdrVOs = event.getSingleTransportationSOManageHdrVOs();
			
			for(int i=0; hdrVOs.length > 0 && i<hdrVOs.length; i++){
				
				if(hdrVOs[i].getIbflag().equals("I")){
					if(hdrVOs[i].getTrspModCd().equals("R")){// Rail 일 경우에만
						chk_us_rail = dbDao.checkUsRail(hdrVOs[i]);// From Node가 US Rail에 해당하는지 체크한다.
					}
					
					if(chk_us_rail.equals("N")){
						rtn_ref_no = rtn_ref_no+dbDao.multi01SingleTransportationSOManage(hdrVOs[i],account)+",";
					}else{
						throw new EventException((new ErrorHandler("TRS00099",new String[]{"Please check the inputted from node."})).getMessage());
					}
				}
			}
			
			return rtn_ref_no;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());	
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}