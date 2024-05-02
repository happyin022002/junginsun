/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USARailWoAckManageEAIDAO.java
 *@FileTitle : USARail WO 신고 정보
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-20
 *@LastModifier : Lee Sang-Woo
 *@LastVersion : 1.0
 * 2006-12-20 Lee Sang-Woo
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;
import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.MessageEdiSendInfoVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;

/**
 * USARailWoAckManage에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see USARailWoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USARailWoAckManageEAIDAO extends EAIDAOSupport {
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send FAX
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	public void faxEdiSendConfirm(ArrayList arr_param) throws EventException {
		String sys_cd = "TRS";
		String app_cd = "ESD_TRS_0927.mrd";
		String batch_ind = "N";
		String title = "NYK LINE";
		String param = "";
		String rcv_info = "";

		MessageEdiSendInfoVO hu01_eventResponse = null;

		try {
			for (int p = 0; p < arr_param.size(); p++) {
				hu01_eventResponse = (MessageEdiSendInfoVO) arr_param.get(p);
				param = "[" + hu01_eventResponse.getTrspSoOfcCtyCd() + "][" + hu01_eventResponse.getTrspSoSeq() + "][" + hu01_eventResponse.getOfcCd() + "]";

				if (hu01_eventResponse.getProvCfmMzdCd() != null && (hu01_eventResponse.getProvCfmMzdCd().equals("2") || hu01_eventResponse.getProvCfmMzdCd().equals("3"))) {
					if (hu01_eventResponse.getProvFaxNo() != null && !hu01_eventResponse.getProvFaxNo().trim().equals("")) {
						FaxMetaInfo info = new FaxMetaInfo(sys_cd, app_cd, batch_ind, title, param, rcv_info + ";" + hu01_eventResponse.getProvFaxNo().replaceAll("-", "").replaceAll(" ", "").trim(), hu01_eventResponse.getOfcCd(), hu01_eventResponse.getCreUsrId());
						FaxUtility.registerDB(info);
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
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send E-mail
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	public void emailEdiSendConfirm(ArrayList arr_param) throws EventException {
		String sys_cd = "TRS";
		String app_cd = "ESD_TRS_0927.mrd";
		String batch_ind = "N";
		String title = "NYK LINE";
		String param = "";
		String email_contents = "NYK LINE";

		MessageEdiSendInfoVO hu01_eventResponse = null;
		boolean bsend = false;
		try {
			for (int p = 0; p < arr_param.size(); p++) {
				hu01_eventResponse = (MessageEdiSendInfoVO) arr_param.get(p);
				param = "[" + hu01_eventResponse.getTrspSoOfcCtyCd() + "][" + hu01_eventResponse.getTrspSoSeq() + "][" + hu01_eventResponse.getOfcCd() + "]";
				if (hu01_eventResponse.getProvCfmMzdCd() != null && (hu01_eventResponse.getProvCfmMzdCd().equals("1") || hu01_eventResponse.getProvCfmMzdCd().equals("3"))) {
					bsend = true;
				}
				if (bsend) {
					if (hu01_eventResponse.getProvEml() != null && !hu01_eventResponse.getProvEml().trim().equals("")) {
						Mail mail = new Mail();
						List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
						ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
						comRptDsgnXptInfoVO.setRdTmpltNm(app_cd);
						comRptDsgnXptInfoVO.setRdApplCd(sys_cd);
						comRptDsgnXptInfoVO.setRdParaCtnt(param);
						comRptDsgnXptInfoVO.setXptFileNm("Confirm MSG.pdf");
						comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						comRptDsgnXptInfoVO.setCreUsrId(hu01_eventResponse.getCreUsrId());
						comRptDsgnXptInfoVO.setUpdUsrId(hu01_eventResponse.getCreUsrId());
						comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);

						mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
						mail.setBatFlg(batch_ind);
						mail.setRdSubSysCd(sys_cd);
						mail.setSubject(title);
						mail.setTextContent(email_contents);
						mail.setRecipient(hu01_eventResponse.getProvEml());
						mail.setFrom("shipment.info@notifications.nykline.com");
						mail.send();
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
}
