/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDownloadBC.java
*@FileTitle : KorManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrMfSeqNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoKorVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDlContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.ObMsnInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DiscCYBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiDGMTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TmpBlBkgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0329EventResponse,KorManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface KorManifestListDownloadBC {

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회
	 *
	 * @param KorMrnNoVO korMrnNoVO
	 * @return KorContainerVO
	 * @throws EventException
	 */
	public KorContainerVO searchManifestInfo(KorMrnNoVO korMrnNoVO) throws EventException;

	/**
	 * ESM_BKG_0329 - BackEndJob 시작
	 *
	 * @param SignOnUserAccount account
	 * @param KorDlContainerVO korDlContainerVO
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobDownloadCstmsBlList(SignOnUserAccount account, KorDlContainerVO korDlContainerVO) throws EventException;

	/**
	 * 이미 다운로드 되었던 Manifest에 대해서 만약 아직 전송이 되지 않은 상태일 경우에 대해서 manage한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return int
	 * @exception EventException
	 */
	public int manageManifest(ManifestListCondVO manifestListCondVO)throws EventException;

	/**
	 * ManifestList 한국세관쪽으로 다운로드
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList( ManifestListCondVO manifestListCondVO , SignOnUserAccount account) throws EventException;

	/**
	 * 세관 신고대상 내역 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * Discharge CY, Bonded Warehouse, Bonded Type등을 조회
	 *
	 * @param discCYBondInfoVO
	 * @return
	 * @exception EventException
	 */
	public DiscCYBondInfoVO searchDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException;

	/**
	 * INBOUND DETAIL UPDATE
	 *
	 * @param discCYBondInfoVO
	 * @return DiscCYBondInfoVO
	 * @exception EventException
	 */
	public DiscCYBondInfoVO manageDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException;

	/**
	 * 세관 B/L 관련 정보 조회
	 * @param ManifestEditListCondVO manifestEditListCondVO
	 * @return ManifestEditListVO
	 * @exception EventException
	 */
	public ManifestEditListVO searchManifestEditList(ManifestEditListCondVO manifestEditListCondVO) throws EventException;

	/**
	 * Package / 품목 Code 조회
	 * @param CodeCondVO codeCondVO
	 * @return CodeVO[]
	 * @exception EventException
	 */
	public CodeVO[] searchCodeInfo(CodeCondVO codeCondVO) throws EventException;

	/**
	 * B/L, Container, E/L 정보들을 추가/수정/삭제 처리
	 * @param ManifestModificationVO manifestModificationVO
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO manifestModificationVO) throws EventException;

	/**
	 * BKG_NO, B/L_NO 자동 생성
	 * @param TmpBlBkgVO tmpBlBkgVO
	 * @return  TmpBlBkgVO
	 * @exception EventException
	 */
	public TmpBlBkgVO searchTempBlNoNBkgNoAssign(TmpBlBkgVO tmpBlBkgVO) throws EventException;

	/**
	 * MSN Bonded Info 조회
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return MsnBondInfoVO[]
	 * @exception EventException
	 */
	public MsnBondInfoVO[] searchMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException;

	/**
	 * MRN Bonded Info Update
	 *
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return BkgCstmsKrMfSeqNoVO[]
	 * @exception EventException
	 */
	public BkgCstmsKrMfSeqNoVO[] modifyMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException;

	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException;

	/**
	 * BL 정보 조회
	 * @param BlInfoCondVO blInfoCondVO
	 * @return BlInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchBlInfo(BlInfoCondVO blInfoCondVO) throws EventException;

	/**
	 * Amendment Manifest 정보 추가/수정/삭제
	 * @param ManifestAmdManiVO manifestAmdManiVO
	 * @exception EventException
	 */
	public void manageAmdManifest(ManifestAmdManiVO manifestAmdManiVO) throws EventException;

	/**
	 * DG Cargo Manifest List 조회
	 * @param DgCgoManifestVO dgCgoManifestVO
	 * @return DgCgoManifestVO
	 * @exception EventException
	 */
	public DgCgoManifestVO searchDgCgoManifestList(DgCgoManifestVO dgCgoManifestVO) throws EventException;

	/**
	 * DG Cargo Manifest 정보 수정
	 * @param DgCgoManifestCondVO dgCgoManifestCondVO
	 * @exception EventException
	 */
	public void manageDgCgoManifest(DgCgoManifestCondVO dgCgoManifestCondVO) throws EventException;

	/**
	 * Discharging CY에 대한 Validation Check
	 * @param String dischCy
	 * @return String
	 * @throws EventException
	 */
	public String searchDischCyValChk(String dischCy) throws EventException;

	/**
	 * MSN 배정을 위한 Validation Check
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMsnValChk(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws EventException;

	/**
	 * Manifest Summary 정보 수정
	 *
	 * @param KorManifestSmryCondVO korManifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(KorManifestSmryCondVO korManifestSmryCondVO) throws EventException;

	/**
	 * Manifest 정보 삭제
	 *
	 * @param KorManiSumCondVO korManiSumCondVO
	 * @throws EventException
	 */
	public void manageManifestSummaryInfo(KorManiSumCondVO korManiSumCondVO) throws EventException;

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException;

	/**
	 * Manifest를 전송 후 정보 UPDATE
	 *
	 * @param KorManifestTransmitVO korManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitManifest(KorManifestTransmitVO korManifestTransmitVO) throws EventException;

	/**
	 * EDI 수신 메시지 처리
	 *
	 * @param RcvMsgVO rcvMsgVO
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException;

	/**
	 * Amendment Transmit 후 전송일시 UPDATE
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void transAmdManifest(KorBlInfoKorVO korBlInfoKorVO) throws EventException;

	/**
	 * MFT Manifest EDI 전송후 UPDATE
	 *
	 * @param ManiCondVO maniCondVO
	 * @throws EventException
	 */
	public void transmitKorMFTManifest(ManiCondVO maniCondVO) throws EventException;

	/**
	 * MRN Creation 정보 INSERT
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @param SignOnUserAccount account
	 * @param String ffDiv  //◁◁◁◁◁◁◁◁◁◁///////////////////////////
	 * @throws EventException
	 */
	public void manageMrnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs, SignOnUserAccount account, String ffDiv) throws EventException;  //◁◁◁◁◁◁◁◁◁◁///////////////////////////

	/**
	 * MRN MSN 정보 삭제
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @throws EventException
	 */
	public void removeMrnMsnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs) throws EventException;

	/**
	 * DGM Manifest 전송후 VVD, Container 정보 UPDATE
	 *
	 * @param ManiDGMTransVO maniDGMTransVO
	 * @throws EventException
	 */
	public void transmitDGMManifest(ManiDGMTransVO maniDGMTransVO) throws EventException;

	/**
	 * VSL, Manifest 정보 조회
	 *
	 * @param KorVslInfoNManifestCondVO korVslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @throws EventException
	 */
	public VslInfoNManifestVO manageVslInfoNManifestList(KorVslInfoNManifestCondVO korVslInfoNManifestCondVO) throws EventException;

	/**
	 * OutBound 의 경우 MSN 정보 추가 처리
	 *
	 * @param ObMsnInfoCondVO obMsnInfoCondVO
	 * @throws EventException
	 */
	public void manageObMsnInfo(ObMsnInfoCondVO obMsnInfoCondVO) throws EventException;

	/**
	 * InBound Empty MSN 저장
	 * @param MsnNoCondVO[] msnNoCondVOs
	 * @throws EventException
	 */
	public void manageMsnNo(MsnNoCondVO[] msnNoCondVOs) throws EventException;

	/**
	 * 한국세관 InBound Empty Amend 전송을 위한 처리
	 * @param EmpAmdManiVO[] empAmdManiVOs
	 * @return EmpAmdManiVO[]
	 * @throws EventException
	 */
	public EmpAmdManiVO[] manageEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException;

	/**
	 * 한국세관 InBound Empty Amend 전송후 UPDATE 처리
	 *
	 * @param EmpAmdManiVO[] empAmdManiVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException;

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param SndCorrVO sndCorrVO
	 * @throws EventException
	 */
	public void addSndDtCorrInfo(SndCorrVO sndCorrVO) throws EventException;

	/**
	 * Web Service EAI용(WEB_001_0001)<br>
	 * Bonded type 을 업데이트<br>
	 *
	 * @param BkgWebServiceVO webVo
	 * @exception EventException
	 */
	public void modifyWeb0010001Control(BkgWebServiceVO webVo) throws EventException;

	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 * @param KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs
	 * @param SignOnUserAccount account
	 * @return KorManifestCrsChkInfoVO
	 * @exception EventException
	 */
	public KorManifestCrsChkInfoVO manageCrossCheck(KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs , SignOnUserAccount account) throws EventException;

	/**
	 * Amendment Transmit 이후에 MF_SND_FLG  UPDATE
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void modifySndFlg(KorBlInfoKorVO korBlInfoKorVO) throws EventException;

	/**
	 * 한국세관에 Cross Chk 화면 조회
	 *
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public List<KorManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(KorMrnNoVO manifestInfoVO) throws EventException;

	/**
	 * 한국세관에 Cross Chk 화면 Sum 조회
	 *
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public KorMrnNoVO searchManifestCrsChkInfoSumKorList(KorMrnNoVO manifestInfoVO) throws EventException;
}