/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderPreviewBCImpl.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.08
*@LastModifier : 최 선
*@LastVersion : 1.48
* 2006.12.06 poong_yeon
* 1.0 최초 생성
* 1.86 N200901220021-[EDI] 구주 SK155153 IFTMIN 개발 요청
* 1.97 N200904300130 - [EDI-TRS] DANSER (S/P # 175368) Work order EDI (IFTMIN) 개발 요청
* 1.41 2010.10.13 이재위 [CHM-201006281-01] [TRS] VLCBB EDI(IFTMIN) 개발
* 1.41 2010.11.29 이재위 [CHM-201007047-01] [TRS] EDI/RD DANGER CGO 관련 조회 수정건
* 1.42 2011.03.31 손은주 [CHM-201109814-01] [TRS] W/O EDI 사용을 위한 setting 요청 (115133)
* 1.45 2011.04.13 김영철 [CHM-201110137-01] [TRS] W/O EDI 환경 구현 요청 (114745)
* 1.46 2011.07.11 최종혁 [CHM-201112197] [TRS] 구주지역 W/O EDI setting 요청  (184332)
* 1.47 2011.11.29 민정호 [CHM-201114404] [TRS] 구주 S/P EDI F/F receiver ID coding 요청
* 1.48 2012.03.08 최 선   [] [TRS] W/O Preview, edi 발송시, Container 상세 정보 추가 조회 및 발송
* 2013.02.26 조인영 [CHM-201323086] W/O Issue - Preview - confirm 시 Inv No 존재하면 confirm 불가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.basic;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration.WorkOrderPreviewDBDAO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration.WorkOrderPreviewEAIDAO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_024EventResponse,WorkOrderPreviewBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderPreviewBCImpl   extends BasicCommandSupport implements WorkOrderPreviewBC {

	// Database Access Object
	private transient WorkOrderPreviewDBDAO dbDao=null;
	private transient WorkOrderPreviewEAIDAO eaiDao=null;
	
	
	/**
	 * WorkOrderPreviewBCImpl 객체 생성<br>
	 * WorkOrderPreviewDBDAO를 생성한다.<br>
	 */
	public WorkOrderPreviewBCImpl(){
		dbDao = new WorkOrderPreviewDBDAO();
		eaiDao = new WorkOrderPreviewEAIDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return SingleTransportationVO[]
	 * @exception EventException
	 */
	public SingleTransportationVO[] searchDeleteSoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;

		try {
			return dbDao.searchDeleteSoList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchWoNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchWoNo(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEdiInquiryList(Event e) throws EventException {

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet = null;

		try {
			rowSet=dbDao.searchEdiInquiryList(event);
			
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
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return 
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreview(Event e, SignOnUserAccount account) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet 			= null;
		TPBInterfaceVO[] models 	= null;
		TPBInterfaceVO[] models1 	= null;
		ArrayList  ffList   		= null;
		ArrayList tempA 			= null;

		try {
			rowSet = dbDao.addWorkOrderPreview(event);
			ffList = addWorkOrderPreviewCommon(event);
			if(ffList == null) ffList = new ArrayList();
			tempA = addWorkOrderPreview317Snd(event);
			if(tempA != null) ffList.addAll(tempA);
			
			/* TRS-TPB IF */		
			models1 = dbDao.searchTrs3PtyIFList(event);	

			if( null != models1 && models1.length > 0){
				TPBInterfaceBCImpl tbpIF 	= new TPBInterfaceBCImpl();
				models = dbDao.searchTrs3PtyIF(event);
				tbpIF.createTRSTPB	(models, account);
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return ffList;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewIssued(Event e, SignOnUserAccount account) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet = null;
		
		TPBInterfaceVO[] models 	= null;
		TPBInterfaceVO[] models1 	= null;
		TPBInterfaceVO[] models2 	= null;
		ArrayList  ffList   = null;
		ArrayList  tempA    = null;
		
		try {						
			TrsTrspWrkOrdVO	wrkOrdVO 		= event.getTrsTrspWrkOrdVO();
			WorkOrderPreviewVO wrkPrvVO  	= event.getWorkOrderPreviewVO();
			
			if( wrkPrvVO.getContiCd() == null || "".equals(wrkPrvVO.getContiCd())){
				rowSet = dbDao.searchContiCd(event);
				while(rowSet.next()){
					wrkPrvVO.setContiCd(rowSet.getString("conti_cd"));
				}
				event.setWorkOrderPreviewVO(wrkPrvVO);
			}
			
			if("N".equals(wrkOrdVO.getWoIssStsCd()) && "M".equals(wrkPrvVO.getContiCd())){
				ffList = addWorkOrderPreviewCommon(event);
				rowSet = dbDao.addWorkOrderPreviewIssued(event);			
			}else if("C".equals(wrkOrdVO.getWoIssStsCd()) && "M".equals(wrkPrvVO.getContiCd())){
				ffList = addWorkOrderPreviewCommon(event);
				rowSet = dbDao.addWorkOrderPreviewIssued(event);				
				if(ffList == null) ffList = new ArrayList();
				
				tempA = addWorkOrderPreviewCommonSnd(event);
				if (tempA!=null)  ffList.addAll(tempA);
			}else{
				rowSet = dbDao.addWorkOrderPreviewIssued(event);
				ffList = addWorkOrderPreviewCommon(event);
			}
			
			/* TRS-TPB IF */	
			models1 = dbDao.searchTrs3PtyIFList(event);	
			if( (null!=models1) && (models1.length > 0) ){

				TPBInterfaceBCImpl tbpIF 	= new TPBInterfaceBCImpl();			
				models2 = dbDao.searchTrs3PtyIFCxl(event);	
				tbpIF.createTRSTPB	(models2, account);
		
				models = dbDao.searchTrs3PtyIF(event);			
				tbpIF.createTRSTPB	(models, account);
			}
		} catch (SQLException ee) {
            log.error("err " + ee.toString(), ee);
            throw new EventException(ee.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return ffList;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @exception EventException
	 */
	public void resendEDIAsia(Event e) throws EventException {
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		String[]ffList = null;
		DBRowSet rowSet 		= null;
		String vndrSeq 			= null;
		String woEdiUseFlg 		= null;
		String ediRcvrNmUseFlg 	= null;
		String soCreOfcCd 		= null;
		String trspBndCd 		= null;
//		TrsTrspWrkOrdPrvTmpVO tmVO = event.getTrsTrspWrkOrdPrvTmpVO();
//		TrsTrspWrkOrdVO troVO = event.getTrsTrspWrkOrdVO();
		try {

			rowSet = dbDao.searchEdiResendList(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();

			while(rowSet.next()){	
				
				vndrSeq = rowSet.getString("vndr_seq");
				woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				soCreOfcCd = rowSet.getString("so_cre_ofc_cd");
				trspBndCd = rowSet.getString("trsp_bnd_cd");

				if(vndrSeq != null && vndrSeq.equals("100253") ){
					woVO.setEdiLoc("ASIA");
				}else if(vndrSeq != null && ((vndrSeq.equals("105121") || vndrSeq.equals("105147") 
						|| vndrSeq.equals("135366")|| vndrSeq.equals("155153")|| vndrSeq.equals("175368") || vndrSeq.equals("115133") || 
						   vndrSeq.equals("114745")|| vndrSeq.equals("184332")|| vndrSeq.equals("157955")|| vndrSeq.equals("105055")) ||
						// 2010.09.29 11개 S/P 추가(VLCBB)+2개 S/P추가  -VLCBB삭제
						((vndrSeq.equals("120759") || vndrSeq.equals("120852") || vndrSeq.equals("121403") 
						|| vndrSeq.equals("125140") || vndrSeq.equals("166660") || vndrSeq.equals("168242") 
						|| vndrSeq.equals("172121") || vndrSeq.equals("143046") || vndrSeq.equals("166697") 
						|| vndrSeq.equals("120849") || vndrSeq.equals("181404") || vndrSeq.equals("186225") || vndrSeq.equals("186226"))) )){
					woVO.setEdiLoc("EUR");
				}else if("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y") && ediRcvrNmUseFlg.equals("Y")){
					woVO.setEdiLoc("USA");
				}
				
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setWoEdiUseFlg(rowSet.getString("WO_EDI_USE_FLG"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(trspBndCd);
				event.setWorkOrderPreviewVO(woVO);
			
			}
			ffList = sendFlatFile(event);
			sendFlatMessage(ffList[1], ffList[2]);
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @exception EventException
	 */
	public void resendEDIEur(Event e) throws EventException {
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		String[]ffList = null;
		DBRowSet rowSet 		= null;
		String vndrSeq 			= null;
		String woEdiUseFlg 		= null;
		String ediRcvrNmUseFlg 	= null;
		String soCreOfcCd 		= null;
		String trspBndCd 		= null;
//		TrsTrspWrkOrdPrvTmpVO tmVO = event.getTrsTrspWrkOrdPrvTmpVO();
//		TrsTrspWrkOrdVO troVO = event.getTrsTrspWrkOrdVO();
		try {

			rowSet = dbDao.searchEdiResendList(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();

			while(rowSet.next()){	
				
				vndrSeq = rowSet.getString("vndr_seq");
				woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				soCreOfcCd = rowSet.getString("so_cre_ofc_cd");
				trspBndCd = rowSet.getString("trsp_bnd_cd");

				if(vndrSeq != null && vndrSeq.equals("100253") ){
					woVO.setEdiLoc("ASIA");
				}else if(vndrSeq != null && ((vndrSeq.equals("105121") || vndrSeq.equals("105147") 
						|| vndrSeq.equals("135366")|| vndrSeq.equals("155153")|| vndrSeq.equals("175368")|| vndrSeq.equals("115133") || 
						   vndrSeq.equals("114745")|| vndrSeq.equals("184332")|| vndrSeq.equals("157955")|| vndrSeq.equals("105055")) ||
						// 2010.09.29 11개 S/P 추가(VLCBB)+2개 S/P추가  -VLCBB삭제
						((vndrSeq.equals("120759") || vndrSeq.equals("120852") || vndrSeq.equals("121403") 
						|| vndrSeq.equals("125140") || vndrSeq.equals("166660") || vndrSeq.equals("168242") 
						|| vndrSeq.equals("172121") || vndrSeq.equals("143046") || vndrSeq.equals("166697") 
						|| vndrSeq.equals("120849") || vndrSeq.equals("181404") || vndrSeq.equals("186225") || vndrSeq.equals("186226"))) )){
					woVO.setEdiLoc("EUR");
				}else if("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y") && ediRcvrNmUseFlg.equals("Y")){
					woVO.setEdiLoc("USA");
				}
				
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setWoEdiUseFlg(rowSet.getString("WO_EDI_USE_FLG"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(trspBndCd);
				event.setWorkOrderPreviewVO(woVO);
			}
				ffList = sendFlatFile(event);
				sendFlatMessage(ffList[1], ffList[2]);
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssueStatus(Event e) throws EventException {

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderPreviewIssueStatus(event);			
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
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException {

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderPreviewIssuedGroup(event);			
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
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException {

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderPreviewGroup(event);			
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
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEdiSendingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchEdiSendingList(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException {
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchSODeleteCheck(event);
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
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchBkgCancelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchBkgCancelList(event);
			return rowSet;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void addFaxAndEmailNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event=(EsdTrs0024Event)e;

		try {
			dbDao.addFaxAndEmailNo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/*
	 * N200901220021-[EDI] 구주 SK155153 IFTMIN 개발 요청
	 * N200904300130 - [EDI-TRS] DANSER (S/P # 175368) Work order EDI (IFTMIN) 개발 요청
	 * N200904300130 - [EDI] VLCBB Work order EDI (IFTMIN) 개발 요청
	 */
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewCommon(Event e) throws EventException {
		
		EsdTrs0024Event event 	= (EsdTrs0024Event)e;
		DBRowSet rowSet 		= null;
		String vndrSeq 			= null;
		String woEdiUseFlg 		= null;
		String ediRcvrNmUseFlg 	= null;
		String soCreOfcCd 		= null;
		String trspBndCd 		= null;
		ArrayList ffList 		= null;
		
		try{
			rowSet = dbDao.searchSoByPrvTmp(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();

			while(rowSet.next()){	
				
				vndrSeq = rowSet.getString("vndr_seq");
				woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				soCreOfcCd = rowSet.getString("so_cre_ofc_cd");
				trspBndCd = rowSet.getString("trsp_bnd_cd");

				if(vndrSeq != null && vndrSeq.equals("100253") ){
					woVO.setEdiLoc("ASIA");
				}else if(vndrSeq != null && ((vndrSeq.equals("105121") || vndrSeq.equals("105147") 
						|| vndrSeq.equals("135366")|| vndrSeq.equals("155153")|| vndrSeq.equals("175368")|| vndrSeq.equals("115133") 
						|| vndrSeq.equals("114745")|| vndrSeq.equals("184332")|| vndrSeq.equals("157955")|| vndrSeq.equals("105055")) ||
						// 2010.09.29 11개 S/P 추가(VLCBB)+2개 S/P추가  -VLCBB삭제
						((vndrSeq.equals("120759") || vndrSeq.equals("120852") || vndrSeq.equals("121403")						
						|| vndrSeq.equals("125140") || vndrSeq.equals("166660") || vndrSeq.equals("168242") 
						|| vndrSeq.equals("172121") || vndrSeq.equals("143046") || vndrSeq.equals("166697") 
						|| vndrSeq.equals("120849") || vndrSeq.equals("181404") || vndrSeq.equals("186225") || vndrSeq.equals("186226") )) )){ 
					woVO.setEdiLoc("EUR");
				}else if("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y") && ediRcvrNmUseFlg.equals("Y")){
					woVO.setEdiLoc("USA");
				}
				
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setContiCd(rowSet.getString("conti_cd"));
				woVO.setSoCreOfcCd(rowSet.getString("so_cre_ofc_cd"));
				woVO.setTrspBndCd(rowSet.getString("trsp_bnd_cd"));
				
				event.setWorkOrderPreviewVO(woVO);
				
				if (ffList == null) ffList = new ArrayList(); 
				
				if("USA".equals(woVO.getEdiLoc())){
					ffList.add(sendUsaFlatFile(event));
				}else if("ASIA".equals(woVO.getEdiLoc()) || "EUR".equals(woVO.getEdiLoc())){
					ffList.add(sendFlatFile(event));	
				}				
				if(vndrSeq != null && vndrSeq.equals("100253") ) break;
			}
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return ffList;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public ArrayList addWorkOrderPreviewCommonSnd(Event e) throws EventException {
		
		EsdTrs0024Event event 	= (EsdTrs0024Event)e;
		DBRowSet rowSet 		= null;
		String vndrSeq 			= null;
		String woEdiUseFlg 		= null;
		String ediRcvrNmUseFlg  = null;
		ArrayList ffList 		= null;


		try{
			rowSet = dbDao.searchSoByPrvTmpSnd(event);
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			
			while(rowSet.next()){
				vndrSeq 		= rowSet.getString("vndr_seq");
				woEdiUseFlg 	= rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				
				vndrSeq = rowSet.getString("vndr_seq");
				woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
				ediRcvrNmUseFlg = rowSet.getString("edi_rcvr_nm_use_flg");
				
				if("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y") && ediRcvrNmUseFlg.equals("Y")){
					woVO.setEdiLoc("USA");
				}
				
				woVO.setEdiTrspSoOfcCtyCd(rowSet.getString("trsp_so_ofc_cty_cd"));
				woVO.setEdiTrspSoSeq(rowSet.getString("trsp_so_seq"));
				woVO.setEdiTrspWoOfcCtyCd(rowSet.getString("trsp_wo_ofc_cty_cd"));
				woVO.setEdiTrspWoSeq(rowSet.getString("trsp_wo_seq"));
				woVO.setEdiWoIssStsCd(rowSet.getString("wo_iss_sts_cd"));
				woVO.setEdiVndrSeq(vndrSeq);
				woVO.setTrspCrrModCd(rowSet.getString("trsp_crr_mod_cd"));
				woVO.setTrspCostDtlModCd(rowSet.getString("trsp_cost_dtl_mod_cd"));
				woVO.setEdiEqNo(rowSet.getString("eq_no"));
				woVO.setEdiRcvrNm(rowSet.getString("edi_rcvr_nm"));
				woVO.setContiCd(rowSet.getString("conti_cd"));
				
				event.setWorkOrderPreviewVO(woVO);
				
				if (ffList == null) ffList = new ArrayList(); 
				
				if("USA".equals(woVO.getEdiLoc())){
					ffList.add(sendUsaFlatFile(event));
				}
			}
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return ffList;
	}
	
	/**
	 * Flat file 전송하기<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String[] sendFlatFile(Event e) throws EventException {

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();

		String vndrSeq = null;
		String costMod = null;
		String crrMod = null;
		String fileNo = "1";
		String woEdiUseFlg = null;
		String trspWoOfcCtyCd = null;
		String ediLoc = null;
		String woIssStsCd = null;

		trspWoOfcCtyCd 	= woVO.getEdiTrspWoOfcCtyCd();
		woEdiUseFlg 	= woVO.getWoEdiUseFlg();
		ediLoc 			= woVO.getEdiLoc();
		woIssStsCd 		= woVO.getEdiWoIssStsCd();
		if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI")) return null;

		String[] returnArray = new String[3];
		returnArray[0] = "EUR_ASIA";
		try {
			
			vndrSeq = woVO.getEdiVndrSeq();
			crrMod = woVO.getTrspCrrModCd();
			costMod = woVO.getTrspCostDtlModCd();
			if( woIssStsCd != null && woIssStsCd.equals("N")){
				if(vndrSeq != null && (vndrSeq.equals("100253")) && 
						crrMod != null && crrMod.equals("WD") && 
						costMod != null && costMod.equals("CY")){
					fileNo = "6";
				}else if(vndrSeq != null && vndrSeq.equals("100253") && 
						costMod != null && costMod.equals("DR")){
					fileNo = "5";
				}else if(vndrSeq != null && vndrSeq.equals("100253") ){
					fileNo = "4";
				}
			}else{
				if(vndrSeq != null && vndrSeq.equals("100253") && 
						crrMod != null && crrMod.equals("WD") && 
						costMod != null && costMod.equals("CY")){
					fileNo = "3";
				}else if(vndrSeq != null && vndrSeq.equals("100253") && 
						costMod != null && costMod.equals("DR")){
					fileNo = "2";
				}else if(vndrSeq != null && vndrSeq.equals("100253") ){
					fileNo = "1";
				}
			}
			if(vndrSeq != null && 
					(vndrSeq.equals("105147") || 
					vndrSeq.equals("155153") || 
					vndrSeq.equals("135366") || 
					vndrSeq.equals("105121") ||
					vndrSeq.equals("115133") ||
					vndrSeq.equals("105055") ||
					// 2010.09.29 11개 S/P 추가(VLCBB)
					vndrSeq.equals("120759") ||
					vndrSeq.equals("120852") ||
					vndrSeq.equals("121403") ||
					vndrSeq.equals("125140") ||
					vndrSeq.equals("166660") ||
					vndrSeq.equals("168242") ||
					vndrSeq.equals("172121") ||
					vndrSeq.equals("143046") ||
					vndrSeq.equals("166697") ||
					vndrSeq.equals("120849") ||
					vndrSeq.equals("181404") || 
					vndrSeq.equals("186225") || 
					vndrSeq.equals("186226") )){
				woVO.setFltFileNo(fileNo);
				woVO.setEdiFltCd("105147");
				event.setWorkOrderPreviewVO(woVO);
				returnArray[1] = makeFlatFile(event);	
				returnArray[2] = woVO.getEdiFltCd();
			} 
			if(vndrSeq != null && 
					(vndrSeq.equals("175368") ||
					 vndrSeq.equals("114745") ||
					 vndrSeq.equals("184332") ||
					 vndrSeq.equals("157955")
					 )){
				woVO.setFltFileNo(fileNo);
				woVO.setEdiFltCd("175368");
				event.setWorkOrderPreviewVO(woVO);
				returnArray[1] = makeFlatFile(event);	
				returnArray[2] = woVO.getEdiFltCd();
			} 
			if(vndrSeq != null && 
					vndrSeq.equals("100253") ){ //SP Code changes from 102297 to 100253
				woVO.setFltFileNo(fileNo);
				woVO.setEdiFltCd("100253");
				event.setWorkOrderPreviewVO(woVO);
				returnArray[1] = makeFlatFile(event);	
				returnArray[2] = woVO.getEdiFltCd();
			} 

		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return returnArray;
	}
	
	/**
	 * Flat file 전송하기<br>
	 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String[] sendUsaFlatFile(Event e) throws EventException {
		
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		
		String vndrSeq 			= null;
		String costMod 			= null;
		String crrMod 			= null;
		String woEdiUseFlg 		= null;
		String trspWoOfcCtyCd 	= null;
		String ediLoc 			= null;
		String woIssStsCd	 	= null;
		
		WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
		
		trspWoOfcCtyCd 		= woVO.getEdiTrspSoOfcCtyCd();
		woEdiUseFlg 		= woVO.getWoEdiUseFlg();
		ediLoc 				= woVO.getEdiLoc();
		woIssStsCd 			= woVO.getEdiWoIssStsCd();

		if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI")) return null;

		String[] returnArray = new String[3];
		returnArray[0] = "USA";
		
		try {
			vndrSeq = woVO.getEdiVndrSeq();
			crrMod 	= woVO.getTrspCrrModCd();
			costMod = woVO.getTrspCostDtlModCd();
			woVO.setEdiVndrSeq(vndrSeq);			
			event.setWorkOrderPreviewVO(woVO);
			returnArray[1] = makeUsaFlatFile(event);	
			returnArray[2] = vndrSeq;

	
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return returnArray;
	}

	/**
	 * Flat File 만들기<br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String makeFlatFile(Event e) throws EventException {
		
		StringBuffer contents 		= new StringBuffer();
		StringBuffer etcTag 		= new StringBuffer();

		DBRowSet layOutRowSet 		= null;
		ArrayList fltCdArray 		= new ArrayList();
		ArrayList colNmArray		= new ArrayList();
		ArrayList colSeqArray 		= new ArrayList();
		ArrayList colLvlArray 		= new ArrayList();
		ArrayList colKndCdArray 	= new ArrayList();
		ArrayList colLenArray 		= new ArrayList();
		HashMap contentsHashMap 	= new HashMap();
		HashMap resultArrayHashMap 	= new HashMap();

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		
		WorkOrderPreviewVO woPrvVO = event.getWorkOrderPreviewVO();
		String fltCd = null;
		String colNm = null;
		String startKey = null;
		String colKndCd = null;
		int curLevel = 0;
		int startLevel = 0;

		try{
			layOutRowSet = dbDao.searchEdiLayoutList(event);

			/*
			 * FLT_KEY_KND -ET(ETC), HD(Header), NR(Normal), OT(Open Tag), CT(CLOSE TAG)
			 * ET - DB COLUMN명으로 전환될수 없는 TAG
			 * HD - OPEN TAG가 아니지만 LEVEL이 시작되는 COLUMN인경우로 DATA가 있는 TAG다
			 * OT - OPEN TAG로 DATA없이 TAG명만 파일에 추가된다.
			 * CT - CLOSE TAG로 DATA없이 TAG명만 파일에 추가된다.
			 * NR - NORMAL TAG로 DATA가 있는 일반 TAG이다.
			 */
			
			while(layOutRowSet.next()){
				colKndCd 	= layOutRowSet.getString("col_knd_cd");
				colNm 		= layOutRowSet.getString("col_nm");
				fltCd 		= woPrvVO.getEdiVndrSeq()+"_"+layOutRowSet.getString("flt_file_no");
//				fltCd 		= layOutRowSet.getString("edi_vndr_seq")+"_"+layOutRowSet.getString("flt_file_no");
				colNm 		= (colNm != null ? colNm.toUpperCase() : colNm);

				fltCdArray.add(fltCd);
				colNmArray.add(colNm);
				colSeqArray.add(layOutRowSet.getString("col_seq"));
				colLvlArray.add(layOutRowSet.getString("col_lvl"));
				colKndCdArray.add(colKndCd);
				colLenArray.add(layOutRowSet.getString("col_len"));
				
				if(colKndCd != null && colKndCd.equals("ET")) {
					etcTag.append(getFlatDataETC(fltCd,colNm, event));
				}
				
				if(colKndCd != null && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
					if(startKey == null) {
						startKey = colNm;
						startLevel = Integer.parseInt(layOutRowSet.getString("col_lvl"));
					}
					contentsHashMap.put(colNm, getRowset2ArrayList(getFlatDataRowSet(fltCd,colNm,event)));
				}
			}
			
			contents.append(etcTag);
			resultArrayHashMap.put("flt_cd"		, fltCdArray		);
			resultArrayHashMap.put("col_nm"		, colNmArray		);
			resultArrayHashMap.put("col_seq"	, colSeqArray		);
			resultArrayHashMap.put("col_lvl"	, colLvlArray		);
			resultArrayHashMap.put("col_knd"	, colKndCdArray	);
			resultArrayHashMap.put("col_len"	, colLenArray		);
			
			String rpKeyValue = null;
			
			for(int i=0; i< colNmArray.size(); i++){
				curLevel = Integer.parseInt( (String) colLvlArray.get(i));
				colNm = rmNull((String) colNmArray.get(i));
				colKndCd = rmNull((String) colKndCdArray.get(i));
				rpKeyValue = JSPUtil.replace(JSPUtil.replace(colNm, "{", ""), "}", "");
				if(curLevel==startLevel && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
					contents.append(getContents(contentsHashMap, resultArrayHashMap, colNm, i));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 

		return contents.toString();
	}
	
	/**
	 * Flat File 만들기<br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param e
	 * @return contents String
	 * @exception EventException
	 */
	public String makeUsaFlatFile(Event e) throws EventException {
		
		StringBuffer contents 		= new StringBuffer();
		StringBuffer etcTag 		= new StringBuffer();

		DBRowSet layOutRowSet 		= null;
		ArrayList fltCdArray 		= new ArrayList();
		ArrayList colNmArray		= new ArrayList();
		ArrayList colSeqArray 		= new ArrayList();
		ArrayList colLvlArray 		= new ArrayList();
		ArrayList colKndCdArray 	= new ArrayList();
		ArrayList colLenArray 		= new ArrayList();
		HashMap contentsHashMap 	= new HashMap();
		HashMap resultArrayHashMap 	= new HashMap();

		EsdTrs0024Event event=(EsdTrs0024Event)e;
		
		String fltCd = null;
		String colNm = null;
		String startKey = null;
		String colKndCd = null;
		int curLevel = 0;
		int startLevel = 0;

		try{
			layOutRowSet = dbDao.searchUsaEdiLayoutList();

			/*
			 * FLT_KEY_KND -ET(ETC), HD(Header), NR(Normal), OT(Open Tag), CT(CLOSE TAG)
			 * ET - DB COLUMN명으로 전환될수 없는 TAG
			 * HD - OPEN TAG가 아니지만 LEVEL이 시작되는 COLUMN인경우로 DATA가 있는 TAG다
			 * OT - OPEN TAG로 DATA없이 TAG명만 파일에 추가된다.
			 * CT - CLOSE TAG로 DATA없이 TAG명만 파일에 추가된다.
			 * NR - NORMAL TAG로 DATA가 있는 일반 TAG이다.
			 */
			while(layOutRowSet.next()){
				
				colKndCd 	= layOutRowSet.getString("col_knd_cd");
				colNm 		= layOutRowSet.getString("col_nm");
				fltCd 		= "999999";
				colNm 		= (colNm != null ? colNm.toUpperCase() : colNm);
				fltCdArray.add(fltCd);
				colNmArray.add(colNm);
				colSeqArray.add(layOutRowSet.getString("flt_file_ut_seq"));
				colLvlArray.add(layOutRowSet.getString("col_lvl"));
				colKndCdArray.add(colKndCd);
				colLenArray.add(layOutRowSet.getString("col_len"));
				
				if(colKndCd != null && colKndCd.equals("ET")) {
					etcTag.append(getUsaFlatDataETC(fltCd, colNm, event));
				}
				
				if(colKndCd != null && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
					if(startKey == null) {
						startKey = colNm;
						startLevel = Integer.parseInt(layOutRowSet.getString("col_lvl"));
					}
					contentsHashMap.put(colNm, getUsaRowset2ArrayList(getUsaFlatDataRowSet(fltCd, colNm, event), colNm));
				}
			}
			
			contents.append(etcTag);
			resultArrayHashMap.put("flt_cd"		, fltCdArray);
			resultArrayHashMap.put("col_nm"		, colNmArray);
			resultArrayHashMap.put("col_seq"	, colSeqArray);
			resultArrayHashMap.put("col_lvl"	, colLvlArray);
			resultArrayHashMap.put("col_knd"	, colKndCdArray	);
			resultArrayHashMap.put("col_len"	, colLenArray);
			
			String rpKeyValue = null;
			
			for(int i=0; i< colNmArray.size(); i++){
				curLevel = Integer.parseInt( (String) colLvlArray.get(i));
				colNm = rmNull((String) colNmArray.get(i));
				colKndCd = rmNull((String) colKndCdArray.get(i));
				rpKeyValue = JSPUtil.replace(JSPUtil.replace(colNm, "{", ""), "}", "");
				if(curLevel==startLevel && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
					contents.append(getContents(contentsHashMap, resultArrayHashMap, colNm, i));
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return contents.toString();
	}
	
	/**
	 * Flat File의 CONTENTS 만들기<br>
	 * EDI에 전송할 Flat CONTENTS 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String getContents(HashMap contentsHashMap,  
			HashMap resultArrayHashMap, String key, int startIndex){
		
		StringBuffer contents = new StringBuffer();
		ArrayList colNmArray = (ArrayList) resultArrayHashMap.get("col_nm");
		ArrayList col_kndArray = (ArrayList) resultArrayHashMap.get("col_knd");
		ArrayList colLvlArray = (ArrayList) resultArrayHashMap.get("col_lvl");
		ArrayList colLenArray = (ArrayList) resultArrayHashMap.get("col_len");
		String keyValue = null;
		String keyKnd = null;
		String keyLvl = null;
		String rpKeyValue = null;
		String rpKey = null;
		String curLvl = null;
		int colLen = 0;
		
		int curLvlInt = 0;
		int keyLvlInt = 0;
		
		ArrayList contentsArray = (ArrayList) contentsHashMap.get(key);
		keyLvl = (String) colLvlArray.get(startIndex);
		HashMap dataHashMap = null;
		StringBuffer logb = null; 
		for(int i=0;contentsArray!=null &&  i<contentsArray.size(); i++ ){
			dataHashMap = (HashMap) contentsArray.get(i);
			
			for(int k=startIndex; k<colNmArray.size(); k++ ){
				curLvl = (String) colLvlArray.get(k);
				keyValue = rmNull((String) colNmArray.get(k));
				keyKnd = rmNull((String) col_kndArray.get(k));
				colLen = rmNull2Int((String) colLenArray.get(k));

				rpKeyValue = JSPUtil.replace(JSPUtil.replace(JSPUtil.replace(keyValue, "{", ""), "}", ""), ":", "");
				rpKey = JSPUtil.replace(JSPUtil.replace(JSPUtil.replace(key, "{", ""), "}", ""), ":", "");
				curLvlInt = Integer.parseInt(curLvl);
				keyLvlInt = Integer.parseInt(keyLvl);
				logb = new StringBuffer();
				if(rpKeyValue.equals(rpKey) && keyKnd.equals("OT")){
					contents.append(keyValue);
					contents.append("\n");
				}else if(keyLvl.equals(curLvl) && keyKnd.equals("CT")){
					contents.append(keyValue);
					contents.append("\n");
				}else if(keyLvl.equals(curLvl) && keyKnd.equals("NR")||keyKnd.equals("HD")){
					contents.append(keyValue);
					contents.append(rpad(rmNull((String)dataHashMap.get(rpKeyValue)), colLen, " "));
					contents.append("\n");
				}
				
				if((curLvlInt-keyLvlInt)==1 && !rpKeyValue.equals(rpKey) && keyKnd.equals("OT")){
					contents.append(getContents(contentsHashMap,resultArrayHashMap,keyValue, k));
				}else if(keyLvl.equals(curLvl) && keyKnd.equals("CT")){
					break;
				}
			}
		}
		return contents.toString();
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public ArrayList getRowset2ArrayList(DBRowSet rowSet) throws EventException {
		
		ArrayList returnArrayList = null;
		String colName = null;
		String colValue = null;
		int cnt = 0;
		
		try{
			if (rowSet!=null) {
				returnArrayList = new ArrayList();
				while(rowSet.next()){
					cnt++;
					HashMap rowHashMap = new HashMap();
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
						colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
						colValue = rowSet.getString(colName);
						colName = (colName != null ? colName.toUpperCase() : colName);
						rowHashMap.put(colName, colValue); 
					}
					returnArrayList.add(rowHashMap);
				}
				
				// data가 없을경우 빈값을 넣는다
				if(cnt < 1){
					HashMap rowHashMap = new HashMap();
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
						colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
						colValue = "";
						colName = (colName != null ? colName.toUpperCase() : colName);
						rowHashMap.put(colName, colValue); 
					}
					returnArrayList.add(rowHashMap);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return returnArrayList;
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public ArrayList getUsaRowset2ArrayList(DBRowSet rowSet, String tagName) throws EventException {
		ArrayList returnArrayList = null;
		String colName = null;
		String colValue = null;
		int cnt = 0;
		try{
			if (rowSet!=null) {
				returnArrayList = new ArrayList();
				while(rowSet.next()){
					cnt++;
					HashMap rowHashMap = new HashMap();
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
						colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
						colValue = rowSet.getString(colName);
						colName = (colName != null ? colName.toUpperCase() : colName);
						rowHashMap.put(colName, colValue); 
					}
					returnArrayList.add(rowHashMap);
				}
				
				// data가 없을경우 빈값을 넣는다
				if(cnt < 1){
					HashMap rowHashMap = new HashMap();
					if(!(tagName.equals("{DANGER_CGO") || tagName.equals("{REEFER_CGO") || tagName.equals("{AWKWARD_CGO"))){						
//					}else{
						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
							colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
							colValue = "";
							colName = (colName != null ? colName.toUpperCase() : colName);
							rowHashMap.put(colName, colValue); 
						}
						returnArrayList.add(rowHashMap);
					}
				}				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return returnArrayList;
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet getFlatDataRowSet(String flatCode, String tagName, Event e) throws EventException {

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet clon_rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		WorkOrderPreviewVO woPrvVO = event.getWorkOrderPreviewVO();
		TrsTrspWrkOrdVO	wrkOrdVO = event.getTrsTrspWrkOrdVO();
//		String WOIssStsCd =  (String) event.getHashParam().get("EDI_WO_ISS_STS_CD");
		String woIssStsCd =  (String) wrkOrdVO.getWoIssStsCd();

		try{
			if(tagName == null) rowSet = null;
			else if(flatCode != null && (woPrvVO.getEdiFltCd().equals("105147"))){
				if(tagName != null && tagName.equals("{TRO_MASTER")){
					rowSet = dbDao.searchEdi10514701TroMaster(event);
				} else if(tagName != null && tagName.equals("{TRO_PIC")){
					rowSet = dbDao.searchEdi10514701TroPic(event);
				} else if(tagName != null && tagName.equals("{TRO_CNTR")){
					rowSet = dbDao.searchEdi10514701TroCntr(event);
				} else if(tagName != null && tagName.equals("{CMDT")){
					rowSet = dbDao.searchEdi10514701Cmdt(event);
				} else if(tagName != null && tagName.equals("{DANGER_CGO")){
					rowSet = dbDao.searchEdi10514701DangerCgo(event);
				} else if(tagName != null && tagName.equals("{REEFER_CGO:")){
					rowSet = dbDao.searchEdi10514701ReeferCgo(event);
				} else if(tagName != null && tagName.equals("{AWKWARD_CGO")){
					rowSet = dbDao.searchEdi10514701AwkwardCgo(event);
				} else if(tagName != null && tagName.equals("{TRO_ADDR")){
					rowSet = dbDao.searchEdi10514701TrdAddr(event);
				} else if(tagName != null && tagName.equals("{CUST")){
					rowSet = dbDao.searchEdi10514701Cust(event);
				} else if(tagName != null && tagName.equals("{CNTR_EUR_DETAILS")){
					rowSet = dbDao.searchEdi10514701CntrEurDetails(event);
				}	
			}else if(flatCode != null && (woPrvVO.getEdiFltCd().equals("175368"))){                                      //CY, FM&TO NODE 만 있는 경우
					if(tagName != null && tagName.equals("{TRO_MASTER")){
						rowSet = dbDao.searchEdi10514701TroMaster(event);
					} else if(tagName != null && tagName.equals("{TRO_PIC")){
						rowSet = dbDao.searchEdi10514701TroPic(event);
					} else if(tagName != null && tagName.equals("{TRO_CNTR")){      
						rowSet = dbDao.searchEdi17536801TroCntr(event);
					} else if(tagName != null && tagName.equals("{CMDT")){
						rowSet = dbDao.searchEdi10514701Cmdt(event);
					} else if(tagName != null && tagName.equals("{DANGER_CGO")){
						rowSet = dbDao.searchEdi17536801DangerCgo(event);
					} else if(tagName != null && tagName.equals("{REEFER_CGO:")){
						rowSet = dbDao.searchEdi17536801ReeferCgo(event);
					} else if(tagName != null && tagName.equals("{AWKWARD_CGO")){
						rowSet = dbDao.searchEdi17536801AwkwardCgo(event);
					} else if(tagName != null && tagName.equals("{TRO_ADDR")){
						rowSet = dbDao.searchEdi10514701TrdAddr(event);
					} else if(tagName != null && tagName.equals("{CUST")){
						rowSet = dbDao.searchEdi10514701Cust(event);
					} else if(tagName != null && tagName.equals("{CNTR_EUR_DETAILS")){
						rowSet = dbDao.searchEdi10514701CntrEurDetails(event);
					} else if(tagName != null && tagName.equals("{BKGVVD")){
						rowSet = dbDao.searchEdi17536801BkgVvd(event);
					} else if(tagName != null && tagName.equals("{SKDVVD")){
						rowSet = dbDao.searchEdi17536801SkdVvd(event);	
					}
			}else if(flatCode != null && (flatCode.equals("100253_1") || flatCode.equals("100253_4"))){ //shuttle
				if( woIssStsCd != null && woIssStsCd.equals("N")){
					rowSet = dbDao.searchEdi102297ShCancel(event);
				}else if(tagName != null && tagName.equals("WO_NO:")){
					rowSet = dbDao.searchEdi102297ShHead(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{DEL")){
					rowSet = dbDao.searchEdi102297ShDel(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{CNTR")){
					rowSet = dbDao.searchEdi102297ShCntr(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{DG")){
					rowSet = dbDao.searchEdi102297ShDg(event);
				}
			}else if(flatCode != null && (flatCode.equals("100253_2")||flatCode.equals("100253_3") || 
					flatCode.equals("100253_5")||flatCode.equals("100253_6"))){ // dr, bg
				if( woIssStsCd != null && woIssStsCd.equals("N")){
					rowSet = dbDao.searchEdi102297ShCancel(event);
				}else if(tagName != null && tagName.equals("WO_NO:")){
					rowSet = dbDao.searchEdi102297DrbgHead(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{VVD")){
					rowSet = dbDao.searchEdi102297DrbgVvd(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{BL")){
					rowSet = dbDao.searchEdi102297DrbgBl(event);
					clon_rowSet = (DBRowSet) rowSet.clone();
					if(!clon_rowSet.next()){
						throw new EventException(new ErrorHandler("TRS00102").getMessage()+tagName);
					}
				} else if(tagName != null && tagName.equals("{CNTR")){
					rowSet = dbDao.searchEdi102297DrbgCntr(event);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rowSet;
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet getUsaFlatDataRowSet(String flatCode, String tagName, Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		
		try{
			if(tagName == null) rowSet = null;
			else if(flatCode != null && (flatCode.equals("999999"))){
				if(tagName != null && tagName.equals("{TRO_MASTER")){
					rowSet = dbDao.searchEdiUsaTroMaster(event);
				} else if(tagName != null && tagName.equals("{TRO_PIC")){
					rowSet = dbDao.searchEdiUsaTroPic(event);
				} else if(tagName != null && tagName.equals("{TRO_CNTR")){
					rowSet = dbDao.searchEdiUsaTroCntr(event);
				} else if(tagName != null && tagName.equals("{CMDT")){
					rowSet = dbDao.searchEdiUsa01Cmdt(event);
				} else if(tagName != null && tagName.equals("{DANGER_CGO")){
					rowSet = dbDao.searchEdiUsaDangerCgo(event);
				} else if(tagName != null && tagName.equals("{REEFER_CGO")){
					rowSet = dbDao.searchEdiUsaReeferCgo(event);
				} else if(tagName != null && tagName.equals("{AWKWARD_CGO")){
					rowSet = dbDao.searchEdiUsaAwkwardCgo(event);
				} else if(tagName != null && tagName.equals("{TRO_ADDR")){
					rowSet = dbDao.searchEdiUsaTrdAddr(event);
				} else if(tagName != null && tagName.equals("{CUST")){
					rowSet = dbDao.searchEdiUsaCust(event);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rowSet;
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String getFlatDataETC(String flatCode, String tagName, Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		WorkOrderPreviewVO woPrvVO = event.getWorkOrderPreviewVO();
		StringBuffer etcTag = new StringBuffer();
		String vndrSeq = null;
		String soCreOfcCd = null;

		vndrSeq = woPrvVO.getEdiVndrSeq();
		soCreOfcCd = woPrvVO.getSoCreOfcCd();
		
		try{	
			if(tagName == null) rowSet = null;
			else if(flatCode != null && (woPrvVO.getEdiFltCd().equals("105147"))){
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					if(flatCode != null && (flatCode.equals("105147_1"))){
						etcTag.append("$$$MSGSTART:SML_UNOB            METRANS             IFTMIN    TRS");
					}else if(flatCode != null && (flatCode.equals("155153_1"))){
						etcTag.append("$$$MSGSTART:SML_UNOB            METRANS             IFTMIN    TRS");
					}else if(flatCode != null && (flatCode.equals("105121_1"))){
						etcTag.append("$$$MSGSTART:HANJ                TFG                 IFTMIN    TRS");
					}else if(flatCode != null && (flatCode.equals("135366_1"))){
						etcTag.append("$$$MSGSTART:SML_UNOB            MASTHAUL            IFTMIN    TRS");
					}else if(flatCode != null && (flatCode.equals("115133_1"))){
						etcTag.append("$$$MSGSTART:SML_UNOB            INTRANS             IFTMIN    TRS");
					}else if(	(vndrSeq.equals("120759") || vndrSeq.equals("120852") || vndrSeq.equals("121403") 
						      || vndrSeq.equals("125140") || vndrSeq.equals("166660") || vndrSeq.equals("168242") 
							  || vndrSeq.equals("172121") || vndrSeq.equals("143046") || vndrSeq.equals("166697") 
						 	  || vndrSeq.equals("120849") || vndrSeq.equals("181404") || vndrSeq.equals("186225") 
						 	  || vndrSeq.equals("186226") )){ 	
						etcTag.append("$$$MSGSTART:SML_UNOB            "+ vndrSeq +"              IFTMIN    TRS");			// 공백5개
					}else if( vndrSeq.equals("105055") ) {
						etcTag.append("$$$MSGSTART:SML_UNOB            FREIGHTLINER        IFTMIN    TRS");
					}
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			}else if(flatCode != null && (flatCode.equals("175368_1"))){
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					etcTag.append("$$$MSGSTART:SML_UNOB            DANSER              IFTMIN    TRS");
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			}else if(flatCode != null && (flatCode.equals("114745_1"))){
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					etcTag.append("$$$MSGSTART:SML_UNOB            UNIFEEDER           IFTMIN    TRS");
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			}else if(flatCode != null && (flatCode.equals("157955_1"))){
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					etcTag.append("$$$MSGSTART:SML                 XPRESS              IFTMIN    TRS");
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			}else if(flatCode != null && (flatCode.equals("184332_1"))){
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					etcTag.append("$$$MSGSTART:SML_UNOB            OPTIMODAL           IFTMIN    TRS");
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			} else if(flatCode != null && (flatCode.equals("100253_1")||flatCode.equals("100253_4"))){
				if(tagName != null && tagName.equals("IFSML2HJT!SO_SND!")){
					etcTag.append("IFSML2HJT!SO_SND!");
				}
			} else if(flatCode != null && (flatCode.equals("100253_2")||flatCode.equals("100253_5"))){
				if(tagName != null && tagName.equals("IFSML2HJT!SO_DR_S!")){
					etcTag.append("IFSML2HJT!SO_DR_S!");
				}
			} else if(flatCode != null && (flatCode.equals("100253_3")||flatCode.equals("100253_6"))){
				if(tagName != null && tagName.equals("IFSML2HJT!SO_BG_S!")){
					etcTag.append("IFSML2HJT!SO_BG_S!");
				}
			}
			etcTag.append("\n");
		
		} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return etcTag.toString();
	}
	
	/**
	 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
	 * EDI에 전송할 Flat파일 생성<br>
	 * 
	 * @param flatCode
	 * @param tagName
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public String getUsaFlatDataETC(String flatCode, String tagName, Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0024Event event=(EsdTrs0024Event)e;
		StringBuffer etcTag = new StringBuffer();
		HashMap hashParam = null;	
		String ediRcvrNm = null;
		try{	
			if(tagName == null) rowSet = null; 
			else if(flatCode != null && (flatCode.equals("999999"))){
				hashParam = event.getHashParam();
				//EdiRcvrNm = (String) hashParam.get("EDI_RCVR_NM");
				ediRcvrNm = event.getWorkOrderPreviewVO().getEdiRcvrNm();
								
				if(tagName != null && tagName.equals("$$$MSGSTART")){
					if(ediRcvrNm.equals("AFTT                ")){
						etcTag.append("$$$MSGSTART:SMFTP               AFTT                204       USA");
					}else{
						etcTag.append("$$$MSGSTART:SMLINE              "+ ediRcvrNm +"204       USA");
					}
					rowSet = dbDao.searchEdi10514701Header(event);
					if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
				}
			}
			etcTag.append("\n");
		
		} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		return etcTag.toString();
	}
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @param vndrSeq
	 * @return 
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile, String vndrSeq) throws EventException {
		return eaiDao.sendFlatMessage(flatFile, vndrSeq);
	}
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @param vndrSeq
	 * @return 
	 * @exception EventException
	 */
	public String sendFlatMessageForESUM(String flatFile, String vndrSeq) throws EventException {
		return eaiDao.sendFlatMessageForESUM(flatFile, vndrSeq);
	}
	
	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @return 
	 * @exception EventException
	 */
	public String sendUsaFlatMessage(String flatFile) throws EventException {
		return eaiDao.sendUsaFlatMessage(flatFile);
	}
	
	/**
	 * null 제거 <br>
	 * 
	 * @param src
	 * @return 
	 */
	public String rmNull(String src){
		if(src == null) src = "";
		return src;
	}
	
	/**
	 * null 제거 <br>
	 * 
	 * @param src
	 * @return 
	 */
	public int rmNull2Int(String src){
		if(src == null || src.trim().equals("")) src = "0";
		return Integer.parseInt(src);
	}
	
	/**
	 * left로 채우기<br>
	 * 
	 * @param srcStr
	 * @param padLen
	 * @param padStr
	 * @return response ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public String lpad(String srcStr, int padLen, String padStr){
		StringBuffer returnStr = new StringBuffer();
		int cnt = padLen - srcStr.length();
		for(int i=0; i<cnt; i++){
			returnStr.append(padStr);
		}
		returnStr.append(srcStr);
		return returnStr.toString();
	}
	
	/**
	 * left로 채우기<br>
	 * 
	 * @param srcStr
	 * @param padLen
	 * @param padStr
	 * @return response ESD_TRS_024EventResponse
	 */
	public String rpad(String srcStr, int padLen, String padStr){
		StringBuffer returnStr = new StringBuffer();
		int cnt = padLen - srcStr.length();
		for(int i=0; i<cnt; i++){
			returnStr.append(padStr);
		}
		returnStr.insert(0, srcStr);
		return returnStr.toString();
	}
	
	
	/**
	 * workordermanage 업무 시나리오 마감작업<br>
	 * WorkOrderPreview업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}



/** 1431ROW 이하  317 EDI 개발중 **/

/**
 * 조회 이벤트 처리<br>
 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
 * @param e 
 * 
 * @return response ESD_TRS_024EventResponse
 * @exception EventException
 */
public ArrayList addWorkOrderPreview317Snd(Event e) throws EventException {
	EsdTrs0024Event event = (EsdTrs0024Event)e;
	DBRowSet rowSet = null;
	HashMap hashParam = null;
	String vndrSeq = null;
	String woEdiUseFlg = null;
	ArrayList ffList = null;

	try{
		rowSet = dbDao.searchSoByPrvTmp317Snd(event);
		while(rowSet.next()){
			if (ffList == null) ffList = new ArrayList(); 
			hashParam = event.getHashParam();
			vndrSeq = rowSet.getString("VNDR_SEQ");
			woEdiUseFlg = rowSet.getString("wo_edi_use_flg");
//			if("M".equals(rowSet.getString("CONTI_CD")) && woEdiUseFlg.equals("Y")){
			if("M".equals(rowSet.getString("CONTI_CD"))){
				hashParam.put("EDI_LOC", "USA");
			}
			hashParam.put("EDI_TRSP_SO_OFC_CTY_CD", rowSet.getString("TRSP_SO_OFC_CTY_CD"));
			hashParam.put("EDI_TRSP_SO_SEQ", rowSet.getString("TRSP_SO_SEQ"));
			hashParam.put("EDI_TRSP_WO_OFC_CTY_CD", rowSet.getString("TRSP_WO_OFC_CTY_CD"));
			hashParam.put("EDI_TRSP_WO_SEQ", rowSet.getString("TRSP_WO_SEQ"));
			hashParam.put("EDI_WO_ISS_STS_CD", rowSet.getString("WO_ISS_STS_CD"));
			hashParam.put("EDI_VNDR_SEQ",vndrSeq);
			hashParam.put("TRSP_CRR_MOD_CD",rowSet.getString("TRSP_CRR_MOD_CD"));
			hashParam.put("TRSP_COST_DTL_MOD_CD",rowSet.getString("TRSP_COST_DTL_MOD_CD"));
			hashParam.put("EDI_EQ_NO",rowSet.getString("EQ_NO"));
			hashParam.put("EDI_FM_NOD_CD",rowSet.getString("FM_NOD_CD"));
			hashParam.put("EDI_TRSP_BND_CD",rowSet.getString("TRSP_BND_CD"));
			hashParam.put("EDI_TRSP_CRR_MOD_CD",rowSet.getString("TRSP_CRR_MOD_CD"));
			hashParam.put("EDI_EQ_KND_CD",rowSet.getString("EQ_KND_CD"));
			hashParam.put("EDI_CGO_TP_CD",rowSet.getString("CGO_TP_CD"));
			event.setHashParam(hashParam);

			ffList.add(send317FlatFile(event));

		}		
	} catch (Exception de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	}
	return ffList;
}

/**
 * Flat file 전송하기<br>
 * WorkOrderPreview화면에 대한 조회 이벤트 처리<br>
 * 
 * @param e
 * @return response ESD_TRS_024EventResponse
 * @exception EventException
 */
public String[] send317FlatFile(Event e) throws EventException {
	EsdTrs0024Event event=(EsdTrs0024Event)e;
	
	String flatStr = null;
	String vndrSeq = null;
	String costMod = null;
	String crrMod = null;
	String woEdiUseFlg = null;
	String trspWoOfcCtyCd = null;
	String ediLog = null;
	String woIssStsCd = null;

	String[] returnArray = new String[3];
	returnArray[0] = "317";
	
	
	HashMap hashParam = event.getHashParam();
	trspWoOfcCtyCd = (String) hashParam.get("EDI_TRSP_WO_OFC_CTY_CD");
	woEdiUseFlg = (String) hashParam.get("wo_edi_use_flg");
	ediLog = (String) hashParam.get("EDI_LOC");
	woIssStsCd = (String) hashParam.get("EDI_WO_ISS_STS_CD");

//	if (woEdiUseFlg == null || !woEdiUseFlg.equals("EDI")) return;
	try {
		
		vndrSeq = (String) hashParam.get("EDI_VNDR_SEQ");
		crrMod = (String) hashParam.get("TRSP_CRR_MOD_CD");
		costMod = (String) hashParam.get("TRSP_COST_DTL_MOD_CD");
		
		hashParam = event.getHashParam();
		hashParam.put("EDI_vndrSeq",vndrSeq);
		event.setHashParam(hashParam);
		flatStr = make317FlatFile(event);
		returnArray[1] = flatStr;
		returnArray[2] = vndrSeq;
		
//		send317FlatMessage(flatStr);
		
	} catch (Exception de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	}
	return returnArray;
}

/**
 * Flat File 만들기<br>
 * EDI에 전송할 Flat파일 생성<br>
 * 
 * @param e
 * @return response ESD_TRS_024EventResponse
 * @exception EventException
 */
public String make317FlatFile(Event e) throws EventException {
	StringBuffer contents 		= new StringBuffer();
	StringBuffer etcTag 		= new StringBuffer();

	DBRowSet layOutRowSet 		= null;
	ArrayList fltCdArray 		= new ArrayList();
	ArrayList colNmArray		= new ArrayList();
	ArrayList colSeqArray 		= new ArrayList();
	ArrayList colLvlArray 		= new ArrayList();
	ArrayList colKndCdArray 	= new ArrayList();
	ArrayList colLenArray 		= new ArrayList();
	HashMap contentsHashMap 	= new HashMap();
	HashMap resultArrayHashMap 	= new HashMap();

	EsdTrs0024Event event=(EsdTrs0024Event)e;
	
	String fltCd = null;
	String colNm = null;
	String startKey = null;
	String colKndCd = null;
	int curLevel = 0;
	int startLevel = 0;

	try{
		layOutRowSet = dbDao.search317EdiLayoutList();

		/*
		 * FLT_KEY_KND -ET(ETC), HD(Header), NR(Normal), OT(Open Tag), CT(CLOSE TAG)
		 * ET - DB COLUMN명으로 전환될수 없는 TAG
		 * HD - OPEN TAG가 아니지만 LEVEL이 시작되는 COLUMN인경우로 DATA가 있는 TAG다
		 * OT - OPEN TAG로 DATA없이 TAG명만 파일에 추가된다.
		 * CT - CLOSE TAG로 DATA없이 TAG명만 파일에 추가된다.
		 * NR - NORMAL TAG로 DATA가 있는 일반 TAG이다.
		 */
		
		while(layOutRowSet.next()){
			colKndCd 	= layOutRowSet.getString("col_knd_cd");
			colNm 		= layOutRowSet.getString("col_nm");
			fltCd 		= "888888";
			colNm 		= (colNm != null ? colNm.toUpperCase() : colNm);
			fltCdArray.add(fltCd);
			colNmArray.add(colNm);
			colSeqArray.add(layOutRowSet.getString("flt_file_ut_seq"));
			colLvlArray.add(layOutRowSet.getString("col_lvl"));
			colKndCdArray.add(colKndCd);
			colLenArray.add(layOutRowSet.getString("col_len"));
			
			if(colKndCd != null && colKndCd.equals("ET")) {
				etcTag.append(get317FlatDataETC(fltCd,colNm, event));
			}
			
			if(colKndCd != null && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
				if(startKey == null) {
					startKey = colNm;
					startLevel = Integer.parseInt(layOutRowSet.getString("col_lvl"));
				}
				contentsHashMap.put(colNm, get317Rowset2ArrayList(get317FlatDataRowSet(fltCd,colNm,event), colNm));
			}
		}
		
		contents.append(etcTag);
		resultArrayHashMap.put("flt_cd"		, fltCdArray		);
		resultArrayHashMap.put("col_nm"		, colNmArray		);
		resultArrayHashMap.put("col_seq"	, colSeqArray		);
		resultArrayHashMap.put("col_lvl"	, colLvlArray		);
		resultArrayHashMap.put("col_knd"	, colKndCdArray	);
		resultArrayHashMap.put("col_len"	, colLenArray		);
		
		String rpKeyValue = null;
		
		for(int i=0; i< colNmArray.size(); i++){
			curLevel = Integer.parseInt( (String) colLvlArray.get(i));
			colNm = rmNull((String) colNmArray.get(i));
			colKndCd = rmNull((String) colKndCdArray.get(i));
			rpKeyValue = JSPUtil.replace(JSPUtil.replace(colNm, "{", ""), "}", "");
			if(curLevel==startLevel && (colKndCd.equals("OT")||colKndCd.equals("HD"))) {
				contents.append(getContents(contentsHashMap, resultArrayHashMap, colNm, i));
			}
		}
	} catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new EventException(se.getMessage());
	} catch (DAOException de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	} catch (Exception ex) {
		log.error(ex.toString(), ex);
		throw new EventException(ex.getMessage());
	} 
	
	return contents.toString();
}

/**
 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
 * EDI에 전송할 Flat파일 생성<br>
 * 
 * @return response ESD_TRS_024EventResponse
 * @exception EventException
 */
public DBRowSet get317FlatDataRowSet(String flatCode, String tagName, Event e) throws EventException {
	DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	EsdTrs0024Event event=(EsdTrs0024Event)e;
	
	try{
		if(tagName == null) rowSet = null;
		else if(flatCode != null && (flatCode.equals("888888"))){
			if(tagName != null){
				rowSet = dbDao.searchEdi317VitMaster(event);
			} 
		}
	} catch (Exception de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	}
	return rowSet;
}

/**
 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
 * EDI에 전송할 Flat파일 생성<br>
 * 
 * @return response ESD_TRS_024EventResponse
 * @exception EventException
 */
public String get317FlatDataETC(String flatCode, String tagName, Event e) throws EventException {
	DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	EsdTrs0024Event event=(EsdTrs0024Event)e;
	StringBuffer etcTag = new StringBuffer();
	try{	
		if(tagName == null) rowSet = null; 
		else if(flatCode != null && (flatCode.equals("888888"))){
			if(tagName != null && tagName.equals("$$$MSGSTART")){
				etcTag.append("$$$MSGSTART:SMFTP               VITUSB              317       USA");
				rowSet = dbDao.searchEdi10514701Header(event);
				if(rowSet.next()) etcTag.append(rowSet.getString("SEQ_DT"));
			}
		}
		etcTag.append("\n");
	}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
	} catch (DAOException de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	} catch (Exception ex) {
		log.error(ex.toString(), ex);
		throw new EventException(ex.getMessage());
	} 
	return etcTag.toString();
}

/**
 * Flat File을 전송한다. <br>
 * EDI에 Flat파일을 전송한다.<br>
 * 
 * @param flatFile 
 * @return 
 * @exception EventException
 */
public String send317FlatMessage(String flatFile) throws EventException {
		return eaiDao.send317FlatMessage(flatFile);
}

/**
 * ResultSet을 HashMap와 ArrayList에 담는다. <br>
 * EDI에 전송할 Flat파일 생성<br>
 * 
 * @param rowSet 
 * @param tagName 
 * @return ArrayList
 * @exception EventException
 */
public ArrayList get317Rowset2ArrayList(DBRowSet rowSet, String tagName) throws EventException {
	ArrayList returnArrayList = null;
	String colName = null;
	String colValue = null;
	int cnt = 0;
	try{
		if (rowSet!=null) {
			returnArrayList = new ArrayList();
			while(rowSet.next()){
				cnt++;
				HashMap rowHashMap = new HashMap();
				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
					colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
					colValue = rowSet.getString(colName);
					colName = (colName != null ? colName.toUpperCase() : colName);
					rowHashMap.put(colName, colValue); 
				}
				returnArrayList.add(rowHashMap);
			}
			
			// data가 없을경우 빈값을 넣는다
			if(cnt < 1){
				HashMap rowHashMap = new HashMap();
				
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
						colName = rowSet.getMetaData().getColumnName(j+1).toLowerCase();
						colValue = "";
						colName = (colName != null ? colName.toUpperCase() : colName);
						rowHashMap.put(colName, colValue); 
					}
					returnArrayList.add(rowHashMap);
				
			}				
		}
	} catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new EventException(se.getMessage());
	} catch (Exception ex) {
		log.error(ex.toString(), ex);
		throw new EventException(ex.getMessage());
	} 
	return returnArrayList;
}

/**
 * vendor sequence 가 변경된 경우 해당 so 에 대해 bkg_no를 조회한다.<br>
 * wo preview confirm 시 vendor sequence 가 변경되었는지 체크하고, 변경된 경우 bkg_no를 리턴한다. <br>
 * 
 * @return response bkg_no
 * @exception EventException
 */
public List<String> getBkgNoIfVndrChanged(Event e) throws EventException{

	EsdTrs0024Event event=(EsdTrs0024Event)e;

	try {
		return dbDao.getBkgNoIfVndrChanged(event);
	} catch (DAOException de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	} 	
}

/**
 * WorkOrder Send FAX
 * @param Event e
 * @param String userId
 * @exception EventException
 */	
public void sendEaiFax(Event e,String userId) throws EventException {
//	WorkOrderPreviewVO 	woVO = null;
    try {
    	eaiDao.sendEaiFax(e,userId);
    } catch (ServerExportException se) {
    	log.error(se.toString(), se);
		throw new EventException(se.getMessage());
	} catch (Exception ex) {
		log.error(ex.toString(), ex);
		throw new EventException(ex.getMessage());
	} 	
}

/**
 * WorkOrder Send Mail
 * @param Event e
 * @param wonoRowSet
 * @return List
 * @exception EventException
 */	
public List emailSend(Event e,DBRowSet wonoRowSet) throws EventException{
	List arrWoMail = new ArrayList();
    try {
    	arrWoMail=eaiDao.emailSend(e,wonoRowSet);
    } catch (ServerExportException se) {
    	throw new EventException(se.getMessage());
	} catch (Exception ex) {
		throw new EventException(ex.getMessage());
	} 
	return arrWoMail;
}
/**
 * 조회 이벤트 처리<br>
 * WorkOrderPreview화면에서 confirm 시 Inv No 존재하는지 체크<br>
 * 
 * @param Event e
 * @return DBRowSet
 * @exception EventException
 */
public DBRowSet searchInvNo(Event e) throws EventException {
	// PDTO(Data Transfer Object including Parameters)

	EsdTrs0024Event event = (EsdTrs0024Event)e;
	DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	try {
		rowSet=dbDao.searchInvNo(event);
		return rowSet;
	} catch (DAOException de) {
		log.error("err "+de.toString(),de);
		throw new EventException(de.getMessage());
	}
}


/**
 * <br>
 * 
 * @param e
 * @return String
 * @exception EventException
 */
public String searchAuthAproRqstNo(Event e) throws EventException{
	String authAproRqstNo = "";
	EsdTrs0024Event event=(EsdTrs0024Event)e;
	try {
		authAproRqstNo = dbDao.searchAuthAproRqstNo(event);
	} catch (DAOException de) {
		log.error("err " + de.toString(), de);
		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
	} catch (Exception de) {
		log.error("err " + de.toString(), de);
		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
	}

	return authAproRqstNo;
}

}
