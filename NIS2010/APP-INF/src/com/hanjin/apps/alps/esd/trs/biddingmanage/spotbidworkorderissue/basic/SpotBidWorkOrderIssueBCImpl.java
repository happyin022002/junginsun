/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpotBidWorkOrderIssueBCImpl.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 유선오
*@LastVersion : 1.5
* 2006-11-21 poong_yeon
* 1.0 최초 생성
*                 1.1 N200901090011 W/O Issue 화면 보완요청
* 2010.09.09 이재위 1.2[SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 2011.02.10 민정호 1.3[CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.07.14 김영철 1.4[CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.12.29 유선오 1.5[CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.01.03 유선오 1.6[CHM-201115242] R4J품질결함수정 -LineNo.458:catch 구문의 SQLException 선언 순서를 점검한다.-sqlException 을 제거, daoException유지 Exception을 추가
* 2012.12.11 이재위 1.7 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event.EsdTrs0091Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0963Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0980Event;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration.SpotBidWorkOrderIssueDBDAO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo.SpotBidWoIssueListVO;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


   
/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @param <SpotBidWoIssueListVO>
 * @see ESD_TRS_0091EventResponse,WorkOrderIssueBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SpotBidWorkOrderIssueBCImpl extends BasicCommandSupport implements SpotBidWorkOrderIssueBC {

	// Database Access Object
	private transient SpotBidWorkOrderIssueDBDAO dbDao=null;

	/**
	 * SpotBidWorkOrderIssueBCImpl 객체 생성<br>
	 * SpotBidWorkOrderIssueDBDAO를 생성한다.<br>
	 */
	public SpotBidWorkOrderIssueBCImpl(){
		dbDao = new SpotBidWorkOrderIssueDBDAO();
	}

	/**
	 * FRUSTRATE에 대한 처리.<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse setFrustrate(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		try {
			ArrayList returnList = dbDao.setFrustrate(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(returnList);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Appointment/Delivery Time 저장 처리.<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse setAppDeli(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		try {
			ArrayList returnList = dbDao.setAppDeli(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(returnList);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Curr Code / Nego Amt 저장 처리.<br>
	 * WorkOrderIssue화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCurrNego(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		try {
			ArrayList returnList = dbDao.modifyCurrNego(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(returnList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueList(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
//		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			GeneralEventResponse eventResponse = null;			
			eventResponse = dbDao.searchWorkOrderIssueList(event);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		
		try {
			return dbDao.searchWorkOrderIssueBySoNo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSelectList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0091Event event=(EsdTrs0091Event)e;
//		ArrayList returnList = null;
//		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {	
			return dbDao.searchSpSelectList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.searchLocalCurr2UsdCurr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			if(rowSet.next()){
				eventResponse.setETCData("amt_usd", rowSet.getString("WO_TOT_AMT_USD"));
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
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMoreCandidates(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0921Event event=(EsdTrs0921Event)e;
		try {
			rowSet=dbDao.searchMoreCandidates(event);
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
	 * S/P Select 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EsdTrs0921EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0921Event event=(EsdTrs0921Event)e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet=dbDao.searchMdmOrganization(event);
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01)){
					eventResponse.setETCData("bil_curr_cd", rowSet.getString("BIL_CURR_CD"));
					eventResponse.setETCData("conti_cd", rowSet.getString("CONTI_CD"));
					
				}
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
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param woVO
	 * @return 
	 * @exception EventException
	 */
	public ArrayList searchSurchargeList(List<SpotBidWoIssueListVO> woVO) throws EventException {
//		EsdTrs0091Event event=(EsdTrs0091Event)e;
//		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		try {
			return dbDao.searchSurchargeList(woVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param scgRs
	 * @return 	
	 * @exception EventException
	 */
	public ArrayList searchSurchargeList(DBRowSet scgRs) throws EventException {
		
		try {
			return dbDao.searchSurchargeList(scgRs);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE BILLING CASE 목록을 가져온다.<br>
	 * 
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBillingCaseCode() throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String bil_cs_cd = "";
		String bil_cs_nm = "";
		StringBuffer sbBilCsCd = new StringBuffer();
		StringBuffer sbBilCsNm = new StringBuffer();
			
		try {
			rowSet=dbDao.searchBillingCaseCode();
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSet.next()){
//				소스품질 결함 사항 수정 2014.05.22 SHIN DONG IL
//				bil_cs_cd = bil_cs_cd + "|"+rowSet.getString("N3PTY_BIL_TP_CD");
//				bil_cs_nm = bil_cs_nm + "|"+rowSet.getString("N3PTY_BIL_TP_NM");
				sbBilCsCd.append("|"+rowSet.getString("N3PTY_BIL_TP_CD"));
				sbBilCsNm.append("|"+rowSet.getString("N3PTY_BIL_TP_NM"));
			}
			bil_cs_cd = sbBilCsCd.toString();
			bil_cs_nm = sbBilCsNm.toString();
			
			eventResponse.setETCData("bil_cs_cd", bil_cs_cd);
			eventResponse.setETCData("bil_cs_nm", bil_cs_nm);
			
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
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTpbBasicAmt(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchTpbBasicAmt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
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
	
	/*
     * 1.15 N200901090011 W/O Issue 화면 보완요청
	 */
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0091EventResponse
	 * @exception EventException
	 */

	public EventResponse searchWoIssuedSoList(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchWoIssuedSoList(event);
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
	 * ESD_TRS_0963 화면에 대한 조회 이벤트 처리 ( Bundling List 조회 )<br>
	 * 
	 * @param e ESD_TRS_0963Event
	 * @return List<BundlingListVO>
	 * @exception EventException
	 */
	public List<BundlingListVO> searchBundlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0963Event event=(EsdTrs0963Event)e;
		try {

			return dbDao.searchBundlingList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Bundling ( 저장 ) 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 조회 이벤트 처리 ( Bundling 저장 )<br>
	 *
	 * @param BundlingListVO[] bundlingListVO
	 * @param SignOnUserAccount account
	 * @param String gpYn
	 * @exception EventException
	 */
	public void setBundling(BundlingListVO[] bundlingListVO, SignOnUserAccount account, String gpYn) throws EventException{
		List<BundlingListVO> updateVoList = new ArrayList<BundlingListVO>();
		try {
			for ( int i=0; i<bundlingListVO.length; i++ ) {
				updateVoList.add(bundlingListVO[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.setBundling(account.getUsr_id(), updateVoList, gpYn);
			}
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면 가기 전에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewStatusCheck(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		EsdTrs0091Event event=(EsdTrs0091Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchWorkOrderPreviewStatusCheck(event);			
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH07)){
				if(rowSet.next()){		
					eventResponse.setETCData("checkSoNo",  rowSet.getString("CHECK_SO_NO"));					
				}
			}
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
	 * 조회 이벤트 처리<br>
	 * More CNT Candidate화면 가기 전에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCntMoreCandidates(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		EsdTrs0980Event event=(EsdTrs0980Event) e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchCntMoreCandidates(event);			
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
	 * ReRate Apply 처리<br>
	 * ESD_TRS_0091 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReRateApplyList(Event e) throws EventException {
		EsdTrs0091Event event=(EsdTrs0091Event)e;

		try {
			return dbDao.searchReRateApplyList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ReRate Apply 처리<br>
	 * ESD_TRS_0091 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0091Event
	 * @return EventResponse ESD_TRS_0091EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMoreBidder(Event e) throws EventException {

		EsdTrs0091Event event=(EsdTrs0091Event)e;
		DBRowSet rowSet=null;

		try {
			rowSet =  dbDao.searchMoreBidder(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
		
	
	/**
	 * workordermanage 업무 시나리오 마감작업<br>
	 * WorkOrderIssue업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
