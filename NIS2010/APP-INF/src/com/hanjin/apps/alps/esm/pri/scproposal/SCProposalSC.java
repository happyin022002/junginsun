/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCProposalSC.java
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
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - Ori/Dest , LOC Group, CMDT Group, Arbitrary, GOH 5개 Terms를 Scope별로 한번에 Quick Accept 가능하도록 기능 추가.
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
* 2011.05.03 김민아 [CHM-201110615-01] S/C Proposal에서 Filed 상태의 Sales rep 수정시 EDI WEB 과의 데이터 불일치 발생에 따른 수정 - Save, Cancel Filing 이벤트 발생시 EDI WEB 호출 추가
* 2011.05.11 김민아 [CHM-201110738-01] Quick Accept All 실행시 GOH Final Rate 데이터 copy 되도록 수정요청 : ARB Update 오류 - 파라미터 prop_sts_cd 추가
* 2011.06.24 김민아 [CHM-201111756-01] SC, RFA 정보 CRM I/F 주기 변경 요청 - File시 Sales Lead No 유무에 상관없이 해당 정보를 CRM으로 전송 및 Filed 상태에서 Save시 S.Rep 이 변경되었을 경우 CRM으로 전송 추가
* 2011.07.01 서미진 [CHM-201111837]  R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.08.04 서미진 [선처리 후 CSR]  COA architecture 위반 수정에 따른 에러 수정
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발(ESM_PRI_0087)
* 2011.10.05 서미진 [CHM-201113544] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완
* 2011.10.18 서미진 [CHM-201113907] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완개발요청 [Inquiry 화면] (ESM_PRI_0041)
* 2011.11.11 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
* 2012.02.23 이석준 [CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
* 2012.04.18 이석준 [CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
* 2012.09.18 원종규 [CHM-201220110-01] 계약 변경 통보 기능-계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
* 2013.01.15 이은섭 [CHM-201322418-01] SC fling cancel 기능 관련 변경 요청
* 2013.06.14 송호진 [CHM-201325245] 조직코드 변경 및 병행 관리 관련 기존 코드에 신규 코드 추가. 6 월 말 기존 코드 삭제 예정 ( CAM -> CCM, CTA -> CCA, CTE,CTI -> CCE, COS -> CCS, CGS -> CCB )
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2013.10.21 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가 
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
* 2014.04.29 전윤주 [CHM-201430072] s/c note conversion의 effective date 로직 보완
* 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
* 2014.08.18 송호진 [CHM-201431411] Split 01-S/C Note conversion상에 컬럼 추가 - Rate indicator 앞 Pattern type 컬럼 추가 및 autorating 로직 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.11.20 송호진 [CHM-201432557] S/C scope duration 로직 수정 - 신규 Svc Scp 의 경우 PRI_SP_SCP_DUR.CTRT_EFF_DT Update, Delete Button Enable
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
* 2015.06.24 최성환 [CHM-201535810] Fixed Rate 계약 정보를 SPC로 I/F 적용 개발
* 2015.06.25 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) 
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
* 2015.09.21 현성길 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2016.01.15 [CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건 
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.vo.CstPriCrmSlsLdVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic.StandardWordingBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic.StandardWordingBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBC;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.basic.SCAffiliateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.basic.SCAffiliateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.event.EsmPri0025Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.event.EsmPri0048Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.event.EsmPri005709Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.basic.SCBoilerPlateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.basic.SCBoilerPlateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0023Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0047Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri005713Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0074Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic.SCContractPartyProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic.SCContractPartyProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0017Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0022Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri005717Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri005718Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0078Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic.SCDurationProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic.SCDurationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.event.EsmPri0019Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.event.EsmPri005701Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.basic.SCGOHChargeProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.basic.SCGOHChargeProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.event.EsmPri000306Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.event.EsmPri000406Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.event.EsmPri005708Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.basic.SCGRICalculationProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.basic.SCGRICalculationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0066Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0081Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0082Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0109Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0112Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0113Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcRateActualCustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic.SCGroupCommodityProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic.SCGroupCommodityProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.event.EsmPri000303Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.event.EsmPri000403Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.event.EsmPri005705Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic.SCGroupLocationProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic.SCGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.event.EsmPri000302Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.event.EsmPri000402Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.event.EsmPri005714Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration.SCGroupLocationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.basic.SCLoadingAgentProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.basic.SCLoadingAgentProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.event.EsmPri000307Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.event.EsmPri000407Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.event.EsmPri005710Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltSvcScpCdCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic.SCMQCProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic.SCMQCProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.event.EsmPri0020Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.event.EsmPri005702Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic.SCNoteConversionProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0031Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0032Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0033Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0052Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0054Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0055Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0100Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0101Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0102Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriSpMnConvAuthFlagVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.basic.SCNoteProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.basic.SCNoteProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000309Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000310Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000408Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000410Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri005712Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri0089Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.Esm0680001Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0003Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0004Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0015Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0018Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0028Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0034Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0036Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0037Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0056Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0057Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0058Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0063Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0087Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0096Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0122Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0123Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri6090Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpScpDelCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtEFFListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri000308Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri000409Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0026Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0027Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0029Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri005706Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0069Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0070Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0091Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0093Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0094Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0097Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri0099Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6016Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6017Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6018Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6019Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6020Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6021Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6022Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6050Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6051Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6086Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltAllRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCheckSurchargeNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRateTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtRoutListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.basic.SCRealCustomerProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.basic.SCRealCustomerProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.event.EsmPri0040Event;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.event.EsmPri0041Event;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.RsltRealCustInquiryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.basic.SCRoutePointProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.basic.SCRoutePointProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.event.EsmPri000301Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.event.EsmPri000401Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.event.EsmPri005704Event;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic.SCTransportationAdditionalChargeProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic.SCTransportationAdditionalChargeProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000304Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000305Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000404Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000405Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri0024Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri005707Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri005715Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri0068Event;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBC;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBC;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
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
import com.hanjin.syscommon.common.table.PriScNoteConvVO;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpAfilVO;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSpBlplVO;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpFileCxlHisVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpInqRecVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpGohChgVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.syscommon.common.table.PriSpSubMqcVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;


/**
 * NIS2010-SCProposal Business Logic ServiceCommand - NIS2010-SCProposal 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Byeon Young Joo
 * @see SCGroupLocationProposalDBDAO
 * @since J2EE 1.4
 */
 
public class SCProposalSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /** 
     * SCProposal system 업무 시나리오 선행작업<br>
     * ESM_PRI_0003_02업무 시나리오 호출시 관련 내부객체 생성<br>
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
     * ESM_PRI_0003_02 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("SCProposalSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * NIS2010-SCProposal system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("EsmPri000302Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupLocationList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupLocationDetailList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchGroupLocationRateApplyList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchGroupLocationRateAcceptedList(e);
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
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0003Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMain(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchProposalAmendmentSummary(e);
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
                eventResponse = searchProposalMainSaleLeadFirstList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                eventResponse = searchProposalMainSaleLeadList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
                eventResponse = searchProposalMainCustTypeChkList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                eventResponse = searchPerformance(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
                eventResponse = comBakEndJbVOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
                eventResponse = comBackEndJbSearchListGetResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
                eventResponse = searchProposalMainPRSCMData(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
                eventResponse = searchProposalMainInitCancelCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
                eventResponse = searchProposalMainStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
                eventResponse = searchProposalRequestCancelCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
                eventResponse = searchProposalMainInitCancelChssCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
                eventResponse = searchCheckChssList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
                eventResponse = searchProposalMainInitCancelChssEffDtCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
                eventResponse = searchProposalRouteCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
            	//[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직 
                eventResponse = searchAffiliateTypeDupCheck(e);               
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
            	//20170406 안혜인 과장님 요청으로 C/T Availible 까지 남은 시간 표기
            	//개발 : 송민석
            	eventResponse =searchCorrectionLimitTime(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProgRequestList(e);                
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageProposal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = counterofferProposal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = approveProposal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = cancelProposal(e);
//            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
//                eventResponse = manageProposalAmendmentSummary(e);
//            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
//                eventResponse = manageProposalScopeAmendmentSummary(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
                eventResponse = changeConversionFlg(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {
                eventResponse = cancelFilingForSuperuser(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) {
                eventResponse = quickAcceptAllTerms(e);
            } else{
                eventResponse = initMainComboData(e);  // 화면 최초 호출 시 실행
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmPri0036Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalAmendList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAmendCheckProposalStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = amendProposal(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0037Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalAmendEffList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAmendEffCheckProposalStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageEffectiveDate(e);
            }            
            // ============================ESM_PRI_0019_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalDurationList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageProposalDuration(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptProposalDuration(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelProposalDuration(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
                eventResponse = acceptAllProposalDuration(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
                eventResponse = cancelAllProposalDuration(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalScopeCheckList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalDurationAmendCheckList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchProposalDurationScopeCount(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchDurScopeCount(e);      
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchMainDuration(e);            
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = searchScopeDuration(e);                      
            }else{
                eventResponse = initDurComboData(e);
            }
            // =============================ESM_PRI_0019_end===================================
            // ============================ESM_PRI_0017_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0017Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalContractCustomerTypeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageProposalContractCustomerType(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptProposalContractCustomerType(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelProposalContractCustomerType(e);
            }else{
                eventResponse = initCustTpComboData(e);
            }
            // =============================ESM_PRI_0017_end===================================
            // ============================ESM_PRI_0057_17_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri005717Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalContractCustomerTypeHistoryList(e);
            }
            // =============================ESM_PRI_0057_17_end===================================
            // ============================ESM_PRI_0022_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0022Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalContractPartyList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = getFileKey(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchProposalContractPartyTypeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchProposalContractPartyFont(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageProposalContractParty(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptProposalContractParty(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelProposalContractParty(e);
            }else{
                eventResponse = initCtrtPtyComboData(e);
            }
            // =============================ESM_PRI_0022_end===================================

            // ============================ESM_PRI_0020_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0020Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMQCList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageProposalMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptProposalMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelProposalMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalSubMQCList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageProposalSubMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
                eventResponse = acceptProposalSubMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
                eventResponse = cancelProposalSubMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
                eventResponse = acceptAllProposalMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
                eventResponse = cancelAllProposalMQC(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchSumScopeMqc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchSumScopeAllMqc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchScopeCount(e);                
            }else{
                eventResponse = initMqcComboData(e);  // 화면 최초 호출 시 실행
            }

            // =============================ESM_PRI_0020_end===================================
            // ============================ESM_PRI_0023_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0023Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBoilerPlateHeader(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchBoilerPlateList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageBoilerPlate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptBoilerPlate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelBoilerPlate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBoilerPlateDetailList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
                eventResponse = acceptBoilerPlateContent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
                eventResponse = cancelBoilerPlateContent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchBoilerPlateListExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchDetailAccept(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {
                eventResponse = copyGuidelineBoilerPlate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
                eventResponse = acceptAllBoilerPlate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
                eventResponse = cancelAllBoilerPlate(e);
            }else {
                eventResponse = initBoilerComboData(e);
            }
            // =============================ESM_PRI_0023_end===================================
            // ============================ESM_PRI_0025_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0025Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAffiliateList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // FileUpload 하기위한 FileKey 가져오기
            	eventResponse = getFileKey(e);
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
            } else{
                eventResponse = initAffilComboData(e);
            }
            // =============================ESM_PRI_0025_end===================================
            // ============================ESM_PRI_0057_09_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri005709Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAffiliateHistoryList(e);
            }else{
                eventResponse = initAffiliateHistory(e);
            }
            // =============================ESM_PRI_0057_09_end===================================
            // ============================ESM_PRI_0096_Start====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0096Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalCopyList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyProposal(e);
            }
            // =============================ESM_PRI_0096_end===================================

        } else if (e.getEventName().equalsIgnoreCase("EsmPri0089Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchContractClauseStdWordingList(e);
            } else {
                eventResponse = searchItemCodeList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000304Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchArbitraryChargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkGuidelineCopyArbitraryChargeExist(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkArbitraryFontStyle(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //guideline copy
                eventResponse = copyGuidelineArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = acceptArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = cancelArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
                eventResponse = acceptAllArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
                eventResponse = cancelAllArbitraryCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
                eventResponse = acceptAllArbitraryChargeFast(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {
                eventResponse = cancelAllArbitraryChargeFast(e);
            } else {
                eventResponse = initArbitraryComboData(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000305Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIHCChargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkIHCFontStyle(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageIHCCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = acceptIHCCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = cancelIHCCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
                eventResponse = acceptAllIHCCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
                eventResponse = cancelAllIHCCharge(e);
            } else {
                eventResponse = initIHCComboData(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000306Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGOHChargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkGuidelineGOHChargeExist(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageGOHCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = copyGuidelineGOHCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = acceptGOHCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = cancelGOHCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
                eventResponse = acceptAllGOHCharge(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
                eventResponse = cancelAllGOHCharge(e);
            } else {
                eventResponse = initGOHComboData(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000301Event")) {
            // ============================ESM_PRI_0003_01_Start====================================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRoutePointLocationList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRoutePointLocationType(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = acceptAllRoutePoint(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = cancelAllRoutePoint(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = acceptRoutePointLocation(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
                eventResponse = cancelRoutePointLocation(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRoutePointLocation(e);
            } else {
                eventResponse = searchCommonRoutePointLocationList(e);
            }

            // =============================ESM_PRI_0003_01_end=====================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000303Event")) {
            // ============================ESM_PRI_0003_03_Start====================================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupCommodityList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupCommodityDeatilList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchGroupCommodityRateApplyList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchGroupCommodityRateAcceptedList(e);
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
            }
            // ============================ESM_PRI_0003_03_end======================================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0063Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGRIGroupCommodityList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGRIGroupCommodityDetailList(e);
            } else {
                eventResponse = searchGRIGroupCommodityInitData(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000308Event")) {
            // ================== ESM_PRI_0003_08 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRateCommodityList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRateRouteList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchRateList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = executeCalculate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = monitorCalculate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchRateListVerticalExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchRateListHorizontalExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                eventResponse = checkGlineCopyGroupCodeExist(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
                eventResponse = searchRateCmdtRoutStyle(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
                eventResponse = searchRateType(e);
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
            } else {
                eventResponse = initRateComboData(e);
            }
            // ================== ESM_PRI_0003_08 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri005706Event")) {
            // ================== ESM_PRI_0057_06 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRateCommodityHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRateRouteHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchRateHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
                eventResponse = searchRateHistoryType(e);
            } else {
                eventResponse = initRateComboData(e);
            }
            // ================== ESM_PRI_0057_06 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000409Event")) {
            // ================== ESM_PRI_0004_09 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRateCommodityInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRateRouteInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchRateInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
                eventResponse = searchRateInquiryType(e);
            } else {
                eventResponse = initRateComboData(e);
            }
            // ================== ESM_PRI_0004_09 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0026Event")) {
            // ================== ESM_PRI_0026 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptRateCommodityDetail(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelRateCommodityDetail(e);
            }
            // ================== ESM_PRI_0026 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0027Event")) {
            // ================== ESM_PRI_0027 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptRateRoutePntVia(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelRateRoutePntVia(e);
            }
            // ================== ESM_PRI_0027 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0029Event")) {
            // ================== ESM_PRI_0029 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkRateExcelVertical(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = uploadRateExcelVertical(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = uploadRateExcelVerticalOnline(e);
            } else {
                eventResponse = initRateExcelVertical(e);
            }
            // ================== ESM_PRI_0029 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0066Event")) {
            // ================== ESM_PRI_0066 START ==================
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
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
                eventResponse = deleteGRICalculation(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageGRICopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = manageGRIPaste(e);
            }
            // ================== ESM_PRI_0066 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0112Event")) {
            // ================== ESM_PRI_0112 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGRICalculationHeaderHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGRICalculationHistoryList(e);
            }
            // ================== ESM_PRI_0112 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0070Event")) {
            // ================== ESM_PRI_0070 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptActualCustomer(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelActualCustomer(e);
            }
            // ================== ESM_PRI_0070 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0091Event")) {
            // ================== ESM_PRI_0091 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptRateCnote(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelRateCnote(e);
            }
            // ================== ESM_PRI_0091 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0093Event")) {
            // ================== ESM_PRI_0093 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAllRateList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptAllRate(e);
            }
            // ================== ESM_PRI_0093 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0094Event")) {
            // ================== ESM_PRI_0094 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptRateRouteDirCallDetail(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelRateRouteDirCallDetail(e);
            }
            // ================== ESM_PRI_0094 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0097Event")) {
            // ================== ESM_PRI_0097 START ==================
            if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = acceptRateCommodityRnote(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelRateCommodityRnote(e);
            }
            // ================== ESM_PRI_097 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0099Event")) {
            // ================== ESM_PRI_0099 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkRateExcelHorizontal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = uploadRateExcelHorizontal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = uploadRateExcelHorizontalOnline(e);
            } else {
                eventResponse = initRateExcelHorizontal(e);
            }
            // ================== ESM_PRI_0099 END ==================
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000307Event")) {
            // ============================ESM_PRI_0003_07_Start========
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchLoadingAgentList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageLoadingAgent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = acceptAllLoadingAgent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = cancelAllLoadingAgent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                eventResponse = acceptLoadingAgent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
                eventResponse = cancelLoadingAgent(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
            	eventResponse = getFileKey(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSvcScpCdCount(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // =============================ESM_PRI_0003_07_end==========
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000309Event")) {
            // ============================ESM_PRI_0003_09_Start========
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchNoteHeader(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchNoteList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteContentList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyGuidelineNote(e);
            } else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {
                eventResponse = manageStandardNote(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = modifyStandardNote(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
                eventResponse = cancelStandardNote(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // =============================ESM_PRI_0003_09_end==========
        } else if (e.getEventName().equalsIgnoreCase("EsmPri000310Event")) {
            // ============================ESM_PRI_0003_10_Start========
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSpecialNoteList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSpecialNoteContentList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteMaxDpSeq(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchNoteContentMaxDpSeq(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchSpecialNoteAcceptedList(e);
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
            } else {
                eventResponse = searchCommonNoteList(e);
            }
            // =============================ESM_PRI_0003_10_end==========
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0018Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchGuidelineCopyCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyScopeGuideline(e);
            } else {
                eventResponse = searchGuidelineCopySvcScpName(e);
            }
        }
            // ============================ESM_PRI_0074_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0074Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBoilerPlateExl(e);
            }
        }   // =============================ESM_PRI_0074_End===============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0015Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchMasterProposalList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkScNumberPrefix(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageMasterProposal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = cancelMasterProposal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = confirmMasterProposal(e);
            } else {
                eventResponse = initMasterProposal(e);
            }
        }


        // ============================ESM_PRI_0024_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0024Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                //eventResponse = searchExcelArbitraryChargeList(e);
                eventResponse = checkArbitraryDuplicate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchArbitraryLoadExcelDupList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCodeCheckResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageExcelArbitraryCharge(e);
            } else {
                eventResponse = initArbitraryComboData(e);
            }
            // =============================ESM_PRI_0024_end===================================
        }
        // ============================ESM_PRI_0068_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0068Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                //eventResponse = searchExcelIHCChargeList(e);
                eventResponse = checkIHCDuplicate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchIHCChargeLoadExcelDupList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchIhcCodeCheckResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageExcelIHCCharge(e);
            } else {
                eventResponse = initIHCComboData(e);
            }
            // =============================ESM_PRI_0068_end===================================
        }
        // ================== ESM_PRI_0069 START ==================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0069Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // paging 조회
                eventResponse = searchViewAllRatesListPaging(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){ // 일반조회
                eventResponse = searchViewAllRatesList(e);
            }
        }
        // ================== ESM_PRI_0069 END ==================
        // ============================ESM_PRI_0109_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0109Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {          // 상단 그리드 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // 하단 그리드 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLSubList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 히든 콤보 : 콤보 필터를 위한 데이터 조회
                eventResponse = searchPriSpScpTrspAddChgCombo1VOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // 적용가능 모든 GRI Calculation 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLAllList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // 적용가능 모든 Abitrary 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 상단 하단  그리드 저장
                eventResponse = managePriSpScpArbGriGrpVOS(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // 적용
                eventResponse = managePriSpScpTrspAddChgGriArbOKCLListVOS(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // 적용 취소
                eventResponse = managePriSpScpTrspAddChgGriArbOKCLCancleListVOS(e);
            }else{
                eventResponse = initSCProposalArbGri(e);
            }
        }   // =============================ESM_PRI_0109_End===============
        // ============================ESM_PRI_0113_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0113Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 상단 그리드 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // 하단 그리드 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLSubHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 히든 콤보 조회
                eventResponse = searchPriSpScpTrspAddChgCombo1VOHistory(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // 적용가능 모든 GRI Calculation 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLAllHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // 적용가능 모든 Abitrary 조회
                eventResponse = searchPriSpScpTrspAddChgGriArbOKCLArbitraryHistoryList(e);
            }
        }   // =============================ESM_PRI_0113_End===============
        // ============================esm_pri_0058_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0058Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalFilingList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchExpireDateCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchFmcConfirmDateCheck(e); //Save 버튼 활성화 전 체크
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCorrectionLimitCheck(e); //Correction 버튼 활성화 전 체크
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchInitFileDtCheck(e); //Correction 버튼실행 전 체크
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageProposalFiling(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = sendFmcFileContractDoStart(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = sendFmcFileCorrectedCopyDoStart(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
            	eventResponse = comBakEndJbVOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
            	eventResponse = comBackEndJbSearchListGetResult(e);                
			} 
            // =============================esm_pri_0058_End===================================
        }
        // =============================ESM_PRI_0031_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0031Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCommodityNoteConversionContentList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCommodityNoteConversionList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchCommodityNoteConversionListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageCommodityNoteConversion(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageCommodityNoteConversionCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageCommodityNoteChargeTypeCode(e);
            } else {
                eventResponse = searchCommonCommodityNoteConversionList(e);
            }
        }
        // =============================ESM_PRI_0032_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0032Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSNoteConversionContentList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteConversionList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchNoteConversionListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageNoteConversion(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageNoteConversionCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageNoteChargeTypeCode(e);
            } else {
                eventResponse = searchCommonNoteConversionList(e);
            }
        }
        // =============================ESM_PRI_0033_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0033Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRouteNoteConversionList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRouteNoteConversionListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageRouteNoteConversion(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageRouteNoteConversionCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageRouteNoteChargeTypeCode(e);
            } else {
                eventResponse = searchCommonRouteNoteConversionList(e);
            }
        }
        // =============================ESM_PRI_0100_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0100Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCommodityNoteConversionContentHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCommodityNoteConversionHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchCommodityNoteConversionHistoryListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageCommodityNoteConversionHistory(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageCommodityNoteConversionHistoryCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageCommodityNoteHistoryChargeTypeCode(e);
            } else {
                eventResponse = searchCommonCommodityNoteConversionHistoryList(e);
            }
        }
        // =============================ESM_PRI_0101_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0101Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRouteNoteConversionHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRouteNoteConversionHistoryListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageRouteNoteConversionHistory(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageRouteNoteConversionHistoryCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageRouteNoteHistoryChargeTypeCode(e);
            } else {
                eventResponse = searchCommonRouteNoteConversionHistoryList(e);
            }
        }
        // =============================ESM_PRI_0102_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0102Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSNoteConversionContentHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteConversionHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchNoteConversionHistoryListCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageNoteConversionHistory(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageNoteConversionHistoryCopy(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageNoteHistoryChargeTypeCode(e);
            } else {
                eventResponse = searchCommonNoteConversionHistoryList(e);
            }
        }
        // =============================esm_pri_0056_Start==============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0056Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalSCNumberMain(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = createaProposalSCNumber(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkProposalSCNumber(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkProposalPreFixNumber(e);
            }

        }
        // =============================ESM_PRI_0055_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0055Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSNoteConversionContentInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteConversionInquiryList(e);
            } else {
                eventResponse = searchCommonNoteConversionInquiryList(e);
            }
        }
        // =============================ESM_PRI_0054_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0054Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCommodityNoteConversionContentInpuiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCommodityNoteConversionInpuiryList(e);
            } else {
                eventResponse = searchCommonCommodityNoteConversionInpuiryList(e);
            }
        }
        // =============================ESM_PRI_0052_Start=============
        else if (e.getEventName().equalsIgnoreCase("EsmPri0052Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRouteNoteConversionInquiryList(e);
            } else {
                eventResponse = searchCommonRouteNoteConversionInquiryList(e);
            }
        }

        // ============================ESM_PRI_6016_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6016Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchCostDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                    eventResponse = searchCostDetailInquiryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPrsCost(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                    eventResponse = modifyPrsSimulationCost(e);
            }
            // =============================ESM_PRI_6016_end===================================
        }
        // ============================ESM_PRI_6021_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6021Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateCmViewAllList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPrsPfmc(e);
            }
            // =============================ESM_PRI_6021_end===================================
        }
        // ============================ESM_PRI_6022_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6022Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAmdtRateCmViewAllList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAmdtRateCmpbAndOpbViewAll(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyAmdtPrsPfmc(e);
            }
            // =============================ESM_PRI_6022_end===================================
        }

        // ============================ESM_PRI_6018_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6018Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateSurchargeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRateSurcharge(e);
            }
            // =============================ESM_PRI_6018_end===================================
        }
        // ============================ESM_PRI_6019_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSurchargeAdjustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCheckSurchargeNoteList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSurchargeAdjust(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageSurchargeAdjustCalc(e);
            }
            // =============================ESM_PRI_6019_end===================================
        }

        // ============================esm_pri_6050_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6050Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRateCommodityAllList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRateGroupCommodityDetailList(e);
            }
            // =============================esm_pri_6050_end===================================
        }
        // ============================esm_pri_6051_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6051Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRateLocationAllList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRateGroupLocationDetailList(e);
            }
            // =============================esm_pri_6051_end===================================
        }
        // ============================esm_pri_6017_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6017Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCostDetailByTransModeList(e);
            }
            // =============================esm_pri_6017_end===================================
        }
        // ============================esm_pri_6020_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6020Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateCmpbViewAllList(e);
            }
            // =============================esm_pri_6020_end===================================
        }

        // ============================esm_pri_0057_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0057Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAmendmentHistoryMain(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAmendmentHistoryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchHistoryAmendTermList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchAmendmentHistorySummary(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
   				//[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)::프린트 파일 오픈시 권한 확인
   				eventResponse = searchPrintOpenAuthInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageConversionUpdate(e);
            }else {
                eventResponse = initAmendHistoryInquiry(e);
            }
            // =============================esm_pri_0057_end===================================
        }

        // ============================esm_pri_0057_04Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005704Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRoutePointLocationHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRoutePointLocationHistoryType(e);
            } else {
                eventResponse = searchCommonRoutePointLocationList(e);
            }
            // =============================esm_pri_0057_04end==================================
        }
        // ============================ESM_PRI_0057_05Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005705Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupCommodityHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupCommodityDeatilHistoryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0057_05_end==================================
        }
        // ============================ESM_PRI_0057_10Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005710Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchLoadingAgentHistoryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0057_10_end==================================
        }
        // ============================ESM_PRI_0057_12Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005712Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchNoteHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchNoteContentHistoryList(e);
            } else {
                eventResponse = searchCommonNoteList(e);
            }
            // ============================ESM_PRI_0057_12_end==================================
        }
        // ============================ESM_PRI_0057_13_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005713Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchBoilerPlateHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBoilerPlateDetailHistoryList(e);
            }
            // =============================ESM_PRI_0057_13_end================================
        }
        // ============================ESM_PRI_0057_14Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005714Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupLocationHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupLocationDetailHistoryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0057_14_end==================================
        }

        // ============================ESM_PRI_0057_01_Start_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005701Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalDurationHistoryList(e);
            }
        }
        // =============================ESM_PRI_0057_01_Start_end===================================

        // ============================ESM_PRI_0057_02_Start_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005702Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMQCHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalSubMQCHistoryList(e);
            }
        }
        // =============================ESM_PRI_0057_01_Start_end===================================

        // ============================ESM_PRI_0057_07_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005707Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchArbitraryChargeHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkArbitraryHistoryFontStyle(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkArbitraryHistoryFontStyle(e);
            } else {
                eventResponse = initArbitraryComboData(e);
            }
        }
        // =============================ESM_PRI_0057_07_end===================================

        // ============================ESM_PRI_0057_15_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005715Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIHCChargeHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
               eventResponse = checkIHCHistoryFontStyle(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
               eventResponse = checkIHCHistoryFontStyle(e);
            } else {
                eventResponse = initIHCComboData(e);
            }
        }
        // =============================ESM_PRI_0057_15_end===================================

        // ============================ESM_PRI_0057_08_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005708Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchGOHChargeHistoryList(e);
            } else {
                eventResponse = initGOHComboData(e);
            }
        }
        // =============================ESM_PRI_0057_08_end===================================

        // ============================ESM_PRI_0057_18_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri005718Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalContractPartyHistoryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchProposalContractPartyHistoryFont(e);
            }
        }
        // =============================ESM_PRI_0057_18_end===================================

        // ============================ESM_PRI_0004_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0004Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalMainInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMainInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalCustomerInfoInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchProposalScopeAmendmentSummaryInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                eventResponse = searchPerformanceInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
                eventResponse = comBakEndJbVOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
                eventResponse = comBackEndJbSearchListGetResult(e);
            } else {
                eventResponse = initProposalInquiry(e);
            }
        }
        // ============================ESM_PRI_0004_End====================================



        // ============================esm_pri_0004_01Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000401Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRoutePointLocationInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRoutePointLocationInquiryType(e);
            } else {
                eventResponse = searchCommonRoutePointLocationList(e);
            }
            // =============================esm_pri_0004_01end==================================
        }
        // ============================ESM_PRI_0004_02Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000402Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupLocationInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupLocationDetailInquiryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0004_02_end==================================
        }
        // ============================ESM_PRI_0004_03Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000403Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGroupCommodityInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchGroupCommodityDeatilInquiryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0004_03_end==================================
        }
        // ============================ESM_PRI_0004_07Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000407Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchLoadingAgentInquiryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0004_07_end==================================
        }
        // ============================ESM_PRI_0004_08Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000408Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchNoteInquiryHeader(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchNoteInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchNoteContentInquiryList(e);
            } else {
                eventResponse = initAmendSourceStatusCodeList(e);
            }
            // ============================ESM_PRI_0004_08_end==================================
        }
        // ============================ESM_PRI_0004_10Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000410Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSpecialNoteInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSpecialNoteContentInquiryList(e);
            } else {
                eventResponse = searchCommonNoteList(e);
            }
            // ============================ESM_PRI_0004_10_end==================================
        }

        // ============================ESM_PRI_0047_Start====================================
       else if (e.getEventName().equalsIgnoreCase("EsmPri0047Event")) {
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//                eventResponse = searchBoilerPlateHeaderInquiry(e);
//            }else
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchBoilerPlateInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBoilerPlateDetailInquiryList(e);
            }else {
                eventResponse = initBoilerInquiryComboData(e);
            }
       }
        // =============================ESM_PRI_0047_end===================================

        // ============================ESM_PRI_0048_Start====================================
     else if (e.getEventName().equalsIgnoreCase("EsmPri0048Event")) {
        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            eventResponse = searchAffiliateInquiryList(e);
        } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            eventResponse = searchManualCheckInquiry(e);
        }else{
            eventResponse = initAffilInquiryComboData(e);
        }
     }
        // =============================ESM_PRI_0048_end===================================

        // =============================ESM_PRI_0078_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0078Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalContractPartyInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchProposalContractPartyFontInquiry(e);
            }else{
                eventResponse = initCtrtPtyInquiryComboData(e);
            }
        }
        // =============================ESM_PRI_0078_end===================================

        // =============================ESM_PRI_000404_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000404Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchArbitraryChargeInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkArbitraryInquiryFontStyle(e);
            } else {
                eventResponse = initArbitraryComboData(e);
            }
        }
        // =============================ESM_PRI_000404_start===================================

        // =============================ESM_PRI_000405_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000405Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIHCChargeInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkIHCInquiryFontStyle(e);
            } else {
                eventResponse = initIHCComboData(e);
            }
        }
        // =============================ESM_PRI_000405_end  ===================================

        // =============================ESM_PRI_000406_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri000406Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchGOHChargeInquiryList(e);
            } else {
                eventResponse = initGOHComboData(e);
            }
        }
        // =============================ESM_PRI_000406_end  ===================================

        // =============================ESM_068_0001_start===================================
        else if (e.getEventName().equalsIgnoreCase("Esm0680001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = receiveNISProposalInfo(e);
            }
        }
        // =============================ESM_068_0001_end  ===================================
        // =============================ESM_PRI_6086_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6086Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSurchargeViewAllList(e);
            }
        }
        // =============================ESM_PRI_6086_end  ===================================
        
        // =============================ESM_PRI_6090_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6090Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchMQCEstimateList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCheckMQCEstimateList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageMQCEstimateList(e);
            }
        }
        // =============================ESM_PRI_6091_end  ===================================
        
        // =============================ESM_PRI_6023_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6023Event")) {
            eventResponse = initPreCMSimulation(e);        	
         }
        // =============================ESM_PRI_6023_end  ===================================
        
        // ============================ESM_PRI_0087_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0087Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMainViewInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchProposalScopeAmendmentSummaryViewInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                eventResponse = searchPerformanceViewInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
                eventResponse = comBakEndJbVOs(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
                eventResponse = comBackEndJbSearchListGetResult(e);
            }
        }
        // ============================ESM_PRI_0087_End====================================
        
        // =============================ESM_PRI_0040_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0040Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRealCustomerList(e);        	
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	 eventResponse = searchProposalCustomerInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
           	 eventResponse = searchAffiliateLoadingagentInfo(e);	 
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRealCustomer (e);
            }else{
                eventResponse = initRealCustomerComboData(e);  // 화면 최초 호출 시 실행
            }
         }
        // =============================ESM_PRI_0040_end  ===================================
        
        // =============================ESM_PRI_0041_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0041Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRealCustomerList(e);        	
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	 eventResponse = searchProposalCustomerInfo(e);
            }
         }
        // =============================ESM_PRI_0041_end  ===================================
        // =============================ESM_PRI_0122_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0122Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchFiledCancelHistoryList(e);        	
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	 eventResponse = manageFiledCancelProposal(e);
            }
         }
        // =============================ESM_PRI_0122_end  ===================================       
        // =============================ESM_PRI_0123_start===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0123Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchFiledCancelHistoryInquiryList(e);        	
            }
         }
        // =============================ESM_PRI_0123_end  ===================================
        
        // =============================ESM_PRI_0028_start  ===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0028Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDownloadRecord(e);        	
            }
         }
        // =============================ESM_PRI_0028_end  ===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0081Event")) {
        // ================== ESM_PRI_0081 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSCActualCustomerList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri0082Event")) {
        // ================== ESM_PRI_0082 START ==================
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSCActualCustomerInquiryList(e);
            }
        }      
        // =============================ESM_PRI_0028_start  ===================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri0034Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOpenRecord(e);            
            }
         }
        return eventResponse;
    }

	// =============================esm_pri_0003_03_Start===================================


    /**
     * UI_PRI_0003_03 : Retrieve <br>
     * GroupLocation을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltGrpLocListVO> list = command.searchGroupLocationList(event.getPriSpScpGrpLocVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Sheet1_SelectCell<br>
     * Group Location Detail을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailList(event.getPriSpScpGrpLocDtlVO());
        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Save<br>
     * Group Location 삭제시 Rate 에서 삭제할 GroupLocation을 사용하는지 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationRateApplyList(Event e)
            throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltGrpLocListVO> list = command.searchGroupLocationRateApplyList(event
                    .getPriSpScpGrpLocVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Save<br>
     * Group Location 삭제시 Accepted 된 데이터가 포함되는지 반환합니다 <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationRateAcceptedList(Event e)
            throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltGrpLocListVO> list = command.searchGroupLocationRateAcceptedList(event
                    .getPriSpScpGrpLocVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * UI_PRI_0003_10 : Save<br>
     * Group Location 삭제시 Accepted 된 데이터가 포함되는지 반환합니다 <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSpecialNoteAcceptedList(Event e) throws EventException {
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltNoteCtntListVO> list = command.searchSpecialNoteAcceptedList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Accept All <br>
     * Group Location을 모두 Accept합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        String result = "";

        try {
            begin();
            result = command.acceptAllGroupLocation(event.getPriSpScpGrpLocDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
        log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("result", result);
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Cancel All <br>
     * Accept 된 Group Location 데이터를 모두 Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        String result = "";

        try {
            begin();
            result = command.cancelAllGroupLocation(event.getPriSpScpGrpLocDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
        log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }

        eventResponse.setETCData("result", result);
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Accept  <br>
     * Group Location을 Accept 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptGroupLocation(event.getPriSpScpGrpLocDtlVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Cancel <br>
     * Accept 된 Group Location을 Cancel 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelGroupLocation(event.getPriSpScpGrpLocDtlVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : G/L Copy  멀티 이벤트 처리<br>
     * SCGroupLocationProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.copyGuidelineGroupLocation(event.getPriSpScpGrpLocDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * UI_PRI_0003_03 : Save <br>
     * Group Location을 추가/수정/삭제합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageGroupLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000302Event event = (EsmPri000302Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageGroupLocation(event.getGrpLocPropVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("13");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
        log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // =============================esm_pri_0003_03_End===================================

    /**
     * ESM_PRI_0003 : Retrieve<br>
     * S/C Main을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMain(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltPropListVO vo = command.searchProposalMain(event.getPriSpHdrVO(), account);
       
            eventResponse.setRsVoList(vo.getRsltPropMnVOs());
            eventResponse.setRsVoList(vo.getRsltPropMnScpListVOs());
            //ctrt_cust_sls_ofc_cd
            if (vo.getRsltPropMnVOs() != null && vo.getRsltPropMnVOs().size() > 0){
                PRICommonBC command1 = new PRICommonBCImpl();
                RsltCdListVO cdVo = new RsltCdListVO();
                cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getPropOfcCd());
                List<RsltCdListVO> list = command1.searchSalesRepByOfficeList(cdVo);
                eventResponse.setRsVoList(list);

                cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getCtrtCustSlsOfcCd());
                cdVo.setEtc2(vo.getRsltPropMnVOs().get(0).getCustCntCd());
                cdVo.setEtc3(vo.getRsltPropMnVOs().get(0).getCustSeq());
                List<RsltCdListVO> list1 = command1.searchSalesRepListByCustOnly(cdVo);
                eventResponse.setRsVoList(list1);

                cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getRealCustSlsOfcCd());
                cdVo.setEtc2(vo.getRsltPropMnVOs().get(0).getRealCustCntCd());
                cdVo.setEtc3(vo.getRsltPropMnVOs().get(0).getRealCustSeq());
                List<RsltCdListVO> list2 = null;
                if (!vo.getRsltPropMnVOs().get(0).getRealCustSlsOfcCd().equals("")){
                    list2 = command1.searchSalesRepListByCustOnly(cdVo);
                }
                eventResponse.setRsVoList(list2);
                RsltCdListVO schVo = new RsltCdListVO();
                for (int i = 0; i < vo.getRsltPropMnScpListVOs().size();i++){
                    schVo.setEtc1(vo.getRsltPropMnScpListVOs().get(i).getPropScpOfcCd());
                    List<RsltCdListVO> list3 = command1.searchSalesRepByOfficeList(schVo);
                    eventResponse.setRsVoList(list3);
                }
                // S/C 조회 LOG 저장 시작 [20171227][CSR #2875] //
                // ESM_PRI_0003  :  Sales Management > Pricing > Service Contract > S/C Creation > S/C Proposal & Amendment Creation 
                PriSpInqRecVO priSpInqRecVO = new PriSpInqRecVO();
                priSpInqRecVO.setPropNo(vo.getRsltPropMnVOs().get(0).getPropNo());
                priSpInqRecVO.setAmdtSeq(vo.getRsltPropMnVOs().get(0).getAmdtSeq());
                priSpInqRecVO.setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
                priSpInqRecVO.setSpScrnEvntPgmCd("ESM_PRI_0003");
                command.manageInquiryRecord(priSpInqRecVO, account);
                // S/C 조회 LOG 저장 종료 //
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 : Customer<br>
     * Customer Country Code와 Customer Seq로 Customer 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCustomerInfo(Event e) throws EventException {
        SchCustVO paramVo = new SchCustVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri0003Event")) {
            EsmPri0003Event event = (EsmPri0003Event) e;
            paramVo = event.getSchCustVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0015Event")) {
            EsmPri0015Event event = (EsmPri0015Event) e;
            paramVo = event.getSchCustVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0040Event")) {
            EsmPri0040Event event = (EsmPri0040Event) e;
            paramVo = event.getSchCustVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0041Event")) {
            EsmPri0041Event event = (EsmPri0041Event) e;
            paramVo = event.getSchCustVO();
        }
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfo(paramVo);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

//    /**
//     * ESM_PRI_0003:Terms에서 호출<br>
//     * AmendmentSummary  를 자동으로 수정한다.<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//    private EventResponse manageProposalAmendmentSummary(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmPri0003Event event = (EsmPri0003Event) e;
//        SCProposalMainBC command = new SCProposalMainBCImpl();
//        int result = 0;
//        try {
//            begin();
//            command.manageProposalAmendmentSummary(event.getPriSpAmdtSmryVO(), account);
//            PriSpMnVO vo = new PriSpMnVO();
//            ObjectCloner.build(event.getPriSpAmdtSmryVO(), vo);
//            result = command.changeAutoRequestMainStatus(vo, account);
//            commit();
//        } catch (EventException ex) {
//            rollback();
//            throw ex;
//      } catch (Exception ex) {
//          rollback();
//          log.error("err " + ex.toString(), ex);
//          throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
//      }
//        eventResponse.setETCData("upd_cnt", String.valueOf(result));
//        return eventResponse;
//    }

//    /**
//     * ESM_PRI_0003:Scope Terms에서 호출<br>
//     * AmendmentScopeSummary  를 자동으로 수정한다.<br>
//     *TERMS가  모두 ACCEPT되었는지 확인하여 SCOPE MAIN의 상태를 ACCEPT로 변경한다.<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//    private EventResponse manageProposalScopeAmendmentSummary(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmPri0003Event event = (EsmPri0003Event) e;
//        SCProposalMainBC command = new SCProposalMainBCImpl();
//        int result = 0;
//        try {
//            begin();
//            command.manageProposalScopeAmendmentSummary(event.getPriSpScpAmdtSmryVO(), account);
//            PriSpScpMnVO scpVo = new PriSpScpMnVO();
//            ObjectCloner.build(event.getPriSpScpAmdtSmryVO(), scpVo);
//            int cnt = command.searchProposalScopeAcceptCheck(scpVo);
//            if (cnt == 0){//scope status accept change
//                PriSpScpMnVO[] priSpScpMnVO = new PriSpScpMnVO[1];
//                priSpScpMnVO[0] = new PriSpScpMnVO();
//                ObjectCloner.build(scpVo, priSpScpMnVO[0]);
//                priSpScpMnVO[0].setPropScpStsCd("A");//Accept로 변경
//                priSpScpMnVO[0].setIbflag("U");
//                command.modifyScopeStatus(priSpScpMnVO, account);
//            }else{
//                command.changeAutoScopeReturnStatus(scpVo, account);
//            }
//            PriSpMnVO vo = new PriSpMnVO();
//            ObjectCloner.build(event.getPriSpScpAmdtSmryVO(), vo);
//            result = command.changeAutoRequestMainStatus(vo, account);
//            commit();
//        } catch (EventException ex) {
//            rollback();
//            throw ex;
//      } catch (Exception ex) {
//          rollback();
//          log.error("err " + ex.toString(), ex);
//          throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
//      }
//        eventResponse.setETCData("upd_cnt", String.valueOf(result));
//        return eventResponse;
//    }


    /**
     * ESM_PRI_0003:sheet2_OnSelectCell()<br>
     * Terms의 Summary 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalAmendmentSummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPropAmdtSmryVO> list = command.searchProposalAmendmentSummary(event.getPriSpAmdtSmryVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003:sheet2_OnSelectCell<br>
     * Scope Terms의 Summary 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeAmendmentSummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummary(event.getPriSpScpAmdtSmryVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }


    /**
     * ESM_PRI_0003 : Save<br>
     * SCProposalMain을 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;

        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        SCMQCProposalBC command3 = new SCMQCProposalBCImpl();
        SCContractPartyProposalBC command4 = new SCContractPartyProposalBCImpl();
        CRMSalesLeadBC command5 = new CRMSalesLeadBCImpl();
        SCNoteConversionProposalBC command6 = new SCNoteConversionProposalBCImpl();
        SCRateProposalBC command7 = new SCRateProposalBCImpl();
        
        String propNo = "";
        try {
            begin();           
            PriSpMnVO[] mnVo  = event.getScPropMnVO().getPriSpMnVOs();
            
            //2011-07-01 서미진 R4J Rule Upgrade : 배열 접근시 첨자(index)는 유효한 범위내에서 사용하도록 변경
            PriSpMnVO tempMnVO = new PriSpMnVO();
            
            if(mnVo.length >0){
            	tempMnVO = mnVo[0];
            }
            //EDI WEB & CRM INTERFACE 위한 조건 조회
            int cnt = command1.searchCheckOfcSrepDiffList(tempMnVO);
            
            //sales lead
            String saleLeadOri =  event.getSaleLeadOri();
            CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
            ObjectCloner.build(tempMnVO, vo);
            log.debug("saleLeadOri=="+saleLeadOri+"  saleadno="+vo.getSlsLdNo());
            //Sale Lead 정보를 수정
            if (!vo.getSlsLdNo().equals(saleLeadOri)){
            	command5.manageSCCRMSalesLeadNo(vo, account);
            }            

            //note conv, duration 변경시  note Conversion의 duration을 변경한다.
            PriSpScpMnVO[] scpVo = event.getScPropMnVO().getPriSpScpMnVOs();
            
            /***********************************************************
           //[CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건
           PropPrPrFlg  = N 일경우만 해당 함수를 호출함.
              해당 케이스는 SC Copy 이후 날짜 적용 후면 바로 Y로 변경이 되므로 그전에 로직 체크가 필요함. 
           Copy 로직: 1.  Copy 버튼 클릭 후 해당 건을 copy 함. 
                      		   단, Note Conversion Data 의 Actual 기간은 : 9999.12.31 ~ 9999.12.31 로 초기값이 저장됨.
               			  2.  Duration 의 기간 입력 후 예) 2015-10-01 ~ 2015-10-31 로 입력 후 Save 버튼 클릭, 이전 데이터 복제 완료 됨.
                  		  3.  위의 2.처리시에 S/C NOTE Conversion Data 의 Actual effective Date 가 2015-10-01 로 업데이트 되어야 하는데 
                      		   위의 설명처럼 로직이 삭제되었으므로 업데이트가 정상적으로 처리되지 않음.
                          4.  따라서 Copy 시에만 해당  manageNoteConversionEffectiveDate 을 적용하도록 함.
           ***********************************************************/
            String propPrPrFlg = command1.searchPropPrprFlg(tempMnVO);
            log.debug("\n propPrPrFlg:["+propPrPrFlg+"]");
            if("N".equals(propPrPrFlg)){
            	//effective date를 변경하는 요건은 필요 없음 [CHM-201430072] 14.04.29
            	log.debug("\n CALL  - manageNoteConversionEffectiveDate~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            	command6.manageNoteConversionEffectiveDate(scpVo, account); 
            }
          
            command6.manageNoteConversionExpireDate(scpVo, account);

            //Scope 삭제전에 먼저 삭제한다.
            command2.manageProposalScopeDurationRemove(event.getScPropMnVO(), account);
            command3.manageProposalScopeMqcRemove(event.getScPropMnVO(), account);
            command7.manageProposalScopeSurchargeRemove(event.getScPropMnVO());
            //Scope Main 삭제
            command1.manageProposalRemove(event.getScPropMnVO(), account);

            //INSERT,UPDATE
            propNo = command1.manageProposal(event.getScPropMnVO(), account);
            command2.manageProposal(event.getScPropMnVO(), account);
            command3.manageProposal(event.getScPropMnVO(), account);
            command4.manageProposal(event.getScPropMnVO(), account);

          //SUMMARY TABLE UPDATE
            if (tempMnVO.getIbflag().equals("I")){
                PriSpAmdtSmryVO smryVo = new PriSpAmdtSmryVO();
                smryVo.setPropNo(propNo);
                smryVo.setAmdtSeq(tempMnVO.getAmdtSeq());
                smryVo.setPropTermTpCd("01");
                command1.manageProposalAmendmentSummary(smryVo, account);
                smryVo.setPropTermTpCd("02");
                command1.manageProposalAmendmentSummary(smryVo, account);
                smryVo.setPropTermTpCd("04");
                command1.manageProposalAmendmentSummary(smryVo, account);
                smryVo.setPropTermTpCd("07");
                command1.manageProposalAmendmentSummary(smryVo, account);
            }

            PriSpScpAmdtSmryVO scpSmryVO = new PriSpScpAmdtSmryVO();
            scpSmryVO.setPropNo(tempMnVO.getPropNo());
            scpSmryVO.setAmdtSeq(tempMnVO.getAmdtSeq());
            for (int i=0; i < scpVo.length; i++){
                if (scpVo[i].getIbflag().equals("I")){
                    scpSmryVO.setSvcScpCd(scpVo[i].getSvcScpCd());
                    scpSmryVO.setPropScpTermTpCd("11");
                    command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
                    scpSmryVO.setPropScpTermTpCd("12");
                    command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
                }
            }

            if(cnt > 0){
            	// INTERFACE : EDI WEB 으로 General Information을 전송
	            PriEdiScGenInfVO genInfVO = new PriEdiScGenInfVO();
	            ObjectCloner.build(tempMnVO, genInfVO);
	            genInfVO.setEaiSts("U");
	            command1.transferScGeneralInfo(genInfVO, account);
	            
	            // INTERFACE : CRM으로 Contract Information을 전송
// CRM Phase-out 됨에 따라 삭제 함 20171204 송민석	            
//	            PriSpMnVO priSpMnVO = new PriSpMnVO();
//	            ObjectCloner.build(tempMnVO, priSpMnVO);
//	            command1.transferScSalesLeadContractInfo(priSpMnVO, account);
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
        eventResponse.setETCData("prop_no", propNo);
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 : Approve<br>
     * Terms가 ACCEPT 되었는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalAcceptCheck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<PriSpMnVO> list = command.searchProposalAcceptCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003:Counter Offer<br>
     *  각 Terms의 상태가 Accepted, Returned인지 알기 위하여 상태코드가 I 가 하나라도 존재하는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCountOfferCheck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command0 = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltStatusVO> listCOffer = command0.searchCountOfferStatus(event.getPriSpMnVO());
            int cnt = 0;
            if (listCOffer != null && listCOffer.size() > 0){
                for (int i = 0; i< listCOffer.size(); i++){
                    RsltStatusVO vo = listCOffer.get(i);
                    cnt += Integer.parseInt(vo.getCnt()) ;
                }
            }
            RsltStatusVO rVo = new RsltStatusVO();
            rVo.setStatus("cnt");
            rVo.setCnt(String.valueOf(cnt));
            eventResponse.setRsVo(rVo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }


    /**
     * ESM_PRI_0003:Request<br>
     * Reqeust 시 필수 입력 데이터를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRequestTermsCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<CstRequestCheckVO> list = command.searchRequestTermsCheck(event.getPriSpMnVO());
            List<RequestCheckForCalculationVO> listCalc = command.searchRequestCheckCalculate(event.getPriSpScpMnVO());
            //Calculate를 하지 않은 내용이 존재 하므로 Exception처리 한다.
            if( listCalc != null && listCalc.size() > 0 ){
                String preSvcScpCd = "";
                String svcScpCd = "";
                StringBuffer strMsg = new StringBuffer();
                for(int i = 0 ; i < listCalc.size(); i++ ){
                    svcScpCd = listCalc.get(i).getSvcScpCd();
                    if( preSvcScpCd.equals(svcScpCd)){
                        strMsg.append(" & ").append("Special Rate");
                    }else if( "G".equals(listCalc.get(i).getGenSpclRtTpCd()) ){
                        strMsg.append("\n  ").append(svcScpCd).append(" ").append( "General Rate" );
                    }else{
                        strMsg.append("\n  ").append(svcScpCd).append(" ").append( "Special Rate" );
                    }
                    preSvcScpCd = svcScpCd;
                }
                //throw new EventException(new ErrorHandler("PRI03019",new String[]{strMsg.toString()}).getMessage());
                CstRequestCheckVO vo = new CstRequestCheckVO();
                vo.setTerms("CALC_CHK" );
                vo.setCnt("1");
                vo.setNote( strMsg.toString());
                list.add(vo);
            }


            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }



    /**
     * ESM_PRI_0003: Terms에서 호출<br>
     *  Terms의 데이터가 변경된 후 Scope의 상태를 변경하기 위하여 Scope의 status를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeStatusCheck(Event e) throws EventException {

        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<PriSpScpMnVO> list = command.searchProposalScopeStatusCheck(event.getPriSpScpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003: delete<br>
     *  Scope삭제시 각 Terms에 데이터가 있는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDeleteCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        //rate  ori/dest loc group cmdt group standard note,special note  L/agent  goh //arb,ihc
        SCProposalMainBC command = new SCProposalMainBCImpl();
        CstPriSpScpDelCntVO vo = new CstPriSpScpDelCntVO();
        int cnt = 0;
        try{
            cnt = command.searchProposalScopeDeleteCheck(event.getPriSpScpMnVO());
            vo.setDelcnt(String.valueOf(cnt));
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }



    /**
     * ESM_PRI_0003: Counter Offer<br>
     * Main의 상태를 변경한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse counterofferProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        String propStsCd = "";
        String userMsg = "";
        try {
            begin();
            PriSpMnVO[] mnVo = event.getScPropProgVO().getPriSpMnVOs();
            command.counterofferProposal(event.getScPropProgVO(), account);
            if (mnVo[0] != null) propStsCd = mnVo[0].getPropStsCd();
            //C/Offer 시  Main의 상태를 returned로 변경한다.
            if (mnVo[0] != null && propStsCd.equals("R")){
//                manageReturnStatus(e);            	
                //cnt 가 0보다 크다면 main을 returned로 변경한다.
                int cnt = 0;
                List<RsltReturnVO> list = command.searchProposalReturnedList(mnVo[0]);
                if (list != null && list.size() >0){
                    cnt++;
                }
                String propNo = mnVo[0].getPropNo();
                String amdtSeq = mnVo[0].getAmdtSeq();
                PriSpMnVO  priMn = new PriSpMnVO();
                priMn.setPropNo(propNo);
                priMn.setAmdtSeq(amdtSeq);
                if (cnt > 0){
                    priMn.setPropStsCd("R");
                }else{
                    priMn.setPropStsCd("Q");
                }
                command.modifyMainStatus(priMn, account);
            }
            //request 시 자동 Accept Proposal: duration,MQC,Customer Type,STANDARD NOTE,Rate direct call
             autoAcceptProposal(e);

             if (propStsCd.equals("Q")){
                 userMsg = "Request";
             }else if (propStsCd.equals("R")){
                 userMsg = "C/Offer";
             }

             //C/Offer,Request
             eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] {userMsg}).getUserMessage());
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
     * ESM_PRI_0003: Approve<br>
     * Main의 상태를 Approve로 변경한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse approveProposal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try {
            begin();
            command.approveProposal(event.getScPropProgVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] {"Approve"}).getUserMessage());
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
     * ESM_PRI_0003: Request<br>
     * Request시 자동 Accept를 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private void autoAcceptProposal(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;

        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        SCContractPartyProposalBC command3 = new SCContractPartyProposalBCImpl();
        SCMQCProposalBC command4 = new SCMQCProposalBCImpl();
        SCNoteProposalBC command5 = new SCNoteProposalBCImpl();
        SCRateProposalBC command6 = new SCRateProposalBCImpl();
        SCBoilerPlateProposalBC commandBoilerPlate = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try {

            //event.getPriSpScpDurVO();
            PriSpMnVO[] mnVo = event.getScPropProgVO().getPriSpMnVOs();
            PriSpScpMnVO[] mnScpVo = event.getScPropMnVO().getPriSpScpMnVOs();
            PriSpCtrtCustTpVO[] custTpVo = event.getScPropMnVO().getPriSpCtrtCustTpVOs();
            PriSpMqcVO[] mqcVo = event.getScPropMnVO().getPriSpMqcVOs();
            PriSpScpMqcVO[] mqcScpVo = event.getScPropMnVO().getPriSpScpMqcVOs();

            //request 시 자동 Accept Proposal
            // duration,MQC,Customer Type,STANDARD NOTE
            if (mnVo[0] != null && mnVo[0].getPropStsCd().equals("Q")  ){
                //duration
                PriSpScpDurVO priSpDurVO = new PriSpScpDurVO();
                PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();
                ObjectCloner.build(mnVo[0], priSpDurVO);
                priSpDurVO.setSvcScpCd("");
                priSpDurVO.setPrcProgStsCd("A");

                if (!mnVo[0].getAmdtSeq().equals("0")){
                    if (mnScpVo != null){
                        for (int i=0; i < mnScpVo.length; i++){
                            //standard note
                            PriSpScpNoteCtntVO noteVo = new PriSpScpNoteCtntVO();
                            ObjectCloner.build(mnScpVo[i], noteVo);
                            noteVo.setPrcProgStsCd("A");
                            noteVo.setNoteTpCd("T");
                            command5.acceptAllNote(noteVo, account);
                        }
                        PriSpScpAmdtSmryVO amdtScpVo = new PriSpScpAmdtSmryVO();
                        amdtScpVo.setPropNo(mnVo[0].getPropNo());
                        amdtScpVo.setAmdtSeq(mnVo[0].getAmdtSeq());
                        amdtScpVo.setPropScpTermTpCd("31");
                        //duration  ,MQC, STANDARD NOTE
                        command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
                    }

                }else{
                    command2.acceptProposalDuration(priSpDurVO, account);
                    if (mnScpVo != null){
                        for (int i=0; i < mnScpVo.length; i++){
                            ObjectCloner.build(mnScpVo[i], priSpScpDurVO);
                            priSpScpDurVO.setPrcProgStsCd("A");
                            command2.acceptProposalDuration(priSpScpDurVO, account);
                            //standard note
                            PriSpScpNoteCtntVO noteVo = new PriSpScpNoteCtntVO();
                            ObjectCloner.build(mnScpVo[i], noteVo);
                            noteVo.setPrcProgStsCd("A");
                            noteVo.setNoteTpCd("T");
                            //standard note
                            command5.acceptAllNote(noteVo, account);
                        }
                    }
                    //Boiler Plate
                    //모든 Data가 GC 일때만 자동 승인 대상이된다.
                    PriSpBlplVO priSpBlplVO = new PriSpBlplVO();
                    priSpBlplVO.setPropNo(mnVo[0].getPropNo() );
                    priSpBlplVO.setAmdtSeq(mnVo[0].getAmdtSeq());
                    int updateBoilerPlateCnt = commandBoilerPlate.autoAcceptProposalBoilerPlate(priSpBlplVO, account);
                    List<String> termList = new ArrayList<String>();
                    //Boiler Plate
                    //모든 Data가 GC 일때만 자동 승인 대상이된다.
                    if( updateBoilerPlateCnt != 0){
                    	termList.add("06"); //Boiler plate
                    }

                    //rate direct call
                    PriSpScpRtVO rtVo = new PriSpScpRtVO();
                    ObjectCloner.build(mnVo[0], rtVo);
                    rtVo.setPrcProgStsCd("A");
                    command6.acceptRateDirectCall(rtVo, account);
                    //contract party
                    PriSpCtrtCustTpVO custVo = new PriSpCtrtCustTpVO();
                    ObjectCloner.build(custTpVo[0], custVo);
                    custVo.setPrcProgStsCd("A");
                    command3.acceptProposalContractCustomerType(custVo, account);
                    //MQC
                    SchPriSpScpMqcVO sMqcVo = new SchPriSpScpMqcVO();
                    SchPriSpScpMqcVO sMqcScpVo = new SchPriSpScpMqcVO();
                    ObjectCloner.build(mqcVo[0], sMqcVo);
                    sMqcVo.setSvcScpCd("");
                    sMqcVo.setPrcProgStsCd("A");
                    sMqcVo.setFnlMqcQty(sMqcVo.getPropMqcQty());
                    command4.acceptProposalMQC(sMqcVo, account);
                    if (mqcScpVo != null){
                        for (int i = 0; i < mqcScpVo.length; i++){
                            ObjectCloner.build(mqcScpVo[i], sMqcScpVo);
                            sMqcScpVo.setPrcProgStsCd("A");
                            sMqcScpVo.setFnlMqcQty(sMqcScpVo.getPropScpMqcQty());
                            command4.acceptProposalMQC(sMqcScpVo, account);
                        }
                    }
                    //sub mqc accept
                    PriSpSubMqcVO subMqc = new PriSpSubMqcVO();
                    ObjectCloner.build(mqcVo[0], subMqc);
                    command4.autoAcceptProposalSubMQC(subMqc, account);


                    //main
                    PriSpAmdtSmryVO amdtVo = new PriSpAmdtSmryVO();
                    amdtVo.setPropNo(mnVo[0].getPropNo());
                    amdtVo.setAmdtSeq(mnVo[0].getAmdtSeq());
                    //duration  //mqc   //customertype
                    termList.add("01");//Duration
                    termList.add("02");//MQC
                    termList.add("03");//Sub-MQC
                    termList.add("07");//Customer Type
                    command.modifyProposalAutoAcceptAmendmentSummary(amdtVo,termList, account);
                    //Scop
                    PriSpScpAmdtSmryVO amdtScpVo = new PriSpScpAmdtSmryVO();
                    amdtScpVo.setPropNo(mnVo[0].getPropNo());
                    amdtScpVo.setAmdtSeq(mnVo[0].getAmdtSeq());
                    //duration  ,MQC, STANDARD NOTE
                    amdtScpVo.setPropScpTermTpCd("");
                    command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
                }

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
     * ESM_PRI_0003: Cancel<br>
     * 상태값을 Cancel하여 이전 상태로 변경한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();

        SCNoteProposalBC command3 = new SCNoteProposalBCImpl();
        SCRoutePointProposalBC command4 = new SCRoutePointProposalBCImpl();
        SCGroupCommodityProposalBC command5 = new SCGroupCommodityProposalBCImpl();
        SCLoadingAgentProposalBC command6 = new SCLoadingAgentProposalBCImpl();
        SCRateProposalBC command7 = new SCRateProposalBCImpl();
        SCGroupLocationProposalBC command8 = new SCGroupLocationProposalBCImpl();
        SCGOHChargeProposalBC command9 = new SCGOHChargeProposalBCImpl();
        SCTransportationAdditionalChargeProposalBC command10 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCAffiliateProposalBC command11 = new SCAffiliateProposalBCImpl();
        SCBoilerPlateProposalBC command12 = new SCBoilerPlateProposalBCImpl();
        SCContractPartyProposalBC command13 = new SCContractPartyProposalBCImpl();
        SCMQCProposalBC command14 = new SCMQCProposalBCImpl();
        SCGRICalculationProposalBC command15 = new SCGRICalculationProposalBCImpl();
        SCNoteConversionProposalBC command16 = new SCNoteConversionProposalBCImpl();
        CRMSalesLeadBC command17 = new CRMSalesLeadBCImpl();
        SCQuotationMainBC command18 = new SCQuotationMainBCImpl();
        SCBoilerPlateProposalBC commandBoilerPlate = new SCBoilerPlateProposalBCImpl();
        SCRealCustomerProposalBC command19 = new SCRealCustomerProposalBCImpl();
        try {
            begin();
            PriSpMnVO[] mnVo = event.getScPropProgVO().getPriSpMnVOs();
            PriSpScpMnVO[] mnScpVo = event.getScPropMnVO().getPriSpScpMnVOs();

            String stsCd = mnVo[0].getPropStsCd();

            if (!stsCd.equals("D")){
                command.cancelProposal(event.getScPropProgVO(), account); //메인 상태변경
//                
            }

            if (stsCd.equals("I")){
                    if (!mnVo[0].getAmdtSeq().equals("0")){
                        command2.manageProposalRequestCancel(mnVo[0], account);//duration
                        PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                        priSpAmdtSmryVO.setPropNo(mnVo[0].getPropNo());
                        priSpAmdtSmryVO.setAmdtSeq(mnVo[0].getAmdtSeq());
                        priSpAmdtSmryVO.setPropTermTpCd("01");
                        command.manageAmendmentSummary(priSpAmdtSmryVO, account);

                        command14.manageProposalRequestCancel(mnVo[0], account);//mqc
                        priSpAmdtSmryVO.setPropTermTpCd("02");
                        command.manageAmendmentSummary(priSpAmdtSmryVO, account);
                        priSpAmdtSmryVO.setPropTermTpCd("03");
                        command.manageAmendmentSummary(priSpAmdtSmryVO, account);
                        if (mnScpVo != null){
                            for (int i=0; i < mnScpVo.length; i++){
                                //standard note
                                PriSpScpNoteCtntVO noteVo = new PriSpScpNoteCtntVO();
                                ObjectCloner.build(mnScpVo[i], noteVo);
                                noteVo.setPrcProgStsCd("A");
                                noteVo.setNoteTpCd("T");
                                command3.cancelAllNote(noteVo, account);

                                PriSpScpAmdtSmryVO amdtScpVo = new PriSpScpAmdtSmryVO();
                                amdtScpVo.setPropNo(mnVo[0].getPropNo());
                                amdtScpVo.setAmdtSeq(mnVo[0].getAmdtSeq());
                                amdtScpVo.setSvcScpCd(mnScpVo[i].getSvcScpCd());
                                amdtScpVo.setPropScpTermTpCd("31");
                                command.manageProposalScopeAmendmentSummary(amdtScpVo, account);

                                command2.manageProposalRequestCancelScope(mnScpVo[i], account);//duration
                                amdtScpVo.setPropScpTermTpCd("11");
                                command.manageProposalScopeAmendmentSummary(amdtScpVo, account);
                                command14.manageProposalRequestCancelScope(mnScpVo[i], account);//mqc
                                amdtScpVo.setPropScpTermTpCd("12");
                                command.manageProposalScopeAmendmentSummary(amdtScpVo, account);

                            }
                        }
                    }else{
                        command2.manageProposalRequestCancel(mnVo[0], account);//duration
                        command14.manageProposalRequestCancel(mnVo[0], account);//mqc
                        command13.manageProposalRequestCancelCustType(mnVo[0], account);//contract

                        //Boiler Plate
                        //모든 Data가 GC 일때만 자동 승인 취소 대상이된다.
                        PriSpBlplVO priSpBlplVO = new PriSpBlplVO();
                        priSpBlplVO.setPropNo(mnVo[0].getPropNo() );
                        priSpBlplVO.setAmdtSeq(mnVo[0].getAmdtSeq());
                        
                        int updateBoilerPlateCnt = commandBoilerPlate.autoCancelProposalBoilerPlate(priSpBlplVO, account);
                        List<String> termList = new ArrayList<String>();
                        //Boiler Plate
                        //모든 Data가 GC 일때만 자동 승인 대상이된다.
                        if( updateBoilerPlateCnt != 0){
                        	termList.add("06"); //Boiler plate
                        }

                        
                        //pri_sp_amdt_smry acpt_flg를 N으로 update
                        PriSpAmdtSmryVO vo = new PriSpAmdtSmryVO();
                        ObjectCloner.build(mnVo[0], vo);
                        
                        termList.add("01");//Duration
                        termList.add("02");//MQC
                        termList.add("03");//Sub-MQC
                        termList.add("07");//Customer Type
                        command.manageProposalAutoRequestCancelAmendmentSummary(vo,termList, account);//Main Terms
                        //pri_sp_scp_amdt_smry acpt_flg를 N으로 update
                        PriSpScpAmdtSmryVO scpVo = new PriSpScpAmdtSmryVO();
                        ObjectCloner.build(mnVo[0], scpVo);
                        command.manageProposalAutoScopeRequestCancelAmendmentSummary(scpVo, account);
                        //scope main 상태변경
                        PriSpScpMnVO scpMnVo = new PriSpScpMnVO();
                        ObjectCloner.build(mnVo[0], scpMnVo);
                        command.modifyAllScopeStatus(scpMnVo, account);
                        if (mnScpVo != null){
                            for (int i = 0; i < mnScpVo.length; i++){
                                command7.manageProposalRequestCancelDirectCall(mnScpVo[i], account);//rate
                                command2.manageProposalRequestCancelScope(mnScpVo[i], account);//duration
                                command14.manageProposalRequestCancelScope(mnScpVo[i], account);//mqc
                                command3.manageProposalRequestCancelStandardNote(mnScpVo[i], account);//note
                            }
                        }
                    }

            }else if (stsCd.equals("D")){// Init Cancel 모든 데이터 삭제
                //Main Exp_dt 변경
                if (!mnVo[0].getAmdtSeq().equals("0")){
                    PriSpMnVO vo = new PriSpMnVO();
                    vo.setAmdtSeq(mnVo[0].getAmdtSeq());
                    vo.setPropNo(mnVo[0].getPropNo());
                    command.manageProposalMainExpiryCancel(vo, account);
                }else{
                	//amdt_seq가 0에서 cancel될 경우 더이당 이 prop_no 는
                	// 존재 하지 않기 때문에 copy to proposal을 통해 quotation에서 넘어온 데이터의 prop_no를 null로 만든다.
                    // Quotation Main
                    PriSqMnVO priSqMnVO = new PriSqMnVO();
                    priSqMnVO.setPropNo(mnVo[0].getPropNo());
                    command18.modifyScQuotationMainPropNoDel(priSqMnVO, account);    // Quotation Main PropNo reset
                }
                CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
                ObjectCloner.build(mnVo[0], vo);
                command17.manageSCCRMSalesLeadNo(vo, account);
log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                command19.removeAllRealCustomer(mnVo[0]); //Real Customer info
                command2.removeProposal(mnVo[0], account);//duration main
                command11.manageProposal(mnVo[0], account); //affiliate
                command12.removeProposal(mnVo[0], account); //Boiler Plate
                command13.removeProposal(mnVo[0], account); //contractParty,Customer type
                command14.removeProposal(mnVo[0], account); //Mqc subMqc
                command.removeProposalProgress(mnVo[0], account);//Progress
                command.removeProposalAmdtSmry(mnVo[0], account);//amdt smry
                command15.manageProposal(mnVo[0], account);//GRI

                if (mnScpVo != null){
                    //NOTE 삭제시 HEADER SEQ를 NULL처리하기위해서 사용
                    PriSpScpNoteListVO priSpScpNoteListVO = new PriSpScpNoteListVO();
                    for (int i = 0; i < mnScpVo.length; i++){
                        command2.removeProposalScope(mnScpVo[i], account);//duration scope
                        ///////////////////////////////////////////////////////////////
                        command16.manageProposal(mnScpVo[i], account);//conversion
                        command3.manageProposal(mnScpVo[i], account);//s Note
                        // 최성민 추가-20091028
                        ObjectCloner.build(mnScpVo[i], priSpScpNoteListVO);
                        command.modifyNoteHeaderSeq(priSpScpNoteListVO,"N", account);
                        //////////////////////////////////////////////////////////////
                        command4.manageProposal(mnScpVo[i], account);//ori/dest
                        command5.manageProposal(mnScpVo[i], account);//group Commodity
                        command6.manageProposal(mnScpVo[i], account);//loading agent
                        command7.removeProposalMain(mnScpVo[i]);//rate
                        command8.removeProposal(mnScpVo[i],account);//group location
                        command9.manageProposal(mnScpVo[i], account);//goh
                        command10.manageProposal(mnScpVo[i], account);//arb/ihc
                        command14.removeProposalScope(mnScpVo[i],account);//Scope Mqc
                        command.removeProposalScopeProgress(mnScpVo[i], account);//progress
                        command.removeProposalScopeAmdtSmry(mnScpVo[i], account);//amdt_smry
                        command.removeProposalScopeMain(mnScpVo[i], account);
                        if (!mnScpVo[i].getAmdtSeq().equals("0")){
                            command.manageProposalScopeMainExpiryCancel(mnScpVo[i], account);
                        }
                    }
                }

                //pri_sp_mn delete add
                command.removeProposal(mnVo[0], account); //proposal main

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
     * ESM_PRI_0003 : 각 Terms에서 호출<br>
     * Terms가 Summary 를 변경 후 메인의 상태를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainStatus(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltMainStsVO> list = command.searchProposalMainStatus(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }



    /**
     * ESM_PRI_0036 : Open<br>
     * Amend Request 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalAmendList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0036Event event = (EsmPri0036Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPropAmdtListVO> list = command.searchProposalAmendList(event.getPriSpHdrVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    

    /**
     * ESM_PRI_0037 : Open<br>
     * Amend Effective Date 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalAmendEffList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0037Event event = (EsmPri0037Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPropAmdtEFFListVO> list = command.searchProposalAmendEffList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0037 : OK <br>
     * Eff DT 변경시 Request가 아니면 Update해서는 안된다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendEffCheckProposalStatus(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0037Event event = (EsmPri0037Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltCdListVO> list = command.searchAmendCheckProposalStatus(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    

    /**
     * ESM_PRI_0037 : OK<br>
     * 입력받은 Effective Date로 Update를 진행합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageEffectiveDate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0037Event event = (EsmPri0037Event) e;
        SCProposalMainBC command01 = new SCProposalMainBCImpl();





 

        try {
            begin();
            command01.manageEffectiveDate(event.getPriSpMnVO(), account);
 
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0036 : OK <br>
     * Amend 시 해당 Proposal 의 MAX seq.가 filed 상태가 아니면 amend 할 수 없다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendCheckProposalStatus(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0036Event event = (EsmPri0036Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
        	List<RsltCdListVO> list = command.searchAmendCheckProposalStatus(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    

    /**
     * ESM_PRI_0036 : OK<br>
     * 입력받은 Effective Date로 Amend Request를 진행합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse amendProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0036Event event = (EsmPri0036Event) e;
        SCProposalMainBC command01 = new SCProposalMainBCImpl();
        SCDurationProposalBC command02 = new SCDurationProposalBCImpl();
        SCMQCProposalBC command03 = new SCMQCProposalBCImpl();
        SCContractPartyProposalBC command04 = new SCContractPartyProposalBCImpl();
        SCGroupLocationProposalBC command05 = new SCGroupLocationProposalBCImpl();
        SCGroupCommodityProposalBC command06 = new SCGroupCommodityProposalBCImpl();
        SCAffiliateProposalBC command07 = new SCAffiliateProposalBCImpl();
        SCBoilerPlateProposalBC command08 = new SCBoilerPlateProposalBCImpl();
        SCGOHChargeProposalBC command09 = new SCGOHChargeProposalBCImpl();
        SCLoadingAgentProposalBC command10 = new SCLoadingAgentProposalBCImpl();
        SCNoteProposalBC command11 = new SCNoteProposalBCImpl();
        SCRateProposalBC command12 = new SCRateProposalBCImpl();
        SCRoutePointProposalBC command13 = new SCRoutePointProposalBCImpl();
        SCTransportationAdditionalChargeProposalBC command14 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCNoteConversionProposalBC command15 = new SCNoteConversionProposalBCImpl();
        SCRealCustomerProposalBC command16 = new SCRealCustomerProposalBCImpl();

        try {
            begin();
            command01.amendProposal(event.getPriSpMnVO(), account);
            command02.amendProposal(event.getPriSpMnVO(), account);
            command03.amendProposal(event.getPriSpMnVO(), account);
            command04.amendProposal(event.getPriSpMnVO(), account);
            command05.amendProposal(event.getPriSpMnVO(), account);
            command06.amendProposal(event.getPriSpMnVO(), account);
            command07.amendProposal(event.getPriSpMnVO(), account);
            command08.amendProposal(event.getPriSpMnVO(), account);
            command09.amendProposal(event.getPriSpMnVO(), account);
            command10.amendProposal(event.getPriSpMnVO(), account);
            command11.amendProposal(event.getPriSpMnVO(), account);
            command12.amendProposal(event.getPriSpMnVO(), account);
            command13.amendProposal(event.getPriSpMnVO(), account);
            command14.amendProposal(event.getPriSpMnVO(), account);
            command15.amendProposal(event.getPriSpMnVO(), account);
            command16.copyAmendRealCustomer(event.getPriSpMnVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0019_start===========================================
    /**
     * ESM_PRI_0019 : Retrieve<br>
     * Duration List를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDurationList(Event e) throws EventException {
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            GrpDurVO grpDurVO = command.searchProposalDurationList(event.getCstAuthorityVO());
            List<RsltPriSpDurVO> list = grpDurVO.getRsltPriSpDurVOS();
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0019 : Accept<br>
     * Duration의 정보를 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptProposalDuration(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptProposalDuration(event.getPriSpScpDurVO(), account);
            if (event.getPriSpScpDurVO().getSvcScpCd().equals("")){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getPriSpScpDurVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getPriSpScpDurVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("01");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }else{
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpScpAmdtSmryVO scpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                scpAmdtSmryVO.setPropNo(event.getPriSpScpDurVO().getPropNo());
                scpAmdtSmryVO.setAmdtSeq(event.getPriSpScpDurVO().getAmdtSeq());
                scpAmdtSmryVO.setSvcScpCd(event.getPriSpScpDurVO().getSvcScpCd());
                scpAmdtSmryVO.setPropScpTermTpCd("11");
                command1.manageScopeAmendmentSummary(scpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
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
     * ESM_PRI_0019 : Accept Cancel<br>
     * Duration의 정보를 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposalDuration(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelProposalDuration(event.getPriSpScpDurVO(), account);
            if (event.getPriSpScpDurVO().getSvcScpCd().equals("")){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getPriSpScpDurVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getPriSpScpDurVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("01");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }else{
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpScpAmdtSmryVO scpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                scpAmdtSmryVO.setPropNo(event.getPriSpScpDurVO().getPropNo());
                scpAmdtSmryVO.setAmdtSeq(event.getPriSpScpDurVO().getAmdtSeq());
                scpAmdtSmryVO.setSvcScpCd(event.getPriSpScpDurVO().getSvcScpCd());
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
     * ESM_PRI_0019 : Accept All<br>
     * Duration의 정보를 모두 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllProposalDuration(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.acceptAllProposalDuration(event.getCstAcceptDurVO(), account);

            if (rValue > 0){
                String propNo = event.getCstAcceptDurVO().getPropNo();
                String amdtSeq = event.getCstAcceptDurVO().getAmdtSeq();

                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(propNo);
                priSpAmdtSmryVO.setAmdtSeq(amdtSeq);
                priSpAmdtSmryVO.setPropTermTpCd("01");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                PriSpMnVO mnVo = new PriSpMnVO();
                mnVo.setPropNo(propNo);
                mnVo.setAmdtSeq(amdtSeq);
                List<RsltCdListVO> listScope = command1.searchScopeList(mnVo);
                if (listScope != null && listScope.size() > 0){
                    PriSpScpAmdtSmryVO scpVo = new PriSpScpAmdtSmryVO();
                    scpVo.setPropNo(propNo);
                    scpVo.setAmdtSeq(amdtSeq);
                    scpVo.setPropScpTermTpCd("11");
                    for (int i = 0; i < listScope.size(); i++){
                        RsltCdListVO cdVo = listScope.get(i);
                        scpVo.setSvcScpCd(cdVo.getCd());
                        command1.manageScopeAmendmentSummary(scpVo, account);
                    }
                }


                eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }
            eventResponse.setETCData("rValue", String.valueOf(rValue));
            eventResponse.setETCData("accept", "all");
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
     * ESM_PRI_0019 : Accept Cancel<br>
     * Duration의 정보를 모두 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllProposalDuration(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.cancelAllProposalDuration(event.getCstAcceptDurVO(), account);
            if (rValue > 0){
                String propNo = event.getCstAcceptDurVO().getPropNo();
                String amdtSeq = event.getCstAcceptDurVO().getAmdtSeq();

                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(propNo);
                priSpAmdtSmryVO.setAmdtSeq(amdtSeq);
                priSpAmdtSmryVO.setPropTermTpCd("01");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                PriSpMnVO mnVo = new PriSpMnVO();
                mnVo.setPropNo(propNo);
                mnVo.setAmdtSeq(amdtSeq);
                List<RsltCdListVO> listScope = command1.searchScopeList(mnVo);
                if (listScope != null && listScope.size() > 0){
                    PriSpScpAmdtSmryVO scpVo = new PriSpScpAmdtSmryVO();
                    scpVo.setPropNo(propNo);
                    scpVo.setAmdtSeq(amdtSeq);
                    scpVo.setPropScpTermTpCd("11");
                    for (int i = 0; i < listScope.size(); i++){
                        RsltCdListVO cdVo = listScope.get(i);
                        scpVo.setSvcScpCd(cdVo.getCd());
                        command1.manageScopeAmendmentSummary(scpVo, account);
                    }
                }

                eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }
            eventResponse.setETCData("rValue", String.valueOf(rValue));
            eventResponse.setETCData("accept", "all");
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
     * ESM_PRI_0019 : Save<br>
     * Duration의 정보를 저장 한다.<br>
     * Expire Date가 같은 Conversion 데이터의 Expire Date를 수정한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalDuration(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        String saveScp = "";

        try {
            begin();
            //Main저장 시 scpSave = true 일 경우 Scope을 같이 저장
            command.manageProposalDuration(event.getCstPriSpScpDurVOs(), account);
            
            CstPriSpScpDurVO[] cstVo = event.getCstPriSpScpDurVOs();
            saveScp = cstVo[0].getScpSave();
            //Main,SCOPE변경시 Scope,MAIN까지 같이 변경하는 경우
            String saveAll = event.getCstPriSpScpDurVOs()[0].getSaveAll();
            String scopeCd = "";
            //main update
            PriSpMnVO mnVo = new PriSpMnVO();
            mnVo.setPropNo(cstVo[0].getPropNo());
            mnVo.setAmdtSeq(cstVo[0].getAmdtSeq());
            mnVo.setExpDt(cstVo[0].getCtrtExpDt());
            if (cstVo[0].getSvcScpCd().equals("")){//MAIN DURATION CHANGE                
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getCstPriSpScpDurVOs()[0].getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpScpDurVOs()[0].getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("01");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);            	                
            	if (saveScp.equals("true")){                    
//            		log.debug("manageProposalDuration=====SCOPE LIST SEARCH=============== 3");
                	List<PriSpScpDurVO> list = command.searchProposalScope(cstVo[0]);
                    if (list != null && list.size() > 0){
                        PriSpScpMnVO[] scpVo = new PriSpScpMnVO[list.size()];
                        for (int i = 0; i< list.size(); i++){
                            PriSpScpAmdtSmryVO vo = new PriSpScpAmdtSmryVO();
                            ObjectCloner.build(cstVo[0], vo);
                            vo.setSvcScpCd(list.get(i).getSvcScpCd());
                            vo.setPropScpTermTpCd("11");
//                            log.debug("manageProposalDuration=====SCOPE SUMMARY UPDATE=============== 4");
                            command1.manageProposalScopeAmendmentSummary(vo, account);
                            scpVo[i] = new PriSpScpMnVO();
                            scpVo[i].setPropNo(cstVo[0].getPropNo());
                            scpVo[i].setAmdtSeq(cstVo[0].getAmdtSeq());
                            scpVo[i].setSvcScpCd(list.get(i).getSvcScpCd());
                            scpVo[i].setExpDt(mnVo.getExpDt());
                            scpVo[i].setIbflag("U");
                            if (i == 0){
                            	scopeCd = list.get(i).getSvcScpCd();                            	
                            }
                        }                        
//                        log.debug("manageProposalDuration=====MAIN수정시 SCOPE을 같이 수정할 경우 CONVERSION EXPIREDATE UPDATE== 5");
                        
                        command2.manageNoteConversionExpireDate(scpVo, account);
                    }
            		if ("Y".equals(saveAll)){
                    	CstPriSpScpDurVO cstScpVo = new CstPriSpScpDurVO();
                    	ObjectCloner.build(event.getCstPriSpScpDurVOs()[0], cstScpVo);
                    	cstScpVo.setSvcScpCd(scopeCd);
                    	CstPriSpScpDurVO[] cstScpVos = new CstPriSpScpDurVO[1];
                    	cstScpVos[0] = new CstPriSpScpDurVO();
                    	cstScpVos[0] = cstScpVo;             
//                    	log.debug("manageProposalDuration=====Main 수정시  Scope DURATION UPDATE================== 6");
                    	command.manageProposalDuration(cstScpVos, account);            			
                        PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                        priSpScpAmdtSmryVO.setPropNo(event.getCstPriSpScpDurVOs()[0].getPropNo());
                        priSpScpAmdtSmryVO.setAmdtSeq(event.getCstPriSpScpDurVOs()[0].getAmdtSeq());
                        priSpScpAmdtSmryVO.setSvcScpCd(scopeCd);
                        priSpScpAmdtSmryVO.setPropScpTermTpCd("11");
//                        log.debug("manageProposalDuration=====Scope 수정시 MAIN SUMMARY UPDATE================== 7");
                        command1.manageProposalScopeAmendmentSummary(priSpScpAmdtSmryVO, account);   
//                        log.debug("manageProposalDuration=====Main 수정시 Scope EXPIREDATE UPDATE========= 8");
                        PriSpScpMnVO vo = new PriSpScpMnVO();
                        ObjectCloner.build(cstVo[0], vo);
                        vo.setExpDt(cstVo[0].getCtrtExpDt());
                        vo.setSvcScpCd(scopeCd);
                        command1.changeProposalScopeMainExpiry(vo, account);            			
            		}else{
//                      if (saveScp.equals("true")){//scope main upate//전체변경
//                    	log.debug("manageProposalDuration=====MAIN 변경시 SCOPE도 같이 수정할 경우  SCOPE EXPIREDATE UPDATE========= 9");
                    	command1.manageProposalScopeMainExpiry(mnVo, account);   
            		}                    
                 
                }
//                log.debug("manageProposalDuration=====MAIN DUR수정시 MAIN EXPIREDATE UPDATE========= 10");
                command1.manageProposalMainExpiry(mnVo, account);                             
                
            }else{
            	//SCOPE DURATION SUMMARY UPDATE
            	PriSpScpAmdtSmryVO scpSmryVo = new PriSpScpAmdtSmryVO();
                scpSmryVo.setPropNo(event.getCstPriSpScpDurVOs()[0].getPropNo());
                scpSmryVo.setAmdtSeq(event.getCstPriSpScpDurVOs()[0].getAmdtSeq());
                scpSmryVo.setSvcScpCd(event.getCstPriSpScpDurVOs()[0].getSvcScpCd());
                scpSmryVo.setPropScpTermTpCd("11");
//                log.debug("manageProposalDuration=====SCOPE DUR 만 수정시 SCOPE SUMMARY UPDATE========= 11");
                command1.manageProposalScopeAmendmentSummary(scpSmryVo, account);                
                //note conv
                if (cstVo != null && cstVo.length > 0){
                    PriSpScpMnVO[] scpVo = new PriSpScpMnVO[cstVo.length];
                    for (int i = 0; i < cstVo.length;i++){
                        scpVo[i] = new PriSpScpMnVO();
                        scpVo[i].setPropNo(cstVo[i].getPropNo());
                        scpVo[i].setAmdtSeq(cstVo[i].getAmdtSeq());
                        scpVo[i].setSvcScpCd(cstVo[i].getSvcScpCd());
                        scpVo[i].setExpDt(cstVo[i].getCtrtExpDt());
                        scpVo[i].setIbflag("U");
                    }
//                    log.debug("manageProposalDuration=====SCOPE DUR 만 수정시 CONVERSION EXPIREDATE UPDATE========= 12");
                    command2.manageNoteConversionExpireDate(scpVo, account);
                }                 
//                if (saveScp.equals("expchange")){//scope main upate//Scope변경
                PriSpScpMnVO vo = new PriSpScpMnVO();
                ObjectCloner.build(cstVo[0], vo);
                vo.setExpDt(cstVo[0].getCtrtExpDt());
//                log.debug("manageProposalDuration=====SCOPE만 변경시   SCOPE EXPIREDATE UPDATE========= 13");
                command1.changeProposalScopeMainExpiry(vo, account);
                
                if ("Y".equals(saveAll)){
                	CstPriSpScpDurVO cstMainVo = new CstPriSpScpDurVO();
                	ObjectCloner.build(event.getCstPriSpScpDurVOs()[0], cstMainVo);
                	cstMainVo.setSvcScpCd("");
                	CstPriSpScpDurVO[] cstMainVos = new CstPriSpScpDurVO[1];
                	cstMainVos[0] = new CstPriSpScpDurVO();
                	cstMainVos[0] = cstMainVo;             
//                	log.debug("manageProposalDuration=====Scope 수정시 Main DURATION UPDATE================== 14");
                	command.manageProposalDuration(cstMainVos, account);
                    PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                    priSpAmdtSmryVO.setPropNo(event.getCstPriSpScpDurVOs()[0].getPropNo());
                    priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpScpDurVOs()[0].getAmdtSeq());
                    priSpAmdtSmryVO.setPropTermTpCd("01");
//                    log.debug("manageProposalDuration=====Scope 수정시 MAIN SUMMARY UPDATE================== 15");
                    command1.manageAmendmentSummary(priSpAmdtSmryVO, account);   
//                    log.debug("manageProposalDuration=====Scope 수정시 MAIN DUR수정시 MAIN EXPIREDATE UPDATE========= 16");
                    command1.manageProposalMainExpiry(mnVo, account);
                }
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
     * ESM_PRI_0019 : Save<br>
     * Main Duration 변경시 Scope Duration의 기간을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeCheckList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<CstPriSpDurVO> list = command.searchProposalScopeCheckList(event.getPriSpScpDurVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    // ===============================ESM_PRI_0019_end=============================================

    // ===============================ESM_PRI_0017_start===========================================
    /**
     * ESM_PRI_0017 : Retrieve<br>
     * SC Contract Party Customer Type의 정보를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractCustomerTypeList(Event e) throws EventException {
        EsmPri0017Event event = (EsmPri0017Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = new PriSpHistoryInquiryParamVO();
        priSpHistoryInquiryParamVO.setConFlg("0");
        try{
            List<RsltPriSpCtrtCustTpVO> list = command.searchProposalContractCustomerTypeList(event.getPriSpCtrtCustTpVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005717 : Retrieve<br>
     * Contract Party Customer Type의 Amend History 정보를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractCustomerTypeHistoryList(Event e) throws EventException {
        EsmPri005717Event event = (EsmPri005717Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try{
            List<RsltPriSpCtrtCustTpVO> list = command.searchProposalContractCustomerTypeList(event.getPriSpCtrtCustTpVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0017 : Accept<br>
     * Contract Party Customer Type의 정보를 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptProposalContractCustomerType(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0017Event event = (EsmPri0017Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptProposalContractCustomerType(event.getPriSpCtrtCustTpVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtCustTpVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtCustTpVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("07");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
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
     * ESM_PRI_0017 : Accept Cancel<br>
     * Contract Party Customer Type의 정보를 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposalContractCustomerType(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0017Event event = (EsmPri0017Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelProposalContractCustomerType(event.getPriSpCtrtCustTpVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtCustTpVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtCustTpVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("07");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
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
     * ESM_PRI_0017 : Save<br>
     * Contract Party Customer Type의 정보를 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalContractCustomerType(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0017Event event = (EsmPri0017Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageProposalContractCustomerType(event.getPriSpCtrtCustTpVOS(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtCustTpVOS()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtCustTpVOS()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("07");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");


            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
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
     * ESM_PRI_0017 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initCustTpComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> custTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01714",0);
            eventResponse.setCustomData("custTypeList", custTypeList);
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    // ===============================ESM_PRI_0017_end=============================================

    // ===============================ESM_PRI_0022_start===========================================
    /**
     * ESM_PRI_0022 : Retrieve<br>
     * Contract Party Customer 의 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyList(Event e) throws EventException {
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpCtrtPtyVO> list = command.searchProposalContractPartyList(event.getPriSpCtrtPtyVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0022 : Retrieve<br>
     * Contract Party Customer Type 의 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyTypeList(Event e) throws EventException {
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriSpCtrtPtyTypeVO> list = command.searchProposalContractPartyTypeList(event.getPriSpCtrtPtyVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0022 : Accept<br>
     * Contract Party Customer의 정보를 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptProposalContractParty(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptProposalContractParty(event.getPriSpCtrtPtyVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtPtyVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtPtyVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("04");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
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
     * ESM_PRI_0022 : Accept Cancel<br>
     * Contract Party Customer 의 정보를 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposalContractParty(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelProposalContractParty(event.getPriSpCtrtPtyVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtPtyVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtPtyVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("04");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
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
     * ESM_PRI_0022 : Save<br>
     * Contract Party Customer 의 정보를 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalContractParty(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageProposalContractParty(event.getPriSpCtrtPtyVOS(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpCtrtPtyVOS()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpCtrtPtyVOS()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("04");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
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
     * ESM_PRI_0022 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initCtrtPtyComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0022_end=============================================

    // ===============================ESM_PRI_0020_start===========================================
    /**
     * ESM_PRI_0020 : Retrieve<br>
     * MQC 의 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMQCList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            GrpMqcVO grpMqcVO = command.searchProposalMQCList(event.getCstMqcVO());
            List<RsltPriSpScpMqcVO> list = grpMqcVO.getRsltPriSpScpMqcVOS();
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;

    }

    /**
     * ESM_PRI_0020 : Accept<br>
     * MQC 의 정보를 Accept 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptProposalMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptProposalMQC(event.getSchPriSpScpMqcVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            if (event.getSchPriSpScpMqcVO().getSvcScpCd().equals("")){
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getSchPriSpScpMqcVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getSchPriSpScpMqcVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("02");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            }else{
                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                smryVO.setPropNo(event.getSchPriSpScpMqcVO().getPropNo());
                smryVO.setAmdtSeq(event.getSchPriSpScpMqcVO().getAmdtSeq());
                smryVO.setPropScpTermTpCd("12");
                smryVO.setSvcScpCd(event.getSchPriSpScpMqcVO().getSvcScpCd());
                command1.manageScopeAmendmentSummary(smryVO, account);
            }
            //메인 status 변경 Returned에서 Request로 변경한다.
            if (event.getSchPriSpScpMqcVO().getPropStsCd().equals("R")){
                PriSpMnVO mnVo = new PriSpMnVO();
                mnVo.setPropNo(event.getSchPriSpScpMqcVO().getPropNo());
                mnVo.setAmdtSeq(event.getSchPriSpScpMqcVO().getAmdtSeq());
                command1.changeAutoRequestMainStatus(mnVo, account);
            }
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

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
     * ESM_PRI_0020 : Accept Cancel<br>
     * MQC 의 정보를 Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposalMQC(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelProposalMQC(event.getSchPriSpScpMqcVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            if (event.getSchPriSpScpMqcVO().getSvcScpCd().equals("")){
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getSchPriSpScpMqcVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getSchPriSpScpMqcVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("02");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            }else{
                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                smryVO.setPropNo(event.getSchPriSpScpMqcVO().getPropNo());
                smryVO.setAmdtSeq(event.getSchPriSpScpMqcVO().getAmdtSeq());
                smryVO.setPropScpTermTpCd("12");
                smryVO.setSvcScpCd(event.getSchPriSpScpMqcVO().getSvcScpCd());
                command1.manageScopeAmendmentSummary(smryVO, account);
            }
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");


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
     * ESM_PRI_0020 : Save<br>
     * MQC 의 정보를 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();

        try {
            begin();
            command.manageProposalMQC(event.getSchPriSpScpMqcVOS(), account);
            if (event.getSchPriSpScpMqcVOS()[0].getSvcScpCd().equals("")){
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getSchPriSpScpMqcVOS()[0].getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getSchPriSpScpMqcVOS()[0].getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("02");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            }else{
                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                smryVO.setPropNo(event.getSchPriSpScpMqcVOS()[0].getPropNo());
                smryVO.setAmdtSeq(event.getSchPriSpScpMqcVOS()[0].getAmdtSeq());
                smryVO.setPropScpTermTpCd("12");
                smryVO.setSvcScpCd(event.getSchPriSpScpMqcVOS()[0].getSvcScpCd());
                command1.manageScopeAmendmentSummary(smryVO, account);
            }          
    
            String saveGbn = event.getSchPriSpScpMqcVOS()[0].getSaveGbn();           
            String saveScp =  event.getSchPriSpScpMqcVOS()[0].getSaveScp();          
      
            if (saveGbn.equals("Y")){                    	
            	SchPriSpScpMqcVO schVo = new SchPriSpScpMqcVO();            	
            	ObjectCloner.build(event.getSchPriSpScpMqcVOS()[0], schVo);
            	if (event.getSchPriSpScpMqcVOS()[0].getSvcScpCd().equals("")){
            		schVo.setSvcScpCd(saveScp);
            	}else{
            		schVo.setSvcScpCd("");
            	}

            	SchPriSpScpMqcVO[] vo = new SchPriSpScpMqcVO[1];
            	vo[0] = new SchPriSpScpMqcVO();
            	vo[0] = schVo;            	
            	
            	command.manageProposalMQC(vo, account);

            	if (event.getSchPriSpScpMqcVOS()[0].getSvcScpCd().equals("")){
                    PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                    smryVO.setPropNo(event.getSchPriSpScpMqcVOS()[0].getPropNo());
                    smryVO.setAmdtSeq(event.getSchPriSpScpMqcVOS()[0].getAmdtSeq());
                    smryVO.setPropScpTermTpCd("12");
                    smryVO.setSvcScpCd(saveScp);
                    command1.manageScopeAmendmentSummary(smryVO, account);
            	}else{
                    PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                    priSpAmdtSmryVO.setPropNo(event.getSchPriSpScpMqcVOS()[0].getPropNo());
                    priSpAmdtSmryVO.setAmdtSeq(event.getSchPriSpScpMqcVOS()[0].getAmdtSeq());
                    priSpAmdtSmryVO.setPropTermTpCd("02");           
                    command1.manageAmendmentSummary(priSpAmdtSmryVO, account);         
            	}      
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
     * ESM_PRI_0020 : Retrieve<br>
     * Sub MQC 의 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalSubMQCList(Event e) throws EventException {
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpSubMqcVO> list = command.searchProposalSubMQCList(event.getPriSpSubMqcVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0020 : Accept <br>
     * Sub MQC 의 정보를 Accept 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptProposalSubMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptProposalSubMQC(event.getPriSpSubMqcVO(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpSubMqcVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpSubMqcVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("03");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

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
     * ESM_PRI_0020 : Accept Cancel<br>
     * Sub MQC 의 정보를 Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposalSubMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelProposalSubMQC(event.getPriSpSubMqcVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpSubMqcVO().getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpSubMqcVO().getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("03");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
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
     * ESM_PRI_0020 : Accept All<br>
     * MQC의 정보를 모두 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllProposalMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.acceptAllProposalMqc(event.getCstAcceptMqcVO(), account);

            if (rValue > 0){
                PriSpMnVO mnVo = new PriSpMnVO();
                String propNo = event.getCstAcceptMqcVO().getPropNo();
                String amdtSeq = event.getCstAcceptMqcVO().getAmdtSeq();

                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(propNo);
                priSpAmdtSmryVO.setAmdtSeq(amdtSeq);
                priSpAmdtSmryVO.setPropTermTpCd("02");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                priSpAmdtSmryVO.setPropTermTpCd("03");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                mnVo.setPropNo(propNo);
                mnVo.setAmdtSeq(amdtSeq);
                List<RsltCdListVO> listScope = command1.searchScopeList(mnVo);
                if (listScope != null && listScope.size() > 0){
                    PriSpScpAmdtSmryVO scpVo = new PriSpScpAmdtSmryVO();
                    scpVo.setPropNo(propNo);
                    scpVo.setAmdtSeq(amdtSeq);
                    scpVo.setPropScpTermTpCd("12");
                    for (int i = 0; i < listScope.size(); i++){
                        RsltCdListVO cdVo = listScope.get(i);
                        scpVo.setSvcScpCd(cdVo.getCd());
                        command1.manageScopeAmendmentSummary(scpVo, account);
                    }
                }


                eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }
            eventResponse.setETCData("rValue", String.valueOf(rValue));
            eventResponse.setETCData("accept", "all");
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
     * ESM_PRI_0020 : Accept Cancel<br>
     * MQC의 정보를 모두 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllProposalMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.cancelAllProposalMqc(event.getCstAcceptMqcVO(), account);
            if (rValue > 0){
                PriSpMnVO mnVo = new PriSpMnVO();
                String propNo = event.getCstAcceptMqcVO().getPropNo();
                String amdtSeq = event.getCstAcceptMqcVO().getAmdtSeq();

                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(propNo);
                priSpAmdtSmryVO.setAmdtSeq(amdtSeq);
                priSpAmdtSmryVO.setPropTermTpCd("02");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                priSpAmdtSmryVO.setPropTermTpCd("03");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                mnVo.setPropNo(propNo);
                mnVo.setAmdtSeq(amdtSeq);
                List<RsltCdListVO> listScope = command1.searchScopeList(mnVo);
                if (listScope != null && listScope.size() > 0){
                    PriSpScpAmdtSmryVO scpVo = new PriSpScpAmdtSmryVO();
                    scpVo.setPropNo(propNo);
                    scpVo.setAmdtSeq(amdtSeq);
                    scpVo.setPropScpTermTpCd("12");
                    for (int i = 0; i < listScope.size(); i++){
                        RsltCdListVO cdVo = listScope.get(i);
                        scpVo.setSvcScpCd(cdVo.getCd());
                        command1.manageScopeAmendmentSummary(scpVo, account);
                    }
                }


                eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }
            eventResponse.setETCData("rValue", String.valueOf(rValue));
            eventResponse.setETCData("accept", "all");
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
     * ESM_PRI_0020 : Save<br>
     * Sub MQC 의 정보를 Save합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalSubMQC(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageProposalSubMQC(event.getPriSpSubMqcVOs(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpSubMqcVOs()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpSubMqcVOs()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("03");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
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
     * ESM_PRI_0020 : Save<br>
     * Scope MQC 의 선택된 Scope의 값을 제외한 Scope 의 MQC합을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSumScopeMqc(Event e) throws EventException {
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpScpMqcVO> list = command.searchSumScopeMqc(event.getPriSpScpMqcVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    /**
     * ESM_PRI_0020 : Save<br>
     * Scope MQC 모든 Scope 의 MQC합을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSumScopeAllMqc(Event e) throws EventException {
        EsmPri0020Event event = (EsmPri0020Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpScpMqcVO> list = command.searchSumScopeAllMqc(event.getPriSpScpMqcVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0020 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initMqcComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);
            ArrayList<CodeInfo> lodUtList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD00897",0);
            eventResponse.setCustomData("lodUtList", lodUtList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0020_end=============================================
    // ===============================ESM_PRI_0023_start=============================================
    /**
     * ESM_PRI_0023 :  OPEN  <br>
     * Boiler Plate Header를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateHeader(Event e) throws EventException {
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriSpBlplHeaderVO> list = command.searchBoilerPlateHeader(event.getRsltPriSpBlplHeaderVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Retrieve  <br>
     * Boiler Plate Title을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateList(Event e) throws EventException {
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpBlplVO> list = command.searchBoilerPlateList(event.getCstBlplSearchVO());
            RsltPriSpBlplHeaderVO vo = new RsltPriSpBlplHeaderVO();
            ObjectCloner.build(event.getCstBlplSearchVO(), vo);
            if (!vo.getBlplHdrSeq().equals("")){
                List<RsltPriSpBlplHeaderVO> list1 = command.searchBoilerPlateTitle(vo);
                if (list1.size() > 0){
                    eventResponse.setETCData("blpl_nm", list1.get(0).getBlplNm());
                    eventResponse.setETCData("blpl_ref_yr", list1.get(0).getBlplRefYr());
                    eventResponse.setETCData("blpl_hdr_seq", list1.get(0).getBlplHdrSeq());
                }
            }
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Retrieve  <br>
     * Boiler Plate Content를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateDetailList(Event e) throws EventException {
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriSpBlplCtntVO> list = command.searchBoilerPlateDetailList(event.getPriSpBlplCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Save  <br>
     * Boiler Plate Title,Content를 저장 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();

        try {
            begin();
            command.manageBoilerPlate(event.getBlplPropVO(), account);
            PriSpBlplVO[] blplVOs = event.getBlplPropVO().getPriSpBlplVOs();
            PriSpBlplCtntVO[] ctntVos = event.getBlplPropVO().getPriSpBlplCtntVOs();

            String propNo = "";
            String amdtSeq = "";
            if (blplVOs != null){
                propNo = blplVOs[0].getPropNo();
                amdtSeq = blplVOs[0].getAmdtSeq();
            }else{
                propNo = ctntVos[0].getPropNo();
                amdtSeq = ctntVos[0].getAmdtSeq();
            }
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(propNo);
            priSpAmdtSmryVO.setAmdtSeq(amdtSeq);
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            if (blplVOs != null){
                int cnt = command.searchBoilerPlateCount(event.getBlplPropVO(), account);
                if (cnt == 0){
                    PriSpBlplVO blplVo = blplVOs[0];
                    PriSpMnVO vo  = new PriSpMnVO();
                    vo.setPropNo( blplVo.getPropNo());
                    vo.setAmdtSeq(blplVo.getAmdtSeq());
                    vo.setBlplHdrSeq("XX");
                    command1.manageProposalMainBoilerPlateSeq(vo, account);
                }
            }



            eventResponse.setUserMessage(new ErrorHandler("PRI00101", new String[]{}).getUserMessage());
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
     * ESM_PRI_0023 :  G/L Copy  <br>
     * Boiler Plate G/L을 Copy합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        PriSpMnVO vo = new PriSpMnVO();
        String blplSeq = "";
        try {
            begin();
            blplSeq = command.copyGuidelineBoilerPlate(event.getCstBlplCopyVO(), account);
            vo.setPropNo(event.getCstBlplCopyVO().getPropNo());
            vo.setAmdtSeq(event.getCstBlplCopyVO().getAmdtSeq());
            vo.setBlplHdrSeq(blplSeq);
            command1.manageProposalMainBoilerPlateSeq(vo, account);


            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(vo.getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(vo.getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI01017").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("blpl_hdr_seq", blplSeq);
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  G/L Copy  <br>
     * 데이터를 Excel로 다운로드 하기위하여 데이터를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateListExcel(Event e) throws EventException {
        EsmPri0023Event event = (EsmPri0023Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();

        try{
            List<RsltPriSpBlplExcelVO> list = command.searchBoilerPlateListExcel(event.getPriSpBlplVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept  <br>
     * Boiler Plate Title을  Accept합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptBoilerPlate(event.getPriSpBlplVOs(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpBlplVOs()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpBlplVOs()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept Cancel  <br>
     * Boiler Plate Title을  Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelBoilerPlate(event.getPriSpBlplVOs(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpBlplVOs()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpBlplVOs()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept  <br>
     * Boiler Plate Content를  Accept합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptBoilerPlateContent(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptBoilerPlateContent(event.getPriSpBlplCtntVOs(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpBlplCtntVOs()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpBlplCtntVOs()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept Cancel  <br>
     * Boiler Plate Content를  Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelBoilerPlateContent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelBoilerPlateContent(event.getPriSpBlplCtntVOs(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpBlplCtntVOs()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpBlplCtntVOs()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("06");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept All  <br>
     * Boiler Plate 모든 데이터를   Accept 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.acceptAllBoilerPlate(event.getCstPriSpBlplVO(), account);

            if (rValue > 0){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getCstPriSpBlplVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpBlplVO().getAmdtSeqAccept());
                priSpAmdtSmryVO.setPropTermTpCd("06");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

                eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00329").getUserMessage());
            }
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Accept Cancel  <br>
     * Boiler Plate 모든 데이터를 Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllBoilerPlate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0023Event event = (EsmPri0023Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.cancelAllBoilerPlate(event.getCstPriSpBlplVO(), account);

            if (rValue > 0){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getCstPriSpBlplVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpBlplVO().getAmdtSeqAccept());
                priSpAmdtSmryVO.setPropTermTpCd("06");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
                eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0023 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initBoilerComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{

            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0023_end=============================================

    // ===============================ESM_PRI_0025_start=============================================
    /**
     * ESM_PRI_0025 : Retrieve <br>
     * Affiliate Company 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateList(Event e) throws EventException {
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltPriSpAfilVO> list = command.searchAffiliateList(event.getPriSpAfilVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0057_09 : Open<br>
     * S/C Rate Search 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAffiliateHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        try{
            // Souce
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02064", 0);
            eventResponse.setCustomData("infoCd", codeInfos);
            //Status
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
            eventResponse.setCustomData("stsCd", codeInfos);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0057 : Retrieve <br>
     * ESM_PRI_0025 참조 : searchAffiliateList <br>
     * Amendment History Inquiry - Affiliate Company 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateHistoryList(Event e) throws EventException {
        List<RsltAfilListVO> list = null;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        EsmPri005709Event event = (EsmPri005709Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            list = command.searchAffiliateHistoryList(event.getRsltAfilListVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Retrieve <br>
     * Customer Manual 입력 check를 위하여 데이터를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualCheck(Event e) throws EventException {
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<PriSpAfilVO> list = command.searchManualCheck(event.getPriSpAfilVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Retrieve <br>
     * Affiliate 자료를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageAffiliate(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();

        SCProposalMainBC command1 = new SCProposalMainBCImpl();

        try {
            begin();
            command.manageAffiliate(event.getPriSpAfilVOS(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpAfilVOS()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpAfilVOS()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("05");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Accept <br>
     * Affiliate 자료를 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAffiliate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptAffiliate(event.getPriSpAfilVOS(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpAfilVOS()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpAfilVOS()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("05");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Accept Cancel <br>
     * Affiliate 자료를 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAffiliate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelAffiliate(event.getPriSpAfilVOS(), account);

            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(event.getPriSpAfilVOS()[0].getPropNo());
            priSpAmdtSmryVO.setAmdtSeq(event.getPriSpAfilVOS()[0].getAmdtSeq());
            priSpAmdtSmryVO.setPropTermTpCd("05");
            command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Accept All <br>
     * Affiliate 자료를 모두 Accept 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllAffiliate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.acceptAllAffiliate(event.getCstPriSpAfilVO(), account);
            if (rValue > 0){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getCstPriSpAfilVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpAfilVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("05");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
                eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : Accept Cancel <br>
     * Affiliate 자료를 모두 Accept Cancel 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllAffiliate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0025Event event = (EsmPri0025Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command.cancelAllAffiliate(event.getCstPriSpAfilVO(), account);
            if (rValue > 0){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
                priSpAmdtSmryVO.setPropNo(event.getCstPriSpAfilVO().getPropNo());
                priSpAmdtSmryVO.setAmdtSeq(event.getCstPriSpAfilVO().getAmdtSeq());
                priSpAmdtSmryVO.setPropTermTpCd("05");
                command1.manageAmendmentSummary(priSpAmdtSmryVO, account);
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
                eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0025 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAffilComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);
            ArrayList<CodeInfo> afilTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD03505",0);
            eventResponse.setCustomData("afilTypeList", afilTypeList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0025_end=============================================

    // ===============================ESM_PRI_0096_start=============================================
    /**
     * ESM_PRI_0096 : Open<br>
     * S/C Proposal Copy 가능한 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCopyList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0096Event event = (EsmPri0096Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPropCopyVO> list1 = command.searchProposalCopyBlplAfilList(event.getRsltPropCopyVO());
            List<RsltPropCopyVO> list2 = command.searchProposalCopyList(event.getRsltPropCopyVO());

            eventResponse.setRsVoList(list1);
            eventResponse.setRsVoList(list2);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0096 : OK<br>
     * S/C Proposal 을 Copy 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyProposal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0096Event event = (EsmPri0096Event) e;
        RsltPropCopyVO vo = event.getRsltPropCopyVO();
        RsltPropCopyVO[] spVos = event.getRsltPropCopyVOs();

        if (spVos == null || spVos.length <= 0) {
            eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
            return eventResponse;
        }
        RsltPropCopyVO[] baVos = event.getRsltPropCpBlplAfilListVOs();

        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        SCContractPartyProposalBC command3 = new SCContractPartyProposalBCImpl();
        SCMQCProposalBC command4 = new SCMQCProposalBCImpl();
        SCBoilerPlateProposalBC command5 = new SCBoilerPlateProposalBCImpl();
        SCAffiliateProposalBC command6 = new SCAffiliateProposalBCImpl();
        SCRoutePointProposalBC command7 = new SCRoutePointProposalBCImpl();
        SCTransportationAdditionalChargeProposalBC command8 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCGroupLocationProposalBC command9 = new SCGroupLocationProposalBCImpl();
        SCGroupCommodityProposalBC command10 = new SCGroupCommodityProposalBCImpl();
        SCNoteProposalBC command11 = new SCNoteProposalBCImpl();
        SCLoadingAgentProposalBC command12 = new SCLoadingAgentProposalBCImpl();
        SCGOHChargeProposalBC command13 = new SCGOHChargeProposalBCImpl();
        SCRateProposalBC command14 = new SCRateProposalBCImpl();
        SCNoteConversionProposalBC command15 = new SCNoteConversionProposalBCImpl();
		SCRealCustomerProposalBC command16 = new SCRealCustomerProposalBCImpl();

        try {
            begin();
            String newPropNo = command1.searchMaxPropNo(account); // 생성된 prop_no
            if (JSPUtil.getNull(newPropNo).equals("")) {
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage());
            }

            vo.setNewPropNo(newPropNo);

            // Copy Proposal Main : PRI_SP_MN/PRI_SP_HDR/PRI_SP_AMDT_SMRY/PRI_SP_PROG COPY
            command1.copyProposalMain(vo, account);

            // Copy Proposal Duration : PRI_SP_DUR
            command2.copyProposalDuration(vo, account);

            // Copy Proposal Customer : PRI_SP_CTRT_PTY/PRI_SP_CTRT_CUST_TP
            command3.copyProposalContractParty(vo, account);

            // Copy Proposal MQC : PRI_SP_MQC
            command4.copyProposalMqc(vo, account);
 log.debug(">>>>>>>>>>>>Copy Proposal MQC>>>>>>>>>>>>>>>>>>>>>>");           
            // Copy Real Customer : PRI_SP_REAL_CUST 
            command16.copyRealCustomer(vo, account);

            if (baVos != null && baVos.length == 1 && baVos[0] != null && baVos[0].getPropNo() != null) {
                baVos[0].setNewPropNo(newPropNo);
                if (JSPUtil.getNullNoTrim(baVos[0].getBlplChk()).equals("1")) {
                    // Copy Proposal Boiler Plate : PRI_SP_BLPL
                    command5.copyProposalBoilerPlate(baVos[0], account);
                }

                if (JSPUtil.getNullNoTrim(baVos[0].getAfilChk()).equals("1")) {
                    // Copy Proposal Affiliate : PRI_SP_AFIL
                    command6.copyProposalAffiliate(baVos[0], account);
                }
            }

            // PRI_SP_AMDT_SMRY UPDATE
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(newPropNo);
            priSpAmdtSmryVO.setAmdtSeq("0");
            command1.manageProposalAmendmentSummaryAll(priSpAmdtSmryVO, account);

            // Scope Copy
            if (spVos != null && spVos.length > 0) {
                for (int i = 0, n = spVos.length; i < n; i++) {
                    spVos[i].setNewPropNo(newPropNo);
                    if (JSPUtil.getNullNoTrim(spVos[i].getScpChk()).equals("1")) {
                        // Copy Proposal Scope Main
                        command1.copyProposalScopeMain(spVos[i], account);

                        // Copy Proposal Scope Duration
                        command2.copyProposalScopeDuration(spVos[i], account);

                        // Copy Proposal Scope MQC
                        command4.copyProposalScopeMqc(spVos[i], account);
                    } else {
                        continue;
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getLocaChk()).equals("1")) {
                        // Copy Proposal Scope Group Location
                        command9.copyProposalScopeLocation(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getCmdtChk()).equals("1")) {
                        // Copy Proposal Scope Group Commodity
                        command10.copyProposalScopeCommodity(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getSpntChk()).equals("1")) {
                        // Copy Proposal Scope Special Note
                        command11.copyProposalScopeNote(spVos[i], account);
                        // Note Conversion
                        command15.copyProposalScNoteConversion(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getLoadChk()).equals("1")) {
                        // Copy Proposal Scope Loading Agent
                        command12.copyProposalScopeLoading(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getGohChk()).equals("1")) {
                        // Copy Proposal Scope GOH Charge
                        command13.copyProposalScopeGohChg(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getGrateChk()).equals("1") || 
                        JSPUtil.getNullNoTrim(spVos[i].getSrateChk()).equals("1")) {
                        // Copy Proposal Scope Rate
                        command14.copyProposalScopeRate(spVos[i], account);
                        if (!JSPUtil.getNull(spVos[i].getPrcPropCreTpCd()).equals("I")) {
                            // Note Conversion
                            command15.copyProposalRoutNoteConversion(spVos[i], account);
                            command15.copyProposalCmdtNoteConversion(spVos[i], account);
                        }
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getOrgnChk()).equals("1")) {
                        // Copy Proposal Scope Origin
                        spVos[i].setOrgDestTpCd("O");
                        command7.copyProposalScopeRoute(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getDestChk()).equals("1")) {
                        // Copy Proposal Scope Destination
                        spVos[i].setOrgDestTpCd("D");
                        command7.copyProposalScopeRoute(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getArorChk()).equals("1")) {
                        // Copy Proposal Scope Arbitrary Origin
                        spVos[i].setAddChgTpCd("A");
                        spVos[i].setOrgDestTpCd("O");
                        command8.copyProposalScopeTransport(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getArdeChk()).equals("1")) {
                        // Copy Proposal Scope Arbitrary Destination
                        spVos[i].setAddChgTpCd("A");
                        spVos[i].setOrgDestTpCd("D");
                        command8.copyProposalScopeTransport(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getIhcChk()).equals("1")) {
                        // Copy Proposal Scope IHC
                        spVos[i].setAddChgTpCd("I");
                        spVos[i].setOrgDestTpCd("");
                        command8.copyProposalScopeTransport(spVos[i], account);
                    }
                }
            }
            // Update Proposal Scope Summary : PRI_SP_SCP_AMDT_SMRY
            command1.copyProposalScopeAmdtSmry(spVos, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00110").getUserMessage());
            eventResponse.setETCData("newPropNo", newPropNo);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    // ===============================ESM_PRI_0096_end=============================================
    /**
     * ESM_PRI_0089 : Open<br>
     * Guideline Clause & Standard Wording 화면의 Combo Item 리스트를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchItemCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            List<?> cdList = (List<?>) cdUtil.getCodeSelect("CD01711", 0); // List<CodeInfo>
            eventResponse.setCustomData("item", cdList);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;

    }

    /**
     * ESM_PRI_0089 : Open<br>
     * Guideline Clause & Standard Wording List 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchContractClauseStdWordingList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0089Event event = (EsmPri0089Event) e;
        SCNoteProposalBC command1 = new SCNoteProposalBCImpl();
        StandardWordingBC command2 = new StandardWordingBCImpl();
        try{
            List<RsltCtrtCluzListVO> list1 = command1.searchContractClauseMasterDetailList(event.getRsltCtrtCluzListVO());
            List<PriScStndWdgVO> list2 = command2.searchStandardWordingList(event.getPriScStndWdgVO());
            eventResponse.setRsVoList(list1);
            eventResponse.setRsVoList(list2);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Search <br>
     * Arbitrary List를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArbitraryChargeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        String btnEnable = "T";
        try {
            List<RsltAddChgListVO> list = command.searchArbitraryChargeList(event.getPriSpScpTrspAddChgVO());
            List<RsltCdListVO> list1 = command.searchArbGriCheck(event.getPriSpScpTrspAddChgVO());
            if (list1 != null && list1.size() >0){
                btnEnable = list1.get(0).getCd();
            }
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("btnEnable", btnEnable);//GRI buttton enable(T)/disable(F)
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Save <br>
     * Arbitrary List를 수정한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.manageArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Guideline Copy <br>
     * Guideline Copy 시 Copy할 Guideline이 존재하는지 확인한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkGuidelineCopyArbitraryChargeExist(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        boolean existGline = true;
        boolean existGlineGrpLoc = true;
        try {
            existGline = command.checkGuidelineArbitraryChargeExist(event.getCstPriSpScpTrspAddChgVO());
            existGlineGrpLoc = command.checkGuidelineArbitraryChargeGroupLocationExist(event.getCstPriSpScpTrspAddChgVO());

            //copy할 guideline이 없다.
            if(existGline == false) {
                eventResponse.setUserMessage((String)new ErrorHandler("PRI01040", new String[]{}).getUserMessage());
                eventResponse.setETCData("FLAG","N");
            }
            //guideline의  group location이 등록되지 않았다.
            else if(existGlineGrpLoc == false) {
                eventResponse.setUserMessage((String)new ErrorHandler("PRI01095", new String[]{}).getUserMessage());
                eventResponse.setETCData("FLAG","N");
            }
            //guideline copy 실행
            else {
                eventResponse.setETCData("FLAG","Y");
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Guideline Copy <br>
     * Arbitrary Cuideline을 Copy를 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.copyGuidelineArbitraryCharge(event.getCstPriSpScpTrspAddChgVO(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getCstPriSpScpTrspAddChgVO().getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getCstPriSpScpTrspAddChgVO().getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getCstPriSpScpTrspAddChgVO().getSvcScpCd());
            if("O".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            //eventResponse.setUserMessage(new ErrorHandler("PRI01017").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Accept <br>
     * Arbitrary Accept를 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptArbitraryCharge(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();

            command1.acceptArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Accept Cancel <br>
     * Arbitrary Accept Cancel을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Accept All <br>
     * Arbitrary Accept All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.acceptAllArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Accept All <br>
     * Arbitrary Accept All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllArbitraryChargeFast(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command1.acceptAllArbitraryChargeFast(event.getCstArbAcceptVO(), account);
           if (rValue > 0){
               PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
               priSpScpAmdtSmryVO.setPropNo(event.getCstArbAcceptVO().getPropNo());
               priSpScpAmdtSmryVO.setAmdtSeq(event.getCstArbAcceptVO().getAmdtSeq());
               priSpScpAmdtSmryVO.setSvcScpCd(event.getCstArbAcceptVO().getSvcScpCd());
               if("O".equals(event.getCstArbAcceptVO().getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
               } else if("D".equals(event.getCstArbAcceptVO().getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
               }
               command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);

               eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
           }else{
               eventResponse.setUserMessage(new ErrorHandler("PRI00329").getUserMessage());
           }
           eventResponse.setETCData("rValue", String.valueOf(rValue));
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Cancel All <br>
     * S/C Proposal Creation - Arbitrary를 Accept Cancel All 처리합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelAllArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_000304 : Cancel All <br>
     * S/C Proposal Creation - Arbitrary를 Accept Cancel All 처리합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllArbitraryChargeFast(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        int rValue = 0;
        try {
            begin();
            rValue = command1.cancelAllArbitraryChargeFast(event.getCstArbAcceptVO(), account);

            if (rValue > 0){
                PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                priSpScpAmdtSmryVO.setPropNo(event.getCstArbAcceptVO().getPropNo());
                priSpScpAmdtSmryVO.setAmdtSeq(event.getCstArbAcceptVO().getAmdtSeq());
                priSpScpAmdtSmryVO.setSvcScpCd(event.getCstArbAcceptVO().getSvcScpCd());
                if("O".equals(event.getCstArbAcceptVO().getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
                } else if("D".equals(event.getCstArbAcceptVO().getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
                }
                command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
                eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            }else{
                eventResponse.setUserMessage(new ErrorHandler("PRI00301").getUserMessage());
            }

            eventResponse.setETCData("rValue", String.valueOf(rValue));
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Search <br>
     * IHC List를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIHCChargeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<RsltAddChgListVO> list = command.searchIHCChargeList(event.getPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Save <br>
     * IHC List를 수정한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.manageIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Accept <br>
     * IHC Accept를 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.acceptIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Accept Cancel <br>
     * IHC Accept Cancel을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Accept All <br>
     * IHC Accept All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.acceptAllIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000305 : Cancel All <br>
     * IHC를 Accept Cancel All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelAllIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Search <br>
     * GOH List를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGOHChargeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command = new SCGOHChargeProposalBCImpl();

        try {
            List<RsltGohChgListVO> list = command.searchGOHChargeList(event.getPriSpScpGohChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Guideline Copy <br>
     * GOH Guideline Copy 시 Copy할 Guideline이 존재하는지 확인한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkGuidelineGOHChargeExist(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command = new SCGOHChargeProposalBCImpl();
        try{
            boolean existGline = command.checkGuidelineGOHChargeExist(event.getCstPriSpScpGohChgVO());

            if(existGline == false) {
                eventResponse.setUserMessage((String)new ErrorHandler("PRI01041", new String[]{}).getUserMessage());
                eventResponse.setETCData("FLAG", "N");
            } else {
                eventResponse.setETCData("FLAG", "Y");
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Guideline Copy <br>
     * GOH Cuideline을 Copy한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.copyGuidelineGOHCharge(event.getCstPriSpScpGohChgVO(), account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getCstPriSpScpGohChgVO().getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getCstPriSpScpGohChgVO().getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getCstPriSpScpGohChgVO().getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            //eventResponse.setUserMessage(new ErrorHandler("PRI01017").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Save <br>
     * GOH List를 수정한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.manageGOHCharge(event.getPriSpScpGohChgVOS(), account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpGohChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpGohChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpGohChgVOS()[0].getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Accept <br>
     * GOH를 Accept를 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.acceptGOHCharge(event.getPriSpScpGohChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpGohChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpGohChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpGohChgVOS()[0].getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Accept Cancel <br>
     * GOH Accept Cancel을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelGOHCharge(event.getPriSpScpGohChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpGohChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpGohChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpGohChgVOS()[0].getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Accept All <br>
     * GOH Accept All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.acceptAllGOHCharge(event.getPriSpScpGohChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpGohChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpGohChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpGohChgVOS()[0].getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000306 : Cancel All <br>
     * GOH Accept Cancel All을 진행한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllGOHCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000306Event event = (EsmPri000306Event) e;
        SCGOHChargeProposalBC command1 = new SCGOHChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();

        try {
            begin();
            command1.cancelAllGOHCharge(event.getPriSpScpGohChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpGohChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpGohChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpGohChgVOS()[0].getSvcScpCd());
            priSpScpAmdtSmryVO.setPropScpTermTpCd("16");

            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_000301 : OPEN<br>
     * Origin/Destination 화면로딩시 콤보정보를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonRoutePointLocationList(Event e) throws EventException {
        //EsmPri000301Event event = (EsmPri000301Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //SOURCE
            vo.setCd("CD02064");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

            //STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : SAVE<br>
     * Origin/Destination 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRoutePointLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        try {
            begin();
            command.manageRoutePointLocation(event.getPriSpScpRoutPntVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpRoutPntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRoutPntVOS()[0].getAmdtSeq());

            if("O".equals(event.getPriSpScpRoutPntVOS()[0].getOrgDestTpCd())) {
                smryVO.setPropScpTermTpCd("41");
            } else {
                smryVO.setPropScpTermTpCd("42");
            }
            smryVO.setSvcScpCd(event.getPriSpScpRoutPntVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            //저장성공
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : RETRIEVE<br>
     * Origin/Destination 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRoutPntLocListVO> list1 = command.searchRoutePointLocationType(event.getRsltRoutPntLocListVO());
            List<RsltRoutPntLocListVO> list2 = command.searchRoutePointLocationList(event.getRsltRoutPntLocListVO());
            eventResponse.setRsVoList(list1);
            eventResponse.setRsVoList(list2);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : RETRIEVE<br>
     * Origin/Destination 정보가 ROUTE TYPE별로 존재하는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationType(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRoutPntLocListVO> list = command.searchRoutePointLocationType(event.getRsltRoutPntLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * Guideline Clause & Standard Wording List 조회 처리<br>
     * Guideline Clause & Standard Wording List 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRIGroupCommodityInitData(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0063Event event = (EsmPri0063Event) e;
        String prcCustTpNm = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltPriSgGrpCmdtVO sgVo = event.getRsltPriSgGrpCmdtVO();

            PRICommonBC command1 = new PRICommonBCImpl();
//          SCProposalMainBC command2 = new SCProposalMainBCImpl();
            String svcScpNm = command1.searchServiceScopeCodeDetailName(sgVo.getSvcScpCd());
//          PriSpScpMnVO vo = command2.searchGRIGroupCommodityEffectiveDt(sgVo);

            // Customer Type Name
            CodeUtil cdUtil = CodeUtil.getInstance();
            prcCustTpNm = cdUtil.getCodeName("CD01714", (String) sgVo.getPrcCustTpCd());
            eventResponse.setCustomData("svcScpNm", svcScpNm);
//          eventResponse.setCustomData("effDt", vo);
//          eventResponse.setCustomData("prcCustTpCd", (String) event.getAttribute("prc_cust_tp_cd"));
            eventResponse.setCustomData("prcCustTpNm", prcCustTpNm);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0063 : Open/Retrieve<br>
     * TPW Group Commodity Guideline Master 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRIGroupCommodityList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0063Event event = (EsmPri0063Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSgGrpCmdtVO> list = command.searchGRIGroupCommodityList(event.getRsltPriSgGrpCmdtVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0063 : Master Row Select<br>
     * TPW Group Commodity Guideline Detail 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRIGroupCommodityDetailList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0063Event event = (EsmPri0063Event) e;
        SCGroupCommodityGuidelineBC command = new SCGroupCommodityGuidelineBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriSgGrpCmdtDtlVO> list = command.searchGroupCommodityGuidelineDtlList(event.getPriSgGrpCmdtVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    // ************* SCRateProposal - START *************
    /**
     * ESM_PRI_0003_08 : OPEN<br>
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

            ArrayList<CodeInfo> rateTypeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01705", 0);

            List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
            ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02202", 0);
            List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());

            ArrayList<CodeInfo> termOrgCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02138", 0);
            ArrayList<CodeInfo> termDestCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02139", 0);
            ArrayList<CodeInfo> noteClassCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01711", 0);
            ArrayList<CodeInfo> transModeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);

            eventResponse.setCustomData("rateTypeCdList", rateTypeCdList);
            eventResponse.setCustomData("ratUtCdList", ratUtCdList);
            eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
            eventResponse.setCustomData("currCdList", currCdList);
            eventResponse.setCustomData("termOrgCdList", termOrgCdList);
            eventResponse.setCustomData("termDestCdList", termDestCdList);
            eventResponse.setCustomData("noteClassCdList", noteClassCdList);
            eventResponse.setCustomData("transModeCdList", transModeCdList);
            
            
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Open<br>
     * Rate의 Commodity Group을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCommodityList(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriSpScpRtCmdtHdrVO());
            String maxBletDpSeq = command.getMaxOldBulletDispSeq(event.getPriSpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());

            eventResponse.setETCData("max_blet_dp_seq", maxBletDpSeq);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Sheet1.Select<br>
     * Rate의 Route 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateRouteList(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriSpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Sheet2.Select<br>
     * Rate의 Rate 관련정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateList(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtListVO vo = command.searchRateList(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDirCallListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0057_06 : Open<br>
     * Rate History - Commodity Group을 조회한다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCommodityHistoryList(Event e) throws EventException {
        EsmPri005706Event event = (EsmPri005706Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCGRICalculationProposalBC cmdGRI = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtCmdtListVO vo = command.searchRateCommodityHistoryList(event.getPriSpScpRtCmdtHdrVO(), event.getIsConversion());
            List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());

            eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0057_06 : Sheet1.Select<br>
     * Rate History - Route 리스트를 조회한다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateRouteHistoryList(Event e) throws EventException {
        EsmPri005706Event event = (EsmPri005706Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteHistoryList(event.getPriSpScpRtCmdtRoutVO(), event.getIsConversion());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0057_06 : Sheet2.Select<br>
     * Rate History - Rate 정보를 조회한다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateHistoryList(Event e) throws EventException {
        EsmPri005706Event event = (EsmPri005706Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtListVO vo = command.searchRateList(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDirCallListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0004_09 : Open<br>
     * Rate Inquiry - Commodity Group을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCommodityInquiryList(Event e) throws EventException {
        EsmPri000409Event event = (EsmPri000409Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCGRICalculationProposalBC cmdGRI = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtCmdtListVO vo = command.searchRateCommodityInquiryList(event.getPriSpScpRtCmdtHdrVO());
            List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());

            eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0004_09 : Sheet1.Select<br>
     * Rate Inquiry - Route 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateRouteInquiryList(Event e) throws EventException {
        EsmPri000409Event event = (EsmPri000409Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteInquiryList(event.getPriSpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0004_09 : Sheet2.Select<br>
     * Rate Inquiry - Rate 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateInquiryList(Event e) throws EventException {
        EsmPri000409Event event = (EsmPri000409Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltRtListVO vo = command.searchRateInquiryList(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDirCallListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Down Excel<br>
     * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriSpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Down Excel<br>
     * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriSpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : OnSaveEnd<br>
     * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCmdtRoutStyle(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            RsltRtCmdtRoutListVO vo = command.searchRateCmdtRoutStyle(event.getPriSpScpRtCmdtHdrVO(), event.getPriSpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutHdrListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }



        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Open<br>
     * Rate Type radio button스타일 처리를 위한 조회를 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateType(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRateTpVO> vos = command.searchRateType(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0057_06 : Open<br>
     * Rate History - Rate Type radio button스타일 처리를 위한 조회를 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateHistoryType(Event e) throws EventException {
        EsmPri005706Event event = (EsmPri005706Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRateTpVO> vos = command.searchRateType(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * SCRateProposal의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateInquiryType(Event e) throws EventException {
        EsmPri000409Event event = (EsmPri000409Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltRateTpVO> vos = command.searchRateType(event.getPriSpScpRtVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Guideline Copy<br>
     * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkGlineCopyGroupCodeExist(Event e) throws EventException {
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            RsltCdListVO vo = command.checkGlineCopyGroupCodeExist(event.getScGlineCopyVO());
            List<RsltCdListVO> vos = new ArrayList<RsltCdListVO>();
            vos.add(vo);

            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Sheet1.Save<br>
     * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRateCommodity(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCNoteConversionProposalBC noteCmd = new SCNoteConversionProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            noteCmd.manageRateCommodity(event.getScRtPropCmdtVO(), account);
            command.manageRateCommodity(event.getScRtPropCmdtVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setSvcScpCd(event.getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            PriSpScpMnVO scpMnVO = new PriSpScpMnVO();
            scpMnVO.setPropNo(event.getPropNo());
            scpMnVO.setAmdtSeq(event.getAmdtSeq());
            scpMnVO.setSvcScpCd(event.getSvcScpCd());
            cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Sheet3.Save<br>
     * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCNoteConversionProposalBC noteCmd = new SCNoteConversionProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            noteCmd.manageRate(event.getScRtPropRtVO(), account);
            command.manageRate(event.getScRtPropRtVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setSvcScpCd(event.getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            PriSpScpMnVO scpMnVO = new PriSpScpMnVO();
            scpMnVO.setPropNo(event.getPropNo());
            scpMnVO.setAmdtSeq(event.getAmdtSeq());
            scpMnVO.setSvcScpCd(event.getSvcScpCd());
            cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Accept<br>
     * Rate 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptRate(event.getPriSpScpRtVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Accept Cancel<br>
     * Rate 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelRate(event.getPriSpScpRtVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0093 : Open<br>
     * Accept All 화면의 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAllRateList(Event e) throws EventException {
        EsmPri0093Event event = (EsmPri0093Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltAllRtListVO> vos = command.searchAllRateList(event.getPriSpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : View All <br>
     * ScrateProposal View All Rate를 페이징 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchViewAllRatesListPaging(Event e) throws EventException {
        SCRateProposalBC command = new SCRateProposalBCImpl();
        EsmPri0069Event event = (EsmPri0069Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            eventResponse.setRs(command.searchViewAllRatesListPaging(event.getViewAllRatesListPagingVO()));
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : View All <br>
     * ScrateProposal View All Rate를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchViewAllRatesList(Event e) throws EventException {
        List<ViewAllRatesListVO> vos = null;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        EsmPri0069Event event = (EsmPri0069Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            vos = command.searchViewAllRatesList(event.getViewAllRatesListVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0093 : Accept<br>
     * Rate의 모든 항목을 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0093Event event = (EsmPri0093Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptAllRate(event.getPriSpScpRtVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Accept Cancel<br>
     * Rate의 모든 항목을 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelAllRate(event.getPriSpScpRtVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_08 : Guideline Copy<br>
     * Guideline의 데이터를 복사해온다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineRate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.copyGuidelineRate(event.getScGlineCopyVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getScGlineCopyVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getScGlineCopyVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getScGlineCopyVO().getPropNo());
            smryVO.setAmdtSeq(event.getScGlineCopyVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getScGlineCopyVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0026 : Accept<br>
     * Commodity 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRateCommodityDetail(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0026Event event = (EsmPri0026Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptRateCommodityDetail(event.getPriSpScpRtCmdtVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0026 : Accept Cancel<br>
     * Commodity 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRateCommodityDetail(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0026Event event = (EsmPri0026Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelRateCommodityDetail(event.getPriSpScpRtCmdtVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0027 : Accept<br>
     * Route Point 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRateRoutePntVia(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0027Event event = (EsmPri0027Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            if (event.getPriSpScpRtRoutOrgPntVO() != null && event.getPriSpScpRtRoutOrgPntVO().length > 0) {
                command.acceptRateRoutePointDetail(event.getPriSpScpRtRoutOrgPntVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutOrgPntVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutOrgPntVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutOrgPntVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutOrgPntVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutOrgPntVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutOrgViaVO() != null && event.getPriSpScpRtRoutOrgViaVO().length > 0) {
                command.acceptRateRouteViaDetail(event.getPriSpScpRtRoutOrgViaVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutOrgViaVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutOrgViaVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutOrgViaVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutOrgViaVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutOrgViaVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutDestViaVO() != null && event.getPriSpScpRtRoutDestViaVO().length > 0) {
                command.acceptRateRouteViaDetail(event.getPriSpScpRtRoutDestViaVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutDestViaVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutDestViaVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutDestViaVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutDestViaVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutDestViaVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutDestPntVO() != null && event.getPriSpScpRtRoutDestPntVO().length > 0) {
                command.acceptRateRoutePointDetail(event.getPriSpScpRtRoutDestPntVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutDestPntVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutDestPntVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutDestPntVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutDestPntVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutDestPntVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0027 : Accept Cancel<br>
     * Route Point 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRateRoutePntVia(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0027Event event = (EsmPri0027Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            if (event.getPriSpScpRtRoutOrgPntVO() != null && event.getPriSpScpRtRoutOrgPntVO().length > 0) {
                command.cancelRateRoutePointDetail(event.getPriSpScpRtRoutOrgPntVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutOrgPntVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutOrgPntVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutOrgPntVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutOrgPntVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutOrgPntVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutOrgViaVO() != null && event.getPriSpScpRtRoutOrgViaVO().length > 0) {
                command.cancelRateRouteViaDetail(event.getPriSpScpRtRoutOrgViaVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutOrgViaVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutOrgViaVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutOrgViaVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutOrgViaVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutOrgViaVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutDestViaVO() != null && event.getPriSpScpRtRoutDestViaVO().length > 0) {
                command.cancelRateRouteViaDetail(event.getPriSpScpRtRoutDestViaVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutDestViaVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutDestViaVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutDestViaVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutDestViaVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutDestViaVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }
            if (event.getPriSpScpRtRoutDestPntVO() != null && event.getPriSpScpRtRoutDestPntVO().length > 0) {
                command.cancelRateRoutePointDetail(event.getPriSpScpRtRoutDestPntVO(), account);

                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                String sTermTpCd = "";
                if (event.getPriSpScpRtRoutDestPntVO()[0].getGenSpclRtTpCd().equals("G")) {
                    sTermTpCd = "71";
                } else if (event.getPriSpScpRtRoutDestPntVO()[0].getGenSpclRtTpCd().equals("S")) {
                    sTermTpCd = "72";
                }
                smryVO.setPropNo(event.getPriSpScpRtRoutDestPntVO()[0].getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpRtRoutDestPntVO()[0].getAmdtSeq());
                smryVO.setSvcScpCd(event.getPriSpScpRtRoutDestPntVO()[0].getSvcScpCd());
                smryVO.setPropScpTermTpCd(sTermTpCd);
                cmdMain.manageScopeAmendmentSummary(smryVO, account);
            }

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0029 : Check<br>
     * Load된 엑셀 데이터가 올바른지 Check한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkRateExcelVertical(Event e) throws EventException {
        EsmPri0029Event event = (EsmPri0029Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0029 : Save<br>
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelVertical(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0029Event event = (EsmPri0029Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();

        try {
            begin();
            String key = command.uploadRateExcelVertical(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
            eventResponse.setETCData("JOB_KEY", key);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0029 : Save<br>
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelVerticalOnline(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0029Event event = (EsmPri0029Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            
            command.uploadRateExcelVerticalOnline(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
            
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtHdrVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtHdrVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtHdrVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtHdrVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtHdrVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
            
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0029 : Open<br>
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
            ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
            comUpldFileVO.setFileUpldNm("SP_Rate_Templet_V.xls");
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
     * ESM_PRI_0099 : Check<br>
     * Load된 엑셀 데이터가 올바른지 Check한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
        EsmPri0099Event event = (EsmPri0099Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltCdListVO> vos = command.checkRateExcelHorizontal(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0099 : Save<br>
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0099Event event = (EsmPri0099Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();

        try {
            begin();
            String key = command.uploadRateExcelHorizontal(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
            eventResponse.setETCData("JOB_KEY", key);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0099 : Save<br>
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelHorizontalOnline(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0099Event event = (EsmPri0099Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            
            command.uploadRateExcelHorizontalOnline(event.getPriSpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
            
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtHdrVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtHdrVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtHdrVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtHdrVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtHdrVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
            
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0099 : Open<br>
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
            comUpldFileVO.setFileUpldNm("SP_Rate_Templet_H.xls");
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
     * ESM_PRI_0066 : Open<br>
     * GRI Calculation Header 리스트를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationHeaderList(Event e) throws EventException {
        EsmPri0066Event event = (EsmPri0066Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0112 : Open<br>
     * GRI Calculation History - Header를 조회합니다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationHeaderHistoryList(Event e) throws EventException {
        EsmPri0112Event event = (EsmPri0112Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0066 : Sheet1.Select<br>
     * GRI Calculation 리스트를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationList(Event e) throws EventException {
        EsmPri0066Event event = (EsmPri0066Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0112 : Open<br>
     * GRI Calculation History - Rate 및 기타정보를 조회합니다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGRICalculationHistoryList(Event e) throws EventException {
        EsmPri0112Event event = (EsmPri0112Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriSpScpGriGrpVO());
            eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0066 : Save<br>
     * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0066Event event = (EsmPri0066Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();

        try {
            begin();
            command.manageGRICalculation(event.getScGriCalcVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0066 : Apply<br>
     * Rate 데이터에 GRI Calculation을 적용합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse applyGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0066Event event = (EsmPri0066Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCGRICalculationProposalBC griCommand = new SCGRICalculationProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.applyGRICalculation(event.getPriSpScpGriGrpVO(), account);
            griCommand.manageGRICalculation(event.getScGriCalcVO(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpGriGrpVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpGriGrpVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpGriGrpVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0066 : Apply Cancel<br>
     * 적용한 GRI Calculation을 취소합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0066Event event = (EsmPri0066Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCGRICalculationProposalBC griCommand = new SCGRICalculationProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelGRICalculation(event.getPriSpScpGriGrpVO(), account);
            //griCommand.manageGRICalculation(event.getScGriCalcVO(), account);
            griCommand.manageGRIApplyFlag(event.getPriSpScpGriGrpVO(), account);
            
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpGriGrpVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpGriGrpVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpGriGrpVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    

    /**
     * ESM_PRI_0066 : Delete<br>
     * 적용한 GRI을 삭제합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse deleteGRICalculation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0066Event event = (EsmPri0066Event) e;
        //SCRateProposalBC command = new SCRateProposalBCImpl();
        SCGRICalculationProposalBC griCommand = new SCGRICalculationProposalBCImpl();
        ///SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            //command.cancelGRICalculation(event.getPriSpScpGriGrpVO(), account);
            griCommand.manageGRICalculation(event.getScGriCalcVO(), account);

//            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
//            String sTermTpCd = "";
//            if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("G")) {
//                sTermTpCd = "71";
//            } else if (event.getPriSpScpGriGrpVO().getGenSpclRtTpCd().equals("S")) {
//                sTermTpCd = "72";
//            }
//            smryVO.setPropNo(event.getPriSpScpGriGrpVO().getPropNo());
//            smryVO.setAmdtSeq(event.getPriSpScpGriGrpVO().getAmdtSeq());
//            smryVO.setSvcScpCd(event.getPriSpScpGriGrpVO().getSvcScpCd());
//            smryVO.setPropScpTermTpCd(sTermTpCd);
            //cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }    

    /**
     * ESM_PRI_0070 : Accept<br>
     * Actual Customer 데이터를 Accept합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptActualCustomer(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0070Event event = (EsmPri0070Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptActualCustomer(event.getPriSpScpRtActCustVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtActCustVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtActCustVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtActCustVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtActCustVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtActCustVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0070 : Accept Cancel<br>
     * Actual Customer 데이터를 Accept Cancel합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelActualCustomer(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0070Event event = (EsmPri0070Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelActualCustomer(event.getPriSpScpRtActCustVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtActCustVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtActCustVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtActCustVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtActCustVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtActCustVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0091 : Accept<br>
     * Commodity Note 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRateCnote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0091Event event = (EsmPri0091Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptRateCnote(event.getPriSpScpRtCnoteVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCnoteVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCnoteVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0091 : Accept Cancel<br>
     * Commodity Note 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRateCnote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0091Event event = (EsmPri0091Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelRateCnote(event.getPriSpScpRtCnoteVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCnoteVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCnoteVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0094 : Accept<br>
     * Direct Call 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRateRouteDirCallDetail(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0094Event event = (EsmPri0094Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptRateRouteDirCallDetail(event.getPriSpScpRtRoutDirVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtRoutDirVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtRoutDirVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtRoutDirVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtRoutDirVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtRoutDirVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0094 : Accept Cancel<br>
     * Direct Call 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRateRouteDirCallDetail(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0094Event event = (EsmPri0094Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelRateRouteDirCallDetail(event.getPriSpScpRtRoutDirVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtRoutDirVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtRoutDirVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtRoutDirVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtRoutDirVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtRoutDirVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0097 : Accept<br>
     * Route Note 데이터를 Accept한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRateCommodityRnote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0097Event event = (EsmPri0097Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.acceptRateCommodityRnote(event.getPriSpScpRtCmdtRnoteVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtRnoteVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtRnoteVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtRnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtRnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0097 : Accept Cancel<br>
     * Route Note 데이터를 Accept Cancel한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRateCommodityRnote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0097Event event = (EsmPri0097Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        SCProposalMainBC cmdMain = new SCProposalMainBCImpl();

        try {
            begin();
            command.cancelRateCommodityRnote(event.getPriSpScpRtCmdtRnoteVOS(), account);

            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            String sTermTpCd = "";
            if (event.getPriSpScpRtCmdtRnoteVOS()[0].getGenSpclRtTpCd().equals("G")) {
                sTermTpCd = "71";
            } else if (event.getPriSpScpRtCmdtRnoteVOS()[0].getGenSpclRtTpCd().equals("S")) {
                sTermTpCd = "72";
            }
            smryVO.setPropNo(event.getPriSpScpRtCmdtRnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriSpScpRtCmdtRnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd(sTermTpCd);
            cmdMain.manageScopeAmendmentSummary(smryVO, account);

            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : ACCEPT<br>
     * Origin/Destination 정보를 ACCEPT한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptRoutePointLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        try {
            begin();
            command.acceptRoutePointLocation(event.getPriSpScpRoutPntVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpRoutPntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRoutPntVOS()[0].getAmdtSeq());

            if("O".equals(event.getPriSpScpRoutPntVOS()[0].getOrgDestTpCd())) {
                smryVO.setPropScpTermTpCd("41");
            } else {
                smryVO.setPropScpTermTpCd("42");
            }
            smryVO.setSvcScpCd(event.getPriSpScpRoutPntVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
//          throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : ACCEPT CANCEL<br>
     * Origin/Destination 정보를 ACCEPT CANCEL 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelRoutePointLocation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        try {
            begin();
            command.cancelRoutePointLocation(event.getPriSpScpRoutPntVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpRoutPntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRoutPntVOS()[0].getAmdtSeq());

            if("O".equals(event.getPriSpScpRoutPntVOS()[0].getOrgDestTpCd())) {
                smryVO.setPropScpTermTpCd("41");
            } else {
                smryVO.setPropScpTermTpCd("42");
            }
            smryVO.setSvcScpCd(event.getPriSpScpRoutPntVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : ACCEPT ALL<br>
     * Origin/Destination 정보를 ALL ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllRoutePoint(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        try {
            begin();
            command.acceptAllRoutePoint(event.getPriSpScpRoutPntVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpRoutPntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRoutPntVOS()[0].getAmdtSeq());

            if("O".equals(event.getPriSpScpRoutPntVOS()[0].getOrgDestTpCd())) {
                smryVO.setPropScpTermTpCd("41");
            } else {
                smryVO.setPropScpTermTpCd("42");
            }
            smryVO.setSvcScpCd(event.getPriSpScpRoutPntVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000301 : CANCEL<br>
     * Origin/Destination 정보를 ALL ACCEPT CANCEL 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllRoutePoint(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000301Event event = (EsmPri000301Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        try {
            begin();
            command.cancelAllRoutePoint(event.getPriSpScpRoutPntVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpRoutPntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpRoutPntVOS()[0].getAmdtSeq());

            if("O".equals(event.getPriSpScpRoutPntVOS()[0].getOrgDestTpCd())) {
                smryVO.setPropScpTermTpCd("41");
            } else {
                smryVO.setPropScpTermTpCd("42");
            }
            smryVO.setSvcScpCd(event.getPriSpScpRoutPntVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ************* SCRateProposal - END *************

    // ************* SCGroupCommodity - START *************

    /**
     * ESM_PRI_000303 : RETRIEVE<br>
     * SCGroupCommodityProposal의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtListVO> list = command.searchGroupCommodityList(event.getPriSpScpGrpCmdtVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : SHEET1@FOCUS<br>
     * SCGroupCommodityProposal의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityDeatilList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailList(event.getPriSpScpGrpCmdtDtlVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : DELETE<br>
     * SCGroupCommodityProposal의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
     * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityRateApplyList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtListVO> list = command.searchGroupCommodityRateApplyList(event.getPriSpScpGrpCmdtVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : DELETE<br>
     * SCGroupCommodityProposal의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * COMMODITY GROUP DTL 에서 이미 Accepted 된 데이터를 조회한다. <br>
     * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityRateAcceptedList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtListVO> list = command.searchGroupCommodityRateAcceptedList(event.getPriSpScpGrpCmdtVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : ACCEPT ALL<br>
     * SCGroupCommodityProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllGroupCommodity(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        String result = "";

        try {
            begin();
            result = command.acceptAllGroupCommodity(event.getPriSpScpGrpCmdtDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("result", result);
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : CANCEL<br>
     * SCGroupCommodityProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllGroupCommodity(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        String result = "";

        try {
            begin();
            result = command.cancelAllGroupCommodity(event.getPriSpScpGrpCmdtDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("result", result);
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : ACCEPT<br>
     * SCGroupCommodityProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptGroupCommodity(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.acceptGroupCommodity(event.getPriSpScpGrpCmdtDtlVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : ACCEPT CANCEL<br>
     * SCGroupLocationProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelGroupCommodity(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.cancelGroupCommodity(event.getPriSpScpGrpCmdtDtlVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : G/L COPY<br>
     * SCGroupCommodityProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineGroupCommodity(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();

        try {
            begin();
            command.copyGuidelineGroupCommodity(event.getPriSpScpGrpCmdtDtlVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000303 : SAVE<br>
     * SCGroupCommodityProposal의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageGroupCommodity(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000303Event event = (EsmPri000303Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageGroupCommodity(event.getGrpCmdtPropVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setPropScpTermTpCd("14");
            smryVO.setSvcScpCd(event.getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ************* SCGroupCommodity - END *************

    // ************* SCLoadingAgent - START *************
    /**
     * ESM_PRI_000307 : RETRIEVE<br>
     * Loading Agent 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchLoadingAgentList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltLodgAgnListVO> list = command.searchLoadingAgentList(event.getPriSpScpLodgAgnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : SAVE<br>
     * Loading Agent 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageLoadingAgent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        try {
            begin();
            command.manageLoadingAgent(event.getPriSpScpLodgAgnVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpLodgAgnVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpLodgAgnVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("15");
            smryVO.setSvcScpCd(event.getPriSpScpLodgAgnVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : ACCEPT ALL<br>
     * Loading Agent 정보를 ALL ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllLoadingAgent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        try {
            begin();
            command.acceptAllLoadingAgent(event.getPriSpScpLodgAgnVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpLodgAgnVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpLodgAgnVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("15");
            smryVO.setSvcScpCd(event.getPriSpScpLodgAgnVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : CANCEL<br>
     * Loading Agent 정보를 ALL ACCEPT CANCEL 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllLoadingAgent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        try {
            begin();
            command.cancelAllLoadingAgent(event.getPriSpScpLodgAgnVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpLodgAgnVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpLodgAgnVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("15");
            smryVO.setSvcScpCd(event.getPriSpScpLodgAgnVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : ACCEPT <br>
     * Loading Agent 정보를 ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptLoadingAgent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        try {
            begin();
            command.acceptLoadingAgent(event.getPriSpScpLodgAgnVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpLodgAgnVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpLodgAgnVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("15");
            smryVO.setSvcScpCd(event.getPriSpScpLodgAgnVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : ACCEPT CANCEL<br>
     * Loading Agent 정보를 ACCEPT CANCEL 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelLoadingAgent(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        try {
            begin();
            command.cancelLoadingAgent(event.getPriSpScpLodgAgnVOS(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command1 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpLodgAgnVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpLodgAgnVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("15");
            smryVO.setSvcScpCd(event.getPriSpScpLodgAgnVOS()[0].getSvcScpCd());
            command1.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000307 : RETRIEVE<br>
     * SCOPE에 'TAW','TAE','ASE','ASW' 코드가 존재하는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSvcScpCdCount(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000307Event event = (EsmPri000307Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltSvcScpCdCntVO> list = command.searchSvcScpCdCount(event.getPriSpScpLodgAgnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_000307 : Key Id <br>
     * POA File Attach Key 정보를 반환한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse getFileKey(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	String keyId = "";
        	
            if(e.getEventName().equals("EsmPri000307Event")){
                EsmPri000307Event event = (EsmPri000307Event) e;
            	if( event.getKeys() != null){
            		keyId = event.getKeys().get(0);
            	}
            } else if(e.getEventName().equals("EsmPri0022Event")){
            	EsmPri0022Event event = (EsmPri0022Event) e;
            	if( event.getKeys() != null){
            		keyId = event.getKeys().get(0);
            	}
            } else if(e.getEventName().equals("EsmPri0025Event")){
            	EsmPri0025Event event = (EsmPri0025Event) e;
            	if( event.getKeys() != null){
            		keyId = event.getKeys().get(0);
            	}
            }
        	eventResponse.setETCData("keyId", keyId);
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ************* SCLoadingAgent - END *************

    // ************* SCNoteProposal - START *************
    /**
     * ESM_PRI_000309 : MAIN@RETRIEVE<br>
     * Standard Note 의 Header 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteHeader(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteHeaderVO> list = command.searchNoteHeader(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000309 : MAIN@RETRIEVE<br>
     * Standard Note 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteListVO> list = command.searchNoteList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000309 : SHEET1@FOCUS<br>
     * Standard Note 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteContentList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_08, 0004_07,0057_14,0004_02,0004_03,0057_05,0057_10 : OPEN<br>
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
            ////////////////////COMMON - START/////////////////////
            //SOURCE
            vo.setCd("CD02064");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

            //STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : OPEN<br>
     * Special Note 화면로딩시 콤보정보를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonNoteList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //SOURCE
            vo.setCd("CD02064");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

            //STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : RETRIEVE<br>
     * Special Note 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSpecialNoteList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteListVO> list = command.searchNoteList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : SHEET1@FOCUS<br>
     * Special Note 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSpecialNoteContentList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_000310 : SAVE<br>
     * Special Note  에 대해서 이전 SEQ의 DP_SEQ MAX값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteMaxDpSeq(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            String maxDpSeq1 = command.searchNoteMaxDpSeq(event.getPriSpScpNoteCtntVO());
            eventResponse.setETCData("TITLE_MAX_DP_SEQ", maxDpSeq1);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_000310 : SAVE<br>
     * Special Note Content 에 대해서 이전 SEQ의 DP_SEQ MAX값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteContentMaxDpSeq(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            String maxDpSeq2 = command.searchNoteContentMaxDpSeq(event.getPriSpScpNoteCtntVO());
            eventResponse.setETCData("CONTENT_MAX_DP_SEQ", maxDpSeq2);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000309 : G/L COPY<br>
     * Guideline 의 Standard Note 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineNote(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command1 = new SCNoteProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        try {
            begin();
            int result = command1.copyGuidelineNote(event.getPriSpScpNoteListVO(), account);
            if(result > 0) {
                command2.modifyNoteHeaderSeq(event.getPriSpScpNoteListVO(), "Y", account);

                //////////////////////////////////////////////////////
                //Amendment Summary Update
                SCProposalMainBC command3 = new SCProposalMainBCImpl();
                PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
                smryVO.setPropNo(event.getPriSpScpNoteListVO().getPropNo());
                smryVO.setAmdtSeq(event.getPriSpScpNoteListVO().getAmdtSeq());
                smryVO.setPropScpTermTpCd("31");
                smryVO.setSvcScpCd(event.getPriSpScpNoteListVO().getSvcScpCd());
                command3.manageScopeAmendmentSummary(smryVO, account);
                ///////////////////////////////////////////////////////

                eventResponse.setUserMessage((String) new ErrorHandler("PRI01017",new String[]{}).getUserMessage());
            } else {
                eventResponse.setUserMessage((String) new ErrorHandler("PRI01016",new String[]{}).getUserMessage());
            }
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : SAVE<br>
     * Special Note 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command1 = new SCNoteProposalBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            //삭제때문에 반드시 CONVERSION을 먼저 처리할것
            command2.manageNote(event.getNotePropVO(), account);
            command1.manageNote(event.getNotePropVO(), account);

            //////////////////////////////////////////////////////PriSpScpNoteListVO
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getNotePropVO().getPriSpScpNoteListVO().getPropNo());
            smryVO.setAmdtSeq(event.getNotePropVO().getPriSpScpNoteListVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("32");
            smryVO.setSvcScpCd(event.getNotePropVO().getPriSpScpNoteListVO().getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000309 : DELETE<br>
     * Standard Note 의 정보를 DELETE 또는 AMEND DELETE 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageStandardNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command1 = new SCNoteProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        try {
            begin();

            int sAmdtSeq = Integer.parseInt(event.getPriSpScpNoteListVO().getAmdtSeq());

            if(sAmdtSeq < 1) {
                // amend Seq 가 0 이면 삭제
                command1.manageStandardNote(event.getPriSpScpNoteListVO());
                command2.modifyNoteHeaderSeq(event.getPriSpScpNoteListVO(), "N", account);
            } else {
                // AMEND SEQ가 0이 아니고 이전 데이터가 존재할경우 AMEND DELETE
                PriSpScpNoteListVO priSpScpNoteListVO = new PriSpScpNoteListVO();
                ObjectCloner.build(event.getPriSpScpNoteListVO(), priSpScpNoteListVO);
                priSpScpNoteListVO.setAmdtSeq(Integer.toString(sAmdtSeq - 1));

                List<RsltNoteListVO> list = command1.searchNoteList(priSpScpNoteListVO);

                if(list.size() > 0) {
                    command1.modifyStandardNote(event.getPriSpScpNoteListVO(),account);
                } else {
                    command1.manageStandardNote(event.getPriSpScpNoteListVO());
                    command2.modifyNoteHeaderSeq(event.getPriSpScpNoteListVO(), "N", account);
                }
            }

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteListVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteListVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("31");
            smryVO.setSvcScpCd(event.getPriSpScpNoteListVO().getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_000309 : DELETE <br>
     * Standard Note 의 정보를 모두 AMEND DELETE한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyStandardNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command1 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.modifyStandardNote(event.getPriSpScpNoteListVO(),account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command2 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteListVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteListVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("31");
            smryVO.setSvcScpCd(event.getPriSpScpNoteListVO().getSvcScpCd());
            command2.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000309 : DELETE CANCEL <br>
     * Standard Note 의 정보를 모두 DELETE CANCEL한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelStandardNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000309Event event = (EsmPri000309Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.cancelStandardNote(event.getPriSpScpNoteListVO(),account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
            SCProposalMainBC command2 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteListVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteListVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("31");
            smryVO.setSvcScpCd(event.getPriSpScpNoteListVO().getSvcScpCd());
            command2.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : ACCEPT<br>
     * Special Note Content 정보를 ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.acceptNote(event.getPriSpScpNoteCtntVOS(), account);

            //////////////////////////////////////////////////////PriSpScpNoteListVO
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteCtntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteCtntVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("32");
            smryVO.setSvcScpCd(event.getPriSpScpNoteCtntVOS()[0].getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : ACCEPT CANCEL<br>
     * Special Note Content 정보를 ACCEPT CANCEL 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelNote(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.cancelNote(event.getPriSpScpNoteCtntVOS(), account);

            //////////////////////////////////////////////////////PriSpScpNoteListVO
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteCtntVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteCtntVOS()[0].getAmdtSeq());
            smryVO.setPropScpTermTpCd("32");
            smryVO.setSvcScpCd(event.getPriSpScpNoteCtntVOS()[0].getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : ACCEPT ALL<br>
     * Special Note Content 정보를 ALL ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse acceptAllNote(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            int result = command.acceptAllNote(event.getPriSpScpNoteCtntVO(), account);

            //////////////////////////////////////////////////////PriSpScpNoteListVO
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteCtntVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteCtntVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("32");
            smryVO.setSvcScpCd(event.getPriSpScpNoteCtntVO().getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            if(result > 0) {
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            } else {
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00301",new String[]{}).getUserMessage());
            }
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000310 : CANCEL<br>
     * Special Note Content 정보를 ALL ACCEPT CANCEL 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelAllNote(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000310Event event = (EsmPri000310Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            int result = command.cancelAllNote(event.getPriSpScpNoteCtntVO(), account);

            //////////////////////////////////////////////////////PriSpScpNoteListVO
            //Amendment Summary Update
            SCProposalMainBC command3 = new SCProposalMainBCImpl();
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriSpScpNoteCtntVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriSpScpNoteCtntVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("32");
            smryVO.setSvcScpCd(event.getPriSpScpNoteCtntVO().getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////

            if(result > 0) {
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            } else {
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00301",new String[]{}).getUserMessage());
            }
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    // ************* SCNoteProposal - END *************

    /**
     * ESM_PRI_0004_08 : MAIN@RETRIEVE<br>
     * Standard Note 의 Header 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteInquiryHeader(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000408Event event = (EsmPri000408Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteHeaderVO> list = command.searchNoteHeader(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_08 : MAIN@RETRIEVE<br>
     * Standard Note 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000408Event event = (EsmPri000408Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteListVO> list = command.searchNoteInquiryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_08 : SHEET1@FOCUS<br>
     * Standard Note 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteContentInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000408Event event = (EsmPri000408Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentInquiryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_0018 : Open <br>
     * Guideline Copy 화면에서 Scope Name 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGuidelineCopySvcScpName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0018Event event = (EsmPri0018Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            SpScpGlineCopyVO vo = event.getSpScpGlineCopyVO();
            if (vo != null) {
                String svcScpNm = command.searchServiceScopeCodeDetailName(vo.getSvcScpCd());
                eventResponse.setCustomData("svcScpNm", svcScpNm);
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }


    /**
     * ESM_PRI_0018 : Open <br>
     * Guideline Copy 대상 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGuidelineCopyCheck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0018Event event = (EsmPri0018Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<SpScpGlineCopyVO> list = command.searchGuidelineCopyCheck(event.getSpScpGlineCopyVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0018 : OK <br>
     * Guideline을 Proposal로 Copy합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse copyScopeGuideline(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0018Event event = (EsmPri0018Event) e;
        SpScpGlineCopyVO[] vos = event.getSpScpGlineCopyVOS();

        if (vos == null || vos.length <= 0) {
            eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
            return eventResponse;
        }
        SpScpGlineCopyVO vo = vos[0];

        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCGroupLocationProposalBC command2 = new SCGroupLocationProposalBCImpl();
        SCGroupCommodityProposalBC command3 = new SCGroupCommodityProposalBCImpl();
        SCTransportationAdditionalChargeProposalBC command4 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCGOHChargeProposalBC command5 = new SCGOHChargeProposalBCImpl();
        SCRateProposalBC command6 = new SCRateProposalBCImpl();
        SCNoteProposalBC command7 = new SCNoteProposalBCImpl();

        try {
            String glineSeq = command1.searchCopyGlineSeq(vo); // Copy 대상의 gline_seq
            if (JSPUtil.getNull(glineSeq).equals("")) {
                eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
                return eventResponse;
            }
            begin();

            vo.setGlineSeq(glineSeq);

            log.debug("****************************** gline_seq : " + glineSeq);

            if (JSPUtil.getNullNoTrim(vo.getLocChk()).equals("2")) {
                log.debug("****************************** Copy Group Location");
                // PRI_SP_SCP_GRP_LOC/PRI_SP_SCP_GRP_LOC_DTL
                command2.copyScopeGuidelineGrpLoc(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getSvcScpCd()).equals("TPW")) {
                if (JSPUtil.getNullNoTrim(vo.getCmdtTpwChk()).equals("2") && !JSPUtil.getNullNoTrim(vo.getCmdtTpwMst()).equals("")) {
                    log.debug("****************************** Copy Group Commodity TPW");
                    command3.copyScopeGuidelineGrpCmdtTpw(vo, account);
                }
            } else {
                if (JSPUtil.getNullNoTrim(vo.getCmdtChk()).equals("2")) {
                    log.debug("****************************** Copy Group Commodity");
                    command3.copyScopeGuidelineGrpCmdt(vo, account);
                }
            }

            vo.setOrgDestTpCd("O");
            if (JSPUtil.getNullNoTrim(vo.getArbOrgChk()).equals("2")) {
                log.debug("****************************** Copy Orgin Arbitrary");
                command4.copyScopeGuidelineArbitrary(vo, account);
            }

            vo.setOrgDestTpCd("D");
            if (JSPUtil.getNullNoTrim(vo.getArbDesChk()).equals("2")) {
                log.debug("****************************** Copy Destination Arbitrary");
                command4.copyScopeGuidelineArbitrary(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getGohChk()).equals("2")) {
                log.debug("****************************** Copy GOH Charge");
                command5.copyScopeGuidelineGohChg(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getRateChk()).equals("2")) {
                log.debug("****************************** Copy Rate");
                command6.copyScopeGuidelineRate(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getNoteChk()).equals("2")) {
                log.debug("****************************** Copy Standard Note");
                String noteHdrSeq = command7.searchGuidelineCopyNoteHdrSeq(vo);

                if (!JSPUtil.getNullNoTrim(noteHdrSeq).equals("")) {
                    vo.setNoteHdrSeq(noteHdrSeq);
                    command7.copyScopeGuidelineStndNote(vo, account);
                    // PRI_SP_SCP_MN 의 note_hdr_seq 컬럼 업데이트
                    command1.modifyScpMnNoteHdrSeqGlineCopy(vo, account);
                }
            }

            log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Update Proposal Scope Summary");
            // PRI_SP_SCP_AMDT_SMRY UPDATE
            command1.copyScopeGuidelineScopeAmdtSmry(vo, account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : OPEN <br>
     * Commodity Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonCommodityNoteConversionList(Event e) throws EventException {
        EsmPri0031Event event = (EsmPri0031Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);
            /*
            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);
            */
            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
        	//////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("C"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String prcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", prcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String convCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", convCfmFlg);
            
            
            // Request User, OFC_AUTH_YN 조회
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
                
                //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
                //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
                //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
                //
                // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
//                if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA") || account.getOfc_cd().equals("SELCMD")) {
//                    eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//                } else {
//                    eventResponse.setCustomData("OFC_AUTH_YN", "N");
//                }
                
            }
            

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);


            log.debug("[SCProposalSC.searchCommonCommodityNoteConversionList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : sheet1@FOCUS<br>
     * Commodity Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionContentList(Event e) throws EventException {
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRtCnoteListVO> list = command.searchCommodityNoteContentList(event.getPriSpScpRtCnoteVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : sheet2@FOCUS<br>
     * Commodity Note Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionList(Event e) throws EventException {
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : Paste<br>
     * Commodity Note Conversion 화면에서의 COPY된 데이터를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionListCopy(Event e) throws EventException {
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : Save<br>
     * Commodity Note Conversion 을 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteConversion(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : Save<br>
     * C/TYPE 을 업데이트 처리한다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0031 : Copy<br>
     * Commodity Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteConversionCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0031Event event = (EsmPri0031Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_0054 : sheet1@FOCUS<br>
     * Commodity Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionContentInpuiryList(Event e) throws EventException {
        EsmPri0054Event event = (EsmPri0054Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRtCnoteListVO> list = command.searchCommodityNoteContentInquiryList(event.getPriSpScpRtCnoteVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0054 : OPEN <br>
     * Commodity Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonCommodityNoteConversionInpuiryList(Event e) throws EventException {
        EsmPri0054Event event = (EsmPri0054Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);

            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0054 : sheet2@FOCUS<br>
     * Commodity Note Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionInpuiryList(Event e) throws EventException {
        EsmPri0054Event event = (EsmPri0054Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_0032 : SHEET1@FOCUS <br>
     * Standard Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSNoteConversionContentList(Event e) throws EventException {
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : OPEN <br>
     * Standard Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonNoteConversionList(Event e) throws EventException {
        EsmPri0032Event event = (EsmPri0032Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);

            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);

            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);
            
            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("P"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String sPrcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", sPrcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String sConvCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", sConvCfmFlg);

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);
            
            
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
            }

            //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
            //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
            //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
            // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
//            if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA")  || account.getOfc_cd().equals("SELCMD")) {
//                eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//            } else {
//                eventResponse.setCustomData("OFC_AUTH_YN", "N");
//            }
            log.debug("[SCProposalSC.searchCommonNoteConversionList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : SHEET2@FOCUS <br>
     * Standard Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionList(Event e) throws EventException {
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : PASTE <br>
     * Standard Note Conversion 정보를 붙여넣기한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionListCopy(Event e) throws EventException {
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : SAVE <br>
     * Standard Note Conversion 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteConversion(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : SAVE <br>
     * C/TYPE 을 업데이트 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0032 : COPY <br>
     * Standard Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteConversionCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0032Event event = (EsmPri0032Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0055 : OPEN <br>
     * Standard Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonNoteConversionInquiryList(Event e) throws EventException {
        EsmPri0055Event event = (EsmPri0055Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);

            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0055 : SHEET1@FOCUS <br>
     * Standard Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSNoteConversionContentInquiryList(Event e) throws EventException {
        EsmPri0055Event event = (EsmPri0055Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_0055 : SHEET2@FOCUS <br>
     * Standard Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionInquiryList(Event e) throws EventException {
        EsmPri0055Event event = (EsmPri0055Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0033 : OPEN <br>
     * Rout Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonRouteNoteConversionList(Event e) throws EventException {
        EsmPri0033Event event = (EsmPri0033Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);
            /*
            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);
            */
            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("R"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String prcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", prcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String convCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", convCfmFlg);

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);
            
            
            // Request User, OFC_AUTH_YN 조회
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
            }

            //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
            //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
            //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
            // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
//            if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA") || account.getOfc_cd().equals("SELCMD")) {
//                eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//            } else {
//                eventResponse.setCustomData("OFC_AUTH_YN", "N");
//            }
            log.debug("[SCProposalSC.searchCommonRouteNoteConversionList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0033 : RETRIEVE <br>
     * Rout Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteNoteConversionList(Event e) throws EventException {
        EsmPri0033Event event = (EsmPri0033Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0033 : PASTE <br>
     * Rout Note Conversion 정보를 붙여넣기한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteNoteConversionListCopy(Event e) throws EventException {
        EsmPri0033Event event = (EsmPri0033Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0033 : SAVE <br>
     * Rout Note Conversion 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteConversion(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0033Event event = (EsmPri0033Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0033 : SAVE <br>
     * C/TYPE 을 업데이트 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0033Event event = (EsmPri0033Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0033 : COPY <br>
     * Rout Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteConversionCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0033Event event = (EsmPri0033Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0052 : OPEN <br>
     * Route Note Conversion 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonRouteNoteConversionInquiryList(Event e) throws EventException {
        EsmPri0052Event event = (EsmPri0052Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);

            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
           //////////////////////COMMON - END///////////////////////

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0052 : RETRIEVE <br>
     * Rout Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteNoteConversionInquiryList(Event e) throws EventException {
        EsmPri0052Event event = (EsmPri0052Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : OPEN <br>
     * Commodity Note Conversion History 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonCommodityNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0100Event event = (EsmPri0100Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);
            /*
            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);
            */
            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("C"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String prcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", prcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String convCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", convCfmFlg);

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);

            //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
            //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
            //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
            // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
            // Request User, OFC_AUTH_YN 조회
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
            }     
            
//            if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA") || account.getOfc_cd().equals("SELCMD")) {	
//                eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//            } else {
//                eventResponse.setCustomData("OFC_AUTH_YN", "N");
//            }
            log.debug("[SCProposalSC.searchCommonCommodityNoteConversionHistoryList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : sheet1@FOCUS<br>
     * Commodity Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionContentHistoryList(Event e) throws EventException {
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRtCnoteListVO> list = command.searchCommodityNoteContentList(event.getPriSpScpRtCnoteVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : sheet2@FOCUS<br>
     * Commodity Note Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            String sCtrtExpDt = command.searchDurationExpDate(event.getPriScNoteConvVO());

            eventResponse.setRsVoList(list);
            eventResponse.setETCData("CTRT_EXP_DT", sCtrtExpDt);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : Paste<br>
     * Commodity Note Conversion 화면에서의 COPY된 데이터를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityNoteConversionHistoryListCopy(Event e) throws EventException {
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : Save<br>
     * Commodity Note Conversion 을 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteConversionHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : Save<br>
     * C/TYPE 을 업데이트 처리한다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteHistoryChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0100 : Copy<br>
     * Commodity Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCommodityNoteConversionHistoryCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0100Event event = (EsmPri0100Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0101 : OPEN <br>
     * Rout Note Conversion History 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonRouteNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0101Event event = (EsmPri0101Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);
            /*
            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);
            */
            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("R"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String prcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", prcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String convCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", convCfmFlg);

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);

            //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
            //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
            //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
            // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
            
            // Request User, OFC_AUTH_YN 조회
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
            }            
            
//            if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA") || account.getOfc_cd().equals("SELCMD")) {
//                eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//            } else {
//                eventResponse.setCustomData("OFC_AUTH_YN", "N");
//            }
            log.debug("[SCProposalSC.searchCommonRouteNoteConversionHistoryList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0101 : RETRIEVE <br>
     * Rout Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0101Event event = (EsmPri0101Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            String sCtrtExpDt = command.searchDurationExpDate(event.getPriScNoteConvVO());

            eventResponse.setRsVoList(list);
            eventResponse.setETCData("CTRT_EXP_DT", sCtrtExpDt);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0101 : PASTE <br>
     * Rout Note Conversion 정보를 붙여넣기한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteNoteConversionHistoryListCopy(Event e) throws EventException {
        EsmPri0101Event event = (EsmPri0101Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0101 : SAVE <br>
     * Rout Note Conversion 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteConversionHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0101Event event = (EsmPri0101Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0101 : SAVE <br>
     * C/TYPE 을 업데이트 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteHistoryChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0101Event event = (EsmPri0101Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0101 : COPY <br>
     * Rout Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRouteNoteConversionHistoryCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0101Event event = (EsmPri0101Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : OPEN <br>
     * Standard Note Conversion History 화면로딩시 콤보정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCommonNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0102Event event = (EsmPri0102Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //NOTE CLASSIFICATION CODE
            vo.setCd("CD01711");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("NOTE_CLSS_CD", list);

            //TYPE & TYPE(multi combo)
            vo.setCd("CD01710");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RULE_APPL_CHG_TP_CD", list);

            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);

            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);

            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);

            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);

            //US SVC MODE
            vo.setCd("CD01729");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_USA_SVC_MOD_CD", list);

            //RECEIVING TERM
            vo.setCd("CD02192");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_RCV_TERM_CD", list);

            //DELIVERY TERM
            vo.setCd("CD02191");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DE_TERM_CD", list);

            //CARGO TYPE(in S/C)
            vo.setCd("CD02202");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_CGO_TP_CD", list);

            //ORG. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ORG_TRSP_MOD_CD", list);

            //DEST. TRANS. MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_DEST_TRSP_MOD_CD", list);

            //BL TYPE
            vo.setCd("CD01733");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_MST_HBL_TP_CD", list);

            //RATE INDICATOR
            vo.setCd("CD01705");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("GEN_SPCL_RT_TP_CD", list);

            //ORG. TRANS. MODE (in S/C)
            vo.setCd("CD02138");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_RCV_TERM_CD", list);

            //DEST. TRANS. MODE (in S/C)
            vo.setCd("CD02139");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("CONV_PRC_DE_TERM_CD", list);

            //IN/OUT GAUGE
            vo.setCd("CD02142");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_IO_GA_CD", list);

            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);

            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

            //RATE PATTERN TYPE CODE 
            vo.setCd("CD03303");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_PATT_TP_CD", list);
            //////////////////////COMMON - END///////////////////////

            //PER TYPE
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("BKG_RAT_UT_CD", list);

            //CURRENCY
            list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);

            //PER TYPE(in S/C)
            list = command.searchAllPerCodeList(vo);
            eventResponse.setCustomData("CONV_RAT_UT_CD", list);

            //GRI COMMODITY
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScgGrpCmdtCdList(vo);
            eventResponse.setCustomData("BKG_SCG_GRP_CMDT_CD", list);

            //NOTE CONVERSION RULE CODE ( CONVERSION TYPE별)
            //추후에 변경할것.
            vo.setEtc1("S"); // 계약 유형: S->S/C,  R->RFA,  T->TRI
            vo.setEtc2("P"); // CONVERSION TYPE CODE
            list = command.searchNoteConvRuleMapgList(vo);
            eventResponse.setCustomData("RULE_CD", list);

            // Scope Charge Code List
            vo.setEtc1(event.getPriScNoteConvVO().getSvcScpCd());
            vo.setEtc2("");
            list = command.searchScopeChargeCodeList(vo);
            eventResponse.setCustomData("CHARGE_CD", list);

            //CREATION TYPE CODE
            String prcPropCreTpCd = command2.searchCreationTypeCode(event.getPriScNoteConvVO());
            eventResponse.setCustomData("PRC_PROP_CRE_TP_CD", prcPropCreTpCd);

            //CONVERSION CONFIRM FLAG
            String convCfmFlg = command2.searchConversionConfirmFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("CONV_CFM_FLG", convCfmFlg);

            //LEGACY I/F FLAG
            String sLgcyIfFlg = command2.searchLegacyIfFlag(event.getPriScNoteConvVO());
            eventResponse.setCustomData("LGCY_IF_FLG", sLgcyIfFlg);

            //입력권한- PKGSA, SELCOS 두개 Office Code 로 한정
            //SELCOS -> SELCMQ 코드 병행 관련 수정 2013.06.14
            //if(account.getOfc_cd().equals("PKGSA") || account.getOfc_cd().equals("SELCMQ")) {
            // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유 
            // Request User, OFC_AUTH_YN 조회
            List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(event.getPriScNoteConvVO(),account) ; 

            if( authList != null && authList.size()>0){
                eventResponse.setCustomData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                eventResponse.setCustomData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
            }     
//            if(account.getOfc_cd().equals("PHXSA") || account.getOfc_cd().equals("NYCRA") || account.getOfc_cd().equals("SELCMA") || account.getOfc_cd().equals("SELCMD")) {
//                eventResponse.setCustomData("OFC_AUTH_YN", "Y");
//            } else {
//                eventResponse.setCustomData("OFC_AUTH_YN", "N");
//            }
            log.debug("[SCProposalSC.searchCommonNoteConversionHistoryList:: eventResponse]\n"+eventResponse.getCustomData());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : SHEET1@FOCUS <br>
     * Standard Note Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSNoteConversionContentHistoryList(Event e) throws EventException {
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentList(event.getPriSpScpNoteCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : SHEET2@FOCUS <br>
     * Standard Note Conversion 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionHistoryList(Event e) throws EventException {
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriScNoteConvVO());
            String sCtrtExpDt = command.searchDurationExpDate(event.getPriScNoteConvVO());

            eventResponse.setRsVoList(list);
            eventResponse.setETCData("CTRT_EXP_DT", sCtrtExpDt);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : PASTE <br>
     * Standard Note Conversion 정보를 붙여넣기한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteConversionHistoryListCopy(Event e) throws EventException {
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriScNoteConvVO(), account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : SAVE <br>
     * Standard Note Conversion 정보를 저장한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteConversionHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCNoteProposalBC command2 = new SCNoteProposalBCImpl();
        try {
            begin();
            command1.manageNoteConversion(event.getPriScNoteConvListVOs(), account);
            command2.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : SAVE <br>
     * C/TYPE 을 업데이트 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteHistoryChargeTypeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        try {
            begin();
            command.manageNoteContentChargeType(event.getPriSpScpNoteCtntListVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0102 : COPY <br>
     * Standard Note Conversion 정보를 COPY한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageNoteConversionHistoryCopy(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0102Event event = (EsmPri0102Event) e;
        SCNoteConversionProposalBC command = new SCNoteConversionProposalBCImpl();
        try {
            begin();
            command.manageNoteConversionCopy(event.getPriScNoteConvListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    // ===============================ESM_PRI_0074_start===========================================//
    /**
     * ESM_PRI_0074 : Save <br>
     * Excel Upload한 데이터를 Boiler Plate에 저장합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageBoilerPlateExl(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0074Event event = (EsmPri0074Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        try {
            begin();
            command.manageBoilerPlateExl(event.getBlplPropVO(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : Open<br>
     * S/C Master 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initMasterProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);

            // Approval Office Code List
            customData = command.searchApprovalOfficeList(new RsltCdListVO());
            eventResponse.setCustomData("appOfcCd", customData);

            // Customer Type Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01714", 0);
            eventResponse.setCustomData("custTpCd", codeInfos);

            // Container Load Unit Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00897", 0);
            eventResponse.setCustomData("lodUtCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : Retrieve<br>
     * S/C Master 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchMasterProposalList(Event e) throws EventException {
        PriSpHdrVO paramVo = new PriSpHdrVO();
        EsmPri0015Event event = (EsmPri0015Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            paramVo = event.getPriSpHdrVO();
            paramVo.setPrcMstPropTpCd("M");

            SCProposalMainBC command = new SCProposalMainBCImpl();
            RsltPropListVO vo = command.searchProposalMain(paramVo, account);

            eventResponse.setRsVoList(vo.getRsltPropMnVOs());
            eventResponse.setRsVoList(vo.getRsltPropMnScpListVOs());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : S/C No<br>
     * S/C Master 생성 시 S/C Number의 Prefix를 체크합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkScNumberPrefix(Event e) throws EventException {
        ChkScNoVO paramVo = new ChkScNoVO();
        EsmPri0015Event event = (EsmPri0015Event) e;
        paramVo = event.getChkScNoVO();
        String result = null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            result = command.checkScNumberPrefix(paramVo);
            eventResponse.setETCData("prefix", JSPUtil.getNull(result));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : Save<br>
     * S/C Proposal Master 를 생성합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageMasterProposal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ScPropMnVO paramVo = new ScPropMnVO();
        EsmPri0015Event event = (EsmPri0015Event) e;
        paramVo = event.getScPropMnVO();

        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        SCMQCProposalBC command3 = new SCMQCProposalBCImpl();
        SCContractPartyProposalBC command4 = new SCContractPartyProposalBCImpl();

        String[] mainTerms = {"01","02","04","07"};     // Duration, MQC, Contract Party, Customer Type
        String[] scopeTerms = {"11","12"};              // Scope Duration, Scope MQC

        String propNo = null;
        boolean isNew = false;
        try {
            begin();
            if (paramVo == null) {
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage());
            }

            if (paramVo.getPriSpHdrVOs() != null && paramVo.getPriSpHdrVOs().length > 0) {
                PriSpHdrVO hdrVo = paramVo.getPriSpHdrVOs()[0];
                isNew = hdrVo.getIbflag().equals("I");
                if (isNew && command1.checkScNumberDup(hdrVo)) {
                    throw new EventException(new ErrorHandler("PRI01062").getMessage());  // 서버에 등록된 중복메세지코드
                }

                propNo = command1.manageProposal(paramVo, account);
                if (!isNew) {
                    propNo = paramVo.getPriSpMnVOs()[0].getPropNo();
                }
            }
            command2.manageProposal(paramVo, account);
            command3.manageProposal(paramVo, account);
            command4.manageProposal(paramVo, account);

            if (isNew) {
                // Amendment Summary Update
                PriSpAmdtSmryVO smryVo = new PriSpAmdtSmryVO();
                smryVo.setPropNo(propNo);
                smryVo.setAmdtSeq("0");

                for (int i = 0, n = mainTerms.length ; i < n ; i++) {
                    smryVo.setPropTermTpCd(mainTerms[i]);
                    command1.manageProposalAmendmentSummary(smryVo, account);
                }
            }

            PriSpScpMnVO[] mnScpVo = paramVo.getPriSpScpMnVOs();
            //Scope     //n1st_cmnc_dt chcange
            if (mnScpVo != null && mnScpVo.length > 0 ){
                PriSpScpAmdtSmryVO scpSmryVo = new PriSpScpAmdtSmryVO();
                scpSmryVo.setPropNo(propNo);
                scpSmryVo.setAmdtSeq("0");
                for (int i = 0; i < mnScpVo.length; i++){
                    if (mnScpVo[i].getIbflag().equals("D")){
                        command1.removeProposalScopeAmdtSmry(mnScpVo[i], account);//scp_amdt_smry
                        command1.removeProposalScopeProgress(mnScpVo[i], account);//Progress
                    } else if (mnScpVo[i].getIbflag().equals("I")){
                        // Scope Amendment Summary Update
                        scpSmryVo.setSvcScpCd(mnScpVo[i].getSvcScpCd());

                        for (int j = 0,n = scopeTerms.length ; j < n ; j++) {
                            scpSmryVo.setPropScpTermTpCd(scopeTerms[j]);
                            command1.manageProposalScopeAmendmentSummary(scpSmryVo, account);
                        }
                    }
                }
            }
            // 성공메세지는 UI에서 선택적으로 출력함.
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("prop_no", propNo);
        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : Delete<br>
     * S/C Proposal Master 를 삭제합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelMasterProposal (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0015Event event = (EsmPri0015Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();

        SCContractPartyProposalBC command13 = new SCContractPartyProposalBCImpl();
        SCMQCProposalBC command14 = new SCMQCProposalBCImpl();

        try {
            begin();
            PriSpMnVO[] mnVo = event.getScPropProgVO().getPriSpMnVOs();
            PriSpScpMnVO[] mnScpVo = event.getScPropMnVO().getPriSpScpMnVOs();

            // pri_sp_mn delete add
            command.removeProposal(mnVo[0], account); // proposal main
            command2.removeProposal(mnVo[0], account);// duration main
            command13.removeProposal(mnVo[0], account); // contractParty,Customer type
            command14.removeProposal(mnVo[0], account); // Mqc subMqc
            command.removeProposalProgress(mnVo[0], account);// Progress
            command.removeProposalAmdtSmry(mnVo[0], account);// amdt smry

            if (mnScpVo != null) {
                for (int i = 0; i < mnScpVo.length; i++) {
                    command2.removeProposalScope(mnScpVo[i], account);// duration scope
                    command14.removeProposalScope(mnScpVo[i], account);// Scope Mqc
                    command.removeProposalScopeProgress(mnScpVo[i], account);// progress
                    command.removeProposalScopeAmdtSmry(mnScpVo[i], account);// amdt_smry
                    command.removeProposalScopeMain(mnScpVo[i], account);
                }
            }
            eventResponse.setUserMessage(new ErrorHandler("PRI00102").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0015 : Go To Proposal<br>
     * S/C Proposal Master 를 Proposal에 적용합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmMasterProposal (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0015Event event = (EsmPri0015Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();

        try {
            begin();
            // pri_sp_mn delete add
            command.confirmMasterProposal(event.getPriSpHdrVO(), account); // proposal main
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0024 : Search <br>
     * Arbitrary Excel List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
//    private EventResponse searchExcelArbitraryChargeList(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//      GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmPri0024Event event = (EsmPri0024Event) e;
//        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
//
//        try {
//          List<RsltAddChgListVO> list = command.searchExcelArbitraryChargeList(event.getPriSpScpTrspAddChgVO());
//          eventResponse.setRsVoList(list);
//        }catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//        return eventResponse;
//    }

    /**
     * ESM_PRI_0024 : Search <br>
     * Arbitrary Excel Upload시 중복 확인을 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryDuplicate(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0024Event event = (EsmPri0024Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            String dupIdx = command.checkArbitraryChargeDuplicate(event.getPriSpScpTrspAddChgVOS());

            if("".equals(dupIdx)) {
                eventResponse.setETCData("FLAG", "Y");
            } else {
                eventResponse.setETCData("DUP_INDEX", dupIdx);
                eventResponse.setETCData("FLAG", "N");
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0068 : Search <br>
     * IHC Excel List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
//    private EventResponse searchExcelIHCChargeList(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//      GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmPri0068Event event = (EsmPri0068Event) e;
//        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
//
//        try {
//          List<RsltAddChgListVO> list = command.searchExcelIHCChargeList(event.getPriSpScpTrspAddChgVO());
//          eventResponse.setRsVoList(list);
//      }catch(EventException ex){
//          throw ex;
//      }catch(Exception ex){
//          throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//      }
//        return eventResponse;
//    }

    /**
     * ESM_PRI_0024 : Search <br>
     * IHC Excel Upload시 중복 확인을 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkIHCDuplicate(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0068Event event = (EsmPri0068Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            String dupIdx = command.checkArbitraryChargeDuplicate(event.getPriSpScpTrspAddChgVOS());

            if("".equals(dupIdx)) {
                eventResponse.setETCData("FLAG", "Y");
            } else {
                eventResponse.setETCData("DUP_INDEX", dupIdx);
                eventResponse.setETCData("FLAG", "N");
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0024 : Save <br>
     * Arbitrary Excel List를 수정한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageExcelArbitraryCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0024Event event = (EsmPri0024Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageArbitraryCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");

            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0068 : Save <br>
     * IHC Excel List를 수정한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageExcelIHCCharge(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0068Event event = (EsmPri0068Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        try {
            begin();
            command.manageIHCCharge(event.getPriSpScpTrspAddChgVOS(), account);

            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
            priSpScpAmdtSmryVO.setPropNo(event.getPriSpScpTrspAddChgVOS()[0].getPropNo());
            priSpScpAmdtSmryVO.setAmdtSeq(event.getPriSpScpTrspAddChgVOS()[0].getAmdtSeq());
            priSpScpAmdtSmryVO.setSvcScpCd(event.getPriSpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("61");
            } else if("D".equals(event.getPriSpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
                priSpScpAmdtSmryVO.setPropScpTermTpCd("62");
            }
            command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");


            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0058 : Open <br>
     * Filing데이터를 가져온다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalFilingList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0058Event event = (EsmPri0058Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<CstPriSpMnFileDtVO> list = command.searchProposalFilingList(event.getCstPriSpMnFileDtVO(),account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0058 : Save <br>
     * Filing 데이터를 저장한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalFiling(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0058Event event = (EsmPri0058Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        CRMSalesLeadBC command3 = new CRMSalesLeadBCImpl();
        SCNoteConversionProposalBC command4 = new SCNoteConversionProposalBCImpl();
        //DEM/DET
        SCExceptionTariffMgtBC command5 = new SCExceptionTariffMgtBCImpl();
        PriSpMnVO priSpMnVO = new PriSpMnVO();
        //Booking Autorating
        BlRatingBC command6 = new BlRatingBCImpl();
        //Chassis Exception
        CgmCodeMgtBC command7 = new CgmCodeMgtBCImpl();
        
        try {
            begin();
            //이전 seq의 exp_dt를 자른다.
            //status를 변경한다.
            //amend eff_dt 보다 file_dt가 크다면 scope,main amend_eff_dt를 자른다
            CstPriSpMnFileVO fileVo = event.getCstPriSpMnFileVO();
            
            ObjectCloner.build(fileVo, priSpMnVO);

            //filing시 note conversion effective date변경
            if (fileVo.getEffDtChg().equals("Y")){
                command4.manageNoteConversionEffectiveDateFiling(priSpMnVO, account);
            }

            command.manageProposalFiling(fileVo, account);//scope main
            if (fileVo.getEffDtChg().equals("Y")){
                //amend eff_dt 보다 file_dt가  크다면 main , scope duration의 eff_dt를 자른다.
            	// Amendment Seq 가 0 인 경우와 Amendment 가 0 이 아니라도 최초로 입력된 Svc Scope 인 경우에 대해서는
            	// 함께 PRI_SP_SCP_DUR.CTRT_EFF_DT 가 업데이트 되도록 로직을 변경함.
                command2.manageProposalTerms(priSpMnVO, account);//duration
            }

            // Sales Lead No가 있을 경우
            if (!JSPUtil.getNull(priSpMnVO.getSlsLdNo()).equals("")) {
                // PRI_CRM_SLS_LD 테이블에 Update
                CstPriCrmSlsLdVO vo = new CstPriCrmSlsLdVO();
                ObjectCloner.build(priSpMnVO, vo);
                vo.setPropStsCd("F");
                command3.manageSCCRMSalesLeadNo(vo, account);
            }
            
            // INTERFACE : CRM으로 Contract Information을 전송
            // CRM Phase-out 됨에 따라 삭제 함 20171204 송민석
            //command.transferScSalesLeadContractInfo(priSpMnVO, account);
            
            // INTERFACE : EDI WEB 으로 General Information을 전송
            PriEdiScGenInfVO genInfVO = new PriEdiScGenInfVO();
            ObjectCloner.build(priSpMnVO, genInfVO);
            genInfVO.setEaiSts("U");
            command.transferScGeneralInfo(genInfVO, account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
            
            // File 시 Rate apply date 보다 effective date가 이전일 경우 메일로 송부
            List<PriEmailTargetListVO> list = command.sendEmail(priSpMnVO, account);
            
            if (list != null && list.size() > 0) { //메일 송부한 BKG list가 있으면 BKG 심사 배치 리스트에 추가 
            	command6.modifyAudDt(list);
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
        
        // [CHM-201535810] Fixed Rate 계약 정보를 SPC로 I/F 적용 개발
        ConstraintMasterBC  spcCommand = new ConstraintMasterBCImpl();
        try{
            begin();
            spcCommand.addFixedFlagInfoByPri( priSpMnVO.getPropNo(), priSpMnVO.getAmdtSeq(), account);
            commit();
        }catch (Exception ex) {
        	rollback();
            log.error("err SPC error" + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00101").getMessage());
        }
        
        try{
            begin();
            //DEM/DET
            SCExceptionVersionVO versionVO = new SCExceptionVersionVO();
            versionVO.setCreUsrId(account.getUsr_id());
            versionVO.setCreOfcCd(account.getOfc_cd());
            versionVO.setUpdUsrId(account.getUsr_id());
            versionVO.setUpdOfcCd(account.getOfc_cd());
            versionVO.setPropNo(priSpMnVO.getPropNo());
            versionVO.setScExptVerSeq("1");
            versionVO.setDmdtExptVerStsCd("L");
            versionVO.setCaller("File");
            command5.modifyVersionSTS(versionVO);
            //CHSS Exception update 
            CHSSSCExceptionVersionVO chssExceptVO = new CHSSSCExceptionVersionVO();
            chssExceptVO.setCreUsrId(account.getUsr_id());
            chssExceptVO.setCreOfcCd(account.getOfc_cd());
            chssExceptVO.setUpdUsrId(account.getUsr_id());
            chssExceptVO.setUpdOfcCd(account.getOfc_cd());
            chssExceptVO.setPropNo(priSpMnVO.getPropNo());
            command7.modifyVersionSTSByAdmtBasic(chssExceptVO);            
            commit();
        }catch (Exception ex) {
        	rollback();
            log.error("err DEM/DET or CHSS error" + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00101").getMessage());
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0056 : OK <br>
     * S/C number를 Assign합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createaProposalSCNumber(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0056Event event = (EsmPri0056Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try {
            begin();
            command.createaProposalSCNumber (event.getPriSpHdrVO(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
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
     * ESM_PRI_0056 : OK <br>
     * S/C No 중복을 체크합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkProposalSCNumber(Event e) throws EventException {
        EsmPri0056Event event = (EsmPri0056Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<PriSpHdrVO> list = command.checkProposalSCNumber(event.getPriSpHdrVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0056 : SAVE<br>
     * 사용자가 입력한 PreFix를 check한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkProposalPreFixNumber(Event e) throws EventException {
        EsmPri0056Event event = (EsmPri0056Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<CstPriSpHdrVO> list = command.checkProposalPreFixNumber(event.getCstPriSpHdrVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_0056 : Open <br>
     * 새로 추가 할 S/C Number를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalSCNumberMain(Event e) throws EventException {
        EsmPri0056Event event = (EsmPri0056Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<CstPriSpHdrVO> list = command.searchProposalSCNumberMain(event.getCstPriSpHdrVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /************************************** ESM_PRI_0109 Start *******************************************/
    /**
     * ESM_PRI_0109 : Open <br>
     * GRI Calculation - Arbitrary 화면에서 콤보 필터를 위해 전체 콤보 데이터를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgCombo1VOs(Event e) throws EventException {
        List<PriSpScpTrspAddChgCombo1VO> list = null;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            list = command.searchPriSpScpTrspAddChgCombo1VOs(event.getPriSpScpTrspAddChgCombo1VO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : Open<br>
     * S/C Arb Gri 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initSCProposalArbGri(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            //  PER combo
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("per", customData);
            // cargo type combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("cargo", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : Open <br>
     * GRI Calculation - Arbitrary 화면에서의 적용 GRI(상단그리드)를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLList(Event e) throws EventException {
        List<PriSpScpTrspAddChgGriArbOKCLListVO> list = null;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            list = command.searchPriSpScpTrspAddChgGriArbOKCLList(event.getPriSpScpTrspAddChgGriArbOKCLListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : sheet1.RowChange <br>
     * GRI Calculation - Arbitrary 화면에서의 적용 GRI 옵션(하단그리드)를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLSubList(Event e) throws EventException {
        List<PriSpScpTrspAddChgGriArbOKCLSubListVO> list = null;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
       try {
           list = command.searchPriSpScpTrspAddChgGriArbOKCLSubList(event.getPriSpScpTrspAddChgGriArbOKCLSubListVO());
           eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : SAVE <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 항목을 저장한다. <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목을 저장한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse managePriSpScpArbGriGrpVOS(Event e) throws EventException {
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            // gri
            command.managePriSpScpArbGriGrpVOS (event.getPriSpScpArbGriGrpVOS(), account);
            //gri option
            command.managePriSpScpArbGriRtVOS (event.getPriSpScpTrspAddChgGriArbOKCLSubListVOS(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : OK <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 적용시 적용할 모든 GRI 와 옵션을 조회한다. <br>
     * 히든 sheet로 적용할 수 있는 Arbitrary 항목과 적용가능 여부를 체크한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLAllList(Event e) throws EventException {
        List<PriSpScpTrspAddChgGriArbOKCLAllListVO> list = null;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            list = command.searchPriSpScpTrspAddChgGriArbOKCLAllList(event.getPriSpScpTrspAddChgGriArbOKCLAllListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : OK <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 적용시 모든 Arbitrary 항목을 조회한다. <br>
     * 히든 sheet로 GRI 항목과 적용가능한지 체크된다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(Event e) throws EventException {
        List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> list = null;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            list = command.searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(event.getPriSpScpTrspAddChgGriArbOKCLArbitraryListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : OK <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse managePriSpScpTrspAddChgGriArbOKCLListVOS(Event e) throws EventException {
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            PriSpScpTrspAddChgGriArbOKCLListVO[] listVOs = event.getPriSpScpTrspAddChgGriArbOKCLListVOS();
            command1.modifyProposalGRICalculationArbOK(listVOs, account);
            command.managePriSpScpTrspAddChgGriArbOKCLListVOS (listVOs, account);

            if (listVOs != null && listVOs.length > 0) {
                PriSpScpTrspAddChgGriArbOKCLListVO vo = listVOs[0];
                PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                priSpScpAmdtSmryVO.setPropNo(vo.getPropNo());
                priSpScpAmdtSmryVO.setAmdtSeq(vo.getAmdtSeq());
                priSpScpAmdtSmryVO.setSvcScpCd(vo.getSvcScpCd());
                if("O".equals(vo.getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
                } else if("D".equals(vo.getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
                }
                // Amendment Summary Update
                command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            }
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0109 : Cancel <br>
     * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse managePriSpScpTrspAddChgGriArbOKCLCancleListVOS(Event e) throws EventException {
        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        SCProposalMainBC command2 = new SCProposalMainBCImpl();
        EsmPri0109Event event = (EsmPri0109Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            PriSpScpTrspAddChgGriArbOKCLListVO[] listVOs = event.getPriSpScpTrspAddChgGriArbOKCLListVOS();
            command1.modifyProposalGRICalculationArbCancle(listVOs, account);
            command.managePriSpScpTrspAddChgGriArbOKCLCancleListVOS (listVOs, account);

            if (listVOs != null && listVOs.length > 0) {
                PriSpScpTrspAddChgGriArbOKCLListVO vo = listVOs[0];
                PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = new PriSpScpAmdtSmryVO();
                priSpScpAmdtSmryVO.setPropNo(vo.getPropNo());
                priSpScpAmdtSmryVO.setAmdtSeq(vo.getAmdtSeq());
                priSpScpAmdtSmryVO.setSvcScpCd(vo.getSvcScpCd());
                if("O".equals(vo.getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("51");
                } else if("D".equals(vo.getOrgDestTpCd())) {
                    priSpScpAmdtSmryVO.setPropScpTermTpCd("52");
                }
                // Amendment Summary Update
                command2.manageScopeAmendmentSummary(priSpScpAmdtSmryVO, account);
            }
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /************************************** ESM_PRI_0109 End *******************************************/

    /**
     * 조회 이벤트 처리<br>
     * GRI Calculation - Arbitrary 화면에서의 조회이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLHistoryList(Event e) throws EventException {

        EsmPri0113Event event = (EsmPri0113Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpTrspAddChgGriArbOKCLListVO> list = command.searchPriSpScpTrspAddChgGriArbOKCLList(event.getPriSpScpTrspAddChgGriArbOKCLListVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * GRI Calculation - Arbitrary 화면에서의 조회이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLAllHistoryList(Event e) throws EventException {

        EsmPri0113Event event = (EsmPri0113Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpTrspAddChgGriArbOKCLAllListVO> list = command.searchPriSpScpTrspAddChgGriArbOKCLAllList(event.getPriSpScpTrspAddChgGriArbOKCLAllListVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * GRI Calculation - Arbitrary 화면에서의 조회이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLArbitraryHistoryList(Event e) throws EventException {

        EsmPri0113Event event = (EsmPri0113Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> list = command.searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(event.getPriSpScpTrspAddChgGriArbOKCLArbitraryListVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * GRI Calculation - Arbitrary 화면에서의 조회이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgGriArbOKCLSubHistoryList(Event e) throws EventException {

        EsmPri0113Event event = (EsmPri0113Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpTrspAddChgGriArbOKCLSubListVO> list = command.searchPriSpScpTrspAddChgGriArbOKCLSubList(event.getPriSpScpTrspAddChgGriArbOKCLSubListVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * GRI Calculation - Arbitrary 화면에서의 조회이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPriSpScpTrspAddChgCombo1VOHistory(Event e) throws EventException {

        EsmPri0113Event event = (EsmPri0113Event) e;
        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpTrspAddChgCombo1VO> list = command.searchPriSpScpTrspAddChgCombo1VOs(event.getPriSpScpTrspAddChgCombo1VO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0019 : Amend Cancel  <BR>
     * Main Duration Amend 시 Scope Duration 의 Amend 데이터가 있는지 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDurationAmendCheckList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpScpDurVO> list = command.searchProposalDurationAmendCheckList(event.getPriSpScpDurVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    /**
     * ESM_PRI_0019 : Save <BR>
     * Main Duration 저장 시 Scope Duration 의 Duration보다 이전 일자인지 확인합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDurationScopeCount(Event e) throws EventException {
        EsmPri0019Event event = (EsmPri0019Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<CstPriSpScpDurCntVO> list = command.searchProposalDurationScopeCount(event.getPriSpScpDurVO());

        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0019 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initDurComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_6016 : onLoad  <BR>
     * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailList(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        EsmPri6016Event event = (EsmPri6016Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriPrsCostListVO> list = command1.searchCostDetailList(event.getRsltPriPrsCostListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6016 : onClick(sheet1)  <BR>
     * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailInquiryList(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        EsmPri6016Event event = (EsmPri6016Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriPrsCostDetailVO> list = command1.searchCostDetailInquiryList(event.getRsltPriPrsCostDetailVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6016 : Save <BR>
     * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPrsCost(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6016Event event = (EsmPri6016Event) e;
        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.modifyPrsCost(event.getRsltPriPrsCostListVOS(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
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
        EsmPri6016Event event = (EsmPri6016Event) e;
        try {


            SCRateProposalBC command = new SCRateProposalBCImpl();
            CalculateBC commandForCalculation = new CalculateBCImpl();

            List<RsltPriPrsCostListVO> listRsltPriPrsCostListVO = new ArrayList<RsltPriPrsCostListVO>();
            String newRoutCsNo = null;
            String newRoutCsSrcDt = null;
            RsltPriPrsCostListVO[] rsltPriPrsCostListVOs =event.getRsltPriPrsCostListVOS();
            InPriPrsRoutCsVO inPriPrsRoutCsVO = event.getInPriPrsRoutCsVO();

            rsltPriPrsCostListVOs[0].setIbflag("U");
            rsltPriPrsCostListVOs[0].setUsdRoutCsSelFlg("N");
            rsltPriPrsCostListVOs[0].setUpdUsrId(account.getUsr_id());
            listRsltPriPrsCostListVO.add(rsltPriPrsCostListVOs[0]);

            //POL(TERM),POD(TERM)의 조합이 정확한지 검사 한다.
            //POL 검사
            List<RsltPriCostSimulationCheckRouteVO> checkList =  command.searchCostSimulationCheckRoutList( event.getInCostSimulationCheckRouteVO());
            if( checkList.size() == 0 ){
                //route와 term을 잘 못 입력 하였다.
                throw new EventException(new ErrorHandler("PRI03021").getMessage());
            }

            //command.modifyPrsSimulationCost(rsltPriPrsCostListVOs,account);

            //0. PRI_PRS_BAT에서  pgm_no = 'ESM_PRI_T001'인 ROW의
            //  PARA_INFO_CTNT(ROUT_CS_SRC_DT)  , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.
            RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = command.searchRouteCaseCostVersion( ); // <--


            //1. 새로운 Rout_cs_no를 select한다.
//            RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO  = command.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO); //<--
//            newRoutCsNo = rsltNewRoutCaseNoVO.getRoutCsNo();
//            newRoutCsSrcDt = rsltNewRoutCaseNoVO.getRoutCsSrcDt();
            RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = commandForCalculation.searchPriPrsRoutCsMaxRoutCsNoCalculate(null);
            newRoutCsNo = maxRoutCsVO.getRoutCsNo();
            newRoutCsSrcDt = rsltRouteCaseCostVersionVO.getParaInfoCtnt();
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsNo);
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsSrcDt);

            begin();
            //2. PRI_PRS_ROUT_CS(BATCH)에 한건을 INSERT한다.(화면에서 입력받은값을 사용.)
            inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
            inPriPrsRoutCsVO.setRoutCsClssNo(rsltRouteCaseCostVersionVO.getPrsBatId()); // <-- rout_cs_clss_no

            commandForCalculation.managePriPrsRouteCase(inPriPrsRoutCsVO, account);


            //2. Route Case를 New Rout_cs_no를 이용해서 입력한다. (online)
            PriSpScpRtUsdRoutCsVO routCsVO = event.getPriSpScpRtUsdRoutCsVO() ;
            routCsVO.setRoutCsNo(newRoutCsNo);
            routCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
            command.managePriRateUsedRouteCase(routCsVO,account);

            //3. Route를 변경한다. usd_rout_cs_sel_flg ( Y --> N )  (online)
            command.modifyPrsRateCommodityRoute(listRsltPriPrsCostListVO);
            log.debug("===== ******************************* modifyPrsRateCommodityRoute 종료  ==>" );


            //4. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 COA 데이터 카피 Insert  (online)
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 실행  ==>" );
            inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
            inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
            inPriPrsRoutCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
            commandForCalculation.copyCoaCostInfoToOnlineCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 종료  ==>" );

            //5. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 Data를 Batch DB에  데이터 카피 Insert  (online -> batch)
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 실행  ==>" );
            commandForCalculation.copyOnlineCostInfoToBatchCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 종료  ==>" );



            //6. Calculate Batch Logic과 동일한 로직을 돌린다. (online)
            command.modifyCalculateLogicData(listRsltPriPrsCostListVO);
            log.debug("===== *******************************  후 ==>");



            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6021 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
     * CM/OP View 내용을 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCmViewAllList(Event e) throws EventException {
        log.debug("===================================>>>>>>>>>>>>>>>>>searchRateCmViewAllList");
        // PDTO(Data Transfer Object including Parameters)
        EsmPri6021Event event = (EsmPri6021Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriRateCmViewAllVO> list = command1.searchRateCmViewAllList(event.getRsltPriRateCmViewAllVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6021 : Save <BR>
     * CM/OP View 의 load 값을  갱신처리 합니다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPrsPfmc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6021Event event = (EsmPri6021Event) e;
        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.modifyPrsPfmc(event.getPriSpScpRtCmdtRoutSetVO(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6022 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
     * S/C Amendment CM/OP View 내용을 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmdtRateCmViewAllList(Event e) throws EventException {
        log.debug("===================================>>>>>>>>>>>>>>>>>searchAmdtRateCmViewAllList");
        // PDTO(Data Transfer Object including Parameters)
        EsmPri6022Event event = (EsmPri6022Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriAmdCmViewAllVO> list = command1.searchAmdtRateCmViewAllList(event.getRsltPriAmdCmViewAllVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
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
        EsmPri6022Event event = (EsmPri6022Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command = new SCRateProposalBCImpl();

        try{
            RsltPriAmdCmpbOpbViewAllVO rsltPriAmdCmpbOpbViewAllVO = command.searchAmdtRateCmpbAndOpbViewAll(event.getRsltPriAmdCmViewAllVO());
            String prsRmnRespbCmpbAmt = "";
            String prsRmnRespbOpbAmt = "";
            if( rsltPriAmdCmpbOpbViewAllVO != null ){
                prsRmnRespbCmpbAmt = rsltPriAmdCmpbOpbViewAllVO.getPrsRespbCmpbAmt();
                prsRmnRespbOpbAmt = rsltPriAmdCmpbOpbViewAllVO.getPrsRespbOpbAmt();
            }
            eventResponse.setETCData("PRS_RMN_RESPB_CMPB_AMT",prsRmnRespbCmpbAmt);
            eventResponse.setETCData("PRS_RMN_RESPB_OPB_AMT",prsRmnRespbOpbAmt);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6022 : Save <BR>
     * S/C Amendment CM/OP View 의 Load값을 갱신처리 합니다.
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyAmdtPrsPfmc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6022Event event = (EsmPri6022Event) e;

        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.modifyAmdtPrsPfmc(event.getPriSpScpRtCmdtRoutSetVO(), account);
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6018 : Retrieve , onLoad , onSaveEnd <BR>
     * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateSurchargeList(Event e) throws EventException {
        EsmPri6018Event event = (EsmPri6018Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = command1.searchRateSurchargeList(event.getInpPrsSurchargeDetailApplicableRouteVO());
            eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailApplicableRouteVOS());
            eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6018 : Save <BR>
     * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRateSurcharge(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6018Event event = (EsmPri6018Event) e;

        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.manageRateSurcharge(event.getPriSpScpRtScgVOS(), account);
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6019 : Retrieve , onLoad, onSaveEnd <BR>
     * PRS- Surcharge Adjust을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeAdjustList(Event e) throws EventException {
        EsmPri6019Event event = (EsmPri6019Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriSurchargeAdjustListVO> list = command1.searchSurchargeAdjustList(event.getRsltPriSurchargeAdjustListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }



        return eventResponse;
    }



    /**
     * ESM_PRI_6019 : onLoad, Calulate <BR>
     * PRS- Surcharge Adjust 팝업을 띄이기 전 해당 surcharge에 대해 note가 존재하는지 체크합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckSurchargeNoteList(Event e) throws EventException {
        EsmPri6019Event event = (EsmPri6019Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriCheckSurchargeNoteListVO> list = command1.searchCheckSurchargeNoteList(event.getRsltPriCheckSurchargeNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }



        return eventResponse;
    }

    /**
     * ESM_PRI_6019 : Save <BR>
     * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSurchargeAdjust(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6019Event event = (EsmPri6019Event) e;

        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.manageSurchargeAdjust(event.getPriSpScpScgAdjVOS(), account);
//            eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_PRI_6019 : OK <BR>
     * PRS- Surcharge Adjust 내용을 바탕으로  Calculate Logic을 수행합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSurchargeAdjustCalc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6019Event event = (EsmPri6019Event) e;

        try {
            begin();
            SCRateProposalBC command = new SCRateProposalBCImpl();
            command.manageSurchargeAdjustCalc(event.getPriSpScpScgAdjVOS()[0], account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6050 :  onLoad <BR>
     * Commodity Group을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCommodityAllList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6050Event event = (EsmPri6050Event) e;
        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriSurchargeAdjustCommodityVO> list = command1.searchRateCommodityAllList(event.getRsltPriSurchargeAdjustCommodityVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6050 :  onLoad, sheet1_onClick <BR>
     * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateGroupCommodityDetailList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6050Event event = (EsmPri6050Event) e;
        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriSurchargeAdjustCommodityDetailVO> list = command1.searchRateGroupCommodityDetailList(event.getRsltPriSurchargeAdjustCommodityDetailVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_6051 :  onLoad <BR>
     * Surcharge Adjust-Location Group을 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateLocationAllList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6051Event event = (EsmPri6051Event) e;
        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriSurchargeAdjustLocationGroupVO> list = command1.searchRateLocationAllList(event.getRsltPriSurchargeAdjustLocationGroupVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6051 :  onLoad, sheet1_onClick <BR>
     * SSurcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateGroupLocationDetailList(Event e) throws EventException {
        log.debug("===================================>>>>>>>>>>>>>>>>>searchGroupCommodityDetailList");
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6051Event event = (EsmPri6051Event) e;
        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = command1.searchRateGroupLocationDetailList(event.getRsltPriSurchargeAdjustLocationGroupDetailVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_6017 :  onLoad , Retrieve <BR>
     * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailByTransModeList(Event e) throws EventException {
        EsmPri6017Event event = (EsmPri6017Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            SCRateProposalBC command1 = new SCRateProposalBCImpl();
            List<RsltPriCostDetailByTransModeListVO> list = command1.searchCostDetailByTransModeList(event.getRsltPriCostDetailByTransModeListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_6020 :  onLoad , Retrieve <BR>
     * RFA CMPB/OPB View All 을 조회 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCmpbViewAllList (Event e) throws EventException {
        EsmPri6020Event event = (EsmPri6020Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateProposalBC command1 = new SCRateProposalBCImpl();
        try{
            List<RsltPriRateCmpbViewAllListVO> list = command1.searchRateCmpbViewAllList(event.getRsltPriRateCmpbViewAllListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Search <br>
     * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000304Event event = (EsmPri000304Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try {
            List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000304 : Search <br>
     * IHC의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkIHCFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000305Event event = (EsmPri000305Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try{
            List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Approve  <BR>
     * Approve시 Validation 을 하기 위해 DEM/DET Exception의 Status를 가져온다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckDmdtList(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCheckDmdtList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0003 :  Approve  <BR>
     * Approve시 Validation 을 하기 위해 CHSS Exception의 Status를 가져온다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckChssList(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCheckChssList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }


    /**
     * ESM_PRI_0057 :  S/C No. Enter<BR>
     * Amendment History Main 데이터를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistoryMain (Event e) throws EventException {
        EsmPri0057Event event = (EsmPri0057Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        SCNoteConversionProposalBC command2 = new SCNoteConversionProposalBCImpl();

        try{
            List<RsltPriSpAmdHstMnVO> list = command1.searchAmendmentHistoryMain(event.getPriSpHdrVO());
            if (list != null && list.size() !=0 && list.get(0) != null){
                eventResponse.setETCData("prop_no", list.get(0).getPropNo());
                eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
                eventResponse.setETCData("ctrt_pty_nm", list.get(0).getCtrtPtyNm());
                eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());
                eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt());
                eventResponse.setETCData("lgcy_if_flg", list.get(0).getLgcyIfFlg());
                
                // Request User, OFC_AUTH_YN 조회
                PriScNoteConvVO priScNoteConvVO = new PriScNoteConvVO();
                priScNoteConvVO.setPropNo(list.get(0).getPropNo());
                priScNoteConvVO.setAmdtSeq("0");
                List<PriSpMnConvAuthFlagVO> authList = command2.searchConversionAuthFlag(priScNoteConvVO,account) ; 

                if( authList != null && authList.size()>0){
                    eventResponse.setETCData("OFC_AUTH_YN", authList.get(0).getOfcAuthYn());
                    eventResponse.setETCData("REQ_USR_FLG", authList.get(0).getReqUsrFlg());
                }                
                
                
                PriSpMnVO vo = new PriSpMnVO();
                vo.setPropNo(list.get(0).getPropNo());
                List<RsltCdListVO> list1 = command1.searchHistoryScopeList(vo);
                eventResponse.setRsVoList(list1);
                

                
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0057 : Open<br>
     * Amendment History Inquery 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
//    @SuppressWarnings("unchecked")
    private EventResponse initAmendHistoryInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
//        RsltCdListVO rsltCdListVO = new RsltCdListVO();
//        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
//        List<CodeInfo> codeInfos = null;
        try{
            // TERM TYPE
            customData = command.searchTermTypeList (new RsltCdListVO());
            eventResponse.setCustomData("termType", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0057 :  Retrieve  <BR>
     * Amendment History Scope List 데이터를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistoryList (Event e) throws EventException {
        EsmPri0057Event event = (EsmPri0057Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try{
            List<RsltAmdtHisMnVO> list = command1.searchAmendmentHistoryList(event.getCstShHistVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0057 :  Sheet1_SelectCell  <BR>
     * Amend된 Terms 데이터를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchHistoryAmendTermList (Event e) throws EventException {
        EsmPri0057Event event = (EsmPri0057Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command1 = new SCProposalMainBCImpl();
        try{
            List<RsltPropScpAmdtSmryVO> list = command1.searchHistoryAmendTermList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0057 :  Sheet1_SelectCell  <BR>
     * 각 Terms에 수정된 정보가 있는 지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistorySummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0057Event event = (EsmPri0057Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            log.debug("searchAmendmentHistorySummary===========sc=="+event.getCstShHistVO().getLgcyIfFlg());
            List<RsltPropScpAmdtSmryVO> list = command.searchAmendmentHistorySummary(event.getCstShHistVO());

            eventResponse.setRsVoList(list);
            
            // S/C 조회 LOG 저장 시작 [20171227][CSR #2875] //
            // ESM_PRI_0057  :  Sales Management > Pricing > Service Contract > S/C Inquiry  > S/C Amendment History
            PriSpInqRecVO priSpInqRecVO = new PriSpInqRecVO();
            priSpInqRecVO.setPropNo(event.getCstShHistVO().getPropNo());
            priSpInqRecVO.setAmdtSeq(event.getCstShHistVO().getAmdtSeq());
            priSpInqRecVO.setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
            priSpInqRecVO.setSpScrnEvntPgmCd("ESM_PRI_0057");
            command.manageInquiryRecord(priSpInqRecVO, account);
            // S/C 조회 LOG 저장 종료 //
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }


    /**
     * ESM_PRI_005704 : RETRIEVE<br>
     * Origin/Destination 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005704Event event = (EsmPri005704Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltRoutPntLocListVO> list = command.searchRoutePointLocationHistoryList(event.getPriSpScpRoutPntVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005704 : RETRIEVE<br>
     * Origin/Destination 정보가 ROUTE TYPE별로 존재하는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationHistoryType(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005704Event event = (EsmPri005704Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltRoutPntLocListVO> list = command.searchRoutePointLocationHistoryType(event.getPriSpScpRoutPntVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_01 : RETRIEVE<br>
     * Origin/Destination 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000401Event event = (EsmPri000401Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRoutPntLocListVO> list = command.searchRoutePointLocationInquiryList(event.getPriSpScpRoutPntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_01 : RETRIEVE<br>
     * Origin/Destination 정보가 ROUTE TYPE별로 존재하는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRoutePointLocationInquiryType(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000401Event event = (EsmPri000401Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltRoutPntLocListVO> list = command.searchRoutePointLocationInquiryType(event.getPriSpScpRoutPntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0058 : RETRIEVE<br>
     * Filing시 main,scope에서 validation하기 위하여 입력한 file date 보다 <br>
     * duration Expire Date가 작거나 같은 Scope을 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchExpireDateCheck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0058Event event = (EsmPri0058Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltExpChkVO> list = command.searchExpireDateCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0058 :  Save 버튼 컨트롤 <br>
     * Save 버튼 컨트롤 시 FMC confirm date를 확인한다.  <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFmcConfirmDateCheck(Event e) throws EventException {
        EsmPri0058Event event = (EsmPri0058Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchFmcConfirmDateCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    
    
    /**
     * ESM_PRI_0058 :  C/T 버튼 컨트롤 <br>
     * C/T 버튼 컨트롤 시 FMC confirm date를 확인한다. 48시간 이내인지  <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCorrectionLimitCheck(Event e) throws EventException {
        EsmPri0058Event event = (EsmPri0058Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCorrectionLimitCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0058 :  C/T 버튼 컨트롤 <br>
     * C/T 버튼 컨트롤 시 FMC confirm date를 확인한다. 48시간 이내인지  <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCorrectionLimitTime(Event e) throws EventException {
    	EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
		    List<RsltCdListVO> list33 = command.searchCorrectionLimitTime(event.getPriSpMnVO());
		    eventResponse.setRsVoList(list33);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
       
    
    /**
     * ESM_PRI_0058 :  C/T 버튼 클릭 전 validation <br>
     * C/T 버튼 클릭 시 최초 filing 후 48시간 이내인지 체크  <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchInitFileDtCheck(Event e) throws EventException {
        EsmPri0058Event event = (EsmPri0058Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchInitFileDtCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_005705 : RETRIEVE<br>
     * Commodity Group Master History 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005705Event event = (EsmPri005705Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltGrpCmdtListVO> list = command.searchGroupCommodityHistoryList(event.getPriSpScpGrpCmdtVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005705 : SHEET1@FOCUS<br>
     * Commodity Group Detail History 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityDeatilHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005705Event event = (EsmPri005705Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        
        try {
            List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailHistoryList(event.getPriSpScpGrpCmdtDtlVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_03 : RETRIEVE<br>
     * Commodity Group Master History 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000403Event event = (EsmPri000403Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtListVO> list = command.searchGroupCommodityInquiryList(event.getPriSpScpGrpCmdtVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_03 : SHEET1@FOCUS<br>
     * Commodity Group Detail History 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupCommodityDeatilInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000403Event event = (EsmPri000403Event) e;
        SCGroupCommodityProposalBC command = new SCGroupCommodityProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailInquiryList(event.getPriSpScpGrpCmdtDtlVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005710 : RETRIEVE<br>
     * Loading Agent 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchLoadingAgentHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005710Event event = (EsmPri005710Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();

        try {
            List<RsltLodgAgnListVO> list = command.searchLoadingAgentHistoryList(event.getPriSpScpLodgAgnVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0004_07 : RETRIEVE<br>
     * Loading Agent 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchLoadingAgentInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000407Event event = (EsmPri000407Event) e;
        SCLoadingAgentProposalBC command = new SCLoadingAgentProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltLodgAgnListVO> list = command.searchLoadingAgentInquiryList(event.getPriSpScpLodgAgnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005712 : RETRIEVE<br>
     * Special Note 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005712Event event = (EsmPri005712Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteListVO> list = command.searchNoteHistoryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005712 : SHEET1@FOCUS<br>
     * Special Note 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNoteContentHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005712Event event = (EsmPri005712Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentHistoryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0004_10 : RETRIEVE<br>
     * Special Note 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSpecialNoteInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000410Event event = (EsmPri000410Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteListVO> list = command.searchNoteInquiryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_10 : SHEET1@FOCUS<br>
     * Special Note 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSpecialNoteContentInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000410Event event = (EsmPri000410Event) e;
        SCNoteProposalBC command = new SCNoteProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltNoteCtntListVO> list = command.searchNoteContentInquiryList(event.getPriSpScpNoteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_005714 : RETRIEVE<br>
     * Location Group 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005714Event event = (EsmPri005714Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();

        try {
            List<RsltGrpLocListVO> list = command.searchGroupLocationHistoryList(event.getPriSpScpGrpLocVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005714 : SHEET1@FOCUS<br>
     * Location Group 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationDetailHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005714Event event = (EsmPri005714Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        
        try {
            List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailHistoryList(event.getPriSpScpGrpLocDtlVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_02 : RETRIEVE<br>
     * Location Group 의 Title 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000402Event event = (EsmPri000402Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpLocListVO> list = command.searchGroupLocationInquiryList(event.getPriSpScpGrpLocVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004_02 : SHEET1@FOCUS<br>
     * Location Group 의 Content 정보를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGroupLocationDetailInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri000402Event event = (EsmPri000402Event) e;
        SCGroupLocationProposalBC command = new SCGroupLocationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailInquiryList(event.getPriSpScpGrpLocDtlVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
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
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event)e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String prsBatId = "";;

        try{
			//////////////////////////////////////////////////////////////////
			// property 읽어 오기
			String rCnt = SubSystemConfigFactory.get("PRI.SC.ROTATION.CNT");
			int iRCnt = 10;
			if( rCnt != null ){
				iRCnt = Integer.valueOf(rCnt); 
			}
			///////////////////////////////////////////////////////////////////
			
            PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriSpScpRtCmdtRoutVO());
            PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);


            //pri_Prs_Bat table에 데이터가 있을경우
            if( prsBatchVO != null ){
                String status  = command.monitorCalculate(prsBatchVO);

                if( "0".equals(status)  // Nothing 아직 상태모름
                        || "1".equals(status) // running
                        || "8".equals(status) // INACTIVE   실행대기
                        || "12".equals(status)// QUE_WAIT    로드밸런싱 대기
                        ){
                    //이미 실행중이라면 에러 처리한다.
                     throw new EventException(new ErrorHandler("PRI03019",new String[]{account.getUsr_id()}).getMessage());
                }
            }
        	//////////////////////////////////////////////////////////////////////////////////// 
        	//batch 프로그램 명을 rotation 하기 위한 작업 시작
        	PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
        	updatePriPrsBatVO.setPgmNo("ESM_PRI_T004");
        	updatePriPrsBatVO.setPrsBatId( String.valueOf(iRCnt) );
        	begin();
        	comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
        	commit();
        	PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation (updatePriPrsBatVO);
        	String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
        	log.debug("rotationPrsBatId====>"+rotationPrsBatId);
        	//batch 프로그램 명을 rotation 하기 위한 작업 종료
        	
			////////////////////////////////////////////////////////////////////////////////////      
        	
        	
            priPrsBatVO = command.executeCalculate(event.getPriSpScpRtCmdtRoutVO(),rotationPrsBatId,account);

            if( priPrsBatVO != null ){
                begin();
                comCommand.addPrsBatch(priPrsBatVO,account);
                prsBatId = priPrsBatVO.getPrsBatId();
                commit();
            }

            eventResponse.setETCData("JOB_ID",prsBatId);

        }catch(EventException ex){
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
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
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000308Event event = (EsmPri000308Event)e;
        SCRateProposalBC command = new SCRateProposalBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String batchId = "";

        try{
            PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getPriSpScpRtCmdtRoutVO());
            PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
            String status  = command.monitorCalculate(prsBatchVO);

            if( prsBatchVO != null ){
                batchId = prsBatchVO.getPrsBatId();
                //SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
	            if( "4".equals(status) ){
            		//SUCCESS가 아니면 FAIL처리
                	// null도 success로 간주한다.
	                if( prsBatchVO.getPrsBatErrVal() != null
	                        && prsBatchVO.getPrsBatErrVal().length() != 0
	                        && !"0".equals( prsBatchVO.getPrsBatErrVal() )){//SUCCESS가 아니면 FAIL처리
	                    status = "90";
	                }
	            }
            }
            eventResponse.setETCData("JOB_ID",batchId);
            eventResponse.setETCData("BATCH_STATUS",status);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_0057_01 : SHEET1@FOCUS<br>
     * Duration의 Amend History 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDurationHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005701Event event = (EsmPri005701Event) e;
        SCDurationProposalBC command = new SCDurationProposalBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltPriSpDurHisVO> list= command.searchProposalDurationHistoryList(event.getPriSpScpDurVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
            

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_0057_02 : SHEET1@FOCUS<br>
     * MQC Main,Scope Amend History 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMQCHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005702Event event = (EsmPri005702Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltPriSpMqcHisVO> list= command.searchProposalMQCHistoryList(event.getPriSpScpMqcVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_0057_02 : SHEET1@FOCUS<br>
     * Sub MQC Amend History 를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalSubMQCHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005702Event event = (EsmPri005702Event) e;
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        
        try {
            List<RsltPriSpSubMqcHisVO> list= command.searchProposalSubMQCHistoryList(event.getPriSpScpMqcVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0057_13 : RETRIEVE<br>
     * Boiler Plate Title 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005713Event event = (EsmPri005713Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltPriSpBlplVO> list = command.searchBoilerPlateHistoryList(event.getCstBlplSearchVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0057_13 : SHEET1@FOCUS<br>
     * Boiler Plate Content 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateDetailHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005713Event event = (EsmPri005713Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltPriSpBlplCtntVO> list = command.searchBoilerPlateDetailHistoryList(event.getPriSpBlplCtntVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_005707 : Search <br>
     * S/C Proposal Creation - Arbitrary Amend History List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArbitraryChargeHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri005707Event event = (EsmPri005707Event) e;

        SCTransportationAdditionalChargeProposalBC command1 = new SCTransportationAdditionalChargeProposalBCImpl();
        SCGRICalculationProposalBC command2 = new SCGRICalculationProposalBCImpl();

        PriSpScpTrspAddChgGriArbOKCLListVO griVO = new PriSpScpTrspAddChgGriArbOKCLListVO();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {

            List<RsltAddChgListVO> list1 = command1.searchArbitraryChargeHistoryList(event.getPriSpScpTrspAddChgVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list1);

            griVO.setPropNo(event.getPriSpScpTrspAddChgVO().getPropNo());
            griVO.setAmdtSeq(event.getPriSpScpTrspAddChgVO().getAmdtSeq());
            griVO.setSvcScpCd(event.getPriSpScpTrspAddChgVO().getSvcScpCd());
            griVO.setOrgDestTpCd(event.getPriSpScpTrspAddChgVO().getOrgDestTpCd());

            List<PriSpScpTrspAddChgGriArbOKCLListVO> list2 = command2.searchPriSpScpTrspAddChgGriArbOKCLList(griVO);
            if(list2 != null && list2.size() > 0) {
                eventResponse.setETCData("GRI_COUNT", "Y");
            } else {
                eventResponse.setETCData("GRI_COUNT", "N");
            }

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005707 : Search <br>
     * Arbitrary Amend History의 Origin과 Destination의 Font Sytle를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryHistoryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri005707Event event = (EsmPri005707Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005707 : Search <br>
     * S/C Proposal Creation - IHC Amend History List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIHCChargeHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri005715Event event = (EsmPri005715Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltAddChgListVO> list = command.searchIHCChargeHistoryList(event.getPriSpScpTrspAddChgVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005707 : Search <br>
     * IHC Amend History의 Origin과 Destination의 Font Sytle를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkIHCHistoryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri005715Event event = (EsmPri005715Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try{
            List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0003 :  Search  <BR>
     * Sale Lead No,Name을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainSaleLeadFirstList(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SchSaleLeadVO vo = new SchSaleLeadVO();
        vo = event.getSchSaleLeadVO();
        vo.setFirstSw("Y");
        try{
            List<RsltPriCrmSlLdVO> list = command.searchProposalMainSaleLeadList(vo);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Search  <BR>
     * Sale Lead No,Name을 조회합니다.(S/C Main에 저장된 sls_ld_no도 같이 조회)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainSaleLeadList(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SchSaleLeadVO vo = new SchSaleLeadVO();

        try{
            vo = event.getSchSaleLeadVO();
            vo.setFirstSw("N");
            List<RsltPriCrmSlLdVO> list = command.searchProposalMainSaleLeadList(vo);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


        return eventResponse;
    }

    /**
     * ESM_PRI_005708 : Search <br>
     * S/C Proposal Creation - GOH List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGOHChargeHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri005708Event event = (EsmPri005708Event) e;
        SCGOHChargeProposalBC command = new SCGOHChargeProposalBCImpl();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();

        try {
            List<RsltGohChgListVO> list = command.searchGOHChargeHistoryList(event.getPriSpScpGohChgVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0022 : Retrieve <br>
     * Option의 Font 처리를 하기위하여 데이터를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyFont(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0022Event event = (EsmPri0022Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltCdListVO> list = command.searchProposalContractPartyFont(event.getPriSpCtrtPtyVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005718 : Retrieve <br>
     * Contract Parties Amend History List를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005718Event event = (EsmPri005718Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        try {
            List<RsltPriSpCtrtPtyVO> list = command.searchProposalContractPartyHistoryList(event.getPriSpCtrtPtyVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_005718 : Retrieve <br>
     * Option의 Font 처리를 하기위하여 데이터를 조회합니다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyHistoryFont(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri005718Event event = (EsmPri005718Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = event.getPriSpHistoryInquiryParamVO();
        
        try {
            List<RsltCdListVO> list = command.searchProposalContractPartyHistoryFont(event.getPriSpCtrtPtyVO(),priSpHistoryInquiryParamVO);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004 : Retrive <br>
     * Proposal Main Inquiry List 를 조회합니다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0004Event event = (EsmPri0004Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        log.debug("searchProposalMainInquiryList====getSprcCtrtCustTpCd="+ event.getCstShInqVO().getSprcCtrtCustTpCd());
        try {
            List<RsltPriSpInqVO> list = command.searchProposalMainInquiryList(event.getCstShInqVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_PRI_0004 : Search <br>
     * RFA Proposal Main Inquiry 를 조회한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0004Event event = (EsmPri0004Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            RsltPropInqListVO vo = command.searchProposalMainInquiry(event.getPriSpMnVO(), account);

            eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
            eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());
            
            
            if( vo.getRsltPropMnInqVOs() != null ){
             
                // S/C 조회 LOG 저장 시작 [20171227][CSR #2875] //
                // ESM_PRI_0004  :  Sales Management > Pricing > Service Contract > S/C Inquiry > S/C Proposal & Amendment Inquiry
                PriSpInqRecVO priSpInqRecVO = new PriSpInqRecVO();
                priSpInqRecVO.setPropNo(vo.getRsltPropMnInqVOs().get(0).getPropNo());
                priSpInqRecVO.setAmdtSeq(vo.getRsltPropMnInqVOs().get(0).getAmdtSeq());
                priSpInqRecVO.setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
                priSpInqRecVO.setSpScrnEvntPgmCd("ESM_PRI_0004");
                command.manageInquiryRecord(priSpInqRecVO, account);
                // S/C 조회 LOG 저장 종료 //
            }
            
            
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0004 : Search <br>
     * SC Proposal Inquiry Scope Terms의 Amendment Summary 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeAmendmentSummaryInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0004Event event = (EsmPri0004Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummaryInquiry(event.getPriSpScpAmdtSmryVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0004 : Open<br>
     * Proposal& Amendment Inquery 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initProposalInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();

        try{
            List<RsltCdListVO> appList = command.searchApprovalOfficeList(new RsltCdListVO());
            eventResponse.setCustomData("appList", appList);
            List<RsltCdListVO> preList = command.searchScPrefixList(new RsltCdListVO());
            eventResponse.setCustomData("preList", preList);

            RsltCdListVO rsltCdListVO = new RsltCdListVO();
            rsltCdListVO.setEtc1(account.getOfc_cd());
            log.debug("init ================ ofc_cd="+ account.getOfc_cd());
            List<RsltCdListVO> saleReplist = command.searchSalesRepByOfficeList(rsltCdListVO);
            eventResponse.setCustomData("saleRepList", saleReplist);

            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> mqcSignList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02280",0);
            eventResponse.setCustomData("mqcSignList", mqcSignList);

            ArrayList<CodeInfo> scTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02266",0);
            eventResponse.setCustomData("scTypeList", scTypeList);

            ArrayList<CodeInfo> stsTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01722",0);
            eventResponse.setCustomData("stsTypeList", stsTypeList);

            ArrayList<CodeInfo> custTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01714",0);
            eventResponse.setCustomData("custTypeList", custTypeList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004 : Customer<br>
     * Customer Country Code와 Customer Seq로 Customer 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCustomerInfoInquiry(Event e) throws EventException {
        PriSpCtrtPtyVO paramVo = new PriSpCtrtPtyVO();
        EsmPri0004Event event = (EsmPri0004Event) e;
        paramVo = event.getPriSpCtrtPtyVO();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfoInquiry(paramVo);

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

//    /**
//     * ESM_PRI_0047 : Open<br>
//     * Boiler Plate Header 정보를 조회합니다.<br>
//     * 변경-> 확인 후 삭제
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//    private EventResponse searchBoilerPlateHeaderInquiry(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        EsmPri0047Event event = (EsmPri0047Event) e;
//        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        try{
//            List<RsltPriSpBlplHeaderVO> list = command.searchBoilerPlateHeaderInquiry(event.getRsltPriSpBlplHeaderVO());
//
//            eventResponse.setRsVoList(list);
//        }catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//
//        return eventResponse;
//    }
    /**
     * ESM_PRI_0047 : Open<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initBoilerInquiryComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0047 : Open<br>
     * Boiler Plate Title 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0047Event event = (EsmPri0047Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();

        try{
            List<RsltPriSpBlplInqVO> list = command.searchBoilerPlateInquiryList(event.getCstBlplSearchVO());
            RsltPriSpBlplHeaderVO vo = new RsltPriSpBlplHeaderVO();
            ObjectCloner.build(event.getCstBlplSearchVO(), vo);

            if (!vo.getBlplHdrSeq().equals("")){
                List<RsltPriSpBlplHeaderVO> list1 = command.searchBoilerPlateTitle(vo);
                eventResponse.setETCData("blpl_nm", list1.get(0).getBlplNm());
                eventResponse.setETCData("blpl_ref_yr", list1.get(0).getBlplRefYr());
                eventResponse.setETCData("blpl_hdr_seq", list1.get(0).getBlplHdrSeq());
            }
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0047 : Open<br>
     * Boiler Plate  Contents를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBoilerPlateDetailInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0047Event event = (EsmPri0047Event) e;
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            List<RsltPriSpBlplCtntInqVO> list = command.searchBoilerPlateDetailInquiryList(event.getPriSpBlplCtntVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_PRI_0048 : Open<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initAffilInquiryComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0048 : Open<br>
     * Affiliate Inquiry List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateInquiryList(Event e) throws EventException {
        EsmPri0048Event event = (EsmPri0048Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriSpAfilInqVO> list = command.searchAffiliateInquiryList(event.getPriSpAfilVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0048 : Open<br>
     * Manual 입력된 Customer를 확인하기 위하여 Manual 입력  여부를 조회한다.  <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualCheckInquiry(Event e) throws EventException {
        EsmPri0048Event event = (EsmPri0048Event) e;
        SCAffiliateProposalBC command = new SCAffiliateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpAfilVO> list = command.searchManualCheckInquiry(event.getPriSpAfilVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0078 : Open <br>
     * Contract Parties Information Inquiry List를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyInquiryList(Event e) throws EventException {
        EsmPri0078Event event = (EsmPri0078Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpCtrtPtyInqVO> list = command.searchProposalContractPartyInquiryList(event.getPriSpCtrtPtyVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }



    /**
     * ESM_PRI_0078 : Open <br>
     * Option의 Font 처리를 하기위하여 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalContractPartyFontInquiry(Event e) throws EventException {
        EsmPri0078Event event = (EsmPri0078Event) e;
        SCContractPartyProposalBC command = new SCContractPartyProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltCdListVO> list = command.searchProposalContractPartyFont(event.getPriSpCtrtPtyVO());

        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0078 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initCtrtPtyInquiryComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02064",0);
            eventResponse.setCustomData("srcInfoList", srcInfoList);
            ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("stsList", stsList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000404 : Search <br>
     * S/C Proposal Inquiry - Arbitrary List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArbitraryChargeInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000404Event event = (EsmPri000404Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<RsltAddChgListVO> list = command.searchArbitraryChargeInquiryList(event.getPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000404 : Search <br>
     * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryInquiryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000404Event event = (EsmPri000404Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try{
            List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000405 : Search <br>
     * S/C Proposal Inquiry - IHC List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIHCChargeInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000405Event event = (EsmPri000405Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try {
            List<RsltAddChgListVO> list = command.searchIHCChargeInquiryList(event.getPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000404 : Search <br>
     * IHC의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkIHCInquiryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000405Event event = (EsmPri000405Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();
        try{
            List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_000406 : Search <br>
     * SC GOH Inquiry List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchGOHChargeInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri000406Event event = (EsmPri000406Event) e;
        SCGOHChargeProposalBC command = new SCGOHChargeProposalBCImpl();

        try {
            List<RsltGohChgListVO> list = command.searchGOHChargeInquiryList(event.getPriSpScpGohChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Save  <br>
     * Save시 Customer Type이 변경되었다면 <br>
     * Commodity Group, Rate, Standard Note에 데이터가 있는지 조회한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainCustTypeChkList(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchProposalMainCustTypeChkList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Initial Cancel  <br>
     * Proposal Cancel 시 Dem/Det 데이터가 있다면  <br>
     * Proposal Cancel을 금지한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInitCancelCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchProposalMainInitCancelCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0003 :  Initial Cancel  <br>
     * Proposal Cancel 시 CHSS Exception 데이터가 있다면  <br>
     * Proposal Cancel을 금지한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInitCancelChssCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchProposalMainInitCancelChssCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0003 :  Initial Cancel  <br>
     * 1번 회차 이상의 Amend Proposal Cancel 시 CHSS Exception 데이터가 생성 된 것이 있다면  <br>
     * Amend Proposal Cancel을 금지한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInitCancelChssEffDtCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchProposalMainInitCancelChssEffDtCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0003 :  Request  <br>
     * Request 시 TPE Scope Destination에 Block하는 location이 있는지 체크한다. <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalRouteCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchProposalRouteCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Request  <br>
     * Request 시 Affiliate type code 가 중복이 되는지 체크한다. <br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateTypeDupCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        try{
            List<RsltCdListVO> list = command.searchAffiliateTypeDupCheck(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0003 : Open <br>
     * Performance를 조회하기 위해 BackEndJob 을 실행한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPerformance(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        EsmPri0003Event event = (EsmPri0003Event)e;
        try{
            eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceDoStart(account, event.getPriSpMnVO()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0004 : Open <br>
     * Performance를 조회하기 위해 BackEndJob 을 실행한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPerformanceInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        EsmPri0004Event event = (EsmPri0004Event)e;
        try{
            eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceDoStart(account, event.getPriSpMnVO()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0087 : Open <br>
     * Performance를 조회하기 위해 BackEndJob 을 실행한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPerformanceViewInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();
        EsmPri0087Event event = (EsmPri0087Event)e;
        try{
            eventResponse.setETCData("BackEndJobKey", command.searchSCPerformanceDoStart(account, event.getPriSpMnVO()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 :  Search  <BR>
     * PRS CM Data를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainPRSCMData(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCProposalMainBC command = new SCProposalMainBCImpl();

        try{
            List<RsltPRSCMDataVO> list = command.searchProposalMainPRSCMData(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0003 : OPEN<br>
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
        try{
            List<RsltCdListVO> appList = command.searchApprovalOfficeList(new RsltCdListVO());
            eventResponse.setCustomData("appList", appList);
            List<RsltCdListVO> appNewList = command.searchApprovalOfficeAllList(new RsltCdListVO());
            eventResponse.setCustomData("appAllList", appNewList);
            List<RsltCdListVO> scopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("scopeList", scopeList);

            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> custTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01714",0);
            eventResponse.setCustomData("custTypeList", custTypeList);
            ArrayList<CodeInfo> lodUtList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD00897",0);
            eventResponse.setCustomData("lodUtList", lodUtList);
            ArrayList<CodeInfo> scpStsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
            eventResponse.setCustomData("scpStsList", scpStsList);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003:conversion check<br>
     * Conversion을 완료 체크한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse changeConversionFlg(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();

        try {
            begin();
            command.changeConversionFlg(event.getPriSpMnVO(), account);
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
     * ESM_PRI_0057 : sheet_selectCell <BR>
     *  Conversion Data를 삭제 후 새로 Conversion Data를 입력한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageConversionUpdate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0057Event event = (EsmPri0057Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SCNoteConversionProposalBC command1 = new SCNoteConversionProposalBCImpl();
        SCRateProposalBC command2 = new SCRateProposalBCImpl();
        SCNoteProposalBC command3 = new SCNoteProposalBCImpl();
        PriSpMnVO mnVo = new PriSpMnVO();
        mnVo = event.getPriSpMnVO();

        try {
            begin();

            command1.manageConversionUpdate(event.getPriSpMnVO(), account);
            command2.manageConversionUpdate(mnVo , account);//RATE NOTE_CHG_TP_CD 수정
            command3.manageConversionUpdate(mnVo , account);//NOTE NOTE_CHG_TP_CD 수정
            command.changeConversionFlg(event.getPriSpMnVO(), account);

            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_04 : Load Page <br>
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
            if(e.getEventName().equalsIgnoreCase("EsmPri0024Event")) {
                EsmPri0024Event event = (EsmPri0024Event) e;

                // Excel Template File Key
                ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
                if("O".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                    comUpldFileVO.setFileUpldNm("SP_Arb_Templet_O.xls");
                } else if("D".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                    comUpldFileVO.setFileUpldNm("SP_Arb_Templet_D.xls");
                }
                String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
                eventResponse.setCustomData("templateKey", fileKey);
            }

            // Trans Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("prcTrspModCd", codeInfos);

            // Rating Unit Code
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("ratUtCd", customData);

            // Currency Code
            customData = command.searchCurrencyCodeList(new RsltCdListVO());
            eventResponse.setCustomData("currCd", customData);

            // Cargo Type Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("prcCgoTpCd", codeInfos);

            // Gri
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01707", 0);
            eventResponse.setCustomData("griApplTpCd", codeInfos);

            // Source Info Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02064", 0);
            eventResponse.setCustomData("srcInfoCd", codeInfos);

            // Proposal Status Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
            eventResponse.setCustomData("prcProgStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_05 : Load Page <br>
     * 기본 Code List를 초기화한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initIHCComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try {
            if(e.getEventName().equalsIgnoreCase("EsmPri0068Event")) {
                EsmPri0068Event event = (EsmPri0068Event) e;

                // Excel Template File Key
                ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
                if("O".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                    comUpldFileVO.setFileUpldNm("SP_IHC_Templet_O.xls");
                } else if("D".equals(event.getCstPriSpScpTrspAddChgVO().getOrgDestTpCd())) {
                    comUpldFileVO.setFileUpldNm("SP_IHC_Templet_D.xls");
                }
                String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
                eventResponse.setCustomData("templateKey", fileKey);
            }

            // Trans Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("prcTrspModCd", codeInfos);

            // Rating Unit Code
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("ratUtCd", customData);

            // Currency Code
            customData = command.searchCurrencyCodeList(new RsltCdListVO());
            eventResponse.setCustomData("currCd", customData);

            // Cargo Type Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("prcCgoTpCd", codeInfos);

            // Source Info Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02064", 0);
            eventResponse.setCustomData("srcInfoCd", codeInfos);

            // Proposal Status Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
            eventResponse.setCustomData("prcProgStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003_06 : Load Page <br>
     * 기본 Code List를 초기화한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initGOHComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        PRICommonBC command = new PRICommonBCImpl();

        CodeUtil cdUtil = CodeUtil.getInstance();

        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;

        try {
            // Trans Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01708", 0);
            eventResponse.setCustomData("prcHngrBarTpCd", codeInfos);

            // Rating Unit Code
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("ratUtCd", customData);

            // Currency Code
            customData = command.searchCurrencyCodeList(new RsltCdListVO());
            eventResponse.setCustomData("currCd", customData);

            // Source Info Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02064", 0);
            eventResponse.setCustomData("srcInfoCd", codeInfos);

            // Proposal Status Code
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
            eventResponse.setCustomData("prcProgStsCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /*************************************************************************************************/
    /*  BACK END JOB 관련 - Start                                                                  */
    /*************************************************************************************************/
    /**
     * BackEndJob : interval <br>
     * ESM_PRI_0003,ESM_PRI_0004 Performance BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse comBakEndJbVOs(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.comBakEndJbVOs(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * BackEndJob : search <br>
     * BackEndJob 결과 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private EventResponse comBackEndJbSearchListGetResult(Event e) throws EventException {
        List list = null;
        String key = (String)e.getAttribute("KEY");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            if(e.getEventName().equalsIgnoreCase("EsmPri0003Event")) {
                list = (List<RsltPerformanceVO>)BackEndJobResult.loadFromFile(key);
            }else if (e.getEventName().equalsIgnoreCase("EsmPri0004Event")){
                list = (List<RsltPerformanceVO>)BackEndJobResult.loadFromFile(key);
            }else if (e.getEventName().equalsIgnoreCase("EsmPri0087Event")){
            	list = (List<RsltPerformanceVO>)BackEndJobResult.loadFromFile(key);
            }else if (e.getEventName().equalsIgnoreCase("EsmPri0058Event")){
            	list = (List<CstPriSpMnFileDtVO>)BackEndJobResult.loadFromFile(key);
            }
            eventResponse.setRsVoList(list);
            
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /*************************************************************************************************/
    /*  BACK END JOB 관련 - End                                                                    */
    /*************************************************************************************************/

    /*************************************************************************************************/
    /*  I/F  관련 - Start                                                                  */
    /*************************************************************************************************/
    /**
     * NIS : ESM068_0001 <br>
     * NIS 로부터 온 정보를 저장/ IF 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse receiveNISProposalInfo(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();

        Esm0680001Event event = (Esm0680001Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();

        try {
            // shell 프로그래밍 수행 필요
            command.receiveNISProposalInfo(event.getPropNo(), event.getAmdtNo(), event.getOpCd());

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /*************************************************************************************************/
    /*  I/F 관련  - End                                                                    */
    /*************************************************************************************************/

    /**
     * ESM_PRI_0024 : Save <br>
     * Arbitrary List를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArbitraryLoadExcelDupList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0024Event event = (EsmPri0024Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<ArbitraryExcelDupCheckVO> list = command.searchArbitraryLoadExcelDupList(event.getPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0024 : CHECK<br>
     * 엑셀파일정보를 VALIDATION체크한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    private EventResponse searchCodeCheckResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0024Event event = (EsmPri0024Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<PriSpScpTrspAddChgVO> list = command.searchCodeCheckResult(event.getPriSpScpTrspAddChgVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0068 : Save <br>
     * Excel import 시 dup check를 위하여 IHC Charge List를 조회한다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIHCChargeLoadExcelDupList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0068Event event = (EsmPri0068Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<IHCExcelDupCheckVO> list = command.searchIHCLoadExcelDupList(event.getPriSpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0068: CHECK<br>
     * 엑셀파일정보를 VALIDATION체크한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    private EventResponse searchIhcCodeCheckResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0068Event event = (EsmPri0068Event) e;
        SCTransportationAdditionalChargeProposalBC command = new SCTransportationAdditionalChargeProposalBCImpl();

        try {
            List<PriSpScpTrspAddChgVO> list = command.searchIhcCodeCheckResult(event.getPriSpScpTrspAddChgVOS());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0003 : Cancel<br>
     *  Request Cancel시 Accept, Returned 데이터가 있는지 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalRequestCancelCheck(Event e) throws EventException {
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<CstRequestCheckVO> list = command.searchProposalRequestCancelCheck(event.getPriSpMnVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_0023 :  Delete  <BR>
     * Master Delete시 Detail  데이터에 Accept된 항목이 있는지 조회한다.<br>
     * Accept데이터가 있다면 삭제할 수 없다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailAccept(Event e) throws EventException {
        EsmPri0023Event event = (EsmPri0023Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCBoilerPlateProposalBC command = new SCBoilerPlateProposalBCImpl();
        try{
            List<RsltCdListVO> list = command.searchDetailAccept(event.getPriSpBlplVOs());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }


    /**
     * ESM_PRI_6086 : Search <br>
     * SC GOH Inquiry List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeViewAllList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6086Event event = (EsmPri6086Event) e;
        SCRateProposalBC command = new SCRateProposalBCImpl();

        try {
            List<RsltPriSurchargeViewAllVO> list = command.searchSurchargeViewAllList(event.getPriSpScpRtCmdtHdrVO());
            List<RsltPriSurchargeLastAccessDateVO> accessList = command.searchSurchargeLastAccessDateList(event.getPriSpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(list);
            
            String accessDateG = "";
            String accessDateS = "";
            String custType = "";
            if( accessList.size() > 0 ){
            	for(int i = 0 ; i < accessList.size(); i++){
            		if(accessList.get(i).getGenSpclRtTpCd().equals("G") ){
            			accessDateG =  accessList.get(i).getCreYmd();
            		}else if(accessList.get(i).getGenSpclRtTpCd().equals("S")){
            			accessDateS = accessList.get(i).getCreYmd();
            		}else if( accessList.get(i).getGenSpclRtTpCd().equals("CUST_TYPE") ){
            			custType = accessList.get(i).getCreYmd();
            		}
            	}
            }
            eventResponse.setETCData("access_date_g", accessDateG);
            eventResponse.setETCData("access_date_s", accessDateS);
            eventResponse.setETCData("cust_type", custType);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0020 :  Save  <BR>
     * 저장시 Scope의 갯수를 조회 한다.<br>
     * 조회한 Scope의 수가 한 개 일 경우 Scope,Main수정시 Main 또는 Scope의 수정 또한 사용자에게 확인한다.<br> 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchScopeCount(Event e) throws EventException {
        EsmPri0020Event event = (EsmPri0020Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCMQCProposalBC command = new SCMQCProposalBCImpl();
        PriSpMnVO mnVo = new PriSpMnVO();

        mnVo.setPropNo(event.getPriSpScpMqcVO().getPropNo());
        log.debug(mnVo.getPropNo());

        mnVo.setAmdtSeq(event.getPriSpScpMqcVO().getAmdtSeq());

        try{

        	List<RsltCdListVO> list = command.searchScopeCount(mnVo);

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }    
    
    
    /**
     * ESM_PRI_0019 :  Save  <BR>
     * 저장시 Scope의 갯수를 조회 한다.<br>
     * 조회한 Scope의 수가 한 개 일 경우 Scope,Main수정시 Main 또는 Scope의 수정 또한 사용자에게 확인한다.<br> 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDurScopeCount(Event e) throws EventException {
        EsmPri0019Event event = (EsmPri0019Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        PriSpMnVO mnVo = new PriSpMnVO();

        mnVo.setPropNo(event.getPriSpScpDurVO().getPropNo());
        mnVo.setAmdtSeq(event.getPriSpScpDurVO().getAmdtSeq());

        try{

        	List<RsltCdListVO> list = command.searchDurScopeCount(mnVo);

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }    
    
    /**
     * ESM_PRI_0019 :  Save  <BR>
     * 저장시 Main Duration을 조회하여 수정된 Scope Duration이 Main Duration의 사이에 있는지 검사한다.<br>
     *  
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchMainDuration(Event e) throws EventException {
        EsmPri0019Event event = (EsmPri0019Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCDurationProposalBC command = new SCDurationProposalBCImpl();

        try{
        	List<RsltCdListVO> list = command.searchMainDuration(event.getPriSpScpDurVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }    
    
    /**
     * ESM_PRI_0019 :  Save  <BR>
     * 저장시 Scope Duration을 조회하여 수정된 Main Duration이 Scope Duration의 사이에 있는지 검사한다.<br>
     *  
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchScopeDuration(Event e) throws EventException {
        EsmPri0019Event event = (EsmPri0019Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SCDurationProposalBC command = new SCDurationProposalBCImpl();
        try{
        	List<RsltCdListVO> list = command.searchScopeDuration(event.getPriSpScpDurVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }      
    
    
    /**
     * ESM_PRI_0003:Request<br>
     * Request 시 Group Ware Main 을 PopUp 하기 위한 조건을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProgRequestList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltCdListVO> list = command.searchProgRequestList(event.getPriSpMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }    
    
    

    /**
     * ESM_PRI_6090:Click Calculate Button<br>
     * MQC estimate 를 저장 하지 않는것이 있는지 확인한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckMQCEstimateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmPri6090Event event = (EsmPri6090Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltCheckMQCEstimateVO> list = command.searchCheckMQCEstimateList(event.getInPrsMQCEstimateVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }   
    
    
    /**
     * ESM_PRI_6090:onPlageLoad, Request<br>
     * MQC estimate Popup의 List를 조회한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchMQCEstimateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmPri6090Event event = (EsmPri6090Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            List<RsltMQCEstimateVO> list = command.searchMQCEstimateList(event.getInPrsMQCEstimateVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }   
    
    /**
     * ESM_PRI_6090:onPlageLoad, Request<br>
     * MQC estimate 를 갱신한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageMQCEstimateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6090Event event = (EsmPri6090Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
 
        try {
            begin();
            command.manageMQCEstimateList(event.getPriSpScpMnVOS(), account);
            commit();
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    

    /**
     * ESM_PRI_0003: Cancel Filing<br>
     * 숨은 기능인 Superuser만 실행 시킬수 있는 Cancel Filing
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelFilingForSuperuser(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
 
        try {
            begin();
            command.cancelFilingForSuperuser(event.getScPropProgVO(),account);
            
            //INTERFACE : EDI WEB 으로 General Information을 전송
            PriEdiScGenInfVO genInfVO = new PriEdiScGenInfVO();
            ObjectCloner.build(event.getScPropProgVO().getPriSpMnVOs()[0], genInfVO);
            genInfVO.setEaiSts("D");
            command.transferScGeneralInfo(genInfVO, account);
            
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
     * ESM_PRI_0003 : QUICK ACCEPT ALL<br>
     * Origin/Destination, LOC Group, CMDT Group, Arbitrary, GOH 5개 항목에 대해서 동시 ACCEPT 처리한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse quickAcceptAllTerms(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0003Event event = (EsmPri0003Event) e;
        SCRoutePointProposalBC command = new SCRoutePointProposalBCImpl();			//Ori/Dest
        SCGroupLocationProposalBC command1 = new SCGroupLocationProposalBCImpl();	//LOC Group
        SCGroupCommodityProposalBC command2 = new SCGroupCommodityProposalBCImpl();	//CMDT Group
        SCTransportationAdditionalChargeProposalBC command3 = new SCTransportationAdditionalChargeProposalBCImpl();	//Arbitrary
        SCGOHChargeProposalBC command4 = new SCGOHChargeProposalBCImpl();			//GOH
        SCProposalMainBC command5 = new SCProposalMainBCImpl();
        String result = "";
        int rValue = 0;
        int cnt = 0;
        
        try {
        	begin();
        	
        	PriSpScpMnVO scpMnVo = event.getPriSpScpMnVO();
        	PriSpMnVO mnVo = event.getPriSpMnVO();
        	PriSpScpRoutPntVO scpRoutPntVo = new PriSpScpRoutPntVO();
        	ObjectCloner.build(scpMnVo, scpRoutPntVo);
        	
            PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
            smryVO.setPropNo(scpRoutPntVo.getPropNo());
            smryVO.setAmdtSeq(scpRoutPntVo.getAmdtSeq());
            smryVO.setSvcScpCd(scpRoutPntVo.getSvcScpCd());
        	
        	//1. Ori/Dest
        	scpRoutPntVo.setOrgDestTpCd("O");
        	result = command.quickAcceptAllRoutePoint(scpRoutPntVo, account);
        	if("OK".equals(result)) {
            //Amendment Summary Update
        		smryVO.setPropScpTermTpCd("41"); 
        		command5.manageScopeAmendmentSummary(smryVO, account);
        		cnt++;
            }
        	
        	scpRoutPntVo.setOrgDestTpCd("D");
        	result = command.quickAcceptAllRoutePoint(scpRoutPntVo, account);
        	if("OK".equals(result)) {
            //Amendment Summary Update
                smryVO.setPropScpTermTpCd("42");
	            command5.manageScopeAmendmentSummary(smryVO, account);
	            cnt++;
            }
        	
        	//2. LOC Group
        	PriSpScpGrpLocDtlVO scpGrpLocDtlVO = new PriSpScpGrpLocDtlVO();
        	ObjectCloner.build(scpMnVo, scpGrpLocDtlVO);
            result = command1.acceptAllGroupLocation(scpGrpLocDtlVO, account);
        	if("OK".equals(result)){
        		cnt++;
        	}
            //Amendment Summary Update
            smryVO.setPropScpTermTpCd("13");
            command5.manageScopeAmendmentSummary(smryVO, account);
            
            //3. CMDT Group
            PriSpScpGrpCmdtDtlVO scpGrpCmdtDtlVO = new PriSpScpGrpCmdtDtlVO();
        	ObjectCloner.build(scpMnVo, scpGrpCmdtDtlVO);
            result = command2.acceptAllGroupCommodity(scpGrpCmdtDtlVO, account);
        	if("OK".equals(result)){
        		cnt++;
        	}
            //Amendment Summary Update
            smryVO.setPropScpTermTpCd("14");
            command5.manageScopeAmendmentSummary(smryVO, account);
            
            //4. Arbitrary
            CstArbAcceptVO cstArbAcceptVO = new CstArbAcceptVO();
        	ObjectCloner.build(scpMnVo, cstArbAcceptVO);
        	cstArbAcceptVO.setOrgDestTpCd("O");
        	cstArbAcceptVO.setPropStsCd(mnVo.getPropStsCd());
            rValue = command3.acceptAllArbitraryChargeFast(cstArbAcceptVO, account);
            if (rValue > 0){
            	//Amendment Summary Update
            	smryVO.setPropScpTermTpCd("51");
                command5.manageScopeAmendmentSummary(smryVO, account);
        		cnt++;
            }
            
        	cstArbAcceptVO.setOrgDestTpCd("D");
            rValue = command3.acceptAllArbitraryChargeFast(cstArbAcceptVO, account);
            if (rValue > 0){
            	//Amendment Summary Update
            	smryVO.setPropScpTermTpCd("52");
                command5.manageScopeAmendmentSummary(smryVO, account);
        		cnt++;
            }
            
            //5. GOH
            PriSpScpGohChgVO scpGohChgVO = new PriSpScpGohChgVO();
        	ObjectCloner.build(scpMnVo, scpGohChgVO);
        	
        	result = command4.quickAcceptAllGOHCharge(scpGohChgVO, account);
        	if("OK".equals(result)) {
            //Amendment Summary Update
        		smryVO.setPropScpTermTpCd("16");
        		command5.manageScopeAmendmentSummary(smryVO, account);
        		cnt++;
            }
        	
//            eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        eventResponse.setETCData("cnt", cnt+"");
        return eventResponse;
    }
    
    
    /**
     * UI_PRI_6023 : Open <br>
     * 초기값을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initPreCMSimulation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
	   	CommonBC commonBC = new CommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
     	   String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    	   String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
    	   ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	       ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
	       
    	   eventResponse.setETCData("ofc_cd", ofc_cd);
	       eventResponse.setETCData("ofc_lvl",ofc_lvl );
	       	
    	   if   (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       			 /*1. Profit Level*/
						 {"rptAuth","CD00939|"+ofc_lvl,""},
						 /*2. Office Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*3. Type/Size*/
						 {"ORITPSZ","","Blank"},
						 /*4. Office */
						 {"AllOffice","","Blank"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0087 : Search <br>
     * S/C Proposal Main View Inquiry 를 조회한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainViewInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0087Event event = (EsmPri0087Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	// S/C No로 Prop No 조회하기
        	if("".equals(event.getPriSpMnVO().getPropNo())){
        		PriSpHdrVO priSpHdrVO = command.searchProposalNoFromScNo(event.getPriSpHdrVO());
        		if(priSpHdrVO != null && !"".equals(priSpHdrVO.getPropNo())){
        			event.getPriSpMnVO().setPropNo(priSpHdrVO.getPropNo());
        		}
        	}
            RsltPropInqListVO vo = command.searchProposalMainInquiry(event.getPriSpMnVO(), account);
            
            eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
            eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());
            
            if( vo.getRsltPropMnInqVOs() != null ){
                
                // S/C 조회 LOG 저장 시작 [20171227][CSR #2875] //
                // ESM_PRI_0087  :  Service Management > Booking/Documentation > Booking > Booking > Booking Creation 
                //                --> BKG Creation(1) 탭, Charge(8) 탭
                PriSpInqRecVO priSpInqRecVO = new PriSpInqRecVO();
                priSpInqRecVO.setPropNo(vo.getRsltPropMnInqVOs().get(0).getPropNo());
                priSpInqRecVO.setAmdtSeq(vo.getRsltPropMnInqVOs().get(0).getAmdtSeq());
                priSpInqRecVO.setLginUsrIp(InetAddress.getLocalHost().getHostAddress());
                priSpInqRecVO.setSpScrnEvntPgmCd("ESM_PRI_0087");
                command.manageInquiryRecord(priSpInqRecVO, account);
                // S/C 조회 LOG 저장 종료 //
            }
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0087 : Search <br>
     * S/C Proposal Main View Inquiry Scope Terms의 Amendment Summary 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeAmendmentSummaryViewInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0087Event event = (EsmPri0087Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummaryInquiry(event.getPriSpScpAmdtSmryVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }
    
    /**
     * ESM_PRI_0040 : Search <br>
     * ESM_PRI_0041 : Search <br>
     * S/C Real Customer 를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRealCustomerList(Event e) throws EventException {
    	//PDTO(Data Transfer Object including Parameters)    	
    	RsltRealCustInquiryVO paramVo = new RsltRealCustInquiryVO();
    	if (e.getEventName().equalsIgnoreCase("EsmPri0040Event")) {
            EsmPri0040Event event = (EsmPri0040Event) e;
            paramVo = event.getRsltRealCustInquiryVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0041Event")) {
        	EsmPri0041Event event = (EsmPri0041Event) e;
        	paramVo = event.getRsltRealCustInquiryVO();
        }

		SCRealCustomerProposalBC command = new SCRealCustomerProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
	    try{
	        List<RsltRealCustInquiryVO> list = command.searchRealCustomerList(paramVo);
            eventResponse.setRsVoList(list);
	    }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
	    return eventResponse;
  }
  
    /**
     * ESM_PRI_0040 : SAVE<br>
     * Real Customer 정보를 저장 한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRealCustomer(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri0040Event event = (EsmPri0040Event) e;
    	SCRealCustomerProposalBC command = new SCRealCustomerProposalBCImpl();
    	SCProposalMainBC command1 = new SCProposalMainBCImpl();
 
        try {
            begin();
            command.manageRealCustomer(event.getPriSpRealCustVOs(), account);
	        List<RsltRealCustInquiryVO> list = command.searchRealCustomerList(event.getRsltRealCustInquiryVO());

	        if( list.size() != 0 ){
	        	command1.modifyProposalMainRealCustomer(event.getPriSpRealCustVOs(),"N", account);
	        }else{
	        	command1.modifyProposalMainRealCustomer(event.getPriSpRealCustVOs(),"Y", account);
	        }
            commit();
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0040 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRealCustomerComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> custTypeList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01714",0);
            eventResponse.setCustomData("custTypeList", custTypeList);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_0040 : OPEN<br>
     * Affiliate와 Loading Agent 의 cust 정보를 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateLoadingagentInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0040Event event = (EsmPri0040Event) e;
        SCRealCustomerProposalBC command = new SCRealCustomerProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<PriSpRealCustVO> list = command.searchAffiliateLoadingagentInfo(event.getPriSpRealCustVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    } 
    /**
     * ESM_PRI_0122 : Search <br>
     * S/C Cancel 된 List를 조회한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFiledCancelHistoryList(Event e) throws EventException {
    	//PDTO(Data Transfer Object including Parameters)    	
    	PriSpFiledCancelSearchVO paramVo = new PriSpFiledCancelSearchVO();
            EsmPri0122Event event = (EsmPri0122Event) e;
            paramVo = event.getPriSpFiledCancelSearchVO();

        SCProposalMainBC command = new SCProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
	    try{
	        List<PriSpFiledCancelSearchVO> list = command.searchFiledCancelHistoryList(paramVo);
            eventResponse.setRsVoList(list);
	    }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
	    return eventResponse;
  }
    
    /**
     * ESM_PRI_0122: Cancel Filing<br>
     * Filed S/C를 cancel 한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageFiledCancelProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0122Event event = (EsmPri0122Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        
        try {
            begin();
            PriSpFileCxlHisVO priSpFileCxlHisVO = event.getPriSpFileCxlHisVOs()[0];
            command.manageFiledCancelProposal(priSpFileCxlHisVO, event.getPriSpProgVO(), account);
//            command.cancelFilingForSuperuser(event.getScPropProgVO(),account);
            
            //INTERFACE : EDI WEB 으로 General Information을 전송d
            PriEdiScGenInfVO genInfVO = new PriEdiScGenInfVO();
            ObjectCloner.build(event.getPriSpFileCxlHisVOs()[0], genInfVO);
            genInfVO.setEaiSts("D");
            command.transferScGeneralInfo(genInfVO, account);
            
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
     * ESM_PRI_0123 : Search <br>
     * S/C Cancel 된 List를 조회한다..<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFiledCancelHistoryInquiryList(Event e) throws EventException {
    	//PDTO(Data Transfer Object including Parameters)    	
    	   PriSpFiledCancelSearchVO paramVo = new PriSpFiledCancelSearchVO();
            EsmPri0123Event event = (EsmPri0123Event) e;
            paramVo = event.getPriSpFiledCancelSearchVO();

        SCProposalMainBC command = new SCProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
	    try{
	        List<PriSpFiledCancelSearchVO> list = command.searchFiledCancelHistoryInquiryList(paramVo);
            eventResponse.setRsVoList(list);
	    }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
	    return eventResponse;
  }

    /**
     * ESM_PRI_0058 : MULTI01 <br>
     * FMC 에 File 을 비동기 방식으로 전송한다. <br>
     * FILECONTRACT
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendFmcFileContractDoStart(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0058Event event = (EsmPri0058Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();
        SCDurationProposalBC command2 = new SCDurationProposalBCImpl();
        SCNoteConversionProposalBC command4 = new SCNoteConversionProposalBCImpl();

        PriSpMnVO priSpMnVO = new PriSpMnVO();

        try{
        	// RD Report 를 생성하는 Connection 과 SC 에서 Transaction 을 수행하는 Connection 이 서로 다른바
        	// 부득이 하나의 실행 안에서 begin - commit 을 분리하여 수행토록 수정 함. 2014.10.29
        	
            begin();
            //이전 seq의 exp_dt를 자른다.
            //status를 변경한다.
            //amend eff_dt 보다 file_dt가 크다면 scope,main amend_eff_dt를 자른다
            CstPriSpMnFileDtVO fileDtVo = event.getCstPriSpMnFileDtVO();
            
			log.error ("FileContract-#1|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq());
            fileDtVo.setFmcFileTpCd("S");
            ObjectCloner.build(fileDtVo, priSpMnVO);

            //filing시 note conversion effective date변경
            if (fileDtVo.getEffDtChg().equals("Y")){
                command4.manageNoteConversionEffectiveDateFiling(priSpMnVO, account);
            }

            command.manageProposalFmcFiling(fileDtVo, account);//scope main
            if (fileDtVo.getEffDtChg().equals("Y")){
                //amend eff_dt 보다 file_dt가  크다면 main , scope duration의 eff_dt를 자른다.
            	// Amendment Seq 가 0 인 경우와 Amendment 가 0 이 아니라도 최초로 입력된 Svc Scope 인 경우에 대해서는
            	// 함께 PRI_SP_SCP_DUR.CTRT_EFF_DT 가 업데이트 되도록 로직을 변경함.
                command2.manageProposalTerms(priSpMnVO, account);//duration
            }
            commit();
            
            begin();
            eventResponse.setETCData("BackEndJobKey", command.sendFmcFileContractDoStart(event.getCstPriSpMnFileDtVO(), account) );
			commit();

        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        
        return eventResponse;
    }

    
    /**
     * ESM_PRI_0058 : MULTI01 <br>
     * FMC 에 File 을 비동기 방식으로 전송한다. <br>
     * FILECORRECTEDCOPY
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendFmcFileCorrectedCopyDoStart(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri0058Event event = (EsmPri0058Event) e;
        SCProposalMainBC command = new SCProposalMainBCImpl();

        try{
            begin();
            eventResponse.setETCData("BackEndJobKey", command.sendFmcFileCorrectedCopyDoStart(event.getCstPriSpMnFileDtVO(), account) );
			commit();

        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        
        return eventResponse;
    }

    /**
	 * [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)::프린트 파일 오픈시 권한 확인
	 * S/C Proposal Master Creation의 데이터를 조회합니다.의 RD Print 파일 오픈 권한 정보 조회를 한다. <br>
	 * 대상 : ESM_PRI_0057 (SCReportSC.java 참조) 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrintOpenAuthInfo(Event e) throws EventException {
		
		EsmPri0057Event event = (EsmPri0057Event)e;
		SCProposalMainBC command = new SCProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			RsltPropListVO vo =  command.searchProposalMainPrintAuthInfo(event.getPriSpHdrVO(), account); 
			
			eventResponse.setETCData("stsCd",        	vo.getRsltPropMnVOs().get(0).getPropStsCd() );
			eventResponse.setETCData("reqUsrFlg",       vo.getRsltPropMnVOs().get(0).getReqUsrFlg());
			eventResponse.setETCData("aproUsrFlg",     vo.getRsltPropMnVOs().get(0).getAproUsrFlg());
			eventResponse.setETCData("allUsrFlg",        vo.getRsltPropMnVOs().get(0).getAllUsrFlg());
			eventResponse.setETCData("maxPropUsrId", vo.getRsltPropMnVOs().get(0).getMaxPropUsrId() );
			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("\n[e.getEventName()]"+e.getEventName());
			log.debug("\n[account]"+account);
			log.debug("\n[stsCd]	"+eventResponse.getETCData("stsCd"));
			log.debug("\n[reqUsrFlg]"+eventResponse.getETCData("reqUsrFlg"));
			log.debug("\n[aproUsrFlg]"+eventResponse.getETCData("aproUsrFlg"));
			log.debug("\n[allUsrFlg]"+eventResponse.getETCData("allUsrFlg"));
			log.debug("\n[maxPropUsrId]"+eventResponse.getETCData("maxPropUsrId"));
			log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	
	 /**
		 * [CHM-201537788] S/C 다운로드 보안 강화_2차 (다운로드 버튼 접근 제한)::프린트 파일 오픈시 권한 확인
		 * S/C Download Record Inquiry 화면 데이터 조회
		 * 대상 : ESM_PRI_0028  
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchDownloadRecord(Event e) throws EventException {
			try{
				EsmPri0028Event event = (EsmPri0028Event)e;
				SCProposalMainBC command = new SCProposalMainBCImpl();
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				List<PriSpDlRecVO> list  = command.searchPriDownloadRecord(event.getPriSpDlRecVo());
				eventResponse.setRsVoList(list);
				return eventResponse;
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
		}
		
		
	    /**
	     * ESM_PRI_0081 : Search <br>
	     * S/C Special Rate의 Actual Customer List를 조회한다..<br>
	     *
	     * @param Event e
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse searchSCActualCustomerList(Event e) throws EventException {
	        //PDTO(Data Transfer Object including Parameters)       
	        
	        EsmPri0081Event event = (EsmPri0081Event) e;
	        PriSpScpRtActCustVO  paramVo  = event.getPriSpScpRtActCustVO();

	        SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
	        GeneralEventResponse eventResponse = new GeneralEventResponse();        
	        try{
	            List<RsltGriCalcRateActualCustListVO> list = command.searchGriCalcRateActualCustList(paramVo);
	            eventResponse.setRsVoList(list);
	        }catch(EventException ex){
	            throw ex;
	        }catch(Exception ex){
	            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	        }
	        return eventResponse;
	  }		
	       
        /**
         * ESM_PRI_0082 : Search <br>
         * S/C Special Rate의 Actual Customer List를 조회한다..<br>
         *
         * @param Event e
         * @return EventResponse
         * @exception EventException
         */
        private EventResponse searchSCActualCustomerInquiryList(Event e) throws EventException {
            //PDTO(Data Transfer Object including Parameters)       
            
            EsmPri0082Event event = (EsmPri0082Event) e;
            PriSpScpRtActCustVO  paramVo  = event.getPriSpScpRtActCustVO();

            SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();        
            try{
                List<RsltGriCalcRateActualCustListVO> list = command.searchGriCalcRateActualCustList(paramVo);
                eventResponse.setRsVoList(list);
            }catch(EventException ex){
                throw ex;
            }catch(Exception ex){
                throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
            }
            return eventResponse;
      }     
        
        
        
        /**
         * ESM_PRI_0066 : Copy<br>
         * GRI Calculation 데이터의 COPY 트랜잭션을 처리합니다.<br>
         *
         * @param Event e
         * @return EventResponse
         * @exception EventException
         */
        private EventResponse manageGRICopy(Event e) throws EventException {
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            EsmPri0066Event event = (EsmPri0066Event) e;
            SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();

            try {
                begin();
                command.removeGRICopy(event.getScGriCalcVO(), account);                
                command.manageGRICopy(event.getScGriCalcVO(), account);
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00110",new String[]{}).getUserMessage());

                commit();
            } catch (EventException ex) {
                rollback();
                throw ex;
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
            }
            return eventResponse;
        }  
        
        /**
         * ESM_PRI_0066 : PASTE<br>
         * GRI Calculation 데이터의 PASTE 트랜잭션을 처리합니다.<br>
         *
         * @param Event e
         * @return EventResponse
         * @exception EventException
         */
        private EventResponse manageGRIPaste(Event e) throws EventException {
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            EsmPri0066Event event = (EsmPri0066Event) e;
            SCGRICalculationProposalBC command = new SCGRICalculationProposalBCImpl();

            try {
                begin();
                 PriSpScpGriGrpVO v = event.getPriSpScpGriGrpVO();
 
                command.removeGRIAll(v, account);                
                command.manageGRIPaste(event.getPriSpScpGriGrpVO(), account);
                eventResponse.setUserMessage((String) new ErrorHandler("PRI00116",new String[]{}).getUserMessage());
                commit();
            } catch (EventException ex) {
                rollback();
                throw ex;
            } catch (Exception ex) {
                rollback();
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
            }
            return eventResponse;
        }  
        
        
        
        /**
         *  S/C 조회 내역 기록 조회
         * S/C OPEN Record Inquiry 화면 데이터 조회
         * 대상 : ESM_PRI_0034  
         * @param Event e
         * @return EventResponse
         * @exception EventException
         */
        private EventResponse searchOpenRecord(Event e) throws EventException {
            try{
                EsmPri0034Event event = (EsmPri0034Event)e;
                SCProposalMainBC command = new SCProposalMainBCImpl();
                GeneralEventResponse eventResponse = new GeneralEventResponse();
                List<PriSpInqRecListVO> list  = command.searchPriOpenRecord(event.getPriSpInqRecSearchVO()) ;
                eventResponse.setRsVoList(list);
                return eventResponse;
                
            }catch(EventException ex){
                throw ex;
            }catch(Exception ex){
                throw new EventException(ex.getMessage(), ex);
            }       
        }
        
}