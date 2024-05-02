/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionBC.java
*@FileTitle : KorCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
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
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see KorCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public interface KorCustomsTransmissionBC {

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 *
	 * @param KorMrnCreateInfoCondVO korMrnCreateInfoCondVO
	 * @return List<KorMrnCreateInfoVO>
	 * @throw EventException
	 */
	public List<KorMrnCreateInfoVO> searchMrnCreateInfo(KorMrnCreateInfoCondVO korMrnCreateInfoCondVO) throws EventException;

	/**
	 * MRN Create 정보 유효성 검사
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @throw EventException
	 */
	public void validateMrnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs) throws EventException;

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListVO
	 * @throw EventException
	 */
	public ManifestListVO searchManifestListForTransmit(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * Manifest Transmit Discharge ( 하선신고 )
	 *
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException;

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param KorManifestTransmitVO korManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitManifest(KorManifestTransmitVO korManifestTransmitVO) throws EventException;

	/**
	 * Trans Amendment To PA
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transAmendManifest(AmendManifestTransmitVO amendManifestTransmitVO) throws EventException;

	/**
	 * Amendment Transmit 전송 (FlatFile Return)
	 * @param AmdManifestTransmitVO amdManifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transAmdManifest(AmdManifestTransmitVO amdManifestTransmitVO) throws EventException;

	/**
	 * 반입신고서 전송
	 * @param ManifestDGNTransmitVO manifestDGNTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitDGNManifest(ManifestDGNTransmitVO manifestDGNTransmitVO) throws EventException;

	/**
	 * 적하일람표 전송
	 * @param ManifestDGMTransmitVO manifestDGMTransmitVO
	 * @return DgmManifestVO
	 * @throw EventException
	 */
	public DgmManifestVO transmitDGMManifest(ManifestDGMTransmitVO manifestDGMTransmitVO) throws EventException;

	/**
	 * MSN Create EDI 전송
	 * @param ManifestMFTTransmitVO manifestMFTTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitKorMFTManifest(ManifestMFTTransmitVO manifestMFTTransmitVO) throws EventException;

	/**
	 * Amendment Transmission to Korean Customs 정정 내용 출력을 위한 조회
	 * @param AmdFormVO[] amdFormVOs
	 * @return AmdFormVO[]
	 * @throw EventException
	 */
	public AmdFormVO[] searchAmdFormPrev(AmdFormVO[] amdFormVOs) throws EventException;

	/**
	 * 한국세관 EDI 수신
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @throw EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException;

	/**
	 * InBound Empty Amend 전송
	 * @param EmpAmdManiTransVO[] empAmdManiTransVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiTransVO[] empAmdManiTransVOs) throws EventException;

	/**
	 * 한국세관 Cancel per B/L EDI 전송
	 *
	 * @param CancelManifestTransmitVO cancelManifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transCancelManifest(CancelManifestTransmitVO cancelManifestTransmitVO) throws EventException;

	/**
	 * ESM_BKG_0503 Transmit Cross-Check 조회
	 * @param KorTransCrossChkCondVO korTransCrossChkCondVO
	 * @return List<KorTransCrossChkDtlVO>
	 * @throws EventException
	 */
	public List<KorTransCrossChkDtlVO> searchTransCrossChk(KorTransCrossChkCondVO korTransCrossChkCondVO) throws EventException;

	/**
	 * KR Manifest를 취소하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throw EventException
	 */
	public String transmitCancellKR(ManifestTransmitVO manifestTransmitVO) throws EventException;

}