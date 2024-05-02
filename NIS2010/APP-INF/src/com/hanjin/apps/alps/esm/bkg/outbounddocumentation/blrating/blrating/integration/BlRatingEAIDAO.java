/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BLRatingEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.04
*@LastModifier   : 박준용
*@LastVersion    : 1.0
* 2009.09.04 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.Locale;
//import java.util.StringTokenizer;
//import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
//import org.apache.commons.lang.StringUtils;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateCheckNoticeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingEAIDAO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS BLRatingEAIDAO <br>
 * - NIS2010-Outbound BL Rating system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Joon Yong Park
 * @see BlRatingBCImpl 참조
 * @since J2EE 1.4
 */
public class BlRatingEAIDAO extends EAIDAOSupport {

	/**
	 * e-mail을  전송한다. <br>
     * @param List<EmailPpdInfoVO> vos
     * @param String usrEml
     * @param String accountUsrEml
     * @param String accountUsrNm
     * @return String
     * @throws EventException
     */
    public String sendPpdChangeInfoByEmail(List<EmailPpdInfoVO> vos, String usrEml, String accountUsrEml, String accountUsrNm) throws EventException {
    	
    	String blNo = "";
    	String vvd =  "";
    	String polCd =  "";
    	String podCd =  "";
    	String polEtdDt =  "";
    	String updDt =  "";
    	String updUsrNm =  "";
    	String shpr =  "";
    	String frwd =  "";
    	String chgContents = "";
    	String subject = "";
    	String contents = "";
    	
    	int len = vos.size();
    	
    	try {	
    		
    		StringBuffer chgContentsBuff = new StringBuffer();
	
			for(int i=0; i < len; i++){
				EmailPpdInfoVO EmailPpdInfoVO = vos.get(i);
				
				if (i == 0) {
					blNo = EmailPpdInfoVO.getBlNo();
			    	vvd = EmailPpdInfoVO.getVvd();
			    	polCd = EmailPpdInfoVO.getPolCd();
			    	podCd = EmailPpdInfoVO.getPodCd();
			    	polEtdDt = EmailPpdInfoVO.getPolEtdDt();
			    	updDt = EmailPpdInfoVO.getUpdDt();
			    	updUsrNm = EmailPpdInfoVO.getUpdUsrNm();
			    	shpr = EmailPpdInfoVO.getShpr();
			    	frwd = EmailPpdInfoVO.getFrwd();
				}
				
		    	String currCd = EmailPpdInfoVO.getCurrCd();
		    	String chgAmt = EmailPpdInfoVO.getChgAmt();
		    	
//		    	chgContents = chgContents 
//				                   + "<br> Prepaid amount : "+ chgAmt
//				                   + "<br> Prepaid currency : "+ currCd ;	    	
		    	chgContentsBuff.append("<br> Prepaid amount : "+ chgAmt + "<br> Prepaid currency : "+ currCd);
			}
			chgContents = chgContentsBuff.toString();
	
            subject = "Prepaid amount change notice ("+blNo+")";
			contents = "The captioned bkg has been rerated and prepaid amount has been changed."		 		
				         + "<br>"
				         + "<br> B/L # : " + blNo
				         + "<br> VVD : " + vvd
				         + "<br> POL : " + polCd
				         + "<br> POD : " + podCd
				         + "<br> Sailing date : " + polEtdDt
				         + "<br> Rerating date : " + updDt
				         + "<br> Rerating staff : " + updUsrNm
				         + "<br> Shipper : " + shpr
				         + "<br> Freight forwarder : " + frwd
				         + chgContents
				         + "<br>"
						 + "<br>Thank you.";
          
			log.debug("@@@@@@ BlRatingEAIDAO : Contents = "+contents);
			
			Mail mail = new Mail();
			mail.setFrom(accountUsrEml, accountUsrNm);
			mail.setRecipient(usrEml);
			mail.setSubject(subject);
			mail.setHtmlContent(contents);
			
			
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			
			// Live 여부
	        if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
	        	return mail.send();
	        } else {
	        	return "";
	        }
				
			

        } catch (MailerAppException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
    /**
	 * e-mail을  전송한다. <br>
     * @param ChargeAmendAuthRequestVO request
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String sendChargeAmendAuthRequest(ChargeAmendAuthRequestVO request, SignOnUserAccount account) throws DAOException {
    	
    	 try {
    	
			ChargeAmendAuthRefUserVO[] usrVOs = request.getChargeAmendAuthRefUserVOs();
			String bkgNo = request.getBkgNo();
			String chgCd = request.getChgCd();
	    	Mail mail = new Mail();
	    	int cnt = usrVOs.length;
	    	int to = 0;
	    	int cc = 0;
			for(int i=0; i<cnt; i++){
				if("T".equals(usrVOs[i].getAproRqstRefTpCd())){
					to++;
				}else if("C".equals(usrVOs[i].getAproRqstRefTpCd())){
					cc++;
				}
			}   	
	    	  	
			String toList[] = new String [to];
			String ccList[] = new String [cc];
			int x=0;
			int y=0;
			
	
			for(int i=0; i<cnt; i++){
				if("T".equals(usrVOs[i].getAproRqstRefTpCd())){
					toList[x] = usrVOs[i].getAproRqstRefUsrEml();
					x++;
				}else if("C".equals(usrVOs[i].getAproRqstRefTpCd())){
					ccList[y] = usrVOs[i].getAproRqstRefUsrEml();
					y++;
				}
			}   
	    	
	        mail.setFrom(account.getUsr_eml(), account.getUsr_nm()); // FROM
	        mail.setOfficeCode(account.getOfc_cd());
	
	        String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
	        boolean isLive = false;     // Live 여부
	        if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
	            isLive = true;
	        } 
	        
//	        if (isLive) {
	            mail.setRecipients(toList);          // TO : 담당자 리스트
	            mail.setCcRcvrEmls(ccList);
//	        } else {
//	            List<String> elist = new ArrayList<String>();
//	            elist.add("zinzz@cyberlogitec.com");	            
//	            mail.setRecipients(elist);
//	        }
	        
	        mail.setRdSubSysCd("BKG");
	        mail.setSubject(chgCd + " Exemption  Request ("+bkgNo+")"); 
	        mail.setHtmlContent(request.getMailBody());
	        mail.setGroupwareMail();
	        
	        String sndNo = mail.send();
	        log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
	        return sndNo;

    	 } catch (Exception e) {
             log.error(e.getMessage(), e);
             throw new DAOException(new ErrorHandler(e).getMessage(), e);
         }
    }
    
    /**
	 * e-mail을  전송한다. <br>
     * @param List<ChargeAmendAuthRequestListVO> vos
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String sendChargeAmendAuthResult(List<ChargeAmendAuthRequestListVO> vos, SignOnUserAccount account) throws DAOException {
    	
    	 try {

			 String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			 boolean isLive = false;     // Live 여부
			 if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
				 isLive = true;
			 }

			 Mail mail = new Mail();			 
			 mail.setFrom(account.getUsr_eml(), account.getUsr_nm()); // FROM
			 mail.setOfficeCode(account.getOfc_cd());
			 mail.setRdSubSysCd("BKG");		        
			 String sndNo = "";
		        
    	 
    		 int size = vos.size();
    		 if (size > 0) {
    			 Iterator list = vos.iterator();
    			 while (list.hasNext()) {
    				 ChargeAmendAuthRequestListVO vo = (ChargeAmendAuthRequestListVO) list.next();
//    				 if (isLive) {
    					 mail.setRecipient(vo.getRqstUsrEml());          // TO : 담당자 리스트
//    				 } else {
//    					 List<String> elist = new ArrayList<String>();
//    					 elist.add("zinzz@cyberlogitec.com");
//    					 mail.setRecipients(elist);
//    				 }
    				 
    				 mail.setSubject(vo.getMailTitle());
    				 mail.setHtmlContent(vo.getMailBody());
    				 mail.setGroupwareMail();
    				 sndNo = mail.send();
    				 log.debug(">>>>>>>>>> Send Mail No : "+sndNo);
    			 }
    		 }
    		 
    		 return sndNo;

    	 } catch (Exception e) {
             log.error(e.getMessage(), e);
             throw new DAOException(new ErrorHandler(e).getMessage(), e);
         }
    }
    
    /**
	 * e-mail을  전송한다. <br>
     * @param RateCheckNoticeVO vo
     * @return String
     * @throws EventException
     */
    public String sendCRateCheckNotice(RateCheckNoticeVO vo) throws DAOException {
    	
    	 try {

			 String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			 boolean isLive = false;     // Live 여부
			 if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
				 isLive = true;
			 }

			 Mail mail = new Mail();			 
			 mail.setFrom("noreply@smlines.com"); // FROM
			 mail.setRdSubSysCd("BKG");		        
			 String sndNo = "";
			 
			 mail.setRecipient(vo.getSrepEml());
			 
			 if(isLive == true){
				 mail.setSubject(vo.getTitle());
			 }else{
				 mail.setSubject("[Test Mail] "+vo.getTitle());
			 }
			 mail.setHtmlContent(vo.getBody());

			 if(isLive == true){
				 sndNo = mail.send();
			 }
    		 return sndNo;

    	 } catch (Exception e) {
             log.error(e.getMessage(), e);
             throw new DAOException(new ErrorHandler(e).getMessage(), e);
         }
    }
}