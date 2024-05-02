/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionBCImpl.java
*@FileTitle : CustomsTransmissionBCImpl
*Open Issues : 
*Change history : 
*@LastModifyDate : 2011.01.17 이수진
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.01.17 이수진
* 1.0 Creation
* 2011.03.30 손은주 [CHM-201109081-01]	MANIFEST AMEND PA(항만청) B/L 추가시 문서명 오류 정정 요청
* 2011.12.05 민정호 [CLT-111121274-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference) 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration.KorCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrSndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAckMsgDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAckMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAutoMacSndDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAutoMacSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrCntVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrNoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorContInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusdmrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmanVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCusrepVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustChkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgCgoVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDiscFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorElnoInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpMacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIbManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIftsaiDateVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIftsaiSndCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIftsaiVslVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMFTVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMakeSubNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestCancelTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestMFTTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorRcvAckMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorSkipVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorUNLocVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslSkdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslSkdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorVslVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmdFormVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmdManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DgmManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.IftsaiSndCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGMTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGNTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestMFTTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlAmdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorIftsaiVslPortVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br> 
 * 
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4     
 */
public class KorCustomsTransmissionBCImpl  extends CustomsTransmissionBCImpl 
{
	
	private static final long serialVersionUID = 955681827953376597L;
	
	// Database Access Object
	private transient KorCustomsTransmissionDBDAO dbDao = null;
	
