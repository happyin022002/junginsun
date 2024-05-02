/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsTransmissionBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2011.11.15 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2012.04.26 김보배 [CHM-201217062] [BKG] Ghana Customs Manifest 전송 기능 개발 요청
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
 * 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface EurCustomsTransmissionBC {

	 /**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  String vvdCd
	 * @param  String polCd
	 * @param  String podCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUvi(String vvdCd, String polCd, String podCd) throws EventException;

	 /**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.(Eur-CTA)<Br>
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	 /**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.(SITPRO)
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;

	 /**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * 
	 * @param  String rcvMsg
	 * @param  String userId
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException;

	 /**
	 * SIT PRO화면에서 메인 그리드 조회
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return List<SitProCargoManifesDetailVO>
	 * @throws EventException
	 */
	public List<SitProCargoManifesDetailVO> searchSitProList(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException;

	 /**
	 * BackEndJob을 실행.(CTA)
	 * 
	 * @param account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, 
			ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException;

	 /**
	 * BackEndJob을 실행.(Sitpro)
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(String usrId,	ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException;

	 /**
	 * BackEndJob을 실행.(Sitpro LdfDown)
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startLdfDownBackEndJob(String usrId,	ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException;

	
	 /**
	 * 대상 BKG_NO 리스트 존재여부를 조회한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistBkgNoList(ManifestTransmitVO manifestTransmitVO) throws EventException;

	 /**
	 * sitpro - vvd와 port 존재여부를 조회한다.<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistVvdPort(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException;

	 /**
	 * 구주 SIT PRO프로그램에서 ENS Download 메서드로 사용함<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @param String[] bkgNos
	 * @return List<SitProENSDownExcelVO>
	 * @throws EventException
	 */
	public List<SitProENSDownExcelVO> searchENSDownExcel(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO,String[] bkgNos) throws EventException;

	/**
	 * 구주 SIT PRO프로그램에서 ENS Download 메서드로 사용함<br>
	 * 
	 * @param manifestTransmitVOs
	 * @param userId
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public HashMap<String, Object> searchLDFDownExcel(ManifestTransmitVO[] manifestTransmitVOs, String userId, String pgmNo) throws EventException;

	
	 /**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)<br>
	 * 
	 * @param  String rcvMsg
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException;

	 /**
	 * 2011.11.15 김보배 [CHM-201114279] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchEurManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * BL LDF 다운로드 배치(베트남의 경우만)
	 * @throws EventException
	 */
	public void searchBlLdfBatch() throws EventException;
}