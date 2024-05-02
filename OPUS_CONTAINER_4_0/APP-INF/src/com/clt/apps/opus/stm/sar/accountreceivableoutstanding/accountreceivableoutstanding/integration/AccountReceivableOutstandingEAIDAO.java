/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableOutstandingDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;

/**
 * AccountReceivableOutstandingDBDAO <br>
 * - AccountReceivableOutstanding system Business Logic<br>
 * 
 * @author 
 * @see AccountReceivableOutstandingBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableOutstandingEAIDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * AccountReceivableOutstandingDBDAO object creation<br>
	 * AccountReceivableOutstandingDBDAO creation<br>
	 */
	public AccountReceivableOutstandingEAIDAO() { }
	
	
	/**
	 * AccountReceivableOutstandingDBDAO object creation<br>
	 * AccountReceivableOutstandingDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableOutstandingEAIDAO(String dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * e-mail, FAX를 전송한다. <br>
	 * 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @return String
	 * @exception EventException
	 */	
    public String sendPaymentRequestLetterByFaxEmail(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) {
    	
    	Date dt = new Date();
    	SimpleDateFormat sf = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
    	
		String sndTp      = paymentRequestLetterByEmailFaxVO.getSendType();
		String rdName     = paymentRequestLetterByEmailFaxVO.getRdName();
		String rdSubSysCd = "SAR";
		//String loclTm     = paymentRequestLetterByEmailFaxVO.getLclTime();
		String subject = "";
		String contents = "";
		subject = paymentRequestLetterByEmailFaxVO.getCustNm() + "  / "+sf.format(dt) + " / NYK Statement";
		
		if(paymentRequestLetterByEmailFaxVO.getEmtCtnt().equals("") || paymentRequestLetterByEmailFaxVO.getEmtCtnt() == null){
			contents = "Please find the attached payment request letter."		 		
	                  + "<br />you have any question, please email us at above address." 
	                  + "<br />"
			          + "<br />Thank you.";
		} else {
			contents = paymentRequestLetterByEmailFaxVO.getEmtCtnt();
			contents = contents.replaceAll("(\r\n|\n)", "<br />"); 
		}    
		
		String rdParam  = "/rp ["+paymentRequestLetterByEmailFaxVO.getEmlSeq()+"]"
		                + "["+paymentRequestLetterByEmailFaxVO.getArOfcCd()+"]"
   		                + "["+paymentRequestLetterByEmailFaxVO.getCustCode()+"]"
		                + "["+paymentRequestLetterByEmailFaxVO.getFax()+"]"
		                + "["+paymentRequestLetterByEmailFaxVO.getEmail()+"]"
		                + "[]"
		                + "[]"
		                + "["+paymentRequestLetterByEmailFaxVO.getCnsdCustFlg()+"]";
		log.info("rdParam <<<<<<<<<<<<<<<<<<<<<<<<<<" + rdParam);
		String filename = "NYK Statement_en_" + sf.format(dt);
		String pdf_file_nm  = filename+".pdf";
		String xls_file_nm  = filename+".xls";
		
		if (sndTp.equals("EMAIL")) {
			// Email 발송				
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			if(paymentRequestLetterByEmailFaxVO.getQeqFmt().equals("ALL")){
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();		
	    		comRptDsgnXptInfoVO.setXptFileNm(pdf_file_nm);
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setRdTmpltNm(rdName);
				comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVO.setCreUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVO.setUpdUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO2 = new ComRptDsgnXptInfoVO();		
	    		comRptDsgnXptInfoVO2.setXptFileNm(xls_file_nm);
				comRptDsgnXptInfoVO2.setXptFileTpCd(ExportInfo.FTYPE_XLS);
				comRptDsgnXptInfoVO2.setRdTmpltNm(rdName);
				comRptDsgnXptInfoVO2.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVO2.setCreUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVO2.setUpdUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO2);
			} else if(paymentRequestLetterByEmailFaxVO.getQeqFmt().equals("PDF")){
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();		
	    		comRptDsgnXptInfoVO.setXptFileNm(pdf_file_nm);
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setRdTmpltNm(rdName);
				comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVO.setCreUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVO.setUpdUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			} else if(paymentRequestLetterByEmailFaxVO.getQeqFmt().equals("EXL")){
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();		
	    		comRptDsgnXptInfoVO.setXptFileNm(xls_file_nm);
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_XLS);
				comRptDsgnXptInfoVO.setRdTmpltNm(rdName);
				comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVO.setCreUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVO.setUpdUsrId(paymentRequestLetterByEmailFaxVO.getSenderUserId());
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			}
			
			try {
				Mail mail = new Mail();
				mail.setFrom(paymentRequestLetterByEmailFaxVO.getSenderEml(),paymentRequestLetterByEmailFaxVO.getSenderUserNm());
				log.info("receive <<<<<<<<<<<<<<<<<<<<<<<<<<" + paymentRequestLetterByEmailFaxVO.getEmail());
				mail.setRecipient(paymentRequestLetterByEmailFaxVO.getEmail());
				mail.setBccRcvrEml(paymentRequestLetterByEmailFaxVO.getRefEml());
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				mail.setRdSubSysCd(rdSubSysCd);
				if(comRptDsgnXptInfoVOs.size() > 0){
					mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				}
				
				return mail.send();
				
			} catch (MailerAppException e) { 
				log.error(e.getMessage());
				//throw new EventException(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
				//throw new EventException(e.getMessage()); 
			}
		} else {
		// Fax 발송	
			try {
			    FaxMetaInfo info = new FaxMetaInfo(rdSubSysCd,       // 모듈명(ex.BKG)
						                   rdName,             // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           "N",                 // 배치 유무(Y/N)
								           "Payment Request Letter(PRL#: " + paymentRequestLetterByEmailFaxVO.getEmlSeq() + ")",             // 제목
								           rdParam,             // RD Parameter (ex. [419][1][selho])
								           paymentRequestLetterByEmailFaxVO.getCustName()+";"+paymentRequestLetterByEmailFaxVO.getFax().replaceAll("-", ""), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           paymentRequestLetterByEmailFaxVO.getSenderOfcCd(), // 지역 FAX office
								           paymentRequestLetterByEmailFaxVO.getSenderUserId()  // 보내는 사람
									       ); 
						
				return FaxUtility.registerDB(info);

			} catch (Exception e) {  
				log.error(e.getMessage());
				//throw new EventException(e.getMessage());
			}	
			
		}  
		return "";
	}
}
