/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CARIssueTransferSlipManageBCImpl.java
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0025Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0078Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0100Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0101Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration.CARIssueTransferSlipManageEAIDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.clt.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.syscommon.common.table.ApInvDtrbVO;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.LeaRevVvdCngVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br> - ENIS-ESD business logic handling.<br>
 * 
 * @author jongbaemoon
 * @see CARIssueTransferSlipManageBC each DAO class reference
 * @since J2EE 1.4
 */
public class CARIssueTransferSlipManageBCImpl extends BasicCommandSupport implements CARIssueTransferSlipManageBC {

	// Database Access Object
	private transient CARIssueTransferSlipManageDBDAO dbDao = null;

	// EAI Interface Object
	private transient CARIssueTransferSlipManageEAIDAO eaiDao = null;

	/**
	 * CARIssueTransferSlipManageBCImpl object creation<br>
	 * CARIssueTransferSlipManageDBDAO creation<br>
	 */
	public CARIssueTransferSlipManageBCImpl() {
		dbDao = new CARIssueTransferSlipManageDBDAO();
		eaiDao = new CARIssueTransferSlipManageEAIDAO();
	}

	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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
			// 1. Get inv_hdr, ap_inv_hdr info  -----------------------------------------------------------------------------------------------------
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
			
			// 2. csr_no Creation
			new_csr_no = dbDao.multiCSRNo(ofc_cd, "S", "Y");
			dbDao.multiCSRInsert(ofc_cd, new_csr_no);
			log.error("\n <2> DONE - chgLEARevVVD.multiCSRNo: NEW CSRNo:"+new_csr_no+" / "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			

			// 3. AP HDR input
			dbDao.createApInvHDR2(model, new_csr_no, usr_eml, usr_id);
			log.error("\n <3> DONE - chgLEARevVVD.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 4. AP DTRB input
			dbDao.createApInvDTRB2(model, new_csr_no, ofc_cd, usr_id);
			log.error("\n <4> DONE - chgLEARevVVD.createApInvDTRB2:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 5. AP DTRB line no
			dbDao.modifyApInvDTRBLineNo(new_csr_no);
			log.error("\n <5> DONE - chgLEARevVVD.modifyApInvDTRBLineNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 6. AP DTRB sum
//			dbDao.createApInvDTRB_sum(tes_inv_hdrs, new_csr_no, curr_cd);	
			
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
			
			// 7. ASA Apply
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
			
			// 8. AP I/F Input
//			pgm_no = dbDao.createApInvIF(new_csr_no);	
//			log.error("\n <8> DONE - chgLEARevVVD.createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 9. HDR CSR NO UPDATE
//			dbDao.upateInvCSRNo(tes_inv_hdrs, new_csr_no);
//			log.error("\n <9> DONE - chgLEARevVVD.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 10.EP Billing
//			dbDao.createCSREPApproval(event.getParam_map());    --- ******
//			log.error("\n <10> DONE - chgLEARevVVD.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 11. tml_inv_sts_cd 'A' Billing
//			dbDao.modifyStsCdSOHDR(tes_inv_hdrs, "A");	
//			log.error("\n <11> DONE - chgLEARevVVD.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 12. AP AMT verify
			chkAmt = dbDao.checkCSRAmtVsInvAmt(new_csr_no);
			log.error("\n <12> DONE - chgLEARevVVD.checkCSRAmtVsInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact LEA.");
				throw new EventException(new ErrorHandler("TES00087", new String[]{}).getMessage());
				
			}
			
			// 14. ERP Interface Perform -----------------------------------------------------------------------------------------------------
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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

		// DB ResultSet object For data transfer
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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

		// DB ResultSet object For data transfer
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary1(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0023Event 		event 			= (EsdTes0023Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		// DB ResultSet object For data transfer
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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
		

		// DB ResultSet object For data transfer
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT CSR DETAIL S

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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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
		

		// DB ResultSet object For data transfer
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT

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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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
		
		// DB ResultSet object For data transfer
		DBRowSet 	rowSet 	= null;
		DBRowSet 	asaSet 	= null;
		String 		csrNo 	= "";
		String 		ap_ofc_cd = "";
		//String csr_no_sub = "S"; // S:STANDARD, C:CREDIT

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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESDTES0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse tmpSearchPreVeiw(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event 		event 			= (EsdTes0024Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		// DB ResultSet object For data transfer
		DBRowSet hdrSet  = null;
		DBRowSet dtrbSet = null;
		
		// DB ResultSet object For data transfer
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

	/** Get AutoRevVVD List
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
	
	
	/** Get ManualRevVVD List
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
	
	/** Modify AutoRevVVD
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
	
	/** Modify ManualRevVVD
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
		
	/** Search ApInvDTRBIn 
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
	
	/** Search ApInvDTRBOut
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse tmpSearchCSRSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0024Event 		event 			= (EsdTes0024Event) e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		// DB ResultSet object For data transfer
		DBRowSet hdrSet 			= null;
		DBRowSet dtrbSet 			= null;

		String cost_ofc_cd			= "";	
		String vndr_seq				= "";		
		String vndr_seq_name		= "";	
		String curr_cd				= "";		
		String hdr_total_amt		= "";
		String payment_due_dt		= "";		

      	
		// DB ResultSet object For data transfer
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
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
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
//		String 			evi_gb 			= event.getCARIssueTransferSlipManageCommonVO().getEviGb();	
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
			new TESInvoiceCommonBCImpl().checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
			csr_no = dbDao.multiCSRNo(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), event.getApInvHdrVO().getCsrTpCd(),"");	
			
			event.getTesTmlSoHdrVO().setCsrNo(csr_no);
			event.getApInvHdrVO().setCsrNo(csr_no);
			event.getApInvDtrbVO().setCsrNo(csr_no); 
			
			log.error("\n =============== searchPreVeiw.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
//			param_map.put("csr_no",csr_no);			
			
//			// 2. REVENUE VVD CONVERSION AUTO, MANUAL invoice UPDATE 처리 
//			dbDao.modifyAutoRevVVD(event.getAutoRowSetArr01());
//			log.error("\n DONE - searchPreVeiw.modifyAutoRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
//			dbDao.modifyManualRevVVD(event.getManualRowSetArr01());			
//			log.error("\n DONE - searchPreVeiw.modifyManualRevVVD:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dbDao.createApInvHDR(event);			
			log.error("\n DONE - searchPreVeiw.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
//			if (cnt_cd.equals("KR")){				
//				dtrbSets = event.getDtrbRowSetArr();
//				
//				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
//					if(dtrbSets[j]!=null){
//						while(dtrbSets[j].next()){
//							apInvDtrbVO = new ApInvDtrbVO();
//
//							apInvDtrbVO.setCsrNo(csr_no);
//							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
//							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
//							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
//							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
//							
//							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
//							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
//							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
//							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
//							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));
//
//							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
//							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
//							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
//							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
//							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
//							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
//							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
//							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
//							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
//							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));
//
//							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
//							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
//							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
//							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
//							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
//							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
//							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
//							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
//							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
//							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));
//
//							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
//							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
//							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
//							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
//							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
//							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
//							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
//							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
//							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));
//
//							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
//							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
//							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
//							apInvDtrbVO.setCreDt(ofc_cd);
//							//apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
//							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
//							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));
//
//							apInsVoList.add(apInvDtrbVO);
//						}
//					}
//				}
//				
//				dbDao.createApInvDTRB(apInsVoList);
//				dbDao.createApInvHdrUpdate(event);
//				
//				log.error("\n DONE - searchPreVeiw.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				if (evi_gb.equals("1") || evi_gb.equals("2")){					
//					dbDao.createApInvDTRBEvi(event);
//					log.error("\n DONE - searchPreVeiw.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				}				
//			} else {
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
				
				dbDao.createApInvDTRB(apInsVoList);
				dbDao.createApInvHdrUpdate(event);
				dbDao.createApInvDTRBEvi(event);
				
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map()); 
				log.error("\n DONE - searchPreVeiw.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			}
						
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
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(cnt_cd, event.getApInvDtrbVO());
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_Acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					apInvDtrbVO.setAttrCtnt7(dtrbLineSet.getString("attr_ctnt7"));
					
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

			
			
			
			log.debug("\n\n  ### ofc_cd:"+ofc_cd);
			if (ofc_cd!=null && !ofc_cd.trim().equals("")){
				if (!ofc_cd.trim().equals("SELTOB")){
					
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
			String chk_addr1	    	= "";
			String chk_addr2	    	= "";
			String chk_addr3	    	= "";
			String chk_cty_nm	    	= "";
			String chk_ste_cd	    	= "";
			String chk_zip_cd	    	= "";
			String chk_cnt_cd	    	= "";
			String pre_pay_amt          = "";
			
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
					pre_pay_amt			= hdrSet.getString("pre_pay_amt");
				
					chk_addr1	    	= hdrSet.getString("chk_addr1");  
					chk_addr2	    	= hdrSet.getString("chk_addr2");  
					chk_addr3	    	= hdrSet.getString("chk_addr3");  
					chk_cty_nm	    	= hdrSet.getString("chk_cty_nm");  
					chk_ste_cd	    	= hdrSet.getString("chk_ste_cd");  
					chk_zip_cd	    	= hdrSet.getString("chk_zip_cd");  
					chk_cnt_cd	    	= hdrSet.getString("chk_cnt_cd");  
				}
			}
			log.error("pre_pay_amtxxxx : "+pre_pay_amt);
			log.error("\n DONE - searchPreVeiw.searchPreviewDTRBList:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dbDao.deleteApInvHDRDTRB(csr_no);
			dbDao.deleteApInvHDRDTRB02(csr_no);
			
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
			eventResponse.setETCData("pre_pay_amt", pre_pay_amt);
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
	 * approvalRequest Event Process<br>
	 * CARIssueTransferSlipManage approvalRequest Event Process<br>
	 * 
	 * @param e EsdTes0024Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException {
		log.error("\n BCImpl approvalRequest ===========================");

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
//		String 			evi_gb 			= event.getCARIssueTransferSlipManageCommonVO().getEviGb();	
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
		String 			attr_ctnt11		= "";
		String 			attr_ctnt12		= "";
		String 			attr_ctnt14		= "";
		String 			payDueDt		= event.getTesTmlSoHdrVO().getPayDueDt();
		
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
		
		//String csr_tp_cd = "S"; // S:STANDARD, C:CREDIT

		try {

			TESInvoiceCommonBC inv_com = new TESInvoiceCommonBCImpl();
			inv_com.checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
	
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
			
			csr_no = dbDao.multiCSRNo(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), event.getApInvHdrVO().getCsrTpCd(),"");	
			dbDao.multiCSRInsert(JSPUtil.getNull(event.getTesTmlSoHdrVO().getCostOfcCd()), csr_no);
			event.getTesTmlSoHdrVO().setCsrNo(csr_no);
			event.getApInvHdrVO().setCsrNo(csr_no);
			event.getApInvDtrbVO().setCsrNo(csr_no);
			
			log.error("\n DONE - approvalRequest.multiCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//			param_map.put("csr_no",csr_no);			

			// 4.AP HDR, DTRB INSERT
			dbDao.createApInvHDR(event);
			log.error("\n DONE - approvalRequest.createApInvHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
//			if (cnt_cd.equals("KR")){
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map());  
//				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//				if(evi_gb.equals("1") || evi_gb.equals("2")){
//					dbDao.createApInvDTRBEvi(event.getTES_TML_SO_HDRS(), event.getParam_map());
//					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//				}
//			} else {
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map());  
//				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
//			}
			
//			if (cnt_cd.equals("KR")){				
//				dtrbSets = event.getDtrbRowSetArr();
//				
//				for(int j=0; dtrbSets!=null && j<dtrbSets.length; j++){
//					if(dtrbSets[j]!=null){
//						while(dtrbSets[j].next()){
//							apInvDtrbVO = new ApInvDtrbVO();
//
//							apInvDtrbVO.setCsrNo(csr_no);
//							apInvDtrbVO.setLineSeq(dtrbSets[j].getString("line_seq"));
//							apInvDtrbVO.setLineNo(dtrbSets[j].getString("line_no"));
//							apInvDtrbVO.setLineTpLuCd(dtrbSets[j].getString("line_tp_lu_cd"));
//							apInvDtrbVO.setInvAmt(dtrbSets[j].getString("csr_amt"));
//							
//							apInvDtrbVO.setInvDesc(dtrbSets[j].getString("inv_desc"));
//							apInvDtrbVO.setInvTaxCd(dtrbSets[j].getString("inv_tax_cd"));
//							apInvDtrbVO.setDtrbCoaCoCd(dtrbSets[j].getString("dtrb_coa_co_cd"));
//							apInvDtrbVO.setDtrbCoaRgnCd(dtrbSets[j].getString("dtrb_coa_rgn_cd"));
//							apInvDtrbVO.setDtrbCoaCtrCd(dtrbSets[j].getString("dtrb_coa_ctr_cd"));
//
//							apInvDtrbVO.setDtrbCoaAcctCd(dtrbSets[j].getString("dtrb_coa_acct_cd"));
//							apInvDtrbVO.setDtrbCoaVvdCd(dtrbSets[j].getString("dtrb_coa_vvd_cd"));
//							apInvDtrbVO.setDtrbCoaInterCoCd(dtrbSets[j].getString("dtrb_coa_inter_co_cd"));
//							apInvDtrbVO.setDtrbCoaFtuN1stCd(dtrbSets[j].getString("dtrb_coa_ftu_n1st_cd"));
//							apInvDtrbVO.setDtrbCoaFtuN2ndCd(dtrbSets[j].getString("dtrb_coa_ftu_n2nd_cd"));
//							apInvDtrbVO.setAttrCateNm(dtrbSets[j].getString("attr_cate_nm"));
//							apInvDtrbVO.setAttrCtnt1(dtrbSets[j].getString("attr_ctnt1"));
//							apInvDtrbVO.setAttrCtnt2(dtrbSets[j].getString("attr_ctnt2"));
//							apInvDtrbVO.setAttrCtnt3(dtrbSets[j].getString("attr_ctnt3"));
//							apInvDtrbVO.setAttrCtnt4(dtrbSets[j].getString("attr_ctnt4"));
//
//							apInvDtrbVO.setAttrCtnt5(dtrbSets[j].getString("attr_ctnt5"));
//							apInvDtrbVO.setAttrCtnt6(dtrbSets[j].getString("attr_ctnt6"));
//							apInvDtrbVO.setAttrCtnt7(dtrbSets[j].getString("attr_ctnt7"));
//							apInvDtrbVO.setAttrCtnt8(dtrbSets[j].getString("attr_ctnt8"));
//							apInvDtrbVO.setAttrCtnt9(dtrbSets[j].getString("attr_ctnt9"));
//							apInvDtrbVO.setAttrCtnt10(dtrbSets[j].getString("attr_ctnt10"));
//							apInvDtrbVO.setAttrCtnt11(dtrbSets[j].getString("attr_ctnt11"));
//							apInvDtrbVO.setAttrCtnt12(dtrbSets[j].getString("attr_ctnt12"));
//							apInvDtrbVO.setAttrCtnt13(dtrbSets[j].getString("attr_ctnt13"));
//							apInvDtrbVO.setAttrCtnt14(dtrbSets[j].getString("attr_ctnt14"));
//
//							apInvDtrbVO.setAttrCtnt15(dtrbSets[j].getString("attr_ctnt15"));
//							apInvDtrbVO.setBkgNo(dtrbSets[j].getString("bkg_no"));
//							apInvDtrbVO.setCntrTpszCd(dtrbSets[j].getString("cntr_tpsz_cd"));
//							apInvDtrbVO.setActVvdCd(dtrbSets[j].getString("act_vvd_cd"));
//							apInvDtrbVO.setPlnSctrDivCd(dtrbSets[j].getString("pln_sctr_div_cd"));
//							apInvDtrbVO.setSoCrrCd(dtrbSets[j].getString("so_crr_cd"));
//							apInvDtrbVO.setYdCd(dtrbSets[j].getString("yd_cd"));
//							apInvDtrbVO.setFtuUseCtnt1(dtrbSets[j].getString("ftu_use_ctnt1"));
//							apInvDtrbVO.setFtuUseCtnt2(dtrbSets[j].getString("ftu_use_ctnt2"));
//
//							apInvDtrbVO.setFtuUseCtnt3(dtrbSets[j].getString("ftu_use_ctnt3"));
//							apInvDtrbVO.setFtuUseCtnt4(dtrbSets[j].getString("ftu_use_ctnt4"));
//							apInvDtrbVO.setFtuUseCtnt5(dtrbSets[j].getString("ftu_use_cntr5"));
//							apInvDtrbVO.setCreDt(ofc_cd);
////							apInvDtrbVO.setCreUsrId(dtrbSets[j].getString("cre_usr_id"));
//							apInvDtrbVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
//							apInvDtrbVO.setEaiEvntDt(dtrbSets[j].getString("eai_evnt_dt"));
//
//							apInsVoList.add(apInvDtrbVO);
//						}
//					}
//				}
//				
//				dbDao.createApInvDTRB(apInsVoList);
//				dbDao.createApInvHdrUpdate(event);
//				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//
//				if (evi_gb.equals("1") || evi_gb.equals("2")){					
//					dbDao.createApInvDTRBEvi(event);
//					log.error("\n DONE - approvalRequest.createApInvDTRBEvi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//				}
//				
//			} 
//		else {
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
				
				dbDao.createApInvDTRB(apInsVoList);
				dbDao.createApInvHdrUpdate(event);
				dbDao.createApInvDTRBEvi(event);
				
//				dbDao.createApInvDTRB(event.getDTRBRowSetArr(), event.getParam_map());
				log.error("\n DONE - approvalRequest.createApInvDTRB:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
//			}
						
			dbDao.modifyApInvDTRBLineNo(csr_no);
			dtrbLineSet = dbDao.modifyApInvDTRBLineNo03(cnt_cd, event.getApInvDtrbVO());
			if (dtrbLineSet != null) {
				while(dtrbLineSet.next()){
					apInvDtrbVO = new ApInvDtrbVO();
					
					apInvDtrbVO.setLineNo(dtrbLineSet.getString("line_no"));
					apInvDtrbVO.setCsrNo(csr_no);
					apInvDtrbVO.setAttrCtnt1(dtrbLineSet.getString("attr_ctnt1"));
					apInvDtrbVO.setDtrbCoaAcctCd(dtrbLineSet.getString("dtrb_coa_Acct_cd"));
					apInvDtrbVO.setDtrbCoaVvdCd(dtrbLineSet.getString("dtrb_coa_vvd_cd"));
					apInvDtrbVO.setAttrCtnt7(dtrbLineSet.getString("attr_ctnt7"));
					
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
	            		attr_ctnt11	= asaRowSet.getString("attr_ctnt11");
	            		attr_ctnt12	= asaRowSet.getString("attr_ctnt12");
	            		attr_ctnt14	= asaRowSet.getString("attr_ctnt14");	            		
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
	            apInvDtrbVO.setAttrCtnt11(attr_ctnt11);
	            apInvDtrbVO.setAttrCtnt12(attr_ctnt12);
	            apInvDtrbVO.setAttrCtnt14(attr_ctnt14);
	            
	            cARIssueTransferSlipManageCommonVO.setAcctCd(acct_cd);
	            tesTmlSoHdrVO.setCostOfcCd(event.getTesTmlSoHdrVO().getCostOfcCd());
	            tesTmlSoHdrVO.setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
	            
	            cARIssueTransferSlipManageCommonVO.setAsaNo(asa_no);

	            apInvDtrbVO.setCsrNo(csr_no);
	            dbDao.createApInvDTRBASANoInsert(cARIssueTransferSlipManageCommonVO, tesTmlSoHdrVO, apInvDtrbVO, ofc_cd, event.getSignOnUserAccount().getUsr_id());
				dbDao.createApInvDTRBASANoUpdate(csr_no);
				log.error("\n DONE - approvalRequest.createApInvDTRBASANo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			}
			
			// 5. R.VVD LEVEL CHECK
			//dbDao.searchApInvVVDChacke(csr_no);
			log.error("\n DONE - approvalRequest.searchApInvVVDChacke:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			

//			// 6.AP I/F에 INSERT
//			pgm_no = dbDao.createApInvIF(csr_no);	
//			log.error("\n DONE - approvalRequest.createApInvIF:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			// 7.HDR CSR NO UPDATE 처리
//			dbDao.upateInvCSRNo(event.getTES_TML_SO_HDRS(), csr_no);
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				tesTmlSoHdrVOs[i].setCsrNo(csr_no);
				tesTmlSoHdrVOs[i].setPayDueDt(payDueDt);
				upInvCSRVoList.add(tesTmlSoHdrVOs[i]); 
			}
			dbDao.upateInvCSRNo(upInvCSRVoList, csr_no);
			log.error("\n DONE - approvalRequest.upateInvCSRNo:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
//			log.error("\n\n ### "+JSPUtil.getNull(csr_no)+" - apro_step : "+JSPUtil.getNull(String.valueOf(event.getParam_map().get("apro_step")))+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n\n");
			// 8.EP Billing
			dbDao.createCSREPApproval(event);
			log.error("\n DONE - csr_no==============>"+csr_no+"  approvalRequest.createCSREPApproval:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
						
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
			
			// 9. tml_inv_sts_cd 'A' Billing
			inv_com.checkInvoiceStatus(event.getTesTmlSoHdrVOs(),TESInvoiceCommonBC.INV_STS_CF);
//			dbDao.modifyStsCdSOHDR(event.getTES_TML_SO_HDRS(), "A");
			for(int i=0; tesTmlSoHdrVOs!=null && i<tesTmlSoHdrVOs.length; i++){
				tesTmlSoHdrVOs[i].setTmlInvStsCd("A");
				upStsCDVoList.add(tesTmlSoHdrVOs[i]);
			}
			dbDao.modifyStsCdSOHDR(upStsCDVoList);
			log.error("\n DONE - approvalRequest.modifyStsCdSOHDR:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			
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
				if (!ofc_cd.trim().equals("SELTOB")){
					
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
			
			// 12. Rev.VVD master check
			revVVDSet = dbDao.checkMstRevVVD01(csr_no);
			
			if (revVVDSet!=null){
				while (revVVDSet.next()){
					vvd_cd = revVVDSet.getString("DTRB_COA_VVD_CD");
					inv_no = revVVDSet.getString("ATTR_CTNT1");
					log.debug("\n\n DTRB_COA_VVD_CD:"+revVVDSet.getString("DTRB_COA_VVD_CD")+" / inv_no:"+revVVDSet.getString("ATTR_CTNT1")+"  ---------------------  --------------------- ---------------------  \n\n");

					//revVVDSet2 = dbDao.checkMstRevVVD02(csr_no);
					revVVDSet2 = dbDao.checkMstRevVVD02(vvd_cd);
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
			
			
			this.approvalAfterTPB(csr_no);
			
			
			eventResponse.setETCData("csrNo", csr_no);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
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
	 * tesUpdateCSRSTSFlag<br>
	 * 
	 * @param String flag
	 * @param String csr_no
	 * @exception EventException
	 */
	public void tesUpdateCSRSTSFlag(String flag, String csr_no) throws EventException {
		
		DBRowSet 	soRowSet 	= null;
		
		TesTmlSoHdrVO 		tesTmlSoHdrVO	= null;
		List<TesTmlSoHdrVO> voList			= new ArrayList<TesTmlSoHdrVO>();

		try {
			soRowSet	= dbDao.searchSO(csr_no);
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
            
            /** APPROVAL CONFIRM	*/
			if (flag.equals("C")){
				dbDao.modifyStsCdSOHDR(voList);	
			
			/** APPROVAL REJECT	*/
			} else if (flag.equals("R")) {
				dbDao.rejectInvoice(voList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * approvalRequest Event Process<br>
	 * CARIssueTransferSlipManage approvalRequest Event Process<br>
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
	 * approvalRequest Event Process<br>
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
	 * approvalRequest Event Process<br>
	 * approvalAfterTPB
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
		 * 1) CSR I/F SUCCESS(IF_FLG 'Y') TES_TML_SO_HDR의 AP_IF_DT = SYSDATE, HPC_CRE_FLG = 'N', LEA_CRE_FLG = 'N' Add
		 */
/*		
		try {
			//dbDao.updateHPC(csr_no, "1");
		} catch (DAOException de) {
			log.error("\n\n approvalAfterTPB.updateHPC.DAOException - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalAfterTPB.updateHPC.Exception - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
*/	 	

		try {
			
			soRowSet = dbDao.searchSO(csr_no);

            if (soRowSet != null) {
            	while(soRowSet.next()){
            		tesTmlSoHdrVO = new TesTmlSoHdrVO();
            		tesTmlSoHdrVO.setIbflag("R");
            		tesTmlSoHdrVO.setTmlInvStsCd("A");
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
		            		
		            		tPBInterfaceVOs[tpbSeq].setCsrNoCxlFlg("N");
		            		
		            		log.error("\n tpbRowSet.tml_if_ofc_cd============>"+tPBInterfaceVOs[tpbSeq].getTmlIfOfcCd());
		            		log.error("\n tpbRowSet.tml_if_seq============>"+tPBInterfaceVOs[tpbSeq].getTmlIfSeq());
		            		tpbSeq++;
		            	}
		            }
				}
			}
			
			
			log.error("\n XXXXX begin - approvalAfterTPB.createTESTPB = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			tbpIF.createTESTPB(tPBInterfaceVOs);	
			
			log.error("\n XXXXX end - approvalAfterTPB.createTESTPB = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		} catch (DAOException de) {
			log.error("\n\n approvalAfterTPB.TPB.DAOException - \n" + de.toString(), de);
/*			try {
				log.error("\n XXXXX begin - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				//dbDao.updateAPErrRsn01(csr_no,"TPB");
//				dbDao.updateAPErrRsn02(csr_no,"TPB");
				log.error("\n XXXXX end - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} catch (DAOException de2) {
				log.error(de2.getMessage(),de2);
				throw new EventException(de2.getMessage());
			}
*/			
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalAfterTPB.TPB.Exception - \n" + de.toString(), de);
/*			try {
				log.error("\n XXXXX begin - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				//dbDao.updateAPErrRsn01(csr_no,"TPB");
//				dbDao.updateAPErrRsn02(csr_no,"TPB");
				log.error("\n XXXXX end - approvalAfterTPB.TPB.updateAPErrRsn(TPB) = CSR_NO:" + JSPUtil.getNull(csr_no)+" - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			} catch (DAOException de2) {
				log.error(de2.getMessage(),de2);
				throw new EventException(de2.getMessage());
			}
*/			
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}	
	
	/**
	 * approvalRequest Event Process<br>
	 * approvalRejectLEA<br>
	 * 
	 * @param String csr_no
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRejectLEA(String csr_no) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			dbDao.updateHPC(csr_no, "2");
		} catch (DAOException de) {
			log.error("\n\n approvalRejectLEA.updateHPC.DAOException - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n approvalRejectLEA.updateHPC.Exception - \n" + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}		

	/**
	 * retrieve event process
	 * searchTAXInfo<br>
	 * 
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException {
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
 		
		String wkplc_nmstring	= "";
		StringBuffer wkplc_nmstring_buf	= new StringBuffer();
		String rgst_no			= "";
		
		
		// DB ResultSet object For data transfer
		String compNo = event.getCARIssueTransferSlipManageCommonVO().getCompNo();
		String vndrSeq = event.getCARIssueTransferSlipManageCommonVO().getVndrSeq();

		try {
			rowSet 		= dbDao.searchTAXDetail(compNo);
			eviCodeSet 	= dbDao.searchEviCodeList(vndrSeq);
			
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
//					wkplc_nmstring  = wkplc_nmstring+"|"+JSPUtil.getNull(eviCodeSet.getString("wkplc_nmstring"));
					wkplc_nmstring_buf.append("|").append(JSPUtil.getNull(eviCodeSet.getString("wkplc_nmstring")));
					
					if(rowSet==null || rowSet.getRowCount()<=0){
	   	         		vndr_nm 	= JSPUtil.getNull(eviCodeSet.getString("vndr_nm"));
	   	         		bzct_nm 	= JSPUtil.getNull(eviCodeSet.getString("bzct_nm")); 
	   	         		bztp_nm 	= JSPUtil.getNull(eviCodeSet.getString("bztp_nm")); 
	   	         		vndr_addr 	= JSPUtil.getNull(eviCodeSet.getString("vndr_addr"));
	   	         		ceo_nm 		= JSPUtil.getNull(eviCodeSet.getString("ceo_nm"));
	   	         		rgst_no		= JSPUtil.getNull(eviCodeSet.getString("rgst_no"));
					}
				}
			}
			
			wkplc_nmstring = wkplc_nmstring_buf.toString();
			
			eventResponse.setRs(rowSet);
			
			eventResponse.setETCData("vndr_nm", vndr_nm);
			eventResponse.setETCData("bzct_nm", bzct_nm);
			eventResponse.setETCData("bztp_nm", bztp_nm);
			eventResponse.setETCData("vndr_addr", vndr_addr);
			eventResponse.setETCData("ceo_nm", ceo_nm);
			eventResponse.setETCData("wkplc_nmstring", wkplc_nmstring);
			eventResponse.setETCData("rgst_no", rgst_no);
			
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
	 * retrieve event process
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
		

		// DB ResultSet object For data transfer
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
	 * retrieve event process
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

	
	
	/**
	 * SOList searchCSRSOlist Search
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
	 * SOList searchCSRSOlist Search
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
	 * SOList searchCSRSOlist Search
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
	 * CSR confirm
	 * @param Event e 
	 * @return EventResponse
	 */	
	public EventResponse multiConfirmCSR(Event e) throws EventException {
		log.debug("\n start BC.multiConfirmCSR ====================== \n");
		
		EsdTes0100Event event=(EsdTes0100Event)e;
		int cnt = 0;
		
		try {
			cnt = dbDao.multiConfirmCSR01(event);
			if(cnt>0){
				dbDao.multiConfirmCSR02(event);
			}
			
			dbDao.multiCSRCancelTPBIF(event.getApInvHdrVO().getCsrNo(), event.getSignOnUserAccount().getOfc_cd());
			
//			dbDao.multiConfirmCSR(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Approval Requested Status CSR cancel Process
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
	 * CSR AP I/F List Search
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

	/** modifyTESInvHdrForPay
	 * 
	 * @param String csr_no
	 * @param String sTrspInvAudStsCd
	 * @param String pay_dt
	 */
	public void modifyTESInvHdrForPay(String csr_no, String sTrspInvAudStsCd, String pay_dt)  throws EventException  {		
		log.debug("\n BC.modifyTESInvHdrForPay() ------  \n");
		
		try{
			
			log.debug("TES!!");
			//SO_HDR (CSR_NO기준으로 PAYMENT_FLG('Y'), PAYMENT_DT)'
			dbDao.modifyTESInvHdr(csr_no, sTrspInvAudStsCd,  pay_dt);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
//	/**
//	 * CSR AP I/F LONG TRAN Error INV HDR ROLL BACK
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
	 * CSR cancel Process
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
	 * ESD Handling for the end of working scenario<br>
	 * CARIssueTransferSlipManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}