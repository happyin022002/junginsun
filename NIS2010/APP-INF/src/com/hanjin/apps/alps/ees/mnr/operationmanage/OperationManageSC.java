/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationManageSC.java
*@FileTitle : Operation	Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 조회 추가
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
* 2012.01.04 신혜정 [CHM-201215407-01] Hanger Rack/Bar Using Report 의 Detail EQ no 내역 팝업 조회         
* 2012.01.12 신혜정 [CHM-201215612-01] Bidding 프로세싱중인 데이터 Confirm 불가토록 로직 수정
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
* 2012.01.30 김상수 [CHM-201215889-01] Repair SPP Upload 화면 로직 변경 요청
*                                      - 엑셀로 업로드 받은 Hour와 Material은 Qty가 1이상일 경우 Hour*Qty, Material*Qty로 계산해서 업로드
* 2012.03.08 박명신 선처리                M1,MD 만 manageHangerInventoryEqStsBasic 타게 로직 수정 
* 2012.03.06 신혜정 [CHM-201216409] 3rd Party 탭 [CHNG INV No] 버튼 클릭시, invoice no 업데이트
* 2012.04.12 신혜정 [CHM-201217048] Disposal Inquiry 화면에서 not pick-up 된 장비 list 조회 기능 추가
* 2012.06.26 신혜정 [CHM-201218436] Estimate Creation > EDI Upload 에 [Calculation] 기능 추가
*                                   - EQ No로 EQ Type, TP/SZ 조회, EDI ID, EQ Type로 Service Provider 정보 조회 
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	     
* 2012.11.20 조경완 [CHM-201221414-01] [MNR] Damage Flagging/Unflagging [EES_MNR_0122, EES_MNR_S122] OOME 해결을 위한 Validation Script 추가       
* 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건
* 2013.01.04 조경완 [CHM-201220942-01] ALPS MNR-Total Loss Module에서 Write Off 처리 건을 위하여 추가 메뉴 개발 요청                       
* 2013.01.04 조경완 [CHM-201220984-01] ALPS MNR-Total Loss-Write Off - Approval        
* 2013.02.15 조경완 [CHM-201322897-01] ALPS-CNTR MNR-Repair -Estimate Creation 화면 상에서 TPB Interface 에러 건 수정 요청
* 2013.04.25 조경완 [CHM-201324321-01] [MNR] 동일 장비에 대해 중복 Disposal Request되는 현상 제거를 위한 기능 보완   
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
* 2013.06.17 조경완 [CHM-201324910-01] ALPS-MNR-Disposal-SLD Creation 기능 보완 요청
* 2013.08.07 조경완 [CHM-201326069-01] [MNR-자체개선] Write off Request 기능 보완      
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능             
* 2013.10.02 조경완 [CHM-201326905-01] [자체개선] SPP Repair Estimate Creation 기능 보완
* 2013.11.27 이혜민 [CHM-201327727-01] Hanger Bar Installation/Removal Manual 입력 시마다 Remark 항시 자동으로 생성되도록 수정
* 2014.11 Chagn Young Kim 10만불 결제관련
* 2015.12.21 이율규 [CHM-201538460] 선박의 사고에 따른 장비관리의 효율성을 위하여 추가 화면 개발
* 2015.12.21 이율규 [CHM-201537757] Estimate 사진 Muti Showing 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBC;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepHistoryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0156Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0157Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0159Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0160Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0163Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0164Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0167Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0200Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0220Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0221Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0235Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0251Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0256Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0261Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnrS301Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnrS304Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnrS308Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispCancelVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispNoPickUpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0109Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0111Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0122Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0125Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0139Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0151Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0158Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0255Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0257Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0258Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnrS122Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EqListForDisposalVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.HangerRackReportVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.basic.ExtraDisposalMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.basic.ExtraDisposalMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0093Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0094Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.CustomMnrXtraDispVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0019Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0022Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0023Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0027Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0028Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0030Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0032Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0036Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0052Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0054Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0055Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0058Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0061Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0191Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0192Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0194Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0211Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0219Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0226Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0227Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0228Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0240Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0243Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0252Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS019Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS027Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS028Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS032Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS232Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkGrpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomDocHeaderVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainINFOVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultListVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0095Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0096Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0098Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0105Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0195Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0234Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0262Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0263Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0264Event;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/** 
 * alps-OperationManage Business Logic ServiceCommand - alps-OperationManage 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author park myoung sin
 * @see GeneralCodeCheckMgtBC
 * @since J2EE 1.4
 */

