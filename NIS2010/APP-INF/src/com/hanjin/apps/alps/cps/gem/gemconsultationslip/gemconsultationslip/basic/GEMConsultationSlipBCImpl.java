/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipBCImpl.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration.GEMConsultationSlipDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration.GEMConsultationSlipEAIDAO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemConsultationVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrRequestBodyVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrRequestHeaderVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsrHisVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;


/**
 * ALPS-GEMConsultationSlip Business Logic Command Interface<br>
 * - ALPS-GEMConsultationSlip에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GEM
 * @see GEMConsultationSlipBC 참조
 * @since J2EE 1.6
 */
public class GEMConsultationSlipBCImpl extends BasicCommandSupport implements GEMConsultationSlipBC {

	// Database Access Object
	private transient GEMConsultationSlipDBDAO dbDao = null;

	/**
	 * GEMConsultationSlipBCImpl 객체 생성<br>
	 * GEMConsultationSlipDBDAO를 생성한다.<br>
	 */
	public GEMConsultationSlipBCImpl() {
		dbDao = new GEMConsultationSlipDBDAO();

	}
	/**
	 * 0033 화면의 저장 로직.<br>
	 * 
	 * @param GemSubsCsulHdrVO gemSubsCsulHdrVO
	 * @param GemSubsCsulDtlVO[] gemSubsCsulDtlVOs
	 * @param SignOnUserAccount account
	 * @return GemSubsCsulHdrVO
	 * @exception EventException
	 */
	public GemSubsCsulHdrVO  manageConsultaion(GemSubsCsulHdrVO gemSubsCsulHdrVO, GemSubsCsulDtlVO[] gemSubsCsulDtlVOs, SignOnUserAccount account) throws EventException{
		
		GemRequestVO gemRequest = null;
		
		String gemCsrNo = gemSubsCsulHdrVO.getSubsCsrNo();
		String plnYrmon = null;
		int hdrCount = 0;
		int dtlCount = 0;
		plnYrmon = gemSubsCsulHdrVO.getInpDt().replace("-", "");
		try {
			   gemRequest = new GemRequestVO();
			if (gemSubsCsulHdrVO.getInpDt() != null) {
				plnYrmon = plnYrmon.substring(0,6) ;
				gemRequest.setPlnYrmon(plnYrmon);
				gemRequest.setGenExpnRqstTpCd("CR");
				gemRequest.setRqstOfcCd(gemSubsCsulHdrVO.getSubsOfcCd());
				gemRequest.setCreUsrId(account.getUsr_id());
				gemRequest.setUpdUsrId(account.getUsr_id());
				
			    //CSR_NO을 가져온다. 
				if (gemCsrNo == null || gemCsrNo.trim().length() == 0) {			
					gemCsrNo = getNewGemCSRNo(gemRequest.getGenExpnRqstTpCd(),gemSubsCsulHdrVO.getSubsOfcCd());
					gemRequest.setGenExpnRqstNo(gemCsrNo);
					gemSubsCsulHdrVO.setSubsCsrNo(gemCsrNo);
					//if(gemCsrNo.substring(16).equals("001")){		
						dbDao.addCSRRequest(gemRequest);
					//} else  {
					//	dbDao.modifyCSRRequest(gemRequest);
					//}
				}
			    //저장된 csr_no가 있는지 체크를 한다. 
				gemSubsCsulHdrVO.setCreUsrId(account.getUsr_id());
				gemSubsCsulHdrVO.setUpdUsrId(account.getUsr_id());
				gemSubsCsulHdrVO.setAproRsltCd("X");
				
			hdrCount = 	dbDao.searchSubsCsulHdrCount(gemCsrNo);
			//저장된  값이 있으면 update를 한다.
			if (hdrCount > 0){
				dbDao.modifySubsCsulHdrVO(gemSubsCsulHdrVO);
			//insert을 한다. 
			}else {
				dbDao.addSubsCsulHdr(gemSubsCsulHdrVO);	
			}
			
			if (gemSubsCsulDtlVOs != null) {
				List<GemSubsCsulDtlVO> insertVoList = new ArrayList<GemSubsCsulDtlVO>();
				int k = 0;
				for(int i=0; i < gemSubsCsulDtlVOs.length; i++) {
					
					gemSubsCsulDtlVOs[i].setSubsCsrNo(gemCsrNo);
					gemSubsCsulDtlVOs[i].setSubsOfcCd(gemSubsCsulHdrVO.getSubsOfcCd());
					gemSubsCsulDtlVOs[i].setSubsCsrSeq(Integer.toString(k+1));
					gemSubsCsulDtlVOs[i].setCreUsrId(account.getUsr_id());
					gemSubsCsulDtlVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(gemSubsCsulDtlVOs[i]);
					k++;
				}	
				// 기존에 csr_no가 존재하는지를 확인을 합니다.
				dtlCount  = dbDao.searchSubsCsulDtlCount(gemCsrNo);
				if(dtlCount > 0){
				// 기존 csr_no 가 존재를 하면 삭제를 한다. 
					dbDao.removeSubsCsulDtl(gemCsrNo);
			    // 삭제후 다시 전체를 입력을 한다. 
					dbDao.addSubsCsulDtl(insertVoList);
				}else {
					dbDao.addSubsCsulDtl(insertVoList);
				}
					
			 }
		 }	

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return gemSubsCsulHdrVO;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *office 별 Currency Code 조회<br>
	 * 
	 * @param  SerachConsultaionVO serachConsultaionVO
	 * @return List<SerachConsultaionVO>
	 * @exception EventException
	 */
	public List<SerachConsultaionVO> searchCurrencyCode(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchCurrencyCode(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *office 별 expense  Code 조회<br>
	 * 
	 * @param  SerachConsultaionVO serachConsultaionVO
	 * @return List<SerachConsultaionVO>
	 * @exception EventException
	 */
	public List<SerachConsultaionVO> searchExpenseCodeOffice(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchExpenseCodeOffice(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

	/**
	 * 신규 CSR No 생성
	 * REQUEST TYPE CODE +  REQUTEST DATE + REQUEST OFFICE CODE +  REQUEST SEQUENCE
	 * max 요청번호+1 취득
	 * @param String genExpnRqstTpCd
	 * @param String rqstOfcCd
	 * @return String( max 요청번호 + 1)
	 * @throws DAOException 
	 */
	private String getNewGemCSRNo(String genExpnRqstTpCd , String rqstOfcCd) throws DAOException {
		//GEM +  REQUTEST DATE + REQUEST OFFICE CODE  +  REQUEST SEQUENCE
		//GEM20160422SINRSC
		
		String rqstDate = dbDao.searchLocalDate(rqstOfcCd);
		String genExpnRqstNo = rqstDate ;
		genExpnRqstNo =  rqstOfcCd + genExpnRqstNo;
		
		//MaxRequst No
		String maxRqstNo = dbDao.searchMaxRqstNo(genExpnRqstTpCd , rqstOfcCd);
		
		if (maxRqstNo == null || maxRqstNo.equals("")) {
			maxRqstNo = "001";
		} else {
			int beginIndex = maxRqstNo.length() - 3;
			maxRqstNo = maxRqstNo.substring(beginIndex);
			int maxNo = new Integer(maxRqstNo).intValue();
			maxNo = maxNo + 1;			
			DecimalFormat formatter = new DecimalFormat("000");
        	maxRqstNo = formatter.format(maxNo);
			
		}

		return genExpnRqstNo + maxRqstNo;
	}
	
	/**
	 * <br>
	 * Dtl 테이블의 정보를 조회를 해온다.<br>
	 * 
	 * @param  GemSubsCsulHdrVO gemSubsCsulHdrVO
	 * @return List<GemSubsCsulDtlVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulDtlVO> searchConsultaionDetail(GemSubsCsulHdrVO gemSubsCsulHdrVO) throws EventException {
		
		try {
			return dbDao.searchConsultaionDetail(gemSubsCsulHdrVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}	
	
    /**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @param csrNo
	 * @param invSubSysCd
	 * @param account
	 * @return String 
	 * @throws EventException
	 */
	public String sendGwApprovalRequestInfo(String csrNo, String invSubSysCd, SignOnUserAccount account) throws EventException {		
		
		
		try {			
			GemCsrInfoVO gwVo = new GemCsrInfoVO();
			GemSubsCsrHisVO hisVo = new GemSubsCsrHisVO();
			
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
			
			String requestId = "COM010-" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date()) + "-ALPSGEM-" + csrNo;
			
			gwVo.setUserId(gwUserId);		
			gwVo.setSysDocId("ALPS_GEM_EP_1");
			gwVo.setRequestId(requestId);
			gwVo.setUserTp("GR");
			gwVo.setSysTp("ALPSGEM");
			gwVo.setCsrNo(csrNo);
			
			// -------------------------------------
			// GW 연동 정보를  history 테이블에 저장한다.
			// -------------------------------------
	    	hisVo.setSubsCsrNo(csrNo);
	    	hisVo.setAutoMnlFlg("Y");
	    	hisVo.setIoBndCd("O");
	    	hisVo.setGwCsrRqstId(requestId);
	    	hisVo.setCreUsrId(usrId);
	    	hisVo.setUpdUsrId(usrId);
	    	
	    	dbDao.saveGWhisInfo(hisVo);
	    	log.error("\n 1. DONE - GEMConsultationSlipBCImpl.sendGwApprovalRequestInfo : saveGWInfo (csr_no:"+(csrNo)+")\n");
			
			// -------------------------------------
			//  csrNo을 가지고 모듈별로 정보를 조회한다.
			// -------------------------------------
			GemCsrRequestHeaderVO headerVo = null;
			List<GemCsrRequestBodyVO> bodyVos = null;
//			List<GemCsrRequestAgmtVO> agmtVos = null;
//			List<GemCsrRequestFileVO> fileVos = null;
//			List<GemCsrRequestFileVO> fileVos2 = null;

			 headerVo = printGemCsrHeaderInfo(csrNo);
			 bodyVos  = printGemCsrBodyInfo(csrNo);
			//agmtVos = gemCommand.printComCsrAgmtInfo(csrNo);
     		//	fileVos2 = dbDao.printComCsrFileInfo(csrNo);
			
			if (headerVo == null) {
				return null;
			}			
			
			//SUBJECT : "Payment" + INTG_CD_VAL_DP_DESC + ":" +  CSR_NO + "_" + Pay To(50자까지) 
			String payTo = JSPUtil.getNull(headerVo.getPayTo());
			if(payTo.length() > 50) 
				payTo = payTo.substring(0, 50);
			
	    	String subject =  "Payment " + invSubSysCd + ":" + csrNo + "_" + payTo;
					
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
		    pw.println("<INV_LCL_AMT><![CDATA[" + headerVo.getInvLclAmt() + "]]></INV_LCL_AMT>");        // INV Amount 항목에 LCL 항목에 매핑 
		    pw.println("<INV_USD_AMT><![CDATA[" + headerVo.getInvUsdAmt() + "]]></INV_USD_AMT>");        // INV Amount 항목에 USD 항목에 매핑
		    pw.println("<EXPN_TYPE><![CDATA[" + headerVo.getExpnType() + "]]></EXPN_TYPE>");           // Expense Type 항목에 매핑 
		    pw.println("</HEADER>");		    
		    pw.println("<BODY>");
		   
	    	for(int i=0;i<bodyVos.size();i++) {
	    		GemCsrRequestBodyVO bodyVo = bodyVos.get(i);
	    		pw.println("<ROW>");
	    		pw.println("<L_EXPN_NAME><![CDATA["+ bodyVo.getGenExpnNm() +"]]></L_EXPN_NAME>");	
	    		pw.println("<L_INV_LCL_AMT><![CDATA[" + bodyVo.getInvLoclAmt() + "]]></L_INV_LCL_AMT>");				
	    		pw.println("<L_INV_USD_AMT><![CDATA[" + bodyVo.getInvUsdAmt() + "]]></L_INV_USD_AMT>");				
	    		pw.println("<L_DESCRIPTION><![CDATA[" + bodyVo.getInvSlpDesc() + "]]></L_DESCRIPTION>");					
	       		pw.println("</ROW>");
	    	}

		    pw.println("</BODY>");
		    pw.println("<FOOTER>");					
		    pw.println("<LCL_AMT><![CDATA[" + headerVo.getInvLclAmt() + "]]></LCL_AMT>");					
		    pw.println("<USD_AMT><![CDATA[" + headerVo.getInvUsdAmt() + "]]></USD_AMT>");					
		    pw.println("</FOOTER>");					
		  
//		    if(agmtVos != null && agmtVos.size() > 0) {	    		    
//		    	pw.println("<AGMT_ATTACH>");	
//			    for(int i=0;i<agmtVos.size();i++) {
//		    		GemCsrRequestAgmtVO agmtVo = agmtVos.get(i);	    		
//		    		pw.println("<ROW>");					
//		    		pw.println("<L_ASSETCD><![CDATA[" + agmtVo.getLAssetcd() + "]]></L_ASSETCD>");					
//		    		pw.println("<L_DOCUMENT_TITLE><![CDATA[" + agmtVo.getLDocumentTitle() + "]]></L_DOCUMENT_TITLE>");					
//		    		pw.println("</ROW>");
//			    }
//			    pw.println("</AGMT_ATTACH>");		    			   
//		    }
		   
//		    if((fileVos != null && fileVos.size() > 0) || (fileVos2 != null && fileVos2.size() > 0)) {		    			    
//		    	pw.println("<FILE_ATTACH>");		    	
//		    	if(fileVos != null && fileVos.size() > 0) {
//			    	for(int i=0;i<fileVos.size();i++) {
//			    		GemCsrRequestFileVO fileVo = fileVos.get(i);
//			    		pw.println("<ROW>");		
//			    		pw.println("<L_FILE_MODULE_ID><![CDATA[" + fileVo.getLFileModuleId() + "]]></L_FILE_MODULE_ID>");					
//			    		pw.println("<L_FILE_SAV_ID><![CDATA[" + fileVo.getLFileSavId() + "]]></L_FILE_SAV_ID>");					
//			    		pw.println("<L_FILE_NM><![CDATA[" + fileVo.getLFileNm() + "]]></L_FILE_NM>");	
//			    		pw.println("<L_FILE_SZ><![CDATA[" + JSPUtil.getNull(aproUtil.searchFileSize(fileVo.getLFileSavId())) + "]]></L_FILE_SZ>");	
//			    		pw.println("</ROW>");
//				    }	
//		    	}
//		    	if(fileVos2 != null && fileVos2.size() > 0) {
//				    for(int i=0;i<fileVos2.size();i++) {
//			    		GemCsrRequestFileVO fileVo2 = fileVos2.get(i);
//			    		pw.println("<ROW>");		
//			    		pw.println("<L_FILE_MODULE_ID><![CDATA[" + fileVo2.getLFileModuleId() + "]]></L_FILE_MODULE_ID>");					
//			    		pw.println("<L_FILE_SAV_ID><![CDATA[" + fileVo2.getLFileSavId() + "]]></L_FILE_SAV_ID>");					
//			    		pw.println("<L_FILE_NM><![CDATA[" + fileVo2.getLFileNm() + "]]></L_FILE_NM>");	
//			    		pw.println("<L_FILE_SZ><![CDATA[" + JSPUtil.getNull(aproUtil.searchFileSize(fileVo2.getLFileSavId())) + "]]></L_FILE_SZ>");	
//			    		pw.println("</ROW>");
//				    }		
//		    	}
//			    pw.println("</FILE_ATTACH>");				    			    
//		    }

		    pw.println("</ROOT>");			
		    
		    gwVo.setXmlData(sw.toString());
		    
		    GEMConsultationSlipEAIDAO eaiDao = new GEMConsultationSlipEAIDAO();		
		    String gwUrl = eaiDao.sendGWData(gwVo);
		    
		    if(gwUrl != null) {
		    	//G/W URL과 request_id 업데이트
		    	updateGemAproGwUrl(csrNo, requestId, gwUrl);
		    
		    	// -------------------------------------
				// G/W 연동 정보를  history 테이블에 저장한다.
				// -------------------------------------
		    	hisVo.setSubsCsrNo(csrNo);
		   // 	hisVo.setCsrAproTpCd("GW");
		    	hisVo.setAutoMnlFlg("Y");
		    	hisVo.setIoBndCd("I");
		    	hisVo.setGwCsrRqstId(requestId);
		    	hisVo.setGwAproUrlCtnt(gwUrl);
		    	hisVo.setCreUsrId(usrId);
		    	hisVo.setUpdUsrId(usrId);
		    	
		    	dbDao.saveGWhisInfo(hisVo);
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
	 * CSR Header Info
	 * @param String csrNo
	 * @return GemCsrRequestHeaderVO
	 */
	public GemCsrRequestHeaderVO printGemCsrHeaderInfo(String csrNo) throws EventException {
		try {
			return dbDao.printGemCsrHeaderInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	
	/**
	 * CSR Body Info List
	 * @param String csrNo
	 * @return List<GemCsrRequestBodyVO>
	 */
	public List<GemCsrRequestBodyVO> printGemCsrBodyInfo(String csrNo) throws EventException {
		try {
			return dbDao.printGemCsrBodyInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	

	/**
	 * GW에서 결과 값 전송<br>
	 * GEM_SUBS_CSUL_HDR 의  GW Url, Request_id 업데이트
	 * 
	 * @param String csr_no
	 * @param String request_id
	 * @param String gw_url
	 * @throws DAOException
	 */
	public void updateGemAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException {
		
		try {
			dbDao.updateGemAproGwUrl(csr_no, request_id, gw_url);
		} catch (DAOException de) {
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
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
	 * G/W 정보를 저장을 한다. . <br>
	 *
	 * @param GemSubsCsrHisVO gemSubsCsrHisVO
	 * @throws EventException
	 */
	public void saveGWhisInfo(GemSubsCsrHisVO gemSubsCsrHisVO) throws EventException {
		try {
			dbDao.saveGWhisInfo(gemSubsCsrHisVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"GW histroy Error"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"GW histroy Error"}).getMessage(), ex);
		}
	}

	/**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다. <br>
	 * GEM_SUBS_CSUL_HDR에서 현재 APPROVAL STEP을 확인을 한다.
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
	public String searchGemRqstAproStepFlg(String csrNo) throws EventException {
		try {
			return dbDao.searchGemRqstAproStepFlg(csrNo);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RQST_APRO_STEP_FLG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RQST_APRO_STEP_FLG"}).getMessage(), ex);
		}
	}

	/**
	 * GW에서 결과 값 전송 <br>
	 *  GEM_SUBS_CSUL_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param GemCsrInfoVO gemCsrInfoVO
	 * @throws DAOException
	 */
	public void updateGemAproGwDt(GemCsrInfoVO gemCsrInfoVO) throws EventException {
		try {
			dbDao.updateGemAproGwDt(gemCsrInfoVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"updateGemAproGwDt"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"updateGemAproGwDt"}).getMessage(), ex);
		}
	}
	/**
	 * <br>
	 * 0034 화면의 조건에 맞추어서 조회를 한다. .<br>
	 * 
	 * @param  SerachConsultaionVO serachConsultaionVO
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public List<GemConsultationVO> searchConsultaionInquiry(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchConsultaionInquiry(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 0036 화면의 조건에 맞추어서 조회를 한다. .<br>
	 * 
	 * @param  SerachConsultaionVO serachConsultaionVO
	 * @return List<GemSubsCsulHdrVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulHdrVO> searchCsrNoInquiry(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchCsrNoInquiry(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * HDR 테이블의 정보를 조회를 해온다.<br>
	 * 
	 * @param  GemSubsCsulHdrVO gemSubsCsulHdrVO
	 * @return List<GemSubsCsulDtlVO>
	 * @exception EventException
	 */
	public List<GemSubsCsulHdrVO> searchConsultaionHdr(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchConsultaionHdr(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 0035 화면의 조건에 맞추어서 조회를 한다. .<br>
	 * 
	 * @param  SerachConsultaionVO serachConsultaionVO
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public List<GemConsultationVO> searchConsultaionInquiryDetail(SerachConsultaionVO serachConsultaionVO) throws EventException {
		
		try {
			return dbDao.searchConsultaionInquiryDetail(serachConsultaionVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 0033 화면에서 Delt_Flg = 'Y'로 변경을 한다. <br>
	 * 
	 * @param  String csrNo
	 * @param  SignOnUserAccount account
	 * @return List<GemConsultationVO>
	 * @exception EventException
	 */
	public int consultaionCancel(String csrNo, SignOnUserAccount account) throws EventException {
		
		try {
			return dbDao.consultaionCancel(csrNo , account.getUsr_id());
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("COM10001", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

}