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
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
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
public interface CndCustomsTransmissionBC {

	 /**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;

	 /**
	 * 세관 신고 대상 상세List를 조회한다.
	 *
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws EventException
	 */
	public List<CstmsManifestVO> searchManifestDtlList(CstmsManifestCondVO cstmsManifestCondVO)
			throws EventException;

	 /**
	 * Vessel Arrival 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param vesselArrivalTransmitVO 전송정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;

	 /**
	 * Vessel Actual Arrival 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param vesselArrivalTransmitVO 전송정보
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitActualVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;

	 /**
	 * Receive History
	 *
	 * @param cstmsRcvHisListCondVO 조회조건
	 * @return List<CstmsRcvHisVO>
	 * @throws EventException
	 */
	public List<CstmsRcvHisVO> searchCstmsRcvHisList(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) throws EventException;

	 /**
	 * Receive History Detail
	 *
	 * @param cstmsRcvLogDtlCondVO 조회조건
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws EventException
	 */
	public List<CstmsRcvLogDtlVO> searchCstmsRcvLogDtl(CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) throws EventException;

	 /**
	 * SendLog History
	 *
	 * @param cstmsSndHisListCondVO 조회조건
	 * @return List<CstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException;

	 /**
	 * SendLog History Detail
	 *
	 * @param cstmsSndLogDtlCondVO 조회조건
	 * @return List<CndCstmsSndLogDtlVO>
	 * @throws EventException
	 */
	public List<CndCstmsSndLogDtlVO> searchCstmsSndLogDtl(CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO) throws EventException;

	 /**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 *
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @param String aiDiv
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO, String aiDiv) throws EventException;

	 /**
	 * ACI Report
	 *
	 * @param cstmsTrsmRsltListCondVO 조회조건
	 * @return List<CstmsTrsmRsltVO>
	 * @throws EventException
	 */
	public List<CstmsTrsmRsltVO> searchCstmsTrsmRsltList(CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO) throws EventException;

	 /**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;

	 /**
	 * AI 전송(재전송)
	 *
	 * @param cstmsManifestAmendmentVO 전송정보
	 * @param account 세션정보
	 * @return String FlatFile
	 */
	public String transAmendManifest(CstmsManifestAmendmentVO cstmsManifestAmendmentVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * EDI Inbound 처리 메서드
	 *
	 * @param cstmsRcvLogVO 로그정보
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO)  throws EventException;

	 /**
	 * FlatFile
	 *
	 * @param condVO 조회조건
	 * @param vslVO Vessel정보
	 * @param polVO POL 정보
	 * @param portList Port 정보
	 * @return String FlatFile
	 */
	public String makeCndVesselArrivalFlatFile(CndVesselArrivalTransmitVO condVO, CndVesselArrivalTransmitVO vslVO,
			CndVesselArrivalTransmitVO polVO, List<CndVesselArrivalTransmitVO> portList) throws EventException;

	/**
	 * Actual FlatFile
	 *
	 * @param actVslVO
	 * @return
	 * @throws EventException
	 */
	public String makeCndActualVesselArrivalFlatFile(CndVesselArrivalTransmitVO actVslVO) throws EventException;

	/**
	 * EDI 오류
	 * @param msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception;

	 /**
	 * Vessel Stowage Plan Transmit을 실행.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo) throws EventException;

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 *
	 * @param StowageManifestCondVO condVO
	 * @return List<ManifestTransmitVO>
	 * @exception EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO condVO) throws EventException;

	/**
	 * Vessel Stowage Plan Transmit 화면에서 캐나다 입항 전 항구 조회.
	 *
	 * @param StowageManifestCondVO condVO
	 * @return List<ManifestTransmitVO>
	 * @exception EventException
	 */
	public List<ManifestTransmitVO> searchLastForeignPort(StowageManifestCondVO condVO) throws EventException;
	
	/**
	 * Select CRN for Baplie 화면에서 CRN No.를 조회.
	 *
	 * @param StowageManifestCondVO condVO
	 * @return List<ManifestTransmitVO>
	 * @exception EventException
	 */
	public List<ManifestTransmitVO> searchCrnNo(StowageManifestCondVO condVO) throws EventException;



}