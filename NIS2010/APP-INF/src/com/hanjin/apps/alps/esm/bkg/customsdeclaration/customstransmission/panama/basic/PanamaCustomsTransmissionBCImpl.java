/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PanamaCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration.PanamaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHamoTrpCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListMctForBasicInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PanamaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient PanamaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public PanamaCustomsTransmissionBCImpl() {
		dbDao = new PanamaCustomsTransmissionDBDAO();
	}


	/**
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = new StringBuffer();
		String callSeq = "";
		PanamaManifestTransmitVO panamaManifestTransmitVO = (PanamaManifestTransmitVO) manifestTransmitVO;
		List<PanamaManifestListMctForBasicInfoVO> panamaManifestListMctForBasicInfoVOs = null;
		List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs = null;
		List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs = null;
		List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardousCargoDetailVOs = null;

		try {
			if (!panamaManifestTransmitVO.getVstNo().equals("") && !panamaManifestTransmitVO.getMvmtSeq().equals("")
					&& !panamaManifestTransmitVO.getPnmVslOprCd().equals("")
					&& !panamaManifestTransmitVO.getPnmOrgCd().equals("")
					&& !panamaManifestTransmitVO.getPnmDestCd().equals("")) {
				callSeq = dbDao.searchCallSeq(panamaManifestTransmitVO);
				panamaManifestTransmitVO.setClptSeq(callSeq);

				if (!callSeq.equals("") && callSeq != null) {
					// ACP(Authority of Canal of Panama)로 전송할 Manifest General Cargo 정보를 조회한다.
					panamaManifestListGeneralCargoDetailVOs = dbDao.searchGeneralCargoDetail(panamaManifestTransmitVO);
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Empty Cargo 정보를 조회한다.
					panamaManifestListEmptyCargoDetailVOs = dbDao.searchEmptyCargoDetail(panamaManifestTransmitVO);
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Hazardous Cargo 정보를 조회한다.
					panamaManifestListHazardousCargoDetailVOs = dbDao
							.searchHazardousCargoDetail(panamaManifestTransmitVO);

					if (panamaManifestListHazardousCargoDetailVOs.size() > 0) {
						panamaManifestTransmitVO.setDgpackage("Y");
					} else {
						panamaManifestTransmitVO.setDgpackage("N");
					}

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 조회한다.
					panamaManifestListMctForBasicInfoVOs = dbDao.searchMctForBasicInfo(panamaManifestTransmitVO);
					PanamaManifestListMctForBasicInfoVO panamaManifestListMctForBasicInfoVO = new PanamaManifestListMctForBasicInfoVO();
					if (panamaManifestListMctForBasicInfoVOs.size() > 0) {
						panamaManifestListMctForBasicInfoVO = panamaManifestListMctForBasicInfoVOs.get(0);
					}

					// ACP(Authority of Canal of Panama)로 전송할 FlatFile Header를 생성한다.
					String sequence = new SimpleDateFormat("yyMMdd").format(new Date())
							+ panamaManifestListMctForBasicInfoVO.getHeaderSeq().trim();
					flatFile.append("$$$MSGSTART:ph20040827081       ACP                 ACPDEC    BKC").append(
							sequence);

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 세팅한다.
					if (panamaManifestListMctForBasicInfoVO != null) {
						flatFile.append("\n");
						flatFile.append("VISITNO:").append(panamaManifestListMctForBasicInfoVO.getVstNo()).append("\n");
						flatFile.append("VVD:").append(panamaManifestListMctForBasicInfoVO.getVvdCd()).append("\n");
						flatFile.append("ORIGROUTE:").append(panamaManifestListMctForBasicInfoVO.getPnmOrgCd()).append(
								"\n");
						flatFile.append("DESTROUTE:").append(panamaManifestListMctForBasicInfoVO.getPnmDestCd())
								.append("\n");

						List<PanamaManifestListHamoTrpCdVO> panamaManifestListHamoTrpCdVOs = dbDao
								.searchHamoTrpCd(panamaManifestTransmitVO);
						if (panamaManifestListHamoTrpCdVOs.size() == 0) {
							flatFile.append("MCARGO:").append("470620").append("\n");
						} else {
							String hamoTrpCd = "";
							String attrCtnt = "";
							for (int i = 0; i < panamaManifestListHamoTrpCdVOs.size(); i++) {
								hamoTrpCd = panamaManifestListHamoTrpCdVOs.get(i).getHamoTrfCd();

								attrCtnt = dbDao.searchAttrCtnt(hamoTrpCd);
								if (attrCtnt != null && !attrCtnt.equals("")) {
									flatFile.append("MCARGO:").append(attrCtnt).append("\n");
									break;
								}
							}
							if (attrCtnt == null || attrCtnt.equals("")) {
								flatFile.append("MCARGO:").append("470620").append("\n");
							}
						}
						// flatFile.append("MCARGO:").append(panamaManifestListMctForBasicInfoVO.getMcargo()).append("\n");

						flatFile.append("CUSTCODE:").append(panamaManifestListMctForBasicInfoVO.getPnmVslOprCd())
								.append("\n");
						flatFile.append("CARGO:").append(panamaManifestListMctForBasicInfoVO.getCargo()).append("\n");
						flatFile.append("MTTANKS:").append(panamaManifestListMctForBasicInfoVO.getMttanks()).append(
								"\n");
						flatFile.append("DGBULK:").append(panamaManifestListMctForBasicInfoVO.getDgbulk()).append("\n");
						flatFile.append("DGPACKAGE:").append(panamaManifestListMctForBasicInfoVO.getDgpackage())
								.append("\n");
						flatFile.append("MOVESEQ:").append(panamaManifestListMctForBasicInfoVO.getMvmtSeq());
					}
					// ACP(Authority of Canal of Panama)로 전송할 Manifest General Cargo 정보를 세팅한다.
					for (int i = 0; i < panamaManifestListGeneralCargoDetailVOs.size(); i++) {
						PanamaManifestListGeneralCargoDetailVO panamaManifestListGeneralCargoDetailVO = panamaManifestListGeneralCargoDetailVOs
								.get(i);
						// 전체
						if (panamaManifestTransmitVO.getErrorType().equals("All")) {
							flatFile.append("\n");
							flatFile.append("{CNTR").append("\n");
							flatFile.append("CNTR_DESC:").append(panamaManifestListGeneralCargoDetailVO.getValue1())
									.append("\n");
							flatFile.append("CNTR_CNTRNO:").append(panamaManifestListGeneralCargoDetailVO.getCntrNo())
									.append("\n");
							flatFile.append("CNTR_POL:").append(panamaManifestListGeneralCargoDetailVO.getPolCd())
									.append("\n");
							flatFile.append("CNTR_POD:").append(panamaManifestListGeneralCargoDetailVO.getPodCd())
									.append("\n");
							flatFile.append("CNTR_QTY:").append(panamaManifestListGeneralCargoDetailVO.getValue2())
									.append("\n");
							flatFile.append("CNTR_TS:").append(panamaManifestListGeneralCargoDetailVO.getCntrTpszCd())
									.append("\n");
							flatFile.append("}CNTR");
							// 에러제외
						} else {
							if ((!panamaManifestListGeneralCargoDetailVO.getValue1().equals("") && panamaManifestListGeneralCargoDetailVO
									.getValue1() != null)
									&& (!panamaManifestListGeneralCargoDetailVO.getValue2().equals("0.000")))
							// || panamaManifestListGeneralCargoDetailVO.getValue2() != null))
							{
								flatFile.append("\n");
								flatFile.append("{CNTR").append("\n");
								flatFile.append("CNTR_DESC:")
										.append(panamaManifestListGeneralCargoDetailVO.getValue1()).append("\n");
								flatFile.append("CNTR_CNTRNO:").append(
										panamaManifestListGeneralCargoDetailVO.getCntrNo()).append("\n");
								flatFile.append("CNTR_POL:").append(panamaManifestListGeneralCargoDetailVO.getPolCd())
										.append("\n");
								flatFile.append("CNTR_POD:").append(panamaManifestListGeneralCargoDetailVO.getPodCd())
										.append("\n");
								flatFile.append("CNTR_QTY:").append(panamaManifestListGeneralCargoDetailVO.getValue2())
										.append("\n");
								flatFile.append("CNTR_TS:").append(
										panamaManifestListGeneralCargoDetailVO.getCntrTpszCd()).append("\n");
								flatFile.append("}CNTR");
							}
						}
					}

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Empty Cargo 정보를 세팅한다.
					for (int i = 0; i < panamaManifestListEmptyCargoDetailVOs.size(); i++) {
						PanamaManifestListEmptyCargoDetailVO panamaManifestListEmptyCargoDetailVO = panamaManifestListEmptyCargoDetailVOs
								.get(i);
						// 전체
						if (panamaManifestTransmitVO.getErrorType().equals("All")) {
							flatFile.append("\n");
							flatFile.append("{MT").append("\n");
							flatFile.append("MT_TOTAL:").append(panamaManifestListEmptyCargoDetailVO.getXMtTotal())
									.append("\n");
							flatFile.append("MT_LOC:").append(panamaManifestListEmptyCargoDetailVO.getXMtLoc()).append(
									"\n");
							flatFile.append("MT_TS:").append(panamaManifestListEmptyCargoDetailVO.getXMtTs()).append(
									"\n");
							flatFile.append("}MT");
							// 에러제외
						} else {
							if (!panamaManifestListEmptyCargoDetailVO.getXMtLoc().equals("C")) {
								flatFile.append("\n");
								flatFile.append("{MT").append("\n");
								flatFile.append("MT_TOTAL:").append(panamaManifestListEmptyCargoDetailVO.getXMtTotal())
										.append("\n");
								flatFile.append("MT_LOC:").append(panamaManifestListEmptyCargoDetailVO.getXMtLoc())
										.append("\n");
								flatFile.append("MT_TS:").append(panamaManifestListEmptyCargoDetailVO.getXMtTs())
										.append("\n");
								flatFile.append("}MT");
							}
						}
					}

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Hazardous Cargo 정보를 세팅한다.
					for (int i = 0; i < panamaManifestListHazardousCargoDetailVOs.size(); i++) {
						PanamaManifestListHazardousCargoDetailVO panamaManifestListHazardousCargoDetailVO = panamaManifestListHazardousCargoDetailVOs
								.get(i);
						// 전체
						if (panamaManifestTransmitVO.getErrorType().equals("All")) {
							flatFile.append("\n");
							flatFile.append("{DG").append("\n");
							flatFile.append("DG_UN:").append(panamaManifestListHazardousCargoDetailVO.getImdgUnNo())
									.append("\n");
							flatFile.append("DG_IMO:").append(panamaManifestListHazardousCargoDetailVO.getImdgClssCd())
									.append("\n");
							flatFile.append("DG_CMPGRP:").append(
									panamaManifestListHazardousCargoDetailVO.getImdgCoGrpCd()).append("\n");
							flatFile.append("DG_CNTRNO:").append(panamaManifestListHazardousCargoDetailVO.getCntrNo())
									.append("\n");
							flatFile.append("DG_FLASH:").append(panamaManifestListHazardousCargoDetailVO.getValue1())
									.append("\n");
							flatFile.append("DG_QTY:").append(panamaManifestListHazardousCargoDetailVO.getValue2())
									.append("\n");
							flatFile.append("DG_KEPTIN:")
									.append(panamaManifestListHazardousCargoDetailVO.getDgKeptin()).append("\n");
							flatFile.append("DG_TS:").append(panamaManifestListHazardousCargoDetailVO.getCntrTpszCd())
									.append("\n");
							flatFile.append("DG_POL:").append(panamaManifestListHazardousCargoDetailVO.getPolCd())
									.append("\n");
							flatFile.append("DG_POD:").append(panamaManifestListHazardousCargoDetailVO.getPodCd())
									.append("\n");
							flatFile.append("}DG");
							// 에러제외
						} else {
							if (!(panamaManifestListHazardousCargoDetailVO.getCntrNo().equals("") || panamaManifestListHazardousCargoDetailVO
									.getCntrNo() == null)
									&& !(panamaManifestListHazardousCargoDetailVO.getImdgClssCd().equals("1") && (panamaManifestListHazardousCargoDetailVO
											.getImdgCoGrpCd().equals("") || panamaManifestListHazardousCargoDetailVO
											.getImdgCoGrpCd() == null))
									&& !(panamaManifestListHazardousCargoDetailVO.getImdgClssCd().equals("3") && (panamaManifestListHazardousCargoDetailVO
											.getValue1().equals("") || panamaManifestListHazardousCargoDetailVO
											.getValue1() == null))) {
								flatFile.append("\n");
								flatFile.append("{DG").append("\n");
								flatFile.append("DG_UN:")
										.append(panamaManifestListHazardousCargoDetailVO.getImdgUnNo()).append("\n");
								flatFile.append("DG_IMO:").append(
										panamaManifestListHazardousCargoDetailVO.getImdgClssCd()).append("\n");
								flatFile.append("DG_CMPGRP:").append(
										panamaManifestListHazardousCargoDetailVO.getImdgCoGrpCd()).append("\n");
								flatFile.append("DG_CNTRNO:").append(
										panamaManifestListHazardousCargoDetailVO.getCntrNo()).append("\n");
								flatFile.append("DG_FLASH:").append(
										panamaManifestListHazardousCargoDetailVO.getValue1()).append("\n");
								flatFile.append("DG_QTY:").append(panamaManifestListHazardousCargoDetailVO.getValue2())
										.append("\n");
								flatFile.append("DG_KEPTIN:").append(
										panamaManifestListHazardousCargoDetailVO.getDgKeptin()).append("\n");
								flatFile.append("DG_TS:").append(
										panamaManifestListHazardousCargoDetailVO.getCntrTpszCd()).append("\n");
								flatFile.append("DG_POL:").append(panamaManifestListHazardousCargoDetailVO.getPolCd())
										.append("\n");
								flatFile.append("DG_POD:").append(panamaManifestListHazardousCargoDetailVO.getPodCd())
										.append("\n");
								flatFile.append("}DG");
							}
						}
					}
					flatFile.append("\n");
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NOTICE.IBMMQ.QUEUE"));

					BookingUtil command = new BookingUtil();
					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

					if (account != null)
						panamaManifestTransmitVO.setUpdUsrId(account.getUsr_id());
					else
						panamaManifestTransmitVO.setUpdUsrId("AUTO SEND");

				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo)
			throws EventException {
		PanamaCustomsTransmissionBackEndJob backEndJob = new PanamaCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			log.info("##########");
			log.info("pgmNo:"+pgmNo);
			log.info("##########");
			if (pgmNo.equals("ESM_BKG_0017")) {
				backEndJob.setManifestTransmitVO(manifestTransmitVO);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Panama Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}	
}