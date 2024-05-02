/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtEAIDAO.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14 
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageClaimSendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/** It's StevedoreDamageMgtEAIDAO.java
 * @author 
 * @see StevedoreDamageMgtBCImpl
 * @since J2EE 1.5
 */
public class StevedoreDamageMgtEAIDAO extends EAIDAOSupport{

    /**
     * Damage Creation 에서 Save 할 때 담당자에게 GW 메일을 전송합니다.
     *  
     * @param SdmsDamageClaimSendMailVO sdmsDamageClaimSendMailVO
     * @param List<String> emailList
     * @return String
     * @exception DAOException 
     */
    public String sendMailDamageCreation(SdmsDamageClaimSendMailVO sdmsDamageClaimSendMailVO, List<String> emailList) throws DAOException {
        try {
            Mail mail = new Mail();
            mail.setFrom(sdmsDamageClaimSendMailVO.getFromUser(), sdmsDamageClaimSendMailVO.getFromUserNm()); // FROM

            String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
            boolean isLive = false;     // Live 여부
            if (ssoTargetUrl.indexOf("alps.hanjin.com") > 0) {
                isLive = true;
            } 
            
            if (isLive) {
                mail.setRecipients(emailList);          // TO : 담당자 리스트
            } else {
//                List<String> elist = new ArrayList<String>();
//                elist.add("jkweon@cyberlogitec.com");
//                elist.add("kwkim@hanjin.com");	// TO : 김기원 차장님 메일주소.(Test)
//                elist.add("otkim@hanjin.com");	// TO : 김외태 부장님 메일주소.(Test)
//                mail.setRecipients(elist);

            	mail.setRecipients(emailList);
            }

            mail.setRdSubSysCd("OPF");
            mail.setSubject(sdmsDamageClaimSendMailVO.getSubject()); 
            mail.setHtmlContent(sdmsDamageClaimSendMailVO.getHtmlContent());
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
