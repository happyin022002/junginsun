/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Kor24ManifestListDownloadBC.java
 *@FileTitle : UI_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
 *------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface Kor24ManifestListDownloadBC {

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestInfo(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return int
	 * @exception EventException
	 */
	public int manageManifest(ManifestListCondVO manifestListCondVO )throws EventException;

	/**
	 * ManifestList 한국세관쪽으로 다운로드
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList( ManifestListCondVO manifestListCondVO , SignOnUserAccount account) throws EventException;

	/**
	 * Manifest Summary 정보 수정
	 * @param ManifestSmryCondVO manifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(ManifestSmryCondVO manifestSmryCondVO) throws EventException;

	/**
	 * Manifest 정보 삭제
	 *
	 * @param ManiSumCondVO maniSumCondVO
	 * @throws EventException
	 */
	public void manageManifestSummaryInfo(ManiSumCondVO maniSumCondVO) throws EventException;

	/**
	 * VSL, Manifest 정보 조회
	 *
	 * @param VslInfoNManifestCondVO vslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @throws EventException
	 */
	public VslInfoNManifestVO manageVslInfoNManifestList(VslInfoNManifestCondVO vslInfoNManifestCondVO) throws EventException;

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException;

	/**
	 * Manifest를 전송 후 정보 UPDATE
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @exception EventException
	 */
	public void transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException;

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
     * InBound Empty MSN 저장
     * @param MsnNoCondVO[] msnNoCondVOs
     * @throws EventException
     */
    public void manageMsnNo(MsnNoCondVO[] msnNoCondVOs) throws EventException;

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param SndCorrVO sndCorrVO
	 * @throws EventException
	 */
	public void addSndDtCorrInfo(SndCorrVO sndCorrVO) throws EventException;

	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 * @param Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs
	 * @param SignOnUserAccount account
	 * @return Kor24ManifestCrsChkInfoVO
	 * @exception EventException
	 */
	public Kor24ManifestCrsChkInfoVO manageCrossCheck(Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 *
	 *
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public List<Kor24ManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(Kor24MrnNoVO manifestInfoVO) throws EventException;

	/**
	 *
	 *
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return Kor24MrnNoVO
	 * @throws EventException
	 */
	public Kor24MrnNoVO searchManifestCrsChkInfoSumKorList(Kor24MrnNoVO manifestInfoVO) throws EventException;

}