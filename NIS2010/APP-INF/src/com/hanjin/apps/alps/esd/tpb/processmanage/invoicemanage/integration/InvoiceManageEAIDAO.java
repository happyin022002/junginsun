/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageEAIDAO.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.0
* 2009.07.17 Sun, CHOI
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TPBRDFaxMailEAIVO;
import com.hanjin.framework.component.exception.CheckUtilsException;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailGroup;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.vo.MailGroupResultVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;


/**
 * ALPS InvoiceManageEAIDAO <br>
 * - ALPS-InvoiceManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see InvoiceManage 참조
 * @since J2EE 1.6
 */
public class InvoiceManageEAIDAO extends DBDAOSupport {

	/**
	 * This method sends RD FAXs
	 *
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @throws FaxSendException
	 */
	public String rdFaxSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws FaxSendException {
		try {
			FaxMetaInfo faxMetaInfo =
				new FaxMetaInfo(rdFaxMailEAIVO.getSubSysCd(),
								rdFaxMailEAIVO.getTmplMrd(),
								"N",
								rdFaxMailEAIVO.getTitle(),
								rdFaxMailEAIVO.getTmplParam(),
								rdFaxMailEAIVO.getReceiverFax(),
								rdFaxMailEAIVO.getSenderUsrOfc(),	
								rdFaxMailEAIVO.getSenderUsrId());

			String faxNo = FaxUtility.registerDB(faxMetaInfo);
			FaxUtility.send(faxNo);
			return faxNo;
		} catch (FaxSendException e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		}
	}
	
//	/**
//	 * This method sends RD Mails
//	 *
//	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
//	 * @return String
//	 * @throws RDMailSendException
//	 */
//	public String rdMailSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws RDMailSendException {
//		try {
////			public RDMailMetaInfo(  sys_cd,
////									tmplMrd,
////									batch_ind,
////									title,
////									content,
////									param,
////									sender_nm,
////									sender_email,
////									receiver_email,
////									crt_user);
//			RDMailMetaInfo rdMailMetaInfo =
//				new RDMailMetaInfo( rdFaxMailEAIVO.getSubSysCd(),
//									rdFaxMailEAIVO.getTmplMrd(),
//									"N",
//									rdFaxMailEAIVO.getTitle(),
//									rdFaxMailEAIVO.getContent(),
//									rdFaxMailEAIVO.getTmplParam(),
//									rdFaxMailEAIVO.getSenderUsrNm(),	
//									rdFaxMailEAIVO.getSenderUsrEml(),
//									rdFaxMailEAIVO.getReceiverEml(),	
//									rdFaxMailEAIVO.getSenderUsrId());
//
//			return RDMailUtility.registerDB(rdMailMetaInfo);
//
//		} catch (RDMailSendException e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		} catch (Exception e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		}
//	}
		
//	/**
//	 * This method sends RD Mails
//	 *
//	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
//	 * @return String
//	 * @throws RDMailSendException
//	 */
//	public String rdMailSend1(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws RDMailSendException {
//		
//		Mail						mail					= null; 
//		ComRptDsgnXptInfoVO			comRptDsgnXptInfoVO		= null;
//		List<ComRptDsgnXptInfoVO>	comRptDsgnXptInfoVOs	= new ArrayList<ComRptDsgnXptInfoVO>();
//		
//		try {
//	    	mail	= new Mail();
//	    	mail.setRdSubSysCd	(rdFaxMailEAIVO.getSubSysCd());
//	    	mail.setBatFlg		("N");
//	    	mail.setSubject		(rdFaxMailEAIVO.getTitle());
//	    	mail.setTextContent	(rdFaxMailEAIVO.getContent());
//    		mail.setFrom		(rdFaxMailEAIVO.getSenderUsrEml(), rdFaxMailEAIVO.getSenderUsrNm());
//    		mail.setRecipient	(rdFaxMailEAIVO.getReceiverEml());
//
//    		comRptDsgnXptInfoVO	= new ComRptDsgnXptInfoVO();
//    		comRptDsgnXptInfoVO.setRdTmpltNm	(rdFaxMailEAIVO.getTmplParam());
//    		comRptDsgnXptInfoVO.setXptFileNm	(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TPB.pdf");
//    		comRptDsgnXptInfoVO.setRdParaCtnt	(rdFaxMailEAIVO.getTmplParam());
//    		comRptDsgnXptInfoVO.setCreUsrId		(rdFaxMailEAIVO.getSenderUsrId());
//			comRptDsgnXptInfoVO.setUpdUsrId		(rdFaxMailEAIVO.getSenderUsrId());
//    		comRptDsgnXptInfoVO.setXptFileTpCd	(ExportInfo.FTYPE_PDF);	
//    		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
//
//    		mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
//    		mail.send();
//		} catch (Exception e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		}
//		return null;
//	}
	
	/**
	 * This method sends RD Mails
	 *
	 * @param TPBRDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @throws MailerAppException
	 * @throws DAOException
	 * @throws CheckUtilsException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public String rdMailSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws MailerAppException, DAOException, CheckUtilsException {
		
		try {
			//mail1 start
			List<List<MailGroupResultVO>> groupMailKeys = null;
			String snd_no = null;
			Mail mail = new Mail();
			mail.setFrom(rdFaxMailEAIVO.getSenderUsrEml());
			mail.setSubject(rdFaxMailEAIVO.getTitle()); 
			mail.setRecipient(rdFaxMailEAIVO.getReceiverEml());
			mail.setTextContent(rdFaxMailEAIVO.getContent());
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVO.setCreUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVO.setUpdUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVO.setRdTmpltNm(rdFaxMailEAIVO.getTmplMrd());
			comRptDsgnXptInfoVO.setRdParaCtnt(rdFaxMailEAIVO.getTmplParam());
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setXptFileNm(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TPB.pdf");
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			
			TemplateMail template = new TemplateMail();
			template.setFrom(rdFaxMailEAIVO.getSenderUsrEml());
			template.setSubject(rdFaxMailEAIVO.getTitle()); 
			template.setRecipient(rdFaxMailEAIVO.getReceiverEml());
	
			template.setTextContent(rdFaxMailEAIVO.getContent());
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOss = new ArrayList<ComRptDsgnXptInfoVO>();
			
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVOa = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVOa.setCreUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVOa.setUpdUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVOa.setRdTmpltNm(rdFaxMailEAIVO.getTmplMrd());
			comRptDsgnXptInfoVOa.setRdParaCtnt(rdFaxMailEAIVO.getTmplParam());
			comRptDsgnXptInfoVOa.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVOa.setXptFileNm(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TPB.pdf");
			comRptDsgnXptInfoVOss.add(comRptDsgnXptInfoVOa);
	
			template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOss);
	
			MailGroup mailGroup = new MailGroup();
			mailGroup.addMail(template);
			mailGroup.addMail(mail);
			
			mailGroup.setEmlCtnt(new StringBuilder("Mail Body Hello"));
			mailGroup.setFrom(rdFaxMailEAIVO.getSenderUsrEml());
			mailGroup.setSubject(rdFaxMailEAIVO.getTitle());
			groupMailKeys = mailGroup.sendMailGroupSplit(750000);
			
			snd_no = groupMailKeys.get(0).get(0).getEmlSndNo();
			//log.debug("Email==============="+snd_no);
		  return snd_no;
		} catch (MailerAppException ex){
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		} catch (DAOException ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch (CheckUtilsException ex){
			log.error(ex.getMessage(), ex);
			throw new CheckUtilsException(new ErrorHandler(ex).getMessage());
		}
	}
}