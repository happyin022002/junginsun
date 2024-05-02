/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404EDIStatusInquiryEAIDAO.java
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-28 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0028Event 참조
 * @since J2EE 1.4
 */
public class USA404EDIStatusInquiryEAIDAO extends EAIDAOSupport{
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send FAX
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void faxEdiSend(EsdTrs0028Event event) throws EventException {
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
		String sys_cd        = "TRS";
		String app_cd        = "ESD_TRS_0927.mrd";
		String batch_ind     = "N";
		String title         = "SM LINE";
		String param         = "";
		String rcv_info      = "";
		String sctrl_ofc_cd  = event.getCtrlOfcCd();
		String sctrl_user_id = event.getUserId();		

		try {
			Multi01USA404EDIStatusInquiryVO[] models = event.getConfirmationMsgSendVos();
			Multi01USA404EDIStatusInquiryVO   model  = null;
			if( models != null ){
				for( int i=0; i<models.length; i++ ){
					model = models[i];
					if (model.getIbflag().equals("I")) {
						param = "["+model.getTrspSoOfcCtyCd()+"]["+model.getTrspSoSeq()+"]["+sctrl_ofc_cd+"]";
						if( model.getRltTrkrFaxNo() != null && !model.getRltTrkrFaxNo().equals("") ) {
							
							FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info+";"+model.getRltTrkrFaxNo(), sctrl_ofc_cd, sctrl_user_id);
							FaxUtility.registerDB(info);
						}
						if( model.getShprFaxNo() != null && !model.getShprFaxNo().equals("") ) {
							FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info+";"+model.getShprFaxNo(), sctrl_ofc_cd, sctrl_user_id);
							FaxUtility.registerDB(info);
						}
					}
				}
			}

        } catch (ServerExportException de) {
        	log.error("err " + de.toString(), de);
        	throw de;
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
    }
	
	/**
	 * 404EDI Send 부분
	 * 
	 * @param sendMessage
	 * @throws DAOException
	 */
	public void return404EDIsent(String sendMessage) throws DAOException {
		// Localhost Test
		String target 		= SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.URL"			);
		String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.TRANSFERTYPE");
		String channel 		= SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.CHANNEL"		);
		String factory 		= SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.FACTORY"		);
		String queue 		= SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.QUEUE"		);
		String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404.IBMMQ.TARGETCLIENT");

        // 2007. 05. 01. Hyunsu modified
		TransferEAI eai = null;

		try {
	        // 2007. 05. 01. Hyunsu modified
			eai = new IBMSendQClient(target, this.getClass());

	        // 2007. 05. 01. Hyunsu modified
			// eai.setIntegrationID("1208"); //EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.

			eai.setTransferType	(transfertype	);
			eai.setChannel		(channel		);
			eai.setFactory		(factory		);
			eai.setQueue		(queue			);
			eai.setTargetClient	(targetclient	);
			eai.setMessage		(sendMessage	);

			log.info("\n\nreturn404EDIsent("+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date())+") sendMessage start... \n"+sendMessage+"\nthe end ("+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date())+")\n");

			eai.commit("TRS404"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())); //EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.
		} catch (EAIException e) {
	        // 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("EAI Exception !").getMessage(), e);
		} catch (Exception e) {
	        // 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
        // 2007. 05. 01. Hyunsu modified
		eai.close();
	}
	
	/**
	 * 404EDI Send 부분
	 * 
	 * @param sendMessage
	 * @throws DAOException
	 */
	public void cancelReturn4040EDIsend(String sendMessage) throws DAOException {
		String target = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_USA404CN.IBMMQ.TARGETCLIENT");

        // 2007. 05. 01. Hyunsu modified
		TransferEAI eai = null;

		try {
			// 2007. 05. 01. Hyunsu modified
			eai = new IBMSendQClient(target, this.getClass());
			// 2007. 05. 01. Hyunsu modified
			// eai.setIntegrationID("1208"); //EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.

			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(sendMessage);
			
			log.info("\n\ncancelReturn4040EDIsend("+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date())+") sendMessage start... \n"+sendMessage+"\n the end ("+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date())+")\n");
			
			// 2007. 05. 01. Hyunsu modified
			eai.commit("TRS998"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())); //EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.

		} catch (EAIException e) {
	        // 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("EAI Exception !").getMessage(), e);
		} catch (Exception e) {
	        // 2007. 05. 01. Hyunsu modified
			eai.rollback(e);

			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}		
        // 2007. 05. 01. Hyunsu modified
		eai.close();
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send E-mail
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void emailEdiSend(EsdTrs0028Event event) throws EventException {
		String sys_cd         = "TRS";
		String app_cd         = "ESD_TRS_0927.mrd";
		String batch_ind      = "N";
		String title          = "SM LINE";
		String param          = "";
		String email_contents = "SM LINE";
		String rcv_email      = "railbilling@us.smlines.com";
		
		String sctrl_ofc_cd  = event.getCtrlOfcCd();
		String sctrl_user_id = event.getUserId();
		
		try {
			Multi01USA404EDIStatusInquiryVO[] models = event.getConfirmationMsgSendVos();
			Multi01USA404EDIStatusInquiryVO   model  = null;
			
			if( models != null ){
				for( int i=0; i<models.length; i++ ){
					model = models[i];
					if (model.getIbflag().equals("I")) {
						param = "["+model.getTrspSoOfcCtyCd()+"]["+model.getTrspSoSeq()+"]["+sctrl_ofc_cd+"]";
						if( model.getRltTrkrEml()!= null && !model.getRltTrkrEml().equals("") ) {							
							sendMail(sys_cd, app_cd, batch_ind, title, param, email_contents, rcv_email, sctrl_user_id, model);
						}
						if( model.getShprEml() != null && !model.getShprEml().equals("") ) {
							sendMail(sys_cd, app_cd, batch_ind, title, param, email_contents, rcv_email, sctrl_user_id, model);
						}
					}
				}
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
	 * @param model
	 * @throws DAOException
	 * @throws MailerAppException
	 */
	private void sendMail(String sys_cd, String app_cd, String batch_ind,
			String title, String param, String email_contents,
			String rcv_email, String sctrl_user_id, Multi01USA404EDIStatusInquiryVO model)
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
		mail.setRecipient(model.getRltTrkrEml());
		mail.setFrom(rcv_email, model.getRltTrkrNm());
		mail.send();
	}
}
