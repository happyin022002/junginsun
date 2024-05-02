/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CARIssueTransferSlipManageBCImpl.java
 *@FileTitle : Terminal invoice CSR Creation - Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-10-09
 *@LastModifier : jongbaemoon
 *@LastVersion : 1.0
 * 2006-12-18 jongbaemoon
 * 1.0 최초 생성
 * 2008-08-23 : AP_PERIOD 변경건 반영
 * 2009-04-28 : (국내용) CSR배부시 LANE CODE가 누락되어 금액 불일치를 유발하는 INVOICE를 추출하기
 * 2010-01-12 : 김회영 수석 요청으로 AP_INV_IF에 넣지 않도록 수정함
 * 2010.09.08 박재흥 [CHM-201005800-01] 세금계산서, 계산서 화면에서 사업자번호 자동으로 넣기
 * 2010.10.13 박재흥 [] 소스품질 적용
 * 2010.12.20 박재흥 [CHM-201007624-01] csr cancel 처리시 TPB I/F 데이타 원복 및 TPB의 Procedure 
 *                  호출시 파라미터(CSR_NO_CXL_FLG='N' 관련) 추가
 * 2015.05.29 김영신 [CHM-201536111]CSR I/F할 때 Line No 반복되지 않도록 로직 변경                 
 =========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0025Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0078Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0100Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0101Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageDBDAO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageEAIDAO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
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
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br> - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jongbaemoon
 * @see ESD_TES_024EventResponse,CARIssueTransferSlipManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CARIssueTransferSlipManageBCImpl extends BasicCommandSupport implements CARIssueTransferSlipManageBC {

	// Database Access Object
	private transient CARIssueTransferSlipManageDBDAO dbDao = null;

	// EAI Interface Object
	private transient CARIssueTransferSlipManageEAIDAO eaiDao = null;

	/**
	 * CARIssueTransferSlipManageBCImpl 객체 생성<br>
	 * CARIssueTransferSlipManageDBDAO를 생성한다.<br>
	 */
	public CARIssueTransferSlipManageBCImpl() {
		dbDao = new CARIssueTransferSlipManageDBDAO();
		eaiDao = new CARIssueTransferSlipManageEAIDAO();
	}

	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param LeaRevVvdCngVO model
	 * @param SignOnUserAccount session_usr_info
	 * @return String 
	 * @exception EventException
	 */
	public String chgLEARevVVD(LeaRevVvdCngVO model, SignOnUserAccount session_usr_info) throws EventException {
		log.error("\n BCImpl chgLEARevVVD ============================ approvalRequest");
		log.error("\n chgLEARevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		
		String ofc_cd 	= session_usr_info!=null?JSPUtil.getNull(session_usr_info.getOfc_cd()):"";
		String usr_id 	= session_usr_info!=null?JSPUtil.getNull(session_usr_info.getUsr_id()):"";
		String usr_eml	= session_usr_info!=null?JSPUtil.getNull(session_usr_info.getUsr_eml()):"";
		String vndr_seq = null;
		String curr_cd  = null;
		
		String asa_no = "";
		String new_csr_no = "";
		String chkAmt = "";
		
		String acct_cd = "954113";
		String inv_no  = "";
		String iss_dt  = "";
		String loc_cd  = "";
		String line_seq = "";
		String line_no  = "";
		String total_amt = "";
		
		String gap 			= "";
		String inv_no2 		= "";
		String cost_cd 		= "";
		String cntr_tpsz_cd = "";
		
		DBRowSet 		soRowSet 		= null;
		DBRowSet 		asaRowSet 		= null;
		DBRowSet		dtrbSumSet		= null;		
		
		TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
		ApInvHdrVO		apInvHdrVO		= null;
		ApInvDtrbVO		apInvDtrbVO		= null;
		TesTmlSoHdrVO[] tesTmlSoHdrVOs	= null;
		
		CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO = null;
		
		try {
			// 1. inv_hdr와 ap_inv_hdr 정보 가져오기 -----------------------------------------------------------------------------------------------------
//			tes_inv_hdrs = dbDao.searchSO(JSPUtil.getNull(model.getCsrNo()));
			
			soRowSet	= dbDao.searchSO(JSPUtil.getNull(model.getCsrNo()));
            if (soRowSet != null) {
            	tesTmlSoHdrVOs = new TesTmlSoHdrVO[soRowSet.getRowCount()];
            	int cnt=0;
            	
            	while(soRowSet.next()){
            		tesTmlSoHdrVOs[cnt].setIbflag("R");
            		tesTmlSoHdrVOs[cnt].setTmlSoOfcCtyCd(soRowSet.getString("tml_so_ofc_cty_cd"));
            		tesTmlSoHdrVOs[cnt].setTmlSoSeq(soRowSet.getString("tml_so_seq"));
            		tesTmlSoHdrVOs[cnt].setInvNo(soRowSet.getString("inv_no"));
            		tesTmlSoHdrVOs[cnt].setVndrSeq(soRowSet.getString("vndr_seq"));
            		tesTmlSoHdrVOs[cnt].setInvOfcCd(soRowSet.getString("inv_ofc_cd"));
            		tesTmlSoHdrVOs[cnt].setCreUsrId(soRowSet.getString("cre_usr_id"));
            		tesTmlSoHdrVOs[cnt].setCurrCd(soRowSet.getString("curr_cd"));
            		
            		cnt++;
            	}
            }
			
			log.error("\n <1> DONE - chgLEARevVVD.searchSO:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			apInvHdrVO = dbDao.searchAP_INV_HDR(JSPUtil.getNull(model.getCsrNo()));
			log.error("\n <1-2> DONE - chgLEARevVVD.searchSO:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			vndr_seq 	= apInvHdrVO!=null?JSPUtil.getNull(apInvHdrVO.getVndrNo()):"";
			curr_cd 	= apInvHdrVO!=null?JSPUtil.getNull(apInvHdrVO.getCsrCurrCd()):"";
			
			// 2. csr_no 생성 
			new_csr_no = dbDao.multiCSRNo(ofc_cd, "S", "Y");
			dbDao.multiCSRInsert(ofc_cd, new_csr_no);
			log.error("\n <2> DONE - chgLEARevVVD.multiCSRNo: NEW CSRNo:"+new_csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			

			// 3. AP HDR 넣기
			dbDao.createApInvHDR2(model, new_csr_no, usr_eml, usr_id);
			log.error("\n <3> DONE - chgLEARevVVD.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 4. AP DTRB 넣기
			dbDao.createApInvDTRB2(model, new_csr_no, ofc_cd, usr_id);
			log.error("\n <4> DONE - chgLEARevVVD.createApInvDTRB2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 5. AP DTRB line no 조정
			dbDao.modifyApInvDTRBLineNo(new_csr_no);
			log.error("\n <5> DONE - chgLEARevVVD.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 6. AP DTRB sum 조정
//			dbDao.createApInvDTRB_sum(tes_inv_hdrs, new_csr_no, curr_cd);	//	curr_cd에 대해 인수석님께 문의하고 진행할  것	
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					tesTmlSoHdrVOs[i].setCsrNo(new_csr_no);
					
					dtrbSumSet = dbDao.createApInvDTRB_sum(tesTmlSoHdrVOs[i]);
					inv_no 		= tesTmlSoHdrVOs[i].getInvNo();
					
					if (dtrbSumSet != null) {
        				while(dtrbSumSet.next()){
        					gap 			= dtrbSumSet.getString("GAP");
        					inv_no2 		= dtrbSumSet.getString("ATTR_CTNT1");
        					cost_cd 		= dtrbSumSet.getString("FTU_USE_CTNT1");
        					cntr_tpsz_cd 	= dtrbSumSet.getString("CNTR_TPSZ_CD");
    
        					if (inv_no==null || inv_no.trim().equals("") || inv_no2==null || inv_no2.trim().equals("") || !inv_no.equals(inv_no2)){
//        						throw new DAOException(new ErrorHandler("Wrong Inv.No Exception!!!").getMessage());
        						throw new EventException(new ErrorHandler("TES00080", new String[]{}).getMessage());
        					}

        					cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
            				cARIssueTransferSlipManageCommonVO.setGap(gap);
            				cARIssueTransferSlipManageCommonVO.setInvNo2(inv_no2);
            				cARIssueTransferSlipManageCommonVO.setCostCd(cost_cd);
            				cARIssueTransferSlipManageCommonVO.setCntrTpszCd(cntr_tpsz_cd);
            				
            				tesTmlSoHdrVO = new TesTmlSoHdrVO();
            				tesTmlSoHdrVO.setCurrCd(curr_cd);
            				tesTmlSoHdrVO.setCsrNo(new_csr_no);
            				
            				dbDao.createApInvDTRB_sumUpdateDiff(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO);
        				}
					}
				}
			}
			
			log.error("\n <6> DONE - chgLEARevVVD.createApInvDTRB_sum:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 7. ASA 적용
			asa_no = dbDao.searchASANo(JSPUtil.getNull(model.getCsrNo()));
			if (asa_no!=null && !asa_no.trim().equals("")) {
//				dbDao.createApInvDTRBASANo(JSPUtil.getNull(model.getCsrNo()), ofc_cd, ofc_cd, vndr_seq, usr_id, "");
				asaRowSet = dbDao.createApInvDTRBASANoSelect(model.getCsrNo());
	            if (asaRowSet != null) {
	            	while(asaRowSet.next()){
	            		inv_no  	= asaRowSet.getString("inv_no");
	            		iss_dt  	= asaRowSet.getString("iss_dt");
	            		loc_cd		= asaRowSet.getString("loc_cd");
	            		line_seq	= asaRowSet.getString("line_seq");
	            		line_no		= asaRowSet.getString("line_no");
	            		total_amt	= asaRowSet.getString("total_amt");
	            	}
	            }
	            
	            tesTmlSoHdrVO = new TesTmlSoHdrVO();
	            apInvDtrbVO	  = new ApInvDtrbVO();	
	            cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
	            
	            tesTmlSoHdrVO.setInvNo(inv_no);
	            tesTmlSoHdrVO.setIssDt(iss_dt);
	            cARIssueTransferSlipManageCommonVO.setLocCd(loc_cd);
	            apInvDtrbVO.setLineSeq(line_seq);
	            apInvDtrbVO.setLineNo(line_no);
	            cARIssueTransferSlipManageCommonVO.setTotalAmt(total_amt);
	            
	            cARIssueTransferSlipManageCommonVO.setAcctCd(acct_cd);
	            tesTmlSoHdrVO.setCostOfcCd(ofc_cd);
	            tesTmlSoHdrVO.setVndrSeq(vndr_seq);
	            
	            dbDao.createApInvDTRBASANoInsert(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO, apInvDtrbVO, ofc_cd, usr_id);
				dbDao.createApInvDTRBASANoUpdate(model.getCsrNo());
				
				log.error("\n <7> DONE - approvalRequest.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			}
			
			/**
			 * 2010/01/12  김회영 수석 요청으로 AP_INV_IF에 넣지 않도록 수정함. 
			 */
			// 8. AP I/F 넣기
//			pgm_no = dbDao.createApInvIF(new_csr_no);	
//			log.error("\n <8> DONE - chgLEARevVVD.createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 9. HDR CSR NO UPDATE 처리
//			dbDao.upateInvCSRNo(tes_inv_hdrs, new_csr_no);
//			log.error("\n <9> DONE - chgLEARevVVD.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 10.EP 결제하기 - 필요없나요?
//			dbDao.createCSREPApproval(event.getParam_map());  //문제  --- ******
//			log.error("\n <10> DONE - chgLEARevVVD.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 11. tml_inv_sts_cd 'A' 결제하기
//			dbDao.modifyStsCdSOHDR(tes_inv_hdrs, "A");	
//			log.error("\n <11> DONE - chgLEARevVVD.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 12. AP AMT 확인
			chkAmt = dbDao.checkCSRAmtVsInvAmt(new_csr_no);
			log.error("\n <12> DONE - chgLEARevVVD.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact LEA.");
				throw new EventException(new ErrorHandler("TES00087", new String[]{}).getMessage());
				
			}
			
			// 13. LEA_REV_VVD_CNG 수정하기 
			dbDao.updateLEA_REV_VVD_CNG(model, new_csr_no);
			log.error("\n <13> DONE - chgLEARevVVD.updateLEA_REV_VVD_CNG:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			
			
			// 14. ERP Interface 수행 -----------------------------------------------------------------------------------------------------
			FNS0080003Document[] docReq = null;
			docReq = approvalRequestAccountLEA1(new_csr_no);
			log.error("\n <14> DONE - chgLEARevVVD.approvalRequestAccountLEA1:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			SendQueueBC apInvCommand = new SendQueueBCImpl();	
			apInvCommand.transferInvToERP(docReq, session_usr_info);
			log.error("\n <15> DONE - chgLEARevVVD.transferInvToERP:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			FNS0080003Document paramDoc = null;
			if (docReq != null && docReq.length > 0) {
				paramDoc = docReq[0];
			}
			approvalRequestAccountLEA2(new_csr_no, paramDoc);
			log.error("\n <16> DONE - chgLEARevVVD.approvalRequestAccountLEA2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			
		} catch (SQLException se) {
			log.error("err "+se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);	
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);	
			throw new EventException(ex.getMessage());
		}
		
		return "Y";
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e  EsdTes0023Event
	 *           
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0023Event event = (EsdTes0023Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchCSRSummary(event.getTesTmlSoHdrVO());
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0023Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchSoIfCd(Event e) throws EventException {
		log.debug("start searchSoIfCd ===================");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0023Event event = (EsdTes0023Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String so_if_cd = "";

		try {
			so_if_cd	= dbDao.searchSoIfCd(event);
			
			eventResponse.setETCData("so_if_cd", so_if_cd);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
			
//			return new ESD_TES_023EventResponse(rowSet, so_if_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary1(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0023Event 		event 			= (EsdTes0023Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchCSRSummary1(event.getTesTmlSoHdrVO());
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail ===================");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event event = (EsdTes0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> arrList = new ArrayList<DBRowSet>();
		

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT CSR DETAIL 일 경우 S로 고정, 대체전표 경우 C로 고정

		try {
			rowSet 		= dbDao.searchCSRSummaryDetail(event.getTesTmlSoHdrVO());
			asaSet 		= dbDao.searchASANOList(event.getSignOnUserAccount().getOfc_cd());
			//csrNo 	= dbDao.multiCSRNo(event.getParam_map(), csr_no_sub);
			ap_ofc_cd 	= dbDao.searchApOfcCD(event.getSignOnUserAccount().getOfc_cd());
			
			arrList.add(rowSet);
			arrList.add(asaSet);
			eventResponse.setRsList(arrList);
			
			eventResponse.setETCData("csrNo", csrNo);
			eventResponse.setETCData("ap_ofc_cd", ap_ofc_cd);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
//			return new ESD_TES_024EventResponse(rowSet, asaSet, csrNo, ap_ofc_cd, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0080Event
	 * @return  EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail2(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail2 ==============");
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0080Event event = (EsdTes0080Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> arrList = new ArrayList<DBRowSet>();
		

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT CSR DETAIL 일 경우 S로 고정, 대체전표 경우 C로 고정

		try {
			rowSet 		= dbDao.searchCSRSummaryDetail(event.getTesTmlSoHdrVO());
			asaSet 		= dbDao.searchASANOList(event.getSignOnUserAccount().getOfc_cd());
			//csrNo 	= dbDao.multiCSRNo(event.getParam_map(), csr_no_sub);
			ap_ofc_cd 	= dbDao.searchApOfcCD(event.getSignOnUserAccount().getOfc_cd());
			
			arrList.add(rowSet);
			arrList.add(asaSet);
			eventResponse.setRsList(arrList);
			
			eventResponse.setETCData("csrNo", csrNo);
			eventResponse.setETCData("ap_ofc_cd", ap_ofc_cd);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
//			return new ESD_TES_024EventResponse(rowSet, asaSet, csrNo, ap_ofc_cd, "SUCCESS");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail1(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event 		event 			= (EsdTes0024Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		List<DBRowSet>			arrList			= new ArrayList<DBRowSet>();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT CSR DETAIL 일 경우 S로 고정, 대체전표 경우 C로 고정

		try {
			rowSet = dbDao.searchCSRSummaryDetail1(event.getTesTmlSoHdrVO());
			asaSet = dbDao.searchASANOList(event.getSignOnUserAccount().getOfc_cd());
			//csrNo = dbDao.multiCSRNo(event.getParam_map(), csr_no_sub);
			ap_ofc_cd = dbDao.searchApOfcCD(event.getSignOnUserAccount().getOfc_cd());
			
			arrList.add(rowSet);
			arrList.add(asaSet);
			//eventResponse.setRsList(arrList);
			
			eventResponse.setRs(rowSet);
			
			if(asaSet != null){
				asaSet.next();
				eventResponse.setETCData("asaNoString", asaSet.getString("asanostring"));
				eventResponse.setETCData("asaCurrCdstring", asaSet.getString("asacurrcdstring"));
			}
			
			eventResponse.setETCData("successFlag", "SUCCESS");
			eventResponse.setETCData("apOfcCd", ap_ofc_cd);
			eventResponse.setETCData("csrNo", csrNo);
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESDTES0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse tmpSearchPreVeiw(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event 		event 			= (EsdTes0024Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet hdrSet  = null;
		DBRowSet dtrbSet = null;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		HashMap param_map = (HashMap) event.getParam_map();
//		//String asa_no = param_map != null ? (String) param_map.get("asa_no") : "";
//		String csr_no = param_map != null ? (String) param_map.get("csr_no") : "";

		try {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> tmpSearchPreVeiw");
			
			hdrSet  = dbDao.searchPreviewHDR(event.getTesTmlSoHdrVO().getCsrNo());
			dtrbSet = dbDao.searchPreviewDTRBList(event.getTesTmlSoHdrVO().getCsrNo());		
			
			List<DBRowSet> arrList = new ArrayList<DBRowSet>();
			
			arrList.add(hdrSet);
			arrList.add(dtrbSet);
			eventResponse.setRsList(arrList);
			
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}	

	/** getAutoRevVVDList 자동계산된 재무항차 리스트를 가져온다.
	 * 
	 * @param Event EsdTes0024Event
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] getAutoRevVVDList(Event e) throws EventException {
		log.debug("start getAutoRevVVDList ==================");
		
		EsdTes0024Event 	event 			= (EsdTes0024Event) e;
		TesTmlSoHdrVO[]		tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet[]			arrDrs			= null;
		DBRowSet			drs				= null;
		String				ap_ofc_cd		= "";	
		
		try {
			if(tesTmlSoHdrVOs != null) arrDrs = new DBRowSet[tesTmlSoHdrVOs.length];
			ap_ofc_cd  = event.getCARIssueTransferSlipManageCommonVO().getApOfcCd();
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					drs = dbDao.getAutoRevVVDList(tesTmlSoHdrVOs[i], ap_ofc_cd);
					arrDrs[i] = drs;
				}
			}// end for
			
			//dRsArr = dbDao.getAutoRevVVDList();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return arrDrs;
	}
	
	
	/** getManualRevVVDList 수동계산된 재무항차를 가져온다.
	 * 
	 * @param e Event
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] getManualRevVVDList(Event e) throws EventException {
		log.debug("start getManualRevVVDList====================");

		EsdTes0024Event event = (EsdTes0024Event) e;
		
		TesTmlSoHdrVO[]		tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet[]			arrDrs			= null;
		DBRowSet			drs				= null;
		String				ap_ofc_cd		= "";	
		

		try {
			if(tesTmlSoHdrVOs != null) arrDrs = new DBRowSet[tesTmlSoHdrVOs.length];
			ap_ofc_cd  = event.getCARIssueTransferSlipManageCommonVO().getApOfcCd();
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					drs = dbDao.getManualRevVVDList(tesTmlSoHdrVOs[i], ap_ofc_cd);
					arrDrs[i] = drs;
				}
			}// end for
			
			//dRsArr = dbDao.getManualRevVVDList(event.getTES_TML_SO_HDRS(),event.getParam_map());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return arrDrs;
	}
	
	/** modifyAutoRevVVD 재무항차 수정
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	public void modifyAutoRevVVD(Event e) throws EventException {
		log.debug("start modifyAutoRevVVD ================");
		
		EsdTes0024Event 			event 	= (EsdTes0024Event) e;
		List<TesTmlSoCntrListVO> 	voList 	= new ArrayList<TesTmlSoCntrListVO>();
		
		TesTmlSoCntrListVO			tesTmlSoCntrListVO = null;
		DBRowSet[] 					arrDrs	= event.getAutoRowSetArr01();
		
		try {
			if(arrDrs!=null){
				for(int j=0; j<arrDrs.length; j++){
					while (arrDrs[j].next()){
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
						
						tesTmlSoCntrListVO.setFincVslCd(arrDrs[j].getString("finc_vsl_cd"));
						tesTmlSoCntrListVO.setFincSkdVoyNo(arrDrs[j].getString("finc_skd_voy_no"));
						tesTmlSoCntrListVO.setFincSkdDirCd(arrDrs[j].getString("finc_skd_dir_cd"));
						tesTmlSoCntrListVO.setCntrNo(arrDrs[j].getString("cntr_no"));
						tesTmlSoCntrListVO.setTmlSoOfcCtyCd(arrDrs[j].getString("tml_so_ofc_cty_cd"));
						tesTmlSoCntrListVO.setTmlSoSeq(arrDrs[j].getString("tml_so_seq"));
						tesTmlSoCntrListVO.setTmlSoCntrListSeq(arrDrs[j].getString("tml_so_cntr_list_seq"));
						
						voList.add(tesTmlSoCntrListVO);
					}
				}
			}
			
			dbDao.modifyAutoRevVVD(voList);
				
			//dbDao.modifyAutoRevVVD(event.getAutoRowSetArr01());
			
			log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/** modifyManualRevVVD 재무항차 수정
	 * 
	 * @param e EventEvent
	 * @throws EventException
	 */
	public void modifyManualRevVVD(Event e) throws EventException {
		log.debug("start modifyManualRevVVD ===========================");
		
		EsdTes0024Event 	event 	= (EsdTes0024Event) e;
		List<TesTmlSoDtlVO> voList 	= new ArrayList<TesTmlSoDtlVO>();
		
		TesTmlSoDtlVO		tesTmlSoDtlVO = null;
		DBRowSet[] 			arrDrs	= event.getManualRowSetArr01();
		
		try {
			if(arrDrs!=null){
				for(int j=0; j<arrDrs.length; j++){
					if(arrDrs[j]!=null){
						while(arrDrs[j].next()){
							tesTmlSoDtlVO = new TesTmlSoDtlVO();
							
							tesTmlSoDtlVO.setFincVslCd(arrDrs[j].getString("finc_vsl_cd"));
							tesTmlSoDtlVO.setFincSkdVoyNo(arrDrs[j].getString("finc_skd_voy_no"));
							tesTmlSoDtlVO.setFincSkdDirCd(arrDrs[j].getString("finc_skd_dir_cd"));
							tesTmlSoDtlVO.setLgsCostCd(arrDrs[j].getString("lgs_cost_cd"));
							tesTmlSoDtlVO.setTmlSoOfcCtyCd(arrDrs[j].getString("tml_so_ofc_cty_cd"));
							tesTmlSoDtlVO.setTmlSoSeq(arrDrs[j].getString("tml_so_seq"));
							tesTmlSoDtlVO.setTmlSoDtlSeq(arrDrs[j].getString("tml_so_dtl_seq"));
							voList.add(tesTmlSoDtlVO);
						}
					}
				}
			}
			
			dbDao.modifyManualRevVVD(voList);	
			
			//dbDao.modifyManualRevVVD(event.getManualRowSetArr01());			
			log.error("\n DONE - searchPreVeiw.modifyManualRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
		
	/** searchApInvDTRBIn 
	 * 
	 * @param Event e
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] searchApInvDTRBIn(Event e) throws EventException {
		log.debug("start searchApInvDTRBIn ============================");
		
		EsdTes0024Event 	event 			= (EsdTes0024Event) e;		
		TesTmlSoHdrVO[]		tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet[]			arrDrs			= null;
		DBRowSet			drs				= null;
		int					seq				= 1;
			
		
		try {
			if(tesTmlSoHdrVOs != null) arrDrs = new DBRowSet[tesTmlSoHdrVOs.length];
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					drs = dbDao.searchApInvDTRBIn(tesTmlSoHdrVOs[i], seq);
					arrDrs[i] = drs;
					seq++;
				}
			}// end for 
			
			//dRsArr = dbDao.searchApInvDTRBIn(event.getTES_TML_SO_HDRS(), event.getParam_map());
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return arrDrs;
	}
	
	/** searchApInvDTRBOut
	 * 
	 * @param e Event
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] searchApInvDTRBOut(Event e) throws EventException {

		EsdTes0024Event 	event = (EsdTes0024Event) e;
		TesTmlSoHdrVO[]		tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet[]			arrDrs			= null;
		DBRowSet			drs				= null;
		int					seq				= 1;
		
		try {
			if(tesTmlSoHdrVOs != null) arrDrs = new DBRowSet[tesTmlSoHdrVOs.length];
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					drs = dbDao.searchApInvDTRBOut(tesTmlSoHdrVOs[i], seq);
					arrDrs[i] = drs;
					seq++;
				}
			}// end for
			
			//dRsArr = dbDao.searchApInvDTRBOut(event.getTES_TML_SO_HDRS(), event.getParam_map());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return arrDrs;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse tmpSearchCSRSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event 		event 			= (EsdTes0024Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet hdrSet 			= null;
		DBRowSet dtrbSet 			= null;

		String cost_ofc_cd			= "";	
		String vndr_seq				= "";		
		String vndr_seq_name		= "";	
		String curr_cd				= "";		
		String hdr_total_amt		= "";
		String payment_due_dt		= "";		

      	
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//HashMap param_map = (HashMap) event.getParam_map();
		//String asa_no = param_map != null ? (String) param_map.get("asa_no") : "";
		//String csr_no = param_map != null ? (String) param_map.get("csr_no") : "";

		try {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> tmpSearchCSRSummary");
			hdrSet	= dbDao.tmpSearchCSRSummary(event);
			dtrbSet	= dbDao.tmpSearchCSRSummaryList(event);

			eventResponse.setRs(dtrbSet);
			
			if(hdrSet!=null){
				while(hdrSet.next()){
			      	cost_ofc_cd 	= JSPUtil.getNull(hdrSet.getString("cost_ofc_cd"));
			      	vndr_seq 		= JSPUtil.getNull(hdrSet.getString("vndr_seq"));
			      	vndr_seq_name 	= JSPUtil.getNull(hdrSet.getString("inv_desc"));
			      	curr_cd 		= JSPUtil.getNull(hdrSet.getString("curr_cd"));
			      	hdr_total_amt 	= JSPUtil.getNull(hdrSet.getString("csr_amt")); 
			      	payment_due_dt 	= JSPUtil.getNull(hdrSet.getString("payment_due_dt")); 	 

				}
			}
			
//			eventResponse.setETCData("pre_csr_no", pre_csr_no);
			eventResponse.setETCData("cost_ofc_cd", cost_ofc_cd);
			eventResponse.setETCData("vndr_seq", vndr_seq);
			eventResponse.setETCData("vndr_seq_name", vndr_seq_name);
			eventResponse.setETCData("curr_cd", curr_cd);
			eventResponse.setETCData("hdr_total_amt", hdr_total_amt);
			eventResponse.setETCData("payment_due_dt", payment_due_dt);
			
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreVeiw(Event e) throws EventException {
		log.debug("\n\n\n  BCImpl searchPreVeiw >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> searchPreVeiw");

		EsdTes0024Event event = (EsdTes0024Event) e;

		DBRowSet hdrSet 		= null;
		DBRowSet dtrbSet 		= null;
		DBRowSet dtrbSumSet 	= null;
		DBRowSet asaRowSet 		= null;
		DBRowSet[] dtrbSets		= null;
		
		DBRowSet dtrbLineSet 	= null;
		
		
		ApInvDtrbVO 	apInvDtrbVO 	= null;
		TesTmlSoHdrVO[] tesTmlSoHdrVOs  = null;
		TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
		CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO = null;

		String			asa_no			= event.getCARIssueTransferSlipManageCommonVO().getAsaNo();
		String 			csr_no 			= event.getApInvHdrVO().getCsrNo();
		String 			cnt_cd 			= event.getCARIssueTransferSlipManageCommonVO().getCntCd();
		String 			evi_gb 			= event.getCARIssueTransferSlipManageCommonVO().getEviGb();	
		String			ofc_cd			= event.getSignOnUserAccount().getOfc_cd();
		String			curr_cd			= event.getTesTmlSoHdrVO().getCurrCd();

		String 			acct_cd 		= "954113";
		String 			inv_no  		= "";
		String 			iss_dt  		= "";
		String 			loc_cd  		= "";
		String 			line_seq 		= "";
		String 			line_no  		= "";
		String 			total_amt 		= "";
		
		String 			gap 			= "";
		String 			inv_no2 		= "";
		String 			cost_cd 		= "";
		String 			cntr_tpsz_cd 	= "";
		
		List<ApInvDtrbVO> apInsVoList 	= new ArrayList<ApInvDtrbVO>();
		List<ApInvDtrbVO> lineNoVoList 	= new ArrayList<ApInvDtrbVO>();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			// 2007-12-10 : invoice의 상태를 확인
			new TESInvoiceCommonBCImpl().checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
			csr_no = dbDao.multiCSRNo(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), event.getApInvHdrVO().getCsrTpCd(),"");	
			
			event.getTesTmlSoHdrVO().setCsrNo(csr_no);
			event.getApInvHdrVO().setCsrNo(csr_no);
			event.getApInvDtrbVO().setCsrNo(csr_no); // csr_no 값을 넣어준다.
			
			log.error("\n =============== searchPreVeiw.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
//			param_map.put("csr_no",csr_no);			
			
//			// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리 
//			dbDao.modifyAutoRevVVD(event.getAutoRowSetArr01());
//			log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
//			dbDao.modifyManualRevVVD(event.getManualRowSetArr01());			
//			log.error("\n DONE - searchPreVeiw.modifyManualRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dbDao.createApInvHDR(event);			
			log.error("\n DONE - searchPreVeiw.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			/**
			 * AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE한다.  
			 */
			dbDao.updateApInvHdrPDTApproval(csr_no);
			
			/**
			 * 환율 상태 확인 : AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE후에 USD환율이 NULL이거나 해당기간에 USD 환율변환이 안되는 상태면 띵긴다.  
			 */
			dbDao.checkUSDExchSts(csr_no);
			
			if (cnt_cd.equals("KR")){				
				dtrbSets = event.getDtrbRowSetArr();
				
				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
					if(dtrbSets[j]!=null){
						while(dtrbSets[j].next()){
							apInvDtrbVO = new ApInvDtrbVO();

							apInvDtrbVO.setCsrNo(csr_no);
							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
							
							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));

							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));

							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));

							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));

							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
							apInvDtrbVO.setCreDt(ofc_cd);
							//apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));

							apInsVoList.add(apInvDtrbVO);
						}
					}
				}
				
				dbDao.createApInvDTRB(apInsVoList); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvHdrUpdate(event);
				
				log.error("\n DONE - searchPreVeiw.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				if (evi_gb.equals("1") || evi_gb.equals("2")){					
					dbDao.createApInvDTRBEvi(event);
					log.error("\n DONE - searchPreVeiw.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				}				
			} else {
				dtrbSets = event.getDtrbRowSetArr();
				
				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
					if(dtrbSets[j]!=null){
						while(dtrbSets[j].next()){
							apInvDtrbVO = new ApInvDtrbVO();

							apInvDtrbVO.setCsrNo(csr_no);
							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
							
							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));

							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));

							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));

							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));

							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
							apInvDtrbVO.setCreDt(ofc_cd);
//							apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());							
							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));

							apInsVoList.add(apInvDtrbVO);
						}
					}
				}
				
				dbDao.createApInvDTRB(apInsVoList); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvHdrUpdate(event);
				
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map()); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				log.error("\n DONE - searchPreVeiw.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
						
			tesTmlSoHdrVOs = event.getTesTmlSoHdrVOs();
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					tesTmlSoHdrVOs[i].setCsrNo(csr_no);
					
					dtrbSumSet 	= dbDao.createApInvDTRB_sum(tesTmlSoHdrVOs[i]);
					inv_no 		= tesTmlSoHdrVOs[i].getInvNo();
	
					if (dtrbSumSet != null) {
        				while(dtrbSumSet.next()){
        					gap 			= dtrbSumSet.getString("GAP");
        					inv_no2 		= dtrbSumSet.getString("ATTR_CTNT1");
        					cost_cd 		= dtrbSumSet.getString("FTU_USE_CTNT1");
        					cntr_tpsz_cd 	= dtrbSumSet.getString("CNTR_TPSZ_CD");
    
        					if (inv_no==null || inv_no.trim().equals("") || inv_no2==null || inv_no2.trim().equals("") || !inv_no.equals(inv_no2)){
//        						throw new DAOException(new ErrorHandler("Wrong Inv.No Exception!!!").getMessage());
        						throw new EventException(new ErrorHandler("TES00080", new String[]{}).getMessage());
        					}

        					cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
            				cARIssueTransferSlipManageCommonVO.setGap(gap);
            				cARIssueTransferSlipManageCommonVO.setInvNo2(inv_no2);
            				cARIssueTransferSlipManageCommonVO.setCostCd(cost_cd);
            				cARIssueTransferSlipManageCommonVO.setCntrTpszCd(cntr_tpsz_cd);
            				
            				tesTmlSoHdrVO = new TesTmlSoHdrVO();
            				tesTmlSoHdrVO.setCurrCd(curr_cd);
            				tesTmlSoHdrVO.setCsrNo(csr_no);
            				
            				dbDao.createApInvDTRB_sumUpdateDiff(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO);
        				}
					}
				}
			}
//			dbDao.createApInvDTRB_sum(event.getTES_TML_SO_HDRS(), (String)event.getParam_map().get("csr_no"), (String)event.getParam_map().get("curr_cd"));
			log.error("\n DONE - searchPreVeiw.createApInvDTRB_sum:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			
			dbDao.modifyApInvDTRBLineNo(csr_no);
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(event.getApInvDtrbVO());
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_Acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					apInvDtrbVO.setFtuUseCtnt1(dtrbLineSet.getString("ftu_use_ctnt1"));		//[CHM-201536111]CSR I/F할 때 Line No 반복되지 않도록 로직 변경
					
					lineNoVoList.add(apInvDtrbVO);
				}
			}
			dbDao.modifyApInvDTRBLineNo02(lineNoVoList); 
			log.error("\n DONE - searchPreVeiw.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

			
			
			if (!asa_no.equals("")) {
//				dbDao.createApInvDTRBASANo((String)event.getParam_map().get("csr_no"), (String)event.getParam_map().get("ofc_cd"), (String)event.getParam_map().get("cost_ofc_cd"), (String)event.getParam_map().get("vndr_seq"), (String)event.getParam_map().get("cre_use_id"), "preview");
				
				asaRowSet = dbDao.createApInvDTRBASANoSelect(csr_no);
	            if (asaRowSet != null) {
	            	while(asaRowSet.next()){
	            		inv_no  	= asaRowSet.getString("inv_no");
	            		iss_dt  	= asaRowSet.getString("iss_dt");
	            		loc_cd		= asaRowSet.getString("loc_cd");
	            		line_seq	= asaRowSet.getString("line_seq");
	            		line_no		= asaRowSet.getString("line_no");
	            		total_amt	= asaRowSet.getString("total_amt");
	            	}
	            }
	            
	            tesTmlSoHdrVO = new TesTmlSoHdrVO();
	            apInvDtrbVO	  = new ApInvDtrbVO();	
	            cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
	            
	            tesTmlSoHdrVO.setInvNo(inv_no);
	            tesTmlSoHdrVO.setIssDt(iss_dt);
	            cARIssueTransferSlipManageCommonVO.setLocCd(loc_cd);
	            apInvDtrbVO.setLineSeq(line_seq);
	            apInvDtrbVO.setLineNo(line_no);
	            cARIssueTransferSlipManageCommonVO.setTotalAmt(total_amt);
	            
	            cARIssueTransferSlipManageCommonVO.setAcctCd(acct_cd);
	            tesTmlSoHdrVO.setCostOfcCd(event.getTesTmlSoHdrVO().getCostOfcCd());
	            tesTmlSoHdrVO.setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
	            
	            apInvDtrbVO.setCsrNo(csr_no);
	            dbDao.createApInvDTRBASANoInsert(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO, apInvDtrbVO, ofc_cd, event.getSignOnUserAccount().getUsr_id());
	            dbDao.createApInvDTRBASANoUpdate(csr_no);
				log.error("\n DONE - searchPreVeiw.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}

			
			// 5. R.VVD LEVEL CHECK
//			log.debug("\n\n RevVVD chk XXXXX---------------------- \n\n");
//			dbDao.searchApInvVVDChacke(csr_no); //test용 - 아직까지는 approvalRequest할때만 RevVVD확인합당.
			
			
			log.debug("\n\n  ### ofc_cd:"+ofc_cd);
			if (ofc_cd!=null && !ofc_cd.trim().equals("")){
				if (!ofc_cd.trim().equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
					// 2007-07-19 : RevVVD 관련 검사 - 200706 이후 ATB_DT기준 계산 기준 검사
					
				DBRowSet 	costCdSet		= dbDao.checkCalcCostCD(csr_no);
				String 		chk				= "";
				String 		tmp_wrong_inv	= "";
				String 		tmp_no_dtl_inv	= "";
				int 		knt_wrong_inv 	= 0;
				int 		knt_no_dtl_inv 	= 0;
				
				while (costCdSet.next()){
					chk = costCdSet.getString("CHK");
					log.debug("\n\n  INV_NO:"+costCdSet.getString("INV_NO") + " - LGS_COST_CD:"+costCdSet.getString("LGS_COST_CD")+"  ---------------------  --------------------- ---------------------  \n\n");
					if (chk!=null && chk.trim().equals("N")){
						tmp_wrong_inv = tmp_wrong_inv + ((costCdSet.isFirst()?"":(++knt_wrong_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
					} else if (chk!=null && chk.trim().equals("NF")){
						tmp_no_dtl_inv = tmp_no_dtl_inv + ((costCdSet.isFirst()?"":(++knt_no_dtl_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
					}
				}

	log.debug("\n\n %%%%% tmp_wrong_inv : "+tmp_wrong_inv + " %%%%% %%%%% %%%%% \n");
	log.debug("\n\n %%%%% tmp_no_dtl_inv : "+tmp_no_dtl_inv + " %%%%% %%%%% %%%%% \n");
				if (tmp_wrong_inv!=null && !tmp_wrong_inv.trim().equals("")){
//					throw new DAOException("\n\n The cost was not calculated automatically at the invoice "+tmp_wrong_inv+". \n");
					throw new EventException(new ErrorHandler("TES00085", new String[]{tmp_wrong_inv}).getMessage());					
				}
				if (tmp_no_dtl_inv!=null && !tmp_no_dtl_inv.trim().equals("")){
//					throw new DAOException("\n\n There is no calculation data at the invoice "+tmp_no_dtl_inv+". \n");
					throw new EventException(new ErrorHandler("TES00086", new String[]{tmp_no_dtl_inv}).getMessage());					
				}
					
				}
			} else {
				log.debug("\n\n ofc_cd NULL exception!!! ------------------------------- \n");
//				throw new DAOException("\n\n Inv Office is invalid ");
				throw new EventException(new ErrorHandler("TES00082", new String[]{}).getMessage());				
			}
			
			
			/** BBBB -- TEST용으로 임시고 운영 반영시에는 지운다. **/
//			dbDao.checkMissingLaneCode(event.getTES_TML_SO_HDRS(), cnt_cd);
//			String chkAmt = "";
//			chkAmt = dbDao.checkCSRAmtVsInvAmt(csr_no);
//			log.error("\n DONE - approvalRequest.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
//			}
//			dbDao.checkMstRevVVD(csr_no);
			/** EEEE -- TEST용으로 임시고 운영 반영시에는 지운다. **/

			
			hdrSet = dbDao.searchPreviewHDR(csr_no);
			log.error("\n DONE - searchPreVeiw.searchPreviewHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dtrbSet = dbDao.searchPreviewDTRBList(csr_no);
			

			String pre_csr_no			= "";	
			String pre_office			= "";		
			String pre_prpd_dy			= "";	
			String pre_pay_to			= "";		
			String pre_csr_type			= "";
			String pre_desc				= "";		
			String pre_pay_group		= "";	
			String pre_evi_tp			= "";		
			String pre_due_date			= ""; 
			String pre_asa_no			= "";		
			String pre_inv_dt			= "";		
			String pre_curr_cd			= "";	
			String pre_amt				= "";
			// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
			String chk_addr1	    	= "";
			String chk_addr2	    	= "";
			String chk_addr3	    	= "";
			String chk_cty_nm	    	= "";
			String chk_ste_cd	    	= "";
			String chk_zip_cd	    	= "";
			String chk_cnt_cd	    	= "";
			
			if(hdrSet!=null){
				while(hdrSet.next()){
					pre_csr_no			= hdrSet.getString("pre_csr_no");
					pre_office			= hdrSet.getString("pre_office"); 
					pre_prpd_dy			= hdrSet.getString("pre_prpd_dy");
					pre_pay_to			= hdrSet.getString("pre_pay_to");
					pre_csr_type		= hdrSet.getString("pre_csr_type"); 
					pre_desc			= hdrSet.getString("pre_desc");
					pre_pay_group		= hdrSet.getString("pre_pay_group");
					pre_evi_tp			= hdrSet.getString("pre_evi_tp");
					pre_due_date		= hdrSet.getString("pre_due_date"); 
					pre_asa_no			= hdrSet.getString("pre_asa_no");
					pre_inv_dt			= hdrSet.getString("pre_inv_dt");
					pre_curr_cd			= hdrSet.getString("pre_curr_cd"); 
					pre_amt				= hdrSet.getString("pre_amt");
				
					chk_addr1	    	= hdrSet.getString("chk_addr1");  
					chk_addr2	    	= hdrSet.getString("chk_addr2");  
					chk_addr3	    	= hdrSet.getString("chk_addr3");  
					chk_cty_nm	    	= hdrSet.getString("chk_cty_nm");  
					chk_ste_cd	    	= hdrSet.getString("chk_ste_cd");  
					chk_zip_cd	    	= hdrSet.getString("chk_zip_cd");  
					chk_cnt_cd	    	= hdrSet.getString("chk_cnt_cd");  
				}
			}
			
			/*
			* approval step 저장 및 유효성 검사
			* ALPS에서 Approval Step을 지정하지 않음(2014.09.29)
			
			dbDao.createCSREPApproval(event);
			String apro_step_chk = new ApprovalUtil().checkAproStepSts(csr_no,event.getSignOnUserAccount().getUsr_id());
			log.error("\n\n TES CSR Preview - csr_no : " + JSPUtil.getNull(csr_no) + " --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + " ======================= \n\n");
			if (apro_step_chk!=null){
				 
				 // P : 10만불 이상인데 PDT 미지정
				 // M : 10만불 이하인데 본부장 미지정
				 // K : Approval Step PDT/본부장 포함 2단계 이하인 경우
				 // E : 오류
				 // I : CEO는 항상 제일 뒤에 위치하는지 검사 
				 // Y : 정상
				 // X : [2014-07,08] PDT 지시 시항 적용 대상이 아님
				 // F : PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT/본부장 결재 우회 허용 
				 // C : 운하통과료 (SO_PORT) -> 결재자 상관없이 무조건 통과 요청
				
				if (apro_step_chk.trim().equals("P")){
					throw new EventException(new ErrorHandler("CSR10011", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("M")){
					throw new EventException(new ErrorHandler("CSR10012", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("K")){
					throw new EventException(new ErrorHandler("CSR10014", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("E")){
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("Y") || apro_step_chk.trim().equals("X")){
					log.error("\n >>>>>>>>>>>>>>>>>>>>> [PASS] csr_no: " + JSPUtil.getNull(csr_no) + " <<<<<<<<<<<<<<<<<<<<< \n");
				} else {
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());					
				}
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
			}
			new ApprovalUtil().deltComAproStep(csr_no); //반드시 CSR preview 에서만 삭제처리가 요함 (필요한지 확인하고 하셩)
			*/
			
			
			log.error("\n DONE - searchPreVeiw.searchPreviewDTRBList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dbDao.deleteApInvHDRDTRB(csr_no);
			dbDao.deleteApInvHDRDTRB02(csr_no); // 기존것을 나누어서 
			
			log.error("\n DONE - searchPreVeiw.deleteApInvHDRDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n");
			
			eventResponse.setRs(dtrbSet);
			
			eventResponse.setETCData("pre_csr_no", pre_csr_no);
			eventResponse.setETCData("pre_office", pre_office);
			eventResponse.setETCData("pre_prpd_dy", pre_prpd_dy);
			eventResponse.setETCData("pre_pay_to", pre_pay_to);
			eventResponse.setETCData("pre_csr_type", pre_csr_type);
			eventResponse.setETCData("pre_desc", pre_desc);
			eventResponse.setETCData("pre_pay_group", pre_pay_group);
			eventResponse.setETCData("pre_evi_tp", pre_evi_tp);
			eventResponse.setETCData("pre_due_date", pre_due_date);
			eventResponse.setETCData("pre_asa_no", pre_asa_no);
			eventResponse.setETCData("pre_inv_dt", pre_inv_dt);
			eventResponse.setETCData("pre_curr_cd", pre_curr_cd);
			eventResponse.setETCData("pre_amt", pre_amt);
			eventResponse.setETCData("chk_addr1", chk_addr1);
			eventResponse.setETCData("chk_addr2", chk_addr2);
			eventResponse.setETCData("chk_addr3", chk_addr3);
			eventResponse.setETCData("chk_cty_nm", chk_cty_nm);
			eventResponse.setETCData("chk_ste_cd", chk_ste_cd);
			eventResponse.setETCData("chk_zip_cd", chk_zip_cd);
			eventResponse.setETCData("chk_cnt_cd", chk_cnt_cd);
			
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 approvalRequest 이벤트 처리<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException {
		log.error("\n BCImpl approvalRequest Start ===========================");

		EsdTes0024Event event = (EsdTes0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

//		HashMap param_map = (HashMap) event.getParam_map();
//		String asa_no = param_map != null ? (String) param_map.get("asa_no") : "";
//		String csr_tp_cd = param_map != null ? (String) param_map.get("csr_tp_cd") : "";
//		String cnt_cd = param_map != null ? (String) param_map.get("cnt_cd") : "";
//		String evi_gb = param_map != null ? (String) param_map.get("evi_gb") : "";
//		//String csr_no = param_map != null ? (String) param_map.get("csr_no") : "";
//		String ofc_cd	= param_map != null ? (String) param_map.get("ofc_cd") : "";
		
		String			asa_no			= event.getCARIssueTransferSlipManageCommonVO().getAsaNo();
//		String 			csr_tp_cd		= event.getApInvHdrVO().getCsrTpCd();
		String 			cnt_cd 			= event.getCARIssueTransferSlipManageCommonVO().getCntCd();
		String 			evi_gb 			= event.getCARIssueTransferSlipManageCommonVO().getEviGb();	
		String			ofc_cd			= event.getSignOnUserAccount().getOfc_cd();
		
		String 			csr_no = "";
		String 			chkAmt = "";
		
		String 			gap 			= "";
		String 			inv_no			= "";
		String 			inv_no2 		= "";
		String 			cost_cd 		= "";
		String 			cntr_tpsz_cd 	= "";
		
		String 			tmp_wrong_inv 	= "";
		String 			vvd_cd 	= "";
		String 			chk 	= "";

		String 			tmp_del_vvd_inv 		= "";
		String 			tmp_not_found_vvd_inv 	= "";
		
		String 			acct_cd 		= "954113";
		String 			iss_dt  		= "";
		String 			loc_cd  		= "";
		String 			line_seq 		= "";
		String 			line_no  		= "";
		String 			total_amt 		= "";
		
		TesTmlSoHdrVO[] tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet 		apInvCnt2Drs	= null;	
		int				acctCdCount		= 0;
		
		DBRowSet[] 		dtrbSets 		= null;
		DBRowSet 		dtrbLineSet 	= null;
		DBRowSet 		dtrbSumSet 		= null;

		DBRowSet 		up3ptySet 		= null;
		DBRowSet 		revVVDSet 		= null;
		DBRowSet 		revVVDSet2 		= null;
		DBRowSet 		asaRowSet 		= null;
		
		ApInvDtrbVO		apInvDtrbVO		= null;
		TesN3rdPtyIfVO	tesN3rdPtyIfVO	= null;
		TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
		
		CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO = null;
		
		List<ApInvDtrbVO> 	apInsVoList		= new ArrayList<ApInvDtrbVO>();
		List<ApInvDtrbVO> 	lineNoVoList 	= new ArrayList<ApInvDtrbVO>();
		List<TesTmlSoHdrVO> upInvCSRVoList 	= new ArrayList<TesTmlSoHdrVO>();
		List<TesTmlSoHdrVO> upStsCDVoList 	= new ArrayList<TesTmlSoHdrVO>();
		List<TesN3rdPtyIfVO> up3PtyVoList 	= new ArrayList<TesN3rdPtyIfVO>();
		
		//String csr_tp_cd = "S"; // S:STANDARD, C:CREDIT CSR DETAIL 일 경우 S로 고정, 대체전표 경우 C로 고정

		try {

			// 2007-12-10 : invoice의 상태를 확인
			TESInvoiceCommonBC inv_com = new TESInvoiceCommonBCImpl();
			inv_com.checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
	
			// 1. 각 데이터 CHECK  후 없는 경우 Exception 발생 시켜  더이상 진행시키지 않음			
			dbDao.searchApInvChacke1(event);
			log.error("\n DONE - approvalRequest.searchApInvChacke1:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
//			dbDao.searchApInvChacke2(event.getTES_TML_SO_HDRS());
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				apInvCnt2Drs = dbDao.searchApInvChacke2(tesTmlSoHdrVOs[i]);
				
				if(apInvCnt2Drs!=null){
					while(apInvCnt2Drs.next()){
						acctCdCount = Integer.parseInt(apInvCnt2Drs.getString("count"))+acctCdCount;
					}
				}
			}

			if( acctCdCount > 0 ){
//				throw new DAOException(new ErrorHandler("TES00069").getMessage());
				throw new EventException(new ErrorHandler("TES00069", new String[]{}).getMessage());
			}
			
			
			log.error("\n DONE - approvalRequest.searchApInvChacke2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 3. csr_no 생성  -- 기존은 하냐였는데 multiCSRNo(), multiCSRInsert()인서트로 나눔
			csr_no = dbDao.multiCSRNo(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), event.getApInvHdrVO().getCsrTpCd(),"");	
			dbDao.multiCSRInsert(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), csr_no);
			event.getTesTmlSoHdrVO().setCsrNo(csr_no);
			event.getApInvHdrVO().setCsrNo(csr_no);
			event.getApInvDtrbVO().setCsrNo(csr_no); // csr_no 값을 넣어준다.
			
			log.error("\n DONE - approvalRequest.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//			param_map.put("csr_no",csr_no);			

			// 4.AP HDR 및 DTRB INSERT
			dbDao.createApInvHDR(event);
			log.error("\n DONE - approvalRequest.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			/**
			 * AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE한다.  
			 */
			dbDao.updateApInvHdrPDTApproval(csr_no);
			
			/**
			 * 환율 상태 확인 : AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE후에 USD환율이 NULL이거나 해당기간에 USD 환율변환이 안되는 상태면 띵긴다.  
			 */
			dbDao.checkUSDExchSts(csr_no);

//			if (cnt_cd.equals("KR")){
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map());  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
//				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//				if(evi_gb.equals("1") || evi_gb.equals("2")){
//					dbDao.createApInvDTRBEvi(event.getTES_TML_SO_HDRS(), event.getParam_map());
//					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//				}
//			} else {
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map());  //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
//				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//			}
			
			if (cnt_cd.equals("KR")){				
				dtrbSets = event.getDtrbRowSetArr();
				
				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
					if(dtrbSets[j]!=null){
						while(dtrbSets[j].next()){
							apInvDtrbVO = new ApInvDtrbVO();

							apInvDtrbVO.setCsrNo(csr_no);
							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
							
							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));

							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));

							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));

							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));

							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
							apInvDtrbVO.setCreDt(ofc_cd);
//							apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));

							apInsVoList.add(apInvDtrbVO);
						}
					}
				}
				
				dbDao.createApInvDTRB(apInsVoList); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvHdrUpdate(event);
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

				if (evi_gb.equals("1") || evi_gb.equals("2")){					
					dbDao.createApInvDTRBEvi(event);
					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				}
				
			} else {
				dtrbSets = event.getDtrbRowSetArr();
				
				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
					if(dtrbSets[j]!=null){
						while(dtrbSets[j].next()){
							apInvDtrbVO = new ApInvDtrbVO();

							apInvDtrbVO.setCsrNo(csr_no);
							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
							
							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));

							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));

							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));

							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));

							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
							apInvDtrbVO.setCreDt(ofc_cd);
//							apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));

							apInsVoList.add(apInvDtrbVO);
						}
					}
				}
				
				dbDao.createApInvDTRB(apInsVoList); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				dbDao.createApInvHdrUpdate(event);
				
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map()); //SC에서 event.setDTRBRowSetArr()를 실행한 경우만 사용해야 합니다.
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
						
			dbDao.modifyApInvDTRBLineNo(csr_no);
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(event.getApInvDtrbVO());
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_Acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					apInvDtrbVO.setFtuUseCtnt1(dtrbLineSet.getString("ftu_use_ctnt1"));	//[CHM-201536111]CSR I/F할 때 Line No 반복되지 않도록 로직 변경
					
					lineNoVoList.add(apInvDtrbVO);
				}
			}
			dbDao.modifyApInvDTRBLineNo02(lineNoVoList); 
			log.error("\n DONE - approvalRequest.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					tesTmlSoHdrVOs[i].setCsrNo(csr_no);
					
					dtrbSumSet 	= dbDao.createApInvDTRB_sum(tesTmlSoHdrVOs[i]);
					inv_no 		= tesTmlSoHdrVOs[i].getInvNo();
					
					if (dtrbSumSet != null) {
        				while(dtrbSumSet.next()){
        					gap 			= dtrbSumSet.getString("GAP");
        					inv_no2 		= dtrbSumSet.getString("ATTR_CTNT1");
        					cost_cd 		= dtrbSumSet.getString("FTU_USE_CTNT1");
        					cntr_tpsz_cd 	= dtrbSumSet.getString("CNTR_TPSZ_CD");
    
        					if (inv_no==null || inv_no.trim().equals("") || inv_no2==null || inv_no2.trim().equals("") || !inv_no.equals(inv_no2)){
//        						throw new DAOException(new ErrorHandler("Wrong Inv.No Exception!!!").getMessage());
        						throw new EventException(new ErrorHandler("TES00080", new String[]{}).getMessage());
        					}

        					cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
            				cARIssueTransferSlipManageCommonVO.setGap(gap);
            				cARIssueTransferSlipManageCommonVO.setInvNo2(inv_no2);
            				cARIssueTransferSlipManageCommonVO.setCostCd(cost_cd);
            				cARIssueTransferSlipManageCommonVO.setCntrTpszCd(cntr_tpsz_cd);
            				
            				tesTmlSoHdrVO = new TesTmlSoHdrVO();
            				tesTmlSoHdrVO.setCurrCd(event.getTesTmlSoHdrVO().getCurrCd());
            				tesTmlSoHdrVO.setCsrNo(csr_no);
            				
            				dbDao.createApInvDTRB_sumUpdateDiff(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO);
        				}
					}
				}
			}
