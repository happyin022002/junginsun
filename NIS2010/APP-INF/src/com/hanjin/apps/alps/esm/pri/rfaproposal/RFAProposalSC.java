/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAProposalSC.java
 *@FileTitle : S/C Location Group Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.06
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.06 변영주
 * 1.0 Creation
=========================================================
 * History
 * 2011.04.08 김민아 [CHM-201110030-01] Approve 상태에서 Save 시 Request Office 와 Sales Rep 을 비교하여 수정 사항이 존재할 경우 EDI 호출하도록 수정 
 * 2011.06.24 김민아 [CHM-201111756-01] SC, RFA 정보 CRM I/F 주기 변경 요청 - Approve 시 Sales Lead No 유무에 상관없이 해당 정보를 CRM으로 전송 및 Approved 상태에서 Save시 S.Rep 이 변경되었을 경우 CRM으로 전송 추가
 * 2011.06.27 이행지 [CHM-201111837]    Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : 배열 접근시 첨자(index)는 유효한 범위내에서 사용해야 한다. => 배열 size 0 이상일때 VO로 매핑시켜 사용하도록 변경
 * 2012.09.18 원종규 [CHM-201220110-01] 계약 변경 통보 기능-계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
 * 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리
 * 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
 * 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
 * 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
 * 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
 * 2014.12.10 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
 * 2015.01.02 최성환 [CHM-201433110] RFA Proposal & Amendment Status 조회 기능 개선
 * 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
