/*=========================================================
Copyright(c) 2013 CyberLogitec
*@FileName : Jp24CustomsTransmissionBCImpl.java
*@FileTitle : Jp24CustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration.Jp24CustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration.Jp24CustomsTransmissionEAIDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpSendLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.CstmsEmlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.DepartureTimeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.EdiAdvJpCommonVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.ErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.FlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.JmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.SendMailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Jp24CustomsTransmission Business Logic Command implementation<br>
 * - OPUS-Jp24CustomsTransmission handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class Jp24CustomsTransmissionBCImpl extends BasicCommandSupport implements Jp24CustomsTransmissionBC {
	// Database Access Object
	private transient Jp24CustomsTransmissionDBDAO dbDao = null;
	private transient Jp24CustomsTransmissionEAIDAO eaiDao = null;


	/**
	 * Jp24CustomsTransmissionBCImpl 객체 생성
	 * Jp24CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public Jp24CustomsTransmissionBCImpl() {
		dbDao = new Jp24CustomsTransmissionDBDAO();
		eaiDao = new Jp24CustomsTransmissionEAIDAO();

	}

	/**
	 * [ESM_BKG_1501] Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO cargoInfoDetailVO
	 * @param SignOnUserAccount account
	 */
	public void transmitCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO cargoInfoDetailVO, SignOnUserAccount account) throws EventException {
		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD테이블의 RLX_DIV(JO_CD1) 정보 UPDATE
			cargoInfoHeaderVO.setUsrId(account.getUsr_id());
			dbDao.modifyAdvJpVslSkd(cargoInfoHeaderVO);
			this.transmitManifest(cargoInfoHeaderVO, cargoInfoDetailVO, account);

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501], [ESM_BKG_1501] Transmit - EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO cargoInfoDetailVO
	 * @param SignOnUserAccount account
	 */
	private void transmitManifest(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO cargoInfoDetailVO, SignOnUserAccount account) throws EventException {
		BookingUtil bookingUtil = new BookingUtil();
		JapanCustomsTransmissionDBDAO japanCustomsTransmissionDBDAO = new JapanCustomsTransmissionDBDAO();
		List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOList = new ArrayList<JapanManifestListSendHeaderInfoVO>();
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

		List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = new ArrayList<EdiAdvJpCommonVO>();
		HashMap<String, String> tempHashMap = new HashMap<String, String>();;
		DecimalFormat formatter = new DecimalFormat("00");
		StringBuilder completeflatFile = null;
		String replacementFlatFile = "";

		try {
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			String pgmDiv = cargoInfoHeaderVO.getPgmDiv();
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			String vvd = cargoInfoHeaderVO.getVvd();
			String vvdPolCd = cargoInfoHeaderVO.getPolCd();
			String blNo = cargoInfoDetailVO.getBlNo();

			// 삭제 전송시 무조건 CMR - 1으로 setting
			if ("Y".equals(cargoInfoHeaderVO.getDelTrasmitFlag())) {
				cargoInfoDetailVO.setTSType("CMR");
				cargoInfoDetailVO.setTCmrKind("1");
			}

			StringBuilder flatFileBody = new StringBuilder();

			// Flatfile Body (S)
			flatFileBody.append(cargoInfoDetailVO.getTCmrKind()).append("\n");

			// BKG_CSTMS_ADV_JP_BL 정보 조회
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			if ("NEW".equals(pgmDiv)) {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBl_N(cargoInfoHeaderVO, blNo);
			} else {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBl(cargoInfoHeaderVO, blNo);
			}
			if (ediAdvJpCommonVOList.size() > 0) {
				tempHashMap = ediAdvJpCommonVOList.get(0).getColumnValues();
				int endCount = 29;
				if ("NEW".equals(pgmDiv)) endCount = 32;
				for (int k=0; k<endCount; k++) flatFileBody.append(tempHashMap.get("data" + formatter.format(k))).append("\n");
			} else {
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n[Jp24CustomsTransmissionDBDAOSearchEdiAdvJpBlRSQL]").getMessage());
			}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

			// BKG_CSTMS_ADV_JP_CUST 정보 조회
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			if ("NEW".equals(pgmDiv)) {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpCustomer_N(blNo);
			} else {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpCustomer(blNo);
			}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			if (ediAdvJpCommonVOList.size() > 0) {
				tempHashMap = ediAdvJpCommonVOList.get(0).getColumnValues();
				for (int k=0; k<40; k++) flatFileBody.append(tempHashMap.get("data" + formatter.format(k))).append("\n");
			} else {
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n[Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomerRSQL]").getMessage());
			}

			// BKG_CSTMS_ADV_JP_MK 정보 조회
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			if ("NEW".equals(pgmDiv)) {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpMarkDesc_N(blNo);
			} else {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpMarkDesc(blNo);
			}
			if (ediAdvJpCommonVOList.size() > 0) {
				tempHashMap = ediAdvJpCommonVOList.get(0).getColumnValues();
				int endCount = 35;
				if ("NEW".equals(pgmDiv)) endCount = 43;
				for (int k=0; k<endCount; k++) flatFileBody.append(tempHashMap.get("data" + formatter.format(k))).append("\n");
			} else {
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n[Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDescRSQL]").getMessage());
			}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////

			// BKG_CSTMS_ADV_JP_CNTR 정보 조회
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			if ("NEW".equals(pgmDiv)) {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpContainer_N(blNo);
			} else {
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpContainer(blNo);
			}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			if (ediAdvJpCommonVOList.size() > 0) {
				List<EdiAdvJpCommonVO> ediAdvJpCntrSealNoList = new ArrayList<EdiAdvJpCommonVO>();
				for (EdiAdvJpCommonVO ediAdvJpCommonVO : ediAdvJpCommonVOList) {
					ediAdvJpCntrSealNoList = dbDao.searchEdiAdvJpCntrSealNo(blNo, ediAdvJpCommonVO.getData00().trim());    // param {bgkNo, cntrNo}
					if (ediAdvJpCntrSealNoList.size() > 0) {
						ediAdvJpCommonVO.setData01(ediAdvJpCntrSealNoList.get(0).getData01());
						ediAdvJpCommonVO.setData02(ediAdvJpCntrSealNoList.get(0).getData02());
						ediAdvJpCommonVO.setData03(ediAdvJpCntrSealNoList.get(0).getData03());
						ediAdvJpCommonVO.setData04(ediAdvJpCntrSealNoList.get(0).getData04());
						ediAdvJpCommonVO.setData05(ediAdvJpCntrSealNoList.get(0).getData05());
						ediAdvJpCommonVO.setData06(ediAdvJpCntrSealNoList.get(0).getData06());
					}
					tempHashMap = ediAdvJpCommonVO.getColumnValues();
					for (int k=0; k<15; k++) flatFileBody.append(tempHashMap.get("data" + formatter.format(k))).append("\n");
				}
			} else {
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing.\n\n[Jp24CustomsTransmissionDBDAOSearchEdiAdvJpContainerRSQL]").getMessage());
			}
			// Flatfile Body (E)

			// Flatfile Replacing characters allowed
			replacementFlatFile = this.replaceAllowCharacter(flatFileBody.toString());

			// Flatfile Header Setting
			String sendDate = bookingUtil.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3));
			String flatFileBodyLength = String.valueOf(replacementFlatFile.length());
			japanManifestListSendHeaderInfoVOList =  japanCustomsTransmissionDBDAO.searchSendHeader(vvd, vvdPolCd, account.getOfc_cd(), account.getUsr_id().replace("_", ""), cargoInfoDetailVO.getTSType(), sendDate, flatFileBodyLength, "");

			// Flatfile Complete
			completeflatFile = new StringBuilder();
			completeflatFile.append(japanManifestListSendHeaderInfoVOList.get(0).getHeader()).append("\n");
			completeflatFile.append(japanManifestListSendHeaderInfoVOList.get(0).getHeader2()).append("\n");
			completeflatFile.append(replacementFlatFile);

			// FlatFile 전송
			String cstmsEdiHeader = "";
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			String headerParam = "JP_" + cargoInfoDetailVO.getTSType();
			if ("NEW".equals(pgmDiv)) headerParam = headerParam + "-7";
			cstmsEdiHeader = bookingUtil.searchCstmsEdiHeaderNew(headerParam);
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(cstmsEdiHeader + "\n" + completeflatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			// (eaiDAO.sendFlatFile에 LIVE에서 TEST용으로 사용하는 임시 송신MQ정보가 하드코딩되어 있음)
			//flatFileAckVO = eaiDao.sendFlatFile(sendFlatFileVO);
			if ("E".equals(flatFileAckVO.getAckStsCd())) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			// 전송결과 저장
			AdvJpSendLogVO advJpSendLogVO = new AdvJpSendLogVO();
			advJpSendLogVO.setTSType(cargoInfoDetailVO.getTSType());
			advJpSendLogVO.setMsgSndSeq(japanManifestListSendHeaderInfoVOList.get(0).getHeader().substring(36, 41));
			advJpSendLogVO.setMsgSndDiv(blNo);    // B/L No.
			advJpSendLogVO.setSndDt(sendDate);
			advJpSendLogVO.setOfcCd(account.getOfc_cd());
			advJpSendLogVO.setLogSeq(cargoInfoDetailVO.getTCmrKind());
			advJpSendLogVO.setVvd(vvd);
			advJpSendLogVO.setBlNo(blNo);
			advJpSendLogVO.setPodCd(cargoInfoDetailVO.getVvdPodCd());   // 조회조건이 아닌 sheet date
			advJpSendLogVO.setPodSplitNo(cargoInfoHeaderVO.getPodSplitNo());
			advJpSendLogVO.setPolCd(vvdPolCd);
			advJpSendLogVO.setPolSplitNo(cargoInfoHeaderVO.getPolSplitNo());
			advJpSendLogVO.setDelCd(cargoInfoDetailVO.getBkgDelCd());
			advJpSendLogVO.setFlatFile(completeflatFile.toString());
			advJpSendLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());
			advJpSendLogVO.setCallSgnNo(cargoInfoHeaderVO.getCallSgnNo());
			advJpSendLogVO.setIbCssmVoyNo(cargoInfoHeaderVO.getIbCssmVoyNo());
			advJpSendLogVO.setCorrRsnCd(cargoInfoHeaderVO.getCorrRsnCd());
			advJpSendLogVO.setCorrRsn(cargoInfoHeaderVO.getCorrRsn());
			advJpSendLogVO.setUsrId(account.getUsr_id());
			dbDao.addAdvJpSendLog(advJpSendLogVO);

		} catch (DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502] B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 */
	public void transmitBLInquiry(AdvJpBlVO advJpBlVO, SignOnUserAccount account) throws EventException {
		CargoInfoHeaderVO cargoInfoHeaderVO = new CargoInfoHeaderVO();
		CargoInfoDetailVO cargoInfoDetailVO = new CargoInfoDetailVO();

		try {
			cargoInfoHeaderVO.setVvd(advJpBlVO.getVvd());
			cargoInfoHeaderVO.setPodSplitNo(advJpBlVO.getPodSplitNo());
			cargoInfoHeaderVO.setPolCd(advJpBlVO.getPolCd());
			cargoInfoHeaderVO.setPolSplitNo(advJpBlVO.getPolSplitNo());
			cargoInfoHeaderVO.setCorrRsnCd(advJpBlVO.getCorrRsnCd());
			cargoInfoHeaderVO.setCorrRsn(advJpBlVO.getCorrRsn());

			if ("9".equals(advJpBlVO.getTCmrKind())) {
				cargoInfoDetailVO.setTSType("AMR");
			} else {
				cargoInfoDetailVO.setTSType("CMR");
			}
			cargoInfoDetailVO.setTCmrKind(advJpBlVO.getTCmrKind());
			cargoInfoDetailVO.setBlNo(advJpBlVO.getBlNo());
			cargoInfoDetailVO.setVvdPodCd(advJpBlVO.getPodCd());
			cargoInfoDetailVO.setBkgDelCd(advJpBlVO.getBkgDelCd());
			cargoInfoDetailVO.setPodDiv(advJpBlVO.getPodDiv());
			cargoInfoDetailVO.setRvisCntrCustTpCd(advJpBlVO.getRvisCntrCustTpCd());

			this.transmitManifest(cargoInfoHeaderVO, cargoInfoDetailVO, account);

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception EventException
	 */
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws EventException {

		try {
			return dbDao.searchDepartureTime(departureTimeVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1503], [BATCH] AtdTransmitForJp24
	 * Departure Time Registration EDI 전송<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @param String eventName
	 * @exception EventException
	 */
	public void transmitDepartureTime(DepartureTimeVO departureTimeVO, String eventName) throws EventException {
		com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil bookingUtil = new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil();
		com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO japanCustomsTransmissionDBDAO =
				new com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO();
		List<com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO> JapanManifestListSendHeaderInfoForDmfVOList =
				new ArrayList<com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO>();
		com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO flatFileAckVO = new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO();
		com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO sendFlatFileVO = new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO();

		List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = new ArrayList<EdiAdvJpCommonVO>();
		HashMap<String, String> mapEdiAdvJpCommonVO = new HashMap<String, String>();
		DecimalFormat formatter = new DecimalFormat("00");
		StringBuilder completeflatFile = new StringBuilder();
		String replacementFlatFile = "";

		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD테이블의 RLX_DIV(JO_CD1) 정보 UPDATE
			CargoInfoHeaderVO cargoInfoHeaderVO = new CargoInfoHeaderVO();
			cargoInfoHeaderVO.setRlxDiv(departureTimeVO.getRlxDiv());
			cargoInfoHeaderVO.setUsrId(departureTimeVO.getUsrId());
			cargoInfoHeaderVO.setVvd(departureTimeVO.getVvd());
			cargoInfoHeaderVO.setPolCd(departureTimeVO.getPolCd());
			cargoInfoHeaderVO.setIbCssmVoyNo(departureTimeVO.getIbCssmVoyNo());
			dbDao.modifyAdvJpVslSkd(cargoInfoHeaderVO);

			// Flatfile Body(S)
			ediAdvJpCommonVOList = dbDao.searchEdiAdvJpVslSkd(departureTimeVO);
			mapEdiAdvJpCommonVO = ediAdvJpCommonVOList.get(0).getColumnValues();
			StringBuilder flatFileBody = new StringBuilder();
			for(int k=0; k<12; k++) flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\n");
			// Flatfile Body(E)

			// E메일 전송시 RELAXED AREA ID
			//String rlxDiv = ediAdvJpCommonVOList.get(0).getData10();
			// BKG_CSTMS_ADV_JP_SND_LOG에 저장 할 LOG SEQ 추출
			String logSeq = ediAdvJpCommonVOList.get(0).getData00();

			// Flatfile Replacing characters allowed
			replacementFlatFile = this.replaceAllowCharacter(flatFileBody.toString());

			/// Flatfile Header Setting
			String sendDate = bookingUtil.searchLocalTime(departureTimeVO.getCntCd() + departureTimeVO.getOfcCd().substring(0, 3));
			String vvd = departureTimeVO.getVvd();
			String polCd = departureTimeVO.getPolCd();
			JapanManifestListSendHeaderInfoForDmfVOList = japanCustomsTransmissionDBDAO.searchSendHeaderForDmf(vvd, polCd, departureTimeVO.getOfcCd(), departureTimeVO.getUsrId().replace("_", ""), replacementFlatFile.toString(), sendDate);

			// Flatfile Complete
			completeflatFile.append(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader().replaceAll("DMF", "ATD")).append("\n");
			completeflatFile.append(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader2().replaceAll("DMF", "ATD")).append("\n");
			completeflatFile.append(replacementFlatFile);

			// FlatFile 전송
			String cstmsEdiHeader = bookingUtil.searchCstmsEdiHeaderNew("JP_ATD");
			sendFlatFileVO.setFlatFile(cstmsEdiHeader + "\n" + completeflatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			// 전송결과 저장
			AdvJpSendLogVO advJpSendLogVO = new AdvJpSendLogVO();
			advJpSendLogVO.setTSType("ATD");
			advJpSendLogVO.setMsgSndSeq(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader().substring(36, 41));
			advJpSendLogVO.setMsgSndDiv(vvd);    // VVD
			advJpSendLogVO.setSndDt(sendDate);
			advJpSendLogVO.setOfcCd(departureTimeVO.getOfcCd());
			advJpSendLogVO.setLogSeq(logSeq);
			advJpSendLogVO.setVvd(vvd);
			advJpSendLogVO.setPolCd(polCd);
			advJpSendLogVO.setPolSplitNo(departureTimeVO.getPolSplitNo());
			advJpSendLogVO.setFlatFile(completeflatFile.toString());
			advJpSendLogVO.setEdiRefId(cstmsEdiHeader.substring(62).trim());
			advJpSendLogVO.setUsrId(departureTimeVO.getUsrId());
			dbDao.addAdvJpSendLog(advJpSendLogVO);

			// BKG_CSTMS_ADV_JP_VSL_SKD 테이블에 전송Flag Update
			dbDao.modifyTrnsFlagOfAdvJpVslSkd(departureTimeVO);

		} catch(EventException ex) {
			log.error("\n\nEventException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception EventException
	 */
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws EventException {

		try {
			return dbDao.searchJmsReport(jmsReportVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException {
		List<ErrorReportVO> errorReportVOList = new ArrayList<ErrorReportVO>();

		try {
			String jpMsgTpId = errorReportVO.getJpMsgTpId();

			if ("SAMR".equals(jpMsgTpId) || "SCMR".equals(jpMsgTpId)) {
				errorReportVOList = dbDao.searchErrorReportForAmrCmr(errorReportVO);

			} else if ("SAS111".equals(jpMsgTpId)) {
				ErrorReportVO tempErrorReportVO = new ErrorReportVO();
				for (AdvJpReceiveLogVO advJpReceiveLogVO : dbDao.searchErrorReportForSas111(errorReportVO)) {
					String[] ediRcvMsgCtntRowArray = advJpReceiveLogVO.getEdiRcvMsgCtnt().trim().split("\n");
					int ediRcvMsgCtntRowKnt = (ediRcvMsgCtntRowArray.length > 22 ? 23 : ediRcvMsgCtntRowArray.length);
					StringBuilder errorMsg = new StringBuilder();
					if (ediRcvMsgCtntRowKnt > 14) {
						for (int i=15; i<ediRcvMsgCtntRowKnt; i++) {
							errorMsg.append(ediRcvMsgCtntRowArray[i]);
						}
					}
					tempErrorReportVO = new ErrorReportVO();
					tempErrorReportVO.setHblDiv(advJpReceiveLogVO.getHblDiv());
					tempErrorReportVO.setHblNo(advJpReceiveLogVO.getHblNo());
					tempErrorReportVO.setAttrCtnt1(advJpReceiveLogVO.getRcvKeyDatCtnt());
					tempErrorReportVO.setAttrCtnt4(errorMsg.toString().trim());
					errorReportVOList.add(tempErrorReportVO);
				}

			} else {
				errorReportVOList = dbDao.searchErrorReport(errorReportVO);
			}
			return errorReportVOList;

		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception EventException
	 */
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws EventException {
		List<FlatFileVO> returnflatFileVOList = new ArrayList<FlatFileVO>();
		FlatFileVO returnflatFileVO = null;

		try {
			List<FlatFileVO> tempFlatFileVOList = dbDao.searchSendFlatFile(flatFileVO);
			if (tempFlatFileVOList != null && tempFlatFileVOList.size() > 0) {
				String[] flatFileRowArray = tempFlatFileVOList.get(0).getFlatFile().split("\n");
				for(int i=0; i<flatFileRowArray.length; i++) {
					returnflatFileVO = new FlatFileVO();
					returnflatFileVO.setFlatFile(flatFileRowArray[i]);
					returnflatFileVOList.add(returnflatFileVO);
				}
			}
			return returnflatFileVOList;
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [EDI_T_BKG_T_JP24CUS_ACK]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForJapan24HR(String flatFile) throws EventException {
		List<AdvJpSendLogVO> advJpSendLogVOList = new ArrayList<AdvJpSendLogVO>();
		List<AdvJpReceiveLogVO> insertVOList = new ArrayList<AdvJpReceiveLogVO>();
		AdvJpReceiveLogVO advJpReceiveLogVO = new AdvJpReceiveLogVO();
		AdvJpReceiveLogVO tempReceiveLogVO = new AdvJpReceiveLogVO();
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String polCd = "";
		String podCd = "";
		String blNo = "";
		String ediRefId = "";
		String jpMsgTpId = "";

		try {
			String[] rowArray = flatFile.split("\n");
			String[] bodyRowArray = (String[]) org.apache.commons.lang.ArrayUtils.remove(rowArray, 0);

			if (bodyRowArray[0].length() > 397) {
				String tempTitle = bodyRowArray[0].substring(8, 14).trim();
				String creUserId = bodyRowArray[0].substring(253, 263).trim();
				if ("".equals(creUserId)) creUserId = "EDI CUSACK";

				if ("SAS108".equals(tempTitle)) {
					tempReceiveLogVO.setCallSgnNo(bodyRowArray[1].trim());
					tempReceiveLogVO.setIbCssmVoyNo(bodyRowArray[2].trim());
					tempReceiveLogVO.setJpMsgTpId("ATD");
					List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCallsign(tempReceiveLogVO);
					if (tempReceiveLogVOList.size() > 0) {
						vslCd = tempReceiveLogVOList.get(0).getVslCd();
						skdVoyNo = tempReceiveLogVOList.get(0).getSkdVoyNo();
						skdDirCd = tempReceiveLogVOList.get(0).getSkdDirCd();
						polCd = tempReceiveLogVOList.get(0).getPolCd();
					}
					podCd = bodyRowArray[10].trim();
					String line16 = "";
					String line18 = "";
					for(int i=14; i<bodyRowArray.length; i=i+7) {
						if (i+6 > bodyRowArray.length || bodyRowArray[i].trim().length() < 16) break;
						advJpReceiveLogVO = new AdvJpReceiveLogVO();
						advJpReceiveLogVO.setJpMsgTpId(tempTitle);
						advJpReceiveLogVO.setJpSvcId(tempTitle);
						advJpReceiveLogVO.setVslCd(vslCd);
						advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
						advJpReceiveLogVO.setSkdDirCd(skdDirCd);
						advJpReceiveLogVO.setPolCd(polCd);
						advJpReceiveLogVO.setPodCd(podCd);
						advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
						// 15라인부터 다건의 B/L일 경우에도 처리
						advJpReceiveLogVO.setBkgNo(bodyRowArray[i].substring(4).trim());
						line16 = bodyRowArray[i+1].trim();
						line18 = bodyRowArray[i+3].trim();
						advJpReceiveLogVO.setRcvKeyDatCtnt(line16 + "/" + bodyRowArray[i+2].trim() + "/" + line18 + "/" + bodyRowArray[i+4].trim() + "/" + bodyRowArray[i+5].trim() + "/" + bodyRowArray[i+6].trim());
						advJpReceiveLogVO.setRcvSeq(String.valueOf(i + 1));
						advJpReceiveLogVO.setUsrId(creUserId);
						insertVOList.add(advJpReceiveLogVO);
					}
					dbDao.addAdvJpReceiveLog(insertVOList);


				} else if ("SAS135".equals(tempTitle)) {
					tempReceiveLogVO.setIbCssmVoyNo(bodyRowArray[6].trim());
					List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCssmVoy(tempReceiveLogVO);
					if (tempReceiveLogVOList.size() > 0) {
						skdVoyNo = tempReceiveLogVOList.get(0).getSkdVoyNo();
						skdDirCd = tempReceiveLogVOList.get(0).getSkdDirCd();
					}
					blNo = bodyRowArray[1].substring(4).trim();
					advJpSendLogVOList = dbDao.searchAdvJpSndLogByBlNo(blNo);
					if (advJpSendLogVOList.size() > 0) {
						vslCd = advJpSendLogVOList.get(0).getVvd().substring(0, 4);
						polCd = advJpSendLogVOList.get(0).getPolCd();
					}
					advJpReceiveLogVO.setJpMsgTpId(tempTitle);
					advJpReceiveLogVO.setJpSvcId(tempTitle);
					advJpReceiveLogVO.setBkgNo(blNo);
					advJpReceiveLogVO.setRcvKeyDatCtnt(bodyRowArray[4].trim());
					advJpReceiveLogVO.setVslCd(vslCd);
					advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
					advJpReceiveLogVO.setSkdDirCd(skdDirCd);
					advJpReceiveLogVO.setPolCd(polCd);
					advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
					advJpReceiveLogVO.setRcvSeq("1");
					advJpReceiveLogVO.setUsrId(creUserId);
					insertVOList.add(advJpReceiveLogVO);
					dbDao.addAdvJpReceiveLog(insertVOList);

					
				} else {
					/*************************************
					 * E-Mail 전송 로직이 덧붙는 MSG_ID
					 *************************************/
					AdvJpSendLogVO advJpSendLogVO = new AdvJpSendLogVO();
					if ("SAS111".equals(tempTitle)) {
						advJpReceiveLogVO.setJpMsgTpId(tempTitle);
						advJpReceiveLogVO.setJpSvcId(tempTitle);
						String hBlNo = "";
						if ("".equals(bodyRowArray[2].substring(4).trim())) {
							// 세번째 라인에 값이 없으면 두번째 라인이 Master B/L
							blNo = bodyRowArray[1].substring(4).trim();
						} else {
							// 세번째 라인에 값이 있으면 세번째 라인이 Master B/L
							blNo = bodyRowArray[2].substring(4).trim();
							hBlNo = bodyRowArray[1].substring(4).trim();
						}
						advJpReceiveLogVO.setBkgNo(blNo);
						advJpReceiveLogVO.setHblNo(hBlNo);

						// SND_LOG테이블에 보낸 History 조회
						advJpSendLogVOList = dbDao.searchAdvJpSndLogByBlNo(blNo);
						if (advJpSendLogVOList.size() > 0) {
							// SND_LOG테이블에 보낸 History가 있으면
							advJpSendLogVO = advJpSendLogVOList.get(0);
							vslCd = advJpSendLogVO.getVvd().substring(0, 4);
							polCd = advJpSendLogVO.getPolCd();
							podCd = advJpSendLogVO.getPodCd();

							tempReceiveLogVO.setCallSgnNo(bodyRowArray[7].trim());
							tempReceiveLogVO.setIbCssmVoyNo(bodyRowArray[9].trim());
							List<AdvJpReceiveLogVO> tempVoyageInfoVOList = dbDao.getAdvJpVslByCssmVoy(tempReceiveLogVO);
							if (tempVoyageInfoVOList.size() > 0) {
								skdVoyNo = tempVoyageInfoVOList.get(0).getSkdVoyNo();
								skdDirCd = tempVoyageInfoVOList.get(0).getSkdDirCd();
							}
						} else {
							// SND_LOG테이블에 보낸 History가 없으면
							advJpSendLogVOList = dbDao.searchBkgVvdByBlNo(blNo);
							if (advJpSendLogVOList.size() > 0) {
								advJpSendLogVO = advJpSendLogVOList.get(0);
								vslCd = advJpSendLogVO.getVvd().substring(0, 4);
								polCd = advJpSendLogVO.getPolCd();
							}
						}

						advJpReceiveLogVO.setRcvKeyDatCtnt(bodyRowArray[3].trim());
						advJpReceiveLogVO.setVslCd(vslCd);
						advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
						advJpReceiveLogVO.setSkdDirCd(skdDirCd);
						advJpReceiveLogVO.setPolCd(polCd);
						advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
						advJpReceiveLogVO.setRcvSeq("1");
						advJpReceiveLogVO.setUsrId(creUserId);
						insertVOList.add(advJpReceiveLogVO);
						dbDao.addAdvJpReceiveLog(insertVOList);

						// E-Mail 전송 (by BL_NO)
						advJpSendLogVO.setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
						advJpSendLogVO.setRcvKeyDatCtnt(advJpReceiveLogVO.getRcvKeyDatCtnt());
						advJpSendLogVO.setRcvPreNotice(bodyRowArray[4].trim());
						advJpSendLogVO.setHblNo(hBlNo);
						this.sendEmailforJP24ByBlNo(advJpSendLogVO);


					} else if ("SAS112".equals(tempTitle)) {    // 기 수신된 SAS111메세지에 대한 성공처리결과 update
						advJpReceiveLogVO.setJpMsgTpId(tempTitle);
						advJpReceiveLogVO.setJpSvcId(tempTitle);
						String hBlNo = "";
						if ("".equals(bodyRowArray[2].substring(4).trim())) {
							// 세번째 라인에 값이 없으면 두번째 라인이 Master B/L
							blNo = bodyRowArray[1].substring(4).trim();
						} else {
							// 세번째 라인에 값이 있으면 세번째 라인이 Master B/L
							blNo = bodyRowArray[2].substring(4).trim();
							hBlNo = bodyRowArray[1].substring(4).trim();
						}
						advJpReceiveLogVO.setBkgNo(blNo);
						advJpReceiveLogVO.setHblNo(hBlNo);

						// SND_LOG테이블에 보낸 History 조회
						advJpSendLogVOList = dbDao.searchAdvJpSndLogByBlNo(blNo);
						// SND_LOG테이블에 보낸 History가 없으면
						if (advJpSendLogVOList.size() < 1) advJpSendLogVOList = dbDao.searchBkgVvdByBlNo(blNo);
						if (advJpSendLogVOList.size() > 0) advJpSendLogVO = advJpSendLogVOList.get(0);

						advJpReceiveLogVO.setRcvKeyDatCtnt(bodyRowArray[3].trim());
						advJpReceiveLogVO.setUsrId(creUserId);

						// E-Mail 전송 (by BL_NO)
						advJpSendLogVO.setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
						advJpSendLogVO.setRcvKeyDatCtnt(advJpReceiveLogVO.getRcvKeyDatCtnt());
						advJpSendLogVO.setHblNo(hBlNo);
						this.sendEmailforJP24ByBlNo(advJpSendLogVO);

						advJpReceiveLogVO.setJpMsgTpId("SAS111");
						advJpReceiveLogVO.setJpSvcId("SAS111");
						dbDao.modifyJpBatNoOfAdvJpReceiveLog(advJpReceiveLogVO);


					} else if (tempTitle.indexOf("*SAMR") > -1 || tempTitle.indexOf("*SCMR") > -1) {
						ediRefId = bodyRowArray[0].substring(34, 51).trim();    // 34번째부터 (34번째 위치포함) 17자리
						jpMsgTpId = tempTitle.substring(1, 5);
						blNo = bodyRowArray[2].substring(4).trim();
						advJpSendLogVOList = dbDao.searchAdvJpSndLogByBlNo(blNo);
						if (advJpSendLogVOList.size() > 0) {
							advJpSendLogVO = advJpSendLogVOList.get(0);
							polCd = advJpSendLogVO.getPolCd();
							podCd = advJpSendLogVO.getPodCd();
						}

						int rcvKeyDatCtntKnt = bodyRowArray[1].trim().length() / 15;
						for(int k=0; k<rcvKeyDatCtntKnt; k++) {
							advJpReceiveLogVO = new AdvJpReceiveLogVO();
							advJpReceiveLogVO.setJpMsgTpId(jpMsgTpId);
							advJpReceiveLogVO.setJpSvcId(jpMsgTpId);
							advJpReceiveLogVO.setRcvKeyDatCtnt(bodyRowArray[1].trim().substring(k*15, (k+1)*15));
							advJpReceiveLogVO.setBkgNo(bodyRowArray[2].substring(4).trim());
							advJpReceiveLogVO.setPolCd(polCd);
							advJpReceiveLogVO.setPodCd(podCd);
							advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
							advJpReceiveLogVO.setRcvSeq(String.valueOf(k + 1));
							advJpReceiveLogVO.setEdiRefId(ediRefId);
							advJpReceiveLogVO.setUsrId(creUserId);
							insertVOList.add(advJpReceiveLogVO);
						}
						if (insertVOList.size() > 0) {
							dbDao.addAdvJpReceiveLog(insertVOList);
							dbDao.modifyRqstFlgOfAdvJpSndLog(advJpReceiveLogVO);
							// E-Mail 전송
							String rcvKeyDatCtnt = insertVOList.get(0).getRcvKeyDatCtnt();
							// RcvKeyDatCtnt가 W로 시작하지 않거나, 00000이 아닐때만
							if (!rcvKeyDatCtnt.startsWith("W") && !"00000".equals(rcvKeyDatCtnt.substring(0, 5))) {
								advJpSendLogVO.setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
								advJpSendLogVO.setRcvKeyDatCtnt(advJpReceiveLogVO.getRcvKeyDatCtnt());
								this.sendEmailforJP24ByBlNo(advJpSendLogVO);
							}
						}


					} else if (tempTitle.indexOf("*SATD") > -1) {
						tempReceiveLogVO.setCallSgnNo(bodyRowArray[2].trim());
						tempReceiveLogVO.setIbCssmVoyNo(bodyRowArray[3].trim());
						List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCssmVoy(tempReceiveLogVO);
						if (tempReceiveLogVOList.size() > 0) {
							skdVoyNo = tempReceiveLogVOList.get(0).getSkdVoyNo();
							skdDirCd = tempReceiveLogVOList.get(0).getSkdDirCd();
						}
						ediRefId = bodyRowArray[0].substring(34, 51).trim();    // 34번째부터 (34번째 위치포함) 17자리
						advJpSendLogVOList = dbDao.searchAdvJpSndLogByEdiRefId(ediRefId);
						if (advJpSendLogVOList.size() > 0) {
							advJpSendLogVO = advJpSendLogVOList.get(0);
							vslCd = advJpSendLogVO.getVvd().substring(0, 4);
							polCd = advJpSendLogVO.getPolCd();
							podCd = advJpSendLogVO.getPodCd();
						}

						jpMsgTpId = tempTitle.substring(1, 5);
						String rcvKeyDatCtnt = bodyRowArray[1].trim();
						int rcvKeyDatCtntKnt = rcvKeyDatCtnt.length() / 15;
						for(int k=0; k<rcvKeyDatCtntKnt; k++) {
							advJpReceiveLogVO = new AdvJpReceiveLogVO();
							advJpReceiveLogVO.setJpMsgTpId(jpMsgTpId);
							advJpReceiveLogVO.setJpSvcId(jpMsgTpId);
							advJpReceiveLogVO.setRcvKeyDatCtnt(rcvKeyDatCtnt.substring(k*15, (k+1)*15));
							advJpReceiveLogVO.setVslCd(vslCd);
							advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
							advJpReceiveLogVO.setSkdDirCd(skdDirCd);
							advJpReceiveLogVO.setPolCd(polCd);
							advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
							advJpReceiveLogVO.setRcvSeq(String.valueOf(k + 1));
							advJpReceiveLogVO.setEdiRefId(bodyRowArray[0].substring(34, 51).trim());
							advJpReceiveLogVO.setIbCssmVoyNo(bodyRowArray[3].trim());
							advJpReceiveLogVO.setUsrId(creUserId);
							insertVOList.add(advJpReceiveLogVO);
						}
						if (insertVOList.size() > 0) {
							dbDao.addAdvJpReceiveLog(insertVOList);
							dbDao.modifyRqstFlgOfAdvJpSndLog(advJpReceiveLogVO);
							// E-Mail 전송
							advJpSendLogVO.setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
							advJpSendLogVO.setRcvKeyDatCtnt(advJpReceiveLogVO.getRcvKeyDatCtnt());
							this.sendEmailforJP24ByVoyNo(advJpSendLogVO);
						}
					}
				}
			}

		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * receiveEDIForJapan24HR, sendEmailForNoResponse, receiveEDIForJapan24HR에서 호출 (by BL_NO)
	 * E메일 전송<br>
	 *
	 * @param AdvJpSendLogVO advJpSendLogVO
	 * @exception EventException
	 */
	private void sendEmailforJP24ByBlNo(AdvJpSendLogVO advJpSendLogVO) throws EventException {
		String subject = "";
		StringBuilder textContent = new StringBuilder();
		String ediMsg = "AMR/CMR";
		String ediMsgTpId = "";

		String JpSndLogId = advJpSendLogVO.getJpSndLogId();
		String rcvKeyDatCtnt = advJpSendLogVO.getRcvKeyDatCtnt();
		String blNo = advJpSendLogVO.getBlNo();
		String hBlNo = advJpSendLogVO.getHblNo();
		String vvd = advJpSendLogVO.getVvd();
		String polCd = advJpSendLogVO.getPolCd();
		String polNm = advJpSendLogVO.getPolNm().trim();
		String podCd = advJpSendLogVO.getPodCd();
		String podNm = advJpSendLogVO.getPodNm().trim();
		String shprNm = advJpSendLogVO.getShprNm().trim();
		String cneeNm = advJpSendLogVO.getCneeNm().trim();


		try {
			if ("BAMR".equals(JpSndLogId) || "BCMR".equals(JpSndLogId)) {
				// - 1. No Response (Japan AMR/CMR)
				subject = ("No Response for BL Number : " + blNo);
				textContent.append("\n\nAcknowledgement has not been received for the following BL(s)");
				textContent.append("\n\nBL Number : " + blNo);
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n\nDischarge Port : " + podNm);
				textContent.append("\n");
				textContent.append("\n\n\n\n\nDisclaimer : No response has been received in OPUS for the above BL(s), please contact your Regional Help Desk.");
				// E-Mail 수신자 구분
				ediMsgTpId = "No Response";


			} else if ("TAMR".equals(JpSndLogId) || "TCMR".equals(JpSndLogId)) {
				// - 2. EDI Technical Failure (Japan AMR/CMR)
				subject = ("Technical Failure BL Number : " + blNo);
				textContent.append("\n\nBL Number : " + blNo);
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n\nDischarge Port : " + podNm);
				textContent.append("\n");
				textContent.append("\n\n\n\n\nDisclaimer : An error has occurred in OPUS EDI. Please contact your Regional Help Desk to resolve this issue.");
				// E-Mail 수신자 구분
				ediMsgTpId = "EDI Technical Failure";


			} else if ("SAS112".equals(JpSndLogId)) {
				// - 6. DNL Removal (Japan AMR/CMR)
				// - 7. DNL Removal (Japan AMR/CMR) for House BL
				// - 9. Hold, Do Not Unload, SPD Removal (Japan AMR/CMR)
				// - 11. Hold, Do Not Unload, SPD Removal (Japan AMR/CMR) for House BL
				String subjectDiv = "";
				String contentDiv = "";
				if ("DNL".equals(rcvKeyDatCtnt)) {
					subjectDiv = "Do not Load Removal";
						// (원본) Disclaimer : DNL Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.
					contentDiv = "Disclaimer : DNL Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.";
					ediMsgTpId = "DNL/DNL Removals";    // E-Mail 수신자 구분
				} else if ("DNU".equals(rcvKeyDatCtnt)) {
					subjectDiv = "Do not unload Removal";
						// (원본) Disclaimer : Hold Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.
					contentDiv = "Disclaimer : DNU Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.";
					ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
				} else if ("SPD".equals(rcvKeyDatCtnt)) {
					subjectDiv = "SPD Removal";
					contentDiv = "Disclaimer : SPD Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.";
					ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
				} else if ("HLD".equals(rcvKeyDatCtnt)) {
					subjectDiv = "Hold Removal";
					contentDiv = "Disclaimer : Hold Removal has been received from Japan Customs. For further assistance, please contact your Regional Help Desk.";
					ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
				}

				if (!"".equals(hBlNo)) {
					subject = (subjectDiv + " for House BL : " + podCd + "(POD) - " + polCd + "(POL) - " + blNo);
				} else {
					subject = (subjectDiv + " : " + podCd + "(POD) - " + polCd + "(POL) - " + blNo);
				}
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nBL Number : " + blNo);
				if (!"".equals(hBlNo)) textContent.append("\n\nNVOCC House BL Number : " + hBlNo);
				textContent.append("\n\nShipper : " + shprNm);
				textContent.append("\n\nConsignee : " + cneeNm);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n\nDischarge Port : " + podNm);
				textContent.append("\n");
				textContent.append("\n\n\n\n\n" + contentDiv + "\n\n");


			} else {
				ErrorReportVO inErrorReportVO = new ErrorReportVO();
				inErrorReportVO.setBlNo(blNo);
				inErrorReportVO.setJpMsgTpId(JpSndLogId);
				List<ErrorReportVO> errorReportVOList = this.searchErrorReport(inErrorReportVO);

				if ("SAMR".equals(JpSndLogId) || "SCMR".equals(JpSndLogId)) {
					// - 3. Rejection (Japan AMR/CMR)
					subject = ("Rejection : " + podCd + "(POD) - " + polCd + "(POL) - " + blNo);
					textContent.append("\n\nVVD : " + vvd);
					textContent.append("\n\nLoad Port : " + polNm);
					textContent.append("\n\nDischarge Port : " + podNm);
					textContent.append("\n\nBL Number : " + blNo);
					textContent.append("\n");
					if (errorReportVOList.size() > 0) {
						for (ErrorReportVO outErrorReportVO : errorReportVOList) {
							textContent.append("\nReason(s) For Rejection : " + outErrorReportVO.getAttrCtnt4());
						}
						textContent.append("\n");
					}
					textContent.append("\n\n\n\n\nDisclaimer : Rejection has been received from Japan Customs; please take necessary action based on the reason of rejection. For further assistance, please contact your Regional Help Desk.");
					// E-Mail 수신자 구분
					ediMsgTpId = "Rejection(Error)";


				} else if ("SAS111".equals(JpSndLogId)) {
					// - 4. DNL (Japan AMR/CMR)
					// - 5. DNL (Japan AMR/CMR)) to House BL
					// - 8. Hold /Do Not Unload/SPD (Japan AMR/CMR)
					// - 10. Hold /Do Not Unload/SPD (Japan AMR/CMR) for House B/L
					String rcvPreNotice = advJpSendLogVO.getRcvPreNotice();
					String subjectDiv = "";
					String reasonDiv = "";
					String contentDiv = "";
					if ("DNL".equals(rcvKeyDatCtnt)) {
						subjectDiv = "Do Not Load";
						reasonDiv = "DNL";
							// (원본) Disclaimer : Do not load the above container(s). DNL has been received from Japan Customs; please take necessary action based on the reason of DNL. For further assistance, please contact your Regional Help Desk.
						contentDiv = "Disclaimer : Do not load the above container(s). DNL has been received from Japan Customs; please take necessary action based on the reason of DNL. For further assistance, please contact your Regional Help Desk.";
						ediMsgTpId = "DNL/DNL Removals";    // E-Mail 수신자 구분
					} else if ("DNU".equals(rcvKeyDatCtnt)) {
						subjectDiv = "Do Not Unload";
						reasonDiv = "DNU";
							// (원본) Disclaimer : Hold the above container(s). Hold has been received from Japan Customs; please take necessary action based on the reason of Hold. For further assistance, please contact your Regional Help Desk.
						contentDiv = "Disclaimer : Do not unload the above container(s). DNU has been received from Japan Customs; please take necessary action based on the reason of DNU. For further assistance, please contact your Regional Help Desk.";
						ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
					} else if ("SPD".equals(rcvKeyDatCtnt)) {
						subjectDiv = "SPD";
						reasonDiv = "Submission Past Due";
						contentDiv = "Disclaimer : Submission Past Due has been received from Japan Customs; cargo should not be unloaded unless agreed by Customs. For further assistance, please contact your Regional Help Desk.";
						ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
					} else if ("HLD".equals(rcvKeyDatCtnt)) {
						subjectDiv = "Hold";
						reasonDiv = "Hold";
						contentDiv = "Disclaimer : Hold has been received from Japan Customs; please take necessary action based on the reason of Hold. For further assistance, please contact your Regional Help Desk.";
						ediMsgTpId = "Hold/Hold Removals(HLD,DNU,SPD)";    // E-Mail 수신자 구분
					}

					if (!"".equals(hBlNo)) {
						subject = (subjectDiv + " for House BL : " + podCd + "(POD) - " + polCd + "(POL) - " + blNo);
					} else {
						subject = (subjectDiv + " : " + podCd + "(POD) - " + polCd + "(POL) - " + blNo);
					}
					textContent.append("\n\nVVD : " + vvd);
					textContent.append("\n\nBL Number : " + blNo);
					if (!"".equals(hBlNo)) textContent.append("\n\nNVOCC House BL Number : " + hBlNo);
					textContent.append("\n\nShipper : " + shprNm);
					textContent.append("\n\nConsignee : " + cneeNm);
					textContent.append("\n\nLoad Port : " + polNm);
					textContent.append("\n\nDischarge Port : " + podNm);
					textContent.append("\n");
					if (errorReportVOList.size() > 0) {
						for (ErrorReportVO outErrorReportVO : errorReportVOList) {
							textContent.append("\nReason(s) For " + reasonDiv + " : " + rcvKeyDatCtnt + " / "  + outErrorReportVO.getAttrCtnt4());
						}
						if (!"".equals(rcvPreNotice)) textContent.append("\n\n" + rcvPreNotice + "\n");
					}
					textContent.append("\n\n\n\n\n" + contentDiv + "\n\n");
				}
			}

			SendMailVO sendMailVO = new SendMailVO();
			// 제목
			sendMailVO.setSubject("Japan24 - " + subject);
			// 내용
			sendMailVO.setTextContent(textContent.toString());

			// 이메일 주소 목록 조회
			String toEmlAddr = "";
			String ccEmlAddr = "";
			CstmsEmlListVO inCstmsEmlListVO = new CstmsEmlListVO();
			inCstmsEmlListVO.setEdiMsg(ediMsg);
			inCstmsEmlListVO.setEdiMsgTpId(ediMsgTpId);
			inCstmsEmlListVO.setPolCd(polCd);
			inCstmsEmlListVO.setPodCd(podCd);
			List<CstmsEmlListVO> cstmsEmlListVOList = dbDao.searchCstmsEmlList(inCstmsEmlListVO);
			if (cstmsEmlListVOList.size() > 0) {
				StringBuilder tmpToEmlTotal = new StringBuilder();
				StringBuilder tmpCcEmlTotal = new StringBuilder();
				for (CstmsEmlListVO outCstmsEmlListVO : cstmsEmlListVOList) {
					String tmpToEml = outCstmsEmlListVO.getToEmlCtnt().trim().replaceAll(" ", "");
					String tmpCcEml = outCstmsEmlListVO.getCcEmlCtnt().trim().replaceAll(" ", "");
					if (tmpToEml.length() > 0) tmpToEmlTotal.append(tmpToEml + ";");
					if (tmpCcEml.length() > 0) tmpCcEmlTotal.append(tmpCcEml + ";");
				}
				// 중복제거
				if (!"".equals(tmpToEmlTotal.toString())) {
					String[] toEmlAddrArray = StringUtils.removeDuplicateStrings(tmpToEmlTotal.toString().split(";"));
					toEmlAddr = StringUtils.arrayToDelimitedString(toEmlAddrArray, ";");
				}
				if (!"".equals(tmpCcEmlTotal.toString())) {
					String[] ccEmlAddrArray = StringUtils.removeDuplicateStrings(tmpCcEmlTotal.toString().split(";"));
					ccEmlAddr = StringUtils.arrayToDelimitedString(ccEmlAddrArray, ";");
				}

				if (!"".equals(toEmlAddr)) {
					// 받는사람
					sendMailVO.setRecipient(toEmlAddr);
					// 참조
					sendMailVO.setCcRcvrEml(ccEmlAddr);
					// 메일 전송
					eaiDao.sendMail(sendMailVO);
				}
			}

		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * receiveEDIForJapan24HR, sendEmailForNoResponse, receiveEDIForJp24SysAtd에서 호출 (by VOY_NO)
	 * E메일 전송<br>
	 *
	 * @param AdvJpSendLogVO advJpSendLogVO
	 * @exception EventException
	 */
	private void sendEmailforJP24ByVoyNo(AdvJpSendLogVO advJpSendLogVO) throws EventException {
		String subject = "";
		StringBuilder textContent = new StringBuilder();
		String ediMsg = "ATD";
		String ediMsgTpId = "";

		String JpSndLogId = advJpSendLogVO.getJpSndLogId();
		String vvd = advJpSendLogVO.getVvd();
		String polCd = advJpSendLogVO.getPolCd();
		String polNm = advJpSendLogVO.getPolNm().trim();

		try {
			if ("BATD".equals(JpSndLogId)) {
				// - 12. No Response (Japan ATD)
				ediMsgTpId = "No Response";
				subject = ("No Response for : " + vvd + " - " + polCd + "(POL)");
				textContent.append("\n\nAcknowledgement has not been received for the following VVD - Load Port");
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n");
				textContent.append("\n\n\n\n\nDisclaimer : No response has been received in OPUS for the above VVD + Load Port, please contact your Regional Help Desk.");


			} else if ("TATD".equals(JpSndLogId)) {
				// - 13. EDI Technical Failure (Japan ATD)
				ediMsgTpId = "EDI Technical Failure";
				subject = ("Technical Failure : " + vvd + " - " + polCd + "(POL)");
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n");
				textContent.append("\n\n\n\n\nDisclaimer : An error has occurred in OPUS EDI. Please contact your Regional Help Desk to resolve this issue.");


			} else if ("SATD".equals(JpSndLogId)) {
				// - 14. Rejection (Japan24 ATD)
				ediMsgTpId = "Rejection(Error)";
				subject = ("Rejection : " + vvd + " - " + polCd + "(POL)");
				textContent.append("\n\nVVD : " + vvd);
				textContent.append("\n\nLoad Port : " + polNm);
				textContent.append("\n");

				ErrorReportVO inErrorReportVO = new ErrorReportVO();
				inErrorReportVO.setVvd(vvd);
				inErrorReportVO.setPolCd(polCd);
				inErrorReportVO.setJpMsgTpId(JpSndLogId);
				List<ErrorReportVO> errorReportVOList = this.searchErrorReport(inErrorReportVO);
				if (errorReportVOList.size() > 0) {
					for (ErrorReportVO outErrorReportVO : errorReportVOList) {
						textContent.append("\nReason(s) For Rejection : " + outErrorReportVO.getAttrCtnt4());
					}
					textContent.append("\n");
				}
				textContent.append("\n\n\n\n\nDisclaimer : Rejection has been received from Japan Customs; please take necessary action based on the reason of rejection. For further assistance, please contact your Regional Help Desk.");
			}

			SendMailVO sendMailVO = new SendMailVO();
			// 제목
			sendMailVO.setSubject("Japan24 - Vessel Departure " + subject);
			// 내용
			sendMailVO.setTextContent(textContent.toString());

			// 이메일 주소 목록 조회
			String toEmlAddr = "";
			String ccEmlAddr = "";
			CstmsEmlListVO inCstmsEmlListVO = new CstmsEmlListVO();
			inCstmsEmlListVO.setEdiMsg(ediMsg);
			inCstmsEmlListVO.setEdiMsgTpId(ediMsgTpId);
			inCstmsEmlListVO.setPolCd(polCd);
			List<CstmsEmlListVO> cstmsEmlListVOList = dbDao.searchCstmsEmlList(inCstmsEmlListVO);
			if (cstmsEmlListVOList.size() > 0) {
				StringBuilder tmpToEmlTotal = new StringBuilder();
				StringBuilder tmpCcEmlTotal = new StringBuilder();
				for (CstmsEmlListVO outCstmsEmlListVO : cstmsEmlListVOList) {
					String tmpToEml = outCstmsEmlListVO.getToEmlCtnt().trim().replaceAll(" ", "");
					String tmpCcEml = outCstmsEmlListVO.getCcEmlCtnt().trim().replaceAll(" ", "");
					if (tmpToEml.length() > 0) tmpToEmlTotal.append(tmpToEml + ";");
					if (tmpCcEml.length() > 0) tmpCcEmlTotal.append(tmpCcEml + ";");
				}
				// 중복제거
				if (!"".equals(tmpToEmlTotal.toString())) {
					String[] toEmlAddrArray = StringUtils.removeDuplicateStrings(tmpToEmlTotal.toString().split(";"));
					toEmlAddr = StringUtils.arrayToDelimitedString(toEmlAddrArray, ";");
				}
				if (!"".equals(tmpCcEmlTotal.toString())) {
					String[] ccEmlAddrArray = StringUtils.removeDuplicateStrings(tmpCcEmlTotal.toString().split(";"));
					ccEmlAddr = StringUtils.arrayToDelimitedString(ccEmlAddrArray, ";");
				}

				if (!"".equals(toEmlAddr)) {
					// 받는사람
					sendMailVO.setRecipient(toEmlAddr);
					// 참조
					sendMailVO.setCcRcvrEml(ccEmlAddr);
					// 메일 전송
					eaiDao.sendMail(sendMailVO);
				}
			}

		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [BATCH] NoResponseForJp24
	 * BATCH for No Response E-MAIL
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @exception EventException
	 */
	public void sendEmailForNoResponse(AdvJpReceiveLogVO advJpReceiveLogVO) throws EventException {

		try {
			List<AdvJpSendLogVO> advJpSendLogVOList = dbDao.searchAdvJpSndLogByEdiRefId(advJpReceiveLogVO.getEdiRefId());
			if (advJpSendLogVOList.size() > 0) {
				String jpSndLogId = ("B" + advJpSendLogVOList.get(0).getJpSndLogId());
				ObjectCloner.build(advJpSendLogVOList.get(0), advJpReceiveLogVO);
				advJpReceiveLogVO.setJpMsgTpId(jpSndLogId);
				advJpReceiveLogVO.setJpSvcId(jpSndLogId);
				advJpReceiveLogVO.setVslCd(advJpSendLogVOList.get(0).getVvd().substring(0, 4));
				advJpReceiveLogVO.setSkdVoyNo(advJpSendLogVOList.get(0).getVvd().substring(4, 8));
				advJpReceiveLogVO.setSkdDirCd(advJpSendLogVOList.get(0).getVvd().substring(8, 9));
				advJpReceiveLogVO.setBkgNo(advJpSendLogVOList.get(0).getBlNo());
				advJpReceiveLogVO.setMsgRcvNo(advJpSendLogVOList.get(0).getMsgSndNo());
				advJpReceiveLogVO.setEdiRcvMsgCtnt(advJpSendLogVOList.get(0).getEdiSndMsgCtnt());
				advJpReceiveLogVO.setRcvKeyDatCtnt("NO RESPON");
				advJpReceiveLogVO.setRcvSeq("1");
				advJpReceiveLogVO.setUsrId("BATCH");

				List<AdvJpReceiveLogVO> insertVOList = new ArrayList<AdvJpReceiveLogVO>();;
				insertVOList.add(advJpReceiveLogVO);
				dbDao.addAdvJpReceiveLog(insertVOList);
				dbDao.modifyRqstFlgOfAdvJpSndLog(advJpReceiveLogVO);

				// E-Mail 전송
				advJpSendLogVOList.get(0).setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
				if ("BAMR".equals(advJpReceiveLogVO.getJpMsgTpId()) || "BCMR".equals(advJpReceiveLogVO.getJpMsgTpId())) {
					this.sendEmailforJP24ByBlNo(advJpSendLogVOList.get(0));
				} else if ("BATD".equals(advJpReceiveLogVO.getJpMsgTpId())) {
					this.sendEmailforJP24ByVoyNo(advJpSendLogVOList.get(0));
				}
			}

		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [EDI_T_BKG_T_JP24SYS_AMR_ACK]
	 * [EDI_T_BKG_T_JP24SYS_ATD_ACK]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @param String AmrAtd
	 * @exception EventException
	 */
	public void receiveEDIForJp24SysAck(String flatFile, String AmrAtd) throws EventException {

		try {
			String[] rowArray = flatFile.split("\n");
			String ediRefId = "";
			String[] bodyRowArray = (String[]) org.apache.commons.lang.ArrayUtils.remove(rowArray, 0);

			if ("SYSACK".equals(rowArray[0].substring(52, 62).trim())) {
				for (int i=0; i<5; i++) {
					if (bodyRowArray[i].startsWith("ORG_MSG_KEY")) {
						String[] tmpStrArr = bodyRowArray[i].split(":");
						if (tmpStrArr.length > 1) ediRefId = tmpStrArr[1].trim();
						break;
					}
				}
				List<AdvJpSendLogVO> advJpSendLogVOList = dbDao.searchAdvJpSndLogByEdiRefId(ediRefId);
				if (advJpSendLogVOList.size() > 0) {
					String jpSndLogId = ("T" + advJpSendLogVOList.get(0).getJpSndLogId());
					AdvJpReceiveLogVO advJpReceiveLogVO = new AdvJpReceiveLogVO();
					ObjectCloner.build(advJpSendLogVOList.get(0), advJpReceiveLogVO);
					advJpReceiveLogVO.setJpMsgTpId(jpSndLogId);
					advJpReceiveLogVO.setJpSvcId(jpSndLogId);
					advJpReceiveLogVO.setVslCd(advJpSendLogVOList.get(0).getVvd().substring(0, 4));
					advJpReceiveLogVO.setSkdVoyNo(advJpSendLogVOList.get(0).getVvd().substring(4, 8));
					advJpReceiveLogVO.setSkdDirCd(advJpSendLogVOList.get(0).getVvd().substring(8, 9));
					advJpReceiveLogVO.setBkgNo(advJpSendLogVOList.get(0).getBlNo());
					advJpReceiveLogVO.setMsgRcvNo(advJpSendLogVOList.get(0).getMsgSndNo());
					advJpReceiveLogVO.setEdiRcvMsgCtnt(advJpSendLogVOList.get(0).getEdiSndMsgCtnt());
					advJpReceiveLogVO.setRcvKeyDatCtnt("TECH FAIL");
					advJpReceiveLogVO.setRcvSeq("1");
					advJpReceiveLogVO.setEdiRcvMsgCtnt(StringUtils.arrayToDelimitedString(bodyRowArray, "\n"));
					advJpReceiveLogVO.setEdiRefId(ediRefId);
					advJpReceiveLogVO.setUsrId("EDI SYSACK");

					List<AdvJpReceiveLogVO> insertVOList = new ArrayList<AdvJpReceiveLogVO>();
					insertVOList.add(advJpReceiveLogVO);
					dbDao.addAdvJpReceiveLog(insertVOList);
					dbDao.modifyRqstFlgOfAdvJpSndLog(advJpReceiveLogVO);

					advJpSendLogVOList.get(0).setJpSndLogId(advJpReceiveLogVO.getJpMsgTpId());
					if ("AMR".equals(AmrAtd)) {
						// E-Mail 전송 (AMR)
						this.sendEmailforJP24ByBlNo(advJpSendLogVOList.get(0));
					} else if ("ATD".equals(AmrAtd)) {
						// E-Mail 전송 (ATD)
						this.sendEmailforJP24ByVoyNo(advJpSendLogVOList.get(0));
					}
				}
			}
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Japan세관 EDI에서 허용되는 문자로만 필터링<br>
	 *
	 * @param String srcString
	 * @return String
	 */
	private String replaceAllowCharacter(String srcString) {
		srcString = srcString.toUpperCase().replaceAll("‘", "'").replaceAll("’", "'").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("＂", "\"");
		return srcString.replaceAll("[^ A-Z0-9\\!\\\"\\#\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\n\\r]", " ");
	}

}

