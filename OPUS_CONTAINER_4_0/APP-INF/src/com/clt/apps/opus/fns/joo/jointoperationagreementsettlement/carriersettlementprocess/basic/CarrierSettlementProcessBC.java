/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessBC.java
*@FileTitle : War Risk Surcharge Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrPreviousVvdPortVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusBsaVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.JooStlVvdVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * OPUS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - OPUS-Jointoperationagreementsettlement: Business Logic Interface<br>
 *
 * @author 
 * @see Fns_joo_0013EventResponse
 * @since J2EE 1.6
 */

public interface CarrierSettlementProcessBC {
	/**
	 * retrieving JOO_SETTLEMENT(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR common)
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException;

	
	/**
	 * saving Settlement
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * deleting multiple JOO_SETTLEMENT
	 * -조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm
	 * @param ProcSettlementVO procSettlementVO
	 * @return ProcSettlementVO[]  
	 * @throws EventException
	 */
	public ProcSettlementVO[] removeSettlement(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * retrieving VVD not in Joo_settlement in case of clicking Create button in settlement
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * retrieving VVD infomation in joo_stl_vvd table in case of inputting VVD
	 * checking validation of inputted VVD
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * retrieving JOO_SETTLEMENT in 0037 screen
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByTrade (McsStatusVO mcsStatusVO) throws EventException;
	
	/**
	 * retrieving VVD and information not in JOO_SETTLEMENT in case of clicking Create button in FNS_JOO_0007 Slot Hire
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForSlotHireList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * retrieving joo_settlement with carrier 0037
	 * @param McsStatusVO mcsStatusVO 
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByCarrier  (McsStatusVO mcsStatusVO) throws EventException;

	/**
	 * 
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
     * retrieving unit price, used qty in case of selecting inter port / ocean
     * Search Condition : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrc(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusTdrList(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrFnl(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlot(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlotPrice(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> searchSettlementRFList(ProcSettlementVO procSettlementVO) throws EventException;


    /**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchAddStlForRFList(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchUsedReeferList(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * retrieving Adjustment Slot Hire
	 * @param AdjustConditionVO adjustConditionVO
	 * @return List<AdjustSettlementVO>
	 * @throws EventException
	 */
	public List<AdjustSettlementVO> searchAdjustSlotHireStlList(AdjustConditionVO adjustConditionVO) throws EventException;

	/**
	 * saving Adjust Settlement
	 * @param AdjustSettlementVO[] adjustSettlementVOs 
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdjustSlotHireStl(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
    /**
     * retrieving carrier infomation in Monthly Clearance by Carrier & Lane.<br>
     * D : FNS_JOO_0015
     * 
     * @param StlConditionVO stlConditionVO
     * @return List<SettlementVO>
     * @throws EventException
     * @author 
     */
    public  List<SettlementVO>  searchMonthlyClearanceList(StlConditionVO stlConditionVO) throws EventException;
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * retrieving Summary of Monthly Clearance Status by VVD<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author 
     */
    public  List<McsStatusReportVO>  searchSummaryOfMcsListByVVD(McsStatusVO mcsStatusVO) throws EventException;
 
    /**
     * FNS_JOO_0042 : Retrieve
     * D : [FnsJoo0042Event]<br>
     * retrieving Slot Exchange Status by Lane & Partner->Finance Lane.<br>
     *
     * @param  SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author 
     */
    public  List<SlotXchLaneVO>    searchSlotXchStatusListByFinanceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException;      
 
    /**
     * FNS_JOO_0043 : Retrieve
     * D : [FnsJoo0043Event]<br>
     * retrieving [Slot Exchange Status by Lane & Partner->Finance  Partner]<br>
     *
     * @param  SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO> 
     * @throws EventException
     * @author 
     */
    public  List<SlotXchPartnerVO>   searchSlotXchStatusListByFinancePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException;
    
//    /**
//     * 
//     * FNS_JOO_0040 <br> 
//     * 
//     *
//     * @param SlotXchLaneVO slotXchLaneVO
//     * @return List<SlotXchLaneVO>
//     * @throws EventException
//     * @author 
//     */
//    public  List<SlotXchLaneVO> searchSlotXchStatusListBySpaceLane(SlotXchLaneVO slotXchLaneVO) throws EventException;
// 
//    /**
//     * 
//     * FNS_JOO_0041 <br> 
//     * 
//     *
//     * @param SlotXchPartnerVO slotXchPartnerVO
//     * @return List<SlotXchPartnerVO>
//     * @throws EventException
//     * @author 
//     */
//    public  List<SlotXchPartnerVO> searchSlotXchStatusListBySpacePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException;    

    /**
     * 
     * D : [FnsJoo0049Event]<br>
     * retrieving [ Settlement Status for Basic Allocation]<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusBsaVO>  
     * @throws EventException
     * @author 
     */
    public  List<StlStatusBsaVO>    searchStlStatusListForBSA(StlConditionVO stlConditionVO) throws EventException;
    
    /**
     * 
     * D : [FnsJoo0050Event]<br>
     * retrieving [ Target Voyage vs Unsettled Status]<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusVO>  
     * @throws EventException
     * @author 
     */
    public  List<StlStatusVO>    searchTgtVoyVsUnstlStatusList( StlConditionVO stlConditionVO ) throws EventException;    
    
    /**
     * 
     * D : [FnsJoo0055Event]<br>
     * retrieving [lane cd exists or not]<br>
     *
     * @param   MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return  List<MdmVslSvcLaneVO>  
     * @throws EventException
     * @author
     */
    public  List<MdmVslSvcLaneVO> searchLaneCdYn (MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;    

    /**
     * 
     * D : [FnsJoo0054Event]<br>
     * retrieving [TDR Creation Inquiry]<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return  List<TdrByLaneVO>  
     * @throws EventException
     * @author
     */
    public  List<TdrByLaneVO> searchTDRCreateListByLane (String fromDt, String toDt, String lane) throws EventException;    

    
    /**
     * 
     * D : [FnsJoo0055Event]<br>
     * retrieving [RDR Upload Inquiry]<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return  List<RdrByLaneVO>  
     * @throws EventException
     * @author
     */
    public  List<RdrByLaneVO> searchRDRCreateListByLane (String fromDt, String toDt, String lane) throws EventException;    

    /**
     * updating cmb_cfm_flg in settlement in case of combined work. 
     * @param CombinedVO[] combinedVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * canceling combined settlement information
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
     * retrieving RDR Load DownLoad by Lane<br>
     * 
     * @param  RdrLoadVO rdrLoadVO 
     * @return List<RdrLoadVO>
     * @throws EventException
     * @author 
     */
	public List<RdrLoadVO> searchRDRDownloadListByLane(RdrLoadVO rdrLoadVO) throws EventException;	
	
    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * saving JOO_RDR_VVD_CRR_RMK<br>
     * 
	 * @param  RdrLoadVO[] rdrLoadVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRVVDCrrRmk(RdrLoadVO[] rdrLoadVOs, SignOnUserAccount account) throws EventException;	

    /**
     * retrieving in case of inputting VVD in Other-Other of settlement
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return String
     * @throws EventException
     */
	public String searchStlVvdOth(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
	 * retrieving slipped data
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ManualStlVvdVO>
	 * @throws EventException
	 */
	public List<ManualStlVvdVO> searchVVDOfNotExistRevMonList(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * retrieving RDR Load DownLoad by VVD<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author 
     */
    public List<TdrLoadVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO) throws EventException;  
 	
    /**
     * retrieving OUS RDR Adjustment
     * @param AdjustConditionVO adjustConditionVO
     * @return List<AdjustOusRDRVO>
     * @throws EventException
     */
//	public List<AdjustOusRDRVO> searchAdjustOusListForRDR(AdjustConditionVO adjustConditionVO) throws EventException;

	/**
	 * retrieving Revenue Direction List
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * retrieving Used Slot Information
     * Search Condition : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotInfo(ProcSettlementVO procSettlementVO) throws EventException;

	/**
	 * 
	 * checking validation of inputted VVD
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvdOusRdr(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfIOChange(ProcSettlementVO procSettlementVO) throws EventException;

    /**
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfRgnChange(ProcSettlementVO procSettlementVO) throws EventException;
	
    /**
     * retrieving StlCmbSeq List of Monthly Clearance<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author 
     */
    public List<SettlementVO> searchMonthlyStlCmbSeqList(StlConditionVO stlConditionVO) throws EventException;
	
	/**
	 * 
	 * @param SettlementRFVO[] settlementRFVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> manageSettlementRF(SettlementRFVO[] settlementRFVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	

	
 	/**
 	 * checking duplication and saving
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
     * retrieving Discharge Port Qty by Loading Port<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
 	public DBRowSet searchDischageForLoading(LoadingQtyVO loadingQtyVO) throws EventException;
 	
    /**
     * 
     * FNS_JOO_0081 :Retrieve<br> 
     * retrieving Discharge Port Qty header information by Loading Por<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoadingHeader(LoadingQtyVO loadingQtyVO) throws EventException;
 	
 	
    /**
     * 
     * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void createReverseSettlement(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * checking validation in case of inputting S/H BSA Type
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchBsaTypeValidationCheck(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
     * saving 0036 Remark
     * @param McsStatusVO[] mcsStatusVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageSummaryOfMcsListByCarrier(McsStatusVO[] mcsStatusVOs, SignOnUserAccount account) throws EventException;

	/**
	 * deleting JOO_STL_DTL, JOO_SETTLMENT in case of deleting Target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @return int
	 * @throws EventException
	 */
	public int removeStlDtlAndSettlement(JooStlVvdVO[] jooStlVvdVOs) throws EventException;
	
	/**
	 * updating Unsettlement Target VVD
	 * @param StlStatusVO[] stlStatusVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageJooTgtUnstlStsRmk(StlStatusVO[] stlStatusVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Container List for settlement backup <br>
	 *
	 * @param  CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @return List<CntrSettlementBackupReportVO>
	 * @exception EventException
	 */
	public List<CntrSettlementBackupReportVO> searchCntrForSettlementBackupReportData(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) throws EventException;
	
	/**
	 * Container List for settlement backup.(BackEnd Job)<br>
	 * 
	 * @param CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrForSettlementBackupReportDataBackEndJob(CntrSettlementBackupReportVO cntrSettlementBackupReportVO, SignOnUserAccount account) throws EventException;
	/**
	 * Container List for settlement backup/Standard format.(BackEndJob download)<br>
	 * 
	 * @param String key
	 * @return Object
	 * @throws EventException
	 */
	public Object searchCntrReportBackEndJobDataFile(String key) throws EventException;
	/**
	 * Standard format for previous vvd and last port 조회<<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return List<CntrPreviousVvdPortVO>
	 * @throws EventException
	 */
	public List<CntrPreviousVvdPortVO> searchCntrPreviousVvdPortInfo(CntrConditionVO cntrConditionVO) throws EventException;
	/**
	 * Standard format 조회<<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return List<CntrStandardFormatVO>
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatReportData(CntrConditionVO cntrConditionVO) throws EventException;
	
	/**
	 * Standard format Summary 조회(BackEndJob)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatReportDataBackEndJob(CntrConditionVO cntrConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Standard format Previous Voyage조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatPreviousVoyageReportData(CntrConditionVO cntrConditionVO) throws EventException;
	
	/**
	 * Standard format Previous Voyage조회(BackEndJob)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatPreviousVoyageReportDataBackEndJob(CntrConditionVO cntrConditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * Standard format Next Voyage조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatNextVoyageReportData(CntrConditionVO cntrConditionVO) throws EventException;
	
	/**
	 * Conversion Table TP/SZ Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	
	/**
	 * Conversion Table TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByTeuList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	
	/**
	 * Conversion Table Void Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByVoidList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	/**
     * FNS_JOO_0086 : Save TP/SZ Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByTpsz(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException;
	/**
     * FNS_JOO_0086 : Save TEU Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByTeu(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException;
	/**
     * FNS_JOO_0086 : Save Void Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByVoid(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	/**
     * FNS_JOO_0087 : Save
     * @param CntrConversionAndOptionVO[] cntrConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrOption(CntrConversionAndOptionVO[] cntrConversionAndOptionVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Conversion Table Normal TP/SZ 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrNormalTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	/**
	 * Container List for settlement backup.(BackEnd Job)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param CntrStandardFormatVO[] cntrStandardFormatPreVOs
	 * @param CntrStandardFormatVO[] cntrStandardFormatSumVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatReportBackEndJob(CntrConditionVO cntrConditionVO, CntrStandardFormatVO[] cntrStandardFormatPreVOs, CntrStandardFormatVO[] cntrStandardFormatSumVOs, SignOnUserAccount account) throws EventException;

    /**
     * retrieving Used Slot Information
     * 2015.08.12 Add
     * parameter : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotByInterList(ProcSettlementVO procSettlementVO) throws EventException; 
 
    /**
     * retrieving unit price, used qty in case of selecting inter port
     * 2015.08.12 Add
     * Search Condition : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrcByInter(ProcSettlementVO procSettlementVO) throws EventException;
	
	/**
     * FNS_JOO_0086 : Save Default TP/SZ Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByDefaultTpsz(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * Conversion Table Default TP/SZ 조회(Laden/Empty)<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionDefaultTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;

	
	/**
	 * Default Conversion Table TP/SZ & TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchDefaultCntrConverion(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
	
	/**
	 * Default Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchDefaultCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException;
}