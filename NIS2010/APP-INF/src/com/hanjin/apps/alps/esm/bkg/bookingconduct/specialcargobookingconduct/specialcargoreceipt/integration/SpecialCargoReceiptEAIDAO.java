/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName       : SpecialCargoReceiptEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012.05.16
*@LastModifier   : 김종호
*@LastVersion    : 1.0
* 2012.05.16 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

//import java.util.ArrayList;
//import java.util.List;

//import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

//import org.apache.commons.lang.StringUtils;

//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.SpecialCargoBookingConduct.blissuance.basic.SpecialCargoReceiptBCImpl;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.SpecialCargoBookingConduct.blissuance.vo.SpecialCargoRjEmlVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.SpecialCargoBookingConduct.blissuance.vo.BkgEmlEdtVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.SpecialCargoBookingConduct.blissuance.vo.FaxSendVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.SpecialCargoBookingConduct.blissuance.vo.MailSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpecialCargoRjEmlVO;
//import com.hanjin.framework.component.fax.FaxMetaInfo;
//import com.hanjin.framework.component.fax.FaxUtility;
//import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
//import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
//import com.hanjin.framework.component.util.io.FileUtils;
//import com.hanjin.framework.core.config.SiteConfigFactory;
//import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
//import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
/**
 * ALPS SpecialCargoReceiptEAIDAO <br>
 * - ALPS-SpecialCargoBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong-ho
 * @see SpecialCargoReceiptBCImpl 참조
 * @since J2EE 1.4
 */
public class SpecialCargoReceiptEAIDAO extends EAIDAOSupport {

    //private transient Logger log = Logger.getLogger(SpecialCargoReceiptEAIDAO.class.getName());
    
	
	/**
	 * Template 메일을 전송한다.
	 * 
	 * @param SpecialCargoRjEmlVO spcgoRjEmlVO
	 * @return String
	 * @throws Exception
	 */	
    public String sendRjEmail(SpecialCargoRjEmlVO spcgoRjEmlVO) throws Exception {
		String sndId = "";
		TemplateMail template = null;
		log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : sendSpRejectMail start : bkgNo = "+spcgoRjEmlVO.getBkgNo());
		try{
			String fromAddr = "noreply@smlines.com";
			String fromName = "SM Line";
			
			
			if (null!=spcgoRjEmlVO.getBkgNo() && !"".equals(spcgoRjEmlVO.getBkgNo())) {
				
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(fromAddr,fromName);
				String mailSubject = "Special Cargo Request Rejected (BKG No: "+spcgoRjEmlVO.getBkgNo()+")";
				template.setSubject(mailSubject);
				template.setRecipient(spcgoRjEmlVO.getUsrEml()); // 1) BKG main의 BKG staff
				// bkg staff과 request staff이 동일인일 경우 한번만 전송
				if(!spcgoRjEmlVO.getUsrEml().equals(spcgoRjEmlVO.getRqstUsrEml())) {
					template.setRecipient(spcgoRjEmlVO.getRqstUsrEml()); // 2) Special Cargo를 최종적으로 Rqst한 Staff
				}
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : spcgoRjEmlVO.getUsrEml() = "+spcgoRjEmlVO.getUsrEml());
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : spcgoRjEmlVO.getRqstUsrEml() = "+spcgoRjEmlVO.getRqstUsrEml());
				

				/*테스트용
				template.setRecipient("jump@cyberlogitec.com");
				template.setRecipient("happyino2@cyberlogitec.com");
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : TEST >>> setRecipient(\"jump@cyberlogitec.com\")");
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : TEST >>> setRecipient(\"happyino2@cyberlogitec.com\")");
				*/

//				template.setCcRcvrEml("jump@cyberlogitec.com"); //참조인
				
				template.setHtmlTemplate("ESM_BKG_0200.html"); 
				template.setArg("subject",mailSubject);
				// 고객명을 html 형식으로 변환
				template.setArg("custNm",spcgoRjEmlVO.getUsrNm().replaceAll("\n", "<br>"));
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : vo.custNm = "+spcgoRjEmlVO.getUsrNm().replaceAll("\n", "<br>"));
				template.setArg("bkgNo",spcgoRjEmlVO.getBkgNo());
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : vo.bkgNo = "+spcgoRjEmlVO.getBkgNo());
				// 본문 내용을 html 형식으로 변환
//				String rmk = spcgoRjEmlVO.getRmk();
//				rmk = rmk.replaceAll("\n", "<br>");
//				rmk = rmk.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
//				rmk = rmk.replaceAll("\\p{Space}", "&nbsp;");
//				
//				template.setArg("rmk",rmk);

				sndId = template.send();
				log.debug("@@@@@@ SpecialCargoReceiptEAIDAO : sndId = "+sndId);
				
			}
		} catch (MailerAppException mae) {
			this.log.error(mae.getCause());
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return sndId;
    }

}