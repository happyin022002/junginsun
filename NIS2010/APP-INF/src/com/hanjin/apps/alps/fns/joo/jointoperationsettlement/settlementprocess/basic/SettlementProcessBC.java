/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SettlementProcessBC.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.04 민정호
* 1.0 Creation
* ----------------------------------------------------------
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.SltHirTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoEstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoSettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoLoadingVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.MvntEvntDtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;



/**
 * ALPS-Settlementprocess Business Logic Command Interface<br>
 * - ALPS-Ssettlementprocess에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jungho Min
 * @see JoocommonEventResponse 참조
 * @since J2EE 1.4
 */

public interface SettlementProcessBC {
    /**
     * Estimation 마감여부를 check한다.
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws EventException
     */
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws EventException;
    
	/**
	 * 추정결과테이블에서 조건에 해당하는 Trade코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchTradeCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException;
	
	
	/**
	 * 추정결과테이블에서 조건에 해당하는 Rlane코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchRlaneCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException;
	
	/**
	 * 추정결과테이블에서 조건에 해당하는 Carrier코드List를 조회한다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchCarrierCodeListEstm(JoEstmConditionVO estmConditionVO) throws EventException;	
	
    /**
     *  [JO Target Creation and Basic Slot Hire Settlement]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0104<br>
     * 
     * @param JoSettlementConditionVO settlementConditionVO
     * @returnType List<SltHirTgtVO>
     * @throws EventException
     */
    public List<SltHirTgtVO> searchJointOperationAccrualList(JoSettlementConditionVO settlementConditionVO) throws EventException;

    /**
     *  [JO Target Creation and Basic Slot Hire Settlement]의 페이지 개수를 [조회] 합니다.<br>
     *      UID : FNS_JOO_0104<br>
     * 
     * @param JoSettlementConditionVO settlementConditionVO
     * @returnType SltHirTgtVO
     * @throws EventException
     */
    public SltHirTgtVO searchJointOperationAccrualTotal(JoSettlementConditionVO settlementConditionVO) throws EventException;    
    
    /** 
     *  [JO Target Creation and Basic Slot Hire Settlement]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0104<br>
     *
     * @param SltHirTgtVO[] sltHirTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */
    public void manageJointOperationAccrual( SltHirTgtVO[] sltHirTgtVOs, JoSettlementConditionVO settlementConditionVO,SignOnUserAccount signOnUserAccount) throws EventException;
    
    /**
     * FNS_JOO_0105: Retrieve
     * ROB 컨테이너 Summary List를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return List<JoLoadingVO>
     * @throws EventException 
     */   
    public List<JoLoadingVO> searchRobSummaryList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException;
    
    
    /**
     * 
     *  [JIntegrated JO Expense Loading Information]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0105<br>
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param String rlaneCd
     * @param SignOnUserAccount signOnUserAccount
     *  @param String reDivrCd
     * @throws EventException
     */
    public void manageJoLoading(JoLoadingVO[] joLoadingVOs, String rlaneCd,SignOnUserAccount signOnUserAccount, String reDivrCd) throws EventException;
    
    /**
     * 
     *  [JIntegrated JO Revenue Loading Information]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0108<br>
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageJoRevLoading(JoLoadingVO[] joLoadingVOs, TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * 
     *  [JIntegrated JO Revenue Loading Information]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0108<br>
     *
     * @param JoLoadingVO[] joLoadingVOs
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageJoRevLoadingMerge(JoLoadingVO[] joLoadingVOs, TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount) throws EventException;    
    
	/**
	 * TDR Carrier Code 조회, Period, rlane이 조회조건임
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchJoRevCarrierCodeString(TdrLoadVO tdrLoadVO) throws EventException; 
    
    
	/**
	 * JOO_SETTLEMENT를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException;
	
	
	/**
	 * Movement Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchMvntEvntDateList(MvntEvntDtVO mvntEvntDtVO) throws EventException;	

	/**
	 * Skd Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchSkdEvntDatet(MvntEvntDtVO mvntEvntDtVO) throws EventException;	
	
    /**
     * 
     *  [Movement Event Date]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0109<br>
     *
     * @param MvntEvntDtVO[] mvntEvntDtVOs
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */
    public void manageMvntEvntDate(MvntEvntDtVO[] mvntEvntDtVOs,SignOnUserAccount signOnUserAccount) throws EventException;
    
