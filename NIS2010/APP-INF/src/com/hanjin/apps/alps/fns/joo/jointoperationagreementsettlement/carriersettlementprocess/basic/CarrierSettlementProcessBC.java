/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessBC.java
*@FileTitle : War Risk Surcharge Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 박희동
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.03 진마리아 [CHM-201006730-01]
                    Summary of Monthly Clearance Status by Carrier 기능에 Due Date, Remark 컬럼 추가
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
* 2011.01.12 김상수 [소스품질관리] R4J에 도출된 parameter 비매치 주석 수정
* 
* 2012.06.21 김상근[CHM-201218380]
* Ticket Title : [ALPS JOO] TDR Inquiry by VVD
* Description  :  Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가.
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustOusRDRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.IntloadSumReportVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusReportVO;
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
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusBsaVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrRatioVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SkdPortVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;

 
/**
 * ALPS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - ALPS-Jointoperationagreementsettlement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Hee Dong
 * @see Fns_joo_0013EventResponse 참조
 * @since J2EE 1.6
 */

public interface CarrierSettlementProcessBC {
	/**
	 * JOO_SETTLEMENT를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * Settlement를 저장한다.
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 다건의 JOO_SETTLEMENT를 삭제한다.
	 * -조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm
	 * @param ProcSettlementVO procSettlementVO
	 * @return ProcSettlementVO[]  
	 * @throws EventException
	 */
	public ProcSettlementVO[] removeSettlement(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * Settlement에서 Create 버튼을 눌렀을 경우 Joo_settlement에 없는 항차를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * 0037화면에서 JOO_SETTLEMENT를 읽어온다.
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByTrade (McsStatusVO mcsStatusVO) throws EventException;
	
	/**
	 * FNS_JOO_0007 Slot Hire 의 Create 버튼을 눌렀을 경우 JOO_SETTLEMENT에 없는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForSlotHireList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * 0037 선사를 조회조건으로 joo_settlement를 조회한다.
	 * @param McsStatusVO mcsStatusVO 
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByCarrier  (McsStatusVO mcsStatusVO) throws EventException;

	/**
	 * FNS_JOO_0009 OUS RDR 화면의 Create버튼을 눌렀을 경우 JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusRdrList(ProcSettlementVO procSettlementVO) throws EventException;
	
    /**
     *  Monthly Clearance Status by Carrier & Lane - Retrieve
     *     UID : FNS_JOO_0039
     * @param StlConditionVO stlConditionVO
     * @return List<McsVO>
     * @throws EventException
     */ 
    public List<McsVO> searchMcsListByCarNLane(  StlConditionVO stlConditionVO  ) throws EventException;
    
    /**
     *  Monthly Clearance Status by Carrier & Lane - Retrieve
     *     UID : FNS_JOO_0039
     * @param StlConditionVO stlConditionVO
     * @param JooSettlementVO[] jooSettlementVOs
     * @return List<McsVO>
     * @throws EventException
     */
    public List<McsVO> searchMccDtlListByCarNLane(StlConditionVO stlConditionVO, JooSettlementVO[] jooSettlementVOs) throws EventException;    
 
    /**
     * Inter Port / Ocean 선택시 단가, used qty등을 조회한다.
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrc(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * FNS_JOO_0010 OUS TDR용 Create버튼을 눌렀을 경우  JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusTdrList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * OUS TDR에서 VVD 입력시 기본정보를 가져온다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrFnl(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * VVD와 from~to port 입력시 USED SLOT 의 TEU, WGT, USED SLOT PRICE를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlot(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * VVD와 from port 입력시 USED SLOT PRICE를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlotPrice(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * FNS_JOO_0011 R/F settlement의 조회용 method임
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> searchSettlementRFList(ProcSettlementVO procSettlementVO) throws EventException;

    /**
	 * FNS_JOO_0011 R/F의 Creation용 조회 Method
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchAddStlForRFList(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * FNS_JOO_0011 R/F의 Row Add에서 I/O, RGN, POL, POD변경시 Used R/F 데이터를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchUsedReeferList(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * Adjustment Slot Hire 조회
	 * @param AdjustConditionVO adjustConditionVO
	 * @return List<AdjustSettlementVO>
	 * @throws EventException
	 */
	public List<AdjustSettlementVO> searchAdjustSlotHireStlList(AdjustConditionVO adjustConditionVO) throws EventException;

	/**
	 * Adjust Settlement 저장 (JOO_SETTLEMENT와 JOO_STL_DTL 에 Insert, Delete만 존재한다.)
	 * @param AdjustSettlementVO[] adjustSettlementVOs 
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdjustSlotHireStl(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
    /**
     * Monthly Clearance by Carrier & Lane의 Carrier정보를 조회 합니다.<br>
     * D : FNS_JOO_0015
     * 
     * @param StlConditionVO stlConditionVO
     * @return List<SettlementVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SettlementVO>  searchMonthlyClearanceList(StlConditionVO stlConditionVO) throws EventException;
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * [Summary of Monthly Clearance Status by VVD]을 [조회 Retrieve]합니다.<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<McsStatusReportVO>  searchSummaryOfMcsListByVVD(McsStatusVO mcsStatusVO) throws EventException;
 
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * [Summary of Monthly Clearance Status by VVD -Total]을 [조회 Retrieve]합니다.<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<McsStatusReportVO>  searchSummaryOfMcsListBySumVVD(McsStatusVO mcsStatusVO) throws EventException;
 
    
    
    
    /**
     * FNS_JOO_0042 : Retrieve
     * D : [FnsJoo0042Event]<br>
     * [Slot Exchange Status by Lane & Partner->Finance Lane]을 [조회 Retrieve]합니다.<br>
     *
     * @param  SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchLaneVO>    searchSlotXchStatusListByFinanceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException;      
 
    /**
     * FNS_JOO_0043 : Retrieve
     * D : [FnsJoo0043Event]<br>
     * [ Slot Exchange Status by Lane & Partner->Finance  Partner]을 [조회 Retrieve]합니다.<br>
     *
     * @param  SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO> 
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchPartnerVO>   searchSlotXchStatusListByFinancePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException;
    
    /**
     * 
     * FNS_JOO_0040 <br> 
     * Slot Exchange Status by Lane & Partner->Space On Lane 정보를 조회 합니다.<br>
     *
     * @param SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchLaneVO> searchSlotXchStatusListBySpaceLane(SlotXchLaneVO slotXchLaneVO) throws EventException;
 
    /**
     * 
     * FNS_JOO_0041 <br> 
     * Slot Exchange Status by Lane & Partner->Space On Partner 정보를 조회 합니다.<br>
     *
     * @param SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<SlotXchPartnerVO> searchSlotXchStatusListBySpacePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException;    

    /**
     * 
     * D : [FnsJoo0049Event]<br>
     * [ Settlement Status for Basic Allocation]을 [조회 Retrieve]합니다.<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusBsaVO>  
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<StlStatusBsaVO>    searchStlStatusListForBSA(StlConditionVO stlConditionVO) throws EventException;
    
    /**
     * 
     * D : [FnsJoo0050Event]<br>
     * [ Target Voyage vs Unsettled Status]을 [조회 Retrieve]합니다.<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusVO>  
     * @throws EventException
     * @author jang kang cheol
     */
    public  List<StlStatusVO>    searchTgtVoyVsUnstlStatusList( StlConditionVO stlConditionVO ) throws EventException;    
    
    /**
     * 
     * D : [FnsJoo0055Event]<br>
     * [lane cd 유무]을 [조회 Retrieve]합니다.<br>
     *
     * @param   MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return  List<MdmVslSvcLaneVO>  
     * @throws EventException
     * @author jang chang su
     */
    public  List<MdmVslSvcLaneVO> searchLaneCdYn (MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;    

    /**
     * 
     * D : [FnsJoo0054Event]<br>
     * [TDR Creation Inquiry]을 [조회 Retrieve]합니다.<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return  List<TdrByLaneVO>  
     * @throws EventException
     * @author jang chang su
     */
    public  List<TdrByLaneVO> searchTDRCreateListByLane (String fromDt, String toDt, String lane) throws EventException;    

    /**
     * 
     * D : [FnsJoo0055Event]<br>
     * [RDR Upload Inquiry]을 [조회 Retrieve]합니다.<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return  List<RdrByLaneVO>  
     * @throws EventException
     * @author jang chang su
     */
    public  List<RdrByLaneVO> searchRDRCreateListByLane (String fromDt, String toDt, String lane) throws EventException;    

    /**
     * Combined 작업시 Settlement의 cmb_cfm_flg를 update한다. 
     * @param CombinedVO[] combinedVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Combined 된 Settlement 정보를 취소한다.
	 * 
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 
     * Reverse 전표생성시 JOO_SETTLEMENT의 CMB_CFM_FLG를 N으로 UPDATE함으로써 다시 COMBINED되도록 한다.
	 *
	 * @param  List<JooStlCmbDtlVO> jooStlCmbDtlVOs
	 * @param  SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 * @author jang kang cheol
	 */
	public void createReverseSlip(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 을  조회 Retrieve합니다.<br>
     * 
     * @param  RdrLoadVO rdrLoadVO 
     * @return List<RdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
	public List<RdrLoadVO> searchRDRDownloadListByLane(RdrLoadVO rdrLoadVO) throws EventException;	
	
    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * RDR Load DownLoad by Lane 데이터중 JOO_RDR_VVD_CRR_RMK에 해당하는 값을 저장합니다.<br>
     * 
	 * @param  RdrLoadVO[] rdrLoadVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRVVDCrrRmk(RdrLoadVO[] rdrLoadVOs, SignOnUserAccount account) throws EventException;	

    /**
     * Settlement의 Other-Other의 VVD 입력시 조회
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return String
     * @throws EventException
     */
	public String searchStlVvdOth(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * Settlement Oth-Oth인 경우 입력한 VVD가 취소됐을 때 FNS_JOO_0053 화면을 열어 해당 VVD로 SLIP된 data를 조회한다.
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ManualStlVvdVO>
	 * @throws EventException
	 */
	public List<ManualStlVvdVO> searchVVDOfNotExistRevMonList(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrLoadVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO) throws EventException;  
 	
    /**
     * OUS RDR Adjustment 조회
     * @param AdjustConditionVO adjustConditionVO
     * @return List<AdjustOusRDRVO>
     * @throws EventException
     */
	public List<AdjustOusRDRVO> searchAdjustOusListForRDR(AdjustConditionVO adjustConditionVO) throws EventException;

	/**
	 * Settlement 단에서 Row ADD로 VVD입력시 9자리만 입력하면 해당하는 Revenue Direction List를 대상항차에서 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * OUS RDR에서 Region 변경시 Used Slot 정보를 조회한다.
     * 조회조건 : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotInfo(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * OUS RDR의 VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보와 OUS RDR의 VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보와 1st BSA, BSA Wgt Per TEU 를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvdOusRdr(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * R/F I/O 변경시 R/F Surcharge정보를 조회한다. 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfIOChange(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * R/F RGN 변경시 R/F Used RF, POL, POD 정보를 조회한다. 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfRgnChange(ProcSettlementVO procSettlementVO) throws EventException;
	
    /**
     * Monthly Clearance의 StlCmbSeq List를 조회합니다.<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author jang kang cheol
     */
    public List<SettlementVO> searchMonthlyStlCmbSeqList(StlConditionVO stlConditionVO) throws EventException;
	
	/**
	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
	 * @param SettlementRFVO[] settlementRFVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> manageSettlementRF(SettlementRFVO[] settlementRFVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	

	
 	/**
 	 * Settlement 저장시에 중복체크를 해서 중복된 데이터가 있으면 user에게 알려주고 없으면 저장한다.
 	 * 적용 ITEM : OUS(RDR, TDR), S/H
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlementSH(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
 	
    /**
     * 
     * FNS_JOO_0081 :Retrieve<br> 
     * Loading Port별 Discharge Port의 Qty 정보를 조회 합니다.<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
 	public DBRowSet searchDischageForLoading(LoadingQtyVO loadingQtyVO) throws EventException;
 	
    /**
     * 
     * FNS_JOO_0081 :Retrieve<br> 
     * Loading Port별 Discharge Port의 Qty 의 비고정된 헤더정보를  조회 합니다.<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoadingHeader(LoadingQtyVO loadingQtyVO) throws EventException;
 	
 	
    /**
     * Reverse전표 생성시 Settlement를 Copy한다.
     * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void createReverseSettlement(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;


	/**
	 * Other Settlement 화면에서 S/H의 BSA Type 입력시 validation을 체크한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchBsaTypeValidationCheck(ProcSettlementVO procSettlementVO) throws EventException;
	
	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
     * 0036 Remark의 내용을 저장한다.
     * @param McsStatusVO[] mcsStatusVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageSummaryOfMcsListByCarrier(McsStatusVO[] mcsStatusVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Adjustment로 강제생성된 Target VVD를 삭제할 경우 JOO_STL_DTL과 JOO_SETTLMENT를 먼저 삭제한다.
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @return int
	 * @throws EventException
	 */
	public int removeStlDtlAndSettlement(JooStlVvdVO[] jooStlVvdVOs) throws EventException;
	
	/**
	 * Unsettlement Target VVD를 수정한다. 
	 * @param StlStatusVO[] stlStatusVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageJooTgtUnstlStsRmk(StlStatusVO[] stlStatusVOs, SignOnUserAccount account) throws EventException;	
	
    /**
     * FNS_JOO_0087: Retrieve
     * D : [FnsJoo0087Event]<br>
     * Intergrated Loging Summary Report를  조회 Retrieve 합니다.<br>
     * 
     * @param IntloadSumReportVO intloadSumReportVO
     * @return List<IntloadSumReportVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<IntloadSumReportVO> searchIntergratedloadSumReportRDRList(IntloadSumReportVO intloadSumReportVO) throws EventException;
    
    /**
	 * Intergrated Loging Summary Report를 저장한다.
	 * @param IntloadSumReportVO[] intloadSumReportVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String 
	 * @throws EventException   
	 */
	public String addIntergratedloadSumReportRDRList(IntloadSumReportVO[] intloadSumReportVOs, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * FNS_JOO_0090: Retrieve
     * D : [FnsJoo0090Event]<br>
     * TDR Ratio by Lane 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrRatioVO tdrRatioVO
     * @return List<TdrRatioVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrRatioVO> searchTDRRatioListByLane(TdrRatioVO tdrRatioVO) throws EventException;
    
    /**
     * FNS_JOO_0090: SAVE
     * D : [FnsJoo0090Event]<br>
     * RDR Ratio by Lane 데이터중 JOO_TDR_RTO에 해당하는 값을 저장합니다.<br>
     * 
	 * @param  TdrRatioVO[] tdrRatioVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void createTDRRationByLane(TdrRatioVO[] tdrRatioVOs, SignOnUserAccount account) throws EventException;
	
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * 'Sub Allocation and Ratio'에 Rep. Carrier가 복수 선택되었거나 혹은 하나도 선택되지를 조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrLoadVO> searchTDRRatioCountByLane(TdrLoadVO tdrLoadVO) throws EventException; 
    
    /**
     * FNS_JOO_0100: Retrieve
     * 스케줄상의 Port를 Retrieve 합니다.<br>
     * 
     * @param KorCllCdlCondVO korCllCdlCondVO
     * @return List<SkdPortVO>
     * @throws EventException
     */   
    public List<SkdPortVO> searchSkdPortList(KorCllCdlCondVO korCllCdlCondVO) throws EventException;    

    
    /**
     * FNS_JOO_0100: Retrieve
     * ROB 컨테이너 목록을 Retrieve 합니다.<br>
     * 
     * @param KorCllCdlCondVO korCllCdlCondVO
     * @param String gubun
     * @return List<KorCllCdlDetailVO>
     * @throws EventException
     */   
    public List<KorCllCdlDetailVO> searchRobList(KorCllCdlCondVO korCllCdlCondVO, String gubun) throws EventException;
       
    /**
     * FNS_JOO_0100: Retrieve
     * ROB 컨테이너 Summary을 Retrieve 합니다.<br>
     * 
     * @param KorCllCdlCondVO korCllCdlCondVO
     * @param String gubun
     * @return List<TdrLoadVO>
     * @throws EventException
     */   
    public List<TdrLoadVO> searchRobTotal(KorCllCdlCondVO korCllCdlCondVO, String gubun) throws EventException;    
 	        
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 조회합니다.<br>
     * 
     * @param TdrRatioVO tdrRatioVO
     * @return List<TdrRatioVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TdrRatioVO> searchROBRatioListByLane(TdrRatioVO tdrRatioVO) throws EventException;
    
    /**
     * ROB Container List Inquiry의 Sub-Allocation and Ratio을 저장합니다.<br>
     * 
	 * @param  TdrRatioVO[] tdrRatioVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageROBRationByLane(TdrRatioVO[] tdrRatioVOs, SignOnUserAccount account) throws EventException;
	
    /**
     * Lane이  적합한지 조회합니다.<br>
     * 
     * @param TdrRatioVO[] tdrRatioVOs
     * @return String
     * @throws EventException
     * @author jang kang cheol
     */
    public String searchLaneChk(TdrRatioVO[] tdrRatioVOs) throws EventException;	
    
    /**
     * FNS_JOO_0103: Retrieve
     * ROB 컨테이너 Summary List를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return String
     * @throws EventException 
     */   
    public String searchRobSummaryList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException;    
  
    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchRobSummaryEndJobStatus(String key) throws EventException;     
	
	
    /**
     * Vessle ETD Schedule  리스트 조회합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     */
    public List<TdrLoadVO> searchVslSkdEtd(TdrLoadVO tdrLoadVO) throws EventException;	
    
    /**
     * RDR Port 저장한다..<br>
     * 
	 * @param  TdrLoadVO[] tdrLoadVOs
	 * @param  String rlaneCd
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRPort(TdrLoadVO[] tdrLoadVOs, String rlaneCd, SignOnUserAccount account) throws EventException;    
    
}