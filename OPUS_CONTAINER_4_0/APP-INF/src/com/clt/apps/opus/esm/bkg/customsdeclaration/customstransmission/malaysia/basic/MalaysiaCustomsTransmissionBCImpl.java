/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MalaysiaCustomsTransmissionBCImpl.java
 *@FileTitle : MalaysiaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2014.06.28
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration.MalaysiaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgXterVgmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaHeadVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author LIM JAE TAEK
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MalaysiaCustomsTransmissionBCImpl extends BasicCommandSupport implements MalaysiaCustomsTransmissionBC {
	// Database Access Object
	private transient MalaysiaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * MalaysiaCustomsTransmissionBCImpl 객체 생성<br>
	 * MalaysiaCustomsTransmissionBCImpl 생성한다.<br>
	 */
	public MalaysiaCustomsTransmissionBCImpl() {
		dbDao = new MalaysiaCustomsTransmissionDBDAO();
	}

	/**
	 * BackEndJob을 실행.(CTA)
	 *
	 * @param SignOnUserAccount account
	 * @param MalaysiaManifestTransmitVO malaysiaManifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, MalaysiaManifestTransmitVO malaysiaManifestTransmitVO, String pgmNo)throws EventException {
		MalaysiaCustomsTransmissionBackEndJob backEndJob = new MalaysiaCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		if (pgmNo.equals("ESM_BKG_1141")) {
			backEndJob.setMalaysiaManifestTransmitVO(malaysiaManifestTransmitVO);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1141-Transmit");
		}
		return resultStr;
	}

	/**
	 * Malaysia 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param MalaysiaManifestTransmitVO malaysiaManifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(MalaysiaManifestTransmitVO malaysiaManifestTransmitVO, SignOnUserAccount account) throws EventException {

		BookingUtil bookingUtil = new BookingUtil();

		// FLATFILE
		String flatFileHeader = "";
		String flatFileRefNo = "";
		String bkgCgoTpCd = "";
		String indFclLcl = "";
		StringBuffer flatFile = new StringBuffer();

		// 조회조건 Input 정보
		MalaysiaManifestListCondVO manifestListCondVO = malaysiaManifestTransmitVO.getMalaysiaManifestListCondVO();
		// B/L Input 정보
		MalaysiaManifestListBlInfoVO[] manifestListBlInfoVOs = malaysiaManifestTransmitVO.getMalaysiaManifestListBlInfoVOs();
		// Container Input 정보
		MalaysiaManifestListCntrInfoVO[] manifestListCntrInfoVOs = malaysiaManifestTransmitVO.getMalaysiaManifestListCntrInfoVOs();

		// -- Output 정보 -- //
		// VSL 정보
		MalaysiaManifestVslInfoVO malaysiaVslInfoVO = new MalaysiaManifestVslInfoVO();

		try {
			String portCd = "";
			if ("E".equals(manifestListCondVO.getSMode())) { // Outbound
				portCd = manifestListCondVO.getSPolCd();
			} else if ("I".equals(manifestListCondVO.getSMode())) { // Inbound
				portCd = manifestListCondVO.getSPodCd();
			}

			String ediHeaderId = "";
			if ("MYPKG".equals(portCd)) {
				ediHeaderId = "MY_PKGCAR";
			} else if ("MYPEN".equals(portCd)) {
				ediHeaderId = "MY_PENCAR";
			} else {
				ediHeaderId = "MY_CUSCAR";
			}

			for (int blIdx=0; blIdx<manifestListBlInfoVOs.length; blIdx++) {

				// Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew(ediHeaderId);
				flatFile.append(flatFileHeader).append("\n");
				if (blIdx == 0) flatFileRefNo = flatFileHeader.substring(62).trim();

				// Body 생성
				// (1)VSL 정보
				malaysiaVslInfoVO = dbDao.searchVslInfo(manifestListBlInfoVOs[blIdx]);
				if (malaysiaVslInfoVO != null) {
					if ("T".equals(malaysiaVslInfoVO.getTsTpCd())) {
						flatFile.append("E_I_IND:").append("T").append("\n");
					} else {
						flatFile.append("E_I_IND:").append(malaysiaVslInfoVO.getEIInd()).append("\n");
					}
					flatFile.append("STATUS:").append(malaysiaVslInfoVO.getStatus()).append("\n");
					flatFile.append("VVD:").append(malaysiaVslInfoVO.getVvd()).append("\n");
					flatFile.append("CON_VVD:").append(malaysiaVslInfoVO.getConVvd()).append("\n");
					flatFile.append("VSL_FULLNAME:").append(malaysiaVslInfoVO.getVslFullname()).append("\n");
					flatFile.append("VSL_AUTH_NO:").append(malaysiaVslInfoVO.getVslAuthNo()).append("\n");
					flatFile.append("VSL_NATION_CD:").append(malaysiaVslInfoVO.getVslNationCd()).append("\n");
					if (malaysiaVslInfoVO.getVslCallNo().length() > 0 && malaysiaVslInfoVO.getVslCallNo() != null) {
						flatFile.append("VSL_SCN:").append(malaysiaVslInfoVO.getVslCallNo()).append("\n");
					} else {
						flatFile.append("VSL_SCN:").append("\n");
					}
					flatFile.append("TS_VVD:").append(malaysiaVslInfoVO.getTsVvd()).append("\n");
					flatFile.append("TS_VSL_FULLNAME:").append(malaysiaVslInfoVO.getTsVslFullname()).append("\n");
					flatFile.append("TS_VSL_NATION_CD:").append(malaysiaVslInfoVO.getTsVslNationCd()).append("\n");
					if (malaysiaVslInfoVO.getTsVslScn().length() > 0 && malaysiaVslInfoVO.getTsVslScn() != null) {
						flatFile.append("TS_VSL_SCN:").append(malaysiaVslInfoVO.getTsVslScn()).append("\n");
					} else {
						flatFile.append("TS_VSL_SCN:").append("\n");
					}
					flatFile.append("PORT:").append(malaysiaVslInfoVO.getPort()).append("\n");
					flatFile.append("PORT_NM:").append(malaysiaVslInfoVO.getPortNm()).append("\n");
					flatFile.append("ETA:").append(malaysiaVslInfoVO.getEta()).append("\n");
					flatFile.append("ETD:").append(malaysiaVslInfoVO.getEtd()).append("\n");
				}

				// (2)B/L 정보
				flatFile.append("{BL_INFO").append("\n");
				flatFile.append("BLNBR:").append(manifestListBlInfoVOs[blIdx].getBlNo()).append("\n");
				flatFile.append("BKGNBR:").append(manifestListBlInfoVOs[blIdx].getBkgNo()).append("\n");
				flatFile.append("BLPKG:").append(manifestListBlInfoVOs[blIdx].getPckQty()).append("\n");
				flatFile.append("BLPKGU:").append(manifestListBlInfoVOs[blIdx].getPckTpCd()).append("\n");
				flatFile.append("BLWGT:").append(manifestListBlInfoVOs[blIdx].getActWgt()).append("\n");
				flatFile.append("BLWGT_UNIT:").append(manifestListBlInfoVOs[blIdx].getWgtUtCd()).append("\n");
				flatFile.append("BLMEA:").append(manifestListBlInfoVOs[blIdx].getMeasQty()).append("\n");
				flatFile.append("BLMEA_UNIT:").append(manifestListBlInfoVOs[blIdx].getMeasUtCd()).append("\n");

				// (3)Container Count 정보
				flatFile.append("CNTR_CNT:").append(dbDao.searchCntrCnt(manifestListBlInfoVOs[blIdx].getBkgNo())).append("\n");

				// (4)Location 정보
				for (MalaysiaManifestLocInfoVO malaysiaManifestLocInfoVO : dbDao.searchLocInfo(manifestListBlInfoVOs[blIdx])) {
					flatFile.append("{LOC_INFO").append("\n");
					flatFile.append("LOC_TYPE:").append(malaysiaManifestLocInfoVO.getLocType()).append("\n");
					flatFile.append("LOC_CD:").append(malaysiaManifestLocInfoVO.getLocCd()).append("\n");
					flatFile.append("LOC_NM:").append(malaysiaManifestLocInfoVO.getLocNm()).append("\n");
					flatFile.append("LOC_ETA:").append(malaysiaManifestLocInfoVO.getLocEta()).append("\n");
					flatFile.append("LOC_ETD:").append(malaysiaManifestLocInfoVO.getLocEtd()).append("\n");
					flatFile.append("}LOC_INFO").append("\n");
				}

				// (5)Customer 정보
				manifestListBlInfoVOs[blIdx].setUsrId(account.getUsr_id());
				for (MalaysiaManifestCustomerInfoVO malaysiaManifestCustomerInfoVO : dbDao.searchCustomerInfo(manifestListBlInfoVOs[blIdx])) {
					flatFile.append("{CUSTOMER_INFO").append("\n");
					flatFile.append("CUSTOMER_TYPE:").append(malaysiaManifestCustomerInfoVO.getCustomerType()).append("\n");
					flatFile.append("CUSTOMER_CD:").append(malaysiaManifestCustomerInfoVO.getCustomerCd()).append("\n");
					flatFile.append("CUSTOMER_NM1:").append(malaysiaManifestCustomerInfoVO.getCustomerNm1()).append("\n");
					flatFile.append("CUSTOMER_NM2:").append(malaysiaManifestCustomerInfoVO.getCustomerNm2()).append("\n");
					flatFile.append("CUSTOMER_ADDR1:").append(malaysiaManifestCustomerInfoVO.getCustomerAddr1()).append("\n");
					flatFile.append("CUSTOMER_ADDR2:").append(malaysiaManifestCustomerInfoVO.getCustomerAddr2()).append("\n");
					flatFile.append("CUSTOMER_ADDR3:").append(malaysiaManifestCustomerInfoVO.getCustomerAddr3()).append("\n");
					flatFile.append("CONTACT_NM:").append(malaysiaManifestCustomerInfoVO.getContactNm()).append("\n");
					flatFile.append("CONTACT_TEL:").append(malaysiaManifestCustomerInfoVO.getContactTel()).append("\n");
					flatFile.append("CONTACT_FAX:").append(malaysiaManifestCustomerInfoVO.getContactFax()).append("\n");
					flatFile.append("CONTACT_EMAIL:").append(malaysiaManifestCustomerInfoVO.getContactEmail()).append("\n");
					flatFile.append("}CUSTOMER_INFO").append("\n");
				}

				// (6-0)CM Info 정보
				for (MalaysiaManifestListCntrInfoVO malaysiaManifestListCntrInfoVO : manifestListCntrInfoVOs) {
					if (malaysiaManifestListCntrInfoVO.getBlNo().equals(manifestListBlInfoVOs[blIdx].getBlNo())) {
						// CM Info 정보
						for (MalaysiaManifestCmInfoVO malaysiaManifestCmInfoVO : dbDao.searchCmInfo(malaysiaManifestListCntrInfoVO)) {
							flatFile.append("{CM_INFO").append("\n");
							flatFile.append("CM_SEQ:").append(malaysiaManifestCmInfoVO.getCmSeq()).append("\n");
							flatFile.append("CM_PKG:").append(malaysiaManifestCmInfoVO.getCmPkg()).append("\n");
							flatFile.append("CM_PKG_UNIT:").append(malaysiaManifestCmInfoVO.getCmPkgUnit()).append("\n");
							flatFile.append("CM_WGT:").append(malaysiaManifestCmInfoVO.getCmWgt()).append("\n");
							flatFile.append("CM_WGT_UNIT:").append(malaysiaManifestCmInfoVO.getCmWgtUnit()).append("\n");
							flatFile.append("CM_MEA:").append(malaysiaManifestCmInfoVO.getCmMea()).append("\n");
							flatFile.append("CM_MEA_UNIT:").append(malaysiaManifestCmInfoVO.getCmMeaUnit()).append("\n");
							flatFile.append("HS_CODE:").append(malaysiaManifestCmInfoVO.getHsCode()).append("\n");
							flatFile.append("CM_CNTRNBR:").append(malaysiaManifestListCntrInfoVO.getCntrNo()).append("\n");

							// (6-1)Danger Goods 정보
							// Danger Goods 정보
							for (MalaysiaManifestDgGoodsInfoVO malaysiaManifestDgGoodsInfoVO : dbDao.searchDgGoodsInfo(manifestListBlInfoVOs[blIdx])) {
								flatFile.append("{DANGER_GOODS").append("\n");
								flatFile.append("HAZARD_CD:").append(malaysiaManifestDgGoodsInfoVO.getHazardCd()).append("\n");
								flatFile.append("UNDG_NO:").append(malaysiaManifestDgGoodsInfoVO.getUndgNo()).append("\n");
								flatFile.append("FLASH_POINT:").append(malaysiaManifestDgGoodsInfoVO.getFlashPoint()).append("\n");
								flatFile.append("}DANGER_GOODS").append("\n");
							}

							// (6-2)CM Description 정보
							for (MalaysiaManifestCmDescVO malaysiaManifestCmDescVO : dbDao.searchCmDesc(malaysiaManifestListCntrInfoVO, malaysiaManifestCmInfoVO.getCmSeq())) {
								flatFile.append("{CM_DESC").append("\n");
								flatFile.append("CM_DESC1:").append(malaysiaManifestCmDescVO.getCmDesc1()).append("\n");
								flatFile.append("CM_DESC2:").append(malaysiaManifestCmDescVO.getCmDesc2()).append("\n");
								flatFile.append("CM_DESC3:").append(malaysiaManifestCmDescVO.getCmDesc3()).append("\n");
								flatFile.append("CM_DESC4:").append(malaysiaManifestCmDescVO.getCmDesc4()).append("\n");
								flatFile.append("CM_DESC5:").append(malaysiaManifestCmDescVO.getCmDesc5()).append("\n");
								flatFile.append("}CM_DESC").append("\n");
							}
							flatFile.append("}CM_INFO").append("\n");
						}
					}
				}

				// (7)Description 정보
				flatFile.append("{DESC").append("\n");
				flatFile.append("DESC:").append(manifestListBlInfoVOs[blIdx].getDescription2()).append("\n");
				flatFile.append("}DESC").append("\n");

				// (8)Mark 정보
				for (MalaysiaManifestMarkInfoVO malaysiaManifestMarkInfoVO : dbDao.searchMarkInfo(manifestListBlInfoVOs[blIdx])) {
					flatFile.append("{MARK").append("\n");
					flatFile.append("MARKNO1:").append(malaysiaManifestMarkInfoVO.getMark1()).append("\n");
					flatFile.append("MARKNO2:").append(malaysiaManifestMarkInfoVO.getMark2()).append("\n");
					flatFile.append("MARKNO3:").append(malaysiaManifestMarkInfoVO.getMark3()).append("\n");
					flatFile.append("MARKNO4:").append(malaysiaManifestMarkInfoVO.getMark4()).append("\n");
					flatFile.append("MARKNO5:").append(malaysiaManifestMarkInfoVO.getMark5()).append("\n");
					flatFile.append("MARKNO6:").append(malaysiaManifestMarkInfoVO.getMark6()).append("\n");
					flatFile.append("MARKNO7:").append(malaysiaManifestMarkInfoVO.getMark7()).append("\n");
					flatFile.append("MARKNO8:").append(malaysiaManifestMarkInfoVO.getMark8()).append("\n");
					flatFile.append("MARKNO9:").append(malaysiaManifestMarkInfoVO.getMark9()).append("\n");
					flatFile.append("MARKNO10:").append(malaysiaManifestMarkInfoVO.getMark10()).append("\n");
					flatFile.append("}MARK").append("\n");
				}

				for (MalaysiaManifestListCntrInfoVO malaysiaManifestListCntrInfoVO : manifestListCntrInfoVOs) {
					if (malaysiaManifestListCntrInfoVO.getBlNo().equals(manifestListBlInfoVOs[blIdx].getBlNo())) {
						// (9)Container 정보
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(malaysiaManifestListCntrInfoVO.getCntrNo()).append("\n");
						flatFile.append("CNTRTYPE:").append(malaysiaManifestListCntrInfoVO.getCntrTpszCd()).append("\n");

						flatFile.append("CNTR_ISO_TP:").append(dbDao.searchCntrIsoTp(manifestListBlInfoVOs[blIdx].getBlNo(), malaysiaManifestListCntrInfoVO.getCntrNo())).append("\n");

						bkgCgoTpCd = dbDao.searchBkgCgoTpCd(manifestListBlInfoVOs[blIdx].getBkgNo());
						indFclLcl = dbDao.searchIndFclLcl(manifestListBlInfoVOs[blIdx].getBkgNo(), malaysiaManifestListCntrInfoVO.getCntrNo());

						if ("P".equals(bkgCgoTpCd) || "R".equals(bkgCgoTpCd)) {
							flatFile.append("CNTR_FM_IND:").append("5").append("\n");
						} else {
							if ("FCL".equals(indFclLcl)) {
								flatFile.append("CNTR_FM_IND:").append("1").append("\n");
							} else {
								flatFile.append("CNTR_FM_IND:").append("3").append("\n");
							}
						}
						flatFile.append("CNTRWGT:").append(malaysiaManifestListCntrInfoVO.getCntrWgt()).append("\n");
						flatFile.append("CNTRWGT_UNIT:").append(malaysiaManifestListCntrInfoVO.getWgtUtCd()).append("\n");
						flatFile.append("CNTRMEA:").append(malaysiaManifestListCntrInfoVO.getMeasQty()).append("\n");
						flatFile.append("CNTRMEA_UNIT:").append(malaysiaManifestListCntrInfoVO.getMeasUtCd()).append("\n");
						flatFile.append("CNTRTMP:").append(malaysiaManifestListCntrInfoVO.getCdoTemp()).append("\n");
						flatFile.append("CNTRTMP_UNIT:").append(malaysiaManifestListCntrInfoVO.getTempUnit()).append("\n");

						// (10)Container Seal 정보
						manifestListBlInfoVOs[blIdx].setCntrNo(malaysiaManifestListCntrInfoVO.getCntrNo());
						for (MalaysiaManifestCntrSealNoInfoVO malaysiaManifestCntrSealNoInfoVO : dbDao.searchCntrSealNoInfo(manifestListBlInfoVOs[blIdx])) {
							flatFile.append("{CNTR_SEAL_NO").append("\n");
							flatFile.append("SEALTYPE:").append(malaysiaManifestCntrSealNoInfoVO.getSealType()).append("\n");
							flatFile.append("SEALNBR:").append(malaysiaManifestCntrSealNoInfoVO.getSealNbr()).append("\n");
							flatFile.append("}CNTR_SEAL_NO").append("\n");
						}
						flatFile.append("}CNTR_INFO").append("\n");
					}
				} // end for (Container)

				flatFile.append("}BL_INFO").append("\n");
			} // end for (BL)

			// 전송로그를 저장한다.(MASTER)
			BkgCstmsMySndLogVO bkgCstmsMySndLogVO = new BkgCstmsMySndLogVO();
			bkgCstmsMySndLogVO.setMyMfSndIndCd(manifestListBlInfoVOs[0].getTrsmSts());
			bkgCstmsMySndLogVO.setFltFileRefNo(flatFileRefNo);
			bkgCstmsMySndLogVO.setVvd(manifestListBlInfoVOs[0].getVvd());
			bkgCstmsMySndLogVO.setPolCd(manifestListBlInfoVOs[0].getInputPolCd());
			bkgCstmsMySndLogVO.setPodCd(manifestListBlInfoVOs[0].getInputPodCd());
			bkgCstmsMySndLogVO.setMyCstmsBndCd(manifestListBlInfoVOs[0].getEIInd());
			bkgCstmsMySndLogVO.setOfcCd(account.getOfc_cd());
			bkgCstmsMySndLogVO.setBlKnt(manifestListBlInfoVOs[0].getBlKnt());
			bkgCstmsMySndLogVO.setTtlCntrKnt(manifestListBlInfoVOs[0].getTtlCntrKnt());
			bkgCstmsMySndLogVO.setUsrId(account.getUsr_id());
			dbDao.addCUSCARSndLog(bkgCstmsMySndLogVO);

			// FlatFile을 4000Byte씩 나눈다 - start(100Byte의 여유를 주기 위해 3900Byte로 나눔)
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

			// 전송로그를 저장한다.(DETAIL)
			BkgCstmsMySndLogDtlVO bkgCstmsMySndLogDtlVO = new BkgCstmsMySndLogDtlVO();
			for (int i = 0; i < loopCnt; i++) {
				if (i == loopCnt - 1) {
					end = remainder;
				} else {
					end = divisor;
				}
				start = i * divisor;
				fFiles[i] = flatFile.substring(start, start + end);

				bkgCstmsMySndLogDtlVO = new BkgCstmsMySndLogDtlVO();
				bkgCstmsMySndLogDtlVO.setMyMfSndIndCd(malaysiaVslInfoVO.getStatus());
				bkgCstmsMySndLogDtlVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsMySndLogDtlVO.setLogDtlSeq(Integer.toString(i + 1));
				bkgCstmsMySndLogDtlVO.setEdiSndMsg(fFiles[i]);
				bkgCstmsMySndLogDtlVO.setUsrId(account.getUsr_id());
				dbDao.addCUSCARSndDtlLog(bkgCstmsMySndLogDtlVO);
			}
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI 전송 처리부
	 *
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException {
		try {
			// FlatFile 이 빈 경우 SKIP 처리
			if (flatFile != null && flatFile.trim().length() > 1) {
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 시작<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitImpSts(MalaysiaImpStsVO malaysiaImpStsVO, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		MalaysiaCustomsTransmissionBackEndJob backEndJob = new MalaysiaCustomsTransmissionBackEndJob();
		try {
			backEndJob.setMalaysiaImpStsVO(malaysiaImpStsVO);
			backEndJob.setAccount(account);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Import Status EDI 전송
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitImpStsInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		String ediHeader = "";
		// BOOKING UTIL
		BookingUtil bookingUtil = new BookingUtil();
		// EDI 전송용 객체
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();

		String blNo = "";


		try {
			// EDI Header 조회
			ediHeader = bookingUtil.searchCstmsEdiHeaderNew("MY_TLIIMP");
			flatFile.append(ediHeader).append("\n");

			// FlatFile Header 조회
			MalaysiaHeadVO malaysiaHeadVO = dbDao.searchHeadFlatFile(malaysiaImpStsVO);

			// Header 만들기
			flatFile.append("TMNL_VSL_NM:").append(malaysiaHeadVO.getTmlVslNm()).append("\n");
			flatFile.append("TMNL_VSL_VOY_DIR:").append(malaysiaHeadVO.getTmlVoyDirCd()).append("\n");
			flatFile.append("VSL_NM:").append(malaysiaHeadVO.getVslEngNm()).append("\n");
			flatFile.append("VSL_VVD:").append(malaysiaHeadVO.getVslCd() + malaysiaHeadVO.getSkdVoyNo() + malaysiaHeadVO.getSkdDirCd()).append("\n");

			// Container FlatFile 만들기
			for (MalaysiaCntrVO malaysiaCntrVO : dbDao.searchCNTRInfoFlatFile(malaysiaImpStsVO)) {
				// flatFile 만들기
				flatFile.append("{CNTR_INFO").append("\n");
				flatFile.append("INS_TP:").append(malaysiaCntrVO.getTsTpCd()).append("\n");
				flatFile.append("SND_DT:").append(malaysiaCntrVO.getSndDt()).append("\n");
				flatFile.append("CNTR_NO:").append(malaysiaCntrVO.getCntrNo()).append("\n");
				flatFile.append("CNTR_TPSZ:").append(malaysiaCntrVO.getCntrTpsz()).append("\n");
				flatFile.append("BKG_NO:").append(malaysiaCntrVO.getBkgNo()).append("\n");

				blNo = dbDao.getBlNoForFlatFile(malaysiaCntrVO);
				flatFile.append("BL_NO:").append(blNo).append("\n");

				flatFile.append("CNTR_STS:").append(malaysiaCntrVO.getFullMtyCd()).append("\n");

				if ("V".equals(malaysiaCntrVO.getPsaCreTpCd())) {
					List<BkgXterVgmVO> bkgXterVgmVOList = dbDao.searchBkgXterVgmInfo(malaysiaCntrVO);
					if (bkgXterVgmVOList.size() > 0) {
						flatFile.append("DOC_ID:").append(bkgXterVgmVOList.get(0).getDocId()).append("\n");
						flatFile.append("MEAS_TP:").append(bkgXterVgmVOList.get(0).getMeasTp()).append("\n");
						flatFile.append("MEAS_DT:").append(bkgXterVgmVOList.get(0).getVgmHndlDt()).append("\n");
						flatFile.append("WGT:").append(malaysiaCntrVO.getVgmWgt().replaceAll(",","")).append("\n");
						flatFile.append("G_WGT:").append(malaysiaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
						flatFile.append("DOC_TP:").append(bkgXterVgmVOList.get(0).getVgmDocTp()).append("\n");
						flatFile.append("CUST_CNTC_TP:").append(bkgXterVgmVOList.get(0).getCustCntcTp()).append("\n");
						flatFile.append("CUST_CNTC_NM:").append(bkgXterVgmVOList.get(0).getCustCntcNm()).append("\n");
					} else {
						flatFile.append("DOC_ID:").append("\n");
						flatFile.append("MEAS_TP:").append("V").append("\n");
						flatFile.append("MEAS_DT:").append("\n");
						flatFile.append("WGT:").append(malaysiaCntrVO.getVgmWgt().replaceAll(",","")).append("\n");
						flatFile.append("G_WGT:").append(malaysiaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
						flatFile.append("DOC_TP:").append("SM2").append("\n");
						flatFile.append("CUST_CNTC_TP:").append("\n");
						flatFile.append("CUST_CNTC_NM:").append("\n");
					}
				} else {
					flatFile.append("DOC_ID:").append("\n");
					flatFile.append("MEAS_TP:").append("V").append("\n");
					flatFile.append("MEAS_DT:").append("\n");
					flatFile.append("WGT:").append(malaysiaCntrVO.getVgmWgt().replaceAll(",","")).append("\n");
					flatFile.append("G_WGT:").append(malaysiaCntrVO.getCntrWgt().replaceAll(",","")).append("\n");
					flatFile.append("DOC_TP:").append("SM2").append("\n");
					flatFile.append("CUST_CNTC_TP:").append("\n");
					flatFile.append("CUST_CNTC_NM:").append("\n");
				}

				flatFile.append("SOC_IND:").append(malaysiaCntrVO.getSocInd()).append("\n");
				flatFile.append("CNTR_OPR:").append(malaysiaCntrVO.getCntrOprCd()).append("\n");
				flatFile.append("IWRD_OPR:").append(malaysiaCntrVO.getIbSltOprCd()).append("\n");
				flatFile.append("RF_TEMP:").append(malaysiaCntrVO.getRcTemp()).append("\n");
				flatFile.append("VENT_CMH:").append(malaysiaCntrVO.getCbmPerHrQty()).append("\n");
				flatFile.append("DG_IND:").append(malaysiaCntrVO.getDcgoFlg()).append("\n");
				flatFile.append("OVH:").append(malaysiaCntrVO.getOvrDimHgt().replaceAll(",", "")).append("\n");
				flatFile.append("OVF:").append(malaysiaCntrVO.getOvrFntDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("OVB:").append(malaysiaCntrVO.getOvrBakDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("OVLW:").append(malaysiaCntrVO.getOvrLfDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("OVRW:").append(malaysiaCntrVO.getOvrRtDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("UMH:").append(malaysiaCntrVO.getDimHgt().replaceAll(",", "")).append("\n");
				flatFile.append("UMW:").append(malaysiaCntrVO.getDimWdt().replaceAll(",", "")).append("\n");
				flatFile.append("UML:").append(malaysiaCntrVO.getDimLen().replaceAll(",", "")).append("\n");
				flatFile.append("CGO_DESC:").append(malaysiaCntrVO.getCgoDesc()).append("\n");
				flatFile.append("HS_CD:").append(malaysiaCntrVO.getCmdtHsCd()).append("\n");
				flatFile.append("RS_IND:").append("\n");
				flatFile.append("CFS_TP:").append(malaysiaCntrVO.getCfsTpCd()).append("\n");
				flatFile.append("DEPOT_SVC:").append(malaysiaCntrVO.getDptSvcTpCd()).append("\n");
				flatFile.append("PTI_TP:").append(malaysiaCntrVO.getRfCntrPreTrdInspTpCd()).append("\n");
				flatFile.append("SPCL_INS:").append(malaysiaCntrVO.getStwgTpCd()).append("\n");
				flatFile.append("OWRD_OPR:").append(malaysiaCntrVO.getObSltOprCd()).append("\n");

				flatFile.append("BATCH_NBR:").append(JSPUtil.getNull(blNo.split(";")[0])).append("\n");

				if (malaysiaCntrVO.getCneeNm().toUpperCase().indexOf("ORDER ") > -1) {
					flatFile.append("CNEE:").append(malaysiaCntrVO.getNtfyNm()).append("\n");
				} else {
					flatFile.append("CNEE:").append(malaysiaCntrVO.getCneeNm()).append("\n");
				}
				flatFile.append("BL_POR:").append(malaysiaCntrVO.getPorCd()).append("\n");
				flatFile.append("BL_POD:").append(malaysiaCntrVO.getPodCd()).append("\n");
				flatFile.append("BL_DEL:").append(malaysiaCntrVO.getDelCd()).append("\n");
				flatFile.append("BL_POL:").append(malaysiaCntrVO.getPolCd()).append("\n");
				flatFile.append("POD1:").append(malaysiaCntrVO.getN1stPodCd()).append("\n");
				flatFile.append("POD2:").append(malaysiaCntrVO.getN2ndPodCd()).append("\n");
				flatFile.append("POD3:").append("\n");
				flatFile.append("DSCH_OVS:").append(malaysiaCntrVO.getDchgOvrSzFlg()).append("\n");
				flatFile.append("DEL_DIR:").append(malaysiaCntrVO.getDirDeFlg()).append("\n");

				String blckStwgCd = "";
				String slanCd = "";
				if (!"".equals(malaysiaCntrVO.getBlckStwgCd())) {
					blckStwgCd = malaysiaCntrVO.getBlckStwgCd();
					slanCd = malaysiaCntrVO.getSlanCd();
				}
				flatFile.append("BLK_STG:").append(blckStwgCd).append("\n");
				flatFile.append("SVC_LANE:").append(slanCd).append("\n");

				flatFile.append("SEAL:").append(malaysiaCntrVO.getCntrSealNo()).append("\n");
				flatFile.append("CLASS:").append(malaysiaCntrVO.getCntrClass()).append("\n");
				flatFile.append("2ND_VSL:").append(malaysiaCntrVO.getPsaVslNm()).append("\n");
				flatFile.append("2ND_VOY_DIR:").append(malaysiaCntrVO.getPsaVoyDirCd()).append("\n");
				flatFile.append("2ND_INS_TP:").append(malaysiaCntrVO.getTpCd2nd()).append("\n");
				flatFile.append("}CNTR_INFO").append("\n");
			}

			// EDI 전송
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
			// 전송결과 UPDATE
			dbDao.modifyImpStsSndInfo(malaysiaImpStsVO);

		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 결과<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitImpSts(String backEndJobKey) throws EventException {
		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}
