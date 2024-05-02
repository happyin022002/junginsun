/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : JointOperationAgreementSettlementSC.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.18 박희동
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.03 진마리아 [CHM-201006730-01]
                    Summary of Monthly Clearance Status by Carrier 기능에 Due Date, Remark 컬럼 추가
* 2010.11.08 이준범 [CHM-201006731-01]
*                   1. 대상 기능
*                     - JO Member Information Creation(JOO_0066)
*                     - Inquiry of JO Member Information(JOO_0067)
*                   2. 보완 대상
*                     - Revenue Lane 정보 반영
*                     - MS Office( Excel, Worl, Power Point등) 첨부
*                     - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
*                   1. 보완 기능
*                     - JO Member Information Creation
*                     - Inquiry of JO Member Information
*                   2. 보완 요청 사항
*                     - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
* 2011.01.07 김상수 [소스품질관리] R4J에 도출된 printStackTrace문 수정
*                   - printStackTrace => log.error로 수정
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
* 2011.06.30 이준범[CHM-201111621-01]
* 제목 : Esitmate Perfomance Creation 화면의 항목 추가 요청
* 내용 : Adjust, Adjusted BSA, Adjusted Slot Cost, Adjuest Estimated Cost, Adjuest Actual Cost, Remark 항목 추가
* 2011.06.30 이준범[CHM-201111620-01]
* 제목 : R9 TP/SZ 코드 도입에 따른 변경 요청
* 내용 : Booking Data Inquiry 화면의  Type Size R9를 H/C에 포함하여 Count하도록 수정
* 
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
* 2012.02.13 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
* 2012.02.28 조병연 [CHM-20121640001][ALPS JOO] Account Month가 Closing된 후 Save 및 Delete 기능 비활성화 
* - Account Month가 Closing된 이후에는 Data 생성 및 삭제 기능들이 비활성화되도록 Logic 추가
* - FnsJoo0005Event, FnsJoo0007Event, FnsJoo0012Event, FnsJoo0016Event, FnsJoo0017Event, FnsJoo0020Event에서
*   AR Closing Time 체크를 위한 로직 추가(6개가 공통으로 사용함)
* - 현재 AP Closing Time을 기준으로 하는것을 AR Closing Time으로 변경 (쿼리 변경)
* - Save, Delete 버튼 비활성화
* 
* 2012.06.21 김상근[CHM-201218380]
* Ticket Title : [ALPS JOO] TDR Inquiry by VVD
* Description  :  Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가.
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement;
 
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

import weblogic.auddi.util.Logger;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0007Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0009Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0010Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0011Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0012Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0013Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0014Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0015Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0036Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0037Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0038Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0039Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0040Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0041Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0042Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0043Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0045Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0046Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0049Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0050Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0053Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0054Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0055Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0056Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0057Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0081Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0087Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0090Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustOusRDRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ArDisabledVVDVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.IntloadSumReportVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrRatioVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0029Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0030Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0032Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0033Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo003401Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo003402Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0074Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0088Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0089Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0016Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0102Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0017Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0018Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0020Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0022Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0023Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0024Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0025Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0026Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0027Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0044Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0068Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0076Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0077Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0078Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0080Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0099Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ApIfErrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArDataInqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.AgmtDocVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic.JointOperationLetterBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic.JointOperationLetterBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0059Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0060Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0061Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0062Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0065Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0066Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0067Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0070Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0073Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0075Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvMcsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvoiceCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBC;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0028Event;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.bizcommon.util.BizComUtil;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;
import com.hanjin.syscommon.common.table.JooEstmClzVO;
import com.hanjin.syscommon.common.table.JooLtrTmpltVO;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooTaxDtlVO;
import com.hanjin.syscommon.common.table.JooTaxVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0100Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0103Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SkdPortVO;


/**
 * ALPS-JointOperationAgreementSettlement Business Logic ServiceCommand -
 * ALPS-JointOperationAgreementSettlement 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Park Hee Dong
 * @see JointOperationConsultationDBDAO
 * @since J2EE 1.4
 */

public class JointOperationAgreementSettlementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationAgreementSettlement system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationAgreementSettlement system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("JointOperationAgreementSettlementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-JointOperationAgreementSettlement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		//FNS_JOO_0044 Tax Inquiry
		if (e.getEventName().equalsIgnoreCase("FnsJoo0044Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxList(e);
			}
			//화면Open
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0044(e);
			}
		//FNS_JOO_0026 A/R ERP Interface
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0026Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARERPInterfaceList(e);
			}
		//FNS_JOO_0027 A/P ERP Interface
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0027Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPERPInterfaceList(e);
			}
		//FNS_JOO_0013 War Risk
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0013Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementWRList(e);
			//Dup Check 후 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementWR(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0013Event event = (FnsJoo0013Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdWR(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlWRList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0013(e);
			}
		//FNS_JOO_0014 Port Skip
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0014Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementPBList(e);
			//Duplication Check후 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementPB(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0014Event event = (FnsJoo0014Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdPB(e);

			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlPBList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0013(e);
			}
		//FNS_JOO_0012 Other
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0012Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementOTHList(e);
			//중복체크하는 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementOTH(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0012Event event = (FnsJoo0012Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdOTH(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlOTHList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			// S/H - M/S인 경우 BSA Type이 변경될 때 맞는 BSA Type인지 Check한다.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBsaTypeValidationCheck(e);
			// Open시
	    	} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0012(e);
			}
		//FNS_JOO_0007 Slot Hire
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0007Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementSHList(e);
			//저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementSH(e);
			//VVD변경(10자리변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdSH(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0007Event event = (FnsJoo0007Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//전체data삭제
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementSH(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlSHList(e);
			//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			// Open시
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0007(e);
			}
		//FNS_JOO_0009 Over Used RDR
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0009Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementRDRList(e);
			//저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementRDR(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0009Event event = (FnsJoo0009Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD변경(10자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdRDR(e);
			//원가 조회 (I/O변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBsaSltPrcForOusRdr(e);
			//Used Slot 조회 (RGN 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchUsedSlotInfo(e);
			//전체삭제
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementRDR(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlRDRList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0009(e);
			}
		//FNS_JOO_0010 Over Used TDR
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0010Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementTDRList(e);
			//저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementTDR(e);
				//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0010Event event = (FnsJoo0010Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD체크 및 Port 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPriceAndPortList(e);
			//From Port 변경시 단가조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOusTdrUsedSlot(e);
			// To Port 변경시 TEU, WGT 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchOusTdrUsedSlotPrice(e);
			//전체삭제
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementTDR(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlTDRList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0010(e);
			}
		//FNS_JOO_0011 Reefer
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0011Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementRFList(e);
			//저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementRF(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0011Event event = (FnsJoo0011Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD Validation체크 및 Port조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdRF(e);
			//POD 변경 => 원가 수량 조회 => 사용안함
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchUsedReeferList(e);
			//I/O Change시 RF Surcharge조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchRfIOChange(e);
			//RGN변경시 POL, POD, Used RF 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRfRgnChange(e);
			//전체데이터 삭제
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeSettlementRF(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlRFList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0011(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualClosing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAccrualClosing(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualListByAccount(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailSlipList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0069Event")) {
		//	FnsJoo0069Event event = (FnsJoo0069Event) e;
		//	SlipConditionVO vo = event.getSlipConditionVO();
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailSlipList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsultationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailConsultation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = approvalConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchConsultationBackEndJobStatus(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCsrDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = reverseConsultation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPersonInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPEvidenceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCreateAPEvidenceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0018(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLetterSendList(e);
			}
			// 화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0070(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryOfMcsListByTrade(e);
			}
			// 화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0037(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccrualListByMAS(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCsrOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCsrCancel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0025(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0066Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMemberInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPicUserIdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMemberInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCustCdNm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCarrierSeq(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0066(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarrierMemberInfo(e);
			}
			// Open시
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0067(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryOfMcsListByCarrier(e);
			} // 화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTradeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = openFnsJoo0036(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSummaryOfMcsListByCarrier(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")
				|| e.getEventName().equalsIgnoreCase("FnsJoo0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTemplate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createTemplate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeTemplate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//OPEN

                if ( e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
                    eventResponse = openFnsJoo0059(e);
                }

                if ( e.getEventName().equalsIgnoreCase("FnsJoo0061Event")) {
                    eventResponse = openFnsJoo0061(e);
                }
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTempalteTextNoList(e);
			}


		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0039Event")) {
			/******************* Monthly Clearance Status by Carrier & Lane: Retirieve ***********************/
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMccListByCarNLane(e);

			}
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
                eventResponse = searchMccDtlListByCarNLane(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0039(e);
            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0029Event")) {
			/******************* Estimate Performance Creation ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJointOperationAccrualList(e);
			}
			/* 2. Save */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageJointOperationAccrual(e);
			}
			/* 3. Create 한 후에 Save*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = createJointOperationAccrual(e);
			}
			/* 3. Target Retrieve : Create 대상 조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = calJointOperationAccrual(e);
			}			
			/* 조회 조건 변경시 */
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCond0029(e);
			}
			/* 4. I/F */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendJointOperationAccrualERP(e);
			}
			/* 4. I/F 조회 */			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchJointOperationAccrualERP(e);
			}					
			/* BackEndJob 상태조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccrualBackEndJobStatus(e);
			}
			/* BackEndJob 결과조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				try{
					eventResponse = searchAccrualBackEndJobResult(e);
				}catch(BackEndJobException ex){
					throw new EventException(ex.getMessage());
				}
			}
			/* 5. Open */
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0029(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){	
				eventResponse = searchAccrualListExcel(e);			// 추가								
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo003401Event")) {
			/******************* Estimate Code Check - Carrier ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstdCarCheckList(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo003402Event")) {
			/******************* Estimate Code Check - VVD ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstdVvdCheckList(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0065Event")) {
			/******************* MCS & Invoice Letter Fax/E-mail Inquiry ***********************/
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLetterSendStsList(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0060Event")) {
			/******************* MCS Letter Information Creation ***********************/
            /* 0. Open */
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0060(e);
            }

			/* 2. Text No. Change*/
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMcsLetter(e);

			}
			/* 3. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMcsCombined(e);

			}
			/* 4. Save */
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMcsLetter(e);

			}
			/* 5. Send */
			if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendMcsLetter(e);

			}
            /* 6. Retrieve2 : 0070에서 저장된건 조회하기. */
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
                eventResponse = searchMcsSavedCombined(e);

            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0038Event")) {
			/******************* Summary of Monthly Clearance Status by VVD ***********************/

			/* 1. Retrieve */
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//
	                eventResponse = searchSummaryOfMcsListByVVD(e);

            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0038(e);
            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0042Event")) {
			/******************* Slot Exchange Status by Lane & Partner->Finance Lane ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSlotXchStatusListByFinanceLane(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0043Event")) {
			/******************* Slot Exchange Status by Lane & Partner->Finance Partner ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSlotXchStatusListByFinancePartner(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0049Event")) {
			/******************* Settlement Status for Basic Allocation ***********************/

			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlStatusListForBSA(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0049(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
                eventResponse = openFnsJoo0049(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0050Event")) {
			/******************* Target Voyage vs Unsettled Status ***********************/
			/* 1. Retrieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTgtVoyVsUnstlStatusList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTgtUnstlStsRmk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0050(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustSlotHireStlList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAdjustSlotHireStl(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0045(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCombinedMonthlyClearanceList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCombinedRlaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCombinedMonthlyClearanceByLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCombinedMonthlyClearance(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeCombinedMonthlyClearance(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0016(e);
				
			//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
				
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createAPConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAPClosYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0017(e);
			//마감여부 조회
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGW(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createARConsultation(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARClosYn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0020(e);
			//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0015Event")) {
            /******************* Monthly Clearance Inquiry : Retirieve ***********************/
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchMonthlyClearanceList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchMonthlyStlCmbSeqList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0015(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0040Event")) {
            /******************* Slot Exchange Status by Lane & Partner->Space On Lane : Retrieve ***********************/
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSlotXchStatusListBySpaceLane(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0040 (e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0041Event")) {
            /******************* Slot Exchange Status by Lane & Partner->Space On Lane : Retrieve ***********************/
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSlotXchStatusListBySpacePartner(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0041 (e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0054Event")) {
            /******************* TDR Cration Inquiry : Retrieve ***********************/
        	log.debug("::CALL::> TDR Cration Inquiry sc :::::::::      ");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 		 eventResponse = searchTDRCreateListByLane (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				 		 eventResponse = searchLaneCdYn (e);
			}
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0055Event")) {
            /******************* RDR Upload Inquiry : Retrieve ***********************/
        	log.debug("::CALL::> RDR Upload Inquiry sc :::::::::      ");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 		 eventResponse = searchRDRCreateListByLane (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				 		 eventResponse = searchLaneCdYn (e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0062Event")) {
            /******************* Invoice Letter Information Creation ***********************/
            /* 0. Open */
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0062(e);
            }

            /* 2. Text No. Change*/
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchInvoiceLetter(e);

            }//
            /* 3. Retrieve */
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchInvoiceCombined(e);

            }
            /* 4. Save */
            if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = createInvoiceLetter(e);

            }
            /* 5. Send */
            if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = sendInvoiceLetter(e);

            }
            /* 6.2 Retrieve Saved Invoice by 0070 */
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
                eventResponse = searchInvoiceSavedCombined(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstmPerformanceList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCond(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0074(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0056Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0056(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRDRCarrierCodeString(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchRDRDownloadListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRDRVVDCrrRmk(e);
            }
            
          //add : 2012.07.31
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
              eventResponse = searchRDRCarrierCodeStringByServiceLane(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0053Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchVVDOfNotExistRevMonList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0057Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0057(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchTDRCarrierCodeString(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchTDRRatioCountByLane(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchTDRDownloadListByLane(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0090Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTDRRatioListByLane(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = createTDRRationByLane(e);  	
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchROBRatioListByLane(e);  
                          	
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {            	
            	eventResponse = manageROBRationByLane(e);  	
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0075Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0075(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchUserNm(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchTempalteSeqList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSignNBank(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageSignNBank(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeSignNBank(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustOusListForRDR(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0046(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0076Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchARDisabledVVD(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0077Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0077(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchARDataInquiry(e);
            }

		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApIfErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = rejectConsultation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLostCombinedDataList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0080(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0081Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
               eventResponse = searchDischageForLoading(e);
           }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//EXCEL DOWN LOAD
               eventResponse = searchDischageForLoadingExcel(e);
           }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0088Event")) {
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstmPerformanceChangeStatusList(e);
			/* 2. Save */
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEstmPerformanceChangeStatus(e);

			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstmPerformanceChangeStatus(e);

			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0088(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0087Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0087(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchIntergratedloadSumReportRDRList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = addIntergratedloadSumReportRDRList(e);
            }
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0089Event")) {
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstmPerformanceChangeStatusIIList(e);

			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEstmPerformanceChangeStatusII(e);

			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0089(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0099Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGWDoc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGWDoc(e);
			}								
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0100Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
                eventResponse = searchRobList(e);	        	
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {        	
	        	eventResponse = searchRobList2(e);	        	                
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {        	
	        	eventResponse = searchRobList3(e);	        	                	        	
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {        	
	        	eventResponse = searchRobList4(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {        	
	        	eventResponse = searchRobList5(e);	        	                	        		        		        	
	        } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSkdPortList(e);	        	
	        }          			
	   }else if (e.getEventName().equalsIgnoreCase("FnsJoo0102Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
	            eventResponse = searchCombinedDupList(e);	        	
	        }
       }else if (e.getEventName().equalsIgnoreCase("FnsJoo0103Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
               eventResponse = searchRobSummaryList(e);               
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {        	
                eventResponse = searchRobSummaryList2(e);       
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {        	
                eventResponse = searchRobSummaryList3(e);           
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {        	
                eventResponse = searchRobSummaryList4(e);                           
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {        	
                eventResponse = searchRobSummaryList5(e);                                           
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchVslSkdEtd(e);	        	
   			/* BackEndJob 상태조회 */
       		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
   				eventResponse = searchRobSummaryEndJobStatus(e);
   			/* BackEndJob 결과조회 */
       		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
   				try{
   					eventResponse = searchRobSummaryBackEndJobResult(e);
   				}catch(BackEndJobException ex){
   					throw new EventException(ex.getMessage());
   				}
       		}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// RDR Port 저장
                eventResponse = manageRDRPort(e);       			
	        }          				        	        	        
       }
		
		return eventResponse;
	}

	/**
	 * FNS_JOO_0044 : Retrieve
	 * TAX정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0044Event event = (FnsJoo0044Event) e;
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		List<TaxVO> list = command.searchTaxList(event.getTaxInvYrmonFr(), event.getTaxInvYrmonTo());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0044 : Open
	 * 화면Open시 영세율/과세율, 흑자/적자등의 공통코드를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0044(Event e) throws EventException {
        try{
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		//영세율(1),과세율(2)
    		CodeUtil codeUtil = CodeUtil.getInstance();
    		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01754", 0);

    		Iterator iterator = (Iterator) codeList2.iterator();

    		StringBuilder tpCombo   = new StringBuilder();
    		StringBuilder tpNmCombo = new StringBuilder();
    		while (iterator.hasNext()) {
    			CodeInfo codeInfo = (CodeInfo)iterator.next();
    			tpCombo  .append(codeInfo.getCode() + "|");
    			tpNmCombo.append(codeInfo.getName() + "|");
    		}

    		String sTpCombo = tpCombo.toString();
    		String sTpNmCombo = tpNmCombo.toString();

    		if (sTpCombo.length() > 0) {
    			sTpCombo = sTpCombo.substring(0, sTpCombo.length() - 1);
    			sTpNmCombo = sTpNmCombo.substring(0, sTpNmCombo.length() - 1);
    		}

    		//흑자(B), 적자(R)
    		Collection<CodeInfo> list = codeUtil.getCodeSelect("CD01756", 0);

    		iterator = (Iterator) list.iterator();

    		StringBuilder plCombo = new StringBuilder();
    		StringBuilder plNmCombo = new StringBuilder();
    		while (iterator.hasNext()) {
    			CodeInfo codeInfo = (CodeInfo) iterator.next();
    			plCombo.append  (codeInfo.getCode() + "|");
    			plNmCombo.append(codeInfo.getName() + "|");
    		}

    		String sPlCombo = plCombo.toString();
    		String sPlNmCombo = plNmCombo.toString();

    		if (sPlCombo.length() > 0) {
    			sPlCombo = sPlCombo.substring(0, sPlCombo.length() - 1);
    			sPlNmCombo = sPlNmCombo.substring(0, sPlNmCombo.length() - 1);
    		}

    		eventResponse.setETCData("CD01754", sTpCombo);
    		eventResponse.setETCData("CD01754NM", sTpNmCombo);
    		eventResponse.setETCData("CD01756", sPlCombo);
    		eventResponse.setETCData("CD01756NM", sPlNmCombo);
    		return eventResponse;

//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//        	throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0026 : Retrieve
	 * AR Data ERP Interface 내용을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchARERPInterfaceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0026Event event = (FnsJoo0026Event) e;
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		List<ErpIfVO> list =
    			command.searchARERPInterfaceList(event.getErpIfFlg(), event.getDtFlg(), event.getIssDtFr(), event.getIssDtTo());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0027 : Retrieve
	 * AP Data ERP Interface 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPERPInterfaceList(Event e)	throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0027Event event = (FnsJoo0027Event) e;
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		List<ErpIfVO> list =
    			command.searchAPERPInterfaceList(event.getErpIfFlg(), event.getDtFlg(), event.getIssDtFr(), event.getIssDtTo());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0013 : 화면 Open
	 * 화면 open시 Carrier Code와 Financial Direction을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0013(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

    		// Carrier 조회
    		jooCodeParamVO.setOfcCd(account.getOfc_cd());
    		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

    		String crrCombo = makeComboString(list, 1);

    		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
    		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
    		procSettlementVO.setReDivrCd("R");
    		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
    		eventResponse.setETCData("jo_crr_cd", crrCombo);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0012 : 화면 Open
	 * Carrier Code List, Financial Direction, Settlement Item, BSA Type 등 코드성 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

    		// Carrier 조회
    		jooCodeParamVO.setOfcCd(account.getOfc_cd());
    		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

    		String crrCombo = makeComboString(list, 1);

    		// ABBR 조회
    		jooCodeParamVO.setSuperCd2("Y"); // Manual만
    		list = command.searchStlItemCodeList(jooCodeParamVO);

    		String abbrCombo = makeComboString(list, 1);
    		String abbrSheet = makeComboString(list, 2); // code
    		String nameSheet = makeComboString(list, 3); // name

    		// Revenue Direction
    		CodeUtil codeUtil = CodeUtil.getInstance();
//    		Collection<CodeInfo> codeList1 = codeUtil.getCodeSelect("CD02115", 0);
//    		String dirctSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList1), BizComUtil.CODE_DELIMITTER);

    		// BSA Type
    		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
    		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);
    		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
    		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

    		String code = "";
    		StringBuilder bsaTypeCdTmp = new StringBuilder();
    		StringBuilder bsaTypeNmTmp = new StringBuilder();
    		for (int i=0; i<bsaTypeCd.length; i++){
    			code = bsaTypeCd[i].substring(0,1);
    			if ("1".equals(code)){
    				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
    				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
    			}
    		}

    		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
    		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

    		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
    		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
    		procSettlementVO.setReDivrCd("R");
    		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));

    		eventResponse.setETCData("jo_crr_cd", crrCombo);
//    		eventResponse.setETCData("fin_dir_combo", dirctSheetList[0]);
    		eventResponse.setETCData("abbrCombo", abbrCombo);
    		eventResponse.setETCData("abbrSheet", abbrSheet);
    		eventResponse.setETCData("nameSheet", nameSheet);
    //		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
    //		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
    		eventResponse.setETCData("stl_jb_combo", bsaTpCd);
    		eventResponse.setETCData("stl_jb_comnm", bsaTpNm);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0013 : Retrieve
	 * Settlement War Risk 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementWRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0013Event event = (FnsJoo0013Event)e;
    		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
    		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0014 : Retrieve
	 * Settlement Port Skip 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementPBList(Event e) throws EventException {
	 try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0014Event event = (FnsJoo0014Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0012 : Retrieve
	 * Settlement Other 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementOTHList(Event e) throws EventException {
	  try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0007 : Retrieve
	 * Settlement Slot Hire 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementSHList(Event e) throws EventException {
	  try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0009 : Retrieve
	 * Settlement Over Used RDR 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementRDRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	  try{
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();

		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0010 : Retrieve
	 * Settlement Over Used TDR 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementTDRList(Event e) throws EventException {
	 try{
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		List<ProcSettlementVO> list = command.searchSettlementList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    } catch (EventException ex) {
        log.error("err " + ex.toString(), ex);
        throw ex;
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(ex.getMessage(), ex);
    }
	}

	/**
	 * FNS_JOO_0013 : Save
	 * War Risk Surcharge Settlement 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementWR(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0013Event event = (FnsJoo0013Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * FNS_JOO_0014 : Save
	 * Port Skip Settlement Duplication Check후 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0014Event event = (FnsJoo0014Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0012 : Save
	 * Other Surcharge Settlement dup check하고 저장한다.
	 * Dup Error시 UI에 표시하고 Dup Error가 발생하지 않은 경우 그냥 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementOTH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Save
	 * Slot Hire Surcharge Settlement Duplication Check후 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Save
	 * Over Used RDR Surcharge Settlement Duplication Check후 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Save
	 * Over Used TDR Surcharge Settlement Duplication Check후 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementTDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			List<ProcSettlementVO> list = command.manageSettlementSH(procSettlementVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Save
	 * Reefer Surcharge Settlement Duplication 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			SettlementRFVO[]   settlementRFVOs   = event.getSettlementRFVOs();

			List<SettlementRFVO> list = command.manageSettlementRF(settlementRFVOs, account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Delete
	 * Slot Hire 조회조건에 맞는 전체 data 삭제한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Delete
	 * Over Used RDR 조회조건에 맞는 전체 data 삭제한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Delete
	 * Over Used TDR 조회조건에 맞는 전체 data 삭제한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementTDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0010Event event = (FnsJoo0010Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Delete
	 * Reefer 조회조건에 맞는 전체 data 삭제한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSettlementRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = command.removeSettlement(event.getProcSettlementVO());
			command1.manageTargetVVDForSettlement(procSettlementVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_JOO_0013 : VVD변경
	 * War Risk VVD Validation Check한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdWR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0013Event event = (FnsJoo0013Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		return searchStlVvd(vo);
	}

	/**
	 * FNS_JOO_0014 : VVD변경
	 * Port Skip VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0014Event event = (FnsJoo0014Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		return searchStlVvd(vo);
	}

	/**
	 * FNS_JOO_0012 : VVD변경
	 * Other VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdOTH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvd(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();

			//Other인 경우만 AR_MST_REV_VVD 조회
			if (vo.getJoMnuNm().equals("M/S")){
				String rtnVal = command.searchStlVvdOth(vo);
				eventResponse.setETCData("CHECKVVD", rtnVal);
			}
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : VVD변경
	 * Slot Hire VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdSH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		return searchStlVvd(vo);
	}

	/**
	 * FNS_JOO_0009 : VVD변경
	 * Over Used RDR VVD Validation Check한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvdOusRdr(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		String fnlHjsBsaQty = "";
		String fnlBsaWgt = "";
		String bsaPerWgt = "";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq      = voOut.getStlVvdSeq();
			stlBzcPortCd   = voOut.getStlBzcPortCd();
			etaDt          = voOut.getEtaDt();
			ucBssPortCd    = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
			fnlHjsBsaQty   = voOut.getFnlHjsBsaQty();
			fnlBsaWgt      = voOut.getFnlBsaWgt();
			bsaPerWgt      = voOut.getBsaPerWgt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);
		eventResponse.setETCData("fnl_hjs_bsa_qty", fnlHjsBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt", fnlBsaWgt);
		eventResponse.setETCData("bsa_per_wgt", bsaPerWgt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : VVD변경
	 * Reefer VVD Validation Check & Port List 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdRF(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		GeneralEventResponse eventResponse = (GeneralEventResponse)searchStlVvd(vo);

		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();

		// parameter 정의
		// super_cd1 => rlane_cd
		// super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		//JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchUnitCostPortList(event.getJooCodeParamVO());

		// select List 정의
		// CODE => PORT
		// NAME => ETD
		String portList = makeComboString(list, 2);

		eventResponse.setETCData("portList", portList);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0007,FNS_JOO_0009,FNS_JOO_0011,FNS_JOO_0012,FNS_JOO_0013,FNS_JOO_0014 : VVD변경
	 * VVD변경시 Validation Check한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvd(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0013 : Create
	 * War Risk Create용 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlWRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0013Event event = (FnsJoo0013Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0014 : Create
	 * Port Skip Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlPBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0014Event event = (FnsJoo0014Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0012 : Create
	 * Other Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlOTHList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Create
	 * Slot-Hire Settlement를 Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlSHList(Event e) throws EventException {
		FnsJoo0007Event event = (FnsJoo0007Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		ProcSettlementVO procSettlementVO = event.getProcSettlementVO();
		List<ProcSettlementVO> list = command.searchAddStlForSlotHireList(procSettlementVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Create
	 * OUS RDR Settlement의 Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlRDRList(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlForOusRdrList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Create
	 * OUS TDR Settlement의 CREATE용 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlTDRList(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchAddStlForOusTdrList(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Create
	 * R/F Settlement의 Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchAddStlForRFList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007 : Open
	 * 화면 Open시 Carrier Code List, Revenue Dir. BSA Type을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0007(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Revenue Direction
		CodeUtil codeUtil = CodeUtil.getInstance();

		//BSA Type => 1로 시작하는 것만...
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = new String[2];
		stljbSheetList[0] = "";
		stljbSheetList[1] = "";

		Iterator iterator = codeList2.iterator();

		while(iterator.hasNext()){
			CodeInfo codeInfo = (CodeInfo)iterator.next();

			if ("1".equals(codeInfo.getCode().substring(0,1))){
				stljbSheetList[0] = stljbSheetList[0]+codeInfo.getCode()+"|";
				stljbSheetList[1] = stljbSheetList[1]+codeInfo.getName()+"|";
			}
		}

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : open
	 * 화면오픈시 Carrier, Revenue Dir., Inter/Ocean 구분을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0009(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Region Code
		CodeUtil codeUtil = CodeUtil.getInstance();
		Collection<CodeInfo> codeList1 = codeUtil.getCodeSelect("CD02169", 0);
		String rgnSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList1), BizComUtil.CODE_DELIMITTER);

		// Inter or Ocean
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00206", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("rgn_combo", rgnSheetList[0]);
		eventResponse.setETCData("ioc", stljbSheetList[0]);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : Open
	 * 화면 오픈시 Carrier Code List, Revenue Dir. 리스트를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0010(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}

	/**
	 * 공통 : Make
	 * list를 Combo용 String으로 변환한다.
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString(List<JooCodeInfoVO> list, int flg)
			throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO) iterator.next();
			// 일반적인 IBCombo용(name, code|)
			if (flg == 0) {
				sb.append(jooCodeInfoVO.getName() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드부분(code|)
			} else if (flg == 2) {
				sb.append(jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드명부분(name|)
			} else if (flg == 3) {
				sb.append(jooCodeInfoVO.getName() + "|");
				// SuperCd조회
			} else if (flg == 4) {
				sb.append(jooCodeInfoVO.getSuperCd1() + ","
						+ jooCodeInfoVO.getSuperCd2() + ","
						+ jooCodeInfoVO.getCode() + "|");
			} else if (flg == 5) {
				sb.append(jooCodeInfoVO.getCode() + "\t"
						+ jooCodeInfoVO.getName() + "|");
			} else if (flg == 6) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getName() + "|");
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}

	/**
	 * List를 combo용 String으로
	 *
	 * @param list
	 * @param flg
	 * @return String
	 * @throws EventException
	 */
	private String makeComboString5(List<JooCodeInfoVO> list, int flg)
			throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();
		int allChk = 1;

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO) iterator.next();
			// 일반적인 IBCombo용(name, code|)
			if (flg == 0) {
				sb.append(jooCodeInfoVO.getName() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				if (allChk == 1) {
					sb.append("ALL,ALL|");
					allChk++;
				}
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드부분(code|)
			} else if (flg == 2) {
				sb.append(jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드명부분(name|)
			} else if (flg == 3) {
				sb.append(jooCodeInfoVO.getName() + "|");
				// SuperCd조회
			} else if (flg == 4) {
				sb.append(jooCodeInfoVO.getSuperCd1() + ","
						+ jooCodeInfoVO.getSuperCd2() + ","
						+ jooCodeInfoVO.getCode() + "|");
			} else if (flg == 5) {
				sb.append(jooCodeInfoVO.getCode() + "\t"
						+ jooCodeInfoVO.getName() + "|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}
    /**
     * FNS_JOO_0030 : Retrieve
     * D : [FnsJoo0060Event]<br>
     * 월별 추정실적을 마감정보 조회한다.
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
	private EventResponse searchAccrualClosing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0030Event event = (FnsJoo0030Event) e;
		JooEstmClzVO vo = event.getJooEstmClzVO();

		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		List<JooEstmClzVO> list = command.searchAccrualClosing(vo, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0030 : Save
     * 월별 추정실적을 마감정보를 저장한다.
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
	private EventResponse modifyAccrualClosing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0030Event event = (FnsJoo0030Event) e;
		JooEstmClzVO[] vos = event.getJooEstmClzVOS();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();

		try {
			begin();
			command.modifyAccrualClosing(vos, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0032 : Retrieve
	 * Estimate Report - Account을 조회합니다.<br>
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchAccrualListByAccount(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0032Event event = (FnsJoo0032Event) e;
    		ActRsltRVO vo = event.getActRsltRVO();
    		List<ActRsltRVO> list = command.searchAccrualListByAccount(vo);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
     * FNS_JOO_0024, FNS_JOO_0069 : Retrieve
     * CSR Approval 화면 CSR Detail이 나타나는 화면이다
     *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchDetailSlipList(Event e)
			throws EventException {
	    try{
    		// PDTO(Data Transfer Object including Parameters)
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		FnsJoo0024Event event = (FnsJoo0024Event) e;
    		SlipConditionVO vo = event.getSlipConditionVO();
    		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
    		List<SlipVO> list = command.searchDetailSlipList(vo);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0022 : Retrieve
	 * CSR Approval 대상 List를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchConsultationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0022Event event = (FnsJoo0022Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		CsrVO csrVO = event.getCsrVO();
		//2010.01.28 => 권한때문에 Office코드를 넣는다.
		csrVO.setSlpOfcCd(account.getOfc_cd());
		//2010.01.29 => Approval Step 때문에 User Id를 넣는다.
		csrVO.setCreUsrId(account.getUsr_id());
		List<CsrVO> list = command.searchConsultationList(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0023 : Retrieve
	 * CSR No.로 CSR Approval 대상 한건을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDetailConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0023Event event = (FnsJoo0023Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		CsrVO csrVO = event.getCsrVO();
		csrVO.setAuthOfcCd(account.getOfc_cd()); //권한
		csrVO.setCreUsrId (account.getUsr_id()); //결재라인
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<CsrVO> list = command.searchDetailConsultation(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0023 : Approval
	 * CSR승인 처리를 한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse approvalConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0023Event event = (FnsJoo0023Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			String key = command.approvalConsultation(csrVOs[0], account);
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * FNS_JOO_0073 : Retrieve
     * MCS & Invoice Mail 송부 시 수신인 및 참조 수신인을 선택위한 조회.
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPersonInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0073Event event = (FnsJoo0073Event) e;
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<JooCntcMbrVO> list = command.searchPersonInfo(event.getJoCrrCd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0018 : Retrieve
	 * AP CSR Creation Evidence 조회한다. (CSR No.가 parameter로 넘어오는 경우)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPEvidenceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0018Event event = (FnsJoo0018Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		TaxGrpVO grpVO = command.searchAPEvidence(event.getCsrNo());
		List<JooTaxVO> jooTaxVOs = grpVO.getJooTaxVOs();
		List<JooTaxDtlVO> jooTaxDtlVOs = grpVO.getJooTaxDtlVOs();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(jooTaxDtlVOs);
		eventResponse.setRsVoList(jooTaxVOs);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0018 : Retreive
	 * Vendor 정보 조회한다.(CSR No.가 parameter로 넘어오지 않는 경우 - 입력모드)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCreateAPEvidenceList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0018Event event = (FnsJoo0018Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<JooTaxVO> list = command.searchVendorInfo(event.getVndrSeq());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0070:Retrieve
	 * MCS & Invoice Letter Creation List를 조회하는
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLetterSendList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		FnsJoo0070Event event = (FnsJoo0070Event) e;
		InvMcsLetterVO vo = event.getLetterVO();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<InvMcsLetterVO> list = command.searchLetterSendList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0018 : 화면 Open
	 * 화면 Open시 전표번호에 입력될 Office List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0018(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		List<JooCodeInfoVO> list = command.searchTaxOfcList(jooCodeParamVO);

		String ofcCombo = makeComboString(list, 1);

		eventResponse.setETCData("ofc_list", ofcCombo);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0070 : 화면 Open
	 * 화면 Open시 Carrier Code List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0070(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier Code List조회
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = ",|" + makeComboString(list, 1);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0037 : Retrieve
     * 공동운항 실적 데이터를 이용하여 Trade 단위로 필요한 조건을 부여하여 Report 조회
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSummaryOfMcsListByTrade(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0037Event event = (FnsJoo0037Event) e;
		McsStatusVO mcsStatusVO = event.getMcsStatusVO();

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		//2010.08.02 화면에서 조회조건으로 받는다.
		//mcsStatusVO.setOfcCd(  this.account.getOfc_cd()  );
		List<McsStatusVO> list = command.searchSummaryOfMcsListByTrade(mcsStatusVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
    /**
     * FNS_JOO_0037 : Open
     * 공동운항 실적 데이터를 이용하여 Trade 단위로  조회용 옵션 Trade Code List
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0037(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            String ofcCd = this.account.getOfc_cd();

    		//Office Code 조회
    		String offCombo = "";
    		if ("SELADG".equals(ofcCd)){
    			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
    			offCombo = " ,|"+makeComboString(list1, 1);
    		}else{
    			offCombo = ofcCd+","+ofcCd;
    		}

            eventResponse.setETCData("office", offCombo);

            // Trade code  조회
            jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
            List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0036 : 화면 Open
     * 화면오픈시 Carrier, Settlement Item, Dir., Status를 조회한다.
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchTradeCodeList(Event e) throws EventException {
         try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            // Trade code  조회
            jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
            List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0036 : 화면 Open
     * 화면오픈시 Office Code 를 조회한다.
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0036(Event e) throws EventException {
         try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            String ofcCd = this.account.getOfc_cd();

    		//Office Code 조회
    		String offCombo = "";
    		if ("SELADG".equals(ofcCd)){
    			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
    			offCombo = " ,|"+makeComboString(list1, 1);
    		}else{
    			offCombo = ofcCd+","+ofcCd;
    		}

            eventResponse.setETCData("office", offCombo);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }


	/**
     * FNS_JOO_0033 : Retrieve
	 * 추정 관련 Report의 유형 중 MAS (관리회계)용 자료를 보여주는 화면조회
	 *
	 * @param EstmActRsltVO vo
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAccrualListByMAS(Event e)
			throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0033Event event = (FnsJoo0033Event) e;
		ActRsltRVO vo = event.getActRsltRVO();
		List<ActRsltRVO> list = command.searchAccrualListByMAS(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Retrieve
	 * 전표 품의현황을   조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSlipList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0025Event event = (FnsJoo0025Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<CsrSlipVO> list = command.searchSlipList(event
				.getSlipConditionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Open
	 * 화면Open시 Office Code를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0025(Event e) throws EventException {
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		// office code가 SELADG이면 JOO_CSR 의 해당일자의 distinct slp_ofc_cd를 가져오고 그 외는
		// login한 user의 소속 office만 선택할 수 있도록 한다.
		if ("SELADG".equals(ofcCd)){
			SlipConditionVO vo = new SlipConditionVO();
			vo.setGubun("0");
			vo.setFrDt(JSPUtil.getKST("yyyyMMdd"));
			vo.setToDt(JSPUtil.getKST("yyyyMMdd"));

			List<SlipConditionVO> list = command.searchCsrOfcList(vo);

			if (list.isEmpty()) {
				ofcCombo = ofcCd + "," + ofcCd;
			} else {
				StringBuilder sb = new StringBuilder();

				Iterator iterator = (Iterator) list.iterator();

				sb.append("All, |");
				while (iterator.hasNext()) {
					SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
							.next();
					sb.append(slipConditionVO.getSlpOfcCd() + ","
							+ slipConditionVO.getSlpOfcCd() + "|");
				}
				ofcCombo = sb.toString();

				if (ofcCombo.length() > 0)
					ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
			}
		} else {
			ofcCombo = ofcCd + "," + ofcCd;
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		eventResponse.setETCData("ofc_cd", ofcCd);
		// eventResponse.setETCData("ofc_cd", "SELADG");
		return eventResponse;
	}

	/**
	 * FNS_JOO_0025 : Retrieve
	 * Office Code List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCsrOfcList(Event e) throws EventException {
		FnsJoo0025Event event = (FnsJoo0025Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		SlipConditionVO vo = event.getSlipConditionVO();

		List<SlipConditionVO> list = command.searchCsrOfcList(vo);

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		if (list.isEmpty()) {
			ofcCombo = ofcCd + "," + ofcCd;
		} else {
			StringBuilder sb = new StringBuilder();

			Iterator iterator = (Iterator) list.iterator();

			sb.append("All, |");
			while (iterator.hasNext()) {
				SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
						.next();
				sb.append(slipConditionVO.getSlpOfcCd() + ","
						+ slipConditionVO.getSlpOfcCd() + "|");
			}
			ofcCombo = sb.toString();

			if (ofcCombo.length() > 0)
				ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		return eventResponse;
	}

	/**
	 * List를 combo용 String으로
	 *
	 * @param List<CustCdNmVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString2(List<CustCdNmVO> list, int flg)
			throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			CustCdNmVO custCdNmVO = (CustCdNmVO) iterator.next();
			// 일반적인 IBCombo용(name, code|)
			if (flg == 0) {
				sb.append(custCdNmVO.getName() + "," + custCdNmVO.getCode()
						+ "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				sb.append(custCdNmVO.getCode() + "," + custCdNmVO.getCode()
						+ "|");
				// IBSheet의 코드부분(code|)
			} else if (flg == 2) {
				sb.append(custCdNmVO.getCode() + "|");
				// IBSheet의 코드명부분(name|)
			} else if (flg == 3) {
				sb.append(custCdNmVO.getName() + "|");
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}

	/**
	 * List를 combo용 String으로
	 *
	 * @param List<CarrierSeqVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString3(List<CarrierSeqVO> list, int flg)
			throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			CarrierSeqVO carrierSeqVO = (CarrierSeqVO) iterator.next();
			// 일반적인 IBCombo용(name, code|)
			if (flg == 0) {
				sb.append(carrierSeqVO.getName() + "," + carrierSeqVO.getCode()
						+ "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				sb.append(carrierSeqVO.getCode() + "," + carrierSeqVO.getCode()
						+ "|");
				// IBSheet의 코드부분(code|)
			} else if (flg == 2) {
				sb.append(carrierSeqVO.getCode() + "|");
				// IBSheet의 코드명부분(name|)
			} else if (flg == 3) {
				sb.append(carrierSeqVO.getName() + "|");
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}


	/**
	 * FNS_JOO_0066 : Open
	 * 화면오픈시 Carrier, Revenue Dir., Inter/Ocean, Sub Conti 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0066(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		String ofcCd = this.account.getOfc_cd();
        jooCodeParamVO.setOfcCd( ofcCd );

		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		List<JooCodeInfoVO> list1 = command.searchCarrierByLaneList(ofcCd);


		String crrCombo = makeComboString(list, 1);
		String crrSheet = makeComboString(list, 2);
		String rlaneSheet = makeComboString(list1, 0);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("jo_crr_cd_sheet", crrSheet);
		eventResponse.setETCData("rlane_cd_sheet", rlaneSheet);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0067 : Open
	 * 화면오픈시 Carrier, Revenue Dir., Inter/Ocean, Sub Conti 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0067(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
        //jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
		List<JooCodeInfoVO> list = command
				.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);

		String crrCombo = makeComboString5(list, 1);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0066 : Customer Code 입력
	 * Customer Name 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustCdNm(Event e) throws EventException {
		FnsJoo0066Event event = (FnsJoo0066Event) e;

		// PDTO(Data Transfer Object including Parameters)
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustCdNmVO custCdNmVO = event.getCustCdNmVO();

		String car = (String) custCdNmVO.getJoCrrCd();

		List<CustCdNmVO> list = command.searchCustCdNm(car);

		String comboList = makeComboString2(list, 1);
		eventResponse.setETCData("customer_code", comboList);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0066 : Get
	 * 공동운항 Partner 정보를 관리용 seq 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierSeq(Event e) throws EventException {
		FnsJoo0066Event event = (FnsJoo0066Event) e;

		// PDTO(Data Transfer Object including Parameters)
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CarrierSeqVO carrierSeqVO = event.getCarrierSeqVO();

		String car = (String) carrierSeqVO.getJoCrrCd();
		String customer = (String) carrierSeqVO.getCustomerCode();

		List<CarrierSeqVO> list = command.searchCarrierSeq(car, customer);

		String comboList = makeComboString3(list, 1);
		eventResponse.setETCData("crr_cntc_seq", comboList);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0066 : Get
     * 공동운항 Partner 정보를 관리용 Member 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMemberInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0066Event event = (FnsJoo0066Event) e;
		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		CustMemberVO custMemberVO = event.getCustMemberVO();

		//custCdInfoVO = command.searchMemberInfo(car, seq);
		List<CustMemberVO> list = command.searchMemberInfo(custMemberVO);

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
     * FNS_JOO_0066 : Save
     * JO Member Information  저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMemberInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0066Event event = (FnsJoo0066Event) e;
		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		try{
			begin();
			command.manageMemberInfo(event.getCustMemberVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * FNS_JOO_0067:Retrieve<br>
	 * 공동운항 Partner 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCarrierMemberInfo(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0067Event event = (FnsJoo0067Event) e;
		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		CustMemberVO custMemberVO = event.getCustMemberVO();

		List<CustMemberVO> list = command.searchMemberInfo(custMemberVO);

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0036 : Retrieve
	 * Summary of Monthly Clearance Status by Carrier Search
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSummaryOfMcsListByCarrier(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0036Event event = (FnsJoo0036Event) e;
		McsStatusVO vo = event.getMcsStatusVO();

		//권한 때문에 OFFICE CODE를 SET
		//2010.08.02 화면에서 조회조건으로 받는다.
		//vo.setOfcCd(account.getOfc_cd());
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<McsStatusVO> list = command.searchSummaryOfMcsListByCarrier(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0059, FNS_JOO_0061 : Retrieve
	 * MCS Letter의 사용 용도에 따른 용도로 관리용 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooLtrTmpltVO jooLtrTmpltVO = null;
		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
			FnsJoo0059Event event = (FnsJoo0059Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
		} else {
			FnsJoo0061Event event = (FnsJoo0061Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
		}

		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		String joLtrTpCd = (String) jooLtrTmpltVO.getJoLtrTpCd() == null ? ""
				: (String) jooLtrTmpltVO.getJoLtrTpCd();
		String ofcCd = (String) jooLtrTmpltVO.getOfcCd() == null ? ""
				: (String) jooLtrTmpltVO.getOfcCd();
		String joTmpltNo = (String) jooLtrTmpltVO.getJoTmpltNo() == null ? ""
				: (String) jooLtrTmpltVO.getJoTmpltNo();

		jooLtrTmpltVO = command.searchTemplate(joLtrTpCd, ofcCd, joTmpltNo);
		if(jooLtrTmpltVO != null){
			Map<String, String> mapVO = jooLtrTmpltVO.getColumnValues();
			eventResponse.setETCData(mapVO);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061 : SAVE
     * MCS Letter의 사용 용도에 따른 Text 부분을 Wording 후 저장
     *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooLtrTmpltVO jooLtrTmpltVO = null;
		String copy = "";
		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
			FnsJoo0059Event event = (FnsJoo0059Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
			copy = event.getCopy();
		} else {
			FnsJoo0061Event event = (FnsJoo0061Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
			copy = event.getCopy();
		}

		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		try {
			begin();

			/*
			 * byte[] n1stStmtCtnt = jooLtrTmpltVO.getN1stStmtCtnt().getBytes();
			 * byte[] n2ndStmtCtnt = jooLtrTmpltVO.getN2ndStmtCtnt().getBytes();
			 * byte[] n3rdStmtCtnt = jooLtrTmpltVO.getN3rdStmtCtnt().getBytes();
			 *
			 * if (n1stStmtCtnt.length > 200) {
			 * jooLtrTmpltVO.setN1stStmtCtnt(new String(n1stStmtCtnt, 0, 200));
			 * } else { jooLtrTmpltVO.setN1stStmtCtnt(new String(n1stStmtCtnt,
			 * 0, n1stStmtCtnt.length)); } if (n2ndStmtCtnt.length > 200) {
			 * jooLtrTmpltVO.setN2ndStmtCtnt(new String(n2ndStmtCtnt, 0, 200));
			 * } else { jooLtrTmpltVO.setN2ndStmtCtnt(new String(n2ndStmtCtnt,
			 * 0, n2ndStmtCtnt.length)); } if (n1stStmtCtnt.length > 200) {
			 * jooLtrTmpltVO.setN3rdStmtCtnt(new String(n3rdStmtCtnt, 0, 200));
			 * } else { jooLtrTmpltVO.setN3rdStmtCtnt(new String(n3rdStmtCtnt,
			 * 0, n3rdStmtCtnt.length)); }
			 */
			LetterVO rstVo = command.createTemplate(jooLtrTmpltVO, copy, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());

	        String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
	        String ofcCd     = jooLtrTmpltVO.getOfcCd();
	        String userId    = this.account.getUsr_id();

	        List<JoTmpltNoVO> list = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);


	        eventResponse.setRsVoList(list);
            eventResponse.setETCData("NEW_JO_TMPLT_NO", rstVo.getJoTmpltNo() );
            eventResponse.setETCData("NEW_JO_LTR_TMPLT_SEQ", rstVo.getJoLtrTmpltSeq() );

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061:Delete
     * MCS Letter의 사용 용도에 따른 Text 부분 삭제
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooLtrTmpltVO jooLtrTmpltVO = null;
		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
			FnsJoo0059Event event = (FnsJoo0059Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
		} else {
			FnsJoo0061Event event = (FnsJoo0061Event) e;
			jooLtrTmpltVO = event.getJooLtrTmpltVO();
		}

		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		try {
			begin();
			String joLtrTpCd = (String) jooLtrTmpltVO.getJoLtrTpCd() == null ? ""
					: (String) jooLtrTmpltVO.getJoLtrTpCd();
			String ofcCd = (String) jooLtrTmpltVO.getOfcCd() == null ? ""
					: (String) jooLtrTmpltVO.getOfcCd();
			String joTmpltNo = (String) jooLtrTmpltVO.getJoTmpltNo() == null ? ""
					: (String) jooLtrTmpltVO.getJoTmpltNo();

			command.removeTemplate(joLtrTpCd, ofcCd, joTmpltNo);
			eventResponse.setUserMessage(new ErrorHandler("JOO10005").getUserMessage()  );
			commit();

	        /***************************************************************************
	         * User Nm Of TextNo  List
	         *
	         ***************************************************************************/
	         joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
	               ofcCd     = jooLtrTmpltVO.getOfcCd();
	        String userId    = this.account.getUsr_id();

	        List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
	        eventResponse.setRsVoList(textNoList);

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0059, FNS_JOO_0061 USER_ID: CHANGE
	 * Letter Template Combo용 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTempalteTextNoList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JoTmpltNoVO joTmpltNoVO = null;
		if (e.getEventName().equalsIgnoreCase("FnsJoo0059Event")) {
			FnsJoo0059Event event = (FnsJoo0059Event) e;
			joTmpltNoVO = event.getJoTmpltNoVO();
		} else {
			FnsJoo0061Event event = (FnsJoo0061Event) e;
			joTmpltNoVO = event.getJoTmpltNoVO();
		}

		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		String joLtrTpCd = joTmpltNoVO.getJoLtrTpCd() == null ? ""
				: joTmpltNoVO.getJoLtrTpCd(); // "M";
		String ofcCd = joTmpltNoVO.getOfcCd() == null ? "" : joTmpltNoVO
				.getOfcCd(); // account.getOfc_cd();
		String userId = joTmpltNoVO.getUserId() == null ? "" : joTmpltNoVO
				.getUserId();

		List<JoTmpltNoVO> list = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);

		eventResponse.setRsVoList( list );
		return eventResponse;
	}



	/**
	 * FNS_JOO_0039 : Retrieve
     * D : [FNS_JOO_0039] <br>
     *  Monthly Clearance Status by Carrier &amp; Lane - Retrieve 합니다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMccListByCarNLane(Event e)
			throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0039Event event = (FnsJoo0039Event) e;
		StlConditionVO stlConditionVO = event.getStlConditionVO();

		stlConditionVO.setOfcCd(  this.account.getOfc_cd() );
		List<McsVO> list         = command.searchMcsListByCarNLane( event.getStlConditionVO()  );
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
    /**
     * FNS_JOO_0039 : Retrieve
     * D : [FNS_JOO_0039] <br>
     *  Monthly Clearance Status by Carrier &amp; Lane - Click Retrieve 합니다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
     */
    private EventResponse searchMccDtlListByCarNLane(Event e)
            throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
        FnsJoo0039Event event = (FnsJoo0039Event) e;

        List<McsVO> list = command.searchMccDtlListByCarNLane(event.getStlConditionVO(),  event.getJooSettlementVOs() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
        
	/**
	 * FNS_JOO_0029 : Retrieve
	 * Estimate Performance Creation - Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJointOperationAccrualList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;

		List<EstmActRsltVO> list = null;
		list = command.searchJointOperationAccrualList(event.getSettlementConditionVO());
		eventResponse.setRsVoList(list);
		//첫page인 경우만 total값을 조회한다.
		if ("1".equals(event.getSettlementConditionVO().getPageNo())){
			event.getSettlementConditionVO().setSearchGubun("1");	// 1:Retrieve, 2:Target Retrieve 3:I/F Retrieve
			EstmActRsltVO estmActRsltVO = command.searchJointOperationAccrualTotal(event.getSettlementConditionVO());
			eventResponse.setETCData("estm_amt", estmActRsltVO.getEstmAmt());
			eventResponse.setETCData("act_amt" , estmActRsltVO.getActAmt ());
			eventResponse.setETCData("accl_amt", estmActRsltVO.getAcclAmt());
			eventResponse.setETCData("tot_cnt" , estmActRsltVO.getDiffAmt());						// 전체 개수
			eventResponse.setETCData("tot_page_cnt" , estmActRsltVO.getTotPageCnt());		// 페이지 개수			
		}

		return eventResponse;
	}
	
	
	/**
	 * FNS_JOO_0029 : Retrieve(ERP)
	 * Estimate Performance Creation - Retrieve(ERP)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJointOperationAccrualERP(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;

		List<EstmActRsltVO> list = null;
		list = command.searchJointOperationAccrualERP(event.getSettlementConditionVO());
		eventResponse.setRsVoList(list);
		//첫page인 경우만 total값을 조회한다.
		if ("1".equals(event.getSettlementConditionVO().getPageNo())){
			EstmActRsltVO estmActRsltVO = command.searchJointOperationAccrualERPTotal(event.getSettlementConditionVO());
			eventResponse.setETCData("estm_amt", estmActRsltVO.getEstmAmt());
			eventResponse.setETCData("act_amt" , estmActRsltVO.getActAmt ());
			eventResponse.setETCData("accl_amt", estmActRsltVO.getAcclAmt());
			eventResponse.setETCData("tot_cnt" , estmActRsltVO.getDiffAmt());						// 전체 조회 건수
			eventResponse.setETCData("tot_page_cnt" , estmActRsltVO.getTotPageCnt());		// 페이지 개수
		}

		return eventResponse;
	}	

	/**
	 * FNS_JOO_0029 : Save
	 * D : [FnsJoo0029Event] <br>
	 * [Estimate Performance Creation]을 [Save]합니다. <br>
	 *
	 * @param FnsJoo0029Event
	 * @return EventResponse
	 * @throws EventException
	 * @author jang kang cheol
	 */
	private EventResponse manageJointOperationAccrual(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;

		try {
			begin();
			String key = command.manageJointOperationAccrual(event.getEstmActRsltVOs(), event.getSettlementConditionVO(), this.account);
			eventResponse.setETCData("key", key);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : Create
	 * D : [FnsJoo0029Event]<br>
	 * [Estimate Performance Creation]을 [Create]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author jang kang cheol
	 */
	private EventResponse createJointOperationAccrual(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			SettlementConditionVO settlementConditionVO = event.getSettlementConditionVO();
			settlementConditionVO.setUsrId(account.getUsr_id());
			String key = command.createJointOperationAccrual(settlementConditionVO, account);
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * FNS_JOO_0029 : Create 대상 조회
	 * D : [FnsJoo0029Event]<br>
	 * [Estimate Performance Creation]을 [Create]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author jang kang cheol
	 */
	private EventResponse calJointOperationAccrual(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			SettlementConditionVO settlementConditionVO = event.getSettlementConditionVO();
			String key = command.calJointOperationAccrual(settlementConditionVO, account);
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0029 : I/F
	 * D : [FnsJoo0029Event]<br>
	 * [Estimate Performance Creation]을 [I/F]합니다.<br>
	 *
	 * @param FnsJoo0029Event
	 * @return EventResponse
	 * @throws EventException
	 * @author jang kang cheol
	 */
	private EventResponse sendJointOperationAccrualERP(Event e)
			throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String key = command.sendJointOperationAccrualERP(event.getEstmActRsltVOs(), event.getSettlementConditionVO(), this.account);
			eventResponse.setETCData("key", key);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : Inter/Ocean 변경
	 * Inter port / Ocean 변경시 단가를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaSltPrcForOusRdr(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event) e;

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchBsaSltPrc(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String bsaSltPrc = null;

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			bsaSltPrc = voOut.getBsaSltPrc();
		}
		eventResponse.setETCData("bsa_slt_prc", bsaSltPrc);
		return eventResponse;
	}

	/**
	 * FNS_JOO_003401 : Retrieve
	 * D : [FnsJoo003401Event]<br>
	 * [Estimate Code Check - Carrier]을 [조회Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchEstdCarCheckList(Event e) throws EventException {
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		FnsJoo003401Event event = (FnsJoo003401Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<EstdCarVO> list = command.searchEstdCarCheckList(event.getYearMm());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_003402 : Retrieve
	 * D : [FnsJoo003402Event]<br>
	 * [Estimate Code Check - VVD]을 [조회Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchEstdVvdCheckList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo003402Event event = (FnsJoo003402Event) e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		List<EstdVvdVO> list = command.searchEstdVvdCheckList(event.getEstdVvdVO() );
    		eventResponse.setRsVoList(list);
    		return eventResponse;

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0065 : Retrieve
	 * D : [FnsJoo0065Event]<br>
	 * [MCS & Invoice Letter Fax/E-mail Inquiry]을 [조회Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchLetterSendStsList(Event e)
			throws EventException {
	    try{
        		JointOperationLetterBC command = new JointOperationLetterBCImpl();
        		FnsJoo0065Event event = (FnsJoo0065Event) e;
        		GeneralEventResponse eventResponse = new GeneralEventResponse();
        		List<LetterVO> list = command.searchLetterSendStsList(event.getOfccd(),
				event.getUserid(), event.getFmdt(), event.getTodt());
        		eventResponse.setRsVoList(list);
        		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

	}


	/**
	 * FNS_JOO_0060 : Get
	 * D : [FnsJoo0060Event]<br>
	 * [MCS Letter Information Creation의 Text No]을 [조회 Get Text No. OnFocus
	 * Out]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchMcsLetter(Event e) throws EventException {
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		FnsJoo0060Event event = (FnsJoo0060Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<McsLetterVO> list     = command.searchMcsLetter( event.getLetterVO() );
        List<McsLetterVO> carrlist = command.searchToCustList( event.getJocrrcd()  );
		eventResponse.setRsVoList(list);
        eventResponse.setRsVoList(carrlist);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0060 : Retrieve
	 * D : [FnsJoo0060Event]<br>
	 * [MCS Letter Information Creation의 Text No]을 [조회 Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchMcsCombined(Event e) throws EventException {
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		FnsJoo0060Event event = (FnsJoo0060Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<McsCombinedVO> list = command.searchMcsCombined(event.getMcsCombinedVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
    /**
     * FNS_JOO_0060 : Saved Retrieve
     * D : [FnsJoo0060Event]<br>
     * [MCS Letter Information Creation]을 [조회 Saved Retrieve]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchMcsSavedCombined(Event e) throws EventException {
        JointOperationLetterBC command = new JointOperationLetterBCImpl();

        FnsJoo0060Event event = (FnsJoo0060Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<LetterVO> jooLetterList  = command.searchJooLetter(event.getLetterVO() );
        List<LetterVO> jooLtrStlList  = command.searchJooLtrStl(event.getLetterVO() );

        String carCd = "";
        if(jooLetterList.size() > 0){
            carCd = ((LetterVO)jooLetterList.get(0)).getJoCrrCd();
        }

        LetterVO letterVO = null;
        if(jooLetterList.size() > 0){
            letterVO = jooLetterList.get(0);
            eventResponse.setETCData(letterVO.getColumnValues());
        }
        eventResponse.setRsVoList(jooLtrStlList);//Grid Dtl
        List<McsLetterVO> carrlist    = command.searchToCustList( carCd  );  //Eng Nm

        eventResponse.setRsVoList(carrlist);

        return eventResponse;
    }
    /**
     * FNS_JOO_0062 : Saved Retrieve
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation]을 [조회 Saved Retrieve]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchInvoiceSavedCombined(Event e) throws EventException {
        JointOperationLetterBC command = new JointOperationLetterBCImpl();

        FnsJoo0062Event event = (FnsJoo0062Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        List<LetterVO> jooLetterList          = command.searchJooLetter(event.getLetterVO() );
        List<InvoiceCombinedVO> jooLtrStlList = command.searchSavedJooLtrStl(event.getInvoiceCombinedVO());


        String jo_crr_cd = "";
        if(jooLetterList.size() > 0){
            jo_crr_cd = ((LetterVO)jooLetterList.get(0)).getJoCrrCd();
        }

        LetterVO letterVO = null;
        if(jooLetterList.size() > 0){
            letterVO = jooLetterList.get(0);
            eventResponse.setETCData( letterVO.getColumnValues() );
        }
        eventResponse.setRsVoList(jooLtrStlList);
        List<McsLetterVO> carrlist    = command.searchToCustList( jo_crr_cd  );

        eventResponse.setRsVoList(carrlist);

        return eventResponse;
    }
	/**
	 * FNS_JOO_0060 : Save
	 * D : [FnsJoo0060Event]<br>
	 * [MCS Letter Information Creation의 Text No]을 [Save]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse manageMcsLetter(Event e) throws EventException {
		JointOperationLetterBC command = new JointOperationLetterBCImpl();
		FnsJoo0060Event event = (FnsJoo0060Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			LetterVO letterVo = command.manageMcsLetter(event.getLetterVO(), event.getLetterVOs(), this.account);
			eventResponse.setETCData("jo_ltr_seq", letterVo.getJoLtrSeq());
            eventResponse.setETCData("jo_ltr_no", letterVo.getJoLtrNo()  );

            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * FNS_JOO_0060 : Send
     * D : [FnsJoo0060Event]<br>
     * [MCS Letter Information Creation]을 [Send]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
	private EventResponse sendMcsLetter(Event e) throws EventException {
	    try{
    		JointOperationLetterBC command = new JointOperationLetterBCImpl();
    		FnsJoo0060Event event          = (FnsJoo0060Event) e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

            begin();
                LetterVO letterVO = event.getLetterVO();
                letterVO.setUsrId( this.account.getUsr_id() );
                command.sendMcsLetter(letterVO);
                eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), null);
                eventResponse.setUserMessage(new ErrorHandler("JOO10006").getUserMessage());
            commit();
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * FNS_JOO_0010 : VVD변경
	 * VVD입력시 포트등의 정보와 COA에서 1stBSA + Swap TEU, WGT, WGT per TEU정보를 가져온다
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPriceAndPortList(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;

		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchOusTdrFnl(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		String fnlHjsBsaQty = "0";
		String fnlBsaWgt = "0";
		String bsaPerWgt = "0";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			Iterator iterator = list.iterator();
			ProcSettlementVO voOut = (ProcSettlementVO) iterator.next();

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();
			fnlHjsBsaQty = voOut.getFnlHjsBsaQty();
			fnlBsaWgt = voOut.getFnlBsaWgt();
			bsaPerWgt = voOut.getBsaPerWgt();
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);
		eventResponse.setETCData("fnl_hjs_bsa_qty", fnlHjsBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt", fnlBsaWgt);
		eventResponse.setETCData("bsa_per_wgt", bsaPerWgt);

		//Port를 조회한다.
		JOOFindCodeAndCheckBC command1 = new JOOFindCodeAndCheckBCImpl();

		// parameter 정의
		// super_cd1 => rlane_cd
		// super_cd2 => VVD (VSL_CD,SKD_VOY_NO,SKD_DIR_CD 9자리)
		JooCodeParamVO jooCodeParamVO = event.getJooCodeParamVO();
		List<JooCodeInfoVO> list1 = command1.searchUnitCostPortList(jooCodeParamVO);

		// select List 정의
		// CODE => PORT
		// NAME => ETD
		String portList = makeComboString(list1, 2);

		eventResponse.setETCData("portList", portList);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : From Port 변경시
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOusTdrUsedSlot(Event e) throws EventException {
		FnsJoo0010Event event = (FnsJoo0010Event) e;

		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchOusTdrUsedSlot(event.getProcSettlementVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String usdSltBsaQty = "0";
		String usdSltWgt = "0";
		String fnlHjsBsaQty = "0";
		String fnlBsaWgt = "0";

		if (list.size() == 0) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			usdSltBsaQty = voOut.getUsdSltBsaQty();
			usdSltWgt    = voOut.getUsdSltWgt();
			fnlHjsBsaQty = voOut.getFnlHjsBsaQty();
			fnlBsaWgt    = voOut.getFnlBsaWgt();
		}
		eventResponse.setETCData("usd_slt_bsa_qty", usdSltBsaQty);
		eventResponse.setETCData("usd_slt_wgt"    , usdSltWgt);
		eventResponse.setETCData("fnl_hjs_bsa_qty", fnlHjsBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt"    , fnlBsaWgt);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0010 : To Port 변경시 Price 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOusTdrUsedSlotPrice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			FnsJoo0010Event event = (FnsJoo0010Event) e;

			// PDTO(Data Transfer Object including Parameters)
			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

			List<ProcSettlementVO> list = command.searchOusTdrUsedSlotPrice(event.getProcSettlementVO());


			String bsaSltPrc = "0";

			if (list.size() == 0) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else if (list.size() > 1) {
				eventResponse.setETCData("CHECKVVD", "T");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				ProcSettlementVO voOut = list.get(0);

				bsaSltPrc = voOut.getBsaSltPrc();
			}
			eventResponse.setETCData("bsa_slt_prc", bsaSltPrc);
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0038 : Retrieve
	 * D : [FnsJoo0038Event]<br>
	 * [Summary of Monthly Clearance Status by VVD]을 [조회 Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchSummaryOfMcsListByVVD(Event e)
			throws EventException {
	    CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0038Event event = (FnsJoo0038Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		McsStatusVO mcsStatusVO = event.getMcsStatusVO();
		mcsStatusVO.setOfcCd(account.getOfc_cd());
		
		
		
		eventResponse.setRsVoList(command.searchSummaryOfMcsListByVVD(mcsStatusVO) );
		eventResponse.setRsVoList(command.searchSummaryOfMcsListBySumVVD(mcsStatusVO) );
		return eventResponse;
	}

	/**
	 * FNS_JOO_0042 : Retrieve
	 * D : [FnsJoo0042Event]<br>
	 * [Slot Exchange Status by Lane & Partner->Finance Lane]을 [조회 Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchSlotXchStatusListByFinanceLane(Event e)
			throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0042Event event = (FnsJoo0042Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotXchLaneVO slotXchLaneVO= event.getSlotXchLaneVO();
		slotXchLaneVO.setOfcCd(  this.account.getOfc_cd() );
		eventResponse.setRsVoList(command.searchSlotXchStatusListByFinanceLane(  slotXchLaneVO )  );
		return eventResponse;
	}

	/**
	 * FNS_JOO_0043 : Retrieve
	 * D : [FnsJoo0043Event]<br>
	 * [ Slot Exchange Status by Lane & Partner->Finance Partner]을 [조회
	 * Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchSlotXchStatusListByFinancePartner(Event e)
			throws EventException {

	    CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0043Event event = (FnsJoo0043Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotXchPartnerVO  slotXchPartnerVO   = event.getSlotXchPartnerVO();
		slotXchPartnerVO.setOfcCd( this.account.getOfc_cd() );
		slotXchPartnerVO.setReDivrCd( "R" );
		eventResponse.setRsVoList(command.searchSlotXchStatusListByFinancePartner(  slotXchPartnerVO ));
        slotXchPartnerVO.setReDivrCd( "E" );
        eventResponse.setRsVoList(command.searchSlotXchStatusListByFinancePartner(  slotXchPartnerVO   ));

		return eventResponse;
	}

	/**
	 * FNS_JOO_0049 : Retrieve
	 * D : [FnsJoo0049Event]<br>
	 * [ Settlement Status for Basic Allocation]을 [조회 Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchStlStatusListForBSA(Event e)
			throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0049Event event = (FnsJoo0049Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StlConditionVO stlConditionVO = event.getStlConditionVO();
		//stlConditionVO.setOfcCd(this.account.getOfc_cd() );
		eventResponse.setRsVoList(command.searchStlStatusListForBSA(stlConditionVO));
		return eventResponse;
	}

	/**
	 * FNS_JOO_0050 : Retrieve
	 * D : [FnsJoo0050Event]<br>
	 * [ Target Voyage vs Unsettled Status]을 [조회 Retrieve]합니다.<br>
	 *
	 * @param Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchTgtVoyVsUnstlStatusList(Event e)
			throws EventException {
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0050Event event = (FnsJoo0050Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(command.searchTgtVoyVsUnstlStatusList(event.getStlConditionVO()));
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Open
	 * R/F Surcharge Creation의 open시 Combo등에 필요한 Code List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0011(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		// Revenue Direction
		CodeUtil codeUtil = CodeUtil.getInstance();

		// Inter or Ocean
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00206", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		// R/T/U
		Collection<CodeInfo> codeList3 = codeUtil.getCodeSelect("CD01868", 0);
		String rtuSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList3), BizComUtil.CODE_DELIMITTER);

		// RGN
		Collection<CodeInfo> codeList4 = codeUtil.getCodeSelect("CD02169", 0);
		String rgnSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList4), BizComUtil.CODE_DELIMITTER);

		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
		procSettlementVO.setReDivrCd("R");
		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("ioc", stljbSheetList[0]);
		eventResponse.setETCData("rtu", rtuSheetList[0]);
		eventResponse.setETCData("rgn", rgnSheetList[0]);
		eventResponse.setETCData("ioc_nm", stljbSheetList[1]);
		eventResponse.setETCData("rtu_nm", rtuSheetList[1]);
		eventResponse.setETCData("rgn_nm", rgnSheetList[1]);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : Retrieve
	 * R/F surcharge를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchSettlementRFList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : POD변경
	 * R/F Surcharge의 POD변경시 단가를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsedReeferList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0011Event event = (FnsJoo0011Event) e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<SettlementRFVO> list = command.searchUsedReeferList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String usdSltBsaQty20 = "0";
		String usdSltBsaQty40 = "0";
		String rfScgPrc20     = "0";
		String rfScgPrc40     = "0";

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		}else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			SettlementRFVO voOut = list.get(0);

			usdSltBsaQty20 = voOut.getUsdSltBsaQty20();
			usdSltBsaQty40 = voOut.getUsdSltBsaQty40();
			rfScgPrc20     = voOut.getRfScgPrc20();
			rfScgPrc40     = voOut.getRfScgPrc40();
		}

		eventResponse.setETCData("usd_slt_bsa_qty_20",usdSltBsaQty20);
		eventResponse.setETCData("usd_slt_bsa_qty_40",usdSltBsaQty40);
		eventResponse.setETCData("rf_scg_prc_20",rfScgPrc20);
		eventResponse.setETCData("rf_scg_prc_40",rfScgPrc40);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0045 : Retrieve
	 * Slot Hire의 Adjust내역을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAdjustSlotHireStlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0045Event event = (FnsJoo0045Event) e;
		AdjustConditionVO vo = event.getAdjustConditionVO();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<AdjustSettlementVO> list = command.searchAdjustSlotHireStlList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
		procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
		procSettlementVO.setReDivrCd(vo.getReDivrCd());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0045 : Open
	 * 화면 Open시 combo에 setting할 Code정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0045(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		CodeUtil codeUtil = CodeUtil.getInstance();
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);

		return eventResponse;
	}

	/**
	 * FNS_JOO_0045 : Save
	 * S/H 의 Adjust내역을 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAdjustSlotHireStl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0045Event event = (FnsJoo0045Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();

		try {
			begin();
			//COA에만 있고 JOO에 존재하지 않는 경우 target VVD를 강제생성한다.
			command1.manageTargetVVDForAdjustment(event.getAdjustSettlementVOS(), account);
			command.manageAdjustSlotHireStl(event.getAdjustSettlementVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Open
	 * Combined Monthly Clearance Creation & inquiry의 화면 open시에 combo에 setting할 Code를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0016(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		CodeUtil codeUtil = CodeUtil.getInstance();
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0016 : Retrieve
	 * Combined Number를 선택하고 조회하는 경우 Combined된 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedMonthlyClearanceList(Event e) throws EventException {
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());
		CombinedGrpVO grpVO = command.searchCombinedMonthlyClearanceList(cmbConditionVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(grpVO.getJooSettlementVOs());
		eventResponse.setRsVoList(grpVO.getCombinedVOs());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Retrieve
	 * Combined Number를 선택하지 않고 조회한 경우 Rlane List만을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedRlaneList(Event e) throws EventException {
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());// Office별 Carrier-lane 권한때문에
		List<JooSettlementVO> list = command.searchCombinedRlaneList(cmbConditionVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Retrieve
	 * Combined Number를 선택하지 않고 조회한 Rlane List를 선택하는 경우 해당 Rlane 들의 Adjust 대상 내역을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombinedMonthlyClearanceByLaneList (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
		cmbConditionVO.setOfcCd(account.getOfc_cd());// Office별 Carrier-lane 권한때문에
		List<CombinedVO> list = command.searchCombinedMonthlyClearanceByLaneList (cmbConditionVO);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0016 : Save
	 * Combine 처리한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCombinedMonthlyClearance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();

		try {
			begin();
			int stlCmbSeq = command.manageCombinedMonthlyClearance(event.getCmbConditionVO(), event.getCombinedVOS(), account);
			command1.manageCombinedMonthlyClearance(event.getCombinedVOS(), account);
			eventResponse.setETCData("stl_cmb_seq",stlCmbSeq+"");
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0016 : Delete
	 * Combined 취소 처리
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeCombinedMonthlyClearance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0016Event event = (FnsJoo0016Event)e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();

		try {
			begin();
			command .removeCombinedMonthlyClearance(event.getCmbConditionVO(), account);
			command1.removeCombinedMonthlyClearance(event.getCombinedVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0017 : Open
	 * AP CSR Creation open시 Combo에 setting할 Code정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0017(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		CodeUtil codeUtil = CodeUtil.getInstance();
		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01745", 0);
		String evidTp[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		Collection<CodeInfo> codeList3 = codeUtil.getCodeSelect("CD01228", 0);
		String csrTp[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList3), BizComUtil.CODE_DELIMITTER);

		String locDateTime = command.searchLocalDateTime(account.getOfc_cd());

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("evidTpCode", evidTp[0]);
		eventResponse.setETCData("evidTpName", evidTp[1]);
		eventResponse.setETCData("csrTpCode" , csrTp[0]);
		eventResponse.setETCData("csrTpName" , csrTp[1]);
		eventResponse.setETCData("localDate" , locDateTime);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0017 : Retrieve
	 * AP CSR정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPConsultation(Event e) throws EventException {
		FnsJoo0017Event event = (FnsJoo0017Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		List<SlipProcessVO> list = command.searchAPConsultation(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0017 : Save
	 * AP CSR정보를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createAPConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0017Event event = (FnsJoo0017Event)e;

		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

//		JooTaxVO[] jooTaxVOs = event.getJooTaxVOs();
//		JooTaxDtlVO[] jooTaxDtlVOs = event.getJooTaxDtlVOs();
//		JooTaxDtlVO jooTaxDtlVO = null;			 
//		String sw = "1"; 
		
		try {						 
////			log.debug("sw = "+sw);
//			if (jooTaxVOs == null || jooTaxDtlVOs == null){
//				sw = "2";
//			}else{				
//				for (int i=0; i < jooTaxVOs.length; i++){						
//					if("".equals(jooTaxVOs[0].getSplAmt()) || jooTaxVOs[0].getSplAmt() == null || 
//							Integer.parseInt(jooTaxVOs[0].getSplAmt()) == 0 || Integer.parseInt(jooTaxVOs[0].getTtlAmt()) == 0){				
////						log.debug("jooTaxVOs[0].getSplAmt() = "+jooTaxVOs[0].getSplAmt());						
//						sw = "2";		
//					}																																			
//					
//					jooTaxDtlVO = jooTaxDtlVOs[i];					
//					if("".equals(jooTaxDtlVO.getSplAmt()) || jooTaxDtlVO.getSplAmt() == null || 
//							Integer.parseInt(jooTaxDtlVO.getSplAmt()) == 0 || Integer.parseInt(jooTaxDtlVO.getTtlAmt()) == 0){
////						log.debug("jooTaxDtlVO.getSplAmt() = "+jooTaxDtlVO.getSplAmt());						
//						sw = "2";						
//					}										
//				}
//			}
//			
//			if("1".equals(sw)){
				begin();			
				String csrNo = command.createAPConsultation(event.getSlipProcessVOS(), event.getJooTaxVOs(), event.getJooTaxDtlVOs(), account);
				eventResponse.setETCData("csr_no",csrNo);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
//			}else{
//				eventResponse.setETCData("sw",sw);				
//				eventResponse.setETCData("csr_no","");
//			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0017 : Eff.Date변경
	 * Eff.Date변경시에 해당일자로 마감이 되었는지 여부를 check한다.
	 * O : Open - 마감 전임으로 그대로 Effective Date를 사용한다.
   	 * C : Closing - 마감이 완료되었으면 다음달 첫일로 Effective Date를 넣어준다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAPClosYn(Event e) throws EventException {
		FnsJoo0017Event event = (FnsJoo0017Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		SlipProcessVO slipProcessVO = command.searchCloseYn(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("clos_yn",slipProcessVO.getVvdCxlFlg());
		eventResponse.setETCData("eff_dt" ,slipProcessVO.getEffDt());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Eff.Date변경
	 * Eff.Date변경시에 해당일자로 마감이 되었는지 여부를 check한다.
	 * O : Open - 마감 전임으로 그대로 Effective Date를 사용한다.
   	 * C : Closing - 마감이 완료되었으면 다음달 첫일로 Effective Date를 넣어준다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchARClosYn(Event e) throws EventException {
		FnsJoo0020Event event = (FnsJoo0020Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		SlipProcessVO slipProcessVO = command.searchCloseYn(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("clos_yn",slipProcessVO.getVvdCxlFlg());
		eventResponse.setETCData("eff_dt" ,slipProcessVO.getEffDt());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Open
	 * AR CSR Creation 화면 open시 Carrier정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0020(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		String locDateTime = command.searchLocalDateTime(account.getOfc_cd());

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("localDate" , locDateTime);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Retrieve
	 * AR CSR 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchARConsultation(Event e) throws EventException {
		FnsJoo0020Event event = (FnsJoo0020Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		List<SlipProcessVO> list = command.searchAPConsultation(event.getSlipProcessVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0020 : Save
	 * AR CSR 정보를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createARConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0020Event event = (FnsJoo0020Event)e;

		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		String csrNo = "";
		try {
			begin();
			csrNo = command.createARConsultation(event.getSlipProcessVOS(), account);
			commit();
			eventResponse.setETCData("csr_no",csrNo);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * FNS_JOO_0039 : Open <br>
     * Monthly Clearance by Carrier & Lane의 Carrier정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0039(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 조회
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     * FNS_JOO_0019 :Open<br>
     * Monthly Clearance Inquiry중 Carrier Code List를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0015(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 조회
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( list );
        return eventResponse;
    }
    /**
     * FNS_JOO_0015 : Retrieve<br>
     * Monthly Clearance by Carrier & Lane의 Carrier정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchMonthlyClearanceList(Event e) throws EventException {

        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
        FnsJoo0015Event event = (FnsJoo0015Event)e;

        StlConditionVO stlConditionVO = event.getStlConditionVO();
        stlConditionVO.setOfcCd(   this.account.getOfc_cd() );

        List<SettlementVO> list = command.searchMonthlyClearanceList( stlConditionVO );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    /**
     * FNS_JOO_0068 : Retrieve
     * CSR Inquiry Detail을 조회한다.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchCsrDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0068Event event = (FnsJoo0068Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		CsrVO csrVO = event.getCsrVO();
		csrVO.setCreUsrId (account.getUsr_id());
		csrVO.setAuthOfcCd(account.getOfc_cd());
		List<CsrVO> list = command.searchCsrDetail(csrVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0068 : Reverse
	 * 오류전표를 취소처리한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse reverseConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0068Event event = (FnsJoo0068Event) e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			//2010.03.22 SETTLEMENT CMB_CFM_FLG = 'N'으로 수정하는 것에서 SETTLEMENT COPY하는 것으로 변경됨
			List<JooStlCmbDtlVO> jooStlCmbDtlVOs = command.reverseConsultation(csrVOs[0], account);
			command1.createReverseSettlement (jooStlCmbDtlVOs, account);
			//2012.04.24 SETTLEMENT 에 insert한 STL_SEQ값을 JOO_STL_CMB_DTL의 STL_SEQ 값에 UPDATE 한다.
			//command1.updateReverseCMBDTL (jooStlCmbDtlVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
    /**
     * FNS_JOO_0038:Open <br>
     * Summary of Monthly Clearance Status by VVD의 Carrier정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0038(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        // Carrier 조회
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> carrlist = command.searchCarrierCodeList(jooCodeParamVO);
        List<JooCodeInfoVO> stlitmlist = command.searchSettlementItemCodeList(jooCodeParamVO);
        eventResponse.setRsVoList( carrlist   );
        eventResponse.setRsVoList( stlitmlist );
        return eventResponse;
    }
    /**
     * FNS_JOO_0049 : Open
     * D : [FnsJoo0049Event]<br>
     * [ Settlement Status for Basic Allocation]을 조회위해 Open시 Trd_cd [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0049(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}

        // Trd_cd 조회
        //jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
        //List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
        //2010.03.24 권한 필요없음 => 박효숙 차장
        List<JooCodeInfoVO> list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        eventResponse.setRsVoList( list  );
        eventResponse.setETCData("office", offCombo);
        return eventResponse;
    }
    /**
     * FNS_JOO_0050 : Open <br>
     *  Target Voyage vs Unsettled Status 의 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0050(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        String ofcCd = this.account.getOfc_cd();

		// Carrier 조회
        jooCodeParamVO.setOfcCd( ofcCd );
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		String crrCombo = makeComboString(list, 1);

		// Trade 조회
		list = command.searchTradeCodeList(jooCodeParamVO);
		String trdCombo = makeComboString(list, 1);

		// Rlane 조회
		list = command.searchRlaneCodeList(jooCodeParamVO);
		String laneCombo = makeComboString(list, 1);

		// ABBR 조회
		list = command.searchStlItemCodeList(jooCodeParamVO);
		String abbrCombo = makeComboString(list, 1);

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			list = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}

		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("trd_cd"    , trdCombo);
		eventResponse.setETCData("rlane_cd"  , laneCombo);
		eventResponse.setETCData("jo_stl_itm_cd", abbrCombo);
		eventResponse.setETCData("office", offCombo);
        return eventResponse;
    }
    /**
     * FNS_JOO_0040 :Retrieve<br>
     * Slot Exchange Status by Lane & Partner->Space On Lane 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchSlotXchStatusListBySpaceLane(Event e) throws EventException {

        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
        FnsJoo0040Event event = (FnsJoo0040Event)e;
        SlotXchLaneVO slotXchLaneVO = event.getSlotXchLaneVO();
        slotXchLaneVO.setOfcCd( this.account.getOfc_cd() );
        List<SlotXchLaneVO> list = command.searchSlotXchStatusListBySpaceLane( event.getSlotXchLaneVO()  );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    /**
     * FNS_JOO_0041 : Retrieve<br>
     * Slot Exchange Status by Lane & Partner->Space On Partner 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchSlotXchStatusListBySpacePartner(Event e) throws EventException {
        try{
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            FnsJoo0041Event event = (FnsJoo0041Event)e;

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            SlotXchPartnerVO  slotXchPartnerVO   = event.getSlotXchPartnerVO();
            slotXchPartnerVO.setOfcCd( this.account.getOfc_cd()  );
            slotXchPartnerVO.setReDivrCd( "R" );
            eventResponse.setRsVoList(command.searchSlotXchStatusListBySpacePartner(  slotXchPartnerVO ));
            slotXchPartnerVO.setReDivrCd( "E" );
            eventResponse.setRsVoList(command.searchSlotXchStatusListBySpacePartner(  slotXchPartnerVO   ));

            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     *  FNS_JOO_0060 : Open <br>
     *  Target Voyage vs Unsettled Status 의 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0060(Event e) throws EventException {
        try{
            FnsJoo0060Event event = (FnsJoo0060Event)e;

            JOOFindCodeAndCheckBC    command  = new JOOFindCodeAndCheckBCImpl();
            JointOperationLetterBC  command2  = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            // Carrier 조회searchMcsTextNo
            jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
            List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
            List<TextNoVO> textNoList      = command2.searchMcsTextNo( event.getLetterVO() );


            eventResponse.setRsVoList( carrlist   );
            eventResponse.setRsVoList( textNoList );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     *  FNS_JOO_0062 : Open <br>
     *  Invoice Letter Information Creation Open시 Invoice TextNo, Carrier Code를  조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0062(Event e) throws EventException {
        try{
            FnsJoo0062Event event = (FnsJoo0062Event)e;

            JOOFindCodeAndCheckBC    command  = new JOOFindCodeAndCheckBCImpl();
            JointOperationLetterBC  command2  = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            // Carrier 조회searchMcsTextNo
            jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
            List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
            List<TextNoVO> textNoList = command2.searchInvoiceTextNo(  event.getLetterVO() );
            eventResponse.setRsVoList( carrlist   );
            eventResponse.setRsVoList( textNoList );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0062 : Get
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get Text No. OnFocus
     * Out]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchInvoiceLetter(Event e) throws EventException {
        try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            FnsJoo0062Event event      = (FnsJoo0062Event) e;
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            List<InvoiceCombinedVO> list     = command.searchInvoiceLetter( event.getLetterVO() );
            List<McsLetterVO> carrlist = command.searchToCustList( event.getJocrrcd()  );
            eventResponse.setRsVoList(list);
            eventResponse.setRsVoList(carrlist);

            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0062 : Retrieve
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation의 Text No]을 [조회 Retrieve]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchInvoiceCombined(Event e) throws EventException {

            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            FnsJoo0062Event event = (FnsJoo0062Event) e;
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            List<InvoiceCombinedVO> list = command.searchInvoiceCombined(event.getInvoiceCombinedVO());
            eventResponse.setRsVoList(list);
            return eventResponse;

    }

    /**
     * FNS_JOO_0062 : Send
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation]을 [Send]합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse sendInvoiceLetter(Event e) throws EventException {
        try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            FnsJoo0062Event event = (FnsJoo0062Event) e;
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            begin();
                LetterVO letterVO = event.getLetterVO();
                letterVO.setUsrId( this.account.getUsr_id() );

                command.sendInvoiceLetter( letterVO );
                eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), null);
                eventResponse.setUserMessage(new ErrorHandler("JOO10006").getUserMessage());
            commit();
            return eventResponse;
        } catch (EventException ex) {
            this.rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            this.rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

    }
    /**
     * FNS_JOO_0062 : Save
     * D : [FnsJoo0062Event]<br>
     * Invoice Letter Information Creation을 생성합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse createInvoiceLetter(Event e) throws EventException {
        JointOperationLetterBC command = new JointOperationLetterBCImpl();
        FnsJoo0062Event event = (FnsJoo0062Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            begin();

            LetterVO letterVo = command.manageInvoiceLetter (event.getLetterVO(), event.getLetterVOs(), this.account);
            eventResponse.setETCData("jo_ltr_seq", letterVo.getJoLtrSeq());
            eventResponse.setETCData("jo_ltr_no", letterVo.getJoLtrNo()  );

            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            commit();
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

    }

    /**
     * FNS_JOO_0055 : Retrieve <br>
     * RDR Upload Inquiry 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang chang su
     */
    private EventResponse searchLaneCdYn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0054Event event54 =  null;
        FnsJoo0055Event event55 =  null;
        String lane_cd = "";
		if (e.getEventName().equalsIgnoreCase("FnsJoo0054Event")){
		    event54 = (FnsJoo0054Event)e;
		    lane_cd = event54.getTdrByLaneVO().getSlanCd();
        }
        if (e.getEventName().equalsIgnoreCase("FnsJoo0055Event")){
            event55 = (FnsJoo0055Event)e;
            lane_cd = event55.getRdrByLaneVO().getSlanCd();
        }
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		String vslSlanCd = null;
		try{
		    MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		    mdmVslSvcLaneVO.setVslSlanCd( lane_cd );
		    mdmVslSvcLaneVO.setOfcCd(  this.account.getOfc_cd() );
			List<MdmVslSvcLaneVO> list = command.searchLaneCdYn (mdmVslSvcLaneVO);

			//eventResponse.setRsVoList(list);
			if(list.size()>0){
				vslSlanCd= list.get(0).getVslSlanCd();
			}else{
				vslSlanCd = "";
			}

			eventResponse.setETCData("vslSlanCd", vslSlanCd);


        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0054 :  Retrieve <br>
     * TDR Cration Inquiry 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang chang su
     */
    private EventResponse searchTDRCreateListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0054Event event = (FnsJoo0054Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try{

			String fromDt = event.getTdrByLaneVO().getFromDt();
			fromDt = fromDt.substring(0, 4)+ fromDt.substring(5, 7)+ fromDt.substring(8, 10);

			String toDt = event.getTdrByLaneVO().getToDt();
			toDt = toDt.substring(0, 4)+ toDt.substring(5, 7)+ toDt.substring(8,10);

			String lane = event.getTdrByLaneVO().getSlanCd();

			List<TdrByLaneVO> list = command.searchTDRCreateListByLane (fromDt ,toDt ,lane);
			//log.debug("::CALL::> FNS_TOT_0054 SC 그리드 조회끝> :::::::::");
			eventResponse.setRsVoList(list);

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0055: Retrieve  <br>
     * RDR Upload Inquiry 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang chang su
     */
    private EventResponse searchRDRCreateListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0055Event event = (FnsJoo0055Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try{

			String fromDt = event.getRdrByLaneVO().getFromDt();
			fromDt = fromDt.substring(0, 4)+ fromDt.substring(5, 7)+ fromDt.substring(8, 10);

			String toDt = event.getRdrByLaneVO().getToDt();
			toDt = toDt.substring(0, 4)+ toDt.substring(5, 7)+ toDt.substring(8,10);

			String lane = event.getRdrByLaneVO().getSlanCd();
			log.debug("fromDt : "+fromDt+"   toDt : "+toDt+" lane : "+lane);
			List<RdrByLaneVO> list = command.searchRDRCreateListByLane (fromDt ,toDt ,lane);
			//log.debug("::CALL::> FNS_TOT_0055 SC 그리드 조회끝> :::::::::");
			eventResponse.setRsVoList(list);

        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * FNS_JOO_0029 : Open
     * Trade, Carrier, Lane Code Combo조회
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0029(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		String exeYrmon = "";
		// 마감여부 조회
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
			jooCodeParamVO.setSuperCd1(exeYrmon);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);

		EstmConditionVO estmConditionVO = new EstmConditionVO();

		estmConditionVO.setExeYrmon  (exeYrmon);
		estmConditionVO.setReDivrCd  ("");
		estmConditionVO.setRevYrmonFr("");
		estmConditionVO.setRevYrmonTo("");

		//Trade Code List 조회
		List<EstmConditionVO> list = command.searchTradeCodeListEstm(estmConditionVO);

		String trdCombo = makeEstmComboString(list, 0);

		//Rlane Code List 조회
		list = command.searchRlaneCodeListEstm(estmConditionVO);
		String laneCombo = makeEstmComboString(list, 1);

		//Carrier Code List 조회
		list = command.searchCarrierCodeListEstm(estmConditionVO);
		String crrCombo = makeEstmComboString(list, 2);

//		CodeUtil codeUtil = CodeUtil.getInstance();

//		// BSA Type - JOINT OPERATION, LEASE, ADDITIONAL, Over Used, 20FT, 40FT
//		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
//		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);

		// VVD Type - RV, PV, BV
//		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD00943", 0);
//		String vvdTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("EXE_YRMON" , exeYrmon);
		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("trd_cd"    , trdCombo);
		eventResponse.setETCData("rlane_cd"  , laneCombo);
//		eventResponse.setETCData("stl_jb_combo", stljbSheetList[0]);
//		eventResponse.setETCData("stl_jb_comnm", stljbSheetList[1]);
//		eventResponse.setETCData("estm_vvd_tp_cd", vvdTpCd[0]);
		eventResponse.setETCData("estm_clz_flg"  , jooCodeInfoVO.getCode());
		return eventResponse;
	}

    /**
     * FNS_JOO_0029 : Retrieve
     * Estimate Performance Creation 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCond0029(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0029Event event = (FnsJoo0029Event)e;

		EstmConditionVO estmConditionVO = event.getEstmConditionVO();

		String estmCondFlg = estmConditionVO.getEstmCondFlg();

		List<EstmConditionVO> list = null;

		String estmClzFlg = "N";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		//0074 에서는 필요한 조건이었으나 0029에서는 사용안함
		estmConditionVO.setRevYrmonFr("");
		estmConditionVO.setRevYrmonTo("");

		switch (Integer.parseInt(estmCondFlg)){
			//exe_yrmon이나 re_divr_cd가 변경된경우
			case 1 :
				JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
				jooCodeParamVO.setSuperCd1(estmConditionVO.getExeYrmon());
				JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);
				estmClzFlg = jooCodeInfoVO.getCode();
			//rev_yrmon period가 변경된 경우
			case 2 :
				//Trade Code List 조회
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
			//trad변경된경우
			case 3 :
				//Rlane Code List 조회
				list = command.searchRlaneCodeListEstm(estmConditionVO);
				laneCombo = makeEstmComboString(list, 1);
			//lane변경된경우
			case 4 :
				//Carrier Code List 조회
				list = command.searchCarrierCodeListEstm(estmConditionVO);
				crrCombo = makeEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("estm_clz_flg", estmClzFlg);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}


    /**
     * FNS_JOO_0074 : Open
     * E-NIS의 BSA 계획 데이터와 공동운항의 실적 데이터를 이용하여 추정실적 산출자료를 조회중
     *   Trade, Carrier, Lane Combo 조회.
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0074(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String exeYrmon = "";
		// 마감여부 조회
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		EstmConditionVO estmConditionVO = new EstmConditionVO();
		estmConditionVO.setExeYrmon(exeYrmon);

		//Revenue Month From~To 조회하기
		List<EstmConditionVO> list = command.searchRevYrmonFrTo(estmConditionVO);

		String revYrmonFr = exeYrmon;
		String revYrmonTo = exeYrmon;

		if (!list.isEmpty()){
			if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
				revYrmonFr = list.get(0).getRevYrmonFr();
			}

			if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
				revYrmonTo = list.get(0).getRevYrmonTo();
			}
		}

		estmConditionVO.setRevYrmonFr(revYrmonFr);
		estmConditionVO.setRevYrmonTo(revYrmonTo);

		//Trade Code List 조회
		list = command.searchTradeCodeListEstm(estmConditionVO);

		String trdCombo = makeEstmComboString(list, 0);

		//Rlane Code List 조회
		list = command.searchRlaneCodeListEstm(estmConditionVO);
		String laneCombo = makeEstmComboString(list, 1);

		//Carrier Code List 조회
		list = command.searchCarrierCodeListEstm(estmConditionVO);
		String crrCombo = makeEstmComboString(list, 2);

		CodeUtil codeUtil = CodeUtil.getInstance();

		// BSA Type
		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);
		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

		String code = "";
		StringBuilder bsaTypeCdTmp = new StringBuilder();
		StringBuilder bsaTypeNmTmp = new StringBuilder();
		for (int i=0; i<bsaTypeCd.length; i++){
			code = bsaTypeCd[i].substring(0,1);
			if ("1".equals(code)){
				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
			}
		}

		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

		eventResponse.setETCData("EXE_YRMON"   , exeYrmon);
		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		eventResponse.setETCData("STL_JB_COMBO", bsaTpCd);
		eventResponse.setETCData("STL_JB_COMNM", bsaTpNm);
		return eventResponse;
	}

	/**
	 * EstmConditionVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<EstmConditionVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeEstmComboString(List<EstmConditionVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			EstmConditionVO estmConditionVO = (EstmConditionVO)iterator.next();

			if (flg==0){
				sb.append(estmConditionVO.getTrdCd()+"|");
			}else if (flg==1){
				sb.append(estmConditionVO.getRlaneCd()+"|");
			}else if (flg==2){
				sb.append(estmConditionVO.getJoCrrCd()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}


	/**
	 * FNS_JOO_0074 : Retrieve
	 * Estimate Performance Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstmPerformanceList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0074Event event = (FnsJoo0074Event) e;

    		List<EstmActRsltVO> list = null;
    		list = command.searchEstmPerformanceList(event.getEstmConditionVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}


    /**
     * FNS_JOO_0074 : Retrieve
     * 조건변경시
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0074Event event = (FnsJoo0074Event)e;

		EstmConditionVO estmConditionVO = event.getEstmConditionVO();

		String estmCondFlg = estmConditionVO.getEstmCondFlg();

		List<EstmConditionVO> list = null;

		String revYrmonFr = "";
		String revYrmonTo = "";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		switch (Integer.parseInt(estmCondFlg)){
			//exe_yrmon이나 re_divr_cd가 변경된경우
			case 1 :
				list = command.searchRevYrmonFrTo(estmConditionVO);

				revYrmonFr = estmConditionVO.getExeYrmon();
				revYrmonTo = estmConditionVO.getExeYrmon();
				if (!list.isEmpty()){
					if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
						revYrmonFr = list.get(0).getRevYrmonFr();
					}

					if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
						revYrmonTo = list.get(0).getRevYrmonTo();
					}
				}
				estmConditionVO.setRevYrmonFr(revYrmonFr);
				estmConditionVO.setRevYrmonTo(revYrmonTo);
			//rev_yrmon period가 변경된 경우
			case 2 :
				//Trade Code List 조회
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
			//trad변경된경우
			case 3 :
				//Rlane Code List 조회
				list = command.searchRlaneCodeListEstm(estmConditionVO);
				laneCombo = makeEstmComboString(list, 1);
			//lane변경된경우
			case 4 :
				//Carrier Code List 조회
				list = command.searchCarrierCodeListEstm(estmConditionVO);
				crrCombo = makeEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}

    /**
     * FNS_JOO_0056 : Open
     * D : [FnsJoo0056Event]<br>
     * [RDR Download by Lane]을 조회위해 Open시 Dir, Region [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0056(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            FnsJoo0056Event event = (FnsJoo0056Event)e;
            RdrLoadVO rdrLoadVO   = event.getRdrLoadVO();
            jooCodeParamVO.setSuperCd1( rdrLoadVO.getSuperCd1() );
            
            //List<JooCodeInfoVO> list = command.searchComCodeList(jooCodeParamVO);
            List<JooCodeInfoVO> list = null;
            if (rdrLoadVO.getSuperCd1().equals("CD02169")) {  // Region은 full name으로 보여준다.
            	list = command.searchComCodeNmList(jooCodeParamVO);
            } else {
            	list = command.searchComCodeList(jooCodeParamVO);
            }
            eventResponse.setRsVoList( list  );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * RDR Carrier Code를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchRDRCarrierCodeString(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0056Event event = (FnsJoo0056Event)e;
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            List<JooCodeInfoVO> list = command.searchRDRCarrierCodeListByPeriodAndRlane (  event.getRdrLoadVO()  );
            //eventResponse.setRsVoList(list);

            StringBuilder comboCode = new StringBuilder();
    		StringBuilder comboText = new StringBuilder();
    		for (int i=0 ; i<list.size(); i++) {
    			comboCode.append(list.get(i).getCode() + "^#^");
    			comboText.append(list.get(i).getCode() + "^#^");  // Code를 그대로 보여준다.
    		}
    		eventResponse.setETCData("comboCode", comboCode.toString());
    		eventResponse.setETCData("comboText", comboText.toString());

    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 을  조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchRDRDownloadListByLane(Event e) throws EventException {
        try{
            // PDTO(Data Transfer Object including Parameters)
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0056Event event = (FnsJoo0056Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<RdrLoadVO> list = command.searchRDRDownloadListByLane (  event.getRdrLoadVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 데이터중 JOO_RDR_VVD_CRR_RMK에 해당하는 값을 저장합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse manageRDRVVDCrrRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	FnsJoo0056Event event = (FnsJoo0056Event)e;
        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try{
			begin();
			command.manageRDRVVDCrrRmk(event.getRdrLoadVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }

    /**
     * FNS_JOO_0053 : Retrieve
     * Other의 VVD입력시 AR_MST_REV_VVD테이블에 REV_YRMON 이 NULL이면 해당 VVD의 SLIP내역을 조회한다.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVVDOfNotExistRevMonList(Event e) throws EventException {
        try{
            // PDTO(Data Transfer Object including Parameters)
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0053Event event = (FnsJoo0053Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<ManualStlVvdVO> list = command.searchVVDOfNotExistRevMonList(event.getProcSettlementVO());
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0057 : Open
     * D : [FnsJoo0057Event]<br>
     * [RDR Download by VVD]을 조회위해 Open시 Direct [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0057(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            FnsJoo0057Event event = (FnsJoo0057Event)e;
            TdrLoadVO tdrLoadVO   = event.getTdrLoadVO();
            jooCodeParamVO.setSuperCd1( tdrLoadVO.getSuperCd1() );

            List<JooCodeInfoVO> list = command.searchComCodeList(jooCodeParamVO);
            eventResponse.setRsVoList( list  );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * TDR Carrier Code를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchTDRCarrierCodeString(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0057Event event = (FnsJoo0057Event)e;
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            List<JooCodeInfoVO> list = command.searchTDRCarrierCodeListByPeriodAndRlane (  event.getTdrLoadVO()  );
            //eventResponse.setRsVoList(list);

            StringBuilder comboCode = new StringBuilder();
    		StringBuilder comboText = new StringBuilder();
    		for (int i=0 ; i<list.size(); i++) {
    			comboCode.append(list.get(i).getCode() + "^#^");
    			comboText.append(list.get(i).getCode() + "^#^");  // Code를 그대로 보여준다.
    		}
    		eventResponse.setETCData("comboCode", comboCode.toString());
    		eventResponse.setETCData("comboText", comboText.toString());

    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchTDRDownloadListByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0057Event event = (FnsJoo0057Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<TdrLoadVO> list = command.searchTDRDownloadListByLane (  event.getTdrLoadVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0059 : Open
     * D : [FnsJoo0059Event]<br>
     * [MCS Letter Information Text Creation]을 조회 위해 Open시
     * Address
     * User Nm 과 n3rd_stmt_ctnt, Signature [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0059(Event e) throws EventException {
        try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            /***************************************************************************
             * Address, n3rd_stmt_ctnt,Signature
             *
             ***************************************************************************/
            JooLtrTmpltVO jooLtrTmpltVO = null;
            FnsJoo0059Event event = (FnsJoo0059Event) e;
            jooLtrTmpltVO = event.getJooLtrTmpltVO();
            String ofcCd = jooLtrTmpltVO.getOfcCd() == null ? "" : jooLtrTmpltVO.getOfcCd(); // account.getOfc_cd();
            JooLtrTmpltVO jooLtrTmpltVOReturn = command.searchTempalteAddress(ofcCd);
            if(jooLtrTmpltVOReturn != null){
                Map<String, String> mapVO = jooLtrTmpltVOReturn.getColumnValues();
                eventResponse.setETCData(mapVO);
            }
            /***************************************************************************
             * User Nm List
             *
             ***************************************************************************/
            LetterVO letterVO = new LetterVO();
            letterVO.setUsrId( this.account.getUsr_id()  );
            letterVO.setOfcCd( ofcCd   );
            letterVO.setJoLtrTpCd(jooLtrTmpltVO.getJoLtrTpCd() );
            List<LetterVO> usrnmlist  = command.searchUserNm(letterVO);
            eventResponse.setRsVoList( usrnmlist  );

            /***************************************************************************
             * User Nm Of TextNo  List
             *
             ***************************************************************************/
            String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
                   ofcCd     = jooLtrTmpltVO.getOfcCd();
            String userId    = this.account.getUsr_id();

            List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
            eventResponse.setRsVoList(textNoList);


            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0061 : Open
     * D : [FnsJoo0061Event]<br>
     * [Invoice Letter Information Text Creation]을 조회 위해 Open시
     * Address
     * User Nm 과 n3rd_stmt_ctnt, Signature [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0061(Event e) throws EventException {
        try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            /***************************************************************************
             * Address, n3rd_stmt_ctnt,Signature
             *
             ***************************************************************************/
            JooLtrTmpltVO jooLtrTmpltVO = null;
            FnsJoo0061Event event = (FnsJoo0061Event) e;
            jooLtrTmpltVO = event.getJooLtrTmpltVO();
            String ofcCd = jooLtrTmpltVO.getOfcCd() == null ? "" : jooLtrTmpltVO.getOfcCd(); // account.getOfc_cd();
            JooLtrTmpltVO jooLtrTmpltVOReturn = command.searchTempalteAddress(ofcCd);
            if(jooLtrTmpltVOReturn != null){
                Map<String, String> mapVO = jooLtrTmpltVOReturn.getColumnValues();
                eventResponse.setETCData(mapVO);
            }
            /***************************************************************************
             * User Nm List
             *
             ***************************************************************************/
            LetterVO letterVO = new LetterVO();
            letterVO.setUsrId( this.account.getUsr_id()  );
            letterVO.setOfcCd( ofcCd   );
            letterVO.setJoLtrTpCd(jooLtrTmpltVO.getJoLtrTpCd() );
            List<LetterVO> usrnmlist  = command.searchUserNm(letterVO);
            eventResponse.setRsVoList( usrnmlist  );

            /***************************************************************************
             * User Nm Of TextNo  List
             *
             ***************************************************************************/
            String joLtrTpCd = jooLtrTmpltVO.getJoLtrTpCd();
                   ofcCd     = jooLtrTmpltVO.getOfcCd();
            String userId    = this.account.getUsr_id();

            List<JoTmpltNoVO> textNoList = command.searchTempalteTextNoList(joLtrTpCd,ofcCd, userId);
            eventResponse.setRsVoList(textNoList);


            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0075 : Open
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 조회위해 Open시 Office Cd [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0075(Event e) throws EventException {
        try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0075Event event = (FnsJoo0075Event)e;

            LetterVO  vo = event.getLetterVO();
            vo.setOfcCd(this.account.getOfc_cd());
            vo.setUsrId( this.account.getUsr_id()  );
            List<LetterVO> offcdlist  = command.searchOfficeCd(  vo );
            List<LetterVO> usrnmlist  = command.searchUserNm(vo);

            eventResponse.setRsVoList( offcdlist  );
            eventResponse.setRsVoList( usrnmlist  );

            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0075 : SEARCH02
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 조회위해  UserNm[조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchUserNm(Event e) throws EventException {
        try{

            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            FnsJoo0075Event event = (FnsJoo0075Event)e;
            List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );

            eventResponse.setRsVoList( usrnmlist  );

            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

    }
    /**
     * FNS_JOO_0075 : SEARCH03
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 조회위해  Text No[조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchTempalteSeqList(Event e)
            throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0075Event event = (FnsJoo0075Event)e;
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            LetterVO  vo  = event.getLetterVO();

            List<LetterVO> list = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
                                                                    JSPUtil.getNull(vo.getOfcCd(), ""),
                                                                    JSPUtil.getNull(vo.getUsrId(), ""));

            eventResponse.setRsVoList( list );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0075 : SEARCH02
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 조회위해  [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchSignNBank(Event e) throws EventException {
       // try{
            JointOperationLetterBC command = new JointOperationLetterBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            FnsJoo0075Event event = (FnsJoo0075Event)e;
            List<LetterVO> list   = command.searchSignNBank(event.getLetterVO());

            eventResponse.setRsVoList( list  );

            return eventResponse;

    }
    /**
     * FNS_JOO_0075 : SAVE
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 저장합니다. .<br>
     *
     * @throws EventException
     * @return EventResponse
     */
    private   EventResponse manageSignNBank(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        FnsJoo0075Event event = (FnsJoo0075Event) e;
        JointOperationLetterBC command = new JointOperationLetterBCImpl();
        try {
            begin();
            LetterVO vo  = event.getLetterVO();
            vo.setCreUsrId( account.getUsr_id() );
            vo.setOfcCd   ( account.getOfc_cd() );
            LetterVO rstVo = command.addSignNBank(  vo );
            commit();


            /* 등록된 USER 조회  */
            List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );
            eventResponse.setRsVoList( usrnmlist  );
            /* 등록된 SEq 조회 */
            List<LetterVO> textnolist = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
                                                                      JSPUtil.getNull(vo.getOfcCd()    , ""),
                                                                      JSPUtil.getNull(vo.getCreUsrId() , ""));
            eventResponse.setRsVoList( textnolist  );
            eventResponse.setETCData("NEW_JO_TMPLT_NO", rstVo.getJoTmpltNo() );
            eventResponse.setETCData("NEW_JO_LTR_TMPLT_SEQ", rstVo.getJoLtrTmpltSeq() );

            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw  ex ;
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

    }
    /**
     * FNS_JOO_0075 : REMOVE
     * D : [FnsJoo0075Event]<br>
     * [Bank detail & Signature]을 조회위해  [삭제]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private   EventResponse removeSignNBank(Event e) throws EventException {
            try{
                GeneralEventResponse eventResponse = new GeneralEventResponse();
                FnsJoo0075Event event = (FnsJoo0075Event) e;
                JointOperationLetterBC command = new JointOperationLetterBCImpl();

                begin();
                LetterVO vo  = event.getLetterVO();
                command.removeSignNBank(  vo );
                commit();


                /* 등록된 USER 조회  */
                List<LetterVO> usrnmlist = command.searchUserNm( event.getLetterVO() );
                eventResponse.setRsVoList( usrnmlist  );
    //            /* 등록된 SEq 조회 */
                List<LetterVO> seqlist = command.searchTempalteSeqList(JSPUtil.getNull(vo.getJoLtrTpCd(), ""),
                                                                          JSPUtil.getNull(vo.getOfcCd()    , ""),
                                                                          JSPUtil.getNull(vo.getCreUsrId() , ""));
                eventResponse.setRsVoList( seqlist  );

                eventResponse.setUserMessage(new ErrorHandler("JOO10005").getUserMessage());

                 return eventResponse;
            } catch (EventException ex) {
                log.error("err " + ex.toString(), ex);
                rollback();
                throw new EventException(ex.getMessage(), ex);
            } catch (Exception ex) {
                rollback();
                log.error("err " + ex.toString(), ex);
                throw new EventException(ex.getMessage(), ex);
            }
    }
	/**
	 * FNS_JOO_0046 : Open
	 * 화면 Open시 combo에 setting할 Code정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0046(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		// Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

		String crrCombo = makeComboString(list, 1);

		eventResponse.setETCData("jo_crr_cd", crrCombo);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0046 : Retrieve
	 * OUS RDR의 Adjust내역을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAdjustOusListForRDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		FnsJoo0046Event event = (FnsJoo0046Event) e;
    		AdjustConditionVO vo = event.getAdjustConditionVO();
    		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
    		List<AdjustOusRDRVO> list = command.searchAdjustOusListForRDR(vo);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw  ex ;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

//	/**
//	 * FNS_JOO_0011 : MULTI
//	 * R/F의 Dup check시에 return값을 SettlementRFVO로 변경
//	 * @param ProcSettlementVO procSettlementVO
//	 * @return SettlementRFVO
//	 * @throws EventException
//	 */
//	private SettlementRFVO setSettlementRFVOUsingProcSettlementVO(ProcSettlementVO procSettlementVO) throws EventException {
//		SettlementRFVO settlementRFVO = new SettlementRFVO();
//		try{
//			settlementRFVO.setIbflag        (procSettlementVO.getIbflag        ());
//			settlementRFVO.setVslCd         (procSettlementVO.getVslCd         ());
//			settlementRFVO.setSkdVoyNo      (procSettlementVO.getSkdVoyNo      ());
//			settlementRFVO.setSkdDirCd      (procSettlementVO.getSkdDirCd      ());
//			settlementRFVO.setRevDirCd      (procSettlementVO.getRevDirCd      ());
//			settlementRFVO.setStlBzcPortCd  (procSettlementVO.getStlBzcPortCd  ());
//			settlementRFVO.setEtaDt         (procSettlementVO.getEtaDt         ());
//			settlementRFVO.setUcBssPortCd   (procSettlementVO.getUcBssPortCd   ());
//			settlementRFVO.setRfScgStlTpCd  (procSettlementVO.getRfScgStlTpCd  ());
//			settlementRFVO.setIocCd         (procSettlementVO.getIocCd         ());
//			settlementRFVO.setScontiCd      (procSettlementVO.getScontiCd      ());
//			settlementRFVO.setFmPortCd      (procSettlementVO.getFmPortCd      ());
//			settlementRFVO.setToPortCd      (procSettlementVO.getToPortCd      ());
//			settlementRFVO.setLoclCurrCd    (procSettlementVO.getLoclCurrCd    ());
//			settlementRFVO.setAcctYrmon     (procSettlementVO.getAcctYrmon     ());
//			settlementRFVO.setStlVvdSeq     (procSettlementVO.getStlVvdSeq     ());
//			settlementRFVO.setTrdCd         (procSettlementVO.getTrdCd         ());
//			settlementRFVO.setJoCrrCd       (procSettlementVO.getJoCrrCd       ());
//			settlementRFVO.setRlaneCd       (procSettlementVO.getRlaneCd       ());
//			settlementRFVO.setReDivrCd      (procSettlementVO.getReDivrCd      ());
//			settlementRFVO.setJoStlItmCd    (procSettlementVO.getJoStlItmCd    ());
//			settlementRFVO.setJoMnuNm       (procSettlementVO.getJoMnuNm       ());
//			settlementRFVO.setUcBssPortEtdDt(procSettlementVO.getUcBssPortEtdDt());
//		}catch(Exception ex){
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//		}
//		return settlementRFVO;
//	}
    /**
     * FNS_JOO_0040 : Open
     * 화면 Open시 combo에 setting할 Trade Code와, Direction Code를 구한다.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0040(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
        jooCodeParamVO.setOfcCd(  this.account.getOfc_cd() );
        List<JooCodeInfoVO> trdlist = command.searchTradeCodeList(jooCodeParamVO);

        jooCodeParamVO.setSuperCd1( "CD00593" );
        List<JooCodeInfoVO> dirlist = command.searchComCodeList(jooCodeParamVO);

        eventResponse.setRsVoList( trdlist  );
        eventResponse.setRsVoList( dirlist  );
        return eventResponse;
    }
    /**
     * FNS_JOO_0041 : Open
     * 화면 Open시 combo에 setting할 Carrier Code와, Direction Code를 구한다.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0041(Event e) throws EventException {

        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
        jooCodeParamVO.setOfcCd( this.account.getOfc_cd() );
        List<JooCodeInfoVO> carrierlist = command.searchCarrierCodeList(jooCodeParamVO);

        jooCodeParamVO.setSuperCd1( "CD00593" );
        List<JooCodeInfoVO> dirlist = command.searchComCodeList(jooCodeParamVO);

        eventResponse.setRsVoList( carrierlist  );
        eventResponse.setRsVoList( dirlist  );
        return eventResponse;
    }

    /**
     * FNS_JOO_0029 : BackEndJob 상태 조회
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchAccrualBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchBakEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0029 : BackEndJob 결과 조회
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	private EventResponse searchAccrualBackEndJobResult(Event e) throws BackEndJobException, EventException {
		String key = (String)e.getAttribute("key");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList((List<EstmActRsltVO>)BackEndJobResult.loadFromFile(key));
		
		FnsJoo0029Event event = (FnsJoo0029Event) e;
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();		
		//첫page인 경우만 total값을 조회한다.
		if ("1".equals(event.getSettlementConditionVO().getPageNo())){
			event.getSettlementConditionVO().setSearchGubun("2");		// 1:Retrieve, 2:Target Retrieve 3:I/F Retrieve
			EstmActRsltVO estmActRsltVO = command.searchJointOperationAccrualTotal(event.getSettlementConditionVO());
			eventResponse.setETCData("estm_amt", estmActRsltVO.getEstmAmt());
			eventResponse.setETCData("act_amt" , estmActRsltVO.getActAmt ());
			eventResponse.setETCData("accl_amt", estmActRsltVO.getAcclAmt());
			eventResponse.setETCData("tot_cnt" , estmActRsltVO.getDiffAmt());						// 전체 개수
			eventResponse.setETCData("tot_page_cnt" , estmActRsltVO.getTotPageCnt());		// 페이지 개수			
		}		
		return eventResponse;
	}

	/**
	 * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014 : VVD(9자리) 변경
	 * @param ProcSettlementVO procSettlementVO
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchRevDirList(procSettlementVO);

		if (list.isEmpty()){
			eventResponse.setETCData("ERR_CD", "E");
		}else{
			eventResponse.setETCData("ERR_CD", "N");
		}

		StringBuilder comboList = new StringBuilder();

		for (int i=0; i < list.size(); i++){
			if (i == list.size()-1){
				comboList.append(list.get(i).getRevDirCd());
			}else{
				comboList.append(list.get(i).getRevDirCd()+"|");
			}
		}

		eventResponse.setETCData("REV_DIR_LIST", comboList.toString());

		return eventResponse;
	}

	/**
	 * FNS_JOO_0009 : RGN 변경
	 * Region 변경시 Used Slot Teu와 WGT를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsedSlotInfo(Event e) throws EventException {
		FnsJoo0009Event event = (FnsJoo0009Event) e;

		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchUsedSlotInfo(event.getProcSettlementVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String fmPortCd     = null;
		String usdSltBsaQty = null;
		String usdSltWgt    = null;
		//2010.03.25 Query 변경으로 RGN변경시 1st BSA TEU, 1st BSA WGT도 같이 가져온다.
		String fnlHjsBsaQty = null;
		String fnlBsaWgt    = null;

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			fmPortCd     = voOut.getFmPortCd();
			usdSltBsaQty = voOut.getUsdSltBsaQty();
			usdSltWgt    = voOut.getUsdSltWgt();
			fnlHjsBsaQty = voOut.getFnlHjsBsaQty();
			fnlBsaWgt    = voOut.getFnlBsaWgt();
		}
		eventResponse.setETCData("fm_port_cd"     , fmPortCd);
		eventResponse.setETCData("usd_slt_bsa_qty", usdSltBsaQty);
		eventResponse.setETCData("usd_slt_wgt"    , usdSltWgt);
		eventResponse.setETCData("fnl_hjs_bsa_qty", fnlHjsBsaQty);
		eventResponse.setETCData("fnl_bsa_wgt"    , fnlBsaWgt);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : I/O Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfIOChange(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			FnsJoo0011Event event = (FnsJoo0011Event) e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			List<SettlementRFVO> list = command.searchRfIOChange(event.getProcSettlementVO());

			StringBuilder ioc        = new StringBuilder();
			StringBuilder rfScgPrc20 = new StringBuilder();
			StringBuilder rfScgPrc40 = new StringBuilder();

			if (list.isEmpty()) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				SettlementRFVO voOut = null;
				for (int i=0; i < list.size(); i++){
					voOut = list.get(i);

					if (i == list.size()-1){
						ioc.append       (voOut.getIocCd     ());
						rfScgPrc20.append(voOut.getRfScgPrc20());
						rfScgPrc40.append(voOut.getRfScgPrc40());
					}else{
						ioc.append       (voOut.getIocCd     ()+"|");
						rfScgPrc20.append(voOut.getRfScgPrc20()+"|");
						rfScgPrc40.append(voOut.getRfScgPrc40()+"|");
					}
				}

			}
			eventResponse.setETCData("ioc_cd"       , ioc.toString());
			eventResponse.setETCData("rf_scg_prc_20", rfScgPrc20.toString());
			eventResponse.setETCData("rf_scg_prc_40", rfScgPrc40.toString());
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0011 : RGN Change
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfRgnChange(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			FnsJoo0011Event event = (FnsJoo0011Event) e;

			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
			List<SettlementRFVO> list = command.searchRfRgnChange(event.getProcSettlementVO());

			StringBuilder fmPortCd = new StringBuilder();
			StringBuilder toPortCd = new StringBuilder();
			StringBuilder usdSltBsaQty20 = new StringBuilder();
			StringBuilder usdSltBsaQty40 = new StringBuilder();

			if (list.isEmpty()) {
				eventResponse.setETCData("CHECKVVD", "E");
			} else {
				eventResponse.setETCData("CHECKVVD", "N");

				SettlementRFVO voOut = null;
				for (int i=0; i < list.size(); i++){
					voOut = list.get(i);

					if (i == list.size()-1){
						fmPortCd.append(voOut.getFmPortCd());
						toPortCd.append(voOut.getToPortCd());
						usdSltBsaQty20.append(voOut.getUsdSltBsaQty20());
						usdSltBsaQty40.append(voOut.getUsdSltBsaQty40());
					}else{
						fmPortCd.append(voOut.getFmPortCd()+"|");
						toPortCd.append(voOut.getToPortCd()+"|");
						usdSltBsaQty20.append(voOut.getUsdSltBsaQty20()+"|");
						usdSltBsaQty40.append(voOut.getUsdSltBsaQty40()+"|");
					}
				}
			}
			eventResponse.setETCData("fm_port_cd", fmPortCd.toString());
			eventResponse.setETCData("to_port_cd", toPortCd.toString());
			eventResponse.setETCData("usd_slt_bsa_qty_20", usdSltBsaQty20.toString());
			eventResponse.setETCData("usd_slt_bsa_qty_40", usdSltBsaQty40.toString());
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * FNS_JOO_0015 : Retrieve<br>
     * Monthly Clearance의 StlCmbSeq List를 조회합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchMonthlyStlCmbSeqList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	        CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
	        FnsJoo0015Event event = (FnsJoo0015Event)e;
	        StlConditionVO stlConditionVO = event.getStlConditionVO();
	        stlConditionVO.setOfcCd(   this.account.getOfc_cd() );
	        List<SettlementVO> list = command.searchMonthlyStlCmbSeqList( stlConditionVO );
	        eventResponse.setRsVoList(list);
    	} catch (EventException ex) {
    		throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
    	}
        return eventResponse;
    }
    /**
     * FNS_JOO_0076 : Retrieve<br>
     * AR정보중 Disabled된 VVD 정보를 조회합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchARDisabledVVD(Event e) throws EventException {

        JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
        FnsJoo0076Event event = (FnsJoo0076Event)e;

        List<ArDisabledVVDVO> list = command.searchARDisabledVVD( event.getArDisabledVVDVO() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    /**
     * FNS_JOO_0077 : Retrieve<br>
     * AR정보를 조회합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchARDataInquiry(Event e) throws EventException {

        JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
        FnsJoo0077Event event = (FnsJoo0077Event)e;

        List<ArDataInqVO> list = command.searchARDataInquiry( event.getArDataInqVO() );
        List<ArDataInqVO> list2 = command.searchARDataInquirySum( event.getArDataInqVO() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        eventResponse.setRsVoList(list);        
        eventResponse.setRsVoList(list2);
        return eventResponse;
    }


    /**
     * FNS_JOO_0078 : Retrieve
     * AP I/F Error list를 조회한다.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchApIfErrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0078Event event = (FnsJoo0078Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<ApIfErrVO> list = command.searchApIfErrList(event.getCsrVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0078 : Reject
	 * 오류전표를 취소처리한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse rejectConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0078Event event = (FnsJoo0078Event) e;
		JointOperationConsultationBC command  = new JointOperationConsultationBCImpl();
		CarrierSettlementProcessBC   command1 = new CarrierSettlementProcessBCImpl  ();
		try {
			begin();
			CsrVO[] csrVOs = event.getCsrVOS();
			//Combined, CSR, SLIP, TAX에 대한 UPDATE / DELTE
			List<JooStlCmbDtlVO> jooStlCmbDtlVOs = command.rejectConsultation(csrVOs[0], account);

			//Settlement의 CMB_CFM_FLG를 N으로 UPDATE한다.
			command1.createReverseSlip(jooStlCmbDtlVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage() );
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


    /**
     * FNS_JOO_0077 : Open
     * 화면 Open시 CarrierCode 와 Office Code Set.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse openFnsJoo0077(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> carrlist = command.searchCarrierCodeListByTradeAndRlane(jooCodeParamVO);
        eventResponse.setRsVoList( carrlist );

        List<JooCodeInfoVO> officelist = command.searchOfcCdSlip(jooCodeParamVO);
        eventResponse.setRsVoList( officelist );
        return eventResponse;
    }


    /**
     * FNS_JOO_0080 : Open
     * 화면 Open시 CarrierCode 와 Office Code Set.
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse openFnsJoo0080(Event e) throws EventException {
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		// office code가 SELADG이면 JOO_CSR 의 해당일자의 distinct slp_ofc_cd를 가져오고 그 외는
		// login한 user의 소속 office만 선택할 수 있도록 한다.
		if ("SELADG".equals(ofcCd)){
			SlipConditionVO vo = new SlipConditionVO();
			vo.setGubun("0");
			vo.setFrDt(JSPUtil.getKST("yyyyMMdd"));
			vo.setToDt(JSPUtil.getKST("yyyyMMdd"));

			List<SlipConditionVO> list = command.searchStlOfcList(vo);

			if (list.isEmpty()) {
				ofcCombo = ofcCd + "," + ofcCd;
			} else {
				StringBuilder sb = new StringBuilder();

				Iterator iterator = (Iterator) list.iterator();

				sb.append("All, |");
				while (iterator.hasNext()) {
					SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
							.next();
					sb.append(slipConditionVO.getSlpOfcCd() + ","
							+ slipConditionVO.getSlpOfcCd() + "|");
				}
				ofcCombo = sb.toString();

				if (ofcCombo.length() > 0)
					ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
			}
		} else {
			ofcCombo = ofcCd + "," + ofcCd;
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		eventResponse.setETCData("ofc_cd", ofcCd);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0080 : 월변경시 해당 월의 office를 조회한다.
	 * Office Code List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlOfcList(Event e) throws EventException {
		FnsJoo0080Event event = (FnsJoo0080Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		SlipConditionVO vo = event.getSlipConditionVO();

		List<SlipConditionVO> list = command.searchStlOfcList(vo);

		String ofcCd = account.getOfc_cd();
		String ofcCombo = "";

		if (list.isEmpty()) {
			ofcCombo = ofcCd + "," + ofcCd;
		} else {
			StringBuilder sb = new StringBuilder();

			Iterator iterator = (Iterator) list.iterator();

			sb.append("All, |");
			while (iterator.hasNext()) {
				SlipConditionVO slipConditionVO = (SlipConditionVO) iterator
						.next();
				sb.append(slipConditionVO.getSlpOfcCd() + ","
						+ slipConditionVO.getSlpOfcCd() + "|");
			}
			ofcCombo = sb.toString();

			if (ofcCombo.length() > 0)
				ofcCombo = ofcCombo.substring(0, ofcCombo.length() - 1);
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("ofc_list", ofcCombo);
		return eventResponse;
	}

	/**
     * FNS_JOO_0080 : Retrieve
     * Settlement되었는데 Combined 되지 않거나 Comined되었으나 CSR생성되지 않은 data를 조회한다.
     * @param Event e
     * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLostCombinedDataList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0080Event event = (FnsJoo0080Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		// 화면단에서 csrNo 를 폼오브젝트에 담아서 받는다
		List<LostCombinedDataVO> list = command.searchLostCombinedDataList(event.getSlipConditionVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
    /**
     * FNS_JOO_0081 :Retrieve<br>
     * Loading Port별 Discharge Port의 Qty 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchDischageForLoading(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            FnsJoo0081Event event = (FnsJoo0081Event)e;
            StringBuffer sql = new StringBuffer();

            LoadingQtyVO loadingQtyVO = event.getLoadingQtyVO() ;
            loadingQtyVO.setOfcCd( this.account.getOfc_cd() );

            DBRowSet dbRowSetHead  = command.searchDischageForLoadingHeader( loadingQtyVO );

            dbRowSetHead.next();
            for(int i=1;i<=dbRowSetHead.getRowCount(); i++ ){

                sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) )), '9', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");

                dbRowSetHead.next();
            }
            loadingQtyVO.setHeaderSql( sql.toString() );
            DBRowSet dbRowSet      = command.searchDischageForLoading( loadingQtyVO );


            dbRowSetHead.beforeFirst();
            eventResponse.setRsVo(dbRowSetHead);
            eventResponse.setRsVo(dbRowSet);


        } catch (EventException ex) {
            throw ex;
        } catch ( Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * FNS_JOO_0081 :Excel DownLoad<br>
     * Loading Port별 Discharge Port의 Qty 정보를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchDischageForLoadingExcel(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            FnsJoo0081Event event = (FnsJoo0081Event)e;
            StringBuffer sql = new StringBuffer();

            LoadingQtyVO loadingQtyVO = event.getLoadingQtyVO() ;
            loadingQtyVO.setOfcCd( this.account.getOfc_cd() );

            DBRowSet dbRowSetHead  = command.searchDischageForLoadingHeader( loadingQtyVO );

            dbRowSetHead.next();
            for(int i=1;i<=dbRowSetHead.getRowCount(); i++ ){

            	sql.append(",      '"+dbRowSetHead.getString("POL_CD")+"' POD"+i+"                                                                                                                                                                                                                                                                                              \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '2', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) AS  POD"+i+"_20_QTY                                                                                       \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '4', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, 2, 1), 1 ) AS POD"+i+"_40_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '5', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) )), '9', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRatehc()+", 1), 1 ) AS POD"+i+"_HC_QTY     \n");
                sql.append(",      SUM(  DECODE( S1.POD_CD, '"+dbRowSetHead.getString("POL_CD")+"', DECODE(SUBSTR(S1.CNTR_TPSZ_CD, 2, 1), '7', DECODE("+ dbRowSetHead.getString("POL_CD_CNT")+"/* HEAD.POL_CD_CNT*/, 1, 1,  DECODE(  FORM.SKD_DIR_CD, '"+dbRowSetHead.getString("SKD_DIR_CD")+"'  /* HEAD.SKD_DIR_CD*/, 1, DECODE(S1.SKD_DIR_CD, DECODE('"+dbRowSetHead.getString("SKD_DIR_CD")+"', 'N', S1.SKD_DIR_CD, 'S', S1.SKD_DIR_CD), 1) ))) ) * DECODE( CNTR_VOL_QTY,0,1,CNTR_VOL_QTY)  ) * DECODE( GROUPING(FORM.POL_CD ), 1,  DECODE( GROUPING(FORM.TYPE ), 1, "+loadingQtyVO.getRate45()+", 1), 1 ) AS POD"+i+"_45_QTY     \n");


                dbRowSetHead.next();
            }
            loadingQtyVO.setHeaderSql( sql.toString() );
            DBRowSet dbRowSet      = command.searchDischageForLoading( loadingQtyVO );


            dbRowSetHead.beforeFirst();
            eventResponse.setRsVo(dbRowSetHead);
            eventResponse.setRsVo(dbRowSet);

        } catch (EventException ex) {
            throw ex;
        } catch ( Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }

    /**
     * FNS_JOO_0017, FNS_JOO_0020 : BackEndJob 상태 조회
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchConsultationBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchBakEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status);
		return eventResponse;
	}

	/**
	 * Account Year Month, R/E 조건을 주면 AP_PERIOD에서 마감여부를 읽어 return한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return String
	 * @throws EventException
	 */
	private String searchCloseYn(ProcSettlementVO procSettlementVO) throws EventException{
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
		jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		return clzYn;
	}

	/**
     * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014, FNS_JOO_0045 : 마감여부 조회
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchCloseYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		ProcSettlementVO procSettlementVO = null;

		if (e instanceof FnsJoo0007Event) {
			procSettlementVO = ((FnsJoo0007Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0009Event) {
			procSettlementVO = ((FnsJoo0009Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0010Event) {
			procSettlementVO = ((FnsJoo0010Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0011Event) {
			procSettlementVO = ((FnsJoo0011Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0012Event) {
			procSettlementVO = ((FnsJoo0012Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0013Event) {
			procSettlementVO = ((FnsJoo0013Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0014Event) {
			procSettlementVO = ((FnsJoo0014Event)e).getProcSettlementVO();
		}else if (e instanceof FnsJoo0016Event) {
			//getCmbConditionVO = ((FnsJoo0016Event)e).getCmbConditionVO();
			
			procSettlementVO = new ProcSettlementVO();
			CmbConditionVO vo = ((FnsJoo0016Event)e).getCmbConditionVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());
			
			
		}else if (e instanceof FnsJoo0017Event) {
			
			procSettlementVO = new ProcSettlementVO();
			SlipProcessVO vo = ((FnsJoo0017Event)e).getSlipProcessVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());
			
			
		}else if (e instanceof FnsJoo0020Event) {
			
			procSettlementVO = new ProcSettlementVO();
			SlipProcessVO vo = ((FnsJoo0020Event)e).getSlipProcessVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());
			
			
			
		}else if (e instanceof FnsJoo0045Event) {
			procSettlementVO = new ProcSettlementVO();
			AdjustConditionVO vo = ((FnsJoo0045Event)e).getAdjustConditionVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());
		}

		if(procSettlementVO != null){		
			jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
			jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
		}
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		eventResponse.setETCData("clz_yn", clzYn);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0012 : S/H의 BSA_TYPE변경시
	 * BSA Type의 Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaTypeValidationCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchBsaTypeValidationCheck(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECK_BSA_TYPE", "E");
		} else {
			eventResponse.setETCData("CHECK_BSA_TYPE", "N");
		}

		return eventResponse;
	}
	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
	 * FNS_JOO_0036 : Save
	 * Remark의 내용을 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSummaryOfMcsListByCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0036Event event = (FnsJoo0036Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try {
			begin();
			//COA에만 있고 JOO에 존재하지 않는 경우 target VVD를 강제생성한다.
			command.manageSummaryOfMcsListByCarrier(event.getMcsStatusVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0050 : Save
	 * Target VVD vs Unsettled Status의 Remark의 내용을 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTgtUnstlStsRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0050Event event = (FnsJoo0050Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			begin();
			StlStatusVO[] stlStatusVOs = event.getStlStatusVOs();
			command.manageJooTgtUnstlStsRmk(stlStatusVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0066 : Get
     * IC of User 정보를 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPicUserIdInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0066Event event = (FnsJoo0066Event) e;
		JointOperationLetterBC command = new JointOperationLetterBCImpl();

		String joCntcPicId = event.getJoCntcPicId();

		PicOfUserInfoVO picOfUserInfoVO = command.searchPicUserIdInfo(joCntcPicId);

		if (picOfUserInfoVO != null) {
			eventResponse.setETCData("USR_NM", picOfUserInfoVO.getUsrNm());
			eventResponse.setETCData("OFC_CD", picOfUserInfoVO.getOfcCd());
			eventResponse.setETCData("AR_HD_QTR_OFC_CD", picOfUserInfoVO.getArHdQtrOfcCd());
		}
		return eventResponse;
	}
	
	

	/**
	 * FNS_JOO_0088 : Retrieve
	 * Estimate Performance Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstmPerformanceChangeStatusList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0088Event event = (FnsJoo0088Event) e;

    		List<EstmPerformanceChangeStatusRsltVO> list = null;
    		list = command.searchEstmPerformanceChangeStatusList(event.getEstmPerformanceChangeStatusVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

    /**
     * FNS_JOO_0088 : Retrieve
     * 조건변경시
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchEstmPerformanceChangeStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0088Event event = (FnsJoo0088Event)e;

		EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO = event.getEstmPerformanceChangeStatusVO();

		String estmCondFlg = estmPerformanceChangeStatusVO.getEstmCondFlg();

		List<EstmPerformanceChangeStatusVO> list = null;

		String revYrmonFr = "";
		String revYrmonTo = "";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		switch (Integer.parseInt(estmCondFlg)){
			//exe_yrmon이나 re_divr_cd가 변경된경우
			case 1 :
				list = command.searchEstmRevYrmonFrTo(estmPerformanceChangeStatusVO);

				revYrmonFr = estmPerformanceChangeStatusVO.getExeYrmon();
				revYrmonTo = estmPerformanceChangeStatusVO.getExeYrmon();
				
				if (!list.isEmpty()){
					if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
						revYrmonFr = list.get(0).getRevYrmonFr();
					}

					if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
						revYrmonTo = list.get(0).getRevYrmonTo();
					}
				}
				
				estmPerformanceChangeStatusVO.setRevYrmonFr(revYrmonFr);
				estmPerformanceChangeStatusVO.setRevYrmonTo(revYrmonTo);
			//rev_yrmon period가 변경된 경우
			case 2 :
				//Trade Code List 조회
				list = command.searchEstmTradeCodeListEstm(estmPerformanceChangeStatusVO);
				trdCombo = makeEstmPerChaStatusEstmComboString(list, 0);
			//trad변경된경우
			case 3 :
				//Rlane Code List 조회
				list = command.searchEstmRlaneCodeListEstm(estmPerformanceChangeStatusVO);
				laneCombo = makeEstmPerChaStatusEstmComboString(list, 1);
			//lane변경된경우
			case 4 :
				//Carrier Code List 조회
				list = command.searchEstmCarrierCodeListEstm(estmPerformanceChangeStatusVO);
				crrCombo = makeEstmPerChaStatusEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0088 : Save
	 * D : [FnsJoo0088Event] <br>
	 * [Estimate Performance Creation]을 [Save]합니다. <br>
	 *
	 * @param FnsJoo0088Event
	 * @return EventResponse
	 * @throws EventException
	 * @author Jo Byeang Yean
	 */
	private EventResponse manageEstmPerformanceChangeStatus(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0088Event event = (FnsJoo0088Event) e;
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();

		try {
			begin();
			
			EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs = event.getEstmPerformanceChangeStatusRsltVOs();
			command.manageEstmPerformanceChangeStatus(estmPerformanceChangeStatusRsltVOs, account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	
    /**
     * FNS_JOO_0088 : Open
     * E-NIS의 BSA 계획 데이터와 공동운항의 실적 데이터를 이용하여 추정실적 산출자료를 조회중
     *   Trade, Carrier, Lane Combo 조회.
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0088(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String exeYrmon = "";
		// 마감여부 조회
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO = new EstmPerformanceChangeStatusVO();
		estmPerformanceChangeStatusVO.setExeYrmon(exeYrmon);

		//Revenue Month From~To 조회하기
		List<EstmPerformanceChangeStatusVO> list = command.searchEstmRevYrmonFrTo(estmPerformanceChangeStatusVO);

		String revYrmonFr = exeYrmon;
		String revYrmonTo = exeYrmon;

		if (!list.isEmpty()){
			if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
				revYrmonFr = list.get(0).getRevYrmonFr();
			}

			if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
				revYrmonTo = list.get(0).getRevYrmonTo();
			}
		}

		estmPerformanceChangeStatusVO.setRevYrmonFr(revYrmonFr);
		estmPerformanceChangeStatusVO.setRevYrmonTo(revYrmonTo);

		//Trade Code List 조회
		list = command.searchEstmTradeCodeListEstm(estmPerformanceChangeStatusVO);

		String trdCombo = makeEstmPerChaStatusEstmComboString(list, 0);

		//Rlane Code List 조회
		list = command.searchEstmRlaneCodeListEstm(estmPerformanceChangeStatusVO);
		String laneCombo = makeEstmPerChaStatusEstmComboString(list, 1);

		//Carrier Code List 조회
		list = command.searchEstmCarrierCodeListEstm(estmPerformanceChangeStatusVO);
		String crrCombo = makeEstmPerChaStatusEstmComboString(list, 2);

		CodeUtil codeUtil = CodeUtil.getInstance();

		// BSA Type
		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);
		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

		String code = "";
		StringBuilder bsaTypeCdTmp = new StringBuilder();
		StringBuilder bsaTypeNmTmp = new StringBuilder();
		for (int i=0; i<bsaTypeCd.length; i++){
			code = bsaTypeCd[i].substring(0,1);
			if ("1".equals(code)){
				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
			}
		}

		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

		eventResponse.setETCData("EXE_YRMON"   , exeYrmon);
		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		eventResponse.setETCData("STL_JB_COMBO", bsaTpCd);
		eventResponse.setETCData("STL_JB_COMNM", bsaTpNm);
		return eventResponse;
	}
	
	/**
	 * EstmPerformanceChangeStatusVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<EstmPerformanceChangeStatusVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeEstmPerChaStatusEstmComboString(List<EstmPerformanceChangeStatusVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO = (EstmPerformanceChangeStatusVO)iterator.next();

			if (flg==0){
				sb.append(estmPerformanceChangeStatusVO.getTrdCd()+"|");
			}else if (flg==1){
				sb.append(estmPerformanceChangeStatusVO.getRlaneCd()+"|");
			}else if (flg==2){
				sb.append(estmPerformanceChangeStatusVO.getJoCrrCd()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}
	
	/**
     * FNS_JOO_0087 : Open
     * D : [FnsJoo0087Event]<br>
     * [Intergrated Loging Summary Report]을 조회위해 Open시 Direct [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0087(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            FnsJoo0087Event event = (FnsJoo0087Event)e;
            IntloadSumReportVO intloadSumReportVO   = event.getIntloadSumReportVO();
            jooCodeParamVO.setSuperCd1( intloadSumReportVO.getSuperCd1() );

            List<JooCodeInfoVO> list = command.searchComCodeNmList(jooCodeParamVO);
            eventResponse.setRsVoList( list  );  
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FnsJoo0087Event: Retrieve
     * D : [FnsJoo0087Event]<br>
     * Intergrated Loging Summary Report 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchIntergratedloadSumReportRDRList(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0087Event event = (FnsJoo0087Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<IntloadSumReportVO> list = command.searchIntergratedloadSumReportRDRList(  event.getIntloadSumReportVO()  );
            eventResponse.setRsVoList(list);   
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }	

	/**
	 * Intergrated Loging Summary Report 멀티 저장
	 * @param Event e    
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addIntergratedloadSumReportRDRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0087Event event = (FnsJoo0087Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try{
			begin();			
			command.addIntergratedloadSumReportRDRList(event.getIntloadSumReportVOs(),account);     
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();       								
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	

	/**
	 * FNS_JOO_0089 : Retrieve
	 * Estimate Performance Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEstmPerformanceChangeStatusIIList(Event e) throws EventException {
	    try{
    		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();
    		FnsJoo0089Event event = (FnsJoo0089Event) e;

    		List<EstmPerformanceChangeStatusIIRsltVO> list = null;
    		list = command.searchEstmPerformanceChangeStatusIIList(event.getEstmPerformanceChangeStatusIIVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	
    /**
     * FNS_JOO_0089 : Retrieve
     * 조건변경시
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchEstmPerformanceChangeStatusII(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0089Event event = (FnsJoo0089Event)e;

		EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO = event.getEstmPerformanceChangeStatusIIVO();

		String estmCondFlg = estmPerformanceChangeStatusIIVO.getEstmCondFlg();

		List<EstmPerformanceChangeStatusIIVO> list = null;

		String revYrmonFr = "";
		String revYrmonTo = "";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		switch (Integer.parseInt(estmCondFlg)){
			//exe_yrmon이나 re_divr_cd가 변경된경우
			case 1 :
				list = command.searchEstmRevYrmonFrToEstmII(estmPerformanceChangeStatusIIVO);

				revYrmonFr = estmPerformanceChangeStatusIIVO.getExeYrmon();
				revYrmonTo = estmPerformanceChangeStatusIIVO.getExeYrmon();
				
				if (!list.isEmpty()){
					if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
						revYrmonFr = list.get(0).getRevYrmonFr();
					}

					if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
						revYrmonTo = list.get(0).getRevYrmonTo();
					}
				}
				
				estmPerformanceChangeStatusIIVO.setRevYrmonFr(revYrmonFr);
				estmPerformanceChangeStatusIIVO.setRevYrmonTo(revYrmonTo);
			//rev_yrmon period가 변경된 경우
			case 2 :
				//Trade Code List 조회
				list = command.searchEstmTradeCodeListEstmII(estmPerformanceChangeStatusIIVO);
				trdCombo = makeEstmPerChaStatusIIEstmComboString(list, 0);
			//trad변경된경우
			case 3 :
				//Rlane Code List 조회
				list = command.searchEstmRlaneCodeListEstmII(estmPerformanceChangeStatusIIVO);
				laneCombo = makeEstmPerChaStatusIIEstmComboString(list, 1);
			//lane변경된경우
			case 4 :
				//Carrier Code List 조회
				list = command.searchEstmCarrierCodeListEstmII(estmPerformanceChangeStatusIIVO);
				crrCombo = makeEstmPerChaStatusIIEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		
		return eventResponse;
	}
	
    /**
     * FNS_JOO_0089 : Open
     * E-NIS의 BSA 계획 데이터와 공동운항의 실적 데이터를 이용하여 추정실적 산출자료를 조회중
     *   Trade, Carrier, Lane Combo 조회.
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0089(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String exeYrmon = "";
		// 마감여부 조회
		try{
			exeYrmon = DateTime.addMonths(DateTime.getFormatString("yyyyMMdd"), -1).substring(0,6);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO = new EstmPerformanceChangeStatusIIVO();
		estmPerformanceChangeStatusIIVO.setExeYrmon(exeYrmon);

		//Revenue Month From~To 조회하기
		List<EstmPerformanceChangeStatusIIVO> list = command.searchEstmRevYrmonFrToEstmII(estmPerformanceChangeStatusIIVO);

		String revYrmonFr = exeYrmon;
		String revYrmonTo = exeYrmon;

		if (!list.isEmpty()){
			if (list.get(0).getRevYrmonFr()!= null && !"".equals(list.get(0).getRevYrmonFr())){
				revYrmonFr = list.get(0).getRevYrmonFr();
			}

			if (list.get(0).getRevYrmonTo()!= null && !"".equals(list.get(0).getRevYrmonTo())){
				revYrmonTo = list.get(0).getRevYrmonTo();
			}
		}

		estmPerformanceChangeStatusIIVO.setRevYrmonFr(revYrmonFr);
		estmPerformanceChangeStatusIIVO.setRevYrmonTo(revYrmonTo);
		//Trade Code List 조회
		list = command.searchEstmTradeCodeListEstmII(estmPerformanceChangeStatusIIVO);

		String trdCombo = makeEstmPerChaStatusIIEstmComboString(list, 0);

		//Rlane Code List 조회
		list = command.searchEstmRlaneCodeListEstmII(estmPerformanceChangeStatusIIVO);
		String laneCombo = makeEstmPerChaStatusIIEstmComboString(list, 1);

		//Carrier Code List 조회
		list = command.searchEstmCarrierCodeListEstmII(estmPerformanceChangeStatusIIVO);
		String crrCombo = makeEstmPerChaStatusIIEstmComboString(list, 2);

		CodeUtil codeUtil = CodeUtil.getInstance();

		// BSA Type
		Collection<CodeInfo> codeList = codeUtil.getCodeSelect("CD01866", 0);
		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList), BizComUtil.CODE_DELIMITTER);
		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

		String code = "";
		StringBuilder bsaTypeCdTmp = new StringBuilder();
		StringBuilder bsaTypeNmTmp = new StringBuilder();
		for (int i=0; i<bsaTypeCd.length; i++){
			code = bsaTypeCd[i].substring(0,1);
			if ("1".equals(code)){
				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
			}
		}

		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

		eventResponse.setETCData("EXE_YRMON"   , exeYrmon);
		eventResponse.setETCData("REV_YRMON_FR", revYrmonFr);
		eventResponse.setETCData("REV_YRMON_TO", revYrmonTo);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		eventResponse.setETCData("STL_JB_COMBO", bsaTpCd);
		eventResponse.setETCData("STL_JB_COMNM", bsaTpNm);
		
		return eventResponse;
	}

	/**
	 * EstmPerformanceChangeStatusVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<EstmPerformanceChangeStatusVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeEstmPerChaStatusIIEstmComboString(List<EstmPerformanceChangeStatusIIVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO = (EstmPerformanceChangeStatusIIVO)iterator.next();

			if (flg==0){
				sb.append(estmPerformanceChangeStatusIIVO.getTrdCd()+"|");
			}else if (flg==1){
				sb.append(estmPerformanceChangeStatusIIVO.getRlaneCd()+"|");
			}else if (flg==2){
				sb.append(estmPerformanceChangeStatusIIVO.getJoCrrCd()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}
	
    /**
     * FNS_JOO_0090 : Open
     * D : [FnsJoo0090Event]<br>
     * [RDR Ratio by Lane]을 조회위해 Open시 Direct [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author kim sang geun
     */
    private EventResponse searchTDRRatioListByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0090Event event = (FnsJoo0090Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<TdrRatioVO> list = command.searchTDRRatioListByLane ( event.getTdrRatioVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
            
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0090: SAVE
     * D : [FnsJoo0090Event]<br>
     * RDR Ratio by Lane 데이터중 JOO_TDR_RTO에 해당하는 값을 저장합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse createTDRRationByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0090Event event = (FnsJoo0090Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try{
			begin();
			command.createTDRRationByLane(event.getTdrRatioVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 조회합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchROBRatioListByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0090Event event = (FnsJoo0090Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            
            List<TdrRatioVO> list = command.searchROBRatioListByLane ( event.getTdrRatioVO()  );
            eventResponse.setRsVoList(list);				
            
            return eventResponse;            
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 저장합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse manageROBRationByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0090Event event = (FnsJoo0090Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		try{
			begin();					
			
			TdrRatioVO tdrRatioVO = null;
			List<TdrRatioVO> list = null;
			
			 for(int i=0; i<event.getTdrRatioVOS().length; i++){
				 
				 if(!"D".equals(event.getTdrRatioVOS()[i].getIbflag())){				 
					 String rlaneCd = event.getTdrRatioVOS()[i].getRlaneCd();
					 String skdDirCd = event.getTdrRatioVOS()[i].getSkdDirCd();
					 String orgRlaneCd = event.getTdrRatioVOS()[i].getOrgRlaneCd();
					 String orgSkdDirCd = event.getTdrRatioVOS()[i].getOrgSkdDirCd();
					 
					 if(!(rlaneCd.equals(orgRlaneCd) && skdDirCd.equals(orgSkdDirCd))){
						 tdrRatioVO = new TdrRatioVO();
							
						 tdrRatioVO.setSlaneCd(event.getTdrRatioVOS()[i].getRlaneCd());
						 tdrRatioVO.setSkdDirCd(event.getTdrRatioVOS()[i].getSkdDirCd());
		
						 list = command.searchROBRatioListByLane (tdrRatioVO);
						 
						 if(list.size() > 0){
								eventResponse.setUserMessage(new ErrorHandler("COM12226",new String[]{"Lane:"+event.getTdrRatioVOS()[i].getRlaneCd()+" Dir:"+event.getTdrRatioVOS()[i].getSkdDirCd()}).getUserMessage());
								return eventResponse;					 
						 }
					 }
				 }
			 }
									
			String sLane = command.searchLaneChk(event.getTdrRatioVOS());			
			if("Y".equals(sLane)){
				command.manageROBRationByLane(event.getTdrRatioVOS(), account);
				commit();
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12241",new String[]{"Lane("+sLane+")"}).getUserMessage());
				return eventResponse;				
			}			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }    
    
    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * RDR Carrier Code를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchRDRCarrierCodeStringByServiceLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0056Event event = (FnsJoo0056Event)e;
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            List<JooCodeInfoVO> list = command.searchRDRCarrierCodeListByPeriodAndServiceLane (  event.getRdrLoadVO()  );
            //eventResponse.setRsVoList(list);

            StringBuilder comboCode = new StringBuilder();
    		StringBuilder comboText = new StringBuilder();
    		for (int i=0 ; i<list.size(); i++) {
    			comboCode.append(list.get(i).getCode() + "^#^");
    			comboText.append(list.get(i).getCode() + "^#^");  // Code를 그대로 보여준다.
    		}
    		eventResponse.setETCData("comboCode", comboCode.toString());
    		eventResponse.setETCData("comboText", comboText.toString());

    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * 'Sub Allocation and Ratio'에 Rep. Carrier가 복수 선택되었거나 혹은 하나도 선택되지를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchTDRRatioCountByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0057Event event = (FnsJoo0057Event)e;
            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
            List<TdrLoadVO> list = command.searchTDRRatioCountByLane(event.getTdrLoadVO());
            
            eventResponse.setETCData("carrier_cnt", list.get(0).getCarrierCnt());
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
	/**
	 * G/W 문서 삭제(SAVE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGW(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();		
		FnsJoo0017Event event = (FnsJoo0017Event)e;		
		String csrNo = event.getCsrNo();
		
		try{	
			begin();			
			command.manageGW(csrNo, account.getUsr_id(), event.getSlipProcessVOS());		
			eventResponse.setUserMessage((String) new ErrorHandler("JOO10003",new String[]{}).getUserMessage());			
			eventResponse.setETCData("deleteYn","Y");			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}    
	
    /**
     * FNS_JOO_0099: Retrieve
     * GW Contract Link 목록조회<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchGWDoc(Event e) throws EventException {
        try{
            FnsJoo0099Event event = (FnsJoo0099Event)e;
            JointOperationConsultationBC command = new JointOperationConsultationBCImpl();            
            List<AgmtDocVO> list = command.searchGWDoc(event.getCsrNo());          
            GeneralEventResponse eventResponse = new GeneralEventResponse();            
    		eventResponse.setRsVoList(list);    		
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }	

	/**
	 * FNS_JOO_0099 : Save
	 * GW Contract Link 목록 정보를 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageGWDoc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0099Event event = (FnsJoo0099Event)e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
		
		try{
			begin();						
			command.manageGWDoc(event.getCsrNo(), event.getAgmtDocVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 스케줄상의 Port를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSkdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		
		// PDTO(Data Transfer Object including Parameters)		
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<SkdPortVO> list = command.searchSkdPortList(event.getKorCllCdlCondVO());

		String clptSeqCombo =  robPortComboString(list, 1);
		String portCdCombo = robPortComboString(list, 2);
		String tmlCdCombo = robPortComboString(list, 3);	
		String clptIndSeqCombo = robPortComboString(list, 4);
		String etaDtCombo = robPortComboString(list, 5);
		String etdDtCombo = robPortComboString(list, 6);		
				
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("clpt_seq" ,clptSeqCombo);		
		eventResponse.setETCData("vps_port_cd" ,portCdCombo);
		eventResponse.setETCData("tml_cd"     ,tmlCdCombo);
		eventResponse.setETCData("clpt_ind_seq"     ,clptIndSeqCombo);
		eventResponse.setETCData("eta_dt"     ,etaDtCombo);
		eventResponse.setETCData("etd_dt"     ,etdDtCombo);		
		
		return eventResponse;
	}	

	
	/**
	 * FNS_JOO_0100 : btn_retrive<br>
	 * ROB 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			List<KorCllCdlDetailVO> list1 = command.searchRobList(event.getKorCllCdlCondVO(), "1");
			eventResponse.setRsVoList(list1);

			List<TdrLoadVO> list2 = command.searchRobTotal(event.getKorCllCdlCondVO(), "1");
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	

	/**
	 * FNS_JOO_0100 : btn_retrive<br>
	 * ROB 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			List<KorCllCdlDetailVO> list1 = command.searchRobList(event.getKorCllCdlCondVO(), "2");
			eventResponse.setRsVoList(list1);

			List<TdrLoadVO> list2 = command.searchRobTotal(event.getKorCllCdlCondVO(), "2");
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}			
	
	/**
	 * FNS_JOO_0100 : btn_retrive<br>
	 * ROB 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobList3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			List<KorCllCdlDetailVO> list1 = command.searchRobList(event.getKorCllCdlCondVO(), "3");
			eventResponse.setRsVoList(list1);

			List<TdrLoadVO> list2 = command.searchRobTotal(event.getKorCllCdlCondVO(), "3");
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}				
	
	/**
	 * FNS_JOO_0100 : btn_retrive<br>
	 * ROB 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobList4(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			List<KorCllCdlDetailVO> list1 = command.searchRobList(event.getKorCllCdlCondVO(), "4");
			eventResponse.setRsVoList(list1);

			List<TdrLoadVO> list2 = command.searchRobTotal(event.getKorCllCdlCondVO(), "4");
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * FNS_JOO_0100 : btn_retrive<br>
	 * ROB 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobList5(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0100Event event = (FnsJoo0100Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		try {
			List<KorCllCdlDetailVO> list1 = command.searchRobList(event.getKorCllCdlCondVO(), "5");
			eventResponse.setRsVoList(list1);

			List<TdrLoadVO> list2 = command.searchRobTotal(event.getKorCllCdlCondVO(), "5");
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	/**  
	 * ROB PORT LIST를 Combo용 String으로 변환한다.
	 * 
	 * @param List<SkdPortVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String robPortComboString(List<SkdPortVO> list, int flg) throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			SkdPortVO skdPortVO = (SkdPortVO) iterator.next();
			
			if (flg == 1) {
				sb.append(skdPortVO.getClptSeq() + "|");				
			}else if (flg == 2) {
				sb.append(skdPortVO.getVpsPortCd() + "|");
			} else if (flg == 3) {
				sb.append(skdPortVO.getTmlCd() + "|");
			} else if (flg == 4) {
				sb.append(skdPortVO.getClptIndSeq() + "|");
			} else if (flg == 5) {
				sb.append(skdPortVO.getEtaDt() + "|");
			} else if (flg == 6) {
				sb.append(skdPortVO.getEtdDt() + "|");
				
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}	
	
	/**
	 * FNS_JOO_0102 : btn_retrive<br>
	 * 기 정산된 데이타가 존재하는 경우 Double Click시 History 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombinedDupList(Event e) throws EventException {
		try{
			FnsJoo0102Event event = (FnsJoo0102Event)e;
            JointOperationConsultationBC command = new JointOperationConsultationBCImpl(); 
            
            CmbConditionVO cmbConditionVO = event.getCmbConditionVO();
    		List<CombinedVO> list = command.searchCombinedDupList(cmbConditionVO);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList(Event e) throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0103Event event = (FnsJoo0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
			String key = command.searchRobSummaryList(tdrLoadVO, account, "1");
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}		
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList2(Event e) throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0103Event event = (FnsJoo0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
			String key = command.searchRobSummaryList(tdrLoadVO, account, "2");
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}	
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList3(Event e) throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0103Event event = (FnsJoo0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
			String key = command.searchRobSummaryList(tdrLoadVO, account, "3");
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}		
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList4(Event e) throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0103Event event = (FnsJoo0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
			String key = command.searchRobSummaryList(tdrLoadVO, account, "4");
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}	
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList5(Event e) throws EventException {
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		FnsJoo0103Event event = (FnsJoo0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
			String key = command.searchRobSummaryList(tdrLoadVO, account, "5");
			eventResponse.setETCData("key", key);
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}		
	
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * Vessle ETD Schedule  리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslSkdEtd(Event e) throws EventException {
		try{
			FnsJoo0103Event event = (FnsJoo0103Event)e;
			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl(); 
            
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
    		List<TdrLoadVO> list = command.searchVslSkdEtd(tdrLoadVO);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }		
	}			
	
	
    /**
     * FNS_JOO_0103 : BackEndJob 상태 조회
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchRobSummaryEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchRobSummaryEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0103 : BackEndJob 결과 조회
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	private EventResponse searchRobSummaryBackEndJobResult(Event e) throws BackEndJobException {
		String key = (String)e.getAttribute("key");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList((List<TdrLoadVO>)BackEndJobResult.loadFromFile(key));
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0029 : 추정 대상 엑셀 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccrualListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0029Event event = (FnsJoo0029Event)e;
		JointOperationAccrualCreationBC command = new JointOperationAccrualCreationBCImpl();

		SimpleDateFormat yyyymmddhh24missFormat = new SimpleDateFormat ("yyyyMMddHHmmss");
		String yyyymmddhh24miss = yyyymmddhh24missFormat.format(new Date(System.currentTimeMillis()));
		
		try{
			String headTitle = "";
			String column_names = "";
			
			headTitle = "Seq.￠Revenue Month￠Carrier Code￠Service Provider/ Customer￠Revenue VVD￠Revenue Lane￠BSA Type￠BSA￠Slot Price￠Account Code￠Estimated Cost￠Actual Cost￠Accrual Cost￠Type￠IO Flag￠STS MK￠Adjust￠Adjust Release￠Adjusted BSA￠Adjusted Slot Price￠Adjusted Estimated Cost￠Adjusted Accrual Cost￠Review Result￠Remark";								
			String title[] = headTitle.split("￠");			
			column_names = "seq_no￠rev_yrmon￠jo_crr_cd￠vndr_cust_seq￠vvd￠rlane_cd￠jo_stl_jb_nm￠bsa_qty￠bsa_slt_prc￠acct_cd￠estm_amt￠act_amt￠accl_amt￠estm_vvd_tp_cd￠jo_ioc_div_cd￠accl_amt_corr_flg￠adj_estm_flg￠adj_rlse_rmk￠adj_bsa_qty￠adj_bsa_slt_prc￠adj_estm_amt￠adj_accl_amt￠adj_rslt_cd￠adj_rmk";						
			String columns[] = column_names.split("￠");			
			
			SettlementConditionVO settlementConditionVO = event.getSettlementConditionVO();			
						
			if("1".equals(settlementConditionVO.getSearchGubun())){
				//1. Retirieve
				eventResponse.setCustomData("vos", command.searchJointOperationAccrualList(settlementConditionVO));				
			}else if("2".equals(settlementConditionVO.getSearchGubun())){
				//2. Target Retrieve : Create 대상 조회				
				eventResponse.setCustomData("vos", command.searchJointOperationAccrual(settlementConditionVO));				
			}else if("3".equals(settlementConditionVO.getSearchGubun())){
				//3. I/F 조회				
				eventResponse.setCustomData("vos", command.searchJointOperationAccrualERP(settlementConditionVO));				
			}
 
			eventResponse.setCustomData("title", title);
			eventResponse.setCustomData("columns", columns);
			eventResponse.setCustomData("fileName", "Estimate_"+yyyymmddhh24miss+"_"+settlementConditionVO.getPageNo()+"page.xls");
			eventResponse.setCustomData("isZip", false);			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 * FNS_JOO_0103 : Save<br>
	 * RDR Port 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRDRPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0103Event event = (FnsJoo0103Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		
		try{
			begin();
			command.manageRDRPort(event.getTdrLoadVOs(), event.getRlaneCd(),  account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;					
	}
	
	/**
     * CSR cancel 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCsrCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0025Event event = (FnsJoo0025Event) e;
		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();

		try{
			begin();
			
			CsrVO csrVO = new CsrVO();
			
			csrVO.setAproFlg("N");
			csrVO.setCxlFlg("Y");
			csrVO.setCxlDesc("Cancel");
			csrVO.setUpdUsrId(account.getUsr_id());
			csrVO.setCsrNo(event.getCsrNo());
			
			csrVO.setSlpTpCd(event.getCsrNo().substring(0, 2));
			csrVO.setSlpFuncCd(event.getCsrNo().substring(2, 3));
			
			if(event.getCsrNo().length() == 20){
				csrVO.setSlpOfcCd(event.getCsrNo().substring(3, 9));
				csrVO.setSlpIssDt("20".concat(event.getCsrNo().substring(9, 15)));
				csrVO.setSlpSerNo(event.getCsrNo().substring(15, 20));
			} else {
				csrVO.setSlpOfcCd(event.getCsrNo().substring(3, 8));
				csrVO.setSlpIssDt("20".concat(event.getCsrNo().substring(8, 14)));
				csrVO.setSlpSerNo(event.getCsrNo().substring(14, 19));
			}
			
			log.debug("["+csrVO.getSlpTpCd()+"]");
			log.debug("["+csrVO.getSlpFuncCd()+"]");
			log.debug("["+csrVO.getSlpOfcCd()+"]");
			log.debug("["+csrVO.getSlpIssDt()+"]");
			log.debug("["+csrVO.getSlpSerNo()+"]");
			
			command.manageCsrCancel(csrVO);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}