/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ArApprovalBCImpl.java
 *@FileTitle : Common CSR Business Logic Command implementation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.08
 *@LastModifier : Jung Ho Min
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
 * -------------------------------------------------------
 */
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.csrapproval.integration.ComCsrApprovalDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration.ArApprovalEAIDAO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration.ArApprovalDBDAO;

/**
 * Common CSR Business Logic Basic Command implementation<br> - Common CSR에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jung Ho Min
 * @see 
 * @since J2EE 1.4
 */

public class ArApprovalBCImpl extends BasicCommandSupport implements ArApprovalBC {
	
	// Database Access Object
	private transient ComCsrApprovalDBDAO dbDao = null;
	private transient ArApprovalDBDAO arDbDao = null;	

	public ArApprovalBCImpl() {
		dbDao = new ComCsrApprovalDBDAO();
		arDbDao = new ArApprovalDBDAO();		
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
		
		TCharterIOConsultationBC fmsCommand = new TCharterIOConsultationBCImpl();
		
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
			
			String requestId = "";
			if("07".equals(csrNo.substring(0,2))){
				// AP
				requestId = "COM006-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSCSR-" + csrNo;				
			}else{
				// AR
				requestId = "COM008-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSCSR-" + csrNo;				
			}
			
			gwVo.setUserId(gwUserId);		
			gwVo.setSysDocId("ALPS_FMSAR_EP_1");
			gwVo.setRequestId(requestId);
			gwVo.setUserTp("GR");
			gwVo.setSysTp("FMSAR");
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
	    	
	    	arDbDao.saveGWInfo(hisVo);
	    	
	    	log.error("\n 1. DONE - ComCsrApprovalBCImpl.sendGwApprovalRequestInfo : saveGWInfo (csr_no:"+(csrNo)+")\n");
			
			// -------------------------------------
			//  csrNo을 가지고 모듈별로 정보를 조회한다.
			// -------------------------------------
			ComCsrRequestHeaderVO headerVo = null;
			List<ComCsrRequestBodyVO> bodyVos = null;
			List<ComCsrRequestAgmtVO> agmtVos = null;

			if("FMS".equals(invSubSysCd)) {
				headerVo = this.printArCsrHeaderInfo(csrNo);
				bodyVos = this.printArCsrBodyInfo(csrNo);
				agmtVos = this.printFmsCsrAgmtInfo(csrNo); 
			}
			
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
		    pw.println("<LOGIN_OFFICE><![CDATA[" + account.getOfc_cd() + "]]></LOGIN_OFFICE>"); // 원 기안자  결재 부서 정보(변경 부서가 아님)								
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
		  
		    if(agmtVos != null) {	    		    
			    if(agmtVos.size() > 0) {
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
			   
		    }
		   
		    pw.println("</ROOT>");			
		    
		    gwVo.setXmlData(sw.toString());
		    
		    ArApprovalEAIDAO eaiDao = new ArApprovalEAIDAO();				
		    String gwUrl = eaiDao.sendGWData(gwVo);
		    
		    if(gwUrl != null) {
		    	//G/W URL과 request_id 업데이트
		    	fmsCommand.updateAproGwUrl(csrNo, requestId, gwUrl);
		    
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
		    	
		    	arDbDao.saveGWInfo(hisVo);
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
			return arDbDao.searchOfcCd(csrNo);
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
			arDbDao.saveGWInfo(comApCsrHisVO);
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
			return arDbDao.searchRqstAproStepFlg(csrNo);
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
	 * AR CSR Header Info
	 * @param csrNo
	 * @return ComCsrRequestHeaderVO
	 */
	private ComCsrRequestHeaderVO printArCsrHeaderInfo(String csrNo) throws EventException {
		try {
			return arDbDao.printArCsrHeaderInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * AR CSR Body Info List
	 * @param csrNo
	 * @return List<ComCsrRequestBodyVO>
	 */
	private List<ComCsrRequestBodyVO> printArCsrBodyInfo(String csrNo) throws EventException {
		try {
			return arDbDao.printArCsrBodyInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CSR Agreement Info List<br>
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 * @exception EventException
	 */
	private List<ComCsrRequestAgmtVO> printFmsCsrAgmtInfo(String csrNo) throws EventException {
		try {
			return arDbDao.printFmsCsrAgmtInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * GW에서 결과 값 전송 <br>
	 * AP_INV_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param comCsrInfoVO
	 * @exception EventException
	 */
	public void updateAproGwDt(ComCsrInfoVO comCsrInfoVO) throws EventException {
		try {
			arDbDao.updateAproGwDt(comCsrInfoVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AR_INV_HDR update"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AR_INV_HDR update"}).getMessage(), ex);
		}		
	}	
	
	/**
	 * AR_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	 * 
	 * @param csr_no
	 * @param ofc_cd
	 * @exception EventException
	 */
	public void updateAproGwFlg(String csr_no, String ofc_cd) throws EventException {
				
		TCharterIOConsultationBC fmsCommand = new TCharterIOConsultationBCImpl();
		
		try {
			String csr_apro_tp_cd = "GW"; 			//결재 구분 코드(AL,GW)
			String jb_tit_cd ="";						//최종 결재자 구분 코드
			String ver_no = "1";						//버전 관리
			String csr_usd_amt = "";				//환율 변경 금액(기준 테이블 참조)
			String acct_xch_rt_yrmon = "";		//GL_DT
			
			/*
			 * ALPS의 Agreement 문서 존재여부 : 문서가 존재하면 Y, 아니면 N
			 * ACM, JOO는 모듈에서 직접 전송 하기로 함
			 */
			String invSubSysCd = searchSubSysCd(csr_no);
			String agmtDocCfmCd = "";
			
			List<ComCsrRequestAgmtVO> agmtVos = null;
			
			if("FMS".equals(invSubSysCd)){
				agmtVos = fmsCommand.printFmsCsrAgmtInfo(csr_no);
			}
			
			if(agmtVos != null && agmtVos.size() > 0) {
				agmtDocCfmCd = "Y";
			} else {
				agmtDocCfmCd = "N";
			}
			
			IfCsrListInputVO ifCsrListInputVO = new IfCsrListInputVO();
			ifCsrListInputVO.setCsrAproTpCd(csr_apro_tp_cd);
			ifCsrListInputVO.setAproUsrJbTitCd(jb_tit_cd);
			ifCsrListInputVO.setVerNo(ver_no);
			ifCsrListInputVO.setCsrUsdAmt(csr_usd_amt);
			ifCsrListInputVO.setAcctXchRtYrmon(acct_xch_rt_yrmon);
			ifCsrListInputVO.setOfcCd(ofc_cd);
			ifCsrListInputVO.setCsrNo(csr_no);
			ifCsrListInputVO.setAgmtDocCfmCd(agmtDocCfmCd);
			
			arDbDao.updateAproGwFlg(ifCsrListInputVO);
						
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AR_INV_HDR update"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AR_INV_HDR update"}).getMessage(), ex);
		}	
	}		
}
