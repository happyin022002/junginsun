/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageBCImpl.java
*@FileTitle : Transportation invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.26
*@LastModifier : 최 선
*@LastVersion : 1.3
* 2006.12.18 JeongSangKi
* -------------------------------------------------------
* history
* 2009.05.11 1.1 N200905040013 2009-05-11: Office Change 개념의 모듈적용 요청
* 2011.07.20 김영철   1.2 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
* 2010.12.26 최 선     1.3 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration.CSRIssueTransferSlipManageDBDAO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration.CSRIssueTransferSlipManageEAIDAO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - CSR에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kimjin
 * @see ESD_TRS_024EventResponse,CSRIssueTransferSlipManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 * @History
 * 2009-02-10 : CSR 중복 발행 체크 로직 추가
 */
public class CSRIssueTransferSlipManageBCImpl extends BasicCommandSupport implements CSRIssueTransferSlipManageBC {

	// Database Access Object
	private transient CSRIssueTransferSlipManageDBDAO dbDao		= null;

	// EAI Interface Object
	private transient CSRIssueTransferSlipManageEAIDAO eaiDao 	= null;
	
	
	/**
	 * CSRIssueTransferSlipManageBCImpl객체 생성	<br>
	 * CSRIssueTransferSlipManageDBDAO를 생성한다		<br>
	 */
	public CSRIssueTransferSlipManageBCImpl(){
		dbDao 	= new CSRIssueTransferSlipManageDBDAO	();
		eaiDao 	= new CSRIssueTransferSlipManageEAIDAO	();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException {
		EsdTrs0031Event event 	= (EsdTrs0031Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet=dbDao.searchCSRSummary(event);
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
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event)e;
		
		DBRowSet rowSet 	= null;
		DBRowSet asaSet 	= null;
		DBRowSet ap_ofc_cd 	= null;
		
		try {
			rowSet		= dbDao.searchCSRSummaryDetail(event);
			asaSet		= dbDao.searchASANOList(event);
			ap_ofc_cd 	= dbDao.searchApOfcCD(event);

			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(asaSet.next()){
				eventResponse.setETCData("asaNoString", asaSet.getString("asanostring"));
				eventResponse.setETCData("csrNo", "");
			}

			if(ap_ofc_cd.next())				
				eventResponse.setETCData("apOfcCd", ap_ofc_cd.getString("AP_OFC_CD"));
			
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
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse correctCsrAmt(Event e) throws EventException {
		EsdTrs0032Event 	event		= (EsdTrs0032Event)e;
		
		try {
			log.error("\n TRS START ... correctCsrAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			dbDao.correctSvcOrdMstCsrScgCorrAmt	(event	);		/** SURCHARGE AMOUNT CORRECTION							*/
			dbDao.correctSvcOrdMstCsrBzcCorrAmt	(event	);		/** BASIC     AMOUNT CORRECTION							*/
			dbDao.correctRfndInvCsrCorrAmt		(event	);		/** REFUND    AMOUNT CORRECTION							*/

			log.error("\n TRS FINISH ... correctCsrAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return null;
	}
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public String generateNewCsrNo(Event e) throws EventException {
		EsdTrs0032Event 	event		= (EsdTrs0032Event)e;
		String				sCsrNo		= null;

		try {
			log.error("\n TRS START ... generateNewCsrNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			sCsrNo 			= dbDao.createCsrNo(event);
			log.error("\n TRS FINISH ... generateNewCsrNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return sCsrNo;
	}	
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse createApInvHdrDtrb(Event e) throws EventException {
		EsdTrs0032Event 	event			= (EsdTrs0032Event)e;
		GeneralEventResponse eventResponse	= new GeneralEventResponse();			
		
		try {
			
			log.error("\n TRS START ... createPreviewApInvHdrDtrb:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				
			log.error("\n TRS START ... createApInvHdrDtrb:createApInvHDR"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			dbDao.createApInvHDR	(event	);
			log.error("\n TRS FINISH ... createApInvHdrDtrb:createApInvHDR"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			log.error("\n TRS START ... createApInvHdrDtrb:createApInvDTRB"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			dbDao.createApInvDtrb	(event	);
			log.error("\n TRS FINISH ... createApInvHdrDtrb:createApInvDTRB"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			/* 국가코드 : 'KR' + 기타증빙('3') 일경우 CSR 보내지 않음. (AP_INV_IF) */
			if(event.getCntCd().equals("KR")){
				if(event.getEviGb().equals("1") || event.getEviGb().equals("2")){
					dbDao.createApInvKRDtrb(event);
				}				
			}
			
			log.debug("<==========================[ ASA Number ]==================================>");
			log.debug("<==========================[ ASA Number ] === ["+event.getAsaNo()+"]================>");
			log.debug("<==========================[ ASA Number ]==================================>");
			
			if(!"".equals(event.getAsaNo()) && event.getAsaNo() != null){
				dbDao.createApInvDTRBASANo	(event);
				log.error("\n TRS FINISH ... createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			log.error("\n TRS FINISH ... createPreviewApInvHdrDtrb:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		eventResponse.setETCData("csrNo", event.getCsr_no());
		return eventResponse;
	}	
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param String sCsrNo
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void updateApInvDtrbLineNo(String sCsrNo, String ofcCd) throws EventException {
		

		try {
			log.error("\n TRS START ... updateApInvDtrbLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			dbDao.modifyApInvDTRBLineNo	(sCsrNo);
			log.error("\n TRS FINISH ... updateApInvDtrbLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			//CSR생성 후 Approval Request 하기 위한 단계로 업데이트
			//new ApprovalUtil().modifyRqstAproStepFlg(sCsrNo,"Y");
//			 ApprovalUtil aproUtil = new ApprovalUtil();
//			 aproUtil.updateAproGwFlg(sCsrNo, ofcCd); 
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @exception EventException
	 */
	public void updateCntrFincVVD(Event e) throws EventException {
		
		
		EsdTrs0032Event event = (EsdTrs0032Event)e;

		try {
			log.error("\n TRS START ... updateCntrFincVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			dbDao.updateCntrFincVVD(event);
			log.error("\n TRS FINISH ... updateCntrFincVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param sCsrNo
	 * @param sPreviewIndicator
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse selectApInvHdrDtrbList(String sCsrNo, String sPreviewIndicator) throws EventException {

		DBRowSet 	hdrSet		= null;
		DBRowSet	dtrbSet		= null;
		
		try {
			log.error("\n TRS START ... selectApInvHdrDtrbList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			hdrSet		= dbDao.searchPreviewHDR		(sCsrNo, sPreviewIndicator	);
			dtrbSet		= dbDao.searchPreviewDTRBList	(sCsrNo						);
			log.error("\n TRS FINISH ... selectApInvHdrDtrbList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			if(hdrSet.next()){
				eventResponse.setETCData("pre_csr_no", 		hdrSet.getString("pre_csr_no"));
				eventResponse.setETCData("pre_office", 		hdrSet.getString("pre_office"));
				eventResponse.setETCData("pre_prpd_dy", 	hdrSet.getString("pre_prpd_dy"));
				eventResponse.setETCData("pre_pay_to", 		hdrSet.getString("pre_pay_to"));
				eventResponse.setETCData("pre_csr_type", 	hdrSet.getString("pre_csr_type"));
				eventResponse.setETCData("pre_desc", 		hdrSet.getString("pre_desc"));
				eventResponse.setETCData("pre_pay_group", 	hdrSet.getString("pre_pay_group"));
				eventResponse.setETCData("pre_evi_tp", 		hdrSet.getString("pre_evi_tp"));
				eventResponse.setETCData("pre_due_date", 	hdrSet.getString("pre_due_date"));
				eventResponse.setETCData("pre_asa_no", 		hdrSet.getString("pre_asa_no"));
				eventResponse.setETCData("pre_inv_dt", 		hdrSet.getString("pre_inv_dt"));
				eventResponse.setETCData("pre_curr_cd", 	hdrSet.getString("pre_curr_cd"));
				eventResponse.setETCData("pre_amt", 		hdrSet.getString("pre_amt"));
				eventResponse.setETCData("chk_mail", 		hdrSet.getString("chk_mail"));
				eventResponse.setETCData("chk_mail1", 		hdrSet.getString("chk_mail1"));
				eventResponse.setETCData("chk_mail2", 		hdrSet.getString("chk_mail2"));
				eventResponse.setETCData("chk_mail3", 		hdrSet.getString("chk_mail3"));
				eventResponse.setETCData("chk_mail4", 		hdrSet.getString("chk_mail4"));
				eventResponse.setETCData("chk_mail5", 		hdrSet.getString("chk_mail5"));
				eventResponse.setETCData("chk_mail6", 		hdrSet.getString("chk_mail6"));
				eventResponse.setETCData("chk_mail7", 		hdrSet.getString("chk_mail7"));
			}
			
			eventResponse.setRsVo(dtrbSet);
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
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void deleteInvHdrDtrbList(String sCsrNo) throws EventException {
		try {
			log.error("\n TRS START ... deletePreviewInvHdrDtrbList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			dbDao.deleteApInvHDRDTRB	(sCsrNo);	/** DELETING AFTER PREVIEW ROWSET GENERATION */ 
			log.error("\n TRS FINISH ... deletePreviewInvHdrDtrbList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_034EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException {
		EsdTrs0034Event event 	= (EsdTrs0034Event)e;
		DBRowSet rowSet 		= null;

		try {
			rowSet 	= dbDao.searchTAXDetail(event.getVndrSeq(), event.getWoVndrSeq());
			FormCommand formcommand = e.getFormCommand();	

			GeneralEventResponse eventResponse = new GeneralEventResponse();			

			eventResponse.setRsVo(rowSet);
			
			if(rowSet.next()){
				if(formcommand.isCommand(FormCommand.SEARCHLIST)){
					eventResponse.setETCData("vndr_nm", 		rowSet.getString("vndr_nm"));
					eventResponse.setETCData("bzct_nm", 		rowSet.getString("bzct_nm"));
					eventResponse.setETCData("bztp_nm", 		rowSet.getString("bztp_nm"));
					eventResponse.setETCData("vndr_addr", 		rowSet.getString("vndr_addr"));
					eventResponse.setETCData("ceo_nm", 			rowSet.getString("ceo_nm"));
					eventResponse.setETCData("rgst_no", 		rowSet.getString("rgst_no"));
					eventResponse.setETCData("wkplc_nmstring", 	rowSet.getString("evi_code"));
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
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException {
		
		EsdTrs0034Event event	= (EsdTrs0034Event)e;
		try {
			String tax_no3 = dbDao.searchApEviNo(event);
			FormCommand formcommand = e.getFormCommand();
			GeneralEventResponse eventResponse = new GeneralEventResponse();			

			eventResponse.setETCData("tax_no3", 	tax_no3);

			if(formcommand.isCommand(FormCommand.MULTI01)){
				eventResponse.setETCData("gsFlg", 		"MULTI01");
			}else if(formcommand.isCommand(FormCommand.MULTI02)){
				eventResponse.setETCData("gsFlg", 		"MULTI02");
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException {
		EsdTrs0034Event event 	= (EsdTrs0034Event)e;
		DBRowSet rowSet 		= null;

		try {
			rowSet 		= dbDao.searchTAXCode(event);
			FormCommand formcommand = e.getFormCommand();	
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			if(rowSet.next()){
				eventResponse.setETCData("tax_code", 	rowSet.getString("ap_tax_nm"));

				if(formcommand.isCommand(FormCommand.MULTI01)){
					eventResponse.setETCData("gsFlg", 		"MULTI01");
				}else if(formcommand.isCommand(FormCommand.MULTI02)){
					eventResponse.setETCData("gsFlg", 		"MULTI02");
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
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param sCsrNo
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrPreVeiw(String sCsrNo) throws EventException {
		

		DBRowSet hdrSet		= null;
		DBRowSet dtrbSet	= null;
		
		try {

			hdrSet		= dbDao.searchPreviewHDR		(sCsrNo,	""	);
			dtrbSet		= dbDao.searchPreviewDTRBList	(sCsrNo			);

			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			if(hdrSet.next()){
				eventResponse.setETCData("pre_csr_no", 		hdrSet.getString("pre_csr_no"));
				eventResponse.setETCData("pre_office", 		hdrSet.getString("pre_office"));
				eventResponse.setETCData("pre_prpd_dy", 	hdrSet.getString("pre_prpd_dy"));
				eventResponse.setETCData("pre_pay_to", 		hdrSet.getString("pre_pay_to"));
				eventResponse.setETCData("pre_csr_type", 	hdrSet.getString("pre_csr_type"));
				eventResponse.setETCData("pre_desc", 		hdrSet.getString("pre_desc"));
				eventResponse.setETCData("pre_pay_group", 	hdrSet.getString("pre_pay_group"));
				eventResponse.setETCData("pre_evi_tp", 		hdrSet.getString("pre_evi_tp"));
				eventResponse.setETCData("pre_due_date", 	hdrSet.getString("pre_due_date"));
				eventResponse.setETCData("pre_asa_no", 		hdrSet.getString("pre_asa_no"));
				eventResponse.setETCData("pre_inv_dt", 		hdrSet.getString("pre_inv_dt"));
				eventResponse.setETCData("pre_curr_cd", 	hdrSet.getString("pre_curr_cd"));
				eventResponse.setETCData("pre_amt", 		hdrSet.getString("pre_amt"));
				eventResponse.setETCData("pre_evi_tp_count", 	hdrSet.getString("pre_evi_tp_count"));
				eventResponse.setETCData("pre_appro_by", 		hdrSet.getString("pre_appro_by"));
				eventResponse.setETCData("chk_mail", 		hdrSet.getString("chk_mail"));
				eventResponse.setETCData("chk_mail1", 		hdrSet.getString("chk_mail1"));
				eventResponse.setETCData("chk_mail2", 		hdrSet.getString("chk_mail2"));
				eventResponse.setETCData("chk_mail3", 		hdrSet.getString("chk_mail3"));
				eventResponse.setETCData("chk_mail4", 		hdrSet.getString("chk_mail4"));
				eventResponse.setETCData("chk_mail5", 		hdrSet.getString("chk_mail5"));
				eventResponse.setETCData("chk_mail6", 		hdrSet.getString("chk_mail6"));
				eventResponse.setETCData("chk_mail7", 		hdrSet.getString("chk_mail7"));
			}			
			eventResponse.setRsVo(dtrbSet);
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
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_0048Event
	 * @return EventResponse ESD_TRS_0048EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrCancel(Event e) throws EventException {
		// searchInvoiceListInquiry와 동일한 dao 메소드 사용하여 to be version으로 일부 수정됨. 추가 수정 필요!! 20090817 kys 
		EsdTrs0048Event event=(EsdTrs0048Event)e;
		DBRowSet rowSet_top= null;
		DBRowSet rowSet= null;

		try {
			rowSet_top 	= dbDao.searchInvoiceInquiry(event);
			rowSet 	    = dbDao.searchInvoiceInquiryList(event);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(rowSet_top.next()){
				eventResponse.setETCData("csr_no"			, rowSet_top.getString("csr_no"));
				eventResponse.setETCData("vndr_no"			, rowSet_top.getString("vndr_no"));
				eventResponse.setETCData("vndr_nm"			, rowSet_top.getString("vndr_nm"));
				eventResponse.setETCData("inv_cnt"			, rowSet_top.getString("inv_cnt"));
				eventResponse.setETCData("csr_curr_cd"		, rowSet_top.getString("csr_curr_cd"));
				eventResponse.setETCData("csr_amt"			, rowSet_top.getString("csr_amt"));
				eventResponse.setETCData("max_iss_dt"		, rowSet_top.getString("max_iss_dt"));
				eventResponse.setETCData("max_rcv_dt"		, rowSet_top.getString("max_rcv_dt"));
				eventResponse.setETCData("asa_no"			, rowSet_top.getString("asa_no"));
				eventResponse.setETCData("vndr_term_nm"		, rowSet_top.getString("vndr_term_nm"));
				eventResponse.setETCData("cost_ofc"			, rowSet_top.getString("cost_ofc"));
				eventResponse.setETCData("payment_due_dt"	, rowSet_top.getString("pre_due_date"));
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
	 * Service Management > Trans S/O > CSR > CSR I/F Status Inquiry : get main list
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRAPiflist(Event e) throws EventException {
		EsdTrs0047Event event = (EsdTrs0047Event)e;
		DBRowSet rowSet = null;	
		try {
			rowSet=dbDao.searchCSRAPiflist(event);
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
	 * CSRIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_0960Event
	 * @return EventResponse ESD_TRS_0960EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceListInquiry(Event e) throws EventException {
		
		EsdTrs0960Event event=(EsdTrs0960Event)e;
		DBRowSet rowSet_top= null;
		DBRowSet rowSet= null;

		try {
			rowSet_top 	= dbDao.searchInvoiceInquiry(event);
			rowSet 	    = dbDao.searchInvoiceInquiryList(event);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(rowSet_top.next()){
				eventResponse.setETCData("csr_no"			, rowSet_top.getString("csr_no"));
				eventResponse.setETCData("vndr_no"			, rowSet_top.getString("vndr_no"));
				eventResponse.setETCData("vndr_nm"			, rowSet_top.getString("vndr_nm"));
				eventResponse.setETCData("inv_cnt"			, rowSet_top.getString("inv_cnt"));
				eventResponse.setETCData("csr_curr_cd"		, rowSet_top.getString("csr_curr_cd"));
				eventResponse.setETCData("csr_amt"			, rowSet_top.getString("csr_amt"));
				eventResponse.setETCData("max_iss_dt"		, rowSet_top.getString("max_iss_dt"));
				eventResponse.setETCData("max_rcv_dt"		, rowSet_top.getString("max_rcv_dt"));
				eventResponse.setETCData("asa_no"			, rowSet_top.getString("asa_no"));
				eventResponse.setETCData("vndr_term_nm"		, rowSet_top.getString("vndr_term_nm"));
				eventResponse.setETCData("cost_ofc"			, rowSet_top.getString("cost_ofc"));
				eventResponse.setETCData("payment_due_dt"	, rowSet_top.getString("pre_due_date"));
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
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void checkApInvDtrbValidation(String sCsrNo) throws EventException {
		
		try {
			log.error("\n TRS START ... checkApInvDtrbValidation:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			/** Checking Coincidence Between Total Amount and Sum of Line Amount */ 
			dbDao.checkSumLineAmountTotalAmount	(sCsrNo);
			log.error("\n TRS START ... checkApInvDtrbValidation.checkSumLineAmountTotalAmount:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** R.VVD CHECK */
			dbDao.checkRevenueVVDfromDTRB		(sCsrNo);
			log.error("\n TRS START ... checkApInvDtrbValidation.checkRevenueVVDfromDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** GL DT CHECK */
			dbDao.checkApInvHdrGLDT				(sCsrNo);			
			log.error("\n TRS START ... checkApInvDtrbValidation.checkApInvHdrGLDT:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			log.error("\n TRS FINISH ... checkApInvDtrbValidation:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_032Event
	 * @exception EventException
	 */
	public void createApInvIF(Event e) throws EventException {
		EsdTrs0032Event event	= (EsdTrs0032Event)e;
//		String	sCsrNo			= event.getCsr_no();
		
		try {			
			log.error("\n TRS START ... createApInvIF:createApInvIF.approvalRequest.updateCSRSOHDRsts"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			//dbDao.createApInvIF			(sCsrNo, event.getSignOnUserAccount().getUsr_id() );			
			//dbDao.approvalRequest		(event); // 결재 모듈을 G/W로 이관
			dbDao.checkCsrNoDup			(event);
			dbDao.updateCSRSOHDRsts		(event);

			 ApprovalUtil aproUtil = new ApprovalUtil();
			 aproUtil.updateAproGwFlg(event.getCsr_no(),event.getSignOnUserAccount().getOfc_cd()); 
			
			log.error("\n TRS FINISH ... createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 결재 - > TRS 
	 * 
	 * @param flag String
	 * @param sCsrNo
	 * @param model
	 * @return 
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String sCsrNo, ComAproRqstRoutVO model) throws EventException 
	{
		DBRowSet 				rowSet	= null;
		FNS0080003Document[] 	docReq 	= null;
		
		try {
			
			log.error("\n <<<<<<<<<<<<<<  TRS - approvalRequestAccount1 BBBB (csr_no:"+JSPUtil.getNull(sCsrNo)+") >>>>>>>>>>>>>>>");
			
			/** APPROVAL CONFIRMATION	*/
			if ( flag.equals("C") )
			{
				/** AP 인터페이스 실행하기										*/
				rowSet 	= dbDao.searchApInvInfForEAIInterface(sCsrNo);
				log.error("\n DONE - approvalRequestAccount1.searchApInvInfForEAIInterface = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				
				if( rowSet != null ){
					docReq 		= eaiDao.transferAtOnceTRS024ToEAIByWS(rowSet, sCsrNo, model);	
					log.error("\n DONE - approvalRequestAccount1.transferAtOnceTRS024ToEAIByWS = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");					
				}else{
					log.error("\n DONE -rowSet Null-approvalRequestAccount1.transferAtOnceTRS024ToEAIByWS = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				}
		
			/** APPROVAL REJECTION [DISAPPROVED]	*/
			}else if ( flag.equals("R") ){
				/** TRS_TRSP_INV_WRK [TRS_TRSP_RAIN_INV_WRK].TRSP_INV_AUD_STS_CD	= 'DA'(DISAPPROVED) UPDATE	*/
				dbDao.updateCSRSTSFlag			(sCsrNo , "DA"	);
				log.error("\n DONE - approvalRequestAccount1.updateCSRSTSFlag = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				
				/** ERP CANCEL (TRS INVOICE REJECT) DELETE AP_INV_HDR/DTRB/IF ??? --- 20070620	*/
				
			/** APPROVAL REJECTION [REJECTED]		*/		
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (EventException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return docReq;
	}
	
	/**
	 * 결재 - > TRS 
	 * 
	 * @param flag String
	 * @param sCsrNo
	 * @param model
	 * @return 
	 * @exception EventException
	 */
	public String approvalRequestAccount2(String flag, String sCsrNo, ComAproRqstRoutVO model) throws EventException 
	{
		
		String	title_name	= null;
		
		try {
			title_name	= model.getAproUsrJbTitNm()+"/"+model.getAproUsrNm();
			

			if ( flag.equals("C") ){
				/**	최종 승인자 정보( *GL_DT + APRO_FLG = 'Y' + 승인자직책/이름) UPDATE	*/
				dbDao.approvalRequestAccount	(sCsrNo, title_name);
				log.error("\n DONE - approvalRequestAccount2.approvalRequestAccount = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				
				/** TRS_TRSP_INV_WRK [TRS_TRSP_RAIN_INV_WRK].TRSP_INV_AUD_STS_CD	= 'IF'(INTERFACED) 	UPDATE	*/
				dbDao.updateCSRSTSFlag			(sCsrNo, "IF");	
				log.error("\n DONE - approvalRequestAccount2.updateCSRSTSFlag = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return "";
	}
	
	/**
	 *  AGT -- > TRS  - > LED (Succeed)
	 *  
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void approvalSuccess(String sCsrNo) throws EventException 
	{
		final String	tpbIfError	= "TPB";
		TPBInterfaceVO[] models 		= null;

		/** GL_DT UPDATE TRANSACTION */
		try {
			log.error("\n DONE - approvalSuccess.updateGLDT = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			dbDao.updateGLDT			(sCsrNo	, "U");
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.error("\n DONE - approvalSuccess.updateApInvHdrIFErrRsn(GL_DT_UPDATE_ERROR) = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			throw new EventException(de.getMessage());
		}		
		
		/** LEA I/F TRANSACTION */

		/** TPB UPDATE TRANSACTION */
		try {
			TPBInterfaceBCImpl tbpIF 	= new TPBInterfaceBCImpl();
			models = dbDao.searchTrs3PtyIF(sCsrNo);
			
			if( models != null )	tbpIF.createTRSTPB	(models);	

			log.error("\n DONE - approvalSuccess.createTRSTPB = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de1) {
			log.error("err "+de1.toString(),de1);
			try {
				dbDao.updateApInvHdrIFErrRsn(sCsrNo, tpbIfError);
				log.error("\n DONE - approvalSuccess.updateApInvHdrIFErrRsn(TPB_IF_ERROR) = CSR_NO:" + JSPUtil.getNull(sCsrNo)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} catch (DAOException de2) {
				log.error("err "+de2.toString(),de2);
				throw new EventException(de2.getMessage());
			}			
			throw new EventException(de1.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 *  AGT -- > TRS  - > LED (Reject)
	 *  
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void approvalReject(String sCsrNo) throws EventException{
		try {
			if(!"12".equals(sCsrNo.substring(0,2)))		dbDao.createInterfaceChgRevenueVVDCSRToLEA	(sCsrNo	, "CANCEL"	);		/** '13' CSR :	Revenue VVD Change AP_INV_HDR.RCV_ERR_FLG = 'E'	*/
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 *  AP Interface - > TRS 
	 *  
	 * @param obj
	 * @exception EventException
	 */
	public void modifyTrsInvHdr(Object obj) throws EventException{
		try {			
			dbDao.modifyTrsInvHdr(obj);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * CSR cancel 
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPifError(Event e) throws EventException {
		EsdTrs0047Event event=(EsdTrs0047Event)e;
		
		try {			
			dbDao.cancelCSRAPifError(event);
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CSR cancel 
	 * @param e ESD_TRS_0047Event
	 * @return EventResponse ESD_TRS_0047EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRApprovalRequest(Event e) throws EventException {
		EsdTrs0047Event event=(EsdTrs0047Event)e;
		
		try {			
			dbDao.cancelCSRApprovalRequest(event);
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CSR cancel 
	 * @param e ESD_TRS_048Event
	 * @return EventResponse ESD_TRS_048EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPif(Event e) throws EventException {

		EsdTrs0048Event event=(EsdTrs0048Event)e;
		
		try {			
			dbDao.cancelCSRAPif(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	

	
	/**
	 * 조회 이벤트 처리<br>
	 * CSRIssueTransferSlipManage ASA 번호 관련<br>
	 *
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse checkASANO(Event e) throws EventException {
		
		EsdTrs0031Event 	event	= (EsdTrs0031Event)e;
		DBRowSet 			rowSet	= null;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet	= dbDao.checkASANO(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			if(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01))
					eventResponse.setETCData("asaFlag", rowSet.getString("SO_IF_CD"));
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
	 * <br>
	 * CSRIssueTransferSlipManage鿡�� R.VVD Change<br>
	 * 
	 * @param model
	 * @param userAccount
	 * @return EventResponse ESD_TES_047EventResponse
	 * @exception EventException
	 */	
	public EventResponse applyChgRevenueVVD(LeaRevVvdCngVO model, SignOnUserAccount userAccount) throws EventException {
		
		log.error("\n\n\n\n\n BCImpl applyChgRevenueVVD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> approvalRequest");
		log.error("\n applyChgRevenueVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

		DBRowSet				rowSet		= null;
		FNS0080003Document[] 	docReq 		= null;
				
		String sNewCsrNo		= null;
		String sOldCsrNo		= JSPUtil.getNull(model.getCsrNo());
		
//		String sUserId			= JSPUtil.getNull(userAccount.getUsr_id		());	
		String sUserOfcCd		= JSPUtil.getNull(userAccount.getOfc_cd		());		
		
		try {
			
			/** STEP 00. Old CSR Number Validation Check											*/
			dbDao.checkCsrNoForApHdrDtrb						(sOldCsrNo	);
			
			/** STEP 01. New CSR Number Generation (13... >> 14... - 2008.04.14:jsk) 				*/
			sNewCsrNo	= dbDao.generateCSRNoForChgRevenueVVD	(sUserOfcCd	);
			model.setModiCsrNo(sNewCsrNo);
			log.error("\n <2> DONE - applyChgRevenueVVD.generateCSRNoForChgRevenueVVD: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 02. NEW AP_INV_HDR  INSERT
			 *  =======================================================
			 *  1. CSR_NO 		: '13S............'
			 *  2. CSR_TP_CD	: 'STANDARD'
			 *  3. GL_DT		: NEW_REV_YRMON(6) + 해당월마지막일(2)
			 *  4. CSR_AMT		: 0
			 *  5. PAY_AMT		: NULL
			 *  6. PAY_DT		: NULL
			 *  7. APRO_FLG		: 'Y' 
			 *  8. ERR_CSR_NO	: OLD CSR_NO
			 *  9. IF_FLG		: NULL
			 *  10.IF_DT		: NULL
			 *  11.IF_ERR_RSN	: NULL
			 *  12.RCV_ERR_FLG	: NULL
			 *  13.RCV_ERR_RSN	: NULL
			 *  14.USR_EML		: LEA USER EMAIL
			 *  15.CRE_DT		: SYSDATE <-- GLOBAL TIME APPLY (?)
			 *  16.CRE_USR_ID	: USER_ID
			 *  17.AFT_ACT_FLG	: NULL
			 */
			
//			 1. inv_hdr와 ap_inv_hdr 정보 가져오기
//			 2. csr_no 생성
//			 3. AP HDR 넣기
//			 4. AP DTRB 넣기
//			 5. AP DTRB line no 조정
//			 6. AP DTRB sum 조정
//			 7. ASA 적용
//			 8. AP I/F 넣기
//			 9. HDR CSR NO UPDATE 처리				???
//			 12. AP AMT 확인
//			 13. LEA_REV_VVD_CNG 수정하기
//			 14. ERP Interface 수행
			
			/** STEP 02. NEW AP_INV_HDR  INSERT														*/
			dbDao.createChgRevenueVVDForApInvHDR	(model, userAccount	);
			log.error("\n <2> DONE - applyChgRevenueVVD.createChgRevenueVVDForApInvHDR: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 03. OLD CSR Select (sCSRNo+sBkgNo+sBkgNoSplit) ==>> Insert -12 = +13 	*/
			dbDao.createChgRevenueVVDForApInvDTRB	(model, userAccount	);
			log.error("\n <2> DONE - applyChgRevenueVVD.createChgRevenueVVDForApInvDTRB: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 04. AP_INV_DTRB	Update Line_no												*/
			dbDao.modifyApInvDTRBLineNo				(sNewCsrNo			);
			log.error("\n <2> DONE - applyChgRevenueVVD.modifyApInvDTRBLineNo: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		
			/** R.VVD CHECK */
			dbDao.checkChgRevenueVVDDTRB			(sNewCsrNo);			
			
			/** STEP 04. AP_INV_IF	Create	삭제됨														*/
			//dbDao.createApInvIF						(sNewCsrNo, sUserId );
			//log.error("\n <2> DONE - applyChgRevenueVVD.createApInvIF: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 05. TRS_TRSP_INV_WRK/TRS_TRSP_RAIL_INV_WRK CSR_NO NEW_CSR_NO UPDATING			*/
			//jsk dbDao.updateChgCsrNo					(model, userAccount);
			log.error("\n <2> DONE - applyChgRevenueVVD.updateInvNewCsrNo: NEW CSRNo:"+sNewCsrNo+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** Checking Coincidence Between Total Amount and Sum of Line Amount */ 
			
			/** STEP 06. AP_INV_IF	Create															*/
			dbDao.updateLEA_REV_VVD_CNG				(model);
			log.error("\n <13> DONE - applyChgRevenueVVD.updateLEA_REV_VVD_CNG:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			

			/** STEP 07. AP 인터페이스 [ERP Interface	]												*/
			rowSet 	= dbDao.searchChgRevenueApInvInfForEAIInterface(sNewCsrNo);
			if( rowSet != null )	docReq 		= eaiDao.transferAtOnceTRS024ToEAIByWS(rowSet, sNewCsrNo, null);				
			log.error("\n <14> DONE - applyChgRevenueVVD.transferAtOnceTRS024ToEAIByWS:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 08. ERP Interface 수행															*/ 
			SendQueueBC apInvCommand = new SendQueueBCImpl();	
			apInvCommand.transferInvToERP(docReq, userAccount);
			log.error("\n <15> DONE - applyChgRevenueVVD.transferInvToERP:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			FNS0080003Document paramDoc = null;
			if (docReq != null && docReq.length > 0){
				paramDoc = docReq[0];

				if (paramDoc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0)
					paramDoc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
			}
			
			/** STEP 09. 최종 승인자/GL_DT 정보 UPDATE 처리											*/
			log.error("\n <16> DONE - applyChgRevenueVVD.approvalRequestAccount:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			/** STEP 10. INTERFACE TO LEA FOR CHANGE REVENUE VVD									*/
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);	
			throw new EventException(de.getMessage());
		}
		return null;
	}
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage鿡�� R.VVD Change<br>
	 * 
	 * @param e ESD_TRS_0047Event
	 * @return EventResponse ESD_TRS_0047EventResponse
	 * @exception EventException
	 */	
	public DBRowSet[]  generateApInvDTRB(Event e) throws EventException {
		
		DBRowSet[]			oApDtrbRowSetArr	= null;
		EsdTrs0032Event 	event				= (EsdTrs0032Event)e;
		
		try {
			
			log.error("\n generateApInvDTRB <<<GENERATING START>>>:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/** STEP 00. generating AP_INV_DTRB ArrayList									*/
			oApDtrbRowSetArr	= dbDao.generateApInvDTRB(event);
			
			log.error("\n generateApInvDTRB <<<GENERATING FINISH>>>:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);	
			throw new EventException(de.getMessage());
		}
		return oApDtrbRowSetArr;
	}	
	
	/**
	 * Office Change시 변경된 국가코드를 조회
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeChangedCntCd(String sOfficeCd) throws EventException 
	{
		String 		cnt_cd 	= "";
		try {
			cnt_cd = dbDao.searchOfficeChangedCntCd	(sOfficeCd);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		return cnt_cd;
	}
	
	/**
	 * Hold Invoice No에 대하여 체크 한다.
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckHoldInvoice(Event e) throws EventException 
	{
		String holdInvNo	= "";
		EsdTrs0032Event 	event				= (EsdTrs0032Event)e;
		
		try {
			holdInvNo = dbDao.searchCheckHoldInvoice(event);	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("holdInvNo", 	holdInvNo);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * G/L month와 ASA month일치 여부에 대하여 체크 한다.
	 * @param e Event
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckGLMonth(Event e) throws EventException 
	{
		String invNo	= "";
		EsdTrs0032Event 	event				= (EsdTrs0032Event)e;
		
		try {
			invNo = dbDao.searchCheckGLMonth(event);	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("invNo", 	invNo);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * MASTER INVOICE PDF 파일을 생성한다.
	 * 
	 * 
	 * @param String csrNo
	 * @param String vndrSeq
	 * @param String usrId
	 * @return String
	 * @throws EventException
	 */
	public String createInvPdfFile(String csrNo, String vndrSeq, String usrId) throws EventException
	{
		String file_sav_id= "";
		try {
			file_sav_id = dbDao.createInvPdfFile(csrNo, vndrSeq, usrId);
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return file_sav_id;
	}

	/**
	 * CSR Header Info
	 * @param csrNo
	 * @return ComCsrRequestHeaderVO
	 */
	public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrHeaderInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	
	/**
	 * CSR Body Info List
	 * @param csrNo
	 * @return List<ComCsrRequestBodyVO>
	 */
	public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrBodyInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CSR Agreement Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CSR File Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrFileInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	
	
	/**
	 * CSR Agreement Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo2(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * CSRIssueTransferSlipManage 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}