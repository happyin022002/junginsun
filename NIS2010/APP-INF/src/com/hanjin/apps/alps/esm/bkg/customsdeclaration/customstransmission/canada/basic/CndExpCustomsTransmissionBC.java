/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName :  CndExpCustomsTransmissionBC.java
 *@FileTitle : CndExpCustomsTransmissionBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic;

import java.util.List;
 
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * -CustomsDeclarationCanadaCes Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImplclass
 * @since J2EE 1.6
 */
public interface CndExpCustomsTransmissionBC {

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 * 
	 * @param CstmsManifestCondVO cstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;

	/**
	 * 세관 신고 대상 상세List를 조회한다.
	 *
	 * @param CstmsManifestCondVO cstmsManifestCondVO
	 * @return List<CstmsManifestVO>
	 * @throws EventException
	 */
	public List<CstmsManifestVO> searchManifestDtlList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;

	/**
	 * Vessel Arrival 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * Vessel Actual Departure 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitActualVesselDeparture(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * Receive History Detail
	 *
	 * @param CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO
	 * @return List<CstmsRcvLogDtlVO>
	 * @throws EventException
	 */
	public List<CstmsRcvLogDtlVO> searchCstmsRcvLogDtl(CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) throws EventException;

	/**
	 * SendLog History Detail
	 *
	 * @param CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO
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
	 * @param CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO
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
	 * @param CstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @param SignOnUserAccount account
	 * @return String FlatFile
	 */
	public String transAmendManifest(CstmsManifestAmendmentVO cstmsManifestAmendmentVO, SignOnUserAccount account) throws EventException;

	/**
	 * EDI Inbound 처리 메서드
	 *
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException;

	/**
	 * FlatFile
	 *
	 * @param CndVesselArrivalTransmitVO condVO
	 * @param CndVesselArrivalTransmitVO vslVO
	 * @param CndVesselArrivalTransmitVO polVO
	 * @param List<CndVesselArrivalTransmitVO> portList
	 * @return String
	 */
	public String makeCndVesselArrivalFlatFile(CndVesselArrivalTransmitVO condVO, CndVesselArrivalTransmitVO vslVO, CndVesselArrivalTransmitVO polVO, List<CndVesselArrivalTransmitVO> portList) throws EventException;

	/**
	 * Actual FlatFile
	 *
	 * @param CndVesselArrivalTransmitVO actVslVO
	 * @return String
	 * @throws EventException
	 */
	public String makeCndActualVesselDepartureFlatFile(CndVesselArrivalTransmitVO actVslVO) throws EventException;

	/**
	 * EDI 오류
	 * 
	 * @param String msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception;

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO) throws EventException;

	/**
	 * Vessel Stowage Plan Transmit 화면에서 캐나다 입항 전 항구 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchLastForeignPort(StowageManifestCondVO stowageManifestCondVO) throws EventException;

	/**
	 * Select CRN for Baplie 화면에서 CRN No.를 조회.
	 *
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchCrnNo(StowageManifestCondVO stowageManifestCondVO) throws EventException;

	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;

	/**
	 * SendLog History
	 *
	 * @param CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO
	 * @return List<CndCstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CndCstmsSndHisVO> searchCndCstmsSndHisList(CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO) throws EventException;

	/**
	 * Receive History
	 *
	 * @param CstmsRcvHisListCondVO cstmsRcvHisListCondVO
	 * @return List<CstmsRcvHisVO>
	 * @throws EventException
	 */
	public List<CstmsRcvHisVO> searchCstmsRcvHisList(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) throws EventException;
	
	/**
	 * Vessel Departure(수입 시 - Arrival 신고) 신고하기 위해 FlatFile을 생성한다.
	 *
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselDeparture(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;	

}