	/**
	 * JapanCustomsTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public KorCustomsTransmissionBCImpl() 
	{
		dbDao = new KorCustomsTransmissionDBDAO();
	}	
	
	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param MrnCreateInfoCondVO mrnCreateInfoCondVO
	 * @return MrnCreateInfoVO[]
	 * @exception EventException
	 */
	public MrnCreateInfoVO[] searchMrnCreateInfo(MrnCreateInfoCondVO mrnCreateInfoCondVO)	throws EventException {
		// 최종 결과 객체
		KorMrnCreateInfoVO[] korMrnCreateInfoVOs = null;
		
		try {
			korMrnCreateInfoVOs = dbDao.searchMrnCreateInfo((KorMrnCreateInfoCondVO)mrnCreateInfoCondVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return korMrnCreateInfoVOs;
	}

	/**
	 * MRN Create 정보 추가 
	 * @param MrnCreateInfoVO mrnCreateInfoVO
	 * @return MrnCreateInfoVO[]
	 * @exception EventException
	 */
	public MrnCreateInfoVO[] manageMrnCreateInfo(MrnCreateInfoVO mrnCreateInfoVO) throws EventException {
		// 처리결과 객체 
		List<KorMrnCreateInfoVO> korMrnCreateInfoVOs = new ArrayList<KorMrnCreateInfoVO>();
		KorMrnCreateInfoVO korMrnCreateInfoVO = null;
		// 파라메터 변환
		KorMrnCreateInfoVO condVO = (KorMrnCreateInfoVO)mrnCreateInfoVO;
		// MRN CHECK DIGIT
		// MRN CHECK DIGIT : 국종망 4세대 반영으로 I(수입) or E(수출)로 변경
				String mrnChkNo  = "I".equals(condVO.getIoBndCd())?"I":"E";
		// VALIDATION 변수
		String mrnNo = null;
		String vvd   = null;
		String mrnChk = null;
		// VSL INFO 
//		KorVslCondVO korVslCondVO = new KorVslCondVO();
		// ETA, ETD 
		KorVslSkdVO korVslSkdVO = null;
		KorVslSkdCondVO korVslSkdCondVO = new KorVslSkdCondVO();
		
		
		try {
			
			// MRN 중복 체크 추가(2013.10.23)
			mrnChk = dbDao.searchMrnChk(condVO);
			if (mrnChk != null) throw new EventException(new ErrorHandler("BKG01118").getMessage());
			// 1st VVD 처리
//			condVO.setVvd(condVO.getVvd1());
			// VALIDATION CHECK 1- VVD CHECK			
			mrnNo = dbDao.searchMrnInfoByVVD(condVO);
			if (mrnNo!=null) throw new EventException(new ErrorHandler("BKG01118").getMessage());
			// VALIDATION CHECK 1- MRN CHECK
			vvd = dbDao.searchMrnInfoByMrn(condVO);
			if (vvd!=null)  throw new EventException(new ErrorHandler("BKG01119").getMessage());
			
			// 2nd VVD 처리
//			if (condVO.getVvd2()!=null && condVO.getVvd2().trim().length() > 1) {
//				condVO.setVvd(condVO.getVvd2());
//				// VALIDATION CHECK 1- VVD CHECK
//				mrnNo = dbDao.searchMrnInfoByVVD(condVO);
//				if (mrnNo!=null) throw new EventException(new ErrorHandler("BKG01118").getMessage());
//				// VALIDATION CHECK 1- MRN CHECK
//				vvd = dbDao.searchMrnInfoByMrn(condVO);
//				if (vvd!=null)  throw new EventException(new ErrorHandler("BKG01119").getMessage());
//			}
			
			// VSL INFO 조회
			korVslSkdCondVO.setVvd(condVO.getVvd());
			vvd = dbDao.searchVslSkdInfo(korVslSkdCondVO);
			if (vvd==null) throw new EventException(new ErrorHandler("BKG00007").getMessage());
			
			// 1st VVD 처리
			// ETA, ETD 정보 조회
			korVslSkdCondVO.setVvd(condVO.getVvd());
			korVslSkdCondVO.setPortCd(condVO.getPortCd());
			korVslSkdVO = dbDao.searchETDETA(korVslSkdCondVO);
			// 조회 결과 담기 
			korMrnCreateInfoVO = new KorMrnCreateInfoVO();
			if (korVslSkdVO!=null) {
				korMrnCreateInfoVO.setVpsEtaDt(korVslSkdVO.getVpsEtaDt());
				korMrnCreateInfoVO.setVpsEtdDt(korVslSkdVO.getVpsEtdDt());			
			}else {
				korMrnCreateInfoVO.setVpsEtaDt("");
				korMrnCreateInfoVO.setVpsEtdDt("");
			}
			korMrnCreateInfoVOs.add(korMrnCreateInfoVO);
			// MRN INSERT
			condVO.setMrnChkNo(mrnChkNo);
//			condVO.setVvd(condVO.getVvd1());
					
			// 2nd VVD 처리
//			if (condVO.getVvd2()!=null && condVO.getVvd2().trim().length() > 1) {
//				// ETA, ETD 정보 조회				
//				korVslSkdCondVO.setVvd(condVO.getVvd2());
//				korVslSkdCondVO.setPortCd(condVO.getPortCd());
//				korVslSkdVO = dbDao.searchETDETA(korVslSkdCondVO);
//				// 조회 결과 담기 
//				korMrnCreateInfoVO = new KorMrnCreateInfoVO();
//				if (korVslSkdVO!=null) {
//					korMrnCreateInfoVO.setVpsEtaDt(korVslSkdVO.getVpsEtaDt());
//					korMrnCreateInfoVO.setVpsEtdDt(korVslSkdVO.getVpsEtdDt());
//				}else {
//					korMrnCreateInfoVO.setVpsEtaDt("");
//					korMrnCreateInfoVO.setVpsEtdDt("");
//				}
//				korMrnCreateInfoVOs.add(korMrnCreateInfoVO);
//				// MRN INSERT
//				condVO.setMrnChkNo(mrnChkNo);
//				condVO.setVvd(condVO.getVvd2());
//			}
			
			// EDI 전송
			transmitIFTSAIMessage(condVO, "A");

			return korMrnCreateInfoVOs.toArray(new KorMrnCreateInfoVO[0]);
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListVO
	 * @exception EventException
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
			if (inType==null || "|A|B|C|D|M|T|R".indexOf(inType) < 1 ) inType="N";
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
			if (podTml2 != null && !"".equals(podTml2)){
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
			for(int i=0; i < korAmdBlInfoVOs.length; i++) {
				korAmdBlInfoVO = korAmdBlInfoVOs[i];
				bndCd = korAmdBlInfoVO.getKrCstmsBndCd();

				// OUT BOUND 처리
				if (condVO.getIoBndCd().equals("O")) {
					if (inType.equals("A")) {//A일때 P이면 나가야함 , 그리고 
						if ("P".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
						if (!bndCd.equals("A")) continue;
					}else if (inType.equals("B")) {
						if ("P".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
						if (!bndCd.equals("B")) continue;
					}else if (inType.equals("C")) {
						if (!bndCd.equals("C")) continue;
						korAmdBlInfoVO.setBdAreaCd("");
					}else if (inType.equals("D")) {
						if (bndCd.equals("N")) continue;
						if (bndCd.equals("C")) korAmdBlInfoVO.setBdAreaCd("");
					}else if (inType.equals("M")) {
						if ("F".equals(korAmdBlInfoVO.getBkgCgoTpCd())||"R".equals(korAmdBlInfoVO.getBkgCgoTpCd())||"B".equals(korAmdBlInfoVO.getBkgCgoTpCd())) continue;
					}
				}else {
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
				if (shipChk!=null && shipChk.equals("N")) korAmdBlInfoVO.setSAddr("N");
				
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
						}else {
							korAmdBlInfoVO.setElnoA(elnoInfoCondVO.getCntFlg());
							if (elnoInfoCondVO.getCntrWgt().equals(korAmdBlInfoVO.getCntrChkWgt())) {
								korAmdBlInfoVO.setElnoB("M");
							}else {
								korAmdBlInfoVO.setElnoB("U");
							}
						}
					} else {
						// BL TYPE 이 SIMPLE 이 아닌 경우 처리
						korAmdBlInfoVO.setElnoA("");
						korAmdBlInfoVO.setElnoB("");
					}
				}else {
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
				){
					korAmdBlInfoVO.setErrorCheck("E");					
				}else {
					if (korAmdBlInfoVO.getCstmsDeclTpCd().equals("I") || korAmdBlInfoVO.getCstmsDeclTpCd().equals("T") ) {
						if (korAmdBlInfoVO.getBdAreaCd().equals("N") ||
							korAmdBlInfoVO.getCAddr().equals("N") ||
							korAmdBlInfoVO.getNAddr().equals("N")
						) {
							korAmdBlInfoVO.setErrorCheck("E");
						}else {
							korAmdBlInfoVO.setErrorCheck("N");
						}
					}else {
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
				if (korCntrNoKorVOs!=null) {
					for(int j=0; j < korCntrNoKorVOs.length; j++) {
						korCntrNoKorVOs[j].setBkgCgoTpCd(korAmdBlInfoVO.getBkgCgoTpCd());
						cntrListVOs.add(korCntrNoKorVOs[j]);
					}
				}
				
				listVOs.add(korAmdBlInfoVO);
			}
		
			korManifestListVO.setKorAmdBlInfoVOs(listVOs.toArray(new KorAmdBlInfoVO[0]));
			korManifestListVO.setKorCntrNoKorVOs(cntrListVOs.toArray(new KorCntrNoKorVO[0]));
			
			if (bkgCstmsKrVvdSmryVO!=null) {
				korManifestListVO.setMrnNo		(bkgCstmsKrVvdSmryVO.getMrnNo()		);
				korManifestListVO.setMrnChkNo	(bkgCstmsKrVvdSmryVO.getMrnChkNo()	);
			}else {
				korManifestListVO.setMrnNo		("");
				korManifestListVO.setMrnChkNo	("");
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return korManifestListVO;
	}

	/**
	 * Manifest Transmit Discharge ( 하선신고 ) 
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {
		// 파라메터 변환
		KorDischManifestTransmitVO condVO = (KorDischManifestTransmitVO)dischManifestTransmitVO;
		
		// IN TYPE 처리 
		String inType = condVO.getInType();
		if ("|A|B|C|D|M|T|R".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
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
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// TEU, FEU count 용 객체
		KorCntrCntVO korCntrCntVO = new KorCntrCntVO();
		int teuCnt=0, feuCnt=0;
		
		try {
			
			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLMM010", "KTNETMFCSS", "CUSAGD");
			flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
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
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType		(condVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()		);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			// 로그 기록
			dbDao.addDiscSndLog(bkgCstmsKrSndLogVO);
			
			// DETAIL LOG 기록
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addDiscHeadSndDtlLog(bkgCstmsKrSndLogDtlVO);

			if(!"E".equals(condVO.getNoneBlInType())){

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
				for(int i=0; i < korDiscFlatFileVOs.length; i++) {
					korDiscFlatFileVO = korDiscFlatFileVOs[i];
					// FlatFile 만들기
					arTemp = korDiscFlatFileVO.getBlData().split("~",100);
					
					tempData.setLength(0);
					k=0;
					
					tempData.append("{BL_CNTR").append("\n");
					tempData.append("BLNBR:").append(arTemp[k++]).append("\n");
					tempData.append("T_REF_NO:").append(arTemp[k++]).append("\n");
					tempData.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
					tempData.append("CARRYIN_AREA_CODE:").append(arTemp[k++]).append("\n");
					tempData.append("CARRYIN_AREA_NM1:").append(arTemp[k++]).append("\n");
					tempData.append("CARRYIN_AREA_NM2:").append("\n");
					tempData.append("CARRYIN_AREA_NM3:").append("\n");
					tempData.append("PKG:").append(arTemp[k++].replaceAll(",","")).append("\n");
					tempData.append("PKGU:").append(arTemp[k++]).append("\n");
					tempData.append("WGT:").append(arTemp[k++].replaceAll(",","")).append("\n");
					
					// BODY SEND LOG 기록
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg(tempData.toString());
					dbDao.addDiscBodySendDtlLog(bkgCstmsKrSndLogDtlVO);
					// FLATFILE BODY 추가
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
						
						if (korCntrCntVO!=null) {
							// COUNT 누적
							teuCnt = teuCnt + Integer.parseInt(korCntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(korCntrCntVO.getFeuCnt());
						}
					}
				
					// CONTAINER LOOP				
					if (cntrDatas!=null) {
						for(int j=0; j < cntrDatas.length; j++) {
							// TEMP 에 추가
							tempData.setLength(0);
							tempData.append("{CNTR_INFO").append("\n");
							tempData.append("CNTRNBR:").append(cntrDatas[j]).append("\n");
							tempData.append("}CNTR_INFO").append("\n");
							// Container Send Log 추가
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(tempData.toString());				
							dbDao.addDiscCNTRSendDtlLog(bkgCstmsKrSndLogDtlVO);
							// flatFile Body 에 추가
							flatFileBody.append(tempData);
	
						}
					}				
	
					// FLATFILE FOOTER 생성			
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg("}BL_CNTR\n");
					flatFileBody.append(bkgCstmsKrSndLogDtlVO.getEdiSndMsg());
					
					// End Send Log 추가 
					dbDao.addDiscEndSendDtlLog(bkgCstmsKrSndLogDtlVO);
				}
			}
			
			// 전송 로그 업데이트
			bkgCstmsKrSndLogVO.setTeuCnt(String.valueOf(teuCnt));
			bkgCstmsKrSndLogVO.setFeuCnt(String.valueOf(feuCnt));
			dbDao.modifyDiscSndLog(bkgCstmsKrSndLogVO);
			
			// FLATFILE 조립 
			flatFile.append(flatFileBody);
			
			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			
			return flatFile.toString();
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
	}
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo )  throws EventException{
		
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_0344")) {
			KorCustomsTransmissionBackEndJob backEndJob = new KorCustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setManifestTransmitVO(manifestTransmitVO);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "KOR EDI Transmit");
		} 
		
		return resultStr;
	}
	

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {
		// FLATFILE 
		StringBuffer flatFile = new StringBuffer();
		String fltFileRefNo = null;
		String[] arTemp = null;
		StringBuffer bfTemp = new StringBuffer();
		int k=0;
		
		// 파라메터 변환
		KorManifestTransmitVO condVO = (KorManifestTransmitVO)manifestTransmitVO;
		
		// POD TML 생성
		//String podTml = condVO.getPodCd() + condVO.getTmlCd();
		
		String podTml = "";
		if (condVO.getTmlCd()!=null && condVO.getTmlCd().length() > 0 && condVO.getPodCd() != null && condVO.getPodCd().length() >0){				
			podTml = condVO.getPodCd() + condVO.getTmlCd();
		}

		if (condVO.getTmlCd()!=null && condVO.getTmlCd().length() > 0 && condVO.getPolCd() != null && condVO.getPolCd().length() >0){
			podTml = condVO.getPolCd() + condVO.getTmlCd();
		}
		
		
		
		
		
		// IN TYPE 처리 
		String inType = condVO.getInType();
		if ("|A|B|C|D|M|T|R".indexOf(inType) < 1) inType = "N";
		
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
			portCd = condVO.getPolCd();
		}
		
		// Bond Code Update 용 객체
		BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
		// VVD SEND UPDATE 용 객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
		// PORT 검색결과
		String unPolCd = null;
		String unPodCd = null;
		String delCd = null; 
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
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// TEU, FEU COUNT 용 객체
		KorCntrCntVO cntrCntVO = new KorCntrCntVO();
		// Export License 객체
		String[] elDatas = null;
		// Container 객체
		String[] cntrDatas = null;
		// Seal Number 관련
		String tempSealNumber = null;
		String[] sealNumbers = null;
		// 송수신처 
		String sender = ""; 
		String receiver = "";
		
		// TEU,FEU 누적용 변수
		int teuCnt = 0;
		int feuCnt = 0;
		
		// SEND DATE
		String sndDt = null;
		
		try {
			
			bkgCstmsKrBlVO.setVvd		(condVO.getVvd()	);
			bkgCstmsKrBlVO.setPortCd	(portCd				);
			bkgCstmsKrBlVO.setInType	(inType				);
			bkgCstmsKrBlVO.setIoBndCd	(condVO.getIoBndCd());
			bkgCstmsKrBlVO.setPolCd		(condVO.getPolCd()	);
			bkgCstmsKrBlVO.setPodCd		(condVO.getPodCd()	);
			bkgCstmsKrBlVO.setPodTml	(podTml				);
			bkgCstmsKrBlVO.setUserId	(condVO.getUserId()	);
			
			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			
			// UNLOCODE 조회
			if (condVO.getIoBndCd().equals("O")) {
				// OUT-BOUND 처리
				unPolCd = dbDao.searchOBUNLocCd(condVO.getPolCd());
			}else {
				// IN-BOUND 처리
				unPodCd = dbDao.searchIBUNLocCd(condVO.getPodCd());
			}
			
			// 일괄삭제후 재전송일 경우
			if (condVO.getInReceiver().equals("1")) resndChk = "P";
			
			// 송수신처 판단
			sender 	= "SSSMLMM010";
			receiver = "KTNETULHS4G";
			// 공동 VVD 인 경우
/*			if("E".equals(condVO.getNoneBlInType())){
				sender = "SSSMLMM010"; receiver = "KTNETMFCSS";
			}			
			
			if (resndChk!=null && resndChk.equals("P")) sender = "SMLM0001";
			if (resndChk!=null && resndChk.equals("P")) {  // 항만청 전송시
				if (condVO.getKtPa().equals("020") || condVO.getKtPa().equals("20") || condVO.getKtPa().equals("820")) {
					receiver = "KMPAE010";
				}else if (condVO.getKtPa().equals("030") || condVO.getKtPa().equals("30") || condVO.getKtPa().equals("031") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("050") || condVO.getKtPa().equals("50")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}*/
			
			// 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "CUSREP");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
			// flatFile 에 추가
			flatFile.append(flatFileHeader).append("\n");

			// FLATFILE 헤더 생성
			korCusrepVO.setResndChk			(resndChk					);
			korCusrepVO.setKtPa				(condVO.getKtPa()			);
			korCusrepVO.setIoBndCd			(condVO.getIoBndCd()		);
			korCusrepVO.setLoclCstmsCd		(condVO.getLoclCstmsCd()	);
			korCusrepVO.setLoclCstmsPrtCd	(condVO.getLoclCstmsPrtCd()	);
			korCusrepVO.setVslCntCd			(condVO.getVslCntCd()		);
			korCusrepVO.setVslNm			(condVO.getVslNm()			);
			korCusrepVO.setVslCallSgnCd		(condVO.getVslCallSgnCd()	);
			korCusrepVO.setMrnNo			(condVO.getMrnNo()			);
			korCusrepVO.setVvd				(condVO.getVvd()			);
			korCusrepVO.setUnPodCd			(unPodCd					);
			korCusrepVO.setUnPolCd			(unPolCd					);
			korCusrepVO.setPolCd			(condVO.getPolCd()			);
			korCusrepVO.setPodCd			(condVO.getPodCd()			);
			korCusrepVO.setEtaDt			(condVO.getEtaDt()			);
			korCusrepVO.setEtdDt			(condVO.getEtdDt()			);
			korCusrepVO.setMsnNo			(condVO.getJoCrrKnt()		);
			korCusrepVO.setInType			(inType						);
			korCusrepVO.setVvdSeq			(condVO.getVvdSeq()			);
			korCusrepVO.setCallKnt			(condVO.getCallKnt());
			korCusrepVO.setDelCd			(condVO.getDelCd()			);

			// 헤더 추가정보 생성
			// 공동 VVD 인 경우
			if("E".equals(condVO.getNoneBlInType())){
				// Out bound 일때만 inType = 'E'로 세팅.
				if (condVO.getIoBndCd().equals("O")) {
					korCusrepVO.setInType(condVO.getNoneBlInType());
				}
				flatFileHeader = dbDao.makeCUSREPNoneBLVVDFlatFile(korCusrepVO);
			} else {
			// 일반 헤더 파일
				flatFileHeader = dbDao.makeCUSREPFlatFile(korCusrepVO);
			}
			arTemp = flatFileHeader.split("~",100);
			
			k=0;
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
			bfTemp.append("SENDDATE:").append(arTemp[k++]).append("\n");
			bfTemp.append("SENDTIME:").append(arTemp[k++]).append("\n");
			bfTemp.append("PARTY:").append(arTemp[k++]).append("\n");
			bfTemp.append("POL:").append(arTemp[k++]).append("\n");
			bfTemp.append("POD:").append(arTemp[k++]).append("\n");
			
			delCd =dbDao.searchDelCd(condVO.getVvd(),condVO.getPolCd());
			bfTemp.append("DEL:").append(delCd).append("\n");
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
			bfTemp.append("AGENCY1:").append(arTemp[k++]).append("\n");
			bfTemp.append("AGENCY2:").append(arTemp[k++]).append("\n");
			bfTemp.append("AGENCY3:").append(arTemp[k++]).append("\n");
			bfTemp.append("INPORT_YYYY:").append(arTemp[k++]).append("\n");
			bfTemp.append("INPORT_CNT:").append(arTemp[k++].replaceAll(",","")).append("\n");
			bfTemp.append("PORT_AUTH:").append(arTemp[k++]).append("\n");
			bfTemp.append("VSLCOM_CODE:").append(arTemp[k++]).append("\n");
			bfTemp.append("}MASTER").append("\n");
			
			flatFile.append(bfTemp);
			
			flatFileHeader = flatFile.toString();
			
			// Send Data 생성
			sndDt = dbDao.searchSysDate();
			
			// 전송 로그 기록
			bkgCstmsKrSndLogVO.setIoBndCd		(condVO.getIoBndCd()	);
			bkgCstmsKrSndLogVO.setSndDt			(sndDt					);
			bkgCstmsKrSndLogVO.setOfcCd			(condVO.getOfcCd()		);
			bkgCstmsKrSndLogVO.setFltFileRefNo	(fltFileRefNo			);
			bkgCstmsKrSndLogVO.setUserId		(condVO.getUserId()		);
			bkgCstmsKrSndLogVO.setVvd			(condVO.getVvd()		);
			bkgCstmsKrSndLogVO.setPolCd			(condVO.getPolCd()		);
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()		);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType		(condVO.getNoneBlInType());
			} else {
				bkgCstmsKrSndLogVO.setInType		(inType					);
			}
			bkgCstmsKrSndLogVO.setBlKnt			(condVO.getMstBlKnt()	);
			bkgCstmsKrSndLogVO.setResndChk		(resndChk				);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()		);
			// 로그기록
			dbDao.addCUSREPSndLog(bkgCstmsKrSndLogVO);
			
			// 전송 세부 로그 기록
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addCUSREPSndDtlLog(bkgCstmsKrSndLogDtlVO);
			
			// FLATFILE BODY 생성시작
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "CUSMAN");
			flatFileHeader = flatFileHeader.substring(0, flatFileHeader.indexOf("BKC")) + fltFileRefNo;
			
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if(!"E".equals(condVO.getNoneBlInType())){

				korCusmanVO.setResndChk	(resndChk				);
				korCusmanVO.setKtPa		(condVO.getKtPa()		);
				korCusmanVO.setIoBndCd	(condVO.getIoBndCd()	);
				korCusmanVO.setMrnNo	(condVO.getMrnNo()		);
				korCusmanVO.setD2Cnt	(condVO.getTtlLcTeuQty());
				korCusmanVO.setD4Cnt	(condVO.getTtlTsTeuQty());
				korCusmanVO.setDiscMdCd	(condVO.getDchgMzdCd()	);
				korCusmanVO.setIoQuay	(condVO.getIoTmlLocCd()	);
				korCusmanVO.setVvd		(condVO.getVvd()		);
				korCusmanVO.setBlNo		(condVO.getBlNo()		);
				korCusmanVO.setPortCd	(portCd					);
				korCusmanVO.setInType	(inType					);
				korCusmanVO.setPodCd	(condVO.getPodCd()		);
				korCusmanVO.setPolCd	(condVO.getPolCd()		);
				korCusmanVO.setPortTmlCd(podTml					);
				korCusmanVOs = dbDao.makeCUSMANBlFlatFile(korCusmanVO);
			
				if (korCusmanVOs==null) throw new EventException(new ErrorHandler("BKG00889").getMessage()); 
			
				// BODY LOOP ( CUSMAN )
				for(int i=0; i < korCusmanVOs.length; i++) {
					// DETAIL 전송 로그 기록
					bfTemp.setLength(0);
					k=0;
					arTemp = korCusmanVOs[i].getBlData().split("~",200);
					
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
					bfTemp.append("BOND_AREA_CODE:").append(arTemp[k++]).append("\n");
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
					
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg(bfTemp.toString());
					dbDao.addCUSMANSndDtlLog(bkgCstmsKrSndLogDtlVO);
					
					// TEU, FEU CNT 조회
					cntrCntVO = new KorCntrCntVO();
					teuCnt = 0;
					feuCnt = 0;
					// 중복 제거
					if (i == 0 || !korCusmanVOs[i-1].getBkgNo().equals(korCusmanVOs[i].getBkgNo())) {
						cntrCntVO.setCstmsDeclTpCd	(korCusmanVOs[i].getCstmsDeclTpCd()	);
						cntrCntVO.setBkgNo			(korCusmanVOs[i].getBkgNo()			);
						cntrCntVO.setPortCd			(korCusmanVOs[i].getPortCd()		);
						cntrCntVO = dbDao.searchTeuFeuCnt(cntrCntVO);								
						// TEU, FEU CNT 누적
						if (cntrCntVO!=null) {
							teuCnt = teuCnt + Integer.parseInt(cntrCntVO.getTeuCnt());
							feuCnt = feuCnt + Integer.parseInt(cntrCntVO.getFeuCnt());
						}
					}
					// FLATFILE 합치기
					flatFileBody.append(bfTemp);
					korCusmanVOs[i].setVvd(condVO.getVvd());
					// SC_DIV 가 'C'가 아닌것만 ELNO FLATFILE 생성
					if (!korCusmanVOs[i].getScDiv().equals("C")) {
						// Export License FlatFile 생성 ( EXPORT )
						elDatas = dbDao.makeCUSMANExpFlatFile(korCusmanVOs[i]);
						// LOOP
						if (elDatas!=null) {
							
							for(int j=0; j < elDatas.length; j++) {
								flatFileExport.setLength(0);
								k=0;
								
								arTemp = elDatas[j].split("~",100);
								
								flatFileExport.append("{KCS_EXNO").append("\n");
								flatFileExport.append("B_EXNO:").append(arTemp[k++].replaceAll("-", "")).append("\n");
								if (!"".equals(condVO.getPolCd()) && condVO.getPolCd()!= null){
								flatFileExport.append("B_UCRNO:").append(arTemp[k++]).append("\n");
								}
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
								
								// Export License 전송로그 기록
								if (flatFileExport!=null) bkgCstmsKrSndLogDtlVO.setEdiSndMsg(flatFileExport.toString());
								dbDao.addCUSMANExpSndDtlLog(bkgCstmsKrSndLogDtlVO);
								
								flatFileBody.append(flatFileExport);
							}
						} // END LOOP
					}
					
					// Container FlatFile 생성
					cntrDatas = dbDao.makeCUSMANCntrFlatFile(korCusmanVOs[i]);
					if (cntrDatas!=null) {					
						// LOOP
						for(int j=0; j < cntrDatas.length; j++) {
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
							if (tempSealNumber!=null) {
								sealNumbers = tempSealNumber.split("~",100);
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[0]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("{CNTR_SEAL_NO").append("\n");
								flatFileCNTR.append("CNTR_SEAL:").append(sealNumbers[1]).append("\n");
								flatFileCNTR.append("}CNTR_SEAL_NO").append("\n");
							}
							
							flatFileCNTR.append("}CNTR_INFO").append("\n");
							
							// Container 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(flatFileCNTR.toString());
							dbDao.addCUSMANCNTRSndDtlLog(bkgCstmsKrSndLogDtlVO);
	
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
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_MNFT.IBMMQ.QUEUE");
		
			return flatFile.toString();
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
	}

	/**
	 * Trans Amendment To PA 
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @exception EventException
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
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";
		String subNo = null;

		try {

			// 수신처 판단
			if (condVO.getKtPa()!=null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020")  || condVO.getKtPa().equals("820")) {  //부산, 울산
					receiver = "BPAED020";
				}else if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLM0001", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
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
			if("E".equals(condVO.getNoneBlInType())){
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
			/***** 3세대
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
			***/
			
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
			
			bfTemp.append("DISC_CO_CD:").append(condVO.getCstmsDchgCd()).append("\n");
			k++; // 하역회사 화면에서 넘어오는 값으로 대체
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");
			
			flatFile.append(bfTemp);
			
			flatFileHeader = flatFile.toString(); 
			
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
			// 로그에 POD 추가
			bkgCstmsKrSndLogVO.setPodCd			(condVO.getPodCd()	);
			bkgCstmsKrSndLogVO.setBlNo			(condVO.getBlNo()	);
			bkgCstmsKrSndLogVO.setKtPa			(condVO.getKtPa()	);
			// 공동 VVD 인 경우에는 Type 을 'E'로 설정
			if("E".equals(condVO.getNoneBlInType())){
				bkgCstmsKrSndLogVO.setInType(condVO.getNoneBlInType());
			}

			// 로그 기록
			dbDao.addMACAMDModiDelSndLog(bkgCstmsKrSndLogVO);
			
			// Detail 로그 및 FlatFile 내용 저장 
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addMACAMDModiDelSndDtlLog(bkgCstmsKrSndLogDtlVO);
			
			// 정정부호에 따른 처리 (ZD 가 존재하면 나머지 코드는 무시)
			if (condVO.getCancelFlg()!=null && condVO.getCancelFlg().equals("ZD")) {
				corrCodes[0] = condVO.getCancelFlg();		// ZD
				mdatas[0]    = "";
			}else {
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
			for(int i=0; i < corrCodes.length; i++) {
				
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
				
				// 정정부호 전송 내역을 Detail LOG Table로 전송일 및 Flat File 내용 저장
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg(bfTemp.toString());
				dbDao.addMACAMDModiCdSndDtlLog(bkgCstmsKrSndLogDtlVO);
				
				flatFileBody.append(bfTemp);
			}
			
			// FLATFILE 조립
			flatFile.append(flatFileBody);
			
			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			
			
			// InBound 이고 ETA 항목 변경시 EDI 전송
			if (condVO.getIoBndCd().equals("I") && condVO.getInChgEta().equals("AI")) {
								
				flatFile.setLength(0);
				flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "IMFMOD");
				fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
				
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
				korImfmodVO.setKrCstmsCorrId("01"					); //Correction Code 변경
				korImfmodVO.setCorrRsn		("사무착오"				);
				korImfmodVO.setSubNo		(subNo					);
				korImfmodVO.setCntrTtlWgt	(condVO.getTtlWgt().replaceAll(",", ""));
				korImfmodVO.setMeasQty		(condVO.getTtlMeasQty().replaceAll(",", ""));

				/*
				 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
				 */
				if( checkRevenueEmpty(korImfmodVO.getBkgCgoTpCd(), korImfmodVO.getKrCstmsBlTpCd()) ) {
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
				bfTemp.append("SENDER1:").append(arTemp[k++]).append("\n");
				bfTemp.append("SENDER2:").append(arTemp[k++]).append("\n");
				bfTemp.append("SENDER3:").append(arTemp[k++]).append("\n");
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
				bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
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
				bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");
				
				// FlatFile 합치기
				flatFile.append(flatFileHeader).append("\n");
				flatFile.append(bfTemp);
				
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
				dbDao.addIMFMODSndLog(bkgCstmsKrSndLogVO);
				
				// 전송 세부 로그 기록
				bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt						);
				bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()			);
				bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo				);
				bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()			);
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFile.toString()		);
				dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
				
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
				
				// 전송 로그 기록
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg(imfmodBLCorrFlatFile);
				dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
				
				// flatFile 전송
				ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
				
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return subNo;
	}

	/**
	 * Amendment Transmit 전송 (FlatFile Return)
	 * @param AmdManifestTransmitVO amdManifestTransmitVO
	 * @return String
	 * @exception EventException
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
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
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
			if (korBlAmdVO.getTransChk()!=null && korBlAmdVO.getTransChk().equals("Y")) {
				throw new EventException(new ErrorHandler("BKG01114", new String[] {korBlAmdVO.getSubNo()}).getMessage());				
			}
			if (korBlAmdVO.getSubNo()==null || korBlAmdVO.getSubNo().trim().length() < 1) {
				throw new EventException(new ErrorHandler("BKG01115").getMessage());
			}
			
			// Transmit Check
			transChk = dbDao.searchTransmitChk(korBlAmdVO.getSubNo());
			if (transChk!=null && transChk.equals("Y")) {
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
			}else {
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
					if (korCntrCorrVOs!=null) korCusmodVO.setCntrCnt(String.valueOf(korCntrCorrVOs.length));
					
					// flatFile Header 생성
					flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "CUSMOD");
					// REF_NO 추출					
					flatFileRefNo = flatFileHeader.trim().substring(flatFileHeader.indexOf("BKC"));
					
					// flatFile 에 추가
					flatFile.append(flatFileHeader).append("\n");
					
					/*
					 * Revenue Empty이면서 kr_cstms_bl_tp_cd가   S(Simple) 이나 C(Consol) 이면 "E"로 변환
					 */
					if( checkRevenueEmpty(korBlAmdVO.getBkgCgoTpCd(), korCusmodVO.getKrCstmsBlTpCd()) ) {
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
					flatFile.append("SHPR_NM1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR_NM2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR_NM3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR5:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR_CITY_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("SHPR_CNT_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("STEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE_NM1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE_NM2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE_NM3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE5:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE_CITY_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CNEE_CNT_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("CTEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY_NM1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY_NM2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY_NM3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY1:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY2:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY3:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY4:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY5:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY_CITY_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTFY_CNT_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("NTEL:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("FFORD_CD:").append(cusmodFlatFileSplit[k++]).append("\n");
					flatFile.append("BOND_AREA_CODE:").append(cusmodFlatFileSplit[k++]).append("\n");
//					2011. 11. 30 임시로 주석처리 => 	[CHM-201114372-01] 한국 적하목록 LIVE 태깅시 주석 풀기				
//					flatFile.append("UCTNO:").append(cusmodFlatFileSplit[k++]).append("\n");
					if (!"".equals(korBlAmdVO.getPolCd()) && korBlAmdVO.getPolCd()!= null){
					flatFile.append("UCRNO:").append(cusmodFlatFileSplit[k++]).append("\n");
					}
					cusmodFlatFile = flatFile.toString();
					
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
					dbDao.addCUSMODSndLog(bkgCstmsKrSndLogVO);
					
					// 세부 전송 로그 기록
					bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt							);
					bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()				);
					bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo					);
					bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()				);
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(cusmodFlatFile					);
					dbDao.addCUSMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
					
					// Export TAB 처리
					if (korExpCorrVOs!=null) {
						// LOOP
						for(int i=0; i < korExpCorrVOs.length; i++) {
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
							bfTemp.append("E_COR_REA1:").append(arTemp[k++]).append("\n");
							bfTemp.append("E_COR_REA2:").append(arTemp[k++]).append("\n");
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
							
							// 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(cusmodExpFlatFile);
							dbDao.addCUSMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
							
							// flatFile 합치기
							flatFile.append(cusmodExpFlatFile);
						}
					}
					
					// Container Tab 처리
					if (korCntrCorrVOs!=null) {
						for(int i=0; i < korCntrCorrVOs.length; i++) {
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
							bfTemp.append("C_COR_REA1:").append(arTemp[k++]).append("\n");
							bfTemp.append("C_COR_REA2:").append(arTemp[k++]).append("\n");
							bfTemp.append("SEALNBR:").append(arTemp[k++]).append("\n");
							// SEAL Number 추가
							if (korCusmodVO.getCntrSealNo1()!=null && korCusmodVO.getCntrSealNo1().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korCusmodVO.getCntrSealNo1()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							if (korCusmodVO.getCntrSealNo2()!=null && korCusmodVO.getCntrSealNo2().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");							
								bfTemp.append("CNTR_SEAL:").append(korCusmodVO.getCntrSealNo2()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							bfTemp.append("}CNTR_INFO").append("\n");
							
							cusmodCntrFlatFile = bfTemp.toString();
							
							// 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(cusmodCntrFlatFile);
							dbDao.addCUSMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
							
							// flatFile 합치기
							flatFile.append(cusmodCntrFlatFile);
						}
					}
					flatFile.append("}BL_CNTR").append("\n");
					
					
					// CORRECTION CODE 가 D나 F가 아닌 경우 처리
					if (!korBlAmdVO.getKrCstmsCorrId().equals("03") && !korBlAmdVO.getKrCstmsCorrId().equals("04")) {
						
						// VVD-B/L Corr TAB 처리
						if (korCorrListVOs!=null) {
							
							for(int i=0; i < korCorrListVOs.length; i++) {
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
								bfTemp.append("U_COR_REA1:").append(arTemp[k++]).append("\n");
								bfTemp.append("U_COR_REA2:").append(arTemp[k++]).append("\n");
								bfTemp.append("}UNIT_MODI").append("\n");
								
								cusmodBlCorrFlatFile = bfTemp.toString();
								
								// 전송 로그 기록
								bkgCstmsKrSndLogDtlVO.setEdiSndMsg(cusmodBlCorrFlatFile);
								dbDao.addCUSMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
								
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
				ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
				
			}else {
				// IN BOUND의 경우
				
				// RECEIVER 가 C 이거나 A 면 IMFMOD 생성
				if (korBlAmdVO.getTransDmr().equals("N") && ( korBlAmdVO.getAmdtRcvrFlg().equals("C") || korBlAmdVO.getAmdtRcvrFlg().equals("A") ) ) {
					
					// flatFile Header 생성
					flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "IMFMOD");	
					
					// REF_NO 추출
					flatFileRefNo = flatFileHeader.trim().substring(flatFileHeader.indexOf("BKC"));
					
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
					if( checkRevenueEmpty(korImfmodVO.getBkgCgoTpCd(), korImfmodVO.getKrCstmsBlTpCd()) ) {
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
					bfTemp.append("SENDER1:").append(arTemp[k++]).append("\n");
					bfTemp.append("SENDER2:").append(arTemp[k++]).append("\n");
					bfTemp.append("SENDER3:").append(arTemp[k++]).append("\n");
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
					bfTemp.append("CBIZNO:").append(arTemp[k++]).append("\n");
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
					bfTemp.append("NBIZNO:").append(arTemp[k++]).append("\n");
					
					imfModBlFlatFile = flatFileHeader +"\n"+ bfTemp.toString();
					
					// FlatFile 합치기
					flatFile.append(imfModBlFlatFile);
					
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
					dbDao.addIMFMODSndLog(bkgCstmsKrSndLogVO);
					
					// 전송 세부 로그 기록
					bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt							);
					bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()				);
					bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo					);
					bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()				);
					bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(imfModBlFlatFile				);
					dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
					
					// Container Tab 처리
					if (korCntrCorrVOs!=null) {
						for(int i=0; i < korCntrCorrVOs.length; i++) {
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
							if (korImfmodVO.getCntrSealNo1()!=null && korImfmodVO.getCntrSealNo1().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");
								bfTemp.append("CNTR_SEAL:").append(korImfmodVO.getCntrSealNo1()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							if (korImfmodVO.getCntrSealNo2()!=null && korImfmodVO.getCntrSealNo2().length() > 0) {
								bfTemp.append("{CNTR_SEAL_NO").append("\n");							
								bfTemp.append("CNTR_SEAL:").append(korImfmodVO.getCntrSealNo2()).append("\n");
								bfTemp.append("}CNTR_SEAL_NO").append("\n");
							}
							bfTemp.append("}CNTR_INFO").append("\n");
							
							imfmodCntrFlatFile = bfTemp.toString();
							
							// 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(imfmodCntrFlatFile);
							dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
							
							// flatFile 합치기
							flatFile.append(imfmodCntrFlatFile);
						}
					}
					
					// VVD-B/L Corr TAB 처리
					if (korCorrListVOs!=null) {
						
						for(int i=0; i < korCorrListVOs.length; i++) {
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
							
							// 전송 로그 기록
							bkgCstmsKrSndLogDtlVO.setEdiSndMsg(imfmodBLCorrFlatFile);
							dbDao.addIMFMODSndDtlLog(bkgCstmsKrSndLogDtlVO);
							
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
					ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
					
				}
			}
			
			// RECEIVER 가 P 이거나 A 이면 MACAMD 생성
			if (korBlAmdVO.getTransDmr().equals("N") && ( korBlAmdVO.getAmdtRcvrFlg().equals("P") || korBlAmdVO.getAmdtRcvrFlg().equals("A")) ) {
			
				// flatFile 초기화
				flatFile.setLength(0);
				// 수신처
				String receiver = null;
				if (korBlAmdVO.getKrPortAuthCd().equals("020") || korBlAmdVO.getKrPortAuthCd().equals("20") || korBlAmdVO.getKrPortAuthCd().equals("820")) {  // 부산, 울산
					receiver = "BPAED020";
				}else if (korBlAmdVO.getKrPortAuthCd().equals("030") || korBlAmdVO.getKrPortAuthCd().equals("031") || korBlAmdVO.getKrPortAuthCd().equals("016") 
						|| korBlAmdVO.getKrPortAuthCd().equals("30") || korBlAmdVO.getKrPortAuthCd().equals("31") || korBlAmdVO.getKrPortAuthCd().equals("16")) {
					receiver = "KMPAE030";
				}else if (korBlAmdVO.getKrPortAuthCd().equals("622")) {
					receiver = "KMPAE050";
				}
				// flatFile Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLM0001", receiver, "MACAMD");
				// REF_NO 추출
				flatFileRefNo = flatFileHeader.trim().substring(flatFileHeader.indexOf("BKC"));
				
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
				if( checkRevenueEmpty(korMacamdVO.getBkgCgoTpCd(), korMacamdVO.getKrCstmsBlTpCd()) ) {
					korMacamdVO.setKrCstmsBlTpCd("E");
				}
				if( "P".equals(korBlAmdVO.getAmdtRcvrFlg()) && "03".equals(korBlAmdVO.getKrCstmsCorrId()) ){
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
				/**** 3세대
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
				***/
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
				
				bfTemp.append("DISC_CO_CD:").append(arTemp[k++]).append("\n");
				bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");
				
				macamdFlatFile = flatFileHeader +"\n"+ bfTemp.toString();
				
				// FlatFile 합치기
				flatFile.append(macamdFlatFile);
				
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
				dbDao.addMACAMDSndLog(bkgCstmsKrSndLogVO);
				
				// 전송 세부 로그 기록
				bkgCstmsKrSndLogDtlVO.setIoBndCd		(korBlAmdVO.getIoBndCd()		);
				bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt							);
				bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()				);
				bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo					);
				bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()				);
				bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(macamdFlatFile					);
				dbDao.addMACAMDSndDtlLog(bkgCstmsKrSndLogDtlVO);
				
				// Container Tab 처리
				if (korCntrCorrVOs!=null) {
					for(int i=0; i < korCntrCorrVOs.length; i++) {
						// 정정사항이 있는 경우에만 처리
						if (korCntrCorrVOs[i].getKrCstmsCorrId()==null || korCntrCorrVOs[i].getKrCstmsCorrId().trim().length() < 1 ) continue;
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
						if (korMacamdVO.getCntrSealNo1()!=null && korMacamdVO.getCntrSealNo1().length() > 0) {
							bfTemp.append("{CNTR_SEAL_NO").append("\n");
							bfTemp.append("CNTR_SEAL:").append(korMacamdVO.getCntrSealNo1()).append("\n");
							bfTemp.append("}CNTR_SEAL_NO").append("\n");
						}
						if (korMacamdVO.getCntrSealNo2()!=null && korMacamdVO.getCntrSealNo2().length() > 0) {
							bfTemp.append("{CNTR_SEAL_NO").append("\n");							
							bfTemp.append("CNTR_SEAL:").append(korMacamdVO.getCntrSealNo2()).append("\n");
							bfTemp.append("}CNTR_SEAL_NO").append("\n");
						}
						bfTemp.append("}CNTR_INFO").append("\n");
						
						macamdCntrFlatFile = bfTemp.toString();
						
						// 전송 로그 기록
						bkgCstmsKrSndLogDtlVO.setEdiSndMsg(macamdCntrFlatFile);
						dbDao.addMACAMDSndDtlLog(bkgCstmsKrSndLogDtlVO);
						
						// flatFile 합치기
						flatFile.append(macamdCntrFlatFile);
					}
				}				
				
				// VVD-B/L Corr TAB 처리
				if (korCorrListVOs!=null) {
					
					for(int i=0; i < korCorrListVOs.length; i++) {
						// 정정사항이 있는 경우만 처리(BT제외)
						if (korCorrListVOs[i].getKrCstmsCorrId()==null || korCorrListVOs[i].getKrCstmsCorrId().trim().length() < 1
						    || korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BT")) continue;
						
											
						// FlatFile 생성
						ObjectCloner.build(korCorrListVOs[i], korMacamdVO);
						
						// CUSMOD의 CORR값과 MACAMD의 CORR 값이 달라짐.: 4세대
						if (korBlAmdVO.getIoBndCd().equals("I")) {
							if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BF")) {
								korMacamdVO.setKrCstmsCorrId("ZA3");								
							} 
							
						} else {
							if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BF")) {
								korMacamdVO.setKrCstmsCorrId("ZA3");								
							} else if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BM")) {
								korMacamdVO.setKrCstmsCorrId("ZB1");	
							} else if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BH")) {
								korMacamdVO.setKrCstmsCorrId("CB");	
							} else if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("BJ")) {
								korMacamdVO.setKrCstmsCorrId("CC");	
							} 
						}
						
						// 용적단위코드를 변경
						if (korCorrListVOs[i].getKrCstmsCorrId().equalsIgnoreCase("ZA4")) {
							if (korMacamdVO.getCrntCtnt1().equals("M")) {
								korMacamdVO.setCrntCtnt1("6Q8");
							} else if (korMacamdVO.getCrntCtnt1().equals("B")) {
								korMacamdVO.setCrntCtnt1("BLL");
							} 
							
							if (korMacamdVO.getCrntCtnt2().equals("M")) {
								korMacamdVO.setCrntCtnt2("6Q8");
							} else if (korMacamdVO.getCrntCtnt2().equals("B")) {
								korMacamdVO.setCrntCtnt2("BLL");
							} 
						}
						
						// 화면상에서는 변경후 값이 CrntCtnt2 로 사용되기때문에
						// MACAMD를 전송할때는 CrntCtnt1 값으로 바꾸고 이값을 1~4줄로 표현한다.
						if (korMacamdVO.getCrntCtnt2().length() > 0) {
							korMacamdVO.setCrntCtnt1(korMacamdVO.getCrntCtnt2());
							korMacamdVO.setCrntCtnt2("");
						}
						
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
						
						// 전송 로그 기록
						bkgCstmsKrSndLogDtlVO.setEdiSndMsg(macamdCorrFlatFile);
						dbDao.addMACAMDSndDtlLog(bkgCstmsKrSndLogDtlVO);
						
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
				ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
				
			}
			
			// Receiver 가 ALL 이고 Inbound 인 경우 BondAreaCode Check
			if (korBlAmdVO.getTransDmr().equals("Y") && korBlAmdVO.getAmdtRcvrFlg().equals("A") && korBlAmdVO.getIoBndCd().equals("I")) {
				
				// 정정 내역 LOOP
				if (korCorrListVOs!=null) {
					
					for(int i=0; i < korCorrListVOs.length; i++) {
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
						flatFileHeader = bookingUtil.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "CUSDMR");
						// REF_NO 추출
						flatFileRefNo = flatFileHeader.trim().substring(flatFileHeader.indexOf("BKC"));
						
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
						bfTemp.append("SENDER1:"+arTemp[k++]).append("\n");
						bfTemp.append("SENDER2:"+arTemp[k++]).append("\n");
						bfTemp.append("SENDER3:"+arTemp[k++]).append("\n");
						
						flatFile.append(flatFileHeader).append("\n");
						flatFile.append(bfTemp);
						
						// CUSDMR EDI 전송
						ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
						
						// LOG 기록
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
						dbDao.addCUSDMRSndLog(bkgCstmsKrSndLogVO);
						
						// 전송 세부 로그 기록
						bkgCstmsKrSndLogDtlVO.setIoBndCd		(korBlAmdVO.getIoBndCd()		);
						bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt							);
						bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()				);
						bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(flatFileRefNo					);
						bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()				);
						bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFile.toString()			);
						dbDao.addCUSDMRSndDtlLog(bkgCstmsKrSndLogDtlVO);	
						// 1건만 전송시킴
						break;
					}
				}
						
				
			}
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return transSndChk;
	}

	/**
	 * 반입신고서 전송 
	 * @param ManifestDGNTransmitVO manifestDGNTransmitVO
	 * @return String
	 * @exception EventException
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
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
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
			korDgCgoVvdVO.setUserId			(condVO.getUserId()	);
			korDgCgoVvdVO.setOfcCd 			(condVO.getOfcCd() 	);
			korDgCgoVvdVO.setSndDt 			(sndDt			  	);
			korDgCgoVvdVO.setFltFileRefNo	(fltFileRefNo		);
			dbDao.addCARDGNSndLog(korDgCgoVvdVO);
			
			// 세부 로그 기록
			korDgCgoVvdVO.setEdiSndMsg(flatFile.toString());
			dbDao.addCARDGNSndDtlLog(korDgCgoVvdVO);
			
			// EDI 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return flatFile.toString();
	}

	/**
	 * 적하일람표 전송
	 * @param ManifestDGMTransmitVO manifestDGMTransmitVO
	 * @return DgmManifestVO
	 * @exception EventException
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
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
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
			
			// 전송 로그 기록
			korDgmVvdVO.setUserId		(condVO.getUserId()	);
			korDgmVvdVO.setOfcCd		(condVO.getOfcCd()	);
			korDgmVvdVO.setSndDt		(sndDt				);
			korDgmVvdVO.setFltFileRefNo	(fltFileRefNo		);
			dbDao.addDGMNFTSndLog(korDgmVvdVO);
			
			// 세부 로그 기록
			korDgmVvdVO.setEdiSndMsg	(flatFile.toString());
			dbDao.addDGMNFTSndDtlLog(korDgmVvdVO);
			
			// Container 처리
			if (bkgCstmsKrDgCgoVOs!=null) {
				
				// SEQ 조회를 위한 파라메터 설정
				bkgCstmsKrDgCgoVvdVO.setMrnNo(korDgmVvdVO.getMrnNo());
				bkgCstmsKrDgCgoVvdVO.setVvd	 (korDgmVvdVO.getVvd()  );
				
				// Bound 구분
				if (korDgmVvdVO.getPodCd()!=null && korDgmVvdVO.getPodCd().trim().length() > 4) {
					korDgmVvdVO.setIoBndCd("I");
					korDgmVvdVO.setPortCd(korDgmVvdVO.getPodCd());
				}else {
					korDgmVvdVO.setIoBndCd("O");
					korDgmVvdVO.setPortCd(korDgmVvdVO.getPolCd());
				}
				
				// Container LOOP
				for(int i=0; i < bkgCstmsKrDgCgoVOs.length; i++) {
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
					
					if (cntrFlatFiles!=null) {
					
						for(int j=0; j < cntrFlatFiles.length; j++) {
							
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
							
							// 로그 기록
							korDgmCntrVO.setEdiSndMsg(bfTemp.toString());
							dbDao.addDGMNFTCNTRSndDtlLog(korDgmCntrVO);
							
							// FlatFile 합치기
							flatFile.append(bfTemp);
						}
					}
				}
				dgmManifestVO.setBkgCstmsKrDgCgoVOs(bkgCstmsKrDgCgoVOs);
			}
			
			// EDI SND
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			
			// EDI SEND 후 전송일자 UPDATE
			bkgCstmsKrDgCgoVvdVO.setUserId		(condVO.getUserId()	);
			bkgCstmsKrDgCgoVvdVO.setMaxVvdSeq	(maxVvdSeq			);
			dgmManifestVO.setBkgCstmsKrDgCgoVvdVO(bkgCstmsKrDgCgoVvdVO);
			
			// EDI SND 후 CONTAINER 전송일자 UPDATE
			bkgCstmsKrDgCgoVO.setVvd	(korDgmVvdVO.getVvd()		);
			bkgCstmsKrDgCgoVO.setUserId	(condVO.getUserId()			);
			bkgCstmsKrDgCgoVO.setIoBndCd(korDgmVvdVO.getIoBndCd()	);
			dgmManifestVO.setBkgCstmsKrDgCgoVO(bkgCstmsKrDgCgoVO);
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return dgmManifestVO;
	}

	/**
	 * MSN Create EDI 전송 
	 * @param ManifestMFTTransmitVO manifestMFTTransmitVO
	 * @return String
	 * @exception EventException
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
			for(int i=0; i < korIbManifestVOs.length; i++) {
				
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
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ENTRY.IBMMQ.QUEUE"));
			flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
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
	private void ediSendMessage(String flatFile, String queueName) throws EventException
	{
		try {					
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  BookingUtil utilCommand = new BookingUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Amendment Transmission to Korean Customs 정정 내용 출력을 위한 조회
	 * @param AmdFormVO[] amdFormVOs
	 * @return AmdFormVO[]
	 * @exception EventException
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
			if (inType==null || "|A|B|C|D|M|T|R".indexOf(inType) < 1 ) inType="N";
			// PORT 처리
			String portCd = condVOs[0].getPodCd();
			if (condVOs[0].getIoBndCd().equals("O")) portCd = condVOs[0].getPolCd();
			// POD_TML 처리
			String podTml2 =condVOs[0].getYardCd();
			if (podTml2 != null && !"".equals(podTml2)){
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
			for(int i=0; i < condVOs.length; i++) {
				
				korAmdFormVO = new KorAmdFormVO();
				
				// MRN 및 SHIP 정보 셋팅
				korAmdFormVO.setMrnNo(bkgCstmsKrVvdSmryVO.getMrnNo() + bkgCstmsKrVvdSmryVO.getMrnChkNo());
				korAmdFormVO.setBlTpCd(bkgCstmsKrVvdSmryVO.getLoclCstmsCd());
				korAmdFormVO.setPortCd(bkgCstmsKrVvdSmryVO.getPortCd());
				korAmdFormVO.setEtaDt(bkgCstmsKrVvdSmryVO.getEtaDt());
				korAmdFormVO.setShipNm(vslVO.getVslEngNm2());
				
				// 포맷 변환
				if (korAmdFormVO.getEtaDt()!=null) {
					korAmdFormVO.setEtaDt(korAmdFormVO.getEtaDt().substring(0,10).replaceAll("-", "."));
				}
				if (korAmdFormVO.getMrnNo()!=null && korAmdFormVO.getMrnNo().length() > 10) {
					korAmdFormVO.setMrnNo( korAmdFormVO.getMrnNo().substring(0, 2) + "-" +
										   korAmdFormVO.getMrnNo().substring(2, 6)+ "-" +	
										   korAmdFormVO.getMrnNo().substring(6, 10)+ "-" +	
										   korAmdFormVO.getMrnNo().substring(10,11)	
										  );
				}
				if (korAmdFormVO.getPortCd()!=null) {
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
				
				if (korAmdBlInfoVOs!=null && korAmdBlInfoVOs.length > 0 ) {

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
					korAmdFormVO.setBlNo	("SMLM"+condVOs[i].getBlNo()			);
					korAmdFormVO.setBlTpCd	(korAmdBlInfoVOs[0].getCstmsDeclTpCd()	);
					if (amdTransVOs!=null) {
						
						for(int j=0; j < amdTransVOs.length; j++) {
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
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
		return list.toArray(new KorAmdFormVO[0]);
	}

	/**
	 * 한국세관 EDI 수신
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException {
		
		// 한국세관 EDI 수신 처리
		
		String[] lines = null;
		
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
				
				for(int i=1; i < lines.length; i++) {
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
				
				// 로그 저장용 객체
				KorAckMsgVO ackMsgVO = new KorAckMsgVO();
								
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
				
				dbDao.addCstmAckMsg(ackMsgVO);
				
				// 전송 세부 로그 추가
				KorAckMsgDtlVO[] ackMsgDtlVOs = new KorAckMsgDtlVO[lines.length];
				KorAckMsgDtlVO ackMsgDtlVO = null;
				for(int i=0; i < lines.length; i++) {
					ackMsgDtlVO = new KorAckMsgDtlVO();
					// 파라메터 셋팅
					ObjectCloner.build(ackMsgVO, ackMsgDtlVO);
					ackMsgDtlVO.setLogDtlSeq(String.valueOf(i+1));
					ackMsgDtlVO.setEdiRcvMsg(lines[i]);
					ackMsgDtlVO.setKrCstmsRjctRsn1(rtnDesc);
					
					ackMsgDtlVOs[i] = ackMsgDtlVO;
				}
				dbDao.addCstmAckMsgDtl(ackMsgDtlVOs);
			} else if(!"MADECLINTS".equals(msgTp)) {
				// REF_NO
				String fltFileRefNo = lines[8].trim().substring(12);
				// RECEIVE SEQUENCE : 조회값이 없을 경우 1로 설정
				String maxRcvSeq = dbDao.searchCstmMaxAckSeq(fltFileRefNo);
				// UserId 대용
				String userId = lines[0].trim().substring(lines[0].indexOf(":")+1, lines[0].indexOf(" "));
				// 수신결과 메시지
				String rsltMsg = "";
				if (lines[6].trim().length() > 12 ) rsltMsg = lines[6].trim().substring(12);
				
				// 로그 저장용 객체
				KorAckMsgVO ackMsgVO = new KorAckMsgVO();
								
				// 전송 로그 추가
				ackMsgVO.setMsgLogTpCd		(lines[4].trim().substring(7)		);
				ackMsgVO.setRcvDt			(lines[7].trim().substring(11)		);
				ackMsgVO.setRcvSeq			(maxRcvSeq							);
				ackMsgVO.setFltFileRefNo	(fltFileRefNo						);
				ackMsgVO.setSmtAmdNo		(lines[2].trim().substring(7)		);
				ackMsgVO.setKrCstmsAcptCd	(lines[5].trim().substring(8)		);
				if (lines[1].trim().length() > 6) ackMsgVO.setBlNo(lines[1].trim().substring(6));
				ackMsgVO.setUserId			(userId);
				dbDao.addCstmAckMsg(ackMsgVO);
				
				// 전송 세부 로그 추가
				KorAckMsgDtlVO[] ackMsgDtlVOs = new KorAckMsgDtlVO[lines.length];
				KorAckMsgDtlVO ackMsgDtlVO = null;
				for(int i=0; i < lines.length; i++) {
					ackMsgDtlVO = new KorAckMsgDtlVO();
					// 파라메터 셋팅
					ObjectCloner.build(ackMsgVO, ackMsgDtlVO);
					ackMsgDtlVO.setLogDtlSeq(String.valueOf(i+1));
					ackMsgDtlVO.setEdiRcvMsg(lines[i]);
					ackMsgDtlVO.setKrCstmsRjctRsn1(rsltMsg);
					
					ackMsgDtlVOs[i] = ackMsgDtlVO;
				}
				dbDao.addCstmAckMsgDtl(ackMsgDtlVOs);
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
				
				// 로그 저장용 객체
				KorAckMsgVO ackMsgVO = new KorAckMsgVO();
								
				// 전송 로그 추가
				ackMsgVO.setMsgLogTpCd		("5VD");
				ackMsgVO.setRcvDt			(lines[3].trim().substring(12)		);
				ackMsgVO.setRcvSeq			(maxRcvSeq							);
				ackMsgVO.setFltFileRefNo	(fltFileRefNo						);
				ackMsgVO.setSmtAmdNo		(lines[5].trim().substring(7)		);
				ackMsgVO.setKrCstmsAcptCd	(lines[2].trim().substring(7)		);
				ackMsgVO.setUserId			(userId);
				dbDao.addCstmAckMsg(ackMsgVO);
				
				// 전송 세부 로그 추가
				KorAckMsgDtlVO[] ackMsgDtlVOs = new KorAckMsgDtlVO[lines.length];
				KorAckMsgDtlVO ackMsgDtlVO = null;
				for(int i=0; i < lines.length; i++) {
					ackMsgDtlVO = new KorAckMsgDtlVO();
					// 파라메터 셋팅
					ObjectCloner.build(ackMsgVO, ackMsgDtlVO);
					ackMsgDtlVO.setLogDtlSeq(String.valueOf(i+1));
					ackMsgDtlVO.setRcvDt(lines[4].trim().substring(14));
					ackMsgDtlVO.setEdiRcvMsg(lines[i]);
					ackMsgDtlVO.setKrCstmsRjctRsn1(rsltMsg);
					
					ackMsgDtlVOs[i] = ackMsgDtlVO;
				}
				dbDao.addCstmAckMsgDtl(ackMsgDtlVOs);
			}
						
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
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
//		KorAutoImfSndVO korAutoImfSndVO = new KorAutoImfSndVO();
//		KorAutoImfSndDtlVO korAutoImfSndDtlVO = new KorAutoImfSndDtlVO();
		KorAutoMacSndVO korAutoMacSndVO = new KorAutoMacSndVO();
		KorAutoMacSndDtlVO korAutoMacSndDtlVO = new KorAutoMacSndDtlVO();
		
		try {
			
			// MAIN LOOP
			for(int i=0; i < korEmpAmdManiTransVOs.length; i++) {
				
				flatFile.setLength(0);
				
				// 헤더 생성

				flatFileHeader = utilCommand.searchCstmsEdiHeader("SSSMLM0001", "KCS4G002", "IMFMOD");
				flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
				
				// flatFile Header
				flatFile.append(flatFileHeader).append("\n");
				
				// 전송일시
				sysdate = dbDao.searchSysDate();
				
				// User name 조회
				usrNm = dbDao.searchComUser(korEmpAmdManiTransVOs[i].getUsrId());
			
				korEmpImfmodVO = new KorEmpImfmodVO();
				// Receiver 가 All 인 경우 처리
				
				//2014.05.15 관세청으로 전송 블록 요청 김대준 차장님
				
//				if (korEmpAmdManiTransVOs[i].getReceiver().equals("0")) {
//					// 파라메터 설정
//					korEmpImfmodVO.setUsrNm			(usrNm									);
//					korEmpImfmodVO.setSubNo			(korEmpAmdManiTransVOs[i].getSubNo()	);
//					korEmpImfmodVO.setCstmsBlNo		(korEmpAmdManiTransVOs[i].getIbTsCblno());
//					korEmpImfmodVO.setTrnsSeq		(korEmpAmdManiTransVOs[i].getIbTsSeq()	);
//					korEmpImfmodVO.setDmstPortCd	(korEmpAmdManiTransVOs[i].getIbTsPort()	);
//					korEmpImfmodVO.setBkgNo			(korEmpAmdManiTransVOs[i].getIbTsBkgno());
//					korEmpImfmodVO.setCstmsDeclTpCd	(korEmpAmdManiTransVOs[i].getIbTsType()	);
//					korEmpImfmodVO = dbDao.makeAutoIMFMODFlatFile(korEmpImfmodVO);
//					
//					flatFile.append(korEmpImfmodVO.getFlatData().replaceAll("~", "\n")).append("\n");
//				
//				
//					// Send Log Seq 조회
//					maxSeq = dbDao.searchMaxImfSndLogSeq(sysdate, korEmpAmdManiTransVOs[i].getOfcCd());
//					
//					// 마스터 로그테이블에 IMF 전송기록 저장
//					korAutoImfSndVO.setSndDt		(sysdate								);
//					korAutoImfSndVO.setOfcCd		(korEmpAmdManiTransVOs[i].getOfcCd()	);
//					korAutoImfSndVO.setFltFileRefNo	(flatFileRefNo							);
//					korAutoImfSndVO.setUsrId		(korEmpAmdManiTransVOs[i].getUsrId()	);
//					korAutoImfSndVO.setVvdCd		(korEmpAmdManiTransVOs[i].getIbTsVvd()	);
//					korAutoImfSndVO.setPolCd		(korEmpAmdManiTransVOs[i].getIbTsPort()	);
//					korAutoImfSndVO.setBlNo			(korEmpAmdManiTransVOs[i].getIbTsCblno());
//					korAutoImfSndVO.setSubNo		(korEmpAmdManiTransVOs[i].getSubNo()	);
//					korAutoImfSndVO.setSndSeq		(maxSeq									);
//					dbDao.addAutoIMFMODSndLog(korAutoImfSndVO);
//					
//					// 디테일 로그 테이블에 IMF 전송기록 저장
//					ObjectCloner.build(korAutoImfSndVO, korAutoImfSndDtlVO);
//					korAutoImfSndDtlVO.setEdiSndMsg(flatFile.toString());
//					dbDao.addAutoIMFMODSndDtlLog(korAutoImfSndDtlVO);
//					
//					// IMFMOD CORRECTION FLATFILE 생성
//					flatFile.append(dbDao.makeAutoIMFMODCorrFlatFile().replaceAll("~", "\n")).append("\n");
//					
//					// 디테일 로그 테이블에 추가 저장
//					korAutoImfSndDtlVO.setEdiSndMsg(flatFile.toString());
//					dbDao.addAutoIMFMODSndDtlLog(korAutoImfSndDtlVO);
//					
//					// EDI 전송
//					sendFlatFileVO.setFlatFile(flatFile.toString());
//					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE"));
//					flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
//					if (flatFileAckVO.getAckStsCd().equals("E"))
//					  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
//				}
				
				// RECEIVER 가 ALL 이거나 PA 인 경우 추가
				if (korEmpAmdManiTransVOs[i].getReceiver().equals("0") || korEmpAmdManiTransVOs[i].getReceiver().equals("1")) {
					flatFile.setLength(0);
					
					// 헤더 생성
					flatFileHeader = utilCommand.searchCstmsEdiHeader("SMLM0001", "BPAED020", "MACAMD");
					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
					
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
					dbDao.addAutoMACAMDSndLog(korAutoMacSndVO);
					
					// 디테일 로그 테이블에 IMF 전송기록 저장
					ObjectCloner.build(korAutoMacSndVO, korAutoMacSndDtlVO);
					korAutoMacSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoMACAMDSndDtlLog(korAutoMacSndDtlVO);
					
					// IMFMOD CORRECTION FLATFILE 생성
					flatFile.append(dbDao.makeAutoMACAMDCorrFlatFile().replaceAll("~", "\n")).append("\n");
					
					// 디테일 로그 테이블에 추가 저장
					korAutoMacSndDtlVO.setEdiSndMsg(flatFile.toString());
					dbDao.addAutoMACAMDSndDtlLog(korAutoMacSndDtlVO);
					
					// EDI 전송
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE"));
					flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
					  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
					
				}
				
			}
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * IFTSAI EDI 전송 (CondVO, jobType[A,R])
	 * 
	 * @param KorMrnCreateInfoCondVO condVO
	 * @param String jobType
	 * @throws EventException
	 */
	private void transmitIFTSAIMessage(KorMrnCreateInfoVO condVO, String jobType) throws EventException {
		try {
			// EDI 전송 처리 시작 ( 첫번째 VVD 에 대해서만 전송 )
			BookingUtil bookingUtil = new BookingUtil();
			// Header 생성
			String flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLMM010", "KTNETPCS", "IFTSAI");
			// FlatFile 에 추가
			StringBuffer flatFile = new StringBuffer();
			flatFile.append(flatFileHeader).append("\n");
			
			// VSL Port 조회
			KorIftsaiVslPortVO korIftsaiVslPortVO = new KorIftsaiVslPortVO();
			korIftsaiVslPortVO.setVslCd		(condVO.getVvd().substring(0,4)	);
			korIftsaiVslPortVO.setSkdVoyNo	(condVO.getVvd().substring(4,8)	);
			korIftsaiVslPortVO.setSkdDirCd	(condVO.getVvd().substring(8,9)	);
			korIftsaiVslPortVO.setVpsPortCd	(condVO.getPortCd()				);
			KorIftsaiVslPortVO iftsaiVslPortVO = dbDao.searchIFTSAIVslPortInfo(korIftsaiVslPortVO);
			
			// VSL Info 조회
			KorIftsaiVslVO korIftsaiVslVO = new KorIftsaiVslVO();
			ObjectCloner.build(korIftsaiVslPortVO, korIftsaiVslVO);
			korIftsaiVslVO.setVpsCallInd(iftsaiVslPortVO.getVpsCallInd());
			KorIftsaiVslVO iftsaiVslVO = dbDao.searchIFTSAIVslInfo(korIftsaiVslVO);
			
			// DATE 조회
			KorIftsaiDateVO korIftsaiDateVO = new KorIftsaiDateVO();
			ObjectCloner.build(korIftsaiVslPortVO, korIftsaiDateVO);
			korIftsaiDateVO.setVpsCallSeq(iftsaiVslPortVO.getVpsCallSeq());
			KorIftsaiDateVO[] iftsaiDatVOs = dbDao.searchIFTSAIDate(korIftsaiDateVO);
			
			flatFile.append("BRAC:").append(iftsaiVslVO.getSendCnt()).append("\n");
			flatFile.append("VSL_CD:").append(korIftsaiVslPortVO.getVslCd()).append("\n");
			flatFile.append("VSL_NM:").append(iftsaiVslVO.getVslNm()).append("\n");
			flatFile.append("VOY:").append(korIftsaiVslPortVO.getSkdVoyNo()).append("\n");
			flatFile.append("DIR:").append(korIftsaiVslPortVO.getSkdDirCd()).append("\n");
			flatFile.append("CALLSIGN:").append(iftsaiVslVO.getCallSg()).append("\n");
			flatFile.append("LANE:").append(iftsaiVslPortVO.getVpsLaneCd()).append("\n");
			flatFile.append("LANE_NM:").append(iftsaiVslVO.getLaneNm()).append("\n");
			flatFile.append("TMNL_VSL_CD:").append(iftsaiVslPortVO.getVpsPlismVsl()).append("\n");
			flatFile.append("TMNL_VYG_NO:").append(iftsaiVslPortVO.getVpsPlismVoy()).append("\n");
			
			
			if (jobType.equals("A")) {
				if (condVO.getIoBndCd().equals("I")) {
					flatFile.append("O_MRN_NO:").append("\n");
					flatFile.append("I_MRN_NO:").append(condVO.getMrnNo()).append(condVO.getMrnChkNo()).append("\n");
				} else {
					flatFile.append("O_MRN_NO:").append(condVO.getMrnNo()).append(condVO.getMrnChkNo()).append("\n");
					flatFile.append("I_MRN_NO:").append("\n");
				}
			} else {
				flatFile.append("O_MRN_NO:").append("\n");
				flatFile.append("I_MRN_NO:").append("\n");
			}
			flatFile.append("REMARK:").append(iftsaiVslVO.getRemark()).append("\n");
			
			
			if (iftsaiDatVOs!=null) {
				for(int i=0; i < iftsaiDatVOs.length; i++) {
					flatFile.append("{PORT_INFO").append("\n");
					flatFile.append("PORT_IND:").append(iftsaiDatVOs[i].getPortInd()).append("\n");
					flatFile.append("LOC_CD:").append(iftsaiDatVOs[i].getLocCd()).append("\n");
					flatFile.append("LOC_DESC:").append(iftsaiDatVOs[i].getLocDesc()).append("\n");
					flatFile.append("YARD_CD:").append(iftsaiDatVOs[i].getYdCd()).append("\n");
					flatFile.append("ETA:").append(iftsaiDatVOs[i].getEta()).append("\n");
					flatFile.append("ETD:").append(iftsaiDatVOs[i].getEtd()).append("\n");
					flatFile.append("ETB:").append(iftsaiDatVOs[i].getEtb()).append("\n");
					flatFile.append("CCT:").append(iftsaiDatVOs[i].getCct()).append("\n");
					flatFile.append("FREE_TIME:").append(iftsaiDatVOs[i].getFt()).append("\n");
					flatFile.append("}PORT_INFO").append("\n");
				}
			}
			
			
			//			
			// Contact Info 조회
			//jjang(2013/11/25)
			String lane = null;
			String port = null;
			String dir = null;
			
			lane = iftsaiVslPortVO.getVpsLaneCd();
			port = condVO.getPortCd();
			dir  = condVO.getVvd().substring(8,9);			
			
			KorContInfoVO contIFTSAIInfoVO = dbDao.searchContactIFTSAIInfo(lane, port, dir); 
			
			if(contIFTSAIInfoVO != null){
				flatFile.append("{CONTACT_INFO").append("\n");
				flatFile.append("CONTACT_USERID:").append(contIFTSAIInfoVO.getUsrId()).append("\n");
				flatFile.append("CONTACT_PERSON:").append(contIFTSAIInfoVO.getUsrNm()).append("\n");
				flatFile.append("CONTACT_TEL:").append(contIFTSAIInfoVO.getXtnPhnNo()).append("\n");
				flatFile.append("CONTACT_FAX:").append(contIFTSAIInfoVO.getFaxNo()).append("\n");
				flatFile.append("CONTACT_EMAIL:").append(contIFTSAIInfoVO.getUsrEml()).append("\n");
				flatFile.append("}CONTACT_INFO").append("\n");
				
			}else{			
				KorContInfoVO contInfoVO = dbDao.searchContactInfo(condVO.getUserId()); 
				if (contInfoVO!=null) {
					flatFile.append("{CONTACT_INFO").append("\n");
					flatFile.append("CONTACT_USERID:").append(condVO.getUserId()).append("\n");
					flatFile.append("CONTACT_PERSON:").append(contInfoVO.getUsrNm()).append("\n");
					flatFile.append("CONTACT_TEL:").append(contInfoVO.getXtnPhnNo()).append("\n");
					flatFile.append("CONTACT_FAX:").append(contInfoVO.getFaxNo()).append("\n");
					flatFile.append("CONTACT_EMAIL:").append(contInfoVO.getUsrEml()).append("\n");
					flatFile.append("}CONTACT_INFO").append("\n");
				}
			}
			
			// FlatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_VENDOR.IBMMQ.QUEUE");			
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * IFTSAI EDI 전송
	 * 
	 * @param IftsaiSndCondVO[] iftsaiSndCondVOs
	 * @return IftsaiSndCondVO
	 * @throws EventException
	 */
	public IftsaiSndCondVO searchIFTSAISnd(IftsaiSndCondVO[] iftsaiSndCondVOs) throws EventException {
		
		try {
		
			// 파라메터 변환
			KorIftsaiSndCondVO[] condVOs = (KorIftsaiSndCondVO[])iftsaiSndCondVOs;
			KorMrnCreateInfoVO condVO = null;
			KorSkipVO korSkipVO = new KorSkipVO();
			String[] skipCheck = null;
			boolean doSkip = false;
			
			for(int i=0; i < condVOs.length; i++) {
				doSkip = false;
				condVO = new KorMrnCreateInfoVO();
				ObjectCloner.build(condVOs[i], condVO);
				condVO.setVvd(condVO.getVvd1());
				
				// SKIP 여부 조회하여 X가 존재하면 전송하고 X가 없으면 EDI 전송 안함
				korSkipVO.setVslCd		(condVO.getVvd1().substring(0,4)	);
				korSkipVO.setSkdVoyNo	(condVO.getVvd1().substring(4,8)	);
				korSkipVO.setSkdDirCd	(condVO.getVvd1().substring(8,9)	);
				korSkipVO.setVpsPortCd	(condVO.getPortCd()					);				
				skipCheck = dbDao.searchVslPortSkdSkipChk(korSkipVO);
				
				if (skipCheck!=null) {
					// 기본값은 EDI 전송하지 않음(S가 나오는 경우 Default)
					doSkip = true;
					
					for(int j=0; j < skipCheck.length; j++) {
						// X 가 존재하면 EDI 전송
						if (skipCheck[j].equals("X")) doSkip = false;
					}
				}
				
				if (doSkip==false) transmitIFTSAIMessage(condVO, "R");
			}
			
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return null;
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
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		String receiver = "";
		
		// 화면에서 넘어온 VO
		KorCancelManifestTransmitVO condVO = null;

		try {
			
			// 파라메터 변환
			condVO = (KorCancelManifestTransmitVO)cancelManifestTransmitVO;
			
			// 수신처 판단
			if (condVO.getKtPa()!=null) {
				if (condVO.getKtPa().equals("20") || condVO.getKtPa().equals("020") || condVO.getKtPa().equals("820")) { // 부산, 울산
					receiver = "BPAED020";
				}else if (condVO.getKtPa().equals("30") || condVO.getKtPa().equals("31") || condVO.getKtPa().equals("030") || condVO.getKtPa().equals("031")) {
					receiver = "KMPAE030";
				}else if (condVO.getKtPa().equals("622")) {
					receiver = "KMPAE050";
				}
			}
			// FLATFILE 헤더 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeader("SMLM0001", receiver, "MACAMD");
			fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
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
			
			/**** 3세대
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
			***/

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
						
			
			bfTemp.append("DISC_CO_CD:").append(arTemp[k++]).append("\n");
			bfTemp.append("GO_BIZ_NO:").append(arTemp[k++]).append("\n");
			
			flatFile.append(bfTemp);
			
			flatFileHeader = flatFile.toString(); 
			
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
			// 로그 기록
			dbDao.addMACAMDModiDelSndLog(bkgCstmsKrSndLogVO);
			
			// Detail 로그 및 FlatFile 내용 저장 
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(condVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg		(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(condVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setUserId			(condVO.getUserId()	);
			// 로그 기록
			dbDao.addMACAMDModiDelSndDtlLog(bkgCstmsKrSndLogDtlVO);
			
			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
			
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
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
		
		if("R".equals(bkgCgoTpCd)) {
			if("S".equals(krCstmsBlTpCd) || "C".equals(krCstmsBlTpCd)) {
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
	 * @exception EventException
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
		String flatFileHeader = null;
		StringBuffer flatFileBody   = new StringBuffer();
		
		// 헤더 생성용 객체
		BookingUtil bookingUtil = new BookingUtil();
		// BODY 생성용 객체
		
		// 전송 로그 기록을 위한 객체
		BkgCstmsKrSndLogVO 	  bkgCstmsKrSndLogVO 	= new BkgCstmsKrSndLogVO();
		BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO = new BkgCstmsKrSndLogDtlVO();
		
		// SEND DATE
		String sndDt = null;
		
		// Max Sequence
		String maxSeq = null;
		
		// 송수신처 판단
		String sender 	= "SSSMLM0001";
		String receiver = "KTNETULHS4G";
			
		// 헤더 생성
		flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "PORTAL");
		fltFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			
		// flatFile 에 추가
		flatFile.append(flatFileHeader).append("\n");

		try {

			// FLATFILE 헤더 생성
			// 헤더 추가정보 생성
			flatFileHeader = dbDao.makeKRTransCancelFlatFile(transmitVO);

			arTemp = flatFileHeader.split("~",100);
			
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
			
			flatFileHeader = flatFile.toString();
			
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
			
			dbDao.addPORTALSndLog(bkgCstmsKrSndLogVO);
			
			// 전송 세부 로그 기록
			// Detail 로그 및 FlatFile 내용 저장
			bkgCstmsKrSndLogDtlVO.setIoBndCd		(transmitVO.getIoBndCd());
			bkgCstmsKrSndLogDtlVO.setSndDt			(sndDt				);
			bkgCstmsKrSndLogDtlVO.setEdiSndMsg	(flatFileHeader		);
			bkgCstmsKrSndLogDtlVO.setOfcCd			(transmitVO.getOfcCd()	);
			bkgCstmsKrSndLogDtlVO.setFltFileRefNo	(fltFileRefNo		);
			bkgCstmsKrSndLogDtlVO.setMfSndSeq     (maxSeq);
			bkgCstmsKrSndLogDtlVO.setUserId			(transmitVO.getUserId()	);
			
			dbDao.addPORTALSndDtlLog(bkgCstmsKrSndLogDtlVO);
			
			// FLATFILE BODY 생성시작
			flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, "PORTAL");
			flatFileHeader = flatFileHeader.substring(0, flatFileHeader.indexOf("BKC")) + fltFileRefNo;
			
			// FLATFILE 조립
			flatFile.append(flatFileBody);
			
			// flatFile 전송
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE");
//			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_T_UDEVHJS_CUSTOMS.IBMMQ.QUEUE");
			
			return flatFile.toString();
			
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
	}

	/**
	 * ESM_BKG_0371  KOREA CUSTOMS : 신규 생성하는 MRN 에 대해서 동일 Vessel 로 등록된 MRN # 있는지 조회한다.<br>
	 * @param MrnCreateInfoVO MrnCreateInfoVO
	 * @return String result
	 * @throws EventException
	 */
	public String searchMrnDuplicated(MrnCreateInfoVO mrnCreateInfoVO) throws EventException {
		
		KorMrnCreateInfoVO korMrnCreateInfoVO = null;
		String mrnChk = null;
		String result = null;
		
		try { 
			mrnChk = dbDao.searchMrnChk((KorMrnCreateInfoVO) mrnCreateInfoVO);
			if (mrnChk != null) 
				{
				 result = "DUPLICATED";
				}
			else{//mrnChk null 
				korMrnCreateInfoVO = dbDao.searchMrnDuplicated((KorMrnCreateInfoVO) mrnCreateInfoVO);
				if (korMrnCreateInfoVO == null){
					result = "NEW MRN";
				}
				else
					result = korMrnCreateInfoVO.getVslCd() + korMrnCreateInfoVO.getSkdVoyNo()+korMrnCreateInfoVO.getSkdDirCd()+"|" +
							korMrnCreateInfoVO.getIoBndCd() + "|" + korMrnCreateInfoVO.getPortCd();	  
				// VVD|IO_BND_CD|PORT_CD 의 형태로 반환하고, SC 에서 eventresponse 에 ETCData 태워서 JS 로 보냄
			
			}
		

		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
	}
		return result;
	}
	
}
