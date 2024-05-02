/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WORejectManageEAIDAO.java
*@FileTitle : WORejectManageEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.basic.WORejectManageBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectManageBCImpl 참조
 * @since J2EE 1.4
 */
public class WORejectManageEAIDAO extends EAIDAOSupport{
	/**
	 * WORejcetManage Send FAX
	 * 
	 * @param e
	 * @param userId
	 * @throws EventException
	 */
	public void faxEdiSend(Event e,String userId) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EsdTrs0024Event event = (EsdTrs0024Event)e;
        try {
        	// Fax Utility를 이용하는 것은 SC, BC, DAO 어디에서든 가능하지만...
        	// DB Transaction이 발생하므로, begin(), commit(), rollback() 처리를 반드시 해주어야 함
          
            // 1. FaxMetaInfo를 생성한다.
            //    <Parameter>
            //    1) sys_cd : 시스템 코드 (TPB, TRS 등)
            //    2) app_cd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
            //    3) batch_ind : Batch 업무 유무 (Y/N)
            //    4) title : FAX 제목
            //    5) param : Report 생성시 필요한 Parameter
            //    6) rcv_info : 수신자 정보
            //    7) office : 사용자의 Office 코드
        	HashMap hashParam = event.getHashParam();
        	
        	String sys_cd = (String) hashParam.get("FAX_SYS_CD");
        	String app_cd = (String) hashParam.get("FAX_APP_CD");
        	String batch_ind = (String) hashParam.get("FAX_BATCH_IND");
        	String title = (String) hashParam.get("FAX_TITLE");
        	String fax_param = (String) hashParam.get("FAX_PARAM");
        	String rcv_info = (String) hashParam.get("FAX_RCV_INFO");
        	String office_cd = (String) hashParam.get("FORM_USR_OFC_CD");
        	
        	String fax_no_01 = (String) hashParam.get("WO_N1ST_FAX_NO");
        	String fax_no_02 = (String) hashParam.get("WO_N2ND_FAX_NO");
        	String fax_no_03 = (String) hashParam.get("WO_N3RD_FAX_NO");
        	

        	if(fax_no_01!=null && !fax_no_01.equals("")){
        		FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, fax_param, rcv_info+";"+fax_no_01, office_cd, userId);
        		FaxUtility.registerDB(info);
        	}
        	
        	if(fax_no_02!=null && !fax_no_02.equals("")){
        		FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, fax_param, rcv_info+";"+fax_no_02, office_cd, userId);
        		FaxUtility.registerDB(info);
        	}
        	
        	if(fax_no_03!=null && !fax_no_03.equals("")){
        		FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, fax_param, rcv_info+";"+fax_no_03, office_cd, userId);
        		FaxUtility.registerDB(info);
        	}
      	
        } catch (ServerExportException se) {
        	log.error("err " + se.toString(), se);
        	throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		
    }	

	/**
	 * WORejcetManage Send E-MAIL
	 * @param Event e
	 * @exception EventException
	 */		
	public void emailSend(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EsdTrs0024Event event = (EsdTrs0024Event)e;
        
//        ArrayList infoV = new ArrayList();
//        RDMailMetaInfo[] infoArr = null;
        
        try {
        	HashMap hashParam = event.getHashParam();
        	
        	String sys_cd = (String) hashParam.get("FAX_SYS_CD");
        	String app_cd = (String) hashParam.get("FAX_APP_CD");
        	String email_param = (String) hashParam.get("FAX_PARAM");
        	String office_cd = (String) hashParam.get("FORM_USR_OFC_CD");
        	String email_title = (String) hashParam.get("EMAIL_TITLE");
        	String email_contents = (String) hashParam.get("EMAIL_CONTENTS");
//        	String user_nm = "SPP_IF"; // 세팅
//        	String user_eml = "sppadm@cyberlogitec.com";
        	String user_nm = (String) hashParam.get("USR_ID");
        	String user_eml = (String) hashParam.get("USR_EML");
        	user_eml = (user_eml==null||user_eml.trim().equals("")?"seokho9@smlines.com":user_eml);
        	
        	String email_no_01 = (String) hashParam.get("WO_N1ST_EML");
        	String email_no_02 = (String) hashParam.get("WO_N2ND_EML");
        	String email_no_03 = (String) hashParam.get("WO_N3RD_EML");
        	
        	if(email_no_01!=null && !email_no_01.equals("")){
        		sendMail(sys_cd, app_cd, "N", email_title, email_contents, email_param, 
        				user_nm, user_eml, email_no_01, office_cd);
        	}

        	
        	if(email_no_02!=null && !email_no_02.equals("")){

        		sendMail(sys_cd, app_cd, "N", email_title, email_contents, email_param, 
        				user_nm, user_eml, email_no_02, office_cd);
        	}
        	
        	if(email_no_03!=null && !email_no_03.equals("")){

         		sendMail(sys_cd, app_cd, "N", email_title, email_contents, email_param, 
        				user_nm, user_eml, email_no_03, office_cd);
        	}

		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
    }	
	
	/**
	 * Mail을  전송한다.
	 * @param sys_cd
	 * @param app_cd
	 * @param batch_ind
	 * @param title
	 * @param param
	 * @param email_contents
	 * @param rcv_email
	 * @param office_cd
	 * @throws DAOException
	 * @throws MailerAppException
	 */
	private void sendMail(String sys_cd, String app_cd, String batch_ind,
			String title, String email_contents, String param,
			String sctrl_user_id, String sctrl_user_eml, String rcv_email,  String office_cd)
		throws DAOException, MailerAppException {
		Mail mail = new Mail();
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
		comRptDsgnXptInfoVO.setRdTmpltNm(app_cd);
		comRptDsgnXptInfoVO.setRdApplCd(sys_cd);
		comRptDsgnXptInfoVO.setRdParaCtnt(param);
		comRptDsgnXptInfoVO.setXptFileNm("Confirm MSG.pdf");
		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
		comRptDsgnXptInfoVO.setCreUsrId(sctrl_user_id);
		comRptDsgnXptInfoVO.setUpdUsrId(sctrl_user_id);
		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
		
		mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
		mail.setBatFlg(batch_ind);
		mail.setRdSubSysCd(sys_cd);		
		mail.setSubject(title);
		mail.setTextContent(email_contents);
//		mail.setRecipient(model.getRltTrkrEml());
		mail.setRecipient(rcv_email); //로컬후 주석 해제
//		mail.setRecipient("mantakorea@cyberlogitec.com"); // 테스트용
//		mail.setFrom(rcv_email, model.getRltTrkrNm());
		mail.setFrom(sctrl_user_eml, sctrl_user_id);
		mail.send();
	}	
}
