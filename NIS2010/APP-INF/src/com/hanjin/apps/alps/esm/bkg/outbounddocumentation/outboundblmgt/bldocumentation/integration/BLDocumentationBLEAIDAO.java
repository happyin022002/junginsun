/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLEAIDAO.java
*@FileTitle : BLDocumentationBLEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19 
* 1.0 Creation
===========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * NIS2010 BLDocumentationBLEAIDAO <br>
 * - NIS2010-BLDocumentationBLEAIDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see BLDocumentationBLBCImpl 참조
 * @since J2EE 1.6
 */
public class BLDocumentationBLEAIDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -1184130086564280801L;

	/**
	 * Customer EDI로 전송 BackEndJob 결과를 확인하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param String bkgNo
	 * @param String emailAdd
	 * @param CmSelfMailVO cmSelfMailVO
	 * @return String
	 * @throws Exception
	 */
	public String sendChkSelfCMByEmail(String bkgNo, String emailAdd, CmSelfMailVO cmSelfMailVO) throws Exception {
		
		String sendId = sendRDEmail(bkgNo, emailAdd, cmSelfMailVO);
		
		if (sendId.length() > 0) return sendId;
		else return "";
	}
	
	/**
	 * Mail : BKG001
	 * RDMail을 전송한다.
	 * 
	 * @param String bkgNo
	 * @param String emailAdd
	 * @param CmSelfMailVO cmSelfMailVO
	 * @return String
	 * @throws Exception
	 */
	private String sendRDEmail(String bkgNo, String emailAdd, CmSelfMailVO cmSelfMailVO) throws Exception {
		String sndId = "";
		TemplateMail template = null;
		try {
			
			template = new TemplateMail();
			template.setBatFlg("N");
			String fromAddr = "noreply@smlines.com";
			String fromName = "SM Line";
			template.setFrom(fromAddr,fromName);
			template.setRecipient(emailAdd);
			template.setSubject("House B/L filing request for automated NVOCC");
			template.setHtmlTemplate("ESM_BKG_0079_07T.html");
			template.setArg("blNo",cmSelfMailVO.getBlNo());
			template.setArg("tVvd",cmSelfMailVO.getVslCd()+cmSelfMailVO.getSkdVoyNo()+cmSelfMailVO.getSkdDirCd());
			template.setArg("porCd",cmSelfMailVO.getPorCd());
			template.setArg("polCd",cmSelfMailVO.getPolCd());
			template.setArg("podCd",cmSelfMailVO.getPodCd());
			template.setArg("delCd",cmSelfMailVO.getDelCd());
			sndId = template.send();
			log.debug("@@@@@@ BLDocumentationBLEAIDAO : sndId = "+sndId);
			
			
//			template = new TemplateMail();
//			template.setBatFlg("N");
//			template.setFrom("no@smlines.com","test@smlines.com");
//			template.setSubject("test");
//			template.setRecipient("yangdh88@cyberlogitec.com");
////			template.setCcRcvrEml(bkgCustAvcNtcMailSndVO.getCcRcvrEml());
//			template.setHtmlTemplate("ESM_BKG_0003T.html");
////			template.setHtmlTemplate("TESM_BKG_0079_07T.html");
//			String imgUrl = "http://www.smlines.com/hanjin/images/img/mail/report_customer_advisory.jpg";
//			template.setArg("img", imgUrl);
//			template.setArg("subject","test");
//			template.setArg("date","2015514");
//			// 고객명을 html 형식으로 변환
//			template.setArg("custNm","customer name".replaceAll("\n", "<br>"));
//			template.setArg("blNo","SEL54545454");
//			
//			String cntrNo = "DFSU6814610";
//			cntrNo = cntrNo.replaceAll("\n", "<br>");
//			cntrNo = cntrNo.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
//			cntrNo = cntrNo.replaceAll("\\p{Space}", "&nbsp;");
//			
//			template.setArg("cntrNo",cntrNo);
//			
//			// 본문 내용을 html 형식으로 변환
//			String rmk = "Please note that MV Hanjin Green Earth 0010W resumed her voyage from Algeciras to next  calling port Hamburg, Germany at 08:30 21st May 2015(LT), after the class approval.";
//			rmk = rmk.replaceAll("\n", "<br>");
//			rmk = rmk.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
//			rmk = rmk.replaceAll("\\p{Space}", "&nbsp;");
//			template.setArg("rmk",rmk);
			
			// Attach File
//			fileList = new ArrayList<SingleMailAttachedFile>();
//			if( bkgCustAvcNtcMailSndVO.getFileKey() != null ){
//				String[] fileKeys = bkgCustAvcNtcMailSndVO.getFileKey().split(";");
//				for( String fileKey:fileKeys ){
//					SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
//					attachedFile.setFileKey(fileKey);
//					fileList.add(attachedFile); 
//				}
//			}
//			template.setAttachedFile(fileList);

			
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new EAIException(ex.getMessage(), ex);
		}
		return sndId;
	}	
}
