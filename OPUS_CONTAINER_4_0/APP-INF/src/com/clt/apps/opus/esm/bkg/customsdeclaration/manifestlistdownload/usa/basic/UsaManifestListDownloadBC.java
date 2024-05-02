/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestListDownloadBC.java
*@FileTitle : ManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListModVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.clt.syscommon.common.table.BkgCstmsIbdHisVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmPortVO;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface UsaManifestListDownloadBC {

	 /**
	 * 국가별 세관 관리 항목 setup 정보 조회<br>
	 *
	 * @param SetupListCondVO setupListCondVO
	 * @return List<SetupListDetailVO>
	 * @exception EventException
	 */
	public List<SetupListDetailVO> searchSetupList(SetupListCondVO setupListCondVO) throws EventException;

	 /**
	 *  국가 코드 조회<br>
	 *  UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 *
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryCodeList() throws EventException;

	 /**
	 *  포트 코드 조회<br>
	 *  UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 *
	 * @param String cntCd
	 * @return List<MdmPortVO>
	 * @exception EventException
	 */
	public List<MdmPortVO> searchPortCodeList(String cntCd) throws EventException;

	 /**
	 * 국가별 세관 관리 항목 setup 정보 저장<br>
	 *
	 * @param SetupListModVO setupListModVO SetupListModVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySetupList(SetupListModVO setupListModVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 국가별 세관 관리 항목 setup 정보 삭제<br>
	 *
	 * @param SetupKeyVO setupKeyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySetupStatus(SetupKeyVO setupKeyVO, SignOnUserAccount account) throws EventException;

	 /**
	 * Customer, Container, Commodity(CM) 등의 BL 정보를 세관테이블 내로 다운로드 받고 이를 조회/확인한다.<br>
	 *
	 * @param BlCondVO blCondVO
	 * @return List<BlDetailVO>
	 * @exception EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException;

	 /**
	 * User Auth List 조회<br>
	 *
	 * @param AuthSetupListCondVO authSetupListCondVO
	 * @return List<AuthSetupListVO>
	 * @exception EventException
	 */
	public List<AuthSetupListVO> searchAuthSetupList (AuthSetupListCondVO authSetupListCondVO) throws EventException;

	 /**
	 * Disposition Code Description 조회<br>
	 *
	 * @param BlCondVO blCondVO
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchCodeDesc(BlCondVO blCondVO) throws EventException;

	 /**
	 * User Auth List 정보 저장<br>
	 *
	 * @param authSetupListVO AuthSetupListVO[]
	 * @return int
	 * @exception EventException
	 */
	public int manageAuthSetupList(AuthSetupListVO[] authSetupListVO) throws EventException;

	 /**
	 * 사용자의 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 *
	 * @param String userId
	 * @return List<UserInfoVO>
	 * @exception EventException
	 */
	public List<UserInfoVO> searchUserAuthority (String userId) throws EventException;

	 /**
	 * 사용자의 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 *
	 * @param String userId
	 * @param String pgmNo
	 * @return String
	 * @exception EventException
	 */
	public String searchUserAuthYn (String userId, String pgmNo) throws EventException;

	 /**
	 * 사용자의 MI - MULTI 권한을 확인하여 버튼 Disable 여부를 결정한다.<br>
	 *
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String searchUserAuthMiMultiYn (String userId) throws EventException;

	 /**
	 * 로그인 한 사용자의 권한을 조회한다.<br>
	 *
	 * @param String userId
	 * @param String ofcCd
	 * @return AuthSetupListVO
	 * @exception EventException
	 */
	public AuthSetupListVO searchUserAuthority (String userId, String ofcCd) throws EventException;

	 /**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.<br>
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고 대상 List를 세관 테이블 내로 다운받는 작업을 BackEndJob으로 등록한다.<br>
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVO, SignOnUserAccount account) throws EventException;

	 /**
	 * US AMS:Manifest Transmit(MI) 조회.<br>
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMiManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * Container 정보 조회
	 *
	 * @param ContainerListCondVO containerListCondVO
	 * @return List<ContainerListRsltVO>
	 * @exception EventException
	 */
	public List<ContainerListRsltVO> searchContainerList(ContainerListCondVO containerListCondVO) throws EventException;

	 /**
	 * Container 정보 저장
	 *
	 * @param ContainerListRsltVO[] cntrListRsltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContainerList(ContainerListRsltVO[] cntrListRsltVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * bl 수정<br>
	 *
	 * @param BlDetailVO blDetailVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void correctBl (BlDetailVO blDetailVO, SignOnUserAccount account) throws EventException;

	 /**
	 * bl 삭제<br>
	 *
	 * @param BlKeyVO blKeyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeBl (BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException;

	 /**
	 * bl 재사용<br>
	 *
	 * @param BlKeyVO b
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reactivateBl (BlKeyVO b, SignOnUserAccount account) throws EventException;

	 /**
	 * BL 정보 변경 내역 저장<br>
	 * @param String blKey
	 * @param String usrId
	 * @param String hisTpId
	 * @return BkgCstmsIbdHisVO
	 * @exception EventException
	 */
	public BkgCstmsIbdHisVO addBlHistory (String blKey, String usrId, String hisTpId) throws EventException;

	 /**
	 * BL 정보 변경 상세 내역 저장<br>
	 * @param BkgCstmsIbdHisVO bkgCstmsIbdHisVO
	 * @param String ctnt
	 * @param String preCtnt
	 * @param String curCtnt
	 * @exception EventException
	 */
	public void addBlDetailHistory (BkgCstmsIbdHisVO bkgCstmsIbdHisVO, String ctnt, String preCtnt, String curCtnt) throws EventException;

	 /**
	 * Container Manifest 정보를 조회한다.
	 *
	 * @param ContainerManifestCondVO containerManifestCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchContainerManifest(ContainerManifestCondVO containerManifestCondVO) throws EventException;

	 /**
	 * 전송대상 Container Manifest 데이터를 수정한다.
	 *
	 * @param ConatinerModificationtVO[] containerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] containerVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 조회 한다
	 *
	 * @param DispoCdListCondVO dispoCdListCondVO
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchDispositionCdList(DispoCdListCondVO dispoCdListCondVO) throws EventException;

	 /**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록, 수정 및 삭제 한다
	 *
	 * @param DispoCdDetailVO[] dispoCdDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDispositionCdList(DispoCdDetailVO[] dispoCdDetailVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회
	 * @param HouseBlCondVO houseBlCondVO
	 * @return List<HouseBlDetailVO>
	 * @exception EventException
	 */
	public List<HouseBlDetailVO> checkHouseBlDataList(HouseBlCondVO houseBlCondVO) throws EventException;

	 /**
	 * 0408, 0533 등에서 입력한 내용을 저장한다.<br>
	 *
	 * @param InbondVO[] inbondVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyInbondData(InbondVO[] inbondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * P/MIB NO Assign 을 위한 조회및 MAX 시퀀스 갱신<br>
	 *
	 * @param InBondNumberVO[] inBondNumberVO
	 * @return List<InBondNumberDetailVO>
	 * @exception EventException
	 */
	public List<InBondNumberDetailVO> assignInBondNumber(InBondNumberVO[] inBondNumberVO) throws EventException;

	 /**
	 * BKG_CSTMS_ADV_BL에 MI, AI 전송일자를 갱신한다.<br>
	 *
	 * @param String blNo
	 * @param String command
	 * @throws Exception
	 */
	public void modifyTransStage(String blNo, String command) throws EventException;

	 /**
	 * BKG_CSTMS_ADV_BL에 MI, AI 전송일자 및 cancel status를  갱신한다.<br>
	 *
	 * @param String blNo
	 * @param String cstmsMfTpCd
	 * @param cstmsTrsmStsCd
	 * @throws Exception
	 */
	public void modifyTransStage2(String blNo, String cstmsMfTpCd, String cstmsTrsmStsCd) throws EventException;

	 /**
	 * TI전송 기록을 BKG_CSTMS_ADV_IBD에 갱신한다.<br>
	 *
	 * @param String blNo
	 * @param String usrId
	 * @param String ofcCd
	 * @return int
	 * @throws Exception
	 */
	public int modifyTiInfo(String blNo, String usrId, String ofcCd) throws EventException;

	 /**
	 * modifyInbondArrFlagByBl 정보를 생성한다.<br>
	 * backEndJob으로 구동하므로, 책임테이블 예외로 한다.<br>
	 *
	 * @param String blNo
	 * @param String transGubun
	 * @throws Exception
	 */
	public void modifyInbondArrFlagByBl(String blNo, String transGubun) throws EventException;

	/**
	 * updateCntrArrExpByBlCntr 컨테이너별로 Arr, Exp 정보를 갱신한다.<br>
	 *
	 * @param String blNo
	 * @param String cntrNo
	 * @param String transGubun
	 * @param String arrDt
	 * @param String arrTime
	 * @throws Exception
	 */
	public void updateCntrArrExpByBlCntr(String blNo, String cntrNo, String transGubun, String arrDt, String arrTime) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 추가한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws EventException
	 */
	public int addCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 Cancus_cntr 결과를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws EventException
	 */
	public int modifyCNRUInfoAtCanada(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_IBD 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws Exception
	 */
	public int modifyExpAccpDtAtBl(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 NVOCC 중 BKG_CSTMS_ADV_CNTR 를 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws Exception
	 */
	public int modifyExpAccpDtAtCntr(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 Nak 결과를 IBD 테이블에 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws Exception
	 */
	public int modifyResultCdByBl(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 Nak 결과를 IBD 테이블에 갱신한다.<br>
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws Exception
	 */
	public int modifyIbd(UsaRcvMsgVO usaRcvMsgVO) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 결과를 IBD 테이블에 갱신한다.(CSTMS_CLR_CNG_FLG)<br>
	 *
	 * @param bkgCstmsAdvIbdVOs List<BkgCstmsAdvIbdVO>
	 * @throws EventException
	 */
	public void modifyIbdCstmsClrCngFlg(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) throws EventException;

	 /**
	 * Actual Vvd 조회
	 *
	 * @param VesselCondVO vesselCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException;

	 /**
	 * ESM_BKG_1144 SNP/Broker Nomination 조회
	 *
	 * @param OrgPartyVO  orgPartyVO
	 * @return List<OrgPartyVO>
	 * @exception EventException
	 */
	public  List<OrgPartyVO> searchOrgPartyList(OrgPartyVO  orgPartyVO) throws EventException;

	 /**
	 * ESM_BKG_1144 SNP/Broker Nomination 저장
	 *
	 * @param OrgPartyVO[] orgPartyVOs
	 * @exception EventException
	 */
	public void manageOrgPartyInfo(OrgPartyVO[]  orgPartyVOs) throws EventException;

	 /**
	 * 미세관 응답메세지 수신 결과를 BL 테이블에 갱신한다.<br>
	 * - CUSTMS_LOC_CD
	 *
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws Exception
	 */
	public int modifyAdvancedBl(UsaRcvMsgVO usaRcvMsgVO);

	 /**
	 * Customer Status Notice 정보 조회<br>
	 *
	 * @param hndlOfcCd
	 * @return UsCustomsStatusNoticeVO
	 * @exception EventException
	 */
	public UsCustomsStatusNoticeVO searchUsCustomsStatusNoticeInfo(String hndlOfcCd)  throws EventException;

	 /**
	 * Customer Status Notice 정보 등록,수정<br>
	 *
	 * @param usCustomsVO
	 * @exception EventException
	 */
	public void manageUsCustomsStatusNoticeInfo(  UsCustomsStatusNoticeVO usCustomsVO )  throws EventException;

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

}