//			dbDao.createApInvDTRB_sum(event.getTES_TML_SO_HDRS(), (String)event.getParam_map().get("csr_no"), (String)event.getParam_map().get("curr_cd"));			
			log.error("\n DONE - approvalRequest.createApInvDTRB_sum:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			if (!asa_no.equals("")) {
//				dbDao.createApInvDTRBASANo((String)event.getParam_map().get("csr_no"), (String)event.getParam_map().get("ofc_cd"), (String)event.getParam_map().get("cost_ofc_cd"), (String)event.getParam_map().get("vndr_seq"), (String)event.getParam_map().get("cre_use_id"), "");
				asaRowSet = dbDao.createApInvDTRBASANoSelect(csr_no);
	            if (asaRowSet != null) {
	            	while(asaRowSet.next()){
	            		inv_no  	= asaRowSet.getString("inv_no");
	            		iss_dt  	= asaRowSet.getString("iss_dt");
	            		loc_cd		= asaRowSet.getString("loc_cd");
	            		line_seq	= asaRowSet.getString("line_seq");
	            		line_no		= asaRowSet.getString("line_no");
	            		total_amt	= asaRowSet.getString("total_amt");
	            	}
	            }
	            
	            tesTmlSoHdrVO = new TesTmlSoHdrVO();
	            apInvDtrbVO	  = new ApInvDtrbVO();	
	            cARIssueTransferSlipManageCommonVO = new CARIssueTransferSlipManageCommonVO();
	            
	            tesTmlSoHdrVO.setInvNo(inv_no);
	            tesTmlSoHdrVO.setIssDt(iss_dt);
	            cARIssueTransferSlipManageCommonVO.setLocCd(loc_cd);
	            apInvDtrbVO.setLineSeq(line_seq);
	            apInvDtrbVO.setLineNo(line_no);
	            cARIssueTransferSlipManageCommonVO.setTotalAmt(total_amt);
	            
	            cARIssueTransferSlipManageCommonVO.setAcctCd(acct_cd);
	            tesTmlSoHdrVO.setCostOfcCd(event.getTesTmlSoHdrVO().getCostOfcCd());
	            tesTmlSoHdrVO.setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());

	            apInvDtrbVO.setCsrNo(csr_no);
	            dbDao.createApInvDTRBASANoInsert(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO, apInvDtrbVO, ofc_cd, event.getSignOnUserAccount().getUsr_id());
				dbDao.createApInvDTRBASANoUpdate(csr_no);
				log.error("\n DONE - approvalRequest.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			// 5. R.VVD LEVEL CHECK
			dbDao.searchApInvVVDChacke(csr_no);
			log.error("\n DONE - approvalRequest.searchApInvVVDChacke:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			

//			 2010/01/12  김회영 수석 요청으로 AP_INV_IF에 넣지 않도록 수정함.  #######################
//			// 6.AP I/F에 INSERT
//			pgm_no = dbDao.createApInvIF(csr_no);	
//			log.error("\n DONE - approvalRequest.createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 7.HDR CSR NO UPDATE 처리
//			dbDao.upateInvCSRNo(event.getTES_TML_SO_HDRS(), csr_no);
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				tesTmlSoHdrVOs[i].setCsrNo(csr_no);
				upInvCSRVoList.add(tesTmlSoHdrVOs[i]);
			}
			dbDao.upateInvCSRNo(upInvCSRVoList, csr_no);
			log.error("\n DONE - approvalRequest.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
//			log.error("\n\n ### "+JSPUtil.getNull(csr_no)+" - apro_step : "+JSPUtil.getNull(String.valueOf(event.getParam_map().get("apro_step")))+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n\n");
			/* ALPS에서 Approval Step을 지정하지 않음
			// 8.EP 결제하기
			dbDao.createCSREPApproval(event);
			log.error("\n DONE - csr_no==============>"+csr_no+"  approvalRequest.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			String apro_step_chk = new ApprovalUtil().checkAproStepSts(csr_no,event.getSignOnUserAccount().getUsr_id());
			log.error("\n\n  TES CSR ApprovalRequest - csr_no : " + JSPUtil.getNull(csr_no) + " --- apro_step_chk : " + JSPUtil.getNull(apro_step_chk) + " ======================= \n\n");
			if (apro_step_chk!=null){
			
				 // P : 10만불 이상인데 PDT 미지정
				 // M : 10만불 이하인데 본부장 미지정
				 // K : Approval Step PDT/본부장 포함 2단계 이하인 경우
				 // E : 오류
				 // I : CEO는 항상 제일 뒤에 위치하는지 검사 
				 // Y : 정상
				 // X : [2014-07,08] PDT 지시 시항 적용 대상이 아님
				 // F : PDT결재완료후 I/F ERROR이후 재발행건들 -> PDT/본부장 결재 우회 허용 
				 // C : 운하통과료 (SO_PORT) -> 결재자 상관없이 무조건 통과 요청
				 
				if (apro_step_chk.trim().equals("P")){
					throw new EventException(new ErrorHandler("CSR10011", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("M")){
					throw new EventException(new ErrorHandler("CSR10012", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("K")){
					throw new EventException(new ErrorHandler("CSR10014", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("E")){
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
				} else if (apro_step_chk.trim().equals("Y") || apro_step_chk.trim().equals("X")){
					log.error("\n >>>>>>>>>>>>>>>>>>>>> [PASS] csr_no: " + JSPUtil.getNull(csr_no) + " <<<<<<<<<<<<<<<<<<<<< \n");
				} else {
					throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());					
				}
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage());
			}*/

			
			
			/**
			 * 2009-04-28 : CONFIRM상태인 Terminal invoice 대상만 Lane code 불일치건 확인 작업 추가
			 * <주> 반드시 invoice CONFIRM -> APPROVAL REQUESTED로 상태가 변경 되기 전에 해야한다. 
			 * 혹은 반대로 LANE CODE누락을 조사하는 과정에서 대상 invoice 조회 조건을 APPROVAL REQUESTED로 해야한다. 
			 */
//			dbDao.checkMissingLaneCode(event.getTES_TML_SO_HDRS(), cnt_cd);
//			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
//				missLaneCDSet = dbDao.checkMissingLaneCode01(tesTmlSoHdrVOs[i],  JSPUtil.getNull(cnt_cd));
//				
//				lane_cd_match = null;
//				if (missLaneCDSet.next()){
//					lane_cd_match = missLaneCDSet.getString("LANE_CD_MATCH_CHK");
//					log.debug("\n 1st lane_cd_match:"+lane_cd_match+" ============= \n");
//
//					if (lane_cd_match!=null && lane_cd_match.trim().equals("N")){
//						//여긴 일단 LANE CODE 불일치 1차 판별 후 2차 검토 작업
//						lane_cd_match2 = null;
//						missLaneCDSet2 = dbDao.checkMissingLaneCode02(tesTmlSoHdrVOs[i]);
//						
//						if (missLaneCDSet2.next()){
//							lane_cd_match2 = missLaneCDSet2.getString("LANE_CD_MATCH_CHK");
//							if (lane_cd_match2!=null && lane_cd_match2.trim().equals("N")){
//								tmp_wrong_inv = tmp_wrong_inv + ((tmp_wrong_inv!=null&&tmp_wrong_inv.length()>1?", ":"") + tesTmlSoHdrVOs[i].getInvNo());
//								break;
//							}
//						}
//						log.debug("\n ================== 2nd lane_cd_match:"+lane_cd_match2+" ================== \n");
//					}
//				}
//				
//			}
//			if (tmp_wrong_inv!=null && !tmp_wrong_inv.trim().equals("")){
////				throw new DAOException("\n\n Wrong Lane code at invoice(s), "+tmp_wrong_inv+".");
//				throw new EventException(new ErrorHandler("TES00081", new String[]{tmp_wrong_inv}).getMessage());				
//			}
			
			// 9. tml_inv_sts_cd 'A' 결제하기
			inv_com.checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
//			dbDao.modifyStsCdSOHDR(event.getTES_TML_SO_HDRS(), "A");
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				tesTmlSoHdrVOs[i].setTmlInvStsCd("A");
				upStsCDVoList.add(tesTmlSoHdrVOs[i]);
			}
			dbDao.modifyStsCdSOHDR(upStsCDVoList);
			log.error("\n DONE - approvalRequest.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			
			// 10. R.VVD CONVERSION LOGIC을 수행한 후 하기의 SQL을 수행하여 N3RD에도 역시 R.VVDFINC_VSL_FINC_VSL_CD, FINC_SKD_VOY_NO, FINC_SKD_DIR_CD를 UPDATE한다.
//			dbDao.modifyTes3PtyIF(event.getTES_TML_SO_HDRS(), event.getSignOnUserAccount().getOfc_cd(), event.getSignOnUserAccount().getUsr_id());
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				up3ptySet = dbDao.modifyTes3PtyIFAP(tesTmlSoHdrVOs[i], event.getSignOnUserAccount().getUsr_id());
				
	            if (up3ptySet != null) {
	            	while(up3ptySet.next()){
	            		tesN3rdPtyIfVO = new TesN3rdPtyIfVO();

	            		tesN3rdPtyIfVO.setFincVslCd(up3ptySet.getString("finc_vsl_cd"));
	            		tesN3rdPtyIfVO.setFincSkdVoyNo(up3ptySet.getString("finc_skd_voy_no"));
	            		tesN3rdPtyIfVO.setFincSkdDirCd(up3ptySet.getString("finc_skd_dir_cd"));
	            		tesN3rdPtyIfVO.setInvNo(up3ptySet.getString("inv_no"));
	            		tesN3rdPtyIfVO.setAcctCd(up3ptySet.getString("acct_cd"));
	            		tesN3rdPtyIfVO.setGlDt(up3ptySet.getString("gl_dt"));
	            		tesN3rdPtyIfVO.setVvdCd(up3ptySet.getString("vvd_cd"));
	            		tesN3rdPtyIfVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
	            		tesN3rdPtyIfVO.setLoclUpdDt(ofc_cd);
	            		tesN3rdPtyIfVO.setTmlIfOfcCd(up3ptySet.getString("tml_if_ofc_cd"));
	            		tesN3rdPtyIfVO.setTmlIfSeq(up3ptySet.getString("tml_if_seq"));
	            		
	            		up3PtyVoList.add(tesN3rdPtyIfVO);
	            	}
	            }
			}
			dbDao.modifyTes3PtyIFTPB(up3PtyVoList);
			log.error("\n DONE - approvalRequest.modifyTes3PtyIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			

			log.debug("\n\n  ### ofc_cd:"+ofc_cd);
			if (ofc_cd!=null && !ofc_cd.trim().equals("")){
				if (!ofc_cd.trim().equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
					// 2007-07-19 : RevVVD 관련 검사 - 200706 이후 ATB_DT기준 계산 기준 검사
					
					DBRowSet 	costCdSet		= dbDao.checkCalcCostCD(csr_no);
					chk				= "";
					tmp_wrong_inv	= "";
					String 		tmp_no_dtl_inv	= "";
					int 		knt_wrong_inv 	= 0;
					int 		knt_no_dtl_inv 	= 0;
					
					while (costCdSet.next()){
						chk = costCdSet.getString("CHK");
						log.debug("\n\n  INV_NO:"+costCdSet.getString("INV_NO") + " - LGS_COST_CD:"+costCdSet.getString("LGS_COST_CD")+"  ---------------------  --------------------- ---------------------  \n\n");
						if (chk!=null && chk.trim().equals("N")){
							tmp_wrong_inv = tmp_wrong_inv + ((costCdSet.isFirst()?"":(++knt_wrong_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
						} else if (chk!=null && chk.trim().equals("NF")){
							tmp_no_dtl_inv = tmp_no_dtl_inv + ((costCdSet.isFirst()?"":(++knt_no_dtl_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
						}
					}
	
					log.debug("\n\n %%%%% tmp_wrong_inv : "+tmp_wrong_inv + " %%%%% %%%%% %%%%% \n");
					log.debug("\n\n %%%%% tmp_no_dtl_inv : "+tmp_no_dtl_inv + " %%%%% %%%%% %%%%% \n");
					if (tmp_wrong_inv!=null && !tmp_wrong_inv.trim().equals("")){
//					throw new DAOException("\n\n The cost was not calculated automatically at the invoice "+tmp_wrong_inv+". \n");
						throw new EventException(new ErrorHandler("TES00085", new String[]{tmp_wrong_inv}).getMessage());					
					}
					if (tmp_no_dtl_inv!=null && !tmp_no_dtl_inv.trim().equals("")){
//					throw new DAOException("\n\n There is no calculation data at the invoice "+tmp_no_dtl_inv+". \n");
						throw new EventException(new ErrorHandler("TES00086", new String[]{tmp_no_dtl_inv}).getMessage());					
					}
					
				}
			} else {
				log.debug("\n\n ofc_cd NULL exception!!! ------------------------------- \n");
//				throw new DAOException("\n\n Inv Office is invalid ");
				throw new EventException(new ErrorHandler("TES00082", new String[]{}).getMessage());				
			}			
			
			
			// 11. AP
			chkAmt = dbDao.checkCSRAmtVsInvAmt(csr_no);
			log.error("\n DONE - approvalRequest.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new EventException(new ErrorHandler("TES00072", new String[]{}).getMessage());
			}
			
			// 12. Rev.VVD로 Rev.VVD master에 존재/삭제 여부를 조회..
			revVVDSet = dbDao.checkMstRevVVD01(csr_no);
			
			if (revVVDSet!=null){
				while (revVVDSet.next()){
					vvd_cd = revVVDSet.getString("DTRB_COA_VVD_CD");
					inv_no = revVVDSet.getString("ATTR_CTNT1");
					log.debug("\n\n DTRB_COA_VVD_CD:"+revVVDSet.getString("DTRB_COA_VVD_CD")+" / inv_no:"+revVVDSet.getString("ATTR_CTNT1")+"  ---------------------  --------------------- ---------------------  \n\n");

					revVVDSet2 = dbDao.checkMstRevVVD02(csr_no); // 2013.01.03 김용진 파라미터 csr_no를 vvd_cd로 바꿈........2012.12.27 다시 원복
					if (revVVDSet2!=null){
						while (revVVDSet2.next()){
							chk = revVVDSet2.getString("CHK");
							if (chk!=null){
								if (chk.trim().equals("Y")){
									tmp_del_vvd_inv = tmp_del_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " has been deleted. ");
								}
							} else {
								tmp_not_found_vvd_inv = tmp_not_found_vvd_inv + (vvd_cd + " at the invoice " + inv_no + " is not found in Revenue VVD master. ");
							}
						}
					}
				}
			} else {
//				throw new DAOException("\n\n There is no CSR distribution data. \n");
				throw new EventException(new ErrorHandler("TES00083", new String[]{}).getMessage());				
			}
			
			if ((tmp_del_vvd_inv!=null && !tmp_del_vvd_inv.trim().equals("")) || (tmp_not_found_vvd_inv!=null && !tmp_not_found_vvd_inv.trim().equals(""))){
//				tmp_del_vvd_inv += (tmp_not_found_vvd_inv + "\n\n Please, make sure VVD code is correct.  If correct, contact SELFAR.");
				tmp_del_vvd_inv = tmp_del_vvd_inv + (tmp_not_found_vvd_inv);
//				throw new DAOException(tmp_del_vvd_inv);
				throw new EventException(new ErrorHandler("TES00084", new String[]{tmp_del_vvd_inv}).getMessage());
			}
			
			//13. CSR생성 후 Approval Request 하기 위한 단계로 업데이트
			ApprovalUtil aproUtil = new ApprovalUtil();			
			aproUtil.updateAproGwFlg(csr_no, ofc_cd);
			
			eventResponse.setETCData("csrNo", csr_no);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			log.error("\n BCImpl approvalRequest End ===========================");
			
			return eventResponse;
			
		} catch(EventException ex) {
			log.error("\n DONE - approvalRequest.DAOException - CSR_NO:"+csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");	
			throw ex;
		} catch (DAOException de) {
			log.error("\n DONE - approvalRequest.DAOException - CSR_NO:"+csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");	
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage());
		} 
		
	}
	
	/**
	 * approvalRequestAccount1과 approvalRequestAccount2로 분리되여 관리됩니다.
	 */
//	public FNS0080003Document approvalRequestAccount(String flag, String csr_no, ComAproRqstRoutVO model) throws EventException {
//
//		log.error("\n\n\n\n\n\n\n\n\n\n ---------------------------------------------------------------------------------------------\nCAR BCImpl - approvalRequestAccount ---------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");
//
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet rowSet = null;
//		Collection models_so = null;
//		
//		String title_name="";
//		//String pgm_no = "";		
//		FNS0080003Document docReq = null;
//
//		try {
//			
//			title_name = model.getApro_usr_jb_tit_nm()+"/"+model.getApro_usr_nm();
//			
//			// 1.csr_no로 tes_tml_so_hdr inv_no, vndr_seq를 모델로 가져오기
//			models_so = dbDao.searchSO(csr_no);					
//			
//			log.error("\n BCImpl.approvalRequestAccount - flag:" + JSPUtil.getNull(flag) + "\n");
//			
//			if(flag.equals("C")){
//				
//				// 2.최종 승인자 정보 UPDATE 처리
//				dbDao.modifyApprovalStep(title_name, csr_no);
//	
//				// 3.AP 인터페이스 실행하기
//				// (임시)ERP와 연동테스트할때까지는 Comment처리
//				
//				rowSet = dbDao.searchINFtoAP(csr_no);
//				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 임시)ERP와 연동테스트할때까지는 Comment처리");	
//
//
//				// 4.EAI 연동후 에러 없이 연동후 so_hdr 테이블 TML_INV_STS_CD 상태를 P로 UPDATE 처리		
//				dbDao.modifyStsCdSOHDR(models_so, "P");		
//				log.error("\n [1] BCImpl.approvalRequestAccount.modifyStsCdSOHDR - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//
//			
//				docReq = eaiDao.transferAtOnceTES024ToEAIByWS(rowSet, csr_no);
//				log.error("\n [2] BCImpl.approvalRequestAccount.transferAtOnceTES024ToEAIByWS - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
//
//				
//			}else{
//				
//				// 1.반송 처리시 so_hdr sts_cd UPDATE 'C', 'RJ' 처리
//				dbDao.rejectInvoice(models_so, model.getApro_ofc_cd());
//			
//			}
//
//			return docReq;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception e) {
//			log.error("err "+e.toString(),e);
//			throw new EventException(e.getMessage());
//		}
//	}
	
//	/**
//	 * approvalRequest 이벤트 처리<br>
//	 * CARIssueTransferSlipManage화면에 대한 approvalRequest 이벤트 처리<br>
//	 * 
//	 * @param e
//	 *            EsdTes0024Event
//	 * @return EventResponse 
//	 * @exception EventException
//	 */
//	public FNS0080003Document[] approvalRequestAccount1(String flag, String csr_no, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException {
//		log.error("\n\n\n\n\n\n\n\n\n\n ---------------------------------------------------------------------------------------------\nCAR BCImpl - approvalRequestAccount1 -- flag:" + JSPUtil.getNull(flag) + "-" +((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+ "-------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");
//		
//		
//		DBRowSet 	rowSet 		= null;
//		DBRowSet 	cntRowSet 	= null;
//		DBRowSet 	soRowSet 	= null;
//		
//		TesTmlSoHdrVO 		tesTmlSoHdrVO	= null;
//		List<TesTmlSoHdrVO> voList			= new ArrayList<TesTmlSoHdrVO>();
//		
//		FNS0080003Document[] docReq = null;
//		
//		int			cnt			= 0;
////		String[][] retval = null;
//
//		try {
//			log.error("\n BCImpl.approvalRequestAccount1 - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " \n");
//			
//			// 1.csr_no로 tes_tml_so_hdr inv_no, vndr_seq를 모델로 가져오기
////			models_so 	= dbDao.searchSO(csr_no);	
//			
//			soRowSet	= dbDao.searchSO(csr_no);
//            if (soRowSet != null) {
//            	while(soRowSet.next()){
//            		tesTmlSoHdrVO = new TesTmlSoHdrVO();
//            		tesTmlSoHdrVO.setIbflag("R");
//            		tesTmlSoHdrVO.setTmlSoOfcCtyCd(soRowSet.getString("tml_so_ofc_cty_cd"));
//            		tesTmlSoHdrVO.setTmlSoSeq(soRowSet.getString("tml_so_seq"));
//            		tesTmlSoHdrVO.setInvNo(soRowSet.getString("inv_no"));
//            		tesTmlSoHdrVO.setVndrSeq(soRowSet.getString("vndr_seq"));
//            		tesTmlSoHdrVO.setInvOfcCd(soRowSet.getString("inv_ofc_cd"));
//            		tesTmlSoHdrVO.setCreUsrId(soRowSet.getString("cre_usr_id"));
//            		tesTmlSoHdrVO.setCurrCd(soRowSet.getString("curr_cd"));
//            		voList.add(tesTmlSoHdrVO);
//            	}
//            }
//			log.error("\n [1] BCImpl.approvalRequestAccount1.searchSO - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");			
//			
//			if (flag.equals("C")){
//				cntRowSet 	= dbDao.searchINFtoAPCount(csr_no);
//				
//	            if(cntRowSet != null){
//	            	while(cntRowSet.next()) {
//						cnt = cntRowSet.getInt(1);
//						//check
//						if(cnt > 0){
//							//CSR No has already Interfaced! Please check up CSR No[$]
//							throw new DAOException((new ErrorHandler("AGT00029", new String[]{csr_no})).getMessage());
//						}
//					}
//	            }
//				rowSet 		= dbDao.searchINFtoAP(csr_no);
//				log.error("\n [2] BCImpl.approvalRequestAccount1.searchINFtoAP - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
//				
//				docReq = eaiDao.transferAtOnceTES024ToEAIByWS(rowSet, csr_no, comAproRqstRoutVO);
//				log.error("\n [3] BCImpl.approvalRequestAccount1.transferAtOnceTES024ToEAIByWS - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
//
//				// XML을 query로 구성하는 경우 - test중
////				retval = dbDao.searchINFtoAP2(csr_no);
////				log.error("\n [2] BCImpl.approvalRequestAccount1.searchINFtoAP2 - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
////				log.debug("\n test -> retval.length : "+retval.length+"\n");
////				for (int j=0; j<retval.length; j++){
////					log.debug("\n - retval["+j+"][1] : "+retval[j][1]+"\n");					
//////					for (int k=0; k<retval[j].length; k++){
//////						log.debug("\n - retval["+j+"]["+k+"] : "+retval[j][k]+"\n");
//////					}
////				}
//				
//			} else {
//				log.error("\n [2] BCImpl.approvalRequestAccount1.rejectInvoice - BEGIN : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
//				// 1.반송 처리시 so_hdr sts_cd UPDATE 'C', 'RJ' 처리
////				dbDao.rejectInvoice(models_so, comAproRqstRoutVO!=null?JSPUtil.getNull(comAproRqstRoutVO.getAproOfcCd()):"");
//				
//				dbDao.rejectInvoice(voList);
//				log.error("\n [2] BCImpl.approvalRequestAccount1.rejectInvoice - END : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");				
//			}
//		} catch (DAOException de) {
//			log.error("\n [EX] BCImpl.approvalRequestAccount1.DAOException - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception e) {
//			log.error("\n [EX] BCImpl.approvalRequestAccount1.Exception - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
//			log.error("err "+e.toString(),e);
//			throw new EventException(e.getMessage());
//		}
//		
//		return docReq;
//	}
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 approvalRequest 이벤트 처리<br>
	 * 
	 * @param String flag
	 * @param String csr_no
	 * @param ComAproRqstRoutVO comAproRqstRoutVO
	 * @return FNS0080003Document[] 
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String csr_no, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException {
		log.error("\n\n\n\n\n\n\n\n\n\n ---------------------------------------------------------------------------------------------\nCAR BCImpl - approvalRequestAccount1 -- flag:" + JSPUtil.getNull(flag) + "-" +((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+ "-------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");
		
		
		DBRowSet 	rowSet 		= null;
//		DBRowSet 	cntRowSet 	= null;
		DBRowSet 	soRowSet 	= null;
		
		TesTmlSoHdrVO 		tesTmlSoHdrVO	= null;
		List<TesTmlSoHdrVO> voList			= new ArrayList<TesTmlSoHdrVO>();
		
		FNS0080003Document[] docReq = null;
		
//		int			cnt			= 0;
//		String[][] retval = null;

		try {
			log.error("\n BCImpl.approvalRequestAccount1 - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " \n");
			
			// 1.csr_no로 tes_tml_so_hdr inv_no, vndr_seq를 모델로 가져오기
			
			soRowSet	= dbDao.searchSO(csr_no);
            if (soRowSet != null) {
            	while(soRowSet.next()){
            		tesTmlSoHdrVO = new TesTmlSoHdrVO();
            		tesTmlSoHdrVO.setIbflag("R");
            		tesTmlSoHdrVO.setTmlSoOfcCtyCd(soRowSet.getString("tml_so_ofc_cty_cd"));
            		tesTmlSoHdrVO.setTmlSoSeq(soRowSet.getString("tml_so_seq"));
            		tesTmlSoHdrVO.setInvNo(soRowSet.getString("inv_no"));
            		tesTmlSoHdrVO.setVndrSeq(soRowSet.getString("vndr_seq"));
            		tesTmlSoHdrVO.setInvOfcCd(soRowSet.getString("inv_ofc_cd"));
            		tesTmlSoHdrVO.setCreUsrId(soRowSet.getString("cre_usr_id"));
            		tesTmlSoHdrVO.setCurrCd(soRowSet.getString("curr_cd"));
            		voList.add(tesTmlSoHdrVO);
            	}
            }
			log.error("\n [1] BCImpl.approvalRequestAccount1.searchSO - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");			
			
			if (flag.equals("C")){
//				cntRowSet 	= dbDao.searchINFtoAPCount(csr_no);
//				
//	            if(cntRowSet != null){
//	            	while(cntRowSet.next()) {
//						cnt = cntRowSet.getInt(1);
//						//check
//						if(cnt > 0){
//							//CSR No has already Interfaced! Please check up CSR No[$]
//							throw new DAOException((new ErrorHandler("AGT00029", new String[]{csr_no})).getMessage());
//						}
//					}
//	            }
				rowSet 		= dbDao.searchINFtoAP(csr_no);
				log.error("\n [2] BCImpl.approvalRequestAccount1.searchINFtoAP - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
				
//				docReq = eaiDao.transferAtOnceTES024ToEAIByWS(rowSet, csr_no, comAproRqstRoutVO);
				docReq = eaiDao.transferAtOnceTES024ToEAIByWS(rowSet, csr_no, comAproRqstRoutVO);

				log.error("\n [3] BCImpl.approvalRequestAccount1.transferAtOnceTES024ToEAIByWS - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");

				
			} else {
				log.error("\n [2] BCImpl.approvalRequestAccount1.rejectInvoice - BEGIN : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
				// 1.반송 처리시 so_hdr sts_cd UPDATE 'C', 'RJ' 처리
//				dbDao.rejectInvoice(models_so, comAproRqstRoutVO!=null?JSPUtil.getNull(comAproRqstRoutVO.getAproOfcCd()):"");
				
				dbDao.rejectInvoice(voList);
				log.error("\n [2] BCImpl.approvalRequestAccount1.rejectInvoice - END : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");				
			}
		} catch (DAOException de) {
			log.error("\n [EX] BCImpl.approvalRequestAccount1.DAOException - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("\n [EX] BCImpl.approvalRequestAccount1.Exception - flag:" + JSPUtil.getNull(flag) + " / CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return docReq;
	}
	
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 approvalRequestAccount2 이벤트 처리<br>
	 * 
	 * @param String flag
	 * @param String csr_no
	 * @param ComAproRqstRoutVO comAproRqstRoutVO
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String approvalRequestAccount2(String flag, String csr_no, ComAproRqstRoutVO comAproRqstRoutVO) throws EventException {
		log.error("\n -----------\nCAR BCImpl - approvalRequestAccount2 - " +((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+ "--------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");
		
		List<TesTmlSoHdrVO> voList		= 	new ArrayList<TesTmlSoHdrVO>();
		DBRowSet 			soRowSet 	= 	null;
		String 				title_name	=	"";
//		String 				hdr_gl_dt 	= 	"";
		TesTmlSoHdrVO		tesTmlSoHdrVO = null;
		
		try {
			log.error("\n BCImpl.approvalRequestAccount2 - flag:" + JSPUtil.getNull(flag) + " : CSR_NO:" + JSPUtil.getNull(csr_no) + "\n");

//			if( doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0 )
//			{
//				hdr_gl_dt = doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
//			}
			
			title_name = comAproRqstRoutVO!=null?(JSPUtil.getNull(comAproRqstRoutVO.getAproUsrJbTitNm())+"/"+JSPUtil.getNull(comAproRqstRoutVO.getAproUsrNm())):"";
			
			// 1.csr_no로 tes_tml_so_hdr inv_no, vndr_seq를 모델로 가져오기
			soRowSet = dbDao.searchSO(csr_no);
            if (soRowSet != null) {
            	while(soRowSet.next()){
            		tesTmlSoHdrVO = new TesTmlSoHdrVO();
            		tesTmlSoHdrVO.setIbflag("R");
            		tesTmlSoHdrVO.setTmlInvStsCd("P");
            		tesTmlSoHdrVO.setTmlSoOfcCtyCd(soRowSet.getString("tml_so_ofc_cty_cd"));
            		tesTmlSoHdrVO.setTmlSoSeq(soRowSet.getString("tml_so_seq"));
            		tesTmlSoHdrVO.setInvNo(soRowSet.getString("inv_no"));
            		tesTmlSoHdrVO.setVndrSeq(soRowSet.getString("vndr_seq"));
            		tesTmlSoHdrVO.setInvOfcCd(soRowSet.getString("inv_ofc_cd"));
            		tesTmlSoHdrVO.setCreUsrId(soRowSet.getString("cre_usr_id"));
            		tesTmlSoHdrVO.setCurrCd(soRowSet.getString("curr_cd"));
            		voList.add(tesTmlSoHdrVO);
            	}
            }
			log.error("\n [1] BCImpl.approvalRequestAccount2.searchSO - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			if (flag.equals("C")){
				/**
				 * <중> GL_DT가 변경된 것이 확인되면 AP_INV_DTRB,Invoice의 DTL, CNTR_LIST의 재무항차 년월을 GL_DT기준으로 변경한다.
				 * AP_INV_IF는 별도로 수정하지 않고 searchINFtoAP()에서 AP I/F용으로 추출할때만 GL_DT처럼 변경 한다.
				 * 반드시 GL_DT가 update되기 전에 실행해야 한다. 
				 */
				dbDao.updateRevVVD(csr_no);			

				
				// 2.최종 승인자 정보 UPDATE 처리
//				dbDao.modifyApprovalStep(title_name, csr_no, hdr_gl_dt);
				dbDao.modifyApprovalStep(title_name, csr_no);
				
				log.error("\n [2] BCImpl.approvalRequestAccount2.modifyApprovalStep - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				
				// 3.EAI 연동후 에러 없이 연동후 so_hdr 테이블 TML_INV_STS_CD 상태를 P로 UPDATE 처리		
				dbDao.modifyStsCdSOHDR(voList);		
				log.error("\n [3] BCImpl.approvalRequestAccount2.modifyStsCdSOHDR - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}

		} catch (DAOException de) {
			log.error("\n [EX] BCImpl.approvalRequestAccount2.DAOException - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("\n [EX] BCImpl.approvalRequestAccount2.Exception - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
		
		return "";
	}
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 approvalRequest 이벤트 처리<br>
	 * 
	 * @param String csr_no
	 * @return FNS0080003Document[] 
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccountLEA1(String csr_no) throws EventException {
		log.error("\n\n\n\n\n\n\n\n\n\n ---------------------------------------------------------------------------------------------\nCAR BCImpl - approvalRequestAccountLEA1 ---------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");

		DBRowSet rowSet = null;
		FNS0080003Document[] docReq = null;

		try {
			rowSet = dbDao.searchINFtoAP(csr_no);
			docReq = eaiDao.transferAtOnceTES024ToEAIByWS(rowSet, csr_no, null);
			log.error("\n [2] BCImpl.approvalRequestAccountLEA1.transferAtOnceTES024ToEAIByWS - DONE : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n\n\n\n\n\n\n");
		} catch (DAOException de) {
			log.error("\n [EX] BCImpl.approvalRequestAccountLEA1.DAOException - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("\n [EX] BCImpl.approvalRequestAccountLEA1.Exception - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}

		return docReq;
	}
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * approvalRequestAccountLEA2
	 * 
	 * @param String csr_no 
	 * @param FNS0080003Document doc
	 * @return String
	 * @exception EventException
	 */
	public String approvalRequestAccountLEA2(String csr_no, FNS0080003Document doc) throws EventException {
		log.error("\n\n ---------------------------------------------------------------------------------------------\nCAR BCImpl - approvalRequestAccount2 ---------------------------------------------------------------------- : CSR_NO:" + JSPUtil.getNull(csr_no) + "<<<<<<");

		String title_name="";
		String hdr_gl_dt = "";

		try {
			if (doc!=null && doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0)
			{
				hdr_gl_dt = doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
			}			
			
			title_name = "chgRevVVDLEA";
			
			// 2.최종 승인자 정보 UPDATE 처리
			dbDao.modifyApprovalStep(title_name, csr_no);

		} catch (DAOException de) {
			log.error("\n [EX] BCImpl.approvalRequestAccountLEA2.DAOException - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("\n [EX] BCImpl.approvalRequestAccountLEA2.Exception - : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}

		return "";
	}
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * approvalAfterTPB
	 * 2008-02-18 : CSR재발행 관련으로 '13~' CSR에 대한 LEA I/F 제거
	 * @param String csr_no 
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse approvalAfterTPB(String csr_no) throws EventException {
		log.error("\n =========== BEGIN - approvalAfterTPB = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");

		List<TesTmlSoHdrVO> voList			= 	new ArrayList<TesTmlSoHdrVO>();
		DBRowSet 			soRowSet 		= 	null;
		DBRowSet 			tpbRowSet 		= 	null;
		
		TesTmlSoHdrVO		tesTmlSoHdrVO	= 	null;
		TPBInterfaceVO[]	tPBInterfaceVOs =	null;
		
		TPBInterfaceBCImpl tbpIF = new TPBInterfaceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		/**
		 * HPC
		 * 1) CSR I/F SUCCESS시(IF_FLG에 'Y' 들어 올때) TES_TML_SO_HDR의 AP_IF_DT = SYSDATE, HPC_CRE_FLG = 'N', LEA_CRE_FLG = 'N' 추가
		 */ 
		try {
			dbDao.updateHPC(csr_no, "1");
		} catch (DAOException de) {
			log.error("\n\n approvalAfterTPB.updateHPC.DAOException - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalAfterTPB.updateHPC.Exception - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	 	
//		try {
//			if (csr_no!=null && !csr_no.equals("") && csr_no.startsWith("13")){
//				// LEA_ACT_COST_IF 생성 및 LEA_REV_VVD_CNG.ERP_IF_FLG update하기 
//				log.error("\n XXXXX begin - approvalAfterTPB.createLEA2 = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				dbDao.createLEA2(csr_no);
//				log.error("\n XXXXX end - approvalAfterTPB.createLEA2 = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			} else {
//				// LEA에 DATA 생성하기
////				log.error("\n XXXXX  begin - approvalAfterTPB.createLEA = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
////				dbDao.createLEA(csr_no);   //LEA I/F batch를 하면서 뺀당
////				log.error("\n XXXXX  end - approvalAfterTPB.createLEA = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			}
//		} catch (DAOException de) {
//			log.error("\n\n approvalAfterTPB.LEA.DAOException - \n" + de.toString(), de);
//			try {
//				log.error("\n XXXXX begin - approvalAfterTPB.updateAPErrRsn(LEA) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				dbDao.updateAPErrRsn(csr_no,"LEA");
//				log.error("\n XXXXX end - approvalAfterTPB.updateAPErrRsn(LEA) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			} catch (DAOException de2) {
//				log.error(de2.getMessage(),de2);
//			}
////			throw new EventException(de.getMessage());
//		} catch (Exception de) {
//			log.error("\n\n approvalAfterTPB.LEA.Exception - \n" + de.toString(), de);
//			try {
//				log.error("\n XXXXX begin - approvalAfterTPB.LEA.updateAPErrRsn(LEA) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				dbDao.updateAPErrRsn(csr_no,"LEA");
//				log.error("\n XXXXX end - approvalAfterTPB.LEA.updateAPErrRsn(LEA) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			} catch (DAOException de2) {
//				log.error(de2.getMessage(),de2);
//			}
////			throw new EventException(de.getMessage());
//		}

		try {
			// csr_no로 tes_tml_so_hdr inv_no, vndr_seq를 모델로 가져오기
//			models_so = dbDao.searchSO(csr_no);
			
			soRowSet = dbDao.searchSO(csr_no);

            if (soRowSet != null) {
            	while(soRowSet.next()){
            		tesTmlSoHdrVO = new TesTmlSoHdrVO();
            		tesTmlSoHdrVO.setIbflag("R");
            		tesTmlSoHdrVO.setTmlInvStsCd("P");
            		tesTmlSoHdrVO.setTmlSoOfcCtyCd(soRowSet.getString("tml_so_ofc_cty_cd"));
            		tesTmlSoHdrVO.setTmlSoSeq(soRowSet.getString("tml_so_seq"));
            		tesTmlSoHdrVO.setInvNo(soRowSet.getString("inv_no"));
            		tesTmlSoHdrVO.setVndrSeq(soRowSet.getString("vndr_seq"));
            		tesTmlSoHdrVO.setInvOfcCd(soRowSet.getString("inv_ofc_cd"));
            		tesTmlSoHdrVO.setCreUsrId(soRowSet.getString("cre_usr_id"));
            		tesTmlSoHdrVO.setCurrCd(soRowSet.getString("curr_cd"));
            		tesTmlSoHdrVO.setCsrNo(csr_no);
            		
            		voList.add(tesTmlSoHdrVO);
            	}
            }
			
			
			// tes_n3rd_pty_if쪽 search 및 tml_n3pty_if_sts_cd 값을 p로 변경 및 모델에 담기고 호출		
			dbDao.searchTes3PtyIF(voList);
			int totalCnt = 0;
			
			if(voList!=null){
				for(int i=0; i<voList.size(); i++){
					tesTmlSoHdrVO = new TesTmlSoHdrVO();
					tesTmlSoHdrVO = (TesTmlSoHdrVO)voList.get(i);
					
					tpbRowSet = dbDao.searchTes3PtyIF02(tesTmlSoHdrVO);
					
					if (tpbRowSet != null) {
						totalCnt = totalCnt + tpbRowSet.getRowCount();
		            }
				}
			}
			
			log.error("\n totalCnt============>"+totalCnt);
			
			tPBInterfaceVOs = new TPBInterfaceVO[totalCnt];
        	int tpbSeq = 0;
        	
			if(voList!=null){
				for(int i=0; i<voList.size(); i++){
					tesTmlSoHdrVO = new TesTmlSoHdrVO();
					tesTmlSoHdrVO = (TesTmlSoHdrVO)voList.get(i);
					
					tpbRowSet = dbDao.searchTes3PtyIF02(tesTmlSoHdrVO);
					
					if (tpbRowSet != null) {
						log.error("\n tpbRowSet.getRowCount()============>"+tpbRowSet.getRowCount());

						while(tpbRowSet.next()){
		            		tPBInterfaceVOs[tpbSeq] = new TPBInterfaceVO();
		            		tPBInterfaceVOs[tpbSeq].setTmlIfOfcCd(tpbRowSet.getString("tml_if_ofc_cd"));
		            		tPBInterfaceVOs[tpbSeq].setTmlIfSeq(tpbRowSet.getString("tml_if_seq"));
		            		
		            		//2010.12.20 CHM-201007624-01 추가
		            		tPBInterfaceVOs[tpbSeq].setCsrNoCxlFlg("N");
		            		
		            		log.error("\n tpbRowSet.tml_if_ofc_cd============>"+tPBInterfaceVOs[tpbSeq].getTmlIfOfcCd());
		            		log.error("\n tpbRowSet.tml_if_seq============>"+tPBInterfaceVOs[tpbSeq].getTmlIfSeq());
		            		tpbSeq++;
		            	}
		            }
				}
			}
			
			
			log.error("\n XXXXX begin - approvalAfterTPB.createTESTPB = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			for(int i=0;tPBInterfaceVOs!=null && i<tPBInterfaceVOs.length;i++){
				log.error("tPBInterfaceVOs["+i+"] = \n"+(tPBInterfaceVOs[i]!=null?tPBInterfaceVOs[i].toString():"")+"\n");
			}
			tbpIF.createTESTPB(tPBInterfaceVOs);	
			
			log.error("\n XXXXX end - approvalAfterTPB.createTESTPB = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("\n\n approvalAfterTPB.TPB.DAOException - \n" + de.toString(), de);
			try {
				log.error("\n XXXXX begin - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				dbDao.updateAPErrRsn01(csr_no,"TPB");
//				dbDao.updateAPErrRsn02(csr_no,"TPB");
				log.error("\n XXXXX end - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} catch (DAOException de2) {
				log.error(de2.getMessage(),de2);
				throw new EventException(de2.getMessage());
			}
//			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalAfterTPB.TPB.Exception - \n" + de.toString(), de);
			try {
				log.error("\n XXXXX begin - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				dbDao.updateAPErrRsn01(csr_no,"TPB");
//				dbDao.updateAPErrRsn02(csr_no,"TPB");
				log.error("\n XXXXX end - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} catch (DAOException de2) {
				log.error(de2.getMessage(),de2);
				throw new EventException(de2.getMessage());
			}
//			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}	
	
	/**
	 * approvalRequest 이벤트 처리<br>
	 * approvalRejectLEA<br>
	 * 
	 * @param String csr_no
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRejectLEA(String csr_no) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		/**
		 * HPC
		 * 2) CSR CANCEL(RCV_ERR_FLG에 'E' 들어 올때) 정보 받을 시 TES_TML_SO_HDR의 AP_CXL_DT = SYSDATE, HPC_CXL_FLG = 'N', LEA_CXL_FLG = 'N' 추가
		 */ 
		try {
			dbDao.updateHPC(csr_no, "2");
		} catch (DAOException de) {
			log.error("\n\n approvalRejectLEA.updateHPC.DAOException - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalRejectLEA.updateHPC.Exception - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 2007-08-29 LEA I/F batch에 AP Reject건을 추가 하면서 뺀당
//		try {
//			// 0.LEA에 DATA 생성하기
//			dbDao.updateLEA(csr_no); //LEA I/F batch를 하면서 뺀당
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			//throw new EventException(de.getMessage());
//		}

		return eventResponse;
	}		

	/**
	 * 조회 이벤트 처리<br>
	 * searchTAXInfo<br>
	 * 
	 * @param e
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTAXInfo(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0078Event event = (EsdTes0078Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet 		= null;
		DBRowSet eviCodeSet 	= null;
		
 		String vndr_nm 			= "";
 		String bzct_nm 			= "";
 		String bztp_nm 			= "";
 		String vndr_addr 		= "";
 		String ceo_nm 			= "";
 		String defOfc 			= "";
 		
		String wkplc_nmstring	= "";
		String rgst_no			= "";
		
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String compNo = event.getCARIssueTransferSlipManageCommonVO().getCompNo();
		String vndrSeq = event.getCARIssueTransferSlipManageCommonVO().getVndrSeq();

		try {
			rowSet 		= dbDao.searchTAXDetail(compNo);
			eviCodeSet 	= dbDao.searchEviCodeList(vndrSeq, account);
			
			if(rowSet!=null){
				while(rowSet.next()){
   	         		vndr_nm 	= JSPUtil.getNull(rowSet.getString("vndr_nm"));
   	         		bzct_nm 	= JSPUtil.getNull(rowSet.getString("bzct_nm")); 
   	         		bztp_nm 	= JSPUtil.getNull(rowSet.getString("bztp_nm")); 
   	         		vndr_addr 	= JSPUtil.getNull(rowSet.getString("vndr_addr"));
   	         		ceo_nm 		= JSPUtil.getNull(rowSet.getString("ceo_nm"));
				}
			}
			
			if(eviCodeSet!=null){
				while(eviCodeSet.next()){
					wkplc_nmstring  = JSPUtil.getNull(eviCodeSet.getString("wkplc_nmstring"));					
					//2010-0906 vndr_seq 맞게 값을 세팅해준다.
					if(rowSet==null || rowSet.getRowCount()<=0){
	   	         		vndr_nm 	= JSPUtil.getNull(eviCodeSet.getString("vndr_nm"));
	   	         		bzct_nm 	= JSPUtil.getNull(eviCodeSet.getString("bzct_nm")); 
	   	         		bztp_nm 	= JSPUtil.getNull(eviCodeSet.getString("bztp_nm")); 
	   	         		vndr_addr 	= JSPUtil.getNull(eviCodeSet.getString("vndr_addr"));
	   	         		ceo_nm 		= JSPUtil.getNull(eviCodeSet.getString("ceo_nm"));
	   	         		rgst_no		= JSPUtil.getNull(eviCodeSet.getString("rgst_no"));
	   	         		defOfc 		= JSPUtil.getNull(eviCodeSet.getString("def_ofc"));
					}
				}
			}
			eventResponse.setRs(rowSet);
			
			eventResponse.setETCData("vndr_nm", vndr_nm);
			eventResponse.setETCData("bzct_nm", bzct_nm);
			eventResponse.setETCData("bztp_nm", bztp_nm);
			eventResponse.setETCData("vndr_addr", vndr_addr);
			eventResponse.setETCData("ceo_nm", ceo_nm);
			eventResponse.setETCData("wkplc_nmstring", wkplc_nmstring);
			eventResponse.setETCData("rgst_no", rgst_no);
			eventResponse.setETCData("def_ofc", defOfc);
			
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * searchApEviNo <br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException {
		log.debug("start searchApEviNo ==========================");
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0078Event event = (EsdTes0078Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String 		tax_no3 	= "";
		String 		tax_no 		= "";
		DBRowSet	dbRowset 	= null;
		

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String tax_no1 = event.getCARIssueTransferSlipManageCommonVO().getTaxNo1();
		String tax_no2 = event.getCARIssueTransferSlipManageCommonVO().getTaxNo2();
		String cre_usr_id = event.getSignOnUserAccount().getUsr_id();

		try {
			dbRowset = dbDao.searchApEviNo(tax_no1, tax_no2);
			
			if(dbRowset != null){
				while(dbRowset.next()){
					tax_no3 = dbRowset.getString("tax_no3");
					tax_no = tax_no1+tax_no2+tax_no3;
				}
			}

			dbDao.searchApEviNoInsert(tax_no, cre_usr_id);
			
			eventResponse.setETCData("tax_no3", tax_no3);
			eventResponse.setETCData("gsFlg", "COMMAND01");
			eventResponse.setETCData("successFlag", "SUCCESS");

			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * searchTAXCode <br>
	 * 
	 * @param e EsdTes0078Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0078Event event 		= (EsdTes0078Event) e;
		DBRowSet 		rowSet 		= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String 			tax_code	= "";

//		HashMap param_map = (HashMap) event.getParam_map();
//		String tax_type = param_map != null ? (String) param_map.get("tax_type") : "";
//		String tax_naid_flg = param_map != null ? (String) param_map.get("tax_naid_flg") : "";
//		String fa_flg = param_map != null ? (String) param_map.get("fa_flg") : "";
//		String tax_nsl_flg = param_map != null ? (String) param_map.get("tax_nsl_flg") : "";

		try {
			rowSet = dbDao.searchTAXCode(event.getCARIssueTransferSlipManageCommonVO(), event.getApTaxVO());
			eventResponse.setRs(rowSet);
			
			if(rowSet!=null){
				if(rowSet.next()){
					tax_code = rowSet.getString("ap_tax_nm");
				}
			}

			log.debug("event.getFormCommand().toString()=========>"+event.getFormCommand().toString());
			
			eventResponse.setETCData("tax_code", tax_code);
			eventResponse.setETCData("gsFlg", "COMMAND02");
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	
	
	/*<-------------- YOO  ------------------------------------------------------------------------------------------>*/
	/**
	 * 대체전표로 검색된 해당 SO목록 searchCSRSOlist
	 * @param  Event e
	 * @return EventResponse 
	 */
	public EventResponse searchCSRSOlist(Event e) throws EventException {
		log.debug("start searchCSRSOlist ==========================");
		
		EsdTes0025Event 		event			= (EsdTes0025Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DBRowSet 				rowSet			= null;	
		
		try {
			rowSet=dbDao.searchCSRSOlist(event.getApInvHdrVO());
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 대체전표로 검색된 해당 SO목록
	 * @param Event e
	 * @return EventResponse 
	 */
	public EventResponse searchCSRSOlist2(Event e) throws EventException {
		log.debug("start searchCSRSOlist2======================");
		EsdTes0101Event event=(EsdTes0101Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DBRowSet rowSet=null;	
		
		try {
			rowSet=dbDao.searchCSRSOlist(event.getApInvHdrVO());
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 대체전표로 검색된 해당 SO목록
	 * @param Event e 
	 * @return EventResponse
	 */
	public EventResponse searchCSRSOhdr(Event e) throws EventException {
		log.debug("start bcimpl searchCSRSOhdr ========================");
		EsdTes0101Event event=(EsdTes0101Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DBRowSet rowSet=null;	
		
		try {
			rowSet=dbDao.searchCSRSOhdr(event);
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  multiRejectedCSRCancellation 
	 *  @param Event e 
	 *  @return EventResponse
	 */	
	public EventResponse multiRejectedCSRCancellation(Event e) throws EventException {
		log.debug("\n BC.multiRejectedCSRCancellation ============================= \n");
		
		EsdTes0025Event event			=(EsdTes0025Event)e;
		TesTmlSoHdrVO[]	tesTmlSoHdrVOs	= event.getTesTmlSoHdrVOs();
		CARIssueTransferSlipManageCommonVO[] cARIssueTransferSlipManageCommonVOs = event.getCARIssueTransferSlipManageCommonVOs();
		
		List<TesTmlSoHdrVO> updVoList 	= new ArrayList<TesTmlSoHdrVO>();
		
		try {
			
			for( int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++ ){
				if(tesTmlSoHdrVOs[i].getIbflag().length()>0){
					tesTmlSoHdrVOs[i].setTmlInvStsCd(cARIssueTransferSlipManageCommonVOs!=null && cARIssueTransferSlipManageCommonVOs[i].getChks().trim().equals("1")?"R":"C");
					tesTmlSoHdrVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUpd_usr_id());
					tesTmlSoHdrVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoHdrVOs[i]);
				}
				
			}
			
			dbDao.multiRejectedCSRCancellation01(updVoList);
			dbDao.multiRejectedCSRCancellation02(event.getTesTmlSoHdrVO().getCsrNo());
			
			// 2010.12.20 [CHM-201007624-01] csr cancel 추가
			dbDao.multiCSRCancelTPBIF(event.getTesTmlSoHdrVO().getCsrNo(), event.getSignOnUserAccount().getOfc_cd());
			
//			dbDao.multiRejectedCSRCancellation(event.getTES_TML_SO_HDRS(), 
//											   event.getChks(), 
//											   event.getParams(), 
//											   event.getSignOnUserAccount().getUsr_id(),
//											   event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 해당 confirm하기
	 * @param Event e 
	 * @return EventResponse
	 */	
	public EventResponse multiConfirmCSR(Event e) throws EventException {
		log.debug("\n start BC.multiConfirmCSR ====================== \n");
		
		EsdTes0100Event event=(EsdTes0100Event)e;
		int cnt = 0;
		
		try {
			//Error Reason 'Duplicated Of Vendor Invoice No'인 경우 invoice no update
			String invNo = dbDao.searchDupInvoiceNo(event.getApInvHdrVO().getCsrNo());
			if(!invNo.equals("")){
				event.getApInvHdrVO().setAttrCtnt1(invNo);
			}
			
			cnt = dbDao.multiConfirmCSR01(event);
			if(cnt>0){
				dbDao.multiConfirmCSR02(event);
			}
			
			// 2010.12.20 [CHM-201007624-01] csr cancel 추가
			dbDao.multiCSRCancelTPBIF(event.getApInvHdrVO().getCsrNo(), event.getSignOnUserAccount().getOfc_cd());
			
//			dbDao.multiConfirmCSR(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Approval Requested상태의 CSR의 cancel처리
	 * @param Event e 
	 * @return EventResponse
	 */	
	public EventResponse cancelCSR(Event e) throws EventException {
		log.debug("\n BC.cancelCSR ================================ \n");

		EsdTes0100Event event=(EsdTes0100Event)e;
		int cnt = 0;
		
		try {
			cnt = dbDao.cancelCSR01(event);
			
			if(cnt>0){
				dbDao.cancelCSR02(event);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CSR AP I/F 목록 조회
	 * @param Event e 
	 * @return EventResponse
	 */
	public EventResponse searchCSRAPiflist(Event e) throws EventException {
		log.debug("start CARIssueTransferSlipManageBCImpl.searchCSRAPiflist ========================");
		EsdTes0100Event event=(EsdTes0100Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DBRowSet rowSet=null;	
		
		try {
			rowSet=dbDao.searchCSRAPiflist(event);
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
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
	 * @param csrNo
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
	 * CSR Agreement Info List
	 * @param csrNo
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
	
	/** getCancelledBkgNoList 자동계산된 재무항차 리스트를 가져온다.
	 * 
	 * @param Event EsdTes0024Event
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] getCancelledBkgNoList(Event e) throws EventException {
		log.debug("start getCancelledBkgNoList ==================");
		
		EsdTes0024Event 	event 			= (EsdTes0024Event) e;
		TesTmlSoHdrVO[]		tesTmlSoHdrVOs 	= event.getTesTmlSoHdrVOs();
		DBRowSet[]			arrDrs			= null;
		DBRowSet			drs				= null;
		
		try {
			if(tesTmlSoHdrVOs != null) arrDrs = new DBRowSet[tesTmlSoHdrVOs.length];
			
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				if(!tesTmlSoHdrVOs[i].getIbflag().equals("")){
					drs = dbDao.getCancelledBkgNoList(tesTmlSoHdrVOs[i]);
					arrDrs[i] = drs;
				}
			}// end for
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return arrDrs;
	}
	
	/**
	 * modifyCancelledBkgNo
	 * 
	 * @param e
	 * @throws EventException
	 */	
	public void modifyCancelledBkgNo(Event e) throws EventException {
		log.debug("start modifyCancelledBkgNo ===========================");
		
		EsdTes0024Event 	event 	= (EsdTes0024Event) e;
		List<TesTmlSoCntrListVO> 	voList 	= new ArrayList<TesTmlSoCntrListVO>();
		
		TesTmlSoCntrListVO			tesTmlSoCntrListVO = null;
		DBRowSet[] 					arrDrs	= event.getBkgRowSetArr01();
		
		try {
			if(arrDrs!=null){
				for(int j=0; j<arrDrs.length; j++){
					while (arrDrs[j].next()){
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
						
						tesTmlSoCntrListVO.setBkgNo(arrDrs[j].getString("bkg_no"));
						tesTmlSoCntrListVO.setBlNo(arrDrs[j].getString("bl_no"));
						tesTmlSoCntrListVO.setVslCd(arrDrs[j].getString("vsl_cd"));
						tesTmlSoCntrListVO.setSkdVoyNo(arrDrs[j].getString("skd_voy_no"));
						tesTmlSoCntrListVO.setSkdDirCd(arrDrs[j].getString("skd_dir_cd"));
						tesTmlSoCntrListVO.setCntrNo(arrDrs[j].getString("cntr_no"));
						tesTmlSoCntrListVO.setTmlSoOfcCtyCd(arrDrs[j].getString("tml_so_ofc_cty_cd"));
						tesTmlSoCntrListVO.setTmlSoSeq(arrDrs[j].getString("tml_so_seq"));
						tesTmlSoCntrListVO.setTmlSoCntrListSeq(arrDrs[j].getString("tml_so_cntr_list_seq"));
						
						voList.add(tesTmlSoCntrListVO);
					}
				}
			}
			
			dbDao.modifyCancelledBkgNo(voList);	
					
			log.error("\n DONE - modifyCancelledBkgNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
//	/**
//	 * CSR AP I/F LONG TRAN 에러시 INV HDR ROLL BACK
//	 * @param Event e 
//	 * @return EventResponse
//	 */
//	public EventResponse modifyStsCdSOHDRBack(Event e) throws EventException {
//		log.debug("start CARIssueTransferSlipManageBCImpl.modifyStsCdSOHDRBack ========================");
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdTes0100Event event = (EsdTes0100Event)e;
//		
//		try {
//			dbDao.modifyStsCdSOHDRBack(event.getApInvHdrVO().getCsrNo());
//			return eventResponse;
//			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * CSR cancel 처리
	 */
//	public EventResponse cancelCSRAPif(Event e) throws EventException {
//
//		ESD_TES_100Event event=(ESD_TES_100Event)e;
//		
//		try {			
//			dbDao.cancelCSRAPif(event.getAP_INV_HDR(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	/*<-------------- YOO : END ------------------------------------------------------------------------------------------>*/	
	
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * CARIssueTransferSlipManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}