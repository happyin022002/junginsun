/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageBCImpl.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.11.29 민정호 [CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
* 2011.12.12 민정호 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration.SingleTransportationSOManageDBDAO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author z_kim_sang_geun
 * @see ESD_TRS_002EventResponse,SingleTransportationSOManageBC 각 DAO 클래스 참조
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
	 *
	 * @return 
	 * @exception EventException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws EventException {
		String lSeq = "";
		try {
			lSeq = dbDao.searchSingleTransportationSOCandidatesListK();
			return lSeq;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		List<SingleTransportationVO> singleTransportationVO = new ArrayList<SingleTransportationVO>();
		try {
			dbDao.searchContiCodeCheck(event);
			singleTransportationVO=dbDao.searchSingleTransportationSOCandidatesListP(event);
			return singleTransportationVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param vo
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListC(Event e, List<SingleTransportationVO> vo, String lSeq) throws EventException {
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		try {
			dbDao.searchSingleTransportationSOCandidatesListC(event, vo,lSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListU(Event e, String lSeq) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		try {
			dbDao.searchSingleTransportationSOCandidatesListU(event, lSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param lSeq
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOCandidatesList(Event e, String lSeq) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			dbDao.searchContiCodeCheck(event);
			
			rowSet=dbDao.searchSingleTransportationSOCandidatesList(event, lSeq);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 *
	 * @param lSeq
	 * @exception EventException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws EventException {
		try {
			dbDao.searchSingleTransportationSOCandidatesListD(lSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event 	event	= (EsdTrs0002Event)e;

		DBRowSet 			rowSet	= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet		= dbDao.searchSingleTransportationSOList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifySingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		List<TrsTrspSvcOrdVO> seqVoList = new  ArrayList<TrsTrspSvcOrdVO>();
		try {
			arrSeq = dbDao.modifySINGLE_TRANSPORTATION_VO(event);
			for( int m=0; m<arrSeq.size(); m++ ) {
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				seqVo.setTrspSoSeq(String.valueOf(arrSeq.get(m))); 
				seqVoList.add(seqVo);
			}

			eventResponse.setRsVoList(seqVoList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_0051 에 대한 이벤트 처리<br>
	 * CY & DOOR S/O Correction화면의 Separate 수행
	 * @param e ESD_TRS_0051Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		try {
			dbDao.modify01SINGLE_TRANSPORTATION_VO(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * W/O Issued 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modify02SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		List<TrsTrspSvcOrdVO> seqVoList = new  ArrayList<TrsTrspSvcOrdVO>();
		try {
			arrSeq = dbDao.modify02SINGLE_TRANSPORTATION_VO(event);
			for( int m=0; m<arrSeq.size(); m++ ) {
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				seqVo.setTrspSoSeq(String.valueOf(arrSeq.get(m))); 
				seqVoList.add(seqVo);
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CY&DOOR Correction S/O 삭제 이벤트 처리<br>
	 * ESD_TRS_0051 에 대한 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeSingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		List<TrsTrspSvcOrdVO> seqVoList = new  ArrayList<TrsTrspSvcOrdVO>();
		try {
			arrSeq = dbDao.removeSINGLE_TRANSPORTATION_VO(event);
			for( int m=0; m<arrSeq.size(); m++ ) {
				TrsTrspSvcOrdVO seqVo = new TrsTrspSvcOrdVO();
				seqVo.setTrspSoSeq(String.valueOf(arrSeq.get(m))); 
				seqVoList.add(seqVo);
			}
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
	 * @param singleTransportationVO
	 * @exception EventException
	 */
	public void verifySingleTransportationSOIRG(SingleTransportationVO singleTransportationVO) throws EventException {
		try {
			dbDao.verifySingleTransportationSOIRG(singleTransportationVO.getColumnValues());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_002 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param sRow
	 * @return 
	 * @exception EventException
	 */
	public String verifySingleTransportationDupChk(Event e, int sRow) throws EventException{
		String sSoNo = "";
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		try {
			dbDao.verifySingleTransportationDupChk(event, sRow);
			return sSoNo;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_002 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @param sRow
	 * @return 
	 * @exception EventException
	 */
	public String multiSingleTransportationSOManage(Event e, int sRow) throws EventException{
		String sSoNo = "";
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		try {
			sSoNo = dbDao.multiSINGLE_TRANSPORTATION_VO(event, sRow);
			return sSoNo;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event=(EsdTrs0930Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modifyOfficeSINGLE_TRANSPORTATION_VO(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOfficeTransportationSOManageMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0930Event event=(EsdTrs0930Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.modifyOfficeMT_TRANSPORTATION_VO(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_930 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_930Event
	 * @return EventResponse ESD_TRS_930EventResponse
	 * @exception EventException
	 */
	public EventResponse search10TransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0930Event event=(EsdTrs0930Event)e;
		DBRowSet rowSet	= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.search10TransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOfficeSOManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchSubOfficeSOManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_002 에 대한 추가 이벤트 처리<br>
	 * Actual Customer Info Change cause from Door Location/Zone Modification
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event 	event			= (EsdTrs0002Event)e;

		try {
			return dbDao.searchActualCustomerInfoSet(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * SO Candidate 삭제 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_002Event
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public List<SingleTransportationVO> removeSOCandidate(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event = (EsdTrs0002Event)e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SingleTransportationVO> sub_models = new ArrayList<SingleTransportationVO>();
			return sub_models = dbDao.removeSOCandidate(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Container 직반납을 위한 OffHireVerify check<br>
	 * ESD_TRS_0002 에 대한 추가 이벤트 처리<br>
	 * OffHireVerify check
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchOffHireVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchOffHireVerify(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CY / Door 변경에 따른 Cost Mode 조회<br>
	 * ESD_TRS_0002 에 대한 추가 이벤트 처리<br>
	 * @param e ESD_TRS_002Event
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchCostMode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String comboText = "";
		StringBuffer sb = new StringBuffer();
		
		try {
			rowSet = dbDao.searchCostMode(event);

			while(rowSet.next()){
				//소스품질 결함 수정
				//comboText = comboText + rowSet.getString("CODE") + "|";
				sb.append(rowSet.getString("CODE") + "|");
			}
			comboText = sb.toString();
			
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("COST_MODE", comboText);
			
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
	 * S/O 발행 변경사항을 Before History 테이블에 관리
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void multiSoIssueBeforeHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException {
		try {
			dbDao.multiSoIssueBeforeHis(singleTransportationVO, replanSts);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * S/O 발행 변경사항을 After History 테이블에 관리
	 * 
	 * @param singleTransportationVO
	 * @param replanSts
	 * @throws EventException
	 */
	public void multiSoIssueAfterHis(SingleTransportationVO singleTransportationVO, String replanSts) throws EventException {
		try {
			dbDao.multiSoIssueAfterHis(singleTransportationVO, replanSts);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * SEARCH09 이벤트 처리<br>
	 * ESD_TRS_0002 화면에 대한 SEARCH07 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0002Event
	 * @return EventResponse EsdTrs0002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgVvd(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0002Event event=(EsdTrs0002Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchBkgVvd(event);
			if(rowSet.next()){
				eventResponse.setETCData("ib_vvd_cd", rowSet.getString("BKG_VVD_IB"));
				eventResponse.setETCData("ob_vvd_cd", rowSet.getString("BKG_VVD_OB"));
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
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		String nextToken = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				nextToken = st.nextToken();
				if(!contains(arrlist, nextToken)){
					arrlist.add(j++, nextToken);
				}
			}
		}
		return arrlist;
	}
	
	/**
	 * ArrayList에 동일한 string이 있는지 판단하는 메소드
	 * 
	 * @param src
	 * @param elem
	 * @return
	 */
	public boolean contains(ArrayList src, String elem){
		
		boolean result = false;
		for(int i=0; src != null && i< src.size(); i++){
			if(elem.equals((String)src.get(i))){
				result = true;
			}
		}
		return result;
	}
		
	/**
	 * S/O Correction 시 Delete flag 체크로직<br>
	 *
	 * @param singleTransportationVO
	 * @return String 
	 * @exception EventException
	 */
	public String verifySingleTransportationDeltChk(com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO singleTransportationVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String delt_flg = "";
		try {
			delt_flg = dbDao.verifySingleTransportationDeltChk(singleTransportationVO);		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return delt_flg;		
	}
	
	/**
	 * SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직<br>
	 *
	 * @param singleTransportationVO
	 * @param uiContiCd
	 * @return String 
	 * @exception EventException
	 */
	public String searchSceTroMapg(SingleTransportationVO singleTransportationVO, String uiContiCd) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String delt_flg = "";
		try {
			delt_flg = dbDao.searchSceTroMapg(singleTransportationVO,uiContiCd);		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return delt_flg;		
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	
	/**
	 * 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
	 * Trans mode 와 Route 가 동일한 내용으로 생성된 건 중복 체크 로직<br>
	 * 
	 * @param singleTransportationVO
	 * @return String
	 * @throws EventException
	 */
	public String searchSODupCheck(SingleTransportationVO singleTransportationVO) throws EventException {

//		EsdTrs0002Event event=(EsdTrs0002Event)e;
		String retVal = "";
		try{
//			SingleTransportationVO singleTransportationVO = event.getSingleTransportationVO();	
			retVal = dbDao.searchSODupCheck(singleTransportationVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return retVal;
	}
	
	/**
	 * 2012.06.18 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
	 * Node가 변경됐을 경우 Distance를 계산한다.
	 * @param singleTransportationVO
	 * @return EventResponse ESD_TRS_002EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceCalculation(SingleTransportationVO singleTransportationVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchDistanceCalculation(singleTransportationVO);
			if(rowSet.next()){
				eventResponse.setETCData("ttl_dist", rowSet.getString("TTL_DIST"));
				eventResponse.setETCData("lnk_dist_div_cd", rowSet.getString("LNK_DIST_DIV_CD"));
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
	 * USA CY & Door Creation의 그리드 Door Yard변경시 Door Yard Name조회
	 * 
	 * @param dorYdNm
	 * @return String 
	 * @exception EventException
	 */
	public String searchDoorYardName(String dorYdNm) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String rtnVal="";
		try {
			rowSet=dbDao.searchDoorYardName(dorYdNm);
			if(rowSet.next()){
				rtnVal = rowSet.getString("ZN_NM");
			}
			
			return rtnVal;
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
}
