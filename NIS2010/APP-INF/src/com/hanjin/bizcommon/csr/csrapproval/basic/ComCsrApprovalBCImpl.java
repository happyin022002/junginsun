/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ComCsrApprovalBCImpl.java
 *@FileTitle : Common CSR Business Logic Command implementation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.08
 *@LastModifier : Young Shin Kim
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * 2014.12.18 I/F Data Update Method add
 * -------------------------------------------------------
 */
package com.hanjin.bizcommon.csr.csrapproval.basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChsMgsSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBC;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBC;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.MnrSendGWAgreementInfoBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.GrpAgentVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBC;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBC;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.bizcommon.approval.basic.ApprovalBC;
import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
//import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0008Event;
import com.hanjin.bizcommon.csr.csrapproval.integration.ComCsrApprovalDBDAO;
import com.hanjin.bizcommon.csr.csrapproval.integration.ComCsrEAIDAO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
//import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * Common CSR Business Logic Basic Command implementation<br> - Common CSR에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Young Shin Kim
 * @see 
 * @since J2EE 1.4
 */

public class ComCsrApprovalBCImpl extends BasicCommandSupport implements ComCsrApprovalBC {
	
	// Database Access Object
	private transient ComCsrApprovalDBDAO dbDao = null;

	public ComCsrApprovalBCImpl() {
		dbDao = new ComCsrApprovalDBDAO();
	}

