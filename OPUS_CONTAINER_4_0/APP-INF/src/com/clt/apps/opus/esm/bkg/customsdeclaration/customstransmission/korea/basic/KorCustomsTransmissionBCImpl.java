/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionBCImpl.java
*@FileTitle : KorCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration.KorCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrVvdSmryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAckMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAutoMacSndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrCntVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrNoKorVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusdmrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmanVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusrepVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgCgoVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDiscFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorElnoInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpAmdManiTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpImfmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpMacamdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIbManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorImfmodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMFTVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMacamdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeSubNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestCancelTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestMFTTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorRcvAckMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorUNLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.AmdFormVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.AmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DgmManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.EmpAmdManiTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGMTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGNTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestMFTTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlAmdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class KorCustomsTransmissionBCImpl extends BasicCommandSupport implements KorCustomsTransmissionBC {

	// Database Access Object
	private transient KorCustomsTransmissionDBDAO dbDao = null;

	/**
	 * KorCustomsTransmissionBCImpl 객체 생성<br>
	 * KorCustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public KorCustomsTransmissionBCImpl() {
		dbDao = new KorCustomsTransmissionDBDAO();
	}

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 *
	 * @param KorMrnCreateInfoCondVO korMrnCreateInfoCondVO
	 * @return List<KorMrnCreateInfoVO>
	 * @throw EventException
	 */
	public List<KorMrnCreateInfoVO> searchMrnCreateInfo(KorMrnCreateInfoCondVO korMrnCreateInfoCondVO) throws EventException {
		try {
			return dbDao.searchMrnCreateInfo(korMrnCreateInfoCondVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * MRN Create 정보 유효성 검사
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @throw EventException
	 */
	public void validateMrnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs) throws EventException {
		try {
			for (KorMrnCreateInfoVO korMrnCreateInfoVO : korMrnCreateInfoVOs) {
				// MRN 중복 체크 추가(2013.10.23)
				//if (dbDao.searchMrnChk(korMrnCreateInfoVO) != null) throw new EventException(new ErrorHandler("BKG01118").getMessage());
				// VVD Check
				if (dbDao.searchMrnInfoByVVD(korMrnCreateInfoVO) != null) throw new EventException(new ErrorHandler("BKG01118").getMessage());
				// MRN Check
				//if (dbDao.searchMrnInfoByMrn(korMrnCreateInfoVO) != null) throw new EventException(new ErrorHandler("BKG01119").getMessage());
				// VSL INFO 조회
				if (dbDao.searchVslSkdInfo(korMrnCreateInfoVO) == null) throw new EventException(new ErrorHandler("BKG00007").getMessage());
			}
		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListVO
	 * @throw EventException
	 */
	public ManifestListVO searchManifestListForTransmit(ManifestListCondVO manifestListCondVO) throws EventException {
		KorManifestListVO 		korManifestListVO = new KorManifestListVO();
		KorManifestListCondVO 	condVO = (KorManifestListCondVO)manifestListCondVO;//intype ='a,b,c'
		List<KorAmdBlInfoVO> 	listVOs = new ArrayList<KorAmdBlInfoVO>();
		List<KorCntrNoKorVO> 	cntrListVOs = new ArrayList<KorCntrNoKorVO>();
		BkgCstmsKrCntrVO		bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
		KorCntrNoKorVO[]		korCntrNoKorVOs = null;

		try {
			// TYPE 처리
			String inType = condVO.getInType();
			if (inType==null || "|A|B|C|D|M".indexOf(inType) < 1 ) inType="N";
			// PORT 처리
			String portCd = condVO.getPodCd();
			if (condVO.getIoBndCd().equals("O")) portCd = condVO.getPolCd();

			// MRN NO 조회
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
			// 파라메터 설정
			bkgCstmsKrVvdSmryVO.setVvd		(condVO.getVvd()	);
			bkgCstmsKrVvdSmryVO.setIoBndCd	(condVO.getIoBndCd());
			bkgCstmsKrVvdSmryVO.setInType	(inType				);//intype
			bkgCstmsKrVvdSmryVO.setPolCd	(condVO.getPolCd()	);
			bkgCstmsKrVvdSmryVO.setPodCd	(condVO.getPodCd()	);
			// 조회
			bkgCstmsKrVvdSmryVO = dbDao.searchMrnNoKor(bkgCstmsKrVvdSmryVO);

			// POD_TML 처리
			String podTml2 = condVO.getYardCd();
			if (podTml2 != null && !"".equals(podTml2)) {
				podTml2 = portCd + condVO.getYardCd();
			} else {
				podTml2 = portCd;
			}
			condVO.setYardCd(podTml2);

			// BL INFO 조회
			KorAmdBlInfoVO korAmdBlInfoVO 	 = new KorAmdBlInfoVO();
			KorAmdBlInfoVO[] korAmdBlInfoVOs = null;

			// 파라메터 설정
			korAmdBlInfoVO.setIoBndCd	(condVO.getIoBndCd()	);
			korAmdBlInfoVO.setPortCd	(portCd					);
			korAmdBlInfoVO.setPolCd		(condVO.getPolCd()		);
			korAmdBlInfoVO.setPodCd		(condVO.getPodCd()		);
			korAmdBlInfoVO.setVvd		(condVO.getVvd()		);
			korAmdBlInfoVO.setYardCd	(condVO.getYardCd()		);
			korAmdBlInfoVO.setBlNo		(condVO.getBlNo()		);
			// 조회
			korAmdBlInfoVOs = dbDao.searchAmdBlInfoKor(korAmdBlInfoVO);

			String bndCd    = null;

			// CUSTOMER 조회용 객체
			KorCustInfoCondVO custInfoCondVO = new KorCustInfoCondVO();
			KorCustInfoVO custInfoVO = null;
			// SHIP ADDRESS CHECK 용 객체
			KorCustChkVO custChkVO = new KorCustChkVO();
			String shipChk = null;
			// CONTAINER 수량 조회용 객체
			KorCntrInfoCondVO cntrInfoCondVO = new KorCntrInfoCondVO();
			String cntrCnt = "0";
			// ELNO 조회용 객체
			KorElnoInfoCondVO elnoInfoCondVO = new KorElnoInfoCondVO();

			if (korAmdBlInfoVOs == null) {
				korAmdBlInfoVOs = new KorAmdBlInfoVO[0];
			}
			// LOOP
			for (int i=0; i < korAmdBlInfoVOs.length; i++) {
				korAmdBlInfoVO = korAmdBlInfoVOs[i];
				bndCd = korAmdBlInfoVO.getKrCstmsBndCd();

				// OUT BOUND 처리
				if (condVO.getIoBndCd().equals("O")) {
					if (inType.equals("A")) {//A일때 P이면 나가야함 , 그리고
						if ("P".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
						if (!bndCd.equals("A")) continue;
					} else  if (inType.equals("B")) {
						if ("P".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
						if (!bndCd.equals("B")) continue;
					} else  if (inType.equals("C")) {
						if (!bndCd.equals("C")) continue;
						korAmdBlInfoVO.setBdAreaCd("");
					} else  if (inType.equals("D")) {
						if (bndCd.equals("N")) continue;
						if (bndCd.equals("C")) korAmdBlInfoVO.setBdAreaCd("");
					} else  if (inType.equals("M")) {
						if ("F".equals(korAmdBlInfoVO.getBkgCgoTpCd())||"R".equals(korAmdBlInfoVO.getBkgCgoTpCd())||"B".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
					}
				} else {
					// IN BOUND 처리
					if (korAmdBlInfoVO.getCstmsDeclTpCd().equals("T")) {
						korAmdBlInfoVO.setWh("");
					}
				}

				// CUSTOMER INFO 조회
				// 파라메터 셋팅
				custInfoCondVO.setIoBndCd		(condVO.getIoBndCd()				);
				custInfoCondVO.setBkgNo			(korAmdBlInfoVO.getBkgNo()			);
				custInfoCondVO.setPortCd		(portCd								);
				custInfoCondVO.setTrnsSeq		(korAmdBlInfoVO.getTrnsSeq()		);
				custInfoCondVO.setCstmsDeclTpCd	(korAmdBlInfoVO.getCstmsDeclTpCd()	);
				// 조회
				custInfoVO = dbDao.searchCustInfoKor(custInfoCondVO);
				// 조회 결과 처리
				korAmdBlInfoVO.setSNm	(custInfoVO.getSNm()	);
				korAmdBlInfoVO.setSAddr	(custInfoVO.getSAddr()	);
				korAmdBlInfoVO.setCNm	(custInfoVO.getCNm()	);
				korAmdBlInfoVO.setCAddr	(custInfoVO.getCAddr()	);
				korAmdBlInfoVO.setNNm	(custInfoVO.getNNm()	);
				korAmdBlInfoVO.setNAddr	(custInfoVO.getNAddr()	);
				korAmdBlInfoVO.setCustNm(custInfoVO.getCustNm()	);

				// SHIP NAME CHECK
				// 파라메터 셋팅
				custChkVO.setBkgNo			(korAmdBlInfoVO.getBkgNo()			);
				custChkVO.setCstmsDeclTpCd	(korAmdBlInfoVO.getCstmsDeclTpCd()	);
				custChkVO.setPortCd			(portCd								);
				custChkVO.setTrnsSeq		(korAmdBlInfoVO.getTrnsSeq()		);

				// 조회
				shipChk = dbDao.searchCustInfoCheck(custChkVO);
				// 조회값 처리
				if (shipChk != null && shipChk.equals("N")) korAmdBlInfoVO.setSAddr("N");

				// 컨테이너 수량 조회
				// 파라메터 셋팅
				cntrInfoCondVO.setBkgNo			(korAmdBlInfoVO.getBkgNo()			);
				cntrInfoCondVO.setCstmsDeclTpCd	(korAmdBlInfoVO.getCstmsDeclTpCd()	);
				cntrInfoCondVO.setPortCd		(portCd								);
				cntrInfoCondVO.setTrnsSeq		(korAmdBlInfoVO.getTrnsSeq()		);
				cntrInfoCondVO.setCBlNo			(korAmdBlInfoVO.getCBlNo()			);
				// 조회
				cntrCnt = dbDao.searchCNTRTtlCntKor(cntrInfoCondVO);
				// 조회 값 처리
				korAmdBlInfoVO.setCntrCnt(cntrCnt);

				// OUT BOUND LOCAL 이 E 인 경우 처리
				if (korAmdBlInfoVO.getCstmsDeclTpCd().equals("E")) {
					// BL TYPE 이 SIMPLE 인 경우 처리
					if (korAmdBlInfoVO.getKrCstmsBlTpCd().equals("S")) {
						// ELNO 관련 조회
						elnoInfoCondVO.setBkgNo			(korAmdBlInfoVO.getBkgNo()			);
						elnoInfoCondVO.setCstmsDeclTpCd	(korAmdBlInfoVO.getCstmsDeclTpCd()	);
						elnoInfoCondVO.setPortCd		(portCd								);
						elnoInfoCondVO.setTrnsSeq		(korAmdBlInfoVO.getTrnsSeq()		);
						// 조회
						elnoInfoCondVO = dbDao.searchExportCntKor(elnoInfoCondVO);
						// 조회 결과 처리
						if (elnoInfoCondVO==null) {
							korAmdBlInfoVO.setElnoB("U");
						} else {
							korAmdBlInfoVO.setElnoA(elnoInfoCondVO.getCntFlg());
							if (elnoInfoCondVO.getCntrWgt().equals(korAmdBlInfoVO.getCntrChkWgt())) {
								korAmdBlInfoVO.setElnoB("M");
							} else {
								korAmdBlInfoVO.setElnoB("U");
							}
						}
					} else {
						// BL TYPE 이 SIMPLE 이 아닌 경우 처리
						korAmdBlInfoVO.setElnoA("");
						korAmdBlInfoVO.setElnoB("");
					}
				} else {
					// IN BOUND 처리
					korAmdBlInfoVO.setElnoA("");
					korAmdBlInfoVO.setElnoB("");
				}

				// 에러 유무 체크
				if ( korAmdBlInfoVO.getBlSeqNo().equals("N") ||
					 korAmdBlInfoVO.getWh().equals("N") ||
					 korAmdBlInfoVO.getCgoDesc1().equals("N") ||
					 korAmdBlInfoVO.getSNm().equals("N") ||
					 korAmdBlInfoVO.getSAddr().equals("N") ||
					 korAmdBlInfoVO.getCNm().equals("N") ||
					 korAmdBlInfoVO.getNNm().equals("N") ||
					 korAmdBlInfoVO.getCmdtCd().equals("N") ||
					 korAmdBlInfoVO.getBizRgstNo().equals("N") ||
					 korAmdBlInfoVO.getCntrCnt().equals("0") ||
					 korAmdBlInfoVO.getPckQty().equals("0") ||
					 korAmdBlInfoVO.getCntrTtlWgt().equals("0") ||
					 korAmdBlInfoVO.getElnoB().equals("U")
				) {
					korAmdBlInfoVO.setErrorCheck("E");
				} else {
					if (korAmdBlInfoVO.getCstmsDeclTpCd().equals("I") || korAmdBlInfoVO.getCstmsDeclTpCd().equals("T") ) {
						if (korAmdBlInfoVO.getBdAreaCd().equals("N") ||
							korAmdBlInfoVO.getCAddr().equals("N") ||
							korAmdBlInfoVO.getNAddr().equals("N")
						) {
							korAmdBlInfoVO.setErrorCheck("E");
						} else {
							korAmdBlInfoVO.setErrorCheck("N");
						}
					} else {
						korAmdBlInfoVO.setErrorCheck("N");
					}
				}

				// Container 정보 추출
				bkgCstmsKrCntrVO.setBkgNo			(korAmdBlInfoVO.getBkgNo()			);
				bkgCstmsKrCntrVO.setCstmsDeclTpCd	(korAmdBlInfoVO.getCstmsDeclTpCd()	);
				bkgCstmsKrCntrVO.setPortCd			(portCd								);
				bkgCstmsKrCntrVO.setTrnsSeq			(korAmdBlInfoVO.getTrnsSeq()		);
				bkgCstmsKrCntrVO.setCBlNo			(korAmdBlInfoVO.getCBlNo()			);

				korCntrNoKorVOs = dbDao.searchCntrNoKorList(bkgCstmsKrCntrVO);
				if (korCntrNoKorVOs != null) {
					for (int j=0; j < korCntrNoKorVOs.length; j++) {
						korCntrNoKorVOs[j].setBkgCgoTpCd(korAmdBlInfoVO.getBkgCgoTpCd());
						cntrListVOs.add(korCntrNoKorVOs[j]);
					}
				}

				listVOs.add(korAmdBlInfoVO);
			}

			korManifestListVO.setKorAmdBlInfoVOs(listVOs.toArray(new KorAmdBlInfoVO[0]));
			korManifestListVO.setKorCntrNoKorVOs(cntrListVOs.toArray(new KorCntrNoKorVO[0]));

			if (bkgCstmsKrVvdSmryVO != null) {
				korManifestListVO.setMrnNo		(bkgCstmsKrVvdSmryVO.getMrnNo()		);
				korManifestListVO.setMrnChkNo	(bkgCstmsKrVvdSmryVO.getMrnChkNo()	);
			} else {
				korManifestListVO.setMrnNo		("");
				korManifestListVO.setMrnChkNo	("");
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korManifestListVO;
	}

	/**
	 * Manifest Transmit Discharge ( 하선신고 )
	 *
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {
		// 파라메터 변환
		KorDischManifestTransmitVO condVO = (KorDischManifestTransmitVO)dischManifestTransmitVO;

		// IN TYPE 처리
		String inType = condVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())) {
			portCd = condVO.getPolCd();
		}

		// FlatFile 객체
		String 		 flatFileHeader = null;
		StringBuffer flatFileBody   = new StringBuffer();
		StringBuffer tempData 		= new StringBuffer();
		StringBuffer flatFile 		= new StringBuffer();
		String		 flatFileRefNo 	= null;
		StringBuffer bfTemp 		= new StringBuffer();
		String[]     arTemp 		= null;
		// flatFile 생성용 객체
		KorDiscFlatFileVO   korDiscFlatFileVO = new KorDiscFlatFileVO();
		KorDiscFlatFileVO[] korDiscFlatFileVOs = null;
		String[] cntrDatas 		= null;
		BookingUtil bookingUtil = new BookingUtil();
		int k=0;

		// 전송일시
		String sndDt = null;

		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO 		= new BkgCstmsKrSndLogVO();
		// TEU, FEU count 용 객체
		KorCntrCntVO korCntrCntVO = new KorCntrCntVO();
		int teuCnt=0, feuCnt=0;

		try {

			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KTNETMFCSS", "CUSAGD");
			flatFileRefNo = flatFileHeader.substring(62).trim();
			// FlatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");


			// FLATFILE 헤더 생성(DB 이용)
			korDiscFlatFileVO.setCstmsDschCd	(condVO.getCstmsDchgCd()	);
			korDiscFlatFileVO.setMrnNo			(condVO.getMrnNo()			);
			korDiscFlatFileVO.setLoclCstmsCd	(condVO.getLoclCstmsCd()	);
			korDiscFlatFileVO.setLoclCstmsPrtCd	(condVO.getLoclCstmsPrtCd()	);
			// 헤더 생성
			flatFileHeader = dbDao.makeDiscHeadFlatFile(korDiscFlatFileVO);
			arTemp = flatFileHeader.split("~", 100);

			k=0;
			bfTemp.setLength(0);
			bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
			bfTemp.append("PARTY:").append(arTemp[k++]).append("\n");
			bfTemp.append("DSCH_COM:").append(arTemp[k++]).append("\n");
			bfTemp.append("PLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("RPLI:").append(arTemp[k++]).append("\n");

			// FlatFile 에 추가
			flatFile.append(bfTemp.toString());
			flatFileHeader = flatFile.toString();

			// 전송일시 생성 (YYYYMMDD hh24:mi:ss)
			sndDt = dbDao.searchSysDate();

			// SEND LOG 추가
			// BL_CNT 는 화면에서 넘어오는 MST_BL_KNT 로 사용
			bkgCstmsKrSndLogVO.setBlKnt			(condVO.getMstBlKnt()	);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()		);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()		);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo			);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()		);
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd()	);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if ("E".equals(condVO.getNoneBlInType())) {
				bkgCstmsKrSndLogVO.setInType		(condVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()		);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			// 로그 기록
			dbDao.addDiscSndLog(bkgCstmsKrSndLogVO);

			if (!"E".equals(condVO.getNoneBlInType())) {

				// FLATFILE BODY 생성
				korDiscFlatFileVO.setVvd(condVO.getVvd());
				korDiscFlatFileVO.setPortCd(portCd);
				korDiscFlatFileVO.setInType(inType);
				korDiscFlatFileVO.setIoBndCd(condVO.getIoBndCd());
				korDiscFlatFileVO.setPodCd(condVO.getPodCd());
				korDiscFlatFileVO.setPolCd(condVO.getPolCd());
				// 조회
					korDiscFlatFileVOs = dbDao.makeDiscBodyFlatFile(korDiscFlatFileVO);
				// 조회 결과 LOOP
				for (int i=0; i < korDiscFlatFileVOs.length; i++) {
					korDiscFlatFileVO = korDiscFlatFileVOs[i];
					// FlatFile 만들기
					arTemp = korDiscFlatFileVO.getBlData().split("~",100);

					tempData.setLength(0);
					k=0;

					tempData.append("{BL_CNTR").append("\n");
					tempData.append("BLNBR:").append(arTemp[k++]).append("\n");
					tempData.append("T_REF_NO:").append(arTemp[k++]).append("\n");
					tempData.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
					tempData.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					tempData.append("PKGU:").append(arTemp[k++]).append("\n");
					tempData.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					// flatFile Body 에 추가
					flatFileBody.append(tempData);

					// CONTAINER FLATFILE 생성
					korDiscFlatFileVO.setPortCd(portCd);
					korDiscFlatFileVO.setUserId(condVO.getUserId());
					cntrDatas = dbDao.makeDiscCntrFlatFile(korDiscFlatFileVO);
					// TEU, FEU 카운트 조회
					korCntrCntVO = new KorCntrCntVO();
					// 중복 제거
					if (i==0 || !korDiscFlatFileVOs[i-1].getBkgNo().equals(korDiscFlatFileVOs[i].getBkgNo()) ) {
						korCntrCntVO.setBkgNo			(korDiscFlatFileVOs[i].getBkgNo()			);
						korCntrCntVO.setCstmsDeclTpCd	(korDiscFlatFileVOs[i].getCstmsDeclTpCd()	);
						korCntrCntVO.setPortCd			(portCd										);
						korCntrCntVO = dbDao.searchTeuFeuCnt(korCntrCntVO);

						if (korCntrCntVO != null) {
							// COUNT 누적
							teuCnt = teuCnt + Integer.parseInt(korCntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(korCntrCntVO.getFeuCnt());
						}
					}

					// CONTAINER LOOP
					if (cntrDatas != null) {
						for (int j=0; j < cntrDatas.length; j++) {
							// TEMP 에 추가
							tempData.setLength(0);
							tempData.append("{CNTR_INFO").append("\n");
							tempData.append("CNTRNBR:").append(cntrDatas[j]).append("\n");
							tempData.append("}CNTR_INFO").append("\n");
							// flatFile Body 에 추가
							flatFileBody.append(tempData);

						}
					}

					// FLATFILE FOOTER 생성
					flatFileBody.append("}BL_CNTR\n");
				}
			}

			flatFile.append(flatFileBody);
			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

			// 전송 로그 업데이트
			bkgCstmsKrSndLogVO.setTeuCnt(String.valueOf(teuCnt));
			bkgCstmsKrSndLogVO.setFeuCnt(String.valueOf(feuCnt));
			bkgCstmsKrSndLogVO.setEdiSndMsgCtnt(flatFile.toString());
			dbDao.modifyDiscSndLog(bkgCstmsKrSndLogVO);

			return flatFile.toString();

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param KorManifestTransmitVO korManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitManifest(KorManifestTransmitVO korManifestTransmitVO) throws EventException {
		// FLATFILE
		StringBuffer flatFile = new StringBuffer();
		String fltFileRefNo = null;
		String[] arTemp = null;
		StringBuffer bfTemp = new StringBuffer();
		int k=0;

		// POL TML 생성
		String polTml = korManifestTransmitVO.getPolCd() + korManifestTransmitVO.getPolYdCd();
		// POD TML 생성
		String podTml = korManifestTransmitVO.getPodCd() + korManifestTransmitVO.getTmlCd();
		// IN TYPE 처리
		String inType = korManifestTransmitVO.getInType();
		//if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";

		// PORT CD 처리
		String portCd = korManifestTransmitVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(korManifestTransmitVO.getIoBndCd())) {
			portCd = korManifestTransmitVO.getPolCd();
		}

		// Bond Code Update 용 객체
		BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
		// VVD SEND UPDATE 용 객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
		// PORT 검색결과
		String unPolCd = null;
		String unPodCd = null;
		//String delCd = null;
		// 일괄삭제 후 재전송 여부
		String resndChk = null;

		// FLATFILE 관련 객체
		String flatFileHeader = null;
		StringBuffer flatFileBody   = new StringBuffer();
		StringBuffer flatFileExport = new StringBuffer();
		StringBuffer flatFileCNTR   = new StringBuffer();

		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		KorCusrepVO korCusrepVO = new KorCusrepVO();
		// BODY 생성용 객체
		KorCusmanVO   korCusmanVO  = new KorCusmanVO();
		KorCusmanVO[] korCusmanVOs = null;

		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO 	  bkgCstmsKrSndLogVO 	= new BkgCstmsKrSndLogVO();
		// TEU, FEU COUNT 용 객체
		KorCntrCntVO cntrCntVO = new KorCntrCntVO();
		// Export License 객체
		String[] elDatas = null;
		// Container 객체
		String[] cntrDatas = null;
		// Seal Number 관련
		String tempSealNumber = null;
		String[] sealNumbers = null;

		// TEU,FEU 누적용 변수
		int teuCnt = 0;
		int feuCnt = 0;

		// SEND DATE
		String sndDt = null;

		try {
			bkgCstmsKrBlVO.setVvd		(korManifestTransmitVO.getVvd()	);
			bkgCstmsKrBlVO.setPortCd	(portCd				);
			bkgCstmsKrBlVO.setInType	(inType				);
			bkgCstmsKrBlVO.setIoBndCd	(korManifestTransmitVO.getIoBndCd());
			bkgCstmsKrBlVO.setPolCd		(korManifestTransmitVO.getPolCd()	);
			bkgCstmsKrBlVO.setPolTml	(polTml				);
			bkgCstmsKrBlVO.setPodCd		(korManifestTransmitVO.getPodCd()	);
			bkgCstmsKrBlVO.setPodTml	(podTml				);
			bkgCstmsKrBlVO.setUserId	(korManifestTransmitVO.getUserId()	);

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (korManifestTransmitVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (korManifestTransmitVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (korManifestTransmitVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (korManifestTransmitVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (korManifestTransmitVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (korManifestTransmitVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (korManifestTransmitVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (korManifestTransmitVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (korManifestTransmitVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (korManifestTransmitVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (korManifestTransmitVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (korManifestTransmitVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(korManifestTransmitVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (korManifestTransmitVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (korManifestTransmitVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);

			// UNLOCODE 조회
			if (korManifestTransmitVO.getIoBndCd().equals("O")) {
				// OUT-BOUND 처리
				unPolCd = dbDao.searchOBUNLocCd(korManifestTransmitVO.getPolCd());
			} else {
				// IN-BOUND 처리
				unPodCd = dbDao.searchIBUNLocCd(korManifestTransmitVO.getPodCd());
			}

			// 일괄삭제후 재전송일 경우
			if (korManifestTransmitVO.getInReceiver().equals("1")) resndChk = "P";

			// 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("KR_CUSREP");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if ("3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) flatFileHeader = flatFileHeader.replace("KORCUS  ", "KORCUS3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			fltFileRefNo = flatFileHeader.substring(62).trim();

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// FLATFILE 헤더 생성
			korCusrepVO.setResndChk			(resndChk					);
			korCusrepVO.setKtPa				(korManifestTransmitVO.getKtPa()			);
			korCusrepVO.setIoBndCd			(korManifestTransmitVO.getIoBndCd()		);
			korCusrepVO.setLoclCstmsCd		(korManifestTransmitVO.getLoclCstmsCd()	);
			korCusrepVO.setLoclCstmsPrtCd	(korManifestTransmitVO.getLoclCstmsPrtCd()	);
			korCusrepVO.setVslCntCd			(korManifestTransmitVO.getVslCntCd()		);
			korCusrepVO.setVslNm			(korManifestTransmitVO.getVslNm()			);
			korCusrepVO.setVslCallSgnCd		(korManifestTransmitVO.getVslCallSgnCd()	);
			korCusrepVO.setMrnNo			(korManifestTransmitVO.getMrnNo()			);
			korCusrepVO.setVvd				(korManifestTransmitVO.getVvd()			);
			korCusrepVO.setUnPodCd			(unPodCd					);
			korCusrepVO.setUnPolCd			(unPolCd					);
			korCusrepVO.setPolCd			(korManifestTransmitVO.getPolCd()			);
			korCusrepVO.setPodCd			(korManifestTransmitVO.getPodCd()			);
			korCusrepVO.setEtaDt			(korManifestTransmitVO.getEtaDt()			);
			korCusrepVO.setEtdDt			(korManifestTransmitVO.getEtdDt()			);
			korCusrepVO.setMsnNo			(korManifestTransmitVO.getJoCrrKnt()		);
			korCusrepVO.setInType			(inType						);
			korCusrepVO.setVvdSeq			(korManifestTransmitVO.getVvdSeq()			);
			korCusrepVO.setCallKnt			(korManifestTransmitVO.getCallKnt());
			korCusrepVO.setDelCd			(korManifestTransmitVO.getDelCd()			);

			// 헤더 추가정보 생성
			// 공동 VVD 인 경우
			if ("E".equals(korManifestTransmitVO.getNoneBlInType())) {
				// Out bound 일때만 inType = 'E'로 세팅.
				if (korManifestTransmitVO.getIoBndCd().equals("O")) {
					korCusrepVO.setInType(korManifestTransmitVO.getNoneBlInType());
				}
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if ("3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) {
	flatFileHeader = dbDao.makeCUSREPNoneBLVVDFlatFile3G(korCusrepVO);
} else {
	flatFileHeader = dbDao.makeCUSREPNoneBLVVDFlatFile(korCusrepVO);
}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			} else {
			// 일반 헤더 파일
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if ("3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) {
	flatFileHeader = dbDao.makeCUSREPFlatFile3G(korCusrepVO);
} else {
	flatFileHeader = dbDao.makeCUSREPFlatFile(korCusrepVO);
}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			}
			arTemp = flatFileHeader.split("~",100);

			k = 0;
			bfTemp.setLength(0);

			bfTemp.append("{MASTER:").append(arTemp[k++]).append("\n");
			bfTemp.append("PLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("RPLI:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCOUNTRY:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLFULLNAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLVOY:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLDIR:").append(arTemp[k++]).append("\n");
			bfTemp.append("CON_VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("SENDDATE:").append(arTemp[k++]).append("\n");
			bfTemp.append("SENDTIME:").append(arTemp[k++]).append("\n");
			bfTemp.append("PARTY:").append(arTemp[k++]).append("\n");
			bfTemp.append("POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("POD:").append(arTemp[k++]).append("\n");

			//delCd = dbDao.searchDelCd(condVO.getVvd(),condVO.getPolCd());
			//bfTemp.append("DEL:").append(delCd).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MBT:").append(arTemp[k++]).append("\n");
			bfTemp.append("CBT:").append(arTemp[k++]).append("\n");
			bfTemp.append("TWGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("TMEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("TPKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("FCT:").append(arTemp[k++]).append("\n");
			bfTemp.append("ECT:").append(arTemp[k++]).append("\n");
			bfTemp.append("JOINT:").append(arTemp[k++]).append("\n");
			bfTemp.append("AGENCY:").append(arTemp[k++]).append("\n");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if (!"3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) {
	bfTemp.append("AGENCY2:").append(arTemp[k++]).append("\n");
	bfTemp.append("AGENCY3:").append(arTemp[k++]).append("\n");
}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			bfTemp.append("INPORT_YYYY:").append(arTemp[k++]).append("\n");
			bfTemp.append("INPORT_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("PORT_AUTH:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCOM_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("}MASTER").append("\n");

			flatFile.append(bfTemp);

			// FLATFILE BODY 생성시작
			flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("KR_CUSMAN");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if ("3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) flatFileHeader = flatFileHeader.replace("KORCUS  ", "KORCUS3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			flatFileHeader = flatFileHeader.substring(0, 62) + fltFileRefNo;

			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if (!"E".equals(korManifestTransmitVO.getNoneBlInType())) {

				korCusmanVO.setResndChk	(resndChk				);
				korCusmanVO.setKtPa		(korManifestTransmitVO.getKtPa()		);
				korCusmanVO.setIoBndCd	(korManifestTransmitVO.getIoBndCd()	);
				korCusmanVO.setMrnNo	(korManifestTransmitVO.getMrnNo()		);
				korCusmanVO.setD2Cnt	(korManifestTransmitVO.getTtlLcTeuQty());
				korCusmanVO.setD4Cnt	(korManifestTransmitVO.getTtlTsTeuQty());
				korCusmanVO.setDiscMdCd	(korManifestTransmitVO.getDchgMzdCd()	);
				korCusmanVO.setIoQuay	(korManifestTransmitVO.getIoTmlLocCd()	);
				korCusmanVO.setVvd		(korManifestTransmitVO.getVvd()		);
				korCusmanVO.setBlNo		(korManifestTransmitVO.getBlNo()		);
				korCusmanVO.setPortCd	(portCd					);
				korCusmanVO.setInType	(inType					);
				korCusmanVO.setPolCd	(korManifestTransmitVO.getPolCd()		);
				korCusmanVO.setPolTml	(polTml					);
				korCusmanVO.setPodCd	(korManifestTransmitVO.getPodCd()		);
				korCusmanVO.setPodTml	(podTml					);

				korCusmanVOs = dbDao.makeCUSMANBlFlatFile(korCusmanVO);
				if (korCusmanVOs == null) throw new EventException(new ErrorHandler("BKG00889").getMessage());
				String bdAreaCd = korManifestTransmitVO.getBdAreaCd();
				// BODY LOOP ( CUSMAN )
				for (int i=0; i < korCusmanVOs.length; i++) {
					// DETAIL 전송 로그 기록
					bfTemp.setLength(0);
					k=0;
					arTemp = korCusmanVOs[i].getBlData().split("~", 200);

					bfTemp.append(flatFileHeader).append("\n");
					bfTemp.append("MSGTYPE:").append(arTemp[k++]).append("\n");
					bfTemp.append("NEWMOD:").append(arTemp[k++]).append("\n");
					bfTemp.append("MRNNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BKGNBR:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLTYPE:").append(arTemp[k++]).append("\n");
					bfTemp.append("TRANS:").append(arTemp[k++]).append("\n");
					bfTemp.append("CGO_SP:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLPKGU:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLWGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLWGTU:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLMEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLMEAU:").append(arTemp[k++]).append("\n");

					if ("".equals(bdAreaCd)) {
						bdAreaCd = arTemp[k++];
					} else {
						k++;
					}
					bfTemp.append("BOND_AREA_CODE:").append(bdAreaCd).append("\n");
					bfTemp.append("IMDGCODE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMDGCODE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMDGCODE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPOL:").append(arTemp[k++]).append("\n");
					bfTemp.append("WHOUSE:").append(arTemp[k++]).append("\n");
					bfTemp.append("WHOUSE_DESC:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLPOD:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLDEL:").append(arTemp[k++]).append("\n");
					bfTemp.append("DESC1:").append(arTemp[k++].replace(",", "")).append("\n");
					bfTemp.append("DESC2:").append(arTemp[k++].replace(",", "")).append("\n");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if ("3G".equalsIgnoreCase(korManifestTransmitVO.getFfDiv())) {
	bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
	k = k + 2;
	bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR5:").append(arTemp[k++]).append("\n");
	k = k + 3;
	bfTemp.append("STEL:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
	k = k + 2;
	bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE5:").append(arTemp[k++]).append("\n");
	k = k + 3;
	bfTemp.append("CTEL:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
	k = k + 2;
	bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY5:").append(arTemp[k++]).append("\n");
	k = k + 3;
	bfTemp.append("NTEL:").append(arTemp[k++]).append("\n");
} else {
	bfTemp.append("SHPR_NM1:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR_NM2:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR_NM3:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR5:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR_CITY_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("SHPR_CNT_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("STEL:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE_NM1:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE_NM2:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE_NM3:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE5:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE_CITY_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("CNEE_CNT_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("CTEL:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY_NM1:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY_NM2:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY_NM3:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY5:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY_CITY_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTFY_CNT_CD:").append(arTemp[k++]).append("\n");
	bfTemp.append("NTEL:").append(arTemp[k++]).append("\n");
}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
					bfTemp.append("CNTRTYPE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRTYPE5:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRVOL5:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLSTAT:").append(arTemp[k++]).append("\n");
					bfTemp.append("T_REF_NO:").append(arTemp[k++]).append("\n");
					bfTemp.append("RESND_BIT:").append(arTemp[k++]).append("\n");
					bfTemp.append("MODI_CODE:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNTRCNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("CMDT_REP:").append(arTemp[k++]).append("\n");
					bfTemp.append("MEA_TON:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("SBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("DISC_COMP:").append(arTemp[k++]).append("\n");
					bfTemp.append("BLK_TOT_WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("BLK_TOT_MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("IO_QUAY:").append(arTemp[k++]).append("\n");

					// TEU, FEU CNT 조회
					cntrCntVO = new KorCntrCntVO();
					// 중복 제거
					if (i == 0 || !korCusmanVOs[i-1].getBkgNo().equals(korCusmanVOs[i].getBkgNo())) {
						cntrCntVO.setCstmsDeclTpCd	(korCusmanVOs[i].getCstmsDeclTpCd()	);
						cntrCntVO.setBkgNo			(korCusmanVOs[i].getBkgNo()			);
						cntrCntVO.setPortCd			(korCusmanVOs[i].getPortCd()		);
						cntrCntVO = dbDao.searchTeuFeuCnt(cntrCntVO);
						// TEU, FEU CNT 누적
						if (cntrCntVO != null) {
							teuCnt = teuCnt + Integer.parseInt(cntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(cntrCntVO.getFeuCnt());
						}
					}
					// FLATFILE 합치기
					flatFileBody.append(bfTemp);

					// SC_DIV 가 'C'가 아닌것만 ELNO FLATFILE 생성
					if (!korCusmanVOs[i].getScDiv().equals("C")) {
						// Export License FlatFile 생성 ( EXPORT )
						elDatas = dbDao.makeCUSMANExpFlatFile(korCusmanVOs[i]);
						// LOOP
						if (elDatas != null) {

							for (int j=0; j < elDatas.length; j++) {
								flatFileExport.setLength(0);
								k=0;

								arTemp = elDatas[j].split("~",100);

								flatFileExport.append("{KCS_EXNO").append("\n");
								flatFileExport.append("B_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("B_UCRNO:");
								if (!"".equals(korManifestTransmitVO.getPolCd()) && korManifestTransmitVO.getPolCd() != null) {
									flatFileExport.append(arTemp[k++]);
								} else {
									k++;
								}
								flatFileExport.append("\n");
								flatFileExport.append("B_PKGU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("B_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("B_WGTU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("B_WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("PART_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("THIS_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("UNIT_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								flatFileExport.append("UNIT_PKGU:").append(arTemp[k++]).append("\n");
								flatFileExport.append("UNIT_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
								flatFileExport.append("}KCS_EXNO").append("\n");

								flatFileBody.append(flatFileExport);
							}
						} // END LOOP
					}

					// Container FlatFile 생성
					korCusmanVOs[i].setVvd(korManifestTransmitVO.getVvd());
					cntrDatas = dbDao.makeCUSMANCntrFlatFile(korCusmanVOs[i]);
					if (cntrDatas != null) {
						// LOOP
						for (int j=0; j < cntrDatas.length; j++) {
							flatFileCNTR.setLength(0);
							k=0;
							arTemp = cntrDatas[j].split("~",100);

							flatFileCNTR.append("{CNTR_INFO").append("\n");
							flatFileCNTR.append("CNTRNBR:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("LDMT:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("SEALNBR:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("CNTRTYPE:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("PKGU:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("WGTU:").append(arTemp[k++]).append("\n");
							flatFileCNTR.append("MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
							flatFileCNTR.append("MEAU:").append(arTemp[k++]).append("\n");
							// SEAL NUMBER 추가
							korCusmanVOs[i].setCntrNo(arTemp[0]);
							tempSealNumber = dbDao.makeCUSMANSealFlatFile(korCusmanVOs[i]);
							if (tempSealNumber != null) {
								sealNumbers = tempSealNumber.split("~",100);
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[0]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[1]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
							}

							flatFileCNTR.append("}CNTR_INFO").append("\n");
							flatFileBody.append(flatFileCNTR);
						} // END LOOP
					}
				}
			} // end Not E type

			// CUSREP SEND LOG UPDATE (TEU, FEU CNT)
			bkgCstmsKrSndLogVO.setTeuCnt(String.valueOf(teuCnt));
			bkgCstmsKrSndLogVO.setFeuCnt(String.valueOf(feuCnt));
			dbDao.modifyCUSREPSndLog(bkgCstmsKrSndLogVO);

			// FLATFILE 조립
			flatFile.append(flatFileBody);

			// flatFile 전송
			this.ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_MNFT.IBMMQ.QUEUE");

			// Send Data 생성
			sndDt = dbDao.searchSysDate();
			// 전송 로그 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(korManifestTransmitVO.getIoBndCd()	);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			bkgCstmsKrSndLogVO.setOfcCd			(korManifestTransmitVO.getOfcCd()		);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo			);
			bkgCstmsKrSndLogVO.setUserId		(korManifestTransmitVO.getUserId()		);
			bkgCstmsKrSndLogVO.setVvd			(korManifestTransmitVO.getVvd()		);
			bkgCstmsKrSndLogVO.setPolCd			(korManifestTransmitVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(korManifestTransmitVO.getPodCd()		);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if ("E".equals(korManifestTransmitVO.getNoneBlInType())) {
				bkgCstmsKrSndLogVO.setInType		(korManifestTransmitVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setBlKnt			(korManifestTransmitVO.getMstBlKnt()	);
			bkgCstmsKrSndLogVO.setResndChk		(resndChk				);
			bkgCstmsKrSndLogVO.setKtPa			(korManifestTransmitVO.getKtPa()		);
			bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(flatFile.toString()	);
			dbDao.addCUSREPSndLog(bkgCstmsKrSndLogVO);

			return flatFile.toString();

		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Trans Amendment To PA
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transAmendManifest(AmendManifestTransmitVO amendManifestTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		String[] arTemp = null;
		String fltFileRefNo = null;
		int k=0;

		// 파라메터 변환
		KorAmendManifestTransmitVO condVO = (KorAmendManifestTransmitVO)amendManifestTransmitVO;

		// FlatFile Header 용 객체
		KorMacamdVO korMacamdVO = new KorMacamdVO();
		// FlatFile 조회용 객체
		KorCorrVO corrVO = new KorCorrVO();

		// FlatFile 객체
		String flatFileHeader = null;
		String flatFileTemp   = null;
		StringBuffer flatFileBody = new StringBuffer();

		// Send Date
		String sndDt = null;
		// 정정 코드 배열
		String[] corrCodes = new String[5];
		String[] mdatas    = new String[5];
		// UNLocCd
		KorUNLocVO korUNLocVO = null;

		// 로그 저장용 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO = new BkgCstmsKrSndLogVO();
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";
		String subNo = null;

		try {

			// 수신처 판단
			if (condVO.getKtPa() != null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020")) {
					receiver = "BPAED020";
				} else  if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				} else  if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("HJSPORT1", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(62).trim();

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// UNLocCd
			korUNLocVO = dbDao.searchUNLocCd(condVO.getPolCd(), condVO.getPodCd());
			// 조회결과 없을경우 빈칸 처리
			if (korUNLocVO==null) {
				korUNLocVO = new KorUNLocVO();
				korUNLocVO.setPodUn("");
				korUNLocVO.setPolUn("");
			}

			korMacamdVO.setPolCd		(condVO.getPolCd()			);
			korMacamdVO.setPodCd		(condVO.getPodCd()			);
			korMacamdVO.setKtPa			(condVO.getKtPa()			);
			korMacamdVO.setIoBndCd		(condVO.getIoBndCd()		);
			korMacamdVO.setCallYear		(condVO.getCallYear()		);
			korMacamdVO.setCallKnt		(condVO.getCallKnt()		);
			korMacamdVO.setVslCallSgnCd	(condVO.getVslCallSgnCd()	);
			korMacamdVO.setMrnNo		(condVO.getMrnNo()			);
			korMacamdVO.setVvd			(condVO.getVvd()			);
			korMacamdVO.setVslNm		(condVO.getVslNm()			);
			korMacamdVO.setVslCntCd		(condVO.getVslCntCd()		);
			korMacamdVO.setBlNo			(condVO.getBlNo()			);
			korMacamdVO.setDchgMzdCd	(condVO.getDchgMzdCd()		);
			korMacamdVO.setIoTmlLocCd	(condVO.getIoTmlLocCd()		);
			korMacamdVO.setBdAreaCd		(condVO.getBdAreaCd()		);
			korMacamdVO.setTtlPckUtCd	(condVO.getTtlPckUtCd()		);
			korMacamdVO.setTtlWgt		(condVO.getTtlWgt()			);
			korMacamdVO.setTtlMeasUtCd	(condVO.getTtlMeasUtCd()	);
			korMacamdVO.setTtlMeasQty	(condVO.getTtlMeasQty()		);
			korMacamdVO.setUnPodCd		(korUNLocVO.getPodUn()		);
			korMacamdVO.setUnPolCd		(korUNLocVO.getPolUn()		);

			// 헤더 추가정보 생성
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if ("E".equals(condVO.getNoneBlInType())) {
				korMacamdVO.setCallYear("");
				korMacamdVO.setDchgMzdCd("");
			}
			flatFileHeader = dbDao.makeMACAMDFlatFile(korMacamdVO);
			arTemp = flatFileHeader.split("~", 100);
			k=0;

			bfTemp.setLength(0);

			bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
			bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SCAC:").append(arTemp[k++]).append("\n");
			bfTemp.append("CARRIER_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_FLAG:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("IN_SEQ:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
			bfTemp.append("QUAY_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
			bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("MEA_TP:").append("").append("\n");
			k++; // MEA_TP Skip 처리
			bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_CO_CD:").append(condVO.getCstmsDchgCd()).append("\n");
			k++; // 하역회사 화면에서 넘어오는 값으로 대체
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");

			flatFile.append(bfTemp);
			flatFileHeader = flatFile.toString();

			// 정정부호에 따른 처리 (ZD 가 존재하면 나머지 코드는 무시)
			if (condVO.getCancelFlg() != null && condVO.getCancelFlg().equals("ZD")) {
				corrCodes[0] = condVO.getCancelFlg();		// ZD
				mdatas[0]    = "";
			} else {
				corrCodes[1] = condVO.getInChgMeth();		// ZH1
				corrCodes[2] = condVO.getInChgPort();		// ZH2
				corrCodes[3] = condVO.getInChgComp();		// ZH3
				corrCodes[4] = condVO.getInChgEta();		// AI
				mdatas[1]    = condVO.getDchgMzdCd();
				mdatas[2]	 = condVO.getIoTmlLocCd();
				mdatas[3]	 = condVO.getCstmsDchgCd();
				mdatas[4]    = condVO.getEtaDt().replaceAll("-","");
			}

			// LOOP
			for (int i=0; i < corrCodes.length; i++) {

				if (corrCodes[i]==null || corrCodes[i].trim().equals("")) continue;

				// makeCorrFlatFile
				corrVO.setCorrCd(corrCodes[i]);
				corrVO.setMdata1(mdatas[i]	 );
				flatFileTemp = dbDao.makeCorrFlatFile(corrVO);

				arTemp = flatFileTemp.split("~",100);
				k=0;
				bfTemp.setLength(0);

				bfTemp.append("{MODI_INFO").append("\n");
				bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_VVD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_FTX1:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX2:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX3:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("MODI_FTX4:").append(arTemp[k++].replace(",", "")).append("\n");
				bfTemp.append("}MODI_INFO").append("\n");

				flatFileBody.append(bfTemp);
			}

			// FLATFILE 조립
			flatFile.append(flatFileBody);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");


			// InBound 이고 ETA 항목 변경시 EDI 전송
			if (condVO.getIoBndCd().equals("I") && condVO.getInChgEta().equals("AI")) {

				flatFile.setLength(0);
				//if ("".equals(korUNLocVO.getPodUn())|| korUNLocVO.getPodUn()== null) {
				//	log.debug("발송 xml" + "KCS0004XML");
				//	flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");
				//} else {
				//	log.debug("발송 xml" + "KCS0004");
					flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");

				//}
				fltFileRefNo = flatFileHeader.substring(62).trim();

				String userName = dbDao.searchComUser(condVO.getUserId());

				// SysDate 조회
				sndDt = dbDao.searchSysDate();

				// SubNo 생성
				KorMakeSubNoVO korMakeSubNoVO = new KorMakeSubNoVO();
				korMakeSubNoVO.setVvd		(condVO.getVvd()	);
				korMakeSubNoVO.setIoBndCd	(condVO.getIoBndCd());
				korMakeSubNoVO.setPolLoc	(condVO.getPolCd()	);
				korMakeSubNoVO.setPodLoc	(condVO.getPodCd()	);
				subNo = dbDao.searchMakeSubNo(korMakeSubNoVO);

				KorImfmodVO korImfmodVO = new KorImfmodVO();
				ObjectCloner.build		(condVO, korImfmodVO	);
				korImfmodVO.setOfcCd		(condVO.getLoclCstmsCd());
				korImfmodVO.setUserName		(userName		  		);
				korImfmodVO.setPodCd		(korUNLocVO.getPodUn()	);
				korImfmodVO.setPolCd		(korUNLocVO.getPolUn()	);
				korImfmodVO.setKrCstmsCorrId("A"					);
				korImfmodVO.setCorrRsn		("사무착오"				);
				korImfmodVO.setSubNo		(subNo					);
				korImfmodVO.setCntrTtlWgt	(condVO.getTtlWgt().replaceAll(",", ""));
				korImfmodVO.setMeasQty		(condVO.getTtlMeasQty().replaceAll(",", ""));

				/*
				 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
				 */
				if ( checkRevenueEmpty(korImfmodVO.getBkgCgoTpCd(), korImfmodVO.getKrCstmsBlTpCd()) ) {
					korImfmodVO.setKrCstmsBlTpCd("E");
				}

				flatFileTemp = dbDao.makeIMFMODBlFlatFile(korImfmodVO);
				arTemp = flatFileTemp.split("~",100);
				k=0;
				bfTemp.setLength(0);

				bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
				bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("DEPT_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("SENDER:").append(arTemp[k++]).append("\n");
				bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CORR_RS:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("FW_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
				bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
				bfTemp.append("DISC_LOC:").append(arTemp[k++]).append("\n");
				bfTemp.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
				bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("HBL_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
				bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
				bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
				bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");

				// FlatFile 합치기
				flatFile.append(flatFileHeader).append("\n");
				flatFile.append(bfTemp);

				// CORRECTION FLATFILE 만들기
				korImfmodVO.setKrCstmsCorrId("AI");
				korImfmodVO.setCorrRsn("01");
				korImfmodVO.setPreCtnt1(condVO.getOldEtaDt());
				korImfmodVO.setCrntCtnt1(condVO.getEtaDt());

				String imfmodBLCorrFlatFile = dbDao.makeIMFMODCorrFlatFile(korImfmodVO);
				arTemp = imfmodBLCorrFlatFile.split("~", 100);

				k=0;
				bfTemp.setLength(0);

				bfTemp.append("{UNIT_MODI").append("\n");
				bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_CORR_RSCD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MODI_PRE_TXT1:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT2:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT3:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_PRE_TXT4:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT1:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT2:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT3:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("MODI_TXT4:").append(arTemp[k++].replace("-", "")).append("\n");
				bfTemp.append("}UNIT_MODI").append("\n");

				imfmodBLCorrFlatFile = bfTemp.toString();
				flatFile.append(imfmodBLCorrFlatFile);

				// flatFile 전송
				ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

				// 전송 로그 기록
				bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
				bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()	);
				bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
				bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()	);
				bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()	);
				bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()	);
				bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
				bkgCstmsKrSndLogVO.setSubNo			(subNo				);
				bkgCstmsKrSndLogVO.setCorrCd		("A"				);
				bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(flatFile.toString());
				dbDao.addIMFMODSndLog(bkgCstmsKrSndLogVO);
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * Amendment Transmit 전송 (FlatFile Return)
	 * @param AmdManifestTransmitVO amdManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transAmdManifest(AmdManifestTransmitVO amdManifestTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		// 임시 flatFile ( DB 저장을 위해 임시로 받아두는 버퍼 )
		StringBuffer bfTemp = new StringBuffer();
		String[] arTemp = null;
		int k = 0;
		String portCd   = null;
		// 파라메터 변환
		KorAmdManifestTransmitVO condVO = (KorAmdManifestTransmitVO)amdManifestTransmitVO;
		// 화면에서 넘어오는 값을 담는 객체
		KorBlAmdVO korBlAmdVO = condVO.getKorBlAmdVO();
		KorCntrCorrVO[] korCntrCorrVOs = condVO.getKorCntrCorrVOs();
		KorCustCorrVO   korCustCorrVO  = condVO.getKorCustCorrVO();
		KorExpCorrVO[]  korExpCorrVOs  = condVO.getKorExpCorrVOs();
		KorCorrListVO[] korCorrListVOs = condVO.getKorCorrListVOs();
		// 전송여부 체크
		String transChk = "N";
		String transSndChk = null;
		// UNLocCd
		KorUNLocVO korUNLocVO = null;
		// 사용자 이름
		String userName = null;
		// CUSMOD FLATFILE 생성용 객체
		KorCusmodVO korCusmodVO = new KorCusmodVO();
		String cusmodFlatFile = null;
		String[] cusmodFlatFileSplit = null;
		// CUSMOD 전송 로그 기록용 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO = new BkgCstmsKrSndLogVO();
		// CUSMOD Export Flat 파일
		String cusmodExpFlatFile = null;
		// CUSMOD Container Flat 파일
		String cusmodCntrFlatFile = null;
		// CUSMOD BL Corr Flat 파일
		String cusmodBlCorrFlatFile = null;
		// Correction Table Update 용 객체
		BkgCstmsKrCorrVO bkgCstmsKrCorrVO  = new BkgCstmsKrCorrVO();
		// CUSDMR Corr 생성용 객체
		KorCusdmrVO korCusdmrVO = new KorCusdmrVO();

		// IMFMODBL FlatFile 생성용 객체
		KorImfmodVO korImfmodVO = new KorImfmodVO();
		String imfModBlFlatFile = null;
		// IMFMOD Container Flat 파일
		String imfmodCntrFlatFile = null;
		// IMFMOD BL Corr Flat 파일
		String imfmodBLCorrFlatFile = null;
		// MACAMD FlatFile 생성용 객체
		KorMacamdVO korMacamdVO = new KorMacamdVO();
		String macamdFlatFile = null;
		// MACAMD CNTR FlatFile
		String macamdCntrFlatFile = null;
		// MACAMD CORR FlatFile
		String macamdCorrFlatFile = null;

		// Header 생성용
		BookingUtil bookingUtil = new BookingUtil();
		String flatFileHeader = null;
		String flatFileRefNo = null;

		// SendDate
		String sndDt = null;

		try {
			// 변수 명이 상이한 부분들 매핑 처리
			// SubNo 처리
			korBlAmdVO.setSubNo(korBlAmdVO.getSmtAmdNo());
			// Call Year 처리
			korBlAmdVO.setCallYear(korBlAmdVO.getEtaDt());

			// Validation Check
			if (korBlAmdVO.getTransChk() != null && korBlAmdVO.getTransChk().equals("Y")) {
				throw new EventException(new ErrorHandler("BKG01114", new String[] {korBlAmdVO.getSubNo()}).getMessage());
			}
			if (korBlAmdVO.getSubNo()==null || korBlAmdVO.getSubNo().trim().length() < 1) {
				throw new EventException(new ErrorHandler("BKG01115").getMessage());
			}

			// Transmit Check
			transChk = dbDao.searchTransmitChk(korBlAmdVO.getSubNo());
			if (transChk != null && transChk.equals("Y")) {
				throw new EventException(new ErrorHandler("BKG01116", new String[] {korBlAmdVO.getSubNo()}).getMessage());
			}

			// UNLocCd
			korUNLocVO = dbDao.searchUNLocCd(korBlAmdVO.getPolCd(), korBlAmdVO.getPodCd());
			// 조회결과 없을경우 빈칸 처리
			if (korUNLocVO==null) {
				korUNLocVO = new KorUNLocVO();
				korUNLocVO.setPodUn("");
				korUNLocVO.setPolUn("");
			}

			// 사용자 조회
			userName = dbDao.searchComUser(condVO.getUserId());

			// PORT_CD
			if (korBlAmdVO.getIoBndCd().equals("O")) {
				portCd = korBlAmdVO.getPolCd();
			} else {
				portCd = korBlAmdVO.getPodCd();
			}

			// 전송일시
			sndDt = dbDao.searchSysDate();

			// OUT BOUND 의 경우
			if (korBlAmdVO.getIoBndCd().equals("O")) {

				// RECEIVER 가 C 이거나 A 면 CUSMOD 생성
				if (korBlAmdVO.getAmdtRcvrFlg().equals("C") || korBlAmdVO.getAmdtRcvrFlg().equals("A")) {

					// 파라메터 셋팅
					ObjectCloner.build(korBlAmdVO, 		korCusmodVO);
					ObjectCloner.build(korCustCorrVO, 	korCusmodVO);
					korCusmodVO.setCstmsOfcCtyCd(korBlAmdVO.getCstmsOfcCtyCd()	);
					korCusmodVO.setPodCd		(korUNLocVO.getPodUn()			);
					korCusmodVO.setCntrCnt		("0"							);
					if (korCntrCorrVOs != null) korCusmodVO.setCntrCnt(String.valueOf(korCntrCorrVOs.length));

					// flatFile Header 생성
					flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0003XML", "CUSMOD");
					// REF_NO 추출
					flatFileRefNo = flatFileHeader.trim().substring(62).trim();

					// flatFile 에 추가
					flatFile.append(flatFileHeader).append("\n");

					/*
					 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
					 */
					if ( checkRevenueEmpty(korBlAmdVO.getBkgCgoTpCd(), korCusmodVO.getKrCstmsBlTpCd()) ) {
						korCusmodVO.setKrCstmsBlTpCd("E");
					}

					// BL flatFile 생성
					cusmodFlatFile = dbDao.makeCUSMODBlFlatFile(korCusmodVO);

					// BL FlatFile 분해 및 FlatFile 에 추가
					cusmodFlatFileSplit = cusmodFlatFile.split("~", 100);
					k = 0;
					flatFile.append("PLI:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("RPLI:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SUB_NO:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("{BL_CNTR").append("\n");
					flatFile.append("COR_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLNBR:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLTYPE:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("TRANS:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLPOD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLDEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLPKG:").append(cusmodFlatFileSplit[k++].replaceAll(",","")).append("\n");
					flatFile.append("BLPKGU:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("COR_REA:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("DESC1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLWGT:").append(cusmodFlatFileSplit[k++].replaceAll(",", "")).append("\n");
					flatFile.append("BLWGTU:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BLMEA:").append(cusmodFlatFileSplit[k++].replaceAll(",","")).append("\n");
					flatFile.append("HBL_CNT:").append(cusmodFlatFileSplit[k++].replaceAll(",","")).append("\n");
					flatFile.append("CNTR_CNT:").append(cusmodFlatFileSplit[k++].replaceAll(",","")).append("\n");
					flatFile.append("SHPR1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("STEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CTEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("FFORD_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BOND_AREA_CODE:").append(cusmodFlatFileSplit[k++]).append("\n");
//					2011. 11. 30 임시로 주석처리 => 	[CHM-201114372-01] 한국 적하목록 LIVE 태깅시 주석 풀기
//					flatFile.append("UCTNO:").append(cusmodFlatFileSplit[k++]).append("\n");
					if (!"".equals(korBlAmdVO.getPolCd()) && korBlAmdVO.getPolCd() != null) {
					flatFile.append("UCRNO:").append(cusmodFlatFileSplit[k++]).append("\n");
					}
					cusmodFlatFile = flatFile.toString();

					// Export TAB 처리
					if (korExpCorrVOs != null) {
						// LOOP
						for (int i=0; i < korExpCorrVOs.length; i++) {
							// 정정이 있는 경우만 처리
							if (korExpCorrVOs[i].getKrCstmsCorrId()==null || korExpCorrVOs[i].getKrCstmsCorrId().trim().length() < 1) continue;
							// FlatFile 생성
							ObjectCloner.build(korExpCorrVOs[i], korCusmodVO);
							cusmodExpFlatFile = dbDao.makeCUSMODExpFlatFile(korCusmodVO);
							arTemp = cusmodExpFlatFile.split("~",100);

							bfTemp.setLength(0);
							k = 0;
							bfTemp.append("{KCS_EXNO").append("\n");
							bfTemp.append("EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
							bfTemp.append("PRE_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
							bfTemp.append("E_COR_CD:").append(arTemp[k++]).append("\n");
							bfTemp.append("E_COR_REA:").append(arTemp[k++]).append("\n");
							bfTemp.append("PKGU:").append(arTemp[k++]).append("\n");
							bfTemp.append("PKG:").append(arTemp[k++].replaceAll(",", "")).append("\n");
							bfTemp.append("WGTU:").append(arTemp[k++]).append("\n");
							bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
							bfTemp.append("RECDT:").append(arTemp[k++]).append("\n");
							bfTemp.append("PART_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
							bfTemp.append("THIS_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
							bfTemp.append("UNIT_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
							bfTemp.append("UNIT_PKGU:").append(arTemp[k++]).append("\n");
							bfTemp.append("UNIT_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
							bfTemp.append("}KCS_EXNO").append("\n");
							cusmodExpFlatFile = bfTemp.toString();

							// flatFile 합치기
							flatFile.append(cusmodExpFlatFile);
						}
					}

					// Container Tab 처리
					if (korCntrCorrVOs != null) {
						for (int i=0; i < korCntrCorrVOs.length; i++) {
							// 정정사항이 있는 경우에만 처리(BT제외)
							if (korCntrCorrVOs[i].getKrCstmsCorrId()==null || korCntrCorrVOs[i].getKrCstmsCorrId().trim().length() < 1
								|| korCntrCorrVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT")) continue;
							// FlatFile 생성
							ObjectCloner.build(korCntrCorrVOs[i], korCusmodVO);
							cusmodCntrFlatFile = dbDao.makeCUSMODCntrFlatFile(korCusmodVO);
							arTemp = cusmodCntrFlatFile.split("~", 100);

							bfTemp.setLength(0);
							k = 0;
							bfTemp.append("{CNTR_INFO").append("\n");
							bfTemp.append("CNTRNBR:").append(arTemp[k++]).append("\n");
							bfTemp.append("PRE_CNTRNBR:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTRTYPE:").append(arTemp[k++]).append("\n");
							bfTemp.append("C_COR_CD:").append(arTemp[k++]).append("\n");
							bfTemp.append("C_COR_REA:").append(arTemp[k++]).append("\n");
							bfTemp.append("SEALNBR:").append(arTemp[k++]).append("\n");
							// SEAL Number 추가
							if (korCusmodVO.getCntrSealNo1() != null && korCusmodVO.getCntrSealNo1().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korCusmodVO.getCntrSealNo1()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							if (korCusmodVO.getCntrSealNo2() != null && korCusmodVO.getCntrSealNo2().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korCusmodVO.getCntrSealNo2()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							bfTemp.append("}CNTR_INFO").append("\n");
							cusmodCntrFlatFile = bfTemp.toString();

							// flatFile 합치기
							flatFile.append(cusmodCntrFlatFile);
						}
					}
					flatFile.append("}BL_CNTR").append("\n");


					// CORRECTION CODE 가 D나 F가 아닌 경우 처리
					if (!korBlAmdVO.getKrCstmsCorrId().equals("D") && !korBlAmdVO.getKrCstmsCorrId().equals("F")) {

						// VVD-B/L Corr TAB 처리
						if (korCorrListVOs != null) {

							for (int i=0; i < korCorrListVOs.length; i++) {
								// 정정사항이 있는 경우만 처리(BT제외)
								if (korCorrListVOs[i].getKrCstmsCorrId()==null || korCorrListVOs[i].getKrCstmsCorrId().trim().length() < 1
									|| korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT")) continue;

								// FlatFile 생성
								ObjectCloner.build(korCorrListVOs[i], korCusmodVO);
								cusmodBlCorrFlatFile = dbDao.makeCUSMODBlCorrFlatFile(korCusmodVO);
								arTemp = cusmodBlCorrFlatFile.split("~", 100);

								bfTemp.setLength(0);
								k = 0;
								bfTemp.append("{UNIT_MODI").append("\n");
								bfTemp.append("U_COR_CD:").append(arTemp[k++]).append("\n");
								bfTemp.append("COR_DESC1:").append(arTemp[k++].replace(",", "")).append("\n");
								bfTemp.append("COR_DESC2:").append(arTemp[k++].replace(",", "")).append("\n");
								bfTemp.append("COR_DESC3:").append(arTemp[k++].replace(",", "")).append("\n");
								bfTemp.append("COR_DESC4:").append(arTemp[k++].replace(",", "")).append("\n");
								bfTemp.append("U_COR_REA:").append(arTemp[k++]).append("\n");
								bfTemp.append("}UNIT_MODI").append("\n");
								cusmodBlCorrFlatFile = bfTemp.toString();

								// flatFile 합치기
								flatFile.append(cusmodBlCorrFlatFile);
							}
						}

						// Correction table Update (SUB_NO)
						bkgCstmsKrCorrVO.setSmtAmdNo(korBlAmdVO.getSubNo()	);
						bkgCstmsKrCorrVO.setUserId	(condVO.getUserId()		);

					}

					// 전송여부 체크
					transSndChk = dbDao.searchTransndChk(korBlAmdVO.getBkgNo(), portCd, korBlAmdVO.getCstmsDeclTpCd());
				}

				// CUSMOD 전송
				ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

				// 전송 로그 기록
				bkgCstmsKrSndLogVO.setSndDt			(sndDt							);
				bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()				);
				bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo					);
				bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()				);
				bkgCstmsKrSndLogVO.setVvd			(korBlAmdVO.getVvd()			);
				bkgCstmsKrSndLogVO.setPolCd			(korBlAmdVO.getPolCd()			);
				bkgCstmsKrSndLogVO.setBlNo			(korBlAmdVO.getBlNo()			);
				bkgCstmsKrSndLogVO.setSubNo			(korBlAmdVO.getSubNo()			);
				bkgCstmsKrSndLogVO.setCorrCd		(korBlAmdVO.getKrCstmsCorrId()	);
				bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(cusmodFlatFile					);
				dbDao.addCUSMODSndLog(bkgCstmsKrSndLogVO);

			} else {
				// IN BOUND의 경우

				// RECEIVER 가 C 이거나 A 면 IMFMOD 생성
				if (korBlAmdVO.getTransDmr().equals("N") && ( korBlAmdVO.getAmdtRcvrFlg().equals("C") || korBlAmdVO.getAmdtRcvrFlg().equals("A") ) ) {

					// flatFile Header 생성
					//if ("".equals(korUNLocVO.getPodUn()) || korUNLocVO.getPodUn() == null) {
					//	log.debug("발송 xml" + "KCS0004XML");
					//    flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");
					//} else {
					//	log.debug("발송 xml" + "KCS0004");
						flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");
					//}
					// REF_NO 추출
					flatFileRefNo = flatFileHeader.trim().substring(62).trim();

					// IMFMODBL FlatFile 생성
					ObjectCloner.build(korBlAmdVO, 		korImfmodVO			);
					ObjectCloner.build(korCustCorrVO, 	korImfmodVO			);
					korImfmodVO.setOfcCd	(korBlAmdVO.getCstmsOfcCtyCd()	);
					korImfmodVO.setDeptCd	(korBlAmdVO.getKrCstmsDeptCd()	);
					korImfmodVO.setUserName	(userName		  				);
					korImfmodVO.setPodCd	(korUNLocVO.getPodUn()			);
					korImfmodVO.setPolCd	(korUNLocVO.getPolUn()			);

					/*
					 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
					 */
					if ( checkRevenueEmpty(korImfmodVO.getBkgCgoTpCd(), korImfmodVO.getKrCstmsBlTpCd()) ) {
						korImfmodVO.setKrCstmsBlTpCd("E");
					}

					imfModBlFlatFile = dbDao.makeIMFMODBlFlatFile(korImfmodVO);
					arTemp = imfModBlFlatFile.split("~", 100);

					bfTemp.setLength(0);
					k=0;
					bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
					bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
					bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("DEPT_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("SENDER:").append(arTemp[k++]).append("\n");
					bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("CORR_RS:").append(arTemp[k++]).append("\n");
					bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
					bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
					bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
					bfTemp.append("FW_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
					bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
					bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
					bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
					bfTemp.append("DISC_LOC:").append(arTemp[k++]).append("\n");
					bfTemp.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
					bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
					bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
					bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("HBL_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
					bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
					bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
					bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
					bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
					bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");
					imfModBlFlatFile = flatFileHeader +"\n"+ bfTemp.toString();

					// FlatFile 합치기
					flatFile.append(imfModBlFlatFile);

					// Container Tab 처리
					if (korCntrCorrVOs != null) {
						for (int i=0; i < korCntrCorrVOs.length; i++) {
							// 정정사항이 있는 경우에만 처리
							if (korCntrCorrVOs[i].getKrCstmsCorrId()==null || korCntrCorrVOs[i].getKrCstmsCorrId().trim().length() < 1 ) continue;
							// FlatFile 생성
							ObjectCloner.build(korCntrCorrVOs[i], korImfmodVO);
							imfmodCntrFlatFile = dbDao.makeIMFMODCntrFlatFile(korImfmodVO);
							arTemp = imfmodCntrFlatFile.split("~", 100);

							k=0;
							bfTemp.setLength(0);
							bfTemp.append("{CNTR_INFO").append("\n");
							bfTemp.append("CNTR_NO:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_TPSZ:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_CORR_CD:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_CORR_TP:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_CORR_O:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_CORR_N:").append(arTemp[k++]).append("\n");
							bfTemp.append("CNTR_PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
							bfTemp.append("CNTR_PKG_CD:").append(arTemp[k++]).append("\n");
							bfTemp.append("SEAL_NO:").append(arTemp[k++]).append("\n");
							// SEAL Number 추가
							if (korImfmodVO.getCntrSealNo1() != null && korImfmodVO.getCntrSealNo1().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korImfmodVO.getCntrSealNo1()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							if (korImfmodVO.getCntrSealNo2() != null && korImfmodVO.getCntrSealNo2().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korImfmodVO.getCntrSealNo2()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							bfTemp.append("}CNTR_INFO").append("\n");
							imfmodCntrFlatFile = bfTemp.toString();

							// flatFile 합치기
							flatFile.append(imfmodCntrFlatFile);
						}
					}

					// VVD-B/L Corr TAB 처리
					if (korCorrListVOs != null) {

						for (int i=0; i < korCorrListVOs.length; i++) {
							// 정정사항이 있는 경우만 처리(BT제외)
							if (korCorrListVOs[i].getKrCstmsCorrId()==null || korCorrListVOs[i].getKrCstmsCorrId().trim().length() < 1
								|| korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT")) continue;

							// FlatFile 생성
							ObjectCloner.build(korCorrListVOs[i], korImfmodVO);
							imfmodBLCorrFlatFile = dbDao.makeIMFMODCorrFlatFile(korImfmodVO);
							arTemp = imfmodBLCorrFlatFile.split("~", 100);

							k=0;
							bfTemp.setLength(0);
							bfTemp.append("{UNIT_MODI").append("\n");
							bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
							bfTemp.append("MODI_CORR_RSCD:").append(arTemp[k++]).append("\n");
							bfTemp.append("MODI_PRE_TXT1:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_PRE_TXT2:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_PRE_TXT3:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_PRE_TXT4:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_TXT1:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_TXT2:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_TXT3:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("MODI_TXT4:").append(arTemp[k++].replace(",", "")).append("\n");
							bfTemp.append("}UNIT_MODI").append("\n");
							imfmodBLCorrFlatFile = bfTemp.toString();

							// flatFile 합치기
							flatFile.append(imfmodBLCorrFlatFile);
						}
					}

					// Correction table Update (SUB_NO)
					bkgCstmsKrCorrVO.setSmtAmdNo(korBlAmdVO.getSubNo()	);
					bkgCstmsKrCorrVO.setUserId	(condVO.getUserId()		);

					// 전송여부 체크
					transSndChk = dbDao.searchTransndChk(korBlAmdVO.getBkgNo(), portCd, korBlAmdVO.getCstmsDeclTpCd());

					// IMFMOD 전송
					ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

					// 전송 로그 기록
					bkgCstmsKrSndLogVO.setSndDt			(sndDt							);
					bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()				);
					bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo					);
					bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()				);
					bkgCstmsKrSndLogVO.setVvd			(korBlAmdVO.getVvd()			);
					bkgCstmsKrSndLogVO.setPolCd			(korBlAmdVO.getPolCd()			);
					bkgCstmsKrSndLogVO.setBlNo			(korBlAmdVO.getBlNo()			);
					bkgCstmsKrSndLogVO.setSubNo			(korBlAmdVO.getSubNo()			);
					bkgCstmsKrSndLogVO.setCorrCd		(korBlAmdVO.getKrCstmsCorrId()	);
					bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(imfModBlFlatFile				);
					dbDao.addIMFMODSndLog(bkgCstmsKrSndLogVO);
				}
			}

			// RECEIVER 가 P 이거나 A 이면 MACAMD 생성
			if (korBlAmdVO.getTransDmr().equals("N") && ( korBlAmdVO.getAmdtRcvrFlg().equals("P") || korBlAmdVO.getAmdtRcvrFlg().equals("A")) ) {

				// flatFile 초기화
				flatFile.setLength(0);
				// 수신처
				String receiver = null;
				if (korBlAmdVO.getKrPortAuthCd().equals("020") || korBlAmdVO.getKrPortAuthCd().equals("20")) {
					receiver = "BPAED020";
				} else  if (korBlAmdVO.getKrPortAuthCd().equals("030") || korBlAmdVO.getKrPortAuthCd().equals("031") || korBlAmdVO.getKrPortAuthCd().equals("016")
						|| korBlAmdVO.getKrPortAuthCd().equals("30") || korBlAmdVO.getKrPortAuthCd().equals("31") || korBlAmdVO.getKrPortAuthCd().equals("16")) {
					receiver = "KMPAE030";
				} else  if (korBlAmdVO.getKrPortAuthCd().equals("622")) {
					receiver = "KMPAE050";
				}
				// flatFile Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeader("HJSPORT1", receiver, "MACAMD");
				// REF_NO 추출
				flatFileRefNo = flatFileHeader.trim().substring(62).trim();

				ObjectCloner.build(korBlAmdVO, 		korMacamdVO);
				ObjectCloner.build(korCustCorrVO, 	korMacamdVO);
				korMacamdVO.setKtPa	(korBlAmdVO.getKrPortAuthCd()	);
				korMacamdVO.setPolCd(korUNLocVO.getPolUn()			);
				korMacamdVO.setPodCd(korUNLocVO.getPodUn()			);
				// WGT, MEAS 소수점 절사
//				if (korMacamdVO.getCntrTtlWgt().indexOf(".") > 0) korMacamdVO.setCntrTtlWgt(korMacamdVO.getCntrTtlWgt().substring(0, korMacamdVO.getCntrTtlWgt().indexOf(".")));
				if (korMacamdVO.getMeasQty().indexOf(".") > 0) korMacamdVO.setMeasQty(korMacamdVO.getMeasQty().substring(0, korMacamdVO.getMeasQty().indexOf(".")));

				/*
				 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
				 */
				if ( checkRevenueEmpty(korMacamdVO.getBkgCgoTpCd(), korMacamdVO.getKrCstmsBlTpCd()) ) {
					korMacamdVO.setKrCstmsBlTpCd("E");
				}
				if ( "P".equals(korBlAmdVO.getAmdtRcvrFlg()) && "D".equals(korBlAmdVO.getKrCstmsCorrId()) ) {
					if ("T".equals(korBlAmdVO.getCstmsDeclTpCd()) || "R".equals(korBlAmdVO.getCstmsDeclTpCd())) {
						korMacamdVO.setPolLoc(korBlAmdVO.getPolLoc());
						korMacamdVO.setPodLoc(korBlAmdVO.getPodLoc());
					}
				}
				macamdFlatFile = dbDao.makeMACAMDAmdFlatFile(korMacamdVO);
				arTemp = macamdFlatFile.split("~", 100);

				k=0;
				bfTemp.setLength(0);
				bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
				bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("SCAC:").append(arTemp[k++]).append("\n");
				bfTemp.append("CARRIER_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
				bfTemp.append("VSL_NAME:").append(arTemp[k++]).append("\n");
				bfTemp.append("VSL_FLAG:").append(arTemp[k++]).append("\n");
				bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
				bfTemp.append("IN_SEQ:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
				bfTemp.append("CORR_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
				bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
				bfTemp.append("QUAY_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
				bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
				bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
				bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
				bfTemp.append("MEA_TP:").append(arTemp[k++]).append("\n");
				bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
				bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
				bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
				bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
				bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
				bfTemp.append("DISC_CO_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");
				macamdFlatFile = flatFileHeader +"\n"+ bfTemp.toString();

				// FlatFile 합치기
				flatFile.append(macamdFlatFile);

				// Container Tab 처리
				if (korCntrCorrVOs != null) {
					for (int i=0; i < korCntrCorrVOs.length; i++) {
						// 정정사항이 있는 경우에만 처리
						if (korCntrCorrVOs[i].getKrCstmsCorrId() == null || korCntrCorrVOs[i].getKrCstmsCorrId().trim().length() < 1) continue;
						// FlatFile 생성
						ObjectCloner.build(korCntrCorrVOs[i], korMacamdVO);
						macamdCntrFlatFile = dbDao.makeMACAMDAmdCntrFlatFile(korMacamdVO);
						arTemp = macamdCntrFlatFile.split("~", 100);

						k=0;
						bfTemp.setLength(0);

						bfTemp.append("{CNTR_INFO").append("\n");
						bfTemp.append("CNTR_NO:").append(arTemp[k++]).append("\n");
						bfTemp.append("CNTR_TPSZ:").append(arTemp[k++]).append("\n");
						bfTemp.append("CNTR_CORR_CD:").append(arTemp[k++]).append("\n");
						bfTemp.append("BULK_WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("BULK_MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("SEAL_NO:").append(arTemp[k++]).append("\n");
						bfTemp.append("PRE_CNTR_NO:").append(arTemp[k++]).append("\n");
						// Seal Number 추가
						if (korMacamdVO.getCntrSealNo1() != null && korMacamdVO.getCntrSealNo1().length() > 0) {
							bfTemp.append("{CNTR_SEAL_NO").append("\n");
							bfTemp.append("CNTR_SEAL:").append(korMacamdVO.getCntrSealNo1()).append("\n");
							bfTemp.append("}CNTR_SEAL_NO").append("\n");
						}
						if (korMacamdVO.getCntrSealNo2() != null && korMacamdVO.getCntrSealNo2().length() > 0) {
							bfTemp.append("{CNTR_SEAL_NO").append("\n");
							bfTemp.append("CNTR_SEAL:").append(korMacamdVO.getCntrSealNo2()).append("\n");
							bfTemp.append("}CNTR_SEAL_NO").append("\n");
						}
						bfTemp.append("}CNTR_INFO").append("\n");
						macamdCntrFlatFile = bfTemp.toString();

						// flatFile 합치기
						flatFile.append(macamdCntrFlatFile);
					}
				}

				// VVD-B/L Corr TAB 처리
				if (korCorrListVOs != null) {

					for (int i=0; i < korCorrListVOs.length; i++) {
						// 정정사항이 있는 경우만 처리(BT제외)
						if (korCorrListVOs[i].getKrCstmsCorrId()==null || korCorrListVOs[i].getKrCstmsCorrId().trim().length() < 1
							|| korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT")) continue;

						// FlatFile 생성
						ObjectCloner.build(korCorrListVOs[i], korMacamdVO);
						macamdCorrFlatFile = dbDao.makeMACAMDAmdCorrFlatFile(korMacamdVO);
						arTemp = macamdCorrFlatFile.split("~", 100);

						k=0;
						bfTemp.setLength(0);

						bfTemp.append("{MODI_INFO").append("\n");
						bfTemp.append("MODI_CORR_CD:").append(arTemp[k++]).append("\n");
						bfTemp.append("MODI_VVD:").append(arTemp[k++]).append("\n");
						bfTemp.append("MODI_FTX1:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("MODI_FTX2:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("MODI_FTX3:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("MODI_FTX4:").append(arTemp[k++].replaceAll(",", "")).append("\n");
						bfTemp.append("}MODI_INFO").append("\n");
						macamdCorrFlatFile = bfTemp.toString();

						// flatFile 합치기
						flatFile.append(macamdCorrFlatFile);
					}
				}

				// Correction table Update (SUB_NO)
				bkgCstmsKrCorrVO.setSmtAmdNo(korBlAmdVO.getSubNo()	);
				bkgCstmsKrCorrVO.setUserId	(condVO.getUserId()		);

				// 전송여부 체크
				transSndChk = dbDao.searchTransndChk(korBlAmdVO.getBkgNo(), portCd, korBlAmdVO.getCstmsDeclTpCd());

				// MACAMD 전송
				ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

				// 전송 로그 기록
				bkgCstmsKrSndLogVO.setIoBndCd		(korBlAmdVO.getIoBndCd()		);
				bkgCstmsKrSndLogVO.setSndDt			(sndDt							);
				bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()				);
				bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo					);
				bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()				);
				bkgCstmsKrSndLogVO.setVvd			(korBlAmdVO.getVvd()			);
				bkgCstmsKrSndLogVO.setPolCd			(korBlAmdVO.getPolCd()			);
				bkgCstmsKrSndLogVO.setBlNo			(korBlAmdVO.getBlNo()			);
				bkgCstmsKrSndLogVO.setCorrCd		(korBlAmdVO.getKrCstmsCorrId()	);
				bkgCstmsKrSndLogVO.setKtPa			(korBlAmdVO.getKrPortAuthCd()	);
				bkgCstmsKrSndLogVO.setSubNo			(korBlAmdVO.getSubNo()			);
				bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(macamdFlatFile					);
				dbDao.addMACAMDSndLog(bkgCstmsKrSndLogVO);
			}

			// Receiver 가 ALL 이고 Inbound 인 경우 BondAreaCode Check
			if (korBlAmdVO.getTransDmr().equals("Y") && korBlAmdVO.getAmdtRcvrFlg().equals("A") && korBlAmdVO.getIoBndCd().equals("I")) {

				// 정정 내역 LOOP
				if (korCorrListVOs != null) {

					for (int i=0; i < korCorrListVOs.length; i++) {
						// 정정사항이 있고 BT 인 경우만 처리
						if (korCorrListVOs[i].getKrCstmsCorrId()==null || !korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT") ) continue;

						// Submit No
						String newSubmitNo = korBlAmdVO.getSmtAmdNo().substring(0, 15) + korBlAmdVO.getMsnNo();

						// 파라메터 값 셋팅
						korCusdmrVO.setCorrRsn		(korBlAmdVO.getCorrRsn()			);
						korCusdmrVO.setCstmsOfcCtyCd(korBlAmdVO.getCstmsOfcCtyCd()		);
						korCusdmrVO.setKrCstmsDeptCd(korBlAmdVO.getKrCstmsDeptCd()		);
						korCusdmrVO.setTrnsSeq		(korBlAmdVO.getTrnsSeq()			);
						korCusdmrVO.setOldDisc		(korCorrListVOs[i].getPreCtnt1()	);
						korCusdmrVO.setNewDisc		(korCorrListVOs[i].getCrntCtnt1()	);
						korCusdmrVO.setUsrName		(userName							);
						korCusdmrVO.setSmtAmdNo		(newSubmitNo						);

						arTemp = dbDao.makeCUSDMRFlatFile(korCusdmrVO).split("~",100);
						flatFile.setLength(0);

						// flatFile Header 생성
						//flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "CUSDMR");
						flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "CUSDMR");
						// REF_NO 추출
						flatFileRefNo = flatFileHeader.trim().substring(62).trim();

						k=0;
						bfTemp.setLength(0);
						bfTemp.append("MSG_CD:"+arTemp[k++]).append("\n");
						bfTemp.append("PLI:"+arTemp[k++]).append("\n");
						bfTemp.append("RPLI:"+arTemp[k++]).append("\n");
						bfTemp.append("SUB_NO:"+arTemp[k++]).append("\n");
						bfTemp.append("STATUS:"+arTemp[k++]).append("\n");
						bfTemp.append("SEND_DT:"+arTemp[k++]).append("\n");
						bfTemp.append("SEQ:"+arTemp[k++]).append("\n");
						bfTemp.append("REASON:"+arTemp[k++]).append("\n");
						bfTemp.append("OLD_DISC:"+arTemp[k++]).append("\n");
						bfTemp.append("NEW_DISC:"+arTemp[k++]).append("\n");
						bfTemp.append("SENDER:"+arTemp[k++]).append("\n");

						flatFile.append(flatFileHeader).append("\n");
						flatFile.append(bfTemp);

						// CUSDMR EDI 전송
						ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

						// 전송 로그 기록
						bkgCstmsKrSndLogVO.setIoBndCd		(korBlAmdVO.getIoBndCd()		);
						bkgCstmsKrSndLogVO.setSndDt			(sndDt							);
						bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()				);
						bkgCstmsKrSndLogVO.setFltFileRefNo	(flatFileRefNo					);
						bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()				);
						bkgCstmsKrSndLogVO.setVvd			(korBlAmdVO.getVvd()			);
						bkgCstmsKrSndLogVO.setPolCd			(korBlAmdVO.getPolCd()			);
						bkgCstmsKrSndLogVO.setBlNo			(korBlAmdVO.getBlNo()			);
						bkgCstmsKrSndLogVO.setCorrCd		(korBlAmdVO.getKrCstmsCorrId()	);
						bkgCstmsKrSndLogVO.setKtPa			(korBlAmdVO.getKrPortAuthCd()	);
						bkgCstmsKrSndLogVO.setSubNo			(newSubmitNo					);
						bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(flatFile.toString()			);
						dbDao.addCUSDMRSndLog(bkgCstmsKrSndLogVO);

						// 1건만 전송시킴
						break;
					}
				}
			}

		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return transSndChk;
	}

	/**
	 * 반입신고서 전송
	 * @param ManifestDGNTransmitVO manifestDGNTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitDGNManifest(ManifestDGNTransmitVO manifestDGNTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		String fltFileRefNo = null;
		String[] arTemp = null;
		int k=0;

		// EDI 전송 및 HEADER 추출용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String flatFileHeader = null;
		String sender = null;

		// 파라메터 변환
		KorManifestDGNTransmitVO condVO = (KorManifestDGNTransmitVO)manifestDGNTransmitVO;
		KorDgCgoVvdVO korDgCgoVvdVO = condVO.getKorDgCgoVvdVO();
		// FlatFile 조회용 객체
		KorDgCgoVvdVO flatFileDataVO = null;
		// 전송일시
		String sndDt = null;

		try {

			// 위험화물반입신고(CARDGN) Flat File 전송을 위한 조회
			flatFileDataVO = dbDao.makeCARDGNFlatFile(korDgCgoVvdVO);

			arTemp = flatFileDataVO.getEdiSndMsg().split("~", 100);
			sender = arTemp[1];

			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, "KLNETDGCS", "CARDGN");
			fltFileRefNo = flatFileHeader.substring(62).trim();

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			flatFile.append("ICNO:").append(arTemp[k++]).append("\n");
			k++; // SenderID Skip 처리
			flatFile.append("PLI:").append(arTemp[k++]).append("\n");
			flatFile.append("DSCH_CODE:").append(arTemp[k++]).append("\n");
			flatFile.append("DSCH_COM:").append(arTemp[k++]).append("\n");
			flatFile.append("JOB_CODE1:").append(arTemp[k++]).append("\n");
			flatFile.append("JOB_CODE2:").append(arTemp[k++]).append("\n");
			flatFile.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			flatFile.append("VSLFULLNAME:").append(arTemp[k++]).append("\n");
			flatFile.append("IN_DATE:").append(arTemp[k++]).append("\n");
			flatFile.append("SUB_NO:").append(arTemp[k++]).append("\n");
			flatFile.append("IN_NO:").append(arTemp[k++]).append("\n");
			flatFile.append("TOTAL_CNTR:").append(arTemp[k++].replaceAll(",","")).append("\n");
			flatFile.append("PORT_AREA:").append(arTemp[k++]).append("\n");
			flatFile.append("PORT_ANCH:").append(arTemp[k++]).append("\n");
			flatFile.append("PORT_DESC:").append(arTemp[k++]).append("\n");
			flatFile.append("FROM_DATE:").append(arTemp[k++]).append("\n");
			flatFile.append("TO_DATE:").append(arTemp[k++]).append("\n");
			flatFile.append("KIND_CODE:").append(arTemp[k++]).append("\n");
			flatFile.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			flatFile.append("FREE_TEXT:").append(arTemp[k++]).append("\n");
			flatFile.append("PERMIT_CODE:").append(arTemp[k++]).append("\n");
			flatFile.append("PREPORT:").append(arTemp[k++]).append("\n");
			flatFile.append("SUBSTANCE:").append(arTemp[k++]).append("\n");

			// 전송일시
			sndDt = dbDao.searchSysDate();

			// 전송 로그 기록
			korDgCgoVvdVO.setUserId(condVO.getUserId());
			korDgCgoVvdVO.setOfcCd(condVO.getOfcCd());
			korDgCgoVvdVO.setSndDt(sndDt);
			korDgCgoVvdVO.setFltFileRefNo(fltFileRefNo);
			korDgCgoVvdVO.setEdiSndMsg(flatFile.toString());
			dbDao.addCARDGNSndLog(korDgCgoVvdVO);

			// EDI 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return flatFile.toString();
	}

	/**
	 * 적하일람표 전송
	 * @param ManifestDGMTransmitVO manifestDGMTransmitVO
	 * @return DgmManifestVO
	 * @throw EventException
	 */
	public DgmManifestVO transmitDGMManifest(ManifestDGMTransmitVO manifestDGMTransmitVO) throws EventException {

		// FlatFile 객체
		KorDgCgoVvdVO flatFileDataVO 	= null;
		StringBuffer flatFile 			= new StringBuffer();
		StringBuffer bfTemp 			= new StringBuffer();
		String flatFileHeader 			= null;
		String fltFileRefNo 			= null;
		String[] arTemp 				= null;
		int k=0;

		// Header 추출용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String sender;

		// 파라메터 변환
		KorManifestDGMTransmitVO condVO 		= (KorManifestDGMTransmitVO)manifestDGMTransmitVO;
		KorDgmVvdVO korDgmVvdVO		 			= condVO.getKorDgmVvdVO();
		BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs 	= condVO.getBkgCstmsKrDgCgoVOs();


		// 전송일시
		String sndDt = null;
		// 컨테이너별 순번
		String dgCgoSeq = null;
		// MAX VVD SEQ
		String maxVvdSeq = null;
		int cgoSeq = 0;
		// 정보 수정용 객체
		BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO = new BkgCstmsKrDgCgoVvdVO();
		BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO = new BkgCstmsKrDgCgoVO();

		// Container FlatFile 용 객체
		KorDgmCntrVO korDgmCntrVO = new KorDgmCntrVO();
		String[] cntrFlatFiles = null;

		// 리턴용 객체
		DgmManifestVO dgmManifestVO = new DgmManifestVO();

		try {


			// FlatFile Header 조회
			flatFileDataVO = dbDao.makeDGMNFTFlatFile(korDgmVvdVO);
			arTemp = flatFileDataVO.getEdiSndMsg().split("~",100);
			maxVvdSeq = flatFileDataVO.getMaxVvdSeq();

			// Header 생성
			sender = arTemp[1];
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, "KLNETDGCS", "DGMNFT");
			fltFileRefNo = flatFileHeader.substring(62).trim();

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			flatFile.append("ICNO:").append(arTemp[k++]).append("\n");
			k++; // Sender Skip 처리
			flatFile.append("PLI:").append(arTemp[k++]).append("\n");
			flatFile.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			flatFile.append("VSLFULLNAME:").append(arTemp[k++]).append("\n");
			flatFile.append("IN_DATE:").append(arTemp[k++]).append("\n");
			flatFile.append("SUB_NO:").append(arTemp[k++]).append("\n");
			flatFile.append("IN_NO:").append(arTemp[k++]).append("\n");
			flatFile.append("PORT_AREA:").append(arTemp[k++]).append("\n");
			flatFile.append("PORT_ANCH:").append(arTemp[k++]).append("\n");
			flatFile.append("IODATE:").append(arTemp[k++]).append("\n");
			flatFile.append("TML_VVD:").append(arTemp[k++]).append("\n");
			flatFile.append("TML_VOYAGE:").append(arTemp[k++]).append("\n");

			// 전송일시
			sndDt = dbDao.searchSysDate();

			// Container 처리
			if (bkgCstmsKrDgCgoVOs != null) {

				// SEQ 조회를 위한 파라메터 설정
				bkgCstmsKrDgCgoVvdVO.setMrnNo(korDgmVvdVO.getMrnNo());
				bkgCstmsKrDgCgoVvdVO.setVvd	 (korDgmVvdVO.getVvd()  );

				// Bound 구분
				if (korDgmVvdVO.getPodCd() != null && korDgmVvdVO.getPodCd().trim().length() > 4) {
					korDgmVvdVO.setIoBndCd("I");
					korDgmVvdVO.setPortCd(korDgmVvdVO.getPodCd());
				} else {
					korDgmVvdVO.setIoBndCd("O");
					korDgmVvdVO.setPortCd(korDgmVvdVO.getPolCd());
				}

				// Container LOOP
				for (int i=0; i < bkgCstmsKrDgCgoVOs.length; i++) {
					// Container 별 SEQ 조회
					dgCgoSeq = dbDao.searchDgCgoSeq(bkgCstmsKrDgCgoVvdVO);

					bkgCstmsKrDgCgoVOs[i].setIbSeq	(String.valueOf(cgoSeq)		);
					bkgCstmsKrDgCgoVOs[i].setIoBndCd(korDgmVvdVO.getIoBndCd()	);
					bkgCstmsKrDgCgoVOs[i].setVvd	(korDgmVvdVO.getVvd()		);
					bkgCstmsKrDgCgoVOs[i].setCntrSeq(maxVvdSeq					);

					// InBound의 경우
					if (korDgmVvdVO.getIoBndCd().equals("I")) {
						cgoSeq = Integer.parseInt(dgCgoSeq) + i + 1;
						bkgCstmsKrDgCgoVOs[i].setIbSeq	(String.valueOf(cgoSeq)		);
					}

					// DGM 컨테이너 FlatFile 생성
					ObjectCloner.build(bkgCstmsKrDgCgoVOs[i], korDgmCntrVO);
					korDgmCntrVO.setCntrSeq(maxVvdSeq);
					cntrFlatFiles = dbDao.makeDGMNFTCNTRInfo(korDgmCntrVO);

					korDgmCntrVO.setSndDt		(sndDt				);
					korDgmCntrVO.setOfcCd		(condVO.getOfcCd()	);
					korDgmCntrVO.setUserId		(condVO.getUserId()	);
					korDgmCntrVO.setFltFileRefNo(fltFileRefNo		);

					if (cntrFlatFiles != null) {

						for (int j=0; j < cntrFlatFiles.length; j++) {

							arTemp = cntrFlatFiles[j].split("~",200);
							k=0;
							bfTemp.setLength(0);
							bfTemp.append("{T_DGC").append("\n");
							bfTemp.append("CNTRNBR:").append(arTemp[k++]).append("\n");
							bfTemp.append("IMDG:").append(arTemp[k++]).append("\n");
							bfTemp.append("BLNBR:").append(arTemp[k++]).append("\n");
							bfTemp.append("UNNBR:").append(arTemp[k++]).append("\n");
							bfTemp.append("CERTI_NO:").append(arTemp[k++]).append("\n");
							bfTemp.append("CERTI_SEQ:").append(arTemp[k++]).append("\n");
							bfTemp.append("CGO_NO:").append(arTemp[k++]).append("\n");
							bfTemp.append("DSCH_CODE:").append(arTemp[k++]).append("\n");
							bfTemp.append("SUBSTANCE1:").append(arTemp[k++]).append("\n");
							bfTemp.append("SUBSTANCE2:").append(arTemp[k++]).append("\n");
							bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
							bfTemp.append("}T_DGC").append("\n");

							// FlatFile 합치기
							flatFile.append(bfTemp);
						}
					}
				}
				dgmManifestVO.setBkgCstmsKrDgCgoVOs(bkgCstmsKrDgCgoVOs);
			}

			// EDI SND
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

			// 전송 로그 기록
			korDgmVvdVO.setUserId		(condVO.getUserId()	);
			korDgmVvdVO.setOfcCd		(condVO.getOfcCd()	);
			korDgmVvdVO.setSndDt		(sndDt				);
			korDgmVvdVO.setFltFileRefNo	(fltFileRefNo		);
			korDgmVvdVO.setEdiSndMsg	(flatFile.toString());
			dbDao.addDGMNFTSndLog(korDgmVvdVO);

			// EDI SEND 후 전송일자 UPDATE
			bkgCstmsKrDgCgoVvdVO.setUserId		(condVO.getUserId()	);
			bkgCstmsKrDgCgoVvdVO.setMaxVvdSeq	(maxVvdSeq			);
			dgmManifestVO.setBkgCstmsKrDgCgoVvdVO(bkgCstmsKrDgCgoVvdVO);

			// EDI SND 후 CONTAINER 전송일자 UPDATE
			bkgCstmsKrDgCgoVO.setVvd	(korDgmVvdVO.getVvd()		);
			bkgCstmsKrDgCgoVO.setUserId	(condVO.getUserId()			);
			bkgCstmsKrDgCgoVO.setIoBndCd(korDgmVvdVO.getIoBndCd()	);
			dgmManifestVO.setBkgCstmsKrDgCgoVO(bkgCstmsKrDgCgoVO);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return dgmManifestVO;
	}

	/**
	 * MSN Create EDI 전송
	 * @param ManifestMFTTransmitVO manifestMFTTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitKorMFTManifest(ManifestMFTTransmitVO manifestMFTTransmitVO) throws EventException {
		// flatFile
		StringBuffer flatFile = new StringBuffer();
		// 파라메터 변환
		KorManifestMFTTransmitVO condVO = (KorManifestMFTTransmitVO)manifestMFTTransmitVO;
		// 개행문자
		String lf = "\n";
		// Header 생성용 객체
		KorMFTVO korMFTVO = new KorMFTVO();
		// Body 생성용 객체
		KorIbManifestVO[] korIbManifestVOs = null;
		KorIbManifestVO korIbManifestVO = new KorIbManifestVO();
		// EDI 전송용 객체
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		BookingUtil utilCommand = new BookingUtil();
		FlatFileAckVO flatFileAckVO = null;

		try {

			// FlatFile 헤더 생성
			flatFile.append("IFHJS2HJT!MFTSND!").append(lf);
			korMFTVO.setMrnNo	(condVO.getMrnNo()		);
			korMFTVO.setMrnChkNo(condVO.getMrnChkNo()	);
			korMFTVO = dbDao.makeKorMFTHeader(korMFTVO);

			if (korMFTVO==null) {
				throw new EventException(new ErrorHandler("BKG00220").getMessage());
			}

			flatFile.append("MRN_NO:").append(korMFTVO.getMrnNo()).append(lf);
			flatFile.append("SND_DT:").append(korMFTVO.getSndDt()).append(lf);

			// FlatFile Body 생성
			ObjectCloner.build(condVO, korIbManifestVO);
			korIbManifestVOs = dbDao.makeKorMFTBodyFile(korIbManifestVO);
			if (korIbManifestVOs==null || korIbManifestVOs.length < 1) {
				throw new EventException(new ErrorHandler("BKG50483").getMessage());
			}

			// BL 단위 LOOP
			for (int i=0; i < korIbManifestVOs.length; i++) {

				flatFile.append("{BL").append(lf);
				flatFile.append("BL_NO:").append(korIbManifestVOs[i].getBlNo()).append(lf);
				flatFile.append("ET_CD:").append(korIbManifestVOs[i].getCstmsClrTpCd()).append(lf);
				flatFile.append("DISC_CD:").append(korIbManifestVOs[i].getCstmsDchgLocWhCd()).append(lf);
				flatFile.append("WH_CD:").append(korIbManifestVOs[i].getCstmsClrWhCd()).append(lf);
				flatFile.append("BT_CD:").append(korIbManifestVOs[i].getBdTpCd()).append(lf);
				flatFile.append("TRANS:").append(korIbManifestVOs[i].getTransChk()).append(lf);
				flatFile.append("}BL").append(lf);

			}

			// EDI 전송
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_ENTRY.IBMMQ.QUEUE"));
			flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}


		return flatFile.toString();
	}

	/**
	 * EDI 전송 처리부
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
			  if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Amendment Transmission to Korean Customs 정정 내용 출력을 위한 조회
	 * @param AmdFormVO[] amdFormVOs
	 * @return AmdFormVO[]
	 * @throw EventException
	 */
	public AmdFormVO[] searchAmdFormPrev(AmdFormVO[] amdFormVOs) throws EventException {

		// 입력 파라메터 변환
		KorAmdFormVO[] condVOs = (KorAmdFormVO[])amdFormVOs;
		// 처리 결과 LIST
		List<KorAmdFormVO> list = new ArrayList<KorAmdFormVO>();
		KorAmdFormVO korAmdFormVO = null;
		KorAmdFormVO korAmdFormCorrVO = null;

		// BL INFO 조회용
		KorAmdBlInfoVO korAmdBlInfoVO 	 = new KorAmdBlInfoVO();
		KorAmdBlInfoVO[] korAmdBlInfoVOs = null;

		// SUBMIT NO 조회용
		KorAmdNoVO amdNoVO = new KorAmdNoVO();
		String submitNo = null;

		// 정정신청 내용 조회용
		KorAmdTransVO amdTransVO = new KorAmdTransVO();
		KorAmdTransVO[] amdTransVOs = null;

		try {

			// TYPE 처리
			String inType = condVOs[0].getInType();
			if (inType==null || "|A|B|C|D|M".indexOf(inType) < 1 ) inType="N";
			// PORT 처리
			String portCd = condVOs[0].getPodCd();
			if (condVOs[0].getIoBndCd().equals("O")) portCd = condVOs[0].getPolCd();
			// POD_TML 처리
			String podTml2 =condVOs[0].getYardCd();
			if (podTml2 != null && !"".equals(podTml2)) {
				podTml2 = portCd + condVOs[0].getYardCd();
			} else {
				podTml2 = portCd;
			}

			// MRN NO 조회
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
			// 파라메터 설정
			bkgCstmsKrVvdSmryVO.setVvd		(condVOs[0].getVvd()	);
			bkgCstmsKrVvdSmryVO.setIoBndCd	(condVOs[0].getIoBndCd());
			bkgCstmsKrVvdSmryVO.setInType	(inType					);
			bkgCstmsKrVvdSmryVO.setPolCd	(condVOs[0].getPolCd()	);
			bkgCstmsKrVvdSmryVO.setPodCd	(condVOs[0].getPodCd()	);
			bkgCstmsKrVvdSmryVO.setPodTml	(podTml2				);
			// 조회
			bkgCstmsKrVvdSmryVO = dbDao.searchMrnNoKor(bkgCstmsKrVvdSmryVO);

			// Ship Name 조회
			KorVslCondVO vslCondVO = new KorVslCondVO();
			vslCondVO.setVvd(condVOs[0].getVvd());
			KorVslVO vslVO  = dbDao.searchVSLInfoInBKG(vslCondVO);

			// BL LOOP
			for (int i=0; i < condVOs.length; i++) {

				korAmdFormVO = new KorAmdFormVO();

				// MRN 및 SHIP 정보 셋팅
				korAmdFormVO.setMrnNo(bkgCstmsKrVvdSmryVO.getMrnNo() + bkgCstmsKrVvdSmryVO.getMrnChkNo());
				korAmdFormVO.setBlTpCd(bkgCstmsKrVvdSmryVO.getLoclCstmsCd());
				korAmdFormVO.setPortCd(bkgCstmsKrVvdSmryVO.getPortCd());
				korAmdFormVO.setEtaDt(bkgCstmsKrVvdSmryVO.getEtaDt());
				korAmdFormVO.setShipNm(vslVO.getVslEngNm2());

				// 포맷 변환
				if (korAmdFormVO.getEtaDt() != null) {
					korAmdFormVO.setEtaDt(korAmdFormVO.getEtaDt().substring(0,10).replaceAll("-", "."));
				}
				if (korAmdFormVO.getMrnNo() != null && korAmdFormVO.getMrnNo().length() > 10) {
					korAmdFormVO.setMrnNo( korAmdFormVO.getMrnNo().substring(0, 2) + "-" +
										   korAmdFormVO.getMrnNo().substring(2, 6)+ "-" +
										   korAmdFormVO.getMrnNo().substring(6, 10)+ "-" +
										   korAmdFormVO.getMrnNo().substring(10,11)
										  );
				}
				if (korAmdFormVO.getPortCd() != null) {
					korAmdFormVO.setPortCd( korAmdFormVO.getPortCd().substring(0,2) + "-" + korAmdFormVO.getPortCd().substring(2));
				}

				// BL INFO 조회
				// 파라메터 설정
				korAmdBlInfoVO.setIoBndCd	(condVOs[i].getIoBndCd()	);
				korAmdBlInfoVO.setPortCd	(portCd						);
				korAmdBlInfoVO.setPolCd		(condVOs[i].getPolCd()		);
				korAmdBlInfoVO.setPodCd		(condVOs[i].getPodCd()		);
				korAmdBlInfoVO.setVvd		(condVOs[i].getVvd()		);
				korAmdBlInfoVO.setYardCd	(podTml2					);
				korAmdBlInfoVO.setBlNo		(condVOs[i].getBlNo()		);
				korAmdBlInfoVO.setCBlNo		(condVOs[i].getBlNo()		);
				korAmdBlInfoVO.setBkgNo		(condVOs[i].getBkgNo()		);
				// 조회
				korAmdBlInfoVOs = dbDao.searchAmdBlInfoKor(korAmdBlInfoVO);

				if (korAmdBlInfoVOs != null && korAmdBlInfoVOs.length > 0 ) {

					// SUBMIT NO 조회
					amdNoVO.setPortCd		(portCd									);
					amdNoVO.setVvd	 		(condVOs[0].getVvd()					);
					amdNoVO.setBlNo			(condVOs[i].getBlNo()					);
					amdNoVO.setCstmsDeclTpCd(korAmdBlInfoVOs[0].getCstmsDeclTpCd()	);
					amdNoVO.setCBlNo		(korAmdBlInfoVOs[0].getCBlNo()			);
					submitNo = dbDao.searchSmtAmdNo(amdNoVO);

					// 정정신청 내역 조회
					amdTransVO.setVvd			(condVOs[0].getVvd()					);
					amdTransVO.setBkgNo			(korAmdBlInfoVOs[0].getBkgNo()			);
					amdTransVO.setPortCd		(portCd									);
					amdTransVO.setCstmsDeclTpCd	(korAmdBlInfoVOs[0].getCstmsDeclTpCd()	);
					amdTransVO.setSmtAmdNo		(submitNo								);
					amdTransVO.setBlNo			(korAmdBlInfoVOs[0].getCBlNo()			);

					amdTransVOs = dbDao.searchAmdTransmitDataList(amdTransVO);

					// 조회 결과값 매핑
					korAmdFormVO.setMsnNo	(condVOs[i].getMsnNo()					);
					korAmdFormVO.setBlNo	("HJSC"+condVOs[i].getBlNo()			);
					korAmdFormVO.setBlTpCd	(korAmdBlInfoVOs[0].getCstmsDeclTpCd()	);
					if (amdTransVOs != null) {

						for (int j=0; j < amdTransVOs.length; j++) {
							korAmdFormCorrVO = new KorAmdFormVO();

							ObjectCloner.build(korAmdFormVO, korAmdFormCorrVO);

							korAmdFormCorrVO.setP1		(amdTransVOs[j].getP1()		);
							korAmdFormCorrVO.setC1		(amdTransVOs[j].getC1()		);
							korAmdFormCorrVO.setSndDt	(amdTransVOs[j].getSendDt()	);

							// 결과 LIST 에 추가
							list.add(korAmdFormCorrVO);
						}
					}

				}
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list.toArray(new KorAmdFormVO[0]);
	}

	/**
	 * 한국세관 EDI 수신
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @throw EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException {

		// 한국세관 EDI 수신 처리
		String[] lines = null;
		// 로그 저장용 객체
		KorAckMsgVO ackMsgVO = new KorAckMsgVO();

		try {

			lines = ((KorRcvAckMsgVO)rcvMsgVO).getFlatFile().split("\n");
			// MSG_TP에 따라 EDI 수신을 구분한다.
			String msgTp = lines[0].trim().substring(lines[0].indexOf(":")+1, lines[0].indexOf(" "));
			if ("KMPAE050".equals(msgTp) || "KMPAE020".equals(msgTp) || "BPAED020".equals(msgTp)) {
				// REF_NO
				String fltFileRefNo = lines[0].trim().substring(62);
				// RECEIVE SEQUENCE : 조회값이 없을 경우 1로 설정
				String maxRcvSeq = dbDao.searchCstmMaxAckSeq(fltFileRefNo);
				// UserId 대용
				String userId = msgTp;
				// 수신결과 메시지
				String msgType = "";
				String docDate = "";
				String cstmsRefNm = "";
				String rtnDesc = "";
				String ediRcvrNm = "";
				String tmlCd = "";
				String krVslCallSgnCd = "";
				String arrYr = "";
				String callKnt = "";

				for (int i=1; i < lines.length; i++) {
					if (lines[i].indexOf("MSG_TYPE:") != -1 ) 			msgType = lines[i].trim().substring(lines[i].indexOf("MSG_TYPE:")+9);
					else if (lines[i].indexOf("DOC_DATE:") != -1 ) 		docDate = lines[i].trim().substring(lines[i].indexOf("DOC_DATE:")+9);
					else if (lines[i].indexOf("DOC_REF:") != -1 ) 		cstmsRefNm = lines[i].trim().substring(lines[i].indexOf("DOC_REF:")+8);
					else if (lines[i].indexOf("RTN_DESC:") != -1 ) 		rtnDesc = lines[i].trim().substring(lines[i].indexOf("RTN_DESC:")+9);
					else if (lines[i].indexOf("RCV_CODE:") != -1 ) 		ediRcvrNm = lines[i].trim().substring(lines[i].indexOf("RCV_CODE:")+9);
					else if (lines[i].indexOf("SND_CODE:") != -1 ) 		tmlCd = lines[i].trim().substring(lines[i].indexOf("SND_CODE:")+9);
					else if (lines[i].indexOf("VSL_CALLSIGN:") != -1 ) 	krVslCallSgnCd = lines[i].trim().substring(lines[i].indexOf("VSL_CALLSIGN:")+13);
					else if (lines[i].indexOf("ENTRY_YEAR:") != -1 ) 	arrYr = lines[i].trim().substring(lines[i].indexOf("ENTRY_YEAR:")+11);
					else if (lines[i].indexOf("ENTRY_SEQ:") != -1 ) 	callKnt = lines[i].trim().substring(lines[i].indexOf("ENTRY_SEQ:")+10);
				}

				// 전송 로그 추가
				ackMsgVO.setMsgLogTpCd		(msgType		);
				ackMsgVO.setRcvDt			(docDate		);
				ackMsgVO.setRcvSeq			(maxRcvSeq		);
				ackMsgVO.setFltFileRefNo	(fltFileRefNo   );
//				ackMsgVO.setSmtAmdNo		(lines[2].trim().substring(7)		);
//				ackMsgVO.setKrCstmsAcptCd	(lines[5].trim().substring(8)		);
//				if (lines[1].trim().length() > 6) ackMsgVO.setBlNo(lines[1].trim().substring(6));
				ackMsgVO.setUserId			(userId);
				ackMsgVO.setCstmsRefNm(cstmsRefNm);
				ackMsgVO.setEdiRcvrNm(ediRcvrNm);
				ackMsgVO.setTmlCd(tmlCd);
				ackMsgVO.setKrVslCallSgnCd(krVslCallSgnCd);
				ackMsgVO.setArrYr(arrYr);
				ackMsgVO.setCallKnt(callKnt);
				ackMsgVO.setKrCstmsRjctRsn1(rtnDesc);

			} else if (!"MADECLINTS".equals(msgTp)) {
				// REF_NO
				String fltFileRefNo = lines[8].trim().substring(12);
				// RECEIVE SEQUENCE : 조회값이 없을 경우 1로 설정
				String maxRcvSeq = dbDao.searchCstmMaxAckSeq(fltFileRefNo);
				// UserId 대용
				String userId = lines[0].trim().substring(lines[0].indexOf(":")+1, lines[0].indexOf(" "));
				// 수신결과 메시지
				String rsltMsg = "";
				if (lines[6].trim().length() > 12 ) rsltMsg = lines[6].trim().substring(12);

				// 전송 로그 추가
				ackMsgVO.setMsgLogTpCd		(lines[4].trim().substring(7)		);
				ackMsgVO.setRcvDt			(lines[7].trim().substring(11)		);
				ackMsgVO.setRcvSeq			(maxRcvSeq							);
				ackMsgVO.setFltFileRefNo	(fltFileRefNo						);
				ackMsgVO.setSmtAmdNo		(lines[2].trim().substring(7)		);
				ackMsgVO.setKrCstmsAcptCd	(lines[5].trim().substring(8)		);
				if (lines[1].trim().length() > 6) ackMsgVO.setBlNo(lines[1].trim().substring(6));
				ackMsgVO.setUserId			(userId);
				ackMsgVO.setKrCstmsRjctRsn1	(rsltMsg);

			} else {
				// REF_NO
				String fltFileRefNo = lines[0].trim().substring(62);
				// RECEIVE SEQUENCE : 조회값이 없을 경우 1로 설정
				String maxRcvSeq = dbDao.searchCstmMaxAckSeq(fltFileRefNo);
				// UserId 대용
				String userId = lines[0].trim().substring(lines[0].indexOf(":")+1, lines[0].indexOf(" "));
				// 수신Reject 메시지
				String rsltMsg = "";
				if (lines[6].trim().length() > 12 ) rsltMsg = lines[6].trim().substring(14);

				// 전송 로그 추가
				ackMsgVO.setMsgLogTpCd		("5VD");
				ackMsgVO.setRcvDt			(lines[3].trim().substring(12)		);
				ackMsgVO.setRcvSeq			(maxRcvSeq							);
				ackMsgVO.setFltFileRefNo	(fltFileRefNo						);
				ackMsgVO.setSmtAmdNo		(lines[5].trim().substring(7)		);
				ackMsgVO.setKrCstmsAcptCd	(lines[2].trim().substring(7)		);
				ackMsgVO.setUserId			(userId);
				ackMsgVO.setKrCstmsRjctRsn1	(rsltMsg);
			}

			dbDao.addCstmAckMsg(ackMsgVO);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return null;
	}

	/**
	 * InBound Empty Amend 전송
	 * @param EmpAmdManiTransVO[] empAmdManiTransVOs
	 * @throws EventException
	 */
	@SuppressWarnings("unused")
	public void transmitEmpAmdManifest(EmpAmdManiTransVO[] empAmdManiTransVOs) throws EventException {

		// 파라메터 변환
		KorEmpAmdManiTransVO[] korEmpAmdManiTransVOs = (KorEmpAmdManiTransVO[])empAmdManiTransVOs;

		// EDI 전송용 객체
		String sysdate = null;
		String maxSeq = null;
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		BookingUtil utilCommand = new BookingUtil();
		FlatFileAckVO flatFileAckVO = null;

		// IMFMOD
		KorEmpImfmodVO korEmpImfmodVO = null;
		// MACAMD
		KorEmpMacamdVO korEmpMacamdVO = null;

		// FlatFile 전송용 객체
		StringBuffer flatFile = new StringBuffer();
		String flatFileHeader = null;
		String flatFileRefNo = null;
		String usrNm = null;

		// Log 저장용 객체
		KorAutoMacSndVO korAutoMacSndVO = new KorAutoMacSndVO();

		try {

			// MAIN LOOP
			for (int i=0; i < korEmpAmdManiTransVOs.length; i++) {

				flatFile.setLength(0);

				// 헤더 생성
				//flatFileHeader = utilCommand.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");
				flatFileHeader = utilCommand.searchCstmsEdiHeader("SSHJSC0002", "KCS0004XML", "IMFMOD");
				flatFileRefNo = flatFileHeader.substring(62).trim();

				// flatFile Header
				flatFile.append(flatFileHeader).append("\n");

				// 전송일시
				sysdate = dbDao.searchSysDate();

				// User name 조회
				usrNm = dbDao.searchComUser(korEmpAmdManiTransVOs[i].getUsrId());

				korEmpImfmodVO = new KorEmpImfmodVO();
				// Receiver 가 All 인 경우 처리

				// RECEIVER 가 ALL 이거나 PA 인 경우 추가
				if (korEmpAmdManiTransVOs[i].getReceiver().equals("0") || korEmpAmdManiTransVOs[i].getReceiver().equals("1")) {
					flatFile.setLength(0);

					// 헤더 생성
					flatFileHeader = utilCommand.searchCstmsEdiHeader("HJSPORT1", "BPAED020", "MACAMD");
					flatFileRefNo = flatFileHeader.substring(62).trim();

					// flatFile Header
					flatFile.append(flatFileHeader).append("\n");

					// MACAMD FlatFile 생성
					korEmpMacamdVO = new KorEmpMacamdVO();
					korEmpMacamdVO.setCstmsBlNo		(korEmpAmdManiTransVOs[i].getIbTsCblno()	);
					korEmpMacamdVO.setTrnsSeq		(korEmpAmdManiTransVOs[i].getIbTsSeq()		);
					korEmpMacamdVO.setDmstPortCd	(korEmpAmdManiTransVOs[i].getIbTsPort()		);
					korEmpMacamdVO.setBkgNo			(korEmpAmdManiTransVOs[i].getIbTsBkgno()	);
					korEmpMacamdVO.setCstmsDeclTpCd	(korEmpAmdManiTransVOs[i].getIbTsType()		);
					korEmpMacamdVO = dbDao.makeAutoMACAMDFlatFile(korEmpMacamdVO);

					flatFile.append(korEmpMacamdVO.getEdiSndData().replaceAll("~", "\n")).append("\n");

					// 전송일시
					sysdate = dbDao.searchSysDate();

					// MaxSEQ 조회
					maxSeq = dbDao.searchMaxMacSndLogSeq(sysdate, korEmpAmdManiTransVOs[i].getOfcCd());

					// IMFMOD CORRECTION FLATFILE 생성
					flatFile.append(dbDao.makeAutoMACAMDCorrFlatFile().replaceAll("~", "\n")).append("\n");

					// MACAMD 로그 기록
					korAutoMacSndVO.setSndDt		(sysdate								);
					korAutoMacSndVO.setOfcCd		(korEmpAmdManiTransVOs[i].getOfcCd()	);
					korAutoMacSndVO.setFltFileRefNo	(flatFileRefNo							);
					korAutoMacSndVO.setUsrId		(korEmpAmdManiTransVOs[i].getUsrId()	);
					korAutoMacSndVO.setVvdCd		(korEmpAmdManiTransVOs[i].getIbTsVvd()	);
					korAutoMacSndVO.setPolCd		(korEmpAmdManiTransVOs[i].getIbTsPort()	);
					korAutoMacSndVO.setBlNo			(korEmpAmdManiTransVOs[i].getIbTsCblno());
					korAutoMacSndVO.setSubNo		(korEmpAmdManiTransVOs[i].getSubNo()	);
					korAutoMacSndVO.setSndSeq		(maxSeq									);
					korAutoMacSndVO.setEdiSndMsg	(flatFile.toString()					);
					dbDao.addAutoMACAMDSndLog(korAutoMacSndVO);

					// EDI 전송
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE"));
					flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 한국세관 Cancel per B/L EDI 전송
	 *
	 * @param CancelManifestTransmitVO cancelManifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transCancelManifest(CancelManifestTransmitVO cancelManifestTransmitVO) throws EventException {
		// FlatFile
		StringBuffer flatFile = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		String[] arTemp = null;
		String fltFileRefNo = null;
		int k=0;
		// FlatFile Header 용 객체
		KorMacamdVO korMacamdVO = new KorMacamdVO();

		// FlatFile 객체
		String flatFileHeader = null;

		// Send Date
		String sndDt = null;
		// UNLocCd
		KorUNLocVO korUNLocVO = null;

		// 로그 저장용 객체
		BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO = new BkgCstmsKrSndLogVO();

		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";

		// 화면에서 넘어온 VO
		KorCancelManifestTransmitVO condVO = null;

		try {

			// 파라메터 변환
			condVO = (KorCancelManifestTransmitVO)cancelManifestTransmitVO;

			// 수신처 판단
			if (condVO.getKtPa() != null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020")) {
					receiver = "BPAED020";
				} else  if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				} else  if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("HJSPORT1", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(62).trim();

			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// UNLocCd
			korUNLocVO = dbDao.searchUNLocCd(condVO.getPolCd(), condVO.getPodCd());
			// 조회결과 없을경우 빈칸 처리
			if (korUNLocVO==null) {
				korUNLocVO = new KorUNLocVO();
				korUNLocVO.setPodUn("");
				korUNLocVO.setPolUn("");
			}

			korMacamdVO.setKtPa			(condVO.getKtPa()			);
			korMacamdVO.setIoBndCd		(condVO.getIoBndCd()		);
			korMacamdVO.setCallYear		(condVO.getCallYear()		);
			korMacamdVO.setCallKnt		(condVO.getCallKnt()		);
			korMacamdVO.setVslCallSgnCd	(condVO.getVslCallSgnCd()	);
			korMacamdVO.setMrnNo		(condVO.getMrnNo()			);
			korMacamdVO.setVvd			(condVO.getVvd()			);
			korMacamdVO.setVslNm		(condVO.getVslNm()			);
			korMacamdVO.setVslCntCd		(condVO.getVslCntCd()		);
			korMacamdVO.setBlNo			(condVO.getBlNo()			);
			korMacamdVO.setDchgMzdCd	(condVO.getDchgMzdCd()		);
			korMacamdVO.setIoTmlLocCd	(condVO.getIoTmlLocCd()		);
			korMacamdVO.setBdAreaCd		(condVO.getBdAreaCd()		);
			korMacamdVO.setTtlPckUtCd	(condVO.getTtlPckUtCd()		);
			korMacamdVO.setTtlWgt		(condVO.getTtlWgt()			);
			korMacamdVO.setTtlMeasUtCd	(condVO.getTtlMeasUtCd()	);
			korMacamdVO.setTtlMeasQty	(condVO.getTtlMeasQty()		);
			korMacamdVO.setUnPodCd		(korUNLocVO.getPodUn()		);
			korMacamdVO.setUnPolCd		(korUNLocVO.getPolUn()		);
			// 헤더 추가정보 생성
			flatFileHeader = dbDao.makeMACAMDFlatFile(korMacamdVO);
			arTemp = flatFileHeader.split("~", 100);
			k=0;

			bfTemp.setLength(0);

			bfTemp.append("MSG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSG_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SEND_DT:").append(arTemp[k++]).append("\n");
			bfTemp.append("PORT_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SCAC:").append(arTemp[k++]).append("\n");
			bfTemp.append("CARRIER_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CALLSIGN:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSL_FLAG:").append(arTemp[k++]).append("\n");
			bfTemp.append("ETA:").append(arTemp[k++]).append("\n");
			bfTemp.append("IN_SEQ:").append(arTemp[k++]).append("\n");
			bfTemp.append("BL_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("MSN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("CORR_CD:F").append("\n");
			k++; // Correction Code 는 F로 셋팅하고 Skip 처리
			bfTemp.append("BL_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_TP:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_MD_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("BKG_POD:").append(arTemp[k++]).append("\n");
			bfTemp.append("QUAY_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("PKG_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CGO_DESC2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS1:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS2:").append(arTemp[k++]).append("\n");
			bfTemp.append("IMO_CLASS3:").append(arTemp[k++]).append("\n");
			bfTemp.append("WGT:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("MEA_TP:").append("").append("\n");
			k++; // MEA_TP Skip 처리
			bfTemp.append("MEA:").append(arTemp[k++].replaceAll(",", "")).append("\n");
			bfTemp.append("SHPR1:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR2:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR3:").append(arTemp[k++]).append("\n");
			bfTemp.append("SHPR4:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE2:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE3:").append(arTemp[k++]).append("\n");
			bfTemp.append("CNEE4:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY1:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY2:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY3:").append(arTemp[k++]).append("\n");
			bfTemp.append("NTFY4:").append(arTemp[k++]).append("\n");
			bfTemp.append("DISC_CO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");

			flatFile.append(bfTemp);

			// SysDate 조회
			sndDt = dbDao.searchSysDate();

			// 일괄정정, 일괄삭제 MASTER LOG 테이블에 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()	);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()	);
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()	);
			bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()	);
			bkgCstmsKrSndLogVO.setEdiSndMsgCtnt	(flatFile.toString());
			// 로그 기록
			dbDao.addMACAMDModiDelSndLog(bkgCstmsKrSndLogVO);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return null;
	}

	/**
	 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 true 아니면 false
	 * @param bkgCgoTpCd
	 * @param krCstmsBlTpCd
	 * @return boolean
	 */
	private boolean checkRevenueEmpty(String bkgCgoTpCd, String krCstmsBlTpCd) {

		boolean retVal = false;

		if ("R".equals(bkgCgoTpCd)) {
			if ("S".equals(krCstmsBlTpCd) || "C".equals(krCstmsBlTpCd)) {
				retVal = true;
			}
		}

		return retVal;
	}

	/**
	 * ESM_BKG_0503 Transmit Cross-Check 조회
	 * @param KorTransCrossChkCondVO korTransCrossChkCondVO
	 * @return List<KorTransCrossChkDtlVO>
	 * @throws EventException
	 */
	public List<KorTransCrossChkDtlVO> searchTransCrossChk(KorTransCrossChkCondVO korTransCrossChkCondVO) throws EventException {
		try {
			return dbDao.searchTransCrossChk(korTransCrossChkCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * KR Manifest를 취소하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitCancellKR(ManifestTransmitVO manifestTransmitVO) throws EventException {
		// FLATFILE
		StringBuffer flatFile = new StringBuffer();
		String fltFileRefNo = null;
		String[] arTemp = null;
		StringBuffer bfTemp = new StringBuffer();
		int k=0;

		// 파라메터 변환
		KorManifestCancelTransmitVO condVO = (KorManifestCancelTransmitVO)manifestTransmitVO;

		KorTransCancellCustVO transmitVO = condVO.getKorTransCancellCustVO();

		// FLATFILE 관련 객체
		String flatFileHeader = "";
		StringBuffer flatFileBody   = new StringBuffer();

		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		// BODY 생성용 객체

		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO 	  bkgCstmsKrSndLogVO 	= new BkgCstmsKrSndLogVO();

		// SEND DATE
		String sndDt = null;

		// Max Sequence
		String maxSeq = null;

		// 송수신처 판단
		String sender 	= "SSHJSC0002";
		String receiver = "MADECLINTS";

		// 헤더 생성
		flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "PORTAL");
		fltFileRefNo = flatFileHeader.substring(62).trim();

		// flatFile 에 추가
		flatFile.append(flatFileHeader).append("\n");

		try {

			// FLATFILE 바디 생성
			flatFileBody.append(dbDao.makeKRTransCancelFlatFile(transmitVO));

			arTemp = flatFileBody.toString().split("~",100);

			k=0;
			bfTemp.setLength(0);

			bfTemp.append("{PORTAL").append("\n");
			bfTemp.append("TYPE:").append(arTemp[k++]).append("\n");
			bfTemp.append("SUBMISSION_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("VVD:").append(arTemp[k++]).append("\n");
			bfTemp.append("VESSEL_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("LOC:").append(arTemp[k++]).append("\n");
			bfTemp.append("APP_DTM:").append(arTemp[k++]).append("\n");
			bfTemp.append("DTM:").append(arTemp[k++]).append("\n");
			bfTemp.append("WITHDRAW_TYPE:").append(arTemp[k++]).append("\n");
			bfTemp.append("WITHDRAW_REASON:").append(arTemp[k++]).append("\n");
			bfTemp.append("MRN_NO:").append(arTemp[k++]).append("\n");
			bfTemp.append("SIMPLE_MBL_COUNT:").append(arTemp[k++]).append("\n");
			bfTemp.append("CONSOLE_MBL_COUNT:").append(arTemp[k++]).append("\n");
			bfTemp.append("HBL_COUNT:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_NAME:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_PIC:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_TEL:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_ADDR1:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_ADDR2:").append(arTemp[k++]).append("\n");
			bfTemp.append("CA_ADDR3:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("}PORTAL").append("\n");
			flatFile.append(bfTemp);

			// Send Data 생성
			sndDt = dbDao.searchSysDate();

			// MaxSEQ 조회
			maxSeq = dbDao.searchMaxPortalSndSeq(sndDt, transmitVO.getOfcCd());

			// 전송 로그 기록
			// 일괄정정, 일괄삭제 MASTER LOG 테이블에 기록
			bkgCstmsKrSndLogVO.setIoBndCd(transmitVO.getIoBndCd());
			bkgCstmsKrSndLogVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogVO.setOfcCd			(transmitVO.getOfcCd());
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogVO.setUserId		(transmitVO.getUserId()	);
			bkgCstmsKrSndLogVO.setMfSndSeq (maxSeq);
			bkgCstmsKrSndLogVO.setVvd			(transmitVO.getVvd());
			bkgCstmsKrSndLogVO.setPolCd			(transmitVO.getPolCd()	);
			bkgCstmsKrSndLogVO.setPodCd		(transmitVO.getPodCd()	);
			bkgCstmsKrSndLogVO.setBlKnt          (transmitVO.getSmpBlKnt());
			bkgCstmsKrSndLogVO.setTeuCnt       (transmitVO.getCnslBlKnt());
			bkgCstmsKrSndLogVO.setFeuCnt       (transmitVO.getMstBlKnt());
			bkgCstmsKrSndLogVO.setSubNo       (transmitVO.getMrnNo());
			bkgCstmsKrSndLogVO.setTrsmCxlTpCd(transmitVO.getTrsmCxlTpCd());
			bkgCstmsKrSndLogVO.setTrsmCxlRsnCd(transmitVO.getTrsmCxlRsnCd());
			bkgCstmsKrSndLogVO.setTrsmCxlDesc(transmitVO.getTrsmCxlDesc());
			bkgCstmsKrSndLogVO.setEdiSndMsgCtnt(flatFile.toString()		);
			dbDao.addPORTALSndLog(bkgCstmsKrSndLogVO);

			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE");

			return flatFile.toString();

		} catch (EventException evx) {
			throw evx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

}