* 2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
 * 2015.11.26 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2015.12.16 SELCMU/김현경 [CHM-201539304] Arbitrary GL Amt backendjob 으로 전환요청
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.05.23.CHM-201641745_[RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
 * =========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFACopyMstToBzcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.vo.CstPriCrmSlsLdVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.basic.RFAAffiliateProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.basic.RFAAffiliateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri200306Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri201906Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri204107Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri2010Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri204101Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.CstScpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.basic.RFAGRICalculationProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.basic.RFAGRICalculationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2033Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2035Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2037Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2087Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2233Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri200303Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri201903Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri204103Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri200302Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri201902Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri204104Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.integration.RFAGroupLocationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.basic.RFANoteConversionProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.basic.RFANoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.basic.RFANoteProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.basic.RFANoteProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri200301Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri201901Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri204108Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri204109Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri2058Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2003Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2007Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2017Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2019Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2020Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2040Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2041Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2044Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2045Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2049Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2054Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2080Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2203Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2244Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri6091Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpAmendVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.MasterInfoFromBasicVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriEdiRfGenInfVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpRetroVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForMatchBackVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefByOfcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.SchSaleLeadRfaVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri200307Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri200308Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri200313Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri201907Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri201908Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri201913Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2022Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2023Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2024Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2025Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2028Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2030Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2034Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2036Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204105Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204110Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204113Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2047Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2055Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2060Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2065Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2067Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2068Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2069Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2070Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2075Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2082Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2208Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6047Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6048Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6049Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6064Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6067Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6070Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6073Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6080Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6083Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6087Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaSummryAcceptAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRoutListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrInquiryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRouteMBListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic.RFATransportationAdditionalChargeProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic.RFATransportationAdditionalChargeProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri200304Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri200305Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri200312Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri201904Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri201909Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri201912Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2029Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri204106Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri204111Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri204112Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2050Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2051Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2053Event;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic.RFAQuotationMainBC;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic.RFAQuotationMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpScpDelCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRpAfilVO;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefVO;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * NIS2010-SCProposal Business Logic ServiceCommand - NIS2010-SCProposal 대한 비지니스 트랜잭션을 실행한다.
 *  
 * @author Byeon Young Joo
 * @see RFAGroupLocationProposalDBDAO
 * @since J2EE 1.4
 */

public class RFAProposalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SCProposal system 업무 시나리오 선행작업<br>
	 * ESM_PRI_2003업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCProposal system 업무 시나리오 마감작업<br>
	 * ESM_PRI_2003 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RFAProposalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-SCProposal system 업무에서 발생하는 모든 이벤트의 분기실행<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 실행하는 경우 사용해야 할 부분
		// 2003, 2103
		if (e.getEventName().equalsIgnoreCase("EsmPri2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalMain(e);
			} //2103 - Retrieve - SEARCH39
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH39)) {
				eventResponse = searchProposalMainSpot(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalCustomerInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchProposalAmendmentSummary(e);
				// 2003_search03==searchProposalAmendmentSummary==사용안함=확인후삭제
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalScopeAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchProposalAcceptCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchProposalCountOfferCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRequestTermsCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchProposalScopeStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchProposalDeleteCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCheckDmdtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchCheckDurationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchProposalMainSaleLeadFirstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchProposalMainSaleLeadList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchApprovalCancelCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = checkRouteTermMissing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchProposalMainPRSCMData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchProposalMainStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchProposalRequestCancelCheck(e);
			}  //2003 - Save - MULTI01
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageProposal(e);
			} //2103 - Save - MULTI11
			else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {
				eventResponse = manageProposalSpot(e);				
			} //2003 , 2103 - REQUEST, Counter Offer - MULTI02
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = counterofferProposal(e);
			}  //2003 - Approve - MULTI03
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = approveProposal(e);
			} //2103 - Approve - MULTI13
			else if (e.getFormCommand().isCommand(FormCommand.MULTI13)) {
				eventResponse = approveProposalSpot(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = cancelProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageProposalAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = manageProposalScopeAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchProposalRequestIhcRateCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = managePriRpScpTrspAddChgCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchProposalRequestPortCyCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = checkRfaContractTpActCust(e);
				//Retroactive RFA 대상 여부를 확인
			    //-------------------------------------------------------------------------------------------------------------	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				eventResponse = checkDurationBasicRFACopy(e);	 //------------------------check Duration for Basic Copy 
			   //-------------------------------------------------------------------------------------------------------------						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchRetroactiveExistCheck(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				// M/B 활성화 여부를 위해 calcutae 하지 않는 scope를 조회
				eventResponse = searchMatchBackCheckCalculate(e);
			//-------------------------------------------------------------------------------------------------------------	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
				eventResponse = manageBasicProposalAll(e);
				
		    //-------------------------------------------------------------------------------------------------------------
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH30)) {
				// [CHM-201642287] Basic RFA용 Amend Check
				eventResponse = checkBasicAmendable(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH26)){
			    eventResponse = searchCheckDemDetExceptionNewVer(e);
		    //-------------------------------------------------------------------------------------------------------------
			} else {
				eventResponse = initMainComboData(e);
			}
		}
		// ============================ESM_PRI_2003_01_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchNoteMaxDpSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchNoteContentMaxDpSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchNoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageNoteConversionCopy(e);
			} else {
				eventResponse = searchCommonSpecialNoteList(e);
			}
		}
		// ============================ESM_PRI_2003_02_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationRateApplyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = copyGuidelineGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = checkOriDestGroupLocationInUse(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2003_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200303Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityRateApplyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = copyGuidelineGroupCommodity(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}
		// ============================ESM_PRI_2003_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkGuidelineCopyArbitraryChargeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkArbitraryFontStyle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // guideline copy
				eventResponse = copyGuidelineArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = acceptArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = cancelArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = acceptAllArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = cancelAllArbitraryCharge(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2003_05_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200305Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICBasePortListByGLine(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFICRouteByGLine(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGLineInfoByFICRoute(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2050_Start=======================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResult(e);
			} else {
				eventResponse = searchCommonUploadArbitraryChargeProposal(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmPri200307Event")) {
			// ================== ESM_PRI_2003_07 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkGlineCopyGroupCodeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchRateCmdtRoutStyle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRateCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
				eventResponse = cancelAllRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
				eventResponse = copyGuidelineRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = executeCalculate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = monitorCalculate(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri200308Event")) {
			// ================== ESM_PRI_2003_08 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkRateFontStyle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchMaxCmdtHdrSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchLocalFicGlineRtAmt(e);
			} else {
				eventResponse = initRateComboData(e);
			}
			// ================== ESM_PRI_2003_07 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri204105Event")) {
			// ================== ESM_PRI_2041_05 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateHistoryList(e);
			} else {
				eventResponse = initRateComboData(e);
			}
			// ================== ESM_PRI_2041_05 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri201907Event")) {
			// ================== ESM_PRI_2019_07 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryList(e);
			} else {
				eventResponse = initRateComboData(e);
			}
			// ================== ESM_PRI_2019_07 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2023Event")) {
			// ================== ESM_PRI_2023 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCommodityDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCommodityDetail(e);
			}
			// ================== ESM_PRI_2023 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2025Event")) {
			// ================== ESM_PRI_2025 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateRoutePntVia(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateRoutePntVia(e);
			}
			// ================== ESM_PRI_2025 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2028Event")) {
			// ================== ESM_PRI_2028 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptFicRateRoutePntVia(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelFicRateRoutePntVia(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICRouteGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCYPortLocation(e);
			}
			// ================== ESM_PRI_2028 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2065Event")) {
			// ================== ESM_PRI_2065 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVertical(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVertical(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelVerticalOnline(e);
			} else {
				eventResponse = initRateExcelVertical(e);
			}
			// ================== ESM_PRI_2065 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2033Event")) {
			// ================== ESM_PRI_2033 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = applyGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelGRICalculation(e);
			}
			// ================== ESM_PRI_2033 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2087Event")) {
			// ================== ESM_PRI_2087 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationHistoryList(e);
			}
			// ================== ESM_PRI_2087 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2082Event")) {
			// ================== ESM_PRI_2082 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptActualCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelActualCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkActualCustomer(e);
			} 
			// ================== ESM_PRI_2082 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2022Event")) {
			// ================== ESM_PRI_2022 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRateCnoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageRateCnoteConversionCopy(e);
			} else {
				eventResponse = searchCommonRateCnoteList(e);
			}

			// ================== ESM_PRI_2022 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2034Event")) {
			// ================== ESM_PRI_2034 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCheckDuplicate(e);
			}
			// ================== ESM_PRI_2034 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2036Event")) {
			// ================== ESM_PRI_2036 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAllScopeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	 // spot
				eventResponse = searchAllRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptAllScopeTerms(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {	 // spot
				eventResponse = acceptAllRate(e);
			} else {
				eventResponse = initSummaryDataList(e);
			}
			// ================== ESM_PRI_2036 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2024Event")) {
			// ================== ESM_PRI_2024 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCommodityRnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCommodityRnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRateCommodityRnoteConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRateCommodityRnoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageRateCommodityRnoteConversionCopy(e);
			} else {
				eventResponse = searchCommonCommodityRnoteList(e);
			}

			// ================== ESM_PRI_2024 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2060Event")) {
			// ================== ESM_PRI_2060 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelHorizontalOnline(e);
			} else {
				eventResponse = initRateExcelHorizontal(e);
			}
			// ================== ESM_PRI_2060 END ==================
			// SC가 여러 이벤트를 실행하는 경우 사용해야 할 부분
			// ============================ESM_PRI_6064_Start====================================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri6064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCostDetailInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPrsCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyPrsSimulationCost(e);
			}
			// =============================ESM_PRI_6064_end===================================
		}
		// [CHM-201535165] RFA match back 팝업화면 추가
		// ============================ESM_PRI_2055 START====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateRouteMBList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRatePortMBList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPrsMBFlgOnChangeStatus(e);
			}
			// =============================ESM_PRI_2055 END===================================
		}

		// ============================ESM_PRI_6070_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateSurcharge(e);
			}
			// =============================ESM_PRI_6070_end===================================
		}
		// ============================ESM_PRI_6073_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeAdjustList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSurchargeAdjust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeAdjustCalc(e);
			}
			// =============================ESM_PRI_6073_end===================================
		}

		// ============================esm_pri_6080_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupCommodityDetailList(e);
			}
			// =============================esm_pri_6080_end===================================
		}
		// ============================esm_pri_6083_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateLocationAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupLocationDetailList(e);
			}
			// =============================esm_pri_6083_end===================================
		}
		// ============================esm_pri_6067_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostDetailByTransModeList(e);
			}
			// =============================esm_pri_6067_end===================================
		}
		// ============================ESM_PRI_6048_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCmViewAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPrsPfmc(e);
			}
			// =============================ESM_PRI_6048_end===================================
		}
		// ============================ESM_PRI_6049_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmdtRateCmViewAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAmdtRateCmpbAndOpbViewAll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAmdtPrsPfmc(e);
			}
			// =============================ESM_PRI_6049_end===================================
		}
		// ============================ESM_PRI_2010_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalDurationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalScopeCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalDurationAmendCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchProposalDurationScopeCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalDurationAcceptCount(e);
			} else {
				eventResponse = initDurComboData(e);
			}
		}
		// =============================ESM_PRI_2010_end===================================

		// ============================ESM_PRI_2040_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = amendProposal(e);
			} // ESM_PRI_2240 Master RFA Amend
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = amendProposalMst(e);
			}
		}
		// ============================ESM_PRI_2040_end===================================

		// ============================esm_pri_6047_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCmpbViewAllList(e);
			}
			// =============================esm_pri_6047_end===================================
		}
		// =============================ESM_PRI_2003_06_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200306Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAffiliateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManualCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = acceptAllAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = cancelAllAffiliate(e);
			} else {
				eventResponse = initAffilComboData(e);
			}
			// =============================ESM_PRI_2003_06_end===================================
		}

		// ============================ESM_PRI_2041_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilHistoryList(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}

		// ============================ESM_PRI_2041_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailHistoryList(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2041_08_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionHistoryList(e);
			} else {
				eventResponse = searchCommonSpecialNoteHistoryList(e);
			}
		}
		// ============================ESM_PRI_2019_01_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionInquiryList(e);
			} else {
				eventResponse = searchCommonSpecialNoteInquiryList(e);
			}
		}
		// ============================ESM_PRI_2019_02_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201902Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailInquiryList(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2019_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201903Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilInquiryList(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDEMDETExceptionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = manageDEMDETException(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Accept
				eventResponse = acceptDEMDETException(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Accept Cancel
				eventResponse = cancelDEMDETException(e);
			} else {
				eventResponse = initDEMDETComboData(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCargoSepcification(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateCargoSepcification(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCargoSepcificationInquiry(e);
			}
		}

		// ============================esm_pri_2041_Start====================================
		//2041, 2141
		else if (e.getEventName().equalsIgnoreCase("EsmPri2041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAmendmentHistoryMain(e);
			} // 2141 -Main Retrieve - SEARCH11
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchAmendmentHistoryMainSpot(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAmendmentHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchHistoryAmendTermList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAmendmentHistorySummary(e);
			} else {
				eventResponse = initAmendHistoryInquiry(e);
			}
			// =============================esm_pri_2041_end===================================
		}
		// ============================ESM_PRI_0041_01_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalDurationHistoryList(e);
			}
		}
		// =============================ESM_PRI_0041_01_end===================================
		// ============================ESM_PRI_2041_07_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAffiliateHistoryList(e);
			}
		}
		// =============================ESM_PRI_2041_07_end===================================
		// ============================ESM_PRI_2041_09_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDEMDETExceptionHistoryList(e);
			}
		}
		// =============================ESM_PRI_2041_09_end===================================

		// ============================ESM_PRI_2041_06_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkHistoryArbitraryFontStyle(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2041_06_End=======================================

		else if (e.getEventName().equalsIgnoreCase("EsmPri2044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalCopyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyProposal(e);
			}
			// =============================ESM_PRI_0096_end===================================

		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOrganizationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageProposalRequestMessage(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalRequestList(e);
			}
		}

		// CHOI [CHM-201433110] RFA Proposal & Amendment Status 조회 기능 개선
		else if (e.getEventName().equalsIgnoreCase("EsmPri2054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalRequestByOfficeList(e);
			}
		}
		
		//2019, 2119
		else if (e.getEventName().equalsIgnoreCase("EsmPri2019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalMainInquiryList(e);
			} //2119 -Main Retrieve - SEARCH10
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchProposalMainSpotInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalMainInquiry(e);
			}  //2119 - Detail Retrieve - SEARCH11
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchProposalMainSpotInquiry(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalCustomerInfoInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalScopeAmendmentSummaryInquiry(e);
			} else {
				eventResponse = initProposalInquiry(e);
			}
		}

		//2020, 2120
		else if (e.getEventName().equalsIgnoreCase("EsmPri2020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalMainViewInquiry(e);
			} //2120 - SEARCH11
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					eventResponse = searchProposalMainViewSpotInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalScopeAmendmentSummaryViewInquiry(e);
			}
		}
		// ============================ESM_PRI_2019_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201904Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkArbitraryInquiryFontStyle(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2019_04_End====================================

		else if (e.getEventName().equalsIgnoreCase("EsmPri2080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGuidelineCopyCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyScopeGuideline(e);
			} else {
				eventResponse = searchGuidelineCopySvcScpName(e);
			}
		}

		// =============================ESM_PRI_2019_06_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAffiliateInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAffiliateHeader(e);
			}
			// =============================ESM_PRI_2019_06_end===================================
		}

		// =============================ESM_PRI_2084_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2084Event")) {
			eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}

		// =============================ESM_PRI_2085_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2085Event")) {
			eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}

		// =============================ESM_PRI_2072_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2072Event")) {
			eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}

		// =============================ESM_PRI_2073_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2073Event")) {
			eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}
		// =============================ESM_PRI_6087_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeViewAllList(e);
			}
		}
		// =============================ESM_PRI_6087_end ===================================

		// =============================ESM_PRI_6091_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6091Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMQCEstimateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckMQCEstimateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMQCEstimateList(e);
			}
		}
		// =============================ESM_PRI_6091_end ===================================

		// =============================ESM_PRI_2029_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchGuidelineRoutePopupList(e);
			}
		}
		// =============================ESM_PRI_2029_end ===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2067Event")) {
			// ================== ESM_PRI_2067 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVerticalForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFicGuidelineRateForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVerticalForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelVerticalOnlineForAeeAew(e);
			} else {
				eventResponse = initRateExcelVerticalForAeeAew(e);
			}
			// ================== ESM_PRI_2067 END ==================
		}

		// ============================ESM_PRI_2019_08_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201908Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRateInquiryFontStyleForAeeAew(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		}
		// =============================ESM_PRI_2019_08_end ===================================

		// ============================ESM_PRI_2019_09_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201909Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeInquiryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkArbitraryInquiryFontStyleForAeeAew(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2019_09_End====================================

		// ================== ESM_PRI_2068 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontalForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontalForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelHorizontalOnlineForAeeAew(e);
			} else {
				eventResponse = initRateExcelHorizontalForAeeAew(e);
			}
		}
		// ================== ESM_PRI_2068 END ==================

		// ============================ESM_PRI_2041_10_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityHistoryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteHistoryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateHistoryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRateHistoryFontStyleForAeeAew(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		}
		// ============================ESM_PRI_2041_10_End====================================
		// ============================ESM_PRI_2041_11_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeHistoryListForAeeAew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkHistoryArbitraryFontStyleForAeeAew(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2041_11_End=======================================

		// ============================ESM_PRI_2051_Start=======================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeProposalForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResultForIHC(e);
			} else {
				eventResponse = searchCommonUploadArbitraryChargeProposalForIHC(e);
			}
		}
		// ================== ESM_PRI_2035 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderListForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationListForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGRICalculationValidation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGRICalculationForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = applyGRICalculationForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelGRICalculationForIHC(e);
			}
		}
		// ================== ESM_PRI_2035 END ==================

		// ================== ESM_PRI_2003_13 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200313Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = executeCalculateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = monitorCalculateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkRateFontStyleForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchMaxCmdtHdrSeqForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchLocalFicGlineRtAmtForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcelForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcelForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkGlineCopyGroupCodeExistForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchRateCmdtRoutStyleForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRateCommodityForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
				eventResponse = cancelAllRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
				eventResponse = copyGuidelineRateForAddOnTariff(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		}
		// ================== ESM_PRI_2003_13 END ==================
		// ================== ESM_PRI_2030 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptFicRateRoutePntViaForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelFicRateRoutePntViaForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICRouteGroupForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCYPortLocationForAddOnTariff(e);
			}
		}
		// ================== ESM_PRI_2030 END ==================
		// ================== ESM_PRI_2003_12 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200312Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICBasePortListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFICRouteForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGLineInfoByFICRouteForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchArbitraryChargeListForAddOnTariff(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ================== ESM_PRI_2003_12 END ==================

		// ================== ESM_PRI_2069 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVerticalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFicGuidelineRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVerticalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelVerticalOnlineForAddOnTariff(e);
			} else {
				eventResponse = initRateExcelVerticalForAddOnTariff(e);
			}
		}
		// ================== ESM_PRI_2069 END ==================

		// ================== ESM_PRI_2070 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelHorizontalOnlineForAddOnTariff(e);
			} else {
				eventResponse = initRateExcelHorizontalForAddOnTariff(e);
			}
		}
		// ================== ESM_PRI_2070 END ==================

		// ============================ESM_PRI_2053 START=======================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeProposalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResultForAddOnTariff(e);
			} else {
				eventResponse = searchCommonUploadArbitraryChargeProposalForAddOnTariff(e);
			}
		}
		// ============================ESM_PRI_2053 END =======================================

		// ================== ESM_PRI_2037 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGRICalculationValidationForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGRICalculationForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = applyGRICalculationForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelGRICalculationForAddOnTariff(e);
			}
		}
		// ================== ESM_PRI_2037 END ==================

		// ============================ESM_PRI_2019_12_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201912Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeInquiryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkArbitraryInquiryFontStyleForAddOnTariff(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2019_12_End====================================

		// ============================ESM_PRI_2019_13_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201913Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRateInquiryFontStyleForAddOnTariff(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		}
		// =============================ESM_PRI_2019_13_end ===================================

		// ============================ESM_PRI_2041_13_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityHistoryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteHistoryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateHistoryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkRateHistoryFontStyleForAddOnTariff(e);
			} else {
				eventResponse = initRateComboData(e);
			}
		}
		// ============================ESM_PRI_2041_13_End====================================

		// ============================ESM_PRI_2041_12_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeHistoryListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkHistoryArbitraryFontStyleForAddOnTariff(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2041_12_End=======================================
		
		// ============================ESM_PRI_2045_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//Retroactvie RFA 사유 코드 리스트 조회
				eventResponse = searchRetroactiveRFANote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				//Retroactvie RFA 사유 코드 지정 후 저장-merge문사용
				eventResponse = manageRetroactiveRFANote(e);
			}
		}
		// ============================ESM_PRI_2045_End=======================================		
		
		
		// Master RFA Start
		// ============================ESM_PRI_2203_Start====================================
		// Master RFA Creation & Amendment
		else if (e.getEventName().equalsIgnoreCase("EsmPri2203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalMstMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRouteSummaryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMstRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalScopeAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchProposalAcceptCheckMst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
				eventResponse = searchApprovalCancelCheckChildren(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRequestTermsCheckMst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchProposalScopeStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchProposalDeleteCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCheckDmdtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchCheckDurationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchProposalMainSaleLeadFirstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchProposalMainSaleLeadList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchApprovalCancelCheckMst(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
//				eventResponse = searchRateCmdtRoutStyle(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
//				eventResponse = searchProposalMainStatus(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
//				eventResponse = searchProposalRequestCancelCheck(e);
			}  // Save - MULTI01
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMstProposal(e);
			}  // Save - Route&Rate&Conversion MULTI02
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageMstRate(e);
			}  // Request - MULTI03
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = requestProposalMst(e);
			}  // Approve - MULTI04
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = approveProposalMst(e);
			}  // Cancle - MULTI05
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelProposalMst(e);
			}  // Accept All - MULTI06
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = acceptAllMstRate(e);
			}  // Accept Cancel all - MULTI07
			else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = cancelAllMstRate(e);
			}  // Rate Accept
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateMst(e);
			}  // Rate Accept Cancel
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateMst(e);
			}  // Conversion Accept
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = acceptRateCommodityRnoteMst(e);
			}  // Conversion Accept Cancel
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = cancelRateCommodityRnoteMst(e);
			}  // Route Accept
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
				eventResponse = acceptRateRoutePntViaMst(e);
			}  // Route Accept Cancel
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
				eventResponse = cancelRateRoutePntViaMst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchProposalRequestIhcRateCheckMst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchProposalRequestPortCyCheckMst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = checkRfaContractTpActCust(e);
				//Retroactive RFA 대상 여부를 확인
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchRetroactiveExistCheck(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				// M/B 활성화 여부를 위해 calcutae 하지 않는 scope를 조회
				eventResponse = searchMatchBackCheckCalculate(e);
			} else {
				eventResponse = initMasterMainComboData(e);
			}
		
		}
		
		// ============================ESM_PRI_2203_End====================================
		
		// ============================ESM_PRI_2233_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2233Event")) {
			// ================== ESM_PRI_2233 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMasterGRICalculationHeaderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMasterGRICalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMasterGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = applyMasterGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelMasterGRICalculation(e);
			}
		}
		// ================== ESM_PRI_2233 END ==================
		
		
		// ============================ESM_PRI_2244_Start=======================================	
		else if (e.getEventName().equalsIgnoreCase("EsmPri2244Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//Rfa Copy 조회
				eventResponse = rfaProposalCreationCopy(e);
			} // Copy to Master RFA 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyProposaltoMst(e);
			} // Copy to original RFA
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = copyProposaltoMst(e);
			} else{
				/*ComboData 입력*/
				eventResponse = initMasterMainComboData(e);
			}
		}
		// ============================ESM_PRI_2244_End====================================


		// ================== ESM_PRI_2208 START ==================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2208Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkMstRateExcelHorizontal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadMstRateExcelHorizontal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadMstRateExcelHorizontalOnline(e);
			} else {
				eventResponse = initMstRateExcelHorizontal(e);
			}
		}
		// ================== ESM_PRI_2208 END ==================
		
		
		// ============================ESM_PRI_2017_Start=======================================	
		else if (e.getEventName().equalsIgnoreCase("EsmPri2017Event")) { // Basic RFA Auto Amend (CHM-201642287)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Basic이 가지고 있는 Route 조회
				eventResponse = searchBasicRFARouteInfo(e);
			} // Amend Basic RFA 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = amendProposalBasic(e);
			} else{
				/*ComboData 입력*/
				eventResponse = initMasterMainComboData(e);
			}
		}
		// ============================ESM_PRI_2017_End====================================
		
		
		return eventResponse;

	}

	// /////////////////////////////// 박성수 수정 시작 ///////////////////////////////////
	
	/**
	 * ESM_PRI_2003_07 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initRateComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();

			List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
			ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());

			ArrayList<CodeInfo> termOrgCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02070", 0);
			ArrayList<CodeInfo> termDestCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02071", 0);
			ArrayList<CodeInfo> transModeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);

			eventResponse.setCustomData("ratUtCdList", ratUtCdList);
			eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
			eventResponse.setCustomData("currCdList", currCdList);
			eventResponse.setCustomData("termOrgCdList", termOrgCdList);
			eventResponse.setCustomData("termDestCdList", termDestCdList);
			eventResponse.setCustomData("transModeCdList", transModeCdList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Open<br>
	 * Rate의 Commodity Group을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriRpScpRtCmdtHdrVO());
			String maxBletDpSeq = command.getMaxOldBulletDispSeq(event.getPriRpScpRtCmdtHdrVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("max_blet_dp_seq", maxBletDpSeq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_05 : Open<br>
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204105Event event = (EsmPri204105Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityHistoryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_07 : Open<br>
	 * Rate Inquiry - Commodity Group을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201907Event event = (EsmPri201907Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityInquiryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Sheet1.Select<br>
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_05 : Sheet1.Select<br>
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204105Event event = (EsmPri204105Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteHistoryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_07 : Sheet1.Select<br>
	 * Rate Inquiry - Route 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201907Event event = (EsmPri201907Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrInquiryListVO> vos = command.searchRateRouteInquiryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Sheet2.Select<br>
	 * Rate 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO(), false);
			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
			eventResponse.setRsVoList(vo.getRsltFicRateByRouteVO().get("X"));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_05 : Sheet2.Select<br>
	 * Rate History - Rate 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204105Event event = (EsmPri204105Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO(), false);

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_07 : Sheet2.Select<br>
	 * Rate Inquiry - Rate 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201907Event event = (EsmPri201907Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateInquiryList(event.getPriRpScpRtVO());

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Down Excel<br>
	 * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			if ("A".equals(event.getFicRtTpCd())) {
				List<RsltRtListVerticalExcelForAeeAewVO> vos = command.searchRateListVerticalExcelForAeeAew(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			} else {
				List<RsltRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Down Excel<br>
	 * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			if ("A".equals(event.getFicRtTpCd())) {
				List<RsltRtListHorizontalExcelForAeeAewVO> vos = command.searchRateListHorizontalExcelForAeeAew(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			} else {
				List<RsltRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : OnSaveEnd<br>
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmdtRoutStyle(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtCmdtRoutListVO vo = command.searchRateCmdtRoutStyle(event.getPriRpScpRtCmdtHdrVO(), event.getPriRpScpRtCmdtRoutVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutHdrListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Guideline Copy<br>
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGlineCopyGroupCodeExist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltCdListVO vo = command.checkGlineCopyGroupCodeExist(event.getRfaGlineCopyVO());
			List<RsltCdListVO> vos = new ArrayList<RsltCdListVO>();
			vos.add(vo);
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Sheet1.Save<br>
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeCommodity(event.getRfaRtPropCmdtVO(), account);
			command.manageRateCommodity(event.getRfaRtPropCmdtVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
			scpMnVO.setPropNo(event.getPropNo());
			scpMnVO.setAmdtSeq(event.getAmdtSeq());
			scpMnVO.setSvcScpCd(event.getSvcScpCd());
			cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
			cmdMain.updatePrsMBFlgOnSaveRt(scpMnVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Sheet3.Save<br>
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeRoute(event.getRfaRtPropRtVO(), account);
			command.manageRate(event.getRfaRtPropRtVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
			scpMnVO.setPropNo(event.getPropNo());
			scpMnVO.setAmdtSeq(event.getAmdtSeq());
			scpMnVO.setSvcScpCd(event.getSvcScpCd());
			cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
			cmdMain.updatePrsMBFlgOnSaveRt(scpMnVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Accept<br>
	 * Rate 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Accept Cancel<br>
	 * Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2034 : Open<br>
	 * 중복된 Rate 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCheckDuplicate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2034Event event = (EsmPri2034Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtCheckDuplicateVO> vos = command.searchRateCheckDuplicate(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2036 : Open<br>
	 * Summary 화면의 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllScopeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2036Event event = (EsmPri2036Event) e;
		PriRpScpRtCmdtHdrVO vo = event.getPriRpScpRtCmdtHdrVO();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC arbitraryCommand = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAGroupCommodityProposalBC cmdtCommand = new RFAGroupCommodityProposalBCImpl();
		RFAGroupLocationProposalBC locationCommand = new RFAGroupLocationProposalBCImpl();
		RFANoteProposalBC noteCommand = new RFANoteProposalBCImpl();
		PRICommonBC comCmd = new PRICommonBCImpl();
		
		try {
			
			// Rate
			List<RsltAllRtListVO> vos = new ArrayList<RsltAllRtListVO>();
			
			if(vo != null && vo.getSvcScpCd() != null && !vo.getSvcScpCd().equals("")) {
				vos = command.searchAllRateList(vo);
			} else {
				RsltCdListVO commVo = new RsltCdListVO();
				commVo.setEtc1(vo.getPropNo());
				commVo.setEtc2(vo.getAmdtSeq());
				List<RsltCdListVO> list = comCmd.searchRpScpServiceScopeCodeList(commVo);
				
				PriRpScpRtCmdtHdrVO voCopy = new PriRpScpRtCmdtHdrVO(); 
				ObjectCloner.build(vo, voCopy);
				
				// All Scope
				for(int i=1; i<list.size(); i++) {
					voCopy.setSvcScpCd(list.get(i).getCd());
					vos.addAll(command.searchAllRateList(voCopy));
				}
			}
			eventResponse.setRsVoList(vos);
			
			// Arbitrary
			List<RsltArbChgListVO> arbiList = arbitraryCommand.searchAllArbitraryList(vo);
			eventResponse.setRsVoList(arbiList);
			
			// Special Notes
			List<RsltNoteCtntListVO> scpList = noteCommand.searchAllSpecialNoteContentList(vo);
			eventResponse.setRsVoList(scpList);
			
			// Location Group
			List<RsltGrpLocDtlListVO> locList = locationCommand.searchAllGroupLocationList(vo);
			eventResponse.setRsVoList(locList);
			
			// Commodity Group
			List<RsltGrpCmdtDtlListVO> cmdtList = cmdtCommand.searchAllGroupCommodityList(vo);
			eventResponse.setRsVoList(cmdtList);
						
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2136 : Open<br>
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllRateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2036Event event = (EsmPri2036Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltAllRtListVO> vos = command.searchAllSpotRateList(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2136 : Accept<br>
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2036Event event = (EsmPri2036Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();

			command.acceptAllRate(event.getPriRpScpRtVO(), hdrVO.getFicRtTpCd(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVO().getSvcScpCd());
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73"); // ihc rate
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2036 : Approve<br>
	 * Summary 의 모든 Scope 항목을 Accept 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllScopeTerms(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2036Event event = (EsmPri2036Event) e;
		RfaSummryAcceptAllVO sumVo = event.getRfaSummryAcceptAllVO();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		RFANoteProposalBC noteCommand = new RFANoteProposalBCImpl();
		RFAGroupLocationProposalBC locCommand = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC cmdtCommand = new RFAGroupCommodityProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC arbitraryCommand = new RFATransportationAdditionalChargeProposalBCImpl();
		
		try {
			begin();
			
			// Rate CY & IHC
			PriRpScpRtVO[] scpRtVos =     sumVo.getPriRpScpRtVOS();
			PriRpScpRtCmdtHdrVO[] hdrVos = sumVo.getPriRpScpRtCmdtHdrVOS();
			String svcScpCd = ""; 
			
			if(scpRtVos != null && scpRtVos.length != 0) {
				String ficRtTpCd = "";
				
				for(int i = 0; i < scpRtVos.length; i++) {
					
					// Service Scope 마다 한번만 실행
					if(!svcScpCd.equals(scpRtVos[i].getSvcScpCd()) || !ficRtTpCd.equals(hdrVos[i].getFicRtTpCd())) {
						svcScpCd = scpRtVos[i].getSvcScpCd();
						ficRtTpCd = hdrVos[i].getFicRtTpCd();
//						log.debug("<<<<<<<<<<<<<<< Rate <<<<<<<<<<<<<<< start" + i );
						command.acceptAllRate(scpRtVos[i], hdrVos[i].getFicRtTpCd(), account);
						
						PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
						
						smryVO.setPropNo(scpRtVos[i].getPropNo());
						smryVO.setAmdtSeq(scpRtVos[i].getAmdtSeq());
						smryVO.setSvcScpCd(scpRtVos[i].getSvcScpCd());
						
						if ("A".equals(hdrVos[i].getFicRtTpCd())) {
							smryVO.setPropScpTermTpCd("73"); // ihc rate
						} else {
							smryVO.setPropScpTermTpCd("71");
						}
						
						cmdMain.manageScopeAmendmentSummary(smryVO, account);
					}
				}
			}
			
			// Special Note
			PriRpScpNoteCtntVO[] noteVos = sumVo.getPriRpScpNoteCtntVOS();
			
			if(noteVos != null && noteVos.length != 0) {
				svcScpCd = "";
				for(int i = 0; i < noteVos.length; i++) {
					// Service Scope 마다 한번만 실행
					if(!svcScpCd.equals(noteVos[i].getSvcScpCd())) {
						svcScpCd = noteVos[i].getSvcScpCd();
						
//						log.debug("<<<<<<<<<<<<<<< Special Note <<<<<<<<<<<<<<< start " + i);
						int result = noteCommand.acceptAllNote(noteVos[i], account);
						
						// ////////////////////////////////////////////////////
						// Amendment Summary Update
						PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
						smryVO.setPropNo(noteVos[i].getPropNo());
						smryVO.setAmdtSeq(noteVos[i].getAmdtSeq());
						smryVO.setPropScpTermTpCd("32");
						smryVO.setSvcScpCd(noteVos[i].getSvcScpCd());
						cmdMain.manageScopeAmendmentSummary(smryVO, account);
						// /////////////////////////////////////////////////////
						
						if (result > 0) {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
						} else {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00301", new String[] {}).getUserMessage());
						}
					}
				}
			}
			
    		// Arbitrary Origin & Dest
			PriRpScpTrspAddChgVO[] arbitraryVos = sumVo.getPriRpScpTrspAddChgVOS();
			
			if(arbitraryVos != null && arbitraryVos.length != 0) {
				arbitraryCommand.acceptAllArbitraryCharge(arbitraryVos, account);
				
				String svcScopeCd = "";
				String orgDestTpCd = "";
				
				for(int i=0; i<arbitraryVos.length; i++) {
					
					if(!orgDestTpCd.equals(arbitraryVos[i].getOrgDestTpCd()) || !svcScopeCd.equals(arbitraryVos[i].getSvcScpCd())) {
						// ////////////////////////////////////////////////////
						// Amendment Summary Update
						PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
						priRpScpAmdtSmryVO.setPropNo(arbitraryVos[i].getPropNo());
						priRpScpAmdtSmryVO.setAmdtSeq(arbitraryVos[i].getAmdtSeq());
						priRpScpAmdtSmryVO.setSvcScpCd(arbitraryVos[i].getSvcScpCd());
						if("O".equals(arbitraryVos[i].getOrgDestTpCd())) {
							priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
						} else {
							priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
						}
						cmdMain.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
						// ////////////////////////////////////////////////////
						orgDestTpCd = arbitraryVos[i].getOrgDestTpCd();
						svcScopeCd = arbitraryVos[i].getSvcScpCd();
					}
				}
			}
			
    		// Location Group
			PriRpScpGrpLocDtlVO[] locVos = sumVo.getPriRpScpGrpLocDtlVOS();
			
			if(locVos != null && locVos.length != 0) {
				svcScpCd = "";
				// svc_scp_cd 만큼만 돌리면 된다.
				for(int i = 0; i < locVos.length; i++) {
					
					if(!svcScpCd.equals(locVos[i].getSvcScpCd() )) {
						
						svcScpCd = locVos[i].getSvcScpCd();
						
//						log.debug("<<<<<<<<<<<<<<<Location Group  <<<<<<<<<<<<<<< start " + i);
						String result = locCommand.acceptAllGroupLocation(locVos[i], account);
						
						// ////////////////////////////////////////////////////
						// Amendment Summary Update
						PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
						smryVO.setPropNo(locVos[i].getPropNo());
						smryVO.setAmdtSeq(locVos[i].getAmdtSeq());
						smryVO.setPropScpTermTpCd("13");
						smryVO.setSvcScpCd(locVos[i].getSvcScpCd());
						cmdMain.manageScopeAmendmentSummary(smryVO, account);
						// /////////////////////////////////////////////////////
						
						if (result.equals("OK")) {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
						} else {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
						}
					}
				}
			}
			
    		// Commodity Group
			PriRpScpGrpCmdtDtlVO[] cmdtVos = sumVo.getPriRpScpGrpCmdtDtlVOS();
			
			if(cmdtVos != null && cmdtVos.length != 0) {
				svcScpCd = "";
				
				for(int i = 0; i < cmdtVos.length; i++) {
					if(!svcScpCd.equals(cmdtVos[i].getSvcScpCd())) {
						svcScpCd = cmdtVos[i].getSvcScpCd();
						
//						log.debug("<<<<<<<<<<<<<<< Commodity Group  <<<<<<<<<<<<<<< start " + i);
						String result = cmdtCommand.acceptAllGroupCommodity(cmdtVos[i], account);
						
						// ////////////////////////////////////////////////////
						// Amendment Summary Update
						PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
						smryVO.setPropNo(cmdtVos[i].getPropNo());
						smryVO.setAmdtSeq(cmdtVos[i].getAmdtSeq());
						smryVO.setPropScpTermTpCd("14");
						smryVO.setSvcScpCd(cmdtVos[i].getSvcScpCd());
						cmdMain.manageScopeAmendmentSummary(smryVO, account);
						// /////////////////////////////////////////////////////
						
						if (result.equals("OK")) {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
						} else {
							eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
						}
					}
				}
			}
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2036 : Open<br>
	 * Summary 화면의 기본 Code List를 초기화한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initSummaryDataList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PRICommonBC command = new PRICommonBCImpl();
		
		CodeUtil cdUtil = CodeUtil.getInstance();
		
		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;
		
		try {
			// Trans Mode
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			eventResponse.setCustomData("prcTrspModCd", codeInfos);
			
			// Rating Unit Code
			customData = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);
			
			// Currency Code
			customData = command.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);
			
			// Cargo Type Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			eventResponse.setCustomData("prcCgoTpCd", codeInfos);
			
			// Source Info Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD02198", 0);
			eventResponse.setCustomData("srcInfoCd", codeInfos);
			
			// Proposal Status Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("prcProgStsCd", codeInfos);
			
			// Origin & Dest Type Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD00139", 0);
			eventResponse.setCustomData("orgDestTpCd", codeInfos);			
			
			// Commodity Type Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01703", 0);
			eventResponse.setCustomData("prcCmdtTpCd", codeInfos);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Accept Cancel<br>
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			command.cancelAllRate(event.getPriRpScpRtVO(), hdrVO.getFicRtTpCd(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVO().getSvcScpCd());
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73"); // ihc rate
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_07 : Guideline Copy<br>
	 * Guideline의 데이터를 복사해온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.copyGuidelineRate(event.getRfaGlineCopyVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getRfaGlineCopyVO().getPropNo());
			smryVO.setAmdtSeq(event.getRfaGlineCopyVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getRfaGlineCopyVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2023 : Accept<br>
	 * Commodity 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateCommodityDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2023Event event = (EsmPri2023Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCommodityDetail(event.getPriRpScpRtCmdtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2023 : Accept Cancel<br>
	 * Commodity 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateCommodityDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2023Event event = (EsmPri2023Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCommodityDetail(event.getPriRpScpRtCmdtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2025 : Accept<br>
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2025Event event = (EsmPri2025Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2025 : Accept Cancel<br>
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2025Event event = (EsmPri2025Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2028 : Accept<br>
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptFicRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2028Event event = (EsmPri2028Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		String smrtString = "71";
		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smrtString = "73"; // ihc rate
			}
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptAutoRateRouteViaDetail(viaVO, account);
				}

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutDestPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutDestPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutDestPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptAutoRateRouteViaDetail(viaVO, account);
				}
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2028 : Accept Cancel<br>
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelFicRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2028Event event = (EsmPri2028Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		String smrtString = "71";
		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smrtString = "73"; // ihc rate
			}
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptCancelAutoRateRouteViaDetail(viaVO, account);
				}
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutDestPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutDestPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutDestPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptCancelAutoRateRouteViaDetail(viaVO, account);
				}
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2065 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVertical(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2065Event event = (EsmPri2065Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2065 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVertical(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2065Event event = (EsmPri2065Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadRateExcelVertical(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2065 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalOnline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2065Event event = (EsmPri2065Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();

			command.uploadRateExcelVerticalOnline(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			/**
			 * 2012.06.15일 추가
			 */
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2065 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVertical(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCdList", currCdList);

			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2060 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2060Event event = (EsmPri2060Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS());

			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2060 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2060Event event = (EsmPri2060Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2060 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalOnline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2060Event event = (EsmPri2060Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();

			command.uploadRateExcelHorizontalOnline(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2060 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontal(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2033 : Open<br>
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2087 : Open<br>
	 * GRI Calculation History - Header를 조회합니다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationHeaderHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2087Event event = (EsmPri2087Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2033 : Sheet1.Select<br>
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2087 : Open<br>
	 * GRI Calculation History - Rate 및 기타정보를 조회합니다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2087Event event = (EsmPri2087Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2033 : Save<br>
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();

		try {
			begin();
			command.manageGRICalculation(event.getRfaGriCalcVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2033 : Apply<br>
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.applyGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2033 : Apply Cancel<br>
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2082 : Accept<br>
	 * Actual Customer 데이터를 Accept합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptActualCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2082Event event = (EsmPri2082Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptActualCustomer(event.getPriRpScpRtActCustVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtActCustVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtActCustVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtActCustVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2082 : Accept Cancel<br>
	 * Actual Customer 데이터를 Accept Cancel합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelActualCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2082Event event = (EsmPri2082Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelActualCustomer(event.getPriRpScpRtActCustVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtActCustVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtActCustVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtActCustVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : Accept<br>
	 * Commodity Note 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateCnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCnote(event.getPriRpScpRtCnoteVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCnoteVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCnoteVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCnoteVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}

			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : Accept Cancel<br>
	 * Commodity Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateCnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCnote(event.getPriRpScpRtCnoteVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCnoteVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCnoteVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCnoteVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}

			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : Accept<br>
	 * Route Note 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateCommodityRnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtRnoteVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtRnoteVOS()[0].getSvcScpCd());

			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : Accept Cancel<br>
	 * Route Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateCommodityRnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtRnoteVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtRnoteVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// /////////////////////////////// 박성수 수정 종료 ///////////////////////////////////

	/**
	 * ESM_PRI_2003 : Retrieve<br>
	 * Proposal Main의 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			RsltPropListVO vo = command.searchProposalMain(event.getPriRpHdrVO(), account);		
			eventResponse.setRsVoList(vo.getRsltPropMnVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpListVOs());

			if (vo.getRsltPropMnVOs() != null && vo.getRsltPropMnVOs().size() > 0) {
				PRICommonBC command1 = new PRICommonBCImpl();
				RsltCdListVO cdVo = new RsltCdListVO();
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getRespbSlsOfcCd());
				cdVo.setEtc2(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				cdVo.setEtc3(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				List<RsltCdListVO> list = command1.searchSalesRepListByCustOnly(cdVo);
				eventResponse.setRsVoList(list);
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getPropOfcCd());
				List<RsltCdListVO> list1 = command1.searchSalesRepByOfficeList(cdVo);
				eventResponse.setRsVoList(list1);

				SchSaleLeadRfaVO slsVo = new SchSaleLeadRfaVO();
				slsVo.setCustCntCd(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				slsVo.setCustSeq(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				slsVo.setRespbSrepCd(vo.getRsltPropMnVOs().get(0).getRespbSrepCd());
				slsVo.setPropNo(vo.getRsltPropMnVOs().get(0).getPropNo());
				slsVo.setAmdtSeq(vo.getRsltPropMnVOs().get(0).getAmdtSeq());
				slsVo.setFirstSw("N");
				List<RsltPriCrmSlLdVO> list2 = command.searchProposalMainSaleLeadList(slsVo);
				eventResponse.setRsVoList(list2);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003 : Retrieve<br>
	 * Proposal Main의 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainSpot(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			RsltPropListVO vo = command.searchProposalMainSpot(event.getPriRpHdrVO(), account);		
			eventResponse.setRsVoList(vo.getRsltPropMnVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpListVOs());

			if (vo.getRsltPropMnVOs() != null && vo.getRsltPropMnVOs().size() > 0) {
				PRICommonBC command1 = new PRICommonBCImpl();
				RsltCdListVO cdVo = new RsltCdListVO();
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getRespbSlsOfcCd());
				cdVo.setEtc2(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				cdVo.setEtc3(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				List<RsltCdListVO> list = command1.searchSalesRepListByCustOnly(cdVo);
				eventResponse.setRsVoList(list);
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getPropOfcCd());
				List<RsltCdListVO> list1 = command1.searchSalesRepByOfficeList(cdVo);
				eventResponse.setRsVoList(list1);

				SchSaleLeadRfaVO slsVo = new SchSaleLeadRfaVO();
				slsVo.setCustCntCd(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				slsVo.setCustSeq(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				slsVo.setRespbSrepCd(vo.getRsltPropMnVOs().get(0).getRespbSrepCd());
				slsVo.setPropNo(vo.getRsltPropMnVOs().get(0).getPropNo());
				slsVo.setAmdtSeq(vo.getRsltPropMnVOs().get(0).getAmdtSeq());
				slsVo.setFirstSw("N");
				List<RsltPriCrmSlLdVO> list2 = command.searchProposalMainSaleLeadList(slsVo);
				eventResponse.setRsVoList(list2);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : btn_ctrt_cust<br>
	 * Customer 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCustomerInfo(Event e) throws EventException {
		PriSpCtrtPtyVO paramVo = new PriSpCtrtPtyVO();
		if (e.getEventName().equalsIgnoreCase("EsmPri2003Event")) {
			EsmPri2003Event event = (EsmPri2003Event) e;
			paramVo = event.getPriSpCtrtPtyVO();
		}

		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfo(paramVo);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : SAVE<br>
	 * RFA PROPOSAL,SCOPE을 추가,수정,삭제합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAProposalDEMDETBC command4 = new RFAProposalDEMDETBCImpl();
		CRMSalesLeadBC command5 = new CRMSalesLeadBCImpl();
		RFANoteConversionProposalBC command6 = new RFANoteConversionProposalBCImpl();
		RFARateProposalBC command7 = new RFARateProposalBCImpl();
		String propNo = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropMnVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
			}

			// EDI WEB & CRM INTERFACE 위한 조건 조회
			int cnt = command1.searchCheckOfcSrepDiffList(priRpMnVO);

			// sales lead
			String saleLeadOri = event.getSaleLeadOri();
			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
			ObjectCloner.build(priRpMnVO, vo);
			if (!vo.getSlsLdNo().equals(saleLeadOri)) {
				command5.manageRFACRMSalesLeadNo(vo, account);
			}

			// note conv
			PriRpScpMnVO[] scpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
			command6.manageNoteConversionEffectiveDate(scpVo, account);
			command6.manageNoteConversionExpireDate(scpVo, account);

			command2.manageProposalScopeDurationRemove(event.getRfaPropMnVO(), account);
			// Surcharge
			command7.manageProposalScopeSurchargeRemove(event.getRfaPropMnVO());
			command1.manageProposalRemove(event.getRfaPropMnVO(), account);

			propNo = command1.manageProposal(event.getRfaPropMnVO(), account);
			command2.manageProposal(event.getRfaPropMnVO(), account);
			command4.manageProposal(event.getRfaPropMnVO(), account);

			// SUMMARY TABLE UPDATE
			if (priRpMnVO.getIbflag().equals("I")) {
				PriRpAmdtSmryVO smryVo = new PriRpAmdtSmryVO();
				smryVo.setPropNo(propNo);
				smryVo.setAmdtSeq(priRpMnVO.getAmdtSeq());
				smryVo.setPropTermTpCd("01");
				command1.manageProposalAmendmentSummary(smryVo, account);
				smryVo.setPropTermTpCd("08");
				command1.manageProposalAmendmentSummary(smryVo, account);
			}
			PriRpScpAmdtSmryVO scpSmryVO = new PriRpScpAmdtSmryVO();
			scpSmryVO.setPropNo(priRpMnVO.getPropNo());
			scpSmryVO.setAmdtSeq(priRpMnVO.getAmdtSeq());
			for (int i = 0; i < scpVo.length; i++) {
				if (scpVo[i].getIbflag().equals("I")) {
					scpSmryVO.setSvcScpCd(scpVo[i].getSvcScpCd());
					scpSmryVO.setPropScpTermTpCd("11");
					command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
				}
			}

			if (cnt > 0) {
				// INTERFACE : EDI WEB 으로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command1.transferRfaGeneralInfo(genInfVO, account);

				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command1.transferRfaSalesLeadContractInfo(priRpMnVO, account);
			}
			commit();
			
			if(Boolean.parseBoolean(event.getCpPriMnFlag())) {
				 managePriRpScpTrspAddChgCopy(e);
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		eventResponse.setETCData("prop_no", propNo);
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2103 : SAVE<br>
	 * RFA PROPOSAL,SCOPE을 추가,수정,삭제합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalSpot(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
//		RFAProposalDEMDETBC command4 = new RFAProposalDEMDETBCImpl(); //DEMDET 기능 불필요
		CRMSalesLeadBC command5 = new CRMSalesLeadBCImpl();
		RFANoteConversionProposalBC command6 = new RFANoteConversionProposalBCImpl();
		RFARateProposalBC command7 = new RFARateProposalBCImpl();
		String propNo = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropMnVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
			}

			// EDI WEB & CRM INTERFACE 위한 조건 조회
			int cnt = command1.searchCheckOfcSrepDiffList(priRpMnVO);

			// sales lead
			String saleLeadOri = event.getSaleLeadOri();
			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
			ObjectCloner.build(priRpMnVO, vo);
			if (!vo.getSlsLdNo().equals(saleLeadOri)) {
				command5.manageRFACRMSalesLeadNo(vo, account);
			}

			// note conv
			PriRpScpMnVO[] scpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
			command6.manageNoteConversionEffectiveDate(scpVo, account);
			command6.manageNoteConversionExpireDate(scpVo, account);

			command2.manageProposalScopeDurationRemove(event.getRfaPropMnVO(), account);
			// Surcharge
			command7.manageProposalScopeSurchargeRemove(event.getRfaPropMnVO());
			command1.manageProposalRemove(event.getRfaPropMnVO(), account);

			propNo = command1.manageProposal(event.getRfaPropMnVO(), account);
			command2.manageProposal(event.getRfaPropMnVO(), account);
			
			//DEM/DET- RFAProposalDEMDETBC
			//command4.manageProposal(event.getRfaPropMnVO(), account);

			// SUMMARY TABLE UPDATE
			if (priRpMnVO.getIbflag().equals("I")) {
				PriRpAmdtSmryVO smryVo = new PriRpAmdtSmryVO();
				smryVo.setPropNo(propNo);
				smryVo.setAmdtSeq(priRpMnVO.getAmdtSeq());
				smryVo.setPropTermTpCd("01");
				command1.manageProposalAmendmentSummary(smryVo, account);
				smryVo.setPropTermTpCd("08");
				command1.manageProposalAmendmentSummary(smryVo, account);
			}
			PriRpScpAmdtSmryVO scpSmryVO = new PriRpScpAmdtSmryVO();
			scpSmryVO.setPropNo(priRpMnVO.getPropNo());
			scpSmryVO.setAmdtSeq(priRpMnVO.getAmdtSeq());
			for (int i = 0; i < scpVo.length; i++) {
				if (scpVo[i].getIbflag().equals("I")) {
					scpSmryVO.setSvcScpCd(scpVo[i].getSvcScpCd());
					scpSmryVO.setPropScpTermTpCd("11");
					command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
				}
			}

			if (cnt > 0) {
				// INTERFACE : EDI WEB 으로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command1.transferRfaGeneralInfo(genInfVO, account);

				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command1.transferRfaSalesLeadContractInfo(priRpMnVO, account);
			}
			commit();
			
			if(Boolean.parseBoolean(event.getCpPriMnFlag())) {
				 managePriRpScpTrspAddChgCopy(e);
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		eventResponse.setETCData("prop_no", propNo);
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : OPEN <br>
	 * SPECIAL NOTE 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonSpecialNoteList(Event e) throws EventException {
		// EsmPri200301Event event = (EsmPri200301Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_PROG_STS_CD", list);

			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

			// CAL.
			vo.setCd("CD01724");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_OP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// US SVC MODE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			list = command.searchAllPerCodeList(vo);
			eventResponse.setCustomData("BKG_RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			/*
			 * //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별) //추후에 변경할것. vo.setEtc1("R"); // 계약 유형: S->S/C, R->RFA, T->TRI vo.setEtc2("P"); // CONVERSION TYPE CODE list
			 * = command.searchNoteConvRuleMapgList(vo); eventResponse.setCustomData("RULE_CD", list);
			 * 
			 * // Scope Charge Code List vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd()); list = command.searchScopeChargeCodeList(vo);
			 * eventResponse.setCustomData("CHARGE_CD", list);
			 */
			
			// S/I
			vo.setCd("CD02582");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : RETRIEVE<br>
	 * SPECIAL NOTE를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteListVO> list = command.searchNoteList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SHEET1.SELECTROW<br>
	 * SPECIAL NOTE의 CONTENT를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();

		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentList(event.getPriRpScpNoteCtntVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * SPECIAL NOTE의 CONTENT에서 SEQ-1 에 대한 DP_SEQ의 MAX값을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteContentMaxDpSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();

		try {
			String maxDpSeq2 = command.searchNoteContentMaxDpSeq(event.getPriRpScpNoteCtntVO());
			eventResponse.setETCData("CONTENT_MAX_DP_SEQ", maxDpSeq2);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * SPECIAL NOTE의 TITLE에서 SEQ-1 에 대한 DP_SEQ의 MAX값을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteMaxDpSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();

		try {
			String maxDpSeq1 = command.searchNoteMaxDpSeq(event.getPriRpScpNoteCtntVO());
			eventResponse.setETCData("TITLE_MAX_DP_SEQ", maxDpSeq1);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * SPECIAL NOTE를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command1 = new RFANoteProposalBCImpl();
		RFANoteConversionProposalBC command2 = new RFANoteConversionProposalBCImpl();

		try {
			begin();

			command2.manageNoteConversion(event.getNotePropVO(), account);
			command1.manageNote(event.getNotePropVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getNotePropVO().getPriRpScpNoteListVO().getPropNo());
			smryVO.setAmdtSeq(event.getNotePropVO().getPriRpScpNoteListVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32");
			smryVO.setSvcScpCd(event.getNotePropVO().getPriRpScpNoteListVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : ACCEPT<br>
	 * SPECIAL NOTE를 ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			command.acceptNote(event.getPriRpScpNoteCtntVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("32");
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : CANCEL<br>
	 * SPECIAL NOTE를 CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			command.cancelNote(event.getPriRpScpNoteCtntVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("32");
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : ACCEPT ALL<br>
	 * SPECIAL NOTE를 ALL ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllNote(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			int result = command.acceptAllNote(event.getPriRpScpNoteCtntVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32");
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00301", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : CANCEL<br>
	 * SPECIAL NOTE를 ALL CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllNote(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			int result = command.cancelAllNote(event.getPriRpScpNoteCtntVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32");
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00301", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SHEET2.SELECTROW<br>
	 * SPECIAL NOTE CONVERSION을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionList(Event e) throws EventException {
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : COPY<br>
	 * SPECIAL NOTE CONVERSION을 붙여넣기합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionListCopy(Event e) throws EventException {
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : COPY<br>
	 * SPECIAL NOTE CONVERSION을 복사합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2084,2085, 2072, 2073 : OPEN <br>
	 * 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonRateNoteList(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// BAR TYPE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			
			// S/I
			vo.setCd("CD02582");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : OPEN <br>
	 * RateCnote 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonRateCnoteList(Event e) throws EventException {
		EsmPri2022Event event = (EsmPri2022Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		RFARateProposalBC command2 = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

			// CAL.
			vo.setCd("CD01724");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_OP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// BAR TYPE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			list = command.searchAllPerCodeList(vo);
			eventResponse.setCustomData("BKG_RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
			// 추후에 변경할것.
			vo.setEtc1("R"); // 계약 유형: S->S/C, R->RFA, T->TRI
			vo.setEtc2("C"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);

			// Scope Charge Code List
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());
			list = command.searchScopeChargeCodeList(vo);
			eventResponse.setCustomData("CHARGE_CD", list);

			// 이전 SEQ의 EXP_DT
			PriRpScpMnVO priRpScpMnVO = new PriRpScpMnVO();
			ObjectCloner.build(event.getPriRfaNoteConvVO(), priRpScpMnVO);
			String bExpDt = command2.searchBeforeExpireDate(priRpScpMnVO);
			eventResponse.setCustomData("BEFORE_EXP_DT", bExpDt);

			// S/I
			vo.setCd("CD02582");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : COPY<br>
	 * RateCnote CONVERSION을 붙여넣기합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCnoteConversionListCopy(Event e) throws EventException {
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : COPY<br>
	 * RateCnote NOTE CONVERSION을 복사합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCnoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : OPEN <br>
	 * RateCommodityRnote 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCommodityRnoteList(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		RFARateProposalBC command2 = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

			// CAL.
			vo.setCd("CD01724");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_OP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// BAR TYPE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			list = command.searchAllPerCodeList(vo);
			eventResponse.setCustomData("BKG_RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
			// 추후에 변경할것.
			vo.setEtc1("R"); // 계약 유형: S->S/C, R->RFA, T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);

			// Scope Charge Code List
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());
			list = command.searchScopeChargeCodeList(vo);
			eventResponse.setCustomData("CHARGE_CD", list);

			// 이전 SEQ의 EXP_DT
			PriRpScpMnVO priRpScpMnVO = new PriRpScpMnVO();
			ObjectCloner.build(event.getPriRfaNoteConvVO(), priRpScpMnVO);
			String bExpDt = command2.searchBeforeExpireDate(priRpScpMnVO);
			eventResponse.setCustomData("BEFORE_EXP_DT", bExpDt);

			// S/I
			vo.setCd("CD02582");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : SHEET2.SELECTROW<br>
	 * RateCommodityRnote CONVERSION을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRnoteConversionList(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : COPY<br>
	 * RateCommodityRnote CONVERSION을 붙여넣기합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRnoteConversionListCopy(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : COPY<br>
	 * RateCommodityRnote NOTE CONVERSION을 복사합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCommodityRnoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200302 : OPEN <br>
	 * LOCATION GROUP 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonGroupLocationList(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_PROG_STS_CD", list);

			// ORI/DST
			vo.setCd("CD02166");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("ORG_DEST_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : RETRIEVE<br>
	 * LOCATION GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : SHEET1.SELECTROW<br>
	 * LOCATION GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : DELETE1<br>
	 * RATE의 사용여부를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationRateApplyList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationRateApplyList(event.getPriRpScpGrpLocVOS());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : ACCEPT ALL<br>
	 * LOCATION GROUP DETAIL을 ALL ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllGroupLocation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.acceptAllGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("13");
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : CANCEL<br>
	 * LOCATION GROUP DETAIL을 ALL CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.cancelAllGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("13");
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00330", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : ACCEPT<br>
	 * LOCATION GROUP DETAIL을 ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			command.acceptGroupLocation(event.getPriRpScpGrpLocDtlVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("13");
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : CANCEL<br>
	 * LOCATION GROUP DETAIL을 CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGroupLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			command.cancelGroupLocation(event.getPriRpScpGrpLocDtlVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("13");
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : G/L COPY<br>
	 * GUIDELINE의 LOCATION GROUP을 COPY합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			int result = command.copyGuidelineGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("13");
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01017", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01016", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : SAVE<br>
	 * LOCATION GROUP을 SAVE합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			// ORI/DST Validation 체크
			String[] checkVal = command.checkGroupLocationCode(event.getRsltGrpLocDtlListVOs());

			if (checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				// SAVE
				command.manageGroupLocation(event.getGrpLocPropVO(), account);

				// ////////////////////////////////////////////////////
				// Amendment Summary Update
				RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getPropNo());
				smryVO.setAmdtSeq(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getAmdtSeq());
				smryVO.setPropScpTermTpCd("13");
				smryVO.setSvcScpCd(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getSvcScpCd());
				command3.manageScopeAmendmentSummary(smryVO, account);
				// /////////////////////////////////////////////////////

				eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : SAVE<br>
	 * LOCATION GROUP의 ORI/DEST를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOriDestGroupLocationInUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			;
			// ORI/DST Validation 체크
			String[] checkVal = command.checkGroupLocationCode(event.getRsltGrpLocDtlListVOs());

			if (checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				eventResponse.setETCData("ORI_DST_CHECK", "");
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03, 2019_03,2041_03 : OPEN<br>
	 * 화면로딩시 콤보정보를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initAmendSourceStatusCodeList(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			// //////////////////COMMON - START/////////////////////
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_PROG_STS_CD", list);
			// ////////////////////COMMON - END///////////////////////
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : RETRIEVE<br>
	 * COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : SHEET1.SELECTROW<br>
	 * COMMODITY GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : DELETE1<br>
	 * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
	 * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityRateApplyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityRateApplyList(event.getPriRpScpGrpCmdtVOS());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : ACCEPT ALL<br>
	 * COMMODITY GROUP를 ALL ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.acceptAllGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : CANCEL<br>
	 * COMMODITY GROUP를 ALL CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.cancelAllGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00330", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : ACCEPT<br>
	 * COMMODITY GROUP를 ACCEPT합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.acceptGroupCommodity(event.getPriRpScpGrpCmdtDtlVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : CANCEL<br>
	 * COMMODITY GROUP를 CANCEL합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.cancelGroupCommodity(event.getPriRpScpGrpCmdtDtlVOS(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : G/L COPY<br>
	 * GUIDELINE의 COMMODITY GROUP을 COPY합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			int result = command.copyGuidelineGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01017", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01016", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : SAVE<br>
	 * COMMODITY GROUP을 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.manageGroupCommodity(event.getGrpCmdtPropVO(), account);

			// ////////////////////////////////////////////////////
			// Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getPropNo());
			smryVO.setAmdtSeq(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14");
			smryVO.setSvcScpCd(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			// /////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2050 : OPEN <br>
	 * 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonUploadArbitraryChargeProposal(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2050Event event = (EsmPri2050Event) e;

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// TRANS MODE
			vo.setCd("CD01720");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);

			// TERM CODE
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("O")) {
				vo.setCd("CD02070");
			} else {
				vo.setCd("CD02071");
			}
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RCV_DE_TERM_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_CGO_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			// list = command.searchAllPerCodeList(vo);
			list = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// ACTUAL CUSTOMER
			vo.setPropNo(event.getRsltPriRpScpArbKeyVO().getPropNo());
			vo.setAmdtSeq(event.getRsltPriRpScpArbKeyVO().getAmdtSeq());
			vo.setSvcScpCd(event.getRsltPriRpScpArbKeyVO().getSvcScpCd());
			vo.setEtc1("");
			vo.setEtc2("");
			list = command.searchRFAActualCustomerList(vo);
			eventResponse.setCustomData("CUST_DEF_CD", list);

			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_O.xls");
			}
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2050 : SAVE<br>
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2050Event event = (EsmPri2050Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeProposal(event.getPriRpScpTrspAddChgVOs(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOs()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOs()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOs()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			// 저장성공
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2050 : CHECK<br>
	 * 엑셀파일를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2050Event event = (EsmPri2050Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRpScpTrspAddChgVO> list = command.searchCodeCheckResult(event.getRsltPriRpScpTrspAddChgVOs());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6064 : onLoad <BR>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6064Event event = (EsmPri6064Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriPrsCostListVO> list = command1.searchCostDetailList(event.getRsltPriPrsCostListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6064 : onClick(sheet1) <BR>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailInquiryList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailInquiryList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6064Event event = (EsmPri6064Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriPrsCostDetailVO> list = command1.searchCostDetailInquiryList(event.getRsltPriPrsCostDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2055 : onLoad <br>
	 * RFA Route Detail에 해당하는 모든 Origin/Dest의 장비상태 리스트 조회 이벤트 처리 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteMBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2055Event event = (EsmPri2055Event) e;
		
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRouteMBListVO> list = command.searchRateRouteMBList(event.getPriRpScpRtVO(), event.getOrgDestTpCd(), event.getCntrTpszCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2055 : onClick <br>
	 * Origin/Dest 선택 시 장비 타입 사이즈 별 상태 리스트 조회 이벤트 처리 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRatePortMBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2055Event event = (EsmPri2055Event) e;
		
		RFARateProposalBC command = new RFARateProposalBCImpl();
		
		try {
			List<RsltRtRouteMBListVO> list = command.searchRatePortMBList(event.getPriRpScpRtVO(), event.getOrgDestTpCd(), event.getFcntrEccCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2055 : searchEnd <br>
	 * Rate M/B 조회 시 플래그 변경 이벤트 처리 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsMBFlgOnChangeStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2055Event event = (EsmPri2055Event) e;
		
		RFARateProposalBC command = new RFARateProposalBCImpl();
		
		try {
			command.modifyPrsMBFlgOnChangeStatus(event.getPriRpScpRtVO(), account);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6070 : Retrieve , onLoad , onSaveEnd <BR>
	 * PRS- Applicable Route, Surcharge Detail을 조회 실행합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateSurchargeList(Event e) throws EventException {
		EsmPri6070Event event = (EsmPri6070Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = command1.searchSurchargeList(event.getInpPrsSurchargeDetailApplicableRouteVO());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailApplicableRouteVOS());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6070 : Save <BR>
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신실행 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateSurcharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6070Event event = (EsmPri6070Event) e;

		try {
			begin();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.manageRateSurcharge(event.getPriRpScpRtScgVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6073 : Retrieve , onLoad, onSaveEnd <BR>
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeAdjustList(Event e) throws EventException {
		EsmPri6073Event event = (EsmPri6073Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriSurchargeAdjustListVO> list = command1.searchSurchargeAdjustList(event.getRsltPriSurchargeAdjustListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6073 : Save <BR>
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신실행 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6073Event event = (EsmPri6073Event) e;

		try {
			begin();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.manageSurchargeAdjust(event.getPriRpScpScgAdjVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6073 : OK <BR>
	 * PRS- Surcharge Adjust 내용을 바탕으로 Calculate Logic을 수행합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeAdjustCalc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6073Event event = (EsmPri6073Event) e;

		try {
			begin();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.manageSurchargeAdjustCalc(event.getPriRpScpScgAdjVOS()[0], account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6080 : onLoad <BR>
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityAllList(Event e) throws EventException {
		EsmPri6080Event event = (EsmPri6080Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriSurchargeAdjustCommodityVO> list = command1.searchRateCommodityAllList(event.getRsltPriSurchargeAdjustCommodityVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6080 : onLoad, sheet1_onClick <BR>
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupCommodityDetailList(Event e) throws EventException {
		EsmPri6080Event event = (EsmPri6080Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriSurchargeAdjustCommodityDetailVO> list = command1.searchRateGroupCommodityDetailList(event.getRsltPriSurchargeAdjustCommodityDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6083 : onLoad <BR>
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateLocationAllList(Event e) throws EventException {
		EsmPri6083Event event = (EsmPri6083Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriSurchargeAdjustLocationGroupVO> list = command1.searchRateLocationAllList(event.getRsltPriSurchargeAdjustLocationGroupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6083 : onLoad, sheet1_onClick <BR>
	 * SSurcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupLocationDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchGroupCommodityDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6083Event event = (EsmPri6083Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = command1.searchRateGroupLocationDetailList(event.getRsltPriSurchargeAdjustLocationGroupDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6067 : onLoad , Retrieve <BR>
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailByTransModeList(Event e) throws EventException {
		EsmPri6067Event event = (EsmPri6067Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriCostDetailByTransModeListVO> list = command1.searchCostDetailByTransModeList(event.getRsltPriCostDetailByTransModeListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6048 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
	 * CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmViewAllList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchRateCmViewAllList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6048Event event = (EsmPri6048Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriRateCmViewAllVO> list = command1.searchRateCmViewAllList(event.getRsltPriRateCmViewAllVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6048 : Save <BR>
	 * CM/OP View 의 Load 값을 갱신실행 합니다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsPfmc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6048Event event = (EsmPri6048Event) e;
		try {
			begin();
			RFAProposalMainBC mainCommand = new RFAProposalMainBCImpl();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.modifyPrsPfmc(event.getPriRpScpRtCmdtRoutSetVO(), account);
			// 추가 로직수행 MN Table에 summary값 update
			mainCommand.modifyScopeMainSummary(event.getPriRpScpRtCmdtRoutSetVO(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6049 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
	 * RFA Amendment CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmdtRateCmViewAllList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchAmdtRateCmViewAllList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6049Event event = (EsmPri6049Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriAmdCmViewAllVO> list = command1.searchAmdtRateCmViewAllList(event.getRsltPriAmdCmViewAllVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch의 실행 상태를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmdtRateCmpbAndOpbViewAll(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6049Event event = (EsmPri6049Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			RsltPriAmdCmpbOpbViewAllVO rsltPriAmdCmpbOpbViewAllVO = command.searchAmdtRateCmpbAndOpbViewAll(event.getRsltPriAmdCmViewAllVO());
			String prsRmnRespbCmpbAmt = "";
			String prsRmnRespbOpbAmt = "";
			if (rsltPriAmdCmpbOpbViewAllVO != null) {
				prsRmnRespbCmpbAmt = rsltPriAmdCmpbOpbViewAllVO.getPrsRespbCmpbAmt();
				prsRmnRespbOpbAmt = rsltPriAmdCmpbOpbViewAllVO.getPrsRespbOpbAmt();
			}
			eventResponse.setETCData("PRS_RMN_RESPB_CMPB_AMT", prsRmnRespbCmpbAmt);
			eventResponse.setETCData("PRS_RMN_RESPB_OPB_AMT", prsRmnRespbOpbAmt);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6049 : Save <BR>
	 * RFA Amendment CM/OP View 의 Load 값을 갱신실행 합니다.
	 * 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAmdtPrsPfmc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6049Event event = (EsmPri6049Event) e;

		try {
			begin();
			RFAProposalMainBC mainCommand = new RFAProposalMainBCImpl();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.modifyAmdtPrsPfmc(event.getPriRpScpRtCmdtRoutSetVO(), account);
			// 추가 로직수행 MN Table에 summary값 update
			mainCommand.modifyScopeMainSummary(event.getPriRpScpRtCmdtRoutSetVO(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003: Counter Offer<br>
	 * Main의 상태를 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		String propStsCd = "";
		String userMsg = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			command.counterofferProposal(event.getRfaPropProgVO(), account);
			if (mnVo[0] != null)
				propStsCd = mnVo[0].getPropStsCd();

			// C/Offer 시 Scope과 Main의 상태를 returned로 변경한다
			if (mnVo[0] != null && propStsCd.equals("R")) {
				// manageReturnStatus(e);
				int cnt = 0;

				List<RsltReturnVO> list = command.searchProposalReturnedList(mnVo[0]);
				if (list != null && list.size() > 0) {
					cnt++;
				}
				String propNo = mnVo[0].getPropNo();
				String amdtSeq = mnVo[0].getAmdtSeq();
				PriRpMnVO priMn = new PriRpMnVO();
				priMn.setPropNo(propNo);
				priMn.setAmdtSeq(amdtSeq);
				if (cnt > 0) {
					priMn.setPropStsCd("R");
				} else {
					priMn.setPropStsCd("Q");
				}
				command.modifyMainStatus(priMn, account);
				// Rate Calc Flag change
				PriRpScpMnVO scpMn = new PriRpScpMnVO();
				scpMn.setPropNo(propNo);
				scpMn.setAmdtSeq(amdtSeq);
				scpMn.setPrsRtCmpbCalcFlg("N");
				scpMn.setPrsRtMbFlg("N");
				command.manageProposalRateCalcFlag(scpMn, account);
				// PRS_RT_CMPB_CALC_FLG
			}
//			// Request 시 Arbitrary Guide Line을 최신으로 갱신
//			if (mnVo[0] != null && propStsCd.equals("Q")) {
//				managePriRpScpTrspAddChgCopy(e);
//			}
			autoAcceptProposal(e);

			if (propStsCd.equals("Q")) {
				userMsg = "Request";
			} else if (propStsCd.equals("R")) {
				userMsg = "C/Offer";
			}

			eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { userMsg }).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// /**
	// * ESM_PRI_2003: Counter Offer<br>
	// * Scope과 Main의 상태를 returned로 변경한다.<br>
	// *
	// * @param e Event
	// * @return response EventResponse
	// * @exception EventException
	// */
	// private void manageReturnStatus(Event e) throws EventException {
	// EsmPri2003Event event = (EsmPri2003Event) e;
	// RFAProposalMainBC command4 = new RFAProposalMainBCImpl();
	// PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
	//
	// // cnt 가 0보다 크다면 main을 returned로 변경한다.
	// int cnt = 0;
	//
	// try {
	// List<RsltReturnVO> list = command4.searchProposalReturnedList(mnVo[0]);
	// if (list != null && list.size() > 0) {
	// cnt++;
	// }
	// String propNo = mnVo[0].getPropNo();
	// String amdtSeq = mnVo[0].getAmdtSeq();
	// PriRpMnVO priMn = new PriRpMnVO();
	// priMn.setPropNo(propNo);
	// priMn.setAmdtSeq(amdtSeq);
	// if (cnt > 0) {
	// priMn.setPropStsCd("R");
	// } else {
	// priMn.setPropStsCd("Q");
	// }
	// command4.modifyMainStatus(priMn, account);
	// //Rate Calc Flag change
	// PriRpScpMnVO scpMn = new PriRpScpMnVO();
	// scpMn.setPropNo(propNo);
	// scpMn.setAmdtSeq(amdtSeq);
	// scpMn.setPrsRtCmpbCalcFlg("N");
	// command4.manageProposalRateCalcFlag(scpMn, account);
	//
	// //PRS_RT_CMPB_CALC_FLG
	// } catch (EventException ex) {
	// rollback();
	// throw ex;
	// } catch (Exception ex) {
	// rollback();
	// log.error("err " + ex.toString(), ex);
	// throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
	// }
	//
	// }

	/**
	 * ESM_PRI_2003: Request<br>
	 * Request시 자동 Accept를 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void autoAcceptProposal(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {

			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();

			// request 시 자동 Accept Proposal
			// duration,MQC,DEM/DT
			if (mnVo[0] != null && mnVo[0].getPropStsCd().equals("Q") && mnVo[0].getAmdtSeq().equals("0")) {
				// duration
				PriRpScpDurVO priRpDurVO = new PriRpScpDurVO();
				PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
				ObjectCloner.build(mnVo[0], priRpDurVO);
				priRpDurVO.setSvcScpCd("");
				priRpDurVO.setPrcProgStsCd("A");
				command2.acceptProposalDuration(priRpDurVO, account);

				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						ObjectCloner.build(mnScpVo[i], priRpScpDurVO);
						priRpScpDurVO.setPrcProgStsCd("A");
						command2.acceptProposalDuration(priRpScpDurVO, account);
					}
				}

				// DEM/DT
				PriRpDmdtVO vo = new PriRpDmdtVO();
				ObjectCloner.build(mnVo[0], vo);

				command1.acceptProposalDEMDETException(vo, account);

				// main
				PriRpAmdtSmryVO amdtVo = new PriRpAmdtSmryVO();
				amdtVo.setPropNo(mnVo[0].getPropNo());
				amdtVo.setAmdtSeq(mnVo[0].getAmdtSeq());
				// duration ,DEM/DT
				command.modifyProposalAutoAcceptAmendmentSummary(amdtVo, account);
				// Scop
				PriRpScpAmdtSmryVO amdtScpVo = new PriRpScpAmdtSmryVO();
				amdtScpVo.setPropNo(mnVo[0].getPropNo());
				amdtScpVo.setAmdtSeq(mnVo[0].getAmdtSeq());
				// duration
				command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

	}

	/**
	 * ESM_PRI_2003:sheet2_OnSelectCell()<br>
	 * Terms의 Summary 를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalAmendmentSummary(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPropAmdtSmryVO> list = command.searchProposalAmendmentSummary(event.getPriRpAmdtSmryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:sheet2_OnSelectCell<br>
	 * Scope Terms의 Summary 를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeAmendmentSummary(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummary(event.getPriRpScpAmdtSmryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:Approve<br>
	 * Terms가 ACCEPT 되었는지 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalAcceptCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRpMnVO> list = command.searchProposalAcceptCheck(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:Counter Offer<br>
	 * 모든 terms가 accepted or returned 상태 인지 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCountOfferCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltStatusVO> listCOffer = command.searchCountOfferStatus(event.getPriRpMnVO());
			int cnt = 0;
			if (listCOffer != null && listCOffer.size() > 0) {
				for (int i = 0; i < listCOffer.size(); i++) {
					RsltStatusVO vo = listCOffer.get(i);
					cnt += Integer.parseInt(vo.getCnt());
				}
			}
			RsltStatusVO rVo = new RsltStatusVO();
			rVo.setStatus("cnt");
			rVo.setCnt(String.valueOf(cnt));
			eventResponse.setRsVo(rVo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:Request<br>
	 * Request 시 필수 입력 Terms 중 데이터가 없는 Terms를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestTermsCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CstRequestCheckVO> list = command.searchRequestTermsCheck(event.getPriRpMnVO());
			List<RequestCheckForCalculationVO> listCalc = command.searchRequestCheckCalculate(event.getPriRpScpMnVO());
			// Calculate를 하지 않은 내용이 존재 하므로 Exception처리 한다.
			if (listCalc != null && listCalc.size() > 0) {
				StringBuffer strMsg = new StringBuffer();
				strMsg.append("\n[ ");
				for (int i = 0; i < listCalc.size(); i++) {
					if (i != 0) {
						strMsg.append(", ");
					}
					strMsg.append(listCalc.get(i).getSvcScpCd());

				}
				strMsg.append(" ]");
				// throw new EventException(new ErrorHandler("PRI03019",new String[]{strMsg.toString()}).getMessage());
				CstRequestCheckVO vo = new CstRequestCheckVO();
				vo.setTerms("CALC_CHK");
				vo.setCnt(strMsg.toString());
				list.add(vo);
			} else {
				
				List<RequestCheckForMatchBackVO> listMB = command.searchRequestCheckMatchBack(event.getPriRpScpMnVO());
				// M/B 조회하지 않은 내용이 존재하므로 Exception 처리 한다.
				if(listMB != null && listMB.size() > 0) {
					StringBuffer strMsg = new StringBuffer();
					strMsg.append("\n[ ");
					for (int i = 0; i < listMB.size(); i++) {
						if (i != 0) {
							strMsg.append(", ");
						}
						strMsg.append(listMB.get(i).getSvcScpCd());
						
					}
					strMsg.append(" ]");
					// throw new EventException(new ErrorHandler("PRI03027",new String[]{strMsg.toString()}).getMessage());
					CstRequestCheckVO vo = new CstRequestCheckVO();
					vo.setTerms("MB_CHK");
					vo.setCnt(strMsg.toString());
					list.add(vo);
				}
			}
			

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Match Back<br>
	 * Request 시 필수 입력 Terms 중 데이터가 없는 Terms를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMatchBackCheckCalculate(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RequestCheckForCalculationVO> listCalc = command.searchMatchBackCheckCalculate(event.getPriRpScpMnVO());
			// Calculate를 하지 않은 내용이 존재 하므로 M/B버튼 비활성 처리 한다.
			if (listCalc != null && listCalc.size() > 0) {
				eventResponse.setETCData("CAL_STATUS", "UN_CALCULATED");
			} else {
				eventResponse.setETCData("CAL_STATUS", "CALCULATED");
			}
	} catch (EventException ex) {
		throw ex;
	} catch (Exception ex) {
		throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
	}

	return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003: Terms에서 호출<br>
	 * Terms의 데이터가 변경된 후 Scope의 상태를 변경하기 위하여 Scope의 status를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeStatusCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRpScpMnVO> list = command.searchProposalScopeStatusCheck(event.getPriRpScpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003: delete<br>
	 * Scope삭제시 각 Terms에 데이터가 있는지 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDeleteCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// rate ori/dest loc group cmdt group standard note,special note L/agent goh //arb,ihc
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		CstPriSpScpDelCntVO vo = new CstPriSpScpDelCntVO();
		int cnt = 0;

		try {
			cnt = command.searchProposalScopeDeleteCheck(event.getPriRpScpMnVO());
			vo.setDelcnt(String.valueOf(cnt));
			eventResponse.setRsVo(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003: Approve<br>
	 * Main의 상태를 Approve로 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approveProposal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		CRMSalesLeadBC command3 = new CRMSalesLeadBCImpl();
		//Booking Autorating
        BlRatingBC command4 = new BlRatingBCImpl();
		String rfaNo = "";
		try {
			begin();
			rfaNo = command.approveProposal(event.getRfaPropProgVO(), account);
			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
				// Sales Lead No가 있을 경우
				if (!JSPUtil.getNull(priRpMnVO.getSlsLdNo()).equals("")) {
					ObjectCloner.build(priRpMnVO, vo);
					vo.setPropStsCd("A");
					command3.manageRFACRMSalesLeadNo(vo, account);
				}
				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command.transferRfaSalesLeadContractInfo(priRpMnVO, account);

				// INTERFACE : EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command.transferRfaGeneralInfo(genInfVO, account);
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { "Approve" }).getUserMessage());

			}
			// Approve 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
			List<PriEmailTargetListVO> list = command.sendEmail(priRpMnVO, account);
			
			if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
				command4.modifyAudDt(list);
            }
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("rfa_no", rfaNo);
		return eventResponse;
	}

	/**
	 * ESM_PRI_2103: Approve Spot <br>
	 * Main의 상태를 Approve로 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approveProposalSpot(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		CRMSalesLeadBC command3 = new CRMSalesLeadBCImpl();
		//Booking Autorating
        BlRatingBC command4 = new BlRatingBCImpl();
		String rfaNo = "";
		try {
			begin();
			
			//##### make a Spot Guide RFA No. #####
			rfaNo = command.approveProposalSpot(event.getRfaPropProgVO(), account);
			//##### make a Spot Guide RFA No. #####
			
			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
				// Sales Lead No가 있을 경우
				if (!JSPUtil.getNull(priRpMnVO.getSlsLdNo()).equals("")) {
					ObjectCloner.build(priRpMnVO, vo);
					vo.setPropStsCd("A");
					command3.manageRFACRMSalesLeadNo(vo, account);
				}
				
				//#####  INTERFACE (CMS0010001) : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command.transferRfaSalesLeadContractInfo(priRpMnVO, account);

				
				//##### INTERFACE (EDI0080001): EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command.transferRfaGeneralInfo(genInfVO, account);
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { "Approve" }).getUserMessage());

			}
			// Approve 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
			List<PriEmailTargetListVO> list = command.sendEmail(priRpMnVO, account);
			
			if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
				command4.modifyAudDt(list);
            }
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("rfa_no", rfaNo);
		return eventResponse;
	}
	/**
	 * ESM_PRI_2003: Cancel<br>
	 * 상태값을 Cancel하여 이전 상태로 변경한다.<br>
	 * Init상태에서 Cancel을 하는 경우에는 해당 Amd Seq No.의 모든 데이터를 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;

		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFANoteProposalBC command3 = new RFANoteProposalBCImpl();
		RFAGroupCommodityProposalBC command5 = new RFAGroupCommodityProposalBCImpl();
		RFARateProposalBC command7 = new RFARateProposalBCImpl();
		RFAGroupLocationProposalBC command8 = new RFAGroupLocationProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command10 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAAffiliateProposalBC command11 = new RFAAffiliateProposalBCImpl();
		RFAProposalDEMDETBC command15 = new RFAProposalDEMDETBCImpl();
		CRMSalesLeadBC command16 = new CRMSalesLeadBCImpl();
		RFAGRICalculationProposalBC command17 = new RFAGRICalculationProposalBCImpl();
		RFANoteConversionProposalBC command18 = new RFANoteConversionProposalBCImpl();
		RFAQuotationMainBC command19 = new RFAQuotationMainBCImpl();

		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();

			String stsCd = mnVo[0].getPropStsCd();
			log.debug("stsCd=======================" + stsCd);
			log.debug("amdtseq=======================" + mnVo[0].getAmdtSeq());
			if (!stsCd.equals("D")) {
				command.cancelProposal(event.getRfaPropProgVO(), account); // 메인 상태변경
			}

			if (stsCd.equals("I")) {
				PriRpAproRqstRefVO priRpAproRqstRefVO = new PriRpAproRqstRefVO();
				if (mnVo[0] != null) {
					command11.manageProposalRequestCancel(mnVo[0], account);// affiliate
					command2.manageProposalRequestCancel(mnVo[0], account);// duration
					command15.manageProposalRequestCancel(mnVo[0], account);// free time

					// pri_sp_amdt_smry acpt_flg를 N으로 update
					PriRpAmdtSmryVO vo = new PriRpAmdtSmryVO();
					ObjectCloner.build(mnVo[0], vo);
					command.manageProposalRequestCancelAmendmentSummary(vo, account);// Main Terms

					// pri_sp_scp_amdt_smry acpt_flg를 N으로 update
					PriRpScpAmdtSmryVO scpVo = new PriRpScpAmdtSmryVO();
					ObjectCloner.build(mnVo[0], scpVo);
					command.manageProposalScopeRequestCancelAmendmentSummary(scpVo, account);
					// scope main 상태변경
					PriRpScpMnVO scpMnVo = new PriRpScpMnVO();
					ObjectCloner.build(mnVo[0], scpMnVo);
					command.modifyAllScopeStatus(scpMnVo, account);

					// Proposal Request 정보의 상태변경을 위한 값을 셋팅한다.
					priRpAproRqstRefVO.setPropNo(mnVo[0].getPropNo());
					priRpAproRqstRefVO.setAmdtSeq(mnVo[0].getAmdtSeq());
					priRpAproRqstRefVO.setPrcAproRqstStsCd("C");
				}

				command5.manageProposalRequestCancel(mnScpVo, account);// commodity
				command8.manageProposalRequestCancel(mnScpVo, account);// location
				command3.manageProposalRequestCancel(mnScpVo, account);// note
				command7.manageProposalRequestCancel(mnScpVo, account);// rate
				command10.manageProposalRequestCancel(mnScpVo, account);// ihc,arb
				command2.manageProposalRequestCancelScope(mnScpVo, account);// duration

				// Proposal Request 정보의 상태를 Cancel로 변경한다.
				command.modifyProposalRequestStatus(priRpAproRqstRefVO, account);

			} else if (stsCd.equals("Q")) {// Approve Cancel

				// MAIN,SCOPE MAIN EXP_DT 원복
				command.manageProposalApproveCancel(mnVo[0], account);//

				log.debug("request approve cancel===================" + mnVo[0].getAmdtSeq());
				log.debug("request approve cancel===================" + mnScpVo[0].getAmdtSeq());
				// Rate Calc Flag change
				PriRpScpMnVO scpMn = new PriRpScpMnVO();
				scpMn.setPropNo(mnVo[0].getPropNo());
				scpMn.setAmdtSeq(mnVo[0].getAmdtSeq());
				scpMn.setPrsRtCmpbCalcFlg("Y");
				scpMn.setPrsRtMbFlg("Y");
				command.manageProposalRateCalcFlag(scpMn, account);

				// sale lead
				CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
				ObjectCloner.build(mnVo[0], vo);
				command16.manageRFACRMSalesLeadNo(vo, account);

				// INTERFACE : EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(mnVo[0], genInfVO);
				genInfVO.setEaiSts("D");
				command.transferRfaGeneralInfo(genInfVO, account);
			} else if (stsCd.equals("D")) {// Init Cancel 모든 데이터 삭제

				CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
				ObjectCloner.build(mnVo[0], vo);
				command16.manageRFACRMSalesLeadNo(vo, account);

				// Quotation Main
				PriRqMnVO priRqMnVO = new PriRqMnVO();
				priRqMnVO.setPropNo(mnVo[0].getPropNo());
				command19.modifyRFAQuotationMainPropNoDel(priRqMnVO, account); // Quotation Main PropNo reset
				command2.removeProposal(mnVo[0], account);// duration main
				command11.manageProposal(mnVo[0], account); // affiliate
				command15.removeProposal(mnVo[0], account); // FREE TIME
				command18.manageProposal(mnVo[0], account);// conversion
				command.removeProposalProgress(mnVo[0], account);// Progress
				command.removeProposalAmdtSmry(mnVo[0], account);// amdt smry
				command17.manageProposal(mnVo[0], account);// GRI

				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						command2.removeProposalScope(mnScpVo[i], account);// duration scope
						command3.manageProposal(mnScpVo[i], account);// s Note
						command5.manageProposal(mnScpVo[i], account);// group Commodity
						command7.removeProposalMain(mnScpVo[i]);// rate
						command8.removeProposal(mnScpVo[i], account);// group location
						command10.manageProposal(mnScpVo[i], account);// arb/ihc
						command.removeProposalScopeProgress(mnScpVo[i], account);// progress
						command.removeProposalScopeAmdtSmry(mnScpVo[i], account);// amdt_smry
						command.removeProposalScopeMain(mnScpVo[i], account);
					}
				}
				command.removeProposal(mnVo[0], account); // proposal main
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI01047", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:Terms에서 호출<br>
	 * Terms의 데이터가 수정되었다면 AmendmentSummary 를 수정한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalAmendmentSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		int result = 0;
		try {
			begin();
			command.manageProposalAmendmentSummary(event.getPriRpAmdtSmryVO(), account);
			PriRpMnVO vo = new PriRpMnVO();
			ObjectCloner.build(event.getPriRpAmdtSmryVO(), vo);
			result = command.changeAutoRequestMainStatus(vo, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("upd_cnt", String.valueOf(result));
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003:Scope Terms에서 호출<br>
	 * Scope Terms의 데이터가 수정되었다면 AmendmentScopeSummary 를 자동으로 수정한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalScopeAmendmentSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		int result = 0;
		try {
			begin();
			command.manageProposalScopeAmendmentSummary(event.getPriRpScpAmdtSmryVO(), account);
			// TERMS가 모두 ACCEPT되었는지 확인하여 SCOPE MAIN의 상태를 ACCEPT로 변경한다.
			PriRpScpMnVO scpVo = new PriRpScpMnVO();
			ObjectCloner.build(event.getPriRpScpAmdtSmryVO(), scpVo);
			int cnt = command.searchProposalScopeAcceptCheck(scpVo);
			if (cnt == 0) {// scope status ALL accept
				PriRpScpMnVO[] priRpScpMnVO = new PriRpScpMnVO[1];
				priRpScpMnVO[0] = new PriRpScpMnVO();
				ObjectCloner.build(scpVo, priRpScpMnVO[0]);
				priRpScpMnVO[0].setPropScpStsCd("A");// Accept로 변경
				priRpScpMnVO[0].setIbflag("U");
				command.modifyScopeStatus(priRpScpMnVO, account);
			} else {
				command.changeAutoScopeReturnStatus(scpVo, account);
			}
			PriRpMnVO vo = new PriRpMnVO();
			ObjectCloner.build(event.getPriRpScpAmdtSmryVO(), vo);
			result = command.changeAutoRequestMainStatus(vo, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("upd_cnt", String.valueOf(result));
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initMainComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> scopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("scopeList", scopeList);

			CodeUtil cdUtil = CodeUtil.getInstance();

			ArrayList<CodeInfo> lodUtList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD00897", 0);
			eventResponse.setCustomData("lodUtList", lodUtList);
			ArrayList<CodeInfo> scpStsList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("scpStsList", scpStsList);
			ArrayList<CodeInfo> dmdtList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01704", 0);
			eventResponse.setCustomData("dmdtList", dmdtList);
			ArrayList<CodeInfo> rfaCtrtTpList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03511", 0);//CD03264
			eventResponse.setCustomData("rfaCtrtTpList", rfaCtrtTpList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ===============================ESM_PRI_2010_start===========================================

	/**
	 * ESM_PRI_2010:Retrieve<br>
	 * 조회 조건에 따라 Main,Scope Duration을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationList(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			GrpDurVO grpDurVO = command.searchProposalDurationList(event.getCstAuthorityVO());
			List<RsltPriRpDurVO> list = grpDurVO.getRsltPriRpDurVOS();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Main,Scope Duration 을 각각 추가/수정/삭제합니다.<br>
	 * Duration이 변경될 때 Expire Date가 같은 Conversion 데이터가 있다면 같이 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalDuration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFANoteConversionProposalBC command2 = new RFANoteConversionProposalBCImpl();
		String saveScp = "";
		try {
			begin();
			command.manageProposalDuration(event.getCstPriRpScpDurVOs(), account);

			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getCstPriRpScpDurVOs()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpScpDurVOs()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("01");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			CstPriRpScpDurVO[] cstVo = event.getCstPriRpScpDurVOs();
			saveScp = cstVo[0].getScpSave();
			// main update
			PriRpMnVO mnVo = new PriRpMnVO();
			mnVo.setPropNo(cstVo[0].getPropNo());
			mnVo.setAmdtSeq(cstVo[0].getAmdtSeq());
			mnVo.setExpDt(cstVo[0].getCtrtExpDt());

			if (cstVo[0].getSvcScpCd().equals("")) {
				// command1.manageProposalMainExpiry(mnVo, account);
				if (saveScp.equals("true")) {
					List<PriRpScpDurVO> list = command.searchProposalScope(cstVo[0]);
					if (list != null && list.size() > 0) {
						PriRpScpMnVO[] scpVo = new PriRpScpMnVO[list.size()];
						for (int i = 0; i < list.size(); i++) {
							PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
							ObjectCloner.build(cstVo[0], vo);
							vo.setSvcScpCd(list.get(i).getSvcScpCd());
							vo.setPropScpTermTpCd("11");
							command1.manageProposalScopeAmendmentSummary(vo, account);

							scpVo[i] = new PriRpScpMnVO();
							scpVo[i].setPropNo(cstVo[0].getPropNo());
							scpVo[i].setAmdtSeq(cstVo[0].getAmdtSeq());
							scpVo[i].setSvcScpCd(list.get(i).getSvcScpCd());
							scpVo[i].setExpDt(mnVo.getExpDt());
							scpVo[i].setIbflag("U");
						}
						command2.manageNoteConversionExpireDate(scpVo, account);
					}
				}
				command1.manageProposalMainExpiry(mnVo, account);
			} else {
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
				PriRpScpAmdtSmryVO scpSmryVo = new PriRpScpAmdtSmryVO();
				scpSmryVo.setPropNo(event.getCstPriRpScpDurVOs()[0].getPropNo());
				scpSmryVo.setAmdtSeq(event.getCstPriRpScpDurVOs()[0].getAmdtSeq());
				scpSmryVo.setSvcScpCd(event.getCstPriRpScpDurVOs()[0].getSvcScpCd());
				scpSmryVo.setPropScpTermTpCd("11");
				command1.manageProposalScopeAmendmentSummary(scpSmryVo, account);
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			}

			// note conv
			if (cstVo != null && cstVo.length > 0) {
				PriRpScpMnVO[] scpVo = new PriRpScpMnVO[cstVo.length];
				for (int i = 0; i < cstVo.length; i++) {
					scpVo[i] = new PriRpScpMnVO();
					scpVo[i].setPropNo(cstVo[i].getPropNo());
					scpVo[i].setAmdtSeq(cstVo[i].getAmdtSeq());
					scpVo[i].setSvcScpCd(cstVo[i].getSvcScpCd());
					scpVo[i].setExpDt(cstVo[i].getCtrtExpDt());
					scpVo[i].setIbflag("U");
				}
				command2.manageNoteConversionExpireDate(scpVo, account);
			}

			if (saveScp.equals("true")) {// scope main upate//전체변경
				command1.manageProposalScopeMainExpiry(mnVo, account);
			}
			if (saveScp.equals("expchange")) {// scope main upate//Scope변경
				PriRpScpMnVO vo = new PriRpScpMnVO();
				ObjectCloner.build(cstVo[0], vo);
				vo.setExpDt(cstVo[0].getCtrtExpDt());
				command1.changeProposalScopeMainExpiry(vo, account);
			}

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Accept<br>
	 * Request 된 데이터를 Accept 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptProposalDuration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();

			String scpAccept = event.getCstScpDurVO().getScpAccept();
			CstScpDurVO cstVo = event.getCstScpDurVO();
			PriRpScpDurVO scpVo = new PriRpScpDurVO();
			ObjectCloner.build(cstVo, scpVo);
			command.acceptProposalDuration(scpVo, account);
			if (event.getCstScpDurVO().getSvcScpCd().equals("")) {
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
				PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
				priRpAmdtSmryVO.setPropNo(event.getCstScpDurVO().getPropNo());
				priRpAmdtSmryVO.setAmdtSeq(event.getCstScpDurVO().getAmdtSeq());
				priRpAmdtSmryVO.setPropTermTpCd("01");
				command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			} else {
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
				PriRpScpAmdtSmryVO scpAmdtSmryVO = new PriRpScpAmdtSmryVO();
				scpAmdtSmryVO.setPropNo(event.getCstScpDurVO().getPropNo());
				scpAmdtSmryVO.setAmdtSeq(event.getCstScpDurVO().getAmdtSeq());
				scpAmdtSmryVO.setSvcScpCd(event.getCstScpDurVO().getSvcScpCd());
				scpAmdtSmryVO.setPropScpTermTpCd("11");
				command1.manageScopeAmendmentSummary(scpAmdtSmryVO, account);
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			}

			if (scpAccept.equals("Y")) {

				List<RsltCdListVO> listScope = command.searchProposalDurationAcceptList(scpVo);
				command.acceptAutoProposalScopeDuration(scpVo, account);
				if (listScope != null && listScope.size() > 0) {
					PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
					vo.setPropNo(scpVo.getPropNo());
					vo.setAmdtSeq(scpVo.getAmdtSeq());
					vo.setPropScpTermTpCd("11");
					for (int i = 0; i < listScope.size(); i++) {
						RsltCdListVO cdVo = listScope.get(i);
						vo.setSvcScpCd(cdVo.getCd());
						command1.manageScopeAmendmentSummary(vo, account);
					}
				}

			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Cancel<br>
	 * Accept된 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelProposalDuration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelProposalDuration(event.getPriRpScpDurVO(), account);
			if (event.getPriRpScpDurVO().getSvcScpCd().equals("")) {
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
				PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
				priRpAmdtSmryVO.setPropNo(event.getPriRpScpDurVO().getPropNo());
				priRpAmdtSmryVO.setAmdtSeq(event.getPriRpScpDurVO().getAmdtSeq());
				priRpAmdtSmryVO.setPropTermTpCd("01");
				command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			} else {
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
				PriRpScpAmdtSmryVO scpAmdtSmryVO = new PriRpScpAmdtSmryVO();
				scpAmdtSmryVO.setPropNo(event.getPriRpScpDurVO().getPropNo());
				scpAmdtSmryVO.setAmdtSeq(event.getPriRpScpDurVO().getAmdtSeq());
				scpAmdtSmryVO.setSvcScpCd(event.getPriRpScpDurVO().getSvcScpCd());
				scpAmdtSmryVO.setPropScpTermTpCd("11");
				command1.manageScopeAmendmentSummary(scpAmdtSmryVO, account);
				log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Main Duration 저장 시 Scope Duration 의 기간을 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CstPriRpDurVO> list = command.searchProposalScopeCheckList(event.getPriRpScpDurVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Main Duration Amend 시 Scope Duration 의 Amend데이터가 있는지 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationAmendCheckList(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRpScpDurVO> list = command.searchProposalDurationAmendCheckList(event.getPriRpScpDurVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Main Duration 저장 시 Scope Duration 의 Duration보다 작은 값인지 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationScopeCount(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CstPriRpScpDurCntVO> list = command.searchProposalDurationScopeCount(event.getPriRpScpDurVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6047 : onLoad , Retrieve <BR>
	 * RFA CMPB/OPB View All 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmpbViewAllList(Event e) throws EventException {
		EsmPri6047Event event = (EsmPri6047Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateProposalBC command1 = new RFARateProposalBCImpl();
		try {
			List<RsltPriRateCmpbViewAllListVO> list = command1.searchRateCmpbViewAllList(event.getRsltPriRateCmpbViewAllListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Search <br>
	 * Arbitrary List를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeList(event.getPriRpScpTrspAddChgVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Guideline Copy <br>
	 * Arbitrary를 수정합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.manageArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Guideline Copy <br>
	 * Arbitrary Guideline Copy 시 Copy할 Guidelin이 존재하는지 Group Location이 유효한지 한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGuidelineCopyArbitraryChargeExist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		boolean existGline = true;
		boolean existGlineGrpLoc = true;

		try {
			existGline = command.checkGuidelineArbitraryChargeExist(event.getCstPriRpScpTrspAddChgVO());
			existGlineGrpLoc = command.checkGuidelineArbitraryChargeGroupLocationExist(event.getCstPriRpScpTrspAddChgVO());

			// copy할 guideline이 없다.
			if (existGline == false) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01040", new String[] {}).getUserMessage());
				eventResponse.setETCData("FLAG", "N");
			}
			// guideline의 group location이 등록되지 않았다.
			else if (existGlineGrpLoc == false) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01095", new String[] {}).getUserMessage());
				eventResponse.setETCData("FLAG", "N");
			}
			// guideline copy 실행
			else {
				eventResponse.setETCData("FLAG", "Y");
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_200304 : Guideline Copy <br>
	 * Arbitrary Cuideline을 Copy한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.copyGuidelineArbitraryCharge(event.getCstPriRpScpTrspAddChgVO(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getCstPriRpScpTrspAddChgVO().getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getCstPriRpScpTrspAddChgVO().getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getCstPriRpScpTrspAddChgVO().getSvcScpCd());
			if ("O".equals(event.getCstPriRpScpTrspAddChgVO().getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getCstPriRpScpTrspAddChgVO().getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			// eventResponse.setUserMessage(new ErrorHandler("PRI01017").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Accept <br>
	 * Arbitrary accept를 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptArbitraryCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.acceptArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Accept Cancel <br>
	 * Arbitrary Accept Cancel 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.cancelArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Accept All <br>
	 * Arbitrary Accept all을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.acceptAllArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Accept Cancel <br>
	 * Arbitrary Accept Cancel을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelAllArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);

			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
			// log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2040 : Ok<br>
	 * Amend Data를 생성한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse amendProposal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2040Event event = (EsmPri2040Event) e;
		RFAProposalMainBC command01 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command02 = new RFADurationProposalBCImpl();
		RFAProposalDEMDETBC command04 = new RFAProposalDEMDETBCImpl();

		RFAGroupLocationProposalBC command05 = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC command06 = new RFAGroupCommodityProposalBCImpl();
		RFAAffiliateProposalBC command07 = new RFAAffiliateProposalBCImpl();
		RFANoteProposalBC command11 = new RFANoteProposalBCImpl();
		RFARateProposalBC command12 = new RFARateProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command14 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFANoteConversionProposalBC command15 = new RFANoteConversionProposalBCImpl();

		PriRpMnVO vo = new PriRpMnVO();
		CstPriRpAmendVO amdVo = event.getCstPriRpAmendVO();
		ObjectCloner.build(amdVo, vo);
		if (!amdVo.getNewDurFlg().equals("Y")) { // 새로운 duration 입력 Y
			vo.setExpDt("");
		}

		try {
			begin();
			command01.amendProposal(vo, account);
			command02.amendProposal(vo, account);
			command04.amendProposal(vo, account);
			command05.amendProposal(vo, account);
			command06.amendProposal(vo, account);
			command07.amendProposal(vo, account);
			command11.amendProposal(vo, account);
			command12.amendProposal(vo, account);
			command14.amendProposal(vo, account);
			command15.amendProposal(vo, account);
			command01.manageProposalAmendmentSummaryDuration(vo, account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Search <br>
	 * Affiliate List를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {
			List<RsltPriRpAfilVO> list = command.searchAffiliateList(event.getPriRpAfilVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Search <br>
	 * Mannual Input 칼럼 사용 가능 여부를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PriRpAfilVO> list = command.searchManualCheck(event.getPriRpAfilVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Save <br>
	 * Affiliate List를 수정한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.manageAffiliate(event.getPriRpAfilVOS(), account);

			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("05");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept <br>
	 * Affiliate를 Accept를 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.acceptAffiliate(event.getPriRpAfilVOS(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("05");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept Cancel<br>
	 * Affiliate를 Accept Cancel을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelAffiliate(event.getPriRpAfilVOS(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("05");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept All<br>
	 * Affiliate를 Accept All을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.acceptAllAffiliate(event.getCstPriRpAfilVO(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getCstPriRpAfilVO().getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpAfilVO().getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("05");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept Cancel All<br>
	 * Affiliate를 Accept Cancel All을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelAllAffiliate(event.getCstPriRpAfilVO(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getCstPriRpAfilVO().getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpAfilVO().getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("05");
			command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initAffilComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02198", 0);
			eventResponse.setCustomData("srcInfoList", srcInfoList);
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("stsList", stsList);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Search <br>
	 * DEMDET List를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDEMDETExceptionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command = new RFAProposalDEMDETBCImpl();

		try {
			List<RsltDmdtExptListVO> list = command.searchDEMDETExceptionList(event.getPriRpDmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Save <br>
	 * DEMDET을 수정한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.manageDEMDETException(event.getPriRpDmdtVOS(), account);

			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("08");
			command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Accept <br>
	 * DEMDET Accept를 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.acceptDEMDETException(event.getPriRpDmdtVOS(), account);

			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("08");
			command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Accept Cancel <br>
	 * DEMDET Accept Cancel을 실행한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();

		try {
			begin();
			command1.cancelDEMDETException(event.getPriRpDmdtVOS(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
			priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
			priRpAmdtSmryVO.setPropTermTpCd("08");
			command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Search <br>
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkArbitraryFontStyle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Request <br>
	 * Request시 dem/det를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckDmdtList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<DmtScExptVerVO> list = command.searchCheckDmdtList(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Request <br>
	 * Request시 Duration 변경을 확인한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckDurationList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltCdListVO> list = command.searchCheckDurationList(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2047 : Search <br>
	 * Rate Cargo Specification을 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCargoSepcification(Event e) throws EventException {
		EsmPri2047Event event = (EsmPri2047Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltPriRpScpRtCgoSpecVO> list = command.searchRateCargoSepcification(event.getPriRpScpRtCgoSpecVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2047 : Save <br>
	 * Rate Cargo Specification을 수정한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCargoSepcification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2047Event event = (EsmPri2047Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			begin();
			command.manageRateCargoSepcification(event.getPriRpScpRtCgoSpecVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2075 : Search <br>
	 * Rate Cargo Specification Inquiry을 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCargoSepcificationInquiry(Event e) throws EventException {
		EsmPri2075Event event = (EsmPri2075Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltPriRpScpRtCgoSpecVO> list = command.searchRateCargoSepcification(event.getPriRpScpRtCgoSpecVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6064 : Save <BR>
	 * RFA RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6064Event event = (EsmPri6064Event) e;
		try {
			begin();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			command.modifyPrsCost(event.getRsltPriPrsCostListVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6023 : OK <BR>
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsSimulationCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6064Event event = (EsmPri6064Event) e;
		try {
			begin();
			RFARateProposalBC command = new RFARateProposalBCImpl();
			SCRateProposalBC commandForCopy = new SCRateProposalBCImpl();
			CalculateBC commandForCalculation = new CalculateBCImpl();

			// command.modifyPrsSimulationCost(event.getRsltPriPrsCostListVOS(),account);

			List<RsltPriPrsCostListVO> listRsltPriPrsCostListVO = new ArrayList<RsltPriPrsCostListVO>();
			String newRoutCsNo = null;
			String newRoutCsSrcDt = null;
			RsltPriPrsCostListVO[] rsltPriPrsCostListVOs = event.getRsltPriPrsCostListVOS();
			InPriPrsRoutCsVO inPriPrsRoutCsVO = event.getInPriPrsRoutCsVO();
			rsltPriPrsCostListVOs[0].setIbflag("U");
			rsltPriPrsCostListVOs[0].setUsdRoutCsSelFlg("N");
			rsltPriPrsCostListVOs[0].setUpdUsrId(account.getUsr_id());
			listRsltPriPrsCostListVO.add(rsltPriPrsCostListVOs[0]);

			// POL(TERM),POD(TERM)의 조합이 정확한지 검사 한다.
			// POL 검사
			List<RsltPriCostSimulationCheckRouteVO> checkList = command.searchCostSimulationCheckRoutList(event.getInCostSimulationCheckRouteVO());
			if (checkList.size() == 0) {
				// route와 term을 잘 못 입력 하였다.
				throw new EventException(new ErrorHandler("PRI03021").getMessage());
			}

			// 0. PRI_PRS_BAT에서 pgm_no = 'ESM_PRI_T001'인 ROW의
			// PARA_INFO_CTNT(ROUT_CS_SRC_DT) , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.
			RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = commandForCopy.searchRouteCaseCostVersion(); // <--

			// 1. 새로운 Rout_cs_no를 select한다.
			// RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO = commandForCopy.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO);
			RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = commandForCalculation.searchPriPrsRoutCsMaxRoutCsNoCalculate(null);
			newRoutCsNo = maxRoutCsVO.getRoutCsNo();
			newRoutCsSrcDt = rsltRouteCaseCostVersionVO.getParaInfoCtnt();
			log.debug("=====rsltNewRoutCaseNoVO==>" + newRoutCsNo);
			log.debug("=====rsltNewRoutCaseNoVO==>" + newRoutCsSrcDt);
			inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());

			// 2. PRI_PRS_ROUT_CS(BATCH)에 한건을 INSERT한다.(화면에서 입력받은값을 사용.)
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
			inPriPrsRoutCsVO.setRoutCsClssNo(rsltRouteCaseCostVersionVO.getPrsBatId()); // <-- rout_cs_clss_no
			commandForCalculation.managePriPrsRouteCase(inPriPrsRoutCsVO, account);

			// 2. Route Case를 New Rout_cs_no를 이용해서 입력한다. (online)
			PriRpScpRtUsdRoutCsVO routCsVO = event.getPriRpScpRtUsdRoutCsVO();
			routCsVO.setRoutCsNo(newRoutCsNo);
			routCsVO.setRoutCsSrcDt(newRoutCsSrcDt);

			command.managePriRateUsedRouteCase(routCsVO, account);

			// 3. Route를 변경한다. usd_rout_cs_sel_flg ( Y --> N )
			command.modifyPrsRateCommodityRoute(listRsltPriPrsCostListVO);
			log.debug("===== ******************************* modifyRateCommodityRoute 종료  ==>");

			// 4. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 COA 데이터 카피 Insert
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 실행  ==>");
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
			inPriPrsRoutCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
			commandForCalculation.copyCoaCostInfoToOnlineCostInfo(inPriPrsRoutCsVO, account);
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 종료  ==>");

			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 실행  ==>");
			commandForCalculation.copyOnlineCostInfoToBatchCostInfo(inPriPrsRoutCsVO, account);
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 종료  ==>");

			// 5. Calculate Batch Logic과 동일한 로직을 돌린다.
			command.modifyCalculateLogicData(listRsltPriPrsCostListVO); // XA Driver를 사용하면 문제가 생길수 있음 (Merge, with 문장)
			log.debug("===== *******************************  후 ==>");

			eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_03 : RETRIEVE<br>
	 * COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204103Event event = (EsmPri204103Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityHistoryList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_03 : SHEET1.SELECTROW<br>
	 * COMMODITY GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204103Event event = (EsmPri204103Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailHistoryList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_03 : RETRIEVE<br>
	 * COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201903Event event = (EsmPri201903Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityInquiryList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_03 : SHEET1.SELECTROW<br>
	 * COMMODITY GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201903Event event = (EsmPri201903Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailInquiryList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_04 : RETRIEVE<br>
	 * LOCATION GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationHistoryList(Event e) throws EventException {
		EsmPri204104Event event = (EsmPri204104Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationHistoryList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_04 : SHEET1.SELECTROW<br>
	 * LOCATION GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailHistoryList(Event e) throws EventException {
		EsmPri204104Event event = (EsmPri204104Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailHistoryList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_02 : RETRIEVE<br>
	 * LOCATION GROUP을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryList(Event e) throws EventException {
		EsmPri201902Event event = (EsmPri201902Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationInquiryList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_02 : SHEET1.SELECTROW<br>
	 * LOCATION GROUP의 DETAIL을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailInquiryList(Event e) throws EventException {
		EsmPri201902Event event = (EsmPri201902Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailInquiryList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : OPEN <br>
	 * SPECIAL NOTE INQUIRY 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonSpecialNoteHistoryList(Event e) throws EventException {
		// EsmPri204108Event event = (EsmPri204108Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_PROG_STS_CD", list);

			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// BAR TYPE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : RETRIEVE<br>
	 * SPECIAL NOTE를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteListVO> list = command.searchNoteHistoryList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : SHEET1.SELECTROW<br>
	 * SPECIAL NOTE의 CONTENT를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentHistoryList(event.getPriRpScpNoteCtntVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : SHEET2.SELECTROW<br>
	 * SPECIAL NOTE CONVERSION을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionHistoryList(Event e) throws EventException {
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : OPEN <br>
	 * SPECIAL NOTE INQUIRY 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonSpecialNoteInquiryList(Event e) throws EventException {
		// EsmPri201901Event event = (EsmPri201901Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_PROG_STS_CD", list);

			// APLICATION
			vo.setCd("CD01723");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);

			// BAR TYPE
			vo.setCd("CD01708");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
			
			// S/I
			vo.setCd("CD02582");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : RETRIEVE<br>
	 * SPECIAL NOTE를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteListVO> list = command.searchNoteInquiryList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : SHEET1.SELECTROW<br>
	 * SPECIAL NOTE의 CONTENT를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentInquiryList(event.getPriRpScpNoteCtntVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : SHEET2.SELECTROW<br>
	 * SPECIAL NOTE CONVERSION을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionInquiryList(Event e) throws EventException {
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Search <BR>
	 * Sale Lead No,Name을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainSaleLeadFirstList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		PriRpMnVO mnVo = event.getPriRpMnVO();
		SchSaleLeadRfaVO vo = new SchSaleLeadRfaVO();
		ObjectCloner.build(mnVo, vo);
		vo.setCustCntCd(mnVo.getCtrtCustCntCd());
		vo.setCustSeq(mnVo.getCtrtCustSeq());
		vo.setFirstSw("Y");
		try {
			List<RsltPriCrmSlLdVO> list = command.searchProposalMainSaleLeadList(vo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Search <BR>
	 * Sale Lead No,Name을 조회합니다.(S/C Main에 저장된 sls_ld_no도 같이 조회)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainSaleLeadList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		PriRpMnVO mnVo = event.getPriRpMnVO();
		SchSaleLeadRfaVO vo = new SchSaleLeadRfaVO();
		ObjectCloner.build(mnVo, vo);
		vo.setCustCntCd(mnVo.getCtrtCustCntCd());
		vo.setCustSeq(mnVo.getCtrtCustSeq());
		vo.setFirstSw("N");
		try {
			List<RsltPriCrmSlLdVO> list = command.searchProposalMainSaleLeadList(vo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041 : RFA No. 입력 <BR>
	 * Amendment History Main 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentHistoryMain(Event e) throws EventException {
		EsmPri2041Event event = (EsmPri2041Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			List<RsltPriRpAmdHstMnVO> list = command1.searchAmendmentHistoryMain(event.getPriRpHdrVO());

			if (list != null && list.size() != 0 && list.get(0) != null) {
				eventResponse.setETCData("prop_no", list.get(0).getPropNo());
				eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
				eventResponse.setETCData("ctrt_pty_nm", list.get(0).getCtrtPtyNm());
				eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());
				eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt());
				eventResponse.setETCData("rfa_ctrt_tp_cd", list.get(0).getRfaCtrtTpCd());

				PriRpMnVO vo = new PriRpMnVO();
				vo.setPropNo(list.get(0).getPropNo());
				List<RsltCdListVO> list1 = command1.searchHistoryScopeList(vo);
				eventResponse.setRsVoList(list1);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2041 : RFA No. 입력 <BR>
	 * Amendment History Main Spot 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentHistoryMainSpot(Event e) throws EventException {
		EsmPri2041Event event = (EsmPri2041Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			List<RsltPriRpAmdHstMnVO> list = command1.searchAmendmentHistoryMainSpot(event.getPriRpHdrVO());

			if (list != null && list.size() != 0 && list.get(0) != null) {
				eventResponse.setETCData("prop_no", list.get(0).getPropNo());
				eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
				eventResponse.setETCData("ctrt_pty_nm", list.get(0).getCtrtPtyNm());
				eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());
				eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt());
				eventResponse.setETCData("rfa_ctrt_tp_cd", list.get(0).getRfaCtrtTpCd());

				PriRpMnVO vo = new PriRpMnVO();
				vo.setPropNo(list.get(0).getPropNo());
				List<RsltCdListVO> list1 = command1.searchHistoryScopeList(vo);
				eventResponse.setRsVoList(list1);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041 : Open<br>
	 * Amendment History Inquery 화면의 Combo Item 들을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse initAmendHistoryInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		List<RsltCdListVO> customData = null;
		try {
			customData = command.searchRfaTermTypeList(new RsltCdListVO());
			eventResponse.setCustomData("termType", customData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041 : Retrieve <BR>
	 * Amendment History Scope List 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentHistoryList(Event e) throws EventException {
		EsmPri2041Event event = (EsmPri2041Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			List<RsltAmdtHisMnVO> list = command1.searchAmendmentHistoryList(event.getCstShHistVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041 : sheet1_OnSelectCell <BR>
	 * Amend된 Terms 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHistoryAmendTermList(Event e) throws EventException {
		EsmPri2041Event event = (EsmPri2041Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			List<RsltPropScpAmdtSmryVO> list = command1.searchHistoryAmendTermList(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041 : sheet Click <BR>
	 * 각 Terms에 Amend된 정보가 있는 지 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmendmentHistorySummary(Event e) throws EventException {
		EsmPri2041Event event = (EsmPri2041Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPropScpAmdtSmryVO> list = command.searchAmendmentHistorySummary(event.getCstShHistVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_01 : SHEET1@FOCUS<br>
	 * Duration의 Amend History 를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204101Event event = (EsmPri204101Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRpDurHisVO> list = command.searchProposalDurationHistoryList(event.getPriRpScpDurVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_07 : Retrieve<br>
	 * RFA의 Amendment History 중에서 Affiliate 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204107Event event = (EsmPri204107Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {
			List<RsltAfilListVO> list = command.searchAffiliateHistoryList(event.getPriRpAfilVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_09 : Retrieve<br>
	 * Amendment History - Dem/Det List를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDEMDETExceptionHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204109Event event = (EsmPri204109Event) e;
		RFAProposalDEMDETBC command = new RFAProposalDEMDETBCImpl();

		try {
			List<RsltDmdtExptHisListVO> list = command.searchDEMDETExceptionHistoryList(event.getPriRpDmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_06 : Search <br>
	 * Arbitrary Amend History 리스트를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204106Event event = (EsmPri204106Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeHistoryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_204106 : Search <br>
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHistoryArbitraryFontStyle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204106Event event = (EsmPri204106Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2044 : Open<br>
	 * RFA Proposal 의 Copy 가능한 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCopyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2044Event event = (EsmPri2044Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltRfaPropCopyVO> list1 = command.searchProposalCopyAfilList(event.getRsltRfaPropCopyVO());
			List<RsltRfaPropCopyVO> list2 = command.searchProposalCopyList(event.getRsltRfaPropCopyVO());

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2044 : OK<br>
	 * RFA Proposal Main/Scope을 Copy 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyProposal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2044Event event = (EsmPri2044Event) e;
		RsltRfaPropCopyVO vo = event.getRsltRfaPropCopyVO();
		RsltRfaPropCopyVO[] spVos = event.getRsltRfaPropCopyVOs();

		if (spVos == null || spVos.length <= 0) {
			eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
			return eventResponse;
		}
		RsltRfaPropCopyVO[] baVos = event.getRsltPropCpBlplAfilListVOs();

		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAAffiliateProposalBC command3 = new RFAAffiliateProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command4 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAGroupLocationProposalBC command5 = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC command6 = new RFAGroupCommodityProposalBCImpl();
		RFANoteProposalBC command7 = new RFANoteProposalBCImpl();
		RFARateProposalBC command8 = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC command9 = new RFANoteConversionProposalBCImpl();
		RFAProposalDEMDETBC command10 = new RFAProposalDEMDETBCImpl();
		try {
			begin();
			String newPropNo = command1.searchMaxPropNo(account); // 생성된 prop_no
			if (JSPUtil.getNull(newPropNo).equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
				commit();
				return eventResponse;
			}

			vo.setNewPropNo(newPropNo);

			// PRI_RP_MN/PRI_RP_HDR/PRI_RP_AMDT_SMRY/PRI_RP_PROG COPY
			command1.copyProposalMain(vo, account);

			// PRI_RP_DMDT
			command10.copyProposalDemDet(vo, account);

			// PRI_RP_DUR
			command2.copyProposalDuration(vo, account);

			if (baVos != null && baVos.length == 1 && baVos[0] != null && baVos[0].getPropNo() != null) {
				baVos[0].setNewPropNo(newPropNo);

				if (JSPUtil.getNullNoTrim(baVos[0].getAfilChk()).equals("1")) {
					// PRI_RP_AFIL
					command3.copyProposalAffiliate(baVos[0], account);
				}
			}

			// PRI_RP_AMDT_SMRY UPDATE
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(newPropNo);
			priRpAmdtSmryVO.setAmdtSeq("0");
			command1.manageProposalAmendmentSummaryAll(priRpAmdtSmryVO, account);

			// Scope Copy
			if (spVos != null && spVos.length > 0) {
				for (int i = 0, n = spVos.length; i < n; i++) {
					spVos[i].setNewPropNo(newPropNo);
					spVos[i].setNewAmdtSeq("0");
					if (JSPUtil.getNullNoTrim(spVos[i].getScpChk()).equals("1")) {
						command1.copyProposalScopeMain(spVos[i], account);
						command2.copyProposalScopeDuration(spVos[i], account);
					} else {
						continue;
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getLocaChk()).equals("1")) {
						// Group Location
						command5.copyProposalScopeLocation(spVos[i], account);
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getCmdtChk()).equals("1")) {
						// Group Commodity
						command6.copyProposalScopeCommodity(spVos[i], account);
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getSpntChk()).equals("1")) {
						// Special Note
						command7.copyProposalScopeNote(spVos[i], account);
						// Note Conversion
						command9.copyProposalRfaNoteConversion(spVos[i], account);
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getRateChk()).equals("1")) {
						// Rate
						command8.copyProposalScopeRate(spVos[i], account);
						// Note Conversion
						command9.copyProposalRoutNoteConversion(spVos[i], account);
						command9.copyProposalCmdtNoteConversion(spVos[i], account);
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getArorChk()).equals("1")) {
						// Arbitrary Origin
						spVos[i].setAddChgTpCd("A");
						spVos[i].setOrgDestTpCd("O");
						command4.copyProposalScopeTransport(spVos[i], account);
					}

					if (JSPUtil.getNullNoTrim(spVos[i].getArdeChk()).equals("1")) {
						// Arbitrary Destination
						spVos[i].setAddChgTpCd("A");
						spVos[i].setOrgDestTpCd("D");
						command4.copyProposalScopeTransport(spVos[i], account);
					}
				}
			}
			// PRI_RP_SCP_AMDT_SMRY UPDATE
			command1.copyProposalScopeAmdtSmry(spVos, account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00110").getUserMessage());
			eventResponse.setETCData("newPropNo", newPropNo);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2007 : Open<br>
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationList(Event e) throws EventException {
		ComOrganizationVO paramVo = new ComOrganizationVO();
		EsmPri2007Event event = (EsmPri2007Event) e;
		paramVo = event.getComOrganizationVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<ComOrganizationVO> list = command.searchOrganizationList(paramVo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2007 : Send<br>
	 * Proposal Request 정보를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalRequestMessage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2007Event event = (EsmPri2007Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			begin();
			command.manageProposalRequestMessage(event.getPriRpAproRqstRefUsrVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2049 : Retrieve<br>
	 * RFA 승인을 위해 신청하거나 접수한 Proposal Request 를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestList(Event e) throws EventException {
		RsltRfaAproRqstRefVO paramVo = new RsltRfaAproRqstRefVO();
		EsmPri2049Event event = (EsmPri2049Event) e;
		paramVo = event.getRsltRfaAproRqstRefVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltRfaAproRqstRefVO> list = command.searchProposalRequestList(paramVo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2054 : Retrieve<br>
	 * RFA 승인을 위해 신청하거나 접수한 Proposal Request 를 [Office 대상]으로 관리할 수 있도록 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestByOfficeList(Event e) throws EventException {
		RsltRfaAproRqstRefByOfcVO paramVo = new RsltRfaAproRqstRefByOfcVO();
		EsmPri2054Event event = (EsmPri2054Event) e;
		paramVo = event.getRsltRfaAproRqstRefByOfcVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltRfaAproRqstRefByOfcVO> list = command.searchProposalRequestByOfficeList(paramVo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2019 : Retrive <br>
	 * Proposal Main Inquiry List 를 조회합니다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2019Event event = (EsmPri2019Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPriRpInqVO> list = command.searchProposalMainInquiryList(event.getCstShRInqVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2119 : Retrive <br>
	 * Proposal Main Spot Inquiry List 를 조회합니다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainSpotInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2019Event event = (EsmPri2019Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPriRpInqVO> list = command.searchProposalMainSpotInquiryList(event.getCstShRInqVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2019 : sheet0_OnSelectCell<br>
	 * RFA Proposal Main Inquiry 를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2019Event event = (EsmPri2019Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			RsltPropInqListVO vo = command.searchProposalMainInquiry(event.getPriRpMnVO(), account);

			eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2019 : sheet0_OnSelectCell<br>
	 * RFA Proposal Main Inquiry 를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainSpotInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2019Event event = (EsmPri2019Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			RsltPropInqListVO vo = command.searchProposalMainSpotInquiry(event.getPriRpMnVO(), account);

			eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2019 : sheet2_OnSelectCell<br>
	 * RFA Proposal Inquiry Scope Terms의 Amendment Summary 를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeAmendmentSummaryInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2019Event event = (EsmPri2019Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummaryInquiry(event.getPriRpScpAmdtSmryVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2019 : Open<br>
	 * Proposal& Amendment Inquery 화면의 Combo Item 들을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initProposalInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> scopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("scopeList", scopeList);
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02394", 0);
			eventResponse.setCustomData("stsList", stsList);
			ArrayList<CodeInfo> rfaCtrtTpList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03264", 0);
			eventResponse.setCustomData("rfaCtrtTpList", rfaCtrtTpList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2019 : Customer<br>
	 * Customer Country Code와 Customer Seq로 Customer 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCustomerInfoInquiry(Event e) throws EventException {
		PriSpCtrtPtyVO paramVo = new PriSpCtrtPtyVO();
		EsmPri2019Event event = (EsmPri2019Event) e;
		paramVo = event.getPriSpCtrtPtyVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfoInquiry(paramVo);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Main Accept 시 <br>
	 * Main Duration Accept시 메인과 exp_dt가 같은 Scope을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationAcceptCount(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		try {
			List<RsltCdListVO> list = command.searchProposalDurationAcceptCount(event.getPriRpDurVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initDurComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02198", 0);
			eventResponse.setCustomData("srcInfoList", srcInfoList);
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("stsList", stsList);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Cancel(Approve) <br>
	 * Approve Cancel시 BKG에 데이터가 있는지 조회한다.<br>
	 * 데이터가 있다면 Cancel 할 수 없다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalCancelCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> list = command.searchApprovalCancelCheck(event.getCstApprovalVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_06 : Retrieve <br>
	 * Affiliate Inquiry를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201906Event event = (EsmPri201906Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {
			List<PriRpAfilInqVO> list = command.searchAffiliateInquiryList(event.getPriRpAfilVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_06 : loadPage() <br>
	 * DEM/DET 에서 호출시 Proposal No.로 기본정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateHeader(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201906Event event = (EsmPri201906Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {

			List<RsltPriRpAfilHdrVO> list = command.searchAffiliateHeader(event.getPriRpMnVO());

			if (list != null && list.size() != 0 && list.get(0) != null) {
				eventResponse.setETCData("rfa_no", list.get(0).getRfaNo());
				eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
				eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());
				eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_04 : Search <br>
	 * Arbitrary Inquiry List를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201904Event event = (EsmPri201904Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeInquiryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_04 : Search <br>
	 * RFA Proposal Creation - Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkArbitraryInquiryFontStyle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201904Event event = (EsmPri201904Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2080 : Open <br>
	 * Guideline Copy 화면에서 Scope Name 을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineCopySvcScpName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2080Event event = (EsmPri2080Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		RpScpGlineCopyVO vo = event.getRpScpGlineCopyVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (vo != null) {
				String svcScpNm = command.searchServiceScopeCodeDetailName(vo.getSvcScpCd());
				eventResponse.setCustomData("svcScpNm", svcScpNm);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2080 : Open <br>
	 * Guideline Copy 대상 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineCopyCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2080Event event = (EsmPri2080Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();

		try {
			List<RpScpGlineCopyVO> list = command.searchGuidelineCopyCheck(event.getRpScpGlineCopyVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2080 : OK <br>
	 * Guideline을 Proposal로 Copy합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyScopeGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2080Event event = (EsmPri2080Event) e;
		RpScpGlineCopyVO[] vos = event.getRpScpGlineCopyVOS();

		if (vos == null || vos.length <= 0) {
			eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
			return eventResponse;
		}
		RpScpGlineCopyVO vo = vos[0];

		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFAGroupLocationProposalBC command2 = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC command3 = new RFAGroupCommodityProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command4 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFARateProposalBC command6 = new RFARateProposalBCImpl();

		try {
			String glineSeq = command1.searchCopyGlineSeq(vo); // Copy 대상의 gline_seq
			if (JSPUtil.getNull(glineSeq).equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
				return eventResponse;
			}
			begin();

			vo.setGlineSeq(glineSeq);
			if (JSPUtil.getNullNoTrim(vo.getLocChk()).equals("1")) {
				// PRI_RP_SCP_GRP_LOC/PRI_SP_SCP_GRP_LOC_DTL
				command2.copyScopeGuidelineGrpLoc(vo, account);
			}

			if (JSPUtil.getNullNoTrim(vo.getCmdtChk()).equals("1")) {
				command3.copyScopeGuidelineGrpCmdt(vo, account);
			}

			vo.setOrgDestTpCd("O");
			if (JSPUtil.getNullNoTrim(vo.getArbOrgChk()).equals("1")) {
				command4.copyScopeGuidelineArbitrary(vo, account);
			}

			vo.setOrgDestTpCd("D");
			if (JSPUtil.getNullNoTrim(vo.getArbDesChk()).equals("1")) {
				command4.copyScopeGuidelineArbitrary(vo, account);
			}

			if (JSPUtil.getNullNoTrim(vo.getRateChk()).equals("1")) {
				command6.copyScopeGuidelineRate(vo, account);
			}

			// PRI_RP_SCP_AMDT_SMRY UPDATE
			command1.copyScopeGuidelineScopeAmdtSmry(vo, account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Search <BR>
	 * PRS CM Data를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainPRSCMData(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();

		try {
			List<RsltRfaPRSCMDataVO> list = command.searchProposalMainPRSCMData(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : 각 Terms에서 호출<br>
	 * Terms가 Summary 를 변경 후 메인의 상태를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltRfaMainStsVO> list = command.searchProposalMainStatus(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeCalculate(Event e) throws EventException {
		log.debug("RFA executeCalculate == executeCalculate == executeCalculate == executeCalculate == executeCalculate");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String prsBatId = "";
		boolean isTransactionStart = false;

		try {
			// property 읽어 오기
			String rCnt = SubSystemConfigFactory.get("PRI.RFA.ROTATION.CNT");
			int iRCnt = 20;
			if (rCnt != null) {
				iRCnt = Integer.valueOf(rCnt);
			}

			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriRpScpRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);

			// pri_Prs_Bat table에 데이터가 있을경우
			if (prsBatchVO != null) {
				String status = command.monitorCalculate(prsBatchVO);

				if ("0".equals(status) // Nothing 아직 상태모름
						|| "1".equals(status) // running
						|| "8".equals(status) // INACTIVE 실행대기
						|| "12".equals(status)// QUE_WAIT 로드밸런싱 대기
				) {
					// 이미 실행중이라면 에러 처리한다.
					throw new EventException(new ErrorHandler("PRI03019", new String[] { account.getUsr_id() }).getMessage());
				}
			}

			// batch 프로그램 명을 rotation 하기 위한 작업 시작
			PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
			updatePriPrsBatVO.setPgmNo("ESM_PRI_T002");
			updatePriPrsBatVO.setPrsBatId(String.valueOf(iRCnt));
			begin();
			comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
			commit();
			PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation(updatePriPrsBatVO);
			String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
			log.debug("rotationPrsBatId====>" + rotationPrsBatId);
			// batch 프로그램 명을 rotation 하기 위한 작업 종료

			priPrsBatVO = command.executeCalculate(event.getPriRpScpRtCmdtRoutVO(), rotationPrsBatId, account);

			if (priPrsBatVO != null) {
				begin();
				isTransactionStart = true;
				comCommand.addPrsBatch(priPrsBatVO, account);
				prsBatId = priPrsBatVO.getPrsBatId();
				commit();
			}

			eventResponse.setETCData("JOB_ID", prsBatId);

		} catch (EventException ex) {
			if (isTransactionStart) {
				rollback();
			}
			throw ex;
		} catch (Exception ex) {
			if (isTransactionStart) {
				rollback();
			}
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch의 실행 상태를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorCalculate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String batchId = "";

		try {
			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriRpScpRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
			String status = command.monitorCalculate(prsBatchVO);

			if (prsBatchVO != null) {
				batchId = prsBatchVO.getPrsBatId();
				
				// SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
				if ("4".equals(status)) {
					// null도 success로 간주한다.
					if (prsBatchVO.getPrsBatErrVal() != null && prsBatchVO.getPrsBatErrVal().length() != 0 && !"0".equals(prsBatchVO.getPrsBatErrVal())) {// SUCCESS가 아니면
						// FAIL처리
						status = "90";
					}
				}

			}
			eventResponse.setETCData("JOB_ID", batchId);
			eventResponse.setETCData("BATCH_STATUS", status);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조건에 일치하는 최대 Commmodity Header Sequence를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxCmdtHdrSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200308Event event = (EsmPri200308Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			String maxCmdtHdrSeq = command.searchMaxCmdtHdrSeq(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setETCData("cmdt_hdr_seq", maxCmdtHdrSeq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Local FIC Guide Line RT Amount를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalFicGlineRtAmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200308Event event = (EsmPri200308Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			String localAmt = command.searchLocalFicGlineRtAmt(event.getPriRpScpRtVO());
			eventResponse.setETCData("local_fic_gline_rt_amt", localAmt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Load Page <br>
	 * 기본 Code List를 초기화한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initArbitraryComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		PRICommonBC command = new PRICommonBCImpl();

		CodeUtil cdUtil = CodeUtil.getInstance();

		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;

		try {
			// Trans Mode
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			eventResponse.setCustomData("prcTrspModCd", codeInfos);

			// Rating Unit Code
			customData = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);

			// Currency Code
			customData = command.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);

			// Cargo Type Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			eventResponse.setCustomData("prcCgoTpCd", codeInfos);

			// Source Info Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD02198", 0);
			eventResponse.setCustomData("srcInfoCd", codeInfos);

			// Proposal Status Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("prcProgStsCd", codeInfos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Load Page <br>
	 * 기본 Code List를 초기화한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initDEMDETComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodeUtil cdUtil = CodeUtil.getInstance();
		List<CodeInfo> codeInfos = null;

		try {
			// Demdet
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01704", 0);
			eventResponse.setCustomData("dmdtFtTpCd", codeInfos);

			// Source Info Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD02198", 0);
			eventResponse.setCustomData("srcInfoCd", codeInfos);

			// Proposal Status Code
			codeInfos = (List<CodeInfo>) cdUtil.getCodeSelect("CD01719", 0);
			eventResponse.setCustomData("prcProgStsCd", codeInfos);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Cancel<br>
	 * 작성자가 Request Cancel시 Accept, Returned 데이터가 있는지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestCancelCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CstRequestCheckVO> list = command.searchProposalRequestCancelCheck(event.getPriRpMnVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6087 : Search <br>
	 * Surcharge View All 을 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeViewAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6087Event event = (EsmPri6087Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			List<RsltPriSurchargeViewAllVO> list = command.searchSurchargeViewAllList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltPriSurchargeLastAccessDateVO> accessList = command.searchSurchargeLastAccessDateList(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setRsVoList(list);

			String accessDate = "";
			if (accessList.size() > 0) {
				accessDate = accessList.get(0).getCreYmd();
			}
			eventResponse.setETCData("access_date", accessDate);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6091:onPlageLoad, Request<br>
	 * Target MVC estimate Popup의 List를 조회한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckMQCEstimateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6091Event event = (EsmPri6091Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltCheckMQCEstimateVO> list = command.searchCheckMQCEstimateList(event.getInPrsMQCEstimateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6091:onPlageLoad, Request<br>
	 * Target MVC estimate Popup의 List를 조회한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMQCEstimateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6091Event event = (EsmPri6091Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltMQCEstimateVO> list = command.searchMQCEstimateList(event.getInPrsMQCEstimateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6091:onPlageLoad, Request<br>
	 * Target MQC estimate 를 갱신한다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMQCEstimateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6091Event event = (EsmPri6091Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();

		try {
			begin();
			command.manageMQCEstimateList(event.getPriRpScpMnVOS(), account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2020 : Onload<br>
	 * RFA Proposal Main Inquiry 를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainViewInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2020Event event = (EsmPri2020Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if ("".equals(event.getPriRpMnVO().getPropNo())) {
				PriRpHdrVO priRpHdrVO = command.searchProposalNoFromRfaNo(event.getPriRpHdrVO());
				if (priRpHdrVO != null && !"".equals(priRpHdrVO.getPropNo())) {
					event.getPriRpMnVO().setPropNo(priRpHdrVO.getPropNo());
				}
			}
			RsltPropInqListVO vo = command.searchProposalMainInquiry(event.getPriRpMnVO(), account);
			eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2120 : Onload<br>
	 * RFA Proposal Main Spot Inquiry 를 조회한다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMainViewSpotInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2020Event event = (EsmPri2020Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if ("".equals(event.getPriRpMnVO().getPropNo())) {
				PriRpHdrVO priRpHdrVO = command.searchProposalNoFromRfaNo(event.getPriRpHdrVO());
				if (priRpHdrVO != null && !"".equals(priRpHdrVO.getPropNo())) {
					event.getPriRpMnVO().setPropNo(priRpHdrVO.getPropNo());
				}
			}
			RsltPropInqListVO vo = command.searchProposalMainSpotInquiry(event.getPriRpMnVO(), account);
			eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2020 : sheet2_OnSelectCell<br>
	 * RFA Proposal Inquiry Scope Terms의 Amendment Summary 를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeAmendmentSummaryViewInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2020Event event = (EsmPri2020Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummaryInquiry(event.getPriRpScpAmdtSmryVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_05 : sheet2_OnChange<br>
	 * Guide Line을 이용하여 FIC Base Port List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICBasePortListByGLine(Event e) throws EventException {
		EsmPri200305Event event = (EsmPri200305Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGLineVO> list = command.searchFICBasePortListByGLine(event.getFicRouteGLineVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_05 : sheet2_OnChange<br>
	 * Guide Line 상의 Route 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteByGLine(Event e) throws EventException {
		EsmPri200305Event event = (EsmPri200305Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGLineVO> list = command.searchFICRouteByGLine(event.getFicRouteGLineVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_05 : sheet2_OnChange<br>
	 * Route 정보를 이용하여 Guide Line 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGLineInfoByFICRoute(Event e) throws EventException {
		EsmPri200305Event event = (EsmPri200305Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<GLineInfoByFICRouteVO> list = command.searchGLineInfoByFICRoute(event.getGLineInfoByFICRouteVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2029 : Guideline Route Search Pop-Up<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchGuidelineRoutePopupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2029Event event = (EsmPri2029Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.searchGuidelineRoutePopupList(event.getSearchGuidelineRouteInquiryVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_200308 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateFontStyle(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200308Event event = (EsmPri200308Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2028 : sheet_OnChange<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteGroup(Event e) throws EventException {
		EsmPri2028Event event = (EsmPri2028Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGroupVO> list = command.searchFicRouteGroup(event.getFicRouteGroupVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2028 : sheet location change<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCYPortLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2028Event event = (EsmPri2028Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltFicCheckCYPortLocationVO> list = command.checkCYPortLocationCode(event.getFicCheckCYPortLocationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2067 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVerticalForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2067Event event = (EsmPri2067Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelVerticalForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAeeAewVOs());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2067 : Check<br>
	 * Load된 엑셀 데이터의 FIC Rate값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFicGuidelineRateForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2067Event event = (EsmPri2067Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltFicGuidelineRateVO> vos = command.searchFicGuidelineRateForAeeAew(event.getFicRateLoadExcelGuidelineCheckVO(),
					event.getFicRateLoadExcelGuidelineCheckVOs());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2067 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2067Event event = (EsmPri2067Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadRateExcelVerticalForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAeeAewVOs(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2067 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalOnlineForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2067Event event = (EsmPri2067Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();

			command.uploadRateExcelVerticalOnlineForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAeeAewVOs(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2067 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVerticalForAeeAew(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCdList", currCdList);

			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2068 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontalForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2068Event event = (EsmPri2068Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelHorizontalForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalLoadExcelForAeeAewVOs());

			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2068 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2068Event event = (EsmPri2068Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadRateExcelHorizontalForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalLoadExcelForAeeAewVOs(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2068 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalOnlineForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2068Event event = (EsmPri2068Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.uploadRateExcelHorizontalOnlineForAeeAew(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalLoadExcelForAeeAewVOs(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2068 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontalForAeeAew(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_08 : Open<br>
	 * Rate Inquiry - Commodity Group을 조회한다. (For AEE/AEW) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityInquiryListForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201908Event event = (EsmPri201908Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityInquiryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_08 : Sheet1.Select<br>
	 * Rate Inquiry - Route 리스트를 조회한다. (For AEE/AEW) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteInquiryListForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201908Event event = (EsmPri201908Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrInquiryListVO> vos = command.searchRateRouteInquiryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_08 : Sheet2.Select<br>
	 * Rate Inquiry - Rate 정보를 조회한다. (For AEE/AEW) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryListForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201908Event event = (EsmPri201908Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateInquiryList(event.getPriRpScpRtVO());

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_08 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateInquiryFontStyleForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201908Event event = (EsmPri201908Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2019_09 : Search <br>
	 * Arbitrary Inquiry List를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeInquiryListForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201909Event event = (EsmPri201909Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeInquiryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_09 : Search <br>
	 * RFA Proposal Creation - Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkArbitraryInquiryFontStyleForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201909Event event = (EsmPri201909Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_10 : Open<br>
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityHistoryListForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204110Event event = (EsmPri204110Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityHistoryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_10 : Sheet1.Select<br>
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteHistoryListForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204110Event event = (EsmPri204110Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteHistoryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_10 : Sheet2.Select<br>
	 * Rate History - Rate 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateHistoryListForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204110Event event = (EsmPri204110Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO(), false);

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_10 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateHistoryFontStyleForAeeAew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204110Event event = (EsmPri204110Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkHistoryFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2041_11 : Search <br>
	 * Arbitrary Amend History 리스트를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeHistoryListForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204111Event event = (EsmPri204111Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeHistoryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_11 : Search <br>
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. (For AEE/AEW)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHistoryArbitraryFontStyleForAeeAew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204111Event event = (EsmPri204111Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2051 : OPEN <br>
	 * 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonUploadArbitraryChargeProposalForIHC(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2051Event event = (EsmPri2051Event) e;

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// TRANS MODE
			vo.setCd("CD01720");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);

			// TERM CODE
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("O")) {
				vo.setCd("CD02070");
			} else {
				vo.setCd("CD02071");
			}
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RCV_DE_TERM_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_CGO_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			// list = command.searchAllPerCodeList(vo);
			list = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// ACTUAL CUSTOMER
			vo.setPropNo(event.getRsltPriRpScpArbKeyVO().getPropNo());
			vo.setAmdtSeq(event.getRsltPriRpScpArbKeyVO().getAmdtSeq());
			vo.setSvcScpCd(event.getRsltPriRpScpArbKeyVO().getSvcScpCd());
			vo.setEtc1("");
			vo.setEtc2("");
			list = command.searchRFAActualCustomerList(vo);
			eventResponse.setCustomData("CUST_DEF_CD", list);

			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_O.xls");
			}
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2051 : SAVE<br>
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeProposalForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2051Event event = (EsmPri2051Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeProposalForIHC(event.getPriRpScpTrspAddChgVOs(), account);

			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOs()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOs()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOs()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);

			// 저장성공
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2051 : CHECK<br>
	 * 엑셀파일를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResultForIHC(Event e) throws EventException {
		EsmPri2051Event event = (EsmPri2051Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRpScpTrspAddChgVO> list = command.searchCodeCheckResult(event.getRsltPriRpScpTrspAddChgVOs());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Open<br>
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationHeaderListForIHC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Sheet1.Select<br>
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationListForIHC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Save<br>
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGRICalculationForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();

		try {
			begin();
			command.manageGRICalculationForIHC(event.getRfaGriCalcVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Apply<br>
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyGRICalculationForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.applyGRICalculationForIHC(event.getPriRpScpGriGrpVO(), event.getCheckGRICalculationValidationVOs(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Apply Cancel<br>
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGRICalculationForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelGRICalculationForIHC(event.getPriRpScpGriGrpVO(), event.getCheckGRICalculationValidationVOs(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2035 : Check Validation<br>
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGRICalculationValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2035Event event = (EsmPri2035Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkGRICalculationValidation(event.getPriRpScpGriGrpVO(), account));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리시 Rate(AEE/AEW)의 FIC_PROP_RT_AMT값이 O인 값이 존재하는지 체크<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestIhcRateCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			eventResponse.setETCData("RSLT", String.valueOf(command.searchProposalRequestIhcRateCheck(event.getPriRpMnVO())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestPortCyCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltCdListVO> list = command.searchProposalRequestPortCyCheck(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Hinterland 2차 프로젝트(2012.09.20) Start
	 */

	/**
	 * ESM_PRI_200313 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateFontStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조건에 일치하는 최대 Commmodity Header Sequence를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxCmdtHdrSeqForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			String maxCmdtHdrSeq = command.searchMaxCmdtHdrSeq(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setETCData("cmdt_hdr_seq", maxCmdtHdrSeq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Local FIC Guide Line RT Amount를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalFicGlineRtAmtForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			String localAmt = command.searchLocalFicGlineRtAmt(event.getPriRpScpRtVO());
			eventResponse.setETCData("local_fic_gline_rt_amt", localAmt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2030 : Accept<br>
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptFicRateRoutePntViaForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2030Event event = (EsmPri2030Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		String smrtString = "71";
		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smrtString = "73"; // ihc rate
			}
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptAutoRateRouteViaDetail(viaVO, account);
				}

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutDestPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutDestPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutDestPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptAutoRateRouteViaDetail(viaVO, account);
				}
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2030 : Accept Cancel<br>
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelFicRateRoutePntViaForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2030Event event = (EsmPri2030Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		String smrtString = "71";
		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smrtString = "73"; // ihc rate
			}
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptCancelAutoRateRouteViaDetail(viaVO, account);
				}
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				if ("A".equals(hdrVO.getFicRtTpCd())) { // 만약 IHC rate라면 VIA도 같이 넣어준다.
					// if(hdrVO.getSvcScpCd().equals("AEE")){//Origin
					PriRpScpRtRoutViaVO viaVO = new PriRpScpRtRoutViaVO();
					viaVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
					viaVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
					viaVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
					viaVO.setCmdtHdrSeq(event.getPriRpScpRtRoutDestPntVO()[0].getCmdtHdrSeq());
					viaVO.setRoutSeq(event.getPriRpScpRtRoutDestPntVO()[0].getRoutSeq());
					viaVO.setOrgDestTpCd(event.getPriRpScpRtRoutDestPntVO()[0].getOrgDestTpCd());
					// 모든 VIA를 UPDATE한다.
					command.acceptCancelAutoRateRouteViaDetail(viaVO, account);
				}
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);

				PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
				smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
				smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
				smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd(smrtString);
				cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2030 : sheet_OnChange<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteGroupForAddOnTariff(Event e) throws EventException {
		EsmPri2030Event event = (EsmPri2030Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGroupVO> list = command.searchFicRouteGroup(event.getFicRouteGroupVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2030 : sheet location change<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCYPortLocationForAddOnTariff(Event e) throws EventException {
		EsmPri2030Event event = (EsmPri2030Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltFicCheckCYPortLocationVO> list = command.checkCYPortLocationCode(event.getFicCheckCYPortLocationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_12 : sheet2_OnChange<br>
	 * Guide Line을 이용하여 FIC Base Port List를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICBasePortListForAddOnTariff(Event e) throws EventException {
		EsmPri200312Event event = (EsmPri200312Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGLineVO> list = command.searchFICBasePortListByGLine(event.getFicRouteGLineVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_12 : sheet2_OnChange<br>
	 * Guide Line 상의 Route 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteForAddOnTariff(Event e) throws EventException {
		EsmPri200312Event event = (EsmPri200312Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGLineVO> list = command.searchFICRouteByGLine(event.getFicRouteGLineVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_12 : sheet2_OnChange<br>
	 * Route 정보를 이용하여 Guide Line 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGLineInfoByFICRouteForAddOnTariff(Event e) throws EventException {
		EsmPri200312Event event = (EsmPri200312Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<GLineInfoByFICRouteVO> list = command.searchGLineInfoByFICRoute(event.getGLineInfoByFICRouteVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2069 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2069Event event = (EsmPri2069Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelVerticalForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAddOnTariffVOs());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2069 : Check<br>
	 * Load된 엑셀 데이터의 FIC Rate값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFicGuidelineRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2069Event event = (EsmPri2069Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFicGuidelineRateForAddOnTariff(event.getFicRateLoadExcelGuidelineCheckVO(),
					event.getFicRateLoadExcelGuidelineCheckVOs(), event.getInOrgDestTpCd()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2069 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2069Event event = (EsmPri2069Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			begin();
			String key = command.uploadRateExcelVerticalForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAddOnTariffVOs(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2069 : Check<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalOnlineForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2069Event event = (EsmPri2069Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();

			command.uploadRateExcelVerticalOnlineForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelForAddOnTariffVOs(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2069 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCdList", currCdList);

			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_New_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2070 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2070Event event = (EsmPri2070Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command
					.checkRateExcelHorizontalForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelForAddOnTariffVOs());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2070 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2070Event event = (EsmPri2070Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			begin();
			String key = command.uploadRateExcelHorizontalForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelForAddOnTariffVOs(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2070 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalOnlineForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2070Event event = (EsmPri2070Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		try {
			begin();

			command.uploadRateExcelHorizontalOnlineForAddOnTariff(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelForAddOnTariffVOs(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2070 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_New_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2053 : SAVE<br>
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeProposalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2053Event event = (EsmPri2053Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeProposalForIHC(event.getPriRpScpTrspAddChgVOs(), account);

			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
			priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOs()[0].getPropNo());
			priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOs()[0].getAmdtSeq());
			priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOs()[0].getSvcScpCd());
			if ("O".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
			} else if ("D".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
				priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
			}

			command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);

			// 저장성공
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2053 : CHECK<br>
	 * 엑셀파일를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResultForAddOnTariff(Event e) throws EventException {
		EsmPri2053Event event = (EsmPri2053Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltPriRpScpTrspAddChgVO> list = command.searchCodeCheckResult(event.getRsltPriRpScpTrspAddChgVOs());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2053 : OPEN <br>
	 * 화면로딩시 콤보정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonUploadArbitraryChargeProposalForAddOnTariff(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2053Event event = (EsmPri2053Event) e;

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;

		try {
			// //////////////////COMMON - START/////////////////////
			// TRANS MODE
			vo.setCd("CD01720");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);

			// TERM CODE
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("O")) {
				vo.setCd("CD02070");
			} else {
				vo.setCd("CD02071");
			}
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RCV_DE_TERM_CD", list);

			// CARGO TYPE
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_CGO_TP_CD", list);
			// ////////////////////COMMON - END///////////////////////

			// PER TYPE
			// list = command.searchAllPerCodeList(vo);
			list = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("RAT_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// ACTUAL CUSTOMER
			vo.setPropNo(event.getRsltPriRpScpArbKeyVO().getPropNo());
			vo.setAmdtSeq(event.getRsltPriRpScpArbKeyVO().getAmdtSeq());
			vo.setSvcScpCd(event.getRsltPriRpScpArbKeyVO().getSvcScpCd());
			vo.setEtc1("");
			vo.setEtc2("");
			list = command.searchRFAActualCustomerList(vo);
			eventResponse.setCustomData("CUST_DEF_CD", list);

			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if (event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("RP_Arb_New_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("RP_Arb_New_Templet_O.xls");
			}
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Sheet1.Save<br>
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCommodityForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeCommodity(event.getRfaRtPropCmdtVO(), account);
			command.manageRateCommodity(event.getRfaRtPropCmdtVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
			scpMnVO.setPropNo(event.getPropNo());
			scpMnVO.setAmdtSeq(event.getAmdtSeq());
			scpMnVO.setSvcScpCd(event.getSvcScpCd());
			cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
			cmdMain.updatePrsMBFlgOnSaveRt(scpMnVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Sheet3.Save<br>
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeRoute(event.getRfaRtPropRtVO(), account);
			command.manageRateForAddOnTariff(event.getRfaRtPropRtVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
			scpMnVO.setPropNo(event.getPropNo());
			scpMnVO.setAmdtSeq(event.getAmdtSeq());
			scpMnVO.setSvcScpCd(event.getSvcScpCd());
			cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
			cmdMain.updatePrsMBFlgOnSaveRt(scpMnVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Open<br>
	 * Rate의 Commodity Group을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriRpScpRtCmdtHdrVO());
			String maxBletDpSeq = command.getMaxOldBulletDispSeq(event.getPriRpScpRtCmdtHdrVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("max_blet_dp_seq", maxBletDpSeq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Sheet1.Select<br>
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Sheet2.Select<br>
	 * Rate 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO(), true);
			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
			eventResponse.setRsVoList(vo.getRsltFicRateByRouteVO().get("O"));
			eventResponse.setRsVoList(vo.getRsltFicRateByRouteVO().get("D"));

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeCalculateForAddOnTariff(Event e) throws EventException {
		log.debug("RFA executeCalculate == executeCalculate == executeCalculate == executeCalculate == executeCalculate");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String prsBatId = "";
		boolean isTransactionStart = false;

		try {
			// property 읽어 오기
			String rCnt = SubSystemConfigFactory.get("PRI.RFA.ROTATION.CNT");
			int iRCnt = 20;
			if (rCnt != null) {
				iRCnt = Integer.valueOf(rCnt);
			}

			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriRpScpRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);

			// pri_Prs_Bat table에 데이터가 있을경우
			if (prsBatchVO != null) {
				String status = command.monitorCalculate(prsBatchVO);

				if ("0".equals(status) // Nothing 아직 상태모름
						|| "1".equals(status) // running
						|| "8".equals(status) // INACTIVE 실행대기
						|| "12".equals(status)// QUE_WAIT 로드밸런싱 대기
				) {
					// 이미 실행중이라면 에러 처리한다.
					throw new EventException(new ErrorHandler("PRI03019", new String[] { account.getUsr_id() }).getMessage());
				}
			}

			// batch 프로그램 명을 rotation 하기 위한 작업 시작
			PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
			updatePriPrsBatVO.setPgmNo("ESM_PRI_T002");
			updatePriPrsBatVO.setPrsBatId(String.valueOf(iRCnt));
			begin();
			comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
			commit();
			PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation(updatePriPrsBatVO);
			String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
			log.debug("rotationPrsBatId====>" + rotationPrsBatId);
			// batch 프로그램 명을 rotation 하기 위한 작업 종료

			priPrsBatVO = command.executeCalculate(event.getPriRpScpRtCmdtRoutVO(), rotationPrsBatId, account);

			if (priPrsBatVO != null) {
				begin();
				isTransactionStart = true;
				comCommand.addPrsBatch(priPrsBatVO, account);
				prsBatId = priPrsBatVO.getPrsBatId();
				commit();
			}

			eventResponse.setETCData("JOB_ID", prsBatId);

		} catch (EventException ex) {
			if (isTransactionStart) {
				rollback();
			}
			throw ex;
		} catch (Exception ex) {
			if (isTransactionStart) {
				rollback();
			}
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch의 실행 상태를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorCalculateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String batchId = "";

		try {
			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriRpScpRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
			String status = command.monitorCalculate(prsBatchVO);

			if (prsBatchVO != null) {
				batchId = prsBatchVO.getPrsBatId();
				
				// SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
				if ("4".equals(status)) {
					if (prsBatchVO.getPrsBatErrVal() != null && prsBatchVO.getPrsBatErrVal().length() != 0 && !"0".equals(prsBatchVO.getPrsBatErrVal())) {// SUCCESS가 아니면
						status = "90";
					}
				}

			}
			eventResponse.setETCData("JOB_ID", batchId);
			eventResponse.setETCData("BATCH_STATUS", status);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Down Excel<br>
	 * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcelForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			if ("A".equals(event.getFicRtTpCd())) {
				List<RsltRtListVerticalExcelForAddOnTariffVO> vos = command.searchRateListVerticalExcelForAddOnTariff(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			} else {
				List<RsltRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Down Excel<br>
	 * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcelForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			if ("A".equals(event.getFicRtTpCd())) {
				List<RsltRtListHorizontalExcelForAddOnTariffVO> vos = command.searchRateListHorizontalExcelForAddOnTariff(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			} else {
				List<RsltRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriRpScpRtCmdtHdrVO());
				eventResponse.setRsVoList(vos);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Accept<br>
	 * Rate 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Accept Cancel<br>
	 * Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Accept Cancel<br>
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			command.cancelAllRate(event.getPriRpScpRtVO(), hdrVO.getFicRtTpCd(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtVO().getSvcScpCd());
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73"); // ihc rate
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Guideline Copy<br>
	 * Guideline의 데이터를 복사해온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.copyGuidelineRate(event.getRfaGlineCopyVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getRfaGlineCopyVO().getPropNo());
			smryVO.setAmdtSeq(event.getRfaGlineCopyVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getRfaGlineCopyVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : Guideline Copy<br>
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGlineCopyGroupCodeExistForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltCdListVO vo = command.checkGlineCopyGroupCodeExist(event.getRfaGlineCopyVO());
			List<RsltCdListVO> vos = new ArrayList<RsltCdListVO>();
			vos.add(vo);
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_13 : OnSaveEnd<br>
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmdtRoutStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200313Event event = (EsmPri200313Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtCmdtRoutListVO vo = command.searchRateCmdtRoutStyle(event.getPriRpScpRtCmdtHdrVO(), event.getPriRpScpRtCmdtRoutVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutHdrListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Open<br>
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationHeaderListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Sheet1.Select<br>
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGRICalculationListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Save<br>
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGRICalculationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			begin();
			command.manageGRICalculationForIHC(event.getRfaGriCalcVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Apply<br>
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyGRICalculationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.applyGRICalculationForAddOnTariff(event.getPriRpScpGriGrpVO(), event.getCheckGRICalculationValidationVOs(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Check Validation<br>
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGRICalculationValidationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkGRICalculationValidationForAddOnTariff(event.getPriRpScpGriGrpVO(), account));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2037 : Apply Cancel<br>
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGRICalculationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2037Event event = (EsmPri2037Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelGRICalculationForAddOnTariff(event.getPriRpScpGriGrpVO(), event.getCheckGRICalculationValidationVOs(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_12 : Search <br>
	 * Arbitrary Inquiry List를 조회합니다. (For Add-On Tariff) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeInquiryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201912Event event = (EsmPri201912Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeInquiryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_12 : Search <br>
	 * RFA Proposal Creation - Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. (For Add-On Tariff) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkArbitraryInquiryFontStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201912Event event = (EsmPri201912Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_13 : Open<br>
	 * Rate Inquiry - Commodity Group을 조회한다. (For Add-On Tariff) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityInquiryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201913Event event = (EsmPri201913Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityInquiryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_13 : Sheet1.Select<br>
	 * Rate Inquiry - Route 리스트를 조회한다. (For Add-On Tariff) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteInquiryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201913Event event = (EsmPri201913Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrInquiryListVO> vos = command.searchRateRouteInquiryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_13 : Sheet2.Select<br>
	 * Rate Inquiry - Rate 정보를 조회한다. (For Add-On Tariff) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201913Event event = (EsmPri201913Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateInquiryList(event.getPriRpScpRtVO());

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_13 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. (For Add-On Tariff) <br>
	 * 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateInquiryFontStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201913Event event = (EsmPri201913Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2041_13 : Open<br>
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityHistoryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204113Event event = (EsmPri204113Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();

		try {
			RsltRtCmdtListVO vo = command.searchRateCommodityHistoryList(event.getPriRpScpRtCmdtHdrVO());
			List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

			eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_13 : Sheet1.Select<br>
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteHistoryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204113Event event = (EsmPri204113Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRtRoutHdrListVO> vos = command.searchRateRouteHistoryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_13 : Sheet2.Select<br>
	 * Rate History - Rate 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateHistoryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204113Event event = (EsmPri204113Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO(), false);

			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_13 : Search <br>
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkRateHistoryFontStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204113Event event = (EsmPri204113Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			eventResponse.setRsVoList(command.checkHistoryFontStyle(event.getPriRpScpRtCmdtHdrVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2041_12 : Search <br>
	 * Arbitrary Amend History 리스트를 조회합니다. (For AEE/AEW) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeHistoryListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204112Event event = (EsmPri204112Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeHistoryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_12 : Search <br>
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. (For AEE/AEW)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHistoryArbitraryFontStyleForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204112Event event = (EsmPri204112Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_12 : Search <br>
	 * Arbitrary List를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200312Event event = (EsmPri200312Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeList(event.getPriRpScpTrspAddChgVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : Copy후 Arbitrary 값을 Update <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriRpScpTrspAddChgCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		try {
			begin();
			String key = command.managePriRpScpTrspAddChgCopy(event.getPriRpComVO(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2082 : Row add<br>
	 * RFA Type이 Contract 일때, actual customer check<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkActualCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2082Event event = (EsmPri2082Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<PriRpScpRtActCustVO> list =  command.checkActualCustomer(event.getPriRpScpRtActCustVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003 : Request <br>
	 * RFA Type이 Contract 일때 마지막으로 actual customer가 commodity 별로 같은지 check<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRfaContractTpActCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			String checkRfaContractTp = command.checkRfaContractTpActCust(event.getPriRpMnVO());
			eventResponse.setETCData("check_rfa_act_cust", checkRfaContractTp);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003 : Request <br>
	 * check Duration Basic Copy<br>
	 * 
	 * Basic RFA의 amdt가 0일때는 Copy한 Master의 Exp date를, amdt가 0이 아닐 때는 auto amend 대상 amdt의 Exp date를 취득한다.(CHM-201642287)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDurationBasicRFACopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			log.debug(event.getPriRpMnVO());
			String checkExpDt = command.checkExpDurationBasicRFACopy(event.getPriRpMnVO());
			eventResponse.setETCData("org_exp_dt", checkExpDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003 : Requset<br>
	 * Route 중에 term이 빠진 Location을 찾는다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRouteTermMissing(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<PriRpScpRtRoutPntVO> list =  command.checkRouteTermMissing(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**				
	 * ESM_PRI_2003 : Approve Check <br>				
	 * Approve 이전에 Retroactive RFA 대상이 존재하는지 체크(RFA의 Creation Date가 Effective Date보다 늦을 경우)<br>				
	 * 				
	 * @param Event e				
	 * @return EventResponse				
	 * @exception EventException				
	 */				
	private EventResponse searchRetroactiveExistCheck(Event e) throws EventException {				
		GeneralEventResponse eventResponse = new GeneralEventResponse();			
		EsmPri2003Event event = (EsmPri2003Event) e;			
		RFAProposalMainBC command = new RFAProposalMainBCImpl();			
		try {			
			String rslt = command.searchRetroactiveExistCheck(event.getPriRpMnVO(), account);
			eventResponse.setETCData("RSLT", rslt );		
		} catch (EventException ex) {			
			throw ex;		
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);		
		}			
		return eventResponse;			
	}				

	/**				
	 * ESM_PRI_2045 : onLoad시 조회 <br>				
	 * Approve 이전에 Retroactive RFA 사유 코드 조회<br>				
	 * 				
	 * @param Event e				
	 * @return EventResponse				
	 * @exception EventException				
	 */				
	private EventResponse searchRetroactiveRFANote(Event e) throws EventException {				
		GeneralEventResponse eventResponse = new GeneralEventResponse();			
		RFAProposalMainBC command = new RFAProposalMainBCImpl();			
		try {			
			List<PriRpRetroVO> list = command.searchRetroactiveRFANote();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {			
			throw ex;		
		} catch (Exception ex) {			
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);		
		}			
		return eventResponse;			
	}	
	
	/**				
	 * ESM_PRI_2045 : Save <br>			
	 * Retroactive RFA Note를 저장한다.<br>			
	 * 			
	 * @param e Event			
	 * @return response EventResponse			
	 * @exception EventException			
	 */			
	private EventResponse manageRetroactiveRFANote(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmPri2045Event event = (EsmPri2045Event) e;		
				
		RFAProposalMainBC command = new RFAProposalMainBCImpl();		
		try {		
			begin();	
			command.manageRetroactiveRFANote(event.getPriRpRetroVO(), account);	
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());  //msgs['PRI00101'] = 'Data saved successfully.';	
			commit();	
		} catch (EventException ex) {		
			rollback();	
			throw ex;	
		} catch (Exception ex) {		
			rollback();	
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);	
		}		
		return eventResponse;		
	}			
	
	
	/*****************************************************/
	/***[CHM-201640671] Master RFA 										    **/
	/*****************************************************/
	
	// ============================ESM_PRI_AAA_Start====================================
	/**
	 * ESM_PRI_2203 : OPEN<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initMasterMainComboData(Event e)  throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;
		try {
	        CodeUtil cdUtil = CodeUtil.getInstance();

		    //DEM/DET
	         ArrayList<CodeInfo> dmdtList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01704", 0);
	         eventResponse.setCustomData("dmdtList", dmdtList);
	            
			// Service Scope
			vo.setCd("CD03504");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("scopeList", list);
			
			// Origin Term
			vo.setCd("CD03501");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("termOrgCdList", list);
			
			// Dest Term
			vo.setCd("CD03500");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("termDestCdList", list);
			
			// Rate Per.
			vo.setCd("CD03502");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("ratUtCdList", list);
			//D2,D4,D5에서 모든 Per type이 되도록 수정
			//List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
			//eventResponse.setCustomData("ratUtCdList", ratUtCdList);
			
			// CAL.
			vo.setCd("CD01724");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_OP_CD", list);
			
			// Cargo Type (Dry Only)
			vo.setCd("CD03503");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("prcCgoTpCdList", list);
			// dry only에서 모든 carge type으로 변경함(20170703 송민석)
            //ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
            //eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
			
	        


	            
			
			// Currency
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCdList", currCdList);
			
			// Charge Term (Conversion)
			// Application
			vo.setCd("CD03498");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);
			// Pay Term
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);
			// Cargo Type (Dry Only)
			vo.setCd("CD03503");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
			// per Unit Code
			vo.setCd("CD03499");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			// Common
			// SOURCE
			vo.setCd("CD02198");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("src_info_cd", list);
			
			// STATUS
			vo.setCd("CD01719");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("prc_prog_sts_cd", list);
			
			// User Auth PRI17 + 승인권자
			list = command.searchMstRfaAuthList(account.getUsr_id());
			eventResponse.setCustomData("MST_RFA_AUTH", list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Retrieve<br>
	 * Master RFA 의 데이터를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMstMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2203Event event = (EsmPri2203Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC mainCommand = new RFAProposalMainBCImpl();
		RFARateProposalBC rateCommand = new RFARateProposalBCImpl();
		PRICommonBC command = new PRICommonBCImpl();
		
		try {
			// Main info
			RsltPropListVO mainVo = mainCommand.searchProposalMainMst(event.getPriRpHdrVO(), account);
			eventResponse.setRsVoList(mainVo.getRsltPropMnMstVOs());
			eventResponse.setRsVoList(mainVo.getRsltPropMnScpListVOs());
			
			if (mainVo.getRsltPropMnMstVOs() != null && mainVo.getRsltPropMnMstVOs().size() > 0) {
				RsltPropMnScpListVO scpVo = mainVo.getRsltPropMnScpListVOs().get(0);
				// Commodity
				PriRpScpRtCmdtHdrVO cmdtHdrVo = new PriRpScpRtCmdtHdrVO();
				cmdtHdrVo.setPropNo(scpVo.getPropNo());
				cmdtHdrVo.setAmdtSeq(scpVo.getAmdtSeq());
				cmdtHdrVo.setSvcScpCd(scpVo.getSvcScpCd());
				
				RsltRtCmdtListVO cmdtVo = rateCommand.searchMstRateCommodityList(cmdtHdrVo);
				eventResponse.setRsVoList(cmdtVo.getRsltRtCmdtDtlListVOS());
				
				// Conversion Charge Code
				RsltCdListVO vo = new RsltCdListVO();
				List<RsltCdListVO> list = null;
				// NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
				vo.setEtc1("R"); // 계약 유형: S->S/C, R->RFA, T->TRI
				vo.setEtc2("R"); // CONVERSION TYPE CODE
				vo.setEtc3("RAS"); // RAS만 조회
				vo.setEtc4(scpVo.getSvcScpCd()); // Scope Charge
				list = command.searchMstNoteConvChgCdList(vo);
				eventResponse.setRsVoList(list);
				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Retrieve<br>
	 * Master RFA의 Route & Summary 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRouteSummaryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltRoutHdrSmryListVO> vos = command.searchRouteSummaryList(event.getPriRpScpRtCmdtRoutVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Sheet3.Select<br>
	 * Rate & Conversion 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMstRateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			RsltRtListVO vo = command.searchMstRateList(event.getPriRpScpRtVO(), false);
			eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
			eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
			eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
			eventResponse.setRsVoList(vo.getRsltFicRateByRouteVO().get("X"));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203:Approve<br>
	 * Terms가 ACCEPT 되었는지 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalAcceptCheckMst(Event e) throws EventException {
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRpMnVO> list = command.searchProposalAcceptCheckMst(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2203:Request<br>
	 * Request 시 필수 입력 Terms 중 데이터가 없는 Terms를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestTermsCheckMst(Event e) throws EventException {
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<CstRequestCheckVO> list = command.searchRequestTermsCheck(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Cancel(Approve) <br>
	 * Approve Cancel시 BKG에 데이터가 있는지 조회한다.<br>
	 * 데이터가 있다면 Cancel 할 수 없다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalCancelCheckMst(Event e) throws EventException {
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltCdListVO> list = command.searchApprovalCancelCheck(event.getCstApprovalVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : SAVE<br>
	 * Master RFA PROPOSAL을 추가,수정,삭제합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMstProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFANoteConversionProposalBC command6 = new RFANoteConversionProposalBCImpl();
		RFARateProposalBC command7 = new RFARateProposalBCImpl();
	    RFAProposalDEMDETBC command4 = new RFAProposalDEMDETBCImpl();

		String propNo = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropMnVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
			}

			// EDI WEB & CRM INTERFACE 위한 조건 조회
			int cnt = command1.searchCheckOfcSrepDiffList(priRpMnVO);

//			// sales lead
//			String saleLeadOri = event.getSaleLeadOri();
//			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
//			ObjectCloner.build(priRpMnVO, vo);
//			if (!vo.getSlsLdNo().equals(saleLeadOri)) {
//				command5.manageRFACRMSalesLeadNo(vo, account);
//			}
			
			// Eff Dt 변경 시
			// note conv
			PriRpScpMnVO[] scpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
			command6.manageNoteConversionEffectiveDate(scpVo, account);
			command6.manageNoteConversionExpireDate(scpVo, account);

			command2.manageProposalScopeDurationRemove(event.getRfaPropMnVO(), account);
			// Surcharge
			command7.manageProposalScopeSurchargeRemove(event.getRfaPropMnVO());
			command1.manageProposalRemove(event.getRfaPropMnVO(), account);

			propNo = command1.manageProposal(event.getRfaPropMnVO(), account);
			command2.manageProposal(event.getRfaPropMnVO(), account);
			
			//DEM/DET
			command4.manageProposal(event.getRfaPropMnVO(), account);
			
			// TODO : DEM/DET관련 추가해야 함
			// SUMMARY TABLE UPDATE
			if (priRpMnVO.getIbflag().equals("I")) {
				PriRpAmdtSmryVO smryVo = new PriRpAmdtSmryVO();
				smryVo.setPropNo(propNo);
				smryVo.setAmdtSeq(priRpMnVO.getAmdtSeq());
				smryVo.setPropTermTpCd("01");
				command1.manageProposalAmendmentSummary(smryVo, account);
//				smryVo.setPropTermTpCd("08");
//				command1.manageProposalAmendmentSummary(smryVo, account);
			}
			PriRpScpAmdtSmryVO scpSmryVO = new PriRpScpAmdtSmryVO();
			scpSmryVO.setPropNo(priRpMnVO.getPropNo());
			scpSmryVO.setAmdtSeq(priRpMnVO.getAmdtSeq());
			scpSmryVO.setSvcScpCd(scpVo[0].getSvcScpCd());
			scpSmryVO.setPropScpTermTpCd("11");
			command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
			
			// 처음에만 넣어주는 Commodity
			if(priRpMnVO.getIbflag().equals("I") && event.getRfaRtPropCmdtVO() != null) {
				if(event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtHdrVOS() != null && event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtHdrVOS().length > 0 
						&& event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtVOS() != null && event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtVOS().length > 0) {
					event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtHdrVOS()[0].setPropNo(propNo);
					event.getRfaRtPropCmdtVO().getPriRpScpRtCmdtVOS()[0].setPropNo(propNo);
					
					command7.manageRateCommodity(event.getRfaRtPropCmdtVO(), account);
					
					PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
					smryVO.setPropNo(propNo);
					smryVO.setAmdtSeq(priRpMnVO.getAmdtSeq());
					smryVO.setSvcScpCd(scpVo[0].getSvcScpCd());
					smryVO.setPropScpTermTpCd("71");
					command1.manageScopeAmendmentSummary(smryVO, account);
				}
			}

			if (cnt > 0) {
				// INTERFACE : EDI WEB 으로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command1.transferRfaGeneralInfo(genInfVO, account);

				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command1.transferRfaSalesLeadContractInfo(priRpMnVO, account);
			}
			commit();
			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		eventResponse.setETCData("prop_no", propNo);
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2203 : Sheet3.Save<br>
	 * Route, Rate 및 Conversion 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMstRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			
			RfaRtPropRtVO rfaRtPropRtVO = new RfaRtPropRtVO();
			ObjectCloner.build(event.getRfaRtPropRtVO(), rfaRtPropRtVO);
			
			command.manageRateMst(event.getRfaRtPropRtVO(), account);
			
			cmdNoteConv.manageNoteConversionCascadeRouteMst(rfaRtPropRtVO, account);
			
			// Route & Summary의 APP Note Conversion을 처리한다.
			RsltRoutHdrSmryListVO appInfo = event.getRsltRoutHdrSmryListVO();
			
			if(appInfo != null && !event.getNoteConvMapgId().equals("")) {
				cmdNoteConv.manageAppNoteConversion(appInfo, event.getNoteConvMapgId(), account);
			}
			
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71");
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
//			PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
//			scpMnVO.setPropNo(event.getPropNo());
//			scpMnVO.setAmdtSeq(event.getAmdtSeq());
//			scpMnVO.setSvcScpCd(event.getSvcScpCd());
//			cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
//			cmdMain.updatePrsMBFlgOnSaveRt(scpMnVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203: Request<br>
	 * Main의 상태를 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse requestProposalMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		String propStsCd = "";
		String userMsg = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			command.counterofferProposal(event.getRfaPropProgVO(), account);
			if (mnVo[0] != null)
				propStsCd = mnVo[0].getPropStsCd();

			// C/Offer 시 Scope과 Main의 상태를 returned로 변경한다
//			if (mnVo[0] != null && propStsCd.equals("R")) {
//				// manageReturnStatus(e);
//				int cnt = 0;
//
//				List<RsltReturnVO> list = command.searchProposalReturnedList(mnVo[0]);
//				if (list != null && list.size() > 0) {
//					cnt++;
//				}
//				String propNo = mnVo[0].getPropNo();
//				String amdtSeq = mnVo[0].getAmdtSeq();
//				PriRpMnVO priMn = new PriRpMnVO();
//				priMn.setPropNo(propNo);
//				priMn.setAmdtSeq(amdtSeq);
//				if (cnt > 0) {
//					priMn.setPropStsCd("R");
//				} else {
//					priMn.setPropStsCd("Q");
//				}
//				command.modifyMainStatus(priMn, account);
//				// Rate Calc Flag change
//				PriRpScpMnVO scpMn = new PriRpScpMnVO();
//				scpMn.setPropNo(propNo);
//				scpMn.setAmdtSeq(amdtSeq);
//				scpMn.setPrsRtCmpbCalcFlg("N");
//				scpMn.setPrsRtMbFlg("N");
//				command.manageProposalRateCalcFlag(scpMn, account);
//				// PRS_RT_CMPB_CALC_FLG
//			}
			
			autoAcceptProposalMst(e);

			if (propStsCd.equals("Q")) {
				userMsg = "Request";
			} else if (propStsCd.equals("R")) {
				userMsg = "C/Offer";
			}

			eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { userMsg }).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203: Request<br>
	 * Request시 자동 Accept를 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void autoAcceptProposalMst(Event e) throws EventException {
		EsmPri2203Event event = (EsmPri2203Event) e;
//		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {

			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();

			// request 시 자동 Accept Proposal
			// duration,MQC,DEM/DT
			if (mnVo[0] != null && mnVo[0].getPropStsCd().equals("Q")) {
				// duration
				PriRpScpDurVO priRpDurVO = new PriRpScpDurVO();
				PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
				ObjectCloner.build(mnVo[0], priRpDurVO);
				priRpDurVO.setSvcScpCd("");
				priRpDurVO.setPrcProgStsCd("A");
				command2.acceptProposalDuration(priRpDurVO, account);

				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						ObjectCloner.build(mnScpVo[i], priRpScpDurVO);
						priRpScpDurVO.setPrcProgStsCd("A");
						command2.acceptProposalDuration(priRpScpDurVO, account);
					}
				}

				// DEM/DT
//				PriRpDmdtVO vo = new PriRpDmdtVO();
//				ObjectCloner.build(mnVo[0], vo);
//
//				command1.acceptProposalDEMDETException(vo, account);

				// main
				PriRpAmdtSmryVO amdtVo = new PriRpAmdtSmryVO();
				amdtVo.setPropNo(event.getPropNo());
				amdtVo.setAmdtSeq(event.getAmdtSeq());
				// duration ,DEM/DT
				command.modifyProposalAutoAcceptAmendmentSummary(amdtVo, account);
				// Scop
				PriRpScpAmdtSmryVO amdtScpVo = new PriRpScpAmdtSmryVO();
				amdtScpVo.setPropNo(event.getPropNo());
				amdtScpVo.setAmdtSeq(event.getAmdtSeq());
				// duration
				command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

	}
	
	/**
	 * ESM_PRI_2203 : Accept All<br>
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllMstRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		RfaSummryAcceptAllVO sumVo = event.getRfaSummryAcceptAllVO();
		
		try {
			begin();
			
			PriRpScpRtVO[] scpRtVos =     sumVo.getPriRpScpRtVOS();
			scpRtVos[0].setAmdtSeq(event.getAmdtSeq());
			command.acceptAllMstRate(scpRtVos[0], "G", account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Accept Cancel all<br>
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllMstRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
//			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			command.cancelAllMstRate(event.getPriRpScpRtVO(), "G", account);
			
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Accept<br>
	 * Master RFA의 Rate 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Accept Cancel<br>
	 * Master RFA의 Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRate(event.getPriRpScpRtVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Accept<br>
	 * Master RFA의 Route Note 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateCommodityRnoteMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);
			command.acceptRateCommodityRnoteConv(event.getRfaRtPropRtVO().getPriRfaNoteConvListVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Accept Cancel<br>
	 * Master RFA의 Route Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateCommodityRnoteMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);
			command.cancelRateCommodityRnoteConv(event.getRfaRtPropRtVO().getPriRfaNoteConvListVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71"); // CY Only
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Accept<br>
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptRateRoutePntViaMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);
			}
			
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71");
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Accept Cancel<br>
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelRateRoutePntViaMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);
			}
			
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPropNo());
			smryVO.setAmdtSeq(event.getAmdtSeq());
			smryVO.setSvcScpCd(event.getSvcScpCd());
			smryVO.setPropScpTermTpCd("71");
			cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203: Approve Master RFA <br>
	 * Main의 상태를 Approve로 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse approveProposalMst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
//		CRMSalesLeadBC command3 = new CRMSalesLeadBCImpl();
		//Booking Autorating
        BlRatingBC command4 = new BlRatingBCImpl();
		String rfaNo = "";
		try {
			begin();
			
			//##### make a Master RFA No. #####
			rfaNo = command.approveProposalMst(event.getRfaPropProgVO(), account);
			//##### make a Master RFA No. #####
			
//			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
				// Sales Lead No가 있을 경우
//				if (!JSPUtil.getNull(priRpMnVO.getSlsLdNo()).equals("")) {
//					ObjectCloner.build(priRpMnVO, vo);
//					vo.setPropStsCd("A");
//					command3.manageRFACRMSalesLeadNo(vo, account);
//				}
				
				//#####  INTERFACE (CMS0010001) : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command.transferRfaSalesLeadContractInfo(priRpMnVO, account);

				
				//##### INTERFACE (EDI0080001): EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command.transferRfaGeneralInfo(genInfVO, account);
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { "Approve" }).getUserMessage());

			}
			// Approve 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
			List<PriEmailTargetListVO> list = command.sendEmail(priRpMnVO, account);
			
			if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
				command4.modifyAudDt(list);
            }
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("rfa_no", rfaNo);
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203: Cancel<br>
	 * 상태값을 Cancel하여 이전 상태로 변경한다.<br>
	 * Init상태에서 Cancel을 하는 경우에는 해당 Amd Seq No.의 모든 데이터를 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelProposalMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;

		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFANoteProposalBC command3 = new RFANoteProposalBCImpl();
		RFAGroupCommodityProposalBC command5 = new RFAGroupCommodityProposalBCImpl();
		RFARateProposalBC command7 = new RFARateProposalBCImpl();
		RFAGroupLocationProposalBC command8 = new RFAGroupLocationProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command10 = new RFATransportationAdditionalChargeProposalBCImpl();
//		RFAAffiliateProposalBC command11 = new RFAAffiliateProposalBCImpl();
		RFAProposalDEMDETBC command15 = new RFAProposalDEMDETBCImpl();
		CRMSalesLeadBC command16 = new CRMSalesLeadBCImpl();
		RFAGRICalculationProposalBC command17 = new RFAGRICalculationProposalBCImpl();
		RFANoteConversionProposalBC command18 = new RFANoteConversionProposalBCImpl();
		RFAQuotationMainBC command19 = new RFAQuotationMainBCImpl();

		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();

			String stsCd = mnVo[0].getPropStsCd();
			log.debug("stsCd=======================" + stsCd);
			log.debug("amdtseq=======================" + mnVo[0].getAmdtSeq());
			if (!stsCd.equals("D")) {
				command.cancelProposal(event.getRfaPropProgVO(), account); // 메인 상태변경
			}

			if (stsCd.equals("I")) {
				PriRpAproRqstRefVO priRpAproRqstRefVO = new PriRpAproRqstRefVO();
				if (mnVo[0] != null) {
//					command11.manageProposalRequestCancel(mnVo[0], account);// affiliate
					command2.manageProposalRequestCancel(mnVo[0], account);// duration
					command15.manageProposalRequestCancel(mnVo[0], account);// free time

					// pri_sp_amdt_smry acpt_flg를 N으로 update
					PriRpAmdtSmryVO vo = new PriRpAmdtSmryVO();
					ObjectCloner.build(mnVo[0], vo);
					command.manageProposalRequestCancelAmendmentSummary(vo, account);// Main Terms

					// pri_sp_scp_amdt_smry acpt_flg를 N으로 update
					PriRpScpAmdtSmryVO scpVo = new PriRpScpAmdtSmryVO();
					ObjectCloner.build(mnVo[0], scpVo);
					command.manageProposalScopeRequestCancelAmendmentSummary(scpVo, account);
					// scope main 상태변경
					PriRpScpMnVO scpMnVo = new PriRpScpMnVO();
					ObjectCloner.build(mnVo[0], scpMnVo);
					command.modifyAllScopeStatus(scpMnVo, account);

					// Proposal Request 정보의 상태변경을 위한 값을 셋팅한다.
					priRpAproRqstRefVO.setPropNo(mnVo[0].getPropNo());
					priRpAproRqstRefVO.setAmdtSeq(mnVo[0].getAmdtSeq());
					priRpAproRqstRefVO.setPrcAproRqstStsCd("C");
				}

				command5.manageProposalRequestCancel(mnScpVo, account);// commodity
				command8.manageProposalRequestCancel(mnScpVo, account);// location
				command3.manageProposalRequestCancelMst(mnScpVo, account);// note
				command7.manageProposalRequestCancel(mnScpVo, account);// rate
				command10.manageProposalRequestCancel(mnScpVo, account);// ihc,arb
				command2.manageProposalRequestCancelScope(mnScpVo, account);// duration

				// Proposal Request 정보의 상태를 Cancel로 변경한다.
				command.modifyProposalRequestStatus(priRpAproRqstRefVO, account);

			} else if (stsCd.equals("Q")) {// Approve Cancel

				// MAIN,SCOPE MAIN EXP_DT 원복
				command.manageProposalApproveCancel(mnVo[0], account);//

				log.debug("request approve cancel===================" + mnVo[0].getAmdtSeq());
				log.debug("request approve cancel===================" + mnScpVo[0].getAmdtSeq());
				// Rate Calc Flag change
				PriRpScpMnVO scpMn = new PriRpScpMnVO();
				scpMn.setPropNo(mnVo[0].getPropNo());
				scpMn.setAmdtSeq(mnVo[0].getAmdtSeq());
				scpMn.setPrsRtCmpbCalcFlg("Y");
				scpMn.setPrsRtMbFlg("Y");
				command.manageProposalRateCalcFlag(scpMn, account);

				// sale lead
				CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
				ObjectCloner.build(mnVo[0], vo);
				command16.manageRFACRMSalesLeadNo(vo, account);

				// INTERFACE : EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(mnVo[0], genInfVO);
				genInfVO.setEaiSts("D");
				command.transferRfaGeneralInfo(genInfVO, account);
			} else if (stsCd.equals("D")) {// Init Cancel 모든 데이터 삭제

				CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
				ObjectCloner.build(mnVo[0], vo);
				command16.manageRFACRMSalesLeadNo(vo, account);

				// Quotation Main
				PriRqMnVO priRqMnVO = new PriRqMnVO();
				priRqMnVO.setPropNo(mnVo[0].getPropNo());
				command19.modifyRFAQuotationMainPropNoDel(priRqMnVO, account); // Quotation Main PropNo reset
				command2.removeProposal(mnVo[0], account);// duration main
//				command11.manageProposal(mnVo[0], account); // affiliate
				command15.removeProposal(mnVo[0], account); // FREE TIME
				command18.manageProposal(mnVo[0], account);// conversion
				command.removeProposalProgress(mnVo[0], account);// Progress
				command.removeProposalAmdtSmry(mnVo[0], account);// amdt smry
				command17.manageProposal(mnVo[0], account);// GRI

				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						command2.removeProposalScope(mnScpVo[i], account);// duration scope
						command3.manageProposal(mnScpVo[i], account);// s Note
						command5.manageProposal(mnScpVo[i], account);// group Commodity
						command7.removeProposalMain(mnScpVo[i]);// rate
						command8.removeProposal(mnScpVo[i], account);// group location
						command10.manageProposal(mnScpVo[i], account);// arb/ihc
						command.removeProposalScopeProgress(mnScpVo[i], account);// progress
						command.removeProposalScopeAmdtSmry(mnScpVo[i], account);// amdt_smry
						command.removeProposalScopeMain(mnScpVo[i], account);
					}
				}
				command.removeProposal(mnVo[0], account); // proposal main
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI01047", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2203 : Request Check <br>
	 * Rquest 처리시 Rate(AEE/AEW)의 FIC_PROP_RT_AMT값이 O인 값이 존재하는지 체크<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestIhcRateCheckMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			eventResponse.setETCData("RSLT", String.valueOf(command.searchProposalRequestIhcRateCheck(event.getPriRpMnVO())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Request Check <br>
	 * Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalRequestPortCyCheckMst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltCdListVO> list = command.searchProposalRequestPortCyCheck(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2203 : Approve Cancle Check <br>
	 * Approve Cancle 처리 시 자식 Basic이 있는지 여부 체크 (CHM-201642287)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalCancelCheckChildren(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2203Event event = (EsmPri2203Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {
			List<RsltCdListVO> list = command.searchApprovalCancelCheckChildren(event.getPriRpHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ============================ESM_PRI_2203_End====================================
	
	// ============================ESM_PRI_2240_Start====================================
	/**
	 * ESM_PRI_2240 : Ok<br>
	 * Amend Data를 생성한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse amendProposalMst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2040Event event = (EsmPri2040Event) e;
		RFAProposalMainBC command01 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command02 = new RFADurationProposalBCImpl();
		RFAProposalDEMDETBC command04 = new RFAProposalDEMDETBCImpl();

//		RFAGroupLocationProposalBC command05 = new RFAGroupLocationProposalBCImpl();
//		RFAGroupCommodityProposalBC command06 = new RFAGroupCommodityProposalBCImpl();
//		RFAAffiliateProposalBC command07 = new RFAAffiliateProposalBCImpl();
		RFANoteProposalBC command11 = new RFANoteProposalBCImpl();
		RFARateProposalBC command12 = new RFARateProposalBCImpl();
//		RFATransportationAdditionalChargeProposalBC command14 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFANoteConversionProposalBC command15 = new RFANoteConversionProposalBCImpl();

		PriRpMnVO vo = new PriRpMnVO();
		CstPriRpAmendVO amdVo = event.getCstPriRpAmendVO();
		ObjectCloner.build(amdVo, vo);
		if (!amdVo.getNewDurFlg().equals("Y")) { // 새로운 duration 입력 Y
			vo.setExpDt("");
		}

		try {
			begin();
			command01.amendProposal(vo, account);
			command02.amendProposal(vo, account);
			command04.amendProposal(vo, account);
//			command05.amendProposal(vo, account);
//			command06.amendProposal(vo, account);
//			command07.amendProposal(vo, account);
			command11.amendProposal(vo, account);
			command12.amendProposal(vo, account);
//			command14.amendProposal(vo, account);
			command15.amendProposalMst(vo, account);
			command01.manageProposalAmendmentSummaryDuration(vo, account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ============================ESM_PRI_2240_End====================================
	
	// ============================ESM_PRI_2244_Start====================================
	/**				
	 * ESM_PRI_2244 : Retrieve <br>			
	 * RFA Proposal Creation [Copy]를 조회한다.<br>			
	 * 			
	 * @param e Event			
	 * @return response EventResponse			
	 * @exception EventException			
	 */			
	private EventResponse rfaProposalCreationCopy(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmPri2244Event event = (EsmPri2244Event) e;		
				
		RFAProposalMainBC command = new RFAProposalMainBCImpl();		
		try {		
			begin();	
			List<RsltRoutHdrSmryListVO> list =command.rfaProposalCreationCopy(event.getRsltRoutHdrSmryListVO());	
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);		
		}		
		return eventResponse;		
	}
	

	/**
	 * ESM_PRI_2244 : OK<br>
	 * Master RFA Proposal Main/Scope를 Master RFA로 Copy 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyProposaltoMst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2244Event event = (EsmPri2244Event) e;
		RsltRfaPropCopyVO vo = event.getRsltRfaPropCopyVO();
		RsltRoutHdrSmryListVO[] smryVOs = event.getRsltRoutHdrSmryListVOs();
		
		if (vo == null || vo.equals("")) {
			eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
			return eventResponse;
		}

		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFARateProposalBC command3 = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC command4 = new RFANoteConversionProposalBCImpl();
		RFAProposalDEMDETBC command5 = new RFAProposalDEMDETBCImpl();
		
		// Copy 될 RFA의 Type Code
		String rfaTypeCode = "M";
		
		try {
			if(event.getRfaType() != null && !event.getRfaType().isEmpty()) {
				rfaTypeCode = event.getRfaType();
			}
			
			begin();
			String newPropNo = command1.searchMaxPropNo(account); // 생성된 prop_no
			if (JSPUtil.getNull(newPropNo).equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
				commit();
				return eventResponse;
			}
			
			vo.setNewPropNo(newPropNo);
			
			// PRI_RP_MN/PRI_RP_HDR/PRI_RP_AMDT_SMRY/PRI_RP_PROG COPY
			command1.copyProposalMainMst(vo, account, rfaTypeCode);
			
			// PRI_RP_DUR
			command2.copyProposalDurationMst(vo, account);

			// PRI_RP_AMDT_SMRY UPDATE
			PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
			priRpAmdtSmryVO.setPropNo(newPropNo);
			priRpAmdtSmryVO.setAmdtSeq("0");
			command1.manageProposalAmendmentSummaryAll(priRpAmdtSmryVO, account);

			// Scope Copy
			command1.copyProposalScopeMain(vo, account);
			command2.copyProposalScopeDurationMst(vo, event.getPriRpMnVO(), account);
			
			// DMDT
// 기존 소스 무조건 Tariff로 Insert한다. 하지만 변경 후에는 Copy하는 것으로 변경			
//			if(!rfaTypeCode.equals("M")){
//				PriRpDmdtVO[] dmdtVo = new PriRpDmdtVO[1];
//				dmdtVo[0] = new PriRpDmdtVO();
//				dmdtVo[0].setIbflag("I");
//				dmdtVo[0].setPropNo(newPropNo);
//				dmdtVo[0].setAmdtSeq("0");
//				dmdtVo[0].setDmdtFtTpCd("T"); // Tariff
//				dmdtVo[0].setPrcProgStsCd("I");
//				dmdtVo[0].setSrcInfoCd("NW");
//				dmdtVo[0].setN1stCmncAmdtSeq("0");
//				
//				command5.manageDEMDETException(dmdtVo, account);
//			}
			command5.copyProposalDemDet(vo, account);

			
			// Rate
			command3.copyProposalScopeRateMst(vo, smryVOs, account, rfaTypeCode);
			// Note Conversion
			command4.copyProposalRoutNoteConversionMst(vo, smryVOs, account, event.getPriRpMnVO());
			
			// PRI_RP_SCP_AMDT_SMRY UPDATE
			RsltRfaPropCopyVO[] vos = vo.getRsltRfaPropCopyVOs();
			command1.copyProposalScopeAmdtSmry(vos, account);
			
			
			//새롭게 추가된 DEM/DET COPY 2017-06-14 송민석
	         //dem/det copy
            if(!rfaTypeCode.equals("M")){// master에서 master copy는 demdet copy 안해줌
                RFAExceptionTariffMgtBC demdetCommand  = new RFAExceptionTariffMgtBCImpl();
                RFACopyMstToBzcVO rfaExceptionVO = new RFACopyMstToBzcVO();
                rfaExceptionVO.setMstPropNo(vo.getPropNo());//Master Proposal No. 　
                rfaExceptionVO.setBzcPropNo(newPropNo);// Basic Proposal No.  
                rfaExceptionVO.setCpyTpCd("C");//Basic BBE 생성 방법 C ( 무조건 고정값 )
                rfaExceptionVO.setCreOfcCd(account.getOfc_cd());
                rfaExceptionVO.setCreUsrId(account.getUsr_id());
                demdetCommand.copyMstRfaVerToBzcRfaVer(rfaExceptionVO);
            }
			eventResponse.setUserMessage(new ErrorHandler("PRI00110").getUserMessage());
			eventResponse.setETCData("newPropNo", newPropNo);
			
			commit();

			begin();
			
			/** Duration update **/ 
			// Duration 수정을 위해 임의로 신규 proposal 정보 입력
			event.getPriRpMnVO().setPropNo(newPropNo);
			event.getPriRpMnVO().setAmdtSeq("0");
			
			// EDI WEB & CRM INTERFACE 위한 조건 조회
			int cnt = command1.searchCheckOfcSrepDiffList(event.getPriRpMnVO());
			
			// PRI_RP_MN/PRI_RP_HDR/PRI_RP_SCP_MN
			command1.manageProposalMst(event.getPriRpMnVO(), account , smryVOs[0].getSvcScpCd());

			// Duration 수정을 위해 임의로 신규 proposal 정보 입력
			CstPriRpScpDurVO[] cstPriRpScpDurVO = new CstPriRpScpDurVO[1];
			cstPriRpScpDurVO[0] = event.getCstPriRpScpDurVO();
			cstPriRpScpDurVO[0].setPropNo(newPropNo);
			cstPriRpScpDurVO[0].setAmdtSeq("0");
			cstPriRpScpDurVO[0].setIbflag("U");
			cstPriRpScpDurVO[0].setScpSave("true");
			cstPriRpScpDurVO[0].setSvcScpCd("");
			
			command2.manageProposalDuration(cstPriRpScpDurVO, account);
			
			PriRpAmdtSmryVO smryVo = new PriRpAmdtSmryVO();
			smryVo.setPropNo(newPropNo);
			smryVo.setAmdtSeq("0");
			smryVo.setPropTermTpCd("01");
			command1.manageProposalAmendmentSummary(smryVo, account);
			smryVo.setPropTermTpCd("08");
			command1.manageProposalAmendmentSummary(smryVo, account);
			
			PriRpScpAmdtSmryVO scpSmryVO = new PriRpScpAmdtSmryVO();
			scpSmryVO.setPropNo(newPropNo);
			scpSmryVO.setAmdtSeq("0");
			scpSmryVO.setSvcScpCd(vo.getSvcScpCd());
			scpSmryVO.setPropScpTermTpCd("11");
			command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
			commit();
			
			if (cnt > 0) {
				// INTERFACE : EDI WEB 으로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(event.getPriRpMnVO(), genInfVO);
				genInfVO.setEaiSts("U");
				command1.transferRfaGeneralInfo(genInfVO, account);
				
				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command1.transferRfaSalesLeadContractInfo(event.getPriRpMnVO(), account);
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	// ============================ESM_PRI_2244_End====================================

	// ============================ESM_PRI_2208_Start====================================

	/**
	 * ESM_PRI_2208 : Check<br>
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMstRateExcelHorizontal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2208Event event = (EsmPri2208Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkMstRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS());

			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2208 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadMstRateExcelHorizontal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2208Event event = (EsmPri2208Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadMstRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2208 : Save<br>
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadMstRateExcelHorizontalOnline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2208Event event = (EsmPri2208Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();

			command.uploadMstRateExcelHorizontalOnline(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2208 : Open<br>
	 * 초기 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initMstRateExcelHorizontal(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Mst_Rate_Templet_H.xls");  //RP_Mst_Rate_Templet_H <- RP_Rate_Templet_H by choi
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
			
			EsmPri2208Event event = (EsmPri2208Event) e;

			RsltCdListVO vo = new RsltCdListVO();
			List<RsltCdListVO> list = null;
			
			// APLICATION
			vo.setCd("CD03498");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RT_APPL_TP_CD", list);
			
			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			// NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
			vo.setEtc1("R"); // 계약 유형: S->S/C, R->RFA, T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			vo.setEtc3("RAS"); 
			vo.setEtc4(event.getSvcScpCd().toString()); // Scope Charge
			list = command.searchMstNoteConvChgCdList(vo);
			eventResponse.setCustomData("RULE_CD", list);
			
			// Scope Charge Code List			
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());			
			list = command.searchScopeChargeCodeList(vo);			
			eventResponse.setCustomData("CHARGE_CD", list);

			// PAY TERM
			vo.setCd("CD01713");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PAY_TERM_CD", list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	// ============================ESM_PRI_2208_End====================================
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_2233 : Open<br>
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMasterGRICalculationHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2233Event event = (EsmPri2233Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2233 : Sheet1.Select<br>
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMasterGRICalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2233Event event = (EsmPri2233Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
		try {
			RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

			eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
			eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2233 : Save<br>
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMasterGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2233Event event = (EsmPri2233Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();

		try {
			begin();
			command.manageGRICalculation(event.getRfaGriCalcVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_2233 : Apply<br>
	 * Rate 데이터에 Master GRI Calculation을 적용합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyMasterGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2233Event event = (EsmPri2233Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.applyGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * ESM_PRI_2233 : Apply Cancel<br>
	 * 적용한 Master GRI Calculation을 취소합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelMasterGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2233Event event = (EsmPri2233Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);

			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
			smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
			if ("A".equals(event.getFicRtTpCd())) {
				smryVO.setPropScpTermTpCd("73");
			} else {
				smryVO.setPropScpTermTpCd("71");
			}
			cmdMain.manageScopeAmendmentSummary(smryVO, account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003: manageBasicProposalAll<br>
	 * Request 클릭시 Basic 계약조건은 Approve 단계까지의 상태를 변경한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBasicProposalAll(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		//Request
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
//		String propStsCd = "";
		String userMsg = "";
		//Accept All
		RFARateProposalBC commandRate = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
		PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
		//Approve
//		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		CRMSalesLeadBC command3 = new CRMSalesLeadBCImpl();
		//Booking Autorating
        BlRatingBC command4 = new BlRatingBCImpl();
		String rfaNo = "";
		try {
			begin();
			//Reqeust Start
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			
			command.counterofferProposal(event.getRfaPropProgVO(), account);
			autoAcceptProposal(e);
			userMsg = "Request";
			
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
			
			// [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
			// Duration Accept
			if (mnVo[0] != null) {
				// duration
				PriRpScpDurVO priRpDurVO = new PriRpScpDurVO();
				PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
				ObjectCloner.build(mnVo[0], priRpDurVO);
				priRpDurVO.setSvcScpCd("");
				priRpDurVO.setPrcProgStsCd("A");
				command2.acceptProposalDuration(priRpDurVO, account);
				
				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						ObjectCloner.build(mnScpVo[i], priRpScpDurVO);
						priRpScpDurVO.setPrcProgStsCd("A");
						command2.acceptProposalDuration(priRpScpDurVO, account);
					}
					
					// main
					PriRpAmdtSmryVO amdtVo = new PriRpAmdtSmryVO();
					amdtVo.setPropNo(mnScpVo[0].getPropNo());
					amdtVo.setAmdtSeq(mnScpVo[0].getAmdtSeq());
					
					// duration ,DEM/DT
					command.modifyProposalAutoAcceptAmendmentSummary(amdtVo, account);
					
					// Scop
					PriRpScpAmdtSmryVO amdtScpVo = new PriRpScpAmdtSmryVO();
					amdtScpVo.setPropNo(mnScpVo[0].getPropNo());
					amdtScpVo.setAmdtSeq(mnScpVo[0].getAmdtSeq());
					// duration
					command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
				}
			}
			
			//accept All Start
			if(mnScpVo != null){
				PriRpScpRtVO priRpScpRtVO = new PriRpScpRtVO();
				priRpScpRtVO.setPropNo(mnScpVo[0].getPropNo());
				priRpScpRtVO.setAmdtSeq(mnScpVo[0].getAmdtSeq());
				priRpScpRtVO.setSvcScpCd(mnScpVo[0].getSvcScpCd());
				commandRate.acceptAllRateBasic(priRpScpRtVO, account); //신규 ----

				smryVO.setPropNo(mnScpVo[0].getPropNo());
				smryVO.setAmdtSeq(mnScpVo[0].getAmdtSeq());
				smryVO.setSvcScpCd(mnScpVo[0].getSvcScpCd());
				smryVO.setPropScpTermTpCd("71");
				cmdMain.manageScopeAmendmentSummary(smryVO, account); //신규----
			}
			userMsg = "All Accept";
			
			//Approve Start
			rfaNo = command.approveProposalBasic(event.getRfaPropProgVO(), account);
			CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
//			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpMnVO priRpMnVO = new PriRpMnVO();

			if (mnVo.length > 0) {
				priRpMnVO = mnVo[0];
				// Sales Lead No가 있을 경우
				if (!JSPUtil.getNull(priRpMnVO.getSlsLdNo()).equals("")) {
					ObjectCloner.build(priRpMnVO, vo);
					vo.setPropStsCd("A");
					command3.manageRFACRMSalesLeadNo(vo, account);
				}
				// INTERFACE : CRM으로 Contract Information을 전송
				// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
				//command.transferRfaSalesLeadContractInfo(priRpMnVO, account);

				// INTERFACE : EDI 로 General Information을 전송
				PriEdiRfGenInfVO genInfVO = new PriEdiRfGenInfVO();
				ObjectCloner.build(priRpMnVO, genInfVO);
				genInfVO.setEaiSts("U");
				command.transferRfaGeneralInfo(genInfVO, account);
			}
			
			// Approve 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
			List<PriEmailTargetListVO> list = command.sendEmail(priRpMnVO, account);
			
			if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
				command4.modifyAudDt(list);
            }
			userMsg = "approve";
			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] { userMsg }).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		eventResponse.setETCData("rfa_no", rfaNo);
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003: Auto Amend 활성 여부<br>
	 * Approved Basic RFA 조회 시 Master RFA를 체크해서 Master의 AMD No.가 변경되었는지 체크한다.(CHM-201642287)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBasicAmendable(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		
		try {
			String amendable_YN = command.checkBasicAmendable(event.getPriRpMnVO());
			eventResponse.setETCData("amendable_YN", amendable_YN);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2017: Basic RFA Auto Amend 팝업<br>
	 * Master RFA 정보와 Master RFA의 Route 중에 Basic이 가지고 있는 정보를 조회한다. (CHM-201642287)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBasicRFARouteInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2017Event event = (EsmPri2017Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC mainCommand = new RFAProposalMainBCImpl();
		
		try {
			// Master RFA Info
			eventResponse.setRsVoList(mainCommand.searchApprovedMstInfo(event.getMstRfaNo()));
			
			// Basic RFA가 상속한 Master RFA의 Basic이 가지고 있는 Route Summary List
			eventResponse.setRsVoList(command.searchMstRouteSummaryList(event.getPriRpScpRtCmdtRoutVO(), event.getMstRfaNo(), "Y"));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2017 : Ok<br>
	 * Basic RFA Amend Data를 생성한다. (CHM-201642287)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse amendProposalBasic(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2017Event event = (EsmPri2017Event) e;
		RFAProposalMainBC command01 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command02 = new RFADurationProposalBCImpl();

		RFANoteProposalBC command11 = new RFANoteProposalBCImpl();
		RFARateProposalBC command12 = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC command15 = new RFANoteConversionProposalBCImpl();
		
	    RFAProposalDEMDETBC command03 = new RFAProposalDEMDETBCImpl();
        RFAExceptionTariffMgtBC demdetCommand  = new RFAExceptionTariffMgtBCImpl();

	      
		PriRpMnVO vo = new PriRpMnVO();
		CstPriRpAmendVO amdVo = event.getCstPriRpAmendVO();
		ObjectCloner.build(amdVo, vo);
		if (!amdVo.getNewDurFlg().equals("Y")) { // 새로운 duration 입력 Y
			vo.setExpDt("");
		}
		
		try {
			begin();
			command01.amendProposal(vo, account);
			command02.amendProposal(vo, account);
			command11.amendProposal(vo, account);
			command12.amendProposalBasic(vo, event.getRsltRoutHdrSmryListVO(), account);
			
			command15.amendProposalBasic(vo, event.getRsltRoutHdrSmryListVO(), account); // 새거 Basic꺼
			//DMDT
 			command03.amendProposalBasic(vo, event.getRsltRoutHdrSmryListVO(), account);
 			
 			////////////////////////////////////////////////
            // route 신규 추가 insert 시작

 	        RsltRoutHdrSmryListVO[] smryVOs = event.getRsltRoutHdrSmryListVOs();
 	       RsltRfaPropCopyVO voCopy = event.getRsltRfaPropCopyVO();
 	       voCopy.setNewPropNo(amdVo.getPropNo());
           voCopy.setNewAmdtSeq(amdVo.getAmdtSeq());

 	        // Copy 될 RFA의 Type Code
 	        String rfaTypeCode = "M";
 			//route
 			//rate RsltRfaPropCopyVO
 	        // Rate
 	        
 	       command12.copyAmendProposalScopeRateMst(voCopy, smryVOs, account);
 	       //conversion
 	       // Note Conversion
 	       //command15.copyProposalRoutNoteConversionMst(voCopy, smryVOs, account, vo);  

            
 			
 			
 			// route 신규 추가 insert 종료
 			
 			
 
			command01.manageProposalAmendmentSummaryDuration(vo, account);
			
            //PRI의 DEM/DET이 EXCEPTION이고 현재 AUTO AMEND하는 RFA에 DEM/DET의 데이터가 없으면 MASTER RFA의 DEMDET을 COPY해야한다.
           //1. PRI의 DEM/DET이 EXCEPTION인지 확인 한다.
           //2. AUTO AMEND하는 RFA에 DEM/DET이 존재 하지 않는다면
           //3. MASTER의 DEM/DET을 COPY한다.
           //TODO : 코딩 진행
           PriRpDmdtVO priRpDmdtVO = new PriRpDmdtVO();
           priRpDmdtVO.setPropNo(vo.getPropNo());
           priRpDmdtVO.setAmdtSeq(String.valueOf(Integer.parseInt(vo.getAmdtSeq())+1));
           
           List<RsltDmdtExptListVO>  dmdtExpt = command03.searchDEMDETExceptionList( priRpDmdtVO);
           if( dmdtExpt != null && dmdtExpt.size() > 1 ){ //amend가 일어난경우
               if("E".equals(dmdtExpt.get(1).getDmdtFtTpCd())){//Exception으로 변경됨
                  if(demdetCommand.isExistRfa(vo.getPropNo())==false){//dem/det 이 존재 하지 않음
                       List<MasterInfoFromBasicVO> info = command01.searchMasterInfoFromBasicRFA(vo);

                       RFACopyMstToBzcVO rfaExceptionVO = new RFACopyMstToBzcVO();
                       rfaExceptionVO.setMstPropNo(info.get(0).getMstPropNo());//Master Proposal No. 　
                       rfaExceptionVO.setBzcPropNo(vo.getPropNo());// Basic Proposal No.  
                       rfaExceptionVO.setCpyTpCd("C");//Basic BBE 생성 방법 C ( 무조건 고정값 )
                       rfaExceptionVO.setCreOfcCd(account.getOfc_cd());
                       rfaExceptionVO.setCreUsrId(account.getUsr_id());
                       demdetCommand.copyMstRfaVerToBzcRfaVer(rfaExceptionVO);
                  }
               }
           }

			
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	

    /**
     * ESM_PRI_2003 : Basic RFA  Request <br>
     * Basic RFA Request시 Dem/Det Exception New Version이 있는지 확인한다.. <br>
     * 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckDemDetExceptionNewVer(Event e) throws EventException {
        EsmPri2003Event event = (EsmPri2003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RFAExceptionTariffMgtBC command            = new RFAExceptionTariffMgtBCImpl();
        RFAProposalMainBC command01 = new RFAProposalMainBCImpl();

        try {
            List<MasterInfoFromBasicVO> info = command01.searchMasterInfoFromBasicRFA(event.getPriRpMnVO());
            boolean isMstRfaVerUppr = command.isUpprMstRfaVerThanBzcRfaVer(info.get(0).getMstPropNo(), info.get(0).getPropNo());
            eventResponse.setETCData("MST_RFA_VER_UPPR_YN", isMstRfaVerUppr ? "Y" : "N");    
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }

        return eventResponse;
    }

	
}
