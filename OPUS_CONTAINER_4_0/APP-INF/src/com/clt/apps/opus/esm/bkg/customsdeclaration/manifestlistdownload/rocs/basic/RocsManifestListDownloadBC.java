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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HistoryListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface RocsManifestListDownloadBC {

	 /**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRN(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN Detail 정보를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRNInfo(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN Detail 정보를 조회한다.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRNInfo(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.
	 * 
	 * @param String frmCrnNumber
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> searchCRN(String frmCrnNumber, String vslCd, String skdVoyNo, String skdDirCd)
			throws EventException;

	 /**
	 * 멀티 이벤트 처리<br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 등록 및 수정한다.
	 * 
	 * @param CrnVO crnVo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */

	public int manageCRN(CrnVO crnVo, SignOnUserAccount account) throws EventException;

	 /**
	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 한다.
	 * 
	 * @param ManifestConfirmationVO[] manifestConfirmationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void confirmManifestList(ManifestConfirmationVO[] manifestConfirmationVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 *ROCS(ROTTERDAM) 세관 Manifest 신고용 B/L 정보를 삭제한다.
	 * 
	 * @param List<BlKeyVO> blKeyVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void removeBl(List<BlKeyVO> blKeyVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 조회 이벤트 처리<br>
	 * Rocs를 통과하는 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * ROCS 세관에 적하목록을 신고하기 위해 필요한 아이템을 저장하는 오퍼레이션
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 * 조회 이벤트 처리<br>
	 * 세관 신고 대상 List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForRocsBl(ManifestListCondVO manifestListCondVO)
			throws EventException;

	 /**
		 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
		 * 
		 * @param vesselCondVO VesselCondVO
		 * @param SignOnUserAccount account
		 * @return List<VesselArrivalVO>
		 * @exception EventException
		 */
		public List<VesselArrivalVO> searchVesselArrival(VesselCondVO vesselCondVO,SignOnUserAccount account) throws EventException;

	 /**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vesselCondVO VesselCondVO
	 * @return List<ManifestListVO>
	 * @exception EventException
	 */
	public List<ManifestListVO> searchManifestList(VesselCondVO vesselCondVO) throws EventException;

	 /**
	 * 추가 이벤트 처리<br>
	 * download 후 B/L을 추가 할 수 있다.<br>
	 * 
	 * @param BlVO blVO
	 * @param SignOnUserAccount account
	 * @throws Exception
	 * @throws DAOException
	 */
	public void addBl(BlVO blVO, SignOnUserAccount account) throws EventException;

	 /**
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.
	 * 
	 * @param BlSeqVO[] blSeqVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlSeq(BlSeqVO[] blSeqVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @throws EventException
	 */
	public void modifyBlReceivedSts(RocsManifestTransmitVO rocsManifestTransmitVO) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param List<RocsManifestTransmitVO> rocsManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlSndSts(List<RocsManifestTransmitVO> rocsManifestTransmitVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlPolCd(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param String vslCallRefNoOld
	 * @param String vslCallRefNoNew
	 * @return List<CrnVO>
	 * @throws EventException
	 */
	public List<CrnVO> checkDuplicateCrnNo(String vslCallRefNoOld, String vslCallRefNoNew) throws EventException;
	
	 /**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param String vslCallRefNoOld
	 * @param String vslCallRefNoNew
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCrnNo(String vslCallRefNoOld, String vslCallRefNoNew,SignOnUserAccount account) throws EventException;

	 /**
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.
	 * 
	 * @param rcvHistCondVO RcvHistCondVO
	 * @return List<RocsSearchRocsReceiveListVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException;

	 /**
	 * Rotterdam세관에서 받은 Send edi 현황정보를 가져온다.
	 * 
	 * @param transmitHistCondVO
	 * @return
	 * @throws EventException
	 */
	public List<TransmitHistVO> searchTransmitHist(TransmitHistCondVO transmitHistCondVO) throws EventException;

	 /**
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.
	 * 
	 * @param historyListCondVO HistoryListCondVO
	 * @return List<RecieveHistLogVO>
	 * @exception EventException
	 */
	public List<RecieveHistLogVO> searchHistoryList(HistoryListCondVO historyListCondVO) throws EventException;

	 /**
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다.
	 * 
	 * @param transmitHistListCondVO
	 * @return
	 * @throws EventException
	 */
	public List<TransmitHistVO> searchTransmitHistList(TransmitHistListCondVO transmitHistListCondVO)
			throws EventException;

	 /**
	 * Rotterdam세관에서 받은 Sent/Receive 현황정보를 가져온다.
	 * 
	 * @param receiveLogCondVO ReceiveLogCondVO
	 * @return List<ReceiveLogVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException;

	 /**
	 * ESM_BKG_1135 : SEARCH <br>
	 * ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchRocsLane() throws EventException;

	 /**
	 * ESM_BKG_1135 : MULTI <br>
	 * ROCS 의 CRN List 화면에서 Lane 정보 수정<br>
	 * 
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRocsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account) throws EventException;
	
}