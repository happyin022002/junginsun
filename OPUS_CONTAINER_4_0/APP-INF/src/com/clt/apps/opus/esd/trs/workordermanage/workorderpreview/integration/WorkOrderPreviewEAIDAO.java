/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderPreviewEAIDAO.java
 *@FileTitle : W/O 발행화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-06
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0
 * 2006-12-06 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.framework.utility.CheckUtilities;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * ESD-workordermanage에 대한 EAI 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderPreviewBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderPreviewEAIDAO extends EAIDAOSupport {
	/**
	 * WorkOrder Send FAX
	 * 
	 * @param e
	 * @param userId
	 * @param workOrderNo
	 * @throws EventException
	 */
	public void sendEaiFax(Event e, String userId, String workOrderNo) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		try {

			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			String sysCd = woVO.getFaxSysCd();
			String appCd = woVO.getFaxAppCd();
			String batchInd = woVO.getFaxBatchInd();
			String title = "Work Order(WO#: " + workOrderNo + ")";
			String faxParam = woVO.getFaxParam();
			String rcvInfo = woVO.getFaxRcvInfo();
			String officeCd = event.getFormUsrOfcCd();

			String faxNo01 = woVO.getWoN1stFaxNo();
			String faxNo02 = woVO.getWoN2ndFaxNo();
			String faxNo03 = woVO.getWoN3rdFaxNo();

			if (faxNo01 != null && !faxNo01.equals("")) {
				faxNo01 = getOnlyNumber(faxNo01);
				FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo + ";" + faxNo01, officeCd, userId);
				FaxUtility.registerDB(info);
				woVO.setFaxNo01(info.getSndNo());
			}

			if (faxNo02 != null && !faxNo02.equals("")) {
				faxNo02 = getOnlyNumber(faxNo02);
				FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo + ";" + faxNo02, officeCd, userId);
				FaxUtility.registerDB(info);
				woVO.setFaxNo02(info.getSndNo());
			}

			if (faxNo03 != null && !faxNo03.equals("")) {
				faxNo03 = getOnlyNumber(faxNo03);
				FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, rcvInfo + ";" + faxNo03, officeCd, userId);
				FaxUtility.registerDB(info);
				woVO.setFaxNo03(info.getSndNo());
			}
			event.setWorkOrderPreviewVO(woVO);
		} catch (ServerExportException se) {
			log.error(se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Flat File을 전송한다. <br>
	 * EDI에 Flat파일을 전송한다.<br>
	 * 
	 * @param flatFile
	 * @return String
	 * @exception EventException
	 */
	public String sendFlatMessage(String flatFile) throws EventException {
		String resultStr = null;
		TransferEAI eai = null;
		try {
			String url = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.URL");
			String intergrationID = "1209";
			String transfertype = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.QUEUE");
			String targetclient = SubSystemConfigFactory.get("TRS.TRS_EDI_WO.IBMMQ.TARGETCLIENT");

			eai = new IBMSendQClient(url, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);

			resultStr = eai.commit(intergrationID);
		} catch (EAIException eaie) {
			eai.rollback(eaie);

			log.error("err " + eaie.toString(), eaie);
			throw new EventException(eaie.getMessage());
		}
		eai.close();

		return resultStr;
	}

	/**
	 * number만 가져오기<br>
	 * fax number로 가져온 String값중 int에 해당되는 값만 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private String getOnlyNumber(String src) {
		StringBuffer returnStr = null;
		int valueInt = 0;
		String src_temp = null;
		if (src != null) {
			returnStr = new StringBuffer();
			for (int i = 0; i < src.length(); i++) {
				src_temp = src.substring(i, i + 1);
				valueInt = src_temp.getBytes()[0];
				if (valueInt >= 48 && valueInt <= 57) {
					returnStr.append(src_temp);
				}
			}
		}
		return returnStr == null ? null : returnStr.toString();
	}

	/**
	 * W/O Email Send
	 * 
	 * @param e
	 * @param wonoRowSet
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List emailSend(Event e, DBRowSet wonoRowSet) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		List<Mail> arrWoMail = new ArrayList<Mail>();
		Mail woMail = null;
		int i = 0;
		try {
			WorkOrderPreviewVO woVO = event.getWorkOrderPreviewVO();
			String sysCd = woVO.getFaxSysCd();
			String emailTitle = woVO.getEmailTitle();
			String emailContents = woVO.getEmailContents();
			String userId = event.getSignOnUserAccount().getUsr_id();
			String userEml = "shipment.info@notifications.nykline.com";
			String userBCCeml = "shipinfobcc@na.nykline.com";

			if (wonoRowSet != null && wonoRowSet.next()) {
				emailTitle += " \'W/O#" + wonoRowSet.getString("trsp_wo_ofc_cty_cd") + wonoRowSet.getString("trsp_wo_seq") + "\'";
			}
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = null;
			comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVO.setRdTmpltNm(woVO.getFaxAppCd());
			comRptDsgnXptInfoVO.setRdApplCd(sysCd);
			comRptDsgnXptInfoVO.setRdParaCtnt(woVO.getFaxParam());
			comRptDsgnXptInfoVO.setXptFileNm("Confirm MSG.pdf");
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setCreUsrId(userId);
			comRptDsgnXptInfoVO.setUpdUsrId(userId);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);

			if (!CheckUtilities.isInBlank(woVO.getWoN1stEml())) {
				woMail = new Mail();
				woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				woMail.setRdSubSysCd(sysCd);
				woMail.setSubject(emailTitle);
				woMail.setTextContent(emailContents);
				woMail.setRecipient(woVO.getWoN1stEml());
				woMail.setBccRcvrEml(userBCCeml);
				woMail.setFrom(userEml);
				arrWoMail.add(i, woMail);
				woVO.setEmlNo01(woMail.send());
				++i;
			}

			if (!CheckUtilities.isInBlank(woVO.getWoN2ndEml())) {
				woMail = new Mail();
				woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				woMail.setRdSubSysCd(sysCd);
				woMail.setSubject(emailTitle);
				woMail.setTextContent(emailContents);
				woMail.setRecipient(woVO.getWoN2ndEml());
				woMail.setBccRcvrEml(userBCCeml);
				woMail.setFrom(userEml);
				arrWoMail.add(i, woMail);
				woVO.setEmlNo02(woMail.send());
				++i;
			}

			if (!CheckUtilities.isInBlank(woVO.getWoN3rdEml())) {
				woMail = new Mail();
				woMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				woMail.setRdSubSysCd(sysCd);
				woMail.setSubject(emailTitle);
				woMail.setTextContent(emailContents);
				woMail.setRecipient(woVO.getWoN3rdEml());
				woMail.setBccRcvrEml(userBCCeml);
				woMail.setFrom(userEml);
				arrWoMail.add(i, woMail);
				woVO.setEmlNo03(woMail.send());
			}
			event.setWorkOrderPreviewVO(woVO);
		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return arrWoMail;
	}
}