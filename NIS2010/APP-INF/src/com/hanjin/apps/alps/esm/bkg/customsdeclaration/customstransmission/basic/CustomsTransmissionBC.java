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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.AustrailiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CstmsNtcSndInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmdFormVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmdManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestListResultForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsMfAmdtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DgmManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.EmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.IftsaiSndCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGMTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestDGNTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestMFTTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.TransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VslInfoNManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface CustomsTransmissionBC {

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException;

	/**
	 * EXPORT Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestOB(ManifestTransmitVO manifestTransmitVO) throws EventException;

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return List<IndonesiaFFVO>
	 * @exception EventException
	 */
	public List<IndonesiaFFVO> transmitManifestForIndonesia(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVO) throws EventException;
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestCts(ManifestTransmitVO[] manifestTransmitVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO[] manifestTransmitVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;	

	/**
	 * ANCS 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * 
	 * @param CstmsManifestVO[] cstmsManifestVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void transmitManifest(CstmsManifestVO[] cstmsManifestVOs, SignOnUserAccount account)
	throws EventException;
	
	/**
	 * 세관에 적하목록 신고를 EDI를 통해 재전송한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestForResend(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException;	

	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String transmitActualVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO)
	throws EventException;

	/**
	 * 중국 Terminal 세관 신고를 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO 
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String transmitTmlManifest ( ManifestTransmitVO manifestTransmitVO , SignOnUserAccount account) throws EventException;
	
	/**
	 * Receive History
	 * 
	 * @param CstmsRcvHisListCondVO cstmsRcvHisListCondVO
	 * @return List<CstmsRcvHisVO>
	 * @exception EventException
	 */
	public List<CstmsRcvHisVO> searchCstmsRcvHisList(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) throws EventException;

	/**
	 * Receive History Detail
	 * 
	 * @param CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO
	 * @return List<CstmsRcvLogDtlVO>
	 * @exception EventException
	 */
	public List<CstmsRcvLogDtlVO> searchCstmsRcvLogDtl(CstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) throws EventException;

	/**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 * 
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @exception EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(
			CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO) throws EventException;

	/**
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.
	 * 
	 * @param CstmsManifestAmendmentVO cstmsManifestAmendmentVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transAmendManifest(CstmsManifestAmendmentVO cstmsManifestAmendmentVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * SendLog History
	 * 
	 * @param CstmsSndHisListCondVO cstmsSndHisListCondVO
	 * @return List<CstmsSndHisVO>
	 * @exception EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException;

	/**
	 * SendLog History Detail
	 * 
	 * @param CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO
	 * @return List<CstmsSndLogDtlVO>
	 * @exception EventException
	 */
	public List<CstmsSndLogDtlVO> searchCstmsSndLogDtl(CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO) throws EventException;

	/**
	 * ACI Report
	 * 
	 * @param CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO
	 * @return List<CstmsTrsmRsltVO>
	 * @exception DAOException
	 */
	public List<CstmsTrsmRsltVO> searchCstmsTrsmRsltList(CstmsTrsmRsltListCondVO cstmsTrsmRsltListCondVO)
			throws EventException;

	/**
	 * ManifestListForEdi
	 * 
	 * @param ManifestListCondForEdiVO manifestListCondForEdiVO
	 * @return ManifestListCondForEdiVO
	 * @exception DAOException
	 */
	public ManifestListForEdiVO searchManifestListForEdi(ManifestListCondForEdiVO manifestListCondForEdiVO)
			throws EventException;

	/**
	 * 세관으로 송수신한 메시지 상세 내역 조회
	 * 
	 * @param CstmsLogDtlCondVO cstmsLogDtlCondVO
	 * @return List<CstmsLogDtlVO>
	 * @exception EventException
	 */
	public List<CstmsLogDtlVO> searchCstmsLogDtl(CstmsLogDtlCondVO cstmsLogDtlCondVO) throws EventException;

	/**
	 * 세관신고 AI
	 * @param CstmsMfAmdtVO[] cstmsMfAmdtVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitCstmsMfAmdt(CstmsMfAmdtVO[] cstmsMfAmdtVOs, SignOnUserAccount account)
			throws EventException;

	
	/**
	 * 세관 입항 관련 플랫 파일 만들기
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String transFlag
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String makeCstmsFlatFileCusrep(String vslCd, String skdVoyNo, String skdDirCd, String transFlag, SignOnUserAccount account)
		throws EventException;
	
	/**
	 * AnType 변경
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveUbizhjsAlpsbkgNaccs(String flatFile, SignOnUserAccount account) throws EventException;
	
	/**
	 * BKR/BKC Type 저장
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveJapanTerminalAlpsbkgNaccs(String flatFile, SignOnUserAccount account) throws EventException;	
	
	/**
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @return RocsManifestTransmitVO
	 * @exception EventException
	 */
	public RocsManifestTransmitVO receiveAlpsbkgUdevhjs(String flatFile, SignOnUserAccount account) throws EventException;
	
	/**
	 * Manifest Save
	 * @param TransmitCondVO transmitCondVO
	 * @param SignOnUserAccount account 
	 * @return TransmitDetailVO
	 * @exception EventException
	 */
	public TransmitDetailVO modifyManifestSummaryInfo ( TransmitCondVO transmitCondVO, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Manifest Delete
	 * @param TransmitCondVO transmitCondVO
	 * @param SignOnUserAccount account
	 * @return TransmitDetailVO
	 * @exception EventException
	 */
	public TransmitDetailVO removeManifestSummaryInfo ( TransmitCondVO transmitCondVO, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Manifest FlatFile Send
	 * @param TransmitCondVO transmitCondVO
	 * @param SignOnUserAccount account
	 * @return TransmitDetailVO
	 * @exception EventException
	 */
	public TransmitDetailVO transmitDischManifest ( TransmitCondVO transmitCondVO , SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * @param transmitCondVO
	 * @param SignOnUserAccount account
	 * @return TransmitDetailVO
	 * @exception EventException
	 */
	public TransmitDetailVO transmitManifest ( TransmitCondVO transmitCondVO , SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Manifest FlatFile Send
	 * @param TransmitCondVO transmitCondVO
	 * @param SignOnUserAccount account
	 * @return TransmitDetailVO
	 * @exception EventException
	 */
	public TransmitDetailVO transmitAmendManifest ( TransmitCondVO transmitCondVO, SignOnUserAccount account ) throws EventException;
	
	/**
	 * Ofm FlatFile Send
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitOfm(ManifestTransmitVO[] manifestTransmitVO) throws EventException;

	/**
	 * EDI Inbound 처리 메서드 
	 * 
	 * @param String sRcvMsg
	 * @param SignOnUserAccount account
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg ( String sRcvMsg, SignOnUserAccount account ) throws EventException;
	
	/**
	 * EDI Inbound 처리 메서드 
	 * @param String sRcvMsg
	 * @param String userId
	 * @exception EventException
	 */
	public void loadCstmsRcvMsg ( String sRcvMsg,String userId) throws EventException;
	
	
	/**
	 * Canada EDI 수신
	 * 
	 * @param cstmsRcvLogVO cstmsRcvLogVO
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException;
	/**
	 * Srilanka EDI 수신
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException;

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param MrnCreateInfoCondVO mrnCreateInfoCondVO
	 * @return MrnCreateInfoVO[]
	 * @exception EventException
	 */
	public MrnCreateInfoVO[] searchMrnCreateInfo(MrnCreateInfoCondVO mrnCreateInfoCondVO) throws EventException;
	
	/**
	 * MRN Create 정보 추가 
	 * @param MrnCreateInfoCondVO mrnCreateInfoCondVO
	 * @return MrnCreateInfoVO[]
	 * @exception EventException
	 */
	public MrnCreateInfoVO[] manageMrnCreateInfo(MrnCreateInfoCondVO mrnCreateInfoCondVO) throws EventException;
	
	/**
	 * MRN Create 정보 추가 (MRN no. Auto Creation 관련 추가 2013.08)
	 * @param MrnCreateInfoVO mrnCreateInfoVO
	 * @return MrnCreateInfoVO[]
	 * @exception EventException
	 */
	public MrnCreateInfoVO[] manageMrnCreateInfo(MrnCreateInfoVO mrnCreateInfoVO) throws EventException;

	/**
	 * GB지역 UVI정보를 찾아온다. 
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @exception EventException
	 */

	public String searchUvi(String vvdCd, String polCd, String podCd) throws EventException;
	
	/**
	 * MRN MSN 정보 삭제
	 * @param MrnCreateInfoCondVO[] mrnCreateInfoCondVOs
	 * @exception EventException
	 */
	public void removeMrnMsnCreateInfo(MrnCreateInfoCondVO[] mrnCreateInfoCondVOs) throws EventException;
	
	/**
	 * 입출항 선박 신고된 적하목록 현황 조회 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListVO
	 * @exception EventException
	 */
	public ManifestListVO searchManifestListForTransmit(ManifestListCondVO manifestListCondVO) throws EventException;
	
	/**
	 * VSL, Manifest 정보 조회
	 * @param VslInfoNManifestCondVO vslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @exception EventException
	 */
	public VslInfoNManifestVO searchVslInfoNManifestList(VslInfoNManifestCondVO vslInfoNManifestCondVO) throws EventException;
	
	/**
	 * Manifest Summary 정보 수정 
	 * @param ManifestSmryCondVO manifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(ManifestSmryCondVO manifestSmryCondVO) throws EventException;
	
	/**
	 * Manifest Summary 정보 삭제
	 * @param ManifestSmryVO manifestSmryVO
	 * @exception EventException
	 */
	public void removeManifestSummaryInfo(ManifestSmryVO manifestSmryVO) throws EventException;
	
	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException;
	
	/**
	 * Trans Amendment To PA 
	 * @param AmendManifestTransmitVO amendManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transAmendManifest(AmendManifestTransmitVO amendManifestTransmitVO) throws EventException;
	

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 * 
	 * @param StowageManifestCondVO condVO
	 * @return List<ManifestTransmitVO>
	 * @exception EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO condVO) throws EventException;
	
	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVO) throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(String usrId, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException;	

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param String usrId
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(String usrId, ManifestTransmitVO manifestTransmitVO, String pgmNo)
			throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo)
			throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param AustrailiaManifestTransmitVO[] AustrailiaManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, AustrailiaManifestTransmitVO[] austrailiaManifestTransmitVOs, String pgmNo)
			throws EventException;	
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param HongKongManifestTransmitVO[] hongKongManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, HongKongManifestTransmitVO[] hongKongManifestTransmitVOs, String pgmNo)
			throws EventException;	
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs, String pgmNo)
			throws EventException;	

	/**
	 * MI 전송(최초전송)
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return List<String> flatFile
	 */
	public List<String> transmitCstmsManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * Amendment Transmit 전송 
	 * @param AmdManifestTransmitVO amdManifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transAmdManifest(AmdManifestTransmitVO amdManifestTransmitVO) throws EventException;
	

	/**
	 * BL 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param BlInfoVO blInfoVO
	 * @param SignOnUserAccount account
	 */
	public void manageBlInfo(BlInfoVO blInfoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 반입신고서 전송 
	 * @param ManifestDGNTransmitVO manifestDGNTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitDGNManifest(ManifestDGNTransmitVO manifestDGNTransmitVO) throws EventException;
	
	/**
	 * 적하일람표 전송
	 * @param ManifestDGMTransmitVO manifestDGMTransmitVO
	 * @return DgmManifestVO
	 * @exception EventException
	 */
	public DgmManifestVO transmitDGMManifest(ManifestDGMTransmitVO manifestDGMTransmitVO) throws EventException;
	
	/**
	 * MSN Create EDI 전송 
	 * @param ManifestMFTTransmitVO manifestMFTTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitKorMFTManifest(ManifestMFTTransmitVO manifestMFTTransmitVO) throws EventException;

	/**
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 BL 정보를 조회한다
	 * 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return BlInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchBlInfo(BlInfoCondVO blInfoCondVO) throws EventException;

	/**
	 * 멕시코 세관 Manifest 전송을 위해 조회한다.
	 * 
	 * @param CargoManifestCondForEdiVO cond
	 * @return CargoManifestListResultForEdiVO
	 * @exception EventException
	 */
	public CargoManifestListResultForEdiVO searchCargoManifestForEdi(CargoManifestCondForEdiVO cond) throws EventException;
	
	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException;

	/**
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 BL 정보를 조회한다
	 * 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	public List<BlInfoVO> searchBlByVvd(BlInfoCondVO blInfoCondVO) throws EventException;

	/**
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 * 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	public List<BlInfoVO> searchTmlBlByVvd(BlInfoCondVO blInfoCondVO) throws EventException;
	
	/**
	 * 서버에 파일생성해서 로컬로 다운로드<br>
	 * 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(BlInfoCondVO blInfoCondVO) throws EventException;
	
	/**
	 * EDI 수신으로 받은 문자열을 Parsing 하여 msg_tp값에 따라서 서로 다른 DAO 메소드를 호출한다.
	 * @param String rcvMsg
	 * @exception EventException
	 * @author Son Yun Seuk
	 */
	public void loadCstmsRcvMsg(String rcvMsg)throws EventException; 
	
	/**
	 * SIT PRO화면에서 메인 그리드 조회
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return List<SitProCargoManifesDetailVO>
	 * @exception EventException
	 */
	public List<SitProCargoManifesDetailVO> searchSitProList(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException;
	
	/**
	 * Amendment Transmission to Korean Customs 정정 내용 출력을 위한 조회
	 * @param AmdFormVO[] amdFormVOs
	 * @return AmdFormVO[]
	 * @exception EventException
	 */
	public AmdFormVO[] searchAmdFormPrev(AmdFormVO[] amdFormVOs) throws EventException;

	/**
	 * 입출항 선박 신고된 적하목록 현황 조회 
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;

	/**
	 * 입출항 선박 신고된 적하목록 상세조회
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @exception EventException
	 */
	public List<CstmsManifestVO> searchManifestDtlList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;
	
	/**
	 * ROTTERDAM(NLRTM) 세관 CRN 정보를 삭제(Cancel) 한다.
	 * @param ReceiveLogVO receiveLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReceiveLog(ReceiveLogVO  receiveLogVO, SignOnUserAccount account) throws EventException;

	/**
	 * ISF Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * @param manifestTransmitVOs manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestIsf(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * InBound Empty Amend 전송 
	 * @param EmpAmdManiTransVO[] empAmdManiTransVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiTransVO[] empAmdManiTransVOs) throws EventException;
	
	/**
	 * EUR-CTA : 대상 BKG_NO 리스트 존재여부를 조회한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistBkgNoList(ManifestTransmitVO manifestTransmitVO) throws EventException;

	/**
	 * EUR-SITPRO : vvd와 port 존재여부를 조회한다.<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return String
	 * @throws EventException
	 */
	public String searchExistVvdPort(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws EventException;

	/**
	 * IFTSAI EDI 전송
	 * 
	 * @param IftsaiSndCondVO[] iftsaiSndCondVOs
	 * @return IftsaiSndCondVO
	 * @throws EventException
	 */
	public IftsaiSndCondVO searchIFTSAISnd(IftsaiSndCondVO[] iftsaiSndCondVOs) throws EventException;
	
	/**
	 * 한국세관 Cancel per B/L EDI 전송
	 * 
	 * @param CancelManifestTransmitVO cancelManifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transCancelManifest(CancelManifestTransmitVO cancelManifestTransmitVO) throws EventException;
	
	/**
	 * 타이완 flatfile 대상 bl이 있는지 확인 한다.
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String retVal
	 * @throws EventException
	 */
	public String searchBLGeneralBasic(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;
	
	/**
	 * Vessel Stowage Plan Alarm set up Search
	 * @param BaplieAlarmSetupVO baplieAlarmSetupVO
	 * @return List<BaplieAlarmSetupVO>
	 * @throws EventException
	 */
	public List<BaplieAlarmSetupVO> searchBaplieAlarmSetup(BaplieAlarmSetupVO baplieAlarmSetupVO) throws EventException;

	/**
	 * BaplieAlarmSetup 추가, 수정, 삭제 한다.
	 * @param BaplieAlarmSetupVO[] baplieAlarmSetupVOs
	 * @param String user_id
	 * @throws EventException
	 */
	public void manageBaplieAlarmSetup(BaplieAlarmSetupVO[] baplieAlarmSetupVOs, String user_id) throws EventException;
	
	/**
	 * ESM_BKG_0503.do에서 사용되는 서비스<br>
	 * Transmit Cross-Check 조회
	 * @param KorTransCrossChkCondVO korTransCrossChkCondVO
	 * @return List<KorTransCrossChkDtlVO>
	 * @throws EventException 
	 * @throws EventException
	 */
	public List<KorTransCrossChkDtlVO> searchTransCrossChk(KorTransCrossChkCondVO korTransCrossChkCondVO) throws EventException;
	
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
	 * Manifest OB를 신고하기 위해 FlatFile을 전송한다.
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestOB(ManifestTransmitVO[] manifestTransmitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestCN(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException;
	

//	/**
//	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
//	 * 
//	 * @param ManifestTransmitVO manifestTransmitVO
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @exception EventException
//	 */
//	public String transmitManifestRU(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
//			throws EventException;
//	
	
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitCancellKR(ManifestTransmitVO manifestTransmitVO)
			throws EventException;
	
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
	 * 조원주_Sea-NACCS 프로젝트 (20120309)
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String sendFlatFile(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조원주_Sea-NACCS 프로젝트 (20120312)
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForSchedule (JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조원주_Sea-NACCS 프로젝트 (20120312)
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForBKGRoute (JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException;
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE<br>
	 * @param VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @return JapanTerminalEdiCheckRsltVO
	 * @exception EventException
	 */	
	public JapanTerminalEdiCheckRsltVO manageTerminalEdi(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 김종옥_Sea-NACCS 프로젝트 (20120312)
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException;

	/**
	 * 김종옥_Sea-NACCS 프로젝트 (20120312)
	 * searchPartialBkgInfoForSchedule
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchPartialBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException;

	/**
	 * 판별로직 확인
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @throws EventException
	 */	
	public String searchCheckColumns(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException;
	
	/**
	 * [CHM-201216099] Transmit to NACCS 버튼<br>
	 * 
	 * @param VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String transmitVesselList(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException;	

	/**
	 * searchNewBkgInfo
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @return List<BkgTerminalEdiJapanBlVO>
	 * @throws EventException
	 */
	public List<BkgTerminalEdiJapanBlVO> searchNewBkgInfo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException;
	
	/**
	 * searchNewBkgDetailInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return JapanTerminalEdiGroupVO
	 * @throws EventException
	 */
	public JapanTerminalEdiGroupVO searchNewBkgDetailInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException;

	/**
	 * addNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @throws EventException
	 */
	public String addNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * addNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @throws EventException
	 */
	public String addNewBkgInfoVvdChk(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account) throws EventException;
	/**
	 * addNewBkgInfo
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account 
	 * @param int logSeq
	 * @return String
	 * @throws EventException
	 */
	public String sendTerminalEdi(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, int logSeq) throws EventException;
	
	/**
	 * managePartialBkgInfoForSchedule
	 * 
	 * @param BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePartialBkgInfoForSchedule(BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Ghana 세관 전송 화면에서 전송 성공 후 로그 저장<br>
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param account
	 * @exception EventException
	 */
	public void addSendLog(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 멕시코 세관 POD 리스트를 조회한다.
	 * 
	 * @param CargoManifestCondForEdiVO cond
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchManifestPodList(CargoManifestCondForEdiVO cond) throws EventException;
	
	/**
	 * searchNewBkgInfoForVvdChk
	 * 
	 * @param String bkgNo
	 * @return BkgTerminalEdiJapanBlVO
	 * @throws EventException
	 */
	public BkgTerminalEdiJapanBlVO searchNewBkgInfoForVvdChk(String bkgNo) throws EventException;
	
	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
     * @param VesselArrivalDetailVO vesselArrivalDetailVO
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String transmitFiBlArrival(VesselArrivalDetailVO vesselArrivalDetailVO, VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * Inbound Domestic T/S Manifest -
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 대상목록 조회
	 *
	 * @param InboundTSInfoBLVO serchCondVO
	 * @return InboundTSInfoGRPVO
	 * @exception EventException
	 */
	public InboundTSGRPVO searchInboundTSManifest(InboundTSInfoBLVO serchCondVO) throws EventException;

	/**
	 * cstms notice 대상 e-mail 정보 조회
	 * 
	 * @param CstmsNtcSndInfoVO cstmsNtcSndInfoVO
	 * @return List<CstmsNtcSndInfoVO>
	 * @throws EventException
	 */
	public List<CstmsNtcSndInfoVO> searhCstmsNtcSndInfo(CstmsNtcSndInfoVO cstmsNtcSndInfoVO) throws EventException;
	
	/**
	 * Europe Customs EDI Country Code 를 조회한다.
	 * 
	 * @param String cmCode
	 * @return String
	 * @throws EventException
	 */
	public String searchEurCustCntCode(String cmCode) throws EventException ;
	
	
	/**
	 * Europe Customs EDI 의 receiver 를 조회한다.
	 * 
	 * @param String cmCode
	 * @param String cntCd
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchEurCustReceiver(String cmCode, String cntCd) throws EventException;
	
	
	
	/**
	 * 위험물 세관신고 위해 FlatFile을 생성 및 전송
	 * 
	 * @param  ManifestTransmitVO[] manifestTransmitVOs
	 * @param  SignOnUserAccount account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> sendDgManifestList(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * ESM_BKG_0371  KOREA CUSTOMS : 신규 생성하는 MRN 에 대해서 동일 Vessel 로 등록된 MRN # 있는지 조회한다.<br>
	 * @param MrnCreateInfoVO mrnCreateInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMrnDuplicated(MrnCreateInfoVO mrnCreateInfoVO) throws EventException; 
		

	/**
	 * Reject 발생시 메일 반송
	 * 
	 * @param UsaRcvMsgVO usaRcvMsgVO 
	 * @param String reBlNo
	 * @param String rejMessage
	 */
	public void sendAmsNtcToObStaff ( UsaRcvMsgVO usaRcvMsgVO , String reBlNo , String rejMessage ) throws EventException ;
	
	/**
	 * EDI Inbound 처리 메서드
	 * 
	 * @param cstmsRcvLogVO 로그정보
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsBaplieRcvMsg(CndCstmsRcvLogVO cstmsRcvLogVO) throws EventException ;
	
	/**
	 * 입출항 선박 신고된 적하목록 현황 조회
	 *  
	 * @param cstmsManifestCondVO 조회조건
	 * @return List<CstmsManifestVO>
	 * @throws EventException
	 */
	public List<CstmsManifestVO> searchExportManifestList(CstmsManifestCondVO cstmsManifestCondVO) throws EventException;	
	
//	/**
//     * 호주 1512팝업 DG : Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
//     * 
//     * @param dgCargoCondVO
//     * @return DgInqModiVO
//     * @throws EventException
//     */
//	
//	public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException ;
//
//	
//	
//	/**
//	* 1512팝업 DG: 호주 위험물 상세 정보들을 저장한다.<br>
//	* @param  DgInqModiVO dgInqModiVO
//	* @param  SignOnUserAccount account
//	* @throws EventException
//	*/
//	 public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException ;
//
//		 
//		 
//    /**
//     * 호주 1512팝업 DG: 	Forward Code로 Forward Name을 조회한다.<br>
//     * 
//     * @param dgListCondVO
//     * @return
//     * @throws EventException
//     */
//    public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException;
//    
//    
//    /**
//     * 호주 1512팝업 DG: UN NO로 NAME을 조회한다.<br>
//     * 
//     * @param dgListCondVO
//     * @return
//     * @throws EventException
//     */
//    public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException ;
//    
//    /**
//	 *호주 1512팝업 DG: Feeder Name, Lloyd No를 조회한다.<br>
//     * 
//	 * @return List<FeederNameVO>
//     * @throws EventException
//     */
//    public List<FeederNameVO> searchDgFeederNameList() throws EventException ;
//    
//    /**
//     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
//     * 
//     * @param dgCargoCondVO
//     * @return List<DgCntrInfoListVO>
//     * @throws EventException
//     */
//    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException ;
//
//    
//    /**
//     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
//     * 
//     * @param dgCargoCondVO
//     * @return List<DgCntrInfoListVO>
//     * @throws EventException
//     */
//    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException ;
//
//	
}