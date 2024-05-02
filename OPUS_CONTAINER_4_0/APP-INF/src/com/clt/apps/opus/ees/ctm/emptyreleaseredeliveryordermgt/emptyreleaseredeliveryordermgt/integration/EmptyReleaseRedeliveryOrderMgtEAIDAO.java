/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtRDMailBCImpl.java
*@FileTitle : EmptyReleaseRedeliveryOrderMgtRDMailBCImpl
*Open Issues :
*Change history : 2009.10.22
*@LastModifyDate : 2009.10.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.10.22 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * OPUS EmptyReleaseRedeliveryOrderMgtEAIDAO <br>
 * - OPUS-EmptyReleaseRedeliveryOrderMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang Soo
 * @see EmptyReleaseRedeliveryOrderMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtEAIDAO extends EAIDAOSupport{

	/**
	 * This method sends RD FAXs
	 *
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @throws FaxSendException
	 */
	public String rdFaxSend(RDFaxMailEAIVO rdFaxMailEAIVO) throws FaxSendException {
		try {
			FaxMetaInfo faxMetaInfo =
				new FaxMetaInfo(rdFaxMailEAIVO.getSubSysCd(),
								rdFaxMailEAIVO.getTmplMrd(),
								"N",
								rdFaxMailEAIVO.getTitle(),
								rdFaxMailEAIVO.getTmplParam(),
								rdFaxMailEAIVO.getReceiverNm() + ";" + rdFaxMailEAIVO.getReceiverFax(),
								rdFaxMailEAIVO.getSenderUsrOfc(),
								rdFaxMailEAIVO.getSenderUsrId());
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+ faxMetaInfo.getEmlTitNm() + "\n" + faxMetaInfo.getRcvrInfoCtnt());
			return FaxUtility.registerDB(faxMetaInfo);

		} catch (FaxSendException e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * This method sends RD Mails
	 *
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @throws MailerAppException, IOException
	 */
	public String rdMailSend(RDFaxMailEAIVO rdFaxMailEAIVO) throws MailerAppException, IOException {
		try {
			String defaultEml = (rdFaxMailEAIVO.getSenderUsrDefaultEml() == null ? "" : rdFaxMailEAIVO.getSenderUsrDefaultEml().trim());
			String userEml = (rdFaxMailEAIVO.getSenderUsrEml() == null ? "" : rdFaxMailEAIVO.getSenderUsrEml().trim());
			TemplateMail templateMail = new TemplateMail();
			templateMail.setTextContent(rdFaxMailEAIVO.getContent());
			templateMail.setFrom(("".equals(defaultEml) ? userEml : defaultEml), rdFaxMailEAIVO.getSenderUsrNm());
			templateMail.setRdSubSysCd(rdFaxMailEAIVO.getSubSysCd());
			templateMail.setRecipient(rdFaxMailEAIVO.getReceiverEml());
			templateMail.setSubject(rdFaxMailEAIVO.getTitle());
			// User Default Email 값이 있으면 CC에 추가
			templateMail.setCcRcvrEml(("".equals(defaultEml) ? null : defaultEml));
			Collection<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVO.setCreUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVO.setRdTmpltNm(rdFaxMailEAIVO.getTmplMrd());
			comRptDsgnXptInfoVO.setRdParaCtnt(rdFaxMailEAIVO.getTmplParam());
			comRptDsgnXptInfoVO.setXptFileNm(rdFaxMailEAIVO.getTitle().replaceAll(" ", "") + ".pdf");
			comRptDsgnXptInfoVO.setUpdUsrId(rdFaxMailEAIVO.getSenderUsrId());
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);

			templateMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			return templateMail.send();

		} catch (MailerAppException e){
			log.error(e.getMessage(), e);
			throw new MailerAppException(new ErrorHandler(e).getMessage());
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw new MailerAppException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * This method sends EDI
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */
	public String sendEdi(String flatFile) throws Exception {
		String integrationId = "CTM_CTM0426_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		//LIVE
		String target = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("CTM.CTM_T_EDI_T_VENDOR_301.IBMMQ.TARGETCLIENT");
		
		TransferEAI eai = new IBMSendQClient(target, this.getClass()); 
		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(flatFile);

		String reString = "";
		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.debug("\n\n#####################################" +
					 "\nEDI 전송결과 : " + reString +
					 "\n#####################################\n");
		} catch (Exception ex) {
			eai.rollback(ex);
			log.error("\n\n [EAIDAO - sendEdi] EAIException :\n" + ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		} 
		eai.close();
		return reString;
	}	
}
