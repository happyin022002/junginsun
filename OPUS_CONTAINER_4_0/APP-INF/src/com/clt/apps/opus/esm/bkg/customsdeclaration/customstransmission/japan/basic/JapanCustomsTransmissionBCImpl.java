/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration.JapanCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.EdiJapanCommonVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlGeneralInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlMarkDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitForReVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.TempFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpVslSkdVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanCustomsTransmissionBCImpl extends BasicCommandSupport implements JapanCustomsTransmissionBC {

	// Database Access Object
	private transient JapanCustomsTransmissionDBDAO dbDao = null;
	private transient JapanCustomsReportDBDAO dbDao2 = null;
	private transient JapanManifestListDownloadDBDAO dbDao3 = null;

	/**
	 * JapanCustomsTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public JapanCustomsTransmissionBCImpl() {
		dbDao = new JapanCustomsTransmissionDBDAO();
		dbDao2 = new JapanCustomsReportDBDAO();
		dbDao3 = new JapanManifestListDownloadDBDAO();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {//Start
		JapanManifestTransmitContainerVO japanManifestTransmitContainerVO = (JapanManifestTransmitContainerVO) manifestTransmitVO;
		JapanManifestTransmitCondVO japanManifestTransmitCondVO = japanManifestTransmitContainerVO.getJapanManifestTransmitCondVO();
		JapanManifestTransmitVO[] japanManifestTransmitVOs = japanManifestTransmitContainerVO.getJapanManifestTransmitVOs();
		String inMsgTp = japanManifestTransmitCondVO.getInMsgTp();

		JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = new JapanManifestListTransmitDetailVO();
		List<JapanTransmitBlKeyVO> japanTransmitBlKeyVOlist = new ArrayList<JapanTransmitBlKeyVO>();

		try {
			if ("CMF03".equals(inMsgTp)) {
				japanTransmitBlKeyVOlist = this.transmitCmf03(japanManifestTransmitCondVO, japanManifestTransmitVOs, account);
			} else {
				japanTransmitBlKeyVOlist = this.transmitMfr(japanManifestTransmitCondVO, japanManifestTransmitVOs, account);
			}
			japanManifestListTransmitDetailVO.setJapanBlKeyVOs(japanTransmitBlKeyVOlist);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return (ManifestTransmitDetailVO)japanManifestListTransmitDetailVO;
	}

	/**
	 * CMF03 전송 처리<br>
	 *
	 * @param JapanManifestTransmitCondVO japanManifestTransmitCondVO
	 * @param JapanManifestTransmitVO[] japanManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return List<JapanTransmitBlKeyVO>
	 * @exception EventException
	 */
	private List<JapanTransmitBlKeyVO> transmitCmf03(JapanManifestTransmitCondVO japanManifestTransmitCondVO, JapanManifestTransmitVO[] japanManifestTransmitVOs, SignOnUserAccount account) throws EventException {
		List<JapanTransmitBlKeyVO> jpBlKeyVOList = new ArrayList<JapanTransmitBlKeyVO>();
		List<JapanManifestListEtcVO> japanManifestListEtcVOList = null;
		List<JapanManifestListEmptyBlInfoVO> jpMtBlInfoVOList = null;
		List<JapanManifestListBlGeneralInfoVO> jpGeneralInfoVOList = null;
		List<JapanManifestListSendHeaderInfoVO> jpHeaderInfoVOList = null;
		List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList_S = new ArrayList<BkgCstmsJpSndLogVO>();
		String prevBlNo = "";
		int realCount = 0;
		int logSeq = 0;

//↓↓↓↓↓↓↓↓↓↓///////////////////////////
		List<EdiJapanCommonVO> ediJapanCommonVO = new ArrayList<EdiJapanCommonVO>();
		java.text.DecimalFormat formatter = new java.text.DecimalFormat("00");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

		StringBuilder flatFileHeader = new StringBuilder();
		TempFlatFileVO tempFlatFileVO = null;

		try {
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			String pgmDiv = japanManifestTransmitCondVO.getPgmDiv();
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			String vvdCd = japanManifestTransmitCondVO.getInVvdCd();
			String vslCd = japanManifestTransmitCondVO.getInVvdCd().substring(0, 4);
			String skdVoyNo = japanManifestTransmitCondVO.getInVvdCd().substring(4, 8);
			String skdDirCd = japanManifestTransmitCondVO.getInVvdCd().substring(8);
			String inPodCd = japanManifestTransmitCondVO.getInPodCd();
			String inPodSplitCd = japanManifestTransmitCondVO.getInPodSplitCd();
			String inPolCd = japanManifestTransmitCondVO.getInPolCd();
			String inCallSgnNo = japanManifestTransmitCondVO.getInCallSgnNo();
			String inCyOprCd = japanManifestTransmitCondVO.getInCyOprCd();
			String inVpsEtaDt = japanManifestTransmitCondVO.getInVpsEtaDt();
			String inMsgTp = japanManifestTransmitCondVO.getInMsgTp();
			String inMsgFlag = japanManifestTransmitCondVO.getInMsgFlag();
			String inVoyageNo = japanManifestTransmitCondVO.getInVoyageNo();
			String inCorrRsnCd = japanManifestTransmitCondVO.getCorrRsnCd();
			String inCorrRsn = japanManifestTransmitCondVO.getCorrRsn();

			BookingUtil command = new BookingUtil();
			String sndDt = command.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3));

			// Loop(S)
			for (JapanManifestTransmitVO japanManifestTransmitVO : japanManifestTransmitVOs) {
				// 직전 bl_no와 같다면 skip
				if (prevBlNo.equals(japanManifestTransmitVO.getBlNumber())) continue;

				String blNo = japanManifestTransmitVO.getBlNumber();
				String inJapanPod = "";

				japanManifestListEtcVOList = null;
				jpMtBlInfoVOList = null;
				jpGeneralInfoVOList = null;

				japanManifestTransmitVO.setInVslCd(vslCd);
				japanManifestTransmitVO.setInSkdVoyNo(skdVoyNo);
				japanManifestTransmitVO.setInSkdDirCd(skdDirCd);
				japanManifestTransmitVO.setInPodCd(inPodCd);
				japanManifestTransmitVO.setInPolCd(inPolCd);
				japanManifestTransmitVO.setInCallSgnNo(inCallSgnNo);
				japanManifestTransmitVO.setInCyOprCd(inCyOprCd);
				japanManifestTransmitVO.setInVpsEtaDt(inVpsEtaDt);
				japanManifestTransmitVO.setInVoyageNo(inVoyageNo);

				//세관 전송시 pod를 일본세관에서 사용하는 pod로 보내기 위해 사용 2014.03.05
				inJapanPod = dbDao.searchJapanPODInfo(inPodCd);

				if (inJapanPod == null || "".equals(inJapanPod)) inJapanPod = inPodCd;

				japanManifestListEtcVOList = dbDao.searchJpcusEta(japanManifestTransmitVO);
				if (inCallSgnNo == null || inCallSgnNo.equals("")) {
					if (japanManifestListEtcVOList.get(0).getCallSgnNo() == null) {
						inCallSgnNo = dbDao.searchVslCallsign(vslCd);
					} else {
						inCallSgnNo = japanManifestListEtcVOList.get(0).getCallSgnNo();
					}
				}

				if (inVpsEtaDt == null || "".equals(inVpsEtaDt)) {
					if (japanManifestListEtcVOList.get(0).getEtaDt() == null) {
						inVpsEtaDt = dbDao.searchEta(japanManifestTransmitVO);
					} else {
						inVpsEtaDt = japanManifestListEtcVOList.get(0).getEtaDt();
					}
				}

				JapanTransmitBlKeyVO blKeyVO = new JapanTransmitBlKeyVO();
				blKeyVO.setBlNo(blNo);
				blKeyVO.setInMsgTp(inMsgTp);
				blKeyVO.setInMsgFlag(inMsgFlag);
				blKeyVO.setInCallSgnNo(inCallSgnNo);
				blKeyVO.setInVvdCd(vvdCd);
				jpBlKeyVOList.add(realCount, blKeyVO);
				String fullMtyCd = dbDao.searchEmptyInd(blKeyVO);

				inVpsEtaDt = inVpsEtaDt.replace("-", "");
				if ("".equals(inVpsEtaDt) || inVpsEtaDt == null)
					inVpsEtaDt = "        ";

				if (inPodSplitCd == null || "".equals(inPodSplitCd) || inPodSplitCd.length() == 0)
					inPodSplitCd = " ";

				StringBuilder bodyContent = new StringBuilder();
				tempFlatFileVO = new TempFlatFileVO();

//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				if ("NEW".equals(pgmDiv)) {
				// NEW (S)

					// 03.Function Type Code (1)
					bodyContent.append(inMsgTp).append("\n");

					if ("F".equals(fullMtyCd)) {
						ediJapanCommonVO = dbDao.searchEdiBlGeneralMfrFull(blKeyVO);
					} else {
						ediJapanCommonVO = dbDao.searchEdiBlGeneralMfrMt(blKeyVO);
					}
					if (ediJapanCommonVO.size() < 1) {
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n["+blNo+"] No B/L Data.").getMessage());
					}
					HashMap<String, String> tempMap4BL = ediJapanCommonVO.get(0).getColumnValues();
					// 06.Vessel Code (9)
					bodyContent.append(tempMap4BL.get("data00")).append("\n");
					// 08.Voyage Number (10)
					bodyContent.append(tempMap4BL.get("data02")).append("\n");
					// 09.Consortium Voyage Number (10)
					bodyContent.append(tempMap4BL.get("data03")).append("\n");
					// (확인 필요)
					bodyContent.append(" ").append("\n");
					// Place of Delivery Code (5)
					bodyContent.append(inJapanPod).append("\n");
					// Port of Discharge Suffix (1)
					bodyContent.append(inPodSplitCd).append("\n");
					// Estimated Date of Arrival (8)
					bodyContent.append(inVpsEtaDt).append("\n");
					// Container Operator Code (5)
					bodyContent.append(tempMap4BL.get("data05")).append("\n");
					// B/L Number (35)
					bodyContent.append(tempMap4BL.get("data06")).append("\n");
					// 68. ~ 77.
					for (int k=27; k<41; k++) bodyContent.append(tempMap4BL.get("data" + formatter.format(k))).append("\n");

					// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
					tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));


				// NEW (E)

				} else {

				// OLD (S)
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

					if ("F".equals(fullMtyCd)) {
						// Full Booking
						jpGeneralInfoVOList = dbDao.searchBlGeneral(blKeyVO);
						JapanManifestListBlGeneralInfoVO jpGeneralInfoVO = jpGeneralInfoVOList.get(0);

						bodyContent.append(inMsgTp).append("\n");
						bodyContent.append(jpGeneralInfoVO.getInCallSgnNo()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getInVvdCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getJpTmlVslNo()).append("\n");    // Consortium Voyage Number
						bodyContent.append(jpGeneralInfoVO.getData1()).append("\n");
						bodyContent.append(inJapanPod).append("\n");
						bodyContent.append(inPodSplitCd).append("\n");
						bodyContent.append(inVpsEtaDt).append("\n");
						bodyContent.append(jpGeneralInfoVO.getCyOprCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData2()).append("\n");

						bodyContent.append(jpGeneralInfoVO.getData14()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg1()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg2()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg3()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData15()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData16()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData17()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData18()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData19()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData20()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData21()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData22()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData23()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData24()).append("\n");

						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));

					} else {
						// Empty Booking
						jpMtBlInfoVOList = dbDao.searchEmptyBl(blKeyVO);
						JapanManifestListEmptyBlInfoVO jpMtBlInfoVO = jpMtBlInfoVOList.get(0);

						bodyContent.append(inMsgTp).append("\n");
						bodyContent.append(jpMtBlInfoVO.getInCallSgnNo()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getInVvdCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getJpTmlVslNo()).append("\n");    // Consortium Voyage Number
						bodyContent.append(ConstantMgr.getScacCode()).append("\n");
						bodyContent.append(inJapanPod).append("\n");
						bodyContent.append(inPodSplitCd).append("\n");
						bodyContent.append(inVpsEtaDt).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCyOprCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData02()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getData65()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData66()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData67()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData68()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData69()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData70()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData71()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData72()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData73()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData74()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData75()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData76()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData77()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData78()).append("\n");

						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));
					}
				}


				if (realCount < 1) logSeq = dbDao.searchSendLogSeq(sndDt, inMsgTp);
				BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
				bkgCstmsJpSndLogVO.setJpSndLogId(inMsgTp);
				bkgCstmsJpSndLogVO.setSndDt(sndDt);
				bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsJpSndLogVO.setVslCd(vslCd);
				bkgCstmsJpSndLogVO.setSkdVoyNo(skdVoyNo);
				bkgCstmsJpSndLogVO.setSkdDirCd(skdDirCd);
				bkgCstmsJpSndLogVO.setPodCd(inPodCd);
				bkgCstmsJpSndLogVO.setLogFlg("N");
				bkgCstmsJpSndLogVO.setBlNo(blNo);
				bkgCstmsJpSndLogVO.setCorrRsnCd(inCorrRsnCd);
				bkgCstmsJpSndLogVO.setCorrRsn(inCorrRsn);
				bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
				if (logSeq == 0) {
					bkgCstmsJpSndLogVO.setLogSeq("1");
					logSeq = 1;
				} else {
					if (logSeq + 1 > 999) {
						throw new EventException(new ErrorHandler("BKG01003", new String[] {}).getMessage());
					} else {
						bkgCstmsJpSndLogVO.setLogSeq(++logSeq + "");
					}
				}

				// **************** 저장 데이터 수집 및 전송 (S) ************************************ //
				StringBuilder flatFileBodyForMfrS = new StringBuilder();
				// 저장 데이터 수집 (bkgCstmsJpSndLogVO)
				bkgCstmsJpSndLogVO.setEdiSndMsgCtnt(tempFlatFileVO.getBodyContent());
				// 전송 데이터 수집 (flatFileBody)
				flatFileBodyForMfrS.append(tempFlatFileVO.getBodyContent());

				// 전송
				flatFileHeader = new StringBuilder();
				String cstmsEdiHeader = command.searchCstmsEdiHeaderNew("JP_" + inMsgTp);
				flatFileHeader.append(cstmsEdiHeader).append("\n");
				bkgCstmsJpSndLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());

				jpHeaderInfoVOList = dbDao.searchSendHeader(vvdCd, inPodCd, account.getOfc_cd(), account.getUsr_id(), inMsgTp, sndDt, flatFileBodyForMfrS.toString().length() + "", "");
				flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader()).append("\n");
				flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader2()).append("\n");

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFileHeader.toString().toUpperCase() + flatFileBodyForMfrS.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
				FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

				bkgCstmsJpSndLogVOList_S.add(bkgCstmsJpSndLogVO);
				// **************** 저장 데이터 수집 및 전송 (E) ************************************ //

				prevBlNo = blNo;
				realCount++;
			}
			// Loop(E)


			if (bkgCstmsJpSndLogVOList_S.size() < 1) {
				throw new EventException(new ErrorHandler("BKG01003", new String[]{}).getMessage());

			} else {
				// [CMF03] BKG_CSTMS_SND_LOG 저장
				dbDao.addSendLog(bkgCstmsJpSndLogVOList_S);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return jpBlKeyVOList;
	}

	/**
	 * MFR, CMF01 전송 처리<br>
	 *
	 * @param JapanManifestTransmitCondVO japanManifestTransmitCondVO
	 * @param JapanManifestTransmitVO[] japanManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return List<JapanTransmitBlKeyVO>
	 * @exception EventException
	 */
	private List<JapanTransmitBlKeyVO> transmitMfr(JapanManifestTransmitCondVO japanManifestTransmitCondVO, JapanManifestTransmitVO[] japanManifestTransmitVOs, SignOnUserAccount account) throws EventException {
		List<JapanTransmitBlKeyVO> jpBlKeyVOList = new ArrayList<JapanTransmitBlKeyVO>();
		List<JapanManifestListEtcVO> japanManifestListEtcVOList = null;
		List<JapanManifestListEmptyBlInfoVO> jpMtBlInfoVOList = null;
		List<JapanManifestListBlGeneralInfoVO> jpGeneralInfoVOList = null;
		List<JapanManifestListEmptyBlCntrInfoVO> jpMtBlCntrInfoVOList = null;
		List<JapanManifestListBlCustInfoVO> jpCustInfoVOList = null;
		List<JapanManifestListBlCntrInfoVO> jpCntrInfoVOList = null;
		List<JapanManifestListBlMarkDescInfoVO> jpMarkDescInfoVOList = null;
		List<JapanManifestListSendHeaderInfoVO> jpHeaderInfoVOList = null;
		List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList_M = new ArrayList<BkgCstmsJpSndLogVO>();
		List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList_S = new ArrayList<BkgCstmsJpSndLogVO>();
		String prevBlNo = "";
		int realCount = 0;
		int logSeq = 0;

//↓↓↓↓↓↓↓↓↓↓///////////////////////////
		List<EdiJapanCommonVO> ediJapanCommonVOList = new ArrayList<EdiJapanCommonVO>();
		java.text.DecimalFormat formatter = new java.text.DecimalFormat("00");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

		StringBuilder flatFileHeader = new StringBuilder();
		StringBuilder flatFileBody = new StringBuilder();
		TempFlatFileVO tempFlatFileVO = null;

		try {
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			String pgmDiv = japanManifestTransmitCondVO.getPgmDiv();
			String corrRsnCd = japanManifestTransmitCondVO.getCorrRsnCd();
			String corrRsn = japanManifestTransmitCondVO.getCorrRsn();
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			String vvdCd = japanManifestTransmitCondVO.getInVvdCd();
			String vslCd = japanManifestTransmitCondVO.getInVvdCd().substring(0, 4);
			String skdVoyNo = japanManifestTransmitCondVO.getInVvdCd().substring(4, 8);
			String skdDirCd = japanManifestTransmitCondVO.getInVvdCd().substring(8);
			String inPodCd = japanManifestTransmitCondVO.getInPodCd();
			String inPodSplitCd = japanManifestTransmitCondVO.getInPodSplitCd();
			String inPolCd = japanManifestTransmitCondVO.getInPolCd();
			String inCallSgnNo = japanManifestTransmitCondVO.getInCallSgnNo();
			String inCyOprCd = japanManifestTransmitCondVO.getInCyOprCd();
			String inVpsEtaDt = japanManifestTransmitCondVO.getInVpsEtaDt();
			String inMsgTp = japanManifestTransmitCondVO.getInMsgTp();
			String inMsgFlag = japanManifestTransmitCondVO.getInMsgFlag();
			String inMfrGubun = japanManifestTransmitCondVO.getInMfrGubun();
			String inVoyageNo = japanManifestTransmitCondVO.getInVoyageNo();

			BookingUtil command = new BookingUtil();
			String sndDt = command.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3));

			// Loop(S)
			for (JapanManifestTransmitVO japanManifestTransmitVO : japanManifestTransmitVOs) {
				// 직전 bl_no와 같다면 skip
				if (prevBlNo.equals(japanManifestTransmitVO.getBlNumber())) continue;

				String blNo = japanManifestTransmitVO.getBlNumber();
				String inProcessGb = inMsgFlag;
				if ("MFR".equals(inMsgTp)) inProcessGb = "9";
				String inJapanPod = "";

				japanManifestListEtcVOList = null;
				jpMtBlInfoVOList = null;
				jpMtBlCntrInfoVOList = null;
				jpCustInfoVOList = null;
				jpCntrInfoVOList = null;
				jpMarkDescInfoVOList = null;

				japanManifestTransmitVO.setInVslCd(vslCd);
				japanManifestTransmitVO.setInSkdVoyNo(skdVoyNo);
				japanManifestTransmitVO.setInSkdDirCd(skdDirCd);
				japanManifestTransmitVO.setInPodCd(inPodCd);
				japanManifestTransmitVO.setInPolCd(inPolCd);
				japanManifestTransmitVO.setInCallSgnNo(inCallSgnNo);
				japanManifestTransmitVO.setInCyOprCd(inCyOprCd);
				japanManifestTransmitVO.setInVpsEtaDt(inVpsEtaDt);
				japanManifestTransmitVO.setInVoyageNo(inVoyageNo);

				//세관 전송시 pod를 일본세관에서 사용하는 pod로 보내기 위해 사용 2014.03.05
				inJapanPod = dbDao.searchJapanPODInfo(inPodCd);
				if (inJapanPod == null || "".equals(inJapanPod)) inJapanPod = inPodCd;

				japanManifestListEtcVOList = dbDao.searchJpcusEta(japanManifestTransmitVO);
				if (inCallSgnNo == null || inCallSgnNo.equals("")) {
					if (japanManifestListEtcVOList.get(0).getCallSgnNo() == null) {
						inCallSgnNo = dbDao.searchVslCallsign(vslCd);
					} else {
						inCallSgnNo = japanManifestListEtcVOList.get(0).getCallSgnNo();
					}
				}

				if (inVpsEtaDt == null || "".equals(inVpsEtaDt)) {
					if (japanManifestListEtcVOList.get(0).getEtaDt() == null) {
						inVpsEtaDt = dbDao.searchEta(japanManifestTransmitVO);
					} else {
						inVpsEtaDt = japanManifestListEtcVOList.get(0).getEtaDt();
					}
				}

				JapanTransmitBlKeyVO blKeyVO = new JapanTransmitBlKeyVO();
				blKeyVO.setBlNo(blNo);
				blKeyVO.setInMsgTp(inMsgTp);
				blKeyVO.setInMsgFlag(inMsgFlag);
				blKeyVO.setInCallSgnNo(inCallSgnNo);
				blKeyVO.setInVvdCd(vvdCd);
				jpBlKeyVOList.add(realCount, blKeyVO);
				String fullMtyCd = dbDao.searchEmptyInd(blKeyVO);

				inVpsEtaDt = inVpsEtaDt.replace("-", "");
				if ("".equals(inVpsEtaDt) || inVpsEtaDt == null)
					inVpsEtaDt = "        ";

				if (inPodSplitCd == null || "".equals(inPodSplitCd) || inPodSplitCd.length() == 0)
					inPodSplitCd = " ";

				if ("MFR".equals(inMsgTp) && !"N".equals(inMfrGubun)) {
					JapanManifestModificationVO japanManifestModificationVO = new JapanManifestModificationVO();
					japanManifestModificationVO.setInVslCd(vslCd);
					japanManifestModificationVO.setInSkdVoyNo(skdVoyNo);
					japanManifestModificationVO.setInSkdDirCd(skdDirCd);
					japanManifestModificationVO.setInPodCd(inPodCd);
					japanManifestModificationVO.setInCallSgnNo(inCallSgnNo);
					japanManifestModificationVO.setInCyOprCd(inCyOprCd);
					japanManifestModificationVO.setInVpsEtaDt(inVpsEtaDt);
					japanManifestModificationVO.setUpdUsrId(account.getUsr_id());
					japanManifestModificationVO.setInVoyageNo(inVoyageNo);
					dbDao3.modifyJpcusBl(japanManifestModificationVO);

					BkgCstmsJpVslSkdVO bkgCstmsJpVslSkdVO = new BkgCstmsJpVslSkdVO();
					bkgCstmsJpVslSkdVO.setVslCd(japanManifestModificationVO.getInVslCd());
					bkgCstmsJpVslSkdVO.setSkdVoyNo(japanManifestModificationVO.getInSkdVoyNo());
					bkgCstmsJpVslSkdVO.setSkdDirCd(japanManifestModificationVO.getInSkdDirCd());
					bkgCstmsJpVslSkdVO.setPodCd(japanManifestModificationVO.getInPodCd());
					bkgCstmsJpVslSkdVO.setCallSgnNo(japanManifestModificationVO.getInCallSgnNo());
					bkgCstmsJpVslSkdVO.setEtaDt(japanManifestModificationVO.getInVpsEtaDt());
					bkgCstmsJpVslSkdVO.setIbCssmVoyNo(japanManifestModificationVO.getInVoyageNo());
					bkgCstmsJpVslSkdVO.setUpdUsrId(account.getUsr_id());
					if (dbDao3.modifyJpcusVslSkd(bkgCstmsJpVslSkdVO) == 0) {
						bkgCstmsJpVslSkdVO.setCreUsrId(account.getUsr_id());
						dbDao3.addJpcusVslSkd(bkgCstmsJpVslSkdVO);
					}
				}

				StringBuilder bodyContent = new StringBuilder();
				tempFlatFileVO = new TempFlatFileVO();

//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				if ("NEW".equals(pgmDiv)) {
				// NEW (S)

					//====================================================

					// 03.Function Type Code (1)
					bodyContent.append(inProcessGb).append("\n");
					// 04.Reason for Deletion Code (1)
					bodyContent.append(JSPUtil.getRPAD(corrRsnCd, 1, " ")).append("\n");
					// 05.Reason for Deletion (210)
					bodyContent.append(JSPUtil.getRPAD(corrRsn, 210, " ").toUpperCase()).append("\n");

					//----------------------------------------------------

					if ("F".equals(fullMtyCd)) {
						ediJapanCommonVOList = dbDao.searchEdiBlGeneralMfrFull(blKeyVO);
					} else {
						ediJapanCommonVOList = dbDao.searchEdiBlGeneralMfrMt(blKeyVO);
					}
					if (ediJapanCommonVOList.size() < 1) {
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n["+blNo+"] No B/L Data.").getMessage());
					}
					HashMap<String, String> tempMap4BL = ediJapanCommonVOList.get(0).getColumnValues();
					// 06. ~ 10.
					for (int k=0; k<5; k++) bodyContent.append(tempMap4BL.get("data" + formatter.format(k))).append("\n");

					// 11.Port of Discharge Code (5)
					bodyContent.append(inJapanPod).append("\n");
					// 12.Port of Discharge Suffix (1)
					bodyContent.append(inPodSplitCd).append("\n");
					// 13.Estimated Date of Arrival (8)
					bodyContent.append(inVpsEtaDt).append("\n");
					// 14. ~ 20.
					for (int k=5; k<12; k++) bodyContent.append(tempMap4BL.get("data" + formatter.format(k))).append("\n");

					//----------------------------------------------------

					if ("F".equals(fullMtyCd)) {
						ediJapanCommonVOList = dbDao.searchEdiBlCustMfrFull(blKeyVO);
					} else {
						ediJapanCommonVOList = dbDao.searchEdiBlCustMfrMt(blKeyVO);
					}
					if (ediJapanCommonVOList.size() < 1) {
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n["+blNo+"] No Customer Data.").getMessage());
					}
					HashMap<String, String> tempMap4Cust = ediJapanCommonVOList.get(0).getColumnValues();
					// 21. ~ 50.
					for (int k=0; k<40; k++) bodyContent.append(tempMap4Cust.get("data" + formatter.format(k))).append("\n");

					//----------------------------------------------------

					String[] blMarkDesc = new String[2];
					if ("F".equals(fullMtyCd)) {
						blMarkDesc = dbDao.searchEdiBlMarkDescMfrFull(blKeyVO);
					} else {
						blMarkDesc = new String[]{JSPUtil.getRPAD(" ", 350, " "), JSPUtil.getRPAD(" ", 140, " ")};
					}
					// 51.Goods Description (350)
					bodyContent.append(blMarkDesc[0]).append("\n");
					// 52.HS Code (The First 6-digit) (6)
					bodyContent.append(tempMap4BL.get("data12")).append("\n");
					// 53.Marks and Numbers (140)
					bodyContent.append(blMarkDesc[1]).append("\n");
					// 54. ~ 78
					for (int k=13; k<42; k++) bodyContent.append(tempMap4BL.get("data" + formatter.format(k))).append("\n");

					//----------------------------------------------------

					StringBuilder etcFlatFile = new StringBuilder();
					if ("F".equals(fullMtyCd)) {
						ediJapanCommonVOList = dbDao.searchEdiBlCntrMfrFull(blKeyVO);
					} else {
						ediJapanCommonVOList = dbDao.searchEdiBlCntrMfrMt(blKeyVO);
					}
					if (ediJapanCommonVOList.size() > 0) {
						for (EdiJapanCommonVO ediJapanCntrVO : ediJapanCommonVOList) {
							HashMap<String, String> tempMap4Cntr = ediJapanCntrVO.getColumnValues();
							// 79.Container Number (12)
							etcFlatFile.append(tempMap4Cntr.get("data00")).append("\n");
							//--------------------------
							List<EdiJapanCommonVO> ediCntrSealNoVO = dbDao.searchEdiCntrSealNoMfrFull(blKeyVO.getBlNo(), tempMap4Cntr.get("data00").trim());    // blNo , cntrNo
							if (ediCntrSealNoVO.size() < 1) {
								throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n["+blNo+"] No CNTR Seal No. Data.").getMessage());
							}
							HashMap<String, String> tempMap4Seal = ediCntrSealNoVO.get(0).getColumnValues();
							// 80.Seal Number (15) x6
							for (int k=0; k<6; k++) etcFlatFile.append(tempMap4Seal.get("data" + formatter.format(k))).append("\n");
							//--------------------------
							// 81. ~ 88.
							for (int k=7; k<15; k++) etcFlatFile.append(tempMap4Cntr.get("data" + formatter.format(k))).append("\n");
						}

					} else {
						// 79.Container Number (12)
						etcFlatFile.append("            ").append("\n");
						// 80.Seal Number (15) x6
						etcFlatFile.append("               ").append("\n");
						etcFlatFile.append("               ").append("\n");
						etcFlatFile.append("               ").append("\n");
						etcFlatFile.append("               ").append("\n");
						etcFlatFile.append("               ").append("\n");
						etcFlatFile.append("               ").append("\n");
						// 81.Empty/Full Container Identification (3)
						etcFlatFile.append("   ").append("\n");
						// 82.Container Size Code (2)
						etcFlatFile.append("  ").append("\n");
						// 83.Container Type Code (2)
						etcFlatFile.append("  ").append("\n");
						// 84.Service Type on Delivery Code (2)
						etcFlatFile.append("  ").append("\n");
						// 85.Container Ownership Code (3)
						etcFlatFile.append("   ").append("\n");
						// 86.Vanning Type Code (3)
						etcFlatFile.append("   ").append("\n");
						// 87.Customs Ｃonvention on Containers (CCC) Application Identifier (1)
						etcFlatFile.append(" ").append("\n");
						// 88.Automatic Search for Discharged Container Exclusion Identifier (1)
						etcFlatFile.append(" ").append("\n");
					}

					//====================================================

					// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
					tempFlatFileVO.setEtcContent(this.replaceAllowCharacter(etcFlatFile.toString().toUpperCase()));
					// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
					tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));


				// NEW (E)

				} else {

				// OLD (S)
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

					if ("F".equals(fullMtyCd)) {
						// Full Booking
						jpGeneralInfoVOList = dbDao.searchBlGeneral(blKeyVO);
						JapanManifestListBlGeneralInfoVO jpGeneralInfoVO = jpGeneralInfoVOList.get(0);

						bodyContent.append(inProcessGb).append("\n");
						bodyContent.append(jpGeneralInfoVO.getInCallSgnNo()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getInVvdCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getJpTmlVslNo()).append("\n");    // Consortium Voyage Number
						bodyContent.append(ConstantMgr.getScacCode()).append("\n");
						bodyContent.append(inJapanPod).append("\n");
						bodyContent.append(inPodSplitCd).append("\n");
						bodyContent.append(inVpsEtaDt).append("\n");
						bodyContent.append(jpGeneralInfoVO.getCyOprCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData2()).append("\n");

						bodyContent.append(jpGeneralInfoVO.getUnLocId1()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData3()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData4()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getUnLocId2()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLocNm()).append("\n");

						jpCustInfoVOList = dbDao.searchBlCust(blKeyVO);
						JapanManifestListBlCustInfoVO jpCustInfoVO = new JapanManifestListBlCustInfoVO();
						if (jpCustInfoVOList.size() > 0) jpCustInfoVO = jpCustInfoVOList.get(0);

						bodyContent.append(jpCustInfoVO.getShprCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprNm1()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprNm2()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprAddr1()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprAddr2()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprAddr3()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprAddr4()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprPostId()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprCntCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getShprPhnNo()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeNm1()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeNm2()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeAddr1()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeAddr2()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeAddr3()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeAddr4()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneePostId()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneeCntCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getCneePhnNo()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Cd()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Nm1()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Nm2()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Addr1()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Addr2()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Addr3()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1Addr4()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1PostId()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1CntCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy1PhnNo()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Cd()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Nm1()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Nm2()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Addr1()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Addr2()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Addr3()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2Addr4()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2PostId()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2CntCd()).append("\n");
						bodyContent.append(jpCustInfoVO.getNtfy2PhnNo()).append("\n");

						String desc = "N/M";
						String mark = "N/M";
						jpMarkDescInfoVOList = dbDao.searchBlMarkDesc(blKeyVO);
						if (jpMarkDescInfoVOList.size() > 0) {
							desc = jpMarkDescInfoVOList.get(0).getBlDesc();
							mark = jpMarkDescInfoVOList.get(0).getDiffRmk();
						}
						bodyContent.append(desc).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData5()).append("\n");
						bodyContent.append(mark).append("\n");

						bodyContent.append(jpGeneralInfoVO.getPckQty()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getPckCstmsCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getGrsWgt()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getWgtUtCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData6()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData7()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getMeasQty()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getMeasUtCd()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData8()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData9()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData10()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData11()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData12()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData13()).append("\n");

						bodyContent.append(jpGeneralInfoVO.getData14()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg1()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg2()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getLoclTsFlg3()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData15()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData16()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData17()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData18()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData19()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData20()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData21()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData22()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData23()).append("\n");
						bodyContent.append(jpGeneralInfoVO.getData24()).append("\n");

						bodyContent.append(jpGeneralInfoVO.getData25()).append("\n");
						StringBuilder etcFlatFile = new StringBuilder();
						jpCntrInfoVOList = dbDao.searchBlCntr(blKeyVO);
						if (jpCntrInfoVOList.size() > 0) {
							List<JapanManifestListBlCntrInfoVO> jpCntrSealNoVOList = new ArrayList<JapanManifestListBlCntrInfoVO>();
							for (JapanManifestListBlCntrInfoVO jpCntrInfoVO : jpCntrInfoVOList) {
								jpCntrSealNoVOList = dbDao.searchCntrSealNo(blKeyVO.getBlNo(), jpCntrInfoVO.getCntrNo().trim());    // blNo , cntrNo
								etcFlatFile.append(jpCntrInfoVO.getCntrNo()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getCntrSealNo()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData2()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData3()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData4()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData5()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData6()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getFullMtyCd()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getCntrTpszCd()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getCntrTpszCd2()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getDeTermCd()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getJpCntrOwnrCd()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getRcvTermCd()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getData7()).append("\n");
								etcFlatFile.append(jpCntrInfoVO.getData8()).append("\n");
							}
						} else {
							etcFlatFile.append("            ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append(" ").append("\n");
							etcFlatFile.append(" ").append("\n");
						}
						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setEtcContent(this.replaceAllowCharacter(etcFlatFile.toString().toUpperCase()));
						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));


					} else {
						// Empty Booking
						jpMtBlInfoVOList = dbDao.searchEmptyBl(blKeyVO);
						JapanManifestListEmptyBlInfoVO jpMtBlInfoVO = jpMtBlInfoVOList.get(0);

						bodyContent.append(inProcessGb).append("\n");

						bodyContent.append(jpMtBlInfoVO.getInCallSgnNo()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getInVvdCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getJpTmlVslNo()).append("\n");    // Consortium Voyage Number
						bodyContent.append(ConstantMgr.getScacCode()).append("\n");
						bodyContent.append(inJapanPod).append("\n");
						bodyContent.append(inPodSplitCd).append("\n");
						bodyContent.append(inVpsEtaDt).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCyOprCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData02()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getData03()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData04()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData05()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData06()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData07()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getShprCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprNm1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprNm2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprAddr1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprAddr2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprAddr3()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprAddr4()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprPostId()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprCntCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getShprPhnNo()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeNm1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeNm2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeAddr1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeAddr2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeAddr3()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeAddr4()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneePostId()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneeCntCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getCneePhnNo()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Cd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Nm1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Nm2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Addr1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Addr2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Addr3()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1Addr4()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1PostId()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1CntCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy1PhnNo()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Cd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Nm1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Nm2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Addr1()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Addr2()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Addr3()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2Addr4()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2PostId()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2CntCd()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getNtfy2PhnNo()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getData48()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData49()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData50()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData51()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData52()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData53()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData54()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData55()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData56()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData57()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData58()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData59()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData60()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData61()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData62()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData63()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData64()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getData65()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData66()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData67()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData68()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData69()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData70()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData71()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData72()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData73()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData74()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData75()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData76()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData77()).append("\n");
						bodyContent.append(jpMtBlInfoVO.getData78()).append("\n");

						bodyContent.append(jpMtBlInfoVO.getData79()).append("\n");

						StringBuilder etcFlatFile = new StringBuilder();
						jpMtBlCntrInfoVOList = dbDao.searchEmptyBlCntr(blKeyVO);
						if (jpMtBlCntrInfoVOList.size() > 0) {
							List<JapanManifestListBlCntrInfoVO> jpCntrSealNoVOList = new ArrayList<JapanManifestListBlCntrInfoVO>();
							for(JapanManifestListEmptyBlCntrInfoVO jpMtBlCntrInfoVO : jpMtBlCntrInfoVOList) {
								jpCntrSealNoVOList = dbDao.searchCntrSealNo(blKeyVO.getBlNo(), jpMtBlCntrInfoVO.getCntrNo().trim());    // bgkNo , cntrNo
								etcFlatFile.append(jpMtBlCntrInfoVO.getCntrNo()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getCntrSealNo()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData2()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData3()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData4()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData5()).append("\n");
								etcFlatFile.append(jpCntrSealNoVOList.get(0).getData6()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData6()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData7()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData8()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData9()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData10()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData11()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData12()).append("\n");
								etcFlatFile.append(jpMtBlCntrInfoVO.getData13()).append("\n");
							}
						} else {
							etcFlatFile.append("            ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("               ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("  ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append("   ").append("\n");
							etcFlatFile.append(" ").append("\n");
							etcFlatFile.append(" ").append("\n");
						}
						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setEtcContent(this.replaceAllowCharacter(etcFlatFile.toString().toUpperCase()));
						// Flatfile Replacing characters allowed & tempFlatFileVO에 임시로 setting
						tempFlatFileVO.setBodyContent(this.replaceAllowCharacter(bodyContent.toString().toUpperCase()));
					}

//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				// OLD (E)
				}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

				if (realCount < 1) logSeq = dbDao.searchSendLogSeq(sndDt, inMsgTp);
				BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
				bkgCstmsJpSndLogVO.setJpSndLogId(inMsgTp);
				bkgCstmsJpSndLogVO.setSndDt(sndDt);
				bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsJpSndLogVO.setVslCd(vslCd);
				bkgCstmsJpSndLogVO.setSkdVoyNo(skdVoyNo);
				bkgCstmsJpSndLogVO.setSkdDirCd(skdDirCd);
				bkgCstmsJpSndLogVO.setPodCd(inPodCd);
				bkgCstmsJpSndLogVO.setLogFlg("N");
				bkgCstmsJpSndLogVO.setBlNo(blNo);
				bkgCstmsJpSndLogVO.setCorrRsnCd(japanManifestTransmitCondVO.getCorrRsnCd());
				bkgCstmsJpSndLogVO.setCorrRsn(japanManifestTransmitCondVO.getCorrRsn());
				bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
				if (logSeq == 0) {
					bkgCstmsJpSndLogVO.setLogSeq("1");
					logSeq = 1;
				} else {
					if (logSeq + 1 > 999) {
						throw new EventException(new ErrorHandler("BKG01003", new String[] {}).getMessage());
					} else {
						bkgCstmsJpSndLogVO.setLogSeq(++logSeq + "");
					}
				}

				// **************** 저장 데이터 수집 및 전송 -1 (S) ************************************ //
				if ("F".equals(fullMtyCd)) {
					// [MFR_M] : Full Booking
					StringBuilder tempflatFileBody = new StringBuilder();
					tempflatFileBody.append("{BL_INFO\n");
					tempflatFileBody.append(tempFlatFileVO.getBodyContent());
					tempflatFileBody.append("{CNTR_INFO\n");
					tempflatFileBody.append(tempFlatFileVO.getEtcContent());
					tempflatFileBody.append("}CNTR_INFO\n");
					tempflatFileBody.append("}BL_INFO\n");
					// 저장용 데이터 수집 (bkgCstmsJpSndLogVO)
					bkgCstmsJpSndLogVO.setEdiSndMsgCtnt(tempFlatFileVO.getBodyContent() + tempFlatFileVO.getEtcContent());
					// 전송용 데이터 수집 (flatFileBody)
					flatFileBody.append(tempflatFileBody.toString());

					bkgCstmsJpSndLogVOList_M.add(bkgCstmsJpSndLogVO);

				} else {
					// [MFR_S] : Empty Booking
					// 저장 데이터 수집(bkgCstmsJpSndLogVO)
					bkgCstmsJpSndLogVO.setEdiSndMsgCtnt(tempFlatFileVO.getBodyContent() + tempFlatFileVO.getEtcContent());
					// 전송 데이터 수집 (flatFileBody)
					StringBuilder flatFileBodyForMfrS = new StringBuilder();
					flatFileBodyForMfrS.append(tempFlatFileVO.getBodyContent());
					flatFileBodyForMfrS.append(tempFlatFileVO.getEtcContent());

					// [MFR_S] 전송
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
					String headerParam = "JP_MFR_S";
					if ("NEW".equals(pgmDiv)) headerParam = headerParam + "-7";
					String cstmsEdiHeader = command.searchCstmsEdiHeaderNew(headerParam);
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

					flatFileHeader = new StringBuilder();
					flatFileHeader.append(cstmsEdiHeader).append("\n");
					bkgCstmsJpSndLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());

					jpHeaderInfoVOList = dbDao.searchSendHeader(vvdCd, inPodCd, account.getOfc_cd(), account.getUsr_id(), inMsgTp, sndDt, flatFileBodyForMfrS.toString().length() + "", "");
					flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader()).append("\n");
					flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader2()).append("\n");

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFileHeader.toString().toUpperCase() + flatFileBodyForMfrS.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

					bkgCstmsJpSndLogVOList_S.add(bkgCstmsJpSndLogVO);
				}
				// **************** 저장 데이터 수집 및 전송 -1 (E) ************************************ //

				prevBlNo = blNo;
				realCount++;
			}
			// Loop(E)


			if (bkgCstmsJpSndLogVOList_M.size() < 1 && bkgCstmsJpSndLogVOList_S.size() < 1) {
				throw new EventException(new ErrorHandler("BKG01003", new String[]{}).getMessage());

			} else {
				// **************** 저장 및 전송 -2 (S) ************************************ //
				// [MFR_S] BKG_CSTMS_SND_LOG 저장
				if (bkgCstmsJpSndLogVOList_S.size() > 0) dbDao.addSendLog(bkgCstmsJpSndLogVOList_S);

				// [MFR_M] 전송
				if (flatFileBody.toString().length() > 0) {
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
					String headerParam = "JP_MFR_M";
					if ("NEW".equals(pgmDiv)) headerParam = headerParam + "-7";
					String cstmsEdiHeader = command.searchCstmsEdiHeaderNew(headerParam);
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
					flatFileHeader = new StringBuilder();
					flatFileHeader.append(cstmsEdiHeader).append("\n");
					for (BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO : bkgCstmsJpSndLogVOList_M) {
						 bkgCstmsJpSndLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());
					}
					jpHeaderInfoVOList = dbDao.searchSendHeader(vvdCd, inPodCd, account.getOfc_cd(), account.getUsr_id(), inMsgTp, sndDt, flatFileBody.toString().length() + "", "");
					flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader()).append("\n");
					flatFileHeader.append(jpHeaderInfoVOList.get(0).getHeader2()).append("\n");

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFileHeader.toString().toUpperCase() + flatFileBody.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}

				// [MFR_M] BKG_CSTMS_SND_LOG 저장
				if (bkgCstmsJpSndLogVOList_M.size() > 0) dbDao.addSendLog(bkgCstmsJpSndLogVOList_M);
			}
			// **************** 저장 및 전송 -2 (E) ************************************ //

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return jpBlKeyVOList;
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 재전송한다.<br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestForResend(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {
		BookingUtil command = new BookingUtil();
		StringBuilder realFlatFile = new StringBuilder();
		JapanManifestTransmitForReVO japanManifestTransmitForReVO =(JapanManifestTransmitForReVO) manifestTransmitVO;
		List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOs = null;

		try {
			String toDate = japanManifestTransmitForReVO.getSndDt() + japanManifestTransmitForReVO.getSndDt2();
			toDate = toDate.replace("-", "").replace(":", "");

			String flatfileBody = dbDao.searchDetailInfo(japanManifestTransmitForReVO.getJpSndLogId(), japanManifestTransmitForReVO.getSndDt() + " " + japanManifestTransmitForReVO.getSndDt2(), japanManifestTransmitForReVO.getOfcCd(), japanManifestTransmitForReVO.getLogSeq(), japanManifestTransmitForReVO.getBlNo());
			String ediHeader = japanManifestTransmitForReVO.getJpSndLogId();
			if ("MFR".equals(japanManifestTransmitForReVO.getJpSndLogId())) {
				ediHeader = "MFR_S";
			} else if ("CMF01".equals(japanManifestTransmitForReVO.getJpSndLogId())) {
				ediHeader = "MFR_M";
			} else if ("BKR".equals(japanManifestTransmitForReVO.getJpSndLogId()) || "BKC".equals(japanManifestTransmitForReVO.getJpSndLogId())) {
				ediHeader = "IFTMBC";
			}

			japanManifestListSendHeaderInfoVOs = dbDao.searchSendHeader(japanManifestTransmitForReVO.getVvdCd(), japanManifestTransmitForReVO.getPodCd(), japanManifestTransmitForReVO.getOfcCd(), japanManifestTransmitForReVO.getUpdUsrId(), japanManifestTransmitForReVO.getJpSndLogId(), toDate.replace("-", "").replace(":", ""), flatfileBody.length() + "", japanManifestTransmitForReVO.getBlNo());

			realFlatFile.append(command.searchCstmsEdiHeaderNew("JP_" + ediHeader));
			realFlatFile.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader()).append("\n");
			realFlatFile.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader2()).append("\n");

			realFlatFile.append(flatfileBody);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(realFlatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
			bkgCstmsJpSndLogVO.setJpSndLogId(japanManifestTransmitForReVO.getJpSndLogId());
			bkgCstmsJpSndLogVO.setSndDt(japanManifestTransmitForReVO.getSndDt() + japanManifestTransmitForReVO.getSndDt2());
			bkgCstmsJpSndLogVO.setLogDt(command.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3)));
			bkgCstmsJpSndLogVO.setOfcCd(japanManifestTransmitForReVO.getOfcCd());
			bkgCstmsJpSndLogVO.setLogSeq(japanManifestTransmitForReVO.getLogSeq());
			bkgCstmsJpSndLogVO.setUpdUsrId(japanManifestTransmitForReVO.getUpdUsrId());
			dbDao.modifySendLog(bkgCstmsJpSndLogVO);

		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO, SignOnUserAccount account) throws EventException {
		StringBuilder realFlatFile = new StringBuilder();
		StringBuilder realFlatFile2 = new StringBuilder();
		String replacementFlatFile = "";
		String etaDt = "";
		String etaDt2 = "";
		JapanManifestTransmitVO japanManifestTransmitVO = new JapanManifestTransmitVO();
		List<JapanManifestListEtcVO> japanManifestListEtcVOList = null;
		List<JapanManifestListVesselArrivalDetailVO> japanManifestListVesselArrivalDetailVOs = null;
		List<JapanManifestListSendHeaderInfoForDmfVO> japanManifestListSendHeaderInfoForDmfVOs = null;
		List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList = new ArrayList<BkgCstmsJpSndLogVO>();

		try {
			japanManifestTransmitVO.setInVslCd(japanVesselArrivalVO.getInVvdCd().substring(0, 4));
			japanManifestTransmitVO.setInSkdVoyNo(japanVesselArrivalVO.getInVvdCd().substring(4, 8));
			japanManifestTransmitVO.setInSkdDirCd(japanVesselArrivalVO.getInVvdCd().substring(8));
			japanManifestTransmitVO.setInPodCd(japanVesselArrivalVO.getInPodCd());
			this.searchDmfSendLog(japanManifestTransmitVO);

			japanManifestListEtcVOList = dbDao.searchJpcusEta(japanManifestTransmitVO);

			if (japanManifestListEtcVOList.size() == 0) {
				etaDt2 = dbDao.searchEta(japanManifestTransmitVO);
				if (etaDt2 != null && !etaDt2.equals("")) etaDt = etaDt2;
			} else {
				etaDt = japanManifestListEtcVOList.get(0).getEtaDt();
			}

			japanManifestListVesselArrivalDetailVOs =
					dbDao.searchVesselArrival(japanVesselArrivalVO.getInVvdCd(), japanVesselArrivalVO.getInPodCd(), japanVesselArrivalVO.getInPodCdSplit(), etaDt.replace("-", ""));
			if (japanManifestListVesselArrivalDetailVOs.size() != 0) {
				JapanManifestListVesselArrivalDetailVO japanManifestListVesselArrivalDetailVO = japanManifestListVesselArrivalDetailVOs.get(0);
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getCallSignNo()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getPodCd()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getPodSplit()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getData1()).append("\n");
				realFlatFile2.append(japanVesselArrivalVO.getInJointFlg()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getEtaDt()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getCstmsMfCd()).append("\n");
				realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getMfRmk()).append("\n");
			}

			// Flatfile Replacing characters allowed
			replacementFlatFile = this.replaceAllowCharacter(realFlatFile2.toString());

			BookingUtil command = new BookingUtil();
			String cstmsEdiHeader = command.searchCstmsEdiHeaderNew("JP_DMF");
			realFlatFile.append(cstmsEdiHeader).append("\n");

			String sndDt = command.searchLocalTime(account.getCnt_cd() +account.getOfc_cd().substring(0, 3));
			japanManifestListSendHeaderInfoForDmfVOs = dbDao.searchSendHeaderForDmf(japanVesselArrivalVO.getInVvdCd(), japanVesselArrivalVO.getInPodCd(), account.getOfc_cd(), account.getUsr_id(), replacementFlatFile.toString(), sndDt);
			realFlatFile.append(japanManifestListSendHeaderInfoForDmfVOs.get(0).getHeader()).append("\n");
			realFlatFile.append(japanManifestListSendHeaderInfoForDmfVOs.get(0).getHeader2()).append("\n");
			realFlatFile.append(replacementFlatFile);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(realFlatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
			bkgCstmsJpSndLogVO.setJpSndLogId("DMF");
			bkgCstmsJpSndLogVO.setSndDt(sndDt);
			bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
			bkgCstmsJpSndLogVO.setVslCd(japanVesselArrivalVO.getInVvdCd().substring(0, 4));
			bkgCstmsJpSndLogVO.setSkdVoyNo(japanVesselArrivalVO.getInVvdCd().substring(4, 8));
			bkgCstmsJpSndLogVO.setSkdDirCd(japanVesselArrivalVO.getInVvdCd().substring(8));
			bkgCstmsJpSndLogVO.setPodCd(japanVesselArrivalVO.getInPodCd());
			bkgCstmsJpSndLogVO.setLogFlg("N");
			// bkgCstmsJpSndLogVO.setBlNo("");
			// bkgCstmsJpSndLogVO.setBlNoTp(japanManifestTransmitVO.getBlNumber().substring(10, 11));
			// bkgCstmsJpSndLogVO.setBlNoChk(japanManifestTransmitVO.getBlNumber().substring(11, 12));
			bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpSndLogVO.setLogSeq("1");
			bkgCstmsJpSndLogVO.setEdiSndMsgCtnt(realFlatFile2.toString());
			bkgCstmsJpSndLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());

			bkgCstmsJpSndLogVOList.add(bkgCstmsJpSndLogVO);
			dbDao.addSendLog(bkgCstmsJpSndLogVOList);
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 *
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveUbizcomOpusBkgNaccs(String flatFile, SignOnUserAccount account) throws EventException {
		try {
			String[] rowArray = flatFile.trim().split("\n");

			String tempTpCd = rowArray[1].substring(3, 8).trim();
			//2012.04.27 김종옥 [CHM-201217431] JP_MSG_TP_ID이 'BKC', 'BKR' 아닐때만 저장 - SEA-NACCS 관련 때문
			if (tempTpCd.indexOf("BKR") > -1 || tempTpCd.indexOf("BKC") > -1) return;

			// 2013.12.04 김상수 [CHM-201326941] 아래에 해당하는 MSG가 아닐때만 저장 - JP24HR관련
			String filterMsgDiv = rowArray[1].substring(8, 15).trim();
			if (filterMsgDiv.indexOf("SAS108") > -1 ||
				filterMsgDiv.indexOf("SAS111") > -1 ||
				filterMsgDiv.indexOf("SAS112") > -1 ||
				filterMsgDiv.indexOf("*SAMR") > -1 ||
				filterMsgDiv.indexOf("*SCMR") > -1 ||
				filterMsgDiv.indexOf("*SATD") > -1 ||
				// 2015.07.28 추가
				filterMsgDiv.indexOf("*SMFR22") > -1 ||
				filterMsgDiv.indexOf("*SCMF22") > -1) {

				return;
			}

			// FlatFile 헤더만 제거
			String[] bodyRowArray = (String[]) org.apache.commons.lang.ArrayUtils.remove(rowArray, 0);

			List<BkgCstmsJpRcvLogVO> insertRcvLogVOList = new ArrayList<BkgCstmsJpRcvLogVO>();
			BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO = new BkgCstmsJpRcvLogVO();
			BkgCstmsJpRcvLogVO insertRcvLogVO = new BkgCstmsJpRcvLogVO();
			bkgCstmsJpRcvLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));

			String msgTpCd = "";
			if (tempTpCd.indexOf("DOR") > -1) {
				msgTpCd = "DOR";
			} else {
				msgTpCd = filterMsgDiv.substring(2);
			}
			bkgCstmsJpRcvLogVO.setJpMsgTpId(msgTpCd);
			bkgCstmsJpRcvLogVO.setJpSvcId(msgTpCd);

			String rcvDt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			bkgCstmsJpRcvLogVO.setRcvDt(rcvDt);

			String creUserId = "";
			if (bodyRowArray[0].length() > 262) creUserId = bodyRowArray[0].substring(253, 263).trim();
			if ("".equals(creUserId)) creUserId = "NACCS";
			bkgCstmsJpRcvLogVO.setCreUsrId(creUserId);

			String vslCd = "";
			String skdVoyNo = "";
			String skdDirCd = "";
			String podCd = "";
			String ediRefId = bodyRowArray[0].substring(34, 49).trim();
			List<BkgCstmsJpSndLogVO> bkgCstmsJpSndLogVOList = dbDao.searchJpSndLogByEdiRefId(ediRefId);
			if (bkgCstmsJpSndLogVOList.size() > 0) {
				vslCd = bkgCstmsJpSndLogVOList.get(0).getVslCd();
				skdVoyNo = bkgCstmsJpSndLogVOList.get(0).getSkdVoyNo();
				skdDirCd = bkgCstmsJpSndLogVOList.get(0).getSkdDirCd();
				podCd = bkgCstmsJpSndLogVOList.get(0).getPodCd();
			}
			bkgCstmsJpRcvLogVO.setVslCd(vslCd);
			bkgCstmsJpRcvLogVO.setSkdVoyNo(skdVoyNo);
			bkgCstmsJpRcvLogVO.setSkdDirCd(skdDirCd);
			bkgCstmsJpRcvLogVO.setPodCd(podCd);

			String blNo = "";
			String rowRcvKeyDatCtnt = "";
			int seqNumber = 0;
			seqNumber = dbDao.searchReceiveLogSeq();

			if ("DOR".equals(msgTpCd)) {
				// DOR
				rowRcvKeyDatCtnt = bodyRowArray[1].substring(0, 15).trim();
				for(int i=2; i<bodyRowArray.length; i++) {
					insertRcvLogVO = new BkgCstmsJpRcvLogVO();
					ObjectCloner.build(bkgCstmsJpRcvLogVO, insertRcvLogVO);

					blNo = bodyRowArray[i].substring(4).trim();
					insertRcvLogVO.setRcvKeyDatCtnt(rowRcvKeyDatCtnt + " " + blNo);
					insertRcvLogVO.setBkgNo(blNo);
					insertRcvLogVO.setRcvSeq(String.valueOf(seqNumber + i));

					insertRcvLogVOList.add(insertRcvLogVO);
				}

			} else {
				// 그 외 MFR
				blNo = bodyRowArray[2].substring(4).trim();
				if ("".equals(blNo)) blNo = dbDao.searchJpBlCntrByEdiRefId(ediRefId, bodyRowArray[3].trim());    // param: ediRefId, cntrNo
				bkgCstmsJpRcvLogVO.setBkgNo(blNo);

				String totalRcvKeyDatCtnt = bodyRowArray[1].trim();
				int rcvKeyDatCtntKnt = totalRcvKeyDatCtnt.length() / 15;
				for(int k=0; k<rcvKeyDatCtntKnt; k++) {
					rowRcvKeyDatCtnt = totalRcvKeyDatCtnt.substring(k*15, (k+1)*15);
					if ("W".equals(rowRcvKeyDatCtnt.substring(0, 1))) continue;

					insertRcvLogVO = new BkgCstmsJpRcvLogVO();
					ObjectCloner.build(bkgCstmsJpRcvLogVO, insertRcvLogVO);
					insertRcvLogVO.setRcvKeyDatCtnt(rowRcvKeyDatCtnt + " " + blNo);
					insertRcvLogVO.setRcvSeq(String.valueOf(seqNumber + k));

					insertRcvLogVOList.add(insertRcvLogVO);
				}
			}

			if (insertRcvLogVOList.size() > 0) dbDao.addReceiveLog(insertRcvLogVOList);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 일본세관 Manifest 수신 로그를 수정한다.<br>
	 *
	 * @param ReceiveLogVO recieveLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReceiveLog(ReceiveLogVO recieveLogVO, SignOnUserAccount account) throws EventException {
		JapanReceiveLogVO japanReceiveLogVO =(JapanReceiveLogVO) recieveLogVO;
		int rcvLogCount = 0;

		try {
			rcvLogCount = dbDao2.searchRcvLogCnt();

			if (rcvLogCount > 0) {
				japanReceiveLogVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyReceiveLog(japanReceiveLogVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO detailVO
	 * @param String pgmNo
	 * @return String BackEndJob Key
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO detailVO, String pgmNo) throws EventException {
		JapanCustomsTransmissionBackEndJob backEndJob = new JapanCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";

		try {
			if (pgmNo.equals("ESM_BKG_0730")) {
				backEndJob.setManifestTransmitVO(detailVO);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "NACCS Transmit.");
			}

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return resultStr;
	}

	/**
	 * DMF 메시지가 기존에 전송된 적이 있는 지 여부를 확인한다.<br>
	 *
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return int
	 * @exception EventException
	 */
	public int searchDmfSendLog(JapanManifestTransmitVO japanManifestTransmitVO) throws EventException {
		try {
			return dbDao.searchDmfSendLog(japanManifestTransmitVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Japan세관 EDI에서 허용되는 문자로만 필터링<br>
	 *
	 * @param String srcString
	 * @return String
	 * @exception EventException
	 */
	private String replaceAllowCharacter(String srcString) throws EventException{
		srcString = srcString.toUpperCase().replaceAll("‘", "'").replaceAll("’", "'").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("＂", "\"");
		return srcString.replaceAll("[^ A-Z0-9\\!\\\"\\#\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\n\\r]", " ");
	}

}

