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
*------------------------------------------------------
* History
* 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
* 2011.04.05 이재위 [CHM-201109537-01] [BKG] Manifest : ENS Monotiring Function화면 개발
* 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
* 2011.09.27 이수영 [CHM-201113324-01] Inbound 배정 EAI-Webservice 개발
* 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
* 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
* 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
* 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
* 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
* 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
* 2013.09.06 김보배 [CHM-201325976] Israel FROB 신고 결과 조회 화면 생성 요청
* 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
* 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
* 2014.04.29 신규정 [CHM-201429559]  ACI - CRN create 화면의 CRN delete 팝업 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrMFListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface Eur24ManifestDownloadBC {

	 /**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @param account SignOnUserAccount 
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * ENS쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_EUR_BL,BKG_CSTMS_EUR_CNTR,BKG_CSTMS_EUR_CNTR_MF,BKG_CSTMS_EUR_DG_CGO,BKG_CSTMS_EUR_SEAL_NO,BKG_CSTMS_EUR_CUST) <br>
	 * 
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 구주 OB쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_EUR_IO_BL,BKG_CSTMS_EUR_IO_CNTR,BKG_CSTMS_EUR_IO_CNTR_MF,BKG_CSTMS_EUR_IO_DG_CGO,BKG_CSTMS_EUR_IO_SEAL_NO,BKG_CSTMS_EUR_IO_CUST) <br>
	 * 
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifestOB(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @param SignOnUserAccount account
	 * @return Eur24BlInfoVO
	 * @throws EventException
	 */
	public Eur24BlInfoVO searchBlInfo(Eur24BlInfoCondVO eur24BlInfoCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @param SignOnUserAccount account
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselArrival(Eur24VesselArrivalCondVO vesselArrivalCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBL(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 입력한다.
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVesselArrival(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException;

	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvd(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.
	  * Arrival Notice용<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvdForAN(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * Europe Advanced Manifest - ENS Report 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSReport(Eu24EnsListVO eu24EnsListVO) throws EventException;

	 /**
	 * Europe Advanced Manifest - ENS Monitoring 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSMonitoring(Eu24EnsListVO eu24EnsListVO) throws EventException;

	 /**
	  * BL로 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> search1stEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * @param CustomsSetupVO customsSetupVO
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchCustomsSetupList(CustomsSetupVO customsSetupVO) throws EventException;

	 /**
	 * Europe Customs 코드를 관리한다.<br>
	 * @param CustomsSetupVO[] customsSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageEU24CustomsSetup(CustomsSetupVO[] customsSetupVOs,SignOnUserAccount account) throws EventException;

	 /**
	 * MDM LOCATION 조회<br>
	 * 
	 * @param String cntCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmLocationPort(String cntCd) throws EventException;

	 /**
	 * MDM YARD 조회<br>
	 * @param String portCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmYardTmlcode(String portCd) throws EventException;

	 /**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * @param  String blNo 
	 * @param  String vvd 
	 * @param  String cntrNo 
	 * @return List<Eur24BlCntrMFListVO>
	 * @throws EventException
	 */
	public List<Eur24BlCntrMFListVO> searchContainerMF(String blNo, String vvd, String cntrNo) throws EventException;

	 /**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24BlInfoVO eur24BlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfo(Eur24BlInfoVO eur24BlInfoVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24RcvMsgVO>  
	 * @throws EventException
	 * @exception EventException
	 */
	public List<Eur24RcvMsgVO> searchCstmsRcvMsg(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	 /**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param String rvis_n1st_clpt_cd  
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException 
	 * @exception EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchCstmsOfficeIdByPort(String rvis_n1st_clpt_cd) throws EventException;

	 /**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException;

	 /**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIFIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException;

	 /**
	 * ENS화면 - POL이 EU 포트인지 체크를 위해 EU포트 조회<br>
	 * @param Eu24CountryListVO eu24CountryListVO
	 * @return List<Eu24CountryListVO>
	 * @throws DAOException
	 */
	public List<Eu24CountryListVO> searchEU24CountryList (Eu24CountryListVO  eu24CountryListVO) throws EventException;

	 /**
	 * Europe Advanced Manifest-Error Code Table 조회<br>
	 * @param EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO
	 * @return List<EU24RcvErrorCodeTableVO>
	 * @throws EventException
	 */
	public List<EU24RcvErrorCodeTableVO> searchEU24RcvErrorCodeTable(EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO) throws EventException;

	 /**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchCstmsENSPofeList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEuPolByVvd(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestOBList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	  * EXS용(1121) BL 정보 조회를 위해 BL_NO로 VVD,POL,POD 등을 먼저 조회한다.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEuOBVvdByBL(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * Europe Advanced Manifest - EXS Report 조회<br>
	 * 
	 * @param Eu24ExsListOBVO eu24ExsListOBVO
	 * @return List<Eu24ExsListOBVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24ExsListOBVO> searchEXSReportOB(Eu24ExsListOBVO eu24ExsListOBVO) throws EventException;

	 /**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryOBVO eU24EDIHistoryOBVO
	 * @return List<EU24EDIHistoryOBVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryOBVO> searchEU24EDIHistoryOB(EU24EDIHistoryOBVO eU24EDIHistoryOBVO) throws EventException;

	 /**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24RcvMsgVO>  
	 * @throws EventException
	 * @exception EventException
	 */
	public List<Eur24RcvMsgVO> searchCstmsRcvMsgOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @return Eur24BlInfoVO
	 * @throws EventException
	 */
	public Eur24BlInfoVO searchBlInfoOB(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBLOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	 /**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24BlInfoVO eur24BlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfoOB(Eur24BlInfoVO eur24BlInfoVO, SignOnUserAccount account) throws EventException;

	 /**
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 삭제 <br>
	 *  
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @exception EventException
	 */
	public void manageMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException;

	 /**
	 * ESM_BKG_1107 : MULTI03 <br>
	 * 메뉴얼 MRN 재입력 <br>
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @exception EventException
	 */
	public void reactivateMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException;

	 /**
	 * ESM_BKG_1146 : MULTI02 <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Save & Select <br>
	 * 
	 * @param EurCrnRcvMsgVO[] eurCrnRcvMsgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePrevDocNo(EurCrnRcvMsgVO[] eurCrnRcvMsgVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * ESM_BKG_1146 : SEARCH <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No pop-up 조회<br>
	 * 
	 * @param EurCrnRcvMsgVO eurCrnRcvMsgVO
	 * @return List<EurCrnRcvMsgVO>
	 * @throws EventException
	 */
	public List<EurCrnRcvMsgVO> searchPrevDocNo(EurCrnRcvMsgVO eurCrnRcvMsgVO)throws EventException;

	 /**
	 * Europe Advanced Manifest - EXS Monitoring 조회<br>
	 * 
	 * @param Eu24EXSListVO eu24EXSListVO
	 * @return List<Eu24EXSListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EXSListVO> searchEXSMonitoring(Eu24EXSListVO eu24EXSListVO) throws EventException;

	 /**
	  * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchPreEUportByVvd(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * Finland (IE344) / BL 로 해당하는 vvd 의 pre EU Port 를 조회
	 * @param  ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchPreEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchVesselFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchBlFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws EventException;

	 /**
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다. (ESM_BKG_1171)
	 * 
	 * @param Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageFIVesselArrival(Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * 해당 ENS B/L 정보를 삭제한다.
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifest(ManifestListDetailVO[] manifestListDetailVOs) throws EventException;
	
	/** 
	 * 삭제 이벤트 처리<br>
	 * 해당 VVD에 존재 하는 모든 EXS B/L 정보를 삭제한다.
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifestEXS(ManifestListDetailVO[] manifestListDetailVOs) throws EventException;
	
	 /**
	 * EU A/N (ESM_BKG_1104) 에서 구주스탭이 해당 VVD 의 모든 MRN 을 삭제
	 * 
	 * @param eur24VesselArrivalNoticeDetailVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteAllMrn(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException;
	
}