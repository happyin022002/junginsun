/*========================================================= 
*Copyright(c) 2009 CyberLogitec 
*@FileName : ManifestListDownloadBC.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface CndManifestListDownloadBC {

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 *
	 * @param manifestListCondVO 조건
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * Bkg_Cstms_Adv_Bl 의 mf_sts_cd = 'D'로 수정
	 *
	 * @param manifestListDetailVOs ManifestList정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고용 VVD 정보 조회
	 *
	 * @param cstmsVvdInfoCondVO 조회조건
	 * @return List<CstmsVvdInfoVO>
	 * @throws EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException;

	 /**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 *
	 * @param cstmsVvdInfoVOs VVD 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고용 VVD별 Reference No 생성
	 *
	 * @param cstmsVvdRefNoCondVO 조건
	 * @return CstmsVvdRefNoVO
	 * @throws EventException
	 */
	public CstmsVvdRefNoVO createCstmsVvdRefNo(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException;

	 /**
	 * 세관 신고용 VVD 정보 조회
	 *
	 * @param vesselCondVO 조회조건
	 * @return List<VesselVO>
	 * @throws EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException;

	 /**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 *
	 * @param vesselInfoVOs VVD정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsVesselInfo(VesselInfoVO[] vesselInfoVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * ETL Data 조회
	 *
	 * @param cstmsVvdListCondVO 조회조건
	 * @return List<CstmsVvdVO>
	 * @throws EventException
	 */
	public List<CstmsVvdVO> searchCstmsVvdList(CstmsVvdListCondVO cstmsVvdListCondVO) throws EventException;

	 /**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 *
	 * @param vesselArrivalCondVO 조회조건
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException;

	 /**
	 * 세관 신고시 필요한 Vessel Arrival 정보를 수정한다.
	 *
	 * @param vesselArrivalVO Vessel Arrival 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException;

	 /**
	 * B/L Inquiry화면에서 세관 신고를 위해 다운로드 받은 B/L을 B/L 단위로 조회<br>
	 *
	 * @param blCondVO 조회조건
	 * @return List<BlDetailVO>
	 * @throws EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException;

	 /**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다
	 *
	 * @param cstmsBlVOs BL정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * Hub정보취득
	 *
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws EventException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws EventException;

	 /**
	 * AnType 변경
	 *
	 * @param avcNoteSetUpInfoVOs An Type 정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageAvcNoteSetUpInfo(AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 * 수신메시지 저장
	 *
	 * @param cstmsRcvLogVO 수신메시지
	 * @return CndCstmsRcvLogVO
	 * @throws EventException
	 */
	public CstmsRcvLogVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException;

	 /**
	 * 선박별 인증서 만료일 (Certificate Expire Date) 업로드
	 *
	 * @param vesselInfoVO 선박정보
	 * @throws EventException
	 */
	public void loadVslCertiExpDt(VesselInfoVO vesselInfoVO) throws EventException;

	 /**
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회
	 *
	 * @param houseBlCondVO 조회조건
	 * @return List<HouseBlDetailVO>
	 * @throws EventException
	 */
	public List<HouseBlDetailVO> checkHouseBlDataList(HouseBlCondVO houseBlCondVO) throws EventException;

	 /**
	 * CRN 정보 조회
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @return List<CndCstmsVslCrnNoVO>
	 * @throws EventException
	 */
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException;

	 /**
	 * CRN 정보를 삭제한다..
	 *
	 * @param cndCstmsVslCrnNoVO CRN정보
	 * @throws EventException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * 해당 VVD에 존재 하는 모든 B/L 정보를 삭제한다.
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifest(ManifestListDetailVO[] manifestListDetailVO) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * 해당 VVD에 존재 하는 모든 B/L 정보를 삭제한다.
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifestBl(ManifestListDetailVO[] manifestListDetailVO) throws EventException;

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs
	 * @param SignOnUserAccount account
	 * @param String CntCd
	 * @param String aiDiv
	 * @exception EventException
	 */
	public void manageCstmsAmendManifest(CstmsManifestAmendmentVO[] CstmsManifestAmendmentVOs, SignOnUserAccount account, String CntCd, String aiDiv) throws EventException;

}

