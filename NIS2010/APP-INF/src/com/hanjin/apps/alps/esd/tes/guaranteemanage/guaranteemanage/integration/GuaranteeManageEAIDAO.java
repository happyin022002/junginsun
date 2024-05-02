/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageEAIDAO.java
*@FileTitle : Guarantee EAIDAO (Mail, FAX Send)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.17 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.framework.component.exception.CheckUtilsException;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;


/**
 * ALPS GuaranteeManageEAIDAO <br>
 * - ALPS-GuaranteeManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see GuaranteeManageBCImpl 참조
 * @since J2EE 1.6
 */
public class GuaranteeManageEAIDAO extends DBDAOSupport {

	
	/**
	 * ESD_TES_2003 Guarantee RD eMail Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception MailerAppException
	 * @exception DAOException
	 * @exception SQLException
	 * @exception CheckUtilsException
	 * @exception IOException
	 */
	public void sendEmail(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws MailerAppException, DAOException, SQLException, CheckUtilsException, IOException
	{
		Mail						mail					= null; 
		ComRptDsgnXptInfoVO			comRptDsgnXptInfoVO		= null;
		List<ComRptDsgnXptInfoVO>	comRptDsgnXptInfoVOs	= new ArrayList<ComRptDsgnXptInfoVO>();
		
		
        // 1. FaxMetaInfo를 생성한다.
        //    <Parameter>
        //    1) sysCd : 시스템 코드 (TPB, TRS 등)
        //    2) appCd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
        //    3) batchInd : Batch 업무 유무 (Y/N)
        //    4) emailTitle : E-mail 제목
        //    5) EmailContents : E-mail 내용
		//    6) param : Report 생성시 필요한 Parameter
        //    7) sendName : sender name
        //    8) sendEmail : sender email
		//    9) recvEmail : receiver email
		//    10) crtUser : creater
		
    	String sysCd		= commonVO.getSysCd();
    	String appCd		= commonVO.getAppCd();
    	String batchInd		= commonVO.getBatchInd();
    	String title 		= commonVO.getEmailTitle();
    	String contents		= commonVO.getEmailContents();
    	String param		= commonVO.getParam();
    	String sendName		= account.getUsr_nm();
    	String sendEmail	= account.getUsr_eml();
    	String crtUser		= account.getUsr_id();
    	
    	mail	= new Mail();
    	mail.setRdSubSysCd	(sysCd);
    	mail.setBatFlg		(batchInd);
    	mail.setSubject		(title);
    	mail.setTextContent	(contents);
		mail.setFrom		(sendEmail, sendName);
		mail.setRecipient	(commonVO.getEmailAddr());

		comRptDsgnXptInfoVO	= new ComRptDsgnXptInfoVO();
		comRptDsgnXptInfoVO.setRdTmpltNm	(appCd);
		comRptDsgnXptInfoVO.setXptFileNm	(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TES.pdf");
		comRptDsgnXptInfoVO.setRdParaCtnt	(param);
		comRptDsgnXptInfoVO.setCreUsrId		(crtUser);
		comRptDsgnXptInfoVO.setUpdUsrId		(crtUser);
		comRptDsgnXptInfoVO.setXptFileTpCd	(ExportInfo.FTYPE_PDF);	
		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);

		mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
		
		mail.send();
	}
	
	/**
	 * ESD_TES_2003 Guarantee RD FAX Send.<br>
	 * 
	 * @param commonVO GuaranteeCommonVO
	 * @param account SignOnUserAccount
	 * @exception FaxSendException
	 */
	public void sendFax(GuaranteeCommonVO commonVO, SignOnUserAccount account) throws FaxSendException
	{

		String[] sendCds = null;
		try{

			String[] arrFaxNum = null;
			if( commonVO.getFaxNum() != null && !"".equals(commonVO.getFaxNum()) ) arrFaxNum = commonVO.getFaxNum().split(";");
			
			// 1. FaxMetaInfo를 생성한다.
			//    <Parameter>
			//    1) sysCd : 시스템 코드 (TPB, TRS 등)
			//    2) appCd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
			//    3) batchInd : Batch 업무 유무 (Y/N)
			//    4) title : FAX 제목
			//    5) param : Report 생성시 필요한 Parameter
			//    6) rcvInfo : 수신자 정보
			//    7) office : 사용자의 Office 코드
			
			String sysCd	= commonVO.getSysCd();
			String appCd	= commonVO.getAppCd();
			String batchInd = commonVO.getBatchInd();
			String title	= commonVO.getFaxTitle();
			String param	= commonVO.getParam();
			String rcvInfo	= commonVO.getRcvInfo();
			String officeCd	= account.getOfc_cd();
			String usrId	= account.getUsr_id();
			
			sendCds = new String[arrFaxNum.length];
			for(int i=0; i<arrFaxNum.length; i++){
        		String faxNo = getOnlyNumber(arrFaxNum[i]);
        		FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, param, rcvInfo+";"+faxNo, officeCd, usrId);
        		// 2. FaxUtility를 이용하여, Database 에 Data 를 입력한다.
        		sendCds[i]=FaxUtility.registerDB(info);
        		log.debug("at Send Fax... faxNo["+i+"] "+faxNo+", sendCds["+i+"] "+sendCds[i]);
			}
			
			// 3. FAX 발송
	    	FaxUtility.send(sendCds);	
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new FaxSendException(ex.getMessage());
		}
	}
	
	
	/**
	 * Number 만 가져오기.<br>
	 * FAX Number 로 가져온 String 값중 INT 에 해당되는 값만 가져오기.<br>
	 * 
	 * @param src String
	 * @return String
	 */
	private String getOnlyNumber(String src){
		StringBuffer returnStr = null;
		int valueInt = 0;
		String src_temp = null;
		if (src == null || src.length() == 0){
			returnStr = null;
		}else{
			returnStr = new StringBuffer();
			for(int i=0; i<src.length(); i++){
				src_temp = src.substring(i, i+1);
				valueInt = src_temp.getBytes()[0];
				if( valueInt>=48 && valueInt <= 57){
					returnStr.append(src_temp);
				}
			}
		}
		
		return returnStr.toString();
	}
}