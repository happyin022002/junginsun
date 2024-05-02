/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DODIOInvoiceEAIDAO.java
*@FileTitle : SEND EMAIL/FAX
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  김종옥
*@LastVersion : 1.0
* 2009.04.29  김종옥
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic.DODInvoiceMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvEmailFaxVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SendFlatFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * ALPS DODInvoiceIssueEAIDAO <br>
 * - DODInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 김종옥
 * @see DODInvoiceMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class DODInvoiceIssueEAIDAO extends EAIDAOSupport {

	/**
	 * Issue 메일을 발송합니다<br>
	 * 
	 * @param DODInvEmailFaxVO dODInvEmailFaxVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendKORDodInvoiceByFaxEmail(DODInvEmailFaxVO dODInvEmailFaxVO, SignOnUserAccount account) throws MailerAppException, EAIException, EventException {
		String sendFlag = dODInvEmailFaxVO.getSendFlg();


		String file_nm = "SM Line Corporation DROP-OFF CHARGE INVOICE("+dODInvEmailFaxVO.getDodInvNo()+").pdf";
		String subject = "SM Line Corporation DROP-OFF CHARGE INVOICE("+dODInvEmailFaxVO.getDodInvNo()+")";
	
		String contents = "안녕하세요. SM 상선㈜ 입니다."		 		
         + "<br>귀하께서 요청하신 DROP-OFF CHARGE INVOICE("+dODInvEmailFaxVO.getDodInvNo()+")에 대한 INVOICE가 발행되었습니다." 
         + "<br>첨부 확인 해 주시기 바랍니다."
         + "<br>확인 후 이상이 있으면 아래 담당자에게 문의하시기 바랍니다."
         + "<br>"
         + "<br>담당자 : "+account.getUsr_locl_nm()+"("+account.getXtn_phn_no()+")";  

	
		// Email 발송
		Mail mail = new Mail();
		if (sendFlag.equals("E")) {			
			
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();

			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
			comRptDsgnXptInfoVO.setXptFileNm(file_nm);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setRdTmpltNm(dODInvEmailFaxVO.getRdName());
			comRptDsgnXptInfoVO.setRdParaCtnt(dODInvEmailFaxVO.getRdParm());
			comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
			
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			
			try {
				
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
				mail.setRecipient(dODInvEmailFaxVO.getCntcPntEml());
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				mail.setRdSubSysCd("EAS");
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				return mail.send();
			} catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
			} catch (Exception e) {
				throw new EventException(e.getMessage(), e);
			}
		}
		// Fax 발송	
		else {
			try {
				FaxMetaInfo info = new FaxMetaInfo("EAS",     // 모듈명(ex.BKG)
								           dODInvEmailFaxVO.getRdName(),   // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           "N",  // 배치 유무(Y/N)
								           subject,     // 제목
								           dODInvEmailFaxVO.getRdParm(), // RD Parameter (ex. [419][1][selho])
								           ""+";"+dODInvEmailFaxVO.getCntcPntFaxNo(), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)  한글이 들어간 경우 전송시 에러 발생함.
								           account.getOfc_cd(),    // 지역 FAX office
									       //account.getUsr_nm()  // 보내는 사람
								           account.getUsr_id()
									       );
				return FaxUtility.registerDB(info);
			} catch (Exception ex){
				throw new EAIException(ex.getMessage(), ex);
			}			
		}	
	}
	
	
	/**
	 * Invoice Inquiry - Update Send Fax/Email <br>
	 * 
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @param String sendFlag
	 * @throws DAOException 
	 */
	public void updateFaxEmail(DODInvoiceMainVO dodInvoiceMainVO, String sendFlag) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(dodInvoiceMainVO != null){
				Map<String, String> mapVO = dodInvoiceMainVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("send_flg", sendFlag);
				velParam.put("send_flg", sendFlag);
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOUpdateFaxEmailUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EDI Transmit 공통 함수<br>
	 * @param SendFlatFileVO sendFlatFileVO
	 * @return FlatFileAckVO
	 * @throws Exception
	 */
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO) throws Exception {
		  String reString = "";
		  String integrationId = "EAS" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		  /* System properties : classpath/properties/subsystem-config.properties */
		  String target = SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.URL");
		  String transfertype = SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.TRANSFERTYPE");
		  String channel = SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.CHANNEL");
		  String factory = SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.FACTORY");
		  String queue = sendFlatFileVO.getQueueNm();//SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.QUEUE");
		  String targetclient = SubSystemConfigFactory.get("EAS.EAS_EDI_IBMMQ.TARGETCLIENT");
		  
		  TransferEAI eai = new IBMSendQClient(target, this.getClass());

		  eai.setTransferType(transfertype);
		  eai.setChannel(channel);
		  eai.setFactory(factory);
		  eai.setQueue(queue);
		  //eai.setQueue("ALPSBKG_T_NACCS_EDI_SEANACCS");
		  eai.setTargetClient(targetclient);
		  //eai.setMessage("hello!!!");
		  eai.setMessage(sendFlatFileVO.getFlatFile());

		  //  eai.setObj(doc);
		  //  eai.setObj(doc);
		  
		  FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		  flatFileAckVO.setSendId(integrationId); 

		  try {
		   reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른

		   log.info("======================================");
		   log.info("reString : " + reString);
		   log.info("======================================");   
		   if ( reString.equals("SUCCESS") )
		    flatFileAckVO.setAckStsCd("A");
		   else
		    flatFileAckVO.setAckStsCd("E");
		        } catch (Exception ea) {
		         eai.rollback(ea);
		   log.error(ea.getMessage(), ea);
		   throw new EventException(new ErrorHandler("EAS00080",new String[]{}).getMessage());
		        }
		  eai.close();
		  return flatFileAckVO;
	}	
	
}
