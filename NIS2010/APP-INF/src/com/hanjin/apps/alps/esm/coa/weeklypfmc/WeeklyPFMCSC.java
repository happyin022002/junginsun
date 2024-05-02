/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WeeklyPFMCSC.java
 *@FileTitle : Weekly PFMC SC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-12
 *@LastModifier : Park Eun Ju
 *@LastVersion : 1.0
 * 2006-10-12 Park Eun Ju
 * 1.0 최초 생성
 *=========================================================
 * History
 * 2008.07.23 전윤주 CSR No.N200807218173 Commercial Base U/C 화면 추가 (159번 화면)
 * 2008.07.23 전성진 CSR No.N200807230006 [117] 
 *					  - SMU 단가 저장 기능 추가
 * 2008.08.29 박은주 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060, 062]
 * 2008.09.08 전윤주 115번 화면 사용하지 않는 method 삭제
 * 2009.04.01 김종열 CSR No.N200903170121 Port Tariff(PA)기능 변경
 *                                        -조회(searchPortTariffList)와 생성(createPortTariff) 분리
 * 2009.08.20 김기대 ENIS --> ALPS 변환
 * 2009.09.04 박수훈 0030(029S)화면 New FrameWork 적용
 * 2009.09.10 박수훈 0112 화면 New FrameWork 적용
 * 2009.08.26 김기대 0040 화면 New FrameWork 적용
 * 2009.08.26 김기대 0041 화면 New FrameWork 적용
 * 2009.09.06 김기대 0042 화면 New FrameWork 적용
 * 2009.09.06 김기대 0043 화면 New FrameWork 적용
 * 2009.09.16 김기대 0029 화면 New FrameWork 적용
 * 2009.09.16 김기대 0059 화면 New FrameWork 적용
 * 2009.09.26 김기대 0039 화면 New FrameWork 적용
 * 2009.09.30 김기대 0036 화면 New FrameWork 적용
 * 2009.09.30 김기대 0044 화면 New FrameWork 적용
 * 2009.09.30 김기대 0047 화면 New FrameWork 적용
 * 2009.10.06 김기대 0037 화면 New FrameWork 적용
 * 2009.10.06 김기대 0038 화면 New FrameWork 적용
 * 2009.10.13 김기대 0145 화면 New FrameWork 적용
 * 2009.10.13 김기대 0146 화면 New FrameWork 적용
 * 2009.10.13 김기대 0106 화면 New FrameWork 적용
 * 2009.10.13 김기대 0154 화면 New FrameWork 적용
 * 2009.10.13 김기대 0159 화면 New FrameWork 적용
 * 2009.09.16 박수훈 0115 화면 New FrameWork 적용
 * 2009.09.17 박수훈 0117 화면 New FrameWork 적용
 * 2009.09.30 박수훈 0118 화면 New FrameWork 적용
 * 2009.10.09 박수훈 0119 화면 New FrameWork 적용
 * 2010.01.09 김기식 0173, 0174, 0175 화면 New FrameWork 적용
 *				( Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
 * ALPS 변환 후 저장 123번 화면 저장 로직 제거 - modifyVslInfo(Event e)
 * ALPS 변환 후 저장 038번 화면 저장 로직 제거 - modifyVSLSubTrade(Event e) *
 * 2009.02.09 이행지  Ticket ID:CHM-200901816 남북항로(SNT) 운항 변/고정비 배부를 위한 T/S Logic신규 개발
 *											로 인한 TS ALLOCATION(SNT)화면(ESM_COA_176) 추가
 * 2010.02.18 박은주 Ticket ID:CHM-201002397 Vessel Pool 및 OP4 logic 보완 요청  (ESM_COA_177 추가)
 * 2010.02.18 이행지 Ticket ID:CHM-201002398 Split 01-Split 01-Vessel Pool 및 OP4 logic 보완 요청
 * 2010.06.17 이행지 Ticket ID:ITM-201001650 - EventResponse => GeneralEventResponse 변경
 * 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
 * 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
 * 2010.10.01 김기종 Ticket ID:CHM-201006017-01[COA] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
 *											-- ESM_COA_0179 TS_ALLOCATION2 추가
 * 2010.09.29 박은주 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
 *				  ESM_COA_0037
 *				  ESM_COA_0146
 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가
 * 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
 * 2011.01.25 최윤성 [CHM-201108537-01] ESM_COA_0037, ESM_COA_0146 에 CommonCode 조회 내용 추가
 * 2011.02.21 김상수 [CHM-201108827-01] * R.month/Week 및 OPR/OPR2 정보 보여주는 칼럼 추가
 *                                      * 불필요하게 사용된 VO에 관련된 소스제거
 * 2011.03.02 김상수 [CHM-201109144-01] Lane Transit time 메뉴 개선
 *                                      - Lane Transit time 화면내의 Sheet에 OPR2(Operation) 칼럼추가
 *                                      - 잘못 구현되어 있거나 불필요한 Program 로직
 *                                        (VO, HTMLAction, mapping.xml, SQL) 제거 및 수정보완
 * 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
 *                                      - ESM_COA_0029화면 페이지로딩시 S.Lane콤보값 후출하도록 변경
 * 2011.03.23 최성민 [CHM-201109616-01] * Bunker Fee (PA)화면에서 사용하는 COA_BNK_TRF 테이블에 COST_WK 컬럼이 추가
 *                                    * Load Excel, Create 기능 추가
 * 2011.05.26 최성민 [CHM-201006017-01] COA 약정율 로직 추가 - SHEET의 콤보세팅을 위한 SEARCHLIST03 추가
 * 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청 - BackEndJob으로 변환
 * 2011.06.16 최성민 [CHM-201111497-01] COA 운항일수 산정 로직 변경 - ESM_COA_0034 생성
 * 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
 * 2011.07.20 최성민 [CHM-201112295-01] [COA] 내부거래단가 조건추가 : Actual Lane 정보 - searchComBoCdList0118() 변경
 * 2011.08.16 최성민 [CHM-201112855-01] [COA]Create VSL table Operator 정보 표시
 * 2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
 * 2011.12.23 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
 * 2012.01.31 김종준 [CHM-201215754-01] SEL에서 대상항차 선택 후, VVD Send를 누르면 해당 대상항차를 FCM 시스템으로 전송 etc.
 * 2012.06.08 이석준 [CHM-201218114-01] 삭제된 데이터를 원복할 수 있도록 기능 변경
 * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
 * 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가
 * 2012.07.18 이석준 [CHM-201219046-01] [COA] Target VVD 배치 기능 추가 
 * 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
 * 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
 * 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가  
 * 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
 * 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
 * 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
 * 2013.01.29 서미진 [CHM-201322638] 한 주차만 생성 가능하던 로직을 여러 주차 생성 가능하도록 신규 배치 생성으로 변경
 * 2013.05.08 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가 
 * 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
 * 2013.06.13 박찬민 [CHM-201324895] Split 02-[COA] COA Report내 "IAS Region " / "Bound2" 추가
 * 2013.10.23 최성민 [CHM-201327081][COA] OP4 로직 변경
 * 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
* =========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.basic.CostSetUpBC;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.basic.CostSetUpBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.basic.EQHoldingBC;
import com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.basic.EQHoldingBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.basic.MASBC;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mas.basic.MASBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.basic.MTCostBC;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.basic.MTCostBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.basic.USDomesticBC;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.basic.USDomesticBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBC;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0034Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0039Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0040Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0041Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0042Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0043Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0044Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0048Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0110Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0114Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0173Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0174Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0175Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0177Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0180Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0181Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0182Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.LaneTable1CycleVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchAverageUCListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDInterPrcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDOP4ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBC;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0045Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0047Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0050Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0106Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0107Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0108Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0125Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0154Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0159Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0176Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0179Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.AllocResultCommitListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistNewListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostSntListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSCommitmentListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSUnitCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.basic.OPMasterBC;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.basic.OPMasterBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event.EsmCoa0036Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event.EsmCoa0037Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event.EsmCoa0123Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event.EsmCoa0145Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event.EsmCoa0146Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.EsmCoa0036ComboVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.basic.WeeklyCMBC;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.basic.WeeklyCMBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0029Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0030Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0112Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0115Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0117Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0118Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0119Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0120Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0121Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0142Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0221Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.CoaEMUCreditListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0222Event;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchEMUPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchOPCreditRtPortPairVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchOwnTMLPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSMUPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostPopListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVD0030ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaBnkTrfVO;
import com.hanjin.syscommon.common.table.CoaFxAmtDtrbVO;
import com.hanjin.syscommon.common.table.CoaInterPrcUtCostVO;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;

 

/**
 * ALPS-COA Business Logic ServiceCommand<br>
 * - ALPS-COA에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author Park Eun Ju
 * @see OPMasterDBDAO 참조
 * @since J2EE 1.5
 */
public class WeeklyPFMCSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * WeeklyPFMC 업무 시나리오 선행작업<br>
	 * WeeklyPFMC 업무 시나리오 호출시 관련 내부객체 생성 <br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("WeeklyPFMCSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * WeeklyPFMC 업무 시나리오 마감작업<br>
	 * WeeklyPFMC 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("WeeklyPFMCSC 종료 ...........................");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-COA 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.debug("\n[CALL] Service Command ----------------------------- "
				+ "\n EventName   : " + e.getEventName()
				+ "\n Command	 : " + e.getFormCommand().getCommand());

		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmCoa0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRgstLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiRgstLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = getEsmCoa0036Combo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0036(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchVslRgstList(e);//명칭 변경 searchVSLInfoList ---> searchVslRgstList
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiVslRgst(e); //명칭 변경 multiVSLInfo --->  multiVslRgst
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchComBoCdList0037(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchVSLSubTradeList(e);
			}
			// ALPS 변환 후 저장 038번 화면 저장로직 제거
			//else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
			//	eventResponse = modifyVSLSubTrade(e);
			//}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchIntervalTransitTimeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiIntervalTransitTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0039(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPortTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiPortTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createPortTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0040(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBunkerTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiBunkerTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBunkerTariffCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = createBunkerTariff(e);
			} else{
				eventResponse = searchComBoCdList0041(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDailyHireList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDailyHire(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createDailyHire(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0042(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOwnDailyHireList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiOwnDailyHire(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0043(e);
			} else {
				eventResponse = searchOptFixedCostList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyVVDCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Retrieve
				eventResponse = searchWeeklyTargetVVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = multiWeeklyTargetVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Creation
				eventResponse = createTargetVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Menual Batch - BackEndJob
				eventResponse = dailyBatch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // TsQty - BackEndJob
				eventResponse = createTSQty(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다.(BSA 0)
				eventResponse = batchBSAVVDZero(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { // BSA Flag 및 주차 변경
				eventResponse = multiTargetVVDBSABatch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 	// batch 모니터링
                eventResponse = monitorBatchStatus(e);
            } else {
				eventResponse = searchComBoCdList0029(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWeeklyTargetVVD0030List(e);
			} else {
				eventResponse = searchComBoCdList0030(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchHJSSalesAmountList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //생성
				eventResponse = createHJSSalesAmount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0045(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostDistList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //생성
				eventResponse = createTsAllocation1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //monitoring
				eventResponse = monitorTSAllocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0047(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostDistList0050(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //생성
				eventResponse = createTsAllocation2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //monitoring
				eventResponse = monitorTSAllocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0050(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0179Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostDistList0179(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //생성
				eventResponse = createFixCostDist0179(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0179(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostDistResultList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Apply to P/L
				eventResponse = applyToPL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0106(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResult(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostDistResultList0108(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Apply to P/L
				eventResponse = applyToPL0108(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0108(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResult(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { //조회1
				eventResponse = searchLaneTSCommitmentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // rlane 별 haul bound
				eventResponse = searchTradeDirbyLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //저장1
				eventResponse = multiLaneTSCommitment(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchComBoCdList0125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0159Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { //조회1
				eventResponse = searchLaneTSUnitCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //저장1
				eventResponse = multiLaneTSUnitCost(e);
			} else {
				eventResponse = searchComBoCdList0159(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchFixCostByVVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0044(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmCoa0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEMUPfmcList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0115 (e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSMUPfmcList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSMUPfmc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createSMUPfmc(e);
			}
			else {
				eventResponse = searchComBoCdList0117(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { //Tab1 New
				eventResponse = searchNWCreList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { //Tab1 Retrieve
				eventResponse = searchNWCreRStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { //Tab2 New
				eventResponse = searchSltChtrCreList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { //Tab2 Retrieve
				eventResponse = searchSltChtrCreRStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Tab1 Creation
				eventResponse = createNWCreForVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Tab2 Creation
				eventResponse = createSltChtrCre(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobStatusByNW(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResultByNW(e);
            } else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchComBoCdList0110(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDChkWithARList (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiVVDChkWithARList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMissingStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0114(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchVslInfoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnTMLPfmcList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOwnTMLPfmc(e);
			}
			else{
				eventResponse = searchComBoCdList0118(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUOM0119List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUOM0119(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0119(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0145Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//조회
				eventResponse = searchHistoryLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//creation
				eventResponse = multiHistoryLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0145(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0146Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchHistVSLInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiHistVSLInfo(e);

			}else {
				eventResponse = searchComBoCdList0146(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0154Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpcChtrRevMssList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0173Event")) {	//Average U/C 화면popup
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	 //2.저장
				eventResponse = createAverageMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	 //ESM_COA_0173 에서 호출
				eventResponse = createBSACommitmentMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {	 //0013, EQ Holding Cost에서 호출
				eventResponse = createEqHoldingCostMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {	 //0012, ABC/STP에서 호출
				eventResponse = createAbcStpCostMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {	 //0009 , EQ Repo Cost에서 호출
				eventResponse = createEqRepoCostMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	 //00009 , EQ Repo Cost에서 호출
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {	 //00115,EMU Cost에서 호출
				eventResponse = createEMUCostMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {	 //00115,EMU Cost에서 호출
				eventResponse = createManualCostStupCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {	 //0042,Dailyhire by Cht-VSL (PA)에서 호출
				eventResponse = createDailyHireMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) {	 //0043,AVG-hire by Own-VSL (PA)에서 호출
				eventResponse = createOwnDailyHireMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {	 //0117,SMU Cost (RA)에서 호출
				eventResponse = createSMUPfmcMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {	 //0014,Domestic Saving Credit에서 호출
				eventResponse = createDomesticMonthCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {	 //0177,Lane Table (1Cycle)
				eventResponse = createLaneTableMonthCopy(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0174Event")) {	//Average U/C 화면Main
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	 //1.조회
				eventResponse = searchAverageUCList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	 //2.STATUS 
				eventResponse = searchAverageUCStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	 //2.저장
				eventResponse = multiAverageUC(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //3.creation
//				eventResponse = createAverageUC(e);  // 팝업화면으로 대체. ESM_COA_0184
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchComBoCdList0174(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmCoa0175Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchFixCostByVVDOP4List(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){//CREATE
				eventResponse = createFixCostByVVDOP4(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0175(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0176Event")) { // TS Allocation - SNT
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //조회
				eventResponse = searchFixCostSntList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //생성
				eventResponse = createFixCostSnt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0176(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0177Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve
				eventResponse = searchLaneDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = multiLaneDetail(e);
			}else {
				eventResponse = searchComBoCdList0177(e);
			} 

		/*
		 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가  (ESM_COA_0048, ESM_COA_0180, ESM_COA_0107)
		 */
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTrunkIPCPricing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = multiTrunkIPCPricing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)||
					e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0180(e);
		  }
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0180Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchFixCostByVVDInterPrcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) ) {
				eventResponse = createFixCostByVVDInterPrc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)||
					e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
				eventResponse = searchComBoCdList0180(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	 // Retrieve
				eventResponse = searchAllocationResultInter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Create
				eventResponse = createAllocationResultInter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Apply to P/L
				eventResponse = applyToPLInter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
				eventResponse = searchComBoCdList0107(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLaneTransitTimeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiLaneTransitTime(e);
			} else {
				eventResponse = searchComBoCdList0034(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0181Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPortTariffDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiPortTariffDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0182Event")) {	//Average U/C (CM2)
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	 //1.조회
				eventResponse = searchAverageCM2List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	 //2.저장
				eventResponse = multiAverageCM2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //3.creation
				eventResponse = createAverageCM2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0182(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSeasonalSMUCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSMUPfmc(e);
			}
			else {
				eventResponse = searchComBoCdList0120(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		// Retrieve
				//eventResponse = searchSeasonalSMUCostPopList(e);
				eventResponse = searchLaneBoundSwitchList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				//eventResponse = multiLaneDetail0121(e);
				eventResponse = multiLaneBoundSwitch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchComBoCdList0121(e);
			} else {
				eventResponse = searchLaneBoundSwitchList(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEmuCreditTableList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0222Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditRtPortPairList(e);
			} 
		}
 

		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * [WeeklyCM 주간 대상항차화면에 대한 조회 이벤트 처리.<br>
	 * ESM_COA_0142 화면 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0142Event event = (EsmCoa0142Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchVVDCheckListVO> list = command.searchVVDCheckList(event.getSearchVVDCheckListVO()
																		, event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티벤트 처리<br>
	 * [WeeklyCM 주간 대상항차화면에 대한 저장 이벤트 처리 <br>
	 * ESM_COA_0142 화면 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyVVDCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0142Event event = (EsmCoa0142Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			begin();
			command.modifyVVDCheck(event.getCoaMonVvdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- WeeklyCM 주간 대상항차 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklyTargetVVDList(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			WeeklyCMBC command = new WeeklyCMBCImpl();
			List<SearchWeeklyTargetVVDListVO> list = command.searchWeeklyTargetVVDList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- WeeklyCM 주간 대상항차화면에 대한 Sheet1 의 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiWeeklyTargetVVD(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			WeeklyCMBC command = new WeeklyCMBCImpl();
			event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
			eventResponse = (GeneralEventResponse) command.multiWeeklyTargetVVD(event.getSearchConditionVO(), event.getWeeklyCMCommonVO(), event.getWeeklyCMCommonVOs(), event.getMultiCoaMonVvdVOs(), account);
			commit();
			
			/*
			log.debug("##1#####################"+1);
			//////////////////////////////////////////////
			//BSA Flag 나 Cost Week 정보가 변경됐을 경우 BSA 배치를 호출한다.
			begin();
			command.multiBsaDailyBatch(event.getMultiCoaMonVvdVOs(), account);
			commit();
			//////////////////////////////////////////////
			log.debug("##2#####################"+2);
			*/
			
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * target VVD 의 bsa flag, week 정보 변경후 bsa 배치 호출 <br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTargetVVDBSABatch(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WeeklyCMBC command = new WeeklyCMBCImpl();
		
		try {		
			//////////////////////////////////////////////
			//BSA Flag 나 Cost Week 정보가 변경됐을 경우 BSA 배치를 호출한다.
			begin();
			command.multiBsaDailyBatch(event.getMultiCoaMonVvdVOs(), account);
			commit();
			//////////////////////////////////////////////
						
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 1. 기능 : Create버튼 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- WeeklyCM 주간 대상항차화면에 대한 Sheet1 의 Create 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse createTargetVVD(Event e) throws EventException {
//		EsmCoa0029Event event = (EsmCoa0029Event)e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		WeeklyCMBC command = new WeeklyCMBCImpl();
//		try {
//			begin();
//			String cmdId = String.valueOf(event.getFormCommand().getCommand());
//			
//			event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
////			eventResponse = (GeneralEventResponse) command.createTargetVVD(event.getSearchConditionVO(), account);
//			eventResponse.setETCData("BackEndJobKey", command.createTargetVVD(event.getSearchConditionVO(), cmdId, account));
//			commit();
//			return eventResponse;
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
	private EventResponse createTargetVVD(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comcmd = new CommonBCImpl();
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {	
			String strStatus = "";
			//1. 배치가 돌고 있는지 Check 한다
			event.getSearchConditionVO().setFUcCd("TVVD");
			
			List<CoaUtCostCreStsVO> list = comcmd.searchBatchStatus(event.getSearchConditionVO());

			if(list.size() > 0) {
				strStatus = list.get(0).getCostCreStsCd();
			}
			
			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}

			// 3. batch status를 생성한다.
			begin();
			comcmd.addBatchStatus(event.getSearchConditionVO(), account);		
			commit();
			// 4. batch를 실행한다.
						
			strStatus = command.createTargetVVD(event.getSearchConditionVO(),account);						
			eventResponse.setETCData("BatchStatus", strStatus);
			
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * [ESM_COA_0072] : PNL Creation <br>
	 * Batch status monitoring
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorBatchStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();		
		SearchConditionVO searchVO = new SearchConditionVO();
		String strStatus = "C";
		try{
			if (e.getEventName().equalsIgnoreCase("EsmCoa0029Event")) {
				searchVO.setFUcCd("TVVD");
			}
			
			//1. 배치가 돌고 있는지 Check 한다
			List<CoaUtCostCreStsVO> list = command.searchBatchStatus(searchVO);
			
			if(list.size() > 0) {
				strStatus = "P";
			}
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	
    /* ************************************************
       BACK END JOB 관련 - Start
       ************************************************/

	/**
	 * ESM_COA_0029 : Create T/S Q'ty<br>
	 * T/S Q'ty 배치를 실행한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTSQty(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WeeklyCMBC command = new WeeklyCMBCImpl();
		
		try {
			begin();
			String cmdId = String.valueOf(event.getFormCommand().getCommand());
			eventResponse.setETCData("BackEndJobKey", command.createTSQty(event.getSearchConditionVO(), cmdId, account));
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_029 : BSA & VVD Creation<br>
	 * BSA & VVD 배치를 실행한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse dailyBatch(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WeeklyCMBC command = new WeeklyCMBCImpl();
		
		try {
			begin();
			String cmdId = String.valueOf(event.getFormCommand().getCommand());
			eventResponse.setETCData("BackEndJobKey", command.dailyBatch(event.getSearchConditionVO(), cmdId, account));			
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

    /**
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobStatus(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        WeeklyCMBC command = new WeeklyCMBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
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
    private EventResponse searchBackEndJobResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	WeeklyCMCommonVO vo= (WeeklyCMCommonVO)BackEndJobResult.loadFromFile(key);    
        	eventResponse.setETCData("err_cd", vo.getErrorCode());
            eventResponse.setETCData("err_msg", vo.getErrorMsg());
            eventResponse.setETCData("vsl_cd",vo.getReturnVslCd());
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /* ************************************************
       BACK END JOB 관련 - End
       ************************************************/

	/**
	 * ESM_COA_029 : UI BSA 배치 이벤트 처리<br>
	 * BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse batchBSAVVDZero(Event e) throws EventException {
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			WeeklyCMBC command = new WeeklyCMBCImpl();
			event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
			eventResponse = (GeneralEventResponse) command.batchBSAVVDZero(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_029 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0029(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0029Event event = (EsmCoa0029Event)e;
		CommonBC commonBC = new CommonBCImpl();
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){

				String array[][] = { {"rLane", event.getSearchConditionVO().getFSeltrade(), "All"} };
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				String array[][] = {
						 {"subTrade", event.getSearchConditionVO().getFSeltrade(), ""},
						 {"sLane2", event.getSearchConditionVO().getFSeltrade(), ""},
						 {"rLane2", event.getSearchConditionVO().getFSeltrade(), ""}
						};

				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}else{
				/*-------------------------------------------------------*/
				String fYear = commonBC.searchPrevYearPrd();
				String prevWeek = commonBC.searchPrevWkPrd();
				String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("period", period);
				eventResponse.setETCData("fYear", fYear);

				String array[][] = { {"trade", "", ""},
									 {"rLane", "", ""},
									 {"sLane", "", ""},
									 {"CD00593", "", ""},
									 {"CD00206", "", ""},
									 {"trade", "", ""},
									 {"subTrade", "AES", ""},
									 {"sLane2", "AES", ""},
									 {"rLane2", "AES", ""},
									 {"CD00793", "", ""},
									 {"CD00593", "", ""},
									 {"CD00206", "", ""},
									 {"CD03217","","All"}
									};

				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0030 : [이벤트]<br>
	 * 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 처리개요 : WeeklyCM 주간 대상항차 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklyTargetVVD0030List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0030Event event = (EsmCoa0030Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchWeeklyTargetVVD0030ListVO> list = command.searchWeeklyTargetVVD0030List(event.getSearchWeeklyTargetVVD0030ListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 항로관리에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.12<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRgstLaneList(Event e) throws EventException {
		EsmCoa0036Event event = (EsmCoa0036Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			List<SearchRgstLaneListVO> list = command.searchRgstLaneList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 항로관리에 대한 Sheet1 의 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.12<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRgstLane(Event e) throws EventException {
		EsmCoa0036Event event = (EsmCoa0036Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			OPMasterBC command = new OPMasterBCImpl();
			command.multiRgstLane(event.getSearchConditionVO(), event.getCoaLaneRgstVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyPFMCSC의 event에 콤보조회 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getEsmCoa0036Combo(Event e) throws EventException {
		EsmCoa0036Event event = (EsmCoa0036Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmCoa0036ComboVO vo = event.getComboVO();
			EsmCoa0036ComboVO tempVo = event.getComboVO();

			List<EsmCoa0036ComboVO> list = new ArrayList<EsmCoa0036ComboVO>();
			list.add(tempVo);
			vo.setListSet(list);

			eventResponse.setRsVoList(vo.getListSet());
			return eventResponse;
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 선박관리에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.18<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslRgstList(Event e) throws EventException {
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			event.getCommonCoaRsVO().setEventName("EsmCoa0037Event");			
			event.getSearchConditionVO().setFOfcCd(account.getOfc_cd());	//set ofc_cd 
			
			CommonCoaRsVO rtnVo = command.searchVslRgstList(event.getSearchConditionVO());
			eventResponse.setRsVo(rtnVo.getDbRowset());
			eventResponse.setETCData("header", rtnVo.getHeader());
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 선박관리에 대한 Sheet1 의 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.18<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	//명칭 변경 multiVSLInfo --->  multiVslRgst
	private EventResponse multiVslRgst(Event e) throws EventException {
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			OPMasterBC command = new OPMasterBCImpl();
			command.multiVslRgst(event.getSearchConditionVO(), event.getCommonCoaRsVO(), event.getCoaVslRgstVOs(), event.getCoaVslSubTrdCapaVOs(), account);
			commit();
			return eventResponse;
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 선박관리에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.18<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVSLSubTradeList(Event e) throws EventException {
//		EsmCoa0038Event event = (EsmCoa0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			CommonCoaRsVO rtnVo = command.searchVSLSubTradeList();
			eventResponse.setRsVo(rtnVo.getDbRowset());

			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 구간별 운항일수 및 비율 생성화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.14<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIntervalTransitTimeList(Event e) throws EventException {
		EsmCoa0039Event event = (EsmCoa0039Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchIntervalTransitTimeListVO> list = command.searchIntervalTransitTimeList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 구간별 운항일수 및 비율 생성화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.14<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiIntervalTransitTime(Event e) throws EventException {
		EsmCoa0039Event event = (EsmCoa0039Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiIntervalTransitTime(event.getCoaMonVvdPortOpDysVOs(), account);
			commit();

			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port Class별 Tariff 조회/변경 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTariffList(Event e) throws EventException {
		EsmCoa0040Event event = (EsmCoa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchPortTariffListVO> list = command.searchPortTariffList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port Terminal별 Tariff 조회/변경 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 :이석준/2011.07.06<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTariffDetailList(Event e) throws EventException {
		EsmCoa0181Event event = (EsmCoa0181Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchPortTariffDetailListVO> list = command.searchPortTariffDetailList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);

			if (list.size() > 0){
				eventResponse.setETCData("pso_cre_dt",list.get(0).getCreDt());
			}
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * 1. 기능 : Retrieve 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- VVD List로 만들어서 PSO Batch 호출<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPortTariff(Event e) throws EventException {
		EsmCoa0040Event event = (EsmCoa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			SearchPortTariffListVO[] searchPortTariffListVOs = event.getSearchPortTariffListVOs();
						
			NetworkCostBC ncCommand = new NetworkCostBCImpl();
			//배치 및 관련 프로세스가 진행상태인지 체크한다.
			
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			String strStatus = "";
//			strStatus = command.searchVvdExpenseSimulationStatus(searchPortTariffListVOs);

			
			// 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("6".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}

			
			begin();
			// 기존 항차별 데이터를 삭제한다.
			ncCommand.deletePortTariff(searchPortTariffListVOs);

			log.debug("log 4: "+ searchPortTariffListVOs[0].getVslCd());
			// 대상 항차를 등록한다.
//			command.manageVvdExpenseSimulationSetup(searchPortTariffListVOs, "I", account);
			commit();

			log.debug("log 5: "+ searchPortTariffListVOs[0].getVslCd());
			// Tariff Simulation 을 실행한다.
			strStatus = command.manageVvdExpenseSimulation(account);
			eventResponse.setETCData("BatchStatus", strStatus);

			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}
	}
	
//	/**
//	 * VVD 단위 Tariff Simulation을 실행한다.
//	 * 
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @throws EventException
//	 */
//	private String manageVvdExpenseSimulation(SignOnUserAccount account){
//		String strStatus = "";
//		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
//		try {
//			strStatus = command.manageVvdExpenseSimulation(account);
//		} catch (EventException e) {
//			rollback();
//			log.error("err " + e.toString(), e);
//		}
//		return strStatus;
//	}

	/**
	 * 1. 기능 : Retrieve 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port Class별 Tariff 조회/변경 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p> Kim Ki Dae / 2009.08.27
	 * - 수정사유/내역 :<p> ALPS 변환
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPortTariff(Event e) throws EventException {

		EsmCoa0040Event event = (EsmCoa0040Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiPortTariff(event.getSearchConditionVO(), event.getSearchPortTariffListVOs(), userId);
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 1. 기능 : save 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port  Tariff 조회/변경 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : SUK JOON LEE/2011.07.07<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPortTariffDetail(Event e) throws EventException {

		EsmCoa0181Event event = (EsmCoa0181Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiPortTariffDetail(event.getSearchConditionVO(), event.getSearchPortTariffDetailListVOs(), userId);
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 연료비 조회/변경 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.22<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerTariffList(Event e) throws EventException {
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchBunkerTariffListVO> list = command.searchBunkerTariffList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_COA_0041 : [LOAD EXCEL]<br>
	 * Load Excel 시 Count 가 1보다 작으면 Error <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerTariffCount(Event e) throws EventException {
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//String key = "";
			StringBuffer sb = new StringBuffer();
			
			NetworkCostBC command = new NetworkCostBCImpl();
			List<CoaBnkTrfVO> list = command.searchBunkerTariffCount(event.getCoaBnkTrfVOs(), event.getSearchConditionVO());
				
			if(list.size() > 0) {
				for(int i=0; i<list.size(); i++) {
					//cost_yrmon 은 row index 를 대신함
					//key = key + list.get(i).getCostYrmon() + "|";
					sb.append(list.get(i).getCostYrmon());
					sb.append("|");
				}
				//key = key.substring(0, key.length()-1);

			}
			eventResponse.setETCData("key", sb.substring(0, sb.length()-1));
			
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_COA_0041 : [CREATE]<br>
	 * Bunker Tariff 정보를 생성한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBunkerTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			command.createBunkerTariff(event.getSearchConditionVO(), account);
			
            eventResponse.setUserMessage((String) new ErrorHandler("COA10018",new String[]{"Creation"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}

	/**
	 * 1. 기능 : save 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 연료비 조회/변경 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.22<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiBunkerTariff(Event e) throws EventException {
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0041Event");
			command.multiBunkerTariff(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getCoaBnkTrfVOs(), userId);
			commit();
			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	private EventResponse searchDailyHireList(Event e) throws EventException {
		EsmCoa0042Event event = (EsmCoa0042Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchDailyHireListVO> list = command.searchDailyHireList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	private EventResponse multiDailyHire(Event e) throws EventException {

		EsmCoa0042Event event = (EsmCoa0042Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0042Event");
			command.multiDailyHire(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getNetworkCostCommonVOs(), userId);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_COA_0042 : [CREATE]<br>
	 * DailyHire를 FMS로부터 I/F하여 생성한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDailyHire(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0042Event event = (EsmCoa0042Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			String cre_sts = command.createDailyHire(event.getSearchConditionVO(), account);
			
			if ("X".equals(cre_sts)){// Exchange Rate가 없는것임.
				eventResponse.setETCData("XrateCnt",cre_sts);
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("COA10018",new String[]{"Creation"}).getUserMessage());
			}
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}	
	

	/**
	 * 1. 기능 : 동적해더 목록을 조회한다.<p>
	 * 2. 처리개요 :  <p>
	 *	<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2007.01.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptFixedCostList(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<NetworkCostCommonVO> list = command.searchOptFixedCostList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			NetworkCostCommonVO vo = (NetworkCostCommonVO)list.get(0);
			eventResponse.setCustomData("headerCD", vo.getHeaderCD());
			eventResponse.setCustomData("headerNM", vo.getHeaderNM());
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 사선 일당 고정비 관리 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnDailyHireList(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			NetworkCostCommonVO rtnVo = command.searchOwnDailyHireList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			list.add(rtnVo);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : save 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- 사선 일당 고정비 관리 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.11.24<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOwnDailyHire(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiOwnDailyHire(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getCoaOwnVslDlyHirVOs(), userId);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0045
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHJSSalesAmountList(Event e) throws EventException {
		EsmCoa0045Event event = (EsmCoa0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<SearchHJSSalesAmountListVO> list = command.searchHJSSalesAmountList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0045
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createHJSSalesAmount(Event e) throws EventException {
		EsmCoa0045Event event = (EsmCoa0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0045Event");
			eventResponse = (GeneralEventResponse) command.createHJSSalesAmount(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0047
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostDistList(Event e) throws EventException {
		EsmCoa0047Event event = (EsmCoa0047Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkTsAllocationCreateBatchStatus();		
			//2. 만약 진행중인 상태거나 Error 이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			event.getSearchConditionVO().setFInout("ESM_COA_0047");
			List<SearchFixCostDistListVO> list = command.searchFixCostDistList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0050
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostDistList0050(Event e) throws EventException {
		EsmCoa0050Event event = (EsmCoa0050Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkTsAllocationCreateBatchStatus();		
			//2. 만약 진행중인 상태거나 Error 이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			event.getSearchConditionVO().setFInout("ESM_COA_0050");
			List<SearchFixCostDistNewListVO> list = command.searchFixCostDistNewList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0179
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostDistList0179(Event e) throws EventException {
		EsmCoa0179Event event = (EsmCoa0179Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getSearchConditionVO().setFInout("ESM_COA_0179");
			List<SearchFixCostDistListVO> list = command.searchFixCostDistList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0179
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createFixCostDist0179(Event e) throws EventException {
		EsmCoa0179Event event = (EsmCoa0179Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0179Event");
			event.getSearchConditionVO().setFInout("ESM_COA_0179");
			eventResponse = (GeneralEventResponse) command.createFixCostDist(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0106
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostDistResultList(Event e) throws EventException {
		EsmCoa0106Event event = (EsmCoa0106Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getSearchConditionVO().setFInout("ESM_COA_0106");
			List<SearchFixCostDistResultListVO> list = command.searchFixCostDistResultList(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_COA_106: APPLY 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 APPLY 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyToPL(Event e) throws EventException {
		EsmCoa0106Event event = (EsmCoa0106Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0106Event");
			event.getSearchConditionVO().setFInout("ESM_COA_0106");
			//eventResponse = (GeneralEventResponse) command.applyToPL(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setETCData("BackEndJobKey", command.applyToPL(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account));
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0108
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostDistResultList0108(Event e) throws EventException {
		EsmCoa0108Event event = (EsmCoa0108Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			//event.getSearchConditionVO().setFInout("ESM_COA_0108");
			List<AllocResultCommitListVO> list = command.searchAllocResultCommitList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_COA_0108: APPLY 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 APPLY 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyToPL0108(Event e) throws EventException {
		EsmCoa0108Event event = (EsmCoa0108Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0108Event");
			event.getSearchConditionVO().setFInout("ESM_COA_0108");
			//eventResponse = (GeneralEventResponse) command.applyToPL(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setETCData("BackEndJobKey", command.applyToPL(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account));
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0125
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneTSCommitmentList(Event e) throws EventException {
		EsmCoa0125Event event = (EsmCoa0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<SearchLaneTSCommitmentListVO> list = command.searchLaneTSCommitmentList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0125
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTradeDirbyLaneList(Event e) throws EventException {
		EsmCoa0125Event event = (EsmCoa0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<CoaLaneRgstVO> list = command.searchTradeDirbyLaneList(event.getSearchConditionVO());
			
			if(list != null) {
				for(CoaLaneRgstVO vo : list) {
					eventResponse.setETCData(vo.getDirCd(), vo.getHulBndCd());
				}
			}
			
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0125
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiLaneTSCommitment(Event e) throws EventException {
		EsmCoa0125Event event = (EsmCoa0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			command.multiLaneTSCommitment(event.getCoaLaneTsBsaCmmtVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0159
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneTSUnitCostList(Event e) throws EventException {
		EsmCoa0159Event event = (EsmCoa0159Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<SearchLaneTSUnitCostListVO> list = command.searchLaneTSUnitCostList(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0159
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiLaneTSUnitCost(Event e) throws EventException {
		EsmCoa0159Event event = (EsmCoa0159Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0159Event");
			command.multiLaneTSUnitCost(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), event.getCoaLaneTsUtCostVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0044
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostByVVDList(Event e) throws EventException {
		EsmCoa0044Event event = (EsmCoa0044Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NetworkCostBC command = new NetworkCostBCImpl();
		try {
			List<SearchFixCostByVVDListVO> list = command.searchFixCostByVVDList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_COA_0115 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0115(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String array[][] = { {"costTableTpsz", "", ""},
								 {"LOC2ECC", "", ""},
								 {"PODECC", "", ""},
								 {"LOC2ECC", "", ""}
								};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
   }

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0115 조회 <br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEMUPfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0115Event event = (EsmCoa0115Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchEMUPfmcListVO> list = command.searchEMUPfmcList(event.getSearchEMUPfmcListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0117 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0117(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0117Event event = (EsmCoa0117Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
				String array[][] = { {"SMUSubTrade", event.getSearchConditionVO().getFTrdCd(), "All"},
									};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd() + ":"+event.getSearchConditionVO().getFSubTrdCd(), ""}
						};
				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else{
				/*-------------------------------------------------------*/
				String array[][] = { {"trade", "", ""},
									 {"SMUSubTrade", "", ""},
									 {"rLane", "", ""},
									 {"CD00593", "", ""},
									};

				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex){
				log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0117 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSMUPfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0117Event event = (EsmCoa0117Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchSMUPfmcListVO> list = command.searchSMUPfmcList(event.getSearchSMUPfmcListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * SUM 단가 화면의 멀티  이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0117 멀티
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSMUPfmc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0117Event event = (EsmCoa0117Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			begin();
			command.multiSMUPfmc(event.getCoaSltMgmtUtVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0117 : [CREATE]<br>
	 * SMU 단가를 SAQ로부터 I/F 하여 생성한다.. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createSMUPfmc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0117Event event = (EsmCoa0117Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try{
			begin();
			command.createSMUPfmc(event.getSearchConditionVO(), account);
			
			eventResponse.setUserMessage((String) new ErrorHandler("COA10018",new String[]{"Creation"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}	
	

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0118 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnTMLPfmcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0118Event event = (EsmCoa0118Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchOwnTMLPfmcListVO> list = command.searchOwnTMLPfmcList(event.getSearchOwnTMLPfmcListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WeeklyCM의 멀티  이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0118 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOwnTMLPfmc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0118Event event = (EsmCoa0118Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			begin();
			command.multiOwnTMLPfmc(event.getCoaInterOwnTmlCostVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0119 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUOM0119List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0119Event event = (EsmCoa0119Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchUOM0119ListVO> list = command.searchUOM0119List(event.getSearchUOM0119ListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WeeklyCM의 멀티  이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0119 수정, 추가
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUOM0119(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0119Event event = (EsmCoa0119Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			begin();
			command.multiUOM0119(event.getCoaTmlTrfGrpVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNWCreList(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			List<SearchNWCreListVO> list = command.searchNWCreList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNWCreRStatusList(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			List<SearchNWCreRStatusListVO> list = command.searchNWCreRStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createNWCreForVVD(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			eventResponse.setETCData("BackEndJobKey", command.createNWCreForVVD(event.getSearchConditionVO(), event.getCoaNtwkCostCreVOs(), account));
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSltChtrCreList(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			List<SearchSltChtrCreListVO> list = command.searchSltChtrCreList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSltChtrCreRStatusList(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			List<SearchSltChtrCreRStatusListVO> list = command.searchSltChtrCreRStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0110
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @throws DAOException
	 */
	private EventResponse createSltChtrCre(Event e) throws EventException {
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
			eventResponse = command.createSltChtrCre(event.getSearchConditionVO(), event.getCoaSltChtrInfoVOs(), account);
//			if (eventResponse != null ){
//				String err_cd = eventResponse.getETCData().get("err_cd");
//				String err_msg = eventResponse.getETCData().get("err_msg");
//				String[] errMessage = {err_cd, err_msg};
//
//				if(!err_cd.trim().equals("")){
//					if(!err_cd.equals("00000")){
//						throw new EventException(new ErrorHandler("COA00025", errMessage).getMessage());
//					}
//				}
//			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VVD Check With AR 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0112 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDChkWithARList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0112Event event = (EsmCoa0112Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			List<SearchVVDChkWithARListVO> list = command.searchVVDChkWithARList (event.getSearchVVDChkWithARListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VVD Check With AR 리스트 Modify 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0112 멀티
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiVVDChkWithARList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0112Event event = (EsmCoa0112Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			begin();
			command.multiVVDChkWithARList(event.getCoaMonVvdVOS()
										, event.getSearchConditionVO()
										, event.getSearchVVDChkWithARListVOS()
										, account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0114
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMissingStatusList(Event e) throws EventException {
		EsmCoa0114Event event = (EsmCoa0114Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0114Event");
			List<SearchMissingStatusListVO> list = command.searchMissingStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OPMaster의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslInfoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsmCoa0123Event event = (EsmCoa0123Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			List<SearchVslInfoListVO> list =  command.searchVslInfoList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Lane의 History 정보를 조회한다(ESM_COA_036화면에서 띄우는 Popup 화면)
	 * 사용 프로그램 : ESM_COA_0145
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHistoryLaneList(Event e) throws EventException {
		EsmCoa0145Event event = (EsmCoa0145Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			List<SearchHistoryLaneListVO> list = command.searchHistoryLaneList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * Lane의 History 정보를 입력/수정/삭제 한다(ESM_COA_036화면에서 띄우는 Popup 화면)
	 * 사용 프로그램 : ESM_COA_0145
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiHistoryLane(Event e) throws EventException {
		EsmCoa0145Event event = (EsmCoa0145Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			OPMasterBC command = new OPMasterBCImpl();
			command.multiHistoryLane(event.getSearchConditionVO(), event.getCoaLaneTpHisVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster BSA용 선박관리에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : LeeHoIk/2007.07.25<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHistVSLInfoList(Event e) throws EventException {
		EsmCoa0146Event event = (EsmCoa0146Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			event.getCommonCoaRsVO().setEventName("EsmCoa0146Event");
			CommonCoaRsVO rtnVo = command.searchHistVslInfoList(event.getSearchConditionVO());
			eventResponse.setETCData("header", rtnVo.getHeader());
			eventResponse.setRsVo(rtnVo.getDbRowset());

			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster BSA용 선박관리에 대한 Sheet1 의 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : LeeHoIk/2007.07.25<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiHistVSLInfo(Event e) throws EventException {
		EsmCoa0146Event event = (EsmCoa0146Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			OPMasterBC command = new OPMasterBCImpl();
			event.getCommonCoaRsVO().setEventName("EsmCoa0146Event");
			command.multiHistVSLInfo(event.getSearchConditionVO(), event.getCommonCoaRsVO(), event.getCoaVslRgstVOs(), event.getCoaVslSubTrdCapaVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Allocation Result 화면에서 PL Apply 시 Space Charter Revenue Missing 를 보여주는 화면
	 * 사용 프로그램 : ESM_COA_0154
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcChtrRevMssList(Event e) throws EventException {
		EsmCoa0154Event event = (EsmCoa0154Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			return this.searchSpcChtrRevMssListInner(event, eventResponse);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	

	/**
	 * ESM_COA_0182 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0182(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0182Event event = (EsmCoa0182Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					//{"trade", "", ""}, //IAS|IMS|IES 만 사용하기 때문에 하드코딩으로 대체
					//{"rLane", "", ""},
					{"rLane3", "", ""}
				};

				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				if (!"".equals(event.getSearchConditionVO().getFTrdCd())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd(), ""}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0174 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0174(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0174Event event = (EsmCoa0174Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", ""},
					{"rLane2", "", ""},
					{"Dir", "", ""}
				};

				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				if (!"".equals(event.getAverageUCVO().getFTrdCd())) {
					String array[][] = {
						{"rLane", event.getAverageUCVO().getFTrdCd(), ""}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Average U/C(OP fixed/variable cost, SPC CHT Rev/Chraterage)를 조회하는 화면
	 * 사용 프로그램 : ESM_COA_0174
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAverageUCList(Event e) throws EventException {
		EsmCoa0174Event event = (EsmCoa0174Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<AverageUCVO> list = command.searchAverageUCList(event.getAverageUCVO());
			List<AverageUCVO> rawList = command.searchAverageUCRawList(event.getAverageUCVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(rawList);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/*
	 * 1. 기능 : Average U/C화면에서 Create 클릭시 저장 이벤트 처리(ESM_COA_174)<p>
	 * 2. 처리개요 :  <p>
	 *	-  Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Choi In Kyung/2009.09.14<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_174EventResponse
	 * @exception EventException
	 */
//	private EventResponse createAverageUC(Event e) throws EventException {
//		EsmCoa0174Event event = (EsmCoa0174Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try {
//			begin();
//			NetworkCostBC command = new NetworkCostBCImpl();
//			SearchConditionVO vo = new SearchConditionVO();
//			vo.setFCostYrmon(event.getAverageUCVO().getFCostYrmon());
//			command.createAverageUC(event.getAverageUCVO(), account);	
//			
//			commit();
//		} catch (EventException ex){
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} catch (Exception ex){
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * 1. 기능 : Retrieve 클릭시 저장 이벤트 처리(ESM_COA_174)<p>
	 * 2. 처리개요 :  <p>
	 *	- 조회/변경 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Choi in kyung/2009.09.15<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_174EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAverageUC(Event e) throws EventException {
		EsmCoa0174Event event = (EsmCoa0174Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiAverageUC(event.getAverageUCVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 1. 기능 : Average U/C Copy화면에서 저장클릭시 저장 이벤트 처리(ESM_COA_173)<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Choi In Kyung/2009.09.16<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.createAverageMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_173 : [Save]<br>
	 * Month Copy 화면에서 저장클릭시 저장 이벤트 처리(ESM_COA_173)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBSACommitmentMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.createBSACommitmentMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0175 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0175(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0175Event event = (EsmCoa0175Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", ""},
					{"rLane", "", ""},
					{"SMUSubTrade", "", ""}
				};
				String prevWeek = commonBC.searchPrevWkPrd();
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				eventResponse.setETCData("prevWeek", prevWeek);
				
				String fYear = commonBC.searchPrevYearPrd();
				eventResponse.setETCData("fYear", fYear);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				if (!"".equals(event.getSearchConditionVO().getFTrdCd())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd(), ""}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_175
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostByVVDOP4List(Event e) throws EventException {
		EsmCoa0175Event event = (EsmCoa0175Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchFixCostByVVDOP4ListVO> list = command.searchFixCostByVVDOP4List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rowCount", String.valueOf(list.size()));
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_175
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createFixCostByVVDOP4(Event e) throws EventException {
		EsmCoa0175Event event = (EsmCoa0175Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();;
		String userId = event.getSignOnUserAccount().getUsr_id();
		try {
			WeeklyCMBC command = new WeeklyCMBCImpl();
			begin();
			eventResponse = (GeneralEventResponse) command.createFixCostByVVDOP4(event.getSearchConditionVO(), userId);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * ESM_COA_0176 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0176(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0176Event event = (EsmCoa0176Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", ""},
					{"rLane", "", ""},
					{"CD00206", "000020: :All", ""},
					{"StndCost", "", ""}

				};
				String prevWeek = commonBC.searchPrevWkPrd();
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				eventResponse.setETCData("prevWeek", prevWeek);
				
				String fYear = commonBC.searchPrevYearPrd();
				eventResponse.setETCData("fYear", fYear);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), ""}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0176
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostSntList(Event e) throws EventException {
		EsmCoa0176Event event = (EsmCoa0176Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<SearchFixCostSntListVO> list = command.searchFixCostSntList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0176
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createFixCostSnt(Event e) throws EventException {
		EsmCoa0176Event event = (EsmCoa0176Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			event.getNetworkDistributionCommonVO().setEventName("EsmCoa0176Event");
			eventResponse = (GeneralEventResponse) command.createFixCostSnt(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_0177 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0177(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0177Event event = (EsmCoa0177Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", ""},
					{"rLane2", "", ""},
					{"subTrade", "", ""}
				};

				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				if (!"".equals(event.getLaneTable1CycleVO().getTrdCd())) {
					String array[][] = {
						{"rLane2", event.getLaneTable1CycleVO().getTrdCd(), ""}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				String array[][] = {
						 {"subTrade", event.getLaneTable1CycleVO().getTrdCd(), ""},
						 {"rLane2", event.getLaneTable1CycleVO().getTrdCd(), ""}
						};

				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0177
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneDetailList(Event e) throws EventException {
		EsmCoa0177Event event = (EsmCoa0177Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<LaneTable1CycleVO> list = command.searchLaneDetailList(event.getLaneTable1CycleVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0177
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiLaneDetail(Event e) throws EventException {
		EsmCoa0177Event event = (EsmCoa0177Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiLaneDetail(event.getLaneTable1CycleVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_COA_0030 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0030(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0030Event event = (EsmCoa0030Event)e;
		CommonBC commonBC = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
				String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd(), "All"},
						{"sLane3", event.getSearchConditionVO().getFTrdCd(), "All"}
					};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else {
				String fYear = commonBC.searchPrevYearPrd();
				String prevWeek = commonBC.searchPrevWkPrd();
				String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("period", period);
				eventResponse.setETCData("fYear", fYear);

				String array[][] = { {"trade", "", ""},
								 {"rLane", "", ""},
								 {"sLane3", "", ""},
								 {"CD00593", "", ""},
								 {"CD00206", "", ""}
								};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0036 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0036(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0036Event event = (EsmCoa0036Event)e;
		try {
		String f_strlane = event.getSearchConditionVO().getFStrlane();
		
			if ("N".equals(f_strlane)){
			String array[][] = {
				{"trade", "", "All"},
				{"sLane", "", "All"},
				{"trade", "", ""},
				{"subTrade", "AES", ""},
				{"laneTP", "", ""},
				{"CD00593", "000020: : ", ""},
				{"CD00206", "000020: : ", ""},
				{"SMUSubTrade", "", ""},
				{"CD03217", "000020: : ", ""},
				{"CD03218", "000020: : ", ""}								
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else {
				String array[][] = {
						{"sLane", "", "All"}			
						
					};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0037 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0037(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"vslSubTrade", "", ""},
					{"CD00231", "000001: : ", ""}
					// 2011.01.25 동적메소드로 변경하여 세팅 불필요
					//, {"CD00230", "000001: : ", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//				String array[][] = {
//					{"CD00230", "000001: : ", ""},
//					{"CD00231", "000001: : ", ""}
//				};
//				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				String array[][] = {
						{"VslOwner", event.getSearchConditionVO().getFVopCd(), ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0039 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0039(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0039Event event = (EsmCoa0039Event)e;
		CommonBC commonBC = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000020: :All", "All"},
					{"CD00206", "000020: :All", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0034 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0034(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0034Event event = (EsmCoa0034Event)e;
		CommonBC commonBC = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			} else { //화면 로딩시 호출
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000020: :All", "All"},
					{"CD00206", "000020: :All", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0040 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0040(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBc.searchPrevWkPrd();
				String fYear = commonBc.searchPrevYearPrd();
				String array[][] = {
					{"sLane",     "", "All"},
					{"rLane3", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0041 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0041(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo  = event.getSearchConditionVO();
		try {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				boolean  rtnValue = commonBC.checkSLaneCode(vo.getFSlanCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				boolean  rtnValue = commonBC.checkRevLaneCode(vo.getFRlaneCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
			} else {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"sLane", "", "All"},
					{"rLane3", "", "All"},
					{"vslCapa", "", "All"},
					{"CD00593", "000020: : ", ""},
					{"vslCapa", "", ""}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0042 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0042(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		try {
			String prevWeek = commonBC.searchPrevWkPrd();
			String fYear = commonBC.searchPrevYearPrd();
			String array[][] = {
				{"chtVessel", "", "All"}
			};
			eventResponse.setETCData("prevWeek", prevWeek);
			eventResponse.setETCData("fYear", fYear);
			eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0043 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0043(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = null;
		EsmCoa0043Event event = null;
		NetworkCostBC command = null;
		List<NetworkCostCommonVO> list = null;
		NetworkCostCommonVO vo = null;
		try {
			commonBC = new CommonBCImpl();
			event = (EsmCoa0043Event)e;
			command = new NetworkCostBCImpl();
			list = command.searchOptFixedCostList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			if (null!=list && 0<list.size()) {
				vo = (NetworkCostCommonVO)list.get(0);
				eventResponse.setETCData("headerCD", vo.getHeaderCD());
				eventResponse.setETCData("headerNM", vo.getHeaderNM());
			}
			String prevWeek = commonBC.searchPrevWkPrd();
			String fYear = commonBC.searchPrevYearPrd();
			String array[][] = {
				{"ownVessel", "", "All"}
			};
			eventResponse.setETCData("prevWeek", prevWeek);
			eventResponse.setETCData("fYear", fYear);
			eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0044 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0044(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0044Event event = (EsmCoa0044Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0045 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0045(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0045Event event = (EsmCoa0045Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0047 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0047(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0047Event event = (EsmCoa0047Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0179 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0179(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0179Event event = (EsmCoa0179Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0106 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0106(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0106Event event = (EsmCoa0106Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchSpcChtrRevMssList, searchComBoCdList0106 내부호출
	 *
	 * @param EsmCoa0154Event event
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSpcChtrRevMssListInner(EsmCoa0154Event event, GeneralEventResponse eventResponse) throws EventException {
		NetworkDistributionBC command = null;
		List<SearchSpcChtrRevMssListVO> list = null;
		try {
			command = new NetworkDistributionBCImpl();
			list = command.searchSpcChtrRevMssList(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rowCount", String.valueOf(list.size()));
			eventResponse.setETCData("rowCount", String.valueOf(list.size()));
		} catch (Exception e) {
			throw new EventException(e.getMessage(), e);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0110 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0110(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000001: :All", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear); 
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				if (!"".equals(event.getSearchConditionVO().getFCobtrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFCobtrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0114 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0114(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String array[][] = {
				{"StndCost", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0118 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0118(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0118Event event = (EsmCoa0118Event)e;
		String code = null;
		try {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				
				code = event.getSearchOwnTMLPfmcListVO().getTmlCd() + "," 
					+ event.getSearchOwnTMLPfmcListVO().getCoaCostSrcCd();
				String array[][] = { {"costSrcAcctItmCd",code,""}};			
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				code = event.getSearchOwnTMLPfmcListVO().getTmlCd() + "," 
					+ event.getSearchOwnTMLPfmcListVO().getCoaCostSrcCd() + "," 
					+ event.getSearchOwnTMLPfmcListVO().getTmlTrfItmCd();
				
				String array[][] = { {"costSrcAcctDtlCd",code,""}};			
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);				
			} else {
				String strTeam_cd = JSPUtil.getNull(commonBC.searchTeamCode(account.getOfc_cd()));
				eventResponse.setETCData("strTeam_cd", strTeam_cd);
				
				String array[][] = {{"OwnTML","",""},
									{"CD01940","",""}, 
									{"costSrcAcctGrpCd","CVIP",""},
									{"currency","",""},
									{"costSrcAcctItmCd","",""},
									{"costSrcAcctDtlCd","",""},
									{"unitCostSlane","",""}};			
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0119 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0119(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String array[][] = {
					{"srcCd", "", ""},
					{"tmlTrfCd", "", ""}
				};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0125 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0125(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0125Event event = (EsmCoa0125Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000001: :All", "All"},
					{"CD00206", "000020: :All", "All"},
					{"trade", "", ""},
					{"rLane3", "", ""},
					{"CD00206", "", ""},
					{"CD03217", "", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				if (!"".equals(event.getSearchConditionVO().getFCobtrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFCobtrade(), "All"}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				if (!"".equals(event.getSearchConditionVO().getFCobtrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFCobtrade(), ""}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0145 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0145(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0145Event event = (EsmCoa0145Event)e;
		SearchConditionVO vo = null;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"laneTP", "", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				vo = event.getSearchConditionVO();
				String edtDate = codeUtil.searchFirstEtd(vo.getFVslCd(), vo.getFSkdVoyNo(), vo.getFSkdDirCd());
				edtDate = Utils.iif(edtDate==null, "", edtDate);
				eventResponse.setETCData("edtDate", edtDate);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0146 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0146(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0146Event event = (EsmCoa0146Event)e;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo  = event.getSearchConditionVO();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"CD00231", "000001: :", ""}

					// 2011.01.25 동적메소드로 변경하여 세팅 불필요
					//, {"CD00230", "000001: :", ""}
				};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);

				String vsl_opr = "";
				vsl_opr = commonBC.getIbCodeCombo("vslOpr", "codeItem", "", "code");
				if(vsl_opr.indexOf('|') > 0) vsl_opr = vsl_opr.substring(2, vsl_opr.length());
				eventResponse.setETCData("ibVslSubTrd", vsl_opr);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				String vsl_cd = vo.getFVslCd().substring(0, 4);
				String skd_voy_no	= vo.getFVslCd().substring(4, 8);
				String skd_dir_cd	= vo.getFVslCd().substring(8, 9);
				String  rtnValue = commonBC.searchFirstEtd(vsl_cd, skd_voy_no, skd_dir_cd);
				eventResponse.setETCData("rtnValue", rtnValue);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				String array[][] = {
						{"VslOwner", event.getSearchConditionVO().getFVopCd(), ""}
				};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}else{
				String vsl_opr = "";
				vsl_opr = commonBC.getIbCodeCombo("vslOpr", "codeItem", "", "code");
				if(vsl_opr.indexOf('|') > 0) vsl_opr = vsl_opr.substring(2, vsl_opr.length());
				eventResponse.setETCData("ibVslSubTrd", vsl_opr);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0159 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0159(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0159Event event = (EsmCoa0159Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000001: :All", "All"},
					{"CD00206", "000020: :All", "All"}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				if (!"".equals(event.getSearchConditionVO().getFCobtrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFCobtrade(), "All"}
					};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/*
	 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 (ESM_COA_0048, ESM_COA_0180, ESM_COA_0107)
	 */
	/**
	 * ESM_COA_0048 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkIPCPricing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0048Event event = (EsmCoa0048Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try {
			List<CoaInterPrcUtCostVO> list = command.searchTrunkIPCPricing(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0048 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTrunkIPCPricing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0048Event event = (EsmCoa0048Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try {
			begin();
			command.multiTrunkIPCPricing(event.getCoaInterPrcUtCostVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0180 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0180(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		EsmCoa0180Event event = (EsmCoa0180Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBc.searchPrevWkPrd();
				String fYear = commonBc.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0180 : [이벤트]<br>
	 * [Re-Assignment by Bound(Internal Pricing)]을 [조회] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostByVVDInterPrcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0180Event event = (EsmCoa0180Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try {
			List<SearchFixCostByVVDInterPrcListVO> list = command.searchFixCostByVVDInterPrcList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0180
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createFixCostByVVDInterPrc(Event e) throws EventException {
		EsmCoa0180Event event = (EsmCoa0180Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			eventResponse = (GeneralEventResponse) command.createFixCostByVVDInterPrc(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_0107 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0107(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		EsmCoa0107Event event = (EsmCoa0107Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBc.searchPrevWkPrd();
				String fYear = commonBc.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0107: Allocation Result(Internal Pricing) 조회<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 APPLY 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllocationResultInter(Event e) throws EventException {
		EsmCoa0107Event event = (EsmCoa0107Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			List<CoaFxAmtDtrbVO> list = command.searchAllocationResultInter(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0180
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createAllocationResultInter(Event e) throws EventException {
		EsmCoa0107Event event = (EsmCoa0107Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			eventResponse = (GeneralEventResponse) command.createAllocationResultInter(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_0107: Allocation Result(Internal Pricing) Aply To PL 이벤트 처리<br>
	 * NetworkDistribution의 event에 대한 특정 리스트 APPLY 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse applyToPLInter(Event e) throws EventException {
		EsmCoa0107Event event = (EsmCoa0107Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkDistributionBC command = new NetworkDistributionBCImpl();
			eventResponse = (GeneralEventResponse) command.applyToPLInter(event.getSearchConditionVO(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESM_COA_0050 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0050(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0050Event event = (EsmCoa0050Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0108 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0108(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0108Event event = (EsmCoa0108Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String prevWeek = commonBC.searchPrevWkPrd();
				String fYear = commonBC.searchPrevYearPrd();
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
				eventResponse.setETCData("prevWeek", prevWeek);
				eventResponse.setETCData("fYear", fYear);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0034 : [Retrieve]<br>
	 * 구간별 운항일수 및 비율 생성화면에 대한 Sheet1 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneTransitTimeList(Event e) throws EventException {
		EsmCoa0034Event event = (EsmCoa0034Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchIntervalTransitTimeListVO> list = command.searchLaneTransitTimeList(event.getSearchConditionVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * ESM_COA_0034 : [Save]<br>
	 * 구간별 운항일수 및 비율 생성화면에 대한 Sheet1 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiLaneTransitTime(Event e) throws EventException {
		EsmCoa0034Event event = (EsmCoa0034Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiLaneTransitTime(event.getCoaMonVvdPortOpDysVOs(), account);
			commit();

			return eventResponse;
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
	}

	/**
	 * Average U/C(CM2)를 조회하는 화면
	 * 사용 프로그램 : ESM_COA_0182
	 *
	 * @param Event e 
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchAverageCM2List(Event e) throws EventException {
		EsmCoa0182Event event = (EsmCoa0182Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchAverageUCListVO> list = command.searchAverageCM2List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex){
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * ESM_COA_0182 : [Save]<br>
	 * Average U/C(CM2)를 저장<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAverageCM2(Event e) throws EventException {
		EsmCoa0182Event event = (EsmCoa0182Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiAverageCM2(event.getSearchConditionVO(), event.getCoaOpAvgUtCostVOS(), account);
			commit();			

			return eventResponse;
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
	}	

	/**
	 * ESM_COA_0182 : [Create]<br>
	 * Average U/C(CM2)를 Create<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageCM2(Event e) throws EventException {
		EsmCoa0182Event event = (EsmCoa0182Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();			
			command.createAverageCM2(event.getSearchConditionVO(), account);
			commit();

			return eventResponse;
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
	}
	/**
	 * ESM_COA_0120 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0120(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0120Event event = (EsmCoa0120Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
				String array[][] = { {"SMUSubTrade", event.getSearchConditionVO().getFTrdCd(), "All"},
									};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd() + ":"+event.getSearchConditionVO().getFSubTrdCd(), ""}
						};
				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else{
				/*-------------------------------------------------------*/
				String array[][] = { {"trade", "", ""},
									 {"SMUSubTrade", "", ""},
									 {"rLane", "", ""},
									// {"CD00593", "", ""},
									 {"CD01089", "", ""},
									};

				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex){
				log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * ESM_COA_0121 : 공통코드 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0121(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0121Event event = (EsmCoa0121Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
				String array[][] = { {"SMUSubTrade", event.getSearchConditionVO().getFTrdCd(), ""},
									};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				String array[][] = {
						{"rLane", event.getSearchConditionVO().getFTrdCd() + ":"+event.getSearchConditionVO().getFSubTrdCd(), ""}
						};
				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}else{
				/*-------------------------------------------------------*/
				String array[][] = { {"trade", "", ""},
									 {"SMUSubTrade", "", ""},
									 {"rLane", "", ""},
									 //{"CD00593", "", ""},
									 {"CD01089", "", ""},
									};

				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex){
				log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost의 event에 대한 생성 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0121
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiLaneBoundSwitch(Event e) throws EventException {
		EsmCoa0121Event event = (EsmCoa0121Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			WeeklyCMBC command = new WeeklyCMBCImpl();
			command.multiLaneBoundSwitch(event.getCoaLaneDirConvVOS(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0120 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSeasonalSMUCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0120Event event = (EsmCoa0120Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try {
			//List<SearchSMUPfmcListVO> list = command.searchSMUPfmcList(event.getSearchSMUPfmcListVO(), event.getSearchConditionVO());
			List<SearchSeasonalSMUCostListVO> list = command.searchSeasonalSMUCostList(event.getSearchSeasonalSMUCostListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 사용 프로그램 : ESM_COA_0121
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneBoundSwitchList(Event e) throws EventException {
		EsmCoa0121Event event = (EsmCoa0121Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			WeeklyCMBC command = new WeeklyCMBCImpl();
			List<SearchSeasonalSMUCostPopListVO> list = command.searchLaneBoundSwitchList(event.getSearchSeasonalSMUCostPopListVO(), event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 1. 기능 :EQ Holding Cost화면에서화면에서 0173 Popup을 통해서 단가 copy시<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Suk Joon, LEE/2012.08.02<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createEqHoldingCostMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EQHoldingBC command = new EQHoldingBCImpl();
			command.createEqHoldingMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 1. 기능 :ABC/STP화면에서화면에서 0173 Popup을 통해서 단가 copy시<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Suk Joon, LEE/2012.08.22<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createAbcStpCostMonthCopy (Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			MASBC command = new MASBCImpl();
			command.createAbcStpCostMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	//createEqRepoCostMonthCopy
	
	/**
	 * 1. 기능 :EQ Repo Cost화면에서화면에서 0173 Popup을 통해서 단가 copy시<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Suk Joon, LEE/2012.08.22<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createEqRepoCostMonthCopy (Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			MTCostBC command = new MTCostBCImpl();
			String status = command.createEqRepoCostMonthCopy(event.getSearchConditionVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0173 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			MTCostBC command = new MTCostBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 1. 기능 :EMU Cost화면에서화면에서 0173 Popup을 통해서 단가 copy시<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Suk Joon, LEE/2012.09.12<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createEMUCostMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			WeeklyCMBC command = new WeeklyCMBCImpl();
			command.createEMUCostMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 1. 기능 :Manual cost Set Up t화면에서화면에서 0173 Popup을 통해서 단가 copy시<p>
	 * 2. 처리개요 :  <p>
	 *	-  저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Suk Joon, LEE/2012.09.12<br>
	 * ===================================<br>
	 * @param e Event
	 * @return response ESM_COA_173EventResponse
	 * @exception EventException
	 */
	private EventResponse createManualCostStupCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostSetUpBC command = new CostSetUpBCImpl();
			command.createManualCostStupCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}


	/**
	 * ESM_COA_0173 : Dailyhire by Cht-VSL (PA) 화면에서 0173 Popup을 통해서 단가 copy시 <br>
	 * Month Copy 공통팝업을 통해 Dailyhire by Cht-VSL 전월 copy <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse createDailyHireMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.createDailyHireMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_COA_0173 : AVG hire by Own VSL (PA) 화면에서 0173 Popup을 통해서 단가 copy시 <br>
	 * Month Copy 공통팝업을 통해 AVG hire by Own VSL 전월 copy <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse createOwnDailyHireMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.createOwnDailyHireMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_COA_0173 : SMU Cost (RA) 화면에서 0173 Popup을 통해서 단가 copy시 <br>
	 * Month Copy 공통팝업을 통해 SMU Cost (RA) 전월 copy <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse createSMUPfmcMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			WeeklyCMBC command = new WeeklyCMBCImpl();
			command.createSMUPfmcMonthCopy(event.getSearchConditionVO(), account);
			commit();
		} catch (EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_COA_0047 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTsAllocation1(Event e) throws EventException {
		EsmCoa0047Event event = (EsmCoa0047Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NetworkDistributionBC command = new NetworkDistributionBCImpl();
		try {			
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkTsAllocationCreateBatchStatus();		
			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			// 3. batch status를 생성한다.
			event.getSearchConditionVO().setFCmdtCd(e.getEventName());
			begin();
			command.addTSAllocationBatchStatus(event.getSearchConditionVO(), account);		
			commit();
			// 4. batch를 실행한다.
			strStatus = command.createTsAllocation(event.getSearchConditionVO(), account);						
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0050 : Creation <br>
	 * Create TS Allocation 2<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTsAllocation2(Event e) throws EventException {
		EsmCoa0050Event event = (EsmCoa0050Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NetworkDistributionBC command = new NetworkDistributionBCImpl();
		try {	
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkTsAllocationCreateBatchStatus();		
			//2. 만약 진행중인 상태거나 Error 이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			// 3. batch status를 생성한다.
			event.getSearchConditionVO().setFCmdtCd(e.getEventName());
			begin();
			command.addTSAllocationBatchStatus(event.getSearchConditionVO(), account);		
			commit();
			// 4. batch를 실행한다.
			strStatus = command.createTsAllocation(event.getSearchConditionVO(), account);						
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * TS Allocation Batch <br>
	 * Batch status monitoring
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorTSAllocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NetworkDistributionBC command = new NetworkDistributionBCImpl();	
		try {
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkTsAllocationCreateBatchStatus();		
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_COA_0014 : [Month Copy]<br>
	 * 1. 기능 :Domestic Saving Credit 화면에서 0173 Popup을 통해서 단가 copy<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDomesticMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			USDomesticBC command = new USDomesticBCImpl();
			command.createDomesticMonthCopy(event.getSearchConditionVO(), account);
			commit();

		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_COA_0177 : [Month Copy]<br>
	 * 1. 기능 :Lane Table (1Cycle) 화면에서 0173 Popup을 통해서 단가 copy<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createLaneTableMonthCopy(Event e) throws EventException {
		EsmCoa0173Event event = (EsmCoa0173Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.createLaneTableMonthCopy(event.getSearchConditionVO(), account);
			commit();

		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}
	
    /**
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobStatusByNW(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        NetworkCostBC command = new NetworkCostBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
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
    private EventResponse searchBackEndJobResultByNW(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	NetworkCostCommonVO vo= (NetworkCostCommonVO)BackEndJobResult.loadFromFile(key);    
        	eventResponse.setETCData("err_cd", vo.getErrorCode());
            eventResponse.setETCData("err_msg", vo.getErrorMsg());
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /* ************************************************
       BACK END JOB 관련 - End
       ************************************************/
	
    

    /**
     * ESM_COA_0174 : [onChange]<br>
	 * Average U/C 생성 정보 조회<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchAverageUCStatus(Event e) throws EventException {
    	EsmCoa0174Event event = (EsmCoa0174Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	

        try {            
        	NetworkCostBC command = new NetworkCostBCImpl();
        	List<CoaUtCostCreStsVO> list = command.searchAverageUCStatus(event.getSearchConditionVO());
        	if(list.size()>0) {
        		eventResponse.setETCData("FM_WEEK", list.get(0).getCostSrcFmYrmon());
    			eventResponse.setETCData("TO_WEEK", list.get(0).getCostSrcToYrmon());
    			eventResponse.setETCData("UPD_DT", list.get(0).getUpdDt());
        	} else {
        		eventResponse.setETCData("FM_WEEK", "");
    			eventResponse.setETCData("TO_WEEK", "");
    			eventResponse.setETCData("UPD_DT", "");
        	}
			
			
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;        
    }
  

    /**
     * ESM_COA_0221 : [Retrieve]<br>
	 * EMU Credit Table 정보 조회<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchEmuCreditTableList(Event e) throws EventException {
    	EsmCoa0221Event event = (EsmCoa0221Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	

        try {            
        	WeeklyCMBC command = new WeeklyCMBCImpl();
        	List<CoaEMUCreditListVO> list = command.searchEmuCreditTableList(event.getSearchConditionVO());
        	eventResponse.setRsVoList(list);	
			
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;        
    }
  
    

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- OPMaster 항로관리에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.12<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditRtPortPairList(Event e) throws EventException {
		EsmCoa0222Event event = (EsmCoa0222Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			WeeklyCMBC command = new WeeklyCMBCImpl();
			List<SearchOPCreditRtPortPairVO> list = command.searchCreditRtPortPairList(event.getSearchOPCreditRtPortPairVO(),"OP");
			List<SearchOPCreditRtPortPairVO> list2 = command.searchCreditRtPortPairList(event.getSearchOPCreditRtPortPairVO(),"ECC");
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	
}