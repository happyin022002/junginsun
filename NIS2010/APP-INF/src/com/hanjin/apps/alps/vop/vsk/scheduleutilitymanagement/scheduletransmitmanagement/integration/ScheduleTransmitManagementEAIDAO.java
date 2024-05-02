/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScheduleTransmitManagementEAIDAO.java
*@FileTitle : ETA sending (Auto FAX/TLX)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2012.12.20 정상기
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.12.20 CHM-201221649-01 황태진  ETA sending (Auto FAX TLX)
* 2013.05.07 CHM-201324462    정상기  VSK Auto TLX SPP 발송 계정 변경
*                             - SPP 발송계정단일화 : vessel-ops@smlines.com
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuffer;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic.ScheduleTransmitManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * ALPS ScheduleTransmitManagementEAIDAO <br>
 * - NIS2010-ScheduleTransmitManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang Tae jin
 * @see ScheduleTransmitManagementBCImpl 참조
 * @since J2EE 1.6
 */
public class ScheduleTransmitManagementEAIDAO extends EAIDAOSupport {
	/**
	 *   Auto FAX/TLX 메일을 발송합니다<br>
	 * 
	 * @param EtaSendTgtVO etaSendTgtVO
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendScheduleTransmitEmail(EtaSendTgtVO etaSendTgtVO) throws MailerAppException, EAIException, EventException {
		
        String 	ssoTargetUrl 		= JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
        boolean isLive 				= false;     // Live 여부
        ////final 	String sEsvcSndrEml	= "vessel-ops@smlines.com"; 
        
        String	sTransmitKindCd		= "STW".equals(etaSendTgtVO.getTrsmPurpCd()) ? "STW" : "ETA";
        String	sSubject			= null;
        String	sSndrEmail			= null;
        
        if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
            isLive = true;
        } 		
        
        //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::========= \n\n");
        //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::isLive >>> ["+isLive+"]\n\n");
        
        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::================================================ \n\n");
        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::isLive       >>> ["+isLive+"]\n\n");  
        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::Owner        >>> ["+etaSendTgtVO.getTrsmOwnrCd()+"]\n\n");  
        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::Sender.Email >>> ["+etaSendTgtVO.getSndrEml()+"]\n\n");  
        
		
        if("STW".equals(sTransmitKindCd)){
        	sSubject	= etaSendTgtVO.getVvd() + " " + etaSendTgtVO.getVpsPortCd() + " - PREPLAN";
        	sSndrEmail	= "vessel-ops@smlines.com";
        }else{
        	sSubject	= "Sked change notice - " + etaSendTgtVO.getVvd() + "/" + etaSendTgtVO.getVpsPortCd();
        	sSndrEmail	= etaSendTgtVO.getSndrEml();
        }
		////String 	subject		= "Sked change notice - " + etaSendTgtVO.getVvd() + "/" + etaSendTgtVO.getVpsPortCd();
		////String	sSndrEml	= "ESVC".equals(etaSendTgtVO.getTrsmOwnrCd())?sEsvcSndrEml:etaSendTgtVO.getSndrEml();
		
		////log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::Conversion.Email >>> ["+sSndrEml+"]\n\n");  
		
		StringBuffer sbContents	= new StringBuffer();
		
		log.debug("\n\n =====:jskjsk:===== ScheduleTransmitManagementEAIDAO ["+etaSendTgtVO.getTrsmLoclDt()+"]");
		
        if("STW".equals(sTransmitKindCd)){
        	sbContents.append("\nSENT PREPLAN VIA E-MAIL.\n");
        	
        }else{
        	
	        sbContents.append("\nSent : ");
			sbContents.append( VSKGeneralUtil.changeDateFormat(etaSendTgtVO.getTrsmLoclDt(), "yyyyMMdd HH:mm", "yyyy-MM-dd HH:mm" ));
			sbContents.append("\nPIC  : ");
			sbContents.append( etaSendTgtVO.getSndrNm());
			if(etaSendTgtVO.getSndrPhnNo() != null && etaSendTgtVO.getSndrPhnNo().length() > 0){
				sbContents.append(" / ");
				sbContents.append( etaSendTgtVO.getSndrPhnNo());			
			}
			
			sbContents.append("\n\nUrgent!!!");
			sbContents.append("\n");	
			sbContents.append("\nDear Master,");
			sbContents.append("\nChanged ETA from ");
			sbContents.append( VSKGeneralUtil.changeDateFormat(etaSendTgtVO.getVpsEtaDt(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm" )); 
			sbContents.append(" to ");
			sbContents.append( VSKGeneralUtil.changeDateFormat(etaSendTgtVO.getNtcEtaDt(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm" ));
			sbContents.append("\nETB/ETD will be (");
			sbContents.append( VSKGeneralUtil.changeDateFormat(etaSendTgtVO.getNtcEtbDt(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
			sbContents.append(")/(");
			sbContents.append( VSKGeneralUtil.changeDateFormat(etaSendTgtVO.getNtcEtdDt(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
			sbContents.append(")");
			sbContents.append("\nReason : ");
			sbContents.append( etaSendTgtVO.getTrsmRsn());
			sbContents.append("\nPlease do the utmost eco-steaming");
			sbContents.append("\n");
			sbContents.append("\nPls reply below information after adjust speed via e-mail,");
			sbContents.append("\nDate and time of RPM adjust / OLD RPM / NEW RPM");
			sbContents.append("\nE-mail for return:");
			sbContents.append( etaSendTgtVO.getFbEml());
			sbContents.append("\n");
			sbContents.append("\n B.RGDS"); 
			
        }

		 // Email 발송
		 Mail 	mail 		= new Mail();
			
		 try 
		 {
			 
			 String		sTrsmMzdCd		= null;
			 sTrsmMzdCd					= "TLX".equals(etaSendTgtVO.getTrsmMzdCd())?"TLX":"FAX";
			 String		sMailContents	= null;
			 
/*			if ("FAX".equals(etaSendTgtVO.getTrsmMzdCd()) ) {
				mail.setRecipient("realvision21@cyberlogitec.com;maria1005@cyberlogitec.com;tjhwang@cyberlogitec.com;"+ etaSendTgtVO.getSndrEml());
				//mail.setRecipient(etaSendTgtVO.getVslFaxTrsmEml() + ";" + etaSendTgtVO.getSndrEml() );
			} else {
				mail.setRecipient("realvision21@cyberlogitec.com;maria1005@cyberlogitec.com;tjhwang@cyberlogitec.com;"+ etaSendTgtVO.getSndrEml());
				//mail.setRecipient(etaSendTgtVO.getVslTlxTrsmEml() + ";" + etaSendTgtVO.getSndrEml());
			}*/
			
			 
			 //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::etaSendTgtVO.getVslTlxTrsmEml() >>> ["+etaSendTgtVO.getVslTlxTrsmEml()+"]\n\n");
			 //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::etaSendTgtVO.getVslFaxTrsmEml() >>> ["+etaSendTgtVO.getVslFaxTrsmEml()+"]\n\n");
			 
