/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBEmailDAO.java
*@FileTitle : EMAIL SEND
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : dongsoo
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.List;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalEmlVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 *  OPUS OwnDangerousCargoApprovalDBEmailDAO <br>
 * @author 
 * @see OwnDangerousCargoApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class OwnDangerousCargoApprovalDBEmailDAO extends EAIDAOSupport{
	/**
	 * ESM_BKG_0156 Mail 전송<br>
	 * 
	 * @param ownApprovalEmlVO
	 * @param ownApprovalRequestVO
	 * @param account
	 * @return String
	 * @throws EAIException
	 */
	public String sendEml(OwnApprovalEmlVO ownApprovalEmlVO , OwnApprovalRequestVO ownApprovalRequestVO, SignOnUserAccount account) throws Exception{
		try {		    
			
			TemplateMail template 		= new TemplateMail();
			
			template.setFrom( account.getUsr_eml(), account.getUsr_id());
			template.setRecipient(ownApprovalEmlVO.getToEml());
			template.setCcRcvrEml(ownApprovalEmlVO.getCcEml());
			template.setRdSubSysCd("VOP");
			template.setBatFlg("N");
			template.setSubject("Approval for Special cargo Request (BKG No : " + ownApprovalEmlVO.getBookingNo() + ")"); 
			
			OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
			
			List<OwnApprovalRequestVO> vos = command.searchSCGMailingList(ownApprovalRequestVO);
			
			String body_footer = "";
			
			StringBuffer bodyConts = new StringBuffer();
			
			if(vos != null && vos.size() > 0) {
//				fromPsn     = vos.get(0).getFromPsn();
//				toPsn       = vos.get(0).getToPsn();
//				ccPsn       = vos.get(0).getCcPsn();
//				subject     = vos.get(0).getSubject();
//				attachFile  = vos.get(0).getAttachFile();
//				bodyHeader  = vos.get(0).getBodyHeader();
				body_footer = vos.get(0).getBodyFooter();
				
				for(int bdyCnt=0; bdyCnt<vos.size(); bdyCnt++) {	
					bodyConts.append(vos.get(bdyCnt).getBodyConts());
				}
			}

			bodyConts.append(body_footer);
			
			template.setArg("contents",bodyConts.toString());
			
			template.setHtmlTemplate("VOP_SCG_0014_01T.html");
			
			return template.send();
			 
		} catch (MailerAppException ex) {
			throw new Exception(ex.getMessage(), ex);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}
}
