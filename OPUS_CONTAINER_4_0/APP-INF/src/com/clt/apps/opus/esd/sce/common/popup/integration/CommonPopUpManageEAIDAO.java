/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CommonPopUpManageEAIDAO.java
 *@FileTitle : EsdSce0103
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2009.07.28 신한성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration;

import java.util.List;

import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
/**
 * SCEM에 대한 DB / EAI 처리를 담당<br>
 * - SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yong_cheon_shin
 * @see CommonPopUpManageDBDAO 참조
 * @since J2EE 1.4
 */
public class CommonPopUpManageEAIDAO extends EAIDAOSupport{
	
    /** 
     * Mail 전송 기능
     * @param String szSubject
     * @param String usr_eml
     * @param List<SingleMailAttachedFile> arFileList
     * @param String[] arrSendList
     * @param String szContents
     * @return String
     * @throws Exception 
     */
    public String sendEml(String szSubject, String usr_eml, List<SingleMailAttachedFile> arFileList, String[] arrSendList, String szContents) throws Exception 
    {
    	Mail mailers = new Mail();
		mailers.setSubject(szSubject);
		mailers.setFrom(usr_eml);
		mailers.setAttachedFile(arFileList);
		mailers.setRecipients( arrSendList);
	    mailers.setTextContent( szContents );
		// 메일 보내기
//	    log.debug("mailers => " + mailers.toString());
	    
	    String sndNo = mailers.send();
	    
	    return sndNo;
    }
}