public class OperationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OperationManage system 업무 시나리오 선행작업<br>
	 * EES_MNR_0139업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * OperationManage system 업무 시나리오 마감작업<br>
	 * EES_MNR_0139 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OperationManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-OperationManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMnr0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyEQFlagFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQFlagHistoryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQFlagListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQFlagHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = requestEstimateService(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchESTNextVerNoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0191Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQWorkOrderHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0194Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWOInfoListBySparePartService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWOInfoListBySparePartService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWONoInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0227Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else	if (e.getEventName().equalsIgnoreCase("EesMnr0219Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyWOFileListService(e);
			}
		} else	if (e.getEventName().equalsIgnoreCase("EesMnr0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyDisposalPriceFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0228Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);

			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairResultListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHangerRackBarService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0151Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalCandidateListFlagService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQDataForDisposalRSQL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalCandidateFlagService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0158Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalCandidatePopupListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDocSendService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDocSendService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0192Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateByEQService(e);
			}
		//Estimate Auditing
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchHtmlCodeForThumbnail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = counterOfferEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = rejectEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = approvalEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = manageEstimateAuditItLaterService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchESTApprovalNextVerNoListService(e);
			}
		//Estimate EDI Auditing
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0240Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = counterOfferEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = rejectEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = approvalEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = manageEstimateAuditItLaterService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchESTWorkOrderListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchESTWorkOrderDetailListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createESTWOCreationService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchESTGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = manageESTGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = manageESTGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchESTGroupApprovalNextVerNoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageEstimateCancelService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListServiceForHJS(e);
				// 2015.03.10 소스 원복 BY JEONGMIN, PARK
//				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageEstimateCancelService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraDisposalByEQService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkExtraDisposalByEQService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExtraDisposalByEQService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraDisposalListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0156Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchDSPPartnerService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchDisposalNoDubChkService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0157Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeDisposalService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0167Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0159Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = reBiddingDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = confirmDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVerifyBiddingDateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVerifyDisposalNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = sendDispContractMailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0195Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossInfoByOFCListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0095Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTotalLossGRPService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchOfficeAreaUS(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalLossListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossWithCLTService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTotalLossService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageTotalLossDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0234Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossWithCLTService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalSoldListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalSoldDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDispRlseNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalSoldService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0251Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalSoldCancelListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalSoldCancelService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0164Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeDisposalListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0163Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalDetailInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDisposalCollectionInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossLessorReportListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0221Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifySoldEQFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalLossListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0235Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalDocSendService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0243Event")) {
		//EDI & Excel Estimate Upload
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEstimateUploadService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqTypeByEqNoData(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchHdrDataByEqNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0252Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = manageEDIGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = manageEDIGroupAuditListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0255Event")) {
		// Hanger Rack & Bar Installation/Removal File Import
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyHangerRackBarService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0256Event")) {
		// Disposal Cancelled Invoice Inquery 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalCancelledInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalDetailCancelledInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0257Event")) {
		// Hanger Rack/Bar Using Report
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHangerRackReportListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0258Event")) {
		// Hanger Rack/Bar Using Report Pop Up
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHangerRackReportDtlListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0261Event")) {
		// Not Pick-up Container No Pop Up
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalNoPickUpListService(e);
			}
		}		
		//**************** SPP FUNCTION START ******************//
		else if (e.getEventName().equalsIgnoreCase("EesMnrS122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQFlagListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = requestEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchESTNextVerNoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairResultListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS232Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyRPRCreateFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS308Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchPartnerListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMyBiddingHdrListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMyBiddingLoaclTimeListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMyBiddingStatusListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMyBiddingHdrListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMyBiddingStatusListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0262Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossWriteOffRqstListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageWriteOffRqstService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeWriteOffRqstService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0263Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWriteOffApprovalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWriteOffApprovalDetailService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageWriteOffApprovalService(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0264Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWriteOffApprovalInquiryService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWriteOffApprovalDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAcepChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAcepChk(e);
			}
		}
		
		//
	
		//**************** SPP FUNCTION START ******************//
		return eventResponse;
	}

	/**
	 * EES_MNR_0255 : Verify <br>
	 * [EES_MNR_0255]Hanger Rack & Bar Installation/Removal File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyHangerRackBarService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0255Event event = (EesMnr0255Event)e;
		HangerInventoryListGRPVO hangerInventoryListGRPVO = null;
		CustomMnrEqStsVO[] customMnrEqStsVOs = new CustomMnrEqStsVO[0]; // 업로드된 엑셀자료
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String eqNo = null; // eqNo
		EQFlagListINVO eqFlagListINVO = null;
		EQFlagListGRPVO eqFlagListGRPVO = null;
		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		List<CustomMnrEqStsVO> selCustomMnrEqStsVOs = null; // eqNo 로 조회한 데이터
		List<CustomMnrEqStsVO> rtnCustomMnrEqStsVOs = null; // verify result 추가한 리턴 리스트
		String flag = "0"; // flag
		StringBuffer sbfVerifyResult = null;
		boolean isSuccess = true;

		hangerInventoryListGRPVO = event.getHangerInventoryListGRPVO();
		customMnrEqStsVOs = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();

		try{
			if(null != customMnrEqStsVOs){
				rtnCustomMnrEqStsVOs = new ArrayList<CustomMnrEqStsVO>(customMnrEqStsVOs.length);

				for(int i=0; i<customMnrEqStsVOs.length; i++){
					sbfVerifyResult = new StringBuffer(""); // verify result 초기화
					isSuccess = true; // 초기화

					//*************************************************
					// 1. eqNo 검증
					//*************************************************
					eqNo = customMnrEqStsVOs[i].getEqNo();
					if(null == eqNo || "".equals(eqNo.trim())){
						isSuccess = false;
						// verify result 셋팅
						sbfVerifyResult.append("EQ No. doesn't exist. ");
					}else{
						// eqNo 로 해당 데이터 조회
						eqFlagListINVO = new EQFlagListINVO();
						eqFlagListINVO.setOfcCd(account.getOfc_cd());
						eqFlagListINVO.setMnrFlgTpCd("HGR");
						eqFlagListINVO.setBoundTpCd("ALL");
						eqFlagListINVO.setEqKndCd("U");
						eqFlagListINVO.setEqList(eqNo);
						eqFlagListINVO.setMnrHngrBarTpCd("ALL");
						eqFlagListINVO.setMnrHngrRckCd("ALL");
						eqFlagListINVO.setMnrHngrTrfCd("ALL");
						eqFlagListINVO.setPLocTp("ALL");
						eqFlagListGRPVO = new EQFlagListGRPVO();
						eqFlagListGRPVO.setEQFlagListINVO(eqFlagListINVO);
						eqFlagListGRPVO = command.searchEQFlagListBasic(eqFlagListGRPVO);
						selCustomMnrEqStsVOs = eqFlagListGRPVO.getCustomMnrEqStsVOS();

						if(null == selCustomMnrEqStsVOs || selCustomMnrEqStsVOs.size() == 0){
							isSuccess = false;
							// verify result 셋팅
							sbfVerifyResult.append("EQ No. is invalid. ");
						}
					}

					// eqNo 가 유효할 경우 기타 항목 체크
					if(isSuccess){
						// flag (화면 입력값 그대로)
						flag = customMnrEqStsVOs[i].getMnrHngrFlg();

						//*************************************************
						// 2. hanger rack type 검증
						//*************************************************
						if(!"O".equals(customMnrEqStsVOs[i].getMnrHngrRckCd()) && !"R".equals(customMnrEqStsVOs[i].getMnrHngrRckCd()) &&
								!"D".equals(customMnrEqStsVOs[i].getMnrHngrRckCd())){
							// 2-1. 콤보 코드 여부 검증
							isSuccess = false;
							sbfVerifyResult.append("Hanger Rack Type is invalid. ");
						}else{
							// 2-2. O 일 경우 변경불가, R, D 일 경우 변경 가능
							if("1".equals(flag)){
								// flag 선택시
								if("O".equals(selCustomMnrEqStsVOs.get(0).getMnrHngrRckCd())){
									// 조회값이 Permanent Hanger Rack_Single 일 경우, 변경 불가.
									if(!"O".equals(customMnrEqStsVOs[i].getMnrHngrRckCd())){
										// 입력값이 Permanent Hanger Rack_Single 이 아닐경우,
										isSuccess = false;
										sbfVerifyResult.append("Permanent Hanger Rack_Single can not be changed. ");
									}
								}else{
									// 조회값이 R, D 일 경우, R, D 로만 변경할 수 있다.
									if(!"R".equals(customMnrEqStsVOs[i].getMnrHngrRckCd()) && !"D".equals(customMnrEqStsVOs[i].getMnrHngrRckCd())){
										// 입력값이, R, D가 아닐 경우
										// verify result 셋팅
										isSuccess = false;
										sbfVerifyResult.append("Cannot select Permanent Hanger Rack_Single. "); // Hanger Rack Type 을 확인하세요..
									}
								}
							}else{
								// flag 비선택시, 조회값 셋팅
								customMnrEqStsVOs[i].setMnrHngrRckCd(selCustomMnrEqStsVOs.get(0).getMnrHngrRckCd());
							}
						}

						//*************************************************
						// 3. tariff type 검증
						//*************************************************
						if(!"CB".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd()) && !"CO".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd()) &&
								!"HO".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd()) && !"HB".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd()) &&
								!"VA".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd()) && !"OT".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd())){
							// 3-1. 콤보 코드 여부 검증
							isSuccess = false;
							sbfVerifyResult.append("Tariff Type is invalid. ");
						}else{
							// 3-2.
							if(!"1".equals(flag)){
								// flag 비선택시, 조회값 셋팅
								customMnrEqStsVOs[i].setMnrHngrTrfCd(selCustomMnrEqStsVOs.get(0).getMnrHngrTrfCd());
							}
						}

						//*************************************************
						// 4. triff desc 검증
						//*************************************************
						if("1".equals(flag)){
							// flag 선택시
							if(!"OT".equals(customMnrEqStsVOs[i].getMnrHngrTrfCd())){
								// tariff type = Other 가 아닐 경우, 조회값 셋팅
								customMnrEqStsVOs[i].setMnrHngrTrfOtrDesc(selCustomMnrEqStsVOs.get(0).getMnrHngrTrfOtrDesc());
							}
						}else{
							// flag 비선택시, 조회값 셋팅
							customMnrEqStsVOs[i].setMnrHngrTrfOtrDesc(selCustomMnrEqStsVOs.get(0).getMnrHngrTrfOtrDesc());
						}

						//*************************************************
						// 5. hanger bar type 검증
						//*************************************************
						if(!"S".equals(customMnrEqStsVOs[i].getMnrHngrBarTpCd()) && !"D".equals(customMnrEqStsVOs[i].getMnrHngrBarTpCd())){
							// 5-1. 콤보 코드 여부 검증
							isSuccess = false;
							sbfVerifyResult.append("Hanger Bar Type is invalid. ");
						}else{
							if("1".equals(flag)){
								if("O".equals(customMnrEqStsVOs[i].getMnrHngrRckCd())){
									// hanger rack type = permanent hanger rack_single(O) 일 경우, 조회값 셋팅
									customMnrEqStsVOs[i].setMnrHngrBarTpCd(selCustomMnrEqStsVOs.get(0).getMnrHngrBarTpCd());
								}
							}else{
								customMnrEqStsVOs[i].setMnrHngrBarTpCd(selCustomMnrEqStsVOs.get(0).getMnrHngrBarTpCd());
							}
						}
						//*************************************************
						// 6. installation bar qty 검증
						//*************************************************
						// 6-1. 자릿수, positive 검증
						if(customMnrEqStsVOs[i].getHngrBarAtchKnt().length() > 6 || customMnrEqStsVOs[i].getActInvtQty().length() > 6
								|| customMnrEqStsVOs[i].getMnrHngrDmgQty().length() > 6 || customMnrEqStsVOs[i].getMnrLostHngrQty().length() > 6
								|| customMnrEqStsVOs[i].getMnrDispHngrQty().length() > 6){
							// 6자리 초과시
							isSuccess = false;
							sbfVerifyResult.append("Please enter numeric to six digits. ");
						}else{
							if(Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) < 0 ){
								// 음수 일 경우
								isSuccess = false;
								sbfVerifyResult.append("Please enter a positive integer. ");
							}else{
								if("1".equals(flag)){
									// installation bar qty = sound + Repairable + Missing + Disposal
									if(Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) != (Integer.parseInt(customMnrEqStsVOs[i].getActInvtQty())
											+ Integer.parseInt(customMnrEqStsVOs[i].getMnrHngrDmgQty()) + Integer.parseInt(customMnrEqStsVOs[i].getMnrLostHngrQty())
											+ Integer.parseInt(customMnrEqStsVOs[i].getMnrDispHngrQty()))){
										isSuccess = false;
										sbfVerifyResult.append("Installation Bar Qty not equals Sound + Repairable + Missing + Disposal. ");
									}
									// installation bar qty = 0 이면 안됨.
									if(Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) == 0){
										isSuccess = false;
										sbfVerifyResult.append("Please input install bar Qty. ");
									}
								}else{
									// flag 비선택시
									// installation bar qty = sound + Repairable + Missing + Disposal
									if(Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) != (Integer.parseInt(customMnrEqStsVOs[i].getActInvtQty())
											+ Integer.parseInt(customMnrEqStsVOs[i].getMnrHngrDmgQty()) + Integer.parseInt(customMnrEqStsVOs[i].getMnrLostHngrQty())
											+ Integer.parseInt(customMnrEqStsVOs[i].getMnrDispHngrQty()))){
										isSuccess = false;
										sbfVerifyResult.append("Installation Bar Qty not equals Sound + Repairable + Missing + Disposal. ");
									}else{
										if(Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) == 0){
											// installation bar qty = 0 일 경우, 오류임.
											isSuccess = false;
											sbfVerifyResult.append("Please input install bar Qty. ");
										}
									}
								}
							}
						}

						//*************************************************
						// 7. Remark 검증
						//*************************************************
						if(customMnrEqStsVOs[i].getHngrBarAtchKnt().length() < 6 && Integer.parseInt(customMnrEqStsVOs[i].getHngrBarAtchKnt()) == 0){
							// installation bar qty = 0 일 경우, 조회값 셋팅
							customMnrEqStsVOs[i].setMnrStsRmk(selCustomMnrEqStsVOs.get(0).getMnrStsRmk());
						}

						// 조회 데이타 셋팅
						customMnrEqStsVOs[i].setEqTpszCd(selCustomMnrEqStsVOs.get(0).getEqTpszCd()); // TP/SZ 셋팅
						customMnrEqStsVOs[i].setMvmtCd(selCustomMnrEqStsVOs.get(0).getMvmtCd()); // MVMT 셋팅
						customMnrEqStsVOs[i].setMnrHngrFlgYdCd(selCustomMnrEqStsVOs.get(0).getMnrHngrFlgYdCd()); // Yard 셋팅
						customMnrEqStsVOs[i].setWoNo(selCustomMnrEqStsVOs.get(0).getWoNo()); // Recently Worked Information
						customMnrEqStsVOs[i].setCreOfcCd(selCustomMnrEqStsVOs.get(0).getCreOfcCd()); // Inventory apply Office 셋팅
						customMnrEqStsVOs[i].setEqKndCd(selCustomMnrEqStsVOs.get(0).getEqKndCd());
						customMnrEqStsVOs[i].setMnrOrdOfcCtyCd(selCustomMnrEqStsVOs.get(0).getMnrOrdOfcCtyCd());
						customMnrEqStsVOs[i].setMnrOrdSeq(selCustomMnrEqStsVOs.get(0).getMnrOrdSeq());
						customMnrEqStsVOs[i].setOfcCd(selCustomMnrEqStsVOs.get(0).getOfcCd());
						customMnrEqStsVOs[i].setMnrStsFlg(selCustomMnrEqStsVOs.get(0).getMnrStsFlg());
					}

					if(isSuccess){
						customMnrEqStsVOs[i].setVerifyResult("SUCCESS");
					}else{
						customMnrEqStsVOs[i].setVerifyResult(sbfVerifyResult.toString());
					}
					rtnCustomMnrEqStsVOs.add(i, customMnrEqStsVOs[i]);
				}// end for
			}

			//set return to event
			eventResponse.setRsVoList(rtnCustomMnrEqStsVOs);

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
	 * EES_MNR_0159 : Re-Bidding <br>
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reBiddingDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		EQFlagMgtBC    command3 = new EQFlagMgtBCImpl();

		EesMnr0159Event event = (EesMnr0159Event)e;
		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			command3.manageEqStsMkrNmMdlNmBasic(disposalGRPVO, account);
			disposalGRPVO = command.reBiddingDisposalBasic(disposalGRPVO,account);

			disposalGRPVO.getDisposalNVO().setInDispStsCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispStsCd());
			disposalGRPVO.getDisposalNVO().setInDispTpCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispTpCd());
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);

			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			customMnrDispHdrVO.setMnrPrnrEml(account.getUsr_eml());
			disposalGRPVO.setCustomMnrDispHdrVO(customMnrDispHdrVO);

			//메일 전송
			disposalGRPVO.setNoticeMailType("ReBidding");
			disposalGRPVO = command.searchDisposalMailListBasic(disposalGRPVO);
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO.setEmailSendInfoVOS(disposalGRPVO.getEmailSendInfoVOS());
			command2.sendHtmlMailBasic(interfaceGRPVO);
			commit();

			eventResponse.setETCData("disp_no",disposalGRPVO.getCustomMnrDispHdrVO().getDispNo());
			eventResponse.setETCData("disp_tp_cd",disposalGRPVO.getCustomMnrDispHdrVO().getDispTpCd());
			eventResponse.setETCData("disp_sts_cd",disposalGRPVO.getCustomMnrDispHdrVO().getDispStsCd());

			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
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
	 * EES_MNR_0159 : Re-Bidding <br>
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDispContractMailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();

		EesMnr0159Event event = (EesMnr0159Event)e;
		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			disposalGRPVO.getDisposalNVO().setInDispStsCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispStsCd());
			disposalGRPVO.getDisposalNVO().setInDispTpCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispTpCd());
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);

			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			customMnrDispHdrVO.setMnrPrnrEml(account.getUsr_eml());
			disposalGRPVO.setCustomMnrDispHdrVO(customMnrDispHdrVO);

			//메일 전송
			disposalGRPVO.setNoticeMailType("Contract");
			disposalGRPVO = command.searchDispContractMailListBasic(disposalGRPVO);
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO.setEmailSendInfoVOS(disposalGRPVO.getEmailSendInfoVOS());
			command2.sendHtmlMailBasic(interfaceGRPVO);
			commit();
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
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
	 *  EES_MNR_0159 : Confirm <br>
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		EQFlagMgtBC    command3 = new EQFlagMgtBCImpl();

		EesMnr0159Event event = (EesMnr0159Event)e;
		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			command3.manageEqStsMkrNmMdlNmBasic(disposalGRPVO, account);
			disposalGRPVO = command.confirmDisposalBasic(disposalGRPVO,account);
			command.addDisposalCofirmSumBasic(disposalGRPVO);

			//조회 조건 추가로 조회조건 바꿔줌
			disposalGRPVO.getDisposalNVO().setInDispStsCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispStsCd());
			disposalGRPVO.getDisposalNVO().setInDispTpCd(disposalGRPVO.getCustomMnrDispHdrVO().getDispTpCd());
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			customMnrDispHdrVO.setMnrPrnrEml(account.getUsr_eml());
			disposalGRPVO.setCustomMnrDispHdrVO(customMnrDispHdrVO);

			//메일 전송	//메일 전송 쿼리 다시생성
			disposalGRPVO = command.searchDSPConfirmMailListBasic(disposalGRPVO);
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO.setGeneralMailFormVOS(disposalGRPVO.getGeneralMailFormVOS());
			command2.sendGeneralMailBasic(interfaceGRPVO);
			commit();

			eventResponse.setETCData("disp_no",disposalGRPVO.getCustomMnrDispHdrVO().getDispNo());
			eventResponse.setETCData("disp_tp_cd",disposalGRPVO.getCustomMnrDispHdrVO().getDispTpCd());
			eventResponse.setETCData("disp_sts_cd",disposalGRPVO.getCustomMnrDispHdrVO().getDispStsCd());

			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
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
	 * EES_MNR_0157 : Save <br>
	 * [EES_MNR_0157]Disposal Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		EQFlagMgtBC    command3 = new EQFlagMgtBCImpl();

		DisposalGRPVO disposalGRPVO = new DisposalGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
			EesMnr0156Event event = (EesMnr0156Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
			EesMnr0157Event event = (EesMnr0157Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		}

		try {
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			customMnrDispHdrVO.setMnrPrnrEml(account.getUsr_eml());
			if(e.getEventName().equalsIgnoreCase("EesMnr0157Event") && customMnrDispHdrVO.getDispStsCd().equals("HC")){
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrDispHdrVO.setAproDt(today);
				customMnrDispHdrVO.setAproUsrId(account.getUsr_id());
			}
			disposalGRPVO.setCustomMnrDispHdrVO(customMnrDispHdrVO);

			begin();
			// MNR_EQ_STS에 eq_mkr_nm eq_mdl_nm 을  받아온 값으로 세팅한다.(2009-11-04)
			// MNR_EQ_STS에 rpr_cost_amt 을  받아온 값으로 세팅한다.(2010-02-18)
			command3.manageEqStsMkrNmMdlNmBasic(disposalGRPVO, account);
			disposalGRPVO = command.manageDisposalBasic(disposalGRPVO,account);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
			//HA일 경우 메일 전송
			//HC일 경우 메일 전송  DispTpCd = C 일 경우 MNR_DISP_BUYR_DTL_PART 값을  넣는다.
			if(customMnrDispHdrVO.getDispStsCd().equals("HC")){
				//Contact 일 경우 MNR_DISP_BUYR_DTL_PART에 한개씩 임으로 넣는다.
				if(customMnrDispHdrVO.getDispTpCd().equals("C")){
					command.addContractDisposalBuyerDTLBasic(disposalGRPVO);
				}
				//HC일 경우 추가 SUM작업
				command.addDisposalCofirmSumBasic(disposalGRPVO);
			}

			//메일 전송
			if(customMnrDispHdrVO.getDispStsCd().equals("HA") && customMnrDispHdrVO.getDispTpCd().equals("B")){
				disposalGRPVO.setNoticeMailType("Approval");
				disposalGRPVO = command.searchDisposalMailListBasic(disposalGRPVO);
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				interfaceGRPVO.setEmailSendInfoVOS(disposalGRPVO.getEmailSendInfoVOS());
				command2.sendHtmlMailBasic(interfaceGRPVO);
			}
			commit();

			eventResponse.setETCData("disp_no",disposalGRPVO.getCustomMnrDispHdrVO().getDispNo());
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0098 : Delete <br>
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		//HISTORY
		StatusHistoryMgtBC command5 = new StatusHistoryMgtBCImpl();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();

		EesMnr0098Event event = (EesMnr0098Event)e;
		TotalLossGRPVO totalLossGRPVO = event.getTotalLossGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		try {
			begin();
			int delCnt=0;
			int notDsCnt=0;
			int notDvCnt=0;
			CustomMnrTtlLssRqstDtlVO[]  arrayCustomMnrTtlLssRqstDtlVOs  = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
				//삭제된 DTL 갯수 계산
				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))delCnt++;
				// DV를 제외한  DTL 갯수 계산
				if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))notDvCnt++;
				// DS를 제외한  DTL 갯수 계산
				if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))notDsCnt++;
			}
			InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
			ExpenseMgtBC command2 = new ExpenseMgtBCImpl();
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
					/** CSR Temp Table에 rollback start *****************************************************************/
					if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
						&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
					{
						//AP_PAY_INV  update DELT_FLG = 'Y'
						command1.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
						//MNR_PAY_INV_WRK delete where pay_inv_seq
						if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
						{
							PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
							payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
							payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
							command2.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
						}
					}
					/** CSR Temp Table에 rollback end *****************************************************************/
				}
			}
			//*************** FLAG RollBack처리용 ************************* //
			EQFlagMgtBC command3 = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomMnrTtlLssRqstDtlVOs.length - notDvCnt];
			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS2 = new CustomMnrEqStsVO[arrayCustomMnrTtlLssRqstDtlVOs.length - notDsCnt];
			CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomMnrTtlLssRqstDtlVOs.length -  notDvCnt];
			int flgCnt = 0; //DV, DV Expense 탭 flag 관련갯수
			int flgCnt2 = 0;//DS,Dispsal 텝 flag 관련 갯수
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {

				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")
					|| arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))
				{
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
					{
						//STS VO
						customMnrEqStsVO.setMnrDmgFlgDt(today);
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrEqStsVO.setMnrDmgFlg("0");
						arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

						//FLG_HIS_VO
						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
						customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrFlgHisVO.setMnrFlgInpTpCd("T");
						customMnrFlgHisVO.setMnrFlgTpCd("TLL");
						customMnrFlgHisVO.setMnrFlgInpDt(today);
						customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
						customMnrFlgHisVO.setMnrStsFlg("N");
						arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
						flgCnt++;
					}
					else if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))
					{

						//STS VO
						customMnrEqStsVO.setMnrDispSelFlgDt(today);
						customMnrEqStsVO.setMnrDispSelFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrEqStsVO.setMnrDispSelFlg("0");
						arrCustomMnrEqStsVOS2[flgCnt2] = customMnrEqStsVO;
						flgCnt2++;
					}
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd("TLL");
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			command3.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직 ROLLBACK
			//*************** FLAG END   ************************* //

			/***************** MST 외부 인터페이스 호출을 위한 **********************/
			InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			// Total Loss 데미지 플래그 처리
			for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("TLL");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
				//Damage Flag
				if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			// Disposal Candidate Selection flag 처리
			for(int i = 0;i < arrCustomMnrEqStsVOS2.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("DSP");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS2[i].getEqKndCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS2[i].getEqNo());
				//Disposal Flag
				if(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

			/***************** MST 외부 인터페이스 호출을 위한 *********************/
			command4.manageIFFlagBasic(interfaceGRPVO,account);         //MST/CGM 로직 호출  ROLLBACK

			//TOTAL LOSS 삭제처리
			totalLossGRPVO = command.removeTotalLossBasic(totalLossGRPVO,account);

			//Total Loss History 삭제
			if(!totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo().equalsIgnoreCase("")) {
				statusHistoryGRPVO.setMnrStsRefNo(totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo());
				command5.removeStatusHistorysAllBasic(statusHistoryGRPVO, account);
			}
			commit();

			//TOTAL LOSS 조회
			totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
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
	 * EES_MNR_0095 : Delete <br>
	 * [EES_MNR_0095]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTotalLossGRPService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		StatusHistoryMgtBC command1 = new StatusHistoryMgtBCImpl();

		EesMnr0095Event event = (EesMnr0095Event)e;
		TotalLossGRPVO totalLossGRPVO = event.getTotalLossGRPVO();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			totalLossGRPVO = command.removeTotalLossGRPBasic(totalLossGRPVO,account);
			//HISTORY 삭제
			statusHistoryGRPVO.setMnrStsRefNo(totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo());
			command1.removeStatusHistorysAllBasic(statusHistoryGRPVO, account);
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
	 * EES_MNR_0159 : Delete <br>
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();

		DisposalGRPVO disposalGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
			EesMnr0156Event event = (EesMnr0156Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
			EesMnr0157Event event = (EesMnr0157Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
			EesMnr0159Event event = (EesMnr0159Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			disposalGRPVO = command.removeDisposalBasic(disposalGRPVO,account);
			commit();
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
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
	* EES_MNR_0164 : Retrieve <br>
	* [EES_MNR_0164]Disposal Request의 정보를 조회 합니다. <br>
	*
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDisposalListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalGRPVO disposalGRPVO = null;
			if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
				EesMnr0156Event event = (EesMnr0156Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
				EesMnr0157Event event = (EesMnr0157Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
				EesMnr0159Event event = (EesMnr0159Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0164Event")){
				EesMnr0164Event event = (EesMnr0164Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			}
			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0164 : Delete <br>
	 * [EES_MNR_0164]Disposal Request의 정보를 삭제(Reject) 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDisposalListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();

		EesMnr0164Event event = (EesMnr0164Event)e;
		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			disposalGRPVO = command.removeDisposalListData(disposalGRPVO,account);
			commit();

			disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
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
	* EES_MNR_0200 : doActionIBSheet <br>
	* [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
	*
	* @param String eventName
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDisposalService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();

			DisposalGRPVO disposalGRPVO = null;
			if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
				EesMnr0156Event event = (EesMnr0156Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
				disposalGRPVO.setBuyerNoOuterJoinFlg("Y"); // buyer list를 outer 없이 선택된 것만 가지고 옴.
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
				EesMnr0157Event event = (EesMnr0157Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
				disposalGRPVO.setBuyerNoOuterJoinFlg("Y"); // buyer list를 outer 없이 선택된 것만 가지고 옴.
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
				EesMnr0159Event event = (EesMnr0159Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
				disposalGRPVO.setBuyerNoOuterJoinFlg("Y"); // buyer list를 outer 없이 선택된 것만 가지고 옴.
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0200Event")){
				EesMnr0200Event event = (EesMnr0200Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0167Event")){
				EesMnr0167Event event = (EesMnr0167Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			}
			
			if(e.getEventName().equalsIgnoreCase("EesMnr0167Event")){
				disposalGRPVO = command.searchDisposalBasicPopUp(disposalGRPVO);	
			} else {
				disposalGRPVO = command.searchDisposalBasic(disposalGRPVO);
			}

			
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyerPartVOS());
			
			if(!e.getEventName().equalsIgnoreCase("EesMnr0167Event")){
				eventResponse.setRsVoList(disposalGRPVO.getEqCustomMnrDispDtlVOS());
				eventResponse.setRsVoList(disposalGRPVO.getQtyCustomMnrDispDtlVOS());	
			}
			if(e.getEventName().equalsIgnoreCase("EesMnr0159Event") || e.getEventName().equalsIgnoreCase("EesMnr0200Event")){
				disposalGRPVO = command.searchDSPBuyerDTLPartBasic(disposalGRPVO, account);
				eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyrDtlPartVOS());
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	* EES_MNR_0156 : Request <br>
	* [EES_MNR_0156]Disposal Request의 정보를 조회 합니다. <br>
	*
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDSPPartnerService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			PartnerMgtBC command = new PartnerMgtBCImpl();
			EesMnr0156Event event = (EesMnr0156Event)e;
			DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
			disposalGRPVO = command.searchDSPPartnerBasic(disposalGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyerPartVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

   /**
	* EES_MNR_0028 : Retrieve <br>
	* [EES_MNR_0028]Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	*
	* @param Event e
	* @param RepairCollectionGRPVO repairCollectionGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchRepairInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();

			RepairCollectionGRPVO repairCollectionGRPVO = null;
			if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
				EesMnr0027Event event = (EesMnr0027Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
				EesMnr0028Event event = (EesMnr0028Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS027Event")){
				EesMnrS027Event event = (EesMnrS027Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
				repairCollectionGRPVO.setCurrSystem("SPP");
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS028Event")){
				EesMnrS028Event event = (EesMnrS028Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
				repairCollectionGRPVO.setCurrSystem("SPP");
			}

			repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
   /**
	* EES_MNR_0028 : Retrieve <br>
	* [EES_MNR_0028]Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	*
	* @param Event e
	* @param RepairCollectionGRPVO repairCollectionGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchRepairInquiryListServiceForHJS(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();

			RepairCollectionGRPVO repairCollectionGRPVO = null;
			
			EesMnr0028Event event = (EesMnr0028Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();

			repairCollectionGRPVO = command.searchRepairInquiryListForHJS(repairCollectionGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0192 : doActionIBSheet <br>
	 * [EES_MNR_0192]Estimate Detail_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateByEQService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0192Event event = (EesMnr0192Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();
			if(estimateGRPVO.getEstimateINVO().getEstTemp().equalsIgnoreCase("Y")){
				estimateGRPVO = command.searchEDIEstimateBasic(estimateGRPVO);
			} else {
				estimateGRPVO = command.searchEstimateBasic(estimateGRPVO,account);
			}
			eventResponse.setETCData(estimateGRPVO.getCustomMnrRprRqstHdrVO().getColumnValues());
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0023 : Caculation <br>
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEstimateCalcService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		EstimateUploadVO[] estimateUploadVOS = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//0023
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		//0243
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0243Event")){
			EesMnr0243Event event = (EesMnr0243Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateUploadVOS = event.getEstimateUploadVOs();
		}

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();

		/* 추가 부분 세팅 START
		: INP_MSG35 = AGMT_OFC_CTY_CD
		: INP_MSG36 = AGMT_SEQ
		: INP_MSG37 = 'NNN'
		: INP_MSG4  = 'SS'
		*/
		CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = null;
		customMnrDatVrfyVOS = estimateGRPVO.getCustomMnrDatVrfyVOS();
		GeneralCodeSearchMgtBC command1 = new GeneralCodeSearchMgtBCImpl();

 		for(int i = 0;i < customMnrDatVrfyVOS.length; i++){
			customMnrDatVrfyVOS[i].setInpMsg35(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtOfcCtyCd());
			customMnrDatVrfyVOS[i].setInpMsg36(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtSeq());
			customMnrDatVrfyVOS[i].setInpMsg37("NNN");
			customMnrDatVrfyVOS[i].setInpMsg4("SS");

			//COST_CD 가 누락되어   없으면  여기서 다시 체크하여 넣어준다. INP_MSG19 ,ex) MRRURC
			//누락 되는 케이스를 찾을수가 없음 로그가 필요함
			if(customMnrDatVrfyVOS[i].getInpMsg19().equals("") || customMnrDatVrfyVOS[i].getInpMsg19() ==  null){
				//log.error("☞☞☞☞☞☞☞  COST_CD NOT EXIST ");
				//log.error("☞☞☞☞☞☞☞  EQ No : " + estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo());
				//log.error("☞☞☞☞☞☞☞  Estimate No : " + estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstRefNo());
				//log.error("☞☞☞☞☞☞☞  EQ TPSZ : " + estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd());
				//log.error("☞☞☞☞☞☞☞  Componet CD : " + customMnrDatVrfyVOS[i].getInpMsg19());

				if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("U")){
					if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("D")){
						customMnrDatVrfyVOS[i].setInpMsg19("MRDRRC");
					} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("R")){
						CostCodeINVO costCodeINVO = new CostCodeINVO();
						//Component Code
						costCodeINVO.setCmpoCd(customMnrDatVrfyVOS[i].getInpMsg2());
						//Tpsz
						costCodeINVO.setTpSz(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd());
						CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
						costCodeGRPVO.setCostCodeINVO(costCodeINVO);
						costCodeGRPVO = command1.searchCostCodeBasic(costCodeGRPVO);
						List<CustomCostCodeVO> customCostCodeVOS = costCodeGRPVO.getCustomCostCodeVOS();
						if(customCostCodeVOS.size() > 0){
							customMnrDatVrfyVOS[i].setInpMsg19(customCostCodeVOS.get(0).getCostCd());
						} else {
							//DEFAULT
							customMnrDatVrfyVOS[i].setInpMsg19("MRRURC");
						}
					} else {
						customMnrDatVrfyVOS[i].setInpMsg19("MRDSRC");
					}
				} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("G")){
					customMnrDatVrfyVOS[i].setInpMsg19("MRGSRC");
				} else {
					customMnrDatVrfyVOS[i].setInpMsg19("MRZSRC");
				}
			}
			//COST_DTL_CD가 누락되어 없으면 여기서 다시 체크하여 넣어준다. INP_MSG20 ,ex) NR
			if(customMnrDatVrfyVOS[i].getInpMsg20().equals("") || customMnrDatVrfyVOS[i].getInpMsg20() ==  null){
				customMnrDatVrfyVOS[i].setInpMsg20("NR");
			}
		}
		/* 추가 부분 세팅 END */

		
		
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();
		RepairMgtBC 	  	  command2 = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//값 세팅
			//시퀸스
			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setTmpSeq(seqValue);
			//AGMT
			estimateINVO.setAgmtOfcCtyCd(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtOfcCtyCd());
			estimateINVO.setAgmtSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtSeq());
			estimateINVO.setAgmtVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtVerNo());
			//TRF
			estimateINVO.setTrfNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getTrfNo());
			estimateGRPVO.setEstimateINVO(estimateINVO);

			//비즈로직에 따른 업데이트 진행 //조회시작
			estimateGRPVO = command.verifyEstimateCalcBasic(estimateGRPVO); // <-- 확인 필요
			commit();
			//로직완료
			eventResponse =	command2.searchLatestEstimateBasic(estimateGRPVO);

			// 0243 일 경우
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOs = estimateGRPVO.getCustomMnrRprRqstDtlVOS();
			
			
			if(!e.getEventName().equalsIgnoreCase("EesMnr0243Event")){
				eventResponse.setRsVoList(customMnrRprRqstDtlVOs);
			}else{
			
				List<EstimateUploadVO> list = new ArrayList<EstimateUploadVO>();
				EstimateUploadVO estimateUploadVO = null;

				for(int i = 0;i < customMnrRprRqstDtlVOs.size(); i++){
				
					estimateUploadVO = new EstimateUploadVO();
					
					// 1. 화면 그리드 좌측 eq no 헤더값.(업로드 데이터 그대로 셋팅)
					estimateUploadVO.setRqstEqNo(estimateUploadVOS[i].getRqstEqNo());  
					estimateUploadVO.setRqstRefNo(estimateUploadVOS[i].getRqstRefNo()); 
					estimateUploadVO.setEqDmgDt(estimateUploadVOS[i].getEqDmgDt());
					estimateUploadVO.setCurrCd(estimateUploadVOS[i].getCurrCd());  
					estimateUploadVO.setEdiId(estimateUploadVOS[i].getEdiId());
					estimateUploadVO.setRprOffhFlg(estimateUploadVOS[i].getRprOffhFlg());
					
					// 2. hour, rate 가 있으면, 화면 값 그대로 셋팅. 없으면, 조회값으로 셋팅
					if(!"0".equals(estimateUploadVOS[i].getRprLbrHrs())){
						// hour, rate 업로드 데이터가 있을때, 그대로 셋팅하고, 
						estimateUploadVO.setEqLocCd(estimateUploadVOS[i].getEqLocCd()); // location
						estimateUploadVO.setEqCmpoCd(estimateUploadVOS[i].getEqCmpoCd()); // Component
						estimateUploadVO.setEqDmgCd(estimateUploadVOS[i].getEqDmgCd()); // Damage
						estimateUploadVO.setEqRprCd(estimateUploadVOS[i].getEqRprCd()); // Repair
						estimateUploadVO.setTrfDivCd(estimateUploadVOS[i].getTrfDivCd()); // Division
						estimateUploadVO.setVolTpCd(estimateUploadVOS[i].getVolTpCd()); // Type
						estimateUploadVO.setRprQty(estimateUploadVOS[i].getRprQty()); // Qty	
						estimateUploadVO.setRprSzNo(estimateUploadVOS[i].getRprSzNo()); // Size/Square
						estimateUploadVO.setDispRprLbrHrs(estimateUploadVOS[i].getDispRprLbrHrs());  // hour*qty 
						estimateUploadVO.setRprLbrHrs(estimateUploadVOS[i].getRprLbrHrs());  // hour
						estimateUploadVO.setRprLbrRt(estimateUploadVOS[i].getRprLbrRt()); // Rate
						estimateUploadVO.setMtrlCostAmt(estimateUploadVOS[i].getMtrlCostAmt()); // Material
						// 아래는 조회된 데이터를 셋팅
						estimateUploadVO.setLbrCostAmt(customMnrRprRqstDtlVOs.get(i).getLbrCostAmt()); // Cost						
						estimateUploadVO.setMnrWrkAmt(customMnrRprRqstDtlVOs.get(i).getMnrWrkAmt()); // Amount
						estimateUploadVO.setEdiErrCd(customMnrRprRqstDtlVOs.get(i).getMnrVrfyTpCd()); // 검증 코드
						estimateUploadVO.setEdiErrNm(customMnrRprRqstDtlVOs.get(i).getMnrVrfyTpCd()); // 검증 코드(화면에서 변경)
					}else{
						// 조회값으로 셋팅
						estimateUploadVO.setEqLocCd(customMnrRprRqstDtlVOs.get(i).getEqLocCd()); // location	
						estimateUploadVO.setEqCmpoCd(customMnrRprRqstDtlVOs.get(i).getEqCmpoCd()); // Component
						estimateUploadVO.setEqDmgCd(customMnrRprRqstDtlVOs.get(i).getEqDmgCd()); // Damage
						estimateUploadVO.setEqRprCd(customMnrRprRqstDtlVOs.get(i).getEqRprCd()); // Repair	
						estimateUploadVO.setTrfDivCd(customMnrRprRqstDtlVOs.get(i).getTrfDivCd()); // Division
						estimateUploadVO.setVolTpCd(customMnrRprRqstDtlVOs.get(i).getVolTpCd()); // Type
						estimateUploadVO.setRprQty(customMnrRprRqstDtlVOs.get(i).getRprQty()); // Qty
						estimateUploadVO.setRprSzNo(customMnrRprRqstDtlVOs.get(i).getRprSzNo()); // Size/Square

						estimateUploadVO.setRprLbrHrs(customMnrRprRqstDtlVOs.get(0).getRprLbrHrs());  // hour
						estimateUploadVO.setRprLbrRt(customMnrRprRqstDtlVOs.get(i).getRprLbrRt()); // Rate
						estimateUploadVO.setLbrCostAmt(customMnrRprRqstDtlVOs.get(i).getLbrCostAmt()); // Cost
						estimateUploadVO.setMtrlCostAmt(customMnrRprRqstDtlVOs.get(i).getMtrlCostAmt()); // Material
						estimateUploadVO.setMnrWrkAmt(customMnrRprRqstDtlVOs.get(i).getMnrWrkAmt()); // Amount
						estimateUploadVO.setEdiErrCd(customMnrRprRqstDtlVOs.get(i).getMnrVrfyTpCd()); // 검증 코드
						estimateUploadVO.setEdiErrNm(customMnrRprRqstDtlVOs.get(i).getMnrVrfyTpCd()); // 검증 코드(화면에서 변경)						
					}
					list.add(estimateUploadVO);
				}
				eventResponse.setRsVoList(list);
			}
			
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
	 * EES_MNR_0023 : doActionIBSheet <br>
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = null;
			//0019
			if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
				EesMnr0019Event event = (EesMnr0019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0023
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
				EesMnr0023Event event = (EesMnr0023Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0240
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
				EesMnr0240Event event = (EesMnr0240Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//SPP 0019
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
				EesMnrS019Event event = (EesMnrS019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setCurrSystem("SPP");
			}
			estimateGRPVO = command.searchEstimateBasic(estimateGRPVO,account);
			
			eventResponse.setETCData(estimateGRPVO.getCustomMnrRprRqstHdrVO().getColumnValues());
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0019 : Delete <br>
	 * [EES_MNR_0019]Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeEstimateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		RepairMgtBC command = new RepairMgtBCImpl();
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();

		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		try {
			begin();
			estimateGRPVO = command.removeEstimateBasic(estimateGRPVO);
			commit();

			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setRqstType("rqst_cre");
			estimateINVO.setCostOfcCd(account.getOfc_cd());
			
			//request DT검색 조건 추가
			estimateINVO.setReqStDt(estimateGRPVO.getCustomMnrRprRqstHdrVO().getReqStDt());
			estimateINVO.setReqEndDt(estimateGRPVO.getCustomMnrRprRqstHdrVO().getReqEndDt());
			
			//SPP 조회용
			if(estimateGRPVO.getCurrSystem().equals("SPP")){
				estimateINVO.setVndrSeq(account.getOfc_eng_nm());
			}
			estimateGRPVO.setEstimateINVO(estimateINVO);

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0019 : Save <br>
	 * [EES_MNR_0019]Repair Estimate Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();

		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작

			
			estimateGRPVO = command.manageEstimateBasic(estimateGRPVO,account);
			
			if("Y".equals(estimateGRPVO.getCurrDmgFlg())){
				rollback();
				eventResponse.setETCData("ERR_FLG", "Y");
			}else{
				commit();
				//로직완료

				//저장한 데이타를 조회해서 다시 보냄
				EstimateINVO estimateINVO = new EstimateINVO();
				estimateINVO.setRqstEqNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo());
				estimateINVO.setRprRqstSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstSeq());
				estimateINVO.setRprRqstVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstVerNo());
				
				//request DT검색 조건 추가
				estimateINVO.setReqStDt(estimateGRPVO.getCustomMnrRprRqstHdrVO().getReqStDt());
				estimateINVO.setReqEndDt(estimateGRPVO.getCustomMnrRprRqstHdrVO().getReqEndDt());
				estimateINVO.setRprRqstLstVerFlg("Y");

				//SPP 조회용
				if(estimateGRPVO.getCurrSystem().equals("SPP")){
					estimateINVO.setVndrSeq(account.getOfc_eng_nm());
				}
				//견적서
				estimateINVO.setRqstType("rqst_cre");
				estimateINVO.setCostOfcCd(account.getOfc_cd());
				estimateGRPVO.setEstimateINVO(estimateINVO);
				eventResponse.setETCData(estimateINVO.getColumnValues());
			}
			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0023 : Audit it Later <br>
	 * [EES_MNR_0023]Repair Estimate Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateAuditItLaterService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = null;
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			estimateGRPVO = command.manageEstimateAuditItLaterBasic(estimateGRPVO,account);
			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setRqstEqNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo());
			estimateINVO.setRprRqstSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstSeq());
			estimateINVO.setRprRqstVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstVerNo());
			estimateINVO.setRprRqstLstVerFlg("Y");

			//Repair Estimate Auditing
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());
			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0019 : Request <br>
	 * [EES_MNR_0019]Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestEstimateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();

		CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
		
		//Request DT 검색조건 추가
		String reqStDt = new String();
		String reqEndDt = new String();
	
		reqStDt = customMnrRprRqstHdrVOS[0].getReqStDt();
		reqEndDt = customMnrRprRqstHdrVOS[0].getReqEndDt();
		
		


		try {
			begin();
			for(int i = 0;i < customMnrRprRqstHdrVOS.length;i++){
				CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
				customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS[i];

				/*************** Current Dmg Flag를 조회 틀리면 플레깅처리 ****************/
				boolean isNeedFlagging = false;
				CustomMnrEqStsVVO customMnrEqStsVVO = command2.searchEqInfoBasic(customMnrRprRqstHdrVO.getRqstEqNo());
				String currDmgFlg = customMnrEqStsVVO.getDmgFlag();
				String reqDmgFlg = "N";


				if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
					reqDmgFlg = "Y";
				}

				if(!currDmgFlg.equalsIgnoreCase(reqDmgFlg)){
					isNeedFlagging = true;
				}
				/*************** Current Dmg Flag를 조회 틀리면 플레깅처리 ****************/

				//************** Dmg Flag ****************//
				if(isNeedFlagging){
					/***********************FLAG *********************************/
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Estimate Request");
					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("R");
					customMnrFlgHisVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Estimate Request");

					//RprWrkTpCd 에 따라 달라짐
					if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
						customMnrEqStsVO.setMnrDmgFlg("1");
						customMnrFlgHisVO.setMnrStsFlg("1");
					} else {
						customMnrEqStsVO.setMnrDmgFlg("0");
						customMnrFlgHisVO.setMnrStsFlg("0");
					}

					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

					arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
					arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("DMG");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					/********************** FLAG END **********************************/

					/***************** MST 외부 인터페이스 호출을 위한 **********************/
					InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DMG");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
						//Damage Flag
						if(arrCustomMnrEqStsVOS[j].getMnrDmgFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
					/***************** MST 외부 인터페이스 호출을 위한 *********************/
					command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command3.manageIFFlagBasic(interfaceGRPVO,account);
				}
			}

			//비즈로직에 따른 업데이트 진행 //조회시작
			estimateGRPVO = command.requestEstimateBasic(estimateGRPVO,account);
			commit();
			//로직완료

			//저장한 데이타를 조회해서 다시 보냄
			EstimateINVO estimateINVO = new EstimateINVO();
			//견적서
			estimateINVO.setRqstType("rqst_cre");
			estimateINVO.setCostOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			
			//request DT검색 조건 추가
			estimateINVO.setReqStDt(reqStDt);
			estimateINVO.setReqEndDt(reqEndDt);

			//SPP 조회용
			if(estimateGRPVO.getCurrSystem().equals("SPP")){
				estimateINVO.setVndrSeq(account.getOfc_eng_nm());
			}
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0023 : Counteroffer <br>
	 * [EES_MNR_0023]Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse counterOfferEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			estimateGRPVO = command.counterOfferEstimateBasic(estimateGRPVO,account);
			commit();
			//로직완료

			//저장한 데이타를 조회해서 다시 보냄
			EstimateINVO estimateINVO = new EstimateINVO();
			//견적서
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0023 : Reject <br>
	 * [EES_MNR_0023]Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = null;
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			estimateGRPVO = command.rejectEstimateBasic(estimateGRPVO,account);
			commit();
			//로직완료

			//저장한 데이타를 조회해서 다시 보냄
			EstimateINVO estimateINVO = new EstimateINVO();
			//견적서
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
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
	 * EES_MNR_0023 : Approval <br>
	 * [EES_MNR_0023]Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}

		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();

		//Sorting by 조회조건
		String searchSorting = customMnrRprRqstHdrVO.getSorting();

		/*************** Current Dmg Flag를 조회 틀리면 플레깅처리 ****************/
		boolean isNeedFlagging = false;
		CustomMnrEqStsVVO customMnrEqStsVVO = command2.searchEqInfoBasic(customMnrRprRqstHdrVO.getRqstEqNo());
		String currDmgFlg = customMnrEqStsVVO.getDmgFlag();
		String reqDmgFlg = "N";
		if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
			reqDmgFlg = "Y";
		}
		if(!currDmgFlg.equalsIgnoreCase(reqDmgFlg)){
			isNeedFlagging = true;
		}
		/*************** Current Dmg Flag를 조회 틀리면 플레깅처리 ****************/

		try {
			//로직시작
			begin();
			if(isNeedFlagging){
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
				customMnrEqStsVO.setMnrStsRmk("From Estimate Approval");
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG");
				customMnrFlgHisVO.setMnrFlgInpTpCd("R");
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);
				customMnrFlgHisVO.setMnrFlgRmk("From Estimate Approval");

				//RprWrkTpCd 에 따라 달라짐
				if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
					customMnrEqStsVO.setMnrDmgFlg("1");
					customMnrFlgHisVO.setMnrStsFlg("1");
				} else {
					customMnrEqStsVO.setMnrDmgFlg("0");
					customMnrFlgHisVO.setMnrStsFlg("0");
				}

				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				/********************** FLAG END **********************************/

				/***************** MST 외부 인터페이스 호출을 위한 **********************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
					iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
					iFMnrFlagVO.setFlagUserId(account.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
					//Damage Flag
					if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
				/***************** MST 외부 인터페이스 호출을 위한 *********************/
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
				command3.manageIFFlagBasic(interfaceGRPVO,account);
			}
			estimateGRPVO = command.approvalEstimateBasic(estimateGRPVO,account);

			//approvalEstimateBasic 에서 처리한 놈으로 바까줌
			customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();

			/************** TPB Start ********************/
			if(customMnrRprRqstHdrVO.getN3ptyFlg().equalsIgnoreCase("Y") && customMnrRprRqstHdrVO.getRprStsCd().equalsIgnoreCase("HA")){
				interfaceGRPVO.setTpbRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				interfaceGRPVO.setTpbRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
				interfaceGRPVO.setTpbRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
				command3.createTPBIFBasic(interfaceGRPVO, account);
			}
			/************* TPB End ***********************/
			commit();
			//로직완료

			//저장한 데이타를 조회해서 다시 보냄
			EstimateINVO estimateINVO = new EstimateINVO();
			//견적서
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateINVO.setSorting(searchSorting);
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0139 : Verify <br>
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEQFlagFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0139Event event = (EesMnr0139Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyEQFlagFileListGRPVO eQFlagMgtGRPVO = new VerifyEQFlagFileListGRPVO();
		eQFlagMgtGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//시퀸스 값을 세팅
			eQFlagMgtGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//비즈로직에 따른 업데이트 진행 //조회시작
			eQFlagMgtGRPVO = command.verifyEQFlagFileListBasic(eQFlagMgtGRPVO);
			commit();
			//로직완료

			eventResponse.setRsVoList(eQFlagMgtGRPVO.getCustomMnrDatVrfyVOS());
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
	 * EES_MNR_0219 : Verify <br>
	 * [EES_MNR_0219]M&R Simple WO File Import Pop_Up의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyWOFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0219Event event = (EesMnr0219Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyEQTypeSizeFlagFileListGRPVO eQTypeSizeFlagMgtGRPVO = new VerifyEQTypeSizeFlagFileListGRPVO();
		eQTypeSizeFlagMgtGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//시퀸스 값을 세팅
			eQTypeSizeFlagMgtGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//비즈로직에 따른 업데이트 진행 //조회시작
			eQTypeSizeFlagMgtGRPVO = command.verifyWOFileListBasic(eQTypeSizeFlagMgtGRPVO);
			commit();
			//로직완료
			eventResponse.setRsVoList(eQTypeSizeFlagMgtGRPVO.getCustomMnrDatVrfyVOS());
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
	 * EES_MNR_0220 : Verify <br>
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyDisposalPriceFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0220Event event = (EesMnr0220Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		DisposalPriceFileListGRPVO disposalPriceFileListGRPVO = new DisposalPriceFileListGRPVO();
		disposalPriceFileListGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//시퀸스 값을 세팅
			disposalPriceFileListGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//비즈로직에 따른 업데이트 진행 //조회시작
			disposalPriceFileListGRPVO = command.verifyDisposalPriceFileListBasic(disposalPriceFileListGRPVO);
			commit();

			eventResponse.setRsVoList(disposalPriceFileListGRPVO.getCustomMnrDatVrfyVOS());
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
	 * EES_MNR_0122 : Retrieve <br>
	 * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQFlagListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			String validFlg = "";
			if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")){
				EesMnr0109Event event = (EesMnr0109Event)e;
				event.getEQFlagListINVO().setOfcCd(account.getOfc_cd());
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());

			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){//2012.11.20  조경완 [CHM-201221414-01] [MNR] Damage Flagging/Unflagging [EES_MNR_0122, EES_MNR_S122] OOME 해결을 위한 Validation Script 추가
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				if("".equals(eQFlagListGRPVO.getEQFlagListINVO().getEqList())&&"".equals(eQFlagListGRPVO.getEQFlagListINVO().getMnrDmgFlgYdCd())){
					validFlg = "N";
				} 
			} else {
				EesMnrS122Event event = (EesMnrS122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				if("".equals(eQFlagListGRPVO.getEQFlagListINVO().getEqList())){
					validFlg = "N";
				} 
			}
			
			if(!"N".equals(validFlg)){
				eQFlagListGRPVO = command.searchEQFlagListBasic(eQFlagListGRPVO);
			}
			
			eventResponse.setRsVoList(eQFlagListGRPVO.getCustomMnrEqStsVOS());
			eventResponse.setETCData("validFlg", validFlg);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0151 : Retrieve <br>
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCandidateListFlagService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

			if(e.getEventName().equalsIgnoreCase("EesMnr0151Event")){
				EesMnr0151Event event = (EesMnr0151Event)e;
				disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());
			}

			disposalCandidateFlagGRPVO = command.searchDisposalCandidateFlagListBasic(disposalCandidateFlagGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqRngStsVOS());
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqStsVOS());
			return eventResponse;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0158 : Retrieve <br>
	 * [EES_MNR_0158]Disposal Candidate Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCandidatePopupListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

			EesMnr0158Event event = (EesMnr0158Event)e;
			disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());

			disposalCandidateFlagGRPVO = command.searchDisposalCandidatePopupListBasic(disposalCandidateFlagGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqStsVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0125 : Retrieve <br>
	 * [EES_MNR_0125]Hanger Bar CNTR History의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQFlagHistoryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

			if(e.getEventName().equalsIgnoreCase("EesMnr0111Event")){
				EesMnr0111Event event = (EesMnr0111Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0125Event")){
				EesMnr0125Event event = (EesMnr0125Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
			}

			eQFlagListGRPVO = command.searchEQFlagHistoryListBasic(eQFlagListGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eQFlagListGRPVO.getCustomMnrFlgHisVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0023 : Retrieve <br>
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateSMRListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = null;
			//0019
			if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
				EesMnr0019Event event = (EesMnr0019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0023
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
				EesMnr0023Event event = (EesMnr0023Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setIsEDI("N");
			//0240 (EDI Auditing)
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
				EesMnr0240Event event = (EesMnr0240Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setIsEDI("Y");
			//SPP 19
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
				EesMnrS019Event event = (EesMnrS019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setCurrSystem("SPP");
			}
			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0022 : Retrieve <br>
	 * [EES_MNR_0022]Repair Group Auditing의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTGroupAuditListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EesMnr0022Event event = (EesMnr0022Event)e;
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0022 : Reject,Approval <br>
	 * [EES_MNR_0022]Repair Group Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageESTGroupAuditListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();

		EesMnr0022Event event = (EesMnr0022Event)e;
		EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

		try{
			begin();
			command.manageESTGroupAuditListBasic(estimateGRPVO,account);

			//************* TPB Start ********************//
			InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
			CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
			//Approval 일 경우만
			if(estimateGRPVO.getGroupAuditAction().equals("Approval")){
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				for(int i = 0;i < customMnrRprRqstHdrVOS.length;i ++){
					CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS[i];
					if(customMnrRprRqstHdrVO.getN3ptyFlg().equalsIgnoreCase("Y")){
						interfaceGRPVO.setTpbRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						interfaceGRPVO.setTpbRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
						interfaceGRPVO.setTpbRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
						command1.createTPBIFBasic(interfaceGRPVO, account);
					}
				}
			}
			//************* TPB End *********************//
			commit();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0027 : Cancel <br>
	 * [EES_MNR_0027]Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse manageEstimateCancelService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		RepairCollectionGRPVO repairCollectionGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
			EesMnr0027Event event = (EesMnr0027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
			EesMnr0028Event event = (EesMnr0028Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		}

		try{
			begin();
			command.manageEstimateCancelBasic(repairCollectionGRPVO,account);
			commit();

			repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	 /**
	  * EES_MNR_0027 : Delete <br>
	  * [EES_MNR_0027]Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageRepairDeleteService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		RepairCollectionGRPVO repairCollectionGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
			EesMnr0027Event event = (EesMnr0027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
			EesMnr0028Event event = (EesMnr0028Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS027Event")){
			EesMnrS027Event event = (EesMnrS027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		}

		try{
			begin();
			command.manageRepairDeleteBasic(repairCollectionGRPVO,account);
			commit();

			repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	 /**
	  * EES_MNR_0122 : Save <br>
	  * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 추가/수정/삭제 합니다. <br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageEQFlagListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command3 = new HangerInventoryMgtBCImpl();

		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		try{

			if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")){
				EesMnr0109Event event = (EesMnr0109Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());


				//0058 extra work order MnrStsRmk 와 구분
				CustomMnrEqStsVO[] customMnrEqStsVO1 = event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS();
				for(int i = 0;i < customMnrEqStsVO1.length; i++){
					event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS()[i].setMnrStsRmk("");
				}
				CustomMnrEqStsVO[] customMnrEqStsVO2 = event.getCustomMnrEqStsVOs();
				for(int i = 0;i < customMnrEqStsVO2.length; i++){
					event.getCustomMnrEqStsVOs()[i].setMnrStsRmk("");
				}

				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
				hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS());
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
			} else {
				EesMnrS122Event event = (EesMnrS122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
			}

			/***************** MST 외부 인터페이스 호출을 위한 **********************/
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

			CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
			for(int i = 0;i < customMnrEqStsVOS.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd());
				iFMnrFlagVO.setRetireFlag("N");
				if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")) {
					iFMnrFlagVO.setEqKindCd(eQFlagListGRPVO.getEQFlagListINVO().getEqKndCd());
				}else{
					iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
				}
				iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());

				//Damage Flag
				if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("DMG")){
					//플레깅 상태
					if(customMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}

					iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
				//Hanger Flag
				} else {
					//플레깅 상태
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}

					iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrHngrFlgDt().replace("-", ""));
					iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
					iFMnrFlagVO.setHrType(customMnrEqStsVOS[i].getMnrHngrRckCd());
					iFMnrFlagVO.setHbType(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
					iFMnrFlagVO.setHbCount(customMnrEqStsVOS[i].getHngrBarAtchKnt());
				}
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			/***************** MST 외부 인터페이스 호출을 위한 *********************/

			begin();
			command.manageEQFlagListBasic(eQFlagListGRPVO,account);
			if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("HGR")){
				command3.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
			}
			command2.manageIFFlagBasic(interfaceGRPVO,account);
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
	  * EES_MNR_0109 : Save <br>
	  * [EES_MNR_0109]Hanger Rack & Bar Installation/Removal의 정보를 추가/수정 합니다. <br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageHangerRackBarService(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		 	HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			EQFlagMgtBC command1 = new EQFlagMgtBCImpl();
			InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
			HangerInventoryMgtBC command3 = new HangerInventoryMgtBCImpl();

			CustomMnrEqStsVO[] customMnrEqStsVOS = null;
			EQFlagListINVO eQFlagListINVO = null;
			CustomMnrFlgHisVO[] customMnrFlgHisVOS = null;

			EesMnr0109Event event = (EesMnr0109Event)e;
			hangerInventoryListGRPVO = event.getHangerInventoryListGRPVO();
			customMnrEqStsVOS 		 = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();
			eQFlagListINVO 			 = hangerInventoryListGRPVO.getEQFlagListINVO();
			if (customMnrEqStsVOS != null) {
				customMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrEqStsVOS.length];
			}

			try {
				//로직시작
				begin();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				if(customMnrEqStsVOS != null) {
					for(int i = 0;i < customMnrEqStsVOS.length; i++){
						java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
						String today = formatter.format(new java.util.Date());
						customMnrEqStsVOS[i].setMnrHngrFlgDt(today);

						//체크 박스값 Y/N으로 변경
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("1")){
							customMnrEqStsVOS[i].setMnrHngrFlg("Y");
						} else {
							customMnrEqStsVOS[i].setMnrHngrFlg("N");
						}
						customMnrEqStsVOS[i].setMnrDmgFlg("N");

						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("HGR");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrHngrFlgDt());
						iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());

						int attachCnt = 0;
						//Hanger Rack/Bar Installation 일때
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){
							iFMnrFlagVO.setHrType(customMnrEqStsVOS[i].getMnrHngrRckCd());
							iFMnrFlagVO.setHbType(customMnrEqStsVOS[i].getMnrHngrBarTpCd());

							attachCnt = Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						} else { //Hanger Rack/Bar Removal 일때
							if(customMnrEqStsVOS[i].getMnrHngrRckCd().equals("O")){
								iFMnrFlagVO.setHrType("O");
								iFMnrFlagVO.setHbType("S");
							} else {
								iFMnrFlagVO.setHrType("");
								iFMnrFlagVO.setHbType("");
							}
						}

						//
						customMnrEqStsVOS[i].setHngrBarAmdQty(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						customMnrEqStsVOS[i].setHngrBarAtchKnt(String.valueOf(attachCnt));

						iFMnrFlagVO.setHbCount(String.valueOf(attachCnt));
						iFMnrFlagVO.setStsFlag(customMnrEqStsVOS[i].getMnrHngrFlg());
						iFMnrFlagVOS.add(iFMnrFlagVO);

						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVOS[i].getMnrHngrFlg());
						customMnrFlgHisVO.setMnrFlgTpCd("HGR");
						customMnrFlgHisVO.setMnrFlgInpTpCd("M");
						customMnrFlgHisVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVOS[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
						customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
						customMnrFlgHisVO.setMnrHngrRckCd(customMnrEqStsVOS[i].getMnrHngrRckCd());
						customMnrFlgHisVO.setHngrBarAmdQty(customMnrEqStsVOS[i].getHngrBarAtchKnt());   //설치 제거 갯수
						customMnrFlgHisVO.setHngrBarTtlQty(String.valueOf(attachCnt));		    		//실부착 갯수
						String actType = "Install";
						//제거
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("N")){
							customMnrFlgHisVO.setActInvtQty(customMnrEqStsVOS[i].getActInvtQty());
							customMnrFlgHisVO.setMnrHngrDmgQty(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							customMnrFlgHisVO.setMnrLostHngrQty(customMnrEqStsVOS[i].getMnrLostHngrQty());
							customMnrFlgHisVO.setMnrDispHngrQty(customMnrEqStsVOS[i].getMnrDispHngrQty());
							actType = "Removal";
						}

						customMnrFlgHisVO.setMnrFlgRmk(actType + " by Manual " + customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + account.getOfc_cd() + "] [" + account.getUsr_id()+ "]");
						customMnrFlgHisVO.setMnrOrdOfcCtyCd(customMnrEqStsVOS[i].getMnrOrdOfcCtyCd());
						customMnrFlgHisVO.setMnrOrdSeq(customMnrEqStsVOS[i].getMnrOrdSeq());
						customMnrFlgHisVO.setMnrHngrTrfCd(customMnrEqStsVOS[i].getMnrHngrTrfCd());
						customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrEqStsVOS[i].getMnrHngrTrfOtrDesc());

						customMnrFlgHisVOS[i] = customMnrFlgHisVO;
						customMnrEqStsVOS[i].setMnrStsRmk(customMnrFlgHisVO.getMnrFlgRmk());
						//없으면 History Remark 그대로 넣어줌
//						if(customMnrEqStsVOS[i].getMnrStsRmk().equals("") || customMnrEqStsVOS[i].getMnrStsRmk() == null){
//							customMnrEqStsVOS[i].setMnrStsRmk(customMnrFlgHisVO.getMnrFlgRmk());
//						}
					}
				}
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

				if(customMnrEqStsVOS != null) {
					//Manual Inventory BC 다시 구현
					command3.manageHangerRackBarManualInventoryBasic(hangerInventoryListGRPVO,account);
					command1.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command2.manageIFFlagBasic(interfaceGRPVO,account);

				}
				commit();
				//로직완료
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
	  * EES_MNR_0151 : Save <br>
	  * [EES_MNR_0151]Disposal Candidate Selection의 정보를 추가/수정/삭제 합니다. <br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageDisposalCandidateFlagService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

		try{
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			if(e.getEventName().equalsIgnoreCase("EesMnr0151Event"))
			{
				EesMnr0151Event event = (EesMnr0151Event)e;
				disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());
				disposalCandidateFlagGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				disposalCandidateFlagGRPVO.setArrCustomMnrEqRngStsVOS(event.getCustomMnrEqRngStsVOs());

				CustomMnrEqRngStsVO[] customMnrEqRngStsVOS = disposalCandidateFlagGRPVO.getarrCustomMnrEqRngStsVOS();
				CustomMnrEqStsVO[] customMnrEqStsVOS = disposalCandidateFlagGRPVO.getArrCustomMnrEqStsVOS();

				String selectCd = disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd();
				/***************** MST 외부 인터페이스 호출을 위한 **********************/
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

				//Selection Type = EQ Range
				if(selectCd.equalsIgnoreCase("R"))
				{
					for ( int i=0; i < customMnrEqRngStsVOS.length; i++ ) {
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DSP");
						iFMnrFlagVO.setRetireFlag("N");
						if(customMnrEqRngStsVOS[i].getMnrDispSelFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						disposalCandidateFlagGRPVO.setEqFrNo(customMnrEqRngStsVOS[i].getFmSerNo());
						disposalCandidateFlagGRPVO.setEqToNo(customMnrEqRngStsVOS[i].getToSerNo());
						disposalCandidateFlagGRPVO.setEqPfx(customMnrEqRngStsVOS[i].getLotEqPfxCd());
						disposalCandidateFlagGRPVO.setIFMnrFlagVO(iFMnrFlagVO);

						//Range 안에 Eq_no를 구해온다.
						disposalCandidateFlagGRPVO = command.searchRangeToEQNoBasic(disposalCandidateFlagGRPVO);
						List<IFMnrFlagVO> searchIFMnrFlagVOS  = disposalCandidateFlagGRPVO.getIFMnrFlagVOS();
						//조회해온 결과를 담는다.
						for ( int j = 0; j < searchIFMnrFlagVOS.size(); j++ ) {
							iFMnrFlagVOS.add(searchIFMnrFlagVOS.get(j));
						}
					}
					disposalCandidateFlagGRPVO.setArrCustomMnrEqRngStsVOS(customMnrEqRngStsVOS);
				//Selection Type = EQ No
				} else if(selectCd.equalsIgnoreCase("N")){
					for(int i = 0;i < customMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DSP");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						if(customMnrEqStsVOS[i].getMnrDispSelFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						customMnrEqStsVOS[i].setMnrDispSelFlgDt(today);
						iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDispSelFlgDt());
						iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDispSelFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					disposalCandidateFlagGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
				/***************** MST 외부 인터페이스 호출을 위한 *********************/
			}

			begin();
			command.manageDisposalCandidateFlagBasic(disposalCandidateFlagGRPVO,account);
			command3.manageIFFlagBasic(interfaceGRPVO,account);    //MST 외부 인터페이스 호출
			commit();
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	 /**
	  * EES_MNR_0191 : Retrieve <br>
	  * [EES_MNR_0191]Repair History_Pop Up의 정보를 조회 합니다. <br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	private EventResponse searchEQWorkOrderHistoryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0191Event event = (EesMnr0191Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO = new EQWorkOrderHistoryListGRPVO();
			eQWorkOrderHistoryListGRPVO.setEQWorkOrderHistoryListINVO(event.getEQWorkOrderHistoryListINVO());

			eQWorkOrderHistoryListGRPVO = command.searchEQWorkOrderHistoryListBasic(eQWorkOrderHistoryListGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eQWorkOrderHistoryListGRPVO.getCustomEQWorkOrderHistoryListVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0194 : Retrieve <br>
	 * [EES_MNR_0194]Reefer Spare Part Summary List의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWOInfoListBySparePartService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			SparePartWOGRPVO sparePartWOGRPVO = new SparePartWOGRPVO();
			RepairMgtBC command = new RepairMgtBCImpl();
			if(e.getEventName().equalsIgnoreCase("EesMnr0194Event"))
			{
				EesMnr0194Event event = (EesMnr0194Event)e;

				sparePartWOGRPVO.setSparePartWOINVO(event.getSparePartWOINVO());

				sparePartWOGRPVO = command.searchWOInfoListBySparePartBasic(sparePartWOGRPVO);
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0055Event"))
			{
				EesMnr0055Event event = (EesMnr0055Event)e;
				sparePartWOGRPVO.setSparePartWOINVO(event.getSparePartWOINVO());

				sparePartWOGRPVO = command.searchWOInfoListBySparePartBasic(sparePartWOGRPVO);
			}

			eventResponse.setRsVoList(sparePartWOGRPVO.getMnrOrderInfoBySparePartVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * [EES_MNR_0211]  Tire Purchase W/O을 팝업형태로 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWONoInquiryListService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0211Event event = (EesMnr0211Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			WONoInquiryListGRPVO wONoInquiryListGRPVO = command.searchWONoInquiryListBasic(event.getWONoInquiryListGRPVO());
			eventResponse.setRsVoList(wONoInquiryListGRPVO.getArrWONoInquiryVOS());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;


	}

	/**
	 * EES_MNR_0226 : sheet1_cost_dtl_cd_OnChange <br>
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse getBzcAmtService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO=new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				EesMnr0058Event event = (EesMnr0058Event)e;
				generalWOGRPVO = command.getBzcAmtBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.getBzcAmtBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomBzcAmtVOLST());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * EES_MNR_0058 : doIBSEARCH <br>
     * [EES_MNR_0058]M&R Extra Expense W/O Creation의 정보를 조회 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchExtraWOService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				EesMnr0058Event event = (EesMnr0058Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0227Event"))
			{
				EesMnr0227Event event = (EesMnr0227Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;


	}

	/**
	 * EES_MNR_0058 : doIBSAVE <br>
	 * [EES_MNR_0058]M&R Extra Expense W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExtraWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
		{
			EesMnr0058Event event = (EesMnr0058Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
			eQFlagListGRPVO.setEQFlagListINVO(event.getGeneralWOGRPVO().getEQFlagListINVO());
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command4 = new HangerInventoryMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			generalWOGRPVO = command.manageExtraWOBasic(generalWOGRPVO, account);

			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				//Flag처리,HangerInventory처리, MST 외부 인터페이스 호출 추가
				CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
				CustomMnrEqStsVO[] customMnrEqStsVOS = new CustomMnrEqStsVO[customMnrOrdDtlVOS.length];
				CustomMnrFlgHisVO[] customMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrOrdDtlVOS.length];

				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

				if(customMnrOrdDtlVOS != null){
					//Container - Hanger 일때만 Flagging 처리
					String costCd = customMnrOrdDtlVOS[0].getCostCd();
					//Hanger Rack/Bar Installation, Removal 일때
					if(costCd.equals("MRDRHA") || costCd.equals("MRDRHD")) {
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());

							//Hanger Rack/Bar Installation 일때
							int attachCnt = 0;	//실부착 갯수
							if(costCd.equals("MRDRHA")){
								customMnrEqStsVO.setMnrHngrFlg("Y");
								attachCnt = Integer.parseInt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
								customMnrEqStsVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							} else { //Hanger Rack/Bar Removal 일때
								attachCnt = 0;
								customMnrEqStsVO.setMnrHngrFlg("N");
								if(customMnrOrdDtlVOS[i].getMnrHngrRckCd().equals("O")){
									customMnrEqStsVO.setMnrHngrRckCd("O");
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								} else {
									customMnrEqStsVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
									customMnrEqStsVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
								}
								customMnrEqStsVO.setActInvtQty(customMnrOrdDtlVOS[i].getActInvtQty());
								customMnrEqStsVO.setMnrHngrDmgQty(customMnrOrdDtlVOS[i].getMnrHngrDmgQty());
								customMnrEqStsVO.setMnrLostHngrQty(customMnrOrdDtlVOS[i].getMnrLostHngrQty());
								customMnrEqStsVO.setMnrDispHngrQty(customMnrOrdDtlVOS[i].getMnrDispHngrQty());
							}


							customMnrEqStsVO.setHngrBarAtchKnt(String.valueOf(attachCnt));
							customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
							customMnrEqStsVO.setMnrDmgFlg("N");
							customMnrEqStsVO.setMnrStsRmk("By Work Order");
							customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
							customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
							customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
							customMnrEqStsVO.setMnrHngrTrfCd(customMnrOrdDtlVOS[i].getMnrHngrTrfCd());
							customMnrEqStsVO.setMnrHngrTrfOtrDesc(customMnrOrdDtlVOS[i].getMnrHngrTrfOtrDesc());
							customMnrEqStsVOS[i] = customMnrEqStsVO;

							IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
							iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
							iFMnrFlagVO.setFlagUserId(account.getUsr_id());
							iFMnrFlagVO.setFlagType("HGR");
							iFMnrFlagVO.setRetireFlag("N");
							iFMnrFlagVO.setEqKindCd(customMnrOrdDtlVOS[i].getEqKndCd());
							iFMnrFlagVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							iFMnrFlagVO.setFlagDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
							iFMnrFlagVO.setFlagYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());

							//Hanger Rack/Bar Installation 일때
							if(costCd.equals("MRDRHA")){
								iFMnrFlagVO.setHrType(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
								iFMnrFlagVO.setHbType(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							} else { //Hanger Rack/Bar Removal 일때
								if(customMnrEqStsVO.getMnrHngrRckCd().equals("O")){
									iFMnrFlagVO.setHrType("O");
									iFMnrFlagVO.setHbType("S");
								} else {
									iFMnrFlagVO.setHrType("");
									iFMnrFlagVO.setHbType("");
								}
							}

							iFMnrFlagVO.setHbCount(String.valueOf(attachCnt));
							iFMnrFlagVO.setStsFlag(customMnrEqStsVO.getMnrHngrFlg());
							iFMnrFlagVOS.add(iFMnrFlagVO);

							CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
							customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrHngrFlg());
							customMnrFlgHisVO.setMnrFlgTpCd("HGR");
							customMnrFlgHisVO.setMnrFlgInpTpCd("W");
							customMnrFlgHisVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							customMnrFlgHisVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
							customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							customMnrFlgHisVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
							customMnrFlgHisVO.setHngrBarAmdQty(customMnrOrdDtlVOS[i].getRprQty());
							customMnrFlgHisVO.setHngrBarTtlQty(String.valueOf(attachCnt));
							if(costCd.equals("MRDRHD")){
								customMnrFlgHisVO.setActInvtQty(customMnrOrdDtlVOS[i].getActInvtQty());
								customMnrFlgHisVO.setMnrHngrDmgQty(customMnrOrdDtlVOS[i].getMnrHngrDmgQty());
								customMnrFlgHisVO.setMnrLostHngrQty(customMnrOrdDtlVOS[i].getMnrLostHngrQty());
								customMnrFlgHisVO.setMnrDispHngrQty(customMnrOrdDtlVOS[i].getMnrDispHngrQty());
							}
							customMnrFlgHisVO.setMnrOrdOfcCtyCd(customMnrOrdDtlVOS[i].getMnrOrdOfcCtyCd());
							customMnrFlgHisVO.setMnrOrdSeq(customMnrOrdDtlVOS[i].getMnrOrdSeq());
							customMnrFlgHisVO.setMnrHngrTrfCd(customMnrOrdDtlVOS[i].getMnrHngrTrfCd());
							customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrOrdDtlVOS[i].getMnrHngrTrfOtrDesc());

							customMnrFlgHisVOS[i] = customMnrFlgHisVO;
						}

						eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
						eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
						eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
						hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
						interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

						command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
						command3.manageIFFlagBasic(interfaceGRPVO,account);
					//COST TYPE이  Other 일때
					} else if(costCd.equals("MRDROT")) {
						List<CustomMnrEqStsVO> listCustomMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>();

						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							//Extra Expense Type이 Hanger Bar(Square,Round) Purchasing 일때
							if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1") || customMnrOrdDtlVOS[i].getCostDtlCd().equals("MD")){
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
								customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
								customMnrEqStsVO.setHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrFlg("N");
								customMnrEqStsVO.setMnrDmgFlg("N");
								customMnrEqStsVO.setMnrStsRmk("By Work Order");
								customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
								customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
								customMnrEqStsVO.setMnrHngrDtlOffrDesc(customMnrOrdDtlVOS[i].getMnrHngrDtlOffrDesc());

								if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1")){
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								}else{
									customMnrEqStsVO.setMnrHngrBarTpCd("D");
								}
								listCustomMnrEqStsVO.add(customMnrEqStsVO);
							}
						}

						if(listCustomMnrEqStsVO.size() > 0){
							CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[listCustomMnrEqStsVO.size()];
							for (int i = 0; i < listCustomMnrEqStsVO.size(); i++) {
								arrCustomMnrEqStsVOS[i] = listCustomMnrEqStsVO.get(i);
							}

							hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
							command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						}
					}
				}
			}


			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			GeneralWOINVO extraWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			extraWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(extraWOINVO);
			eventResponse.setETCData(extraWOINVO.getColumnValues());

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
	 * EES_MNR_0058 : Delete <br>
	 * [EES_MNR_0058]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
		{
			EesMnr0058Event event = (EesMnr0058Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
		{
			EesMnr0052Event event = (EesMnr0052Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0054Event"))
		{
			EesMnr0054Event event = (EesMnr0054Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command4 = new HangerInventoryMgtBCImpl();

		try {
			//로직시작
			begin();

			//EXT WO만 행거 인벤토리 로직 롤백
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event")){
				//mnrOrdSeq 에 전체 WO NO 가 담겨서 날라옴 ....
				CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();
				String mnrOrdOfcCtyCd = "";
				String mnrOrdSeq = "";
				String woNo = customMnrOrdHdrVO.getMnrOrdSeq();
				if(woNo != null && !woNo.equals("")){
					mnrOrdOfcCtyCd = woNo.substring(0,3);
					mnrOrdSeq = woNo.substring(3);
				}

				//Flag처리,HangerInventory처리, MST 외부 인터페이스 호출 추가
				CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();

				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrEqStsVO> tmpCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrFlgHisVO> customMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();

				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

				if(customMnrOrdDtlVOS != null){
					//Container - Hanger 일때만 Flagging 처리
					String costCd = customMnrOrdDtlVOS[0].getCostCd();
					//Hanger Rack/Bar Installation, Removal 일때
					if(costCd.equals("MRDRHA") || costCd.equals("MRDRHD")) {
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							//가장 최근 데이타 조회하기 위한 세팅 중간[메뉴얼]로 인한 변경사항 체크 위해
							EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
							eQFlagListINVO.setEqList(customMnrOrdDtlVOS[i].getEqNo());
							eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);

							//가장 최근 데이타로 다시 조회해 온다.
							eQFlagListGRPVO = command2.searchHangerEQFlagListBasic(eQFlagListGRPVO);
							CustomMnrEqStsVO tmpCustomMnrEqStsVO = eQFlagListGRPVO.getCustomMnrEqStsVO();
							if(tmpCustomMnrEqStsVO != null){
								//작업 필요 여부 플레그
								boolean workFlag = false;
								String remarkStr = "";
								CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
 								//WO 삭제  표시,인벤토리 계산시 별로도 계산함
 								tmpCustomMnrEqStsVO.setCostDtlCd("RMH");
								//Hanger Rack/Bar Installation 일때

								if(costCd.equals("MRDRHA")){
									customMnrEqStsVO.setMnrHngrFlg("N");
									//설치 WO 삭제시 매뉴얼로 이미 제거 처리 된경우 작업 없음
									//매뉴얼 설치수정혹은 설치의  경우에만 작업
									if(tmpCustomMnrEqStsVO.getMnrHngrFlg().equals("Y")){
										workFlag = true;

										customMnrEqStsVO.setHngrBarAtchKnt("0");
										customMnrEqStsVO.setActInvtQty(tmpCustomMnrEqStsVO.getHngrBarAtchKnt());
										customMnrEqStsVO.setMnrHngrDmgQty("0");
										customMnrEqStsVO.setMnrLostHngrQty("0");
										customMnrEqStsVO.setMnrDispHngrQty("0");
										customMnrEqStsVO.setRecentHngrBarAtchKnt(tmpCustomMnrEqStsVO.getHngrBarAtchKnt());
									}
									remarkStr = "INSTALL";
								//Hanger Rack/Bar Removal 일때
								} else {
									customMnrEqStsVO.setMnrHngrFlg("Y");
									//제거 WO 삭제시 매뉴얼로 이미 설치 처리 된경우 작업 없음
									//매뉴얼 삭제수정혹은 삭제의  경우에만 작업
									if(tmpCustomMnrEqStsVO.getMnrHngrFlg().equals("N")){
										workFlag = true;

										int soundQty = Integer.parseInt(tmpCustomMnrEqStsVO.getActInvtQty());
										int dmgQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrHngrDmgQty());
										int lostQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrLostHngrQty());
										int dispQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrDispHngrQty());

										int reCoveryCnt = soundQty + dmgQty + lostQty + dispQty;
										customMnrEqStsVO.setHngrBarAtchKnt(String.valueOf(reCoveryCnt));
										customMnrEqStsVO.setActInvtQty("0");
										customMnrEqStsVO.setMnrHngrDmgQty("0");
										customMnrEqStsVO.setMnrLostHngrQty("0");
										customMnrEqStsVO.setMnrDispHngrQty("0");
										customMnrEqStsVO.setRecentHngrBarAtchKnt(String.valueOf(reCoveryCnt));
									}
									remarkStr = "REMOVE";
								}
								customMnrEqStsVO.setEqNo(tmpCustomMnrEqStsVO.getEqNo());
								customMnrEqStsVO.setEqTpszCd(tmpCustomMnrEqStsVO.getEqTpszCd());
								customMnrEqStsVO.setEqKndCd(tmpCustomMnrEqStsVO.getEqKndCd());
								customMnrEqStsVO.setMnrHngrRckCd(tmpCustomMnrEqStsVO.getMnrHngrRckCd());
								customMnrEqStsVO.setMnrHngrBarTpCd(tmpCustomMnrEqStsVO.getMnrHngrBarTpCd());
								customMnrEqStsVO.setMnrDmgFlg("N");
								customMnrEqStsVO.setMnrHngrFlgYdCd(tmpCustomMnrEqStsVO.getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(tmpCustomMnrEqStsVO.getMnrHngrFlgDt());
								customMnrEqStsVO.setMnrHngrTrfCd(tmpCustomMnrEqStsVO.getMnrHngrTrfCd());
								customMnrEqStsVO.setMnrHngrTrfOtrDesc(tmpCustomMnrEqStsVO.getMnrHngrTrfOtrDesc());
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
								String today = formatter.format(new java.util.Date());
								customMnrEqStsVO.setMnrHngrFlgDt(today);

								customMnrEqStsVO.setMnrStsRmk("By Work Order [" + remarkStr + "][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");
								tmpCustomMnrEqStsVO.setMnrStsRmk("By Work Order [" + remarkStr + "][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");

								IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
								iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
								iFMnrFlagVO.setFlagUserId(account.getUsr_id());
								iFMnrFlagVO.setFlagType("HGR");
								iFMnrFlagVO.setRetireFlag("N");
								iFMnrFlagVO.setEqKindCd(customMnrEqStsVO.getEqKndCd());
								iFMnrFlagVO.setEqNo(customMnrEqStsVO.getEqNo());
								iFMnrFlagVO.setFlagDt(customMnrEqStsVO.getMnrHngrFlgDt());
								iFMnrFlagVO.setFlagYdCd(customMnrEqStsVO.getMnrHngrFlgYdCd());
								iFMnrFlagVO.setHrType(customMnrEqStsVO.getMnrHngrRckCd());
								iFMnrFlagVO.setHbType(customMnrEqStsVO.getMnrHngrBarTpCd());
								if(customMnrEqStsVO.getMnrHngrFlg().equals("N")){
									if(customMnrEqStsVO.getMnrHngrRckCd().equals("O")){
										iFMnrFlagVO.setHrType("O");
										iFMnrFlagVO.setHbType("S");
									} else {
										iFMnrFlagVO.setHrType("");
										iFMnrFlagVO.setHbType("");
									}
								}
								iFMnrFlagVO.setHbCount(customMnrEqStsVO.getHngrBarAtchKnt());
								iFMnrFlagVO.setStsFlag(customMnrEqStsVO.getMnrHngrFlg());

								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrHngrFlg());
								customMnrFlgHisVO.setMnrFlgTpCd("HGR");
								customMnrFlgHisVO.setMnrFlgInpTpCd("W");
								customMnrFlgHisVO.setEqNo(customMnrEqStsVO.getEqNo());
								customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVO.getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrHngrFlgYdCd());
								customMnrFlgHisVO.setMnrHngrRckCd(customMnrEqStsVO.getMnrHngrRckCd());
								customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());
								customMnrFlgHisVO.setHngrBarAmdQty(customMnrEqStsVO.getRecentHngrBarAtchKnt());
								customMnrFlgHisVO.setHngrBarTtlQty(customMnrEqStsVO.getHngrBarAtchKnt());
								customMnrFlgHisVO.setActInvtQty(customMnrEqStsVO.getActInvtQty());
								customMnrFlgHisVO.setMnrHngrDmgQty(customMnrEqStsVO.getMnrHngrDmgQty());
								customMnrFlgHisVO.setMnrLostHngrQty(customMnrEqStsVO.getMnrLostHngrQty());
								customMnrFlgHisVO.setMnrDispHngrQty(customMnrEqStsVO.getMnrDispHngrQty());
								customMnrFlgHisVO.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd);
								customMnrFlgHisVO.setMnrOrdSeq(mnrOrdSeq);
								customMnrFlgHisVO.setMnrHngrTrfCd(customMnrEqStsVO.getMnrHngrTrfCd());
								customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrEqStsVO.getMnrHngrTrfOtrDesc());
								if(workFlag){
									customMnrEqStsVOS.add(customMnrEqStsVO);
									tmpCustomMnrEqStsVOS.add(tmpCustomMnrEqStsVO);
									customMnrFlgHisVOS.add(customMnrFlgHisVO);
									iFMnrFlagVOS.add(iFMnrFlagVO);
								}
							}
						}
						//list => array 변환 작업
						CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = null;
						CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = null;
						CustomMnrEqStsVO[] arrTmpCustomMnrEqStsVOS = null;

						arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[customMnrEqStsVOS.size()];
						if ( customMnrEqStsVOS.size() > 0 ) {
							for ( int x = 0; x < customMnrEqStsVOS.size(); x++ ) {
								arrCustomMnrEqStsVOS[x] = customMnrEqStsVOS.get(x);
							}
						}
						arrTmpCustomMnrEqStsVOS = new CustomMnrEqStsVO[tmpCustomMnrEqStsVOS.size()];
						if ( tmpCustomMnrEqStsVOS.size() > 0 ) {
							for ( int x = 0; x < tmpCustomMnrEqStsVOS.size(); x++ ) {
								arrTmpCustomMnrEqStsVOS[x] = tmpCustomMnrEqStsVOS.get(x);
							}
						}
						arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrFlgHisVOS.size()];
						if ( customMnrFlgHisVOS.size() > 0 ) {
							for ( int x = 0; x < customMnrEqStsVOS.size(); x++ ) {
								arrCustomMnrFlgHisVOS[x] = customMnrFlgHisVOS.get(x);
							}
						}
						eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
						eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);

						eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
						hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(arrTmpCustomMnrEqStsVOS);
						interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

						command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
						command3.manageIFFlagBasic(interfaceGRPVO,account);
					//COST TYPE이  Other 일때
					} else if(costCd.equals("MRDROT")) {
						CustomMnrEqStsVO[] arrCustomMnrEqStsVOS;
						
						//M1,MD 만 manageHangerInventoryEqStsBasic 타게 하기위해 	
						//2012-03-08 박명신 추가
						List<CustomMnrEqStsVO> calCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
						
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							//Extra Expense Type이 Hanger Bar(Square,Round) Purchasing 일때
							if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1") || customMnrOrdDtlVOS[i].getCostDtlCd().equals("MD")){
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
								customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
								customMnrEqStsVO.setHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrFlg("N");
								customMnrEqStsVO.setMnrDmgFlg("N");
								customMnrEqStsVO.setMnrStsRmk("By Work Order [PURCHASING][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");
								customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
								customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
								customMnrEqStsVO.setMnrHngrDtlOffrDesc(customMnrOrdDtlVOS[i].getMnrHngrDtlOffrDesc());

								if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1")){
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								} else {
									customMnrEqStsVO.setMnrHngrBarTpCd("D");
								}
								calCustomMnrEqStsVOS.add(customMnrEqStsVO);
							}
						}
						
						if(calCustomMnrEqStsVOS.size() > 0){	
							arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[calCustomMnrEqStsVOS.size()];
							for (int i = 0; i < calCustomMnrEqStsVOS.size(); i++) {
								arrCustomMnrEqStsVOS[i] = calCustomMnrEqStsVOS.get(i);
							}
							hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
							command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						}
					}
				}
			}

			//비즈로직에 따른 업데이트 진행 //조회시작
			generalWOGRPVO = command.removeWOBasic(generalWOGRPVO, account);
			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());
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
	 * EES_MNR_0226 : Retrieve <br>
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimpleWOService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{

	        if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0226Event"))
			{
				EesMnr0226Event event = (EesMnr0226Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0054 : Retrieve <br>
	 * [EES_MNR_0054]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFSpareWOService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{

	        if(e.getEventName().equalsIgnoreCase("EesMnr0054Event"))
			{
	        	EesMnr0054Event event = (EesMnr0054Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0228Event"))
			{
				EesMnr0228Event event = (EesMnr0228Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0052 : W/O Creation <br>
	 * [EES_MNR_0052]Simple W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSimpleWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();

		EesMnr0052Event event = (EesMnr0052Event)e;
		generalWOGRPVO = event.getGeneralWOGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			generalWOGRPVO = command.manageExtraWOBasic(generalWOGRPVO, account);
			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());
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
	 * EES_MNR_0054 : W/O Creation <br>
	 * [EES_MNR_0054]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFSpareWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EesMnr0054Event event = (EesMnr0054Event)e;
		generalWOGRPVO = event.getGeneralWOGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			//로직시작
			begin();
			//비즈로직에 따른 업데이트 진행 //조회시작
			generalWOGRPVO = command.manageRFSpareWOBasic(generalWOGRPVO, account);
			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0032 : Retrieve <br>
	 * [EES_MNR_0032]Repair Result creatioln by W/O의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairResultListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		RepairResultGRPVO repairResultGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0032Event")){
			EesMnr0032Event event = (EesMnr0032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS032Event")){
			EesMnrS032Event event = (EesMnrS032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		}

		try{
			repairResultGRPVO = command.searchRepairResultListBasic(repairResultGRPVO);
			eventResponse.setRsVoList(repairResultGRPVO.getRepairResultListVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0032 : Save <br>
	 * [EES_MNR_0032]Repair Result creatioln by W/O의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepairResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairResultGRPVO repairResultGRPVO = new RepairResultGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0032Event")){
			EesMnr0032Event event = (EesMnr0032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS032Event")){
			EesMnrS032Event event = (EesMnrS032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		}
		RepairMgtBC	command = new RepairMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		//로직시작
		//*************** FLAG 처리용 ************************* //
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		RepairResultListVO[] repairResultListVOS = repairResultGRPVO.getArrRepairResultListVOS();

		int flgCnt = 0;
		//unflagging 할 데이타 갯수 체크
		for ( int i = 0; i < repairResultListVOS.length; i++ )
		{
			if(repairResultListVOS[i].getIbflag().equals("U")){
				String dmgFlg       = repairResultListVOS[i].getMnrDmgFlg();
				String rprRsltDt       = repairResultListVOS[i].getRprRsltDt().trim();
				if(dmgFlg.equals("Y") && rprRsltDt.length()>=8)
				{
					flgCnt++;
				}
			}
		}
		//unflagging 할 데이타값  입력
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[flgCnt];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[flgCnt];
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(new java.util.Date());
		flgCnt=0;
		for ( int i = 0; i < repairResultListVOS.length; i++ )
		{
			if(repairResultListVOS[i].getIbflag().equals("U")){
				String dmgFlg       = repairResultListVOS[i].getMnrDmgFlg();
				String rprRsltDt       = repairResultListVOS[i].getRprRsltDt().trim();
				if(dmgFlg.equals("Y") && rprRsltDt.length()>=8)
				{
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(repairResultListVOS[i].getEqNo());
					customMnrEqStsVO.setEqKndCd(repairResultListVOS[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(repairResultListVOS[i].getEqTpszCd());

					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(repairResultListVOS[i].getYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Repair Result Creation");
					customMnrEqStsVO.setMnrDmgFlg("0");
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(repairResultListVOS[i].getEqNo());
					customMnrFlgHisVO.setEqTpszCd(repairResultListVOS[i].getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("S");
					customMnrFlgHisVO.setEqKndCd(repairResultListVOS[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(repairResultListVOS[i].getYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Repair Result Creation");
					customMnrFlgHisVO.setMnrStsFlg("0");
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;
				}
			}
		}

		EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
		eQFlagListINVO.setMnrFlgTpCd("DMG");
		eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
		eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
		eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
		//*************** FLAG END   ************************* //

		/***************** MST 외부 인터페이스 호출을 위한 **********************/
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

		CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
		for(int i = 0;i < customMnrEqStsVOS.length; i++){
			IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
			iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
			iFMnrFlagVO.setFlagUserId(account.getUsr_id());
			iFMnrFlagVO.setFlagType(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd());
			iFMnrFlagVO.setRetireFlag("N");
			iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
			iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());

			//Damage Flag
			if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("DMG")){
				//플레깅 상태
				if(customMnrEqStsVOS[i].getMnrDmgFlg().equals("0"))
					iFMnrFlagVO.setStsFlag("N");
				else
					iFMnrFlagVO.setStsFlag("Y");
				iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
		     }
			iFMnrFlagVOS.add(iFMnrFlagVO);
		}
		interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
		/***************** MST 외부 인터페이스 호출을 위한 *********************/

		try {
			begin();
			//데미지 언플래깅 체크가 존재하는 경우
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
				command3.manageIFFlagBasic(interfaceGRPVO,account);    //MST 외부 인터페이스 호출
			}

			//비즈로직에 따른 업데이트 진행 //조회시작
			repairResultGRPVO = command.manageRepairResultBasic(repairResultGRPVO, account);
			commit();
			//로직완료
			//저장한 데이타를 조회해서 다시 보냄
			RepairResultINVO repairResultINVO = new RepairResultINVO();

			repairResultGRPVO.setRepairResultINVO(repairResultINVO);
			eventResponse.setETCData(repairResultINVO.getColumnValues());

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
	 * EES_MNR_0036 : Open <br>
	 * [EES_MNR_0036]M&R Document Transmission의 정보를 조회 합니다. <br>
	 *
	 * @param Event e `
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0036Event event = (EesMnr0036Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();
		DocGRPVO docGRPVO = new DocGRPVO();

		try{
			docGRPVO = command.searchDocSendBasic(event.getDocGRPVO());

			eventResponse.setRsVoList(docGRPVO.getCustomDocHeaderVOs());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0036 : W/O Send <br>
	 * [EES_MNR_0036] M&R Document Transmission의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0036Event event = (EesMnr0036Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();

		try{
			DocGRPVO docGRPVO = event.getDocGRPVO();
			CustomDocHeaderVO[] arrCustomDocHeaderVO = docGRPVO.getArrcustomDocHeaderVOs();
			String ifTrcSeq = "";

			begin();

			for ( int i = 0; i < arrCustomDocHeaderVO.length; i++ ) {

				CustomMnrOrdHdrVO customMnrOrdHdrVO = new CustomMnrOrdHdrVO();
				ifTrcSeq = "";

				if(arrCustomDocHeaderVO[i].getSel().equals("1")){

					if(arrCustomDocHeaderVO[i].getTrsmModCd().equals("E")||arrCustomDocHeaderVO[i].getTrsmModCd().equals("F")||arrCustomDocHeaderVO[i].getTrsmModCd().equals("M")){

						DocResultVO docResultVO = new DocResultVO();

						if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("SPL")){
							docResultVO.setTmplMrd("EES_MNR_0183.mrd");
						}else if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("EXT")){
							docResultVO.setTmplMrd("EES_MNR_0187.mrd");
						}else if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("RFS")){
							docResultVO.setTmplMrd("EES_MNR_0231.mrd");
						}else{
							docResultVO.setTmplMrd("EES_MNR_0182.mrd");
						}

						docResultVO.setRdSubSysCd("MNR");
						docResultVO.setBatFlg("N");
						docResultVO.setDocTitNm(arrCustomDocHeaderVO[i].getDocSubject());
						docResultVO.setEmlCtnt(arrCustomDocHeaderVO[i].getMemo());
						docResultVO.setTemplateArgs("/rv mnr_ord_ofc_cty_cd["+ arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(0,3) +"] mnr_ord_seq[" + arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3) + "] user_nm[" + account.getUsr_nm() + "] memo[" + arrCustomDocHeaderVO[i].getMemo() + "] subject[" + arrCustomDocHeaderVO[i].getDocSubject() + "]");
						docResultVO.setSndrNm(account.getUsr_nm());
						docResultVO.setFaxOffice(account.getOfc_cd());
						docResultVO.setReceiverRmail(arrCustomDocHeaderVO[i].getMnrPrnrEml());
						docResultVO.setSndrEml(account.getUsr_eml());
						docResultVO.setCreUsrId(account.getUsr_id());
						docResultVO.setEdiId(arrCustomDocHeaderVO[i].getEdiId());
						docResultVO.setMnrOrdOfcCtyCd(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(0,3));
						docResultVO.setMnrOrdSeq(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3));

						String arrFaxNo[] = arrCustomDocHeaderVO[i].getFaxNo().split(",");
						StringBuffer faxNo = new StringBuffer();
						for(int j = 0; j < arrFaxNo.length;j++){
							if(j>0){
								faxNo.append(",").append(" ;").append(arrFaxNo[j]);
							}else{
								faxNo.append(" ;").append(arrFaxNo[j]);
							}
						}

						docResultVO.setFaxRcvInfo(faxNo.toString());
						docResultVO.setTemplateFile("");
						docResultVO.setTrsmModCd(arrCustomDocHeaderVO[i].getTrsmModCd());

						ifTrcSeq = command2.docSendBasic(docResultVO, account);
					}

					customMnrOrdHdrVO.setTrsmModCd(arrCustomDocHeaderVO[i].getTrsmModCd());
					customMnrOrdHdrVO.setOrdIssOfcCd(account.getOfc_cd());
					customMnrOrdHdrVO.setIfTrcSeq(ifTrcSeq);
					customMnrOrdHdrVO.setMnrOrdSeq(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3));
					customMnrOrdHdrVO.setCreUsrId(account.getUsr_id());
					customMnrOrdHdrVO.setUpdUsrId(account.getUsr_id());
					docGRPVO.setCustomMnrOrdHdrVO(customMnrOrdHdrVO);

					docGRPVO = command.manageDocSendBasic(docGRPVO,account);
				}

			}
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
	 * EES_MNR_0030 : Retrieve <br>
	 * [EES_MNR_0030]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTWorkOrderListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0030Event event = (EesMnr0030Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			ESTWOMainGRPVO eSTWOMainGRPVO = new ESTWOMainGRPVO();

			eSTWOMainGRPVO = command.searchESTWorkOrderListBasic(event.getESTWOMainGRPVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eSTWOMainGRPVO.getCustomESTWOMainSMRVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0030 : Retrieve <br>
	 * [EES_MNR_0030] W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTWorkOrderDetailListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0030Event event = (EesMnr0030Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			ESTWOMainGRPVO eSTWOMainGRPVO = new ESTWOMainGRPVO();

			eSTWOMainGRPVO = command.searchESTWorkOrderDetailListBasic(event.getESTWOMainGRPVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eSTWOMainGRPVO.getCustomESTWOMainINFOVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0030 : W/O Creation <br>
	 * [EES_MNR_0030]W/O Creation의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createESTWOCreationService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0030Event event = (EesMnr0030Event)e;

		RepairMgtBC command = new RepairMgtBCImpl();
		ESTWOMainGRPVO eSTWOMainGRPVO = event.getESTWOMainGRPVO();

		//*************** FLAG 처리용 ************************* //
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		CustomESTWOMainINFOVO[] arrayCustomESTWOMainINFOVOs = eSTWOMainGRPVO.getArrayCustomESTWOMainINFOVOs();
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomESTWOMainINFOVOs.length];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomESTWOMainINFOVOs.length];
		int flgCnt = 0;

		for ( int i = 0; i < arrayCustomESTWOMainINFOVOs.length; i++ ) {
			String dmgFlg       = arrayCustomESTWOMainINFOVOs[i].getMnrDmgFlg();
			String hiddenDmgFlg = arrayCustomESTWOMainINFOVOs[i].getHiddenMnrDmgFlg();
			if(!dmgFlg.equals(hiddenDmgFlg)) {
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(arrayCustomESTWOMainINFOVOs[i].getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(arrayCustomESTWOMainINFOVOs[i].getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(arrayCustomESTWOMainINFOVOs[i].getEqTpszCd());
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);
				customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomESTWOMainINFOVOs[i].getRprYdCd());
				customMnrEqStsVO.setMnrStsRmk("From Estimate W/O Creation");
				customMnrEqStsVO.setMnrDmgFlg(dmgFlg);
				arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(arrayCustomESTWOMainINFOVOs[i].getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(arrayCustomESTWOMainINFOVOs[i].getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG");
				customMnrFlgHisVO.setMnrFlgInpTpCd("W");
				customMnrFlgHisVO.setEqKndCd(arrayCustomESTWOMainINFOVOs[i].getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomESTWOMainINFOVOs[i].getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);
				customMnrFlgHisVO.setMnrFlgRmk("From Estimate W/O Creation");
				customMnrFlgHisVO.setMnrStsFlg(dmgFlg);
				arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

				flgCnt++;
			}
		}
		EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
		eQFlagListINVO.setMnrFlgTpCd("DMG");
		eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
		eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
		eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
		//*************** FLAG END   ************************* //

		/***************** MST 외부 인터페이스 호출을 위한 **********************/
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
		if(flgCnt > 0) {
			for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){

				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("DMG");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
				//Damage Flag
				if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
		}
		/***************** MST 외부 인터페이스 호출을 위한 *********************/

		try {
			begin();
			//데미지 플래깅 체크가 존재하는 경우
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
				command3.manageIFFlagBasic(interfaceGRPVO,account);
			}
			eSTWOMainGRPVO = command.createESTWOCreationBasic(eSTWOMainGRPVO, account);		//W/O Creation 로직
			commit();
			eventResponse.setETCData("wo_nos", eSTWOMainGRPVO.getWoNos());
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
	 * EES_MNR_0093 : Retrieve <br>
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExtraDisposalByEQService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0093Event event = (EesMnr0093Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();

			extraDisposalMgtGRPVO = command.searchExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(extraDisposalMgtGRPVO.getListCustomMnrXtraDispVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0093 : checkDuplication <br>
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExtraDisposalByEQService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			EesMnr0093Event event = (EesMnr0093Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			extraDisposalMgtGRPVO = command.checkExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO());
			eventResponse.setETCData("cnt", extraDisposalMgtGRPVO.getCnt());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0093 : Save <br>
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExtraDisposalByEQService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0093Event event = (EesMnr0093Event)e;
		ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();

		ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = event.getExtraDisposalMgtGRPVO();

		try{
			CustomMnrXtraDispVO[]  arrayCustomMnrXtraDispVOs  = extraDisposalMgtGRPVO.getArrayCustomMnrXtraDispVOs();

			//*************** FLAG 처리용 ************************* //
			EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomMnrXtraDispVOs.length];
			CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomMnrXtraDispVOs.length];
			int flgCnt = 0;
			String mnrFlgTpCd = "";

			for ( int i = 0; i < arrayCustomMnrXtraDispVOs.length; i++ ) {
				String xtraDispStsCd	= arrayCustomMnrXtraDispVOs[i].getXtraDispStsCd();
				if(xtraDispStsCd.equals("HA")||xtraDispStsCd.equals("HC")) {
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(arrayCustomMnrXtraDispVOs[i].getEqNo());
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrXtraDispVOs[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(arrayCustomMnrXtraDispVOs[i].getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrXtraDispVOs[i].getIssYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Scrapping/Donation Creation");
					if(xtraDispStsCd.equals("HA")) { //Confirm
						customMnrEqStsVO.setMnrDmgFlg("1");
					} else if(xtraDispStsCd.equals("HC")) {  //Cancel
						customMnrEqStsVO.setMnrDmgFlg("0");
					}
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(arrayCustomMnrXtraDispVOs[i].getEqNo());
					customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrXtraDispVOs[i].getEqTpszCd());
					String mnrXtraDispTpCd = arrayCustomMnrXtraDispVOs[i].getMnrXtraDispTpCd();
					//2010-03-29 : mnrFlgTpCd 2개의 구분(SCR/DON)에서 3개의 구분(SCR/DON/SRO)으로 수정
					if(mnrXtraDispTpCd.equals("SCR")) {
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("C");
					} else if(mnrXtraDispTpCd.equals("DON")){
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("N");
					} else {
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("O");
					}
					customMnrFlgHisVO.setMnrFlgTpCd(mnrFlgTpCd);

					customMnrFlgHisVO.setEqKndCd(arrayCustomMnrXtraDispVOs[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrXtraDispVOs[i].getIssYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Scrapping/Donation Creation");
					if(xtraDispStsCd.equals("HA")) {  //Confirm
						customMnrFlgHisVO.setMnrStsFlg("Y");
					} else if(xtraDispStsCd.equals("HC")) {//Cancel
						customMnrFlgHisVO.setMnrStsFlg("N");
					}
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd(mnrFlgTpCd);
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			//*************** FLAG END   ************************* //

			/***************** MST 외부 인터페이스 호출을 위한 **********************/
			InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			if(flgCnt > 0) {
				for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
					iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
					iFMnrFlagVO.setFlagUserId(account.getUsr_id());
					iFMnrFlagVO.setFlagType(mnrFlgTpCd);
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
					//Damage Flag
					if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			}
			/***************** MST 외부 인터페이스 호출을 위한 *********************/

			begin();

			//Confirm 이나  Cancel 을 했을 경우 (Save 제외)
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
				command3.manageIFFlagBasic(interfaceGRPVO,account);         //MST/CGM 로직
			}

			//저장
			command.manageExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO(), account);

			//FA 전송
			//CustomMnrXtraDispVO[]  arrayCustomMnrXtraDispVOs  = event.getExtraDisposalMgtGRPVO().getArrayCustomMnrXtraDispVOs();
			InterfaceMgtBC command4	= new 	InterfaceMgtBCImpl();
			FaErpListVO[] arrayfaErpListVOs = new FaErpListVO[arrayCustomMnrXtraDispVOs.length];
			String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			String ymdhm = (new SimpleDateFormat("yyyyMMdd")).format(new Date());

			for ( int i=0; i< arrayCustomMnrXtraDispVOs.length; i++ ) {
				if(arrayCustomMnrXtraDispVOs[i] == null)break;

				if ( arrayCustomMnrXtraDispVOs[i].getXtraDispStsCd().equals("HA")){
					FaErpListVO faErpListVO = new FaErpListVO();
					faErpListVO.setLifid("FNS027-0001");
					faErpListVO.setSeq(ymdhms + arrayCustomMnrXtraDispVOs[i].getEqNo());
					faErpListVO.setTotalCount("1");
					faErpListVO.setRnum("1");
					//Tag Number search start////////////////////////////////
					String faEqNo = "";
					String eqNo		= arrayCustomMnrXtraDispVOs[i].getEqNo();
					faEqNo	= command4.searchFAEqNoBasic(eqNo);
					faErpListVO.setTagNumber(faEqNo);
					//Tag Number search end//////////////////////////////////
					faErpListVO.setBookTypeCode("SML GAAP BOOK");
					faErpListVO.setDateRetired(arrayCustomMnrXtraDispVOs[i].getIssDt().replace("-", ""));
					faErpListVO.setUnitsRetired("1");
					faErpListVO.setProceedsOfSale("0");
					String mnrXtraDispTpCd = arrayCustomMnrXtraDispVOs[i].getMnrXtraDispTpCd();
					if(mnrXtraDispTpCd.equals("DON")) {
						faErpListVO.setRetirementTypeCode("DONATION");
					} else {
						// Scrapping도 Donation으로 처리하라는 FA 요청 : 2010.03.20
						faErpListVO.setRetirementTypeCode("DONATION");
						//faErpListVO.setRetirementTypeCode("SCRAPPING");
					}
					faErpListVO.setInterfaceFlag("N");
					faErpListVO.setCreationDate(ymdhm);
					faErpListVO.setLastUpdateDate(ymdhm);
					faErpListVO.setSoldTo("136514");
					faErpListVO.setAttribute2("USD");

					arrayfaErpListVOs[i] = faErpListVO;

					//전송
					command4.faSendBasic(arrayfaErpListVOs, account, "SCR"); // Scrapping/Donation Creation 구분(SCR)
				}
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0094 : Retrieve <br>
	 * [EES_MNR_0094]Scrapping/Donation Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExtraDisposalListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0094Event event = (EesMnr0094Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();

			extraDisposalMgtGRPVO = command.searchExtraDisposalListBasic(event.getExtraDisposalMgtGRPVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(extraDisposalMgtGRPVO.getListCustomMnrXtraDispVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0195 : Retrieve <br>
	 * [EES_MNR_0195]Total Loss No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossInfoByOFCListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0195Event event = (EesMnr0195Event)e;
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossInfoGRPVO totalLossInfoGRPVO = new TotalLossInfoGRPVO();

			totalLossInfoGRPVO = command.searchTotalLossInfoByOFCListBasic(event.getTotalLossInfoGRPVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossInfoGRPVO.getListCustomMnrTtlLssRqstHdrVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0098 : Retrieve <br>
	 * [EES_MNR_0098]Total Loss Management의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);
			eventResponse.setETCData("from_email",   account.getUsr_eml());
			eventResponse.setETCData("sender",   account.getUsr_nm());		

			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0096 : Retrieve <br>
	 * [EES_MNR_0096]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0095Event")){
			EesMnr0095Event event = (EesMnr0095Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossBasic(totalLossGRPVO,account);
			

			//단건조회(Header)
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());

			//다중조회(Detail)
			for (int i = 0; i < totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().size(); i++) {
				eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().get(i));
			}

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0098 : doActionIBSheet <br>
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossWithCLTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0234Event")){
			EesMnr0234Event event = (EesMnr0234Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossBasic(totalLossGRPVO,account);
			totalLossGRPVO = command.searchTotalLossWithCLTBasic(totalLossGRPVO,account);

			//단건조회(Header)
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());

			//다중조회(Detail)
			for (int i = 0; i < totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().size(); i++) {
				eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().get(i));
			}

			//  Total Loss Collection
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssCltVOS());

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0098 : Save <br>
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StatusHistoryMgtBC command2 = new StatusHistoryMgtBCImpl();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();

		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0095Event")){
			EesMnr0095Event event = (EesMnr0095Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			begin();

			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			CustomMnrTtlLssRqstDtlVO[]  arrayCustomMnrTtlLssRqstDtlVOs  = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			int payInvSeqCnt = 0;
			String[] arrayPayInvSeq = null;
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 시작
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//Total Loss History 저장
			String mnrStsRefNo = "";
			if(totalLossGRPVO.getArrayCustomMnrStsHisVO() != null) {
				statusHistoryGRPVO.setArrayCustomMnrStsHisVO(totalLossGRPVO.getArrayCustomMnrStsHisVO());
				statusHistoryGRPVO = command2.manageStatusHistorysBasic(statusHistoryGRPVO, account);
				mnrStsRefNo = statusHistoryGRPVO.getMnrStsRefNo();
			}

			//Total Loss Request 저장
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setMnrStsRefNo(mnrStsRefNo);
			totalLossGRPVO = command.manageTotalLossBasic(totalLossGRPVO, account);
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 끝
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//Confirm

			if(ttlLssStsCd.equals("HA") || ttlLssStsCd.equals("HE")) {
				//*************** FLAG 처리용 ************************* //
				EQFlagMgtBC command3 = new EQFlagMgtBCImpl();
				EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
				int delCnt=0;       // 삭제된  DTL 갯수
				int dvCnt=0;		// DV DTL 갯수
				int dvDelCnt=0;	    // DV DTL에서 삭제된 갯수
				int dvTtlCancelCnt=0;	    // DV DTL에서 Close Type이 RE, TC인 개수

				for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
					// 삭제된  DTL 갯수 계산
					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D") || arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("U"))delCnt++;

					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
					{
						dvCnt++; // DV DTL 갯수 계산
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D") || arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("U")){
							dvDelCnt++; // DV DTL에서 삭제된 갯수
						}
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("U") && ("RE".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd())||"TC".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd()))){
							if("I".equals(command.searchEqCurrentStatus(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd(), arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo()).get(1))){
								dvTtlCancelCnt++; // DV DTL에서 Close Type이 RE, TC인 개수	
							}
						}
					}
				}
				int flgCnt = 0; //DV, DV Expense 탭 flag 관련갯수
				if(!e.getEventName().equalsIgnoreCase("EesMnr0098Event"))
				{
					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[dvCnt];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[dvCnt];
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {

						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
						{
							//STS VO
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
							customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
							String today = formatter.format(new java.util.Date());
							customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
							String iBflag=arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().toUpperCase();
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
							{
								//STS VO
								customMnrEqStsVO.setMnrDmgFlgDt(today);
								customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrEqStsVO.setMnrDmgFlg((iBflag.equals("D"))?"0":"1");
								arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

								//FLG_HIS_VO
								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
								customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
								customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrFlgHisVO.setMnrFlgInpTpCd("T");
								customMnrFlgHisVO.setMnrFlgTpCd("TLL");
								customMnrFlgHisVO.setMnrFlgInpDt(today);
								customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
								customMnrFlgHisVO.setMnrStsFlg((iBflag.equals("D"))?"N":"Y");
								arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
								flgCnt++;
							}
						}
					}
					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("TLL");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					//*************** FLAG END   ************************* //

					/***************** MST 외부 인터페이스 호출을 위한 **********************/
					InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					String ttlLssNtfyDt=totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssIssDt();
					ttlLssNtfyDt=ttlLssNtfyDt.replaceAll("-","");
					// Total Loss 데미지 플래그 처리
					for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("TLL");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
						//Damage Flag
						if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						//iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagDt(totalLossGRPVO.getTotalLossINVO().getTtlLssDt().replaceAll("-",""));
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						iFMnrFlagVO.setTtlLssNtfyDt(ttlLssNtfyDt);
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

					/***************** MST 외부 인터페이스 호출을 위한 *********************/
					command3.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
					command4.manageIFFlagBasic(interfaceGRPVO,account);         //MST/CGM 로직 호출
					
//					if(!"Y".equals(totalLossGRPVO.getPageSeparator())){//totalloss by accident일 경우 invoice 생성 및 csr ap 생성 안함 
						/** MNR_PAY_INV_WRK 추가 **********************************************/
						ExpenseMgtBC command5 = new ExpenseMgtBCImpl();
						PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
						String ttlLssNo = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
						String ttlLssIssDt = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssIssDt();
						payableInvoiceGRPVO.setTtlLssNo(ttlLssNo);
						payableInvoiceGRPVO.setTtlLssIssDt(ttlLssIssDt);//Issue Date 추가
						String ttlLssDtlSeq ="0";
						for(int i=0; i<arrayCustomMnrTtlLssRqstDtlVOs.length; i++) {
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssDtlSeq().equalsIgnoreCase(""))
							{
								ttlLssDtlSeq = String.valueOf(Integer.valueOf(ttlLssDtlSeq)+1);
							}else{
								ttlLssDtlSeq = arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssDtlSeq();
							}
	
							if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
								String mnrInvTpCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd();
								if(mnrInvTpCd.equals("DV")) {
	
									payableInvoiceGRPVO.setTtlLssDtlSeq(ttlLssDtlSeq);
									arrayPayInvSeq = command5.manageTotalLossPayableInvoiceBasic(payableInvoiceGRPVO, account);
									arrayCustomMnrTtlLssRqstDtlVOs[i].setPayInvSeq(arrayPayInvSeq[0]);
									payInvSeqCnt++;
								}
							}
						}
	
						arrayPayInvSeq=null;
						arrayPayInvSeq=new String[payInvSeqCnt];
						payInvSeqCnt=0;
						for(int i=0; i<arrayCustomMnrTtlLssRqstDtlVOs.length; i++) {
							if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
								String mnrInvTpCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd();
								if(mnrInvTpCd.equals("DV")) {
									arrayPayInvSeq[payInvSeqCnt]=arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq();
									payInvSeqCnt++;
								}
							}
						}
	
						totalLossGRPVO.setArrayCustomMnrTtlLssRqstDtlVOs(arrayCustomMnrTtlLssRqstDtlVOs);
						totalLossGRPVO = command.modifyTotalLossDetailBasic(totalLossGRPVO, account);
						/** MNR_PAY_INV_WRK 추가 **********************************************/
	
						/** CSR Temp Table에 Insert *****************************************************************/
						InterfaceMgtBC command6 = new InterfaceMgtBCImpl();
						ExpenseMgtBC command7 = new ExpenseMgtBCImpl();
						if(payInvSeqCnt > 0) {
							String invRgstNo = "";
							for(int i=0; i<arrayPayInvSeq.length; i++) {
								invRgstNo = command6.createCSRIFBasic("TLL", arrayPayInvSeq[i], account);
								command7.modifyTotalLossPayableInvoiceBasic(arrayPayInvSeq[i], invRgstNo, account, null);
							}
						}
	
						/** CSR Temp Table에 Insert  *****************************************************************/
	
						/** NR_PAY_INV_WRK,CSR Temp Table에 rollback Delete Start *****************************************************************/
						InterfaceMgtBC command8 = new InterfaceMgtBCImpl();
						ExpenseMgtBC command9 = new ExpenseMgtBCImpl();
						for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
								if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))
								{
									/** CSR Temp Table에 rollback start *****************************************************************/
									if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
										&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
									{
										//AP_PAY_INV  update DELT_FLG = 'Y'
										command8.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
										//MNR_PAY_INV_WRK delete where pay_inv_seq
										if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
										{
											PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
											payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
											payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
											command9.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
										}
									}
									/** CSR Temp Table에 rollback end *****************************************************************/
								}
							}
						}
						/** NR_PAY_INV_WRK,CSR Temp Table에 rollback Delete END  *****************************************************************/
	
						//FA 전송
						InterfaceMgtBC command10	= new 	InterfaceMgtBCImpl();
	
						List<FaErpListVO> fMnrFlagVOS = new ArrayList<FaErpListVO>();
						String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
						String ymdhm  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
						int faErpCnt = 0;
						for ( int i=0; i< arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
							if(arrayCustomMnrTtlLssRqstDtlVOs[i] == null)break;
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
							{
								if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
									FaErpListVO faErpListVO = new FaErpListVO();
									faErpListVO.setLifid("FNS027-0001");
									faErpListVO.setSeq(ymdhms + arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
									faErpListVO.setRnum(String.valueOf(faErpCnt+1));
									//Tag Number search start////////////////////////////////
									String faEqNo = "";
									String eqNo		= arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo();
									faEqNo			= command10.searchFAEqNoBasic(eqNo);
									faErpListVO.setTagNumber(faEqNo);
									//Tag Number search end//////////////////////////////////
									faErpListVO.setBookTypeCode("SML GAAP BOOK");
									faErpListVO.setDateRetired(ttlLssIssDt.replace("-", ""));
									faErpListVO.setUnitsRetired("1");
									faErpListVO.setProceedsOfSale(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssBilAmt());
									faErpListVO.setInvoiceNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvNo());
									//내부적으로는 TTL로 하기로 했으나 ERP로는 TTL로 넘겨야함
									faErpListVO.setRetirementTypeCode("TTL");
									faErpListVO.setInterfaceFlag("N");
									faErpListVO.setCreationDate(ymdhm);
									faErpListVO.setLastUpdateDate(ymdhm);
									faErpListVO.setSoldTo("136514");
									//추가 2010-07-08
									faErpListVO.setLclAmt(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssBilAmt());
								    faErpListVO.setLclCurr(arrayCustomMnrTtlLssRqstDtlVOs[i].getCurrCd());
	
									fMnrFlagVOS.add(faErpListVO);
									faErpCnt++;
								}
							}
					    }
	
						//List를 Array로 변형한다.
						FaErpListVO[] arrayFaErpListVOs = new FaErpListVO[fMnrFlagVOS.size()];
						for (int i = 0; i < fMnrFlagVOS.size(); i++) {
							arrayFaErpListVOs[i] = fMnrFlagVOS.get(i);
							arrayFaErpListVOs[i].setTotalCount(fMnrFlagVOS.size() + "");
						}
	
						//전송
						command10.faSendBasic(arrayFaErpListVOs, account, "TTL"); // Total Loss Request 구분(TTL)
//					}
				}else if(ttlLssStsCd.equals("HA") && e.getEventName().equalsIgnoreCase("EesMnr0098Event")) {
					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[dvDelCnt];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[dvDelCnt];
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")
							&& (arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D") || (arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("U") )))
						{
							//STS VO
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
							customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
							String today = formatter.format(new java.util.Date());
							customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV") )
							{
								//STS VO
								customMnrEqStsVO.setMnrDmgFlgDt(today);
								customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
									customMnrEqStsVO.setMnrDmgFlg("0");
								} else{
									if("RE".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd()) || "TC".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd())){
										customMnrEqStsVO.setMnrDmgFlg("0");
									} else{
										customMnrEqStsVO.setMnrDmgFlg("1");
									}
								}
								
								arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

								//FLG_HIS_VO
								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
								customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
								customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrFlgHisVO.setMnrFlgInpTpCd("T");
								customMnrFlgHisVO.setMnrFlgTpCd("TLL");
								customMnrFlgHisVO.setMnrFlgInpDt(today);
								customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
								if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
									customMnrFlgHisVO.setMnrStsFlg("N");
								} else{
									if("RE".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd()) || "TC".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd())){
										customMnrFlgHisVO.setMnrStsFlg("N");
									} else{
										customMnrFlgHisVO.setMnrStsFlg("Y");
									}
								}
								
								arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
								flgCnt++;
							}
						}
					}
					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("TLL");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					//*************** FLAG END   ************************* //

					/***************** MST 외부 인터페이스 호출을 위한 **********************/
					InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					// Total Loss 데미지 플래그 처리
					for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("TLL");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
						//Damage Flag
						if("0".equals(arrCustomMnrEqStsVOS[i].getMnrDmgFlg())){
							iFMnrFlagVO.setStsFlag("N");
						} else{
							iFMnrFlagVO.setStsFlag("Y");
						}
						
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						
						if("0".equals(arrCustomMnrEqStsVOS[i].getMnrDmgFlg())){
							List<String> returnVal = command.searchEqCurrentStatus(iFMnrFlagVO.getEqKindCd(), iFMnrFlagVO.getEqNo());
							if("I".equals(returnVal.get(1))){
								iFMnrFlagVO.setFlagYdCd(returnVal.get(0));
								iFMnrFlagVOS.add(iFMnrFlagVO);	
							}
						}
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

					/***************** MST 외부 인터페이스 호출을 위한 *********************/
					command3.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
					command4.manageIFFlagBasic(interfaceGRPVO,account);         //MST/CGM 로직 호출
					
//					if(!"Y".equals(totalLossGRPVO.getPageSeparator())){ //totalloss by accident일 경우 invoice 생성 및 csr ap 생성 안함
						/** MNR_PAY_INV_WRK 추가 **********************************************/
	
	
						/** NR_PAY_INV_WRK,CSR Temp Table에 rollback Delete Start *****************************************************************/
						PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
						String ttlLssNo = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
						payableInvoiceGRPVO.setTtlLssNo(ttlLssNo);
						InterfaceMgtBC command8 = new InterfaceMgtBCImpl();
						ExpenseMgtBC command9 = new ExpenseMgtBCImpl();
						for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
								if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))
								{
									/** CSR Temp Table에 rollback start *****************************************************************/
									if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
										&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
									{
										//AP_PAY_INV  update DELT_FLG = 'Y'
										command8.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
										//MNR_PAY_INV_WRK delete where pay_inv_seq
										if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
										{
											PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
											payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
											payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
											command9.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
										}
									}
									/** CSR Temp Table에 rollback end *****************************************************************/
								}
							}
						}
						/** NR_PAY_INV_WRK,CSR Temp Table에 rollback Delete END  *****************************************************************/
					} else if (ttlLssStsCd.equals("HE") && e.getEventName().equalsIgnoreCase("EesMnr0098Event")) {
						CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[dvTtlCancelCnt];
						CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[dvTtlCancelCnt];
						for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
							
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV") && ("RE".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd()) || "TC".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssCmplCd()))
								&& ("I".equals(command.searchEqCurrentStatus(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd(), arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo()).get(1)))
							)
							{
								//STS VO
								CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
								customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
								customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
								customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
								String today = formatter.format(new java.util.Date());
								customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
//								String iBflag=arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().toUpperCase();
								if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
								{
									//STS VO
									customMnrEqStsVO.setMnrDmgFlgDt(today);
									customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
									
									customMnrEqStsVO.setMnrDmgFlg("0");
									arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

									//FLG_HIS_VO
									CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
									customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
									customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
									customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
									customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
									customMnrFlgHisVO.setMnrFlgInpTpCd("T");
									customMnrFlgHisVO.setMnrFlgTpCd("TLL");
									customMnrFlgHisVO.setMnrFlgInpDt(today);
									customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
									
									customMnrFlgHisVO.setMnrStsFlg("N");
									arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
									flgCnt++;
								}
							}
						}
						EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
						eQFlagListINVO.setMnrFlgTpCd("TLL");
						eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
						eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
						eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
						//*************** FLAG END   ************************* //

						/***************** MST 외부 인터페이스 호출을 위한 **********************/
						InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
						InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
						List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
						String ttlLssNtfyDt=totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssIssDt();
						ttlLssNtfyDt=ttlLssNtfyDt.replaceAll("-","");
						// Total Loss 데미지 플래그 처리
						for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
							if(arrCustomMnrEqStsVOS[i] != null){
								IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
								iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
								iFMnrFlagVO.setFlagUserId(account.getUsr_id());
								iFMnrFlagVO.setFlagType("TLL");
								iFMnrFlagVO.setRetireFlag("N");
								iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
								iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
								iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
								//Damage Flag
								iFMnrFlagVO.setStsFlag("N");
								//iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
								iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
								iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
								iFMnrFlagVO.setTtlLssNtfyDt(ttlLssNtfyDt);
								iFMnrFlagVOS.add(iFMnrFlagVO);
							}
						}
						interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
						interfaceGRPVO.setMnrTotalLossStatusCode(ttlLssStsCd);

						/***************** MST 외부 인터페이스 호출을 위한 *********************/
						command3.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
						command4.manageIFFlagBasic(interfaceGRPVO,account);  
						//CLOSE TYPE: RE(RETURN OF EQ), TC(TLL CANCEL)이 아닌 장비들의 경우 현재 STATUS 확인 후 TLL이 아니면 TLL로 바꿔준다.
					}
//				}
			}
			commit();
			//Total Loss No return
			eventResponse.setETCData("totalLossNo", totalLossGRPVO.getTotalLossNo());
			String workType = totalLossGRPVO.getTotalLossINVO().getWorkType();
			if(!workType.equals("request")) {
				totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);
			}
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
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
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalSoldListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			EesMnr0160Event event = (EesMnr0160Event)e;
			DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();

			disposalSoldGRPVO = command.searchDisposalSoldListBasic(event.getDisposalSoldGRPVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispHdrVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalSoldDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();
		EesMnr0160Event event = (EesMnr0160Event)e;
		DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();
		try {
			begin();
			disposalSoldGRPVO = command.searchDisposalSoldDetailBasic(event.getDisposalSoldGRPVO(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispDtlVO());

		return eventResponse;
	}

	/**
	 * EES_MNR_0251 : Retrieve <br>
	 * [EES_MNR_0251]Sold Cancellation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalSoldCancelListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0251Event event = (EesMnr0251Event)e;
		DisposalMgtBC command = new DisposalMgtBCImpl();

		try{
			List<CustomMnrDispCancelVO> list = command.searchDisposalSoldCancelListBasic(event.getDisposalSoldINVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0163 : Retrieve <br>
	 * [EES_MNR_0163]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			if (e.getEventName().equalsIgnoreCase("EesMnr0163Event")) {
				EesMnr0163Event event = (EesMnr0163Event)e;
				disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();
			}else if (e.getEventName().equalsIgnoreCase("EesMnrS308Event")) {
				EesMnrS308Event event = (EesMnrS308Event)e;
				disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();
			}
			disposalInquiryGRPVO = command.searchDisposalInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomMnrRcvInvWrkVOs());

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0163 : Invoice Detail <br>
	 * [EES_MNR_0163]Disposal Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalDetailInquiryListService(Event e) throws EventException {
		try {
		 	// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnr0163Event event = (EesMnr0163Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchDisposalDetailInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomDispInvDtIVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0163 : Collection Info <br>
	 * [EES_MNR_0163]Disposal Invoice Collection 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCollectionInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnr0163Event event = (EesMnr0163Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchDisposalCollectionInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomBkgOtsDtlVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}


	/**
	 * EES_MNR_0163 : Load <br>
	 * [EES_MNR_0163] 파트너 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnrS308Event event = (EesMnrS308Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchPartnerBasic(disposalInquiryGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			if(disposalInquiryGRPVO.getDisposalInquiryINVO() ==null){
				eventResponse.setETCData("cust_cd","");
				eventResponse.setETCData("cust_lgl_eng_nm","");
			} else {
				eventResponse.setETCData(disposalInquiryGRPVO.getDisposalInquiryINVO().getColumnValues());
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0251 : Save <br>
	 * [EES_MNR_0251] Sold Cancellation의 정보를 저장 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalSoldCancelService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0251Event event = (EesMnr0251Event)e;

		try{
			begin();
			/***************** MST, CGM 외부 인터페이스 호출을 위한 **Start************/
			List<IFMnrFlagVO> iFMnrFlagVOList4MST = new ArrayList<IFMnrFlagVO>();
			List<IFMnrFlagVO> iFMnrFlagVOList4MGS = new ArrayList<IFMnrFlagVO>();
			List<IFMnrFlagVO> iFMnrFlagVOList4CHS = new ArrayList<IFMnrFlagVO>();

			for (int i=0; i<event.getCustomMnrDispCancelVOS().length; i++) {
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("SLD");
				iFMnrFlagVO.setStsFlag("N");
				iFMnrFlagVO.setEqNo(event.getCustomMnrDispCancelVOS()[i].getEqNo());

				// "U" = MST
				if ("U".equals(event.getCustomMnrDispCancelVOS()[i].getEqKndCd())) {
					iFMnrFlagVOList4MST.add(iFMnrFlagVO);
				}
				// "G" = M.G.Set
				else if ("G".equals(event.getCustomMnrDispCancelVOS()[i].getEqKndCd())) {
					iFMnrFlagVOList4MGS.add(iFMnrFlagVO);
				}
				// "Z" = Chassis
				else if ("Z".equals(event.getCustomMnrDispCancelVOS()[i].getEqKndCd())) {
					iFMnrFlagVOList4CHS.add(iFMnrFlagVO);
				} 
			}

			// MST
			if (iFMnrFlagVOList4MST.size() > 0) {
				IFMnrFlagVO[] iFMnrFlagVOs4MST = new IFMnrFlagVO[iFMnrFlagVOList4MST.size()];
				for (int j=0; j<iFMnrFlagVOList4MST.size(); j++) {
					iFMnrFlagVOs4MST[j] = iFMnrFlagVOList4MST.get(j);
				}
				ContainerOnOffhireBC command4MST =  new ContainerOnOffhireBCImpl();
				command4MST.createMNRStatusBasic(iFMnrFlagVOs4MST, account);
			}

			ChassisMgsetOnOffhireBC command4CGM1 =  null;
			// M.G.Set
			if (iFMnrFlagVOList4MGS.size() > 0) {
				command4CGM1 =  new ChassisMgsetOnOffhireBCImpl();
				command4CGM1.removeMGSByMNRSoldCancelBasic(iFMnrFlagVOList4MGS);
				command4CGM1.modifyMGSByMNRSoldCancelBasic(iFMnrFlagVOList4MGS);
			}
			// Chassis
			if (iFMnrFlagVOList4CHS.size() > 0) {
				command4CGM1 =  new ChassisMgsetOnOffhireBCImpl();
				command4CGM1.removeMGSByMNRSoldCancelBasic(iFMnrFlagVOList4CHS);
				command4CGM1.removeCHSByMNRSoldCancelBasic(iFMnrFlagVOList4CHS);
				command4CGM1.modifyCHSByMNRSoldCancelBasic(iFMnrFlagVOList4CHS);
			}
			/***************** MST, CGM 외부 인터페이스 호출을 위한 **End************/

			DisposalMgtBC command2 = new DisposalMgtBCImpl();
			command2.manageDisposalSoldCancel(event.getCustomMnrDispCancelVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("MNR00053").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0160 : Save <br>
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalSoldService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalMgtBC command = new DisposalMgtBCImpl();
		EesMnr0160Event event = (EesMnr0160Event)e;

		//*************** FLAG 처리용 ************************* //
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		//Flagging Row 갯수 구하기
		DisposalSoldGRPVO disposalSoldGRPVO = event.getDisposalSoldGRPVO();
		CustomMnrDispDtlVO[] arrayCustomMnrDispDtlVOs = disposalSoldGRPVO.getArrayCustomMnrDispDtlVO();
		int flgCnt = 0;
		for ( int i = 0; i < arrayCustomMnrDispDtlVOs.length; i++ ) {
			String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();
			if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {  //입력,삭제 변경
				flgCnt++;
			} else if (dispSoldDtFlg.equals("U")) {  //수정변경
				flgCnt = flgCnt + 2;
			}
		}
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[flgCnt];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[flgCnt];

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		String unFlagDay = formatter.format(new java.util.Date());

		//*************** FLAG 처리용 ************************* //
		try{
			//*************** FLAG START   ************************* //
			flgCnt = 0;

			for ( int i = 0; i < arrayCustomMnrDispDtlVOs.length; i++ ) {
				String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();
				//입력,삭제변경
				if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
					if(dispSoldDtFlg.equals("Y")) {
						customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
						customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
						customMnrEqStsVO.setMnrDmgFlg("1");
						customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
					} else {
						customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
						customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
						customMnrEqStsVO.setMnrDmgFlg("0");
						if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
							customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
						} else {
							customMnrEqStsVO.setMnrDmgFlgDt(unFlagDay);
						}
					}

					customMnrEqStsVO.setMnrStsRmk("From Disposal Sold Creation");
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					if(dispSoldDtFlg.equals("Y")) {
						customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
						customMnrFlgHisVO.setMnrStsFlg("1");
						customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
					} else {
						customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
						customMnrFlgHisVO.setMnrStsFlg("0");
						if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
							customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
						} else {
							customMnrFlgHisVO.setMnrFlgInpDt(unFlagDay);
						}
					}
					customMnrFlgHisVO.setMnrFlgTpCd("SLD");
					customMnrFlgHisVO.setMnrFlgInpTpCd("M");
					customMnrFlgHisVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgRmk("From Disposal Sold Creation");
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;

				//수정변경
				} else if (dispSoldDtFlg.equals("U")) {
					for(int j=0; j<2; j++) {
						//STS VO
						CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
						if(j==0) {
							customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
							customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							customMnrEqStsVO.setMnrDmgFlg("0");
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								customMnrEqStsVO.setMnrDmgFlgDt(unFlagDay);
							}
						} else {
							customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
							customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							customMnrEqStsVO.setMnrDmgFlg("1");
							customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						}
						customMnrEqStsVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
						customMnrEqStsVO.setMnrStsRmk("From Disposal Sold Creation");
						arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

						//FLG_HIS_VO
						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						if(j==0) {
							customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							customMnrFlgHisVO.setMnrStsFlg("0");
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								customMnrFlgHisVO.setMnrFlgInpDt(unFlagDay);
							}
						} else {
							customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							customMnrFlgHisVO.setMnrStsFlg("1");
							customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						}
						customMnrFlgHisVO.setMnrFlgTpCd("SLD");
						customMnrFlgHisVO.setMnrFlgInpTpCd("D");
						customMnrFlgHisVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());

						customMnrFlgHisVO.setMnrFlgRmk("From Disposal Sold Creation");
						arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

						flgCnt++;
					}
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd("SLD");
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			//*************** FLAG END   ************************* //

			/***************** MST 외부 인터페이스 호출을 위한 **********************/
			InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			if(flgCnt > 0) {
				for(int i = 0;i < arrayCustomMnrDispDtlVOs.length; i++){
					String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();
					//입력/삭제변경
					if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("SLD");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
						if(dispSoldDtFlg.equals("Y")) {
							iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						} else {
							iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								iFMnrFlagVO.setFlagDt(unFlagDay);
							}
						}
						//Damage Flag
						iFMnrFlagVO.setStsFlag(arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg());
						iFMnrFlagVO.setCustCntCd(arrayCustomMnrDispDtlVOs[i].getMnrPrnrCntCd());
						iFMnrFlagVO.setCustSeq(arrayCustomMnrDispDtlVOs[i].getMnrPrnrSeq());

						iFMnrFlagVOS.add(iFMnrFlagVO);
					//수정변경
					} else if(dispSoldDtFlg.equals("U")) {
						for(int j=0; j<2; j++) {
							IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
							iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
							iFMnrFlagVO.setFlagUserId(account.getUsr_id());
							iFMnrFlagVO.setFlagType("SLD");
							iFMnrFlagVO.setRetireFlag("N");
							iFMnrFlagVO.setEqKindCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
							if(j==0) {
								iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
								iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
								iFMnrFlagVO.setStsFlag("N"); //Damage Flag
								if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
									iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
								} else {
									iFMnrFlagVO.setFlagDt(unFlagDay);
								}
							} else {
								iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
								iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
								iFMnrFlagVO.setStsFlag("Y"); //Damage Flag
								iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
							}

							iFMnrFlagVO.setCustCntCd(arrayCustomMnrDispDtlVOs[i].getMnrPrnrCntCd());
							iFMnrFlagVO.setCustSeq(arrayCustomMnrDispDtlVOs[i].getMnrPrnrSeq());

							iFMnrFlagVOS.add(iFMnrFlagVO);
						}
					}
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			}
			/***************** MST 외부 인터페이스 호출을 위한 *********************/

			begin();

			//데미지 플래깅 체크가 존재하는 경우
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//데미지 플래깅 로직
				command3.manageIFFlagBasic(interfaceGRPVO,account);         //MST 외부 인터페이스 호출
			}

			command.manageDisposalSoldBasic(event.getDisposalSoldGRPVO(), account);
			commit();

			//수정된 결과를 재조회해서 날린다.
			disposalSoldGRPVO = command.searchDisposalSoldListBasic(event.getDisposalSoldGRPVO(), account);
			eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispHdrVO());
			eventResponse.setETCData("select_disp_no", disposalSoldGRPVO.getDisposalSoldINVO().getSelectedDispNo());
			eventResponse.setETCData("mnr_prnr_cnt_cd",disposalSoldGRPVO.getDisposalSoldINVO().getSelectedMnrPrnrCntCd());
			eventResponse.setETCData("mnr_prnr_seq",disposalSoldGRPVO.getDisposalSoldINVO().getSelectedMnrPrnrSeq());
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
	 * EES_MNR_0105 : Retrieve <br>
	 * [EES_MNR_0105]Total Loss Payment to Lessor Report의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossLessorReportListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0105Event event = (EesMnr0105Event)e;
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		try{
			List<TotalLossLessorReportVO> list = command.searchTotalLossLessorReportListBasic(event.getTotalLossLessorReportINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0221 : Verify <br>
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifySoldEQFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0221Event event = (EesMnr0221Event)e;

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getSoldEQFileListGRPVO().getArrayCustomMnrDatVrfyVO());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		SoldEQFileListGRPVO soldEQFileListGRPVO = event.getSoldEQFileListGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();
			//공통함수를 이용 임시테이블에 입력하고, 시퀀스를 얻어온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//Validation Check를 위한 업데이트문을 실행하고, 조회하여 수정된 값들을 얻어온다.
			soldEQFileListGRPVO.getSoldEQFileListINVO().setTmpSeq(seqValue);  				//set tmp_seq
			soldEQFileListGRPVO = command.verifySoldEQFileListBasic(soldEQFileListGRPVO);	//update and search
			commit();

			//set return to event
			eventResponse.setRsVoList(soldEQFileListGRPVO.getListCustomMnrDatVrfyVO());

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
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160] Release No 를 생성 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDispRlseNoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalMgtBC command = new DisposalMgtBCImpl();
		DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();
		try{
			disposalSoldGRPVO = command.searchDispRlseNoBasic(account);
			eventResponse.setETCData("dispRlseNo",disposalSoldGRPVO.getDispRlseNo());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_S232 : Verify<br>
	 * [EES_MNR_S232] Eq No의 존재를 검증 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyRPRCreateFileListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnrS232Event event = (EesMnrS232Event)e;
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
			GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

			VerifyRPRCreateFileListGRPVO rPRCreateMgtGRPVO = new VerifyRPRCreateFileListGRPVO();
			rPRCreateMgtGRPVO.setRPRCreateMgtINVO(event.getRPRCreateMgtINVO());

			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//시퀸스 값을 세팅
			rPRCreateMgtGRPVO.getRPRCreateMgtINVO().setTmpSeq(seqValue);
			//비즈로직에 따른 업데이트 진행 //조회시작
			rPRCreateMgtGRPVO = command.verifyRPRCreateFileListBasic(rPRCreateMgtGRPVO);
			commit();
			//로직완료
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(rPRCreateMgtGRPVO.getCustomMnrDatVrfyVOS());
			return eventResponse;
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Retrieve <br>
	 * [EES_MNR_S304] My Bidding List의 헤더목록을 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMyBiddingHdrListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = null;

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
				//myBiddingGRPVO.getMyBiddingINVO().setOfcCd(account.getOfc_cd());
			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
				myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
				myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
				//myBiddingGRPVO.getMyBiddingINVO().setOfcCd(account.getOfc_cd());
			}

			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Submit <br>
	 * [EES_MNR_S304] My Bidding List의 선택된 Bidding No의 Bidding Status을 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMyBiddingStatusListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			MyBiddingINVO myBiddingINVO = null;

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingINVO = event.getMyBiddingINVO();

			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingINVO = event.getMyBiddingINVO();
			}
			DisposalMgtBC command = new DisposalMgtBCImpl();

			List<CustomMyBiddingHdrVO> list = command.searchMyBiddingStatus(myBiddingINVO);
			if(list != null && list.size() > 0){
				eventResponse.setETCData("biddingStatus", list.get(0).getBiddingStatus());
			}

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}


	/**
	* EES_MNR_S304 : doActionIBSheet <br>
	* [EES_MNR_S304] My Bidding List의 디테일목록을 조회 합니다. <br>
	*
	* @param String eventName
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchMyBiddingDtlListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = null;

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
			}

			myBiddingGRPVO = command.searchMyBiddingDtlListBasic(myBiddingGRPVO);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(myBiddingGRPVO.getListEqCustomMyBiddingDtlVO());
			eventResponse.setRsVoList(myBiddingGRPVO.getListQtyCustomMyBiddingDtlVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Save <br>
	 * [EES_MNR_S304]My Bidding List의 디테일목록을 추가/수정 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMyBiddingDtlListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();

		MyBiddingGRPVO myBiddingGRPVO = null;

		//My Bidding List
		if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
		//Bidding List
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
			EesMnrS301Event event = (EesMnrS301Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
			myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
			myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			//저장
			myBiddingGRPVO = command.manageMyBiddingDtlListBasic(myBiddingGRPVO, account);
			commit();

			//조회
			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);

			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());
			eventResponse.setETCData("disp_no", myBiddingGRPVO.getDispNo());
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Save <br>
	 * [EES_MNR_S304]My Bidding List의 디테일목록을 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMyBiddingDtlListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();

		MyBiddingGRPVO myBiddingGRPVO = null;

		//My Bidding List
		if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
		//Bidding List
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
			EesMnrS301Event event = (EesMnrS301Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
			myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
			myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			//삭제
			myBiddingGRPVO = command.removeMyBiddingDtlListBasic(myBiddingGRPVO, account);
			commit();

			//조회
			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);

			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());
			eventResponse.setETCData("disp_no", myBiddingGRPVO.getDispNo());
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0235 : Doc Send <br>
	 * [EES_MNR_0235] M&R Disposal Release Order Document Transmission의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0235Event event = (EesMnr0235Event)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();

		try{
			DocGRPVO docGRPVO = event.getDocGRPVO();
			CustomDocHeaderVO customDocHeaderVO = docGRPVO.getCustomDocHeaderVO();

			begin();

			DocResultVO docResultVO = new DocResultVO();

			docResultVO.setTmplMrd("EES_MNR_0184.mrd");
			docResultVO.setRdSubSysCd("MNR");
			docResultVO.setBatFlg("N");
			docResultVO.setDocTitNm("");
			docResultVO.setEmlCtnt("");
			String dispNo 		= customDocHeaderVO.getDispNo();
			String userNm 		= customDocHeaderVO.getUserNm();
			String mnrPrnrCntCd = customDocHeaderVO.getMnrPrnrCntCd();
			String mnrPrnrSeq	= customDocHeaderVO.getMnrPrnrSeq();
			docResultVO.setTemplateArgs("/rv disp_no["+ dispNo +"] user_nm[" + userNm + "] mnr_prnr_cnt_cd[" + mnrPrnrCntCd + "] mnr_prnr_seq[" + mnrPrnrSeq +"]");
			docResultVO.setSndrNm(account.getUsr_nm());
			docResultVO.setFaxOffice(account.getOfc_cd());
			docResultVO.setReceiverRmail(customDocHeaderVO.getMnrPrnrEml());
			docResultVO.setSndrEml(account.getUsr_eml());
			docResultVO.setCreUsrId(account.getUsr_id());

			String arrFaxNo[] = customDocHeaderVO.getFaxNo().split(",");
			StringBuffer faxNo = new StringBuffer();
			for(int j = 0; j < arrFaxNo.length;j++){
				if(j>0){
					faxNo.append(",").append(" ;").append(arrFaxNo[j]);
				}else{
					faxNo.append(" ;").append(arrFaxNo[j]);
				}
			}

			docResultVO.setFaxRcvInfo(faxNo.toString());
			docResultVO.setTemplateFile("");
			docResultVO.setTrsmModCd(customDocHeaderVO.getTrsmModCd());

			command.docSendBasic(docResultVO, account);

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
	 * EES_MNR_0243 : Search <br>
	 * [EES_MNR_0243] Estimate Upload 자료에서 EQ_NO를 검증 <br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTypeByEqNoData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0243Event event = (EesMnr0243Event)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		try {
			List<EstimateUploadVO> list = command.searchEqTypeByEqNoBasic(event.getEstimateUploadVOs());
			eventResponse.setRsVoList(list);
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
	 * EES_MNR_0243 : Save <br>
	 * [EES_MNR_0243] Estimate Upload 자료를 가공하여 견적서로 생성합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateUploadService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl();

		//Estimate Upload 자료를  Event로 받아옴
		EesMnr0243Event event = (EesMnr0243Event)e;
		EstimateUploadVO[] estimateUploadVOs = event.getEstimateUploadVOs();

		try{
			begin();

			//TMP 테이블에 인서트
			EstimateUploadGRPVO estimateUploadGRPVO = command.createEstimateUploadBasic(estimateUploadVOs, account, event.getReqUi());
			List<InterfaceGRPVO> interfaceGRPVOList = estimateUploadGRPVO.getInterfaceGRPVOList();
			InterfaceGRPVO interfaceGRPVO = null;
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = null;

			//신규추가
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVOs = new CustomMnrRprRqstHdrVO();

			for (int i = 0; i < interfaceGRPVOList.size(); i++) {
				interfaceGRPVO = interfaceGRPVOList.get(i);
				//견적서가 본 테이블로 이동 가능여부 검증
				interfaceGRPVO = command.checkEDIEstimateBasic(interfaceGRPVO);
				//유효성 검증 결과 자료를 재할당
				interfaceGRPVOList.set(i, interfaceGRPVO);
				customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();

				//account 다시 세팅
				SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);

				//벨리데이션 통과 했다면
				if (interfaceGRPVO.getValidOk()) {
					//견적서 테이블에 인서트
					customMnrRprRqstHdrVOs = command2.ediEstimateCopyToEstimateDetail(interfaceGRPVO);

					/***********************FLAG *********************************/
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
					customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("E");
					customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());

					//RprWrkTpCd 에 따라 달라짐 무조건 플레깅
					customMnrFlgHisVO.setMnrStsFlg("1");

					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

					arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
					arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("DMG");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
					/********************** FLAG END **********************************/

					/***************** MST 외부 인터페이스 호출을 위한 [시작] **********************/
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					for(int j = 0; j < arrCustomMnrEqStsVOS.length; j++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
						iFMnrFlagVO.setFlagType("DMG");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
						iFMnrFlagVO.setStsFlag("Y");
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());

						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
					command.manageIFFlagBasic(interfaceGRPVO,ediAccount);
					/***************** MST 외부 인터페이스 호출을 위한 [끝]*********************/

					/////////////////////////////////////////////////////////////////////////////////////////////////
					//Verify 기능 추가 Start 2011.07.06 김영오
					/////////////////////////////////////////////////////////////////////////////////////////////////
					estimateGRPVO = new EstimateGRPVO();
					RepairMgtBC commandV0 = new RepairMgtBCImpl();

					//Verify 기능 추가 작업 전 조회
					//신규로 들어온 데이터들 조회.
					//Param1 : RQST_EQ_NO
					//Param2 : RPR_RQST_SEQ
					//Param3 : RPR_RQST_VER_NO
					EstimateINVO estimateINVOv = new EstimateINVO();
					estimateINVOv.setRqstEqNo(customMnrRprRqstHdrVOs.getRqstEqNo());
					estimateINVOv.setRprRqstSeq(customMnrRprRqstHdrVOs.getRprRqstSeq());
					estimateINVOv.setRprRqstVerNo(customMnrRprRqstHdrVOs.getRprRqstVerNo());
					estimateINVOv.setRprRqstLstVerFlg("Y");
					estimateGRPVO.setEstimateINVO(estimateINVOv);

					estimateGRPVO = commandV0.searchEstimateDtl(estimateGRPVO,account);

					/* 추가 부분 세팅 START
					: INP_MSG35 = AGMT_OFC_CTY_CD
					: INP_MSG36 = AGMT_SEQ
					: INP_MSG37 = 'NNN'
					: INP_MSG4  = 'SS'
					*/
					GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
					CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = new CustomMnrDatVrfyVO[estimateGRPVO.getCustomMnrRprRqstVDtlVOS().size()];

					for(int k = 0; k < estimateGRPVO.getCustomMnrRprRqstVDtlVOS().size(); k++){
						CustomMnrDatVrfyVO customMnrDatVrfyVO = new CustomMnrDatVrfyVO();
						customMnrDatVrfyVO.setInpMsg1(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(k).getEqLocCd());
						customMnrDatVrfyVO.setInpMsg2(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(k).getEqCmpoCd());
						customMnrDatVrfyVOS[k] = customMnrDatVrfyVO;
					}

					GeneralCodeSearchMgtBC commandV1 = new GeneralCodeSearchMgtBCImpl();
					for(int j = 0; j < customMnrDatVrfyVOS.length; j++){
						customMnrDatVrfyVOS[j].setInpMsg1(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getEqLocCd());
						customMnrDatVrfyVOS[j].setInpMsg2(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getEqCmpoCd());
						customMnrDatVrfyVOS[j].setInpMsg3(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getEqDmgCd());
						customMnrDatVrfyVOS[j].setInpMsg5(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getEqRprCd());
						customMnrDatVrfyVOS[j].setInpMsg6(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getTrfOptCd());
						customMnrDatVrfyVOS[j].setInpMsg7(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getTrfDivCd());
						customMnrDatVrfyVOS[j].setInpMsg8(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getVolTpCd());
						customMnrDatVrfyVOS[j].setInpMsg9(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprQty());
						customMnrDatVrfyVOS[j].setInpMsg10(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprSzNo());
						customMnrDatVrfyVOS[j].setInpMsg11(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprLbrHrs());
						customMnrDatVrfyVOS[j].setInpMsg12(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprLbrRt());
						customMnrDatVrfyVOS[j].setInpMsg13(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getLbrCostAmt());
						customMnrDatVrfyVOS[j].setInpMsg14(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getMtrlCostAmt());
						customMnrDatVrfyVOS[j].setInpMsg15(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getMnrWrkAmt());
						customMnrDatVrfyVOS[j].setInpMsg16(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprLbrBzcHrs());
						customMnrDatVrfyVOS[j].setInpMsg17(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getLbrMtrlBzcAmt());
						customMnrDatVrfyVOS[j].setInpMsg18(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprLbrBzcRt());
						customMnrDatVrfyVOS[j].setInpMsg19(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getCostCd());
						customMnrDatVrfyVOS[j].setInpMsg20(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getCostDtlCd());
						customMnrDatVrfyVOS[j].setInpMsg21(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getMnrLrAcctFlg());
						customMnrDatVrfyVOS[j].setInpMsg22(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getN3ptyFlg());
						customMnrDatVrfyVOS[j].setInpMsg23(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getN3ptyBilLbrHrs());
						customMnrDatVrfyVOS[j].setInpMsg24(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getN3ptyBilLbrRt());
						customMnrDatVrfyVOS[j].setInpMsg25(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getLbrCostAmt());
						customMnrDatVrfyVOS[j].setInpMsg26(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getN3ptyBilMtrlCostAmt());
						customMnrDatVrfyVOS[j].setInpMsg27(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getN3ptyBilAmt());
						customMnrDatVrfyVOS[j].setInpMsg28(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getMnrLbrBzcAmt());
						customMnrDatVrfyVOS[j].setInpMsg29(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getMnrAgmtAmt());
						customMnrDatVrfyVOS[j].setInpMsg30(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getRprDtlRmk());
						customMnrDatVrfyVOS[j].setUpdUsrId(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getUpdUsrId());
						customMnrDatVrfyVOS[j].setCreUsrId(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(j).getCreUsrId());

						customMnrDatVrfyVOS[j].setInpMsg35(customMnrRprRqstTmpHdrVO.getAgmtOfcCtyCd());
						customMnrDatVrfyVOS[j].setInpMsg36(customMnrRprRqstTmpHdrVO.getAgmtSeq());
						customMnrDatVrfyVOS[j].setInpMsg37("NNN");
						customMnrDatVrfyVOS[j].setInpMsg4("SS");

						//COST_CD 가 누락되어   없으면  여기서 다시 체크하여 넣어준다. INP_MSG19 ,ex) MRRURC
						//누락 되는 케이스를 찾을수가 없음 로그가 필요함
						if(customMnrDatVrfyVOS[j].getInpMsg19().equals("") || customMnrDatVrfyVOS[j].getInpMsg19() ==  null){
							//log.error("☞☞☞☞☞☞☞  COST_CD NOT EXIST ");
							//log.error("☞☞☞☞☞☞☞  EQ No : " + customMnrRprRqstTmpHdrVO.getRqstEqNo());
							//log.error("☞☞☞☞☞☞☞  Estimate No : " + customMnrRprRqstTmpHdrVO.getRqstRefNo());
							//log.error("☞☞☞☞☞☞☞  EQ TPSZ : " + customMnrRprRqstTmpHdrVO.getEqTpszCd());
							//log.error("☞☞☞☞☞☞☞  Componet CD : " + customMnrDatVrfyVOS[j].getInpMsg19());
							if(customMnrRprRqstTmpHdrVO.getEqKndCd().equals("U")){
								if(customMnrRprRqstTmpHdrVO.getEqTpszCd().startsWith("D")){
									customMnrDatVrfyVOS[j].setInpMsg19("MRDRRC");
								} else if(customMnrRprRqstTmpHdrVO.getEqTpszCd().startsWith("R")){
									CostCodeINVO costCodeINVO = new CostCodeINVO();
									//Component Code
									costCodeINVO.setCmpoCd(customMnrDatVrfyVOS[j].getInpMsg2());
									//Tpsz
									costCodeINVO.setTpSz(customMnrRprRqstTmpHdrVO.getEqTpszCd());
									CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
									costCodeGRPVO.setCostCodeINVO(costCodeINVO);
									costCodeGRPVO = commandV1.searchCostCodeBasic(costCodeGRPVO);
									List<CustomCostCodeVO> customCostCodeVOS = costCodeGRPVO.getCustomCostCodeVOS();
									if(customCostCodeVOS.size() > 0){
										customMnrDatVrfyVOS[j].setInpMsg19(customCostCodeVOS.get(0).getCostCd());
									} else {
										//DEFAULT
										customMnrDatVrfyVOS[j].setInpMsg19("MRRURC");
									}
								} else {
									customMnrDatVrfyVOS[j].setInpMsg19("MRDSRC");
								}
							} else if(customMnrRprRqstTmpHdrVO.getEqKndCd().equals("G")){
								customMnrDatVrfyVOS[j].setInpMsg19("MRGSRC");
							} else {
								customMnrDatVrfyVOS[j].setInpMsg19("MRZSRC");
							}
						}
						//COST_DTL_CD 가 누락되어   없으면  여기서 다시 체크하여 넣어준다. INP_MSG20 ,ex) NR
						if(customMnrDatVrfyVOS[j].getInpMsg20().equals("") || customMnrDatVrfyVOS[j].getInpMsg20() ==  null){
							customMnrDatVrfyVOS[j].setInpMsg20("NR");
						}
					}

					/* 추가 부분 세팅 END */
					generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);
					GeneralCodeCheckMgtBC commandV2  = new GeneralCodeCheckMgtBCImpl();

					//로직시작
					//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
					String seqValue = commandV2.createMnrTempDetail(generalCodeCheckMgtGRPVO,account);

					//값 세팅
					//시퀸스
					EstimateINVO estimateINVO = new EstimateINVO();
					estimateINVO.setTmpSeq(seqValue);
					//AGMT
					estimateINVO.setAgmtOfcCtyCd(customMnrRprRqstTmpHdrVO.getAgmtOfcCtyCd());
					estimateINVO.setAgmtSeq(customMnrRprRqstTmpHdrVO.getAgmtSeq());
					estimateINVO.setAgmtVerNo(customMnrRprRqstTmpHdrVO.getAgmtVerNo());
					//TRF
					estimateINVO.setTrfNo(customMnrRprRqstTmpHdrVO.getEqTpszCd());

					estimateINVO.setRqstEqNo(estimateINVOv.getRqstEqNo());
					estimateINVO.setRprRqstVerNo(estimateINVOv.getRprRqstVerNo());
					estimateINVO.setRprRqstSeq(estimateINVOv.getRprRqstSeq());
					estimateGRPVO.setEstimateINVO(estimateINVO);

					//비즈로직에 따른 업데이트 진행
					estimateGRPVO = commandV2.verifyEstimateCalcDetail(estimateGRPVO);
					/////////////////////////////////////////////////////////////////////////////////////////////////
					//Verify 기능 추가END 2011.07.06 김영오
					/////////////////////////////////////////////////////////////////////////////////////////////////

					// HOUR * Qty , Material * Qty 계산식 적용으로 인하여 임시로 사용하지 않기로 함 - 2012.01.19 김상수  
					/*
					//EDI로 입력된 RPR_LBR_HRS는 무시하고, Verify되어진 RPR_LBR_BZ_HRS로 대체 - 2011.10.26 김상수
					command2.modifyEstimateDTLTmpDTLData(interfaceGRPVO, estimateGRPVO);
					*/

				}
			}
			commit();

			//가공된 자료의 결과목록을 조회
			List<EstimateUploadVO> estimateUploadVOList = command.searchEstimateUploadResultBasic(estimateUploadGRPVO);
			eventResponse.setRsVoList(estimateUploadVOList);
			eventResponse.setETCData("complex_pk", estimateUploadGRPVO.getEstimateUploadPkStr());

		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	* EES_MNR_S304 : doActionIBSheet <br>
	* [EES_MNR_S304] My Bidding List의  Local Time을 조회 합니다. <br>
	*
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchMyBiddingLoaclTimeListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = null;

			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();

			myBiddingGRPVO = command.searchMyBiddingLoaclTimeListBasic(myBiddingGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setETCData(myBiddingGRPVO.getMyBiddingINVO().getColumnValues());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0252 : Retrieve <br>
	 * [EES_MNR_0252]EDI Estimate Group Auditing의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIGroupAuditListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EesMnr0252Event event = (EesMnr0252Event)e;
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0252 : Reject,Approval <br>
	 * [EES_MNR_0252]EDI Estimate Group Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIGroupAuditListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();

		EesMnr0252Event event = (EesMnr0252Event)e;
		EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

		try{
			begin();
			command.manageESTGroupAuditListBasic(estimateGRPVO,account);

			//************* TPB Start ********************//
			InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
			CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
			//Approval 일 경우만
			if(estimateGRPVO.getGroupAuditAction().equals("Approval")){
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				for(int i = 0;i < customMnrRprRqstHdrVOS.length;i ++){
					CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS[i];
					if(customMnrRprRqstHdrVO.getN3ptyFlg().equalsIgnoreCase("Y")){
						interfaceGRPVO.setTpbRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						interfaceGRPVO.setTpbRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
						interfaceGRPVO.setTpbRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
						command1.createTPBIFBasic(interfaceGRPVO, account);
					}
				}
			}
			//************* TPB End *********************//
			commit();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0256 : Retrieve <br>
	 * [EES_MNR_0256]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCancelledInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			if (e.getEventName().equalsIgnoreCase("EesMnr0256Event")) {
				EesMnr0256Event event = (EesMnr0256Event)e;
				disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();
			}
			disposalInquiryGRPVO = command.searchDisposalCancelledInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomMnrRcvInvWrkVOs());

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0256 : Invoice Detail <br>
	 * [EES_MNR_0256]Disposal Cancelled Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalDetailCancelledInquiryListService(Event e) throws EventException {
		try {
		 	// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnr0256Event event = (EesMnr0256Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchDisposalDetailCancelledInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomDispInvDtIVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0257 : Retrieve <br>
	 * [EES_MNR_0257] Hanger Rack/Bar Using Report의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHangerRackReportListService(Event e) throws EventException {
		try {
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EesMnr0257Event event = (EesMnr0257Event)e;

			List<HangerRackReportVO> list = command.searchHangerRackReportListBasic(event.getHangerRackReportVO(), account);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0258 : Retrieve <br>
	 * [EES_MNR_0258] Hanger Rack/Bar Using Report Pop Up의 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchHangerRackReportDtlListService(Event e) throws EventException {
		try {
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EesMnr0258Event event = (EesMnr0258Event)e;

			List<HangerRackReportVO> list = command.searchHangerRackReportDtlListBasic(event.getHangerRackReportVO(), account);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
    /**
	 * EES_MNR_0159 : searchVerifyBiddingDateService <br>
	 * [EES_MNR_0159] Bidding End Date를 시스템 날짜와 비교합니다. <br>
	 * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVerifyBiddingDateService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
    		EesMnr0159Event event = (EesMnr0159Event)e;
    		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
			
			String dispEndDt = disposalGRPVO.getCustomMnrDispHdrVO().getDispEndDt();
			int year = Integer.parseInt(dispEndDt.substring(0, 4));
			int mon = Integer.parseInt(dispEndDt.substring(5, 7));
			int date = Integer.parseInt(dispEndDt.substring(8, 10));
			int hour = Integer.parseInt(dispEndDt.substring(11, 13));
			int min = Integer.parseInt(dispEndDt.substring(14, 16));
			int sec = Integer.parseInt(dispEndDt.substring(17, 19 ));
			
			Calendar currentCalendar = Calendar.getInstance();

			Calendar baseCalendar = Calendar.getInstance();
			baseCalendar.set(year, mon-1, date, hour, min, sec);
			
			boolean verifyRslt = currentCalendar.before(baseCalendar);			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			eventResponse.setETCData("verifyRslt", verifyRslt+"");
			
			return eventResponse;

		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
	 * EES_MNR_0159 : searchVerifyDisposalNoService <br>
	 * [EES_MNR_0159] Disposal No 를 체크합니다. <br>
	 * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVerifyDisposalNoService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
    		EesMnr0159Event event = (EesMnr0159Event)e;
    		DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
			String dispNo = "";
    		DisposalMgtBC command = new DisposalMgtBCImpl();

			disposalGRPVO = command.searchVerifyDisposalNoBasic(disposalGRPVO);
			
			StringBuffer sb = new StringBuffer();
			if(disposalGRPVO.getCustomMnrDispHdrVOS().size()>0){
				for(int i = 0; i < disposalGRPVO.getCustomMnrDispHdrVOS().size();i++){
					sb.append(disposalGRPVO.getCustomMnrDispHdrVOS().get(i).getDispNo()+", ");
				}
				dispNo = sb.toString();
			}
			
			if(dispNo.length() > 0){
				dispNo = dispNo.substring(0, dispNo.length()-2);
			}
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			eventResponse.setETCData("DISP_NO", dispNo);
			
			return eventResponse;

		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
	/**
	 * EES_MNR_0098 : Modify <br>
	 * [EES_MNR_0098]Total Loss Collection & Inquiry 의 invoice no를 수정합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTotalLossDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		EesMnr0098Event event = (EesMnr0098Event)e;
		TotalLossGRPVO totalLossGRPVO = event.getTotalLossGRPVO();

		try {
			begin();
			
			CustomMnrTtlLssRqstDtlVO[]  arrayCustomMnrTtlLssRqstDtlVOs  = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			
			totalLossGRPVO.setArrayCustomMnrTtlLssRqstDtlVOs(arrayCustomMnrTtlLssRqstDtlVOs);
			command.modifyTotalLossDetailInvNoBasic(totalLossGRPVO, account);	
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
	 * EES_MNR_0261 : Retrieve <br>
	 * [EES_MNR_0261] Not Pick-up Container No Pop Up의 정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDisposalNoPickUpListService(Event e) throws EventException {
		try {
			DisposalMgtBC command = new DisposalMgtBCImpl();
			EesMnr0261Event event = (EesMnr0261Event)e;

			List<CustomMnrDispNoPickUpVO> list = command.searchDisposalNoPickUpListBasic(event.getDisposalNVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}		

	/**
	 * EES_MNR_0095 : Retrieve <br>
	 * [EES_MNR_0095]Total Loss Request 에서 로그인 Office의 지역이 US인지 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeAreaUS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		
		EesMnr0095Event event = (EesMnr0095Event)e;

		try{
			int totCnt = command.searchOfficeAreaUS(event.getRqstOfcCd());
			
			String chkUS = (totCnt > 0) ? "Y" : "N";
			eventResponse.setETCData("chkUS", chkUS);

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0243 : Search <br>
	 * [EES_MNR_0243] Estimate Upload 자료에서 [Calculation]처리 전, eq No 로 관련 정보 조회 <br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHdrDataByEqNoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0243Event event = (EesMnr0243Event)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		try {
			EstimateUploadVO[] estimateUploadVOs = event.getEstimateUploadVOs();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
			
			if(estimateUploadVOs.length > 0){
				customMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO(); 
				customMnrRprRqstHdrVO.setRqstEqNo(estimateUploadVOs[0].getRqstEqNo());
								
			}
			// 1. eq no 로, eq type, tp/sz 조회
			customMnrRprRqstHdrVO = command.searchEqTypeNTpSzByEqNoBasic(customMnrRprRqstHdrVO);
			if(customMnrRprRqstHdrVO == null){
				// 해당 eq no 값이 없을때, 
				eventResponse.setETCData("verifyRslt", "EQ No not found");
			}else{
				// eq knd cd 가 없을때
				if("".equals(customMnrRprRqstHdrVO.getEqKndCd()) || null == customMnrRprRqstHdrVO.getEqKndCd()){
					eventResponse.setETCData("verifyRslt", "EQ Type not found");
				}else{
					eventResponse.setETCData("eqKndCd", customMnrRprRqstHdrVO.getEqKndCd());
					eventResponse.setETCData("eqTpszCd", customMnrRprRqstHdrVO.getEqTpszCd());
					
					if("".equals(estimateUploadVOs[0].getEdiId())){
						eventResponse.setETCData("verifyRslt", "EDI ID not found");
					}else{
						// 2. edi id, eq type으로 service provider 정보 조회			
						customMnrRprRqstHdrVO.setEdiId(estimateUploadVOs[0].getEdiId());		
						customMnrRprRqstHdrVO = command.searchTempEstimateAGMTBasic(customMnrRprRqstHdrVO);		
						if(customMnrRprRqstHdrVO == null){
							eventResponse.setETCData("verifyRslt", "Agreement not found(EDI ID or EQ Type unmatched)");
						}else{
							// 조회값이 각각 없을때, 처리
							eventResponse.setETCData("agmtOfcCtyCd", customMnrRprRqstHdrVO.getAgmtOfcCtyCd());
							eventResponse.setETCData("agmtSeq", customMnrRprRqstHdrVO.getAgmtSeq());
							eventResponse.setETCData("agmtVerNo", customMnrRprRqstHdrVO.getAgmtVerNo());
							eventResponse.setETCData("trfNo", customMnrRprRqstHdrVO.getTrfNo());
						}
					}
					
				}
			}
			
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
	 * EES_MNR_0262 : Retrieve <br>
	 * [EES_MNR_0262]Write Off Request 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossWriteOffRqstListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0262Event event = (EesMnr0262Event)e;
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();

			totalLossGRPVO = command.searchTotalLossWriteOffRqstListBasic(event.getTotalLossGRPVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVO());
			if(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().size() >0){
				eventResponse.setETCData("respb_ofc_cd", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getRespbOfcCd());
				eventResponse.setETCData("rqst_dt", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getRqstDt());
				eventResponse.setETCData("ttl_lss_rsn_cd", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getTtlLssRsnCd());
				eventResponse.setETCData("ttl_lss_dtl_rsn_cd", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getTtlLssDtlRsnCd());
				eventResponse.setETCData("ttl_lss_dt", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getTtlLssDt());
				eventResponse.setETCData("ttl_lss_no", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getTtlLssNo());
				eventResponse.setETCData("file_seq", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getFileSeq());
				eventResponse.setETCData("mnr_sts_ref_no", totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO().get(0).getMnrStsRefNo());
			}else{
				eventResponse.setETCData("respb_ofc_cd", "");
				eventResponse.setETCData("rqst_dt", "");
				eventResponse.setETCData("ttl_lss_rsn_cd", "");
				eventResponse.setETCData("ttl_lss_dtl_rsn_cd", "");
				eventResponse.setETCData("ttl_lss_dt", "");
				eventResponse.setETCData("ttl_lss_no", "");
				eventResponse.setETCData("file_seq", "");
				eventResponse.setETCData("mnr_sts_ref_no", "");
			}
			if(!"".equals(totalLossGRPVO.getWrtfNo())){
				if(!"RS".equals(totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getWrtfStsCd())){
					eventResponse.setETCData("ttl_lss_dtl_rsn_rmk", "");
					eventResponse.setETCData("dpc_clt_fald_rsn_rmk", "");
					eventResponse.setETCData("rcvr_act_his_rmk", "");
					eventResponse.setETCData("sub_file_seq", "");
					eventResponse.setETCData("wrtf_sts_cd", "");
					eventResponse.setETCData("wrtf_no", "");
				}else{
					eventResponse.setETCData("ttl_lss_dtl_rsn_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getTtlLssDtlRsnRmk());
					eventResponse.setETCData("dpc_clt_fald_rsn_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getDpcCltFaldRsnRmk());
					eventResponse.setETCData("rcvr_act_his_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getRcvrActHisRmk());
					eventResponse.setETCData("sub_file_seq", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getSubFileSeq());
					eventResponse.setETCData("wrtf_sts_cd", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getWrtfStsCd());
					eventResponse.setETCData("wrtf_no", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getWrtfNo());
				}
			}else{
				eventResponse.setETCData("ttl_lss_dtl_rsn_rmk", "");
				eventResponse.setETCData("dpc_clt_fald_rsn_rmk", "");
				eventResponse.setETCData("rcvr_act_his_rmk", "");
				eventResponse.setETCData("sub_file_seq", "");
				eventResponse.setETCData("wrtf_sts_cd", "");
				eventResponse.setETCData("wrtf_no", "");
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0262 : Save <br>
	 * [EES_MNR_0262]Write Off Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWriteOffRqstService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ApprovalStepMgtBC command3 = new ApprovalStepMgtBCImpl();
		ApprovalStepGRPVO approvalStepGRPVO = new ApprovalStepGRPVO();

		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;

		EesMnr0262Event event = (EesMnr0262Event)e;
		totalLossGRPVO = event.getTotalLossGRPVO();
		

		try{
			begin();

			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 시작
			//////////////////////////////////////////////////////////////////////////////////////////////////
			String paramWrtfNo = totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfNo();
			
			totalLossGRPVO = command.manageWriteOffBasic(totalLossGRPVO, account);
			
			CustomApprovalStepHistoryVO[] arrCustomApprovalStepHistoryVOs = totalLossGRPVO.getArrCustomApprovalStepHistoryVOs();
			if(totalLossGRPVO.getArrCustomApprovalStepHistoryVOs() != null){
				if("NEW".equals(paramWrtfNo)||"".equals(paramWrtfNo)){
					for(int i=0; i < arrCustomApprovalStepHistoryVOs.length; i++){
						arrCustomApprovalStepHistoryVOs[i].setWrtfNo(totalLossGRPVO.getWrtfNo());
					}
				}
				approvalStepGRPVO.setCustomApprovalStepHistoryVOs(arrCustomApprovalStepHistoryVOs);
				approvalStepGRPVO.setWorkType(totalLossGRPVO.getTotalLossINVO().getWorkType());
				approvalStepGRPVO.setWrtfNo(totalLossGRPVO.getWrtfNo());
				command3.manageApprovalStepHistoryBasic(approvalStepGRPVO, account);
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 끝
			//////////////////////////////////////////////////////////////////////////////////////////////////
			
			commit();
			
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
			eventResponse.setETCData("wrtf_no", totalLossGRPVO.getWrtfNo());
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
	 * EES_MNR_0262 : Delete <br>
	 * [EES_MNR_0262]Write Off Request의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWriteOffRqstService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

//		ApprovalStepMgtBC command3 = new ApprovalStepMgtBCImpl();
//		ApprovalStepGRPVO approvalStepGRPVO = new ApprovalStepGRPVO();

		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;

		EesMnr0262Event event = (EesMnr0262Event)e;
		totalLossGRPVO = event.getTotalLossGRPVO();
		

		try{
			begin();
			totalLossGRPVO = command.removeWriteOffBasic(totalLossGRPVO,account);
			
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
	 * EES_MNR_0263 : Retrieve <br>
	 * [EES_MNR_0263]Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffApprovalListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0263Event event = (EesMnr0263Event)e;
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();

			totalLossGRPVO = command.searchWriteOffApprovalListBasic(event.getTotalLossGRPVO(), account);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0263 : Retrieve <br>
	 * [EES_MNR_0263]Write Off Approval Detail 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffApprovalDetailService(Event e) throws EventException {
		try {
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
			
			if(e.getEventName().equalsIgnoreCase("EesMnr0263Event")){
				EesMnr0263Event event = (EesMnr0263Event)e;
				totalLossGRPVO = event.getTotalLossGRPVO();
			}else if(e.getEventName().equalsIgnoreCase("EesMnr0264Event")){
				EesMnr0264Event event = (EesMnr0264Event)e;
				totalLossGRPVO = event.getTotalLossGRPVO();
			}
			// PDTO(Data Transfer Object including Parameters)
			
			totalLossGRPVO = command.searchWriteOffApprovalDetailBasic(totalLossGRPVO);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVO());
			
			eventResponse.setETCData("ttl_lss_dtl_rsn_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getTtlLssDtlRsnRmk());
			eventResponse.setETCData("dpc_clt_fald_rsn_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getDpcCltFaldRsnRmk());
			eventResponse.setETCData("rcvr_act_his_rmk", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getRcvrActHisRmk());
			eventResponse.setETCData("sub_file_seq", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getSubFileSeq());
			eventResponse.setETCData("file_seq", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getFileSeq());
			eventResponse.setETCData("wrtf_sts_cd", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getWrtfStsCd());
			eventResponse.setETCData("wrtf_no", totalLossGRPVO.getListCustomMnrWrtfRqstHdrVO().get(0).getWrtfNo());
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0263 : Save <br>
	 * [EES_MNR_0263]Write Off Approval 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWriteOffApprovalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ApprovalStepMgtBC command3 = new ApprovalStepMgtBCImpl();
		ApprovalStepGRPVO approvalStepGRPVO = new ApprovalStepGRPVO();

		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = null;

		EesMnr0263Event event = (EesMnr0263Event)e;
		totalLossGRPVO = event.getTotalLossGRPVO();
		
		String ofcTpCd = "";
		try{
			begin();

			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 시작
			//////////////////////////////////////////////////////////////////////////////////////////////////			
			ofcTpCd = command3.searchApprovalOfcTypeBasic(approvalStepGRPVO, account);
			totalLossGRPVO.setOfcTpCd(ofcTpCd);
			
			totalLossGRPVO = command.manageWriteOffApprovalBasic(totalLossGRPVO, account);
			
			CustomApprovalStepHistoryVO[] arrCustomApprovalStepHistoryVOs = totalLossGRPVO.getArrCustomApprovalStepHistoryVOs();
			if(totalLossGRPVO.getArrCustomApprovalStepHistoryVOs() != null){
				approvalStepGRPVO.setCustomApprovalStepHistoryVOs(arrCustomApprovalStepHistoryVOs);
				approvalStepGRPVO.setWorkType(totalLossGRPVO.getTotalLossINVO().getWorkType());
				approvalStepGRPVO.setWrtfNo(totalLossGRPVO.getCustomMnrWrtfRqstHdrVO().getWrtfNo());
				command3.manageApprovalStepHistoryBasic(approvalStepGRPVO, account);
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//공통저장 끝
			//////////////////////////////////////////////////////////////////////////////////////////////////
			
			commit();
			
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
			eventResponse.setETCData("wrtf_no", totalLossGRPVO.getWrtfNo());
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
	 * EES_MNR_0156 <br>
	 * [EES_MNR_0156]Disposal No 의 중복체크를 한다 <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalNoDubChkService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();

		DisposalGRPVO disposalGRPVO = null;
		
		EesMnr0156Event event = (EesMnr0156Event)e;
		disposalGRPVO = event.getDisposalGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			disposalGRPVO = command.searchDisposalNoDubChkBasic(disposalGRPVO);
			String dub_disp_no = disposalGRPVO.getCustomMnrDispHdrVOS().get(0).getDispNo();
			if(dub_disp_no == null || "".equals(dub_disp_no)){
				dub_disp_no = "";
			}
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			eventResponse.setETCData("dub_disp_no", dub_disp_no);
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
	 * EES_MNR_0019  <br>
	 * [EES_MNR_0019] Estimate Creation 정보를 체크합니다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTNextVerNoListService(Event e) throws EventException {
		RepairMgtBC command = new RepairMgtBCImpl();
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}
		
		try {
			estimateGRPVO = command.searchESTNextVerNoListBasic(estimateGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = estimateGRPVO.getCustomMnrRprRqstHdrVOS();
			StringBuffer rqstEqNo = new StringBuffer();
			String chkEqNo = "";
			if(customMnrRprRqstHdrVOS != null){
				for(int i = 0; i < customMnrRprRqstHdrVOS.size();i++){
					if(i>0){
						rqstEqNo.append(",").append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}else{
						rqstEqNo.append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}
				}
				chkEqNo = rqstEqNo.toString();
			}		
			eventResponse.setETCData("RQST_EQ_NO", chkEqNo);
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0023  <br>
	 * [EES_MNR_0023] Estimate Creation 정보를 체크합니다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTApprovalNextVerNoListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0023Event event = (EesMnr0023Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();
			
			estimateGRPVO = command.searchESTApprovalNextVerNoListBasic(estimateGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = estimateGRPVO.getCustomMnrRprRqstHdrVOS();
			StringBuffer rqstEqNo = new StringBuffer();
			String chkEqNo = "";
			if(customMnrRprRqstHdrVOS != null){
				for(int i = 0; i < customMnrRprRqstHdrVOS.size();i++){
					if(i>0){
						rqstEqNo.append(",").append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}else{
						rqstEqNo.append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}
				}
				chkEqNo = rqstEqNo.toString();
			}		
			eventResponse.setETCData("RQST_EQ_NO", chkEqNo);
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0022  <br>
	 * [EES_MNR_0022] Estimate Creation 정보를 체크합니다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTGroupApprovalNextVerNoListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0022Event event = (EesMnr0022Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();
			
			estimateGRPVO = command.searchESTNextVerNoListBasic(estimateGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = estimateGRPVO.getCustomMnrRprRqstHdrVOS();
			StringBuffer rqstEqNo = new StringBuffer();
			String chkEqNo = "";
			if(customMnrRprRqstHdrVOS != null){
				for(int i = 0; i < customMnrRprRqstHdrVOS.size();i++){
					if(i>0){
						rqstEqNo.append(",").append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}else{
						rqstEqNo.append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}
				}
				chkEqNo = rqstEqNo.toString();
			}		
			eventResponse.setETCData("RQST_EQ_NO", chkEqNo);
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0264 : Retrieve <br>
	 * [EES_MNR_0264]Write Off Approval 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffApprovalInquiryService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0264Event event = (EesMnr0264Event)e;
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();

			totalLossGRPVO = command.searchWriteOffApprovalInquiryBasic(event.getTotalLossGRPVO(), account);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0023 : doActionIBSheet <br>
	 * [EES_MNR_0023]Repair Estimate Creation의 썸네일 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHtmlCodeForThumbnail(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = null;
			
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();

			
			String htmlCodeForThumbnail = new String();
			htmlCodeForThumbnail = command.searchHtmlCodeForThumbnail(estimateGRPVO.getThumbnailFileSeq());
			
			eventResponse.setETCData("htmlCodeForThumbnail", htmlCodeForThumbnail);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	/**
	 * EES_MNR_0151 : Load Excel 후 자동 조회(OnLoadExcel) <br>
	 * [EES_MNR_0151]Load Excel로 전달 받은 EQ들에 대한 정보를 조회합니다. <br> <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQDataForDisposalRSQL(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			EqListForDisposalVO[] eqList = null;
			String eqKndCd = null;
			
			List<CustomMnrEqStsVO> eqInformation = new ArrayList<CustomMnrEqStsVO>();

			if(e.getEventName().equalsIgnoreCase("EesMnr0151Event")){
				EesMnr0151Event event = (EesMnr0151Event)e;
				eqList = event.getEqListForDisposalVOs();
				eqKndCd = event.getEqKndCd();
			}

			eqInformation = command.searchEQDataForDisposalRSQL(eqList, eqKndCd);
			
			eventResponse.setRsVoList(eqInformation);
			return eventResponse;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0061 : Retrieve <br>
	 * [EES_MNR_0061] ACEP Check List 조회 <br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAcepChk(Event e) throws EventException {
		try {
			RepairMgtBC command = new RepairMgtBCImpl();
			
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			AcepChkGrpVO acepChkGrpVO = new AcepChkGrpVO();
			EesMnr0061Event event = (EesMnr0061Event)e;

			acepChkGrpVO.setAcepChkHdrVO(event.getAcepChkGrpVO().getAcepChkHdrVO());

			acepChkGrpVO = command.searchAcepChk(acepChkGrpVO,account);

			eventResponse.setETCData(acepChkGrpVO.getAcepChkHdrVO().getColumnValues());
			eventResponse.setRsVoList(acepChkGrpVO.getAcepChkDtlVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0061 : Save <br>
	 * [EES_MNR_0061] ACEP Check List 저장 <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageAcepChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AcepChkGrpVO acepChkGrpVO = new AcepChkGrpVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();
		EesMnr0061Event event = (EesMnr0061Event)e;
		acepChkGrpVO = event.getAcepChkGrpVO();

		try {
			begin();
			acepChkGrpVO = command.manageAcepChk(acepChkGrpVO,account);
			
			eventResponse.setETCData(acepChkGrpVO.getAcepChkHdrVO().getColumnValues());
			eventResponse.setRsVoList(acepChkGrpVO.getAcepChkDtlVOs());
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