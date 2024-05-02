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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.clt.framework.core.layer.event.EventException;
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
public interface AncsManifestListDownloadBC {

	 /**
     * 벨기에 세관 신고 대상 VVD 목록 조회
     * 
     * @param CstmsVvdListCondVO condVo
     * @param SignOnUserAccount account
     * @return List<CstmsVvdVO>
     * @throws EventException
     */
	
	public List<CstmsVvdVO> searchCstmsVvdList(CstmsVvdListCondVO condVo, SignOnUserAccount account) throws EventException;

	 /**
	 * 벨기에 세관 신고 대상 VVD 목록 상세 조회
	 * 
	 * @param cstmsVvdDtlListCondVO
	 * @return
	 * @throws EventException
	 */
	
	public List<CstmsVvdDtlVO> searchCstmsVvdDtlList(CstmsVvdDtlListCondVO cstmsVvdDtlListCondVO) throws EventException;

	 /**
	 * ANCS 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 BL 테이블로 부터 다운 로드 받음
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageManifest(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException;
	
	 /**
     * 벨기에 세관 저장정보 삭제
     * 
     * @param CstmsVvdListCondVO condVo
     * @return String
     * @throws EventException
     */
	
	public String deleteCstmsAncsManifest(CstmsVvdListCondVO condVo) throws EventException;
	
	 /**
	 * 벨기에 세관 입항 신고를 위한 VVD별 입항 정보 조회
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return VesselArrivalVO
	 * @exception EventException
	 */
	
	public VesselArrivalVO searchVesselArrival2(VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	 /**
	 * 벨기에 세관 VVD별 입항 정보를 관리
	 * 
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	
	public void manageAncsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 벨기에 세관 VVD별 입항 정보를 관리
	 * 
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException;

	 /**
	 * ANCS 세관 신고용 VVD 정보 조회
	 * 
	 * @param cstmsVvdInfoCondVO
	 * @return
	 * @throws EventException
	 */
	
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException;

	 /**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * 
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 *  세관 적하 목록 상세 정보를 조회
	 * 
	 * @param CstmsMfDtlCondVO cstmsMfDtlListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	
	public List<ManifestListDetailVO> searchCstmsMfDtlList(CstmsMfDtlCondVO cstmsMfDtlListCondVO)
			throws EventException;

	 /**
	 *  Customr, Container, Commodity(CM) 등의 BL 정보를 세관테이블 내로 다운로드 받고 이를 조회/확인한다.
	 * 
	 * @param cstmsBlCondVO CstmsBlCondVO
	 * @return AncsCstmsBlCVO
	 * @throws EventException
	 */
	
	public AncsCstmsBlCVO inquiryBlData(CstmsBlCondVO cstmsBlCondVO) throws EventException;

	 /**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다
	 * @param cstmsBlVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * ANCS 세관 테이블에서 Notify Address 정보 조회
	 * 
	 * @param CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO
	 * @param SignOnUserAccount account
	 * @return List<CstmsNtfyAddrVO>
	 * @exception EventException
	 */
	
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr (CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO, SignOnUserAccount account) throws EventException;

	 /**
	 * SendLog History
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchAncsLane() throws EventException;

	 /**
	 * ANCS 세관 관련 Notify Address를 관리 한다
	 * 
	 * @param CstmsNtfyAddrVO[] cstmsNtfyAddrVOs
     * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	
	public void manageCstmsNtfyAddr(CstmsNtfyAddrVO[] cstmsNtfyAddrVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * 세관 관련 선박 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param vesselInfoVOs
	 * @param account
	 * @throws EventException
	 */
	
	public void manageCstmsVesselInfo(VesselInfoVO[] vesselInfoVOs, SignOnUserAccount account) throws EventException;

	
}