			 //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::etaSendTgtVO.getVslEml() >>> ["+etaSendTgtVO.getVslEml()+"]\n\n");
			 //log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::etaSendTgtVO.getNtcEtdDt() >>> ["+etaSendTgtVO.getNtcEtdDt()+"]\n\n");
			 

			List<String> rcvrEmlList	= new ArrayList<String>();
			if(isLive){
				rcvrEmlList.add		("TLX".equals(etaSendTgtVO.getTrsmMzdCd())? etaSendTgtVO.getVslTlxTrsmEml() : etaSendTgtVO.getVslFaxTrsmEml());
				//::jsk::2013.01.23  라이브반영시 주석처리:://rcvrEmlList.add		("TLX.0583435168711@ipmsg.com");
			}else{
				rcvrEmlList.add		("TLX".equals(sTrsmMzdCd)?etaSendTgtVO.getVslTlxTrsmEml():etaSendTgtVO.getVslFaxTrsmEml());	//status@ipmsg.com -- unused //dykim@easylink.co.kr
				rcvrEmlList.add		(etaSendTgtVO.getSndrEml());
			}

			
			///////////////////////////////////////////////////////////////////////////
/*			String[]	 ccEmlAddrArr	= new String[] {""};			
			if(isLive){
				ccEmlAddrArr[0]		= etaSendTgtVO.getVslEml	();
				ccEmlAddrArr[1]		= etaSendTgtVO.getLanePicEml();
				ccEmlAddrArr[2]		= etaSendTgtVO.getFbEml		();
			}else{
				ccEmlAddrArr[0]		= etaSendTgtVO.getLanePicEml();
				ccEmlAddrArr[1]		= etaSendTgtVO.getFbEml		();
			}*/
			///////////////////////////////////////////////////////////////////////////
			
			String[] ccEmlAddrArr	= new String[3];
			
			if("ETA".equals(sTrsmMzdCd)){
				if(isLive){
					ccEmlAddrArr[0]		= etaSendTgtVO.getVslEml		();
					ccEmlAddrArr[1]		= etaSendTgtVO.getLanePicEml	();
					ccEmlAddrArr[2]		= etaSendTgtVO.getFbEml			();
				}else{
					ccEmlAddrArr[0]		= etaSendTgtVO.getLanePicEml	();
					ccEmlAddrArr[1]		= etaSendTgtVO.getFbEml			();
				
					//if("ALPS".equals(etaSendTgtVO.getTrsmOwnrCd()))
					//	ccEmlArr[1]		= "realvision21@cyberlogitec.com";
					//else
					//	ccEmlArr[1]		= "neojina@cyberlogitec.com";			//"박연진"<neojina@cyberlogitec.com>;
				}					
			}
				
			mail.setRecipients		(rcvrEmlList	);
			mail.setCcRcvrEmls		(ccEmlAddrArr	);
			mail.setRdSubSysCd		("VSK"			);
			mail.setBatFlg			("Y"			);
 			mail.setFrom			(sSndrEmail		); 
			mail.setSubject			(sSubject		);
			
			//-----------------------------------------------------------------------------------------------------------------
			log.debug(("\n\n ::jskjskjsk:: ["+sTrsmMzdCd+"]\n [" +JSPUtil.replace(sbContents.toString(), "@", "(at)"))+ "]");
			
			sMailContents	= sbContents.toString();
			
			if("TLX".equals(sTrsmMzdCd)){
				sMailContents		= JSPUtil.replace(sbContents.toString(), "@", "(at)");	//TELEX 인식불가문자 Conversion//
				//sMailContents		= JSPUtil.replace(sbContents.toString(), "!", ""	);	//TELEX 인식불가문자 Conversion//
				mail.setTextContent		(sMailContents);
			}else{
				mail.setTextContent		(sMailContents);
			}
			//-----------------------------------------------------------------------------------------------------------------
			
			////mail.setGroupwareMail();	//web mail to easylink 불가로 groupware mail 변경가능성
			String sndNo = mail.send();
			
			//log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementEAIDAO::email Contents >>> ["+mail.getEmlCtnt()+"]\n\n");
			
			return sndNo;
			
		 } catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
			} catch (Exception e) {
				throw new EventException(e.getMessage(), e);
			}
		}	
}
