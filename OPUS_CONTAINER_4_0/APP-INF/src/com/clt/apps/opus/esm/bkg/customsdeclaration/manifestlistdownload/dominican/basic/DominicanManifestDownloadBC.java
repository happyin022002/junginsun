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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface DominicanManifestDownloadBC {

	 /**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	 /**
	 * BackEndJob을 실행.
	 * 
	 * @param String usrId
	 * @param ManifestListCondVO manifestListCondVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(String usrId, ManifestListCondVO manifestListCondVO, String pgmNo) throws EventException;

	 /**
	 * xml을 생성해서 로컬로 다운로드<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(ManifestListCondVO manifestListCondVO) throws EventException;	
}