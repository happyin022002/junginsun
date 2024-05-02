/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementEAIDAO.java
*@FileTitle : Vessel Schedule Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.08.12 정상기
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능                            
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.basic.ScheduleNotificationManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationTransmitLogVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * ALPS ScheduleNotificationManagementEAIDAO <br>
 * - NIS2010-ScheduleNotificationManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JEONG SANG-KI
 * @see ScheduleNotificationManagementBCImpl 참조
 * @since J2EE 1.6
 */
public class ScheduleNotificationManagementEAIDAO extends EAIDAOSupport {
	/**
	 * Vessel Schedule 변경사항에 대한 Notice를 GW Mail로 발송합니다<br>
	 * 
	 * @param VslSkdCngNotificationTransmitLogVO notificationVO
	 * @return VslSkdCngNotificationTransmitLogVO
	 * @exception EAIException 
	 */	
	public VslSkdCngNotificationTransmitLogVO sendScheduleNotificationEmail(VslSkdCngNotificationTransmitLogVO notificationVO) throws MailerAppException, EAIException, EventException {
		
		if(notificationVO == null)	return null;
		
		//VSKCodeFinderDBDAO commonDbDao	= new VSKCodeFinderDBDAO();
		
        String 	ssoTargetUrl 		= JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
        boolean isLive 				= false;     				// Live 여부
        //final 	String sEsvcSndrEml	= "vessel-ops@smlines.com"; 
        
        VslSkdCngNotificationTransmitLogVO	rtnVO	= new VslSkdCngNotificationTransmitLogVO();
        
        if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
            isLive = true;
        } 		
        
        String	sAlpsUrl	= null;	
        
        //::SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL"):://
        if(isLive)	sAlpsUrl	= "http://alps.smlines.com/";
        else		sAlpsUrl	= "http://alpsdev.smlines.com:9400/";
        
        //log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::========= \n\n");
        //log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::isLive >>> ["+isLive+"]\n\n");
        
        log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::================================================ \n\n");
        log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::isLive       >>> ["+isLive+"]\n\n");  
        //log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::Owner        >>> ["+etaSendTgtVO.getTrsmOwnrCd()+"]\n\n");  
        //log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::Sender.Email >>> ["+etaSendTgtVO.getSndrEml()+"]\n\n");  
        

        /*     	NTFC_TRSM_TP_CD
         * --------------------------------------------
         * 		ET : ETA/ETB/ETD 지연
         * 		PS : PORT SKIP 
         * 		PR : PORT REVERSE
         * 		SR : BOTH SKIP + REVERSE	
         */	
        
        
        String sVslCd			= notificationVO.getVslCd();
        String sSkdVoyNo		= notificationVO.getSkdVoyNo();
        String sSkdDirCd		= notificationVO.getSkdDirCd();
        
        String sVvd				= sVslCd+sSkdVoyNo+sSkdDirCd;
        	
        String sVpsPortCd		= notificationVO.getVpsPortCd();	
        
        String	sSubject		= null;
        String	sSndrEmail		= null;
        StringBuffer sbContents	= new StringBuffer();
        
        String	sReceiverEmail	= notificationVO.getRcvrEml();
        String	sEtaDelayHrs	= notificationVO.getEtaDelayHrs() == null ? "0" : notificationVO.getEtaDelayHrs();
        String	sEtbDelayHrs	= notificationVO.getEtbDelayHrs() == null ? "0" : notificationVO.getEtbDelayHrs();
        String	sEtdDelayHrs	= notificationVO.getEtdDelayHrs() == null ? "0" : notificationVO.getEtdDelayHrs();
        
        //String	sEtaAdvanceOrDelayStupHrs	= null;
        //String	sEtbAdvanceOrDelayStupHrs	= null;
        //String	sEtdAdvanceOrDelayStupHrs	= null;
        
        String	sCrntEtaDt		= notificationVO.getVpsEtaDt() == null ? "" : notificationVO.getVpsEtaDt();
        String	sCrntEtbDt		= notificationVO.getVpsEtbDt() == null ? "" : notificationVO.getVpsEtbDt();
        String	sCrntEtdDt		= notificationVO.getVpsEtdDt() == null ? "" : notificationVO.getVpsEtdDt();
        
		boolean isEtaAdvFlag	= false;
		boolean isEtbAdvFlag	= false;
		boolean isEtdAdvFlag	= false;
		
		boolean isOnTimeEtaFlag	= false; 		//PF SKD ETA와 일치  
		boolean isOnTimeEtbFlag	= false; 		//PF SKD ETB와 일치  
		boolean isOnTimeEtdFlag	= false;		//PF SKD ETD와 일치  

