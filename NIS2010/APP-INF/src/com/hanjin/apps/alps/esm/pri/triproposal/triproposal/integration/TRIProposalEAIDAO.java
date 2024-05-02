/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalEAIDAO.java
*@FileTitle : TRI 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.30 문동규
* 1.0 Creation
=========================================================
* History
* 2016.06.17 [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발  
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic.TRIProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/** It's TRIProposalEAIDAO.java
 * @author Moon Dong Gyu
 * @see TRIProposalBCImpl
 * @since J2EE 1.5
 */
public class TRIProposalEAIDAO extends EAIDAOSupport{

	/**
	 * TRI Proposal Excel Data 를 첨부하여 Descartes 로 메일을 전송합니다.
	 *  
	 * @param TriPropSendMailVO triPropSendMailVO
	 * @exception DAOException 
	 */
	public void sendMailTRIProposal(TriPropSendMailVO triPropSendMailVO) throws DAOException {
        try {
            Mail mail = new Mail();
    		mail.setFrom(triPropSendMailVO.getFromUser(), triPropSendMailVO.getFromUserNm()); // FROM
            
            String ssoTargetUrl = SiteConfigFactory.get("COM.HANJIN.SSO.TARGET");
            boolean isLive = false;     // Live 여부
            if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
                isLive = true;
            } else if (ssoTargetUrl.indexOf("scalps.smlines.com") > 0) {
                isLive = true;
            }
            
            if (isLive) {
                mail.setRecipient("dmspub@descartes.com");  // TO : DXI
            } else {
                mail.setRecipient("seonghwanchoi@cyberlogitec.com");     // TO :  메일주소.(Test)
            }

            mail.setBccRcvrEml(triPropSendMailVO.getFromUser());    // BCC
    		mail.setSubject(triPropSendMailVO.getSubject()); 
    		mail.setTextContent(triPropSendMailVO.getTextContent());

    		SingleMailAttachedFile smfile = new SingleMailAttachedFile();
    		smfile.setFileKey(triPropSendMailVO.getFileKey());
    		List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
    		fileList.add(smfile);
    		mail.setAttachedFile(fileList);

    		String sndNo = mail.send();
    		log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage(), e);
        }
	}

    /**
     * TRI Proposal 에서 Publish 할 때 담당자에게 GW 메일을 전송합니다.
     *  
     * @param TriPropSendMailVO triPropSendMailVO
     * @param List<String> emailList
     * @exception DAOException 
     */
    public void sendMailTRIProposalPublish(TriPropSendMailVO triPropSendMailVO, List<String> emailList) throws DAOException {
        try {
            Mail mail = new Mail();
            mail.setFrom(triPropSendMailVO.getFromUser(), triPropSendMailVO.getFromUserNm()); // FROM

            String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
            boolean isLive = false;     // Live 여부
            if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
                isLive = true;
            } else if (ssoTargetUrl.indexOf("scalps.smlines.com") > 0) {
                isLive = true;
            }
            
            if (isLive) {
                mail.setRecipients(emailList);          // TO : 담당자 리스트
            } else {
                List<String> elist = new ArrayList<String>();
                elist.add("seonghwanchoi@cyberlogitec.com");         // TO : 	참조 하드 코딩 메일주소.(Test)
                mail.setRecipients(elist);
            }

            mail.setBccRcvrEml(triPropSendMailVO.getFromUser());    // BCC
            mail.setSubject(triPropSendMailVO.getSubject()); 
            mail.setHtmlContent(triPropSendMailVO.getHtmlContent());
            mail.setGroupwareMail();

            String sndNo = mail.send();
            log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage(), e);
        }
    }
}