	/**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @param csrNo
	 * @param invSubSysCd
	 * @param account
	 * @return gwUrl 
	 * @throws EventException
	 */
	public String sendGwApprovalRequestInfo(String csrNo, String invSubSysCd, SignOnUserAccount account) throws EventException {		
		
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		AGNCommAgreementBC acmCommand = new AGNCommAgreementBCImpl();
		TCharterIOConsultationBC fmsCommand = new TCharterIOConsultationBCImpl();
		PayableRentalCostBC lseCommand = new PayableRentalCostBCImpl(); 
		GeneralInvoiceAuditBCImpl psoCommond = new GeneralInvoiceAuditBCImpl(); 
		ChsMgsSendGWAgreementInfoBC cgmCommand = new ChsMgsSendGWAgreementInfoBCImpl();
	    MnrSendGWAgreementInfoBC mnrCommand = new MnrSendGWAgreementInfoBCImpl();

		ApprovalUtil aproUtil = new ApprovalUtil();
		
		try {			
			ComCsrInfoVO gwVo = new ComCsrInfoVO();
			ComApCsrHisVO hisVo = new ComApCsrHisVO();
			
			if(csrNo == null || csrNo.equals("")){
				throw new EventException("There is no CSR_NO.");
			}
			if(invSubSysCd == null || invSubSysCd.equals("") || invSubSysCd.length() < 3) {
				throw new EventException("There is no INV_SUB_SYS_CD.");
			}
			
			//-------------------------------------
			// 사용자 설정 (GW사용자 아이디 변환)
			// -------------------------------------		
			String usrId = account.getUsr_id();
			String gwUserId = dbDao.searchGwUserId(usrId);
			
			if (gwUserId == null) {
				gwUserId = account.getUsr_id();
			}
			
			String requestId = "COM006-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSCSR-" + csrNo;
			
			gwVo.setUserId(gwUserId);		
			gwVo.setSysDocId("ALPS_CSR_EP_1");
			gwVo.setRequestId(requestId);
			gwVo.setUserTp("GR");
			gwVo.setSysTp("ALPSCSR");
			gwVo.setCsrNo(csrNo);
			
			// -------------------------------------
			// GW 연동 정보를  history 테이블에 저장한다.
			// -------------------------------------
	    	hisVo.setCsrNo(csrNo);
	    	hisVo.setCsrAproTpCd("GW");
	    	hisVo.setAutoMnlFlg("Y");
	    	hisVo.setIoBndCd("O");
	    	hisVo.setGwCsrRqstId(requestId);
	    	hisVo.setCreUsrId(usrId);
	    	hisVo.setUpdUsrId(usrId);
	    	
	    	dbDao.saveGWInfo(hisVo);
	    	log.error("\n 1. DONE - ComCsrApprovalBCImpl.sendGwApprovalRequestInfo : saveGWInfo (csr_no:"+(csrNo)+")\n");
			
			// -------------------------------------
			//  csrNo을 가지고 모듈별로 정보를 조회한다.
			// -------------------------------------
			ComCsrRequestHeaderVO headerVo = null;
			List<ComCsrRequestBodyVO> bodyVos = null;
			List<ComCsrRequestAgmtVO> agmtVos = null;
			List<ComCsrRequestFileVO> fileVos = null;
			List<ComCsrRequestFileVO> fileVos2 = null;

			if(invSubSysCd.equals("TES")) {				
				headerVo = tesCommand.printComCsrHeaderInfo(csrNo);
				bodyVos = tesCommand.printComCsrBodyInfo(csrNo);
				agmtVos = tesCommand.printComCsrAgmtInfo(csrNo);
			} else if(invSubSysCd.equals("TRS")) {
				headerVo = trsCommand.printComCsrHeaderInfo(csrNo);
				bodyVos = trsCommand.printComCsrBodyInfo(csrNo);
				agmtVos = trsCommand.printComCsrAgmtInfo(csrNo);
				fileVos = trsCommand.printComCsrFileInfo(csrNo);					
			} else if("ACM".equals(invSubSysCd)) {
				GrpAgentVO agentVO = new GrpAgentVO();
				agentVO  = acmCommand.manageAgentApplication(csrNo);
				
				headerVo = agentVO.getHeaderVo();
				bodyVos  = agentVO.getBodyVos();
				agmtVos  = agentVO.getAgmtVos();
			} else if("FMS".equals(invSubSysCd)) {
				headerVo = fmsCommand.printComCsrHeaderInfo(csrNo);
				bodyVos = fmsCommand.printComCsrBodyInfo(csrNo);
				agmtVos = fmsCommand.printFmsCsrAgmtInfo(csrNo);
				fileVos = fmsCommand.printComCsrFileInfo(csrNo);
				//log.debug("FMS ATTACH FILE...");
			} else {
				headerVo = dbDao.printComCsrHeaderInfo(csrNo);
				bodyVos = dbDao.printComCsrBodyInfo(csrNo);
				
				if(invSubSysCd.equals("LSE")){
					agmtVos = lseCommand.printComCsrLseAgmtInfo(csrNo); 
				} else if("PSO".equals(invSubSysCd)) {
					fileVos = psoCommond.printComCsrFileInfo(csrNo);
				} else if(invSubSysCd.equals("MNR")) {
					agmtVos = mnrCommand.printComCsrAgmtInfo(csrNo);
				    fileVos = mnrCommand.printComCsrFileInfo(csrNo);
				}else if(invSubSysCd.equals("CHS") || invSubSysCd.equals("MGS") || invSubSysCd.equals("CGM")){ 
					agmtVos = cgmCommand.printComCsrAgmtInfo(csrNo);
				}
			}
			
			fileVos2 = dbDao.printComCsrFileInfo(csrNo);
			
			if (headerVo == null) {
				return null;
			}			
			
			//SUBJECT : "Payment" + INTG_CD_VAL_DP_DESC + ":" +  CSR_NO + "_" + Pay To(50자까지) 
			String payTo = JSPUtil.getNull(headerVo.getPayTo());
			if(payTo.length() > 50) 
				payTo = payTo.substring(0, 50);
			
			String subject =  "Payment " + searchSubject(invSubSysCd) + ":" + csrNo + "_" + payTo;
					
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);

		    pw.println("<?xml version=\"1.0\" encoding = \"EUC-KR\" ?>");
		    pw.println("<ROOT>");					
		    pw.println("<HEADER>");					
		    pw.println("<SUBJECT><![CDATA[" + subject + "]]></SUBJECT>");					
		    pw.println("<VATREGISTNO><![CDATA[" + headerVo.getVatregistno() + "]]></VATREGISTNO>");					
		    pw.println("<CSRDATE><![CDATA[" + headerVo.getCsrdate() + "]]></CSRDATE>");					
		    pw.println("<CSR_NO><![CDATA[" + headerVo.getCsrNo() + "]]></CSR_NO>");					
		    pw.println("<OFFICE><![CDATA[" + headerVo.getOffice() +"]]></OFFICE>");					
		    pw.println("<PRPD_BY><![CDATA[" + headerVo.getPrpdBy() + "]]></PRPD_BY>");					
		    pw.println("<BUDGET><![CDATA[" + headerVo.getBudget() + "]]></BUDGET>");					
		    pw.println("<PERFORMANCE><![CDATA[" + headerVo.getPerformance() + "]]></PERFORMANCE>");					
		    pw.println("<RATIO><![CDATA[" + headerVo.getRatio() + "]]></RATIO>");					
		    pw.println("<PAY_TO><![CDATA[" + headerVo.getPayTo() + "]]></PAY_TO>");					
		    pw.println("<DESCRIPTION><![CDATA[" + headerVo.getDescription() + "]]></DESCRIPTION>");					
		    pw.println("<EVIDENCE><![CDATA[" + headerVo.getEvidence() + "]]></EVIDENCE>");					
		    pw.println("<QTY><![CDATA[" + headerVo.getQty() + "]]></QTY>");					
		    pw.println("<INVOICE_DATE><![CDATA["+ headerVo.getInvoiceDate() + "]]></INVOICE_DATE>");					
		    pw.println("<DUE_DATE><![CDATA[" + headerVo.getDueDate() + "]]></DUE_DATE>");					
		    pw.println("<AR_OFFSET_NO><![CDATA[" + headerVo.getArOffsetNo() + "]]></AR_OFFSET_NO>");					
		    pw.println("<CSR_TYPE><![CDATA[" + headerVo.getCsrType() + "]]></CSR_TYPE>");					
		    pw.println("<PAY_GROUP><![CDATA[" + headerVo.getPayGroup() +"]]></PAY_GROUP>");					
		    pw.println("<ASA_NO><![CDATA[" + headerVo.getAsaNo() + "]]></ASA_NO>");					
		    pw.println("<CURRENCY><![CDATA[" + headerVo.getCurrency() + "]]></CURRENCY>");					
		    pw.println("<AMOUNT><![CDATA[" + headerVo.getAmount() + "]]></AMOUNT>");					
		    pw.println("<PYMT_AMT><![CDATA[" + headerVo.getPymtAmt() + "]]></PYMT_AMT>");					
		    pw.println("<APR_LINE><![CDATA[" + headerVo.getAprLine() + "]]></APR_LINE>");
		    //CHM-201535264 심성윤 2015.04.13 예외 오피스 지정
		    pw.println("<LOGIN_OFFICE><![CDATA[" + JSPUtil.getNull(aproUtil.getExptOfc(csrNo, account.getOfc_cd())) + "]]></LOGIN_OFFICE>"); // 원 기안자  결재 부서 정보(변경 부서가 아님)								
		    pw.println("<AAFLAG><![CDATA[" + JSPUtil.getNull(aproUtil.searchAgmtCfmCd2(csrNo)) + "]]></AAFLAG>");
		    pw.println("</HEADER>");		    
		    pw.println("<BODY>");
		   
	    	for(int i=0;i<bodyVos.size();i++) {
	    		ComCsrRequestBodyVO bodyVo = bodyVos.get(i);
	    		pw.println("<ROW>");
	    		pw.println("<L_SEQ><![CDATA["+ bodyVo.getLSeq() +"]]></L_SEQ>");	
	    		pw.println("<L_COA><![CDATA[" + bodyVo.getLCoa() + "]]></L_COA>");				
	    		pw.println("<L_ACCOUNT_NAME><![CDATA[" + bodyVo.getLAccountName() + "]]></L_ACCOUNT_NAME>");				
	    		pw.println("<L_GL_DATE><![CDATA[" + bodyVo.getLGlDate() + "]]></L_GL_DATE>");					
	    		pw.println("<L_CITY><![CDATA[" + bodyVo.getLCity() + "]]></L_CITY>");					
	    		pw.println("<L_VENDOR_INV_NO><![CDATA[" + bodyVo.getLVendorInvNo() +"]]></L_VENDOR_INV_NO>");					
	    		pw.println("<L_DESCRIPTION><![CDATA[" + bodyVo.getLDescription() + "]]></L_DESCRIPTION>");					
	    		pw.println("<L_DEBIT_AMT><![CDATA[" + bodyVo.getLDebitAmt() + "]]></L_DEBIT_AMT>");					
	    		pw.println("<L_CREDIT_AMT><![CDATA[" + bodyVo.getLCreditAmt() + "]]></L_CREDIT_AMT>");	
	    		pw.println("</ROW>");
	    	}

		    pw.println("</BODY>");
		    pw.println("<FOOTER>");					
		    pw.println("<DEBIT_AMT><![CDATA[" + headerVo.getAmount() + "]]></DEBIT_AMT>");					
		    pw.println("<CREDIT_AMT><![CDATA[" + headerVo.getAmount() + "]]></CREDIT_AMT>");					
		    pw.println("</FOOTER>");					
		  
		    if(agmtVos != null && agmtVos.size() > 0) {	    		    
		    	pw.println("<AGMT_ATTACH>");	
			    for(int i=0;i<agmtVos.size();i++) {
		    		ComCsrRequestAgmtVO agmtVo = agmtVos.get(i);	    		
		    		pw.println("<ROW>");					
		    		pw.println("<L_ASSETCD><![CDATA[" + agmtVo.getLAssetcd() + "]]></L_ASSETCD>");					
		    		pw.println("<L_DOCUMENT_TITLE><![CDATA[" + agmtVo.getLDocumentTitle() + "]]></L_DOCUMENT_TITLE>");					
		    		pw.println("</ROW>");
			    }
			    pw.println("</AGMT_ATTACH>");		    			   
		    }
		   
		    if((fileVos != null && fileVos.size() > 0) || (fileVos2 != null && fileVos2.size() > 0)) {		    			    
		    	pw.println("<FILE_ATTACH>");		    	
		    	if(fileVos != null && fileVos.size() > 0) {
			    	for(int i=0;i<fileVos.size();i++) {
			    		ComCsrRequestFileVO fileVo = fileVos.get(i);
			    		pw.println("<ROW>");		
			    		pw.println("<L_FILE_MODULE_ID><![CDATA[" + fileVo.getLFileModuleId() + "]]></L_FILE_MODULE_ID>");					
			    		pw.println("<L_FILE_SAV_ID><![CDATA[" + fileVo.getLFileSavId() + "]]></L_FILE_SAV_ID>");					
			    		pw.println("<L_FILE_NM><![CDATA[" + fileVo.getLFileNm() + "]]></L_FILE_NM>");	
			    		pw.println("<L_FILE_SZ><![CDATA[" + JSPUtil.getNull(aproUtil.searchFileSize(fileVo.getLFileSavId())) + "]]></L_FILE_SZ>");	
			    		pw.println("</ROW>");
				    }	
		    	}
		    	if(fileVos2 != null && fileVos2.size() > 0) {
				    for(int i=0;i<fileVos2.size();i++) {
			    		ComCsrRequestFileVO fileVo2 = fileVos2.get(i);
			    		pw.println("<ROW>");		
			    		pw.println("<L_FILE_MODULE_ID><![CDATA[" + fileVo2.getLFileModuleId() + "]]></L_FILE_MODULE_ID>");					
			    		pw.println("<L_FILE_SAV_ID><![CDATA[" + fileVo2.getLFileSavId() + "]]></L_FILE_SAV_ID>");					
			    		pw.println("<L_FILE_NM><![CDATA[" + fileVo2.getLFileNm() + "]]></L_FILE_NM>");	
			    		pw.println("<L_FILE_SZ><![CDATA[" + JSPUtil.getNull(aproUtil.searchFileSize(fileVo2.getLFileSavId())) + "]]></L_FILE_SZ>");	
			    		pw.println("</ROW>");
				    }		
		    	}
			    pw.println("</FILE_ATTACH>");				    			    
		    }

		    pw.println("</ROOT>");			
		    
		    gwVo.setXmlData(sw.toString());
		    
		    ComCsrEAIDAO eaiDao = new ComCsrEAIDAO();		
		    String gwUrl = eaiDao.sendGWData(gwVo);
		    
		    if(gwUrl != null) {
		    	//G/W URL과 request_id 업데이트
		    	aproUtil.updateAproGwUrl(csrNo, requestId, gwUrl);
		    
		    	// -------------------------------------
				// G/W 연동 정보를  history 테이블에 저장한다.
				// -------------------------------------
		    	hisVo.setCsrNo(csrNo);
		    	hisVo.setCsrAproTpCd("GW");
		    	hisVo.setAutoMnlFlg("Y");
		    	hisVo.setIoBndCd("I");
		    	hisVo.setGwCsrRqstId(requestId);
		    	hisVo.setGwAproUrlCtnt(gwUrl);
		    	hisVo.setCreUsrId(usrId);
		    	hisVo.setUpdUsrId(usrId);
		    	
		    	dbDao.saveGWInfo(hisVo);
		    	log.error("\n 2. DONE - ComCsrApprovalBCImpl.sendGwApprovalRequestInfo : saveGWInfo (csr_no:"+(csrNo)+")\n");
		    }
		    
			return gwUrl; 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getUserMessage(), de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * CSR_No로 SUB_SYS_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchSubSysCd(String csrNo) throws EventException {
		try {
			return dbDao.searchSubSysCd(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Sub Sys Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Sub Sys Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR_No로 OFC_CD 를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCd(String csrNo) throws EventException {
		try {
			return dbDao.searchOfcCd(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Ofc Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Ofc Code"}).getMessage(), ex);
		}
	}
	
	/**
	 * History table insert<br>
	 *
	 * @param ComApCsrHisVO comApCsrHisVO
	 * @throws EventException
	 */
	public void saveGWInfo(ComApCsrHisVO comApCsrHisVO) throws EventException {
		try {
			dbDao.saveGWInfo(comApCsrHisVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"History table insert"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"History table insert"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다. <br>
	 *
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchRqstAproStepFlg(String csrNo) throws EventException {
		try {
			return dbDao.searchRqstAproStepFlg(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RQST_APRO_STEP_FLG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RQST_APRO_STEP_FLG"}).getMessage(), ex);
		}
	}
	
	/**
	 * 모듈별 Subject를 조회한다. <br>
	 *
	 * @param String invSubSydCd
	 * @return String
	 * @throws EventException
	 */
	public String searchSubject(String invSubSydCd) throws EventException {
		try {
			return dbDao.searchSubject(invSubSydCd);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
		}
	}
	
	/**
	 * I/F Flag의 상태를 조회한다. <br>
	 * COM_CSR_0015<br>
	 * @author 2015513 심성윤 (2015.03.13)
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckIfFlg(String csrNo) throws EventException {
		try {
			return dbDao.searchCheckIfFlg(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
		}
	}
	/**
	 * 기안이 완료 전 상태인지를 조회한다.<br>
	 * CHM-201535042<br>
	 * @author 심성윤 (2015.03.31)
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckAproStepFlg(String csrNo) throws EventException{
		try {
			return dbDao.searchCheckAproStepFlg(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Subject"}).getMessage(), ex);
		}
	}
	/**
	 * GW 승인자 정보를 조회한다<br>
	 *
	 * @param String csrNo
	 * @return ComApCsrHisVO 
	 * @throws EventException
	 */
	public ComApCsrHisVO searchCsrHisInfo(String csrNo) throws EventException {
		try {
			return dbDao.searchCsrHisInfo(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
		}
	}
	/**
	 * AL 승인자 정보를 조회한다<br>
	 * COM_CSR_0015<br>
	 * @author 2015513 심성윤 (2015.03.13)
	 * @param String csrNo
	 * @return ComApCsrHisVO 
	 * @throws EventException
	 */
	public ComCsrInfoVO searchCsrApAproInfo(String csrNo) throws EventException {
		try {
			return dbDao.searchCsrApAproInfo(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
		}
	}
	
	/**
	 * I/F DT update<br>
	 *
	 * @param String csrNo
	 * @throws EventException
	 */
	public void updateErpInterface(String csrNo) throws EventException {
		try {
			dbDao.updateErpInterface(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AP_INV_HDR table update"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AP_INV_HDR table update"}).getMessage(), ex);
		}
	}
	
	/**
	 * Batch로 ERP I/F할 대상 CSR 조회
	 *  
	 * @return List<ComCsrInfoVO>
	 * @throws EventException
	 */
	public List<ComCsrInfoVO> searchBatchCsr() throws EventException {
		try {
			return dbDao.searchBatchCsr();
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search History Info"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR 단위로 ERP I/F 처리
	 * @param ComCsrInfoVO vo
	 * @throws EventException
	 */
	public void processErpInterface(ComCsrInfoVO vo) throws EventException {
		
		String csrNo = JSPUtil.getNull(vo.getCsrNo());
		String usrId = JSPUtil.getNull(vo.getUserId());
		String aproUsrNm = JSPUtil.getNull(vo.getAproUsrNm());
		String aproUsrJbTitNm = JSPUtil.getNull(vo.getAproUsrJbTitNm());
		
		ComApCsrHisVO hisVo = new ComApCsrHisVO();
		ApprovalCsrVO approvalCsrVO = new ApprovalCsrVO();
		ComAproRqstRoutVO rout = new ComAproRqstRoutVO();
		
		ComCsrApprovalBC command = new ComCsrApprovalBCImpl();	
		ApprovalBC aproCommand = new ApprovalBCImpl();
		AGTAuditBC agtCommand = new AGTAuditBCImpl();
    	AGNCommApprovalBC acmCommand = new AGNCommApprovalBCImpl();
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		TCharterIOConsultationBC     fmsCommand = new TCharterIOConsultationBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
				
		try {
			String ofcCd = JSPUtil.getNull(command.searchOfcCd(csrNo));
			String subSysCd = JSPUtil.getNull(command.searchSubSysCd(csrNo));
			
			approvalCsrVO.setCsrNo(csrNo);
			approvalCsrVO.setInvSubSysCd(subSysCd);
			approvalCsrVO.setSubSysCd(subSysCd);
			approvalCsrVO.setUsrNm(JSPUtil.getNull(aproUsrNm));
			
			rout.setAproUsrNm(JSPUtil.getNull(aproUsrNm));
			rout.setAproUsrJbTitNm(JSPUtil.getNull(aproUsrJbTitNm));
			
			if ("FMS".equals(subSysCd)){
				fmsCommand.manageApproveFMS(usrId, csrNo, ofcCd);
			} else {
				//1) 결재 Update 수행 (Header & Route 정보)
				aproCommand.confirmApprovalGW(approvalCsrVO);
				log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC confirmApprovalGW DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>");	  
				
	    		//2) CSR 결재완료시, 각 모듈별 Update 수행 (TES/TRS/AGT/ACM/CSR)
				if("TRS".equals(subSysCd)) {
					trsCommand.approvalRequestAccount2("C", csrNo, rout);
				} else if("TES".equals(subSysCd)) {
					tesCommand.approvalRequestAccount2("C", csrNo, rout);
				} else if("AGT".equals(subSysCd)){
					agtCommand.transferAgentActualINFtoAP2("C", csrNo, rout);
				} else if("ACM".equals(subSysCd)){
					acmCommand.transferAgentActualINFtoAP2("C", csrNo, rout );
				}
				log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC approvalRequestAccount2 DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");	
    			//3) CSR 결재완료시, ERP Interface 수행
    			FNS0080003Document[] docReq = null;			
				
				if("AGT".equals(subSysCd)) {
					docReq = agtCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
				} else if("ACM".equals(subSysCd)) {
					docReq = acmCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
				} else if("TES".equals(subSysCd)) {
					docReq = tesCommand.approvalRequestAccount1("C", csrNo, rout);
				} else if("TRS".equals(subSysCd)) {
					docReq = trsCommand.approvalRequestAccount1("C", csrNo, rout);	
				} else if("MNR".equals(subSysCd) || "TLL".equals(subSysCd) || "LSE".equals(subSysCd) 
						|| "PSO".equals(subSysCd) || "CHS".equals(subSysCd) || "MGS".equals(subSysCd) || "CNI".equals(subSysCd)) {
					//AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
					docReq = csrCommand.approvalRequestAccount1("C", csrNo, ofcCd, rout);
				}
				log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC approvalRequestAccount1 DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");
				
				//invoice 정산내역을 ERP AP로 인터페이스한다.
//				transferInvToERP(docReq, approvalCsrVO); 
				new SendQueueBCImpl().transferInvToERP(docReq, null);
				/** BATCH SENDING **/
		    	hisVo.setCsrNo(csrNo);
		    	hisVo.setCsrAproTpCd("GW");
		    	hisVo.setAutoMnlFlg("Y");
		    	hisVo.setIoBndCd("I");
		    	hisVo.setApCsrIfStsCd("SD");
		    	hisVo.setCreUsrId(usrId!=null&&!usrId.trim().equals("")?usrId:"SYSTEM");
		    	hisVo.setUpdUsrId(usrId!=null&&!usrId.trim().equals("")?usrId:"SYSTEM");			    	
		    	command.saveGWInfo(hisVo);
				//BIZ스레드처리후 Exception 없다면 비동기(Biz) 커밋 :: Approval 결재 처리    	   	
				log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC transferInvToERP DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");
			}
			
			dbDao.updateErpInterface(csrNo);
		
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AP_INV_HDR table update"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AP_INV_HDR table update"}).getMessage(), ex);
		}
	}
}
