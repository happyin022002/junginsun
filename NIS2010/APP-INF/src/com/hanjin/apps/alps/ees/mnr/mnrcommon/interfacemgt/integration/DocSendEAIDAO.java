/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocSendEAIDAO.java
*@FileTitle : DocSendEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.06 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.GeneralMailFormVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;


/**
 * alps DocSendEAIDAO <br>
 * - alps-MNRCommon system Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author HyungSeok Ham
 * @see interfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class DocSendEAIDAO extends EAIDAOSupport{

	/**
	 * EDI : UBIZHJS_NIS2010MNR_WESTIM<br>
	 * 견적서에대한 WorkOrder정보를 EDI에 송신 한다.<br>
	 * 
	 * @param DocResultVO docResultVO
	 * @return String
	 * @throws 
	 */ 
	public String sendEDIData(DocResultVO docResultVO) throws Exception {
		TransferEAI eai = null;
		String reString = "";
		try {
			String integrationId = "MNR" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			/* System properties : classpath/properties/subsystem-config.properties */
			String target = SubSystemConfigFactory.get("MNR.IBMMQ.URL");
			String transfertype = SubSystemConfigFactory.get("MNR.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("MNR.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("MNR.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("MNR.ALPMNR_WO_SEND.IBMMQ.QUEUE");  //sendFlatFileVO.getQueueNm();//
			String targetclient = SubSystemConfigFactory.get("MNR.IBMMQ.TARGETCLIENT");
			
			eai = new IBMSendQClient(target, this.getClass());
			
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(docResultVO.getFlatFile());
			
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("======================================");
			log.info("reString : " + reString);
			log.info("======================================");		
			if ( reString.equals("SUCCESS") )
				reString = integrationId;		
			else	
				reString = integrationId;	
				
		} catch (EAIException ea) {					
			eai.rollback(ea);					
			log.error(ea.getMessage(), ea);	 
			throw new DAOException(new ErrorHandler("MNR00001",new String[]{}).getMessage());
		} catch (Exception ea) {			
			eai.rollback(ea);		
			log.error(ea.getMessage(), ea);	 
			throw new DAOException(new ErrorHandler("MNR00001",new String[]{}).getMessage());
		}			
		eai.close();
		return reString;
	}
	
	/**
	 * FaxData 전송합니다.<br>
	 * 
	 * @param DocResultVO docResultVO
	 * @return String
	 * @exception DAOException
	 */
	public String sendFaxData(DocResultVO docResultVO) throws DAOException {
		
		String rdSubSysCd = docResultVO.getRdSubSysCd();
		String tmplMrd = docResultVO.getTmplMrd();
		String batFlg = docResultVO.getBatFlg();
		String docTitNm = docResultVO.getDocTitNm();
		String templateArgs = docResultVO.getTemplateArgs();
		String faxRcvInfo =  docResultVO.getFaxRcvInfo();
		String faxOffice = docResultVO.getFaxOffice();
		String sndrNm = docResultVO.getSndrNm();
		
		String refNo = "";
		
		try {
			FaxMetaInfo faxMetaInfo = new FaxMetaInfo(rdSubSysCd,
					tmplMrd,
					batFlg,
					docTitNm,
					templateArgs,
					faxRcvInfo,
					faxOffice,
					sndrNm);
			refNo =  FaxUtility.registerDB(faxMetaInfo);	
			FaxUtility.send(faxMetaInfo);
	 	}catch(FaxSendException e){
	 		log.error(e.getMessage(),e);  	
	 		throw new DAOException(new ErrorHandler(e).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
		return refNo;
	}


	/**
	 * MailData 전송합니다.<br>
	 * 
	 * @param DocResultVO docResultVO
	 * @return String
	 * @exception DAOException
	 */
	public String sendMailData(DocResultVO docResultVO) throws DAOException {

		String rdSubSysCd = docResultVO.getRdSubSysCd();
		String tmplMrd = docResultVO.getTmplMrd();
		String batFlg = docResultVO.getBatFlg();
		String docTitNm = docResultVO.getDocTitNm();
		String emlCtnt = docResultVO.getEmlCtnt();
		String templateArgs = docResultVO.getTemplateArgs();
		String sndrNm = docResultVO.getSndrNm();
		String sndrEml = docResultVO.getSndrEml();
		String receiverRmail = docResultVO.getReceiverRmail();
		String creUsrId = docResultVO.getCreUsrId();
		
		if(emlCtnt.equals("")){
			emlCtnt = docTitNm;
		}
		
		String refNo = "";
		
		try {
			TemplateMail mail = new TemplateMail();
			mail.setBatFlg(batFlg);
			mail.setTextContent(emlCtnt);
			mail.setFrom(sndrEml, sndrNm);
			mail.setRdSubSysCd(rdSubSysCd);
			mail.setRecipient(receiverRmail);
			mail.setSubject(docTitNm);
			
			Collection<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVO.setCreUsrId(creUsrId);
			comRptDsgnXptInfoVO.setRdTmpltNm(tmplMrd);
			comRptDsgnXptInfoVO.setRdParaCtnt(templateArgs);
			comRptDsgnXptInfoVO.setUpdUsrId(creUsrId);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			refNo = mail.send();
	 	}catch(MailerAppException ex){	
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(DAOException ex){	
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){	
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    
		return refNo;
	}
		
	/**
	 * [Mail]:[DISPOSAL-BIDDING] <br>
	 * html Template 메일 발송합니다.<br>	
	 *	
	 * @param  List<EmailSendInfoVO> emailSendInfoVOS
	 * @throws MailerAppException
	 */
	public void sendHtmlMailData(List<EmailSendInfoVO> emailSendInfoVOS) throws DAOException {
		try {
			for(int i = 0;i < emailSendInfoVOS.size(); i++){
				EmailSendInfoVO emailSendInfoVO = emailSendInfoVOS.get(i);
				TemplateMail mail = new TemplateMail();
				List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
							
				mail.setBccRcvrEml(emailSendInfoVO.getBlindcarboncopy());
				mail.setCcRcvrEml(emailSendInfoVO.getCarboncopy());
				mail.setFrom(emailSendInfoVO.getSender());				//보내는 사람 메일주소
				mail.setSubject(emailSendInfoVO.getSubject());			//메일 제목
				mail.setRecipient(emailSendInfoVO.getRecipient());		//받는 사람 메일주소
				mail.setHtmlContent(emailSendInfoVO.getTextContent());		//메일 본문내용
				
				//Mail Attach	
				if(emailSendInfoVO.getFilekey() != null &&
				   !"".equalsIgnoreCase(emailSendInfoVO.getFilekey()) &&
				   !emailSendInfoVO.getFilekey().equalsIgnoreCase("null")) {
	
					String[] fileKeys = emailSendInfoVO.getFilekey().split(";");
					for(String fileKey:fileKeys){
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						list.add(attachedFile);					
						mail.setAttachedFile(list);			
					}			
				}		
					
				//Template 설정.
				if(emailSendInfoVO.getTemplate() != null && !"".equals(emailSendInfoVO.getTemplate())){
					mail.setHtmlTemplate(emailSendInfoVO.getTemplate());
						
					//Set Arguments
					String argument = emailSendInfoVO.getArgument();
					String[] argumentTemplates = argument.split(",");
					for(String argumentTemplate:argumentTemplates){
						String[] argumentSet = argumentTemplate.split(";");
						if(argumentSet.length != 2){
							throw new IllegalArgumentException();
						}	
						mail.setArg(argumentSet[0], argumentSet[1]);
					}			
				}	
				mail.setGroupwareMail();   
				mail.send();
			}		
		}catch(MailerAppException ex){	
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){		
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
     * [Mail]:[IF_MNR_0001] <br>
	 * GENERAL Mail 전송합니다.<br>
	 *   
	 * @param List<GeneralMailFormVO> generalMailFormVOS
	 * @exception Exception 
	 */ 
	public void sendGeneralMailData(List<GeneralMailFormVO> generalMailFormVOS) throws DAOException  {
		try {
			for(int i = 0;i < generalMailFormVOS.size(); i++){	
				GeneralMailFormVO generalMailFormVO = generalMailFormVOS.get(i);
				//받는사람이있는 메일만 보낸다.		
				if(!generalMailFormVO.getRecipient().equals("") && generalMailFormVO.getRecipient() != null){
					Mail mail = null;	  	  
					mail = new Mail();	 	   
					mail.setFrom(generalMailFormVO.getSender());
					mail.setSubject(generalMailFormVO.getSubject());
					mail.setRecipient(generalMailFormVO.getRecipient());
					mail.setTextContent(generalMailFormVO.getTextcontent()); 
					mail.send();	
				}   	
			}    				
		}catch(MailerAppException ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    

	}	
	
}
