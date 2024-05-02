/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RocsCustomsTransmissionBCImpl.java
 *@FileTitle : RocsCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
 * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
 *    => Rocs FlatFile에 MRN 정보 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.integration.RocsCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestListTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchCmInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchDgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchRfCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lim Jae Taek
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RocsCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient RocsCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public RocsCustomsTransmissionBCImpl() {
		dbDao = new RocsCustomsTransmissionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Rocs를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = null;

		RocsManifestTransmitVO rocsManifestTransmitVO = new RocsManifestTransmitVO();

		List<RocsSearchBlInfoVO> rocsSearchBlInfoVOs = null;
		List<RocsSearchCmInfoVO> rocsSearchCmInfoVOs = null;
		List<RocsSearchDgCntrInfoVO> rocsSearchDgCntrInfoVOs = null;
		List<RocsSearchRfCntrInfoVO> rocsSearchRfCntrInfoVOs = null;
		List<RocsSearchCntrInfoVO> rocsSearchCntrInfoVOs = null;
		List<RocsManifestTransmitVO> rocsManifestTransmitVOs = new ArrayList<RocsManifestTransmitVO>();
		BookingUtil command = new BookingUtil();
		String msgDt = "";
		int tempCount = 0;
		try {
			if (manifestTransmitVOs.length > 0) {
				String blNumber = "";
				for (int q = 0; q < manifestTransmitVOs.length; q++) {
					flatFile = new StringBuffer();
					rocsManifestTransmitVO = (RocsManifestTransmitVO) manifestTransmitVOs[q];
					if (!blNumber.equals(rocsManifestTransmitVO.getBlNo())) {
						rocsSearchBlInfoVOs = dbDao.searchBlInfo(rocsManifestTransmitVO);
						rocsSearchCmInfoVOs = dbDao.searchCmInfo(rocsManifestTransmitVO);
						rocsSearchDgCntrInfoVOs = dbDao.searchDgCntrInfo(rocsManifestTransmitVO);
						rocsSearchRfCntrInfoVOs = dbDao.searchRfCntrInfo(rocsManifestTransmitVO);
						rocsSearchCntrInfoVOs = dbDao.searchCntrInfo(rocsManifestTransmitVO);

						msgDt = dbDao.searchMsgDt();
						rocsManifestTransmitVO.setUsertId(account.getUsr_id());
						rocsManifestTransmitVO.setOfcCd(account.getOfc_cd());
						rocsManifestTransmitVO.setMsgDt(msgDt);

						flatFile.append("$$$MSGSTART:SMLINE              NLRTMPCS            IFTMCS    ").append(msgDt);

						if (rocsSearchBlInfoVOs != null && rocsSearchBlInfoVOs.size() > 0) {
							if (rocsManifestTransmitVO.getKind().equalsIgnoreCase("")) {
								rocsManifestTransmitVO.setFlag("9");
								rocsManifestTransmitVO.setKind("9");
							} else {
								rocsManifestTransmitVO.setFlag(rocsManifestTransmitVO.getKind());
							}
							rocsManifestTransmitVOs.add(tempCount,rocsManifestTransmitVO);
							//dbDao.modofyBlSndSts(rocsManifestTransmitVO);
							msgDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));
							rocsManifestTransmitVO.setMsgDt(msgDt);
							dbDao.addSendLog(rocsManifestTransmitVO);
							for (int i = 0; i < rocsSearchBlInfoVOs.size(); i++) {
								RocsSearchBlInfoVO rocsSearchBlInfoVO = rocsSearchBlInfoVOs.get(i);
								flatFile.append("\n");
								flatFile.append(
										rocsSearchBlInfoVO.getVvd().toString() + "-"
												+ rocsSearchBlInfoVO.getBlNo().substring(0, 12)).append("\n");
								flatFile.append("VVD:").append(rocsSearchBlInfoVO.getVvd()).append("\n");
								flatFile.append("STATUS:").append(rocsSearchBlInfoVO.getFlag()).append("\n");
								flatFile.append("WGT:").append(rocsSearchBlInfoVO.getWgt()).append("\n");
								flatFile.append("WGT_U:").append(rocsSearchBlInfoVO.getWgtU()).append("\n");
								flatFile.append("FRT_OPT:").append(rocsSearchBlInfoVO.getFrtOpt()).append("\n");
								flatFile.append("BL_NO:").append(rocsSearchBlInfoVO.getBlNo().substring(0, 12)).append("\n");
								
								flatFile.append("MRN:").append(rocsSearchBlInfoVO.getMrnNo()).append("\n");								
								
								flatFile.append("T1_IND:").append(rocsSearchBlInfoVO.getT1Ind()).append("\n");
								flatFile.append("SCAC:").append(rocsSearchBlInfoVO.getScac()).append("\n");
								flatFile.append("LLOYD_CD:").append(rocsSearchBlInfoVO.getLloydCd()).append("\n");
								flatFile.append("POD:").append(rocsSearchBlInfoVO.getPod()).append("\n");
								flatFile.append("BERTH_CD:").append(rocsSearchBlInfoVO.getBerthCd()).append("\n");
								flatFile.append("POD_ETA:").append(rocsSearchBlInfoVO.getPodEta()).append("\n");
								flatFile.append("POL:").append(rocsSearchBlInfoVO.getPol()).append("\n");
								flatFile.append("POL_ATD:").append(rocsSearchBlInfoVO.getPolAtd()).append("\n");
								flatFile.append("PRE:").append(rocsSearchBlInfoVO.getPre()).append("\n");
								flatFile.append("POST:").append(rocsSearchBlInfoVO.getPost()).append("\n");
								flatFile.append("POR:").append(rocsSearchBlInfoVO.getPor()).append("\n");
								flatFile.append("DEL:").append(rocsSearchBlInfoVO.getDelCd()).append("\n");
								flatFile.append("SS_REF_NO:").append(rocsSearchBlInfoVO.getSsRefNo()).append("\n");
								flatFile.append("SENDER_ID:").append(rocsSearchBlInfoVO.getSenderId()).append("\n");
								flatFile.append("SENDER:").append(rocsSearchBlInfoVO.getSenderCd()).append("\n");
								flatFile.append("CARRIER_ID:").append(rocsSearchBlInfoVO.getCarrierId()).append("\n");
								flatFile.append("CARRIER:").append(rocsSearchBlInfoVO.getCarrier()).append("\n");
								flatFile.append("SHPR_EORI:").append(rocsSearchBlInfoVO.getShprEori()).append("\n");
								flatFile.append("SHPR_NAME:").append(rocsSearchBlInfoVO.getShprName()).append("\n");
								flatFile.append("SHPR_ADDR_STR:").append(rocsSearchBlInfoVO.getShprAddrStr()).append("\n");
								flatFile.append("SHPR_ADDR_CITY:").append(rocsSearchBlInfoVO.getShprAddrCity()).append("\n");
								flatFile.append("SHPR_ADDR_PLC:").append(rocsSearchBlInfoVO.getShprAddrPlc()).append("\n");
								flatFile.append("SHPR_ADDR_CNTRY:").append(rocsSearchBlInfoVO.getShprAddrCntry()).append("\n");
								flatFile.append("SHPR_ADDR:").append(rocsSearchBlInfoVO.getShprAddr()).append("\n");
								flatFile.append("CNEE_EORI:").append(rocsSearchBlInfoVO.getCneeEori()).append("\n");
								flatFile.append("CNEE_NAME:").append(rocsSearchBlInfoVO.getCneeName()).append("\n");
								flatFile.append("CNEE_ADDR_STR:").append(rocsSearchBlInfoVO.getCneeAddrStr()).append("\n");
								flatFile.append("CNEE_ADDR_CITY:").append(rocsSearchBlInfoVO.getCneeAddrCity()).append("\n");
								flatFile.append("CNEE_ADDR_PLC:").append(rocsSearchBlInfoVO.getCneeAddrPlc()).append("\n");
								flatFile.append("CNEE_ADDR_CNTRY:").append(rocsSearchBlInfoVO.getCneeAddrCntry()).append("\n");
								flatFile.append("CNEE_ADDR:").append(rocsSearchBlInfoVO.getCneeAddr()).append("\n");
								flatFile.append("NTFY_EORI:").append(rocsSearchBlInfoVO.getNtfyEori()).append("\n");
								flatFile.append("NTFY_NAME:").append(rocsSearchBlInfoVO.getNtfyName()).append("\n");
								flatFile.append("NTFY_ADDR_STR:").append(rocsSearchBlInfoVO.getNtfyAddrStr()).append("\n");
								flatFile.append("NTFY_ADDR_CITY:").append(rocsSearchBlInfoVO.getNtfyAddrCity()).append("\n");
								flatFile.append("NTFY_ADDR_PLC:").append(rocsSearchBlInfoVO.getNtfyAddrPlc()).append("\n");
								flatFile.append("NTFY_ADDR_CNTRY:").append(rocsSearchBlInfoVO.getNtfyAddrCntry()).append("\n");
								flatFile.append("NTFY_ADDR:").append(rocsSearchBlInfoVO.getNtfyAddr()).append("\n");
							}
						}
						if (rocsSearchCmInfoVOs != null) {
							for (int i = 0; i < rocsSearchCmInfoVOs.size(); i++) {
								RocsSearchCmInfoVO rocsSearchCmInfoVO = rocsSearchCmInfoVOs.get(i);
								flatFile.append("{CM_INFO").append("\n");
								flatFile.append("CM_SEQ_NO:").append(rocsSearchCmInfoVO.getCmSeqNo()).append("\n");
								flatFile.append("CM_PKG_NO:").append(rocsSearchCmInfoVO.getCmPkgNo()).append("\n");
								flatFile.append("CM_PKG_CD:").append(rocsSearchCmInfoVO.getCmPkgCd()).append("\n");
								flatFile.append("CM_HS_CD:").append(rocsSearchCmInfoVO.getCmHsCd()).append("\n");
								flatFile.append("CM_DESC:").append(rocsSearchCmInfoVO.getCmDesc()).append("\n");
								flatFile.append("CM_WGT:").append(rocsSearchCmInfoVO.getCmWgt()).append("\n");
								flatFile.append("CM_WGT_U:").append(rocsSearchCmInfoVO.getCmWgtU()).append("\n");
								flatFile.append("CM_CNTR_NO:").append(rocsSearchCmInfoVO.getCmCntrNo()).append("\n");
								flatFile.append("}CM_INFO").append("\n");
							}
						}
						if (rocsSearchDgCntrInfoVOs != null) {
							for (int i = 0; i < rocsSearchDgCntrInfoVOs.size(); i++) {
								RocsSearchDgCntrInfoVO rocsSearchDgCntrInfoVO = rocsSearchDgCntrInfoVOs.get(i);
								flatFile.append("{DANGER_CGO").append("\n");
								flatFile.append("CNTR_NO:").append(rocsSearchDgCntrInfoVO.getCntrNo()).append("\n");
								flatFile.append("DG_IMO_CLASS:").append(rocsSearchDgCntrInfoVO.getDgImoClass()).append(
										"\n");
								flatFile.append("DG_UNNO:").append(rocsSearchDgCntrInfoVO.getDgUnno()).append("\n");
								flatFile.append("DG_FLASH_PNT:").append(rocsSearchDgCntrInfoVO.getDgFlashPnt()).append(
										"\n");
								flatFile.append("DG_PKG_DESC:").append(rocsSearchDgCntrInfoVO.getDgPkgDesc()).append(
										"\n");
								flatFile.append("}DANGER_CGO").append("\n");
							}
						}
						if (rocsSearchRfCntrInfoVOs != null) {
							for (int i = 0; i < rocsSearchRfCntrInfoVOs.size(); i++) {
								RocsSearchRfCntrInfoVO rocsSearchRfCntrInfoVO = rocsSearchRfCntrInfoVOs.get(i);
								flatFile.append("{REEFER_CGO").append("\n");
								flatFile.append("CNTR_NO:").append(rocsSearchRfCntrInfoVO.getCntrNo()).append("\n");
								flatFile.append("RF_TEMP_C:").append(rocsSearchRfCntrInfoVO.getRfTempC()).append("\n");
								flatFile.append("}REEFER_CGO").append("\n");
							}
						}
						if (rocsSearchCntrInfoVOs != null) {
							for (int i = 0; i < rocsSearchCntrInfoVOs.size(); i++) {
								RocsSearchCntrInfoVO rocsSearchCntrInfoVO = rocsSearchCntrInfoVOs.get(i);
								flatFile.append("{CNTR_INFO").append("\n");
								flatFile.append("CNTR_NO:").append(rocsSearchCntrInfoVO.getCntrNo()).append("\n");
								flatFile.append("CNTR_TS:").append(rocsSearchCntrInfoVO.getCntrTs()).append("\n");
								flatFile.append("CNTR_SC:").append(rocsSearchCntrInfoVO.getCntrSc()).append("\n");
								flatFile.append("CNTR_FM:").append(rocsSearchCntrInfoVO.getCntrFm()).append("\n");
								flatFile.append("SEAL_NO:").append(rocsSearchCntrInfoVO.getSealNo()).append("\n");
								flatFile.append("}CNTR_INFO").append("\n");
							}
						}
						blNumber = rocsManifestTransmitVO.getBlNo();

						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(flatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ROCS.IBMMQ.QUEUE"));

						FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
						flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

						if (flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

						tempCount++;

						ArrayList tmpArray = new ArrayList();
						StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
						int j = 0;
						while (token.hasMoreTokens()) {
							tmpArray.add(token.nextToken());
							rocsManifestTransmitVO.setVarj(String.valueOf(j + 1));
							rocsManifestTransmitVO.setDataCtnt(tmpArray.get(j++).toString());
							dbDao.addSendLogDetail(rocsManifestTransmitVO);
						}

					}
				}
			}// if
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		RocsManifestListTransmitDetailVO rocsManifestListTransmitDetailVO = new RocsManifestListTransmitDetailVO();
		rocsManifestListTransmitDetailVO.setFliatFile(flatFile.toString());

		rocsManifestListTransmitDetailVO.setRocsManifestTransmitVOs(rocsManifestTransmitVOs);
		return (ManifestTransmitDetailVO)rocsManifestListTransmitDetailVO;		
	}

	/**
	 * 전송 이벤트 처리<br>
	 * CustomsTransmission화면에 대한 전송 이벤트 처리<br>
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @return RocsManifestTransmitVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public RocsManifestTransmitVO receiveAlpsbkgUdevhjs(String flatFile, SignOnUserAccount account) throws EventException {
		RocsManifestTransmitVO rocsManifestTransmitVO = new RocsManifestTransmitVO();
		try {
			

			StringTokenizer token = new StringTokenizer(flatFile, "\n");
			ArrayList tmpArray = new ArrayList();

			while (token.hasMoreTokens()) {
				tmpArray.add(token.nextToken());
			}
			for (int j = 0; j < tmpArray.size(); j++) {
				String data1 = tmpArray.get(j).toString();

				if (data1.length() > 11 && data1.substring(0, 12).equalsIgnoreCase("RTMCUSAPERAK")) {
					rocsManifestTransmitVO.setMsgDt(data1.substring(12).trim());
				}
				if (data1.length() > 5 && data1.substring(0, 6).equalsIgnoreCase("RSP_TP"))
					rocsManifestTransmitVO.setMsgTp(data1.substring(7, 8).trim());
				if (data1.length() > 4 && data1.substring(0, 5).equalsIgnoreCase("BL_NO"))
					rocsManifestTransmitVO.setBlNo(data1.substring(6).trim());
				if (data1.length() > 7 && data1.substring(0, 8).equalsIgnoreCase("ERROR_CD"))
					rocsManifestTransmitVO.setErrorCd(data1.substring(9).trim());
				if (data1.length() > 9 && data1.substring(0, 10).equalsIgnoreCase("ERROR_DESC"))
					rocsManifestTransmitVO.setErrorDesc(data1.substring(11).trim());
				if (data1.length() > 8 && data1.substring(0, 9).equalsIgnoreCase("ERROR_RFF"))
					rocsManifestTransmitVO.setErrorRff(data1.substring(10).trim());
				rocsManifestTransmitVO.setUsertId("EDIUSER");
			}
			dbDao.addReceivedLog(rocsManifestTransmitVO);

			for (int j = 0; j < tmpArray.size(); j++) {
				String data1 = tmpArray.get(j).toString();
				rocsManifestTransmitVO.setDataCtnt(data1);
				rocsManifestTransmitVO.setVarj(String.valueOf(j + 1));
				dbDao.addReceivedLogDetail(rocsManifestTransmitVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return rocsManifestTransmitVO;
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] detailVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] detailVOs, String pgmNo)
			throws EventException {
		RocsCustomsTransmissionBackEndJob backEndJob = new RocsCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0061")) {
				backEndJob.setRocsManifestTransmitVO((RocsManifestTransmitVO[]) detailVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Rocs Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}
}