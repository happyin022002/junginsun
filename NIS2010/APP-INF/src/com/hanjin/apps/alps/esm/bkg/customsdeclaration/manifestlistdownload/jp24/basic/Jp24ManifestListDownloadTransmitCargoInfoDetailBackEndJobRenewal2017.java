/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017.java
 *@FileTitle : Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.09.07
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2017.09.07 하대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadEAIDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpSendLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.EdiAdvJpCommonVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.MailContentsParamVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.SendMailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1501 EventResponse, Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017 extends BackEndCommandSupport {

	private static final long serialVersionUID = -6235444891899639843L;
	private CargoInfoHeaderVO cargoInfoHeaderVO;
	private CargoInfoDetailVO[] cargoInfoDetailVOs;
	private SignOnUserAccount signOnUserAccount;
	// Database Access Object
	private Jp24ManifestListDownloadDBDAO dbDao = new Jp24ManifestListDownloadDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 */
	public void setCargoInfoHeaderVO(CargoInfoHeaderVO cargoInfoHeaderVO) {
		this.cargoInfoHeaderVO = cargoInfoHeaderVO;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 */
	public void setCargoInfoDetailVOs(CargoInfoDetailVO[] cargoInfoDetailVOs){
		if(cargoInfoDetailVOs != null){
			CargoInfoDetailVO[] tmpVOs = Arrays.copyOf(cargoInfoDetailVOs, cargoInfoDetailVOs.length);
			this.cargoInfoDetailVOs = tmpVOs;
		}
	}

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}

	/**
	 * Back End Job Result
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		CargoInfoHeaderVO headerVO = this.cargoInfoHeaderVO;    // 조회조건
		CargoInfoDetailVO[] detailVOs = this.cargoInfoDetailVOs;    // Sheet내용
		SignOnUserAccount account = this.signOnUserAccount;

		BookingUtil bookingUtil = new BookingUtil();
		JapanCustomsTransmissionDBDAO japanCustomsTransmissionDBDAO = new JapanCustomsTransmissionDBDAO();
		List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOList = new ArrayList<JapanManifestListSendHeaderInfoVO>();
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();

		Jp24ManifestListDownloadEAIDAO eaiDao = new Jp24ManifestListDownloadEAIDAO();
		List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = new ArrayList<EdiAdvJpCommonVO>();
		HashMap<String, String> mapEdiAdvJpCommonVO = new HashMap<String, String>();;
		DecimalFormat formatter = new DecimalFormat("00");
		StringBuilder completeflatFile = null;
		String replacementFlatFile = "";
		int toCatchError=0;
		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD테이블의 RLX_DIV(JO_CD1) 정보 UPDATE
			headerVO.setUsrId(account.getUsr_id());
			dbDao.modifyAdvJpVslSkd(headerVO);

			String vvd = headerVO.getVvd();
			String polCd = headerVO.getPolCd();
			
			for (int i=0; i<detailVOs.length; i++) {
				toCatchError=i;
				String blNo = detailVOs[i].getBlNo();
				String delCd = detailVOs[i].getDelCd();
				String delReason = detailVOs[i].getDelReason();
				// 직전 bl_no와 같다면 skip
				if (i > 0 &&  blNo.equals(detailVOs[i - 1].getBlNo())) continue;
				// 삭제 전송시 무조건 CMR/1으로 setting
				if ("Y".equals(headerVO.getDelNewTrasmitFlag())) {
					detailVOs[i].setTSType("CMR");
					detailVOs[i].setTCmrKind("1");
					headerVO.setTCmrKind("1");
				}
				
				StringBuilder flatFileBody = new StringBuilder();
				// Flatfile Body (S)
				flatFileBody.append(detailVOs[i].getTCmrKind()).append("\r\n");
				// BKG_CSTMS_ADV_JP_BL 정보 조회
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBlRenewal2017(vvd, blNo, headerVO.getPolSplitNo(), headerVO.getPodSplitNo(), delCd, delReason, detailVOs[i].getTCmrKind());
				mapEdiAdvJpCommonVO = new HashMap<String, String>();
				mapEdiAdvJpCommonVO = ediAdvJpCommonVOList.get(0).getColumnValues();
				for (int k=0; k<31 ; k++) {
					flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\r\n");
				}

				// E메일 전송시 사용될 일부 정보 setting
				String pol4Naccs = ediAdvJpCommonVOList.get(0).getData09();
				String pod4Naccs = ediAdvJpCommonVOList.get(0).getData21();
				String etdFullInfo = DateTime.getFormatDate(ediAdvJpCommonVOList.get(0).getData13() + ediAdvJpCommonVOList.get(0).getData14(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm");

				// BKG_CSTMS_ADV_JP_CUST 정보 조회
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpCustomerRenewal2017(blNo);
				mapEdiAdvJpCommonVO = new HashMap<String, String>();
				mapEdiAdvJpCommonVO = ediAdvJpCommonVOList.get(0).getColumnValues();
				for (int k=0; k<40 ; k++) {
					flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\r\n");
				}

				// BKG_CSTMS_ADV_JP_MK 정보 조회
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpMarkDescRenewal2017(blNo);
				mapEdiAdvJpCommonVO = new HashMap<String, String>();
				mapEdiAdvJpCommonVO = ediAdvJpCommonVOList.get(0).getColumnValues();
				for (int k=0; k<43 ; k++) {
					flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\r\n");
				}

				// BKG_CSTMS_ADV_JP_CNTR 정보 조회
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpContainerRenewal2017(blNo);
				for (EdiAdvJpCommonVO ediAdvJpCommonVO : ediAdvJpCommonVOList) {
					mapEdiAdvJpCommonVO = new HashMap<String, String>();
					mapEdiAdvJpCommonVO = ediAdvJpCommonVO.getColumnValues();
					for (int k=0; k<15 ; k++) {
						flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\r\n");
					}
				}
				// Flatfile Body (E)

				// Flatfile Replacing characters allowed
				replacementFlatFile = flatFileBody.toString().toUpperCase().replaceAll("‘", "'").replaceAll("’", "'").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("＂", "\"");
				replacementFlatFile = replacementFlatFile.replaceAll("[^A-Z0-9\\!\\\"\\#\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\n\\r]", " ");

				// Flatfile Header Setting
				String sendDate = bookingUtil.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3));
				String flatFileBodyLength = String.valueOf(replacementFlatFile.length());
				japanManifestListSendHeaderInfoVOList =  japanCustomsTransmissionDBDAO.searchSendHeaderRenewal2017(vvd, polCd, account.getOfc_cd(), account.getUsr_id().replace("_", ""), detailVOs[i].getTSType(), sendDate, flatFileBodyLength, "");

				// Flatfile Complete
				completeflatFile = new StringBuilder();
				completeflatFile.append(japanManifestListSendHeaderInfoVOList.get(0).getHeader()).append("\n");
				completeflatFile.append(japanManifestListSendHeaderInfoVOList.get(0).getHeader2()).append("\r\n");
				completeflatFile.append(replacementFlatFile);

				// FlatFile 전송
				sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(completeflatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
				flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
				// (eaiDAO.sendFlatFile에 LIVE에서 TEST용으로 사용하는 임시 송신MQ정보가 하드코딩되어 있음)
				//flatFileAckVO = eaiDao.sendFlatFile(sendFlatFileVO);
				if ("E".equals(flatFileAckVO.getAckStsCd())) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

				// E-Mail 전송 (S)
				String emlAddrString = "";
				String emlSndRsltFlg = "N";
				if (("AMR".equals(detailVOs[i].getTSType()) || ("CMR".equals(detailVOs[i].getTSType()) && "2".equals(detailVOs[i].getTCmrKind()))) &&
					 "N".equals(detailVOs[i].getRvisCntrCustTpCd())) {

					MailContentsParamVO mailContentsParamVO = new MailContentsParamVO();
					mailContentsParamVO.setVvd(vvd);
					mailContentsParamVO.setBlNo(blNo);
					mailContentsParamVO.setPolCd(polCd);
					List<MailContentsParamVO> mailContentsVOList = dbDao.searchMailContentsParam(mailContentsParamVO);
					if (mailContentsVOList.size() > 0) {
						SendMailVO sendMailVO = new SendMailVO();
						// 보내는사람
						String fromEmail = (dbDao.getUsrEmlOfBooking(blNo) + "").replaceAll(" ", "").trim();
						if ("".equals(fromEmail)) fromEmail = account.getUsr_eml();
						sendMailVO.setFromEmail(fromEmail);
						sendMailVO.setFromName("SM Line");
						// 제목
						sendMailVO.setSubject("Japan AFR Notice (AMR) - " + mailContentsVOList.get(0).getVslEngNm() + " + SMLM" + blNo);
						// 내용
						String rlxDiv = ("1".equals(headerVO.getRlxDiv()) ? "Y" : " "); 
						sendMailVO.setTextContent("\r\n" +
												  "\r\nVessel Information for Japan AFR(Advance Filing Rules)" +
												  "\r\n\nFrom SM Line Corporation" +
												  "\r\n" +
												  "\r\n" +
												  "\r\nWe transferred AMR with the below Vessel Information." +
												  "\r\n" +
												  "\r\n" +
												  "\r\nBooking & B/L# : SMLM" + blNo +
												  "\r\n" +
												  "\r\nCall Sign : " + mailContentsVOList.get(0).getCallSgnNo() +
												  "\r\nVessel Name : " + mailContentsVOList.get(0).getVslEngNm() +
												  "\r\nVoyage Number : " + vvd.substring(4) +
												  "\r\nCarrier Code : SMLM" +
												  "\r\nPOL code : " + pol4Naccs +
												  "\r\nPOL Name : " + mailContentsVOList.get(0).getPolNm() +
												  "\r\nETD of POL : " + etdFullInfo +
												  "\r\nPOD code : " + pod4Naccs +
												  "\r\nPOD Name : " + mailContentsVOList.get(0).getPodNm() +
												  "\r\nRelaxed Application Area Identifier : " + rlxDiv + "\r\n\r\n\r\n");

						emlAddrString = detailVOs[i].getUsrEml().replaceAll(" ", "").trim();
						if ("".equals(emlAddrString)) {
							emlAddrString = (dbDao.getUsrEmlOfAdvJpBl(blNo) + "").replaceAll(" ", "").trim();
							if ("".equals(emlAddrString)) {
								emlAddrString = (dbDao.getCntcPsonEml(blNo) + "").replaceAll(" ", "").trim();
							}
						}
						if (emlAddrString != null &&  !"".equals(emlAddrString.trim())) {
							//@ 테스트 메일계정 삭제 2017.08.16
//							if(!emlAddrString.contains("afr24hr@jp.smlines.com")){
//							emlAddrString += ";afr24hr@jp.smlines.com"; }// User 임시 테스트용
							String[] tempEmlAddrArray = emlAddrString.split(";");
							for (String tempEmlAddr : tempEmlAddrArray) {   // 받는사람
									
								if (tempEmlAddr.contains("@")) {
										sendMailVO.setRecipient(tempEmlAddr);
								// 메일 전송
										String emlSndNo = eaiDao.sendMail(sendMailVO);
										if (emlSndNo != null && !"".equals(emlSndNo)) {
											emlSndRsltFlg = "Y";
												}
											}
									}
								}

						// ADV_JP_BL 테이블에 변경된 E-Mail정보 저장 (E-Mail이 전송 되었을때만)
						if ("Y".equals(emlSndRsltFlg)) {
							detailVOs[i].setUsrEml(emlAddrString);
							detailVOs[i].setUsrId(account.getUsr_id());
							dbDao.modifyUsrEmlOfAdvJpBl(detailVOs[i]);
						}
					}
				}
				// E-Mail 전송 (S)

				// 전송결과 저장
				AdvJpSendLogVO advJpSendLogVO = new AdvJpSendLogVO();
				advJpSendLogVO.setTSType(detailVOs[i].getTSType());
				advJpSendLogVO.setMsgSndSeq(japanManifestListSendHeaderInfoVOList.get(0).getHeader().substring(36, 41));
				advJpSendLogVO.setMsgSndDiv(blNo);    // B/L No.
				advJpSendLogVO.setSndDt(sendDate);
				advJpSendLogVO.setOfcCd(account.getOfc_cd());
				advJpSendLogVO.setLogSeq(detailVOs[i].getTCmrKind());
				advJpSendLogVO.setVvd(vvd);
				advJpSendLogVO.setBlNo(blNo);
				advJpSendLogVO.setPodCd(detailVOs[i].getPodCd());   // 조회조건이 아닌 sheet date
				advJpSendLogVO.setPodSplitNo(headerVO.getPodSplitNo());
				advJpSendLogVO.setPolCd(polCd);
				advJpSendLogVO.setPolSplitNo(headerVO.getPolSplitNo());
				advJpSendLogVO.setDelCd(detailVOs[i].getBkgDelCd());
				advJpSendLogVO.setFlatFile(completeflatFile.toString());
				advJpSendLogVO.setCntcPsonEml(emlAddrString);
				advJpSendLogVO.setEmlSndRsltFlg(emlSndRsltFlg);
				advJpSendLogVO.setUsrId(account.getUsr_id());
				dbDao.addAdvJpSendLog(advJpSendLogVO);
			}

		} catch (DAOException ex) {
			 log.error("\n JP24 email BL check " + detailVOs[toCatchError].getBlNo());
			 log.error("\n JP24 email BL check " + detailVOs[toCatchError].getUsrEml());
			 log.error("\n JP24 email BL check " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			 log.error("\n JP24 email BL check " + detailVOs[toCatchError].getBlNo());
			 log.error("\n JP24 email BL check " + detailVOs[toCatchError].getUsrEml());
			 log.error("\n JP24 email BL check " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return "Success";
	}

}
