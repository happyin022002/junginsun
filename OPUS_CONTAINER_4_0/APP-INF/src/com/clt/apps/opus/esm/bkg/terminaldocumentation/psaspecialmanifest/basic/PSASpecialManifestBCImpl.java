/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : psaspecialmanifestBCImpl.java
*@FileTitle : psaspecialmanifestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier :
*@LastVersion : 1.0
* 2011.09.01
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration.PSASpecialManifestDBDAO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainMeansVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainPartiesVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASpecialContainerVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PsaDGRcvMsgVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see PSASpecialManifestDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestBCImpl extends BasicCommandSupport implements PSASpecialManifestBC {

	// Database Access Object
	private transient PSASpecialManifestDBDAO dbDao = null;

	/**
	 * FullReleaseOrderBCImpl 객체 생성<br>
	 * FullReleaseOrderDBDAO를 생성한다.<br>
	 */
	public PSASpecialManifestBCImpl() {
		dbDao = new PSASpecialManifestDBDAO();
	}

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		String result = "";
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			while (rowSet.next()) result = rowSet.getObject("jb_sts_flg").toString();
			return result;
		} catch(BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA VSL Name 조회<br>
	 *
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchPSAVslName(String vvd) throws EventException {
		try {
			return dbDao.searchPSAVslName(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
	}

	/**
	 * 수출,수입, T/S, Barge별로 전송 대상을 조회한다.<br>
	 *
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws EventException
	 */
	public List<PSADgListDetailVO> searchPsaDgManifestList(PSADgListCondVO psaDgListCondVO) throws EventException {
		PSASpecialContainerVO psaSpecialContainerVO = new PSASpecialContainerVO();
		List<PSADgListDetailVO> retVOList = new ArrayList<PSADgListDetailVO>();

		try {
			/*
			 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),
			 *  도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함-(Booking 쪽 data)
			 */
			List<PSADgListDetailVO> vslInfoList = dbDao.serachPsaVslAtCommon(psaDgListCondVO);
			if (vslInfoList != null && vslInfoList.size() > 0) {
				psaSpecialContainerVO.setPsaVslInfo(vslInfoList.get(0));
			}

			// booking쪽 위험물 데이타를 조회
			psaDgListCondVO.setAppendFlag("N");
			List<PSADgListDetailVO> psaDetailList = dbDao.searchPsaDgInfoAtBkgDg(psaDgListCondVO);
			if (psaDetailList != null && psaDetailList.size() > 0) {
				psaSpecialContainerVO.setPsaDetailList(psaDetailList);
			}

			retVOList.add(psaSpecialContainerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
		return retVOList;
	}

	/**
	 * 위험물 Sent결과를 조회해 온다.<br>
	 *
	 * @param  PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<PSASendHistoryDetailVO> searchPsaSendHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException {
		try {
			return dbDao.searchPsaSendHistoryByCntrNo(psaSendHistoryCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0577 : Transmit - Back End Job 시작<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param PSADgEdiVO[] psaDgEdiVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitDgManifest(PSADgEdiVO[] psaDgEdiVOs, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		PSASpecialManifestBackEndJob backEndJob = new PSASpecialManifestBackEndJob();
		try {
			backEndJob.setPsaDgEdiVOs(psaDgEdiVOs);
			backEndJob.setSignOnUserAccount(account);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSA Import Status EDI 전송
	 *
	 * @param PSADgEdiVO[] psaDgEdiVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @throws EventException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public List<String> transmitDgManifest(PSADgEdiVO[] psaDgEdiVOs, SignOnUserAccount account) throws EventException {

		// ORIGINAL 전송 VO
		List<PSADgEdiVO> originalDgEdiVO = new ArrayList<PSADgEdiVO>();
		// UPDATE 전송 VO
		List<PSADgEdiVO> updateDgEdiVO = new ArrayList<PSADgEdiVO>();
		// CANCEL 전송 VO
		List<PSADgEdiVO> cancelDgEdiVO = new ArrayList<PSADgEdiVO>();
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

		PSADgEdiVO psaDgEdiVO = new PSADgEdiVO();

		// 위험물 대상 총건수
		int psaDgEdiVOsMaxSize = 0;

		/*
		 * 전송 type : 화면에서 눌려진 전송 버튼 구분(EDI Transmit / EDI Cancel)
		 * => 이후 다움과 같이 다시 셋팅함 (O->ORIGIN,U->UPDATE,C->CANCEL
		 */
		String transType = "";

		try {

			psaDgEdiVOsMaxSize = psaDgEdiVOs.length;

			for(int i = 0; i < psaDgEdiVOsMaxSize; i++) {
				psaDgEdiVO = psaDgEdiVOs[i];

				if(i != 0) {
					psaDgEdiVO.setVvdCd(psaDgEdiVOs[0].getVvdCd());
					psaDgEdiVO.setPortCd(psaDgEdiVOs[0].getPortCd());
					psaDgEdiVO.setDType(psaDgEdiVOs[0].getDType());
					psaDgEdiVO.setUiType(psaDgEdiVOs[0].getUiType());
					psaDgEdiVO.setKeyType(psaDgEdiVOs[0].getKeyType());
					psaDgEdiVO.setPBoundCd(psaDgEdiVOs[0].getPBoundCd());
					psaDgEdiVO.setPPodCd(psaDgEdiVOs[0].getPPodCd());
					psaDgEdiVO.setPPolCd(psaDgEdiVOs[0].getPPolCd());
					psaDgEdiVO.setTransType(transType);

				} else {
					transType = psaDgEdiVOs[0].getTransType();
				}

				if(transType.equalsIgnoreCase("CANCEL_SEND")) {
					psaDgEdiVO.setTransType("C");
					cancelDgEdiVO.add(psaDgEdiVO);
				} else {
					if(psaDgEdiVO.getSendType().equals("") || psaDgEdiVO.getSendType().equals("C")) {
						psaDgEdiVO.setTransType("O");
						originalDgEdiVO.add(psaDgEdiVO);
					} else if(psaDgEdiVO.getSendType().equals("O") || psaDgEdiVO.getSendType().equals("U")) {
						psaDgEdiVO.setTransType("U");
						updateDgEdiVO.add(psaDgEdiVO);
					}
				}
			} // end for(i)

			String preFirstMsnNo = "";
			String currFirstMsnNo = "";

			// 업데이트일경우 - First_Ref_No별 업데이트 flatfile 나누기
			int updateDgEdiVOMaxSize = updateDgEdiVO.size();
			List<PSADgEdiVO> updateTmpDgEdiVO = new ArrayList<PSADgEdiVO>();

			for(int i = 0; i < updateDgEdiVOMaxSize; i++) {
				psaDgEdiVO = updateDgEdiVO.get(i);

				currFirstMsnNo = psaDgEdiVO.getFirstMsgSndNo();

				if(!preFirstMsnNo.equals(currFirstMsnNo)) {

					if(!preFirstMsnNo.equals("")) {
						updateDgEdiVOList.add(updateTmpDgEdiVO);
						updateTmpDgEdiVO = new ArrayList<PSADgEdiVO>();
					}
				}

				psaDgEdiVO.setTransType("U");
				updateTmpDgEdiVO.add(psaDgEdiVO);

				preFirstMsnNo = currFirstMsnNo;

				if(i == updateDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
					updateDgEdiVOList.add(updateTmpDgEdiVO);
				}

			} // end for(i)

			// Update 전송
			List<PSADgEdiVO> updateVO = null;
			if(updateDgEdiVOList != null && updateDgEdiVOList.size() > 0) {

				for(int i =0; i < updateDgEdiVOList.size(); i++) {
					updateVO = (List<PSADgEdiVO>) updateDgEdiVOList.get(i);
					updateFlatFile = this.sendFlatFile(updateVO, account);
					updateFlatFileList.add(updateFlatFile);
				}
			}

			preFirstMsnNo = "";
			currFirstMsnNo = "";

			// cancel일경우 - First_Ref_No별 업데이트 flatfile 나누기
			int cancelDgEdiVOMaxSize = cancelDgEdiVO.size();
			List<PSADgEdiVO> cancelTmpDgEdiVO = new ArrayList<PSADgEdiVO>();

			for(int i = 0; i < cancelDgEdiVOMaxSize; i++) {
				psaDgEdiVO = cancelDgEdiVO.get(i);

				currFirstMsnNo = psaDgEdiVO.getFirstMsgSndNo();

				if(!preFirstMsnNo.equals(currFirstMsnNo)) {

					if(!preFirstMsnNo.equals("")) {
						cancelDgEdiVOList.add(cancelTmpDgEdiVO);
						cancelTmpDgEdiVO = new ArrayList<PSADgEdiVO>();
					}
				}

				psaDgEdiVO.setTransType("C");
				cancelTmpDgEdiVO.add(psaDgEdiVO);

				preFirstMsnNo = currFirstMsnNo;

				if(i == cancelDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
					cancelDgEdiVOList.add(cancelTmpDgEdiVO);
				}

			} // end for(i)

			// Cancel 전송
			List<PSADgEdiVO> cancelVO = null;
			if(cancelDgEdiVOList != null && cancelDgEdiVOList.size() > 0) {

				for(int i =0; i < cancelDgEdiVOList.size(); i++) {
					cancelVO = (List<PSADgEdiVO>) cancelDgEdiVOList.get(i);

					cancelFlatFile = this.sendFlatFile(cancelVO, account);

					updateFlatFileList.add(cancelFlatFile);
				}
			}


			// Original 전송
			if(originalDgEdiVO != null && originalDgEdiVO.size() > 0) {
				originalFlatFile = this.sendFlatFile(originalDgEdiVO, account);
			}

			retList.add(originalFlatFile);

			// 리턴 FF에 구분선 넣어주기
			StringBuilder tmpUpdateFlatFile = new StringBuilder();
			for(int i=0; i< updateFlatFileList.size(); i++) {
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
	 * @param List<PSADgEdiVO> psaDgEdiVOs
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	private String sendFlatFile(List<PSADgEdiVO> psaDgEdiVOs, SignOnUserAccount account) throws EventException {

		StringBuffer flatFile = null;
		String header = "";

		boolean inFlag = true;
//		boolean inFlag2 = true;

		int psaDgEdiVOsMaxSize = 0;
		int mainPartiesVOsMaxSize = 0;
		int ediRspnSeq = 1;

		PSADeclBaseInfoVO declBaseInfoVO = null;
		PSADgEdiVO psaDgEdiVO = null;

		List<PSAMainPartiesVO> mainPartiesVOs = null;
		PSAMainPartiesVO mainPartiesVO = null;

		PSAMainMeansVO mainMeansVO = null;

		String currBlNo = "";
		String prevBlNo = "";

		String vvdCd = "";
		String portCd = "";
		String dType = "";
		String transType = ""; // 전송 Type ("O" - 최초전송, "U" - 재전송, "C" - 취소전송)

		PSACntrBaseInfoVO cntrBaseInfoVO = null;
		List<PSACntrBaseInfoVO> cntrBaseInfoByBlVOs = null;
		List<PSACntrBaseInfoVO> cntrBaseInfoVOs = new ArrayList<PSACntrBaseInfoVO>();

		List<PSACntrCgoVO> cntrCgoVOList = null;
		PSACntrCgoVO cntrCgoVO = null;

		String oldUserRefNo = "";
		String firstUserRefNo = "";


		String ofcCd = ""; // office code
		String usrId = ""; // User Id
		String keyType = "PSA_DG";
		String msgTpId = "";

		String secFileNbr = "";

		BookingUtil command = null;

		/* log 저장 vo 선언  시작*/
		PSADgSendHistoryVO dgSendHistoryVO = null; // send
		PSADgSendDtlHistoryVO dgSendDtlHistoryVO = null;
		List<PSADgSendDtlHistoryVO> dgSendDtlHistoryVOList = new ArrayList<PSADgSendDtlHistoryVO>(); // send detail list
		PSADgSendHistoryVO dgSendFlatFileHistoryVO = null; // FlatFile Log
		List<PSADgSendHistoryVO> dgSendFlatFileHistoryVOList = new ArrayList<PSADgSendHistoryVO>(); // FlatFile Log list
		/* log 저장 vo 선언  끝*/

		String sndKey = ""; // MSG_SND_NO

		boolean consignmentEmptyFlag = false;

		try {
			command = new BookingUtil();
			ofcCd = account.getOfc_cd(); // office code
			usrId = account.getUsr_id();
			flatFile = new StringBuffer();

			psaDgEdiVOsMaxSize = psaDgEdiVOs.size();

			for(int i = 0; i < psaDgEdiVOsMaxSize; i++) {
				psaDgEdiVO = psaDgEdiVOs.get(i);

				currBlNo = psaDgEdiVO.getBlNo();

				if(inFlag) {
					vvdCd 		= psaDgEdiVO.getVvdCd();
					portCd 		= psaDgEdiVO.getPortCd();
					dType		= psaDgEdiVO.getDType();

					transType = psaDgEdiVO.getTransType();

					// FlatFile Header를 생성한다.
					header = command.searchCstmsEdiHeaderNew("SG_IFTDGN");
					flatFile.append(header).append("\n");
					flatFile.append("{DECL").append("\n");

					psaDgEdiVO.setOfcCd(ofcCd);
					// decl 기본정보를 조회한다.
					declBaseInfoVO = dbDao.searchPsaDeclBaseInfo(psaDgEdiVO);

					msgTpId = "IFTDGN";

//					if( (transType.equals("U") || transType.equals("C") ) ) { // 전송타입이 UPDATE OR CANCEL 전송일 경우.. MSG_SND_NO를 신규로 만들 않고 맨뒤 2자리만 증가한다.
//						DecimalFormat fmt = new DecimalFormat("00");
//						String oldMsgSndNo = psaDgEdiVO.getMsgSndNo();
//						String newSeq = fmt.format( Integer.parseInt(oldMsgSndNo.substring(15, 17)) + 1 );
//						sndKey = oldMsgSndNo.substring(0, 15) + newSeq;
//					} else {
						// 신규로 MSG_SND_NO 키값을 만든다.
						sndKey = dbDao.searchPsaEdiHistoryKey(msgTpId, keyType, vvdCd, portCd, dType);
//					}

					if ( declBaseInfoVO != null) {

						flatFile.append("DOC_NAME:")				.append(declBaseInfoVO.getDocName()).append("\n");
						//flatFile.append("DECL_TYPE:")				.append(declBaseInfoVO.getDeclType()).append("\n");
						flatFile.append("HANDLING:")				.append(declBaseInfoVO.getHandling()).append("\n");

						/* Send Master log VO 셋팅 */
						dgSendHistoryVO = new PSADgSendHistoryVO();
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

						if(!transType.equals("O")) { // 최초전송이 아닐 경우만   OLD_USER_REF, FIRST_USER_REF값을 조회한다.
							oldUserRefNo 	= psaDgEdiVO.getMsgSndNo();
							firstUserRefNo 	= psaDgEdiVO.getFirstMsgSndNo();
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
						psaDgEdiVO.setUsrId(usrId);
						mainPartiesVOs = dbDao.searchPsaMainParties(psaDgEdiVO);

						if(mainPartiesVOs != null) {

							mainPartiesVOsMaxSize = mainPartiesVOs.size();
							for(int idx =0; idx < mainPartiesVOsMaxSize; idx++) {

								mainPartiesVO = mainPartiesVOs.get(idx);

								flatFile.append("{MAIN_PARTIES").append("\n");
								if(mainPartiesVO != null) {

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
							} // end for(idx)
						}


						// MAIN MEANS 정보를 조회한다.
						mainMeansVO = dbDao.searchPsaMainMeans(psaDgEdiVO);

						if(mainMeansVO != null) {
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

				} // end if(inFlag)

				if(!currBlNo.equals("")) {

					if(prevBlNo.equals(currBlNo)) continue;

					psaDgEdiVO.setVvdCd(vvdCd);
					psaDgEdiVO.setPortCd(portCd);
					psaDgEdiVO.setDType(dType);
					psaDgEdiVO.setUsrId(usrId);
					psaDgEdiVO.setMsgSndNo(sndKey);
					// 컨테이터 기본정보를 조회한다.
					cntrBaseInfoByBlVOs = dbDao.searchPsaCntrBaseInfo(psaDgEdiVO);
					cntrBaseInfoVOs.addAll(cntrBaseInfoByBlVOs);
				}
				prevBlNo = currBlNo;

			} // end for(i)

			if(cntrBaseInfoVOs != null) {

				int cntrBaseInfoVOsMaxSize = cntrBaseInfoVOs.size();

				for(int idx = 0; idx < cntrBaseInfoVOsMaxSize; idx++) {
					cntrBaseInfoVO = cntrBaseInfoVOs.get(idx);

					flatFile.append("{CNTR").append("\n");
						flatFile.append("CNTRNO:")				.append(cntrBaseInfoVO.getCntrNo()).append("\n");
						flatFile.append("CNTRTS_CD:")			.append(cntrBaseInfoVO.getCntrtsCd()).append("\n");
						flatFile.append("ISO:")					.append(cntrBaseInfoVO.getIso()).append("\n");
						flatFile.append("IMEX:")				.append(cntrBaseInfoVO.getImex()).append("\n");
						flatFile.append("CNTR_FL_MT_IND:")		.append(cntrBaseInfoVO.getBkgCgoTpCd()).append("\n");
					flatFile.append("}CNTR").append("\n");

				} // end for(idx)

				String currBkgId = "";
				String preBkgId = "";

				int bkgCnt = 0;

				// bl list로 loop를 돌린다(중복 BL은 continue)
				for(int idx = 0; idx < cntrBaseInfoVOsMaxSize; idx++) {

					cntrBaseInfoVO = cntrBaseInfoVOs.get(idx);

					currBkgId = cntrBaseInfoVO.getLBkgId();

					if(preBkgId.equals(currBkgId)) continue;

					bkgCnt++; // booking 카운트

					flatFile.append("{CONSIGNMENTS").append("\n");

					flatFile.append("{SUB_PARTIES").append("\n");
						flatFile.append("SUB_PARTY_TYPE:")			.append("\n");
						flatFile.append("SUB_PARTY_ID:")			.append("\n");
						flatFile.append("SUB_AUTHORIZED:")			.append("\n");
						flatFile.append("SUB_ADDRESS1:")			.append("\n");
						flatFile.append("SUB_ADDRESS2:")			.append("\n");
						flatFile.append("SUB_ADDRESS3:")			.append("\n");
						flatFile.append("SUB_ADDRESS4:")			.append("\n");
						flatFile.append("SUB_ADDRESS5:")			.append("\n");
						flatFile.append("SUB_CONTACT:")				.append("\n");
						flatFile.append("SUB_PHONE:")				.append("\n");
						flatFile.append("SUB_FAX:")					.append("\n");
						flatFile.append("SUB_REF:")					.append("\n");
					flatFile.append("}SUB_PARTIES").append("\n");

					flatFile.append("{SUB_MEANS").append("\n");
						flatFile.append("SUB_MEANS_TYPE:")			.append("\n");
						flatFile.append("SUB_VVD:")					.append("\n");
						flatFile.append("SUB_CON_VVD:")				.append("\n");

					if(!consignmentEmptyFlag) {    //////////////////// full

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
							flatFile.append("}BKG_LOCS").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPodBkgLocType()).append("\n");
								flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPodBkgLoc()).append("\n");
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
								flatFile.append("BKG_LOC_TYPE:")			.append("\n");
								flatFile.append("BKG_LOC:")					.append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

							flatFile.append("{BKG_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")			.append("\n");
								flatFile.append("BKG_LOC:")					.append("\n");
							flatFile.append("}BKG_LOCS").append("\n");

					}
					// bl단위로 컨테이터 item정보를 조회하도록 변경
					cntrCgoVOList = dbDao.searchPsaCntrCgoByCntrBase(cntrBaseInfoVO);

					if(cntrCgoVOList != null) {

						for(int j=0; j<cntrCgoVOList.size(); j++) {
							cntrCgoVO = cntrCgoVOList.get(j);

							if(cntrCgoVO != null) {

								flatFile.append("{ITEMS").append("\n");

								if(!consignmentEmptyFlag) {

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
								dgSendDtlHistoryVO = new PSADgSendDtlHistoryVO();
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
						} // end for(j)
					}

					flatFile.append("}BOOKINGS").append("\n");
					flatFile.append("}CONSIGNMENTS").append("\n");

					preBkgId = currBkgId;

				} // end for(idx)

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

			if(remainder > 0) {
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
				dgSendFlatFileHistoryVO = new PSADgSendHistoryVO(); // send
				dgSendFlatFileHistoryVO.setMsgSndNo(dgSendHistoryVO.getMsgSndNo());
				dgSendFlatFileHistoryVO.setEurEdiMsgTpId(dgSendHistoryVO.getEurEdiMsgTpId());
				dgSendFlatFileHistoryVO.setKeyVal(String.valueOf(i+1));
				dgSendFlatFileHistoryVO.setCreUsrId(dgSendHistoryVO.getCreUsrId());
				dgSendFlatFileHistoryVO.setUpdUsrId(dgSendHistoryVO.getUpdUsrId());
				dgSendFlatFileHistoryVO.setMsgDesc(fFiles[i]);

				dgSendFlatFileHistoryVOList.add(dgSendFlatFileHistoryVO);
			}


			// bkg_cstms_psa_snd_log 테이블에 FlatFile을 (4000byte씩)통으로 저장한다.
			if(dgSendFlatFileHistoryVOList != null && dgSendFlatFileHistoryVOList.size() > 0) {
				dbDao.addPsaSendFlatFileLog(dgSendFlatFileHistoryVOList);
			}

			// 전송로그를 저장한다. (MASTER)
			if(dgSendHistoryVO != null) {
				dbDao.addPsaSendLog(dgSendHistoryVO);
			}
			// 전송로그를 저장한다. (DETAIL)
			if(dgSendDtlHistoryVOList != null && dgSendDtlHistoryVOList.size() > 0) {
				dbDao.addPsaSendDtlLog(dgSendDtlHistoryVOList);
			}

			// MQ로 전송한다.
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			//라이브 태깅 시에 QUEUE Name
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE"));
			//로컬 테스트시에 QUEUE Name
			//sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_PSA.IBMMQ.QUEUE"));

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

	/**
	 * ESM_BKG_0577 : Transmit - Back End Job 결과<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<String> resultBackEndJobTransmitDgManifest(String backEndJobKey) throws EventException {
		try {
			return (List<String>) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws EventException
	 */
	public List<PSADgListDetailVO> searchPsaDgInfoAtBkgDgByBlNo(PSADgListCondVO psaDgListCondVO) throws EventException {
		try {
			return dbDao.searchPsaDgInfoAtBkgDg(psaDgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {} ).getMessage(), ex);
		}
	}

	/**
	 * RECEIVE받은 FLAT FILE을 수신 구분별로 분기한다.<br>
	 * @param rcvMsg
	 * @param rcvGubun
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String rcvGubun) throws EventException {

		if(rcvGubun.equalsIgnoreCase("OpusBkgTPsacusAckEven")) { // PSA위험물 신고 응답메시지 수신
			this.loadAperakRcvMsg(rcvMsg);
		}

	}


	/**
	 * PSA위험물 수신
	 * RECEIVE받은 수신 FLAT FILE을 로그테이블에 생성한다.  <br>
	 *
	 * @param rcvMsg
	 * @throws EventException
	 */
	private void loadAperakRcvMsg(String rcvMsg) throws EventException {
		String msgRcvNo = "";
		String tmpStr = "";
		String keyAndValue[] = null;
		int keyAndValueMaxSize = 0;
		String regex = ":";
		String rcvLogSeq = "";

		String key = "";
		String value = "";

		String rcvId = "";

		String msgTpId = "IFD";
		int RcvLogErrSeg = 1;
		PsaDGRcvMsgVO psaDGRcvMsgVO = new PsaDGRcvMsgVO();;

		try {
			String[] tmpArray = rcvMsg.split("\n");

			if (tmpArray != null && tmpArray.length > 0) {

				msgRcvNo = dbDao.searchMsgRcvNo(msgTpId);
				rcvLogSeq = dbDao.searchRcvLogSeq(msgTpId, msgRcvNo);
//				psaDGRcvMsgVO.setMsgTpId(msgTpId);
//				log.debug("tmpArrayMaxSize===>"+tmpArrayMaxSize);
//				log.debug("tmpStr===>"+tmpStr);


				for (int i=0 ; i<tmpArray.length; i++) {

					tmpStr = tmpArray[i].toString().trim();

//					if(tmpStr.equalsIgnoreCase("{ERROR")) {
//						//psaDGRcvMsgVO = new PsaDGRcvMsgVO();
//						psaDGRcvMsgVO.setKeyVal(psaDGRcvMsgVO.getKeyVal());
//						psaDGRcvMsgVO.setMsgTpId(msgTpId);
//						psaDGRcvMsgVO.setCreUsrId(rcvId);
//						psaDGRcvMsgVO.setUpdUsrId(rcvId);
//
//					}
//
//					if(tmpStr.equalsIgnoreCase("}ERROR")) {
//						psaDGRcvMsgVOs.add(psaDGRcvMsgVO);
//					}

//					if(tmpStr.equalsIgnoreCase("{ERROR") || tmpStr.equalsIgnoreCase("}ERROR") ) continue;

					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					keyAndValueMaxSize = keyAndValue.length;
					if(keyAndValueMaxSize == 1) {
						value = "";
					} else if(keyAndValueMaxSize >= 2) {
						value = keyAndValue[1].trim();
						if(keyAndValueMaxSize > 2) {
							value = value + " : " + keyAndValue[2].trim();
						}
					}

					if(key.equalsIgnoreCase("VSL_NAME")) {

						psaDGRcvMsgVO.setPsaVslName(value);
						psaDGRcvMsgVO.setRcvLogSeq(rcvLogSeq);
						psaDGRcvMsgVO.setCreUsrId(rcvId);
						psaDGRcvMsgVO.setUpdUsrId(rcvId);
						psaDGRcvMsgVO.setPsaEdiMsgTpId(msgTpId);
						psaDGRcvMsgVO.setMsgRcvNo(msgRcvNo);
						psaDGRcvMsgVO.setRcvLogErrSeq(""+RcvLogErrSeg);
					} else if(key.equalsIgnoreCase("VOYAGE_IN")) {
						psaDGRcvMsgVO.setIbVvdCd(value);
					} else if(key.equalsIgnoreCase("VOYAGE_OUT")) {
						psaDGRcvMsgVO.setObVvdCd(value);
					} else if(key.equalsIgnoreCase("CNTR_NBR")) {
						psaDGRcvMsgVO.setCntrNo(value);
						psaDGRcvMsgVO.setRcvLogErrSeq("" +(RcvLogErrSeg+1)); //
					} else if(key.equalsIgnoreCase("CNTR_HND")) {
						psaDGRcvMsgVO.setCntrHndlKndCd(value);
					} else if(key.equalsIgnoreCase("CNTR_ST")) {
						psaDGRcvMsgVO.setErrCntrStsCd(value);
					} else if(key.equalsIgnoreCase("TANK_CNTR")) {
						psaDGRcvMsgVO.setTnkCntrTpszFlg(value);
					} else if(key.equalsIgnoreCase("PKG_NBR")) {
						psaDGRcvMsgVO.setTtlPckQty(value);
					} else if(key.equalsIgnoreCase("PKG_TYPE")) {
						psaDGRcvMsgVO.setTtlPckTpNm(value);
					} else if(key.equalsIgnoreCase("WGT_DG")) {
						psaDGRcvMsgVO.setDgTtlWgt(value);
					} else if(key.equalsIgnoreCase("IMO_CLASS")) {
						psaDGRcvMsgVO.setImoNo(value);
					} else if(key.equalsIgnoreCase("UN_NBR")) {
						psaDGRcvMsgVO.setImdgUnNo(value);
					} else if(key.equalsIgnoreCase("FLASH_PNT")) {
						psaDGRcvMsgVO.setFlshPntTempCtnt(value);
					} else if(key.equalsIgnoreCase("REASON")) {
						psaDGRcvMsgVO.setCstmsErrMsg(value);
						//psaDGRcvMsgVOs.add(psaDGRcvMsgVO);
						dbDao.addAck(psaDGRcvMsgVO);
					} else if(key.equalsIgnoreCase("TOTAL_SUB")) {
						psaDGRcvMsgVO.setCntrTtlKnt(value);
					} else if(key.equalsIgnoreCase("TOTAL_ERROR")) {
						psaDGRcvMsgVO.setCntrTtlErrKnt(value);
					} else if(key.equalsIgnoreCase("TOTAL_SUCC")) {
						psaDGRcvMsgVO.setCntrTtlScsKnt(value);
					}

				} // end for(i)

				dbDao.addAckKnt(psaDGRcvMsgVO);

			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {} ).getMessage(), ex);
		}
	}

	/**
	 * PSA 수신 결과를 조회해 온다.<br>
	 *
	 * @param  PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<PSASendHistoryDetailVO> searchPsaReceiveHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException {
		try {
			return dbDao.searchPsaReceiveHistory(psaSendHistoryCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}


}