/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AustraliaManifestBackEndJob.java.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier :
**@LastVersion : 1.0
* 2013.11.15
* 1.0 Creation
*
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration.AusCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCntrCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusDgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusMainMeansVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusMainPartiesVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgEdiVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1520 EventResponse, AustraliaCustomsTransmissionBackEndJobDgManifest 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AustraliaCustomsTransmissionBackEndJobDgManifest extends BackEndCommandSupport{
	private SignOnUserAccount account = null;
	private AusDgEdiVO[] inputDgEdiVOs = null;
	// Database Access Object
	private AusCustomsTransmissionDBDAO dbDao = new AusCustomsTransmissionDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param AusDgEdiVO[] ausDgEdiVOs
	 */
	public void setAusDgEdiVOs(AusDgEdiVO[] ausDgEdiVOs) {
		if (ausDgEdiVOs != null) {
			AusDgEdiVO[] tmpVOs = Arrays.copyOf(ausDgEdiVOs, ausDgEdiVOs.length);
			this.inputDgEdiVOs = tmpVOs;
		}
	}

	/**
	 * BackEndCommand Start
	 * @return List<String>
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> doStart() throws Exception {
		// ORIGINAL 전송 VO
		List<AusDgEdiVO> originalDgEdiVO = new ArrayList<AusDgEdiVO>();
		// UPDATE 전송 VO
		List<AusDgEdiVO> updateDgEdiVO = new ArrayList<AusDgEdiVO>();
		// CANCEL 전송 VO
		List<AusDgEdiVO> cancelDgEdiVO = new ArrayList<AusDgEdiVO>();
		// UPDATE VO LIST
		List updateDgEdiVOList = new ArrayList();
		// CANCEL VO LIST
		List cancelDgEdiVOList = new ArrayList();
		// 생성된 FlatFile String 리스트 : 위험물 하단에 임시로 생성된 FlatFile을 보여주기 위해사용
		List<String> retList = new ArrayList<String>();

		String originalFlatFile = "";
		String updateFlatFile = "";
		List<String> updateFlatFileList = new ArrayList<String>();
		String cancelFlatFile = "";

		AusDgEdiVO ausDgEdiVO = new AusDgEdiVO();

		// 위험물 대상 총건수
		int ausDgEdiVOsMaxSize = 0;

		/*
		 * 전송 type : 화면에서 눌려진 전송 버튼 구분(EDI Transmit / EDI Cancel)
		 * => 이후 다움과 같이 다시 셋팅함 (O->ORIGIN,U->UPDATE,C->CANCEL
		 */
		String transType = "";

		try {

			ausDgEdiVOsMaxSize = this.inputDgEdiVOs.length;

			for (int i=0; i<ausDgEdiVOsMaxSize; i++) {
				ausDgEdiVO = this.inputDgEdiVOs[i];

				if (i != 0) {
					ausDgEdiVO.setVvdCd(inputDgEdiVOs[0].getVvdCd());
					ausDgEdiVO.setPortCd(inputDgEdiVOs[0].getPortCd());
					ausDgEdiVO.setDType(inputDgEdiVOs[0].getDType());
					ausDgEdiVO.setUiType(inputDgEdiVOs[0].getUiType());
					ausDgEdiVO.setKeyType(inputDgEdiVOs[0].getKeyType());
					ausDgEdiVO.setPBoundCd(inputDgEdiVOs[0].getPBoundCd());
					ausDgEdiVO.setPPodCd(inputDgEdiVOs[0].getPPodCd());
					ausDgEdiVO.setPPolCd(inputDgEdiVOs[0].getPPolCd());
					ausDgEdiVO.setTransType(transType);

				} else {
					transType = inputDgEdiVOs[0].getTransType();
				}

				if (transType.equalsIgnoreCase("CANCEL_SEND")) {
					ausDgEdiVO.setTransType("C");
					cancelDgEdiVO.add(ausDgEdiVO);
				} else {
					if (ausDgEdiVO.getSendType().equals("") || ausDgEdiVO.getSendType().equals("C")) {
						ausDgEdiVO.setTransType("O");
						originalDgEdiVO.add(ausDgEdiVO);
					} else if (ausDgEdiVO.getSendType().equals("O") || ausDgEdiVO.getSendType().equals("U")) {
						ausDgEdiVO.setTransType("U");
						updateDgEdiVO.add(ausDgEdiVO);
					}
				}
			} // end for (i)

			String preFirstMsnNo = "";
			String currFirstMsnNo = "";

			// 업데이트일경우 - First_Ref_No별 업데이트 flatfile 나누기
			int updateDgEdiVOMaxSize = updateDgEdiVO.size();
			List<AusDgEdiVO> updateTmpDgEdiVO = new ArrayList<AusDgEdiVO>();

			for (int i=0; i<updateDgEdiVOMaxSize; i++) {
				ausDgEdiVO = updateDgEdiVO.get(i);

				currFirstMsnNo = ausDgEdiVO.getFirstMsgSndNo();

				if (!preFirstMsnNo.equals(currFirstMsnNo)) {

					if (!preFirstMsnNo.equals("")) {
						updateDgEdiVOList.add(updateTmpDgEdiVO);
						updateTmpDgEdiVO = new ArrayList<AusDgEdiVO>();
					}
				}

				ausDgEdiVO.setTransType("U");
				updateTmpDgEdiVO.add(ausDgEdiVO);

				preFirstMsnNo = currFirstMsnNo;

				if (i == updateDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
					updateDgEdiVOList.add(updateTmpDgEdiVO);
				}

			} // end for (i)

			// Update 전송
			List<AusDgEdiVO> updateVO = new ArrayList<AusDgEdiVO>();
			if (updateDgEdiVOList != null && updateDgEdiVOList.size() > 0) {
				for (int i=0; i<updateDgEdiVOList.size(); i++) {
					updateVO = (List<AusDgEdiVO>) updateDgEdiVOList.get(i);
					updateFlatFile = this.sendFlatFile(updateVO, account);
					updateFlatFileList.add(updateFlatFile);
				}
			}

			preFirstMsnNo = "";
			currFirstMsnNo = "";

			// cancel일경우 - First_Ref_No별 업데이트 flatfile 나누기
			int cancelDgEdiVOMaxSize = cancelDgEdiVO.size();
			List<AusDgEdiVO> cancelTmpDgEdiVO = new ArrayList<AusDgEdiVO>();

			for (int i=0; i<cancelDgEdiVOMaxSize; i++) {
				ausDgEdiVO = cancelDgEdiVO.get(i);
				currFirstMsnNo = ausDgEdiVO.getFirstMsgSndNo();
				if (!preFirstMsnNo.equals(currFirstMsnNo)) {
					if (!preFirstMsnNo.equals("")) {
						cancelDgEdiVOList.add(cancelTmpDgEdiVO);
						cancelTmpDgEdiVO = new ArrayList<AusDgEdiVO>();
					}
				}

				ausDgEdiVO.setTransType("C");
				cancelTmpDgEdiVO.add(ausDgEdiVO);

				preFirstMsnNo = currFirstMsnNo;

				if (i == cancelDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
					cancelDgEdiVOList.add(cancelTmpDgEdiVO);
				}

			} // end for (i)

			// Cancel 전송
			List<AusDgEdiVO> cancelVO = new ArrayList<AusDgEdiVO>();
			if (cancelDgEdiVOList != null && cancelDgEdiVOList.size() > 0) {
				for (int i=0; i<cancelDgEdiVOList.size(); i++) {
					cancelVO = (List<AusDgEdiVO>) cancelDgEdiVOList.get(i);
					cancelFlatFile = this.sendFlatFile(cancelVO, account);
					updateFlatFileList.add(cancelFlatFile);
				}
			}


			// Original 전송
			if (originalDgEdiVO != null && originalDgEdiVO.size() > 0) {
				originalFlatFile = this.sendFlatFile(originalDgEdiVO, account);
			}
			retList.add(originalFlatFile);

			// 리턴 FF에 구분선 넣어주기
			StringBuilder tmpUpdateFlatFile = new StringBuilder();
			for (int i=0; i< updateFlatFileList.size(); i++) {
				tmpUpdateFlatFile.append("[" + (i+1) + "]===============================\n");
				tmpUpdateFlatFile.append(updateFlatFileList.get(i));
			}
			retList.add(tmpUpdateFlatFile.toString());
			retList.add(cancelFlatFile);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		}
		return retList;
	}

	/**
	 * FlatFile을 생성한다.<br>
	 *
	 * @param List<AusDgEdiVO> ausDgEdiVOs
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	private String sendFlatFile(List<AusDgEdiVO> ausDgEdiVOs, SignOnUserAccount account) throws EventException {

		StringBuffer flatFile = null;
		String header = "";

		boolean inFlag = true;
//			boolean inFlag2 = true;

		int ausDgEdiVOsMaxSize = 0;
		int mainPartiesVOsMaxSize = 0;
		int ediRspnSeq = 1;

		AusDeclBaseInfoVO declBaseInfoVO = null;
		AusDgEdiVO ausDgEdiVO = null;

		List<AusMainPartiesVO> mainPartiesVOs = new ArrayList<AusMainPartiesVO>();
		AusMainPartiesVO mainPartiesVO = null;

		AusMainMeansVO mainMeansVO = null;

		String currBlNo = "";
		String prevBlNo = "";

		String vvdCd = "";
		String portCd = "";
		String dType = "";
		String transType = ""; // 전송 Type ("O" - 최초전송, "U" - 재전송, "C" - 취소전송)

		List<AusCntrBaseInfoVO> cntrBaseInfoByBlVOs = new ArrayList<AusCntrBaseInfoVO>();
		List<AusCntrBaseInfoVO> cntrBaseInfoVOs = new ArrayList<AusCntrBaseInfoVO>();

		List<AusCntrCgoVO> cntrCgoVOList = new ArrayList<AusCntrCgoVO>();
		AusCntrCgoVO cntrCgoVO = null;

		String oldUserRefNo = "";
		String firstUserRefNo = "";


		String ofcCd = ""; // office code
		String usrId = ""; // User Id
		String keyType = "Aus_DG";
		String msgTpId = "";

		String secFileNbr = "";

		BookingUtil command = null;

		/* log 저장 vo 선언  시작*/
		AusDgSendHistoryVO dgSendHistoryVO = null; // send
		AusDgSendDtlHistoryVO dgSendDtlHistoryVO = null;
		List<AusDgSendDtlHistoryVO> dgSendDtlHistoryVOList = new ArrayList<AusDgSendDtlHistoryVO>(); // send detail list
		AusDgSendHistoryVO dgSendFlatFileHistoryVO = null; // FlatFile Log
		List<AusDgSendHistoryVO> dgSendFlatFileHistoryVOList = new ArrayList<AusDgSendHistoryVO>(); // FlatFile Log list
		/* log 저장 vo 선언  끝*/

		String sndKey = ""; // MSG_SND_NO

		boolean consignmentEmptyFlag = false;

		try {
			command = new BookingUtil();
			ofcCd = account.getOfc_cd(); // office code
			usrId = account.getUsr_id();
			flatFile = new StringBuffer();

			ausDgEdiVOsMaxSize = ausDgEdiVOs.size();

			for (int i=0; i < ausDgEdiVOsMaxSize; i++) {
				ausDgEdiVO = ausDgEdiVOs.get(i);

				currBlNo = ausDgEdiVO.getBkgNo();

				if (inFlag) {
					vvdCd 		= ausDgEdiVO.getVvdCd();
					portCd 		= ausDgEdiVO.getPortCd();
					dType		= ausDgEdiVO.getDType();

					transType = ausDgEdiVO.getTransType();

					// FlatFile Header를 생성한다.
					header = command.searchCstmsEdiHeaderNew("AU_IFTDGN");
					flatFile.append(header).append("\n");
					flatFile.append("{DECL").append("\n");

					ausDgEdiVO.setOfcCd(ofcCd);
					// decl 기본정보를 조회한다.
					declBaseInfoVO = dbDao.searchAusDeclBaseInfo(ausDgEdiVO);

					msgTpId = "IFTDGN";

//					if ( (transType.equals("U") || transType.equals("C") ) ) { // 전송타입이 UPDATE OR CANCEL 전송일 경우.. MSG_SND_NO를 신규로 만들 않고 맨뒤 2자리만 증가한다.
//						DecimalFormat fmt = new DecimalFormat("00");
//						String oldMsgSndNo = ausDgEdiVO.getMsgSndNo();
//						String newSeq = fmt.format( Integer.parseInt(oldMsgSndNo.substring(15, 17)) + 1 );
//						sndKey = oldMsgSndNo.substring(0, 15) + newSeq;
//					} else {
						// 신규로 MSG_SND_NO 키값을 만든다.
						sndKey = dbDao.searchAusEdiHistoryKey(msgTpId, keyType, vvdCd, portCd, dType);
//					}

					if ( declBaseInfoVO != null) {

						flatFile.append("DOC_NAME:")				.append(declBaseInfoVO.getDocName()).append("\n");
						//flatFile.append("DECL_TYPE:")				.append(declBaseInfoVO.getDeclType()).append("\n");
						flatFile.append("HANDLING:")				.append(declBaseInfoVO.getHandling()).append("\n");

						/* Send Master log VO 셋팅 */
						dgSendHistoryVO = new AusDgSendHistoryVO();
						dgSendHistoryVO.setEurEdiMsgTpId("IFD");
						dgSendHistoryVO.setMsgSndNo(sndKey);
						dgSendHistoryVO.setSndUsrId(usrId);
						dgSendHistoryVO.setAutoSndTpCd("M");
						dgSendHistoryVO.setEurDgDeclTpCd(declBaseInfoVO.getHandling());
						dgSendHistoryVO.setVvdCd(vvdCd);
						dgSendHistoryVO.setPortCd(portCd);
						dgSendHistoryVO.setCreUsrId(usrId);
						dgSendHistoryVO.setUpdUsrId(usrId);

						dgSendHistoryVO.setMsgFuncId(transType);

						flatFile.append("STATUS:")					.append(transType).append("\n");
						flatFile.append("REASON:")					.append(declBaseInfoVO.getReason()).append("\n");
						flatFile.append("USER_REF:")				.append(dgSendHistoryVO.getMsgSndNo()).append("\n");

						if (!transType.equals("O")) { // 최초전송이 아닐 경우만   OLD_USER_REF, FIRST_USER_REF값을 조회한다.
							oldUserRefNo 	= ausDgEdiVO.getMsgSndNo();
							firstUserRefNo 	= ausDgEdiVO.getFirstMsgSndNo();
							secFileNbr = declBaseInfoVO.getSecFileNbr();
						} else { // 최초전송일 경우  FIRST_USER_REF  = dgSendHistoryVO.getMsgSndNo()로 셋팅한다.
							firstUserRefNo = dgSendHistoryVO.getMsgSndNo();
							oldUserRefNo   = "";
							secFileNbr = "";
						}

						flatFile.append("OLD_USER_REF:")			.append(oldUserRefNo).append("\n");
						flatFile.append("FIRST_USER_REF:")			.append(firstUserRefNo).append("\n");
						flatFile.append("SEC_FILE_NBR:")			.append(secFileNbr).append("\n");
						flatFile.append("FF_REF:")					.append(declBaseInfoVO.getFfRef()).append("\n");

						// MAIN PARTIES 정보를 조회한다.
						ausDgEdiVO.setUsrId(usrId);
						mainPartiesVOs = dbDao.searchAusMainParties(ausDgEdiVO);

						if (mainPartiesVOs != null) {

							mainPartiesVOsMaxSize = mainPartiesVOs.size();
							for (int idx =0; idx < mainPartiesVOsMaxSize; idx++) {

								mainPartiesVO = mainPartiesVOs.get(idx);

								flatFile.append("{MAIN_PARTIES").append("\n");
								if (mainPartiesVO != null) {

									flatFile.append("PARTY_TYPE:")					.append(mainPartiesVO.getPartyType()).append("\n");
									flatFile.append("PARTY_ID:")					.append(mainPartiesVO.getPartyId()).append("\n");
									flatFile.append("AUTHORIZED:")					.append(mainPartiesVO.getAuthorized()).append("\n");
									flatFile.append("ADDRESS1:")					.append(mainPartiesVO.getAddress1().replaceAll("\n", " ")).append("\n");
									flatFile.append("ADDRESS2:")					.append(mainPartiesVO.getAddress2().replaceAll("\n", " ")).append("\n");
									flatFile.append("ADDRESS3:")					.append(mainPartiesVO.getAddress3().replaceAll("\n", " ")).append("\n");
									flatFile.append("ADDRESS4:")					.append(mainPartiesVO.getAddress4().replaceAll("\n", " ")).append("\n");
									flatFile.append("ADDRESS5:")					.append(mainPartiesVO.getAddress5().replaceAll("\n", " ")).append("\n");
									flatFile.append("CONTACT:")						.append(mainPartiesVO.getContact()).append("\n");
									flatFile.append("PHONE:")						.append(mainPartiesVO.getPhone()).append("\n");
									flatFile.append("FAX:")							.append(mainPartiesVO.getFax()).append("\n");
									flatFile.append("REF:")							.append(mainPartiesVO.getRef1()).append("\n");

								} else {
									flatFile.append("PARTY_TYPE:")					.append("").append("\n");
									flatFile.append("PARTY_ID:")					.append("").append("\n");
									flatFile.append("AUTHORIZED:")					.append("").append("\n");
									flatFile.append("ADDRESS1:")					.append("").append("\n");
									flatFile.append("ADDRESS2:")					.append("").append("\n");
									flatFile.append("ADDRESS3:")					.append("").append("\n");
									flatFile.append("ADDRESS4:")					.append("").append("\n");
									flatFile.append("ADDRESS5:")					.append("").append("\n");
									flatFile.append("CONTACT:")						.append("").append("\n");
									flatFile.append("PHONE:")						.append("").append("\n");
									flatFile.append("FAX:")							.append("").append("\n");
									flatFile.append("REF:")							.append("").append("\n");
								}

								flatFile.append("}MAIN_PARTIES").append("\n");
							} // end for (idx)
						}


						// MAIN MEANS 정보를 조회한다.
						mainMeansVO = dbDao.searchAusMainMeans(ausDgEdiVO);

						if (mainMeansVO != null) {
							flatFile.append("{MAIN_MEANS").append("\n");
								flatFile.append("MAIN_MEANS_TYPE:")				.append(mainMeansVO.getMainMeansType()).append("\n");
								flatFile.append("MAIN_VVD:")					.append(mainMeansVO.getMainVvd()).append("\n");
								flatFile.append("CON_MAIN_VVD:")				.append(mainMeansVO.getConMainVvd()).append("\n");
								flatFile.append("MAIN_MODE:")					.append(mainMeansVO.getMainMode()).append("\n");
								flatFile.append("MAIN_NAME:")					.append(mainMeansVO.getMainName()).append("\n");
								flatFile.append("MAIN_SSR:")					.append(mainMeansVO.getMainSsr()).append("\n");
								flatFile.append("{MAIN_IDS").append("\n");
									flatFile.append("MAIN_ID_TYPE:")				.append(mainMeansVO.getLMainIdType()).append("\n");
									flatFile.append("MAIN_ID:")						.append(mainMeansVO.getLMainId()).append("\n");
								flatFile.append("}MAIN_IDS").append("\n");
								flatFile.append("{MAIN_IDS").append("\n");
									flatFile.append("MAIN_ID_TYPE:")				.append(mainMeansVO.getCMainIdType()).append("\n");
									flatFile.append("MAIN_ID:")						.append(mainMeansVO.getCMainId()).append("\n");
								flatFile.append("}MAIN_IDS").append("\n");
								flatFile.append("MAIN_NATION:")						.append(mainMeansVO.getMainNation()).append("\n");
								flatFile.append("MAIN_LICENSE:")					.append(mainMeansVO.getMainLicense()).append("\n");
							flatFile.append("}MAIN_MEANS").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEta1()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEta1()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEtd1()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEtd1()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEtd0()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEtd0()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEta2()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEta2()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");


							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeBer()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocBer()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc1()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc1()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc0()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc0()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc2()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc2()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");
						}
					}

					inFlag = false;

				} // end if (inFlag)

				if (!currBlNo.equals("")) {

					if (prevBlNo.equals(currBlNo)) continue;

					ausDgEdiVO.setVvdCd(vvdCd);
					ausDgEdiVO.setPortCd(portCd);
					ausDgEdiVO.setDType(dType);
					ausDgEdiVO.setUsrId(usrId);
					ausDgEdiVO.setMsgSndNo(sndKey);
					// 컨테이터 기본정보를 조회한다.
					cntrBaseInfoByBlVOs = dbDao.searchAusCntrBaseInfo(ausDgEdiVO);
					cntrBaseInfoVOs.addAll(cntrBaseInfoByBlVOs);
				}
				prevBlNo = currBlNo;

			} // end for (i)


			if (cntrBaseInfoVOs.size() > 0) {
				for (AusCntrBaseInfoVO cntrBaseInfoVO : cntrBaseInfoVOs) {
					flatFile.append("{CNTR").append("\n");
						flatFile.append("CNTRNO:")				.append(cntrBaseInfoVO.getCntrNo()).append("\n");
						flatFile.append("CNTRTS_CD:")			.append(cntrBaseInfoVO.getCntrtsCd()).append("\n");
						flatFile.append("ISO:")					.append(cntrBaseInfoVO.getIso()).append("\n");
						flatFile.append("IMEX:")				.append(cntrBaseInfoVO.getImex()).append("\n");
						flatFile.append("CNTR_FL_MT_IND:")		.append(cntrBaseInfoVO.getBkgCgoTpCd()).append("\n");
					flatFile.append("}CNTR").append("\n");
				} // end for (idx)


				String currBkgId = "";
				String preBkgId = "";
				int bkgCnt = 0;

				// bl list로 loop를 돌린다(중복 BL은 continue)
				for (AusCntrBaseInfoVO cntrBaseInfoVO : cntrBaseInfoVOs) {
					currBkgId = cntrBaseInfoVO.getLBkgId();

					if (preBkgId.equals(currBkgId)) continue;

					bkgCnt++; // booking 카운트
					flatFile.append("{CONSIGNMENTS").append("\n");

					for (AusCntrBaseInfoVO subPartyCntrBaseInfoVO : dbDao.searchSubPartyInfo(cntrBaseInfoVO)) {
						flatFile.append("{SUB_PARTIES").append("\n");
							flatFile.append("SUB_PARTY_TYPE:")			.append(subPartyCntrBaseInfoVO.getSubPartyType()).append("\n");
							flatFile.append("SUB_PARTY_ID:")			.append(subPartyCntrBaseInfoVO.getSubPartyId()).append("\n");
							flatFile.append("SUB_AUTHORIZED:")			.append(subPartyCntrBaseInfoVO.getSubAuthorized()).append("\n");
							flatFile.append("SUB_ADDRESS1:")			.append(subPartyCntrBaseInfoVO.getSubAddress1().replaceAll("\n", " ")).append("\n");
							flatFile.append("SUB_ADDRESS2:")			.append(subPartyCntrBaseInfoVO.getSubAddress2().replaceAll("\n", " ")).append("\n");
							flatFile.append("SUB_ADDRESS3:")			.append(subPartyCntrBaseInfoVO.getSubAddress3().replaceAll("\n", " ")).append("\n");
							flatFile.append("SUB_ADDRESS4:")			.append(subPartyCntrBaseInfoVO.getSubAddress4().replaceAll("\n", " ")).append("\n");
							flatFile.append("SUB_ADDRESS5:")			.append(subPartyCntrBaseInfoVO.getSubAddress5().replaceAll("\n", " ")).append("\n");
							flatFile.append("SUB_CONTACT:")				.append(subPartyCntrBaseInfoVO.getSubContact()).append("\n");
							flatFile.append("SUB_PHONE:")				.append(subPartyCntrBaseInfoVO.getSubPhone()).append("\n");
							flatFile.append("SUB_FAX:")					.append(subPartyCntrBaseInfoVO.getSubFax()).append("\n");
							flatFile.append("SUB_REF:")					.append(subPartyCntrBaseInfoVO.getSubRef()).append("\n");
						flatFile.append("}SUB_PARTIES").append("\n");
					}


					flatFile.append("{SUB_MEANS").append("\n");
						flatFile.append("SUB_MEANS_TYPE:")			.append("\n");
						flatFile.append("SUB_VVD:")					.append("\n");
						flatFile.append("SUB_CON_VVD:")				.append("\n");

					if (!consignmentEmptyFlag) {    //////////////////// full

							flatFile.append("SUB_MODE:")				.append(cntrBaseInfoVO.getSubMode()).append("\n");
							flatFile.append("SUB_NAME:")				.append(cntrBaseInfoVO.getSubName()).append("\n");
							flatFile.append("SUB_SSR:")					.append(cntrBaseInfoVO.getSubSsr()).append("\n");

							flatFile.append("{SUB_IDS").append("\n");
								flatFile.append("SUB_ID_TYPE:")					.append(cntrBaseInfoVO.getSubIdType()).append("\n");
								flatFile.append("SUB_ID:")						.append(cntrBaseInfoVO.getSubId()).append("\n");
							flatFile.append("}SUB_IDS").append("\n");

							flatFile.append("SUB_NATION:")			.append(cntrBaseInfoVO.getSubNation()).append("\n");
							flatFile.append("SUB_LICENSE:")			.append(cntrBaseInfoVO.getSubLicense()).append("\n");
						flatFile.append("}SUB_MEANS").append("\n");

						flatFile.append("{BOOKINGS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append(cntrBaseInfoVO.getLBkgIdType()).append("\n");
								flatFile.append("BKG_ID:")				.append(cntrBaseInfoVO.getLBkgId()).append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append(cntrBaseInfoVO.getBBkgIdType()).append("\n");
								flatFile.append("BKG_ID:")				.append(cntrBaseInfoVO.getBBkgId()).append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append("S").append("\n");
								flatFile.append("BKG_ID:")				.append(bkgCnt).append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")			.append(cntrBaseInfoVO.getBkgDateType()).append("\n");
								flatFile.append("BKG_DATE:")				.append(cntrBaseInfoVO.getBkgDate()).append("\n");
							flatFile.append("}BKG_DATES").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPolBkgLocType()).append("\n");
								flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPolBkgLoc()).append("\n");
								flatFile.append("BKG_LOC_DESC:")			.append(cntrBaseInfoVO.getPolBkgLocDesc()).append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPodBkgLocType()).append("\n");
								flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPodBkgLoc()).append("\n");
								flatFile.append("BKG_LOC_DESC:")			.append(cntrBaseInfoVO.getPodBkgLocDesc()).append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

					} else {    //////////////////// empty

							flatFile.append("SUB_MODE:")				.append("\n");
							flatFile.append("SUB_NAME:")				.append("\n");
							flatFile.append("SUB_SSR:")					.append("\n");

							flatFile.append("{SUB_IDS").append("\n");
								flatFile.append("SUB_ID_TYPE:")					.append("\n");
								flatFile.append("SUB_ID:")						.append("\n");
							flatFile.append("}SUB_IDS").append("\n");

							flatFile.append("SUB_NATION:")			.append("\n");
							flatFile.append("SUB_LICENSE:")			.append("\n");
						flatFile.append("}SUB_MEANS").append("\n");

						flatFile.append("{BOOKINGS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append("\n");
								flatFile.append("BKG_ID:")				.append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append("\n");
								flatFile.append("BKG_ID:")				.append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_IDS").append("\n");
								flatFile.append("BKG_ID_TYPE:")			.append("\n");
								flatFile.append("BKG_ID:")				.append("\n");
							flatFile.append("}BKG_IDS").append("\n");

							flatFile.append("{BKG_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")			.append("\n");
								flatFile.append("BKG_DATE:")				.append("\n");
							flatFile.append("}BKG_DATES").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPolBkgLocType()).append("\n");
								flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPolBkgLoc()).append("\n");
								flatFile.append("BKG_LOC_DESC:")			.append(cntrBaseInfoVO.getPolBkgLocDesc()).append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPodBkgLocType()).append("\n");
								flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPodBkgLoc()).append("\n");
								flatFile.append("BKG_LOC_DESC:")			.append(cntrBaseInfoVO.getPodBkgLocDesc()).append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

					}
					// bl단위로 컨테이터 item정보를 조회하도록 변경
					cntrCgoVOList = dbDao.searchAusCntrCgoByCntrBase(cntrBaseInfoVO);

					if (cntrCgoVOList != null) {

						for (int j=0; j<cntrCgoVOList.size(); j++) {
							cntrCgoVO = cntrCgoVOList.get(j);

							if (cntrCgoVO != null) {

								flatFile.append("{ITEMS").append("\n");

								if (!consignmentEmptyFlag) {

									flatFile.append("ITEM_NBR:")			.append(cntrCgoVO.getItemNbr()).append("\n");
									flatFile.append("PKG_QTY:")				.append(cntrCgoVO.getPkgQty()).append("\n");
									flatFile.append("OUTPKG_QTY:")			.append(cntrCgoVO.getOutpkgQty()).append("\n");
									flatFile.append("INPKG_QTY:")			.append(cntrCgoVO.getInpkgQty()).append("\n");
									flatFile.append("PKG_TP:")				.append(cntrCgoVO.getPkgTp()).append("\n");
									flatFile.append("OUTPKG_TP:")			.append(cntrCgoVO.getOutpkgTp()).append("\n");
									flatFile.append("INPKG_TP:")			.append(cntrCgoVO.getInpkgTp()).append("\n");
									flatFile.append("PKG_DESC:")			.append(cntrCgoVO.getPkgDesc().replaceAll("\n", " ")).append("\n");
									flatFile.append("OUTPKG_DESC:")			.append(cntrCgoVO.getOutpkgDesc().replaceAll("\n", " ")).append("\n");
									flatFile.append("INPKG_DESC:")			.append(cntrCgoVO.getInpkgDesc().replaceAll("\n", " ")).append("\n");
									flatFile.append("HAZ_CONT:")			.append(cntrCgoVO.getHazCont().replaceAll("\n", " ")).append("\n");
									flatFile.append("PROP_SHIP_NM:")		.append(cntrCgoVO.getPropShipNm().replaceAll("\n", " ")).append("\n");
									flatFile.append("IMO_CLASS:")			.append(cntrCgoVO.getImoClass()).append("\n");
									flatFile.append("SUB_CLASS1:")			.append(cntrCgoVO.getSubClass1()).append("\n");
									flatFile.append("SUB_CLASS2:")			.append(cntrCgoVO.getSubClass2()).append("\n");
									flatFile.append("SUB_CLASS3:")			.append(cntrCgoVO.getSubClass3()).append("\n");
									flatFile.append("SUB_CLASS4:")			.append(cntrCgoVO.getSubClass4()).append("\n");
									flatFile.append("IMO_COMP:")			.append(cntrCgoVO.getImoComp()).append("\n");
									flatFile.append("IMO_PAGE:")			.append(cntrCgoVO.getImoPage()).append("\n");
									flatFile.append("UN_NBR:")				.append(cntrCgoVO.getUnNbr()).append("\n");
									flatFile.append("UN_NBR_SEQ:")			.append(cntrCgoVO.getUnNbrSeq()).append("\n");

									flatFile.append("FLASH:")				.append(cntrCgoVO.getFlash()).append("\n");
									flatFile.append("FLASH_UNIT:")			.append(cntrCgoVO.getFlashUnit()).append("\n");
									flatFile.append("PKG_GROUP:")			.append(cntrCgoVO.getPkgGroup()).append("\n");
									flatFile.append("EMS_NBR:")				.append(cntrCgoVO.getEmsNbr()).append("\n");
									flatFile.append("MFAG:")				.append(cntrCgoVO.getMfag()).append("\n");
									flatFile.append("ESPN:")				.append(cntrCgoVO.getEspn()).append("\n");
									flatFile.append("POLLUTANT:")			.append(cntrCgoVO.getPollutant()).append("\n");
									flatFile.append("IMO_LIMIT:")			.append(cntrCgoVO.getImoLimit()).append("\n");
									flatFile.append("HCDG:")				.append(cntrCgoVO.getHcdg()).append("\n");
									flatFile.append("GROSSWGT:")			.append(cntrCgoVO.getGrosswgt()).append("\n");
									flatFile.append("GROSSWGT_UNIT:")		.append(cntrCgoVO.getGrosswgtUnit()).append("\n");
									flatFile.append("NETWGT:")				.append(cntrCgoVO.getNetwgt()).append("\n");
									flatFile.append("NETWGT_UNIT:")			.append(cntrCgoVO.getNetwgtUnit()).append("\n");

									//flatFile.append("NW_EXPLOSIVE:")		.append(cntrCgoVO.getNwExplosive()).append("\n");
									//flatFile.append("NW_EXP_UNIT:")			.append(cntrCgoVO.getNwExpUnit()).append("\n");
									flatFile.append("NW_EXPLOSIVE:")		.append("").append("\n");
									flatFile.append("NW_EXP_UNIT:")			.append("").append("\n");

									flatFile.append("CNTRNBR:")				.append(cntrCgoVO.getCntrnbr()).append("\n");
									flatFile.append("STOWPOS:")				.append(cntrCgoVO.getStowpos()).append("\n");

								} else {
									flatFile.append("ITEM_NBR:")			.append("\n");
									flatFile.append("PKG_QTY:")				.append("\n");
									flatFile.append("OUTPKG_QTY:")			.append("\n");
									flatFile.append("INPKG_QTY:")			.append("\n");
									flatFile.append("PKG_TP:")				.append("\n");
									flatFile.append("OUTPKG_TP:")			.append("\n");
									flatFile.append("INPKG_TP:")			.append("\n");
									flatFile.append("PKG_DESC:")			.append("\n");
									flatFile.append("OUTPKG_DESC:")			.append("\n");
									flatFile.append("INPKG_DESC:")			.append("\n");
									flatFile.append("HAZ_CONT:")			.append("\n");
									flatFile.append("PROP_SHIP_NM:")		.append("\n");
									flatFile.append("IMO_CLASS:")			.append("\n");
									flatFile.append("SUB_CLASS1:")			.append("\n");
									flatFile.append("SUB_CLASS2:")			.append("\n");
									flatFile.append("SUB_CLASS3:")			.append("\n");
									flatFile.append("SUB_CLASS4:")			.append("\n");
									flatFile.append("IMO_PAGE:")			.append("\n");
									flatFile.append("UN_NBR:")				.append("\n");
									flatFile.append("UN_NBR_SEQ:")			.append("\n");

									flatFile.append("FLASH:")				.append("\n");
									flatFile.append("FLASH_UNIT:")			.append("\n");
									flatFile.append("PKG_GROUP:")			.append("\n");
									flatFile.append("EMS_NBR:")				.append("\n");
									flatFile.append("MFAG:")				.append("\n");
									flatFile.append("ESPN:")				.append("\n");
									flatFile.append("POLLUTANT:")			.append("\n");
									flatFile.append("IMO_LIMIT:")			.append("\n");
									flatFile.append("HCDG:")				.append("\n");
									flatFile.append("GROSSWGT:")			.append("\n");
									flatFile.append("GROSSWGT_UNIT:")		.append("\n");
									flatFile.append("NETWGT:")				.append("\n");
									flatFile.append("NETWGT_UNIT:")			.append("\n");

									flatFile.append("NW_EXPLOSIVE:")		.append("\n");
									flatFile.append("NW_EXP_UNIT:")			.append("\n");

									flatFile.append("CNTRNBR:")				.append("\n");
									flatFile.append("STOWPOS:")				.append("\n");

								}

								flatFile.append("}ITEMS").append("\n");

								// send log detail VO 저장
								dgSendDtlHistoryVO = new AusDgSendDtlHistoryVO();
								dgSendDtlHistoryVO.setEurEdiMsgTpId("IFD");
								dgSendDtlHistoryVO.setMsgSndNo(sndKey);
								dgSendDtlHistoryVO.setEdiRspnSeq(String.valueOf(ediRspnSeq++));
								dgSendDtlHistoryVO.setBlNo(cntrBaseInfoVO.getLBkgId());
								dgSendDtlHistoryVO.setCntrNo(cntrCgoVO.getCntrnbr());
								dgSendDtlHistoryVO.setCntrCgoSeq(cntrCgoVO.getItemNbr());
								dgSendDtlHistoryVO.setDgBlRefNo("");
								dgSendDtlHistoryVO.setDgItmRefNo("");
								dgSendDtlHistoryVO.setCreUsrId(usrId);
								dgSendDtlHistoryVO.setUpdUsrId(usrId);

								dgSendDtlHistoryVOList.add(dgSendDtlHistoryVO);
							}
						} // end for (j)
					}

					flatFile.append("}BOOKINGS").append("\n");

					flatFile.append("}CONSIGNMENTS").append("\n");

					preBkgId = currBkgId;

				} // end for (idx)

			}

			flatFile.append("}DECL").append("\n");

			//FlatFile을 4000Byte씩 나눈다 - start
			int divisor = 3900;
			int totLength = flatFile.length();
			int quotient = totLength / divisor;
			int remainder = totLength % divisor;

			int loopCnt = 0;
			int start = 0;
			int end = 0;

			if (remainder > 0) {
				loopCnt = quotient + 1;
			} else {
				loopCnt = quotient;
			}

			String[] fFiles = new String[loopCnt];

			for (int i=0; i<loopCnt; i++) {
				if (i == loopCnt-1) {
					end = remainder;
				} else {
					end = divisor;
				}

				start = i * divisor;

				fFiles[i] = flatFile.substring(start, start+end);

				// send Flat File log VO 셋팅
				dgSendFlatFileHistoryVO = new AusDgSendHistoryVO(); // send
				dgSendFlatFileHistoryVO.setMsgSndNo(dgSendHistoryVO.getMsgSndNo());
				dgSendFlatFileHistoryVO.setEurEdiMsgTpId(dgSendHistoryVO.getEurEdiMsgTpId());
				dgSendFlatFileHistoryVO.setKeyVal(String.valueOf(i+1));
				dgSendFlatFileHistoryVO.setCreUsrId(dgSendHistoryVO.getCreUsrId());
				dgSendFlatFileHistoryVO.setUpdUsrId(dgSendHistoryVO.getUpdUsrId());
				dgSendFlatFileHistoryVO.setMsgDesc(fFiles[i]);

				dgSendFlatFileHistoryVOList.add(dgSendFlatFileHistoryVO);
			}


			// bkg_cstms_aus_snd_log 테이블에 FlatFile을 (4000byte씩)통으로 저장한다.
			if (dgSendFlatFileHistoryVOList != null && dgSendFlatFileHistoryVOList.size() > 0) {
				dbDao.addAusSendFlatFileLog(dgSendFlatFileHistoryVOList);
			}

			// 전송로그를 저장한다. (MASTER)
			if (dgSendHistoryVO != null) {
				dbDao.addAusSendLog(dgSendHistoryVO);
			}

			// 전송로그를 저장한다. (DETAIL)
			if (dgSendDtlHistoryVOList != null && dgSendDtlHistoryVOList.size() > 0) {
				dbDao.addAusSendDtlLog(dgSendDtlHistoryVOList);
			}

			// MQ로 전송한다.
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			if ( flatFileAckVO.getAckStsCd().equals("E") ) {
				throw new EventException(new ErrorHandler("BKG00205",new String[] {} ).getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		}
		return flatFile.toString();
	}

}

