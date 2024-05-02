/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanManifestListDownloadBCImpl.java
 *@FileTitle : ESM_BKG-0462
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.05.18 김승민
 * 1.0 Creation
 * ------------------------------------------------------
 * history
 * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러( WGT 정수자리수가 7자리 이상인지 체크함.)
 * 2011.04.13 김영철 [] R4J 메소드 주석 기술부분 보완( searchWgtErrBkgNo)
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.ApprovalCstmsCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhRoutVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.CstmsJpWhVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface JapanManifestListDownloadBC {

	/**
	 * VVD, Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param JapanManifestModificationVO[] japanManifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForDl(JapanManifestModificationVO[] japanManifestModificationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VVD, Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param JapanManifestModificationVO[] japanManifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForMfs(JapanManifestModificationVO[] japanManifestModificationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VVD, Port 등 입력 후 조회한 세관 CMF 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 *
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForCmf(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException;

	/**
	 * 일본세관 신고 대상 Customer 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param MfrCustModificationVO mfrCustModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCust(MfrCustModificationVO mfrCustModificationVO, SignOnUserAccount account) throws EventException;

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param MfrMndModificationVO mfrCustModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrMnd(MfrMndModificationVO mfrCustModificationVO, SignOnUserAccount account) throws EventException;

	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 저장한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 *
	 * @param BlKeyVO blKeyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reactivateBl(BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException;

	/**
	 * 일본세관 신고 대상 Container 정보를 세관 테이블 내에 생성한다.<br>
	 *
	 * @param MfrCntrModificationVO[] mfrCntrModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCntr(MfrCntrModificationVO[] mfrCntrModificationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 일본세관 신고 대상 Customer 정보를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchMfrCust(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchMfrMnd(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 일본세관 신고 대상 Container 정보를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMfrCntr(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * download 후 B/L을 추가 할 수 있다.<br>
	 *
	 * @param BlVO blVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBl(BlVO blVO, SignOnUserAccount account) throws EventException;

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchManifestListForDl(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return JapanContainerVO
	 * @exception EventException
	 */
	public JapanContainerVO searchManifestListForMfs(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestListForCmf(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(DOR 데이터) 를 조회한다.<br>
	 *
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForDor() throws EventException;
	/**
	 * 일본 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @return List<VesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<JapanVesselArrivalVO> searchVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO) throws EventException;

	/**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 *
	 * @param List<JapanTransmitBlKeyVO> japanBlKeyVOs
	 * @exception EventException
	 */
	public void modifyMsgStatus(List<JapanTransmitBlKeyVO> japanBlKeyVOs) throws EventException;

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_BL) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception EventException
	 */
	public List<ApprovalCstmsCdVO> searchAproNoFromJpBl(ApprovalCstmsCdVO approvalCstmsCdVO) throws EventException;

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival (from BKG_CSTMS_JP_WH_ROUT) 조회<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @return List<ApprovalCstmsCdVO>
	 * @exception EventException
	 */
	public List<ApprovalCstmsCdVO> searchAproNoFromWhRout(ApprovalCstmsCdVO approvalCstmsCdVO) throws EventException;

	/**
	 * [ESM_BKG_1510]
	 * Approval Number and Place of Arrival 목록 저장<br>
	 *
	 * @param ApprovalCstmsCdVO approvalCstmsCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApprovalCstmsCd(ApprovalCstmsCdVO approvalCstmsCdVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 조회<br>
	 *
	 * @param CstmsJpWhVO cstmsJpWhVO
	 * @return List<CstmsJpWhVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhVO> searchCstmsJpWh(CstmsJpWhVO cstmsJpWhVO) throws EventException;

	/**
	 * [ESM_BKG_1511]
	 * Bonded Place Code 목록 저장<br>
	 *
	 * @param CstmsJpWhVO[] cstmsJpWhVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsJpWh(CstmsJpWhVO[] cstmsJpWhVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1512]
	 * CSTMS_CD Combo Item 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhRoutVO> getComboCstmsCd(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws EventException;

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 조회<br>
	 *
	 * @param CstmsJpWhRoutVO cstmsJpWhRoutVO
	 * @return List<CstmsJpWhRoutVO>
	 * @exception EventException
	 */
	public List<CstmsJpWhRoutVO> searchCstmsJpWhRout(CstmsJpWhRoutVO cstmsJpWhRoutVO) throws EventException;

	/**
	 * [ESM_BKG_1512]
	 * Approval Number and Place of Arrival 목록 저장<br>
	 *
	 * @param CstmsJpWhRoutVO[] cstmsJpWhRoutVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsJpWhRout(CstmsJpWhRoutVO[] cstmsJpWhRoutVOs, SignOnUserAccount account) throws EventException;


}