    /**
     * FNS_JOO_0108: Retrieve
     * D : [FnsJoo0057Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<JoLoadingVO>
     * @throws EventException
     */
    public List<JoLoadingVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO) throws EventException;
        
    /**
     *  [Settlement Target]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0110<br>
     * 
     * @param JoSettlementConditionVO settlementConditionVO
     * @returnType List<StlTgtVO>
     * @throws EventException
     */
    public List<StlTgtVO> searchStlTgtList(JoSettlementConditionVO settlementConditionVO) throws EventException;

    /**
     *  [Settlement Target]의 페이지 개수를 [조회] 합니다.<br>
     *      UID : FNS_JOO_0110<br>
     * 
     * @param JoSettlementConditionVO settlementConditionVO
     * @returnType SltHirTgtVO
     * @throws EventException
     */
    public SltHirTgtVO searchStlTgTotaltList(JoSettlementConditionVO settlementConditionVO) throws EventException;       
    
    /** 
     *  [Settlement Target]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0110<br>
     *
     * @param StlTgtVO[] stlTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */
    public void manageStlTgt(StlTgtVO[] stlTgtVOs, JoSettlementConditionVO settlementConditionVO,SignOnUserAccount signOnUserAccount) throws EventException;

    /** 
     *  [Settlement Target Sublet]을 [저장] 합니다.<br>
     *      UID : FNS_JOO_0110<br>
     *
     * @param StlTgtVO[] stlTgtVOs
     * @param JoSettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */
    public void manageStlTgtSublet(StlTgtVO[] stlTgtVOs, JoSettlementConditionVO settlementConditionVO,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Settlement Target 조회한다.
	 * 
	 * @param ProcSettlementVO procSettlementVO
     * @param SignOnUserAccount signOnUserAccount 
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO, SignOnUserAccount signOnUserAccount) throws EventException;	
  
	
    /**
     *  [JO Settlement Status Information]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0107<br>
     * 
     * @param StlStsVO stlStsVO
     * @returnType List<StlStsVO>
     * @throws EventException
     */
    public List<StlStsVO> searchJoSettlementStatusList(StlStsVO stlStsVO) throws EventException;
    
    /**
     *  [O Settlement Status Information]의 페이지 개수를 [조회] 합니다.<br>
     *      UID : FNS_JOO_0107<br>
     * 
     * @param StlStsVO stlStsVO
     * @returnType StlStsVO
     * @throws EventException
     */
    public StlStsVO searchJoSettlementStatusListTotal(StlStsVO stlStsVO) throws EventException;        
    
    
	/**
	 * Settlement를 저장한다.
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param String acctYrmon
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, String acctYrmon, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Trade코드List를 조회한다.
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchTradeCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException;	
	
	
	/**
	 * Rlane코드List를 조회한다.
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchRlaneCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException;
	
	/**
	 * Carrier코드List를 조회한다.
	 * @param JoSettlementConditionVO joSettlementConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws EventException
	 */
	public List<JoEstmConditionVO> searchCarrierCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws EventException;		
	
	/**
     *  [JO Settlement Status Information]을 [프로시저를 호출] 합니다.<br>
     *      UID : FNS_JOO_0107<br>
     * 
     * @param String p_trd_cd
     * @param String p_crr_cd
     * @param String p_rlane_cd  
     * @throws EventException
     */
    public void callProcedure(String p_trd_cd, String p_crr_cd, String p_rlane_cd) throws EventException;
    
	/**
     *  [JO Expense Loading Information]을 [프로시저를 호출] 합니다.<br>
     *      UID : FNS_JOO_0105<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @returnType String 
     * @throws EventException
     */
    public String callJELProcedure(TdrLoadVO tdrLoadVO) throws EventException;
    
    /**
     * FNS_JOO_0111 Retrieve
     * Jo Expense Report 리스트를 Retrieve 합니다.<br>
     *  
     * @param TdrLoadVO tdrLoadVO
     * @param SignOnUserAccount signOnUserAccount
     * @param String gubun
     * @return List<JoLoadingVO>
     * @throws EventException 
     */   
    public List<JoLoadingVO> searchExpRptList(TdrLoadVO tdrLoadVO, SignOnUserAccount signOnUserAccount, String gubun) throws EventException;
    
	/**
     *  [Movement Event Date Setting]을 [프로시저를 호출] 합니다.<br>
     *      UID : FNS_JOO_0109<br>
     * JOO_CNTR_MVMT_EVNT_DT_SLAN_PRC
     * @param MvntEvntDtVO mvntEvntDtVO
     * @returnType String 
     * @throws EventException
     */
    public String callMVMTProcedure(MvntEvntDtVO mvntEvntDtVO) throws EventException;
    
	/**
     *  [Movement Event Date Setting]을 [프로시저를 호출] 합니다.<br>
     *      UID : FNS_JOO_0109<br>
     * JOO_CNTR_MVMT_EVNT_DT_ALL_PRC
     * @param MvntEvntDtVO mvntEvntDtVO
     * @returnType String 
     * @throws EventException
     */
    public String callMVMTALLProcedure(MvntEvntDtVO mvntEvntDtVO) throws EventException;

	/**
     *  [JO Target Creation and Basic Slot Hire Settlement]을 [프로시저를 호출] 합니다.<br>
     *      UID : FNS_JOO_0104<br>
     * JOO_SLT_ALL_PRC
     * @param JoEstmConditionVO estmConditionVO
     * @returnType String 
     * @throws EventException
     */
    public String callSLOTProcedure(JoEstmConditionVO estmConditionVO) throws EventException;
    
	/**
	 * Settlement 단에서 Row ADD로 VVD입력시 9자리만 입력하면 해당하는 Revenue Direction List를 대상항차에서 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException;
	
    /**
     *  [JO Settlement PIC]을 [조회] 합니다.<br>
     *      UID : FNS_JOO_0113<br>
     * 
     * @param StlStsVO stlStsVO
     * @returnType List<StlStsVO>
     * @throws EventException
     */
    public List<StlStsVO> searchJoSettlementPicList(StlStsVO stlStsVO) throws EventException;
    
    /**
     *  [O Settlement Status PIC]의 페이지 개수를 [조회] 합니다.<br>
     *      UID : FNS_JOO_0113<br>
     * 
     * @param StlStsVO stlStsVO
     * @returnType StlStsVO
     * @throws EventException
     */
    public StlStsVO searchJoSettlementPicListTotal(StlStsVO stlStsVO) throws EventException;        	
    
    
	/**
	 * 공동운항에서 PIC 조회
	 *  
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchPicList() throws EventException;    
  
    /**
     * Pic를 저장 합니다.<br>
     * 
     * @param  StlStsVO[] stlStsVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
	public String managePic(StlStsVO[] stlStsVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
    /** 
     * Pic를 저장 합니다.(Multi Creation & Change)<br>
     *
     * @param StlStsVO[] stlStsVOs
     * @param SignOnUserAccount signOnUserAccount 
     * @throws EventException
     */
    public void manageMultiPic(StlStsVO[] stlStsVOs, SignOnUserAccount signOnUserAccount) throws EventException;	
}