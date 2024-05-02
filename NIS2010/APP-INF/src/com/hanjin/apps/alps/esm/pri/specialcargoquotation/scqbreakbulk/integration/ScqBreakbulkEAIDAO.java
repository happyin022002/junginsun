/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkEAIDAO.java
*@FileTitle : ScqBreakbulkEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.06.27 이혜민
* 1.0 Creation
=========================================================
* History 
* 2013.07.04 송호진 [CHM-201325215] Email 기능 관련 긴급 반영
* 2015.01.05 [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * Break Bulk Cargo Rate 대한 EAI 처리를 담당<br>
 * - CRM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Lee hye min
 * @see ScqBreakbulkBCImpl 참조
 * @since J2EE 1.4
 */
public class ScqBreakbulkEAIDAO extends EAIDAOSupport{

    /**
     * 승인권자가 Approval, Reject 시 해당 requeste에게 G/W 메일 발송<br>
     *  
     * @param TriPropSendMailVO sendMailVO
     * @param String[] toUser
     * @return String
     * @exception DAOException 
     */
    public String sendEmail(TriPropSendMailVO sendMailVO, String[] toUser) throws DAOException {
        try {
            Mail mail = new Mail();
            List<String> elist = new ArrayList<String>();
            mail.setFrom(sendMailVO.getFromUser(), sendMailVO.getFromUserNm()); // FROM
            mail.setOfficeCode(sendMailVO.getOfcCd());
            
           // log.debug(">>>>>>>>>>>>>Send Mail toUser -> requester : "+toUser[0]+ ", srep : " +toUser[1]);
            
            String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
            boolean isLive = false;     // Live 여부
            if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
                isLive = true;
            }
            int toUserCount = toUser.length;
            log.debug(">>>>>>>>>>>>>Send Mail toUserCount : "+toUserCount);
            if (isLive) {
            	for(int i=0; i<toUserCount; i++){
            		elist.add(toUser[i]);
            	}
            	mail.setRecipients(elist);         
            } else { // Live 아닐 경우 장승환 부장님(SELCMR), 송호진ssn, 이혜민 -- [CHM-201639660] SELCMR로 변경 Requested by SELCMR/Pilkyung Jun
                elist.add("standy@cyberlogitec.com");
                elist.add("shchang@smlines.com");
                
                mail.setRecipients(elist);
            }

            mail.setRdSubSysCd("PRI");
            mail.setSubject(sendMailVO.getSubject()); 
            mail.setHtmlContent(sendMailVO.getHtmlContent());
            mail.setGroupwareMail();
            String sndNo = mail.send();
            log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
            return sndNo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage(), e);
        }
    }
    
}