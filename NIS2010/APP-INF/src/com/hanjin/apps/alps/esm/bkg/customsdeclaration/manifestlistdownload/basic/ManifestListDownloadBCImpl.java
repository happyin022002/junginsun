/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManifestListDownloadBCImpl.java
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
 * 2015.04.27 이한나[CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.MrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusBkgAndLocalDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCargoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.FeederNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaVslRgstVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelRcvHisCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrMfSeqNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDiscCYBondInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorRateHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.ObMsnInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlInVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.ModifyCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListSecondBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsMfDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DiscCYBondInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HistoryListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiDGMTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MrnCreateCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MrnMsnCreateCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnBondInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListModVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TmpBlBkgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPortVO;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0017EventResponse,PanamaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public abstract class ManifestListDownloadBCImpl extends BasicCommandSupport implements ManifestListDownloadBC {

	/**
	 * B/L List조회후 Simple BL의 ELNO 누락건에 대하여 eMail을 전송
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendSimpleElNoEmail(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException{
		return null;
	}

	/**
	 * B/L List조회후 Console BL건에 대하여 House BL EDI 전송을 요청하는 eMail을 전송
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConsoleEmail(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException{
		return null;
	}
	

	/**
	 * Web Service EAI용(WEB_001_0001)<br>
	 * Bonded type을 업데이트<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @exception EventException
	 */
	public void modifyWeb0010001Control(BkgWebServiceVO bkgWebServiceVO) throws EventException {}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 벨기에 세관 입항 신고를 위한 VVD별 입항 정보 조회
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return VesselArrivalVO
	 * @exception EventException
	 */
	public VesselArrivalVO searchVesselArrival2(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		return null;
	}
	
	/**
	 * Rotterdem세관에서 받은 EDI 현황을 가져온다.
	 * 
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return List<ReceiveLogVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException {
		return null;
	}
	
	/**
	 * ANCS 세관테이블로부터 Customr, Container, Commodity(CM) 등의 BL 정보를  조회/확인한다.
	 * 
	 * @param cstmsBlCondVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public AncsCstmsBlCVO inquiryBlData(CstmsBlCondVO cstmsBlCondVO) throws EventException {
		return null;
	}

	/**
	 * Rotterdem세관에 보낸 EDI 현황을 가져온다.
	 * 
	 * @param TransmitHistListCondVO transmitHistListCondVO
	 * @return List<TransmitHistVO>
	 * @exception EventException
	 */
	public List<TransmitHistVO> searchTransmitHistList(TransmitHistListCondVO transmitHistListCondVO) throws EventException {
		return null;
	}
	
	/**
	 * Rotterdem세관에서 받은 EDI 현황을 가져온다.
	 * 
	 * @param TransmitHistCondVO transmitHistCondVO
	 * @return List<TransmitHistVO>
	 * @exception EventException
	 */
	public List<TransmitHistVO> searchTransmitHist(TransmitHistCondVO transmitHistCondVO) throws EventException {
		return null;
	}
	
	/**
	 * Rotterdem세관에서 받은 MSG flat file 가져온다.
	 * @param ReceiveLogCondVO receiveLogCondVO
	 * @return List<ReceiveLogVO>
	 * @exception EventException
	 */
	public List<ReceiveLogVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException {
		return null;
	}
	
	
	/**
	 * Rotterdem세관에서 받은 EDI 현황을 가져온다.
	 * 
	 * @param HistoryListCondVO historyListCondVO
	 * @return List<RecieveHistLogVO>
	 * @exception EventException
	 */
	public List<RecieveHistLogVO> searchHistoryList(HistoryListCondVO historyListCondVO) throws EventException {
		return null;
	}
	

	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForDl(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 *  일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForMfs(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 *  Manifest 정보를 추가 / 수정 / 삭제 처리 한다.
	 * 
	 * @param ManifestListDetailVO manifestListDetailVO
	 * @exception EventException
	 */
	public void manageManifest(ManifestListDetailVO manifestListDetailVO) throws EventException {}
	
	/**
	 *  일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.
	 * 
	 * @param ManifestListDetailVO manifestListDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifest(ManifestListDetailVO manifestListDetailVO) throws EventException {
		return null;
	}
	
	/**
	 * 서버에 파일생성해서 로컬로 다운로드<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO 
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(ManifestListCondVO manifestListCondVO) throws EventException{
		return null;
	}

	/**
	 * 서버에 파일생성해서 로컬로 다운로드<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return int
	 * @exception EventException
	 */
	public int manageManifest(ManifestListCondVO manifestListCondVO) throws EventException {
		return 0;
	}

	/**
	 * ANCS 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 BL 테이블로 부터 다운 로드 받음
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO manifestModificationVO) throws EventException {

	}
	
	/**
	 * ANCS 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 BL 테이블로 부터 다운 로드 받음
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException {

	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {

	}

	/**
	 * Container Manifest정보를 업데이트 한다.
	 * 
	 * @param ConatinerModificationtVO[] conatinerModificationtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] conatinerModificationtVOs, SignOnUserAccount account)
			throws EventException {

	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		return null;
	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForDl(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {}
	
	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAncsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account)
			throws EventException {}	
	
	/**
	 * VVD,Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForMfs(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {}
	
	/**
	 * VVD,Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param String vslCallRefNoOld
	 * @param String vslCallRefNoNew
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void  manageCrnNo(String vslCallRefNoOld, String vslCallRefNoNew, SignOnUserAccount account)
			throws EventException {}	

	/**
	 * 세관 신고용 VVD 정보 조회
	 * 
	 * @param CstmsVvdInfoCondVO cstmsVvdInfoCondVO
	 * @return List<CstmsVvdInfoVO>
	 * @exception EventException
	 */
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException {
		return null;
	}

	/**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 * 
	 * @param CstmsVvdInfoVO[] cstmsVvdInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException {}

	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 * 
	 * @param cstmsVvdRefNoCondVO 조회조건
	 * @return CstmsVvdRefNoVO
	 * @exception EventException
	 */
	public CstmsVvdRefNoVO createCstmsVvdRefNo(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException {
		return null;
	}

	/**
	 * 국가별 세관 관리 항목 setup 정보 조회<br>
	 * UsaManifestListDownload 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SetupListCondVO setupListCondVO
	 * @return List<SetupListDetailVO>
	 * @exception EventException
	 */
	public List<SetupListDetailVO> searchSetupList(SetupListCondVO setupListCondVO) throws EventException {
		return null;
	}

	/**
	 * 국가 코드 조회<br>
	 * UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryCodeList() throws EventException {
		return null;
	}

	/**
	 * 포트 코드 조회<br>
	 * UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 * 
	 * @param String cntCd
	 * @return List<MdmPortVO>
	 * @exception EventException
	 */
	public List<MdmPortVO> searchPortCodeList(String cntCd) throws EventException {
		return null;
	}

	/**
	 * 등록된 vvd code인지 여부를 체크한다.<br>
	 * UsaManifestListDownload Combo List에서 사용하는 코드를 가져온다.<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @exception EventException
	 */
	public List<CrnVO> searchCRNInfo(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		return null;
	}

	/**
	 * 국가별 세관 관리 항목 setup 정보 저장<br>
	 * UsaManifestListDownload 화면에 대한 저장 이벤트 처리<br>
	 * @param SetupListModVO setupListModVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySetupList(SetupListModVO setupListModVO, SignOnUserAccount account) throws EventException {

	}

	/**
	 * 국가별 세관 관리 항목 setup 정보 삭제<br>
	 * UsaManifestListDownload 화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param SetupKeyVO setupKeyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySetupStatus(SetupKeyVO setupKeyVO, SignOnUserAccount account) throws EventException {

	}

	/**
	 * 화물에 대한 Manifest를 신고하기 위해 등록했던 Vessel 정보를 조회한다.
	 * 
	 * @param VesselCondVO vesselCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVessel(VesselCondVO vesselCondVO) throws EventException {
		return null;
	}
	
	/**
	 * 화물에 대한 Manifest List를 조회한다.
	 * @param VesselCondVO vesselCondVO
	 * @return List<ManifestListVO>
	 * @exception EventException
	 */
	public List<ManifestListVO> searchManifestList(VesselCondVO vesselCondVO) throws EventException {
		return null;
	}
	
	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.
	 * 
	 * @param VesselCondVO vesselCondVO
	 * @return List<VesselArrivalVO>
	 * @exception EventException
	 */
	public List<VesselArrivalVO> searchVesselArrival(VesselCondVO vesselCondVO) throws EventException {
		return null;
	}

	/**
	 * 화물에 대한 Manifest를 신고하기 위해 사전 VVD INFORMATION을 입력한다.
	 * 
	 * @param VesselVO[] vesselVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVessel(VesselVO[] vesselVOs, SignOnUserAccount account) throws EventException {}

	/**
     * 벨기에 세관 신고 대상 VVD 목록 조회
     * 
     * @param CstmsVvdListCondVO condVo
     * @return List<CstmsVvdVO>
     * @throws EventException
     */
	public List<CstmsVvdVO> searchCstmsVvdList(CstmsVvdListCondVO condVo) throws EventException {
		return null;
	}

	/**
	 * Customer, Container, Commodity(CM) 등의 BL 정보 조회/확인<br>
	 * UsaManifestListDownload 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BlCondVO blCondVO
	 * @return List<BlDetailVO>
	 * @exception EventException
	 */
	public List<BlDetailVO> inquiryBlData(BlCondVO blCondVO) throws EventException {
		return null;
	}

	/**
	 * 세관 신고시 필요한 Vessel Arrival 정보를 수정한다.
	 * 
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {}

	/**
	 * Harmonized Tariff code 입력을 위한 조회
	 * 
	 * @param BrHsCdCondVO brHsCdCondVO
	 * @return List<BrHsCdDetailVO>
	 * @exception EventException
	 */
	public List<BrHsCdDetailVO> searchHsCdList(BrHsCdCondVO brHsCdCondVO) throws EventException {
		return null;
	}

	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException {
		return null;
	}
	
	/**
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션 (EU Arrival Notice)
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @param SignOnUserAccount account
	 * @return List<VesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO , SignOnUserAccount account)
			throws EventException {
		return null;
	}

	/**
	 * User Auth List 조회<br>
	 * 
	 * @param AuthSetupListCondVO authSetupListCondVO
	 * @return List<AuthSetupListVO>
	 * @exception EventException
	 */
	public List<AuthSetupListVO> searchAuthSetupList(AuthSetupListCondVO authSetupListCondVO) throws EventException {
		return null;
	}

	/**
	 * User name, office 조회<br>
	 * 
	 * @param String userId
	 * @return List<UserInfoVO>
	 * @exception EventException
	 */
	public List<UserInfoVO> searchUserAuthority(String userId) throws EventException {
		return null;
	}

	/**
	 * User Auth 조회<br>
	 * 
	 * @param String userId
	 * @param String ofcCd
	 * @return AuthSetupListVO
	 * @exception EventException
	 */
	public AuthSetupListVO searchUserAuthority(String userId, String ofcCd) throws EventException {
		return null;
	}

	/**
     * User Auth List 정보 저장<br>
     * 
     * @param AuthSetupListVO[] authSetupListVO 
     * @return int
     * @exception EventException
     */
    public int manageAuthSetupList(AuthSetupListVO[] authSetupListVO) throws EventException {
    	return 0;
    }

	/**
	 * 세관 신고용 VVD 목록 상세 조회
	 * 
	 * @param CstmsVvdListCondVO condVo
	 * @return List<CstmsVvdVO>
	 * @exception EventException
	 */
	public List<CstmsVvdVO> searchCstmsVvdDtlList(CstmsVvdListCondVO condVo) throws EventException {
		return null;
	}

	/**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param CstmsBlVO[] cstmsBlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException {}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestInfo(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * searchKorMrnNoVO
	 * @param KorMrnNoVO mrnNoVO
	 * @return KorMrnNoVO
	 */
	public KorMrnNoVO searchKorMrnNoVO(KorMrnNoVO mrnNoVO) throws EventException {
		return null;
	}

	/**
	 * CRN,VVD 정보를 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @exception EventException
	 */

	public List<CrnVO> searchCRN(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * CRN,VVD 정보를 조회
	 * 
	 * @param String vslCallRefNo
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @exception EventException
	 */

	public List<CrnVO> searchCRN(String vslCallRefNo, String vslCd, String skdVoyNo, String skdDirCd)
			throws EventException {
		return null;
	}

	/**
	 * CRN,VVD 정보를 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<CrnVO>
	 * @exception EventException
	 */

	public List<CrnVO> searchCRNInfo(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 세관 적하 목록 상세 정보를 조회
	 * 
	 * @param CstmsMfDtlCondVO cstmsMfDtlListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchCstmsMfDtlList(CstmsMfDtlCondVO cstmsMfDtlListCondVO) throws EventException {
		return null;
	}

	/**
	 * Empty container를 위한 B/L 추가 필요시 DummyBlNo를 신규로 생성(Assign)한다.
	 * 
	 * @param String bkgNoGenDivCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String generateDummyBlNo(String bkgNoGenDivCd, SignOnUserAccount account) throws EventException {
		return null;
	}

	/**
	 * Dummy Bl Number 저장
	 * 
	 * @param BlVO blVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBl(BlVO blVO, SignOnUserAccount account) throws EventException {}
	
	 
	/**
	 * 신고 대상 Customer 정보를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchMfrCust(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 신고 대상 Marks & Description 정보를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchMfrMnd(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 일본세관 신고 대상 Marks & Description 정보를 세관 테이블 내에 생성한다.
	 * 
	 * @param MfrMndModificationVO mfrMndModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrMnd(MfrMndModificationVO mfrMndModificationVO, SignOnUserAccount account)
			throws EventException {}

	/**
	 * Manifest Registration(MFR)에서 Mnd 정보 수정
	 * 
	 * @param MfrMndModificationVO mfrMndModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeJpcusBlMd(MfrMndModificationVO mfrMndModificationVO, SignOnUserAccount account)
			throws EventException {}

	/**
	 * 신고 대상 Customer 정보를 세관 테이블 내에 생성한다.
	 * 
	 * @param MfrCustModificationVO mfrCustModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCust(MfrCustModificationVO mfrCustModificationVO, SignOnUserAccount account)
			throws EventException {}

	/**
	 * 신고 대상 Container 정보를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMfrCntr(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 신고 대상 Container 정보를 세관 테이블 내에 생성한다.
	 * 
	 * @param MfrCntrModificationVO[] mfrCntrModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMfrCntr(MfrCntrModificationVO[] mfrCntrModificationVOs, SignOnUserAccount account)
			throws EventException {}

	/**
	 * US AMS:Manifest Transmit(MI) 조회.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMiManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * US AMS:EXPORT Manifest Transmit(XI) 조회.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchMiManifestListOB(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
     * bl 삭제<br>
     * 
     * @param BlKeyVO blKeyVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
	public void removeBl(BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException {}

	/**
	 * bl 삭제<br>
	 * 
	 * @param BlKeyVO[] blKeyVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeBl(BlKeyVO[] blKeyVOs, SignOnUserAccount account) throws EventException {}
	
	/**
	 * bl 삭제<br>
     * 
     * @param List<BlKeyVO> rocsBlKeyVOs
     * @param SignOnUserAccount account 
     * @exception EventException
	 */
	public void removeBl(List<BlKeyVO> rocsBlKeyVOs, SignOnUserAccount account) throws EventException {

	}

	/**
	 * Rotterdam 세관 Ref No(CRN) Creation한다.
	 * 
	 * @param CrnVO crnVO
     * @param SignOnUserAccount account 
     * @return int
	 * @exception EventException
	 */
	public int manageCRN(CrnVO crnVO, SignOnUserAccount account) throws EventException {
		return 0;
	}

	/**
	 * Confirm Indicator 를 업데이트한다.
	 * @param ManifestConfirmationVO[] manifestConfirmationVOs
     * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void confirmManifestList(ManifestConfirmationVO[] manifestConfirmationVOs, SignOnUserAccount account)
			throws EventException {}

	/**
	 * B/L List조회후 세관신고DownLoad
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 *세관 신고 대상 List를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */

	public List<ManifestListDetailVO> searchManifestListForRocsBl(ManifestListCondVO manifestListCondVO)
			throws EventException {
		return null;
	}

	/**
	 * ANCS 세관 테이블에서 Notify Address 정보 조회
	 * 
	 * @param CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO
	 * @return List<CstmsNtfyAddrVO>
	 * @exception EventException
	 */
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr(CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO) throws EventException {
		return null;
	}
	
	/**
	 * ANCS 세관 테이블에서 Notify Address 정보 조회
	 * 
	 * @param CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO
	 * @param SignOnUserAccount account
	 * @return List<CstmsNtfyAddrVO>
	 * @exception EventException
	 */
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr(CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO, SignOnUserAccount account) throws EventException {
		return null;
	}

	/**
	 * ANCS 세관 관련 Notify Address를 관리 한다
	 * 
	 * @param CstmsNtfyAddrVO[] cstmsNtfyAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsNtfyAddr(CstmsNtfyAddrVO[] cstmsNtfyAddrVOs, SignOnUserAccount account)
			throws EventException {

	}

	/**
	 * 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestListForCmf(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * Hub정보취득
	 * 
	 * @param podCd
	 * @param delCd
	 * @param podNodCd
	 * @return
	 * @throws EventException
	 */
	public String[] searchHubInfo(String podCd, String delCd, String podNodCd) throws EventException {
		return null;
	}

	/**
	 * bl 수정<br>
	 * 
	 * @param BlDetailVO blDetailVO
	 * @param SignOnUserAccount account            
	 * @exception EventException
	 */
	public void correctBl(BlDetailVO blDetailVO, SignOnUserAccount account) throws EventException {

	}

	/**
	 * 화물에 대한 Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifestForCmf(ManifestModificationVO manifestModificationVO, SignOnUserAccount account)
			throws EventException {}

	/**
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 * 
	 * @param BlKeyVO blKeyVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reactivateBl(BlKeyVO blKeyVO, SignOnUserAccount account) throws EventException {}

    
	/**
	 * Office 코드 등록 유무 조회
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchExistOrganization(String ofcCd) throws EventException {
		return 0;
	}

	/**
	 * B/L List 조회 후 세관신고DownLoad
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList(ManifestListCondVO manifestListCondVO,
			SignOnUserAccount account) throws EventException {
		return null;
	}
	
	/**
	 * 일본 세관에 신고할 대상 Manifest 정보(DOR 데이터) 를 조회한다.
	 * 
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestListForDor() throws EventException {
		return null;
	}	

	/**
	 * AnType 변경
	 * @param AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAvcNoteSetUpInfo(AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs, SignOnUserAccount account) throws EventException {
		
	}
	
	/**
	 * 인도세관에서 보세통관 장치장 리스트를 조회한다.
	 * 
	 * @param BondCondVO bondCondVO
	 * @return List<BondDetailListVO>
	 * @exception EventException
	 */
	public List<BondDetailListVO> searchBondList(BondCondVO bondCondVO) throws EventException {
		return null;
	}
	
	
	
	/**
	 * Container 정보 조회
	 * 
	 * @param containerListCondVO ContainerListCondVO
	 * @return List<ContainerListRsltVO>
	 * @exception EventException
	 */
	public List<ContainerListRsltVO> searchContainerList(ContainerListCondVO containerListCondVO) throws EventException {
		return null;
	}		
	
	/**
	 * Container 정보 저장
	 * 
	 * @param ContainerListRsltVO[] cntrListRsltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContainerList(ContainerListRsltVO[] cntrListRsltVOs, SignOnUserAccount account) throws EventException {}	
	
	/**
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.
	 * @param BlSeqVO[] blSeqVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public  void modifyBlSeq(BlSeqVO[] blSeqVOs, SignOnUserAccount account) throws EventException {	 
	}
	
	/**
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBlPolCd(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException{
	}
	
	/**
	 * Discharge CY, Bonded Warehouse, Bonded Type등을 조회
	 * 
	 * @param DiscCYBondInfoVO discCYBondInfoVO
	 * @return DiscCYBondInfoVO
	 * @exception EventException
	 */
	public DiscCYBondInfoVO searchDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException
	{
		return null;
	}

	/**
	 * INBOUND DETAIL UPDATE
	 * 
	 * @param DiscCYBondInfoVO discCYBondInfoVO
	 * @return DiscCYBondInfoVO  
	 * @exception EventException
	 */
	public DiscCYBondInfoVO manageDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException {
		return null;
	}
	
	/**
	 * Container Manifest 정보를 조회한다.
	 * 
	 * @param containerManifestCondVO ContainerManifestCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchContainerManifest(ContainerManifestCondVO containerManifestCondVO) throws EventException {
		return null;
	}	
	
	/**
	 * 전송대상 Container Manifest 데이터를 수정한다.
	 * 
	 * @param List<ManifestListDetailVO> manifestListDetailVOs 
	 * @exception EventException
	 */
	public void modifyContainerManifest(List<ManifestListDetailVO> manifestListDetailVOs) throws EventException {}
	
	/**
	 * 세관 관련 선박 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param vesselInfoVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageCstmsVesselInfo(VesselInfoVO[] vesselInfoVOs, SignOnUserAccount account) throws EventException {}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 조회 한다
	 * 
	 * @param DispoCdListCondVO dispoCdListCondVO 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchDispositionCdList(DispoCdListCondVO dispoCdListCondVO) throws EventException {
		return null;
	}

	/**
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록, 수정 및 삭제 한다
	 * 
	 * @param DispoCdDetailVO[] dispoCdDetailVOs 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageDispositionCdList(DispoCdDetailVO[] dispoCdDetailVOs, SignOnUserAccount account) throws EventException {}
	
	/**
	 * 세관 B/L 관련 정보 조회
	 * @param ManifestEditListCondVO manifestEditListCondVO
	 * @return ManifestEditListVO
	 * @exception EventException
	 */
	public ManifestEditListVO searchManifestEditList(ManifestEditListCondVO manifestEditListCondVO) throws EventException {
		return null;
	}

	/**
	 * Package / 품목 Code 조회
	 * @param CodeCondVO codeCondVO
	 * @return CodeVO[]
	 * @exception EventException
	 */
	public CodeVO[] searchCodeInfo(CodeCondVO codeCondVO) throws EventException {
		return null;
	}

	/**
	 * 수신메시지 저장
	 * 
	 * @param CstmsRcvLogVO cstmsRcvLogVO
	 * @return CstmsRcvLogVO
	 * @exception EventException
	 */
	public CstmsRcvLogVO loadCstmsRcvMsg(CstmsRcvLogVO cstmsRcvLogVO) throws EventException {
		return null;
	}

	/**
	 * BKG_NO, B/L_NO 자동 생성
	 * @param TmpBlBkgVO tmpBlBkgVO
	 * @return TmpBlBkgVO
	 * @exception EventException
	 */
	public TmpBlBkgVO searchTempBlNoNBkgNoAssign(TmpBlBkgVO tmpBlBkgVO) throws EventException {
		return null;
	}

	/**
	 * MSN Bonded Info 조회
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return MsnBondInfoVO[]
	 * @exception EventException
	 */
	public MsnBondInfoVO[] searchMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException {
		return null;
	}

	/**
	 * MSN Bonded Info 수정
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return BkgCstmsKrMfSeqNoVO[]
	 * @exception EventException
	 */
	public BkgCstmsKrMfSeqNoVO[] modifyMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException {
		return null;
	}
	
	/**
	 * 선박별 인증서 만료일 (Certificate Expire Date) 업로드
	 * @param VesselInfoVO vesselInfoVO
	 * @exception EventException
	 */
	public void loadVslCertiExpDt(VesselInfoVO vesselInfoVO) throws EventException {}

    /**
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회
	 * @param HouseBlCondVO houseBlCondVO 
	 * @return List<HouseBlDetailVO>
	 * @exception EventException
	 */
	public List<HouseBlDetailVO> checkHouseBlDataList(HouseBlCondVO houseBlCondVO) throws EventException {
		return null;
	}
	
	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException {
		return null;
	}

	/**
	 * BL 정보 조회 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return BlInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchBlInfo(BlInfoCondVO blInfoCondVO) throws EventException {
		return null;
	}

	/**
	 * Disposition Code Description 조회<br>
	 * 
	 * @param BlCondVO blCondVO 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchCodeDesc(BlCondVO blCondVO) throws EventException {
		return null;
	}

	/**
	 * Amendment Manifest 정보 추가/수정/삭제 
	 * @param ManifestAmdManiVO manifestAmdManiVO
	 * @exception EventException
	 */
	public void manageAmdManifest(ManifestAmdManiVO manifestAmdManiVO) throws EventException {}

	/**
	 * DG Cargo Manifest List 조회 
	 * @param DgCgoManifestVO dgCgoManifestVO
	 * @return DgCgoManifestVO
	 * @exception EventException
	 */
	public DgCgoManifestVO searchDgCgoManifestList(DgCgoManifestVO dgCgoManifestVO) throws EventException {
		return null;
	}

	/**
	 * DG Cargo Manifest 정보 수정
	 * @param DgCgoManifestCondVO dgCgoManifestCondVO
	 * @exception EventException
	 */
	public void manageDgCgoManifest(DgCgoManifestCondVO dgCgoManifestCondVO) throws EventException {}
	
	/**
	 * BKG 정보 조회 
	 * @param IndonesiaManifestListCondVO indonesiaManifestListCondVO
	 * @return List<indonesiaBkgDetailVO>
	 * @exception EventException
	 */
    public List<indonesiaBkgDetailVO> searchBkgInfo(
			IndonesiaManifestListCondVO indonesiaManifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * 중국 세관 테이블에 Customer, Container 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param ChinaBlInfoVO chinaBlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfo(ChinaBlInfoVO chinaBlInfoVO, SignOnUserAccount account) throws EventException {}

	/**
	 * EUR24용 테이블 Customer, Container 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24BlInfoVO eur24BlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfo(Eur24BlInfoVO eur24BlInfoVO, SignOnUserAccount account) throws EventException {}
	
	
    /**
	 * 0408, 0533 등에서 입력한 내용을 저장한다.<br>
	 * 
	 * @param InbondVO[] inbondVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyInbondData(InbondVO[] inbondVO, SignOnUserAccount account) throws EventException{
		return 0;
	}
	

	/**
	 * P/MIB NO Assign 을 위한 조회및 MAX 시퀀스 갱신<br>
	 * 
	 * @param InBondNumberVO[] inBondNumberVO
	 * @return List<InBondNumberDetailVO>
	 * @exception EventException
	 */
	public List<InBondNumberDetailVO> assignInBondNumber(InBondNumberVO[] inBondNumberVO) throws EventException{
		return null;
	}
	
	/**
	 * 세관 신고용 VVD 상세 정보 조회
	 * 
	 * @param cstmsVvdDtlListCondVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CstmsVvdDtlVO> searchCstmsVvdDtlList(CstmsVvdDtlListCondVO cstmsVvdDtlListCondVO) throws EventException {
		return null;
	}

	/**
	 * Discharging CY에 대한 Validation Check
	 * @param String dischCy
	 * @return String
	 * @throws EventException
	 */
	public String searchDischCyValChk(String dischCy) throws EventException {
		return null;
	}

	/**
	 * MSN 배정을 위한 Validation Check
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMsnValChk(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws EventException {
		return null;
	}

	/**
	 * 세관 테이블의 Customer, Container 등의 BL 정보를 삭제한다
	 * 
	 * @param ChinaBlInfoListVO[] chinaBlInfoListVOs
	 * @param String transMode
	 * @exception EventException
	 */
	public void manageBlByVvd(ChinaBlInfoListVO[] chinaBlInfoListVOs, String transMode) throws EventException {}
	
    /**
     * 수정된 Vessel 정보를 BKG CUSTOMS PANAMA VVD에 저장한다.<br>
     * 
     * @param ManifestTransmitVO manifestTransmitVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifySendHist(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {}
    
    /**
	 * 일본세관 전송용 Manifest B/L Status를 Active or Deleted로 업데이트한다.<br>
	 * 
	 * @param List<JapanTransmitBlKeyVO> japanBlKeyVOs
	 * @exception EventException 
	 */    
    public void modifyMsgStatus(List<JapanTransmitBlKeyVO> japanBlKeyVOs) throws EventException {}
    
    /**
	 * SriLanka 세관에 신고할 Vessel Arrival 데이터를 전송한 뒤 Send Date를 저장한다.<br>
	 * 
	 * @param VesselArrivalTransmitVO VesselArrivalTransmitVO
	 * @exception EventException
	 */    
    public void modifySendDt(VesselArrivalTransmitVO VesselArrivalTransmitVO) throws EventException {}    
    
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @throws EventException
	 */    
    public void modifyBlReceivedSts(RocsManifestTransmitVO rocsManifestTransmitVO) throws EventException {}

	/**
	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다.
	 * @param List<RocsManifestTransmitVO> rocsManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
    public void modifyBlSndSts(List<RocsManifestTransmitVO> rocsManifestTransmitVOs, SignOnUserAccount account) throws EventException {}

    /**
	 * Manifest Summary 정보 수정 
	 * @param ManifestSmryCondVO manifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(ManifestSmryCondVO manifestSmryCondVO) throws EventException {}

	/**
	 * Manifest Summary 정보 삭제
	 * @param ManifestSmryVO manifestSmryVO
	 * @exception EventException
	 */
	public void removeManifestSummaryInfo(ManifestSmryVO manifestSmryVO) throws EventException {}

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {}

	/**
	 * Manifest를 전송 후 정보 UPDATE 
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @exception EventException
	 */
	public void transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {}

	/**
	 * EDI 수신 메시지 처리 
	 *  
	 * @param RcvMsgVO rcvMsgVO
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException {}

	/**
	 * Amendment Transmit 후 전송일시 UPDATE
	 * 
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void transAmdManifest(KorBlInfoKorVO korBlInfoKorVO) throws EventException {}

	/**
	 * MFT Manifest EDI 전송후 UPDATE
	 * 
	 * @param ManiCondVO maniCondVO
	 * @throws EventException
	 */
	public void transmitKorMFTManifest(ManiCondVO maniCondVO) throws EventException {	}

	/**
	 * MRN Creation 정보 INSERT
	 * 
	 * @param MrnCreateCondVO mrnCreateCondVO
	 * @throws EventException
	 */
	public void manageMrnCreateInfo(MrnCreateCondVO mrnCreateCondVO) throws EventException {}

	/**
	 * MRN MSN 정보 삭제
	 * 
	 * @param MrnMsnCreateCondVO[] mrnMsnCreateCondVOs
	 * @throws EventException
	 */
	public void removeMrnMsnCreateInfo(MrnMsnCreateCondVO[] mrnMsnCreateCondVOs) throws EventException {}
	/**
	 * MRN MSN 정보 삭제(2013.08 추가)
	 * 
	 * @param MrnCreateInfoVO[] mrnCreateInfoVOs
	 * @throws EventException
	 */
	public void removeMrnMsnCreateInfo(MrnCreateInfoVO[] mrnCreateInfoVOs) throws EventException {}

	/**
	 * DGM Manifest 전송후 VVD, Container 정보 UPDATE
	 * 
	 * @param ManiDGMTransVO maniDGMTransVO
	 * @throws EventException
	 */
	public void transmitDGMManifest(ManiDGMTransVO maniDGMTransVO) throws EventException {}

	/**
	 * VSL, Manifest 정보 조회
	 * 
	 * @param vslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @throws EventException
	 */
	public VslInfoNManifestVO manageVslInfoNManifestList(VslInfoNManifestCondVO vslInfoNManifestCondVO) throws EventException {
		return null;
	}

	/**
	 * Manifest 정보 삭제
	 * 
	 * @param ManiSumCondVO maniSumCondVO
	 * @throws EventException
	 */
	public void manageManifestSummaryInfo(ManiSumCondVO maniSumCondVO) throws EventException {}

	/**
	 * OutBound 의 경우 MSN 정보 추가 처리
	 * 
	 * @param ObMsnInfoCondVO obMsnInfoCondVO
	 * @throws EventException
	 */
	public void manageObMsnInfo(ObMsnInfoCondVO obMsnInfoCondVO) throws EventException {}

    /**
     * B/L 정보를 수정
     * 
     * @param List<TransKeyVO> transKeyVOs 
     * @exception EventException
     */
	public void modifyBl ( List<TransKeyVO> transKeyVOs ) throws EventException {}

    /**
     * B/L 테이블에 전송 내역 데이터 수정
     * 
     * @param List<TransKeyVO> transKeyVOs 
     * @param String pol 
     * @exception EventException
     */
	public void modifyBl2 ( List<TransKeyVO> transKeyVOs, String pol ) throws EventException {}

    /**
     * VVD 테이블에 전송 내역 데이터 수정
     * 
     * @param TransKeyVO transKeyVO 
     * @param String pol 
     * @exception EventException
     */
    public void modifyVvd ( TransKeyVO transKeyVO, String pol ) throws EventException {}

    /**
     * InBound Empty MSN 저장
     * @param MsnNoCondVO[] msnNoCondVOs
     * @throws EventException
     */
	public void manageMsnNo(MsnNoCondVO[] msnNoCondVOs) throws EventException {}

	/**
     * 한국세관 InBound Empty Amend 전송을 위한 처리
     * @param EmpAmdManiVO[] empAmdManiVOs
     * @return EmpAmdManiVO[]
     * @throws EventException
     */
	public EmpAmdManiVO[] manageEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {
		return null;
	}

	/**
     * 한국세관 InBound Empty Amend 전송후 UPDATE 처리
     * 
     * @param EmpAmdManiVO[] empAmdManiVOs
     * @throws EventException
     */
	public void transmitEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {}

	/**
	 * 미세관 응답메세지 수신 결과를 IBD 테이블에 갱신한다.(CSTMS_CLR_CNG_FLG)<br>
	 * 
	 * @param bkgCstmsAdvIbdVOs List<BkgCstmsAdvIbdVO>
	 * @throws EventException
	 */
	public void modifyIbdCstmsClrCngFlg(List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs) throws EventException{}
	
    /**
     * 유져의 버튼 권한을 조회한다.<br>
     * 
     * @param String userId 
     * @param String pgmNo
     * @return String
     * @exception EventException
     */
    public String  searchUserAuthYn(String userId, String pgmNo) throws EventException {
    	return null;
    }
    
    /**
     * 유져의 MI - MULTI 권한을 조회한다.<br>
     * 
     * @param String userId 
     * @return String
     * @exception EventException
     */
    public String  searchUserAuthMiMultiYn(String userId) throws EventException {
    	return null;
    }

    /**
	 * 국가별 Package Unit 조회
	 * 
	 * @param bkgCstmsPckTpConvVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws EventException
	 */
	public List<BkgCstmsCdConvCtntVO> searchPkgUnitList(BkgCstmsCdConvCtntVO bkgCstmsPckTpConvVO) throws EventException {
		return null;
	}
	
	/**
	 * Correction 전송후 SendDate Update
	 * 
	 * @param SndCorrVO sndCorrVO
	 * @throws EventException
	 */
	public void addSndDtCorrInfo(SndCorrVO sndCorrVO) throws EventException {}
	
	/**
	 * SendLog History Detail
	 * 
	 * @return List<CstmsSndLogDtlVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchAncsLane() throws EventException {
		return null;
	}		

	/**
	 * HS CODE 를 입력,수정 삭제 한다. <br>
	 * 
	 * @param brHsCdDetailVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageHSCode(BrHsCdDetailVO[] brHsCdDetailVOs, SignOnUserAccount account) throws EventException {}
	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvd(ManifestListCondVO manifestListCondVO) throws EventException {
		 return null;
	 }
	 
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * Arrival Notice용<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvdForAN(ManifestListCondVO manifestListCondVO) throws EventException {
		 return null;
	 }
	 
	 /**
	  * BL로 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> search1stEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
		 return null;
	 }
	 
	/**
	 * Europe Advanced Manifest - ENS Report조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	public List<Eu24EnsListVO> searchENSReport(Eu24EnsListVO eu24EnsListVO) throws EventException  {
		 return null;
	}
	
	/**
	 * Europe Advanced Manifest - ENS Monitoring조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	public List<Eu24EnsListVO> searchENSMonitoring(Eu24EnsListVO eu24EnsListVO) throws EventException  {
		return null;
	}

	/**
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * 
	 * @param CustomsSetupVO customsSetupVO
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	public List<CustomsSetupVO> searchCustomsSetupList(CustomsSetupVO customsSetupVO) throws EventException {
		return null;
	}
	
	/**
	 * MDM LOCATION 조회<br>
	 * 
	 * @param String cntCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	public List<CustomsSetupVO> searchMdmLocationPort(String cntCd) throws EventException {
		return null;
	}
	
	/**
	 * MDM YARD 조회<br>
	 * 
	 * @param String portCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	public List<CustomsSetupVO> searchMdmYardTmlcode(String portCd) throws EventException{
		return null;
	}
	
	/**
	 * Europe Customs 코드를 관리한다.<br>
	 * @param CustomsSetupVO[] customsSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageEU24CustomsSetup(CustomsSetupVO[] customsSetupVOs,SignOnUserAccount account) throws EventException {}
	


	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException   {
		 return null;
	}
	
	/**
	 * ENS화면 - POL이 EU 포트인지 체크를 위해 EU포트 조회<br>
	 * @param Eu24CountryListVO eu24CountryListVO
	 * @return List<Eu24CountryListVO>
	 * @throws DAOException
	 */
	public List<Eu24CountryListVO> searchEU24CountryList (Eu24CountryListVO  eu24CountryListVO) throws EventException  {
		return null;
	}
	/**
	 * Europe Advanced Manifest-Error Code Table 조회<br>
	 * @param EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO
	 * @return List<EU24RcvErrorCodeTableVO>
	 * @throws EventException
	 */
	public List<EU24RcvErrorCodeTableVO> searchEU24RcvErrorCodeTable(EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO) throws EventException {
		return null;
	}
	
	/**
	 * ESM_BKG_1105.do에서 사용되는 서비스<br>
	 * VVD가 변경됨에 따라 Original port와 Yard code가 변경되는 메서드
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException 
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchCstmsENSPofeList(ManifestListCondVO manifestListCondVO) throws EventException{
		return null;
	}
	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	public List<ManifestListDetailVO> searchEuPolByVvd(ManifestListCondVO manifestListCondVO) throws EventException{
		return null;
	}
	
	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestOBList(ManifestListCondVO manifestListCondVO) throws EventException{
		return null;
	}

	/**
	 * OUTBOUND용 VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String manageManifestOB(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		return null;
	}
	/**
	 * Europe Advanced Manifest - EXS Report조회<br>
	 * 
	 * @param Eu24ExsListOBVO eu24ExsListOBVO
	 * @return List<Eu24ExsListOBVO>
	 * @throws EventException 
	 */
	public List<Eu24ExsListOBVO> searchEXSReportOB(Eu24ExsListOBVO eu24ExsListOBVO) throws EventException  {
		 return null;
	}
	
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryOBVO historyOBVO
	 * @return List<EU24EDIHistoryOBVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryOBVO> searchEU24EDIHistoryOB(EU24EDIHistoryOBVO historyOBVO) throws EventException   {
		 return null;
	}
	/**
	 * ESM_BKG_0462.do에서 사용되는 서비스<br>
	 * WGT 정수 값 자리수가 7자리 이상인 경우에 Booking No 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return String
	 * @throws EventException 
	 */
//	public String searchWgtErrBkgNo(ManifestListCondVO manifestListCondVO) throws EventException{
//		return null;
//	}
	
	
	 /**
	  * EXS용(1121) BL 정보 조회를 위해 BL_NO로 VVD,POL,POD 등을 먼저 조회한다.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEuOBVvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
		 return null;
	 }	
	 
	 
   /**
	* ESM_BKG_1135 : SEARCH <br>
	* ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	* 
	* @return List<BkgHrdCdgCtntVO>
	* @exception DAOException
	*/
	public List<BkgHrdCdgCtntVO> searchRocsLane() throws EventException {
		 return null;
	}
	 
	/**
	* ESM_BKG_1135 : MULTI <br>
	* ROCS 의 CRN List 화면에서 Lane 정보 수정<br>
	* 
	* @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	* @param SignOnUserAccount account
	* @exception EventException
	*/
	public void manageRocsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account) throws EventException {}

	/**
	 * ESM_BKG_1146 : MULTI02 <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Save & Select<br>
	 * 
	 * @param EurCrnRcvMsgVO[] eurCrnRcvMsgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePrevDocNo(EurCrnRcvMsgVO[] eurCrnRcvMsgVOs, SignOnUserAccount account )throws EventException{};
	
	   /**
     * ESM_BKG_1144 SNP/Broker Nomination 조회<br>
     * 
     * @param OrgPartyVO  orgPartyVO
     * @return List<OrgPartyVO>
     * @exception EventException
     */
	public List<OrgPartyVO> searchOrgPartyList( OrgPartyVO  orgPartyVO ) throws EventException {
		return null;
	}	
	
	/**
	 * ESM_BKG_1144 : MULTI <br>
	 * SNP/Broker Nomination 화면에서 SAVE<br>
	 * @param OrgPartyVO[]  orgPartyVOs
	 * @exception EventException
	 */
	public void manageOrgPartyInfo(OrgPartyVO[]  orgPartyVOs)throws EventException{};
	
	/**
	 * ESM_BKG_1146 : SEARCH <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No pop-up 조회<br>
	 * 
	 * @param EurCrnRcvMsgVO eurCrnRcvMsgVO
	 * @return List<EurCrnRcvMsgVO>
	 * @throws EventException
	 */
	public List<EurCrnRcvMsgVO> searchPrevDocNo(EurCrnRcvMsgVO eurCrnRcvMsgVO) throws EventException{
		return null;
	}
	
	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 * @param KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs
	 * @param SignOnUserAccount account
	 * @return KorManifestCrsChkInfoVO
	 * @exception EventException
	 */	
	public KorManifestCrsChkInfoVO manageCrossCheck(KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs , SignOnUserAccount account) throws EventException{
		return null;
	}
	
	/**
	 * Amendment Transmit 후 SndFlg UPDATE
	 * 
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void modifySndFlg(KorBlInfoKorVO korBlInfoKorVO) throws EventException {}
	
	
	/**
	 * Europe Advanced Manifest - EXS Monitoring 조회<br>
	 * 
	 * @param Eu24EXSListVO eu24EXSListVO
	 * @return List<Eu24EXSListVO>
	 * @throws EventException 
	 */
	public List<Eu24EXSListVO> searchEXSMonitoring(Eu24EXSListVO eu24EXSListVO) throws EventException {
		return null;
	}
	
	/**
	 * 
	 * 
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public List<KorManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(KorMrnNoVO manifestInfoVO) throws EventException {
		return null;
	}

	/**
	 * 
	 * 
	 * @param KorMrnNoVO manifestInfoVO
	 * @return KorMrnNoVO
	 * @throws EventException
	 */
	public KorMrnNoVO searchManifestCrsChkInfoSumKorList(KorMrnNoVO manifestInfoVO) throws EventException {
		return null;
	}
	
	/**
	 * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회
	 * @param  ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchPreEUportByVvd(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}
	
	/**
	 * Finland (IE344) / BL 로 해당하는 vvd 의 pre EU Port 를 조회
	 * @param  ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchPreEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param String usrId
	 * @param ManifestListCondVO manifestListCondVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(String usrId, ManifestListCondVO manifestListCondVO, String pgmNo) throws EventException {
		return null;
	}
	
	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.<br>
	 * 
	 * @param FdrBlInVO fdrBlInVO
	 * @return List<FdrBlVO>
	 * @exception EventException
	 */
	public List<FdrBlVO> searchBkgListForFdrBl(FdrBlInVO fdrBlInVO) throws EventException{
		return null;
	}
	
	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.<br>
	 * 
	 * @param FdrBlVO[] fdrBlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustInfoBkgCstmsRuCust(FdrBlVO[] fdrBlVOs, SignOnUserAccount account) throws EventException{	}
	
	/**
	 * 입력된 VVD 가 이스라엘을 거치는지 아닌지 VVD schedule 을 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselSchedule(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}
	
	/**
	 * 이스라엘 수신 히스토리를 조회한다.
	 * 
	 * @param IsraelRcvHisCondVO israelRcvHisCondVO
	 * @return List<IsraelRcvHisCondVO>
	 * @exception EventException
	 */
	public List<IsraelSearchRcvHisVO> searchRcvHis(IsraelRcvHisCondVO israelRcvHisCondVO) throws EventException{
		return null;
	}
	
	/**
	 * ESM_BKG_1163
	 * SAVE 시 CNTR WGT 정보 저장
	 * 
	 * @param ModifyCntrInfoVO[] modifyCntrInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRussiaCntrInfo(ModifyCntrInfoVO[] modifyCntrInfoVOs, SignOnUserAccount account) throws EventException {};
	
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIFIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException   {
		 return null;
	}
	
	/**
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다.
	 * 
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	public void manageFIVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {}

	
//	/**
//	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션
//	 * 
//	 * @param VesselArrivalCondVO vesselArrivalCondVO
//	 * @return List<VesselArrivalDetailVO>
//	 * @exception EventException
//	 */
//	public List<VesselArrivalDetailVO> searchVesselFIArrival(VesselArrivalCondVO vesselArrivalCondVO)
//			throws EventException {
//		return null;
//	}
	
	/**
	 * EU A/N (ESM_BKG_1104) 에서 구주스탭이 해당 VVD 의 모든 MRN 을 삭제
	 * 
	 * @param eur24VesselArrivalNoticeDetailVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteAllMrn(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException {}
		
	
	/**
	 * CRN List를 조회한다.
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @return List<CndCstmsVslCrnNoVO>
	 * @exception EventException
	 */
	public List<CndCstmsVslCrnNoVO> searchBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws EventException{
		return null;
	}

	/**
	 * CRN List를 삭제한다.
	 * @param CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO
	 * @exception EventException
	 */
	public void removeBkgCstmsCndVslCrnNo(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) throws  EventException {}

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 조회<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @return List<ChinaVslRgstVO>
	 * @exception EventException
	 */
	public List<ChinaVslRgstVO> searchChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO) throws EventException {
		return null;
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 저장<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @param ChinaVslRgstVO[] chinaVslRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO, ChinaVslRgstVO[] chinaVslRgstVOs, SignOnUserAccount account) throws EventException {}

	
	/**
	 * [ESM_BKG_1179]
	 * Customer Status Notice 정보 조회<br>
	 * 
	 * @param hndlOfcCd
	 * @return UsCustomsStatusNoticeVO 
	 * @exception EventException
	 */	
	public UsCustomsStatusNoticeVO searchUsCustomsStatusNoticeInfo(String hndlOfcCd) throws EventException {
		return null;
	}

	/**
	 * [ESM_BKG_1179] 
	 * Customer Status Notice 정보 조회<br>
	 * 
	 * @param usCustomsStatusNoticeVO
	 * @exception EventException
	 */	
	public void manageUsCustomsStatusNoticeInfo(UsCustomsStatusNoticeVO usCustomsStatusNoticeVO) throws EventException {
	}


	/**
	 * BL 갯수 정보를 return하기 위해서
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchBlKnt(ManifestListCondVO manifestListCondVO) throws EventException {

		return null;
	} 
	
	/**
	 * 베트남 세관 새로운 엑셀파일 형식 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<VietnamManifestListSecondBlInfoVO>
	 * @exception EventException
	 */
	public List<VietnamManifestListSecondBlInfoVO> searchManifestExcelList(ManifestListCondVO manifestListCondVO) throws EventException {
		return null;
	}
	

	/**
     * 호주 위험물 정보 조회시, 위험물테이블과 booking쪽 테이블에서 동시에 조회한다.<Br>
     * 
	 * @param AusDgListCondVO ausDgListCondVO
     * @return List<AusBkgAndLocalDgListDetailVO> 
     * @throws EventException
     */
	
	 public List<AusBkgAndLocalDgListDetailVO> searchAusDgInfoAtBkgAndLocal(AusDgListCondVO ausDgListCondVO) throws EventException { 
		 return null;
	 }
	
	
	 /**
	     * 호주 위험물 정보 조회한다.<Br>
	     * 
		 * @param AusDgListCondVO ausDgListCondVO
	     * @return List<AusDgListDetailVO>
	     * @throws EventException
	     */
	public List<AusDgListDetailVO> searchAusDgInfo(AusDgListCondVO ausDgListCondVO) throws EventException {
		return null;
	}
	
	/**
     * 호주 위험물 화면 상단의 vessel 정보를 조회한다.<Br>
     * 
	 * @param AusDgListCondVO ausDgListCondVO
     * @return List<AusVslInfoVO>
     * @throws EventException
     */
	public List<AusVslInfoVO> searchAusVslInfo(AusDgListCondVO ausDgListCondVO) throws EventException {
		return null;
	}
	
	
	/**
     * 호주 위험물 정보를 수정한다.<Br>
     * @param AusVslInfoVO ausVslInfoVO
	 * @param AusDgListDetailVO[] ausDgListDetailVOs
	 * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageDgManifestList(AusVslInfoVO ausVslInfoVO, AusDgListDetailVO[] ausDgListDetailVOs, SignOnUserAccount account) throws EventException {
	
	}
	
	/**
     * 호주 1512팝업 Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
     * 
     * @param dgCargoCondVO
     * @return DgInqModiVO
     * @throws EventException
     */
	
	public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException {
		return null;
	}
	
	
	   /**
			 * 호주 위험물 상세 정보들을 저장한다.<br>
			 * 
			 * @param  DgInqModiVO dgInqModiVO
			 * @param  SignOnUserAccount account
			 * @throws EventException
			 */
	 public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException {

	 }
	 
	 
	    /**
	     * 호주 1512팝업 DG: 	Forward Code로 Forward Name을 조회한다.<br>
	     * 
	     * @param dgListCondVO
	     * @return
	     * @throws EventException
	     */
	    public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException { 
	    	return null;
	    }	
	    
	    
	    /**
	     * 호주 1512팝업 DG: UN NO로 NAME을 조회한다.<br>
	     * 
	     * @param dgListCondVO
	     * @return
	     * @throws EventException
	     */
	    public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException { 
	    	return null;
	    }
	    
	    /**
		 *호주 1512팝업 DG: Feeder Name, Lloyd No를 조회한다.<br>
	     * 
		 * @return List<FeederNameVO>
	     * @throws EventException
	     */
	    public List<FeederNameVO> searchDgFeederNameList() throws EventException { 
	    	return null;
	    }
	    
	    /**
	     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	     * 
	     * @param dgCargoCondVO
	     * @return List<DgCntrInfoListVO>
	     * @throws EventException
	     */
	    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException { 
	    	return null;
	    }
	    
	    /**
	     * 호주 1512팝업 DG: 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	     * 
	     * @param dgCargoCondVO
	     * @return List<DgCntrInfoListVO>
	     * @throws EventException
	     */
	    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException { 
	    	return null;
	    }
	    
//	    
//	    /**
//	     * 호주 1512팝업 DG: Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
//	     * 
//	     * @param dgCargoCondVO
//	     * @return DgInqModiVO
//	     * @throws EventException
//	     */
//	    public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException { 
//	    	return null;
//	    }	
	    
		
		
    /**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 VVD 존재 여부를 확인한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVvdInfo(ManifestListCondVO manifestListCondVO) throws EventException{
		return null;
	}

	
	/**
	 * ROCS(ROTTERDAM) - CRN Creation & Management (POD Calling Seq, Turn VVD 로직 적용)
	 * @param CrnVO crnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCrnWithCallSeq(CrnVO crnVO, SignOnUserAccount account) throws EventException{
		return null;
	}
		
	/**
	 * ROCS(ROTTERDAM) 세관 Manifest의 CRN No.를 update 한다
	 * @param CrnVO crnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifyCrnNoWithCallSeq(CrnVO crnVO, SignOnUserAccount account) throws EventException {
		return null;
	}
	
	/**
	 * Warehouse Assign by B/L - Rate 중에 WHF list 찾기
	 * @param DiscCYBondInfoVO discCYBondInfoVO
	 * @return List<KorDiscCYBondInfoVO> 
	 * @exception EventException
	 */
	 public List<KorDiscCYBondInfoVO> searchWhfRateList(DiscCYBondInfoVO discCYBondInfoVO) throws EventException{
		 return null;
	 }
	 
	/**
	 * Warehouse Assign by B/L - BB Cgo의 WHF의 금액 계산하기
	 * @param KorDiscCYBondInfoVO korDiscCYBondInfoVO
	 * @return List<KorDiscCYBondInfoVO>
	 * @exception EventException
	 */
	public List<KorDiscCYBondInfoVO> searchWhfBbCgoWgtInfo(KorDiscCYBondInfoVO korDiscCYBondInfoVO) throws EventException{
		return null;
	}
	
	/**
	 * Warehouse Assign by B/L - KOREA WHF Port Rate 값 구하기
	 * @param KorDiscCYBondInfoVO korDiscCYBondInfoVO
	 * @return List<KorDiscCYBondInfoVO>
	 * @exception EventException
	 */
	public List<KorDiscCYBondInfoVO> searchWhfPortRt(KorDiscCYBondInfoVO korDiscCYBondInfoVO) throws EventException{
		return null;
	}

	/**
	 * Warehouse Assign by B/L - KOREA WHF Wave 정보를 Hard Coding 테이블에서 가져오기
	 * @param KorDiscCYBondInfoVO korDiscCYBondInfoVO
	 * @return List<KorRateHeadVO>
	 * @exception EventException
	 */
	public List<KorRateHeadVO> searchWhfWaveInfo(KorDiscCYBondInfoVO korDiscCYBondInfoVO) throws EventException{
		return null;
	}
	
	/**
	 * MRN Check Digit 정보 Update
	 * 
	 * @param MrnCreateCondVO mrnCreateCondVO
	 * @throws EventException
	 */
	public void modifyMrnCehckDigit(MrnCreateCondVO mrnCreateCondVO) throws EventException{		
	}
	
}