        /*	PROFORMA - ESTIMATED
         *  ---------------------------------------------
         * 	MINUS	:: DELAY
         * 	PLUS	:: ADVANCE
         *  ---------------------------------------------
         */
        if(		!"".equals(sEtaDelayHrs) && sEtaDelayHrs != null 
        	&&	!"".equals(sEtbDelayHrs) && sEtbDelayHrs != null  
        	&&	!"".equals(sEtdDelayHrs) && sEtdDelayHrs != null
        	)
        {
//            if(Integer.parseInt(sEtaDelayHrs)>0){
//            	sEtaAdvanceOrDelayStupHrs	= notificationVO.getEtaDlayFmHrs();
//            }else{
//            	sEtaAdvanceOrDelayStupHrs	= notificationVO.getEtaDlayToHrs();
//            }
//            
//            if(Integer.parseInt(sEtbDelayHrs)>0){
//            	sEtbAdvanceOrDelayStupHrs	= notificationVO.getEtbDlayFmHrs();
//            }else{
//            	sEtbAdvanceOrDelayStupHrs	= notificationVO.getEtbDlayToHrs();
//            }
//            
//            if(Integer.parseInt(sEtdDelayHrs)>0){
//            	sEtdAdvanceOrDelayStupHrs	= notificationVO.getEtdDlayFmHrs();
//            }else{
//            	sEtdAdvanceOrDelayStupHrs	= notificationVO.getEtdDlayToHrs();
//            }
        	
        	
			  sEtaDelayHrs	= notificationVO.getEtaDelayHrs() == null || "".equals(notificationVO.getEtaDelayHrs()) ? "0" : notificationVO.getEtaDelayHrs();
			  sEtbDelayHrs	= notificationVO.getEtbDelayHrs() == null || "".equals(notificationVO.getEtbDelayHrs()) ? "0" : notificationVO.getEtbDelayHrs();
			  sEtdDelayHrs	= notificationVO.getEtdDelayHrs() == null || "".equals(notificationVO.getEtdDelayHrs()) ? "0" : notificationVO.getEtdDelayHrs();
			  

			  if(Float.parseFloat(sEtaDelayHrs) < 0)	isEtaAdvFlag	= true;
			  if(Float.parseFloat(sEtbDelayHrs) < 0)	isEtbAdvFlag	= true;
			  if(Float.parseFloat(sEtdDelayHrs) < 0)	isEtdAdvFlag	= true;
	          
			  if(Float.parseFloat(sEtaDelayHrs) == 0)	isOnTimeEtaFlag	= true;
			  if(Float.parseFloat(sEtbDelayHrs) == 0)	isOnTimeEtbFlag	= true;
			  if(Float.parseFloat(sEtdDelayHrs) == 0)	isOnTimeEtdFlag	= true;
                    	
        }

        
        //::ESTIMATE TIME ADVANCE OR DELAY:://
        if("ET".equals(notificationVO.getNtfcTrsmTpCd())){
        	sSubject	= "Notification for Vessel Sked Change (Estimated Time) - "+sVvd+" / "+sVpsPortCd+"";
        	
        	sbContents.append("<br><br><font size='4'>Pls be noted that there is sked change on ");
        	sbContents.append(sVvd);
        	sbContents.append(" / ");
        	sbContents.append(sVpsPortCd);
        	sbContents.append(" out of your setting time in ALPS.");
        	sbContents.append("<br>");
        	sbContents.append(sVvd);
        	sbContents.append(" / ");
        	sbContents.append(sVpsPortCd);
        	
        	if(sEtaDelayHrs != null && !"".equals(sEtaDelayHrs) && !"0".equals(sEtaDelayHrs)){
            	sbContents.append(" / ");
            	sbContents.append("ETA ");
            	sbContents.append(sCrntEtaDt);
            	sbContents.append(" (");
            	
            	if(isOnTimeEtaFlag){
	            	sbContents.append("<font color='black'>");
	            	sbContents.append(sEtaDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else if(isEtaAdvFlag){
	            	sbContents.append("<font color='blue'>");
	            	sbContents.append(sEtaDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else{
	            	sbContents.append("<font color='red'>");
	            	sbContents.append(sEtaDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}
            	
            	sbContents.append(")"); 
        	}
        	
        	if(sEtbDelayHrs != null && !"".equals(sEtbDelayHrs) && !"0".equals(sEtbDelayHrs)){
            	sbContents.append(" / ");
            	sbContents.append("ETB ");
            	sbContents.append(sCrntEtbDt);
            	sbContents.append(" (");
            	
            	if(isOnTimeEtbFlag){
	            	sbContents.append("<font color='black'>");
	            	sbContents.append(sEtbDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else if(isEtbAdvFlag){
	            	sbContents.append("<font color='blue'>");
	            	sbContents.append(sEtbDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else{
	            	sbContents.append("<font color='red'>");
	            	sbContents.append(sEtbDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}
            	sbContents.append(")");       
        	}
        	
        	if(sEtdDelayHrs != null && !"".equals(sEtdDelayHrs) && !"0".equals(sEtdDelayHrs)){
            	sbContents.append(" / ");
            	sbContents.append("ETD ");
            	sbContents.append(sCrntEtdDt);
            	sbContents.append(" (");
            	
            	if(isOnTimeEtdFlag){
	            	sbContents.append("<font color='black'>");
	            	sbContents.append(sEtdDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else if(isEtdAdvFlag){
	            	sbContents.append("<font color='blue'>");
	            	sbContents.append(sEtdDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}else{
	            	sbContents.append("<font color='red'>");
	            	sbContents.append(sEtdDelayHrs);
	            	sbContents.append(" hours");
	            	sbContents.append("</font>");
            	}
            	sbContents.append(")");       
        	}
        	
        	
        	sbContents.append("<br><br>");  
        	sbContents.append("<a href='"+ sAlpsUrl +"hanjin/VOP_VSK_0019.do?pop_mode=Y&vsl_cd="+sVslCd+"&skd_voy_no="+sSkdVoyNo+"&skd_dir_cd="+sSkdDirCd+"' target='_blank'>");
        	
        	//sbContents.append("<a href='#' onClick='window.open('" + SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") + "hanjin/VOP_VSK_0019.do?pop_mode=Y&vsl_cd="+sVslCd+"&skd_voy_no="+sSkdVoyNo+"&skd_dir_cd="+sSkdDirCd+"', '_blank', left='100', top='100', width='800', height='600', menubar='no', toolbar='no');' >");
        	//sbContents.append("<a href='#' onclick=window.open('http://alps.smlines.com/hanjin/VOP_VSK_0019.do', '', '') >");
        	
        	
        	//<a href="#" onclick="window.open ('http://alps.smlines.com/hanjin/VOP_VSK_0019.do','cong_window' , 'toolbar=0, location=0, status=0, menubar=0, scrollbars=1, resizable=1, top=50, left=20, width=850, height=600')">ttt</a>
        	
        	sbContents.append("<font size='4'>Click for VVD Sked Inquiry</font>");
        	sbContents.append("</a>");        	
        	
        	sbContents.append("</font>"); 
        	
        //::PORT SKIP:://
        }else if("PS".equals(notificationVO.getNtfcTrsmTpCd())){
        	sSubject	= "Notification for Vessel Sked Change (PORT SKIP) - "+sVvd+" / "+sVpsPortCd+"";
        	
        	sbContents.append("<br><br><font size='4'>");
        	sbContents.append(sVvd);
        	sbContents.append(" will skip ");
        	sbContents.append(sVpsPortCd);
        	sbContents.append(".</font>");
        	
        //::PORT SKIP CANCEL:://
        }else if("PX".equals(notificationVO.getNtfcTrsmTpCd())){
        	sSubject	= "Notification for Vessel Sked Change (SKIP CANCEL) - "+sVvd+" / "+sVpsPortCd+"";
        	
        	sbContents.append("<br><br><font size='4'>");
        	sbContents.append(sVvd);
        	sbContents.append(" skip canceled ");
        	sbContents.append(sVpsPortCd);
        	sbContents.append(".</font>");   
        	
        //::OTHERS:://
        }else{
        	return null;
        }

		 // Email 발송
		 Mail 	mail 		= new Mail();
		 
		 sSndrEmail	= "noreply@smlines.com";
			
		 try 
		 {
			 
			List<String> rcvrEmlList	= new ArrayList<String>();
			rcvrEmlList.add		(sReceiverEmail);
				
			mail.setRecipients		(rcvrEmlList			);
			mail.setRdSubSysCd		("VSK"					);
			mail.setBatFlg			("Y"					);
 			mail.setFrom			(sSndrEmail				); 
			mail.setSubject			(sSubject				);
			mail.setHtmlContent		(sbContents.toString()	);
			////::jskjskjsk::2013-08-12::////
			
			if(isLive)	mail.setGroupwareMail	();
							
			String sEmailSendNo 	= mail.send();
			
			rtnVO.setSndrEml	(sSndrEmail		);
			rtnVO.setRcvrEml	(sReceiverEmail	);
			rtnVO.setEmlSndNo	(sEmailSendNo	);
			
			//log.info("\n ======== ::jskjskjsk::ScheduleNotificationManagementEAIDAO::email Contents >>> ["+mail.getEmlCtnt()+"]\n\n");
			
			
		 } catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
		 } catch (Exception e) {
			 	throw new EventException(e.getMessage(), e);
		 }
		
		 return rtnVO;
	}

}
